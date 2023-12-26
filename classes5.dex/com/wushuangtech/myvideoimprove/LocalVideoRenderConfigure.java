package com.wushuangtech.myvideoimprove;

import com.wushuangtech.myvideoimprove.LocalVideoRenderModel;
import com.wushuangtech.myvideoimprove.capture.VideoCapCameraInterImpl;
import com.wushuangtech.myvideoimprove.render.LocalVideoRenderer;

class LocalVideoRenderConfigure {
    static final int WORK_MSG_VIDEO_CAP_TORCH = 203;
    static final int WORK_MSG_VIDEO_CAP_ZOOM = 202;
    static final int WORK_MSG_VIDEO_RENDER_BEAUTFY_BRIGHT_LEVEL = 103;
    static final int WORK_MSG_VIDEO_RENDER_BEAUTFY_ENABLE = 101;
    static final int WORK_MSG_VIDEO_RENDER_BEAUTFY_LEVEL = 102;
    static final int WORK_MSG_VIDEO_RENDER_MODE = 104;
    static final int WORK_MSG_VIDEO_RENDER_REVIEW_ADJUST = 100;
    private boolean mBeautfyEnabled = true;
    private LocalVideoRenderer mLocalVideoRenderer;
    private LocalVideoRenderModel.OnLocalVideoRenderModelCallBack mOnLocalVideoRenderModelCallBack;
    private VideoCapCameraInterImpl mVideoCap;

    LocalVideoRenderConfigure() {
    }

    /* access modifiers changed from: package-private */
    public void initRenderer(VideoCapCameraInterImpl videoCapCameraInterImpl, LocalVideoRenderer localVideoRenderer, LocalVideoRenderModel.OnLocalVideoRenderModelCallBack onLocalVideoRenderModelCallBack) {
        this.mLocalVideoRenderer = localVideoRenderer;
        this.mVideoCap = videoCapCameraInterImpl;
        this.mOnLocalVideoRenderModelCallBack = onLocalVideoRenderModelCallBack;
    }

    /* access modifiers changed from: package-private */
    public void configRenderer(int i, Object[] objArr) {
        if (i < 200) {
            handleVideoRenderEvent(i, objArr);
        } else {
            handleVideoCapEvent(i, objArr);
        }
    }

    private void handleVideoRenderEvent(int i, Object[] objArr) {
        switch (i) {
            case 100:
                this.mLocalVideoRenderer.setRenderPreviewStatus(objArr[0].booleanValue());
                return;
            case 101:
                boolean booleanValue = objArr[0].booleanValue();
                if (this.mBeautfyEnabled != booleanValue) {
                    this.mLocalVideoRenderer.setEnableBeautify(booleanValue);
                    this.mBeautfyEnabled = booleanValue;
                    return;
                }
                return;
            case 102:
                this.mLocalVideoRenderer.setBeautifyLevel(objArr[0].floatValue());
                return;
            case 103:
                this.mLocalVideoRenderer.setBrightLevel(objArr[0].floatValue());
                return;
            case 104:
                this.mLocalVideoRenderer.setRenderMode(objArr[0].intValue());
                return;
            default:
                return;
        }
    }

    private void handleVideoCapEvent(int i, Object[] objArr) {
        if (i == 202) {
            this.mVideoCap.setCameraZoom(objArr[0].intValue());
        } else if (i == 203) {
            this.mVideoCap.setCameraTorch(objArr[0].booleanValue());
        }
    }
}
