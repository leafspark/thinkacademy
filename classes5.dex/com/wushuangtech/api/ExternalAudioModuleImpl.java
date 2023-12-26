package com.wushuangtech.api;

import android.content.Context;
import android.util.LongSparseArray;
import com.wushuangtech.api.ExternalAudioModule;
import com.wushuangtech.bean.AudioEncodedConfig;
import com.wushuangtech.bean.CommonEventBean;
import com.wushuangtech.broadcast.HeadSetReceiver;
import com.wushuangtech.expansion.api.Constants;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.User;
import com.wushuangtech.utils.OmniLog;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class ExternalAudioModuleImpl extends ExternalAudioModule {
    private static final String TAG = "ExternalAudioModule";
    private final ExternalAudioModule.LocalAudioLevelSum localLevelSum = new ExternalAudioModule.LocalAudioLevelSum();
    private int mAudioScenario = -1;
    private WeakReference<ExternalAudioModuleCallback> mCallback;
    private int mEncodedFrameSize = 0;
    private long mLastLocalAudioSpeechInputLevel;
    private final LocalAudioSender mLocalAudioSender = new LocalAudioSender(this);
    private final Object mLocalAudioSpeechInputLevelLock = new Object();

    private native long GetAudioTimestamp(long j);

    private native int GetBufferDuration();

    private native int GetDataErrorTimes();

    private native int GetDelayMS(long j);

    private native int GetFractionLost();

    private native long GetMaxErrorUserid();

    private native int GetRemoteAudioLevelRangeSum(long j);

    private native long GetTotalRecvBytes();

    private native long GetTotalSendBytes();

    private native int GetTotalWannaSendBytes();

    private native int GetUserErrorTimes();

    private native void GetlSpeechInputLevelSum();

    private native boolean IsAllRemoteMuted();

    private native boolean IsRemoteAudioMutedByMyself(long j);

    private native void NativeCachDirectBufferAddress(ByteBuffer byteBuffer);

    /* access modifiers changed from: private */
    public native void PushEncodedAudioData(byte[] bArr, int i);

    /* access modifiers changed from: private */
    public native void SendNACKData(byte[] bArr, int i, long j);

    /* access modifiers changed from: private */
    public native void SendRTCPData(byte[] bArr, int i, long j);

    /* access modifiers changed from: private */
    public native void SetFractionLost(int i);

    private native void Uninitialize();

    private native String nativeGetChannelIdByUser(long j);

    private native int nativeGetEncodedFps();

    private native int nativeGetSpeechInputAudioLevel();

    private native int nativeGetSpeechOutputAudioLevel(long j);

    public native boolean Initialize(ExternalAudioModuleImpl externalAudioModuleImpl);

    static /* synthetic */ int access$008(ExternalAudioModuleImpl externalAudioModuleImpl) {
        int i = externalAudioModuleImpl.mEncodedFrameSize;
        externalAudioModuleImpl.mEncodedFrameSize = i + 1;
        return i;
    }

    ExternalAudioModuleImpl() {
        Initialize(this);
        NativeCachDirectBufferAddress(ByteBuffer.allocateDirect(960));
    }

    public void setExternalAudioModuleCallback(ExternalAudioModuleCallback externalAudioModuleCallback) {
        this.mCallback = new WeakReference<>(externalAudioModuleCallback);
    }

    public LocalAudioSender getLocalAudioSender() {
        return this.mLocalAudioSender;
    }

    public void setExpandCartonParams(int i, int i2) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).setExpandCartonParams(i, i2);
        }
    }

    public void enableAudioVadIndication(boolean z, boolean z2) {
        ExternalAudioModuleCallback callBack = getCallBack();
        if (callBack != null) {
            callBack.enableAudioVadIndication(z, z2);
        }
    }

    public int getAudioVadLevel(String str, long j) {
        ExternalAudioModuleCallback callBack = getCallBack();
        if (callBack == null) {
            return 0;
        }
        return callBack.getAudioVadLevel(str, j);
    }

    public boolean isLocalMuted() {
        ExternalAudioModuleCallback callBack = getCallBack();
        if (callBack == null) {
            return false;
        }
        return callBack.isLocalMuted();
    }

    public void replayUsingVoip(boolean z) {
        ExternalAudioModuleCallback callBack = getCallBack();
        if (callBack != null) {
            callBack.replayUseVoip(z);
        }
    }

    public void setHeadsetStatus(boolean z) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).setHeadsetStatus(z);
        }
    }

    public void pauseAudio() {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).pauseAudio();
        }
    }

    public void resumeAudio() {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).resumeAudio();
        }
    }

    public int getBufferDuration() {
        return GetBufferDuration();
    }

    public long getTotalSendBytes() {
        return GetTotalSendBytes();
    }

    public long getTotalRecvBytes() {
        return GetTotalRecvBytes();
    }

    public int getRecvBytes(long j) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return ((ExternalAudioModuleCallback) this.mCallback.get()).getRecvBytes(j);
    }

    public long getCaptureDataSzie() {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return ((ExternalAudioModuleCallback) this.mCallback.get()).getCaptureDataSize();
    }

    public int getEncodedFps() {
        return nativeGetEncodedFps();
    }

    public int getEncodeDataSize() {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return ((ExternalAudioModuleCallback) this.mCallback.get()).getEncodeDataSize();
    }

    public int getEncodeFrameCount() {
        return this.mEncodedFrameSize;
    }

    public int getSizeOfMuteAudioPlayed() {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference == null || weakReference.get() == null) {
            return 0;
        }
        return ((ExternalAudioModuleCallback) this.mCallback.get()).getSizeOfMuteAudioPlayed();
    }

    public int getUserErrorTimes() {
        return GetUserErrorTimes();
    }

    public int getDataErrorTimes() {
        return GetDataErrorTimes();
    }

    public long getMaxErrorUserid() {
        return GetMaxErrorUserid();
    }

    public boolean isCapturing() {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        return (weakReference == null || weakReference.get() == null || !((ExternalAudioModuleCallback) this.mCallback.get()).isCapturing()) ? false : true;
    }

    public ExternalAudioModule.LocalAudioStatistics getLocalAudioStatistics() {
        ExternalAudioModuleCallback callBack = getCallBack();
        if (callBack == null) {
            return new ExternalAudioModule.LocalAudioStatistics();
        }
        return callBack.getLocalAudioStatistics();
    }

    public LongSparseArray<ExternalAudioModule.AudioStatistics> getAudioStatistics() {
        ExternalAudioModule.AudioStatistics valueAt;
        ExternalAudioModuleCallback callBack = getCallBack();
        if (callBack == null) {
            return new LongSparseArray<>();
        }
        LongSparseArray<ExternalAudioModule.AudioStatistics> remoteAudioStatistics = callBack.getRemoteAudioStatistics();
        for (int i = 0; i < remoteAudioStatistics.size(); i++) {
            long keyAt = remoteAudioStatistics.keyAt(i);
            if (keyAt > 0 && (valueAt = remoteAudioStatistics.valueAt(i)) != null) {
                buildAudioStatistics(nativeGetChannelIdByUser(keyAt), keyAt, valueAt);
            }
        }
        return remoteAudioStatistics;
    }

    public LongSparseArray<ExternalAudioModule.AudioStatistics> getAudioStatistics(String str) {
        ExternalAudioModule.AudioStatistics valueAt;
        ExternalAudioModuleCallback callBack = getCallBack();
        if (callBack == null) {
            return new LongSparseArray<>();
        }
        LongSparseArray<ExternalAudioModule.AudioStatistics> longSparseArray = new LongSparseArray<>();
        LongSparseArray<ExternalAudioModule.AudioStatistics> remoteAudioStatistics = callBack.getRemoteAudioStatistics();
        for (int i = 0; i < remoteAudioStatistics.size(); i++) {
            long keyAt = remoteAudioStatistics.keyAt(i);
            if (keyAt > 0 && (valueAt = remoteAudioStatistics.valueAt(i)) != null && nativeGetChannelIdByUser(keyAt).equals(str)) {
                buildAudioStatistics(str, keyAt, valueAt);
                longSparseArray.put(keyAt, valueAt);
            }
        }
        return longSparseArray;
    }

    public ExternalAudioModule.AecParams getAecStats() {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return ((ExternalAudioModuleCallback) this.mCallback.get()).getAecStats();
    }

    public ExternalAudioModule.AecDelayMetrics getAecDelayMetrics() {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return ((ExternalAudioModuleCallback) this.mCallback.get()).getAecDelayMetrics();
    }

    public void SetLocalSsrc(int i) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).setLocalSsrc(i);
        }
    }

    public int getAudioFractionLost() {
        return GetFractionLost();
    }

    public ExternalAudioModule.LocalAudioLevelSum getSpeechInputLevelSum() {
        return executingGetSpeechInputLevelSum();
    }

    public int getAudioLevel(String str, long j, boolean z) {
        if (z) {
            return nativeGetSpeechInputAudioLevel();
        }
        return nativeGetSpeechOutputAudioLevel(j);
    }

    public boolean RemoteAudioMutedByMyself(long j) {
        return IsRemoteAudioMutedByMyself(j);
    }

    public int GetRemoteLevelRangeSum(long j) {
        return GetRemoteAudioLevelRangeSum(j);
    }

    public boolean IsAllRemoteAudioMuted() {
        return IsAllRemoteMuted();
    }

    public ArrayList<Long> getSpeakers() {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return ((ExternalAudioModuleCallback) this.mCallback.get()).getSpeakers();
    }

    public float GetMicVolumeScale() {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        return (weakReference == null || weakReference.get() == null) ? CropImageView.DEFAULT_ASPECT_RATIO : ((ExternalAudioModuleCallback) this.mCallback.get()).audioSoloVolumeScale();
    }

    public float GetRemoteVolumeScale(long j) {
        ExternalAudioModuleCallback callBack = getCallBack();
        if (callBack == null) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        float remoteVolumeScale = callBack.remoteVolumeScale(j);
        if (remoteVolumeScale == -1.0f) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        return remoteVolumeScale;
    }

    public boolean RecordMixing() {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return ((ExternalAudioModuleCallback) this.mCallback.get()).recordMixing();
    }

    public boolean PlayMixing() {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return ((ExternalAudioModuleCallback) this.mCallback.get()).playMixing();
    }

    public boolean FilePlaying() {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        return ((ExternalAudioModuleCallback) this.mCallback.get()).audioFileMixing();
    }

    /* access modifiers changed from: package-private */
    public void EnableAudio(boolean z) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).pauseRecordOnly(!z);
        }
    }

    /* access modifiers changed from: package-private */
    public void SetForceDisableBuiltInAec(boolean z) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).setForceDisableBuiltInAec(z);
        }
    }

    /* access modifiers changed from: package-private */
    public void SetAgcStatus(boolean z, int i) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).setAgcStatus(z, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void SetNsStatus(boolean z, int i) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).setNsStatus(z, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void ForceUseVoipAll(boolean z, boolean z2) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).forceUseVoipAll(z, z2);
        }
    }

    /* access modifiers changed from: package-private */
    public void SetForceUseOpensl(boolean z) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).setForceUseOpensl(z);
        }
    }

    /* access modifiers changed from: package-private */
    public void MuteDataSending(boolean z) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).muteDataSending(z);
        }
    }

    /* access modifiers changed from: package-private */
    public void EnableLowerAudioLatency(boolean z) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).enableLowerAudioLatency(z);
        }
    }

    public void setAudioApplicationScene(int i) {
        this.mAudioScenario = i;
        ExternalAudioModuleCallback callBack = getCallBack();
        if (callBack != null) {
            OmniLog.d(TAG, "Init audio global config, sence : " + i);
            callBack.setAudioApplicationScene(i);
        }
    }

    public void configChannelBeforeJoinChannel() {
        if (this.mAudioScenario == -1) {
            ExternalAudioModuleCallback callBack = getCallBack();
            if (callBack != null) {
                callBack.setAudioApplicationScene(2);
            } else {
                return;
            }
        }
        AudioEncodedConfig audioEncodedConfig = GlobalHolder.getInstance().getGlobalAudioConfig().getAudioEncodedConfig();
        OmniLog.i(TAG, "AUDIO_ENCODE_PARAMS Send audio codec args : " + audioEncodedConfig.toString());
        RoomJni.getInstance().SetPreferAudioCodec(audioEncodedConfig.mEncodeType, audioEncodedConfig.mEncodeBitrate, audioEncodedConfig.mChannelNum);
    }

    public void configChannelAfterJoinChannel(Context context) {
        HeadSetReceiver.reportAudioRouteChange(!HeadSetReceiver.isHeadsetOn(context));
        sendAudioModuleEvent(new CommonEventBean(4, new Object[0]));
    }

    public void unConfigChannelAfterJoinChannel() {
        this.mEncodedFrameSize = 0;
        ExternalAudioModuleCallback callBack = getCallBack();
        if (callBack != null) {
            callBack.clearResource();
        }
    }

    public void initChannelResAfterJoined(String str) {
        ExternalAudioModuleCallback callBack = getCallBack();
        if (callBack != null) {
            callBack.initChannelResAfterJoined(str);
        }
    }

    public void leaveChannel(String str) {
        ExternalAudioModuleCallback callBack = getCallBack();
        if (callBack != null) {
            callBack.leaveChannel(str);
        }
    }

    public int setProfile(int i, int i2) {
        if (i < 0 || i > Constants.AudioProfile.values().length - 1 || i2 < 0 || i > Constants.AudioScenario.values().length - 1) {
            return -5;
        }
        if (GlobalHolder.getInstance().isJoinedChannel()) {
            return -3;
        }
        this.mAudioScenario = i2;
        OmniLog.i(TAG, "Init audio global config : " + i + " | " + i2);
        setAudioQualityProfile(Constants.AudioProfile.fromInt(i));
        ExternalAudioModuleCallback callBack = getCallBack();
        if (callBack == null) {
            return -3;
        }
        callBack.setAudioApplicationScene(i2);
        return 0;
    }

    public int setEncodeParams(int i, int i2, int i3) {
        if (i != 1 && i != 2 && i != 4) {
            return -5;
        }
        if (i == 1 && (i2 < 8 || i2 > 128)) {
            return -5;
        }
        if (i == 2 && (i2 < 8 || i2 > 32)) {
            return -5;
        }
        if (i == 4 && (i2 < 8 || i2 > 128)) {
            return -5;
        }
        if (i3 != 1 && i3 != 2) {
            return -5;
        }
        if (GlobalHolder.getInstance().isJoinedChannel()) {
            return -3;
        }
        GlobalHolder.getInstance().getGlobalAudioConfig().setAudioEncodeParams(i, i2, i3);
        return 0;
    }

    public void setServerDevParam(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        ExternalAudioModuleCallback callBack = getCallBack();
        if (callBack != null) {
            callBack.setServerDevParam(i, z, z2, z3, z4, z5, z6);
        }
    }

    public void enableAudioPcmWriteFile(boolean z, String str) {
        ExternalAudioModuleCallback callBack = getCallBack();
        if (callBack != null) {
            callBack.enableAudioPcmWriteFile(z, str);
        }
    }

    public Object sendAudioModuleEvent(CommonEventBean commonEventBean) {
        ExternalAudioModuleCallback callBack = getCallBack();
        if (callBack == null) {
            return null;
        }
        return callBack.sendAudioModuleEvent(commonEventBean);
    }

    private ExternalAudioModule.LocalAudioLevelSum executingGetSpeechInputLevelSum() {
        ExternalAudioModule.LocalAudioLevelSum localAudioLevelSum;
        synchronized (this.mLocalAudioSpeechInputLevelLock) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.mLastLocalAudioSpeechInputLevel;
            boolean z = true;
            if (j == 0) {
                this.mLastLocalAudioSpeechInputLevel = currentTimeMillis;
            } else if (currentTimeMillis - j < 1000) {
                z = false;
            }
            if (z) {
                GetlSpeechInputLevelSum();
                this.mLastLocalAudioSpeechInputLevel = currentTimeMillis;
            }
            localAudioLevelSum = new ExternalAudioModule.LocalAudioLevelSum();
            localAudioLevelSum.preLevelSum = this.localLevelSum.preLevelSum;
            localAudioLevelSum.levelSum = this.localLevelSum.levelSum;
            localAudioLevelSum.afterLevelSum = this.localLevelSum.afterLevelSum;
        }
        return localAudioLevelSum;
    }

    public boolean StartCapture() {
        OmniLog.i(TAG, "StartCapture mCallback:" + this.mCallback);
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        return (weakReference == null || weakReference.get() == null || !((ExternalAudioModuleCallback) this.mCallback.get()).startCapture()) ? false : true;
    }

    public boolean StartSafetyCapture() {
        OmniLog.i(TAG, "StartSafetyCapture mCallback:" + this.mCallback);
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        return (weakReference == null || weakReference.get() == null || !((ExternalAudioModuleCallback) this.mCallback.get()).startSafetyCapture()) ? false : true;
    }

    public boolean StopCapture() {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        return (weakReference == null || weakReference.get() == null || !((ExternalAudioModuleCallback) this.mCallback.get()).stopCapture()) ? false : true;
    }

    private boolean StartPlay(long j) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        return (weakReference == null || weakReference.get() == null || !((ExternalAudioModuleCallback) this.mCallback.get()).startPlay(j)) ? false : true;
    }

    private boolean StopPlay(long j) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        return (weakReference == null || weakReference.get() == null || !((ExternalAudioModuleCallback) this.mCallback.get()).stopPlay(j)) ? false : true;
    }

    private void SetSendCodec(int i, int i2, int i3, boolean z) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).setSendCodec(i, i2, i3, false);
        }
    }

    private void MuteLocal(boolean z) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).muteLocal(z);
        }
    }

    private boolean IsLocalMuted() {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        return (weakReference == null || weakReference.get() == null || !((ExternalAudioModuleCallback) this.mCallback.get()).isLocalMuted()) ? false : true;
    }

    private void MuteRemote(long j, boolean z) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).muteRemote(j, z);
        }
    }

    /* access modifiers changed from: package-private */
    public void SetForceChangeAudioRouter(boolean z, boolean z2) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).setForceChangeAudioRouter(z, z2);
        }
    }

    private void OnGetLocalLevelSum(int i, int i2, int i3) {
        this.localLevelSum.levelSum = i3;
        this.localLevelSum.preLevelSum = i;
        this.localLevelSum.afterLevelSum = i2;
    }

    private void AdjRemoteAudioVolumeScale(long j, double d) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).adjustPlaybackSignalVolume(j, d);
        }
    }

    private void AdjSpeakerVolumeScale(double d) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).adjSpeakerVolumeScale((float) d);
        }
    }

    private void ReplayUsingVoip(boolean z) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).replayUseVoip(z);
        }
    }

    private void ResetSendNackList() {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).resetSendNackList();
        }
    }

    private void SetAudioEngineMode(int i) {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((ExternalAudioModuleCallback) this.mCallback.get()).setAudioEngineMode(i);
        }
    }

    public static class LocalAudioSender implements AudioSender {
        private final WeakReference<ExternalAudioModule> mExternalAudioModuleRef;

        public LocalAudioSender(ExternalAudioModule externalAudioModule) {
            this.mExternalAudioModuleRef = new WeakReference<>(externalAudioModule);
        }

        public void pushEncodedAudioData(byte[] bArr) {
            ExternalAudioModuleImpl externalAudioModuleImpl = (ExternalAudioModuleImpl) this.mExternalAudioModuleRef.get();
            if (externalAudioModuleImpl != null) {
                ExternalAudioModuleImpl.access$008(externalAudioModuleImpl);
                externalAudioModuleImpl.PushEncodedAudioData(bArr, bArr.length);
            }
        }

        public void sendRTCPData(byte[] bArr, int i, long j) {
            ExternalAudioModuleImpl externalAudioModuleImpl = (ExternalAudioModuleImpl) this.mExternalAudioModuleRef.get();
            if (externalAudioModuleImpl != null) {
                externalAudioModuleImpl.SendRTCPData(bArr, i, j);
            }
        }

        public void sendNACKData(byte[] bArr, int i, long j) {
            ExternalAudioModuleImpl externalAudioModuleImpl = (ExternalAudioModuleImpl) this.mExternalAudioModuleRef.get();
            if (externalAudioModuleImpl != null) {
                externalAudioModuleImpl.SendNACKData(bArr, i, j);
            }
        }

        public void SetAudioFractionLoss(int i) {
            ExternalAudioModuleImpl externalAudioModuleImpl = (ExternalAudioModuleImpl) this.mExternalAudioModuleRef.get();
            if (externalAudioModuleImpl != null) {
                externalAudioModuleImpl.SetFractionLost(i);
            }
        }
    }

    private ExternalAudioModuleCallback getCallBack() {
        WeakReference<ExternalAudioModuleCallback> weakReference = this.mCallback;
        if (weakReference == null) {
            return null;
        }
        return (ExternalAudioModuleCallback) weakReference.get();
    }

    private void buildAudioStatistics(String str, long j, ExternalAudioModule.AudioStatistics audioStatistics) {
        User user;
        RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(str);
        if (userManager != null && (user = userManager.getUser(j)) != null) {
            audioStatistics.delayMs = user.ismTimestampTrusted() ? GetDelayMS(j) : 0;
        }
    }

    /* renamed from: com.wushuangtech.api.ExternalAudioModuleImpl$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$wushuangtech$expansion$api$Constants$AudioProfile;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.wushuangtech.expansion.api.Constants$AudioProfile[] r0 = com.wushuangtech.expansion.api.Constants.AudioProfile.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$wushuangtech$expansion$api$Constants$AudioProfile = r0
                com.wushuangtech.expansion.api.Constants$AudioProfile r1 = com.wushuangtech.expansion.api.Constants.AudioProfile.MUSIC_STANDARD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$wushuangtech$expansion$api$Constants$AudioProfile     // Catch:{ NoSuchFieldError -> 0x001d }
                com.wushuangtech.expansion.api.Constants$AudioProfile r1 = com.wushuangtech.expansion.api.Constants.AudioProfile.MUSIC_STANDARD_STEREO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$wushuangtech$expansion$api$Constants$AudioProfile     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.wushuangtech.expansion.api.Constants$AudioProfile r1 = com.wushuangtech.expansion.api.Constants.AudioProfile.MUSIC_HIGH_QUALITY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$wushuangtech$expansion$api$Constants$AudioProfile     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.wushuangtech.expansion.api.Constants$AudioProfile r1 = com.wushuangtech.expansion.api.Constants.AudioProfile.MUSIC_HIGH_QUALITY_STEREO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.ExternalAudioModuleImpl.AnonymousClass1.<clinit>():void");
        }
    }

    public void setAudioQualityProfile(Constants.AudioProfile audioProfile) {
        int i = AnonymousClass1.$SwitchMap$com$wushuangtech$expansion$api$Constants$AudioProfile[audioProfile.ordinal()];
        int i2 = 48;
        int i3 = 2;
        int i4 = 1;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    i2 = 96;
                } else if (i != 4) {
                    i2 = 32;
                    GlobalHolder.getInstance().getGlobalAudioConfig().setAudioEncodeParams(i3, i2, i4);
                } else {
                    i2 = io.agora.rtc.Constants.ERR_WATERMARK_ARGB;
                }
            }
            i4 = 2;
            i3 = 1;
            GlobalHolder.getInstance().getGlobalAudioConfig().setAudioEncodeParams(i3, i2, i4);
        }
        i3 = 1;
        GlobalHolder.getInstance().getGlobalAudioConfig().setAudioEncodeParams(i3, i2, i4);
    }
}
