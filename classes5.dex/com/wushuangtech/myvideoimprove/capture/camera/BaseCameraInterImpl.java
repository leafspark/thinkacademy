package com.wushuangtech.myvideoimprove.capture.camera;

import android.content.Context;
import android.hardware.Camera;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.wushuangtech.constants.RtcGlobalServerMessage;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.GlobalVideoConfig;
import com.wushuangtech.myvideoimprove.bean.VideoCapCameraConfigureBean;
import com.wushuangtech.myvideoimprove.capture.VideoCapFrame;
import com.wushuangtech.myvideoimprove.utils.MyCameraUtils;
import com.wushuangtech.utils.OmniLog;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class BaseCameraInterImpl implements BaseCameraInter, CameraOptionInter {
    private static final String TAG = "CameraInterImpl";
    protected final CameraParams mCameraParams = new CameraParams();
    protected CameraPreSize mCameraPreSize;
    protected Lock mLock = new ReentrantLock();
    protected OnCameraPreviewFrameCallBack mOnCameraPreviewFrameCallBack;
    protected OnCameraErrorCallBack onCameraErrorCallBack;

    public interface OnCameraErrorCallBack {
        void onError(int i);
    }

    public interface OnCameraPreviewFrameCallBack {
        void onPreviewFrame(VideoCapFrame videoCapFrame);
    }

    private int vectorDis(int i, int i2) {
        return i < i2 ? WXMediaMessage.THUMB_LENGTH_LIMIT : i - i2;
    }

    public void setOnCameraPreviewFrameCallBack(OnCameraPreviewFrameCallBack onCameraPreviewFrameCallBack) {
        this.mOnCameraPreviewFrameCallBack = onCameraPreviewFrameCallBack;
    }

    public void setOnCameraErrorCallBack(OnCameraErrorCallBack onCameraErrorCallBack2) {
        this.onCameraErrorCallBack = onCameraErrorCallBack2;
    }

    public boolean setCameraParams(int i, int i2, int i3) {
        try {
            this.mLock.lock();
            if (this.mCameraParams.width == i && this.mCameraParams.height == i2 && this.mCameraParams.fps == i3) {
                return false;
            }
            this.mCameraParams.width = i;
            this.mCameraParams.height = i2;
            this.mCameraParams.fps = i3;
            this.mLock.unlock();
            return true;
        } finally {
            this.mLock.unlock();
        }
    }

    public int getCameraId() {
        try {
            this.mLock.lock();
            return this.mCameraParams.cameraId;
        } finally {
            this.mLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean setCameraOrientation(int i) {
        try {
            this.mLock.lock();
            this.mCameraParams.mRotation = i;
            this.mLock.unlock();
            return true;
        } catch (Throwable th) {
            this.mLock.unlock();
            throw th;
        }
    }

    public CameraPreSize getCameraPreSize() {
        try {
            this.mLock.lock();
            CameraPreSize cameraPreSize = this.mCameraPreSize;
            if (cameraPreSize == null) {
                return null;
            }
            CameraPreSize cameraPreSize2 = new CameraPreSize(cameraPreSize.width, this.mCameraPreSize.height);
            this.mLock.unlock();
            return cameraPreSize2;
        } finally {
            this.mLock.unlock();
        }
    }

    public int getCameraRotate() {
        try {
            this.mLock.lock();
            return this.mCameraParams.previewAngle;
        } finally {
            this.mLock.unlock();
        }
    }

    public int[] getCameraExpectSize() {
        try {
            this.mLock.lock();
            return new int[]{this.mCameraParams.width, this.mCameraParams.height};
        } finally {
            this.mLock.unlock();
        }
    }

    public int getCameraFps() {
        try {
            this.mLock.lock();
            return this.mCameraParams.fps;
        } finally {
            this.mLock.unlock();
        }
    }

    public void switchCamera() {
        try {
            this.mLock.lock();
            int i = 1;
            if (this.mCameraParams.cameraId == 1) {
                i = 0;
            }
            this.mCameraParams.cameraId = i;
        } finally {
            this.mLock.unlock();
        }
    }

    public boolean cameraInspectFunction(int i) {
        return MyCameraUtils.inspectCameraSupports(this.mCameraParams.cameraId, i);
    }

    public void resetStatus() {
        this.mCameraParams.cameraId = 1;
    }

    public VideoCapCameraConfigureBean initCamera() {
        logI(TAG, "============= Start init camera! ===================");
        return initCamera(this.mCameraParams);
    }

    public VideoCapCameraConfigureBean startCameraCap(VideoCapCameraConfigureBean videoCapCameraConfigureBean) {
        logI(TAG, "============= Start open camera! <" + videoCapCameraConfigureBean.mCameraTexture + "> ===================");
        if (this.mCameraParams.userRecordMode && !checkPreviewSize(videoCapCameraConfigureBean)) {
            logE(TAG, "setRecordingHint error!");
            if (videoCapCameraConfigureBean.mCamera != null) {
                videoCapCameraConfigureBean.mCamera.release();
            }
            this.mCameraParams.userRecordMode = false;
            videoCapCameraConfigureBean = initCamera(this.mCameraParams);
            if (videoCapCameraConfigureBean.mCameraOpenResult != 0) {
                return videoCapCameraConfigureBean;
            }
        }
        return openCamera(videoCapCameraConfigureBean, videoCapCameraConfigureBean.mCameraTexture);
    }

    /* access modifiers changed from: protected */
    public void sendPreviewSizeChangedEvent(int i, int i2) {
        GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.VIDEO_LOCAL_CAP_SIZE_CHANGED, Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public CameraPreSize findCloselyPreSize(int i, int i2, List<CameraPreSize> list) {
        if (i < i2) {
            int i3 = i2;
            i2 = i;
            i = i3;
        }
        logI(TAG, "Src size : " + i + " | " + i2);
        CameraPreSize cameraPreSize = list.get(0);
        int vectorDis = vectorDis(cameraPreSize.width, i) + vectorDis(cameraPreSize.height, i2);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (CameraPreSize next : list) {
            sb.append("[");
            sb.append(next.width);
            sb.append(" * ");
            sb.append(next.height);
            sb.append("], ");
            int vectorDis2 = vectorDis(next.width, i) + vectorDis(next.height, i2);
            if (next.width < next.height) {
                vectorDis2++;
            }
            if (vectorDis2 < vectorDis) {
                cameraPreSize = next;
                vectorDis = vectorDis2;
            }
        }
        sb.append("]");
        logI(TAG, "Support sizes : " + sb.toString());
        logI(TAG, "Closest size : " + cameraPreSize.width + " | " + cameraPreSize.height);
        return new CameraPreSize(cameraPreSize.width, cameraPreSize.height);
    }

    /* access modifiers changed from: package-private */
    public int[] findClosestFpsRange(int i, List<int[]> list) {
        logI(TAG, "Target fps : " + i);
        if (list.size() == 1) {
            logI(TAG, "fps range : " + Arrays.toString(list.get(0)));
            return list.get(0);
        }
        Collections.sort(list, new Comparator<int[]>() {
            public int compare(int[] iArr, int[] iArr2) {
                if (((long) (iArr[0] + iArr[1])) > ((long) (iArr2[0] + iArr2[1]))) {
                    return -1;
                }
                return 1;
            }
        });
        for (int[] arrays : list) {
            logI(TAG, "fps range : " + Arrays.toString(arrays));
        }
        if (list.get(1)[1] < i) {
            return list.get(0);
        }
        return list.get(1);
    }

    private boolean checkPreviewSize(VideoCapCameraConfigureBean videoCapCameraConfigureBean) {
        try {
            Camera.Size previewSize = videoCapCameraConfigureBean.mCamera.getParameters().getPreviewSize();
            if (previewSize.width == videoCapCameraConfigureBean.mPreviewWidth && previewSize.height == videoCapCameraConfigureBean.mPreviewHeight) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void logI(String str, String str2) {
        OmniLog.i("LPW][VCW", str, str2);
    }

    /* access modifiers changed from: package-private */
    public void logE(String str, String str2) {
        OmniLog.e("LPW][VCW", str, str2);
    }

    public static class CameraParams {
        int cameraId = 1;
        public int fps = 15;
        public int height = GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_HEIGHT;
        int mCameraZoom;
        public Context mContext;
        public int mRotation;
        boolean openFlash;
        int previewAngle = 90;
        boolean userRecordMode = true;
        public int width = GlobalVideoConfig.VIDEO_DEFAULT_ENCODE_WIDTH;

        public String toString() {
            return "CameraParams{mContext=" + this.mContext + ", cameraId=" + this.cameraId + ", width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", previewAngle=" + this.previewAngle + ", mRotation=" + this.mRotation + ", mCameraZoom=" + this.mCameraZoom + ", openFlash=" + this.openFlash + ", userRecordMode=" + this.userRecordMode + '}';
        }
    }

    public static class CameraPreSize {
        public int height;
        public int width;

        CameraPreSize(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }
}
