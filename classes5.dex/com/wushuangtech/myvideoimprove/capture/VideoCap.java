package com.wushuangtech.myvideoimprove.capture;

import com.wushuangtech.myvideoimprove.bean.VideoCapConfigureBean;

public interface VideoCap {
    int getVideoCapFps();

    int[] getVideoCapSize();

    VideoCapConfigureBean initVideoCapture();

    boolean isVideoCaping();

    void resetStatus();

    VideoCapConfigureBean startVideoCapture(VideoCapConfigureBean videoCapConfigureBean);

    void stopVideoCapture();
}
