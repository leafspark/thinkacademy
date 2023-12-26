package io.agora.rtc.video;

import android.graphics.Matrix;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Range;
import android.view.Surface;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.EglBase10;
import io.agora.rtc.gl.EglBase14;
import io.agora.rtc.gl.GlRectDrawer;
import io.agora.rtc.gl.RendererCommon;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.internal.Logging;
import io.agora.rtc.utils.ThreadUtils;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGLContext;

public class MediaCodecVideoEncoder extends MediaCodecBase {
    private static final String[] ASYNC_EXCLUDED_MODELS = {"SM-G7810"};
    private static final int BASE_FRAME_RATE_FOR_AMLOGIC = 30;
    private static final int BASE_FRAME_RATE_FOR_EXYNOS = 30;
    private static final int BASE_FRAME_RATE_FOR_HIS_HISI = 30;
    private static final int BASE_FRAME_RATE_FOR_HIS_K3 = 30;
    private static final int BASE_FRAME_RATE_FOR_HIS_TOPAZ = 30;
    private static final int BASE_FRAME_RATE_FOR_MTK = 30;
    private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    private static final int DEQUEUE_TIMEOUT = 0;
    private static final String[] H264_HW_EXCEPTION_MODELS = {"SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4", "P6-C00", "HM 2A", "XT105", "XT109", "XT1060"};
    private static final String[] H264_HW_QCOM_EXCEPTION_MODELS = {"mi note lte", "redmi note 4x", "1605-a01", "aosp on hammerhead", "lm-x210", "oppo r9s"};
    private static final String H264_MIME_TYPE = "video/avc";
    private static final String[] H265_HW_EXCEPTION_HARDWARES = {"mt6771", "mt6762"};
    private static final String[] H265_HW_EXCEPTION_MODELS = new String[0];
    private static final String H265_MIME_TYPE = "video/hevc";
    private static final String[] INTERVAL_HW_EXCEPTION_MODELS = {"vivo X21A", "MI 8", "MI 6"};
    private static final int INT_INTERVAL_UPPER_LIMIT = 100;
    private static final int INT_SETTING_INTERVAL_VALUE = 10;
    private static final int KBPS_TO_BPS_FACTOR = 900;
    private static final int KBPS_TO_BPS_FACTOR_QCOM = 950;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 3000;
    private static final String[] MTK_NO_ADJUSTMENT_MODELS = {"vivo y83a", "vivo x21i", "vivo X21i A"};
    private static final String TAG = "MediaCodecVideoEncoder";
    private static final boolean VERBOSE = false;
    private static final int VIDEO_ControlRateConstant = 2;
    private static final int VIDEO_ControlRateVariable = 1;
    private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
    private static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
    private static int codecErrors;
    private static String codecOmxName = null;
    private static MediaCodecVideoEncoderErrorCallback errorCallback;
    private static Set<String> hwEncoderDisabledTypes = new HashSet();
    private static int mH264SupportProfileHigh = 0;
    private static final int[] supportedColorList = {19, 21, 2141391872, COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m};
    private static final String[] supportedH264HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos.", "OMX.MTK.", "OMX.IMG.TOPAZ.", "OMX.hisi.", "OMX.k3.", "OMX.amlogic.", "OMX.rk.", "OMX.MS."};
    private static final String[] supportedH265HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos.", "OMX.MTK.", "OMX.IMG.TOPAZ.", "OMX.hisi.", "OMX.k3.", "OMX.amlogic.", "OMX.rk."};
    private static final int[] supportedSurfaceColorList = {2130708361};
    private static final String[] supportedVp8HwCodecPrefixes = {"OMX.qcom.", "OMX.Intel."};
    private static final String[] supportedVp9HwCodecPrefixes = {"OMX.qcom."};
    private int SDKVer;
    /* access modifiers changed from: private */
    public MediaCodecEncoderCallback asyncEncoderCallback;
    /* access modifiers changed from: private */
    public final LinkedHashSet<Integer> availableInputIndexes = new LinkedHashSet<>();
    private int bitrateAdjustmentType;
    private int bitrateMode = 2;
    /* access modifiers changed from: private */
    public final Object callbackLock = new Object();
    private ChipProperties chipProperties = null;
    private String codecName;
    private int colorFormat;
    /* access modifiers changed from: private */
    public ByteBuffer configData = null;
    private int converted_bps;
    private String cpuModel;
    private Handler dedicatedHandler = null;
    private HandlerThread dedicatedHandlerThread;
    private String deviceModel;
    private GlRectDrawer drawer;
    private boolean eglAttachedOnDedicatedThread = false;
    private EglBase eglBase;
    private FileOutputStream fos = null;
    private boolean hasPendingKeyFrame = false;
    private int height;
    private int heightAlignment = 4;
    private Surface inputSurface;
    private boolean isInitialized = false;
    private int keyFrameEncodeMinInterval = 100;
    private int keyFrameIntervalInMsec = 0;
    private long lastKeyFrameTimeMs = 0;
    private long lastResetForQcomTimeMs = 0;
    private int lastSetFps;
    private int maxSupportedBitrate = 0;
    private int maxSupportedHeight = 32768;
    private int maxSupportedWidth = 32768;
    /* access modifiers changed from: private */
    public MediaCodec mediaCodec;
    private int memoryType = 0;
    private int minSupportedBitrate = 0;
    private int minSupportedHeight = 2;
    private int minSupportedWidth = 2;
    /* access modifiers changed from: private */
    public long nativeHandle;
    @Deprecated
    private ByteBuffer[] outputBuffers;
    private int outputFrameRotation;
    private int profile = 66;
    private boolean qcomExceptionModel = false;
    private final Matrix rotateMatrix = new Matrix();
    private String settingAdjustmentConfs = null;
    private int settingAdjustmentReset = -1;
    private int settingBitrateAdjustmentType = -1;
    private int settingBitrateBaseFPS = -1;
    private int settingBitrateFactor = -1;
    private int settingBitrateMode = -1;
    private int settingCodecParameterForExynos = -1;
    private int settingHighProfile = -1;
    private String settingInitConfs = null;
    private int settingMaxFPS = -1;
    private int settingMaxHeight = -1;
    private int settingMaxWidth = -1;
    private int supportCodecs = 0;
    private VideoCodecType type;
    /* access modifiers changed from: private */
    public boolean useAsyncMode = false;
    private int width;
    private int widthAlignment = 16;

    public enum BitrateAdjustmentType {
        NO_ADJUSTMENT,
        FRAMERATE_ADJUSTMENT,
        ACTUAL_FRAMERATE_ADJUSTMENT,
        DYNAMIC_ADJUSTMENT
    }

    public interface MediaCodecVideoEncoderErrorCallback {
        void onMediaCodecVideoEncoderCriticalError(int i);
    }

    public enum VideoCodecType {
        VIDEO_CODEC_VP8,
        VIDEO_CODEC_VP9,
        VIDEO_CODEC_H264,
        VIDEO_CODEC_H265
    }

    /* access modifiers changed from: private */
    public native void onAsyncEncodeFrameResult(long j, boolean z, OutputBufferInfo outputBufferInfo);

    private int supportedEncoderConfig(int i, int i2, int i3, int i4) {
        return 0;
    }

    public static boolean isAsyncModeSupported() {
        if (Build.VERSION.SDK_INT >= 23 && !Arrays.asList(ASYNC_EXCLUDED_MODELS).contains(Build.MODEL)) {
            return true;
        }
        return false;
    }

    public static void setErrorCallback(MediaCodecVideoEncoderErrorCallback mediaCodecVideoEncoderErrorCallback) {
        Logging.d(TAG, "Set error callback");
        errorCallback = mediaCodecVideoEncoderErrorCallback;
    }

    public static void disableVp8HwCodec() {
        Logging.w(TAG, "VP8 encoding is disabled by application.");
        hwEncoderDisabledTypes.add(VP8_MIME_TYPE);
    }

    public static void disableVp9HwCodec() {
        Logging.w(TAG, "VP9 encoding is disabled by application.");
        hwEncoderDisabledTypes.add(VP9_MIME_TYPE);
    }

    public static void disableH264HwCodec() {
        Logging.w(TAG, "H.264 encoding is disabled by application.");
        hwEncoderDisabledTypes.add(H264_MIME_TYPE);
    }

    public static void disableH265HwCodec() {
        Logging.w(TAG, "H.265 encoding is disabled by application.");
        hwEncoderDisabledTypes.add(H265_MIME_TYPE);
    }

    public static boolean isVp8HwSupported() {
        return !hwEncoderDisabledTypes.contains(VP8_MIME_TYPE) && findHwEncoder(VP8_MIME_TYPE, supportedVp8HwCodecPrefixes, supportedColorList) != null;
    }

    public static boolean isVp9HwSupported() {
        return !hwEncoderDisabledTypes.contains(VP9_MIME_TYPE) && findHwEncoder(VP9_MIME_TYPE, supportedVp9HwCodecPrefixes, supportedColorList) != null;
    }

