package com.wushuangtech.inter;

import com.wushuangtech.bean.AVSourceSyncBean;
import com.wushuangtech.expansion.bean.LocalAudioStats;
import com.wushuangtech.expansion.bean.RtcStats;
import com.wushuangtech.handler.AVRouterHandler;
import com.wushuangtech.jni.callback.RtcGlobalSignalCallBackImpl;
import com.wushuangtech.library.GlobalAudioConfig;
import com.wushuangtech.library.GlobalVideoConfig;

public interface RtcGlobalAVInterface {
    void cacheAVSourceSyncOpt(AVSourceSyncBean aVSourceSyncBean);

    void clearResource();

    void configChannelAfterJoinChannel();

    AVRouterHandler getAVRouterHandler();

    GlobalAudioConfig getAudioConfig();

    LocalAudioStats getLocalAudioStatus();

    int getLocalVideoSentFps();

    RtcStats getRtcStats(String str);

    GlobalVideoConfig getVideoConfig();

    void init();

    void initChannelAfterJoinChannel(String str);

    void reportAVStatistical();

    void resetAVStatistical();

    void resetChannelAVStatistical(String str);

    void setGlobalEventInterface(RtcGlobalEventInterface rtcGlobalEventInterface);

    void setRtcGlobalSignalCallBack(RtcGlobalSignalCallBackImpl rtcGlobalSignalCallBackImpl);

    void startAVStatistical();

    void unInit();

    void updateAVStatistical();
}
