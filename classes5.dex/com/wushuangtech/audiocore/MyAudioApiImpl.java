package com.wushuangtech.audiocore;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.eaydu.omni.core.voiceengine.RtcAudioDecision;
import com.eaydu.omni.core.voiceengine.RtcAudioStatus;
import com.eaydu.omni.core.voiceengine.WebRtcAudioManager;
import com.wushuangtech.api.AudioSender;
import com.wushuangtech.api.EnterConfApi;
import com.wushuangtech.api.EnterConfApiImpl;
import com.wushuangtech.api.ExternalAudioModule;
import com.wushuangtech.audiocore.bean.AudioMixModeBean;
import com.wushuangtech.audiocore.bean.AudioStuckBean;
import com.wushuangtech.audiocore.callback.AudioFileMixCallback;
import com.wushuangtech.audiocore.callback.ExternalAudioProcessCallback;
import com.wushuangtech.audiocore.utils.AssertUtils;
import com.wushuangtech.bean.CommonEventBean;
import com.wushuangtech.bean.EfficiencyStatisticsBean;
import com.wushuangtech.broadcast.HeadSetReceiver;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.constants.RtcGlobalServerMessage;
import com.wushuangtech.library.DelayExecuteController;
import com.wushuangtech.library.GlobalAudioConfig;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.User;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.utils.PhoneUtils;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyAudioApiImpl extends MyAudioApi {
    public static final double AUDIO_FILE_DEFAULT_VALUE = 0.5d;
    public static final float AUDIO_FILE_VOLUME_MAX_VAULE = 1.0f;
    private static final int MYAUDIO_AGC_ADAPTIVEANALOG = 0;
    private static final int MYAUDIO_AGC_ADAPTIVEDIGITAL = 1;
    private static final int MYAUDIO_AGC_DEFAULT = 1;
    private static final int MYAUDIO_AGC_FIXEDDIGITAL = 2;
    private static final int MYAUDIO_AGC_MODE_UNCHANGED = 0;
    private static final int MYAUDIO_AUDIO_CALLBACK_STUCK = 113;
    private static final int MYAUDIO_AUDIO_CLEAR_RESOURCE = 50;
    private static final int MYAUDIO_AUDIO_EARBACK_VOL = 21;
    private static final int MYAUDIO_AUDIO_FILE_FINISHED = 112;
    private static final int MYAUDIO_AUDIO_FILE_PAUSE = 104;
    private static final int MYAUDIO_AUDIO_FILE_PAUSE_ALL_EFFECT = 109;
    private static final int MYAUDIO_AUDIO_FILE_PITCH = 103;
    private static final int MYAUDIO_AUDIO_FILE_PLAY = 101;
    private static final int MYAUDIO_AUDIO_FILE_RESUME = 105;
    private static final int MYAUDIO_AUDIO_FILE_RESUME_ALL_EFFECT = 110;
    private static final int MYAUDIO_AUDIO_FILE_SEEK = 107;
    private static final int MYAUDIO_AUDIO_FILE_STOP = 102;
    private static final int MYAUDIO_AUDIO_FILE_STOP_ALL_EFFECT = 108;
    private static final int MYAUDIO_AUDIO_LOCAL_STATE_CHANGED = 300;
    private static final int MYAUDIO_AUDIO_MIX_MODE = 28;
    private static final int MYAUDIO_CHANGE_WEBRTC_VERSION = 24;
    private static final int MYAUDIO_EABLE_EARBACK = 16;
    private static final int MYAUDIO_INITIALIZE = 0;
    private static final int MYAUDIO_MUTE_LOCAL = 26;
    private static final int MYAUDIO_MUTE_REMOTE = 27;
    private static final int MYAUDIO_PAUSE = 5;
    private static final int MYAUDIO_PAUSE_RECORD = 9;
    private static final int MYAUDIO_REMOET_AND_LOCAL_MIX = 22;
    private static final int MYAUDIO_RESET_SEND_NACKLIST = 12;
    private static final int MYAUDIO_RESTARTPLAYBACK = 11;
    private static final int MYAUDIO_RESTARTP_RECORD = 13;
    private static final int MYAUDIO_RESUME = 6;
    private static final int MYAUDIO_RESUME_RECORD = 10;
    private static final int MYAUDIO_SET_DELAY_OFFSET = 8;
    private static final int MYAUDIO_SET_FORCE_USE_OPENSL = 19;
    private static final int MYAUDIO_SET_HEADSET_STATUS = 7;
    private static final int MYAUDIO_SET_SEND_CODEC = 18;
    private static final int MYAUDIO_START_CAPTURE = 1;
    private static final int MYAUDIO_START_PLAY = 3;
    private static final int MYAUDIO_START_PLAYMIX = 42;
    private static final int MYAUDIO_START_RECORDMIX = 40;
    private static final int MYAUDIO_STOP_CAPTURE = 2;
    private static final int MYAUDIO_STOP_PLAY = 4;
    private static final int MYAUDIO_STOP_PLAYMIX = 43;
    private static final int MYAUDIO_STOP_RECORDMIX = 41;
    private static final int MYAUDIO_USE_EXT_PCM = 25;
    private static final int MYAUDIO_USE_HIGH_QUALITY_AUDIO = 17;
    private static final int RESERVED_ID_FOR_FILE_PLAY = -1;
    private static final String TAG = "MyAudioApi";
    private final ExternalAudioModule.AecDelayMetrics aec_delay_metrics = new ExternalAudioModule.AecDelayMetrics();
    boolean enable_audio_effect = false;
    private final ExternalAudioModule.AecParams mAecParam = new ExternalAudioModule.AecParams();
    /* access modifiers changed from: private */
    public volatile boolean mAudioCaptured;
    private final Object mAudioCapturedLock = new Object();
    private AudioDataWriter mAudioDataWriter;
    private final Object mAudioDataWriterLock = new Object();
    private final AudioEventHandler mAudioEventHandler = new AudioEventHandler();
    private WeakReference<AudioFileMixCallback> mAudioFileMixCallback;
    private final List<WeakReference<AudioSender>> mAudioSenders = new ArrayList();
    private DelayExecuteController<Double> mAudioVolumeController;
    private Context mContext;
    private int mExternalAudioId;
    private final Object mExternalAudioLock = new Object();
    private int mLastExternalAudioChannel;
    private int mLastExternalAudioSampleRate;
    private int mLocalAudioChannel = 1;
    private int mLocalAudioMode = 0;
    private int mLocalAudioPerCall = 1920;
    private int mLocalAudioSampleRate = 48000;
    private final ExternalAudioModule.LocalAudioStatistics mLocalAudioStatistics = new ExternalAudioModule.LocalAudioStatistics();
    private int mMixAudioChannel = 1;
    private int mMixAudioPerCall = 1920;
    private int mMixAudioSampleRate = 48000;
    private boolean mMixEnabled;
    private final List<AudioMixModeBean> mMixUidList = new ArrayList();
    private boolean mPlayMixEnabled;
    private WeakReference<ExternalAudioProcessCallback> mProcessCallback;
    private final EfficiencyStatisticsBean mProcessLocalDataBean = new EfficiencyStatisticsBean();
    private final EfficiencyStatisticsBean mProcessMixDataBean = new EfficiencyStatisticsBean();
    private final EfficiencyStatisticsBean mProcessRemoteDataBean = new EfficiencyStatisticsBean();
    private boolean mRecordMixEnabled;
    private int mRemoteAudioChannel = 1;
    private int mRemoteAudioPerCall = 1920;
    private int mRemoteAudioSampleRate = 48000;
    private final LongSparseArray<ExternalAudioModule.AudioStatistics> mRemoteAudioStatistics = new LongSparseArray<>();
    private boolean mReportAudioCapFailed;
    /* access modifiers changed from: private */
    public final ArrayList<Long> mSpeakers = new ArrayList<>();
    private ByteBuffer playBuffer = null;
    private ByteBuffer recordAndPlayMixBuffer = null;
    private ByteBuffer recordBuffer = null;
    /* access modifiers changed from: private */
    public final Object speakers_lock_obj = new Object();
    private Handler threadHandler;
    private boolean voiceDetectionEnabled = false;

    private native void AdjAllRemoteAudioVolumeScale(double d);

    private native void AdjRemoteAudioVolumeScale(long j, double d);

    private native void AdjSpeakerVolumeScale(double d);

    private native void AdjustMicVolumeScale(double d);

    private native double AllRemoteAudioVolumeScale();

    private native boolean AudioFileMixing();

    /* access modifiers changed from: private */
    public native void DealPlayFileFinished();

    private native void EnableAecDelayAgnostic(boolean z);

    /* access modifiers changed from: private */
    public native void EnableEarBack(boolean z);

    private native void EnableLowerAudioLatency(boolean z);

    private native void EnableNewDenoise(boolean z);

    private native void EnablePlayMix(boolean z, int i, int i2, int i3);

    private native void EnableRecordMix(boolean z, int i, int i2, int i3);

    private native void EnableRemoteAndLocalMix(boolean z, ByteBuffer byteBuffer, int i, int i2, int i3);

    private native void EnableVoiceDetection(boolean z);

    private native int ExtPcmCreate(boolean z, boolean z2, boolean z3, int i);

    private native int ExtPcmPush(int i, byte[] bArr, int i2, int i3, int i4, int i5, long j);

    private native void ExtPcmRelease(int i);

    private native void ForceVoipRecord16k(boolean z);

    private native boolean GetAecStats();

    private native int GetAudioErrorTimes();

    private native int GetDynamicBitrate();

    private native void GetEcDelayMetrics();

    private native double GetEffectVolumeScale();

    private native int GetEncodeDataSize();

    private native void GetLocalAudioStatistics();

    private native int GetPcmDataSize();

    private native int GetRecvBytes(long j);

    private native void GetRemoteAudioStatistics();

    private native double GetTrackVolumeScale(int i);

    private native boolean HasVoice();

    private native boolean Initialize(MyAudioApiImpl myAudioApiImpl, Context context);

    private native int IsLocalMute();

    private native boolean IsNewDenoiseEnabled();

    private native double MicVolumeScale();

    private native void MuteDataSending(boolean z);

    private native int MuteLocal(boolean z);

    private native void MuteRemote(long j, boolean z);

    private native void NativeCachDirectBufferAddress(ByteBuffer byteBuffer, ByteBuffer byteBuffer2);

    private void OnReportDurationMs(int i, int i2) {
    }

    /* access modifiers changed from: private */
    public native void PauseAllEffect();

    /* access modifiers changed from: private */
    public native boolean PauseAudio();

    /* access modifiers changed from: private */
    public native void PauseAudioFileMix(int i);

    /* access modifiers changed from: private */
    public native void PauseRecordOnly(boolean z);

    private native double RemoteAudioVolumeScale(long j);

    private native void ResetSendNackList();

    /* access modifiers changed from: private */
    public native int RestartPlayUseVoip(boolean z);

    /* access modifiers changed from: private */
    public native void ResumeAllEffect();

    /* access modifiers changed from: private */
    public native boolean ResumeAudio();

    /* access modifiers changed from: private */
    public native void ResumeAudioFileMix(int i);

    /* access modifiers changed from: private */
    public native void SeekAudioFileTo(int i, int i2);

    private native void SetAecStatus(boolean z, int i);

    /* access modifiers changed from: private */
    public native void SetAgcConfig(int i, int i2, boolean z);

    private native void SetAgcStatus(boolean z, int i);

    private native void SetAllEffectVolumeScale(double d);

    /* access modifiers changed from: private */
    public native void SetAudioEngineMode(int i);

    private native void SetBuiltInAecStatus(boolean z);

    /* access modifiers changed from: private */
    public native void SetDelayOffsetMS(int i);

    /* access modifiers changed from: private */
    public native void SetEarbackVolume(float f);

    private native void SetExpandCartonParams(int i, int i2);

    private native void SetForceUseOpensl(boolean z);

    /* access modifiers changed from: private */
    public native void SetHeadSetPlugStatus(boolean z);

    private native void SetLocalSsrc(int i);

    private native void SetNsStatus(boolean z, int i);

    /* access modifiers changed from: private */
    public native void SetPitchSemiTones(int i, double d);

    private native void SetSendCodec(int i, int i2, int i3, boolean z);

    /* access modifiers changed from: private */
    public native void SetTrackVolumeScale(int i, double d);

    private native void SetUseVoipAll(boolean z);

    private native double SpeakerVolumeScale();

    private native boolean StartAudioFileMixing(int i, String str, int i2, boolean z, int i3, double d);

    /* access modifiers changed from: private */
    public native boolean StartCapture();

    /* access modifiers changed from: private */
    public native boolean StartPlay(long j);

    /* access modifiers changed from: private */
    public native void StopAllEffect();

    private native boolean StopAudioFileMixing(int i);

    /* access modifiers changed from: private */
    public native boolean StopCapture();

    private native boolean StopPlay(long j);

    /* access modifiers changed from: private */
    public native void UseExtPcm(boolean z, boolean z2);

    /* access modifiers changed from: private */
    public native void UseHighQualityAudio(boolean z);

    private native void nativeEnableLowComplexityMode(int i);

    public native void EnableAec3(boolean z);

    public native void EnableLocalVadIndication(boolean z);

    public native void EnableRemoteVadIndication(boolean z);

    public native int GetAudioEngineMode();

    public native int GetLocalAudioVadLevel(long j, long j2);

    public native int GetRemoteAudioVadLevel(long j, long j2);

    public native void PullPlayoutData(byte[] bArr, int i, int i2);

    public native void PushRecordData(byte[] bArr, int i, int i2);

    public native void SetAudioFolder(String str);

    public native void SetPlayoutTrackVolumeScale(int i, double d);

    public native void SetPublishTrackVolumeScale(int i, double d);

    public native void SetRecvStreamMixedVolume(int i);

    public int getAudioVadLevel(String str, long j) {
        return 0;
    }

    MyAudioApiImpl(Context context) {
        this.mContext = context;
        mAudioApi = this;
        HandlerThread handlerThread = new HandlerThread("myaudioapi");
        handlerThread.start();
        AnonymousClass1 r1 = new Handler(handlerThread.getLooper()) {
            public void handleMessage(Message message) {
                AsynchronousInstrumentation.handlerMessageBegin(this, message);
                super.handleMessage(message);
                int i = message.what;
                boolean z = false;
                if (i == 13) {
                    if (RtcAudioStatus.setRecServerForceDisableUseVoip(message.arg1 != 1) && !RtcAudioStatus.forceVoipRecord16k) {
                        MyAudioApiImpl.this.PauseRecordOnly(true);
                        MyAudioApiImpl.this.PauseRecordOnly(false);
                    }
                } else if (i == 50) {
                    MyAudioApiImpl.this.handleClearResource();
                } else if (i == 300) {
                    int i2 = message.arg1;
                    int i3 = message.arg2;
                    if (i2 != 1 || MyAudioApiImpl.this.mAudioCaptured) {
                        GlobalHolder.getInstance().sendRtcEngineEvent(93, Integer.valueOf(i2), Integer.valueOf(i3));
                    } else {
                        OmniLog.w(MyAudioApiImpl.TAG, "Audio capture already closed...");
                        AsynchronousInstrumentation.handlerMessageEnd();
                    }
                } else if (i == 16) {
                    MyAudioApiImpl myAudioApiImpl = MyAudioApiImpl.this;
                    if (message.arg1 == 1) {
                        z = true;
                    }
                    myAudioApiImpl.EnableEarBack(z);
                } else if (i == 17) {
                    MyAudioApiImpl myAudioApiImpl2 = MyAudioApiImpl.this;
                    if (message.arg1 == 1) {
                        z = true;
                    }
                    myAudioApiImpl2.UseHighQualityAudio(z);
                } else if (i == 21) {
                    MyAudioApiImpl.this.SetEarbackVolume(((Float) message.obj).floatValue());
                } else if (i == 22) {
                    MyAudioApiImpl.this.handleMixStatus(message);
                } else if (i == 112) {
                    MyAudioApiImpl.this.DealPlayFileFinished();
                } else if (i != 113) {
                    switch (i) {
                        case 0:
                            MyAudioApiImpl.this.handleInitialize();
                            break;
                        case 1:
                            OmniLog.i(OmniLog.AUDIO_WATCH, MyAudioApiImpl.TAG, "Finally recv start audio capture, state = " + MyAudioApiImpl.this.mAudioCaptured);
                            if (!MyAudioApiImpl.this.mAudioCaptured) {
                                RtcAudioStatus.setCapDataSizeInBytes(0);
                                MyAudioApiImpl.this.SetAgcConfig(3, 9, true);
                                MyAudioApiImpl.this.EnableAec3(true);
                                if (!MyAudioApiImpl.this.StartCapture()) {
                                    GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_ON_ERROR, 1005);
                                }
                                boolean unused = MyAudioApiImpl.this.mAudioCaptured = true;
                                break;
                            } else {
                                AsynchronousInstrumentation.handlerMessageEnd();
                                return;
                            }
                        case 2:
                            OmniLog.i(OmniLog.AUDIO_WATCH, MyAudioApiImpl.TAG, "Finally recv stop audio capture, state = " + MyAudioApiImpl.this.mAudioCaptured);
                            if (MyAudioApiImpl.this.mAudioCaptured) {
                                boolean unused2 = MyAudioApiImpl.this.mAudioCaptured = false;
                                boolean unused3 = MyAudioApiImpl.this.StopCapture();
                                GlobalHolder.getInstance().sendRtcEngineEvent(93, 0, 0);
                                GlobalAudioConfig globalAudioConfig = GlobalHolder.getInstance().getGlobalAudioConfig();
                                if (globalAudioConfig != null) {
                                    globalAudioConfig.setAudioLocalFirstEncodedNotifyed(false);
                                    break;
                                }
                            } else {
                                AsynchronousInstrumentation.handlerMessageEnd();
                                return;
                            }
                            break;
                        case 3:
                            OmniLog.d("MyAudioApi -> StartPlay invoked!");
                            if (!MyAudioApiImpl.this.StartPlay(((Long) message.obj).longValue())) {
                                ((EnterConfApiImpl) EnterConfApi.getInstance()).reportAudioPlayError();
                                GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_ON_ERROR, 1005);
                            }
                            synchronized (MyAudioApiImpl.this.speakers_lock_obj) {
                                try {
                                    if (!MyAudioApiImpl.this.mSpeakers.contains(message.obj)) {
                                        MyAudioApiImpl.this.mSpeakers.add((Long) message.obj);
                                    }
                                } finally {
                                    AsynchronousInstrumentation.handlerMessageEnd();
                                }
                            }
                            break;
                        case 4:
                            MyAudioApiImpl.this.stopPlayInternal(message);
                            break;
                        case 5:
                            if (!MyAudioApiImpl.this.PauseAudio()) {
                                GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_ON_ERROR, 1005);
                                break;
                            }
                            break;
                        case 6:
                            if (!MyAudioApiImpl.this.ResumeAudio()) {
                                GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_ON_ERROR, 1005);
                                break;
                            }
                            break;
                        case 7:
                            boolean headsetOn = RtcAudioStatus.setHeadsetOn(message.arg1 == 1);
                            MyAudioApiImpl.this.SetHeadSetPlugStatus(message.arg1 == 1);
                            try {
                                boolean playStreamTypeUsingVoip = RtcAudioDecision.getInstance(RtcAudioDecision.DecisionType.Momo).playStreamTypeUsingVoip();
                                MyAudioApiImpl.this.updateAudioStatus(playStreamTypeUsingVoip, true);
                                int unused4 = MyAudioApiImpl.this.RestartPlayUseVoip(playStreamTypeUsingVoip);
                            } catch (Exception unused5) {
                                OmniLog.e(MyAudioApiImpl.TAG, "updateAudioStatus error");
                            }
                            if (headsetOn && !RtcAudioStatus.forceVoipRecord16k) {
                                MyAudioApiImpl.this.PauseRecordOnly(true);
                                MyAudioApiImpl.this.PauseRecordOnly(false);
                                break;
                            }
                        case 8:
                            MyAudioApiImpl.this.SetDelayOffsetMS(message.arg1);
                            break;
                        case 9:
                            MyAudioApiImpl.this.PauseRecordOnly(true);
                            break;
                        case 10:
                            MyAudioApiImpl.this.PauseRecordOnly(false);
                            break;
                        case 11:
                            int i4 = message.arg1;
                            if (RtcAudioStatus.mCurrentPlayMode != i4) {
                                RtcAudioStatus.mCurrentPlayMode = i4;
                                if (RtcAudioStatus.forcePlayMode) {
                                    i4 = RtcAudioStatus.forcePlayModeVoip;
                                }
                                if (i4 == 1) {
                                    z = true;
                                }
                                RtcAudioStatus.setPlayUseVoip(z);
                                boolean playStreamTypeUsingVoip2 = RtcAudioDecision.getInstance(RtcAudioDecision.DecisionType.Momo).playStreamTypeUsingVoip();
                                MyAudioApiImpl.this.updateAudioStatus(playStreamTypeUsingVoip2, true);
                                int unused6 = MyAudioApiImpl.this.RestartPlayUseVoip(playStreamTypeUsingVoip2);
                                OmniLog.aw_d(MyAudioApiImpl.TAG, "Adjust voip : " + playStreamTypeUsingVoip2);
                                break;
                            } else {
                                AsynchronousInstrumentation.handlerMessageEnd();
                                return;
                            }
                        default:
                            switch (i) {
                                case 24:
                                    MyAudioApiImpl.this.SetAudioEngineMode(message.arg1);
                                    break;
                                case 25:
                                    MyAudioApiImpl myAudioApiImpl3 = MyAudioApiImpl.this;
                                    boolean z2 = message.arg1 == 1;
                                    if (message.arg2 == 1) {
                                        z = true;
                                    }
                                    myAudioApiImpl3.UseExtPcm(z2, z);
                                    break;
                                case 26:
                                    MyAudioApiImpl.this.handleMuteLocalAudio(message);
                                    break;
                                case 27:
                                    MyAudioApiImpl.this.handleMuteRemoteAudio(message);
                                    break;
                                case 28:
                                    MyAudioApiImpl.this.setAudioMixModeInternal(message);
                                    break;
                                default:
                                    switch (i) {
                                        case 40:
                                            MyAudioApiImpl.this.handleRecordMixStatus(true);
                                            break;
                                        case 41:
                                            MyAudioApiImpl.this.handleRecordMixStatus(false);
                                            break;
                                        case 42:
                                            MyAudioApiImpl.this.handlePlayMixStatus(true);
                                            break;
                                        case 43:
                                            MyAudioApiImpl.this.handlePlayMixStatus(false);
                                            break;
                                        default:
                                            switch (i) {
                                                case 101:
                                                    MyAudioApiImpl.this.handleAudioFilePlay(true, message);
                                                    break;
                                                case 102:
                                                    MyAudioApiImpl.this.handleAudioFilePlay(false, message);
                                                    break;
                                                case 103:
                                                    MyAudioApiImpl.this.SetPitchSemiTones(message.arg1, (double) message.arg2);
                                                    break;
                                                case 104:
                                                    MyAudioApiImpl.this.PauseAudioFileMix(message.arg1);
                                                    break;
                                                case 105:
                                                    MyAudioApiImpl.this.ResumeAudioFileMix(message.arg1);
                                                    break;
                                                default:
                                                    switch (i) {
                                                        case 107:
                                                            MyAudioApiImpl.this.SeekAudioFileTo(message.arg1, message.arg2);
                                                            break;
                                                        case 108:
                                                            MyAudioApiImpl.this.StopAllEffect();
                                                            break;
                                                        case 109:
                                                            MyAudioApiImpl.this.PauseAllEffect();
                                                            break;
                                                        case 110:
                                                            MyAudioApiImpl.this.ResumeAllEffect();
                                                            break;
                                                    }
                                            }
                                    }
                            }
                    }
                } else {
                    MyAudioApiImpl.this.handleAudioStuck((AudioStuckBean) message.obj);
                }
            }
        };
        this.threadHandler = r1;
        if (!(r1 instanceof Handler)) {
            r1.sendEmptyMessage(0);
        } else {
            AsynchronousInstrumentation.sendEmptyMessage(r1, 0);
        }
    }

    public void setExternalAudioProcessCallback(ExternalAudioProcessCallback externalAudioProcessCallback) {
        OmniLog.printFunInvoked("setExternalAudioProcessCallback", externalAudioProcessCallback);
        this.mProcessCallback = new WeakReference<>(externalAudioProcessCallback);
    }

    public void addAudioSender(AudioSender audioSender) {
        boolean z = true;
        OmniLog.printFunInvoked("addAudioSender", audioSender);
        Iterator<WeakReference<AudioSender>> it = this.mAudioSenders.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().get() == audioSender) {
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            this.mAudioSenders.add(new WeakReference(audioSender));
        }
    }

    public void removeAudioSender(AudioSender audioSender) {
        OmniLog.printFunInvoked("removeAudioSender", audioSender);
        for (WeakReference next : this.mAudioSenders) {
            if (next.get() == audioSender) {
                this.mAudioSenders.remove(next);
                return;
            }
        }
    }

    public boolean pauseAudio() {
        OmniLog.printFunInvoked("pauseAudio", new Object[0]);
        Handler handler = this.threadHandler;
        return !(handler instanceof Handler) ? handler.sendEmptyMessage(5) : AsynchronousInstrumentation.sendEmptyMessage(handler, 5);
    }

    public boolean resumeAudio() {
        OmniLog.printFunInvoked("resumeAudio", new Object[0]);
        Handler handler = this.threadHandler;
        return !(handler instanceof Handler) ? handler.sendEmptyMessage(6) : AsynchronousInstrumentation.sendEmptyMessage(handler, 6);
    }

    public void enableEarsBack(boolean z) {
        OmniLog.printFunInvoked("enableEarsBack", Boolean.valueOf(z));
        Message obtain = Message.obtain();
        obtain.what = 16;
        obtain.arg1 = z ? 1 : 0;
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtain);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, obtain);
        }
    }

    public void useHighQualityAudio(boolean z) {
        OmniLog.printFunInvoked("useHighQualityAudio", Boolean.valueOf(z));
        Message message = new Message();
        message.what = 17;
        message.arg1 = z ? 1 : 0;
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(message);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, message);
        }
    }

    public int getDynamicBitrate() {
        OmniLog.printFunInvoked("getDynamicBitrate", new Object[0]);
        return GetDynamicBitrate();
    }

    public void setAudioFileMixCallback(AudioFileMixCallback audioFileMixCallback) {
        OmniLog.printFunInvoked("setAudioFileMixCallback", audioFileMixCallback);
        this.mAudioFileMixCallback = new WeakReference<>(audioFileMixCallback);
    }

    public boolean startAudioFileMixingForAssert(String str, boolean z, int i) {
        OmniLog.printFunInvoked("startAudioFileMixingForAssert", str, Boolean.valueOf(z), Integer.valueOf(i));
        if (TextUtils.isEmpty(AssertUtils.transformToFile(this.mContext, str)) || !startAudioFileMixing(str, z, i)) {
            return false;
        }
        return true;
    }

    public boolean startAudioFileMixing(String str, boolean z, int i) {
        OmniLog.printFunInvoked("startAudioFileMixing", str, Boolean.valueOf(z), Integer.valueOf(i));
        return playEffect(-1, str, i, 1.0d, 0.0d, z);
    }

    public void stopAudioFileMixing() {
        OmniLog.printFunInvoked("stopAudioFileMixing", new Object[0]);
        stopEffect(-1);
    }

    public void setAudioMixingPitch(int i) {
        OmniLog.printFunInvoked("setAudioMixingPitch", Integer.valueOf(i));
        Message message = new Message();
        message.what = 103;
        message.arg1 = -1;
        message.arg2 = i;
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(message);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, message);
        }
    }

    public void pauseAudioFileMix() {
        OmniLog.printFunInvoked("pauseAudioFileMix", new Object[0]);
        pauseEffect(-1);
    }

    public void resumeAudioFileMix() {
        OmniLog.printFunInvoked("resumeAudioFileMix", new Object[0]);
        resumeEffect(-1);
    }

    public void seekAudioFileTo(int i) {
        OmniLog.printFunInvoked("seekAudioFileTo", Integer.valueOf(i));
        Message message = new Message();
        message.what = 107;
        message.arg1 = -1;
        message.arg2 = i;
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(message);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, message);
        }
    }

    public float audioFileVolumeScale() {
        return (float) GetTrackVolumeScale(-1);
    }

    public float audioSoloVolumeScale() {
        return (float) MicVolumeScale();
    }

    public float remoteVolumeScale(long j) {
        return (float) RemoteAudioVolumeScale(j);
    }

    public float speakerVolumeScale() {
        OmniLog.printFunInvoked("speakerVolumeScale", new Object[0]);
        return (float) SpeakerVolumeScale();
    }

    public boolean audioFileMixing() {
        return AudioFileMixing();
    }

    public boolean playEffectForAsset(int i, String str, int i2, double d, double d2, boolean z) {
        String str2 = str;
        OmniLog.printFunInvoked("playEffectForAsset", Integer.valueOf(i), str2, Integer.valueOf(i2), Double.valueOf(d), Double.valueOf(d2), Boolean.valueOf(z));
        String transformToFile = AssertUtils.transformToFile(this.mContext, str2);
        if (TextUtils.isEmpty(transformToFile) || !playEffect(i, transformToFile, i2, d, d2, z)) {
            return false;
        }
        return true;
    }

    public boolean playEffect(int i, String str, int i2, double d, double d2, boolean z) {
        OmniLog.printFunInvoked("playEffect", Integer.valueOf(i), str, Integer.valueOf(i2), Double.valueOf(d), Double.valueOf(d2), Boolean.valueOf(z));
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Message message = new Message();
        message.what = 101;
        Bundle bundle = new Bundle();
        bundle.putInt("id", i);
        bundle.putString("fileName", str);
        bundle.putBoolean("loopback", z);
        bundle.putInt("loopTimes", i2);
        bundle.putDouble("pitch", d);
        message.setData(bundle);
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(message);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, message);
        }
        return true;
    }

    public void stopEffect(int i) {
        OmniLog.printFunInvoked("stopEffect", Integer.valueOf(i));
        Message obtain = Message.obtain();
        obtain.what = 102;
        obtain.arg1 = i;
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtain);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, obtain);
        }
    }

    public void stopAllEffect() {
        OmniLog.printFunInvoked("stopAllEffect", new Object[0]);
        Message obtain = Message.obtain();
        obtain.what = 108;
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtain);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, obtain);
        }
    }

    public void pauseEffect(int i) {
        OmniLog.printFunInvoked("pauseEffect", Integer.valueOf(i));
        Message obtain = Message.obtain();
        obtain.what = 104;
        obtain.arg1 = i;
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtain);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, obtain);
        }
    }

    public void pauseAllEffect() {
        OmniLog.printFunInvoked("pauseAllEffect", new Object[0]);
        Message obtain = Message.obtain();
        obtain.what = 109;
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtain);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, obtain);
        }
    }

    public void resumeEffect(int i) {
        OmniLog.printFunInvoked("resumeEffect", Integer.valueOf(i));
        Message obtain = Message.obtain();
        obtain.what = 105;
        obtain.arg1 = i;
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtain);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, obtain);
        }
    }

    public void resumeAllEffect() {
        OmniLog.printFunInvoked("resumeAllEffect", new Object[0]);
        Message obtain = Message.obtain();
        obtain.what = 110;
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtain);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, obtain);
        }
    }

    public void setVolumeOfEffect(int i, double d) {
        OmniLog.printFunInvoked("setVolumeOfEffect", Integer.valueOf(i), Double.valueOf(d));
        if (d < 0.0d) {
            d = 0.0d;
        }
        SetTrackVolumeScale(i, d);
    }

    public void setEffectsVolume(double d) {
        OmniLog.printFunInvoked("setEffectsVolume", Double.valueOf(d));
        if (d < 0.0d) {
            d = 0.0d;
        }
        if (d > 1.0d) {
            d = 1.0d;
        }
        SetAllEffectVolumeScale(d);
    }

    public double getVolumeOfEffect(int i) {
        OmniLog.printFunInvoked("getVolumeOfEffect", Integer.valueOf(i));
        return GetTrackVolumeScale(i);
    }

    public double getEffectsVolume() {
        OmniLog.printFunInvoked("getEffectsVolume", new Object[0]);
        return GetEffectVolumeScale();
    }

    public void adjustAudioFileVolumeScale(double d) {
        if (d < 0.0d) {
            d = 0.0d;
        }
        if (d > 1.0d) {
            d = 1.0d;
        }
        this.mAudioVolumeController.invoked(Double.valueOf(d));
    }

    public void adjustAudioFilePlayoutTrackVol(double d) {
        if (d < 0.0d) {
            d = 0.0d;
        }
        if (d > 1.0d) {
            d = 1.0d;
        }
        SetPlayoutTrackVolumeScale(-1, d);
    }

    public void adjustAudioFilePublishTrackVol(double d) {
        if (d < 0.0d) {
            d = 0.0d;
        }
        if (d > 1.0d) {
            d = 1.0d;
        }
        SetPublishTrackVolumeScale(-1, d);
    }

    public void adjustAudioSoloVolumeScale(double d) {
        if (d < 0.0d) {
            d = 0.0d;
        }
        if (d > 5.0d) {
            d = 5.0d;
        }
        AdjustMicVolumeScale(d);
    }

    public void adjustPlaybackSignalVolume(double d) {
        if (d <= 0.0d) {
            d = 0.0d;
        }
        if (d > 4.0d) {
            d = 4.0d;
        }
        AdjAllRemoteAudioVolumeScale(d);
    }

    public void adjustPlaybackSignalVolumeForChannel(long j, double d) {
        if (d <= 0.0d) {
            d = 0.0d;
        }
        if (d > 4.0d) {
            d = 4.0d;
        }
        executingAdjustPlaybackSignalVolume(String.valueOf(j), d);
    }

    public void adjustPlaybackSignalVolume(long j, double d) {
        if (d <= 0.0d) {
            d = 0.0d;
        }
        if (d > 4.0d) {
            d = 4.0d;
        }
        AdjRemoteAudioVolumeScale(j, d);
    }

    public int setRecordMixParameters(int i, int i2, int i3, int i4) {
        if (i != 8000 && i != 16000 && i != 32000 && i != 44100 && i != 48000) {
            return -5;
        }
        if (i2 != 1 && i2 != 2) {
            return -5;
        }
        if ((i3 != 0 && i3 != 1 && i3 != 2) || i4 <= 0) {
            return -5;
        }
        this.mLocalAudioSampleRate = i;
        this.mLocalAudioChannel = i2;
        this.mLocalAudioPerCall = i4;
        this.mLocalAudioMode = i3;
        if (!this.mRecordMixEnabled) {
            return 0;
        }
        stopRecordMix();
        startRecordMix();
        return 0;
    }

    public int startRecordMix() {
        OmniLog.printFunInvoked("startRecordMix", new Object[0]);
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendEmptyMessage(40);
        } else {
            AsynchronousInstrumentation.sendEmptyMessage(handler, 40);
        }
        return 0;
    }

    public void stopRecordMix() {
        OmniLog.printFunInvoked("stopRecordMix", new Object[0]);
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendEmptyMessage(41);
        } else {
            AsynchronousInstrumentation.sendEmptyMessage(handler, 41);
        }
    }

    public void setPlayMixParamatars(int i, int i2, int i3) {
        this.mRemoteAudioSampleRate = i;
        this.mRemoteAudioChannel = i2;
        this.mRemoteAudioPerCall = i3;
        if (this.mPlayMixEnabled) {
            stopPlayMix();
            startPlayMix();
        }
    }

    public int startPlayMix() {
        OmniLog.printFunInvoked("startPlayMix", Integer.valueOf(this.mRemoteAudioPerCall), Integer.valueOf(this.mRemoteAudioSampleRate), Integer.valueOf(this.mRemoteAudioChannel));
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendEmptyMessage(42);
        } else {
            AsynchronousInstrumentation.sendEmptyMessage(handler, 42);
        }
        return 0;
    }

    public void stopPlayMix() {
        OmniLog.printFunInvoked("stopPlayMix", new Object[0]);
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendEmptyMessage(43);
        } else {
            AsynchronousInstrumentation.sendEmptyMessage(handler, 43);
        }
    }

    public boolean playMixing() {
        return this.mPlayMixEnabled;
    }

    public int setRemoteAndLocalMixParamatars(int i, int i2, int i3) {
        this.mMixAudioSampleRate = i;
        this.mMixAudioChannel = i2;
        this.mMixAudioPerCall = i3;
        if (!this.mMixEnabled) {
            return 0;
        }
        stopRemoteAndLocalMix();
        startRemoteAndLocalMix();
        return 0;
    }

    public void startRemoteAndLocalMix() {
        OmniLog.printFunInvoked("startRemoteAndLocalMix", Integer.valueOf(this.mMixAudioSampleRate), Integer.valueOf(this.mMixAudioChannel), Integer.valueOf(this.mMixAudioPerCall));
        Message obtain = Message.obtain();
        obtain.what = 22;
        Bundle bundle = new Bundle();
        bundle.putBoolean("isBegin", true);
        bundle.putInt("samplerate", this.mMixAudioSampleRate);
        bundle.putInt("channel", this.mMixAudioChannel);
        bundle.putInt("bufSize", this.mMixAudioPerCall);
        obtain.setData(bundle);
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtain);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, obtain);
        }
    }

    public void stopRemoteAndLocalMix() {
        OmniLog.printFunInvoked("stopRemoteAndLocalMix", new Object[0]);
        Message obtain = Message.obtain();
        obtain.what = 22;
        Bundle bundle = new Bundle();
        bundle.putBoolean("isBegin", false);
        obtain.setData(bundle);
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtain);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, obtain);
        }
    }

    public void setExpandCartonParams(int i, int i2) {
        SetExpandCartonParams(i, i2);
    }

    public boolean startCapture() {
        synchronized (this.mAudioCapturedLock) {
            Handler handler = this.threadHandler;
            if (!(handler instanceof Handler)) {
                handler.sendEmptyMessage(1);
            } else {
                AsynchronousInstrumentation.sendEmptyMessage(handler, 1);
            }
        }
        return true;
    }

    public boolean stopCapture() {
        synchronized (this.mAudioCapturedLock) {
            Handler handler = this.threadHandler;
            if (!(handler instanceof Handler)) {
                handler.sendEmptyMessage(2);
            } else {
                AsynchronousInstrumentation.sendEmptyMessage(handler, 2);
            }
        }
        return true;
    }

    public boolean startPlay(long j) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = Long.valueOf(j);
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtain);
            return true;
        }
        AsynchronousInstrumentation.sendMessage(handler, obtain);
        return true;
    }

    public boolean stopPlay(long j) {
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = Long.valueOf(j);
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtain);
            return true;
        }
        AsynchronousInstrumentation.sendMessage(handler, obtain);
        return true;
    }

    public void setDelayoffset(int i, boolean z, boolean z2, boolean z3) {
        OmniLog.printFunInvoked("setDelayoffset", Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
        if (GlobalConfig.mBranch != LocalSDKConstants.BRANCH_CLIENT_QUANMIN) {
            RtcAudioStatus.setRecServerForceDisableBuiltInAec(!z2);
            Message obtain = Message.obtain();
            obtain.what = 8;
            if (RtcAudioStatus.forceVoipRecord16k) {
                i = 0;
            }
            obtain.arg1 = i;
            Handler handler = this.threadHandler;
            if (!(handler instanceof Handler)) {
                handler.sendMessage(obtain);
            } else {
                AsynchronousInstrumentation.sendMessage(handler, obtain);
            }
            Message obtain2 = Message.obtain();
            obtain2.what = 13;
            obtain2.arg1 = z3 ? 1 : 0;
            Handler handler2 = this.threadHandler;
            if (!(handler2 instanceof Handler)) {
                handler2.sendMessage(obtain2);
            } else {
                AsynchronousInstrumentation.sendMessage(handler2, obtain2);
            }
        }
    }

    public void setServerDevParam(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        if (GlobalConfig.mBranch != LocalSDKConstants.BRANCH_CLIENT_QUANMIN) {
            RtcAudioStatus.setRecServerForceDisableBuiltInAgc(!z3);
            RtcAudioStatus.setRecServerForceDisableBuiltInNs(!z4);
            WebRtcAudioManager.serverForceDisableLowlatency = !z6;
            setDelayoffset(i, z, z2, z5);
        }
    }

    public void setHeadsetStatus(boolean z) {
        OmniLog.printFunInvoked("setHeadsetStatus", Boolean.valueOf(z));
        Message obtain = Message.obtain();
        obtain.what = 7;
        obtain.arg1 = z ? 1 : 0;
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtain);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, obtain);
        }
    }

    public long getCaptureDataSize() {
        return RtcAudioStatus.capDataSizeInBytes();
    }

    public int getRecvBytes(long j) {
        return GetRecvBytes(j);
    }

    public int getSizeOfMuteAudioPlayed() {
        return GetAudioErrorTimes();
    }

    public int getEncodeDataSize() {
        return GetEncodeDataSize();
    }

    public ExternalAudioModule.AecParams getAecStats() {
        this.mAecParam.valid = GetAecStats();
        return this.mAecParam;
    }

    public void setSendCodec(int i, int i2, int i3, boolean z) {
        OmniLog.printFunInvoked("setSendCodec", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 <= 0) {
            i2 = 32000;
        }
        SetSendCodec(i, i2, i3, z);
    }

    public void pauseRecordOnly(boolean z) {
        if (z) {
            Handler handler = this.threadHandler;
            if (!(handler instanceof Handler)) {
                handler.sendEmptyMessage(9);
            } else {
                AsynchronousInstrumentation.sendEmptyMessage(handler, 9);
            }
        } else {
            Handler handler2 = this.threadHandler;
            if (!(handler2 instanceof Handler)) {
                handler2.sendEmptyMessage(10);
            } else {
                AsynchronousInstrumentation.sendEmptyMessage(handler2, 10);
            }
        }
    }

    public void muteLocal(boolean z) {
        Message obtain = Message.obtain();
        obtain.what = 26;
        obtain.obj = Boolean.valueOf(z);
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtain);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, obtain);
        }
    }

    public boolean isLocalMuted() {
        int IsLocalMute = IsLocalMute();
        if (IsLocalMute < 0) {
            ((EnterConfApiImpl) EnterConfApi.getInstance()).reportMuteLocalErr(IsLocalMute + 100);
        }
        return IsLocalMute == 1;
    }

    public void muteRemote(long j, boolean z) {
        Message obtain = Message.obtain();
        obtain.what = 27;
        Bundle bundle = new Bundle();
        bundle.putLong("uid", j);
        bundle.putBoolean("muted", z);
        obtain.setData(bundle);
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtain);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, obtain);
        }
    }

    public void muteDataSending(boolean z) {
        MuteDataSending(z);
    }

    public void enableLowerAudioLatency(boolean z) {
        EnableLowerAudioLatency(z);
    }

    public void adjSpeakerVolumeScale(float f) {
        AdjSpeakerVolumeScale((double) f);
    }

    public void replayUseVoip(boolean z) {
        Message obtain = Message.obtain();
        obtain.what = 11;
        obtain.arg1 = z ? 1 : 0;
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtain);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, obtain);
        }
    }

    public void resetSendNackList() {
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendEmptyMessage(12);
        } else {
            AsynchronousInstrumentation.sendEmptyMessage(handler, 12);
        }
    }

    public ArrayList<Long> getSpeakers() {
        ArrayList<Long> arrayList = new ArrayList<>();
        synchronized (this.speakers_lock_obj) {
            arrayList.addAll(this.mSpeakers);
        }
        return arrayList;
    }

    public boolean isCapturing() {
        return RtcAudioStatus.capturing();
    }

    public void setForceDisableBuiltInAec(boolean z) {
        RtcAudioStatus.setRecLocalForceDisableBuiltInAec(z);
    }

    public void setAecStatus(boolean z, int i) {
        SetAecStatus(z, i);
    }

    public void setAgcStatus(boolean z, int i) {
        SetAgcStatus(z, i);
    }

    public void setNsStatus(boolean z, int i) {
        SetNsStatus(z, i);
    }

    public void forceUseVoipAll(boolean z, boolean z2) {
        if (!z) {
            z2 = true;
        }
        RtcAudioStatus.setForceRecUseVoip(z2);
        SetUseVoipAll(z2);
    }

    public void forceVoipRecord16k(boolean z) {
        ForceVoipRecord16k(z);
        RtcAudioStatus.forceVoipRecord16k = z;
    }

    public void setForceUseOpensl(boolean z) {
        SetForceUseOpensl(z);
    }

    public boolean recordMixing() {
        return this.mRecordMixEnabled;
    }

    public ExternalAudioModule.LocalAudioStatistics getLocalAudioStatistics() {
        GetLocalAudioStatistics();
        return this.mLocalAudioStatistics;
    }

    public synchronized LongSparseArray<ExternalAudioModule.AudioStatistics> getRemoteAudioStatistics() {
        this.mRemoteAudioStatistics.clear();
        GetRemoteAudioStatistics();
        return this.mRemoteAudioStatistics.clone();
    }

    public void enableVoiceDetection(boolean z) {
        OmniLog.printFunInvoked("enableVoiceDetection", Boolean.valueOf(z));
        this.voiceDetectionEnabled = z;
        EnableVoiceDetection(z);
    }

    public boolean isVoiceDetectionEnabled() {
        return this.voiceDetectionEnabled;
    }

    public void enableAudioEffect(boolean z, int i) {
        this.enable_audio_effect = z;
        setRecordMixParameters(48000, 1, 0, 1920);
        startRecordMix();
        AudioEffect.getInstance().setup(48000, 1);
        AudioEffect.getInstance().chooseEffectType(i);
    }

    public ExternalAudioModule.AecDelayMetrics getAecDelayMetrics() {
        GetEcDelayMetrics();
        return this.aec_delay_metrics;
    }

    public void setLocalSsrc(int i) {
        SetLocalSsrc(i);
    }

    public boolean startSafetyCapture() {
        synchronized (this.mAudioCapturedLock) {
            Handler handler = this.threadHandler;
            if (!(handler instanceof Handler)) {
                handler.sendEmptyMessage(2);
            } else {
                AsynchronousInstrumentation.sendEmptyMessage(handler, 2);
            }
            Handler handler2 = this.threadHandler;
            if (!(handler2 instanceof Handler)) {
                handler2.sendEmptyMessage(1);
            } else {
                AsynchronousInstrumentation.sendEmptyMessage(handler2, 1);
            }
        }
        return true;
    }

    public void enableAudioVadIndication(boolean z, boolean z2) {
        EnableLocalVadIndication(z);
        EnableRemoteVadIndication(z2);
    }

    public void enableAudioPcmWriteFile(boolean z, String str) {
        synchronized (this.mAudioDataWriterLock) {
            if (!z) {
                AudioDataWriter audioDataWriter = this.mAudioDataWriter;
                if (audioDataWriter != null) {
                    audioDataWriter.clearResource();
                    this.mAudioDataWriter = null;
                }
            } else if (this.mAudioDataWriter == null) {
                this.mAudioDataWriter = new AudioDataWriter(str);
            }
        }
    }

    public Object sendAudioModuleEvent(CommonEventBean commonEventBean) {
        return this.mAudioEventHandler.recvExternalAudioModuleEvent(this, commonEventBean);
    }

    public int setRemoteVolumeAll(int i) {
        OmniLog.i(TAG, "setRemoteVolumeAll volume:" + i);
        SetRecvStreamMixedVolume(i);
        return 0;
    }

    public void initChannelResAfterJoined(String str) {
        if (GlobalConfig.mAudioLocalEnabled) {
            startCapture();
        }
    }

    public void leaveChannel(String str) {
        String str2 = GlobalConfig.mAVUploadChannelName;
        if (!TextUtils.isEmpty(str2) && str2.equals(str)) {
            handleEngineLeave();
        }
    }

    public void clearResource() {
        synchronized (this.mExternalAudioLock) {
            int i = this.mExternalAudioId;
            if (i != 0) {
                ExtPcmRelease(i);
                this.mExternalAudioId = 0;
            }
        }
        replayUseVoip(false);
        handleEngineLeave();
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendEmptyMessage(50);
        } else {
            AsynchronousInstrumentation.sendEmptyMessage(handler, 50);
        }
    }

    public void setAudioEngineMode(int i) {
        Message obtain = Message.obtain();
        obtain.what = 24;
        obtain.arg1 = i;
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtain);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, obtain);
        }
    }

    public void useExtPcm(boolean z, boolean z2) {
        Message obtain = Message.obtain();
        obtain.what = 25;
        obtain.arg1 = z ? 1 : 0;
        obtain.arg2 = z2 ? 1 : 0;
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtain);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, obtain);
        }
    }

    public void pushRecordPcm(byte[] bArr, int i, int i2) {
        PushRecordData(bArr, i, i2);
    }

    public void pullPlayoutData(byte[] bArr, int i, int i2) {
        PullPlayoutData(bArr, i, i2);
    }

    public void setAudioApplicationScene(int i) {
        boolean isEmu = PhoneUtils.isEmu();
        OmniLog.aw_d(TAG, "Set audio scene : " + i + " | emu : " + isEmu);
        if (i == 1) {
            setForceDisableBuiltInAec(false);
            setAgcStatus(true, 2);
            setNsStatus(true, 3);
            forceUseVoipAll(false, true);
            forceVoipRecord16k(false);
            setForceChangeAudioRouter(false, false);
        } else if (i == 2) {
            setAgcStatus(!isEmu, 1);
            setNsStatus(!isEmu, 3);
            setForceDisableBuiltInAec(false);
            forceVoipRecord16k(true);
            forceUseVoipAll(false, true);
            setForceChangeAudioRouter(false, true);
        } else if (i == 3) {
            setForceDisableBuiltInAec(true);
            setAgcStatus(false, 1);
            setNsStatus(false, 3);
            forceUseVoipAll(true, false);
            forceVoipRecord16k(false);
            setForceChangeAudioRouter(true, false);
        } else if (i != 4) {
            setForceDisableBuiltInAec(false);
            setAgcStatus(true, 2);
            setNsStatus(true, 3);
            forceUseVoipAll(false, false);
            forceVoipRecord16k(true);
            setForceChangeAudioRouter(false, false);
        } else {
            setForceUseOpensl(true);
            setForceDisableBuiltInAec(false);
            setAgcStatus(false, 1);
            setNsStatus(false, 3);
            forceUseVoipAll(true, false);
            forceVoipRecord16k(false);
            setForceChangeAudioRouter(true, false);
        }
    }

    public void setForceChangeAudioRouter(boolean z, boolean z2) {
        OmniLog.aw_d(TAG, "Set force change audio router, verrideDefault :  " + z + "  | usingVoip : " + z2);
        RtcAudioStatus.forcePlayMode = z;
        RtcAudioStatus.forcePlayModeVoip = z2;
        replayUseVoip(z2);
    }

    public void reportAudioRecordError(int i) {
        if (i != 0) {
            Message.obtain(this.threadHandler, 300, 3, i == 4 ? 3 : i == 12 ? 2 : 1).sendToTarget();
            OmniLog.aw_e(TAG, "Audio capture happend error... " + i);
            ExternalAudioModule.RecordErrInfo recinfo = RtcAudioStatus.getRecinfo();
            recinfo.errorCode = i;
            ((EnterConfApiImpl) EnterConfApi.getInstance()).reportAudioRecError(recinfo);
            if (!this.mReportAudioCapFailed) {
                this.mReportAudioCapFailed = true;
            }
            Handler handler = this.threadHandler;
            if (!(handler instanceof Handler)) {
                handler.sendEmptyMessage(9);
            } else {
                AsynchronousInstrumentation.sendEmptyMessage(handler, 9);
            }
            this.threadHandler.sendEmptyMessageDelayed(10, 3000);
        } else if (GlobalConfig.mIsInRoom.get()) {
            Message.obtain(this.threadHandler, 300, 1, 0).sendToTarget();
        }
    }

    public void reportAudioPlayError(int i) {
        GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_ON_ERROR, 1109);
    }

    public void writeAudioLocalPcmData(ByteBuffer byteBuffer) {
        synchronized (this.mAudioDataWriterLock) {
            if (this.mAudioDataWriter != null) {
                int capacity = byteBuffer.capacity();
                byte[] bArr = new byte[capacity];
                System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset(), bArr, 0, capacity);
                this.mAudioDataWriter.writeAudioRecordDatas(bArr);
            }
        }
    }

    public int setAudioEncoderConfiguration(int i, int i2) {
        GlobalAudioConfig globalAudioConfig = GlobalHolder.getInstance().getGlobalAudioConfig();
        int i3 = globalAudioConfig.getAudioEncodedConfig().mEncodeType;
        if (i3 == 1 && (i < 8 || i > 128)) {
            return -5;
        }
        if (i3 == 2 && (i < 8 || i > 32)) {
            return -5;
        }
        if (i3 == 4 && (i < 8 || i > 128)) {
            return -5;
        }
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            return -5;
        }
        if (GlobalHolder.getInstance().isJoinedChannel()) {
            return -3;
        }
        globalAudioConfig.setAudioEncodeBitrateParam(i);
        nativeEnableLowComplexityMode(i2);
        return 0;
    }

    public int setAudioMixMode(int i, long[] jArr) {
        if (jArr == null) {
            jArr = new long[0];
        }
        Message.obtain(this.threadHandler, 28, new Object[]{Integer.valueOf(i), jArr}).sendToTarget();
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0050, code lost:
        return ExtPcmPush(r2, r12, r0.length, r15, r16, r7, r13);
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int pushExternalAudioFrame(byte[] r12, long r13, int r15, int r16, int r17, int r18) {
        /*
            r11 = this;
            r10 = r11
            r0 = r12
            r5 = r15
            r6 = r16
            if (r0 == 0) goto L_0x0054
            if (r5 <= 0) goto L_0x0054
            if (r6 <= 0) goto L_0x0054
            if (r18 >= 0) goto L_0x000e
            goto L_0x0054
        L_0x000e:
            int r1 = r0.length
            int r1 = r1 / r6
            int r7 = r1 / 2
            java.lang.Object r1 = r10.mExternalAudioLock
            monitor-enter(r1)
            int r2 = r10.mLastExternalAudioSampleRate     // Catch:{ all -> 0x0051 }
            r3 = 1
            r4 = 0
            if (r2 != r5) goto L_0x0022
            int r2 = r10.mLastExternalAudioChannel     // Catch:{ all -> 0x0051 }
            if (r2 == r6) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r2 = r4
            goto L_0x0027
        L_0x0022:
            r10.mLastExternalAudioSampleRate = r5     // Catch:{ all -> 0x0051 }
            r10.mLastExternalAudioChannel = r6     // Catch:{ all -> 0x0051 }
            r2 = r3
        L_0x0027:
            int r8 = r10.mExternalAudioId     // Catch:{ all -> 0x0051 }
            if (r8 == 0) goto L_0x0030
            if (r2 == 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r2 = r8
            goto L_0x0044
        L_0x0030:
            if (r8 == 0) goto L_0x0037
            r11.ExtPcmRelease(r8)     // Catch:{ all -> 0x0051 }
            r10.mExternalAudioId = r4     // Catch:{ all -> 0x0051 }
        L_0x0037:
            r2 = 3000(0xbb8, float:4.204E-42)
            int r2 = r11.ExtPcmCreate(r3, r4, r4, r2)     // Catch:{ all -> 0x0051 }
            if (r2 != 0) goto L_0x0042
            r0 = -1
            monitor-exit(r1)     // Catch:{ all -> 0x0051 }
            return r0
        L_0x0042:
            r10.mExternalAudioId = r2     // Catch:{ all -> 0x0051 }
        L_0x0044:
            monitor-exit(r1)     // Catch:{ all -> 0x0051 }
            int r4 = r0.length
            r1 = r11
            r3 = r12
            r5 = r15
            r6 = r16
            r8 = r13
            int r0 = r1.ExtPcmPush(r2, r3, r4, r5, r6, r7, r8)
            return r0
        L_0x0051:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0051 }
            throw r0
        L_0x0054:
            r0 = -5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.audiocore.MyAudioApiImpl.pushExternalAudioFrame(byte[], long, int, int, int, int):int");
    }

    public void setAudioEarbackVol(float f) {
        if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
            f = 0.0f;
        }
        if (((double) f) > 1.0d) {
            f = 1.0f;
        }
        Message obtain = Message.obtain();
        obtain.what = 21;
        obtain.obj = Float.valueOf(f);
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtain);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, obtain);
        }
    }

    /* access modifiers changed from: private */
    public void updateAudioStatus(boolean z, boolean z2) {
        try {
            AudioManager audioManager = (AudioManager) this.mContext.getSystemService("audio");
            if (audioManager != null) {
                if (z2) {
                    HeadSetReceiver.autoSetHeadsetOn(audioManager, z);
                }
                if (z) {
                    HeadSetReceiver.requestAudioFocus(this.mContext);
                    audioManager.setMode(3);
                    return;
                }
                if (!(GlobalConfig.mBranch == LocalSDKConstants.BRANCH_CLIENT_MIAOMIAO || GlobalConfig.mBranch == LocalSDKConstants.BRANCH_CLIENT_JIUJIU || GlobalConfig.mBranch == LocalSDKConstants.BRANCH_CLIENT_TC)) {
                    HeadSetReceiver.abandonAudioFocus();
                }
                audioManager.setMode(0);
            }
        } catch (Exception e) {
            OmniLog.e(TAG, "updateAudioStatus -> exception = " + e.getLocalizedMessage());
        }
    }

    private void executingAdjustPlaybackSignalVolume(String str, double d) {
        LongSparseArray<User> userArray = GlobalHolder.getInstance().getUserArray(str);
        if (userArray != null) {
            for (int i = 0; i < userArray.size(); i++) {
                User valueAt = userArray.valueAt(i);
                if (valueAt != null) {
                    AdjRemoteAudioVolumeScale(valueAt.getUid(), d);
                }
            }
        }
    }

    private void nativeCachDirectBufferAddress() {
        this.recordBuffer = ByteBuffer.allocateDirect(Marshallable.PROTO_PACKET_SIZE);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(Marshallable.PROTO_PACKET_SIZE);
        this.playBuffer = allocateDirect;
        NativeCachDirectBufferAddress(this.recordBuffer, allocateDirect);
    }

    /* access modifiers changed from: private */
    public void handleInitialize() {
        OmniLog.i(TAG, "handleInitialize start");
        if (!Initialize(mAudioApi, this.mContext)) {
            GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_ON_ERROR, 1005);
            return;
        }
        nativeCachDirectBufferAddress();
        EnableAecDelayAgnostic(true);
        SetAudioFolder(this.mContext.getExternalFilesDir("").getAbsolutePath());
        this.mAudioVolumeController = new DelayExecuteController<>(new OnDelayExecuteControllerCallBackImpl(mAudioApi), Double.valueOf(0.5d));
        OmniLog.i(TAG, "handleInitialize end");
    }

    /* access modifiers changed from: private */
    public void stopPlayInternal(Message message) {
        long longValue = ((Long) message.obj).longValue();
        OmniLog.d("MyAudioApi -> StopPlay invoked!");
        if (!StopPlay(longValue)) {
            GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_ON_ERROR, 1005);
        }
        synchronized (this.speakers_lock_obj) {
            this.mSpeakers.remove(message.obj);
        }
        if (this.mMixUidList.size() > 0) {
            Iterator<AudioMixModeBean> it = this.mMixUidList.iterator();
            int i = -1;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AudioMixModeBean next = it.next();
                i++;
                OmniLog.i("AUDIO_MIX_MODE", TAG, "stopPlayInternal Iterator bean = " + next.toString());
                if (next.mUid == longValue) {
                    OmniLog.i("AUDIO_MIX_MODE", TAG, "stopPlayInternal Find user and remove stage = " + longValue);
                    break;
                }
            }
            if (i != -1) {
                this.mMixUidList.remove(i);
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleAudioFilePlay(boolean z, Message message) {
        if (z) {
            Bundle data = message.getData();
            int i = data.getInt("id");
            if (!StartAudioFileMixing(i, data.getString("fileName"), 1, data.getBoolean("loopback"), data.getInt("loopTimes"), data.getDouble("pitch"))) {
                GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_ON_ERROR, 1005);
            } else if (i == -1) {
                this.mAudioVolumeController.startExecute();
            }
        } else {
            if (!StopAudioFileMixing(message.arg1)) {
                GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.CHANNEL_ON_ERROR, 1005);
            }
            this.mAudioVolumeController.reset();
        }
    }

    /* access modifiers changed from: private */
    public void handleRecordMixStatus(boolean z) {
        this.mRecordMixEnabled = z;
        if (z) {
            OmniLog.i(TAG, "Enable record mix : " + this.mLocalAudioPerCall + " | " + this.mLocalAudioSampleRate + " | " + this.mLocalAudioChannel);
            EnableRecordMix(true, this.mLocalAudioPerCall, this.mLocalAudioSampleRate, this.mLocalAudioChannel);
            return;
        }
        EnableRecordMix(false, this.mLocalAudioPerCall, this.mLocalAudioSampleRate, this.mLocalAudioChannel);
    }

    /* access modifiers changed from: private */
    public void handlePlayMixStatus(boolean z) {
        this.mPlayMixEnabled = z;
        if (z) {
            OmniLog.i(TAG, "Enable play mix : " + this.mRemoteAudioPerCall + " | " + this.mRemoteAudioSampleRate + " | " + this.mRemoteAudioChannel);
            EnablePlayMix(true, this.mRemoteAudioPerCall, this.mRemoteAudioSampleRate, this.mRemoteAudioChannel);
            return;
        }
        EnablePlayMix(false, this.mRemoteAudioPerCall, this.mRemoteAudioSampleRate, this.mRemoteAudioChannel);
    }

    /* access modifiers changed from: private */
    public void handleMixStatus(Message message) {
        Bundle data = message.getData();
        boolean z = data.getBoolean("isBegin");
        this.mMixEnabled = z;
        if (z) {
            int i = data.getInt("bufSize");
            int i2 = data.getInt("samplerate");
            int i3 = data.getInt("channel");
            ByteBuffer byteBuffer = this.recordAndPlayMixBuffer;
            if (byteBuffer == null || i != byteBuffer.capacity()) {
                this.recordAndPlayMixBuffer = ByteBuffer.allocateDirect(i);
            }
            OmniLog.i(TAG, "Enable play mix : " + i + " | " + i2 + " | " + i3);
            EnableRemoteAndLocalMix(true, this.recordAndPlayMixBuffer, i, i2, i3);
            return;
        }
        EnableRemoteAndLocalMix(false, (ByteBuffer) null, 0, 0, 0);
    }

    /* access modifiers changed from: private */
    public void handleClearResource() {
        this.mReportAudioCapFailed = false;
        resetChannelStatus();
        handleRecordMixStatus(false);
        handlePlayMixStatus(false);
        EnableEarBack(false);
        RtcAudioStatus.forcePlayMode = false;
        RtcAudioStatus.forcePlayModeVoip = false;
        RtcAudioStatus.setCapDataSizeInBytes(0);
        AudioManager audioManager = (AudioManager) this.mContext.getSystemService("audio");
        GlobalHolder.getInstance().setAudioMode("leaveRealChannel", audioManager, 0);
        HeadSetReceiver.autoSetHeadsetOn(audioManager, false);
        if (this.mMixUidList.size() > 0) {
            for (AudioMixModeBean audioMixModeBean : this.mMixUidList) {
                OmniLog.i("AUDIO_MIX_MODE", TAG, "handleClearResource, remove bean = " + audioMixModeBean.toString());
            }
            this.mMixUidList.clear();
        }
        OmniLog.i("AUDIO_MIX_MODE", TAG, "handleClearResource, reset mode");
    }

    /* access modifiers changed from: private */
    public void handleMuteLocalAudio(Message message) {
        int MuteLocal = MuteLocal(((Boolean) message.obj).booleanValue());
        if (MuteLocal != 0) {
            ((EnterConfApiImpl) EnterConfApi.getInstance()).reportMuteLocalErr(MuteLocal);
        }
        int IsLocalMute = IsLocalMute();
        if (IsLocalMute < 0) {
            ((EnterConfApiImpl) EnterConfApi.getInstance()).reportMuteLocalErr(IsLocalMute + 100);
        }
    }

    /* access modifiers changed from: private */
    public void handleMuteRemoteAudio(Message message) {
        Bundle data = message.getData();
        long j = data.getLong("uid", -1);
        boolean z = data.getBoolean("muted", false);
        if (j != -1) {
            MuteRemote(j, z);
        }
    }

    /* access modifiers changed from: private */
    public void setAudioMixModeInternal(Message message) {
        Object[] objArr = (Object[]) message.obj;
        ((Integer) objArr[0]).intValue();
        long[] jArr = (long[]) objArr[1];
        if (this.mMixUidList.size() > 0) {
            for (AudioMixModeBean audioMixModeBean : this.mMixUidList) {
                OmniLog.i("AUDIO_MIX_MODE", TAG, "setAudioMixModeInternal, remove bean = " + audioMixModeBean.toString());
            }
            this.mMixUidList.clear();
        }
        if (jArr.length > 0) {
            for (long j : jArr) {
                AudioMixModeBean audioMixModeBean2 = new AudioMixModeBean();
                audioMixModeBean2.mUid = j;
                this.mMixUidList.add(audioMixModeBean2);
                OmniLog.i("AUDIO_MIX_MODE", TAG, "setAudioMixModeInternal, add bean = " + audioMixModeBean2.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleAudioStuck(AudioStuckBean audioStuckBean) {
        String channelNameByUid = GlobalHolder.getInstance().getChannelNameByUid(audioStuckBean.mUid);
        if (!TextUtils.isEmpty(channelNameByUid)) {
            GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.AUDIO_BUFFER_STATE_CHANGED, channelNameByUid, Long.valueOf(audioStuckBean.mUid), Integer.valueOf(audioStuckBean.mState), Long.valueOf(audioStuckBean.mTimestampInMs));
        }
    }

    private void resetChannelStatus() {
        this.mAudioVolumeController.reset();
        StopAudioFileMixing(-1);
        SetTrackVolumeScale(-1, 0.5d);
        SetPlayoutTrackVolumeScale(-1, 0.5d);
        SetPublishTrackVolumeScale(-1, 0.5d);
        AdjustMicVolumeScale(1.0d);
        AdjAllRemoteAudioVolumeScale(1.0d);
        SetEarbackVolume(1.0f);
        AudioEffect.getInstance().enableAudioEffect(false);
    }

    private void handleEngineLeave() {
        stopCapture();
    }

    private void checkAudioLocalFirstEncodedNotify() {
        GlobalAudioConfig globalAudioConfig = GlobalHolder.getInstance().getGlobalAudioConfig();
        if (globalAudioConfig != null && !globalAudioConfig.isAudioLocalFirstEncodedNotifyed() && globalAudioConfig.setAudioLocalFirstEncodedNotifyed(true)) {
            GlobalHolder.getInstance().sendRtcEngineEvent(93, 2, 0);
        }
    }

    private void OnRecordPCMData(int i, int i2, boolean z) {
        int i3 = z ? 2 : 1;
        AudioEffect.getInstance().process(this.recordBuffer, i / (i3 * 2), i3);
        if (this.mRecordMixEnabled) {
            WeakReference<ExternalAudioProcessCallback> weakReference = this.mProcessCallback;
            ExternalAudioProcessCallback externalAudioProcessCallback = weakReference != null ? (ExternalAudioProcessCallback) weakReference.get() : null;
            if (externalAudioProcessCallback != null) {
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = new byte[i];
                System.arraycopy(this.recordBuffer.array(), this.recordBuffer.arrayOffset(), bArr, 0, i);
                byte[] onRecordPCMData = externalAudioProcessCallback.onRecordPCMData(bArr, 0, i, i2, z);
                if (onRecordPCMData != null) {
                    this.mProcessLocalDataBean.calc(currentTimeMillis);
                    GlobalConfig.mLocalAudioDataProcessAvgEffeciency = this.mProcessLocalDataBean.mAvgSpentTime;
                    this.recordBuffer.put(onRecordPCMData);
                }
            }
        }
        synchronized (this.mAudioDataWriterLock) {
            if (this.mAudioDataWriter != null) {
                byte[] bArr2 = new byte[i];
                System.arraycopy(this.recordBuffer.array(), this.recordBuffer.arrayOffset(), bArr2, 0, i);
                this.mAudioDataWriter.writeAudioRecordAfter3ADatas(bArr2);
            }
        }
        this.recordBuffer.rewind();
    }

    private void OnRemoteAndLocalMixPCMData(int i, int i2, boolean z) {
        WeakReference<ExternalAudioProcessCallback> weakReference = this.mProcessCallback;
        ExternalAudioProcessCallback externalAudioProcessCallback = weakReference != null ? (ExternalAudioProcessCallback) weakReference.get() : null;
        if (externalAudioProcessCallback != null) {
            long currentTimeMillis = System.currentTimeMillis();
            byte[] bArr = new byte[i];
            System.arraycopy(this.recordAndPlayMixBuffer.array(), this.recordAndPlayMixBuffer.arrayOffset(), bArr, 0, i);
            byte[] OnRemoteAndLocalMixPCMData = externalAudioProcessCallback.OnRemoteAndLocalMixPCMData(bArr, 0, i, i2, z);
            if (OnRemoteAndLocalMixPCMData != null) {
                this.mProcessMixDataBean.calc(currentTimeMillis);
                GlobalConfig.mMixAudioDataProcessAvgEffeciency = this.mProcessMixDataBean.mAvgSpentTime;
                this.recordAndPlayMixBuffer.put(OnRemoteAndLocalMixPCMData);
            }
        }
        this.recordAndPlayMixBuffer.rewind();
    }

    private void OnPlaybackPCMData(int i, int i2, boolean z) {
        if (this.mPlayMixEnabled) {
            WeakReference<ExternalAudioProcessCallback> weakReference = this.mProcessCallback;
            ExternalAudioProcessCallback externalAudioProcessCallback = weakReference != null ? (ExternalAudioProcessCallback) weakReference.get() : null;
            if (externalAudioProcessCallback != null) {
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr = new byte[i];
                System.arraycopy(this.playBuffer.array(), this.playBuffer.arrayOffset(), bArr, 0, i);
                byte[] onPlaybackPCMData = externalAudioProcessCallback.onPlaybackPCMData(bArr, 0, i, i2, z);
                if (onPlaybackPCMData != null) {
                    this.mProcessRemoteDataBean.calc(currentTimeMillis);
                    GlobalConfig.mRemoteAudioDataProcessAvgEffeciency = this.mProcessRemoteDataBean.mAvgSpentTime;
                    this.playBuffer.put(onPlaybackPCMData);
                }
            }
        }
        this.playBuffer.rewind();
    }

    private void EncodedAudio(byte[] bArr) {
        checkAudioLocalFirstEncodedNotify();
        for (WeakReference next : this.mAudioSenders) {
            if (next.get() != null) {
                ((AudioSender) next.get()).pushEncodedAudioData(bArr);
            }
        }
    }

    private void OnSendNACKData(byte[] bArr, int i, long j) {
        for (WeakReference next : this.mAudioSenders) {
            if (next.get() != null) {
                ((AudioSender) next.get()).sendNACKData(bArr, i, j);
            }
        }
    }

    private void OnSendRTCPData(byte[] bArr, int i, long j) {
        for (WeakReference next : this.mAudioSenders) {
            if (next.get() != null) {
                ((AudioSender) next.get()).sendRTCPData(bArr, i, j);
            }
        }
    }

    private void OnGetLocalAudioSatistics(long j, int i, int i2, long j2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, int i10, int i11, long j3, long j4, int i12, int i13, int i14, int i15, int i16) {
        int i17 = i9;
        this.mLocalAudioStatistics.ssrc = j;
        this.mLocalAudioStatistics.fractionLost = i;
        this.mLocalAudioStatistics.rttMs = i2;
        this.mLocalAudioStatistics.encodeDataSize = j2;
        this.mLocalAudioStatistics.erl = i3;
        this.mLocalAudioStatistics.eRle = i4;
        this.mLocalAudioStatistics.aNlp = i5;
        this.mLocalAudioStatistics.delayMedian = i6;
        this.mLocalAudioStatistics.delayStd = i7;
        this.mLocalAudioStatistics.fractionPoorDelays = f;
        this.mLocalAudioStatistics.reportType = i8;
        this.mLocalAudioStatistics.capFps = i17;
        this.mLocalAudioStatistics.encodeInputFps = i17;
        this.mLocalAudioStatistics.encodeOutputFps = i10;
        this.mLocalAudioStatistics.aAfterlevelSum = (long) i11;
        this.mLocalAudioStatistics.asVolumeLevelSum = j3;
        this.mLocalAudioStatistics.asVolumeLevelRmsSend = j4;
        this.mLocalAudioStatistics.asVolumeLevelRmsA = i12;
        this.mLocalAudioStatistics.asVolumeLevelRms = i13;
        this.mLocalAudioStatistics.asVolumeOriginalLevel = i14;
        this.mLocalAudioStatistics.asVolumeCallBackAfterLevel = i15;
        this.mLocalAudioStatistics.asVolumeCallBackBeforeLevel = i16;
    }

    private void OnGetRemoteAudioSatistics(long j, int i, int i2, int i3, long j2, int i4, int i5, long j3, long j4, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20) {
        ExternalAudioModule.AudioStatistics audioStatistics = new ExternalAudioModule.AudioStatistics();
        audioStatistics.lossRate = i;
        audioStatistics.bufferDuration = i2;
        audioStatistics.jitterBufferMs = i3;
        audioStatistics.decodedLength = j2;
        audioStatistics.fractionLost = i4;
        audioStatistics.cartonCount = i5;
        audioStatistics.ssrc = j3;
        audioStatistics.recvLength = j4;
        audioStatistics.rttMs = i6;
        audioStatistics.sampleRate = i7;
        audioStatistics.channels = i8;
        audioStatistics.decFps = i9;
        audioStatistics.recvFps = i10;
        audioStatistics.decoderInputFps = i11;
        audioStatistics.decoderOutputFps = i12;
        audioStatistics.renderOutputFps = i13;
        audioStatistics.decodeDur = i14;
        audioStatistics.arVolumeLevelRmsA = i15;
        audioStatistics.arVolumeLevelRms = i16;
        audioStatistics.arVolumeLevelSum = i17;
        audioStatistics.arSysPlayoutFps = i18;
        audioStatistics.arProcElapsedAvg = i19;
        audioStatistics.arProcElapsedMax = i20;
        long j5 = j;
        this.mRemoteAudioStatistics.append(j, audioStatistics);
    }

    private void OnGetAecStats(int i, int i2, int i3, int i4) {
        this.mAecParam.model = Build.MODEL;
        this.mAecParam.open_delay_estimate = i;
        this.mAecParam.delay_estimate = i4;
        this.mAecParam.offset = i3;
        this.mAecParam.pre_offset = i2;
        this.mAecParam.voip_play = RtcAudioDecision.getInstance(RtcAudioDecision.DecisionType.Momo).playStreamTypeUsingVoip() ? 1 : 0;
        this.mAecParam.voip_record = RtcAudioStatus.recordMode();
    }

    private void SetAudioFractionLoss(int i) {
        for (WeakReference next : this.mAudioSenders) {
            if (next.get() != null) {
                ((AudioSender) next.get()).SetAudioFractionLoss(i);
            }
        }
    }

    private void OnAudioDecoderStatus(int i, int i2) {
        if (i2 == -1) {
            GlobalHolder.getInstance().notifyAudioMixingPlayFinish();
        } else {
            GlobalHolder.getInstance().notifyPlayEffectFinish(i2);
        }
        WeakReference<AudioFileMixCallback> weakReference = this.mAudioFileMixCallback;
        if (weakReference != null && weakReference.get() != null) {
            ((AudioFileMixCallback) this.mAudioFileMixCallback.get()).OnAudioDecoderStatus(AudioFileMixCallback.AudioFileMixStatus.AudioFileMixStatus_eof);
        }
    }

    private void OnReportDuration(int i, int i2) {
        WeakReference<AudioFileMixCallback> weakReference;
        if (i2 == -1 && (weakReference = this.mAudioFileMixCallback) != null && weakReference.get() != null) {
            ((AudioFileMixCallback) this.mAudioFileMixCallback.get()).OnReportFileDuration(i);
        }
    }

    private void OnReportPlayoutSeconds(int i, int i2) {
        WeakReference<AudioFileMixCallback> weakReference;
        if (i2 == -1 && (weakReference = this.mAudioFileMixCallback) != null && weakReference.get() != null) {
            ((AudioFileMixCallback) this.mAudioFileMixCallback.get()).OnReportPlayoutSeconds(i);
        }
    }

    private void OnAudioDecoderError(int i, String str) {
        WeakReference<AudioFileMixCallback> weakReference;
        if (i == -1 && (weakReference = this.mAudioFileMixCallback) != null && weakReference.get() != null) {
            ((AudioFileMixCallback) this.mAudioFileMixCallback.get()).OnReportPlayoutError();
        }
    }

    private void OnBufferingBegin(int i) {
        WeakReference<AudioFileMixCallback> weakReference;
        if (i == -1 && (weakReference = this.mAudioFileMixCallback) != null && weakReference.get() != null) {
            ((AudioFileMixCallback) this.mAudioFileMixCallback.get()).OnBufferingBegin();
        }
    }

    private void OnBufferingEnd(int i) {
        WeakReference<AudioFileMixCallback> weakReference;
        if (i == -1 && (weakReference = this.mAudioFileMixCallback) != null && weakReference.get() != null) {
            ((AudioFileMixCallback) this.mAudioFileMixCallback.get()).OnBufferingEnd();
        }
    }

    private void OnAudioPlayFinished() {
        Message obtain = Message.obtain();
        obtain.what = 112;
        Handler handler = this.threadHandler;
        if (!(handler instanceof Handler)) {
            handler.sendMessage(obtain);
        } else {
            AsynchronousInstrumentation.sendMessage(handler, obtain);
        }
    }

    private void OnFirstAudioFrameDecoded(long j) {
        GlobalHolder.getInstance().notifyGlobalFirstRemoteAudioDecoded(j);
    }

    private void OnAudioStuckBegin(long j, long j2) {
        AudioStuckBean audioStuckBean = new AudioStuckBean();
        audioStuckBean.mUid = j;
        audioStuckBean.mState = 0;
        audioStuckBean.mTimestampInMs = j2;
        Message.obtain(this.threadHandler, 113, audioStuckBean).sendToTarget();
    }

    private void OnAudioStuckEnd(long j, int i, long j2) {
        AudioStuckBean audioStuckBean = new AudioStuckBean();
        audioStuckBean.mUid = j;
        audioStuckBean.mState = 1;
        audioStuckBean.mTimestampInMs = j2;
        Message.obtain(this.threadHandler, 113, audioStuckBean).sendToTarget();
    }

    private void OnGetDelayMetrics(int i, int i2, double d) {
        this.aec_delay_metrics.delay_median = i;
        this.aec_delay_metrics.delay_std = i2;
        this.aec_delay_metrics.fraction_poor_delays = d;
    }

    private void OnLog(int i, String str) {
        OmniLog.i(str);
    }

    private static class OnDelayExecuteControllerCallBackImpl implements DelayExecuteController.OnDelayExecuteControllerCallBack<Double> {
        private final WeakReference<MyAudioApiImpl> mOutReference;

        public OnDelayExecuteControllerCallBackImpl(MyAudioApiImpl myAudioApiImpl) {
            this.mOutReference = new WeakReference<>(myAudioApiImpl);
        }

        public void execute(Double d) {
            MyAudioApiImpl myAudioApiImpl;
            if (d != null && (myAudioApiImpl = (MyAudioApiImpl) this.mOutReference.get()) != null) {
                myAudioApiImpl.SetTrackVolumeScale(-1, d.doubleValue());
            }
        }
    }
}
