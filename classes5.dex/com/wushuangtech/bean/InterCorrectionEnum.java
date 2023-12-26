package com.wushuangtech.bean;

public enum InterCorrectionEnum {
    INTER_SETUP_REMOTE_VIDEO("setupRemoteVideo"),
    INTER_MUTE_REMOTE_AUDIO("muteRemoteAudioStream"),
    INTER_MUTE_REMOTE_VIDEO("muteRemoteVideoStream");
    
    String mVal;

    private InterCorrectionEnum(String str) {
        this.mVal = str;
    }
}
