package com.eaydu.omni.core.voiceengine;

import android.os.Build;

class RtcAudioDefaultDecision extends RtcAudioDecision {
    RtcAudioDefaultDecision() {
    }

    public void chooseRecAudioSource(boolean z) {
        if (!RtcAudioStatus.forceVoipRecord16k || !z ? Build.VERSION.SDK_INT <= 19 || WebRtcAudioUtils.isBlackListedVoiceCommunication() || RtcAudioStatus.recServerForceDisableUseVoip || (!RtcAudioStatus.forceRecUseVoip && RtcAudioStatus.headsetOn) : Build.VERSION.SDK_INT <= 19) {
            z = false;
        }
        RtcAudioStatus.recAudioSource = z ? 7 : (RtcAudioStatus.headsetOn || RtcAudioStatus.forceVoipRecord16k) ? 1 : 6;
    }

    public boolean playStreamTypeUsingVoip() {
        return RtcAudioStatus.playUseVoip;
    }
}