    public static boolean isH264HwSupported() {
        try {
            if (hwEncoderDisabledTypes.contains(H264_MIME_TYPE) || findHwEncoder(H264_MIME_TYPE, supportedH264HwCodecPrefixes, supportedColorList) == null) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            Logging.e(TAG, "isH264HwSupported failed!");
            return false;
        }
    }

    public static boolean isH265HwSupported() {
        try {
            if (hwEncoderDisabledTypes.contains(H265_MIME_TYPE) || findHwEncoder(H265_MIME_TYPE, supportedH265HwCodecPrefixes, supportedColorList) == null) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            Logging.e(TAG, "isH265HwSupported failed!");
            return false;
        }
    }

    public static boolean isVp8HwSupportedUsingTextures() {
        return !hwEncoderDisabledTypes.contains(VP8_MIME_TYPE) && findHwEncoder(VP8_MIME_TYPE, supportedVp8HwCodecPrefixes, supportedSurfaceColorList) != null;
    }

    public static boolean isVp9HwSupportedUsingTextures() {
        return !hwEncoderDisabledTypes.contains(VP9_MIME_TYPE) && findHwEncoder(VP9_MIME_TYPE, supportedVp9HwCodecPrefixes, supportedSurfaceColorList) != null;
    }

    public static boolean isH264HwSupportedUsingTextures() {
        try {
            return !hwEncoderDisabledTypes.contains(H264_MIME_TYPE) && findHwEncoder(H264_MIME_TYPE, supportedH264HwCodecPrefixes, supportedSurfaceColorList) != null;
        } catch (Exception unused) {
            Logging.e(TAG, "isH264HwSupportedUsingTextures failed!");
            return false;
        }
    }

    public static boolean isH265HwSupportedUsingTextures() {
        try {
            return !hwEncoderDisabledTypes.contains(H265_MIME_TYPE) && findHwEncoder(H265_MIME_TYPE, supportedH265HwCodecPrefixes, supportedSurfaceColorList) != null;
        } catch (Exception unused) {
            Logging.e(TAG, "isH265HwSupportedUsingTextures failed!");
            return false;
        }
    }

    private static boolean isA50OrHigher() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static int isH264HwHighProfileSupported() {
        return mH264SupportProfileHigh;
    }

    private static class EncoderProperties {
        public final String codecName;
        public final int colorFormat;
        public final boolean supportedList;

        public EncoderProperties(String str, int i, boolean z) {
            this.codecName = str;
            this.colorFormat = i;
            this.supportedList = z;
        }
    }

