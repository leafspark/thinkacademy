package com.wushuangtech.api;

import android.util.LongSparseArray;
import com.wushuangtech.api.ExternalAudioModule;
import com.wushuangtech.bean.CommonEventBean;
import java.util.ArrayList;

public interface ExternalAudioModuleCallback {
    void adjSpeakerVolumeScale(float f);

    void adjustPlaybackSignalVolume(long j, double d);

    boolean audioFileMixing();

    float audioSoloVolumeScale();

    void clearResource();

    void enableAudioPcmWriteFile(boolean z, String str);

    void enableAudioVadIndication(boolean z, boolean z2);

    void enableLowerAudioLatency(boolean z);

    void forceUseVoipAll(boolean z, boolean z2);

    ExternalAudioModule.AecDelayMetrics getAecDelayMetrics();

    ExternalAudioModule.AecParams getAecStats();

    int getAudioVadLevel(String str, long j);

    long getCaptureDataSize();

    int getEncodeDataSize();

    ExternalAudioModule.LocalAudioStatistics getLocalAudioStatistics();

    int getRecvBytes(long j);

    LongSparseArray<ExternalAudioModule.AudioStatistics> getRemoteAudioStatistics();

    int getSizeOfMuteAudioPlayed();

    ArrayList<Long> getSpeakers();

    void initChannelResAfterJoined(String str);

    boolean isCapturing();

    boolean isLocalMuted();

    void leaveChannel(String str);

    void muteDataSending(boolean z);

    void muteLocal(boolean z);

    void muteRemote(long j, boolean z);

    boolean pauseAudio();

    void pauseRecordOnly(boolean z);

    boolean playMixing();

    boolean recordMixing();

    float remoteVolumeScale(long j);

    void replayUseVoip(boolean z);

    void resetSendNackList();

    boolean resumeAudio();

    Object sendAudioModuleEvent(CommonEventBean commonEventBean);

    void setAecStatus(boolean z, int i);

    void setAgcStatus(boolean z, int i);

    void setAudioApplicationScene(int i);

    void setAudioEngineMode(int i);

    void setDelayoffset(int i, boolean z, boolean z2, boolean z3);

    void setExpandCartonParams(int i, int i2);

    void setForceChangeAudioRouter(boolean z, boolean z2);

    void setForceDisableBuiltInAec(boolean z);

    void setForceUseOpensl(boolean z);

    void setHeadsetStatus(boolean z);

    void setLocalSsrc(int i);

    void setNsStatus(boolean z, int i);

    int setRemoteVolumeAll(int i);

    void setSendCodec(int i, int i2, int i3, boolean z);

    void setServerDevParam(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6);

    boolean startCapture();

    boolean startPlay(long j);

    boolean startSafetyCapture();

    boolean stopCapture();

    boolean stopPlay(long j);
}
