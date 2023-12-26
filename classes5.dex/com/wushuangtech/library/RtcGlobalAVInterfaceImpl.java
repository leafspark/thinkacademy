package com.wushuangtech.library;

import com.wushuangtech.bean.AVSourceSyncBean;
import com.wushuangtech.expansion.bean.LocalAudioStats;
import com.wushuangtech.expansion.bean.RtcStats;
import com.wushuangtech.handler.AVRouterHandler;
import com.wushuangtech.inter.RtcGlobalAVInterface;
import com.wushuangtech.inter.RtcGlobalEventInterface;
import com.wushuangtech.jni.callback.RtcGlobalSignalCallBackImpl;

public class RtcGlobalAVInterfaceImpl implements RtcGlobalAVInterface {
    private final GlobalAVHolder mAVHolder = new GlobalAVHolder();

    public void init() {
        this.mAVHolder.init();
    }

    public void unInit() {
        this.mAVHolder.unInit();
    }

    public GlobalAudioConfig getAudioConfig() {
        return this.mAVHolder.getAudioConfig();
    }

    public GlobalVideoConfig getVideoConfig() {
        return this.mAVHolder.getVideoConfig();
    }

    public AVRouterHandler getAVRouterHandler() {
        return this.mAVHolder.getAVRouterHandler();
    }

    public void setGlobalEventInterface(RtcGlobalEventInterface rtcGlobalEventInterface) {
        this.mAVHolder.setGlobalEventInterface(rtcGlobalEventInterface);
    }

    public void setRtcGlobalSignalCallBack(RtcGlobalSignalCallBackImpl rtcGlobalSignalCallBackImpl) {
        this.mAVHolder.setRtcGlobalSignalCallBack(rtcGlobalSignalCallBackImpl);
    }

    public void configChannelAfterJoinChannel() {
        this.mAVHolder.configChannelAfterJoinChannel();
    }

    public void initChannelAfterJoinChannel(String str) {
        this.mAVHolder.initChannelAfterJoinChannel(str);
    }

    public void clearResource() {
        this.mAVHolder.clearResource();
    }

    public void cacheAVSourceSyncOpt(AVSourceSyncBean aVSourceSyncBean) {
        this.mAVHolder.cacheAVSourceSyncOpt(aVSourceSyncBean);
    }

    public void startAVStatistical() {
        this.mAVHolder.startAVStatistical();
    }

    public void updateAVStatistical() {
        this.mAVHolder.updateAVStatistical();
    }

    public void resetAVStatistical() {
        this.mAVHolder.resetAVStatistical();
    }

    public void resetChannelAVStatistical(String str) {
        this.mAVHolder.resetChannelAVStatistical(str);
    }

    public int getLocalVideoSentFps() {
        return this.mAVHolder.getLocalVideoSentFps();
    }

    public LocalAudioStats getLocalAudioStatus() {
        return this.mAVHolder.getLocalAudioStatus();
    }

    public RtcStats getRtcStats(String str) {
        return this.mAVHolder.getRtcStats(str);
    }

    public void reportAVStatistical() {
        this.mAVHolder.reportAVStatistical();
    }
}
