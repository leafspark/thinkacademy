package com.wushuangtech.myvideoimprove;

import android.graphics.SurfaceTexture;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;
import com.wushuangtech.library.GlobalVideoConfig;
import com.wushuangtech.library.video.bean.VideoFrame;
import com.wushuangtech.library.video.egl.EGLHelper14;
import com.wushuangtech.library.video.opengles.input.CameraPreviewInput;
import com.wushuangtech.library.video.opengles.input.GLTextureOutputRenderer;
import com.wushuangtech.library.video.opengles.output.HandleDataOutput;
import com.wushuangtech.library.video.opengles.output.ScreenEndpoint;
import com.wushuangtech.myvideoimprove.bean.CodecHardwareDecoderConfigureBean;
import com.wushuangtech.myvideoimprove.codec.decoder.HardwareDecoder;
import com.wushuangtech.utils.MyGLUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

public class VideoFileSourceModel implements Runnable, GLTextureOutputRenderer.OnFrameAvailableListener {
    private static final String TAG = "VideoFileSource";
    private ByteBuffer buffer = ByteBuffer.allocate(1048576);
    private CameraPreviewInput mCameraPreviewInput;
    private boolean mDecoderStarted;
    private Thread mDecodingFileThread;
    private boolean mDisplayChanged;
    private EGLSurface mDisplayEGLSurface;
    private SurfaceTexture mDisplaySurfaceTexture;
    private EGLHelper14 mEGLHelper14;
    private boolean mEGLInited;
    private EGLSurface mEGLSurface;
    private int mEncHeight;
    private int mEncWidth;
    private boolean mFileOpened;
    private ByteBuffer mGLByteBuffer;
    private ConcurrentLinkedQueue<VideoFrame> mGLByteBufferCache;
    private HandleDataOutput mHandleDataOutput;
    private HardwareDecoder mHardwareDecoder;
    private final Object mLock = new Object();
    private MediaExtractor mMediaExtractor;
    private OnVideoFileEventCallBack mOnVideoFileEventCallBack;
    private ScreenEndpoint mScreenEndpoint;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private final float[] mTmpMatrix = new float[16];
    private int mVideoRawHeight;
    private int mVideoRawWidth;
    private int[] mViewSize;

    public interface OnVideoFileEventCallBack {
        void onVideoFilePlayCompleted();
    }

    public EGLContext getEGLContext14() {
        EGLHelper14 eGLHelper14 = this.mEGLHelper14;
        if (eGLHelper14 != null) {
            return eGLHelper14.getEGLContext();
        }
        return null;
    }

    public int getTextureId() {
        HandleDataOutput handleDataOutput = this.mHandleDataOutput;
        if (handleDataOutput != null) {
            return handleDataOutput.getFrameBufferTextureId();
        }
        return 0;
    }

    public int[] getVideoRawSize() {
        return new int[]{this.mVideoRawWidth, this.mVideoRawHeight};
    }

    public VideoFrame getVideoRawBuffer() {
        ConcurrentLinkedQueue<VideoFrame> concurrentLinkedQueue = this.mGLByteBufferCache;
        if (concurrentLinkedQueue != null) {
            return concurrentLinkedQueue.poll();
        }
        return null;
    }

