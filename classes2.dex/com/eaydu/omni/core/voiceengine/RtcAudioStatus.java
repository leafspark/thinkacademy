package com.eaydu.omni.core.voiceengine;

import android.media.AudioManager;
import com.wushuangtech.api.ExternalAudioModule;
import com.wushuangtech.broadcast.HeadSetReceiver;

public class RtcAudioStatus {
    static AudioManager audioManager = null;
    public static boolean forcePlayMode = false;
    public static boolean forcePlayModeVoip = false;
    static boolean forceRecUseVoip = false;
    public static boolean forceVoipRecord16k = false;
    static boolean headsetOn = false;
    static boolean isCapturing = false;
    public static int mCurrentPlayMode = 0;
    static boolean playUseVoip = false;
    static int recAudioSource = 7;
    public static int recChannels = 1;
    static long recDataSizeInBytes = 0;
    private static boolean recLocalForceDisableBuiltInAec = false;
    public static int recSampleRate = 48000;
    private static boolean recServerForceDisableBuiltInAec = false;
    static boolean recServerForceDisableBuiltInAgc = false;
    static boolean recServerForceDisableBuiltInNs = false;
    static boolean recServerForceDisableUseVoip = false;

    public static boolean setRecServerForceDisableUseVoip(boolean z) {
        recServerForceDisableUseVoip = z;
        return isCapturing && z && recAudioSource == 7;
    }

    public static void setRecServerForceDisableBuiltInNs(boolean z) {
        recServerForceDisableBuiltInNs = z;
    }

    public static void setRecServerForceDisableBuiltInAgc(boolean z) {
        recServerForceDisableBuiltInAgc = z;
    }

    public static void setRecServerForceDisableBuiltInAec(boolean z) {
        recServerForceDisableBuiltInAec = z;
    }

    public static void setRecLocalForceDisableBuiltInAec(boolean z) {
        recLocalForceDisableBuiltInAec = z;
    }

    public static void setPlayUseVoip(boolean z) {
        playUseVoip = z;
    }

    public static boolean setHeadsetOn(boolean z) {
        headsetOn = z;
        if (!isCapturing) {
            return false;
        }
        return (!forceRecUseVoip && z) != (recAudioSource == 1);
    }

    public static void setForceRecUseVoip(boolean z) {
        forceRecUseVoip = z;
    }

    public static long capDataSizeInBytes() {
        return recDataSizeInBytes;
    }

    public static void setCapDataSizeInBytes(long j) {
        recDataSizeInBytes = j;
    }

    public static boolean capturing() {
        return isCapturing;
    }

    public static ExternalAudioModule.RecordErrInfo getRecinfo() {
        ExternalAudioModule.RecordErrInfo recordErrInfo = new ExternalAudioModule.RecordErrInfo();
        recordErrInfo.channels = recChannels;
        recordErrInfo.samplerate = recSampleRate;
        recordErrInfo.recordmode = recordMode();
        recordErrInfo.audioMode = audioManager.getMode();
        recordErrInfo.speakerphoneon = audioManager.isSpeakerphoneOn();
        recordErrInfo.audiofocus = HeadSetReceiver.isAudioFocus();
        return recordErrInfo;
    }

    public static int recordMode() {
        return recAudioSource;
    }

    public static boolean isForceDisableBuiltInAec() {
        return recLocalForceDisableBuiltInAec || recServerForceDisableBuiltInAec;
    }
}
