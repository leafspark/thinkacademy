package com.wushuangtech.myvideoimprove.render;

import android.graphics.SurfaceTexture;
import com.wushuangtech.bean.FastLogCacheBean;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.video.VideoStatus;
import com.wushuangtech.library.video.bean.MediaCodecSurface;
import com.wushuangtech.library.video.opengles.GLRenderer;
import com.wushuangtech.library.video.opengles.WaterMarkController;
import com.wushuangtech.library.video.opengles.input.CameraPreviewInput;
import com.wushuangtech.library.video.opengles.output.HandleDataOutput;
import com.wushuangtech.library.video.opengles.output.ScreenEndpoint;
import com.wushuangtech.library.video.opengles.output.VideoEncodeEndpoint;
import com.wushuangtech.myvideoimprove.bean.LocalOpenGLRendererBean;
import com.wushuangtech.myvideoimprove.capture.VideoCapFrame;
import com.wushuangtech.myvideoimprove.render.imageprocessing.FastImageProcessingPipeline;
import com.wushuangtech.myvideoimprove.render.imageprocessing.OpenGLPixelReader;
import com.wushuangtech.utils.DeviceUtils;
import com.wushuangtech.utils.OmniLog;

class LocalOpenGLRenderer implements GLRenderer.OnGLRendererCallBack, WaterMarkController.OnWaterMarkStatusChangedListener {
    private static final String TAG = "LocalOpenGLRenderer";
    private float mBeautifyBrightLevel = 0.5f;
    private boolean mBeautifyEnabled = true;
    private float mBeautifyLevel = 0.5f;
    private int mCameraId = 1;
    private int mCameraRotate = 90;
    private VideoEncodeEndpoint mDualVideoEncodeEndpoint;
    private final FastLogCacheBean mFastLogCacheBean = new FastLogCacheBean("LocalOpenGLRenderer::renderingDisplay::frameBufferTextureId=0", TAG, OmniLog.VIDEO_RENDER_WATCH, 2);
    private HandleDataOutput mHandleDataOutput;
    private final Object mLock = new Object();
    private OpenGLPixelReader mOpenGLPixelReader;
    private OpenGLRendererCallBack mOpenGLRendererCallBack;
    private FastImageProcessingPipeline mPipeline;
    private boolean mPreview = GlobalConfig.mLocalVideoPreview;
    private CameraPreviewInput mPreviewInput;
    private int mRenderMode = 1;
    private boolean mRendering;
    private ScreenEndpoint mScreen;
    private int mVideoDualEncodeHeight;
    private int mVideoDualEncodeWidth;
    private VideoEncodeEndpoint mVideoEncodeEndpoint;
    private int mVideoEncodeHeight;
    private int mVideoEncodeWidth;
    private int mVideoHeight;
    private boolean mVideoLocalHorMirror = GlobalConfig.mLocalVideoHorMirrorEnabled;
    private boolean mVideoLocalVerMirror = GlobalConfig.mLocalVideoVrtMirrorEnabled;
    private boolean mVideoRemoteHorMirror = false;
    private int mVideoWidth;
    private int mViewHeight;
    private int mViewWidth;
    private WaterMarkController mWaterMarkPos;

    public interface OpenGLRendererCallBack {
        int onRendererTextureReadyCallBack(byte[] bArr, int i, int i2, int i3, int i4, long j);
    }

    private void enableBeautifyInternal(boolean z) {
    }

    public void onWaterMarkParamsChanged() {
    }

    LocalOpenGLRenderer() {
    }

    public void setOpenGLRendererCallBack(OpenGLRendererCallBack openGLRendererCallBack) {
        this.mOpenGLRendererCallBack = openGLRendererCallBack;
    }

    public void setCameraId(int i) {
        this.mCameraId = i;
        ScreenEndpoint screenEndpoint = this.mScreen;
        if (screenEndpoint != null) {
            screenEndpoint.setCameraId(i);
        }
        VideoEncodeEndpoint videoEncodeEndpoint = this.mVideoEncodeEndpoint;
        if (videoEncodeEndpoint != null) {
            videoEncodeEndpoint.setCameraId(i);
        }
        VideoEncodeEndpoint videoEncodeEndpoint2 = this.mDualVideoEncodeEndpoint;
        if (videoEncodeEndpoint2 != null) {
            videoEncodeEndpoint2.setCameraId(i);
        }
    }

