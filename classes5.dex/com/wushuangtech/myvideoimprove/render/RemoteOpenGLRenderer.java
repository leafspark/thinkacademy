package com.wushuangtech.myvideoimprove.render;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.wushuangtech.expansion.api.Constants;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.video.bean.VideoRemoteRawDataBean;
import com.wushuangtech.library.video.opengles.input.GLTextureOutputRenderer;
import com.wushuangtech.library.video.opengles.input.VideoDecodeInput;
import com.wushuangtech.library.video.opengles.input.VideoRawDataDecodeInput;
import com.wushuangtech.library.video.opengles.output.ScreenEndpoint;
import com.wushuangtech.myvideoimprove.render.imageprocessing.FastImageProcessingPipeline;
import com.wushuangtech.utils.MyGLUtils;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;

public class RemoteOpenGLRenderer {
    private String TAG = "RemoteOpenGLRenderer";
    private VideoDecodeInput mDecodeInput;
    private final String mDeviceId;
    private int mHeight;
    private boolean mInited;
    private int mMirrorMode;
    private FastImageProcessingPipeline mPipeline;
    private int mRenderMode;
    private ScreenEndpoint mScreen;
    private SurfaceTexture mSurfaceTexture;
    private boolean mTextureCreated;
    private int[] mTextureId;
    private VideoRawDataDecodeInput mVideoRawDataDecodeInput;
    private final WeakReference<RemoteVideoRenderer> mVideoRendererRef;
    private int mViewHeight;
    private int mViewWidth;
    private int mWidth;

    public RemoteOpenGLRenderer(String str, RemoteVideoRenderer remoteVideoRenderer) {
        this.mDeviceId = str;
        this.mMirrorMode = GlobalConfig.mRemoteVideoHorMirrorEnabled ? Constants.VIDEO_MIRROR_MODE_ENABLED : Constants.VIDEO_MIRROR_MODE_DISABLED;
        this.mRenderMode = GlobalConfig.mRemoteVideoRenderMode;
        this.mVideoRendererRef = new WeakReference<>(remoteVideoRenderer);
    }

    public void setTAG(String str) {
        this.TAG = str + "::" + this.TAG;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    public void initRenderer() {
        if (!this.mInited) {
            boolean z = true;
            this.mInited = true;
            this.mPipeline = new FastImageProcessingPipeline();
            this.mScreen = new ScreenEndpoint(this.mDeviceId);
            if (GlobalConfig.mVideoRemoteRenderTexture) {
                VideoDecodeInput videoDecodeInput = new VideoDecodeInput();
                this.mDecodeInput = videoDecodeInput;
                videoDecodeInput.addTarget(this.mScreen);
                this.mPipeline.addRootRenderer(this.mDecodeInput);
                this.mPipeline.addFilterToDestroy(this.mDecodeInput);
            } else {
                VideoRawDataDecodeInput videoRawDataDecodeInput = new VideoRawDataDecodeInput(this.mDeviceId);
                this.mVideoRawDataDecodeInput = videoRawDataDecodeInput;
                videoRawDataDecodeInput.addTarget(this.mScreen);
                this.mPipeline.addRootRenderer(this.mVideoRawDataDecodeInput);
                this.mPipeline.addFilterToDestroy(this.mVideoRawDataDecodeInput);
            }
            this.mPipeline.addFilterToDestroy(this.mScreen);
            this.mPipeline.startRendering();
            if (GlobalConfig.mVideoRemoteRenderTexture) {
                checkTextureStats();
            }
            executingSettingRenderSize(this.mWidth, this.mHeight);
            this.mScreen.setPreView(true);
            this.mScreen.setViewSize(this.mViewWidth, this.mViewHeight);
            this.mScreen.setRenderMode(this.mRenderMode);
            ScreenEndpoint screenEndpoint = this.mScreen;
            if (this.mMirrorMode != 160201) {
                z = false;
            }
            screenEndpoint.setRenderMirror(z, false);
            log("Init renderer success! video size=" + this.mWidth + " * " + this.mHeight + ", view size=" + this.mViewWidth + "*" + this.mViewHeight);
        }
    }

    public void prepare() {
        this.mDecodeInput.setSurfaceTexture(this.mSurfaceTexture);
        this.mDecodeInput.setTextureId(this.mTextureId[0]);
        RemoteVideoRenderer remoteVideoRenderer = (RemoteVideoRenderer) this.mVideoRendererRef.get();
        if (remoteVideoRenderer != null) {
            remoteVideoRenderer.mOnRemoteVideoRendererCallBack.onSurfaceTextureAvailable(this.mSurfaceTexture, this.mDeviceId);
        }
    }

    public void clearResource() {
        if (this.mInited) {
            this.mPipeline.clearResource();
            int[] iArr = this.mTextureId;
            if (!(iArr == null || iArr[0] == 0)) {
                GLES20.glDeleteTextures(1, iArr, 0);
                this.mTextureId = null;
            }
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSurfaceTexture = null;
            }
            log("Clear resource over!");
            this.mTextureCreated = false;
            this.mInited = false;
        }
    }