    public float[] getMatrix() {
        return this.mTmpMatrix;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public int openVideoFile(android.graphics.SurfaceTexture r9, int[] r10, java.lang.String r11, com.wushuangtech.myvideoimprove.VideoFileSourceModel.OnVideoFileEventCallBack r12) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.mLock
            monitor-enter(r0)
            boolean r1 = r8.mFileOpened     // Catch:{ all -> 0x00b3 }
            r2 = 0
            if (r1 == 0) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x00b3 }
            return r2
        L_0x000a:
            monitor-exit(r0)     // Catch:{ all -> 0x00b3 }
            r8.mOnVideoFileEventCallBack = r12
            android.media.MediaExtractor r12 = new android.media.MediaExtractor
            r12.<init>()
            android.media.MediaFormat r11 = r8.getVideoFormatFromVideoFile(r12, r11)
            if (r11 != 0) goto L_0x001d
            r12.release()
            r9 = -1
            return r9
        L_0x001d:
            java.lang.String r0 = "width"
            int r0 = r11.getInteger(r0)
            java.lang.String r1 = "height"
            int r1 = r11.getInteger(r1)
            java.lang.String r3 = "frame-rate"
            int r3 = r11.getInteger(r3)     // Catch:{ Exception -> 0x0030 }
            goto L_0x0031
        L_0x0030:
            r3 = r2
        L_0x0031:
            java.lang.String r4 = "bitrate"
            int r4 = r11.getInteger(r4)     // Catch:{ Exception -> 0x0038 }
            goto L_0x0039
        L_0x0038:
            r4 = r2
        L_0x0039:
            java.lang.String r5 = "VideoFileSource"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Video file info : "
            r6.append(r7)
            r6.append(r0)
            java.lang.String r7 = " * "
            r6.append(r7)
            r6.append(r1)
            java.lang.String r7 = " | frameRate : "
            r6.append(r7)
            r6.append(r3)
            java.lang.String r3 = " | bitrate : "
            r6.append(r3)
            r6.append(r4)
            java.lang.String r3 = r6.toString()
            android.util.Log.d(r5, r3)
            com.wushuangtech.myvideoimprove.codec.decoder.HardwareDecoder r3 = new com.wushuangtech.myvideoimprove.codec.decoder.HardwareDecoder
            java.lang.String r4 = "HardwareDecoder"
            r3.<init>(r4)
            r3.setExternalMediaFormat(r11)
            java.lang.Object r11 = r8.mLock
            monitor-enter(r11)
            java.util.concurrent.ConcurrentLinkedQueue r4 = new java.util.concurrent.ConcurrentLinkedQueue     // Catch:{ all -> 0x00b0 }
            r4.<init>()     // Catch:{ all -> 0x00b0 }
            r8.mGLByteBufferCache = r4     // Catch:{ all -> 0x00b0 }
            int r4 = r0 * r1
            int r4 = r4 * 4
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.allocate(r4)     // Catch:{ all -> 0x00b0 }
            r8.mGLByteBuffer = r4     // Catch:{ all -> 0x00b0 }
            r8.mDisplaySurfaceTexture = r9     // Catch:{ all -> 0x00b0 }
            r8.mHardwareDecoder = r3     // Catch:{ all -> 0x00b0 }
            r8.mMediaExtractor = r12     // Catch:{ all -> 0x00b0 }
            r8.mVideoRawWidth = r0     // Catch:{ all -> 0x00b0 }
            r8.mVideoRawHeight = r1     // Catch:{ all -> 0x00b0 }
            r8.mEncWidth = r0     // Catch:{ all -> 0x00b0 }
            r8.mEncHeight = r1     // Catch:{ all -> 0x00b0 }
            r9 = 1
            r8.mFileOpened = r9     // Catch:{ all -> 0x00b0 }
            r8.mViewSize = r10     // Catch:{ all -> 0x00b0 }
            r8.mDisplayChanged = r9     // Catch:{ all -> 0x00b0 }
            java.lang.Thread r9 = new java.lang.Thread     // Catch:{ all -> 0x00b0 }
            r9.<init>(r8)     // Catch:{ all -> 0x00b0 }
            r8.mDecodingFileThread = r9     // Catch:{ all -> 0x00b0 }
            boolean r10 = r9 instanceof java.lang.Thread     // Catch:{ all -> 0x00b0 }
            if (r10 != 0) goto L_0x00a9
            r9.start()     // Catch:{ all -> 0x00b0 }
            goto L_0x00ae
        L_0x00a9:
            java.lang.Thread r9 = (java.lang.Thread) r9     // Catch:{ all -> 0x00b0 }
            com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation.threadStart(r9)     // Catch:{ all -> 0x00b0 }
        L_0x00ae:
            monitor-exit(r11)     // Catch:{ all -> 0x00b0 }
            return r2
        L_0x00b0:
            r9 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x00b0 }
            throw r9
        L_0x00b3:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b3 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.VideoFileSourceModel.openVideoFile(android.graphics.SurfaceTexture, int[], java.lang.String, com.wushuangtech.myvideoimprove.VideoFileSourceModel$OnVideoFileEventCallBack):int");
    }

    public void closeVideoFile() {
        synchronized (this.mLock) {
            Log.d(TAG, "Start close video file....");
            this.mFileOpened = false;
        }
        Thread thread = this.mDecodingFileThread;
        if (thread != null) {
            thread.interrupt();
            try {
                this.mDecodingFileThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.mDecodingFileThread = null;
        }
        Log.d(TAG, "Close render thread...");
        synchronized (this.mLock) {
            MediaExtractor mediaExtractor = this.mMediaExtractor;
            if (mediaExtractor != null) {
                mediaExtractor.release();
                this.mMediaExtractor = null;
            }
            ConcurrentLinkedQueue<VideoFrame> concurrentLinkedQueue = this.mGLByteBufferCache;
            if (concurrentLinkedQueue != null) {
                concurrentLinkedQueue.clear();
                this.mGLByteBufferCache = null;
            }
            this.mGLByteBuffer = null;
            this.mDisplaySurfaceTexture = null;
        }
    }

    private void destoryOpenGLResource() {
        Log.d(TAG, "Destory opengl resource...");
        EGLHelper14 eGLHelper14 = this.mEGLHelper14;
        if (eGLHelper14 != null) {
            eGLHelper14.makeCurrent(this.mEGLSurface);
            CameraPreviewInput cameraPreviewInput = this.mCameraPreviewInput;
            if (cameraPreviewInput != null) {
                cameraPreviewInput.destroy();
                this.mCameraPreviewInput = null;
            }
            HandleDataOutput handleDataOutput = this.mHandleDataOutput;
            if (handleDataOutput != null) {
                handleDataOutput.destroy();
                this.mHandleDataOutput = null;
            }
            ScreenEndpoint screenEndpoint = this.mScreenEndpoint;
            if (screenEndpoint != null) {
                screenEndpoint.destroy();
                this.mScreenEndpoint = null;
            }
            this.mEGLHelper14.destorySurface(this.mEGLSurface);
            this.mEGLHelper14.destorySurface(this.mDisplayEGLSurface);
            this.mEGLHelper14.destory();
            this.mEGLHelper14 = null;
        }
        HardwareDecoder hardwareDecoder = this.mHardwareDecoder;
        if (hardwareDecoder != null) {
            hardwareDecoder.release();
            this.mHardwareDecoder = null;
        }
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.mSurfaceTexture = null;
        }
        Surface surface = this.mSurface;
        if (surface != null) {
            surface.release();
            this.mSurface = null;
        }
    }

    public void run() {
        while (renderFrame()) {
            try {
                Thread.sleep(33);
            } catch (InterruptedException unused) {
                destoryOpenGLResource();
                return;
            }
        }
        destoryOpenGLResource();
        this.mOnVideoFileEventCallBack.onVideoFilePlayCompleted();
    }

    private MediaFormat getVideoFormatFromVideoFile(MediaExtractor mediaExtractor, String str) {
        try {
            mediaExtractor.setDataSource(new FileInputStream(new File(str)).getFD());
            int trackCount = mediaExtractor.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                String string = trackFormat.getString("mime");
                if (string != null) {
                    if (!string.equals("video/mp4v-es") && !string.equals("video/avc")) {
                        if (string.equals("video/hevc") || string.equals("video/av01")) {
                        }
                    }
                    mediaExtractor.selectTrack(i);
                    return trackFormat;
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0037, code lost:
        if (r4 == false) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0039, code lost:
        closeVideoFile();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        if (r8 == null) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003f, code lost:
        if (r6 == null) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0041, code lost:
        if (r9 == null) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0043, code lost:
        if (r10 == null) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0045, code lost:
        if (r7 == null) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0047, code lost:
        if (r11 != null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0050, code lost:
        if (r3.readSampleData(r12.buffer, 0) >= 0) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0052, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0053, code lost:
        r0 = new com.wushuangtech.library.video.bean.VideoFrame();
        r0.data = r12.buffer.array();
        r0.width = r12.mVideoRawWidth;
        r0.height = r12.mVideoRawHeight;
        r0.timeStamp = r3.getSampleTime();
        r1.decodingFrame(r0);
        r6.makeCurrent(r7);
        r9.onDrawFrame();
        r6.swapBuffers(r7);
        r6.makeCurrent(r8);
        r10.setTextureId(r11.getFrameBufferTextureId());
        r10.onDrawFrame();
        r6.swapBuffers(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008e, code lost:
        return r3.advance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008f, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean renderFrame() {
        /*
            r12 = this;
            java.lang.Object r0 = r12.mLock
            monitor-enter(r0)
            boolean r1 = r12.mFileOpened     // Catch:{ all -> 0x0090 }
            r2 = 0
            if (r1 != 0) goto L_0x000a
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            return r2
        L_0x000a:
            com.wushuangtech.myvideoimprove.codec.decoder.HardwareDecoder r1 = r12.mHardwareDecoder     // Catch:{ all -> 0x0090 }
            android.media.MediaExtractor r3 = r12.mMediaExtractor     // Catch:{ all -> 0x0090 }
            boolean r4 = r12.mEGLInited     // Catch:{ all -> 0x0090 }
            r5 = 1
            if (r4 != 0) goto L_0x001b
            boolean r4 = r12.initEGL()     // Catch:{ all -> 0x0090 }
            if (r4 != 0) goto L_0x001b
            r4 = r5
            goto L_0x001c
        L_0x001b:
            r4 = r2
        L_0x001c:
            if (r4 != 0) goto L_0x0024
            r12.tryCreateDisplayEGLSurface()     // Catch:{ all -> 0x0090 }
            r12.tryStartDecoder()     // Catch:{ all -> 0x0090 }
        L_0x0024:
            boolean r6 = r12.mDecoderStarted     // Catch:{ all -> 0x0090 }
            if (r6 != 0) goto L_0x002a
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            return r5
        L_0x002a:
            com.wushuangtech.library.video.egl.EGLHelper14 r6 = r12.mEGLHelper14     // Catch:{ all -> 0x0090 }
            android.opengl.EGLSurface r7 = r12.mEGLSurface     // Catch:{ all -> 0x0090 }
            android.opengl.EGLSurface r8 = r12.mDisplayEGLSurface     // Catch:{ all -> 0x0090 }
            com.wushuangtech.library.video.opengles.input.CameraPreviewInput r9 = r12.mCameraPreviewInput     // Catch:{ all -> 0x0090 }
            com.wushuangtech.library.video.opengles.output.ScreenEndpoint r10 = r12.mScreenEndpoint     // Catch:{ all -> 0x0090 }
            com.wushuangtech.library.video.opengles.output.HandleDataOutput r11 = r12.mHandleDataOutput     // Catch:{ all -> 0x0090 }
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            if (r4 == 0) goto L_0x003d
            r12.closeVideoFile()
            return r2
        L_0x003d:
            if (r8 == 0) goto L_0x008f
            if (r6 == 0) goto L_0x008f
            if (r9 == 0) goto L_0x008f
            if (r10 == 0) goto L_0x008f
            if (r7 == 0) goto L_0x008f
            if (r11 != 0) goto L_0x004a
            goto L_0x008f
        L_0x004a:
            java.nio.ByteBuffer r0 = r12.buffer
            int r0 = r3.readSampleData(r0, r2)
            if (r0 >= 0) goto L_0x0053
            return r2
        L_0x0053:
            com.wushuangtech.library.video.bean.VideoFrame r0 = new com.wushuangtech.library.video.bean.VideoFrame
            r0.<init>()
            java.nio.ByteBuffer r2 = r12.buffer
            byte[] r2 = r2.array()
            r0.data = r2
            int r2 = r12.mVideoRawWidth
            r0.width = r2
            int r2 = r12.mVideoRawHeight
            r0.height = r2
            long r4 = r3.getSampleTime()
            r0.timeStamp = r4
            r1.decodingFrame(r0)
            r6.makeCurrent(r7)
            r9.onDrawFrame()
            r6.swapBuffers(r7)
            r6.makeCurrent(r8)
            int r0 = r11.getFrameBufferTextureId()
            r10.setTextureId(r0)
            r10.onDrawFrame()
            r6.swapBuffers(r8)
            boolean r0 = r3.advance()
            return r0
        L_0x008f:
            return r5
        L_0x0090:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.VideoFileSourceModel.renderFrame():boolean");
    }

    private boolean initEGL() {
        EGLHelper14 eGLHelper14 = new EGLHelper14();
        if (!eGLHelper14.eglInit()) {
            return false;
        }
        EGLSurface createOffscreenSurface = eGLHelper14.createOffscreenSurface(GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_WIDTH, GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_HEIGHT);
        this.mEGLSurface = createOffscreenSurface;
        if (createOffscreenSurface == null || !eGLHelper14.makeCurrent(createOffscreenSurface)) {
            return false;
        }
        this.mEGLHelper14 = eGLHelper14;
        initOpenGLRenderer();
        this.mEGLInited = true;
        return true;
    }

    private void initOpenGLRenderer() {
        this.mCameraPreviewInput = new CameraPreviewInput();
        this.mHandleDataOutput = new HandleDataOutput();
        this.mScreenEndpoint = new ScreenEndpoint();
        this.mCameraPreviewInput.addTarget(this.mHandleDataOutput);
        this.mHandleDataOutput.setOnFrameAvailableListener(this);
        int createWhiteOESTextureId = MyGLUtils.createWhiteOESTextureId();
        SurfaceTexture surfaceTexture = new SurfaceTexture(createWhiteOESTextureId);
        surfaceTexture.setDefaultBufferSize(this.mEncWidth, this.mEncHeight);
        this.mSurface = new Surface(surfaceTexture);
        this.mCameraPreviewInput.setSurfaceTexture(surfaceTexture);
        this.mCameraPreviewInput.setTextureId(createWhiteOESTextureId);
        this.mCameraPreviewInput.setRenderSize(this.mEncWidth, this.mEncHeight);
        this.mHandleDataOutput.setRenderSize(this.mEncWidth, this.mEncHeight);
        ScreenEndpoint screenEndpoint = this.mScreenEndpoint;
        int[] iArr = this.mViewSize;
        screenEndpoint.setViewSize(iArr[0], iArr[1]);
        this.mScreenEndpoint.setEncodeSize(this.mEncWidth, this.mEncHeight);
        this.mScreenEndpoint.setPreView(true);
        this.mScreenEndpoint.setRenderMode(2);
        this.mScreenEndpoint.setRenderMirror(true, false);
    }

    private void tryCreateDisplayEGLSurface() {
        SurfaceTexture surfaceTexture = this.mDisplaySurfaceTexture;
        EGLSurface eGLSurface = this.mDisplayEGLSurface;
        EGLHelper14 eGLHelper14 = this.mEGLHelper14;
        if (eGLHelper14 != null && this.mDisplayChanged) {
            if (eGLSurface != null) {
                eGLHelper14.destorySurface(eGLSurface);
                this.mDisplayEGLSurface = null;
            }
            EGLSurface createWindowSurface = eGLHelper14.createWindowSurface(surfaceTexture);
            if (createWindowSurface != null) {
                this.mDisplayEGLSurface = createWindowSurface;
                this.mDisplayChanged = false;
            }
        }
    }

    private void tryStartDecoder() {
        HardwareDecoder hardwareDecoder = this.mHardwareDecoder;
        Surface surface = this.mSurface;
        int i = this.mEncWidth;
        int i2 = this.mEncHeight;
        if (hardwareDecoder != null && surface != null && !this.mDecoderStarted) {
            hardwareDecoder.setSurface(surface);
            CodecHardwareDecoderConfigureBean codecHardwareDecoderConfigureBean = new CodecHardwareDecoderConfigureBean();
            codecHardwareDecoderConfigureBean.width = i;
            codecHardwareDecoderConfigureBean.height = i2;
            if (hardwareDecoder.open(codecHardwareDecoderConfigureBean)) {
                this.mDecoderStarted = true;
            } else {
                hardwareDecoder.release();
            }
        }
    }

    public void onFrameAvailable(int i, int i2) {
        ByteBuffer byteBuffer = this.mGLByteBuffer;
        ConcurrentLinkedQueue<VideoFrame> concurrentLinkedQueue = this.mGLByteBufferCache;
        if (this.mFileOpened && byteBuffer != null && concurrentLinkedQueue != null) {
            byteBuffer.clear();
            System.currentTimeMillis();
            GLES20.glReadPixels(0, 0, this.mEncWidth, this.mEncHeight, 6408, 5121, byteBuffer);
            byte[] array = byteBuffer.array();
            byte[] bArr = new byte[byteBuffer.limit()];
            System.arraycopy(array, byteBuffer.arrayOffset(), bArr, 0, byteBuffer.limit());
            if (concurrentLinkedQueue.size() >= 30) {
                concurrentLinkedQueue.poll();
            }
            VideoFrame videoFrame = new VideoFrame();
            videoFrame.data = bArr;
            videoFrame.width = this.mEncWidth;
            videoFrame.height = this.mEncHeight;
            videoFrame.timeStamp = System.currentTimeMillis();
            concurrentLinkedQueue.add(videoFrame);
        }
    }
}
