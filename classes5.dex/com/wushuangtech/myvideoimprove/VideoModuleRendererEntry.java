package com.wushuangtech.myvideoimprove;

import android.content.Context;
import android.graphics.Bitmap;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.video.opengles.WaterMarkController;
import com.wushuangtech.myvideoimprove.LocalVideoRenderModel;
import com.wushuangtech.myvideoimprove.bean.BaseVideoModelConfigureBean;
import com.wushuangtech.myvideoimprove.bean.LocalVideoModelConfigureBean;
import com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder;
import com.wushuangtech.myvideoimprove.inter.OnLocalVideoModuleEventCallBack;
import com.wushuangtech.myvideoimprove.inter.OnVideoModuleControlCallBack;
import com.wushuangtech.myvideoimprove.view.VideoRenderView;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;

public class VideoModuleRendererEntry implements OnVideoModuleControlCallBack, LocalVideoRenderModel.OnLocalVideoNV21DataCallBack, LocalVideoRenderModel.OnLocalVideoTextureCallBack {
    private static final String TAG = "LVRMEntry";
    private LocalVideoRenderModel mLocalVideoRenderModel;
    /* access modifiers changed from: private */
    public OnLocalVideoModuleEventCallBack mOnLocalVideoModuleEventCallBack;
    private boolean mSetupLocalVideo;

    public boolean isSetupLocalVideo() {
        return this.mSetupLocalVideo;
    }

    public void setOnLocalVideoModuleEventCallBack(OnLocalVideoModuleEventCallBack onLocalVideoModuleEventCallBack) {
        this.mOnLocalVideoModuleEventCallBack = onLocalVideoModuleEventCallBack;
        this.mLocalVideoRenderModel.setOnLocalVideoModuleEventCallBack(onLocalVideoModuleEventCallBack);
    }

    public int setupLocalVideoDirector(VideoRenderView videoRenderView, WaterMarkController waterMarkController, int i, int i2) {
        return setupLocalVideo(videoRenderView, false, i, 0, i2, waterMarkController);
    }

    public int setupLocalVideo(VideoRenderView videoRenderView, WaterMarkController waterMarkController, int i, int i2) {
        return setupLocalVideo(videoRenderView, true, -1, i, i2, waterMarkController);
    }

    public void setVideoRenderMode(int i) {
        this.mLocalVideoRenderModel.configRenderer(104, Integer.valueOf(i));
    }

    public void setVideoLocalRenderMirror(boolean z, boolean z2) {
        this.mLocalVideoRenderModel.setVideoLocalMirror(z, z2);
    }

    public void setVideoLocalEncodedMirror(boolean z) {
        this.mLocalVideoRenderModel.setVideoRemoteMirror(z);
    }

    public void setVideoEncodeParams(int i, int i2, int i3, int i4) {
        this.mLocalVideoRenderModel.setVideoEncoderParams(i, i2, i3, i4, false);
    }

    public void setVideoDualEncodeParams(int i, int i2, int i3, int i4) {
        this.mLocalVideoRenderModel.setVideoEncoderParams(i, i2, i3, i4, true);
    }

    public void startPreview() {
        this.mLocalVideoRenderModel.configRenderer(100, true);
    }

    public void stopPreview() {
        this.mLocalVideoRenderModel.configRenderer(100, false);
    }

    public void startRender() {
        this.mLocalVideoRenderModel.startVideoRender((BaseVideoModelConfigureBean) null);
    }

    public void stopRender() {
        this.mLocalVideoRenderModel.stopVideoRender();
    }

    public void setCameraSwitch() {
        this.mLocalVideoRenderModel.setVideoCapSwitch();
    }

    public boolean setCameraZoom(int i) {
        this.mLocalVideoRenderModel.configRenderer(202, Integer.valueOf(i));
        return true;
    }

    public boolean setCameraTorch(boolean z) {
        this.mLocalVideoRenderModel.configRenderer(203, Boolean.valueOf(z));
        return true;
    }

    public void setBeautfyEnabled(boolean z) {
        this.mLocalVideoRenderModel.configRenderer(101, Boolean.valueOf(z));
    }

    public void setBeautfyParams(float f, float f2) {
        this.mLocalVideoRenderModel.configRenderer(102, Float.valueOf(f));
        this.mLocalVideoRenderModel.configRenderer(103, Float.valueOf(f2));
    }

    private void setVidoeEnderStatus(boolean z, boolean z2) {
        OmniLog.i(OmniLog.LOCAL_PREVIEW, TAG, "Recv signal to change the state of the encoder, open? : " + z + " | dual? : " + z2 + " - bug1000 bug1001 000 ");
        this.mLocalVideoRenderModel.setVideoEncoderType(GlobalConfig.mForceVideoSoftEncoder);
        this.mLocalVideoRenderModel.setVideoEncoderStatus(z, z2);
    }

