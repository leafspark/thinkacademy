package com.wushuangtech.audiocore;

import com.wushuangtech.bean.CommonEventBean;

class AudioEventHandler {
    AudioEventHandler() {
    }

    public Object recvExternalAudioModuleEvent(MyAudioApi myAudioApi, CommonEventBean commonEventBean) {
        int i = commonEventBean.mEventType;
        if (i == 1) {
            myAudioApi.adjustPlaybackSignalVolumeForChannel(((Long) commonEventBean.mObjects[0]).longValue(), ((Double) commonEventBean.mObjects[1]).doubleValue());
            return null;
        } else if (i == 2) {
            myAudioApi.adjustPlaybackSignalVolume(((Long) commonEventBean.mObjects[0]).longValue(), ((Double) commonEventBean.mObjects[1]).doubleValue());
            return null;
        } else if (i != 4) {
            return null;
        } else {
            myAudioApi.startPlayMix();
            return null;
        }
    }
}
