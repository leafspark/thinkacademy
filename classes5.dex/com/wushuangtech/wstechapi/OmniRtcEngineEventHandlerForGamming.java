package com.wushuangtech.wstechapi;

import com.wushuangtech.expansion.bean.AudioVolumeInfo;
import com.wushuangtech.expansion.bean.RtcStats;

public abstract class OmniRtcEngineEventHandlerForGamming extends OmniRtcEngineEventHandler {
    public void onAudioVolumeIndication(AudioVolumeInfo[] audioVolumeInfoArr, int i) {
    }

    public void onConnectionLost() {
    }

    public void onError(int i) {
    }

    public void onJoinChannelSuccess(String str, long j, int i) {
    }

    public void onLeaveChannel(RtcStats rtcStats) {
    }

    public void onRtcStats(RtcStats rtcStats) {
    }

    public void onUserJoined(long j, int i, int i2) {
    }

    public void onUserOffline(long j, int i) {
    }
}