    public void startRendering(LocalOpenGLRendererBean localOpenGLRendererBean) {
        createRenderer();
        configureRenderer(localOpenGLRendererBean);
        this.mPipeline.startRendering();
        this.mRendering = true;
        VideoStatus.mEglRenderStatus = VideoStatus.OpenglESRenderStatus.RENDERING;
    }

    public void clearResource() {
        FastImageProcessingPipeline fastImageProcessingPipeline = this.mPipeline;
        if (fastImageProcessingPipeline != null) {
            fastImageProcessingPipeline.clearResource();
            this.mPipeline = null;
        }
        this.mRendering = false;
        this.mPreviewInput = null;
        this.mHandleDataOutput = null;
        this.mScreen = null;
        this.mVideoEncodeEndpoint = null;
        this.mDualVideoEncodeEndpoint = null;
    }

    public boolean renderingBase() {
        FastImageProcessingPipeline fastImageProcessingPipeline = this.mPipeline;
        if (this.mRendering && fastImageProcessingPipeline != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!fastImageProcessingPipeline.onDrawFrame()) {
                return false;
            }
            VideoStatus.addVideoCapFrameTimes();
            VideoStatus.videoCapFrameEffectBufferSurface = (int) (System.currentTimeMillis() - currentTimeMillis);
        }
        return true;
    }

    public boolean renderingDisplay() {
        if (!this.mRendering) {
            return true;
        }
        ScreenEndpoint screenEndpoint = this.mScreen;
        HandleDataOutput handleDataOutput = this.mHandleDataOutput;
        if (!(screenEndpoint == null || handleDataOutput == null)) {
            int frameBufferTextureId = handleDataOutput.getFrameBufferTextureId();
            if (frameBufferTextureId == 0) {
                this.mFastLogCacheBean.mMessage = "Render local display failed! Texture id is zero!";
                OmniLog.fd(this.mFastLogCacheBean);
                return false;
            }
            screenEndpoint.newTextureReady(frameBufferTextureId, handleDataOutput, false);
            VideoStatus.mVideoRenderDisplayFrmes++;
        }
        return true;
    }

    public boolean renderingEncoder(MediaCodecSurface mediaCodecSurface) {
        HandleDataOutput handleDataOutput;
        VideoEncodeEndpoint videoEncodeEndpoint;
        if (!this.mRendering || (handleDataOutput = this.mHandleDataOutput) == null) {
            return true;
        }
        int frameBufferTextureId = handleDataOutput.getFrameBufferTextureId();
        if (frameBufferTextureId == 0) {
            return false;
        }
        if (mediaCodecSurface.getFlag() == 1) {
            VideoEncodeEndpoint videoEncodeEndpoint2 = this.mVideoEncodeEndpoint;
            if (videoEncodeEndpoint2 != null) {
                videoEncodeEndpoint2.newTextureReady(frameBufferTextureId, this.mHandleDataOutput, false);
            }
        } else if (mediaCodecSurface.getFlag() == 2 && (videoEncodeEndpoint = this.mDualVideoEncodeEndpoint) != null) {
            videoEncodeEndpoint.newTextureReady(frameBufferTextureId, this.mHandleDataOutput, false);
        }
        return true;
    }

    public void setRotate(int i) {
        this.mCameraRotate = i;
        String str = TAG;
        OmniLog.i(str, "Setting rotate = " + i);
        ScreenEndpoint screenEndpoint = this.mScreen;
        if (screenEndpoint != null) {
            screenEndpoint.setRotate(i);
        }
        VideoEncodeEndpoint videoEncodeEndpoint = this.mVideoEncodeEndpoint;
        if (videoEncodeEndpoint != null) {
            videoEncodeEndpoint.setMatrixRotate(i);
        }
        VideoEncodeEndpoint videoEncodeEndpoint2 = this.mDualVideoEncodeEndpoint;
        if (videoEncodeEndpoint2 != null) {
            videoEncodeEndpoint2.setMatrixRotate(i);
        }
        executingSetVideoSize(this.mVideoWidth, this.mVideoHeight, this.mCameraRotate);
        executingSetVideoEncodeSize(this.mVideoEncodeWidth, this.mVideoEncodeHeight, this.mCameraRotate);
        executingSetVideoDualEncodeSize(this.mVideoDualEncodeWidth, this.mVideoDualEncodeHeight, this.mCameraRotate);
    }

    public void setVideoSize(int i, int i2) {
        if (i != 0 && i2 != 0) {
            if (i != this.mVideoWidth || i2 != this.mVideoHeight) {
                String str = TAG;
                OmniLog.i(str, "Setting video size = " + i + " * " + i2 + ", rotate = " + this.mCameraRotate);
                this.mVideoWidth = i;
                this.mVideoHeight = i2;
                executingSetVideoSize(i, i2, this.mCameraRotate);
            }
        }
    }

    public void executingSetVideoSize(int i, int i2, int i3) {
        int[] adjustSizeByRotate = DeviceUtils.adjustSizeByRotate(i, i2, i3);
        int i4 = adjustSizeByRotate[0];
        int i5 = adjustSizeByRotate[1];
        CameraPreviewInput cameraPreviewInput = this.mPreviewInput;
        if (cameraPreviewInput != null) {
            cameraPreviewInput.setRenderSize(i4, i5);
        }
    }

    public void executingSetVideoEncodeSize(int i, int i2, int i3) {
        int[] adjustSizeByRotate = DeviceUtils.adjustSizeByRotate(i, i2, i3);
        int i4 = adjustSizeByRotate[0];
        int i5 = adjustSizeByRotate[1];
        ScreenEndpoint screenEndpoint = this.mScreen;
        if (screenEndpoint != null) {
            screenEndpoint.setEncodeSize(i4, i5);
        }
        VideoEncodeEndpoint videoEncodeEndpoint = this.mVideoEncodeEndpoint;
        if (videoEncodeEndpoint != null) {
            videoEncodeEndpoint.setEncodeRawSize(i4, i5);
            this.mVideoEncodeEndpoint.setEncodeSize(i4, i5);
        }
    }

    public void executingSetVideoDualEncodeSize(int i, int i2, int i3) {
        int[] adjustSizeByRotate = DeviceUtils.adjustSizeByRotate(i, i2, i3);
        int i4 = adjustSizeByRotate[0];
        int i5 = adjustSizeByRotate[1];
        VideoEncodeEndpoint videoEncodeEndpoint = this.mDualVideoEncodeEndpoint;
        if (videoEncodeEndpoint != null) {
            videoEncodeEndpoint.setEncodeRawSize(i4, i5);
            this.mDualVideoEncodeEndpoint.setEncodeSize(i4, i5);
        }
    }

    public void setVideoEncodeSize(int i, int i2) {
        if (i != 0 && i2 != 0) {
            String str = TAG;
            OmniLog.i(str, "Setting encode size = " + i + " * " + i2 + ", rotate = " + this.mCameraRotate);
            this.mVideoEncodeWidth = i;
            this.mVideoEncodeHeight = i2;
            executingSetVideoEncodeSize(i, i2, this.mCameraRotate);
        }
    }

    public void setVideoDualEncodeSize(int i, int i2) {
        if (i != 0 && i2 != 0) {
            String str = TAG;
            OmniLog.i(str, "Setting dual encode size = " + i + " * " + i2 + ", rotate = " + this.mCameraRotate);
            this.mVideoDualEncodeWidth = i;
            this.mVideoDualEncodeHeight = i2;
            executingSetVideoDualEncodeSize(i, i2, this.mCameraRotate);
        }
    }

    public void setViewSize(int i, int i2) {
        this.mViewWidth = i;
        this.mViewHeight = i2;
        String str = TAG;
        OmniLog.i(str, "Setting view size = " + i + " * " + i2);
        ScreenEndpoint screenEndpoint = this.mScreen;
        if (screenEndpoint != null) {
            screenEndpoint.setViewSize(i, i2);
        }
    }

    public void setRenderPreviewStatus(boolean z) {
        this.mPreview = z;
        ScreenEndpoint screenEndpoint = this.mScreen;
        if (screenEndpoint != null) {
            screenEndpoint.setPreView(z);
        }
    }

    public void setRenderMode(int i) {
        this.mRenderMode = i;
        String str = TAG;
        OmniLog.i(str, "Setting render mode = " + i);
        ScreenEndpoint screenEndpoint = this.mScreen;
        if (screenEndpoint != null) {
            screenEndpoint.setRenderMode(i);
        }
    }

    public void setBeautifyStatus(boolean z) {
        this.mBeautifyEnabled = z;
        if (this.mRendering) {
            enableBeautifyInternal(z);
        }
    }

    public void setBeautifyLevel(float f) {
        this.mBeautifyLevel = f;
    }

    public void setBrightLevel(float f) {
        this.mBeautifyBrightLevel = f;
    }

    public void setRenderMirror(boolean z, boolean z2) {
        this.mVideoLocalHorMirror = z;
        this.mVideoLocalVerMirror = z2;
        String str = TAG;
        OmniLog.i(str, "Setting render mirror, hor = " + z + ", ver = " + z2);
        ScreenEndpoint screenEndpoint = this.mScreen;
        if (screenEndpoint != null) {
            screenEndpoint.setRenderMirror(z, z2);
        }
    }

    public void setRenderEncodeMirror(boolean z) {
        this.mVideoRemoteHorMirror = z;
        String str = TAG;
        OmniLog.i(str, "Setting encode mirror, hor = " + z);
        VideoEncodeEndpoint videoEncodeEndpoint = this.mVideoEncodeEndpoint;
        if (videoEncodeEndpoint != null) {
            videoEncodeEndpoint.setRenderMirror(z);
        }
        VideoEncodeEndpoint videoEncodeEndpoint2 = this.mDualVideoEncodeEndpoint;
        if (videoEncodeEndpoint2 != null) {
            videoEncodeEndpoint2.setRenderMirror(z);
        }
    }

    public void setReadPixelParams(int[] iArr) {
        OpenGLPixelReader openGLPixelReader = this.mOpenGLPixelReader;
        if (openGLPixelReader != null) {
            openGLPixelReader.setReadPixelParams(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        r8 = TAG;
        com.wushuangtech.utils.OmniLog.i(r8, "Executing set render type :  " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setRenderType(boolean r7, com.wushuangtech.myvideoimprove.bean.LocalOpenGLRendererBean r8) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mLock
            monitor-enter(r0)
            if (r7 == 0) goto L_0x002f
            com.wushuangtech.myvideoimprove.render.imageprocessing.OpenGLPixelReader r1 = r6.mOpenGLPixelReader     // Catch:{ all -> 0x0051 }
            if (r1 != 0) goto L_0x0010
            com.wushuangtech.myvideoimprove.render.imageprocessing.OpenGLPixelReader r1 = new com.wushuangtech.myvideoimprove.render.imageprocessing.OpenGLPixelReader     // Catch:{ all -> 0x0051 }
            r1.<init>()     // Catch:{ all -> 0x0051 }
            r6.mOpenGLPixelReader = r1     // Catch:{ all -> 0x0051 }
        L_0x0010:
            int[] r8 = r8.mOpenGLReadPixelArgs     // Catch:{ all -> 0x0051 }
            if (r8 != 0) goto L_0x001d
            java.lang.String r7 = TAG     // Catch:{ all -> 0x0051 }
            java.lang.String r8 = "openglReadPixelArgs == null"
            com.wushuangtech.utils.OmniLog.e(r7, r8)     // Catch:{ all -> 0x0051 }
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return
        L_0x001d:
            com.wushuangtech.myvideoimprove.render.imageprocessing.OpenGLPixelReader r1 = r6.mOpenGLPixelReader     // Catch:{ all -> 0x0051 }
            r2 = 0
            r2 = r8[r2]     // Catch:{ all -> 0x0051 }
            r3 = 1
            r3 = r8[r3]     // Catch:{ all -> 0x0051 }
            r4 = 2
            r4 = r8[r4]     // Catch:{ all -> 0x0051 }
            r5 = 3
            r8 = r8[r5]     // Catch:{ all -> 0x0051 }
            r1.setReadPixelParams(r2, r3, r4, r8)     // Catch:{ all -> 0x0051 }
            goto L_0x0039
        L_0x002f:
            com.wushuangtech.myvideoimprove.render.imageprocessing.OpenGLPixelReader r8 = r6.mOpenGLPixelReader     // Catch:{ all -> 0x0051 }
            if (r8 == 0) goto L_0x0039
            r8.clearResource()     // Catch:{ all -> 0x0051 }
            r8 = 0
            r6.mOpenGLPixelReader = r8     // Catch:{ all -> 0x0051 }
        L_0x0039:
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            java.lang.String r8 = TAG
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Executing set render type :  "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            com.wushuangtech.utils.OmniLog.i(r8, r7)
            return
        L_0x0051:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.render.LocalOpenGLRenderer.setRenderType(boolean, com.wushuangtech.myvideoimprove.bean.LocalOpenGLRendererBean):void");
    }

    public void setRenderWaterMark(WaterMarkController waterMarkController) {
        this.mWaterMarkPos = waterMarkController;
    }

    public void setRenderRawData(VideoCapFrame videoCapFrame) {
        HandleDataOutput handleDataOutput;
        if (this.mRendering && (handleDataOutput = this.mHandleDataOutput) != null) {
            handleDataOutput.receiveVideoData(videoCapFrame.mData, videoCapFrame.mWidth, videoCapFrame.mHeight, videoCapFrame.mRotate, videoCapFrame.mTimestamp, videoCapFrame.mDrop);
        }
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        CameraPreviewInput cameraPreviewInput = this.mPreviewInput;
        if (cameraPreviewInput != null) {
            cameraPreviewInput.setSurfaceTexture(surfaceTexture);
        }
    }

    public void setSurfaceTextureId(int i) {
        CameraPreviewInput cameraPreviewInput = this.mPreviewInput;
        if (cameraPreviewInput != null) {
            cameraPreviewInput.setTextureId(i);
        }
    }

    public int notifyHandleTextureData(byte[] bArr, int i, int i2, int i3, int i4, long j) {
        OpenGLRendererCallBack openGLRendererCallBack = this.mOpenGLRendererCallBack;
        if (openGLRendererCallBack != null) {
            return openGLRendererCallBack.onRendererTextureReadyCallBack(bArr, i, i2, i3, i4, j);
        }
        return 0;
    }

    private void createRenderer() {
        this.mPipeline = new FastImageProcessingPipeline();
        this.mPreviewInput = new CameraPreviewInput();
        HandleDataOutput handleDataOutput = new HandleDataOutput();
        this.mHandleDataOutput = handleDataOutput;
        handleDataOutput.setOnOpenGLTextureDataCallBack(this);
        this.mScreen = new ScreenEndpoint();
        this.mVideoEncodeEndpoint = new VideoEncodeEndpoint(1);
        this.mDualVideoEncodeEndpoint = new VideoEncodeEndpoint(2);
        this.mPreviewInput.addTarget(this.mHandleDataOutput);
        this.mPipeline.addRootRenderer(this.mPreviewInput);
        this.mPipeline.addFilterToDestroy(this.mPreviewInput);
        this.mPipeline.addFilterToDestroy(this.mHandleDataOutput);
        this.mPipeline.addFilterToDestroy(this.mScreen);
        this.mPipeline.addFilterToDestroy(this.mVideoEncodeEndpoint);
        this.mPipeline.addFilterToDestroy(this.mDualVideoEncodeEndpoint);
    }

    private void configureRenderer(LocalOpenGLRendererBean localOpenGLRendererBean) {
        String str = TAG;
        OmniLog.i(str, "Config renderer bean = " + localOpenGLRendererBean + ", texture = " + localOpenGLRendererBean.mVideoCapSurfaceTexture + ", textureId = " + localOpenGLRendererBean.mCameraTextureId);
        this.mPreviewInput.setSurfaceTexture(localOpenGLRendererBean.mVideoCapSurfaceTexture);
        this.mPreviewInput.setTextureId(localOpenGLRendererBean.mCameraTextureId);
        this.mPreviewInput.setRenderSize(this.mVideoWidth, this.mVideoHeight);
        this.mScreen.setCameraId(this.mCameraId);
        this.mScreen.setPreView(this.mPreview);
        this.mScreen.setRenderMode(this.mRenderMode);
        this.mScreen.setViewSize(this.mViewWidth, this.mViewHeight);
        this.mScreen.setRotate(this.mCameraRotate);
        this.mScreen.setRenderMirror(this.mVideoLocalHorMirror, this.mVideoLocalVerMirror);
        this.mVideoEncodeEndpoint.setCameraId(this.mCameraId);
        this.mVideoEncodeEndpoint.setMatrixRotate(this.mCameraRotate);
        this.mVideoEncodeEndpoint.setRenderMirror(this.mVideoRemoteHorMirror);
        this.mDualVideoEncodeEndpoint.setCameraId(this.mCameraId);
        this.mDualVideoEncodeEndpoint.setMatrixRotate(this.mCameraRotate);
        this.mDualVideoEncodeEndpoint.setRenderMirror(this.mVideoRemoteHorMirror);
        executingSetVideoSize(this.mVideoWidth, this.mVideoHeight, this.mCameraRotate);
        executingSetVideoEncodeSize(this.mVideoEncodeWidth, this.mVideoEncodeHeight, this.mCameraRotate);
        executingSetVideoDualEncodeSize(this.mVideoDualEncodeWidth, this.mVideoDualEncodeHeight, this.mCameraRotate);
    }
}