    public void setActivityDirector(int i) {
        this.mLocalVideoRenderModel.setActivityDirector(i);
    }

    public void setVideoCapRotateFromSystem(int i) {
        this.mLocalVideoRenderModel.setVideoCapRotateFromSystem(i);
    }

    public void setVideoBitrateMode(int i) {
        this.mLocalVideoRenderModel.setVideoEncoderBitrateMode(i);
    }

    public int getCameraMaxZoom() {
        return this.mLocalVideoRenderModel.getVideoCapCameraMaxZoom();
    }

    public void setCameraPreviewResolution(int i, int i2) {
        this.mLocalVideoRenderModel.setVideoCapPreviewResolution(i, i2);
    }

    public Object getCameraId() {
        return Integer.valueOf(this.mLocalVideoRenderModel.getVideoCapCameraId());
    }

    public boolean cameraInspectFunction(int i) {
        return this.mLocalVideoRenderModel.getVideoCapCameraFuncSupported(i);
    }

    public void requestKeyFrame(LocalVideoEncoder.VideoEncoderType videoEncoderType) {
        this.mLocalVideoRenderModel.setVideoEncoderKeyFrame(videoEncoderType);
    }

    private int setupLocalVideo(VideoRenderView videoRenderView, boolean z, int i, int i2, int i3, WaterMarkController waterMarkController) {
        VideoRenderView videoRenderView2;
        VideoRenderView videoRenderView3 = videoRenderView;
        long currentTimeMillis = System.currentTimeMillis();
        if (!(videoRenderView3 == null || (videoRenderView2 = this.mLocalVideoRenderModel.getVideoRenderView()) == videoRenderView3)) {
            OmniLog.i(OmniLog.LOCAL_PREVIEW, TAG, "Import Setup local video, Change view, old : " + videoRenderView2 + " | new : " + videoRenderView);
            this.mLocalVideoRenderModel.setVideoRenderView(videoRenderView);
        }
        configLocalVideoRender(z, i, i2, i3, waterMarkController);
        this.mSetupLocalVideo = true;
        OmniLog.i(OmniLog.LOCAL_PREVIEW, TAG, "Setup local video, execute finish, spend time : " + (System.currentTimeMillis() - currentTimeMillis));
        return 0;
    }

    private void configLocalVideoRender(boolean z, int i, int i2, int i3, WaterMarkController waterMarkController) {
        if (z) {
            this.mLocalVideoRenderModel.setVideoCapRotate(i2);
        } else {
            this.mLocalVideoRenderModel.setActivityDirector(i);
        }
        this.mLocalVideoRenderModel.configRenderer(104, Integer.valueOf(i3));
        this.mLocalVideoRenderModel.setWaterMark(waterMarkController);
    }

    public void createNewLocalVideoRenderModel(Context context) {
        OmniLog.i(OmniLog.LOCAL_PREVIEW, TAG, "Create local video renderer module, context:" + context);
        LocalVideoRenderModel localVideoRenderModel = new LocalVideoRenderModel();
        this.mLocalVideoRenderModel = localVideoRenderModel;
        localVideoRenderModel.setContext(context);
        this.mLocalVideoRenderModel.setOnLocalVideoNV21DataCallBack(this);
        this.mLocalVideoRenderModel.setOnLocalVideoTextureCallBack(this);
        this.mLocalVideoRenderModel.setOnLocalVideoModuleEventCallBack(this.mOnLocalVideoModuleEventCallBack);
        this.mLocalVideoRenderModel.setOnLocalVideoRenderModelCallBack(new LocalVideoRenderModelCallBackImpl(this));
        this.mLocalVideoRenderModel.createVideoRenderer(new LocalVideoModelConfigureBean());
    }

    public void resetLocalVideoRenderModel() {
        this.mLocalVideoRenderModel.resetStatus();
    }

    public void onVideoFrameData(byte[] bArr, int i, int i2, int i3, long j) {
        OnLocalVideoModuleEventCallBack onLocalVideoModuleEventCallBack = this.mOnLocalVideoModuleEventCallBack;
        if (onLocalVideoModuleEventCallBack != null) {
            onLocalVideoModuleEventCallBack.onVideoNV21FrameReport(bArr, i, i2, i3, j);
        }
    }

    public int onVideoFrameTexture(int i, byte[] bArr, int i2, int i3, int i4, long j) {
        OnLocalVideoModuleEventCallBack onLocalVideoModuleEventCallBack = this.mOnLocalVideoModuleEventCallBack;
        if (onLocalVideoModuleEventCallBack != null) {
            return onLocalVideoModuleEventCallBack.onVideoTextureFrameReport(i, bArr, i2, i3, i4, j);
        }
        return 0;
    }

