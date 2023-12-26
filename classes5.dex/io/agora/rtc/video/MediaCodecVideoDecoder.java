package io.agora.rtc.video;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Surface;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.RendererCommon;
import io.agora.rtc.gl.SurfaceTextureHelper;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.internal.Logging;
import io.agora.rtc.utils.ThreadUtils;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MediaCodecVideoDecoder extends MediaCodecBase {
    private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    private static final int DEQUEUE_INPUT_TIMEOUT = 100000;
    private static final String H264_MIME_TYPE = "video/avc";
    private static final String H265_MIME_TYPE = "video/hevc";
    private static final long MAX_DECODE_TIME_MS = 2000;
    private static final int MAX_QUEUED_OUTPUTBUFFERS = 3;
    private static final int MAX_TEXTURE_BUFFER_COUNT = 16;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final String TAG = "MediaCodecVideoDecoder";
    private static final boolean VERBOSE = false;
    private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
    private static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
    private static int codecErrors;
    private static AtomicInteger currentInstances = new AtomicInteger(0);
    private static MediaCodecVideoDecoderErrorCallback errorCallback;
    private static Set<String> hwDecoderDisabledTypes = new HashSet();
    private static boolean preferGoogleSoftwareDecoder = false;
    private static MediaCodecVideoDecoder runningInstance;
    private static final List<Integer> supportedColorList = Arrays.asList(new Integer[]{19, 21, 2141391872, Integer.valueOf(COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m)});
    private static final List<Integer> supportedColorListAddOn = Arrays.asList(new Integer[]{2135033992});
    private static final String[] supportedH264HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos.", "OMX.rk.", "OMX.sprd.", "OMX.amlogic.", "OMX.IMG.TOPAZ.", "OMX.IMG.MSVDX.", "OMX.hisi.", "OMX.k3.", "OMX.allwinner.", "OMX.MTK.", "OMX.Nvidia.", "OMX.Intel.", "OMX.MS.", "OMX.NVT."};
    private static final String[] supportedH265HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos.", "OMX.rk.", "OMX.sprd.", "OMX.amlogic.", "OMX.IMG.TOPAZ.", "OMX.IMG.MSVDX.", "OMX.hisi.", "OMX.k3.", "OMX.allwinner.", "OMX.MTK.", "OMX.Nvidia.", "OMX.Intel.", "OMX.MS.", "OMX.google."};
    private static final String[] supportedVp8HwCodecPrefixes = {"OMX.qcom.", "OMX.Nvidia.", "OMX.Exynos.", "OMX.Intel."};
    private static final String[] supportedVp9HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos."};
    private HandlerThread asyncHandlerThread;
    private String codecName;
    private int colorFormat;
    private int cropHeight;
    private int cropWidth;
    private final Queue<TimeStamps> decodeStartTimeMsQueue = new ConcurrentLinkedQueue();
    private MediaCodecDecoderCallback decoderCallback = null;
    /* access modifiers changed from: private */
    public final Queue<DecodedOutputBuffer> dequeuedSurfaceOutputBuffers = new ConcurrentLinkedQueue();
    private int droppedFrames;
    private boolean hasDecodedFirstFrame;
    private int height;
    ByteBuffer[] inputBuffers;
    private boolean isOMXHisi;
    /* access modifiers changed from: private */
    public MediaCodec mediaCodec;
    private Thread mediaCodecThread;
    /* access modifiers changed from: private */
    public long nativeHandle;
    ByteBuffer[] outputBuffers;
    private int sliceHeight;
    private int stride;
    private int supportCodecs;
    private int supportInstances = 1;
    private Surface surface = null;
    private SurfaceTextureHelper surfaceTextureHelper;
    private TextureListener textureListener;
    private boolean useAsyncMode = false;
    /* access modifiers changed from: private */
    public boolean useSurface;
    private int width;

    public interface MediaCodecVideoDecoderErrorCallback {
        void onMediaCodecVideoDecoderCriticalError(int i);
    }

    public enum VideoCodecType {
        VIDEO_CODEC_VP8,
        VIDEO_CODEC_VP9,
        VIDEO_CODEC_H264,
        VIDEO_CODEC_H265
    }

    /* access modifiers changed from: private */
    public native void deliverOutputTextureReady(DecodedTextureBuffer decodedTextureBuffer, long j);

    /* access modifiers changed from: private */
    public native void deliverOutputYuvReady(DecodedOutputBuffer decodedOutputBuffer, long j);

    public static void setErrorCallback(MediaCodecVideoDecoderErrorCallback mediaCodecVideoDecoderErrorCallback) {
        errorCallback = mediaCodecVideoDecoderErrorCallback;
    }

    public static boolean isAsyncModeSupported() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static void disableVp8HwCodec() {
        Logging.w(TAG, "VP8 decoding is disabled by application.");
        hwDecoderDisabledTypes.add(VP8_MIME_TYPE);
    }

    public static void disableVp9HwCodec() {
        Logging.w(TAG, "VP9 decoding is disabled by application.");
        hwDecoderDisabledTypes.add(VP9_MIME_TYPE);
    }

    public static void disableH264HwCodec() {
        Logging.w(TAG, "H.264 decoding is disabled by application.");
        hwDecoderDisabledTypes.add(H264_MIME_TYPE);
    }

    public static void disableH265HwCodec() {
        Logging.w(TAG, "H.265 decoding is disabled by application.");
        hwDecoderDisabledTypes.add(H265_MIME_TYPE);
    }

    public static boolean isVp8HwSupported() {
        return !hwDecoderDisabledTypes.contains(VP8_MIME_TYPE) && findDecoder(VP8_MIME_TYPE, supportedVp8HwCodecPrefixes) != null;
    }

    public static boolean isVp9HwSupported() {
        return !hwDecoderDisabledTypes.contains(VP9_MIME_TYPE) && findDecoder(VP9_MIME_TYPE, supportedVp9HwCodecPrefixes) != null;
    }

    public static boolean isH264HwSupported() {
        return !hwDecoderDisabledTypes.contains(H264_MIME_TYPE) && findDecoder(H264_MIME_TYPE, supportedH264HwCodecPrefixes) != null;
    }

    public static boolean isH265HwSupported() {
        return !hwDecoderDisabledTypes.contains(H265_MIME_TYPE) && findDecoder(H265_MIME_TYPE, supportedH265HwCodecPrefixes) != null;
    }

    public static void printStackTrace() {
        Thread thread;
        MediaCodecVideoDecoder mediaCodecVideoDecoder = runningInstance;
        if (mediaCodecVideoDecoder != null && (thread = mediaCodecVideoDecoder.mediaCodecThread) != null) {
            StackTraceElement[] stackTrace = thread.getStackTrace();
            if (stackTrace.length > 0) {
                Logging.d(TAG, "MediaCodecVideoDecoder stacks trace:");
                for (StackTraceElement stackTraceElement : stackTrace) {
                    Logging.d(TAG, stackTraceElement.toString());
                }
            }
        }
    }

    private static class DecoderProperties {
        public final String codecName;
        public final int colorFormat;

        public DecoderProperties(String str, int i) {
            this.codecName = str;
            this.colorFormat = i;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007c, code lost:
        if (r7.startsWith("OMX.google.") != false) goto L_0x0090;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x015d A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static io.agora.rtc.video.MediaCodecVideoDecoder.DecoderProperties findDecoder(java.lang.String r16, java.lang.String[] r17) {
        /*
            r1 = r16
            r2 = r17
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 0
            r4 = 19
            if (r0 >= r4) goto L_0x000c
            return r3
        L_0x000c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "Trying to find HW decoder for mime "
            r0.append(r4)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r4 = "MediaCodecVideoDecoder"
            io.agora.rtc.internal.Logging.i(r4, r0)
            r6 = 0
        L_0x0023:
            int r0 = android.media.MediaCodecList.getCodecCount()
            if (r6 >= r0) goto L_0x0161
            android.media.MediaCodecInfo r0 = android.media.MediaCodecList.getCodecInfoAt(r6)     // Catch:{ IllegalArgumentException -> 0x002e }
            goto L_0x0036
        L_0x002e:
            r0 = move-exception
            r7 = r0
            java.lang.String r0 = "Cannot retrieve decoder codec info"
            io.agora.rtc.internal.Logging.e(r4, r0, r7)
            r0 = r3
        L_0x0036:
            if (r0 == 0) goto L_0x015d
            boolean r7 = r0.isEncoder()
            if (r7 == 0) goto L_0x0040
            goto L_0x015d
        L_0x0040:
            java.lang.String[] r7 = r0.getSupportedTypes()
            int r8 = r7.length
            r9 = 0
        L_0x0046:
            if (r9 >= r8) goto L_0x0058
            r10 = r7[r9]
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x0055
            java.lang.String r7 = r0.getName()
            goto L_0x0059
        L_0x0055:
            int r9 = r9 + 1
            goto L_0x0046
        L_0x0058:
            r7 = r3
        L_0x0059:
            if (r7 != 0) goto L_0x005d
            goto L_0x015d
        L_0x005d:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Found candidate decoder: "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            io.agora.rtc.internal.Logging.i(r4, r8)
            boolean r8 = preferGoogleSoftwareDecoder
            r9 = 1
            if (r8 == 0) goto L_0x007f
            java.lang.String r8 = "OMX.google."
            boolean r8 = r7.startsWith(r8)
            if (r8 == 0) goto L_0x008f
            goto L_0x0090
        L_0x007f:
            int r8 = r2.length
            r10 = 0
        L_0x0081:
            if (r10 >= r8) goto L_0x008f
            r11 = r2[r10]
            boolean r11 = r7.startsWith(r11)
            if (r11 == 0) goto L_0x008c
            goto L_0x0090
        L_0x008c:
            int r10 = r10 + 1
            goto L_0x0081
        L_0x008f:
            r9 = 0
        L_0x0090:
            if (r9 != 0) goto L_0x0094
            goto L_0x015d
        L_0x0094:
            android.media.MediaCodecInfo$CodecCapabilities r0 = r0.getCapabilitiesForType(r1)
            int[] r8 = r0.colorFormats
            int r9 = r8.length
            r10 = 0
        L_0x009c:
            if (r10 >= r9) goto L_0x00bb
            r11 = r8[r10]
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "   Color: 0x"
            r12.append(r13)
            java.lang.String r11 = java.lang.Integer.toHexString(r11)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            io.agora.rtc.internal.Logging.d(r4, r11)
            int r10 = r10 + 1
            goto L_0x009c
        L_0x00bb:
            java.lang.String r8 = "OMX.rk."
            boolean r8 = r7.startsWith(r8)
            r9 = 21
            if (r8 == 0) goto L_0x00cb
            io.agora.rtc.video.MediaCodecVideoDecoder$DecoderProperties r0 = new io.agora.rtc.video.MediaCodecVideoDecoder$DecoderProperties
            r0.<init>(r7, r9)
            return r0
        L_0x00cb:
            java.util.List<java.lang.Integer> r8 = supportedColorList
            java.util.Iterator r8 = r8.iterator()
        L_0x00d1:
            boolean r10 = r8.hasNext()
            java.lang.String r11 = ". Color: 0x"
            java.lang.String r12 = "Found target decoder "
            if (r10 == 0) goto L_0x0114
            java.lang.Object r10 = r8.next()
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            int[] r13 = r0.colorFormats
            int r14 = r13.length
            r15 = 0
        L_0x00e9:
            if (r15 >= r14) goto L_0x00d1
            r5 = r13[r15]
            if (r5 != r10) goto L_0x0111
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            r0.append(r7)
            r0.append(r11)
            java.lang.String r1 = java.lang.Integer.toHexString(r5)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            io.agora.rtc.internal.Logging.i(r4, r0)
            io.agora.rtc.video.MediaCodecVideoDecoder$DecoderProperties r0 = new io.agora.rtc.video.MediaCodecVideoDecoder$DecoderProperties
            r0.<init>(r7, r5)
            return r0
        L_0x0111:
            int r15 = r15 + 1
            goto L_0x00e9
        L_0x0114:
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r9) goto L_0x015d
            java.util.List<java.lang.Integer> r5 = supportedColorListAddOn
            java.util.Iterator r5 = r5.iterator()
        L_0x011e:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x015d
            java.lang.Object r8 = r5.next()
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            int[] r9 = r0.colorFormats
            int r10 = r9.length
            r13 = 0
        L_0x0132:
            if (r13 >= r10) goto L_0x011e
            r14 = r9[r13]
            if (r14 != r8) goto L_0x015a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            r0.append(r7)
            r0.append(r11)
            java.lang.String r1 = java.lang.Integer.toHexString(r14)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            io.agora.rtc.internal.Logging.d(r4, r0)
            io.agora.rtc.video.MediaCodecVideoDecoder$DecoderProperties r0 = new io.agora.rtc.video.MediaCodecVideoDecoder$DecoderProperties
            r0.<init>(r7, r14)
            return r0
        L_0x015a:
            int r13 = r13 + 1
            goto L_0x0132
        L_0x015d:
            int r6 = r6 + 1
            goto L_0x0023
        L_0x0161:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "No HW decoder found for mime "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            io.agora.rtc.internal.Logging.i(r4, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.MediaCodecVideoDecoder.findDecoder(java.lang.String, java.lang.String[]):io.agora.rtc.video.MediaCodecVideoDecoder$DecoderProperties");
    }

    private void getDecoderProperties(int i) {
        MediaCodecInfo mediaCodecInfo;
        String[] strArr = {VP8_MIME_TYPE, VP9_MIME_TYPE, H264_MIME_TYPE, H265_MIME_TYPE};
        this.supportCodecs = 0;
        String str = null;
        for (int i2 = 0; i2 < MediaCodecList.getCodecCount(); i2++) {
            try {
                mediaCodecInfo = MediaCodecList.getCodecInfoAt(i2);
            } catch (IllegalArgumentException e) {
                Logging.e(TAG, "Cannot retrieve decoder codec info", e);
                mediaCodecInfo = null;
            }
            if (mediaCodecInfo != null && !mediaCodecInfo.isEncoder()) {
                for (String str2 : mediaCodecInfo.getSupportedTypes()) {
                    if (str2.equals(VP8_MIME_TYPE)) {
                        this.supportCodecs |= 1;
                    } else if (str2.equals(H264_MIME_TYPE)) {
                        this.supportCodecs |= 2;
                    } else if (str2.equals(H265_MIME_TYPE)) {
                        this.supportCodecs |= 4;
                    }
                    if (str == null && str2.equals(strArr[i])) {
                        str = mediaCodecInfo.getName();
                        this.codecName = str;
                        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(strArr[i]);
                        if (Build.VERSION.SDK_INT >= 23) {
                            this.supportInstances = capabilitiesForType.getMaxSupportedInstances();
                        }
                    }
                }
            }
        }
    }

    private boolean initDecode(int i, int i2, int i3, SurfaceTextureHelper surfaceTextureHelper2, boolean z, Looper looper, long j, boolean z2, EglBase.Context context, String str) {
        String str2;
        String[] strArr;
        if (this.mediaCodecThread != null) {
            throw new RuntimeException("initDecode: Forgot to release()?");
        } else if (currentInstances.get() >= this.supportInstances) {
            return false;
        } else {
            currentInstances.incrementAndGet();
            if (z2) {
                if (surfaceTextureHelper2 == null) {
                    this.surfaceTextureHelper = SurfaceTextureHelper.create("ahwdectex", context, 16);
                } else {
                    this.surfaceTextureHelper = surfaceTextureHelper2;
                }
                if (this.surfaceTextureHelper == null) {
                    Logging.e(TAG, "failed to init decoder for surface output");
                    return false;
                }
            }
            this.useSurface = z2;
            VideoCodecType videoCodecType = VideoCodecType.values()[i];
            if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP8) {
                strArr = supportedVp8HwCodecPrefixes;
                str2 = VP8_MIME_TYPE;
            } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP9) {
                strArr = supportedVp9HwCodecPrefixes;
                str2 = VP9_MIME_TYPE;
            } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_H264) {
                strArr = supportedH264HwCodecPrefixes;
                str2 = H264_MIME_TYPE;
            } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_H265) {
                strArr = supportedH265HwCodecPrefixes;
                str2 = H265_MIME_TYPE;
            } else {
                throw new RuntimeException("initDecode: Non-supported codec " + videoCodecType);
            }
            DecoderProperties findDecoder = findDecoder(str2, strArr);
            if (findDecoder != null) {
                Logging.i(TAG, "Java initDecode: " + videoCodecType + " : " + i2 + " x " + i3 + ". Color: 0x" + Integer.toHexString(findDecoder.colorFormat) + ". Use Surface: " + z2 + ". Use async mode: " + z + ". nativeHandle: " + j);
                runningInstance = this;
                this.mediaCodecThread = Thread.currentThread();
                try {
                    this.width = i2;
                    this.height = i3;
                    this.stride = i2;
                    this.sliceHeight = i3;
                    this.cropWidth = i2;
                    this.cropHeight = i3;
                    if (findDecoder.codecName == null || Build.HARDWARE == null || !findDecoder.codecName.startsWith("OMX.hisi.") || !Build.HARDWARE.startsWith("bigfish")) {
                        this.isOMXHisi = false;
                    } else {
                        this.isOMXHisi = true;
                        Logging.d(TAG, " bigfish isOMXHisi: " + this.isOMXHisi);
                    }
                    MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str2, i2, i3);
                    if (!z2) {
                        createVideoFormat.setInteger("color-format", findDecoder.colorFormat);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        applyCustomConfig(createVideoFormat, new String(Base64.decode(str, 0)));
                    }
                    Logging.d(TAG, "Format: " + createVideoFormat);
                    MediaCodec createByCodecName = MediaCodecVideoEncoder.createByCodecName(findDecoder.codecName);
                    this.mediaCodec = createByCodecName;
                    if (createByCodecName == null) {
                        Logging.e(TAG, "Can not create media decoder");
                        return false;
                    }
                    this.nativeHandle = j;
                    this.useAsyncMode = z;
                    if (z) {
                        this.decoderCallback = new MediaCodecDecoderCallback();
                        if (looper == null) {
                            HandlerThread handlerThread = new HandlerThread("decoderAsyncHandler");
                            this.asyncHandlerThread = handlerThread;
                            handlerThread.start();
                            looper = this.asyncHandlerThread.getLooper();
                        }
                        this.mediaCodec.setCallback(this.decoderCallback, new Handler(looper));
                    }
                    if (z2) {
                        this.textureListener = new TextureListener(this.surfaceTextureHelper, this.decoderCallback);
                        this.surface = new Surface(this.surfaceTextureHelper.getSurfaceTexture());
                    }
                    this.mediaCodec.configure(createVideoFormat, this.surface, (MediaCrypto) null, 0);
                    this.mediaCodec.start();
                    Logging.d(TAG, "MediaCodec started");
                    this.colorFormat = findDecoder.colorFormat;
                    if (!z) {
                        this.outputBuffers = this.mediaCodec.getOutputBuffers();
                        this.inputBuffers = this.mediaCodec.getInputBuffers();
                        Logging.i(TAG, "Input buffers: " + this.inputBuffers.length + ". Output buffers: " + this.outputBuffers.length);
                    }
                    this.decodeStartTimeMsQueue.clear();
                    this.hasDecodedFirstFrame = false;
                    this.dequeuedSurfaceOutputBuffers.clear();
                    this.droppedFrames = 0;
                    return true;
                } catch (IllegalStateException e) {
                    Logging.e(TAG, "initDecode failed", e);
                    return false;
                }
            } else {
                throw new RuntimeException("Cannot find HW decoder for " + videoCodecType);
            }
        }
    }

    private void reset(int i, int i2) {
        if (this.mediaCodecThread == null || this.mediaCodec == null) {
            throw new RuntimeException("Incorrect reset call for non-initialized decoder.");
        }
        Logging.i(TAG, "Java reset: " + i + " x " + i2);
        if (this.useAsyncMode) {
            this.mediaCodec.flush();
            synchronized (this.decoderCallback.availableInputIndexes) {
                this.decoderCallback.availableInputIndexes.clear();
            }
            this.mediaCodec.start();
            Logging.d(TAG, "MediaCodec restarted");
        } else {
            this.mediaCodec.flush();
        }
        this.width = i;
        this.height = i2;
        this.decodeStartTimeMsQueue.clear();
        this.dequeuedSurfaceOutputBuffers.clear();
        this.hasDecodedFirstFrame = false;
        this.droppedFrames = 0;
    }

    private void release() {
        Logging.i(TAG, "Java releaseDecoder. Total number of dropped frames: " + this.droppedFrames);
        if (this.useAsyncMode) {
            HandlerThread handlerThread = this.asyncHandlerThread;
            if (handlerThread != null) {
                handlerThread.quit();
                this.asyncHandlerThread = null;
            }
            synchronized (this.decoderCallback) {
                this.decoderCallback.isObsolete = true;
            }
            this.decoderCallback = null;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final MediaCodec mediaCodec2 = this.mediaCodec;
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    Logging.i(MediaCodecVideoDecoder.TAG, "Java releaseDecoder on release thread");
                    mediaCodec2.stop();
                    mediaCodec2.release();
                    Logging.i(MediaCodecVideoDecoder.TAG, "Java releaseDecoder on release thread done");
                } catch (Exception e) {
                    Logging.e(MediaCodecVideoDecoder.TAG, "Media decoder release failed", e);
                }
                countDownLatch.countDown();
            }
        });
        if (!(thread instanceof Thread)) {
            thread.start();
        } else {
            AsynchronousInstrumentation.threadStart(thread);
        }
        if (!ThreadUtils.awaitUninterruptibly(countDownLatch, 5000)) {
            Logging.e(TAG, "Media decoder release timeout");
            codecErrors++;
            if (errorCallback != null) {
                Logging.e(TAG, "Invoke codec error callback. Errors: " + codecErrors);
                errorCallback.onMediaCodecVideoDecoderCriticalError(codecErrors);
            }
        }
        this.mediaCodec = null;
        this.mediaCodecThread = null;
        runningInstance = null;
        currentInstances.decrementAndGet();
        if (this.useSurface) {
            this.surface.release();
            this.surface = null;
            this.textureListener.release();
            this.surfaceTextureHelper.dispose();
            this.surfaceTextureHelper = null;
        }
        Logging.d(TAG, "Java releaseDecoder done");
    }

    static class InputBufferInfo {
        public final ByteBuffer buffer;
        public final int index;

        public InputBufferInfo(int i, ByteBuffer byteBuffer) {
            this.index = i;
            this.buffer = byteBuffer;
        }
    }

    private InputBufferInfo dequeueInputBufferAvailable() {
        InputBufferInfo inputBufferInfo;
        synchronized (this.decoderCallback.availableInputIndexes) {
            if (this.decoderCallback.availableInputIndexes.isEmpty()) {
                try {
                    this.decoderCallback.availableInputIndexes.wait(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Iterator it = this.decoderCallback.availableInputIndexes.iterator();
            if (!it.hasNext()) {
                Logging.e(TAG, "no input buffer available");
                inputBufferInfo = new InputBufferInfo(-1, (ByteBuffer) null);
            } else {
                int intValue = ((Integer) it.next()).intValue();
                it.remove();
                try {
                    inputBufferInfo = new InputBufferInfo(intValue, this.mediaCodec.getInputBuffer(intValue));
                } catch (IllegalStateException e2) {
                    Logging.e(TAG, "failed to get input buffer for index " + intValue + " : " + e2);
                    inputBufferInfo = new InputBufferInfo(-2, (ByteBuffer) null);
                }
            }
        }
        return inputBufferInfo;
    }

    private int dequeueInputBuffer() {
        try {
            return this.mediaCodec.dequeueInputBuffer(100000);
        } catch (IllegalStateException e) {
            Logging.e(TAG, "dequeueIntputBuffer failed", e);
            return -2;
        }
    }

    private boolean queueInputBuffer(int i, int i2, long j, long j2, long j3) {
        try {
            this.decodeStartTimeMsQueue.add(new TimeStamps(SystemClock.elapsedRealtime(), j2, j3));
            if (!this.useAsyncMode) {
                this.inputBuffers[i].position(0);
                int i3 = i2;
                this.inputBuffers[i].limit(i2);
            } else {
                int i4 = i2;
            }
            this.mediaCodec.queueInputBuffer(i, 0, i2, j, 0);
            return true;
        } catch (IllegalStateException e) {
            Logging.e(TAG, "decode failed", e);
            return false;
        }
    }

    private static class TimeStamps {
        /* access modifiers changed from: private */
        public final long decodeStartTimeMs;
        /* access modifiers changed from: private */
        public final long ntpTimeStamp;
        /* access modifiers changed from: private */
        public final long timeStamp;

        public TimeStamps(long j, long j2, long j3) {
            this.decodeStartTimeMs = j;
            this.timeStamp = j2;
            this.ntpTimeStamp = j3;
        }
    }

    private static class DecodedOutputBuffer {
        public final ByteBuffer buffer;
        /* access modifiers changed from: private */
        public final long bufferedFrames;
        /* access modifiers changed from: private */
        public final long decodeTimeMs;
        /* access modifiers changed from: private */
        public final long endDecodeTimeMs;
        private final int imageFormat;
        /* access modifiers changed from: private */
        public final int index;
        /* access modifiers changed from: private */
        public final long ntpTimeStampMs;
        private final int offset;
        /* access modifiers changed from: private */
        public final long presentationTimeStampMs;
        private final int size;
        /* access modifiers changed from: private */
        public final long timeStamp;

        public DecodedOutputBuffer(int i, ByteBuffer byteBuffer, int i2, int i3, int i4, long j, long j2, long j3, long j4, long j5, long j6) {
            this.index = i;
            this.offset = i2;
            this.size = i3;
            this.buffer = byteBuffer;
            this.imageFormat = i4;
            this.presentationTimeStampMs = j;
            this.timeStamp = j2;
            this.ntpTimeStampMs = j3;
            this.decodeTimeMs = j4;
            this.endDecodeTimeMs = j5;
            this.bufferedFrames = j6;
        }
    }

    private static class DecodedTextureBuffer {
        private final long bufferedFrames;
        private final long decodeTimeMs;
        private final long frameDelayMs;
        private final long ntpTimeStampMs;
        private final long presentationTimeStampMs;
        VideoFrame.TextureBuffer textureBuffer;
        private final long timeStamp;
        private final float[] transformMatrix;

        public DecodedTextureBuffer(float[] fArr, long j, long j2, long j3, long j4, long j5, VideoFrame.TextureBuffer textureBuffer2, long j6) {
            this.transformMatrix = fArr;
            this.presentationTimeStampMs = j;
            this.timeStamp = j2;
            this.ntpTimeStampMs = j3;
            this.decodeTimeMs = j4;
            this.frameDelayMs = j5;
            this.textureBuffer = textureBuffer2;
            this.bufferedFrames = j6;
        }
    }

    private DecodedOutputBuffer dequeueOutputBuffer(int i) {
        if (this.decodeStartTimeMsQueue.isEmpty()) {
            return null;
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        while (true) {
            int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, TimeUnit.MILLISECONDS.toMicros((long) i));
            if (dequeueOutputBuffer == -3) {
                this.outputBuffers = this.mediaCodec.getOutputBuffers();
                Logging.i(TAG, "Decoder output buffers changed: " + this.outputBuffers.length);
                if (this.hasDecodedFirstFrame) {
                    throw new RuntimeException("Unexpected output buffer change event.");
                }
            } else if (dequeueOutputBuffer == -2) {
                handleOutputFormatChanged(this.mediaCodec.getOutputFormat());
            } else if (dequeueOutputBuffer != -1) {
                return handleOutputBufferAvailable(dequeueOutputBuffer, this.outputBuffers[dequeueOutputBuffer], bufferInfo, getBufferColorFormat(dequeueOutputBuffer));
            } else {
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    public int getBufferColorFormat(int i) {
        if (i < 0 || Build.VERSION.SDK_INT < 21 || this.colorFormat != 2135033992) {
            return 0;
        }
        int integer = this.mediaCodec.getOutputFormat(i).getInteger("color-format");
        if (!this.isOMXHisi || integer != 47) {
            return integer;
        }
        return 17;
    }

    /* access modifiers changed from: private */
    public DecodedOutputBuffer handleOutputBufferAvailable(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i2) {
        long j;
        MediaCodec.BufferInfo bufferInfo2 = bufferInfo;
        TimeStamps poll = this.decodeStartTimeMsQueue.poll();
        if (poll == null) {
            Logging.e(TAG, "decodeStartTimeMs empty, dropping decoded output");
            return null;
        }
        this.hasDecodedFirstFrame = true;
        long elapsedRealtime = SystemClock.elapsedRealtime() - poll.decodeStartTimeMs;
        if (elapsedRealtime > MAX_DECODE_TIME_MS) {
            Logging.w(TAG, "Very high decode time: " + elapsedRealtime + "ms.");
            j = 2000;
        } else {
            j = elapsedRealtime;
        }
        return new DecodedOutputBuffer(i, byteBuffer, bufferInfo2.offset, bufferInfo2.size, i2, TimeUnit.MICROSECONDS.toMillis(bufferInfo2.presentationTimeUs), poll.timeStamp, poll.ntpTimeStamp, j, SystemClock.elapsedRealtime(), (long) this.decodeStartTimeMsQueue.size());
    }

    /* access modifiers changed from: private */
    public void handleOutputFormatChanged(MediaFormat mediaFormat) {
        Logging.i(TAG, "Decoder format changed: " + mediaFormat.toString());
        int integer = mediaFormat.getInteger("width");
        int integer2 = mediaFormat.getInteger("height");
        if (this.hasDecodedFirstFrame && !(integer == this.width && integer2 == this.height)) {
            Logging.w(TAG, "Decoder format changed. Configured " + this.width + "*" + this.height + ". New " + integer + "*" + integer2);
        }
        this.width = mediaFormat.getInteger("width");
        this.height = mediaFormat.getInteger("height");
        if (mediaFormat.containsKey("stride")) {
            this.stride = mediaFormat.getInteger("stride");
        }
        if (mediaFormat.containsKey("slice-height")) {
            this.sliceHeight = mediaFormat.getInteger("slice-height");
        }
        if (!mediaFormat.containsKey("crop-left") || !mediaFormat.containsKey("crop-right")) {
            this.cropWidth = this.width;
        } else {
            this.cropWidth = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        }
        if (!mediaFormat.containsKey("crop-bottom") || !mediaFormat.containsKey("crop-top")) {
            this.cropHeight = this.height;
        } else {
            this.cropHeight = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        }
        Logging.i(TAG, "Frame stride and slice height: " + this.stride + " x " + this.sliceHeight);
        Logging.i(TAG, "Crop width and height: " + this.cropWidth + " x " + this.cropHeight);
        this.stride = Math.max(this.width, this.stride);
        this.sliceHeight = Math.max(this.height, this.sliceHeight);
    }

    private void returnDecodedOutputBuffer(int i) throws IllegalStateException, MediaCodec.CodecException {
        if (!this.useSurface) {
            this.mediaCodec.releaseOutputBuffer(i, false);
            return;
        }
        throw new IllegalStateException("returnDecodedOutputBuffer() called for surface decoding.");
    }

    class MediaCodecDecoderCallback extends MediaCodec.Callback implements TextureListener.DecodedTextureBufferCallback {
        final LinkedHashSet<Integer> availableInputIndexes = new LinkedHashSet<>();
        boolean isObsolete = false;

        MediaCodecDecoderCallback() {
        }

        public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
            synchronized (this.availableInputIndexes) {
                this.availableInputIndexes.add(Integer.valueOf(i));
                this.availableInputIndexes.notifyAll();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0097, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onOutputBufferAvailable(android.media.MediaCodec r5, int r6, android.media.MediaCodec.BufferInfo r7) {
            /*
                r4 = this;
                monitor-enter(r4)
                boolean r5 = r4.isObsolete     // Catch:{ all -> 0x0098 }
                if (r5 == 0) goto L_0x000e
                java.lang.String r5 = "MediaCodecVideoDecoder"
                java.lang.String r6 = "discarding output as this callback is obsolete."
                io.agora.rtc.internal.Logging.w(r5, r6)     // Catch:{ all -> 0x0098 }
                monitor-exit(r4)     // Catch:{ all -> 0x0098 }
                return
            L_0x000e:
                io.agora.rtc.video.MediaCodecVideoDecoder r5 = io.agora.rtc.video.MediaCodecVideoDecoder.this     // Catch:{ all -> 0x0098 }
                int r5 = r5.getBufferColorFormat(r6)     // Catch:{ all -> 0x0098 }
                io.agora.rtc.video.MediaCodecVideoDecoder r0 = io.agora.rtc.video.MediaCodecVideoDecoder.this     // Catch:{ all -> 0x0098 }
                boolean r0 = r0.useSurface     // Catch:{ all -> 0x0098 }
                r1 = 0
                if (r0 != 0) goto L_0x0075
                io.agora.rtc.video.MediaCodecVideoDecoder r0 = io.agora.rtc.video.MediaCodecVideoDecoder.this     // Catch:{ IllegalStateException -> 0x005c }
                android.media.MediaCodec r0 = r0.mediaCodec     // Catch:{ IllegalStateException -> 0x005c }
                java.nio.ByteBuffer r0 = r0.getOutputBuffer(r6)     // Catch:{ IllegalStateException -> 0x005c }
                if (r0 != 0) goto L_0x0041
                java.lang.String r5 = "MediaCodecVideoDecoder"
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
                r7.<init>()     // Catch:{ all -> 0x0098 }
                java.lang.String r0 = "failed to get output buffer, index: "
                r7.append(r0)     // Catch:{ all -> 0x0098 }
                r7.append(r6)     // Catch:{ all -> 0x0098 }
                java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x0098 }
                io.agora.rtc.internal.Logging.e(r5, r6)     // Catch:{ all -> 0x0098 }
                monitor-exit(r4)     // Catch:{ all -> 0x0098 }
                return
            L_0x0041:
                io.agora.rtc.video.MediaCodecVideoDecoder r2 = io.agora.rtc.video.MediaCodecVideoDecoder.this     // Catch:{ all -> 0x0098 }
                io.agora.rtc.video.MediaCodecVideoDecoder$DecodedOutputBuffer r5 = r2.handleOutputBufferAvailable(r6, r0, r7, r5)     // Catch:{ all -> 0x0098 }
                if (r5 == 0) goto L_0x0052
                io.agora.rtc.video.MediaCodecVideoDecoder r7 = io.agora.rtc.video.MediaCodecVideoDecoder.this     // Catch:{ all -> 0x0098 }
                long r2 = r7.nativeHandle     // Catch:{ all -> 0x0098 }
                r7.deliverOutputYuvReady(r5, r2)     // Catch:{ all -> 0x0098 }
            L_0x0052:
                io.agora.rtc.video.MediaCodecVideoDecoder r5 = io.agora.rtc.video.MediaCodecVideoDecoder.this     // Catch:{ all -> 0x0098 }
                android.media.MediaCodec r5 = r5.mediaCodec     // Catch:{ all -> 0x0098 }
                r5.releaseOutputBuffer(r6, r1)     // Catch:{ all -> 0x0098 }
                goto L_0x0096
            L_0x005c:
                r5 = move-exception
                java.lang.String r7 = "MediaCodecVideoDecoder"
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
                r0.<init>()     // Catch:{ all -> 0x0098 }
                java.lang.String r1 = "getOutputBuffer exception, index: "
                r0.append(r1)     // Catch:{ all -> 0x0098 }
                r0.append(r6)     // Catch:{ all -> 0x0098 }
                java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0098 }
                io.agora.rtc.internal.Logging.e(r7, r6, r5)     // Catch:{ all -> 0x0098 }
                monitor-exit(r4)     // Catch:{ all -> 0x0098 }
                return
            L_0x0075:
                io.agora.rtc.video.MediaCodecVideoDecoder r0 = io.agora.rtc.video.MediaCodecVideoDecoder.this     // Catch:{ all -> 0x0098 }
                r2 = 0
                io.agora.rtc.video.MediaCodecVideoDecoder$DecodedOutputBuffer r5 = r0.handleOutputBufferAvailable(r6, r2, r7, r5)     // Catch:{ all -> 0x0098 }
                if (r5 != 0) goto L_0x0088
                io.agora.rtc.video.MediaCodecVideoDecoder r5 = io.agora.rtc.video.MediaCodecVideoDecoder.this     // Catch:{ all -> 0x0098 }
                android.media.MediaCodec r5 = r5.mediaCodec     // Catch:{ all -> 0x0098 }
                r5.releaseOutputBuffer(r6, r1)     // Catch:{ all -> 0x0098 }
                goto L_0x0096
            L_0x0088:
                io.agora.rtc.video.MediaCodecVideoDecoder r6 = io.agora.rtc.video.MediaCodecVideoDecoder.this     // Catch:{ all -> 0x0098 }
                java.util.Queue r6 = r6.dequeuedSurfaceOutputBuffers     // Catch:{ all -> 0x0098 }
                r6.add(r5)     // Catch:{ all -> 0x0098 }
                io.agora.rtc.video.MediaCodecVideoDecoder r5 = io.agora.rtc.video.MediaCodecVideoDecoder.this     // Catch:{ all -> 0x0098 }
                r5.MaybeRenderDecodedTextureBuffer()     // Catch:{ all -> 0x0098 }
            L_0x0096:
                monitor-exit(r4)     // Catch:{ all -> 0x0098 }
                return
            L_0x0098:
                r5 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0098 }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.MediaCodecVideoDecoder.MediaCodecDecoderCallback.onOutputBufferAvailable(android.media.MediaCodec, int, android.media.MediaCodec$BufferInfo):void");
        }

        public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            Logging.e(MediaCodecVideoDecoder.TAG, "onError " + codecException);
        }

        public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            Logging.w(MediaCodecVideoDecoder.TAG, "onOutputFormatChanged " + mediaFormat);
            MediaCodecVideoDecoder.this.handleOutputFormatChanged(mediaFormat);
        }

        public void onDecodedTextureBufferAvailable(DecodedTextureBuffer decodedTextureBuffer) {
            MediaCodecVideoDecoder.this.MaybeRenderDecodedTextureBuffer();
            MediaCodecVideoDecoder mediaCodecVideoDecoder = MediaCodecVideoDecoder.this;
            mediaCodecVideoDecoder.deliverOutputTextureReady(decodedTextureBuffer, mediaCodecVideoDecoder.nativeHandle);
        }
    }

    private static class TextureListener implements SurfaceTextureHelper.OnTextureFrameAvailableListener {
        private final Queue<DecodedOutputBuffer> decodedOutputBuffers;
        private final DecodedTextureBufferCallback decodedTextureBufferCallback;
        private final Queue<DecodedTextureBuffer> decodedTextureBuffers;
        private int height;
        private final Object newFrameLock = new Object();
        private final SurfaceTextureHelper surfaceTextureHelper;
        private int width;

        private interface DecodedTextureBufferCallback {
            void onDecodedTextureBufferAvailable(DecodedTextureBuffer decodedTextureBuffer);
        }

        public boolean isWaitingForTexture() {
            return false;
        }

        public TextureListener(SurfaceTextureHelper surfaceTextureHelper2, DecodedTextureBufferCallback decodedTextureBufferCallback2) {
            LinkedList linkedList = new LinkedList();
            this.decodedOutputBuffers = linkedList;
            this.decodedTextureBuffers = new LinkedList();
            this.surfaceTextureHelper = surfaceTextureHelper2;
            surfaceTextureHelper2.startListening(this);
            linkedList.clear();
            this.decodedTextureBufferCallback = decodedTextureBufferCallback2;
        }

        public void addBufferToRender(DecodedOutputBuffer decodedOutputBuffer) {
            synchronized (this.newFrameLock) {
                this.decodedOutputBuffers.add(decodedOutputBuffer);
            }
        }

        public void removeBufferToRender(DecodedOutputBuffer decodedOutputBuffer) {
            synchronized (this.newFrameLock) {
                this.decodedOutputBuffers.remove();
            }
        }

        public void updateResolution(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public void onTextureFrameAvailable(int i, float[] fArr, long j) {
            synchronized (this.newFrameLock) {
                DecodedOutputBuffer remove = this.decodedOutputBuffers.remove();
                VideoFrame.TextureBuffer createTextureBuffer = this.surfaceTextureHelper.createTextureBuffer(this.width, this.height, RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr));
                VideoFrame.TextureBuffer textureCopy = this.surfaceTextureHelper.textureCopy(createTextureBuffer);
                createTextureBuffer.release();
                DecodedTextureBuffer decodedTextureBuffer = new DecodedTextureBuffer(fArr, remove.presentationTimeStampMs, remove.timeStamp, remove.ntpTimeStampMs, remove.decodeTimeMs, SystemClock.elapsedRealtime() - remove.endDecodeTimeMs, textureCopy, remove.bufferedFrames);
                DecodedTextureBufferCallback decodedTextureBufferCallback2 = this.decodedTextureBufferCallback;
                if (decodedTextureBufferCallback2 != null) {
                    decodedTextureBufferCallback2.onDecodedTextureBufferAvailable(decodedTextureBuffer);
                } else {
                    this.decodedTextureBuffers.add(decodedTextureBuffer);
                    this.newFrameLock.notifyAll();
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:7|8|9|10) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public io.agora.rtc.video.MediaCodecVideoDecoder.DecodedTextureBuffer dequeueTextureBuffer() {
            /*
                r4 = this;
                java.lang.Object r0 = r4.newFrameLock
                monitor-enter(r0)
                java.util.Queue<io.agora.rtc.video.MediaCodecVideoDecoder$DecodedTextureBuffer> r1 = r4.decodedTextureBuffers     // Catch:{ all -> 0x0035 }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0035 }
                if (r1 == 0) goto L_0x0022
                java.util.Queue<io.agora.rtc.video.MediaCodecVideoDecoder$DecodedOutputBuffer> r1 = r4.decodedOutputBuffers     // Catch:{ all -> 0x0035 }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0035 }
                if (r1 != 0) goto L_0x0022
                java.lang.Object r1 = r4.newFrameLock     // Catch:{ InterruptedException -> 0x001b }
                r2 = 6
                long r2 = (long) r2     // Catch:{ InterruptedException -> 0x001b }
                r1.wait(r2)     // Catch:{ InterruptedException -> 0x001b }
                goto L_0x0022
            L_0x001b:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0035 }
                r1.interrupt()     // Catch:{ all -> 0x0035 }
            L_0x0022:
                r1 = 0
                java.util.Queue<io.agora.rtc.video.MediaCodecVideoDecoder$DecodedTextureBuffer> r2 = r4.decodedTextureBuffers     // Catch:{ all -> 0x0035 }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0035 }
                if (r2 != 0) goto L_0x0033
                java.util.Queue<io.agora.rtc.video.MediaCodecVideoDecoder$DecodedTextureBuffer> r1 = r4.decodedTextureBuffers     // Catch:{ all -> 0x0035 }
                java.lang.Object r1 = r1.remove()     // Catch:{ all -> 0x0035 }
                io.agora.rtc.video.MediaCodecVideoDecoder$DecodedTextureBuffer r1 = (io.agora.rtc.video.MediaCodecVideoDecoder.DecodedTextureBuffer) r1     // Catch:{ all -> 0x0035 }
            L_0x0033:
                monitor-exit(r0)     // Catch:{ all -> 0x0035 }
                return r1
            L_0x0035:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0035 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.MediaCodecVideoDecoder.TextureListener.dequeueTextureBuffer():io.agora.rtc.video.MediaCodecVideoDecoder$DecodedTextureBuffer");
        }

        public void release() {
            this.surfaceTextureHelper.stopListening();
            synchronized (this.newFrameLock) {
                this.surfaceTextureHelper.returnTextureFrame();
                this.decodedOutputBuffers.clear();
                for (DecodedTextureBuffer decodedTextureBuffer : this.decodedTextureBuffers) {
                    if (decodedTextureBuffer.textureBuffer != null) {
                        decodedTextureBuffer.textureBuffer.release();
                    }
                }
                this.decodedTextureBuffers.clear();
            }
        }
    }

    private DecodedTextureBuffer dequeueTextureBuffer(int i) {
        if (this.useSurface) {
            DecodedOutputBuffer dequeueOutputBuffer = dequeueOutputBuffer(i);
            if (dequeueOutputBuffer != null) {
                this.dequeuedSurfaceOutputBuffers.add(dequeueOutputBuffer);
            }
            MaybeRenderDecodedTextureBuffer();
            DecodedTextureBuffer dequeueTextureBuffer = this.textureListener.dequeueTextureBuffer();
            if (dequeueTextureBuffer != null) {
                MaybeRenderDecodedTextureBuffer();
                return dequeueTextureBuffer;
            } else if (this.dequeuedSurfaceOutputBuffers.size() < Math.min(3, this.outputBuffers.length)) {
                return null;
            } else {
                this.droppedFrames++;
                DecodedOutputBuffer remove = this.dequeuedSurfaceOutputBuffers.remove();
                this.textureListener.removeBufferToRender(remove);
                this.mediaCodec.releaseOutputBuffer(remove.index, false);
                return new DecodedTextureBuffer((float[]) null, remove.presentationTimeStampMs, remove.timeStamp, remove.ntpTimeStampMs, remove.decodeTimeMs, SystemClock.elapsedRealtime() - remove.endDecodeTimeMs, (VideoFrame.TextureBuffer) null, remove.bufferedFrames);
            }
        } else {
            throw new IllegalStateException("dequeueTexture() called for byte buffer decoding.");
        }
    }

    /* access modifiers changed from: private */
    public void MaybeRenderDecodedTextureBuffer() {
        DecodedOutputBuffer poll;
        if (!this.textureListener.isWaitingForTexture() && (poll = this.dequeuedSurfaceOutputBuffers.poll()) != null) {
            this.textureListener.addBufferToRender(poll);
            this.textureListener.updateResolution(this.cropWidth, this.cropHeight);
            this.mediaCodec.releaseOutputBuffer(poll.index, true);
        }
    }
}