    private static EncoderProperties findHwEncoder(String str, String[] strArr, int[] iArr) {
        try {
            return do_findHwEncoder(str, strArr, iArr);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: io.agora.rtc.video.MediaCodecVideoEncoder$EncoderProperties} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: io.agora.rtc.video.MediaCodecVideoEncoder$EncoderProperties} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: io.agora.rtc.video.MediaCodecVideoEncoder$EncoderProperties} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static io.agora.rtc.video.MediaCodecVideoEncoder.EncoderProperties do_findHwEncoder(java.lang.String r18, java.lang.String[] r19, int[] r20) {
        /*
            r0 = r18
            r1 = r20
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 19
            r4 = 0
            if (r2 >= r3) goto L_0x000c
            return r4
        L_0x000c:
            r2 = 0
            r5 = r1[r2]
            r6 = 2130708361(0x7f000789, float:1.701803E38)
            r7 = 1
            if (r5 != r6) goto L_0x0017
            r5 = r7
            goto L_0x0018
        L_0x0017:
            r5 = r2
        L_0x0018:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Model: "
            r8.append(r9)
            java.lang.String r10 = android.os.Build.MODEL
            r8.append(r10)
            java.lang.String r10 = ", hardware: "
            r8.append(r10)
            java.lang.String r10 = android.os.Build.HARDWARE
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            java.lang.String r10 = "MediaCodecVideoEncoder"
            io.agora.rtc.internal.Logging.i(r10, r8)
            java.lang.String r8 = "video/avc"
            boolean r11 = r0.equals(r8)
            if (r11 == 0) goto L_0x0077
            java.lang.String[] r11 = H264_HW_EXCEPTION_MODELS
            java.util.List r11 = java.util.Arrays.asList(r11)
            java.lang.String r12 = android.os.Build.MODEL
            boolean r11 = r11.contains(r12)
            if (r11 == 0) goto L_0x006a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r9)
            java.lang.String r1 = android.os.Build.MODEL
            r0.append(r1)
            java.lang.String r1 = " has black listed H.264 encoder."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            io.agora.rtc.internal.Logging.w(r10, r0)
            return r4
        L_0x006a:
            java.lang.String r9 = android.os.Build.HARDWARE
            java.lang.String r11 = "kirin970"
            boolean r9 = r9.equalsIgnoreCase(r11)
            if (r9 == 0) goto L_0x00a9
            if (r5 != 0) goto L_0x00a9
            return r4
        L_0x0077:
            java.lang.String r9 = "video/hevc"
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto L_0x00a9
            java.lang.String[] r9 = H265_HW_EXCEPTION_HARDWARES
            java.util.List r9 = java.util.Arrays.asList(r9)
            java.lang.String r11 = android.os.Build.HARDWARE
            boolean r9 = r9.contains(r11)
            if (r9 == 0) goto L_0x00a9
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Hardware: "
            r0.append(r1)
            java.lang.String r1 = android.os.Build.HARDWARE
            r0.append(r1)
            java.lang.String r1 = " has black listed H.265 encoder."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            io.agora.rtc.internal.Logging.w(r10, r0)
            return r4
        L_0x00a9:
            r9 = r2
        L_0x00aa:
            int r11 = android.media.MediaCodecList.getCodecCount()
            if (r9 >= r11) goto L_0x0239
            android.media.MediaCodecInfo r11 = android.media.MediaCodecList.getCodecInfoAt(r9)
            boolean r12 = r11.isEncoder()
            if (r12 != 0) goto L_0x00c0
        L_0x00ba:
            r16 = r3
            r17 = r7
            goto L_0x022c
        L_0x00c0:
            java.lang.String[] r12 = r11.getSupportedTypes()
            int r13 = r12.length
            r14 = r2
        L_0x00c6:
            if (r14 >= r13) goto L_0x00d8
            r15 = r12[r14]
            boolean r15 = r15.equals(r0)
            if (r15 == 0) goto L_0x00d5
            java.lang.String r12 = r11.getName()
            goto L_0x00d9
        L_0x00d5:
            int r14 = r14 + 1
            goto L_0x00c6
        L_0x00d8:
            r12 = r4
        L_0x00d9:
            if (r12 != 0) goto L_0x00dc
            goto L_0x00ba
        L_0x00dc:
            boolean r13 = checkMinSDKVersion(r12, r5)
            if (r13 != 0) goto L_0x00f7
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r13 = "Check min sdk version failed, "
            r11.append(r13)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            io.agora.rtc.internal.Logging.e(r10, r11)
            goto L_0x00ba
        L_0x00f7:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Found candidate encoder "
            r13.append(r14)
            r13.append(r12)
            java.lang.String r13 = r13.toString()
            io.agora.rtc.internal.Logging.i(r10, r13)
            java.lang.String r13 = "OMX."
            boolean r13 = r12.startsWith(r13)
            if (r13 != 0) goto L_0x0116
            if (r5 != 0) goto L_0x0116
            goto L_0x00ba
        L_0x0116:
            codecOmxName = r12
            android.media.MediaCodecInfo$CodecCapabilities r11 = r11.getCapabilitiesForType(r0)
            boolean r13 = r0.equals(r8)
            if (r13 == 0) goto L_0x0137
            android.media.MediaCodecInfo$CodecProfileLevel[] r13 = r11.profileLevels
            int r14 = r13.length
            r15 = r2
        L_0x0126:
            if (r15 >= r14) goto L_0x0137
            r2 = r13[r15]
            int r2 = r2.profile
            r4 = 8
            if (r2 != r4) goto L_0x0132
            mH264SupportProfileHigh = r7
        L_0x0132:
            int r15 = r15 + 1
            r2 = 0
            r4 = 0
            goto L_0x0126
        L_0x0137:
            java.lang.String r2 = "OMX.amlogic."
            boolean r2 = r12.startsWith(r2)
            if (r2 == 0) goto L_0x014d
            if (r5 == 0) goto L_0x0147
            io.agora.rtc.video.MediaCodecVideoEncoder$EncoderProperties r0 = new io.agora.rtc.video.MediaCodecVideoEncoder$EncoderProperties
            r0.<init>(r12, r6, r7)
            return r0
        L_0x0147:
            io.agora.rtc.video.MediaCodecVideoEncoder$EncoderProperties r0 = new io.agora.rtc.video.MediaCodecVideoEncoder$EncoderProperties
            r0.<init>(r12, r3, r7)
            return r0
        L_0x014d:
            int[] r2 = r11.colorFormats
            int r4 = r2.length
            java.lang.String r13 = "   Color:"
            r14 = 0
            r15 = 0
        L_0x0154:
            r6 = 21
            if (r14 >= r4) goto L_0x017e
            r7 = r2[r14]
            if (r6 != r7) goto L_0x015d
            r15 = 1
        L_0x015d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r13)
            java.lang.String r13 = " 0x"
            r6.append(r13)
            java.lang.String r7 = java.lang.Integer.toHexString(r7)
            r6.append(r7)
            java.lang.String r7 = ", "
            r6.append(r7)
            java.lang.String r13 = r6.toString()
            int r14 = r14 + 1
            r7 = 1
            goto L_0x0154
        L_0x017e:
            io.agora.rtc.internal.Logging.d(r10, r13)
            int r2 = r1.length
            r4 = 0
        L_0x0183:
            if (r4 >= r2) goto L_0x0228
            r7 = r1[r4]
            int[] r13 = r11.colorFormats
            int r14 = r13.length
            r6 = 0
        L_0x018b:
            if (r6 >= r14) goto L_0x021b
            r3 = r13[r6]
            if (r3 != r7) goto L_0x020f
            java.lang.String r1 = ". Color: 0x"
            java.lang.String r2 = " : "
            java.lang.String r4 = "Found target encoder for mime "
            r5 = 19
            if (r3 != r5) goto L_0x01e6
            r5 = 1
            if (r15 != r5) goto L_0x01e6
            java.lang.String r5 = "OMX.IMG.TOPAZ."
            boolean r5 = r12.startsWith(r5)
            if (r5 != 0) goto L_0x01b6
            java.lang.String r5 = "OMX.hisi."
            boolean r5 = r12.startsWith(r5)
            if (r5 != 0) goto L_0x01b6
            java.lang.String r5 = "OMX.k3."
            boolean r5 = r12.startsWith(r5)
            if (r5 == 0) goto L_0x01e6
        L_0x01b6:
            java.lang.String r3 = "TOPAZ,force use COLOR_FormatYUV420SemiPlanar"
            io.agora.rtc.internal.Logging.i(r10, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r4)
            r3.append(r0)
            r3.append(r2)
            r3.append(r12)
            r3.append(r1)
            r0 = 21
            java.lang.String r1 = java.lang.Integer.toHexString(r0)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            io.agora.rtc.internal.Logging.i(r10, r1)
            io.agora.rtc.video.MediaCodecVideoEncoder$EncoderProperties r1 = new io.agora.rtc.video.MediaCodecVideoEncoder$EncoderProperties
            r2 = 1
            r1.<init>(r12, r0, r2)
            return r1
        L_0x01e6:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r0)
            r5.append(r2)
            r5.append(r12)
            r5.append(r1)
            java.lang.String r0 = java.lang.Integer.toHexString(r3)
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            io.agora.rtc.internal.Logging.i(r10, r0)
            io.agora.rtc.video.MediaCodecVideoEncoder$EncoderProperties r0 = new io.agora.rtc.video.MediaCodecVideoEncoder$EncoderProperties
            r1 = 1
            r0.<init>(r12, r3, r1)
            return r0
        L_0x020f:
            r3 = 21
            r16 = 19
            r17 = 1
            int r6 = r6 + 1
            r3 = r16
            goto L_0x018b
        L_0x021b:
            r16 = r3
            r3 = 21
            r17 = 1
            int r4 = r4 + 1
            r6 = r3
            r3 = r16
            goto L_0x0183
        L_0x0228:
            r16 = r3
            r17 = 1
        L_0x022c:
            int r9 = r9 + 1
            r3 = r16
            r7 = r17
            r2 = 0
            r4 = 0
            r6 = 2130708361(0x7f000789, float:1.701803E38)
            goto L_0x00aa
        L_0x0239:
            r2 = r4
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.MediaCodecVideoEncoder.do_findHwEncoder(java.lang.String, java.lang.String[], int[]):io.agora.rtc.video.MediaCodecVideoEncoder$EncoderProperties");
    }

    private void getEncoderProperties(int i) {
        String[] strArr = {VP8_MIME_TYPE, VP9_MIME_TYPE, H264_MIME_TYPE, H265_MIME_TYPE};
        this.supportCodecs = 0;
        String str = null;
        for (int i2 = 0; i2 < MediaCodecList.getCodecCount(); i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equals(VP8_MIME_TYPE)) {
                        this.supportCodecs |= 1;
                    } else if (str2.equals(H264_MIME_TYPE)) {
                        this.supportCodecs |= 2;
                    } else if (str2.equals(H265_MIME_TYPE)) {
                        this.supportCodecs |= 4;
                    }
                    if (str == null && str2.equals(strArr[i])) {
                        str = codecInfoAt.getName();
                        MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(strArr[i]);
                        if (isA50OrHigher()) {
                            MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                            Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
                            Range<Integer> supportedHeights = videoCapabilities.getSupportedHeights();
                            this.maxSupportedWidth = supportedWidths.getUpper().intValue();
                            this.maxSupportedHeight = supportedHeights.getUpper().intValue();
                            this.minSupportedWidth = supportedWidths.getLower().intValue();
                            this.minSupportedHeight = supportedHeights.getLower().intValue();
                            this.widthAlignment = videoCapabilities.getWidthAlignment();
                            this.heightAlignment = videoCapabilities.getHeightAlignment();
                            Range<Integer> bitrateRange = videoCapabilities.getBitrateRange();
                            this.maxSupportedBitrate = bitrateRange.getUpper().intValue();
                            this.minSupportedBitrate = bitrateRange.getLower().intValue();
                            Logging.i(TAG, "max supported size:" + this.maxSupportedWidth + "x" + this.maxSupportedHeight + " min supported size:" + this.minSupportedWidth + "x" + this.minSupportedHeight + " align size: " + this.widthAlignment + "x" + this.heightAlignment + " bitrate range: " + this.maxSupportedBitrate + " -> " + this.minSupportedBitrate);
                        }
                    }
                }
            }
        }
        this.SDKVer = Build.VERSION.SDK_INT;
        this.deviceModel = Build.MODEL;
        this.cpuModel = Build.HARDWARE;
    }

    private static class ChipProperties {
        public int baseFrameRate;
        public BitrateAdjustmentType bitrateAdjustmentType;
        public String chipName;
        public int highProfileMinSdkVersion;
        public int initFrameRate;
        public boolean isNeedResetWhenDownBps;

        ChipProperties(String str, BitrateAdjustmentType bitrateAdjustmentType2, boolean z, int i, int i2, int i3) {
            this.chipName = str;
            this.bitrateAdjustmentType = bitrateAdjustmentType2;
            this.isNeedResetWhenDownBps = z;
            this.baseFrameRate = i;
            this.initFrameRate = i2;
            this.highProfileMinSdkVersion = i3;
        }
    }

    static MediaCodec createByCodecName(String str) {
        try {
            return MediaCodec.createByCodecName(str);
        } catch (Exception e) {
            Logging.e(TAG, "create media encoder failed, ", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void nativeCreate(long j) {
        this.nativeHandle = j;
        Logging.i(TAG, "nativeCreate handle: " + j);
    }

    /* access modifiers changed from: package-private */
    public void nativeDestroy() {
        Logging.i(TAG, "nativeDestroy");
        HandlerThread handlerThread = this.dedicatedHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.dedicatedHandlerThread = null;
        }
        this.dedicatedHandler = null;
        this.nativeHandle = 0;
    }

    private boolean isOnDedicatedHandlerThread() {
        HandlerThread handlerThread = this.dedicatedHandlerThread;
        return handlerThread != null && handlerThread.getId() == Thread.currentThread().getId();
    }

    public static class InitParameters {
        int bitrateKbps;
        int codec;
        String customConfigJson;
        boolean fallbackToBaselineProfile;
        int fps;
        int height;
        int init_fps;
        int keyInterval;
        int profile;
        EGLContext sharedEgl10Context;
        android.opengl.EGLContext sharedEgl14Context;
        boolean useAsyncMode;
        int width;

        public InitParameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, boolean z2, android.opengl.EGLContext eGLContext, EGLContext eGLContext2, String str) {
            this.codec = i;
            this.width = i2;
            this.height = i3;
            this.bitrateKbps = i4;
            this.fps = i5;
            this.init_fps = i6;
            this.keyInterval = i7;
            this.fallbackToBaselineProfile = z;
            this.profile = i8;
            this.useAsyncMode = z2;
            this.sharedEgl14Context = eGLContext;
            this.sharedEgl10Context = eGLContext2;
            if (!TextUtils.isEmpty(str)) {
                this.customConfigJson = new String(Base64.decode(str, 0));
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean useSurface() {
            return (this.sharedEgl14Context == null && this.sharedEgl10Context == null) ? false : true;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(VideoCodecType.values()[this.codec]);
            sb.append(" : " + this.width + " x " + this.height);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" @ ");
            sb2.append(this.bitrateKbps);
            sb2.append(" Kbps,");
            sb.append(sb2.toString());
            sb.append(" Fps: ");
            sb.append(this.fps + ",");
            sb.append(" Key interval: " + this.keyInterval + "s,");
            sb.append(" Encode from texture : " + useSurface() + ",");
            sb.append(" Async mode: " + this.useAsyncMode + ".");
            StringBuilder sb3 = new StringBuilder();
            sb3.append(" Custom config: ");
            sb3.append(this.customConfigJson);
            sb.append(sb3.toString());
            return sb.toString();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean initEncoder(final InitParameters initParameters) {
        boolean z = initParameters.useAsyncMode;
        this.useAsyncMode = z;
        if (z || initParameters.useSurface()) {
            if (this.dedicatedHandlerThread == null) {
                HandlerThread handlerThread = new HandlerThread("encodeHandler");
                this.dedicatedHandlerThread = handlerThread;
                handlerThread.start();
            }
            this.dedicatedHandler = new Handler(this.dedicatedHandlerThread.getLooper());
        }
        AnonymousClass1 r0 = new Callable<Boolean>() {
            public Boolean call() throws Exception {
                boolean access$000 = MediaCodecVideoEncoder.this.doInitEncoder(initParameters);
                if (!access$000 && initParameters.fallbackToBaselineProfile && initParameters.profile != 66) {
                    initParameters.profile = 66;
                    Logging.w(MediaCodecVideoEncoder.TAG, "Init encoder: retry with baseline profile");
                    access$000 = MediaCodecVideoEncoder.this.doInitEncoder(initParameters);
                }
                return Boolean.valueOf(access$000);
            }
        };
        boolean z2 = false;
        Handler handler = this.dedicatedHandler;
        if (handler != null) {
            z2 = ((Boolean) ThreadUtils.invokeAtFrontUninterruptibly(handler, r0)).booleanValue();
        } else {
            try {
                z2 = ((Boolean) r0.call()).booleanValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Init encoder done: ");
        sb.append(z2 ? "success" : "failed");
        Logging.i(TAG, sb.toString());
        return z2;
    }

    /* access modifiers changed from: private */
    public boolean doInitEncoder(InitParameters initParameters) {
        if (this.isInitialized) {
            Logging.w(TAG, "already initialized!");
            return true;
        }
        try {
            if (!createEncoder(initParameters)) {
                Logging.e(TAG, "failed to create hardware encoder!!");
                return false;
            }
            this.isInitialized = true;
            initEglForEncoderIfNeeded(initParameters);
            this.mediaCodec.start();
            if (!this.useAsyncMode) {
                this.outputBuffers = this.mediaCodec.getOutputBuffers();
                Logging.d(TAG, "Output buffers: " + this.outputBuffers.length);
            }
            return true;
        } catch (Exception e) {
            Logging.e(TAG, "failed to create hardware encoder,", e);
            try {
                release();
            } catch (Exception e2) {
                Logging.e(TAG, "failed to release hardware encoder,", e2);
            }
            return false;
        }
    }

    private boolean createEncoder(InitParameters initParameters) throws RuntimeException {
        EncoderProperties encoderProperties;
        Logging.i(TAG, "Java initEncode: " + initParameters.toString());
        this.width = initParameters.width;
        int i = initParameters.height;
        this.height = i;
        if (this.width < this.minSupportedWidth || i < this.minSupportedHeight) {
            Logging.w(TAG, "Not supported size:" + this.width + "x" + this.height);
            return false;
        }
        if (initParameters.fps < 1) {
            initParameters.fps = 1;
        }
        if (initParameters.keyInterval < 1) {
            initParameters.keyInterval = 1;
        }
        this.lastSetFps = initParameters.fps;
        this.keyFrameIntervalInMsec = initParameters.keyInterval * 1000;
        this.lastKeyFrameTimeMs = 0;
        this.lastResetForQcomTimeMs = SystemClock.elapsedRealtime();
        VideoCodecType videoCodecType = VideoCodecType.values()[initParameters.codec];
        this.type = videoCodecType;
        VideoCodecType videoCodecType2 = VideoCodecType.VIDEO_CODEC_VP8;
        String str = H265_MIME_TYPE;
        if (videoCodecType == videoCodecType2) {
            encoderProperties = findHwEncoder(VP8_MIME_TYPE, supportedVp8HwCodecPrefixes, initParameters.useSurface() ? supportedSurfaceColorList : supportedColorList);
            str = VP8_MIME_TYPE;
        } else if (this.type == VideoCodecType.VIDEO_CODEC_VP9) {
            encoderProperties = findHwEncoder(VP9_MIME_TYPE, supportedH264HwCodecPrefixes, initParameters.useSurface() ? supportedSurfaceColorList : supportedColorList);
            str = VP9_MIME_TYPE;
        } else if (this.type == VideoCodecType.VIDEO_CODEC_H264) {
            encoderProperties = findHwEncoder(H264_MIME_TYPE, supportedH264HwCodecPrefixes, initParameters.useSurface() ? supportedSurfaceColorList : supportedColorList);
            str = H264_MIME_TYPE;
        } else if (this.type == VideoCodecType.VIDEO_CODEC_H265) {
            encoderProperties = findHwEncoder(str, supportedH265HwCodecPrefixes, initParameters.useSurface() ? supportedSurfaceColorList : supportedColorList);
        } else {
            encoderProperties = null;
            str = null;
        }
        if (encoderProperties != null) {
            ChipProperties chipProperties2 = getChipProperties(encoderProperties.codecName, initParameters.fps);
            this.chipProperties = chipProperties2;
            if (this.settingBitrateAdjustmentType > 0) {
                chipProperties2.bitrateAdjustmentType = BitrateAdjustmentType.values()[this.settingBitrateAdjustmentType];
            }
            int i2 = this.settingBitrateBaseFPS;
            if (i2 > 0) {
                ChipProperties chipProperties3 = this.chipProperties;
                chipProperties3.baseFrameRate = i2;
                chipProperties3.initFrameRate = i2;
            }
            this.converted_bps = convertBitRate(initParameters.bitrateKbps, initParameters.fps);
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, this.width, this.height);
            if ((this.settingHighProfile > 0 || Build.VERSION.SDK_INT >= this.chipProperties.highProfileMinSdkVersion) && initParameters.profile == 100) {
                Logging.i(TAG, "Set high profile and level");
                if (this.type == VideoCodecType.VIDEO_CODEC_H264) {
                    createVideoFormat.setInteger("profile", 8);
                    createVideoFormat.setInteger("level", WXMediaMessage.TITLE_LENGTH_LIMIT);
                } else if (this.type == VideoCodecType.VIDEO_CODEC_H265) {
                    createVideoFormat.setInteger("profile", 1);
                    createVideoFormat.setInteger("level", 256);
                }
                this.profile = 100;
            } else {
                this.profile = 66;
            }
            createVideoFormat.setInteger("bitrate", this.converted_bps);
            int i3 = this.settingBitrateMode;
            if (i3 > 0) {
                this.bitrateMode = i3;
            } else if (encoderProperties.codecName.startsWith("OMX.rk.") || this.type == VideoCodecType.VIDEO_CODEC_H265) {
                this.bitrateMode = 2;
            } else if (!this.qcomExceptionModel) {
                this.bitrateMode = 1;
            }
            createVideoFormat.setInteger("bitrate-mode", this.bitrateMode);
            createVideoFormat.setInteger("color-format", encoderProperties.colorFormat);
            if (this.chipProperties.bitrateAdjustmentType == BitrateAdjustmentType.NO_ADJUSTMENT) {
                createVideoFormat.setInteger("frame-rate", initParameters.init_fps);
            } else {
                createVideoFormat.setInteger("frame-rate", this.chipProperties.initFrameRate);
            }
            if (Arrays.asList(INTERVAL_HW_EXCEPTION_MODELS).contains(Build.MODEL) && initParameters.keyInterval >= 100) {
                Logging.i(TAG, "keyInterval: " + initParameters.keyInterval);
                Logging.i(TAG, "Model: " + Build.MODEL + " ,need to modify interval.");
                initParameters.keyInterval = 10;
            }
            if (this.chipProperties.bitrateAdjustmentType == BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT) {
                createVideoFormat.setInteger("i-frame-interval", initParameters.keyInterval);
            } else {
                createVideoFormat.setInteger("i-frame-interval", initParameters.keyInterval + 1);
            }
            if (!TextUtils.isEmpty(initParameters.customConfigJson)) {
                applyCustomConfig(createVideoFormat, initParameters.customConfigJson);
            }
            Logging.d(TAG, "Format: " + createVideoFormat);
            MediaCodec createByCodecName = createByCodecName(encoderProperties.codecName);
            this.mediaCodec = createByCodecName;
            if (createByCodecName != null) {
                if (this.useAsyncMode) {
                    MediaCodecEncoderCallback mediaCodecEncoderCallback = new MediaCodecEncoderCallback();
                    this.asyncEncoderCallback = mediaCodecEncoderCallback;
                    this.mediaCodec.setCallback(mediaCodecEncoderCallback, this.dedicatedHandler);
                }
                this.mediaCodec.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                this.codecName = encoderProperties.codecName;
                Logging.i(TAG, "codecName: " + this.codecName);
                this.colorFormat = encoderProperties.colorFormat;
                if (initParameters.useSurface()) {
                    this.memoryType = 11;
                } else {
                    this.memoryType = 0;
                }
                this.bitrateAdjustmentType = this.chipProperties.bitrateAdjustmentType.ordinal();
                return true;
            }
            throw new RuntimeException("Can not create media encoder");
        }
        throw new RuntimeException("Can not find HW encoder for " + this.type);
    }

    private void initEglForEncoderIfNeeded(InitParameters initParameters) {
        if (initParameters.useSurface()) {
            this.eglAttachedOnDedicatedThread = false;
            if (initParameters.sharedEgl14Context != null) {
                this.eglBase = new EglBase14(new EglBase14.Context(initParameters.sharedEgl14Context), EglBase.CONFIG_RECORDABLE);
            } else if (initParameters.sharedEgl10Context != null) {
                this.eglBase = new EglBase10(new EglBase10.Context(initParameters.sharedEgl10Context), EglBase.CONFIG_RECORDABLE);
            }
            if (this.eglBase != null) {
                Surface createInputSurface = this.mediaCodec.createInputSurface();
                this.inputSurface = createInputSurface;
                this.eglBase.createSurface(createInputSurface);
                this.drawer = new GlRectDrawer();
            }
        }
    }

    private void releaseEglForEncoderIfNeeded() {
        if (this.eglBase != null) {
            if (!isOnDedicatedHandlerThread() || !this.eglAttachedOnDedicatedThread) {
                this.eglBase.makeCurrent();
            }
            GlRectDrawer glRectDrawer = this.drawer;
            if (glRectDrawer != null) {
                glRectDrawer.release();
                this.drawer = null;
            }
            this.eglBase.release();
            this.eglBase = null;
        }
        Surface surface = this.inputSurface;
        if (surface != null) {
            surface.release();
            this.inputSurface = null;
        }
        this.eglAttachedOnDedicatedThread = false;
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public ByteBuffer[] getInputBuffers() {
        ByteBuffer[] inputBuffers = this.mediaCodec.getInputBuffers();
        Logging.d(TAG, "Input buffers: " + inputBuffers.length);
        return inputBuffers;
    }

    /* access modifiers changed from: package-private */
    public int getOutputFrameRotation() {
        return this.outputFrameRotation;
    }

    /* access modifiers changed from: package-private */
    public boolean checkKeyFrame(boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.hasPendingKeyFrame) {
            if (elapsedRealtime - this.lastKeyFrameTimeMs > ((long) this.keyFrameEncodeMinInterval)) {
                this.hasPendingKeyFrame = false;
                return true;
            }
        } else if (!z) {
            return z;
        } else {
            long j = this.lastKeyFrameTimeMs;
            if (j == 0 || elapsedRealtime - j > ((long) this.keyFrameEncodeMinInterval)) {
                return z;
            }
            this.hasPendingKeyFrame = true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean encodeBuffer(boolean z, int i, int i2, int i3, long j) {
        if (!this.isInitialized) {
            Logging.e(TAG, "encodeBuffer: encoder is not initialized!");
            return false;
        }
        boolean checkKeyFrame = checkKeyFrame(z);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.lastKeyFrameTimeMs == 0) {
            this.lastKeyFrameTimeMs = elapsedRealtime;
        }
        this.outputFrameRotation = i3;
        if (!checkKeyFrame) {
            try {
                if (this.chipProperties.bitrateAdjustmentType != BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT && elapsedRealtime - this.lastKeyFrameTimeMs >= ((long) this.keyFrameIntervalInMsec)) {
                }
                this.mediaCodec.queueInputBuffer(i, 0, i2, j, 0);
                return true;
            } catch (IllegalStateException e) {
                Logging.e(TAG, "encodeBuffer failed", e);
                return false;
            }
        }
        if (checkKeyFrame) {
            Logging.i(TAG, "Sync frame request");
        }
        Bundle bundle = new Bundle();
        bundle.putInt("request-sync", 0);
        this.mediaCodec.setParameters(bundle);
        this.lastKeyFrameTimeMs = elapsedRealtime;
        this.mediaCodec.queueInputBuffer(i, 0, i2, j, 0);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0063 A[Catch:{ RuntimeException -> 0x0042, all -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069 A[Catch:{ RuntimeException -> 0x0042, all -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007f A[Catch:{ RuntimeException -> 0x0042, all -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0093 A[Catch:{ RuntimeException -> 0x0042, all -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b4 A[Catch:{ RuntimeException -> 0x0042, all -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c2 A[Catch:{ RuntimeException -> 0x0042, all -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00db A[Catch:{ RuntimeException -> 0x0042, all -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f7 A[Catch:{ RuntimeException -> 0x0042, all -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0101 A[Catch:{ RuntimeException -> 0x0042, all -> 0x003f }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean encodeTexture(boolean r22, int r23, int r24, float[] r25, int r26, int r27, int r28, int r29, int r30, boolean r31, long r32, java.lang.Runnable r34) {
        /*
            r21 = this;
            r1 = r21
            r0 = r30
            boolean r2 = r1.isInitialized
            java.lang.String r3 = "MediaCodecVideoEncoder"
            r4 = 0
            if (r2 != 0) goto L_0x0016
            java.lang.String r0 = "encodeTexture: encoder is not initialized!"
            io.agora.rtc.internal.Logging.e(r3, r0)
            if (r34 == 0) goto L_0x0015
            r34.run()
        L_0x0015:
            return r4
        L_0x0016:
            boolean r2 = r21.checkKeyFrame(r22)
            long r5 = android.os.SystemClock.elapsedRealtime()
            long r7 = r1.lastKeyFrameTimeMs
            r9 = 0
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L_0x0028
            r1.lastKeyFrameTimeMs = r5
        L_0x0028:
            r7 = 1
            if (r2 != 0) goto L_0x0045
            io.agora.rtc.video.MediaCodecVideoEncoder$ChipProperties r8 = r1.chipProperties     // Catch:{ RuntimeException -> 0x0042 }
            io.agora.rtc.video.MediaCodecVideoEncoder$BitrateAdjustmentType r8 = r8.bitrateAdjustmentType     // Catch:{ RuntimeException -> 0x0042 }
            io.agora.rtc.video.MediaCodecVideoEncoder$BitrateAdjustmentType r9 = io.agora.rtc.video.MediaCodecVideoEncoder.BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT     // Catch:{ RuntimeException -> 0x0042 }
            if (r8 == r9) goto L_0x005d
            long r8 = r1.lastKeyFrameTimeMs     // Catch:{ RuntimeException -> 0x0042 }
            long r8 = r5 - r8
            int r10 = r1.keyFrameIntervalInMsec     // Catch:{ RuntimeException -> 0x0042 }
            long r10 = (long) r10     // Catch:{ RuntimeException -> 0x0042 }
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 < 0) goto L_0x005d
            goto L_0x0045
        L_0x003f:
            r0 = move-exception
            goto L_0x0118
        L_0x0042:
            r0 = move-exception
            goto L_0x010d
        L_0x0045:
            if (r2 == 0) goto L_0x004c
            java.lang.String r2 = "Sync frame request"
            io.agora.rtc.internal.Logging.i(r3, r2)     // Catch:{ RuntimeException -> 0x0042 }
        L_0x004c:
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ RuntimeException -> 0x0042 }
            r2.<init>()     // Catch:{ RuntimeException -> 0x0042 }
            java.lang.String r8 = "request-sync"
            r2.putInt(r8, r4)     // Catch:{ RuntimeException -> 0x0042 }
            android.media.MediaCodec r8 = r1.mediaCodec     // Catch:{ RuntimeException -> 0x0042 }
            r8.setParameters(r2)     // Catch:{ RuntimeException -> 0x0042 }
            r1.lastKeyFrameTimeMs = r5     // Catch:{ RuntimeException -> 0x0042 }
        L_0x005d:
            boolean r2 = r21.isOnDedicatedHandlerThread()     // Catch:{ RuntimeException -> 0x0042 }
            if (r2 != 0) goto L_0x0069
            io.agora.rtc.gl.EglBase r5 = r1.eglBase     // Catch:{ RuntimeException -> 0x0042 }
            r5.makeCurrent()     // Catch:{ RuntimeException -> 0x0042 }
            goto L_0x0074
        L_0x0069:
            boolean r5 = r1.eglAttachedOnDedicatedThread     // Catch:{ RuntimeException -> 0x0042 }
            if (r5 != 0) goto L_0x0074
            io.agora.rtc.gl.EglBase r5 = r1.eglBase     // Catch:{ RuntimeException -> 0x0042 }
            r5.makeCurrent()     // Catch:{ RuntimeException -> 0x0042 }
            r1.eglAttachedOnDedicatedThread = r7     // Catch:{ RuntimeException -> 0x0042 }
        L_0x0074:
            r5 = 16384(0x4000, float:2.2959E-41)
            android.opengl.GLES20.glClear(r5)     // Catch:{ RuntimeException -> 0x0042 }
            android.graphics.Matrix r5 = io.agora.rtc.gl.RendererCommon.convertMatrixToAndroidGraphicsMatrix(r25)     // Catch:{ RuntimeException -> 0x0042 }
            if (r31 == 0) goto L_0x00b4
            r6 = 90
            if (r0 == r6) goto L_0x008d
            r6 = 270(0x10e, float:3.78E-43)
            if (r0 != r6) goto L_0x0088
            goto L_0x008d
        L_0x0088:
            r6 = r26
            r8 = r27
            goto L_0x0091
        L_0x008d:
            r8 = r26
            r6 = r27
        L_0x0091:
            if (r0 == 0) goto L_0x00b1
            android.graphics.Matrix r9 = r1.rotateMatrix     // Catch:{ RuntimeException -> 0x0042 }
            r9.reset()     // Catch:{ RuntimeException -> 0x0042 }
            android.graphics.Matrix r9 = r1.rotateMatrix     // Catch:{ RuntimeException -> 0x0042 }
            r10 = 1056964608(0x3f000000, float:0.5)
            r9.preTranslate(r10, r10)     // Catch:{ RuntimeException -> 0x0042 }
            android.graphics.Matrix r9 = r1.rotateMatrix     // Catch:{ RuntimeException -> 0x0042 }
            float r10 = (float) r0     // Catch:{ RuntimeException -> 0x0042 }
            r9.preRotate(r10)     // Catch:{ RuntimeException -> 0x0042 }
            android.graphics.Matrix r9 = r1.rotateMatrix     // Catch:{ RuntimeException -> 0x0042 }
            r10 = -1090519040(0xffffffffbf000000, float:-0.5)
            r9.preTranslate(r10, r10)     // Catch:{ RuntimeException -> 0x0042 }
            android.graphics.Matrix r9 = r1.rotateMatrix     // Catch:{ RuntimeException -> 0x0042 }
            r5.preConcat(r9)     // Catch:{ RuntimeException -> 0x0042 }
        L_0x00b1:
            r13 = r6
            r14 = r8
            goto L_0x00b8
        L_0x00b4:
            r13 = r26
            r14 = r27
        L_0x00b8:
            float[] r12 = io.agora.rtc.gl.RendererCommon.convertMatrixFromAndroidGraphicsMatrix(r5)     // Catch:{ RuntimeException -> 0x0042 }
            r5 = 10
            r6 = r24
            if (r6 != r5) goto L_0x00db
            r1.memoryType = r5     // Catch:{ RuntimeException -> 0x0042 }
            io.agora.rtc.gl.GlRectDrawer r10 = r1.drawer     // Catch:{ RuntimeException -> 0x0042 }
            r15 = 0
            r16 = 0
            int r5 = r1.width     // Catch:{ RuntimeException -> 0x0042 }
            int r6 = r1.height     // Catch:{ RuntimeException -> 0x0042 }
            r11 = r23
            r17 = r5
            r18 = r6
            r19 = r28
            r20 = r29
            r10.drawRgb(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ RuntimeException -> 0x0042 }
            goto L_0x00f5
        L_0x00db:
            r5 = 11
            r1.memoryType = r5     // Catch:{ RuntimeException -> 0x0042 }
            io.agora.rtc.gl.GlRectDrawer r10 = r1.drawer     // Catch:{ RuntimeException -> 0x0042 }
            r15 = 0
            r16 = 0
            int r5 = r1.width     // Catch:{ RuntimeException -> 0x0042 }
            int r6 = r1.height     // Catch:{ RuntimeException -> 0x0042 }
            r11 = r23
            r17 = r5
            r18 = r6
            r19 = r28
            r20 = r29
            r10.drawOes(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ RuntimeException -> 0x0042 }
        L_0x00f5:
            if (r31 == 0) goto L_0x00f8
            r0 = r4
        L_0x00f8:
            r1.outputFrameRotation = r0     // Catch:{ RuntimeException -> 0x0042 }
            io.agora.rtc.gl.EglBase r0 = r1.eglBase     // Catch:{ RuntimeException -> 0x0042 }
            r0.swapBuffers()     // Catch:{ RuntimeException -> 0x0042 }
            if (r2 != 0) goto L_0x0106
            io.agora.rtc.gl.EglBase r0 = r1.eglBase     // Catch:{ RuntimeException -> 0x0042 }
            r0.detachCurrent()     // Catch:{ RuntimeException -> 0x0042 }
        L_0x0106:
            if (r34 == 0) goto L_0x010b
            r34.run()
        L_0x010b:
            r4 = r7
            goto L_0x0117
        L_0x010d:
            java.lang.String r2 = "encodeTexture failed"
            io.agora.rtc.internal.Logging.e(r3, r2, r0)     // Catch:{ all -> 0x003f }
            if (r34 == 0) goto L_0x0117
            r34.run()
        L_0x0117:
            return r4
        L_0x0118:
            if (r34 == 0) goto L_0x011d
            r34.run()
        L_0x011d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.MediaCodecVideoEncoder.encodeTexture(boolean, int, int, float[], int, int, int, int, int, boolean, long, java.lang.Runnable):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean encodeTexture(boolean z, int i, int i2, float[] fArr, int i3, int i4, int i5, int i6, int i7, long j) {
        return encodeTexture(z, i, i2, fArr, i3, i4, i5, i6, i7, true, j, (Runnable) null);
    }

    /* access modifiers changed from: package-private */
    public boolean encodeTextureBuffer(VideoFrame.TextureBuffer textureBuffer, boolean z, int i, int i2, int i3, boolean z2, long j) {
        textureBuffer.retain();
        final boolean z3 = z;
        final VideoFrame.TextureBuffer textureBuffer2 = textureBuffer;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final boolean z4 = z2;
        final long j2 = j;
        try {
            return ((Boolean) ThreadUtils.invokeAtFrontUninterruptibly(this.dedicatedHandler, new Callable<Boolean>() {
                public Boolean call() throws Exception {
                    return Boolean.valueOf(MediaCodecVideoEncoder.this.encodeTexture(z3, textureBuffer2.getTextureId(), VideoFrame.getAgoraFormat(textureBuffer2), RendererCommon.convertMatrixFromAndroidGraphicsMatrix(textureBuffer2.getTransformMatrix()), textureBuffer2.getWidth(), textureBuffer2.getHeight(), i4, i5, i6, z4, j2, new Runnable() {
                        public void run() {
                            textureBuffer2.release();
                        }
                    }));
                }
            })).booleanValue();
        } catch (Exception e) {
            Logging.e(TAG, "encode texture buffer exception: " + e);
            textureBuffer.release();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void release() {
        Logging.i(TAG, "Java releaseEncoder");
        AnonymousClass3 r0 = new Runnable() {
            public void run() {
                if (MediaCodecVideoEncoder.this.useAsyncMode) {
                    synchronized (MediaCodecVideoEncoder.this.callbackLock) {
                        MediaCodecVideoEncoder.this.availableInputIndexes.clear();
                        if (MediaCodecVideoEncoder.this.asyncEncoderCallback != null) {
                            MediaCodecVideoEncoder.this.asyncEncoderCallback.stale = true;
                        }
                        MediaCodecVideoEncoder.this.doReleaseEncoder();
                    }
                    return;
                }
                MediaCodecVideoEncoder.this.doReleaseEncoder();
            }
        };
        Handler handler = this.dedicatedHandler;
        if (handler != null) {
            ThreadUtils.invokeAtFrontUninterruptibly(handler, (Runnable) r0);
        } else {
            r0.run();
        }
    }

    /* access modifiers changed from: private */
    public void doReleaseEncoder() {
        if (!this.isInitialized) {
            Logging.e(TAG, "doReleaseEncoder: encoder is not initialized!");
            return;
        }
        boolean z = false;
        this.isInitialized = false;
        releaseEglForEncoderIfNeeded();
        final AnonymousClass1CaughtException r2 = new Object() {
            Exception e;
        };
        final MediaCodec mediaCodec2 = this.mediaCodec;
        if (mediaCodec2 != null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Logging.i(MediaCodecVideoEncoder.TAG, "Java releaseEncoder on release thread");
                    try {
                        Logging.i(MediaCodecVideoEncoder.TAG, "Java releaseEncoder: MediaCodec.stop");
                        mediaCodec2.stop();
                    } catch (Exception e) {
                        Logging.e(MediaCodecVideoEncoder.TAG, "Media encoder stop failed", e);
                    }
                    try {
                        Logging.i(MediaCodecVideoEncoder.TAG, "Java releaseEncoder: MediaCodec.release");
                        mediaCodec2.release();
                    } catch (Exception e2) {
                        Logging.e(MediaCodecVideoEncoder.TAG, "Media encoder release failed", e2);
                        r2.e = e2;
                    }
                    Logging.i(MediaCodecVideoEncoder.TAG, "Java releaseEncoder on release thread done");
                    countDownLatch.countDown();
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
            if (!ThreadUtils.awaitUninterruptibly(countDownLatch, 3000)) {
                Logging.e(TAG, "Media encoder release timeout");
                z = true;
            }
            this.mediaCodec = null;
        }
        if (z) {
            codecErrors++;
            if (errorCallback != null) {
                Logging.e(TAG, "Invoke codec error callback. Errors: " + codecErrors);
                errorCallback.onMediaCodecVideoEncoderCriticalError(codecErrors);
            }
            throw new RuntimeException("Media encoder release timeout.");
        } else if (r2.e == null) {
            Logging.i(TAG, "Java releaseEncoder done");
        } else {
            RuntimeException runtimeException = new RuntimeException(r2.e);
            runtimeException.setStackTrace(ThreadUtils.concatStackTraces(r2.e.getStackTrace(), runtimeException.getStackTrace()));
            throw runtimeException;
        }
    }

    private static boolean checkMinSDKVersion(String str, boolean z) {
        if (z) {
            return Build.VERSION.SDK_INT >= 19;
        }
        if (str.startsWith("OMX.qcom.")) {
            if (Build.VERSION.SDK_INT >= 19) {
                return true;
            }
            return false;
        } else if (str.startsWith("OMX.MTK.")) {
            if (Build.VERSION.SDK_INT >= 21) {
                return true;
            }
            return false;
        } else if (str.startsWith("OMX.Exynos.")) {
            if (Build.VERSION.SDK_INT >= 21) {
                return true;
            }
            return false;
        } else if (str.startsWith("OMX.IMG.TOPAZ.")) {
            if (Build.VERSION.SDK_INT >= 21) {
                return true;
            }
            return false;
        } else if (str.startsWith("OMX.k3.")) {
            if (Build.VERSION.SDK_INT >= 21) {
                return true;
            }
            return false;
        } else if (Build.VERSION.SDK_INT >= 21) {
            return true;
        } else {
            return false;
        }
    }

    private ChipProperties getChipProperties(String str, int i) {
        if (str.startsWith("OMX.qcom.")) {
            if (Arrays.asList(H264_HW_QCOM_EXCEPTION_MODELS).contains(Build.MODEL.toLowerCase())) {
                Logging.w(TAG, "Qcom Exception Model: " + Build.MODEL);
                this.qcomExceptionModel = true;
                return new ChipProperties(str, BitrateAdjustmentType.NO_ADJUSTMENT, true, i, i, 21);
            }
            this.qcomExceptionModel = false;
            return new ChipProperties(str, BitrateAdjustmentType.NO_ADJUSTMENT, false, i, i, 21);
        } else if (str.startsWith("OMX.MTK.")) {
            String str2 = Build.HARDWARE;
            Logging.i(TAG, "MTK hardware: " + str2);
            if (str2.equalsIgnoreCase("mt6763") || str2.equalsIgnoreCase("mt6763t")) {
                return new ChipProperties(str, BitrateAdjustmentType.NO_ADJUSTMENT, false, i, i, 21);
            } else if (Arrays.asList(MTK_NO_ADJUSTMENT_MODELS).contains(Build.MODEL)) {
                return new ChipProperties(str, BitrateAdjustmentType.NO_ADJUSTMENT, false, i, i, 21);
            } else if (str2.equalsIgnoreCase("mt6735") || str2.equalsIgnoreCase("mt8167")) {
                return new ChipProperties(str, BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT, false, i, i, Integer.MAX_VALUE);
            } else {
                return new ChipProperties(str, BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT, false, i, i, 21);
            }
        } else if (str.startsWith("OMX.Exynos.")) {
            if (Build.MODEL.equalsIgnoreCase("MX4 Pro")) {
                return new ChipProperties(str, BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT, false, i, i, Integer.MAX_VALUE);
            } else if (Build.MANUFACTURER.equalsIgnoreCase("vivo") && Build.MODEL.equalsIgnoreCase("V1938CT")) {
                return new ChipProperties(str, BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT, false, i, i, 21);
            } else if (this.settingCodecParameterForExynos <= 0 || Build.VERSION.SDK_INT <= 28) {
                return new ChipProperties(str, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT, false, 30, 30, 21);
            } else {
                return new ChipProperties(str, BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT, false, i, i, 21);
            }
        } else if (str.startsWith("OMX.IMG.TOPAZ.")) {
            if (Build.HARDWARE.equalsIgnoreCase("hi6250")) {
                return new ChipProperties(str, BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT, false, i, i, Integer.MAX_VALUE);
            }
            return new ChipProperties(str, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT, false, 30, 30, Integer.MAX_VALUE);
        } else if (str.startsWith("OMX.hisi.")) {
            return new ChipProperties(str, BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT, false, i, i, Integer.MAX_VALUE);
        } else if (str.startsWith("OMX.k3.")) {
            return new ChipProperties(str, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT, false, 30, 30, 21);
        } else if (str.startsWith("OMX.amlogic.")) {
            Logging.i(TAG, "getChipProperties for amlogic");
            return new ChipProperties(str, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT, false, 30, 30, Integer.MAX_VALUE);
        } else if (str.startsWith("OMX.rk.")) {
            return new ChipProperties(str, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT, false, 30, 30, Integer.MAX_VALUE);
        } else {
            Logging.i(TAG, "getChipProperties from unsupported chip list");
            return new ChipProperties(str, BitrateAdjustmentType.NO_ADJUSTMENT, false, i, i, 23);
        }
    }

    private int convertBitRate(int i, int i2) {
        if (this.chipProperties.bitrateAdjustmentType == BitrateAdjustmentType.FRAMERATE_ADJUSTMENT) {
            i = (i * this.chipProperties.baseFrameRate) / i2;
        }
        int i3 = this.settingBitrateFactor;
        if (i3 <= 0) {
            i3 = (this.chipProperties.chipName.startsWith("OMX.rk.") || this.type == VideoCodecType.VIDEO_CODEC_H265) ? 1000 : this.chipProperties.chipName.startsWith("OMX.qcom.") ? KBPS_TO_BPS_FACTOR_QCOM : KBPS_TO_BPS_FACTOR;
        }
        return i3 * i;
    }

    private int setRates(int i, int i2) {
        if (!this.isInitialized) {
            Logging.e(TAG, "setRates: encoder is not initialized!");
            return -1;
        }
        Logging.d(TAG, "setRates: " + i + " Kbps" + i2 + " fps");
        boolean z = i2 > 0 && i2 != this.lastSetFps;
        if (i2 <= 0) {
            i2 = this.lastSetFps;
        }
        this.lastSetFps = i2;
        int convertBitRate = convertBitRate(i, i2);
        if (z) {
            try {
                if (this.settingAdjustmentReset > 0 || this.chipProperties.bitrateAdjustmentType == BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT) {
                    this.converted_bps = convertBitRate;
                    return 0;
                }
            } catch (IllegalStateException e) {
                Logging.e(TAG, "setRates failed", e);
                return 0;
            }
        }
        String str = "[async] ";
        if (convertBitRate > this.converted_bps) {
            this.converted_bps = convertBitRate;
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", this.converted_bps);
            this.mediaCodec.setParameters(bundle);
            StringBuilder sb = new StringBuilder();
            if (!this.useAsyncMode) {
                str = "";
            }
            sb.append(str);
            sb.append("setRates up to : ");
            sb.append(this.converted_bps);
            sb.append(" bps(converted) ");
            sb.append(this.lastSetFps);
            sb.append(" fps");
            Logging.i(TAG, sb.toString());
            return 1;
        }
        int i3 = 25000;
        if (!this.chipProperties.chipName.startsWith("OMX.qcom.")) {
            i3 = 0;
        } else if (!this.qcomExceptionModel) {
            if (this.converted_bps <= 200000) {
                i3 = 15000;
            }
        }
        if (convertBitRate < this.converted_bps - i3) {
            this.converted_bps = convertBitRate;
            if (this.chipProperties.isNeedResetWhenDownBps) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - this.lastResetForQcomTimeMs < 2000) {
                    return 2;
                }
                this.lastResetForQcomTimeMs = elapsedRealtime;
                return 0;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("video-bitrate", this.converted_bps);
            this.mediaCodec.setParameters(bundle2);
            StringBuilder sb2 = new StringBuilder();
            if (!this.useAsyncMode) {
                str = "";
            }
            sb2.append(str);
            sb2.append("setRates down to : ");
            sb2.append(this.converted_bps);
            sb2.append(" bps(converted) ");
            sb2.append(this.lastSetFps);
            sb2.append(" fps");
            Logging.i(TAG, sb2.toString());
        }
        return 1;
    }

    static class InputBufferInfo {
        public final ByteBuffer buffer;
        public final int index;

        public InputBufferInfo(int i, ByteBuffer byteBuffer) {
            this.index = i;
            this.buffer = byteBuffer;
        }
    }

    /* access modifiers changed from: package-private */
    public InputBufferInfo dequeueInputBufferAvailable() {
        InputBufferInfo inputBufferInfo;
        synchronized (this.callbackLock) {
            Iterator it = this.availableInputIndexes.iterator();
            if (!it.hasNext()) {
                Logging.e(TAG, "no input buffer available");
                inputBufferInfo = new InputBufferInfo(-1, (ByteBuffer) null);
            } else {
                try {
                    int intValue = ((Integer) it.next()).intValue();
                    it.remove();
                    inputBufferInfo = new InputBufferInfo(intValue, this.mediaCodec.getInputBuffer(intValue));
                } catch (IllegalStateException e) {
                    Logging.e(TAG, "codec exception: " + e.getMessage());
                    inputBufferInfo = new InputBufferInfo(-2, (ByteBuffer) null);
                }
            }
        }
        return inputBufferInfo;
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public int dequeueInputBuffer() {
        try {
            return this.mediaCodec.dequeueInputBuffer(0);
        } catch (IllegalStateException e) {
            Logging.e(TAG, "dequeueIntputBuffer failed", e);
            return -2;
        }
    }

    static class OutputBufferInfo {
        public final ByteBuffer buffer;
        public final int index;
        public final boolean isKeyFrame;
        public final long presentationTimestampUs;
        public final int size;

        public OutputBufferInfo(int i, ByteBuffer byteBuffer, boolean z, long j, int i2) {
            this.index = i;
            this.buffer = byteBuffer;
            this.isKeyFrame = z;
            this.presentationTimestampUs = j;
            this.size = i2;
        }
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public OutputBufferInfo dequeueOutputBuffer() {
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0);
            if (dequeueOutputBuffer >= 0) {
                if ((bufferInfo.flags & 2) != 0) {
                    Logging.d(TAG, "Config frame generated. Offset: " + bufferInfo.offset + ". Size: " + bufferInfo.size);
                    this.configData = ByteBuffer.allocateDirect(bufferInfo.size);
                    this.outputBuffers[dequeueOutputBuffer].position(bufferInfo.offset);
                    this.outputBuffers[dequeueOutputBuffer].limit(bufferInfo.offset + bufferInfo.size);
                    this.configData.put(this.outputBuffers[dequeueOutputBuffer]);
                    this.mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0);
                }
            }
            if (dequeueOutputBuffer >= 0) {
                return createOutputBufferInfo(bufferInfo, dequeueOutputBuffer, this.outputBuffers[dequeueOutputBuffer].duplicate());
            }
            if (dequeueOutputBuffer == -3) {
                this.outputBuffers = this.mediaCodec.getOutputBuffers();
                return dequeueOutputBuffer();
            } else if (dequeueOutputBuffer == -2) {
                return dequeueOutputBuffer();
            } else {
                if (dequeueOutputBuffer == -1) {
                    return null;
                }
                throw new RuntimeException("dequeueOutputBuffer: " + dequeueOutputBuffer);
            }
        } catch (IllegalStateException e) {
            Logging.e(TAG, "dequeueOutputBuffer failed", e);
            return new OutputBufferInfo(-1, (ByteBuffer) null, false, -1, 0);
        }
    }

    /* access modifiers changed from: private */
    public OutputBufferInfo createOutputBufferInfo(MediaCodec.BufferInfo bufferInfo, int i, ByteBuffer byteBuffer) {
        byteBuffer.position(bufferInfo.offset);
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        boolean z = (bufferInfo.flags & 1) != 0;
        if (z) {
            Logging.d(TAG, "Sync frame generated");
        }
        if (!z || !(this.type == VideoCodecType.VIDEO_CODEC_H264 || this.type == VideoCodecType.VIDEO_CODEC_H265)) {
            return new OutputBufferInfo(i, byteBuffer.slice(), z, bufferInfo.presentationTimeUs, bufferInfo.size);
        }
        Logging.d(TAG, "Appending config frame of size " + this.configData.capacity() + " to output buffer with offset " + bufferInfo.offset + ", size " + bufferInfo.size);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.configData.capacity() + bufferInfo.size);
        this.configData.rewind();
        allocateDirect.put(this.configData);
        allocateDirect.put(byteBuffer);
        allocateDirect.position(0);
        return new OutputBufferInfo(i, allocateDirect, z, bufferInfo.presentationTimeUs, bufferInfo.size + this.configData.capacity());
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public boolean releaseOutputBuffer(int i) {
        try {
            this.mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } catch (IllegalStateException e) {
            Logging.e(TAG, "releaseOutputBuffer failed", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void dumpIntoFile(OutputBufferInfo outputBufferInfo, VideoCodecType videoCodecType) {
        String format;
        if (this.fos == null) {
            try {
                if (videoCodecType == VideoCodecType.VIDEO_CODEC_H264) {
                    format = String.format("/sdcard/java_dump_video_%d_%d.h264", new Object[]{Integer.valueOf(this.width), Integer.valueOf(this.height)});
                } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_H265) {
                    format = String.format("/sdcard/java_dump_video_%d_%d.h265", new Object[]{Integer.valueOf(this.width), Integer.valueOf(this.height)});
                } else {
                    format = String.format("/sdcard/java_dump_video_%d_%d.raw", new Object[]{Integer.valueOf(this.width), Integer.valueOf(this.height)});
                }
                this.fos = new FileOutputStream(format, true);
            } catch (Exception unused) {
                Logging.i(TAG, "dumpIntoFile: failed to open " + null);
                return;
            }
        }
        if (outputBufferInfo != null && outputBufferInfo.index >= 0) {
            Logging.i(TAG, "Dump nal: " + outputBufferInfo.buffer);
            try {
                byte[] bArr = new byte[outputBufferInfo.buffer.remaining()];
                outputBufferInfo.buffer.get(bArr);
                this.fos.write(bArr, 0, outputBufferInfo.size);
            } catch (Exception e) {
                Logging.e(TAG, "Run: 4.1 Exception ", e);
            }
        }
    }

    private class MediaCodecEncoderCallback extends MediaCodec.Callback {
        boolean stale;

        private MediaCodecEncoderCallback() {
            this.stale = false;
        }

        public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
            synchronized (MediaCodecVideoEncoder.this.callbackLock) {
                if (this.stale) {
                    Logging.w(MediaCodecVideoEncoder.TAG, "discard stale available input buffer");
                } else {
                    MediaCodecVideoEncoder.this.availableInputIndexes.add(Integer.valueOf(i));
                }
            }
        }

        public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
            synchronized (MediaCodecVideoEncoder.this.callbackLock) {
                if (this.stale) {
                    Logging.w(MediaCodecVideoEncoder.TAG, "discard stale available output buffer");
                    return;
                }
                try {
                    ByteBuffer outputBuffer = MediaCodecVideoEncoder.this.mediaCodec.getOutputBuffer(i);
                    if (outputBuffer == null) {
                        Logging.e(MediaCodecVideoEncoder.TAG, "failed to get output buffer, index: " + i);
                        return;
                    }
                    try {
                        if ((bufferInfo.flags & 2) != 0) {
                            Logging.d(MediaCodecVideoEncoder.TAG, "[async] Config frame generated. Offset: " + bufferInfo.offset + ". Size: " + bufferInfo.size);
                            ByteBuffer unused = MediaCodecVideoEncoder.this.configData = ByteBuffer.allocateDirect(bufferInfo.size);
                            MediaCodecVideoEncoder.this.configData.put(outputBuffer);
                        } else {
                            OutputBufferInfo access$900 = MediaCodecVideoEncoder.this.createOutputBufferInfo(bufferInfo, i, outputBuffer);
                            MediaCodecVideoEncoder mediaCodecVideoEncoder = MediaCodecVideoEncoder.this;
                            mediaCodecVideoEncoder.onAsyncEncodeFrameResult(mediaCodecVideoEncoder.nativeHandle, true, access$900);
                        }
                    } catch (Exception e) {
                        Logging.e(MediaCodecVideoEncoder.TAG, "handle output buffer error", e);
                    }
                    MediaCodecVideoEncoder.this.mediaCodec.releaseOutputBuffer(i, false);
                } catch (IllegalStateException e2) {
                    Logging.e(MediaCodecVideoEncoder.TAG, "getOutputBuffer exception, index: " + i, e2);
                }
            }
        }

        public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            Logging.e(MediaCodecVideoEncoder.TAG, "onError " + codecException);
        }

        public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            Logging.w(MediaCodecVideoEncoder.TAG, "onOutputFormatChanged " + mediaFormat);
        }
    }

    public static boolean isQcomHWEncoder() {
        String str = codecOmxName;
        if (str == null || str.startsWith("OMX.qcom.")) {
            Logging.i(TAG, "Qualcomm HW encoder true");
            return true;
        }
        Logging.i(TAG, "Qualcomm HW encoder false");
        return false;
    }

    public static int getHWEncoderManufactor() {
        if (codecOmxName.startsWith("OMX.qcom.")) {
            return 0;
        }
        if (codecOmxName.startsWith("OMX.MTK.")) {
            return 1;
        }
        if (codecOmxName.startsWith("OMX.Exynos.")) {
            return 2;
        }
        if (codecOmxName.startsWith("OMX.IMG.TOPAZ.")) {
            return 3;
        }
        if (codecOmxName.startsWith("OMX.k3.")) {
            return 4;
        }
        if (codecOmxName.startsWith("OMX.hisi.")) {
            return 5;
        }
        if (codecOmxName.startsWith("OMX.amlogic.")) {
            return 6;
        }
        return codecOmxName.startsWith("OMX.rk.") ? 7 : -1;
    }
}