    public void videoEncodeParamsChanged(boolean z, int i, int i2) {
        if (z) {
            this.mLocalVideoRenderModel.setVideoEncoderParams(LocalVideoEncoder.VideoEncoderType.DUAL, i, i2);
        } else {
            this.mLocalVideoRenderModel.setVideoEncoderParams(LocalVideoEncoder.VideoEncoderType.MAIN, i, i2);
        }
    }

    public void videoEncodeStarted(boolean z) {
        setVidoeEnderStatus(true, z);
    }

    public void videoEncodeStoped(boolean z) {
        setVidoeEnderStatus(false, z);
    }

    public void waterMarkBitmapChanged(Bitmap bitmap) {
        WaterMarkController waterMark = this.mLocalVideoRenderModel.getWaterMark();
        if (waterMark != null) {
            waterMark.setBitmap(bitmap);
        }
    }

    public void waterMarkLocationChanged(float f, float f2) {
        WaterMarkController waterMark = this.mLocalVideoRenderModel.getWaterMark();
        if (waterMark != null) {
            waterMark.setX_soffset(f);
            waterMark.setY_soffset(f2);
        }
    }

    private static class LocalVideoRenderModelCallBackImpl implements LocalVideoRenderModel.OnLocalVideoRenderModelCallBack {
        private final WeakReference<VideoModuleRendererEntry> mOutReference;

        public void onVideoRenderModelDestoryed() {
        }

        public LocalVideoRenderModelCallBackImpl(VideoModuleRendererEntry videoModuleRendererEntry) {
            this.mOutReference = new WeakReference<>(videoModuleRendererEntry);
        }

        public void onVideoCaptureSuccess(int i, int i2, int i3) {
            OnLocalVideoModuleEventCallBack access$000;
            VideoModuleRendererEntry videoModuleRendererEntry = (VideoModuleRendererEntry) this.mOutReference.get();
            if (videoModuleRendererEntry != null && (access$000 = videoModuleRendererEntry.mOnLocalVideoModuleEventCallBack) != null) {
                access$000.onVideoCameraSuccess(i, i2, i3);
            }
        }

        public void onVideoCaptureError(int i) {
            OnLocalVideoModuleEventCallBack access$000;
            VideoModuleRendererEntry videoModuleRendererEntry = (VideoModuleRendererEntry) this.mOutReference.get();
            if (videoModuleRendererEntry != null && (access$000 = videoModuleRendererEntry.mOnLocalVideoModuleEventCallBack) != null) {
                access$000.onVideoCameraError(i);
            }
        }

        public void onVideoRenderFailed(int i) {
            OnLocalVideoModuleEventCallBack access$000;
            VideoModuleRendererEntry videoModuleRendererEntry = (VideoModuleRendererEntry) this.mOutReference.get();
            if (videoModuleRendererEntry != null && (access$000 = videoModuleRendererEntry.mOnLocalVideoModuleEventCallBack) != null) {
                access$000.onVideoRenderError(i);
            }
        }

        public void onVideoStartEncoderFailed(int i) {
            OnLocalVideoModuleEventCallBack access$000;
            VideoModuleRendererEntry videoModuleRendererEntry = (VideoModuleRendererEntry) this.mOutReference.get();
            if (videoModuleRendererEntry != null && (access$000 = videoModuleRendererEntry.mOnLocalVideoModuleEventCallBack) != null) {
                access$000.onVideoEncodeError(i);
            }
        }

        public void onVideoFirstLocalVideoFrame(int i, int i2) {
            OnLocalVideoModuleEventCallBack access$000;
            VideoModuleRendererEntry videoModuleRendererEntry = (VideoModuleRendererEntry) this.mOutReference.get();
            if (videoModuleRendererEntry != null && (access$000 = videoModuleRendererEntry.mOnLocalVideoModuleEventCallBack) != null) {
                access$000.onVideoFirstLocalVideoFrame(i, i2);
            }
        }

        public void onVideoEncodedDataReport(boolean z, byte[] bArr, int i, int i2, int i3, long j) {
            VideoModuleRendererEntry videoModuleRendererEntry = (VideoModuleRendererEntry) this.mOutReference.get();
            if (videoModuleRendererEntry != null && videoModuleRendererEntry.mOnLocalVideoModuleEventCallBack != null) {
                videoModuleRendererEntry.mOnLocalVideoModuleEventCallBack.onVideoEncodedDataReport(z, bArr, i, i2, i3, j);
            }
        }
    }
}
