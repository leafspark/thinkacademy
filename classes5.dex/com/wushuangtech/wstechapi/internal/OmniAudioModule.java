package com.wushuangtech.wstechapi.internal;

import com.wushuangtech.api.EnterConfApi;
import com.wushuangtech.audiocore.MyAudioApi;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;

class OmniAudioModule {
    private static final String TAG = "OmniAudioModule";

    OmniAudioModule() {
    }

    public int enableLocalAudio(boolean z) {
        if (GlobalConfig.mAudioLocalEnabled == z) {
            return 0;
        }
        if (!GlobalConfig.mAudioEnabled) {
            return -3;
        }
        GlobalConfig.mAudioLocalEnabled = z;
        if (!GlobalHolder.getInstance().isJoinedChannel()) {
            return 0;
        }
        EnterConfApi.getInstance().updateHeartbeatReporterAudioStatus((Boolean) null, Boolean.valueOf(z), (Boolean) null);
        if (z) {
            MyAudioApi.getInstance().startCapture();
        } else {
            MyAudioApi.getInstance().stopCapture();
        }
        return 0;
    }

    public int setAudioMode(int i) {
        if (i != 0 && i != 1 && i != 2) {
            return -5;
        }
        GlobalHolder.getInstance().getGlobalAudioConfig().setAudioMode(i);
        return 0;
    }

    public int setAudioEncoderConfiguration(int i, int i2) {
        return MyAudioApi.getInstance().setAudioEncoderConfiguration(i, i2);
    }

    public int setRemoteVolumeAll(int i) {
        MyAudioApi.getInstance().setRemoteVolumeAll(i);
        return 0;
    }

    public int setAudioMixMode(int i, long[] jArr) {
        if (i == 0 || 1 == i) {
            return MyAudioApi.getInstance().setAudioMixMode(i, jArr);
        }
        return -5;
    }
}
