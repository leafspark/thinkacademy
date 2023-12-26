package com.wushuangtech.api;

import com.wushuangtech.bean.CommonEventBean;
import com.wushuangtech.bean.ServerConfigBean;
import java.util.List;

public interface ExternalVideoModuleCallback {

    public enum VideoFrameType {
        FRAMETYPE_INVALID,
        FRAMETYPE_SPS_PPS,
        FRAMETYPE_I,
        FRAMETYPE_P
    }

    void addVideoSender(VideoSender videoSender);

    void changeDualEncParam(int i, int i2);

    void changeEncParam(int i, int i2);

    int dualMaxBitrate();

    int dualMaxFps();

    void initVideoConfig(String str);

    void initVideoGlobalConfig();

    boolean isCapturing();

    int maxBitrate();

    int maxFps();

    void receiveH264Sei(byte[] bArr, long j, String str);

    void receiveVideoData(String str, byte[] bArr, String str2, long j, int i, int i2, VideoFrameType videoFrameType);

    void removeVideoSender(VideoSender videoSender);

    void requestDualIFrame();

    void requestIFrame();

    void resetVideoDecoderStatus(CommonEventBean commonEventBean);

    void setBitrateMode(int i);

    boolean startCapture();

    boolean startDualCapture();

    void stopAllPlay();

    boolean stopCapture();

    boolean stopDualCapture();

    void stopPlay(String str);

    void stopPlay(String str, String str2);

    void updateServerConfig(List<ServerConfigBean> list);

    void updateVideoDecoderSpentTime();
}
