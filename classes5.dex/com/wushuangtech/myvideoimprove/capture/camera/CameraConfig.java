package com.wushuangtech.myvideoimprove.capture.camera;

import com.wushuangtech.utils.OmniLog;

public class CameraConfig {
    public static final int CAMERA_PARAMETER_CONFIG_BACKUP_1 = 1;
    public static final int CAMERA_PARAMETER_CONFIG_BACKUP_2 = 2;
    public static final int CAMERA_PARAMETER_CONFIG_BACKUP_3 = 3;
    public static final int CAMERA_PARAMETER_CONFIG_BACKUP_4 = 4;
    public static final int CAMERA_PARAMETER_CONFIG_FUNC_NUM = 4;
    public static final int CAMERA_PARAMETER_CONFIG_MAIN = 0;
    private static final String TAG = "CameraConfig";
    private int mConfig = 0;
    private int mErrorTimes;
    public boolean mFlashEnabled = true;
    public boolean mFocusEnabled = true;
    public boolean mFpsEnabled = true;
    public boolean mRecordModeEnabled = true;
    public boolean mZoomEnabled = true;

    public void switchParametersConfig(int i) {
        this.mConfig = i;
        if (i == 0) {
            this.mFocusEnabled = true;
            this.mRecordModeEnabled = true;
            this.mFpsEnabled = true;
            this.mFlashEnabled = true;
            this.mZoomEnabled = true;
        } else if (i == 1) {
            this.mFocusEnabled = false;
            this.mRecordModeEnabled = true;
            this.mFpsEnabled = true;
            this.mFlashEnabled = true;
            this.mZoomEnabled = true;
        } else if (i == 2) {
            this.mFocusEnabled = false;
            this.mRecordModeEnabled = false;
            this.mFpsEnabled = true;
            this.mFlashEnabled = true;
            this.mZoomEnabled = true;
        } else if (i == 3) {
            this.mFocusEnabled = false;
            this.mRecordModeEnabled = false;
            this.mFpsEnabled = false;
            this.mFlashEnabled = true;
            this.mZoomEnabled = true;
        } else if (i == 4) {
            this.mFocusEnabled = false;
            this.mRecordModeEnabled = false;
            this.mFpsEnabled = false;
            this.mFlashEnabled = false;
            this.mZoomEnabled = false;
        }
    }

    public void increaseErrorTimes() {
        this.mErrorTimes++;
        OmniLog.e(OmniLog.VIDEO_CAP_WATCH, TAG, "Camera start preview failed! times=" + this.mErrorTimes);
        int i = this.mErrorTimes;
        if (i <= 4) {
            switchParametersConfig(i);
        }
    }

    public String toString() {
        return "CameraConfig{mConfig=" + this.mConfig + ", mErrorTimes=" + this.mErrorTimes + ", mFlashEnabled=" + this.mFlashEnabled + ", mFocusEnabled=" + this.mFocusEnabled + ", mZoomEnabled=" + this.mZoomEnabled + ", mRecordModeEnabled=" + this.mRecordModeEnabled + ", mFpsEnabled=" + this.mFpsEnabled + '}';
    }
}