    public void setRenderSize(int i, int i2) {
        if (i != 0 && i2 != 0) {
            log("Setting video render size : " + i + " * " + i2);
            if (this.mWidth != i || this.mHeight != i2) {
                this.mWidth = i;
                this.mHeight = i2;
                executingSettingRenderSize(i, i2);
                if (!GlobalConfig.mVideoRemoteRenderTexture) {
                    return;
                }
                if (this.mTextureCreated) {
                    clearResource();
                    initRenderer();
                    return;
                }
                checkTextureStats();
            }
        }
    }

    private void executingSettingRenderSize(int i, int i2) {
        if (GlobalConfig.mVideoRemoteRenderTexture) {
            VideoDecodeInput videoDecodeInput = this.mDecodeInput;
            if (videoDecodeInput != null) {
                videoDecodeInput.setRenderSize(i, i2);
                return;
            }
            return;
        }
        VideoRawDataDecodeInput videoRawDataDecodeInput = this.mVideoRawDataDecodeInput;
        if (videoRawDataDecodeInput != null) {
            videoRawDataDecodeInput.setRenderSize(i, i2);
        }
    }

    public void setPreviewSize(int i, int i2) {
        log("Setting video preview size : " + i + " * " + i2);
        if (i != this.mViewWidth || i2 != this.mViewHeight) {
            this.mViewWidth = i;
            this.mViewHeight = i2;
            ScreenEndpoint screenEndpoint = this.mScreen;
            if (screenEndpoint != null) {
                screenEndpoint.setViewSize(i, i2);
            }
        }
    }

    public void setRenderMode(int i) {
        log("Setting video render mode : " + i);
        if (this.mRenderMode != i) {
            this.mRenderMode = i;
            ScreenEndpoint screenEndpoint = this.mScreen;
            if (screenEndpoint != null) {
                screenEndpoint.setRenderMode(i);
            }
        }
    }

    public void setMirrorMode(int i) {
        log("Setting video mirror mode : " + i);
        if (i != this.mMirrorMode) {
            this.mMirrorMode = i;
            ScreenEndpoint screenEndpoint = this.mScreen;
            if (screenEndpoint != null) {
                screenEndpoint.setRenderMirror(i == 160201, false);
            }
        }
    }

    public boolean drawFrame(VideoRemoteRawDataBean videoRemoteRawDataBean) {
        VideoRawDataDecodeInput videoRawDataDecodeInput = this.mVideoRawDataDecodeInput;
        if (videoRawDataDecodeInput != null) {
            videoRawDataDecodeInput.setRawData(videoRemoteRawDataBean);
        }
        return this.mPipeline.onDrawFrame();
    }

    public boolean drawDisplayWindow() {
        GLTextureOutputRenderer gLTextureOutputRenderer;
        if (GlobalConfig.mVideoRemoteRenderTexture) {
            gLTextureOutputRenderer = this.mDecodeInput;
        } else {
            gLTextureOutputRenderer = this.mVideoRawDataDecodeInput;
        }
        ScreenEndpoint screenEndpoint = this.mScreen;
        if (!(gLTextureOutputRenderer == null || screenEndpoint == null)) {
            int frameBufferTextureId = gLTextureOutputRenderer.getFrameBufferTextureId();
            if (frameBufferTextureId == 0) {
                OmniLog.e("RVW", this.TAG, "Frame buffer texture id is zero!", false);
                return false;
            }
            screenEndpoint.newTextureReady(frameBufferTextureId, gLTextureOutputRenderer, false);
        }
        return true;
    }

    private void checkTextureStats() {
        if (!this.mTextureCreated && createSurfaceTexture()) {
            this.mTextureCreated = true;
            prepare();
        }
    }

    private boolean createSurfaceTexture() {
        if (this.mWidth == 0 || this.mHeight == 0 || !this.mInited) {
            return false;
        }
        int createWhiteOESTextureId = MyGLUtils.createWhiteOESTextureId();
        this.mTextureId = new int[]{createWhiteOESTextureId};
        SurfaceTexture surfaceTexture = new SurfaceTexture(createWhiteOESTextureId);
        this.mSurfaceTexture = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(this.mWidth, this.mHeight);
        log("Create new texture! " + this.mSurfaceTexture + " | width : " + this.mWidth + " | height : " + this.mHeight);
        return true;
    }

    private void log(String str) {
        OmniLog.i("RVW", this.TAG, str);
    }
}
