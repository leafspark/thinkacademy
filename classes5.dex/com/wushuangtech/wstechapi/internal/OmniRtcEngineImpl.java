package com.wushuangtech.wstechapi.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.view.TextureView;
import com.eaydu.omni.core.screen.ScreenCapture;
import com.eaydu.omni.core.screen.ScreenEncoderConfig;
import com.wushuangtech.api.EnterConfApi;
import com.wushuangtech.api.EnterConfApiImpl;
import com.wushuangtech.api.ExternalAudioModule;
import com.wushuangtech.api.RtcEngineEventReporter;
import com.wushuangtech.api.RtcUserManager;
import com.wushuangtech.audiocore.AudioEffect;
import com.wushuangtech.audiocore.AudioEncoder;
import com.wushuangtech.audiocore.MyAudioApi;
import com.wushuangtech.audiocore.MyAudioApiImpl;
import com.wushuangtech.audiocore.MyExternalAudioProcessCallbackImpl;
import com.wushuangtech.audiocore.callback.AudioFileMixCallback;
import com.wushuangtech.audiocore.utils.AssertUtils;
import com.wushuangtech.bean.AudioEncodedConfig;
import com.wushuangtech.bean.FastLogCacheBean;
import com.wushuangtech.bean.InterCorrectUserBean;
import com.wushuangtech.bean.VideoRemoteStreamType;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.constants.RtcEngineEvent;
import com.wushuangtech.expansion.bean.ChannelMediaRelayConfiguration;
import com.wushuangtech.expansion.bean.OmniVideoFrame;
import com.wushuangtech.expansion.bean.ScreenRecordConfig;
import com.wushuangtech.expansion.bean.VideoCompositingLayout;
import com.wushuangtech.expansion.inter.OmniInterfaceTestCallBack;
import com.wushuangtech.expansion.inter.OmniRtcEngineEventInter;
import com.wushuangtech.handler.ContentInspectHandler;
import com.wushuangtech.jni.ReportLogJni;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.jni.VideoJni;
import com.wushuangtech.jni.response.ChannelJoinResponse;
import com.wushuangtech.library.GlobalAudioConfig;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.RtcInvokeSafetyChecker;
import com.wushuangtech.library.video.VideoDualStreamManager;
import com.wushuangtech.log.LogRecorder;
import com.wushuangtech.myvideoimprove.ExternalVideoSource;
import com.wushuangtech.utils.HttpUtil;
import com.wushuangtech.utils.MyFileUtils;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.utils.PhoneUtils;
import com.wushuangtech.wstechapi.IAudioEffectManager;
import com.wushuangtech.wstechapi.OmniRtcChannel;
import com.wushuangtech.wstechapi.OmniRtcEngine;
import com.wushuangtech.wstechapi.OmniRtcEngineEventHandler;
import com.wushuangtech.wstechapi.OmniRtcEngineExtend;
import com.wushuangtech.wstechapi.bean.ChannelMediaOptions;
import com.wushuangtech.wstechapi.bean.OmniLocalModuleConfig;
import com.wushuangtech.wstechapi.bean.OmniVideoMixerCanvas;
import com.wushuangtech.wstechapi.bean.PublisherConfiguration;
import com.wushuangtech.wstechapi.bean.VideoCanvas;
import com.wushuangtech.wstechapi.bean.VideoEncoderConfiguration;
import com.wushuangtech.wstechapi.bean.VideoRotate;
import com.wushuangtech.wstechapi.constants.OmniModuleConstants;
import com.wushuangtech.wstechapi.inter.OmniInterSyncHelper;
import com.yalantis.ucrop.view.CropImageView;
import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

public class OmniRtcEngineImpl extends OmniRtcEngine implements OmniInterfaceTestCallBack, IAudioEffectManager, AudioFileMixCallback {
    private static final String[] H264_HW_BLACKLIST = {"SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4", "P6-C00", "HM 2A", "XT105", "XT109", "XT1060"};
    /* access modifiers changed from: private */
    public static final String TAG = "OmniRtcEngine";
    /* access modifiers changed from: private */
    public AudioEncoder mAudioEncoder;
    /* access modifiers changed from: private */
    public double mAudioMixSoloVolume;
    /* access modifiers changed from: private */
    public String mCacheLogPath;
    /* access modifiers changed from: private */
    public Context mContext;
    public int mCurrentAudioMixingDuration;
    public int mCurrentAudioMixingPosition;
    /* access modifiers changed from: private */
    public String mCurrentLoginChanelKey;
    /* access modifiers changed from: private */
    public String mCurrentLoginChannel;
    /* access modifiers changed from: private */
    public long mCurrentLoginUserID;
    /* access modifiers changed from: private */
    public final CustomFuncHandler mCustomFuncHandler = new CustomFuncHandler();
    /* access modifiers changed from: private */
    public int mExternalAudioChannels;
    private final MyExternalAudioProcessCallbackImpl mExternalAudioProcessCallback;
    private final FastLogCacheBean mExternalAudioPushWatcher;
    /* access modifiers changed from: private */
    public int mExternalAudioSampleRate;
    private byte[] mInsertBytes;
    private boolean mIsNeedInsert;
    /* access modifiers changed from: private */
    public int mLastVideoEncBitrate;
    /* access modifiers changed from: private */
    public int mLastVideoEncFps;
    /* access modifiers changed from: private */
    public int mLastVideoEncHeight;
    /* access modifiers changed from: private */
    public int mLastVideoEncWidth;
    /* access modifiers changed from: private */
    public LogRecorder mLogRecorder;
    /* access modifiers changed from: private */
    public final OmniAudioModule mOmniAudioModule;
    private final OmniInterSyncHelperImpl mOmniInterSyncHelperImpl;
    /* access modifiers changed from: private */
    public final OmniRtcEngineAssist mOmniRtcEngineAssist;
    private final OmniRtcEngineExtend mOmniRtcEngineExtend;
    Lock mRecorderLock = new ReentrantLock();
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, OmniRtcChannel> mRtcChannels = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public boolean mRtcEngineDestroyed;
    /* access modifiers changed from: private */
    public final RtcInvokeSafetyChecker mRtcInvokeSafetyChecker = new RtcInvokeSafetyChecker();
    /* access modifiers changed from: private */
    public String mRtmpUrl = "";
    ScreenCapture mScreenCapture;
    /* access modifiers changed from: private */
    public int mVideoMixerHeight = -1;
    /* access modifiers changed from: private */
    public int mVideoMixerWidth = -1;

    /* access modifiers changed from: private */
    public Object handleIJKModule(OmniLocalModuleConfig omniLocalModuleConfig) {
        return null;
    }

    public void OnAudioDecoderStatus(AudioFileMixCallback.AudioFileMixStatus audioFileMixStatus) {
    }

    public void OnBufferingBegin() {
    }

    public void OnBufferingEnd() {
    }

    public void OnReportPlayoutError() {
    }

    public int enableCustomVideoBackgroundImage(boolean z) {
        return 0;
    }

    public IAudioEffectManager getAudioEffectManager() {
        return this;
    }

    public void reportTestString(String str) {
    }

    public int setVideoBackgroundImage(Bitmap bitmap, int i) {
        return 0;
    }

    static {
        Class<OmniRtcEngine> cls = OmniRtcEngine.class;
    }

    public OmniRtcEngineImpl(Context context, String str, OmniRtcEngineEventInter omniRtcEngineEventInter) {
        MyExternalAudioProcessCallbackImpl myExternalAudioProcessCallbackImpl = new MyExternalAudioProcessCallbackImpl();
        this.mExternalAudioProcessCallback = myExternalAudioProcessCallbackImpl;
        this.mAudioMixSoloVolume = 1.0d;
        this.mContext = context.getApplicationContext();
        GlobalHolder.getInstance().initSdk(context, str, omniRtcEngineEventInter);
        this.mOmniAudioModule = new OmniAudioModule();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = new OmniInterSyncHelperImpl();
        this.mOmniInterSyncHelperImpl = omniInterSyncHelperImpl;
        omniInterSyncHelperImpl.setTag("OmniRtcEngine");
        omniInterSyncHelperImpl.setChannelType(true);
        this.mOmniRtcEngineExtend = new OmniRtcEngineExtendImpl(omniInterSyncHelperImpl);
        OmniRtcEngineAssist omniRtcEngineAssist = new OmniRtcEngineAssist();
        this.mOmniRtcEngineAssist = omniRtcEngineAssist;
        omniRtcEngineAssist.init(this);
        if (context instanceof Activity) {
            omniRtcEngineAssist.setActivity((Activity) context);
        }
        ExternalAudioModule instance = ExternalAudioModule.getInstance();
        MyAudioApi instance2 = MyAudioApi.getInstance(this.mContext);
        instance.setExternalAudioModuleCallback(instance2);
        instance2.addAudioSender(instance.getLocalAudioSender());
        instance2.setAudioFileMixCallback(this);
        instance2.setExternalAudioProcessCallback(myExternalAudioProcessCallbackImpl);
        handleVideoModule(0);
        GlobalHolder.getInstance().setOmniInterfaceTestCallBack(this);
        ActivityManager activityManager = (ActivityManager) this.mContext.getSystemService("activity");
        if (activityManager != null) {
            ConfigurationInfo deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo();
            log("GLES VERSION : " + deviceConfigurationInfo.reqGlEsVersion);
            if (196608 <= deviceConfigurationInfo.reqGlEsVersion) {
                GlobalConfig.mIsSupportPBO = true;
            }
        }
        this.mExternalAudioPushWatcher = new FastLogCacheBean("OmniRtcEngine-pushExternalAudioFrame", TAG, 4);
        log("OmniRtcEngine Local SDK Version: 3.6.140(2023_03_23) Thread:" + Thread.currentThread().getId());
    }

    public void reinitialize(final Context context, final String str, final OmniRtcEngineEventInter omniRtcEngineEventInter) {
        this.mOmniInterSyncHelperImpl.executeInter(getInvokedMethodName(), new OmniInterSyncHelper() {
            public int run() {
                OmniLog.i("Start reinit engine...  Thread:" + Thread.currentThread().getId());
                boolean unused = OmniRtcEngineImpl.this.mRtcEngineDestroyed = false;
                Context unused2 = OmniRtcEngineImpl.this.mContext = context.getApplicationContext();
                if (OmniRtcEngineImpl.this.mRtcChannels == null) {
                    ConcurrentHashMap unused3 = OmniRtcEngineImpl.this.mRtcChannels = new ConcurrentHashMap();
                }
                if (context instanceof Activity) {
                    OmniRtcEngineImpl.this.mOmniRtcEngineAssist.setActivity((Activity) context);
                }
                GlobalHolder.getInstance().reinitialize(context, str, omniRtcEngineEventInter);
                return 0;
            }
        });
    }

    public void doDestroy() {
        this.mOmniInterSyncHelperImpl.executeInter(getInvokedMethodName(), new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                omniRtcEngineImpl.log("Starting destory... " + Thread.currentThread().getId());
                boolean unused = OmniRtcEngineImpl.this.mRtcEngineDestroyed = true;
                int unused2 = OmniRtcEngineImpl.this.executeLeaveChannel();
                OmniRtcEngineImpl.this.log("Exit engine room over... ");
                if (OmniRtcEngineImpl.this.mRtcChannels != null) {
                    for (Map.Entry value : OmniRtcEngineImpl.this.mRtcChannels.entrySet()) {
                        OmniRtcChannel omniRtcChannel = (OmniRtcChannel) value.getValue();
                        omniRtcChannel.leaveChannel();
                        omniRtcChannel.destroy();
                    }
                    OmniRtcEngineImpl.this.mRtcChannels.clear();
                    ConcurrentHashMap unused3 = OmniRtcEngineImpl.this.mRtcChannels = null;
                }
                OmniRtcEngineImpl.this.log("Exit all channel room over... ");
                OmniRtcEngineImpl.this.handleVideoModule(1);
                if (OmniRtcEngineImpl.this.mLogRecorder != null) {
                    OmniRtcEngineImpl.this.mLogRecorder.stop();
                    LogRecorder unused4 = OmniRtcEngineImpl.this.mLogRecorder = null;
                }
                GlobalHolder.getInstance().unInitSdk();
                return 0;
            }
        });
        log("Destroy engine over... ");
    }

    public Context getContext() {
        return this.mContext;
    }

    /* access modifiers changed from: package-private */
    public byte[] getInsertBytes() {
        return this.mInsertBytes;
    }

    public OmniInterSyncHelperImpl getInterSyncHepler() {
        return this.mOmniInterSyncHelperImpl;
    }

    public void setIsNeedInsert(boolean z) {
        this.mIsNeedInsert = z;
    }

    /* access modifiers changed from: package-private */
    public Object handleVideoModule(OmniLocalModuleConfig omniLocalModuleConfig) {
        return OmniVideoModule.getInstance().receiveVideoModuleEvent(omniLocalModuleConfig);
    }

    /* access modifiers changed from: package-private */
    public Object handleVideoModule(int i) {
        return OmniVideoModule.getInstance().receiveVideoModuleEvent(i);
    }

    /* access modifiers changed from: private */
    public Object handleRTMPModule(OmniLocalModuleConfig omniLocalModuleConfig) {
        if (omniLocalModuleConfig.eventType == 0) {
            handleVideoModule(new OmniLocalModuleConfig(20, new Object[0]));
        }
        return OmniRtmpModule.getInstance().receiveRtmpModuleEvent(omniLocalModuleConfig);
    }

    public void addHandler(OmniRtcEngineEventHandler omniRtcEngineEventHandler) {
        GlobalHolder.getInstance().addRtcEngineEventReceiver(omniRtcEngineEventHandler);
    }

    public void removeHandler(OmniRtcEngineEventHandler omniRtcEngineEventHandler) {
        RtcEngineEventReporter rtcEngineEventReporter = GlobalHolder.getInstance().getRtcEngineEventReporter();
        if (rtcEngineEventReporter != null) {
            rtcEngineEventReporter.removeEventReceiver(omniRtcEngineEventHandler);
        }
    }

    public int setChannelProfile(final int i) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "mode : " + i, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Integer.valueOf(i));
                int i = i;
                if (i != 0 && i != 1 && i != 2) {
                    return -5;
                }
                GlobalConfig.mCurrentChannelMode = i;
                return 0;
            }
        });
    }

    public int setClientRole(final int i) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "role : " + i, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.log("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Integer.valueOf(i));
                boolean z = GlobalConfig.mIsInRoom.get();
                boolean z2 = GlobalConfig.mIsLogining.get();
                if (GlobalConfig.mBranch != LocalSDKConstants.BRANCH_CLIENT_NEW) {
                    int i = i;
                    if (i != 1 && i != 2 && i != 3) {
                        return -5;
                    }
                    if (GlobalConfig.mCurrentChannelMode != 1) {
                        if (i == 1) {
                            OmniRtcEngineImpl.this.log("Only live mode can set the anchor role...");
                            return -3;
                        }
                    } else if (z && i == 1) {
                        OmniRtcEngineImpl.this.log("The current role is already the anchor...");
                        return -3;
                    }
                } else {
                    int i2 = i;
                    if (!(i2 == 1 || i2 == 2)) {
                        return -5;
                    }
                }
                if (z) {
                    if (!EnterConfApi.getInstance().changeUserRole(i)) {
                        return -5;
                    }
                } else if (GlobalHolder.getInstance().setRoleForBroadcaster(GlobalConfig.ENGINE_NAME, i) != 0) {
                    OmniLog.w(OmniLog.CHANNEL_PUSH, OmniRtcEngineImpl.TAG, "Set role failed... Only one can be set broadcaster at the same time!Engine");
                    return -5;
                } else if (z2) {
                    GlobalConfig.mIsNeedSetRole = true;
                }
                GlobalConfig.mLocalRole = i;
                OmniRtcEngineImpl omniRtcEngineImpl2 = OmniRtcEngineImpl.this;
                omniRtcEngineImpl2.log("Set role : " + i + " | room status : " + z + " | logining : " + z2);
                return 0;
            }
        });
    }

    public int joinChannel(String str, String str2, long j) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str3 = invokedMethodName;
        final String str4 = str;
        final String str5 = str2;
        final long j2 = j;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "channelKey : " + str + " | channelName : " + str2 + " | optionalUid : " + j + " | branch : " + GlobalConfig.mBranch, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (!OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    return OmniRtcEngineImpl.this.executingJoinChannel(str4, str5, j2);
                }
                String access$900 = OmniRtcEngineImpl.TAG;
                OmniLog.i(access$900, "RtcEngine not created! " + str3);
                return 0;
            }
        });
    }

    public int leaveChannel() {
        final String invokedMethodName = getInvokedMethodName();
        return this.mOmniInterSyncHelperImpl.executeInter(invokedMethodName, new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend(3, invokedMethodName, new Object[0]);
                String access$900 = OmniRtcEngineImpl.TAG;
                OmniLog.rw_i(access$900, "leaveChannel pull room? : " + GlobalConfig.mIsInPullRoom + " | in room? : " + GlobalConfig.mIsInRoom.get() + " | currentLoginChannel : " + OmniRtcEngineImpl.this.mCurrentLoginChannel);
                return OmniRtcEngineImpl.this.executeLeaveChannel();
            }
        });
    }

    /* access modifiers changed from: private */
    public int executeLeaveChannel() {
        EnterConfApi.getInstance().exitRoom(this.mCurrentLoginChannel);
        this.mOmniRtcEngineAssist.resetStats();
        resetEngineStatusForLeaveChannel();
        OmniLog.rw_i(TAG, "leaveChannel execute over!");
        return 0;
    }

    public int renewToken(final String str) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "token : " + str, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, str);
                if (TextUtils.isEmpty(str)) {
                    return -5;
                }
                if (!GlobalConfig.mIsInRoom.get()) {
                    return -3;
                }
                EnterConfApi.getInstance().renewChannelKey(str);
                return 0;
            }
        });
    }

    public int switchChannel(final String str, final String str2) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "token = " + str + ", channelName = " + str2, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (!OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    return OmniRtcEngineImpl.this.switchChannelInternal(str, str2, (ChannelMediaOptions) null);
                }
                String access$900 = OmniRtcEngineImpl.TAG;
                OmniLog.w(access$900, "RtcEngine not created! " + invokedMethodName);
                return -7;
            }
        });
    }

    public int switchChannel(String str, String str2, ChannelMediaOptions channelMediaOptions) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        StringBuilder sb = new StringBuilder();
        sb.append("token = ");
        sb.append(str);
        sb.append(", channelName = ");
        sb.append(str2);
        sb.append(", options = ");
        sb.append(channelMediaOptions == null ? "null" : channelMediaOptions.toString());
        final String str3 = invokedMethodName;
        final String str4 = str;
        final String str5 = str2;
        final ChannelMediaOptions channelMediaOptions2 = channelMediaOptions;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, sb.toString(), (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (!OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    return OmniRtcEngineImpl.this.switchChannelInternal(str4, str5, channelMediaOptions2);
                }
                String access$900 = OmniRtcEngineImpl.TAG;
                OmniLog.w(access$900, "RtcEngine not created! " + str3);
                return -7;
            }
        });
    }

    public int enableAudio() {
        final String invokedMethodName = getInvokedMethodName();
        return this.mOmniInterSyncHelperImpl.executeInter(invokedMethodName, new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, new Object[0]);
                if (GlobalConfig.mAudioEnabled) {
                    return 0;
                }
                EnterConfApi instance = EnterConfApi.getInstance();
                GlobalConfig.mAudioEnabled = true;
                instance.updateHeartbeatReporterAudioStatus(true, (Boolean) null, (Boolean) null);
                if (!GlobalConfig.mIsInRoom.get()) {
                    return 0;
                }
                if (GlobalConfig.mAudioLocalEnabled) {
                    MyAudioApiImpl.getInstance(OmniRtcEngineImpl.this.mContext).startCapture();
                }
                if (GlobalConfig.mAudioLocalStreamEnabled) {
                    instance.muteLocalAudio(false);
                }
                instance.muteAllRemoteAudio(false);
                return 0;
            }
        });
    }

    public int disableAudio() {
        final String invokedMethodName = getInvokedMethodName();
        return this.mOmniInterSyncHelperImpl.executeInter(invokedMethodName, new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, new Object[0]);
                if (!GlobalConfig.mAudioEnabled) {
                    return 0;
                }
                EnterConfApi instance = EnterConfApi.getInstance();
                GlobalConfig.mAudioEnabled = false;
                instance.updateHeartbeatReporterAudioStatus(false, (Boolean) null, (Boolean) null);
                if (!GlobalConfig.mIsInRoom.get()) {
                    return 0;
                }
                MyAudioApiImpl.getInstance(OmniRtcEngineImpl.this.mContext).stopCapture();
                instance.muteLocalAudio(true);
                instance.muteAllRemoteAudio(true);
                return 0;
            }
        });
    }

    public int enableLocalAudio(final boolean z) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "enabled : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.log("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                int enableLocalAudio = OmniRtcEngineImpl.this.mOmniAudioModule.enableLocalAudio(z);
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Boolean.valueOf(z), Integer.valueOf(enableLocalAudio));
                return enableLocalAudio;
            }
        });
    }

    public int muteLocalAudioStream(final boolean z) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "muted : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.log("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                int muteLocalAudio = EnterConfApi.getInstance().muteLocalAudio(z);
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Boolean.valueOf(z), Integer.valueOf(muteLocalAudio));
                return muteLocalAudio;
            }
        });
    }

    public int muteAllRemoteAudioStreams(final boolean z) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "muted : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.log("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Boolean.valueOf(z));
                EnterConfApi.getInstance().muteAllRemoteAudioForChannel(z);
                return 0;
            }
        });
    }

    public int muteRemoteAudioStream(long j, boolean z) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str = invokedMethodName;
        final long j2 = j;
        final boolean z2 = z;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "uid : " + j + " | muted : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.log("RtcEngine not created! " + str);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(str, Long.valueOf(j2), Boolean.valueOf(z2));
                return EnterConfApi.getInstance().muteRemoteAudio(j2, z2);
            }
        });
    }

    public int setDefaultMuteAllRemoteAudioStreams(final boolean z) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "muted : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Boolean.valueOf(z));
                GlobalConfig.mDefaultMuteAllRemoteAudioStreams = z;
                return 0;
            }
        });
    }

    public int enableVideo() {
        final String invokedMethodName = getInvokedMethodName();
        return this.mOmniInterSyncHelperImpl.executeInter(invokedMethodName, new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.log("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, new Object[0]);
                Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(OmniModuleConstants.VIDEO_ENABLED, new Object[]{true}));
                if (handleVideoModule != null) {
                    return ((Integer) handleVideoModule).intValue();
                }
                return -6;
            }
        });
    }

    public int disableVideo() {
        final String invokedMethodName = getInvokedMethodName();
        return this.mOmniInterSyncHelperImpl.executeInter(invokedMethodName, new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.log("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, new Object[0]);
                Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(OmniModuleConstants.VIDEO_ENABLED, new Object[]{false}));
                if (handleVideoModule != null) {
                    return ((Integer) handleVideoModule).intValue();
                }
                return -6;
            }
        });
    }

    public int enableVideoImproveModule(final boolean z) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "enabled : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (GlobalConfig.mIsInRoom.get()) {
                    return -3;
                }
                GlobalConfig.mVideoImproveEnabled = z;
                return 0;
            }
        });
    }

    public int setVideoEncoderConfiguration(final VideoEncoderConfiguration videoEncoderConfiguration) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        StringBuilder sb = new StringBuilder();
        sb.append("config : ");
        sb.append(videoEncoderConfiguration == null ? "null" : videoEncoderConfiguration.toString());
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, sb.toString(), (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                VideoEncoderConfiguration videoEncoderConfiguration = videoEncoderConfiguration;
                if (videoEncoderConfiguration == null) {
                    return -5;
                }
                Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(12, new Object[]{videoEncoderConfiguration}));
                if (handleVideoModule != null) {
                    return ((Integer) handleVideoModule).intValue();
                }
                return -6;
            }
        });
    }

    public int setVideoProfile(final int i, final boolean z) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "profile : " + i + " | swapWidthAndHeight : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Integer.valueOf(i), Boolean.valueOf(z));
                OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(10, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}));
                return 0;
            }
        });
    }

    public int setVideoProfile(int i, int i2, int i3, int i4) {
        if (this.mLastVideoEncWidth == i && this.mLastVideoEncHeight == i2 && this.mLastVideoEncBitrate == i4 && this.mLastVideoEncFps == i3) {
            return 0;
        }
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str = invokedMethodName;
        final int i5 = i;
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "width : " + i + " | height : " + i2 + " | frameRate : " + i3 + " | bitRate : " + i4, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                int i;
                int i2;
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + str);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(str, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
                int i3 = i5;
                if (i3 <= 0 || (i = i6) <= 0 || (i2 = i7) <= 0 || i8 <= 0 || i * i3 > 2073600 || i2 > 30) {
                    return -5;
                }
                int unused = OmniRtcEngineImpl.this.mLastVideoEncWidth = i3;
                int unused2 = OmniRtcEngineImpl.this.mLastVideoEncHeight = i6;
                int unused3 = OmniRtcEngineImpl.this.mLastVideoEncBitrate = i8;
                int unused4 = OmniRtcEngineImpl.this.mLastVideoEncFps = i7;
                OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(11, new Object[]{Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}));
                return 0;
            }
        });
    }

    public int enableLocalVideo(final boolean z) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "enabled : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.log("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                if (z) {
                    GlobalConfig.mVideoCapStartTimestamp = System.currentTimeMillis();
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Boolean.valueOf(z));
                Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(OmniModuleConstants.VIDEO_LOCAL_ENABLED, new Object[]{Boolean.valueOf(z)}));
                if (handleVideoModule != null) {
                    return ((Integer) handleVideoModule).intValue();
                }
                return -6;
            }
        });
    }

    public int muteLocalVideoStream(final boolean z) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "muted : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.log("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                int i = -6;
                Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(OmniModuleConstants.VIDEO_LOCAL_STREAM_ENABLED, new Object[]{Boolean.valueOf(z)}));
                if (handleVideoModule != null) {
                    i = ((Integer) handleVideoModule).intValue();
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Boolean.valueOf(z), Integer.valueOf(i));
                return i;
            }
        });
    }

    public int startPreview() {
        final String invokedMethodName = getInvokedMethodName();
        return this.mOmniInterSyncHelperImpl.executeInter(invokedMethodName, new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.log("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, new Object[0]);
                Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(3, new Object[]{true}));
                if (handleVideoModule != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("startPreview ret:");
                    Integer num = (Integer) handleVideoModule;
                    sb.append(num.intValue());
                    OmniLog.i(sb.toString());
                    return num.intValue();
                }
                OmniLog.i("startPreview ret:-6");
                return -6;
            }
        });
    }

    public int stopPreview() {
        final String invokedMethodName = getInvokedMethodName();
        return this.mOmniInterSyncHelperImpl.executeInter(invokedMethodName, new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, new Object[0]);
                if (!GlobalConfig.mVideoEnabled) {
                    OmniLog.e("stopPreview mVideoEnabled:" + GlobalConfig.mVideoEnabled);
                    return -3;
                }
                Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(3, new Object[]{false}));
                if (handleVideoModule != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("stopPreview handleVideoModule:");
                    Integer num = (Integer) handleVideoModule;
                    sb.append(num.intValue());
                    OmniLog.i(sb.toString());
                    return num.intValue();
                }
                OmniLog.i("stopPreview ret:-6");
                return -6;
            }
        });
    }

    public int setLogFile(final String str) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        int executeInter = omniInterSyncHelperImpl.executeInter(invokedMethodName, "logPath : " + str, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                String str;
                try {
                    if (TextUtils.isEmpty(str)) {
                        String unused = OmniRtcEngineImpl.this.mCacheLogPath = "";
                        return 0;
                    }
                    File file = new File(str);
                    if (file.isFile()) {
                        str = file.getParent();
                        OmniLog.i(OmniLog.RECORD_LOG_WATCH, "setLogFile -> Receive File not Dir! " + str);
                    } else {
                        str = file.getAbsolutePath();
                    }
                    if (str != null) {
                        if (!str.equals(OmniRtcEngineImpl.this.mCacheLogPath)) {
                            String unused2 = OmniRtcEngineImpl.this.mCacheLogPath = str;
                            String access$900 = OmniRtcEngineImpl.TAG;
                            OmniLog.i(OmniLog.RECORD_LOG_WATCH, access$900, "Setting log save path = " + str);
                            int i = GlobalConfig.mLogFilterLevel;
                        }
                    }
                    return 0;
                } catch (Exception e) {
                    OmniLog.e(OmniLog.RECORD_LOG_WATCH, "setLogFile exception -> " + e.getLocalizedMessage());
                    return -6;
                }
            }
        });
        buildReportLogAndSend(invokedMethodName, str, Integer.valueOf(executeInter));
        return executeInter;
    }

    public int setLogFilter(final int i) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        int executeInter = omniInterSyncHelperImpl.executeInter(invokedMethodName, "logLevel : " + i, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                GlobalConfig.mLogFilterLevel = i;
                OmniLog.PRINT_FAST_MSG = i == 2063;
                if (OmniRtcEngineImpl.this.mLogRecorder != null) {
                    if (GlobalConfig.mLogFilterLevel == 0) {
                        OmniRtcEngineImpl.this.mLogRecorder.stop();
                    } else {
                        OmniRtcEngineImpl.this.mLogRecorder.start();
                    }
                }
                return 0;
            }
        });
        buildReportLogAndSend(invokedMethodName, Integer.valueOf(i), Integer.valueOf(executeInter));
        return executeInter;
    }

    public int setupLocalVideo(VideoCanvas videoCanvas) {
        int screenOrientation = PhoneUtils.getScreenOrientation(this.mContext);
        String str = TAG;
        OmniLog.i(str, "Setup local video -> screenOrientation : " + screenOrientation);
        VideoRotate videoRotate = VideoRotate.ROTATE_0;
        if (1 == screenOrientation) {
            videoRotate = VideoRotate.ROTATE_90;
        }
        return setupLocalVideo(videoCanvas, videoRotate);
    }

    public int setupLocalVideo(final VideoCanvas videoCanvas, final int i) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        StringBuilder sb = new StringBuilder();
        sb.append("canvas : ");
        sb.append(videoCanvas == null ? "null" : videoCanvas.toString());
        sb.append(" | activityOrientation : ");
        sb.append(i);
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, sb.toString(), (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.log("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                int access$2000 = OmniRtcEngineImpl.this.executingSetupLocalVideo(videoCanvas, false, i, (VideoRotate) null);
                OmniRtcEngineImpl omniRtcEngineImpl2 = OmniRtcEngineImpl.this;
                String str = invokedMethodName;
                Object[] objArr = new Object[3];
                VideoCanvas videoCanvas = videoCanvas;
                objArr[0] = videoCanvas == null ? "null" : videoCanvas.toString();
                objArr[1] = Integer.valueOf(i);
                objArr[2] = Integer.valueOf(access$2000);
                omniRtcEngineImpl2.buildReportLogAndSend(str, objArr);
                return access$2000;
            }
        });
    }

    public int setupLocalVideo(final VideoCanvas videoCanvas, final VideoRotate videoRotate) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        StringBuilder sb = new StringBuilder();
        sb.append("canvas : ");
        sb.append(videoCanvas == null ? "null" : videoCanvas.toString());
        sb.append(" | rotate : ");
        sb.append(videoRotate);
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, sb.toString(), (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.log("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                int access$2000 = OmniRtcEngineImpl.this.executingSetupLocalVideo(videoCanvas, true, -1, videoRotate);
                OmniRtcEngineImpl omniRtcEngineImpl2 = OmniRtcEngineImpl.this;
                String str = invokedMethodName;
                Object[] objArr = new Object[3];
                VideoCanvas videoCanvas = videoCanvas;
                objArr[0] = videoCanvas == null ? "null" : videoCanvas.toString();
                objArr[1] = videoRotate;
                objArr[2] = Integer.valueOf(access$2000);
                omniRtcEngineImpl2.buildReportLogAndSend(str, objArr);
                return access$2000;
            }
        });
    }

    public int setupRemoteVideo(VideoCanvas videoCanvas) {
        return setupRemoteVideoInternal(videoCanvas, (InterCorrectUserBean) null);
    }

    public int setupRemoteVideoInternal(final VideoCanvas videoCanvas, final InterCorrectUserBean interCorrectUserBean) {
        String str;
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        StringBuilder sb = new StringBuilder();
        sb.append("canvas : ");
        String str2 = "null";
        if (videoCanvas == null) {
            str = str2;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(videoCanvas.toString());
            sb2.append(", cache : ");
            sb2.append(interCorrectUserBean == null ? str2 : interCorrectUserBean.toString());
            str = sb2.toString();
        }
        sb.append(str);
        int executeInter = omniInterSyncHelperImpl.executeInter("setupRemoteVideo", sb.toString(), (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniLog.e(OmniRtcEngineImpl.TAG, "RtcEngine not created! setupRemoteVideo");
                    return -7;
                } else if (videoCanvas == null) {
                    OmniLog.e(OmniRtcEngineImpl.TAG, "canvas is null setupRemoteVideo");
                    return -1;
                } else if (!GlobalConfig.mVideoEnabled) {
                    String access$900 = OmniRtcEngineImpl.TAG;
                    OmniLog.e(access$900, "mVideoEnabled: " + GlobalConfig.mVideoEnabled + "setupRemoteVideo");
                    return -3;
                } else {
                    SurfaceView surface = videoCanvas.getSurface();
                    TextureView viewRenderView = videoCanvas.getViewRenderView();
                    if (surface == null && viewRenderView == null) {
                        String access$9002 = OmniRtcEngineImpl.TAG;
                        OmniLog.e(access$9002, "surfaceView: " + surface + " textureView:" + viewRenderView + "setupRemoteVideo");
                        return -5;
                    }
                    String channelId = videoCanvas.getChannelId();
                    if (interCorrectUserBean == null) {
                        if (TextUtils.isEmpty(channelId)) {
                            videoCanvas.setChannelId(LocalSDKConstants.ENGINE_CHANNEL_ID);
                        }
                        OmniRtcEngineImpl.this.mOmniRtcEngineAssist.putCacheOptForSetupRemoteVideo(videoCanvas);
                    } else if (!OmniRtcEngineImpl.this.mOmniRtcEngineAssist.checkCacheOptForSetupRemoteVideo(interCorrectUserBean)) {
                        return 0;
                    }
                    String channelId2 = videoCanvas.getChannelId();
                    long userID = videoCanvas.getUserID();
                    String deviceID = videoCanvas.getDeviceID();
                    if (LocalSDKConstants.ENGINE_CHANNEL_ID.equals(channelId2)) {
                        channelId2 = GlobalConfig.mLocalRoomName;
                    }
                    RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(channelId2);
                    if (userManager == null) {
                        String access$9003 = OmniRtcEngineImpl.TAG;
                        OmniLog.e(access$9003, "Setup remote video failed! RtcUserManager is null, channelName = " + channelId2);
                        return 0;
                    } else if (userManager.getUser(userID) == null) {
                        String access$9004 = OmniRtcEngineImpl.TAG;
                        OmniLog.e(access$9004, "Setup remote video failed! User is null, channelName = " + channelId2 + ", uid = " + userID);
                        return 0;
                    } else {
                        if (!TextUtils.isEmpty(deviceID)) {
                            userManager.updateUserDeviceIdWithOpened(userID, deviceID);
                            boolean controlUserVideoDevice = EnterConfApi.getInstance().controlUserVideoDevice(channelId2, userID, deviceID, true);
                            if (!controlUserVideoDevice) {
                                String access$9005 = OmniRtcEngineImpl.TAG;
                                OmniLog.e(access$9005, "controlUserVideoDevice: " + controlUserVideoDevice + "setupRemoteVideo");
                                return -6;
                            }
                        } else {
                            deviceID = String.valueOf(userID);
                            userManager.updateUserDeviceIdWithOpened(userID, deviceID);
                        }
                        Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(8, new Object[]{surface, viewRenderView, String.valueOf(channelId2), Long.valueOf(userID), deviceID, Integer.valueOf(videoCanvas.getShowMode())}));
                        if (handleVideoModule != null) {
                            return ((Integer) handleVideoModule).intValue();
                        }
                        return -6;
                    }
                }
            }
        });
        Object[] objArr = new Object[2];
        if (videoCanvas != null) {
            str2 = videoCanvas.toString();
        }
        objArr[0] = str2;
        objArr[1] = Integer.valueOf(executeInter);
        buildReportLogAndSend("setupRemoteVideo", objArr);
        return executeInter;
    }

    public int setupRemoteVideoMixer(final OmniVideoMixerCanvas omniVideoMixerCanvas) {
        return this.mOmniInterSyncHelperImpl.executeInter("setupRemoteVideoMixer", new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                Object[] objArr = new Object[1];
                OmniVideoMixerCanvas omniVideoMixerCanvas = omniVideoMixerCanvas;
                objArr[0] = omniVideoMixerCanvas == null ? "null" : omniVideoMixerCanvas.toString();
                omniRtcEngineImpl.buildReportLogAndSend("setupRemoteVideoMixer", objArr);
                OmniVideoMixerCanvas omniVideoMixerCanvas2 = omniVideoMixerCanvas;
                if (omniVideoMixerCanvas2 == null || TextUtils.isEmpty(omniVideoMixerCanvas2.getDevId())) {
                    return -5;
                }
                if (!GlobalConfig.mIsEnableVideoMixer.get()) {
                    return -6;
                }
                return 0;
            }
        });
    }

    public int switchCamera() {
        final String invokedMethodName = getInvokedMethodName();
        return this.mOmniInterSyncHelperImpl.executeInter(invokedMethodName, new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend("switchCamera", new Object[0]);
                if (!GlobalConfig.mVideoEnabled) {
                    return -3;
                }
                Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(151, new Object[0]));
                if (handleVideoModule != null) {
                    return ((Integer) handleVideoModule).intValue();
                }
                return -6;
            }
        });
    }

    public int setEnableSpeakerphone(final boolean z) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("setEnableSpeakerphone isOpenSpeaker : " + z, new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("setEnableSpeakerphone", Boolean.valueOf(z));
                EnterConfApi.getInstance().setSpeakerphoneOn(z);
                return 0;
            }
        });
    }

    public boolean isSpeakerphoneEnabled() {
        return this.mOmniInterSyncHelperImpl.executeInterBool("isSpeakerphoneEnabled", new OmniInterSyncHelper() {
            public boolean runBool() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("isSpeakerphoneEnabled", new Object[0]);
                AudioManager audioManager = (AudioManager) OmniRtcEngineImpl.this.mContext.getSystemService("audio");
                if (audioManager != null) {
                    return audioManager.isSpeakerphoneOn();
                }
                return true;
            }
        });
    }

    public int muteRemoteVideoStream(long j, boolean z) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str = invokedMethodName;
        final long j2 = j;
        final boolean z2 = z;
        int executeInter = omniInterSyncHelperImpl.executeInter(invokedMethodName, "uid : " + j + " | muted : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (!OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    return EnterConfApi.getInstance().muteRemoteVideo(j2, z2);
                }
                OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                omniRtcEngineImpl.debugLogW("RtcEngine not created! " + str);
                return -7;
            }
        });
        buildReportLogAndSend(invokedMethodName, Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(executeInter));
        return executeInter;
    }

    public int muteRemoteVideoStream(long j, int i, boolean z) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str = invokedMethodName;
        final long j2 = j;
        final int i2 = i;
        final boolean z2 = z;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "uid : " + j + " | videoType : " + i + " | muted : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + str);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(str, Long.valueOf(j2), Integer.valueOf(i2), Boolean.valueOf(z2));
                if (!GlobalConfig.mIsInRoom.get()) {
                    return 0;
                }
                return EnterConfApi.getInstance().controlDeviceVideoByType(!z2, j2, i2);
            }
        });
    }

    public int muteRemoteVideoStream(long j, String str, boolean z) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str2 = invokedMethodName;
        final String str3 = str;
        final long j2 = j;
        final boolean z2 = z;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "uid : " + j + " | deviceId : " + str + " | muted : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + str2);
                    return 0;
                }
                boolean isEmpty = TextUtils.isEmpty(str3);
                OmniRtcEngineImpl omniRtcEngineImpl2 = OmniRtcEngineImpl.this;
                String str = str2;
                Object[] objArr = new Object[3];
                objArr[0] = Long.valueOf(j2);
                objArr[1] = isEmpty ? "null" : str3;
                objArr[2] = Boolean.valueOf(z2);
                omniRtcEngineImpl2.buildReportLogAndSend(str, objArr);
                if (isEmpty) {
                    return -5;
                }
                if (GlobalConfig.mIsInRoom.get() && !EnterConfApi.getInstance().controlUserVideoDevice(GlobalConfig.mLocalRoomName, j2, str3, !z2)) {
                    return -6;
                }
                return 0;
            }
        });
    }

    public int muteAllRemoteVideoStreams(final boolean z) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "muted : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Boolean.valueOf(z));
                EnterConfApi.getInstance().muteAllRemoteVideoForChannel(z);
                return 0;
            }
        });
    }

    public int setDefaultMuteAllRemoteVideoStreams(final boolean z) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "muted : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Boolean.valueOf(z));
                GlobalConfig.mDefaultMuteAllRemoteVideoStreams = z;
                return 0;
            }
        });
    }

    public int setDefaultAudioRouteToSpeakerphone(boolean z) {
        int i = 1;
        buildReportLogAndSend("setDefaultAudioRouteToSpeakerphone", Boolean.valueOf(z));
        if (GlobalConfig.mIsInRoom.get()) {
            return -3;
        }
        if (!z) {
            i = 2;
        }
        GlobalConfig.mDefaultAudioRoute = i;
        return 0;
    }

    public int subscribeOtherChannel(final String str) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "channelName : " + str, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, str);
                if (OmniRtcEngineImpl.this.mRtcInvokeSafetyChecker.checkCurrentRoomStatus() && OmniRtcEngineImpl.this.mRtcInvokeSafetyChecker.checkCurrentRole(1)) {
                    return 0;
                }
                return -3;
            }
        });
    }

    public int unSubscribeOtherChannel(final String str) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "channelName : " + str, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, str);
                if (OmniRtcEngineImpl.this.mRtcInvokeSafetyChecker.checkCurrentRoomStatus() && OmniRtcEngineImpl.this.mRtcInvokeSafetyChecker.checkCurrentRole(1)) {
                    return 0;
                }
                return -3;
            }
        });
    }

    public int stopAudioPlayAndRecord(final boolean z) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("stopAudioPlayAndRecord stop : " + z, new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("stopAudioPlayAndRecord", Boolean.valueOf(z));
                if (!GlobalConfig.mIsInRoom.get()) {
                    return -3;
                }
                if (z) {
                    MyAudioApiImpl.getInstance(OmniRtcEngineImpl.this.mContext).pauseAudio();
                } else {
                    MyAudioApiImpl.getInstance(OmniRtcEngineImpl.this.mContext).resumeAudio();
                }
                return 0;
            }
        });
    }

    public int setAudioMode(final int i) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "mode : " + i, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Integer.valueOf(i));
                return OmniRtcEngineImpl.this.mOmniAudioModule.setAudioMode(i);
            }
        });
    }

    public int setAudioEncoderConfiguration(final int i, final int i2) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "bitrate : " + i + " | processMode : " + i2, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                int audioEncoderConfiguration = OmniRtcEngineImpl.this.mOmniAudioModule.setAudioEncoderConfiguration(i, i2);
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(audioEncoderConfiguration));
                return audioEncoderConfiguration;
            }
        });
    }

    public int setAudioMixMode(final int i, final long[] jArr) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        StringBuilder sb = new StringBuilder();
        sb.append("mixMode = ");
        sb.append(i);
        sb.append(", uid = ");
        sb.append(jArr == null ? "null" : Arrays.toString(jArr));
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, sb.toString(), (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                int audioMixMode = OmniRtcEngineImpl.this.mOmniAudioModule.setAudioMixMode(i, jArr);
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Integer.valueOf(i), jArr, Integer.valueOf(audioMixMode));
                return audioMixMode;
            }
        });
    }

    public int setVideoMixerParams(int i, int i2, int i3, int i4, int i5, int i6) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        StringBuilder sb = new StringBuilder();
        sb.append("bitrate : ");
        final int i7 = i;
        sb.append(i);
        sb.append(" | fps : ");
        final int i8 = i2;
        sb.append(i8);
        sb.append(" | width : ");
        final int i9 = i3;
        sb.append(i9);
        sb.append(" | height : ");
        final int i10 = i4;
        sb.append(i10);
        sb.append(" | mode : ");
        final int i11 = i5;
        sb.append(i11);
        final String str = invokedMethodName;
        final int i12 = i6;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, sb.toString(), (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                int i;
                OmniRtcEngineImpl.this.buildReportLogAndSend(str, Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10));
                if (i7 <= 0 || i8 <= 0 || (i = i9) <= 0 || i10 <= 0) {
                    return -5;
                }
                int i2 = i11;
                if (i2 != 160601 && i2 != 160602) {
                    return -5;
                }
                int unused = OmniRtcEngineImpl.this.mVideoMixerWidth = i;
                int unused2 = OmniRtcEngineImpl.this.mVideoMixerHeight = i10;
                EnterConfApi.getInstance().setVideoMixerParams(i7, i8, i9, i10, i11, i12);
                return 0;
            }
        });
    }

    public int setAudioMixerParams(final int i, final int i2, final int i3) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("setAudioMixerParams bitrate : " + i + " | samplerate : " + i2 + " | channels : " + i3, new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("setVideoMixerParams", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                return 0;
            }
        });
    }

    public int setVideoCompositingLayout(final VideoCompositingLayout videoCompositingLayout) {
        String str;
        String invokedMethodName = getInvokedMethodName();
        Object[] objArr = new Object[1];
        if (videoCompositingLayout == null) {
            str = "null";
        } else {
            str = videoCompositingLayout.toString();
        }
        objArr[0] = str;
        buildReportLogAndSend(invokedMethodName, objArr);
        if (videoCompositingLayout == null) {
            return -5;
        }
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "layout : " + videoCompositingLayout.toString(), (OmniInterSyncHelper) new OmniInterSyncHelper() {
            /* JADX WARNING: Removed duplicated region for block: B:87:0x0260 A[Catch:{ JSONException -> 0x0283 }] */
            /* JADX WARNING: Removed duplicated region for block: B:88:0x0265 A[Catch:{ JSONException -> 0x0283 }] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public int run() {
                /*
                    r24 = this;
                    r0 = r24
                    long r1 = com.wushuangtech.library.GlobalConfig.mLocalUserID
                    java.lang.String r3 = com.wushuangtech.library.GlobalConfig.mLocalRoomName
                    r4 = 0
                    int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
                    r5 = -3
                    if (r4 == 0) goto L_0x0288
                    boolean r4 = android.text.TextUtils.isEmpty(r3)
                    if (r4 == 0) goto L_0x0015
                    goto L_0x0288
                L_0x0015:
                    com.wushuangtech.library.GlobalHolder r4 = com.wushuangtech.library.GlobalHolder.getInstance()
                    com.wushuangtech.api.RtcDeviceManager r3 = r4.getDeviceManager(r3)
                    if (r3 != 0) goto L_0x0020
                    return r5
                L_0x0020:
                    int r4 = com.wushuangtech.library.GlobalConfig.mBranch
                    int r6 = com.wushuangtech.constants.LocalSDKConstants.BRANCH_CLIENT_YQ
                    r7 = -5
                    r8 = 1
                    if (r4 == r6) goto L_0x002d
                    int r4 = com.wushuangtech.library.GlobalConfig.mLocalRole
                    if (r4 == r8) goto L_0x002d
                    return r7
                L_0x002d:
                    com.wushuangtech.expansion.bean.VideoCompositingLayout r4 = r5
                    com.wushuangtech.expansion.bean.VideoCompositingLayout$Region[] r4 = r4.regions
                    if (r4 == 0) goto L_0x0287
                    int r6 = r4.length
                    if (r6 > 0) goto L_0x0038
                    goto L_0x0287
                L_0x0038:
                    r6 = -6
                    com.wushuangtech.library.UserDeviceConfig r7 = r3.getVideoDeviceForDefault(r1)     // Catch:{ JSONException -> 0x0285 }
                    java.lang.String r9 = "SEI -> setVideoCompositingLayout error! < "
                    if (r7 != 0) goto L_0x0059
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0285 }
                    r3.<init>()     // Catch:{ JSONException -> 0x0285 }
                    r3.append(r9)     // Catch:{ JSONException -> 0x0285 }
                    r3.append(r1)     // Catch:{ JSONException -> 0x0285 }
                    java.lang.String r1 = " > Get local device obj is null!"
                    r3.append(r1)     // Catch:{ JSONException -> 0x0285 }
                    java.lang.String r1 = r3.toString()     // Catch:{ JSONException -> 0x0285 }
                    com.wushuangtech.utils.OmniLog.e(r1)     // Catch:{ JSONException -> 0x0285 }
                    return r6
                L_0x0059:
                    java.lang.String r7 = r7.getDeviceId()     // Catch:{ JSONException -> 0x0285 }
                    boolean r10 = android.text.TextUtils.isEmpty(r7)     // Catch:{ JSONException -> 0x0285 }
                    if (r10 == 0) goto L_0x007b
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0285 }
                    r3.<init>()     // Catch:{ JSONException -> 0x0285 }
                    r3.append(r9)     // Catch:{ JSONException -> 0x0285 }
                    r3.append(r1)     // Catch:{ JSONException -> 0x0285 }
                    java.lang.String r1 = " > Get local device id is null!"
                    r3.append(r1)     // Catch:{ JSONException -> 0x0285 }
                    java.lang.String r1 = r3.toString()     // Catch:{ JSONException -> 0x0285 }
                    com.wushuangtech.utils.OmniLog.e(r1)     // Catch:{ JSONException -> 0x0285 }
                    return r6
                L_0x007b:
                    org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0285 }
                    r1.<init>()     // Catch:{ JSONException -> 0x0285 }
                    java.lang.String r2 = "mid"
                    r1.put(r2, r7)     // Catch:{ JSONException -> 0x0285 }
                    org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0285 }
                    r2.<init>()     // Catch:{ JSONException -> 0x0285 }
                    int r10 = r4.length     // Catch:{ JSONException -> 0x0285 }
                    r12 = 0
                L_0x008c:
                    java.lang.String r13 = "h"
                    java.lang.String r14 = "w"
                    if (r12 >= r10) goto L_0x01a8
                    r15 = r4[r12]     // Catch:{ JSONException -> 0x0285 }
                    if (r15 != 0) goto L_0x009d
                    r23 = r9
                    r6 = r10
                    r16 = r12
                    goto L_0x019e
                L_0x009d:
                    org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0283 }
                    r6.<init>()     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r8 = r15.mDeviceID     // Catch:{ JSONException -> 0x0283 }
                    boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ JSONException -> 0x0283 }
                    if (r8 == 0) goto L_0x00f7
                    r16 = r12
                    long r11 = r15.mUserID     // Catch:{ JSONException -> 0x0283 }
                    com.wushuangtech.library.UserDeviceConfig r11 = r3.getVideoDeviceForDefault(r11)     // Catch:{ JSONException -> 0x0283 }
                    if (r11 != 0) goto L_0x00ce
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0283 }
                    r1.<init>()     // Catch:{ JSONException -> 0x0283 }
                    r1.append(r9)     // Catch:{ JSONException -> 0x0283 }
                    long r2 = r15.mUserID     // Catch:{ JSONException -> 0x0283 }
                    r1.append(r2)     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r2 = " > 获取此用户ID对应默认的设备ID是空的!"
                    r1.append(r2)     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0283 }
                    com.wushuangtech.utils.OmniLog.e(r1)     // Catch:{ JSONException -> 0x0283 }
                    return r5
                L_0x00ce:
                    java.lang.String r12 = r11.getDeviceId()     // Catch:{ JSONException -> 0x0283 }
                    boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ JSONException -> 0x0283 }
                    if (r12 == 0) goto L_0x00f2
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0283 }
                    r1.<init>()     // Catch:{ JSONException -> 0x0283 }
                    r1.append(r9)     // Catch:{ JSONException -> 0x0283 }
                    long r2 = r15.mUserID     // Catch:{ JSONException -> 0x0283 }
                    r1.append(r2)     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r2 = " > 从UserDeviceConfig获取此用户ID对应默认的设备ID是空的!"
                    r1.append(r2)     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0283 }
                    com.wushuangtech.utils.OmniLog.e(r1)     // Catch:{ JSONException -> 0x0283 }
                    return r5
                L_0x00f2:
                    java.lang.String r11 = r11.getDeviceId()     // Catch:{ JSONException -> 0x0283 }
                    goto L_0x011d
                L_0x00f7:
                    r16 = r12
                    java.lang.String r11 = r15.mDeviceID     // Catch:{ JSONException -> 0x0283 }
                    com.wushuangtech.library.UserDeviceConfig r11 = r3.getVideoDeviceByDeviceId(r11)     // Catch:{ JSONException -> 0x0283 }
                    if (r11 != 0) goto L_0x011b
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0283 }
                    r1.<init>()     // Catch:{ JSONException -> 0x0283 }
                    r1.append(r9)     // Catch:{ JSONException -> 0x0283 }
                    long r2 = r15.mUserID     // Catch:{ JSONException -> 0x0283 }
                    r1.append(r2)     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r2 = " > 获取此用户设备ID对应UserDeviceConfig是空的!"
                    r1.append(r2)     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0283 }
                    com.wushuangtech.utils.OmniLog.e(r1)     // Catch:{ JSONException -> 0x0283 }
                    return r5
                L_0x011b:
                    java.lang.String r11 = r15.mDeviceID     // Catch:{ JSONException -> 0x0283 }
                L_0x011d:
                    boolean r12 = r7.equals(r11)     // Catch:{ JSONException -> 0x0283 }
                    if (r12 != 0) goto L_0x015a
                    com.wushuangtech.api.EnterConfApi r17 = com.wushuangtech.api.EnterConfApi.getInstance()     // Catch:{ JSONException -> 0x0283 }
                    r23 = r9
                    long r8 = r15.mUserID     // Catch:{ JSONException -> 0x0283 }
                    r21 = 1
                    com.wushuangtech.expansion.bean.VideoCompositingLayout r12 = r5     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r12 = r12.mStreamUrl     // Catch:{ JSONException -> 0x0283 }
                    r18 = r8
                    r20 = r11
                    r22 = r12
                    r17.mixGuestVideo(r18, r20, r21, r22)     // Catch:{ JSONException -> 0x0283 }
                    java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0283 }
                    r8.<init>()     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r9 = "SEI -> RtmpAddVideo uid : "
                    r8.append(r9)     // Catch:{ JSONException -> 0x0283 }
                    r12 = r6
                    long r5 = r15.mUserID     // Catch:{ JSONException -> 0x0283 }
                    r8.append(r5)     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r5 = " | device id : "
                    r8.append(r5)     // Catch:{ JSONException -> 0x0283 }
                    r8.append(r11)     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r5 = r8.toString()     // Catch:{ JSONException -> 0x0283 }
                    com.wushuangtech.utils.OmniLog.i(r5)     // Catch:{ JSONException -> 0x0283 }
                    goto L_0x015d
                L_0x015a:
                    r12 = r6
                    r23 = r9
                L_0x015d:
                    java.lang.String r5 = "id"
                    r12.put(r5, r11)     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r5 = "z"
                    int r6 = r15.zOrder     // Catch:{ JSONException -> 0x0283 }
                    r12.put(r5, r6)     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r5 = "x"
                    r6 = r10
                    double r9 = r15.x     // Catch:{ JSONException -> 0x0283 }
                    r12.put(r5, r9)     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r5 = "y"
                    double r9 = r15.y     // Catch:{ JSONException -> 0x0283 }
                    r12.put(r5, r9)     // Catch:{ JSONException -> 0x0283 }
                    double r9 = r15.width     // Catch:{ JSONException -> 0x0283 }
                    r12.put(r14, r9)     // Catch:{ JSONException -> 0x0283 }
                    double r9 = r15.height     // Catch:{ JSONException -> 0x0283 }
                    r12.put(r13, r9)     // Catch:{ JSONException -> 0x0283 }
                    int r5 = com.wushuangtech.library.GlobalConfig.mBranch     // Catch:{ JSONException -> 0x0283 }
                    int r9 = com.wushuangtech.constants.LocalSDKConstants.BRANCH_CLIENT_QUANMIN     // Catch:{ JSONException -> 0x0283 }
                    if (r5 != r9) goto L_0x019b
                    java.lang.String r5 = "slotIndex"
                    int r9 = r15.slotIndex     // Catch:{ JSONException -> 0x0283 }
                    r12.put(r5, r9)     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r5 = "isVideo"
                    boolean r9 = r15.isVideo     // Catch:{ JSONException -> 0x0283 }
                    if (r9 == 0) goto L_0x0197
                    r9 = 1
                    goto L_0x0198
                L_0x0197:
                    r9 = 0
                L_0x0198:
                    r12.put(r5, r9)     // Catch:{ JSONException -> 0x0283 }
                L_0x019b:
                    r2.put(r12)     // Catch:{ JSONException -> 0x0283 }
                L_0x019e:
                    int r12 = r16 + 1
                    r10 = r6
                    r9 = r23
                    r5 = -3
                    r6 = -6
                    r8 = 1
                    goto L_0x008c
                L_0x01a8:
                    java.lang.String r3 = "pos"
                    r1.put(r3, r2)     // Catch:{ JSONException -> 0x0283 }
                    long r2 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r4 = "ts"
                    r1.put(r4, r2)     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r2 = "ver"
                    java.lang.String r3 = "20161227"
                    r1.put(r2, r3)     // Catch:{ JSONException -> 0x0283 }
                    org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0283 }
                    r2.<init>()     // Catch:{ JSONException -> 0x0283 }
                    com.wushuangtech.expansion.bean.VideoCompositingLayout r3 = r5     // Catch:{ JSONException -> 0x0283 }
                    int r3 = r3.mCanvasWidth     // Catch:{ JSONException -> 0x0283 }
                    if (r3 == 0) goto L_0x01de
                    com.wushuangtech.expansion.bean.VideoCompositingLayout r3 = r5     // Catch:{ JSONException -> 0x0283 }
                    int r3 = r3.mCanvasHeight     // Catch:{ JSONException -> 0x0283 }
                    if (r3 != 0) goto L_0x01cf
                    goto L_0x01de
                L_0x01cf:
                    com.wushuangtech.expansion.bean.VideoCompositingLayout r3 = r5     // Catch:{ JSONException -> 0x0283 }
                    int r3 = r3.mCanvasWidth     // Catch:{ JSONException -> 0x0283 }
                    r2.put(r14, r3)     // Catch:{ JSONException -> 0x0283 }
                    com.wushuangtech.expansion.bean.VideoCompositingLayout r3 = r5     // Catch:{ JSONException -> 0x0283 }
                    int r3 = r3.mCanvasHeight     // Catch:{ JSONException -> 0x0283 }
                    r2.put(r13, r3)     // Catch:{ JSONException -> 0x0283 }
                    goto L_0x022d
                L_0x01de:
                    com.wushuangtech.wstechapi.internal.OmniRtcEngineImpl r3 = com.wushuangtech.wstechapi.internal.OmniRtcEngineImpl.this     // Catch:{ JSONException -> 0x0283 }
                    int r3 = r3.mVideoMixerWidth     // Catch:{ JSONException -> 0x0283 }
                    r4 = -1
                    if (r3 == r4) goto L_0x0202
                    com.wushuangtech.wstechapi.internal.OmniRtcEngineImpl r3 = com.wushuangtech.wstechapi.internal.OmniRtcEngineImpl.this     // Catch:{ JSONException -> 0x0283 }
                    int r3 = r3.mVideoMixerHeight     // Catch:{ JSONException -> 0x0283 }
                    if (r3 == r4) goto L_0x0202
                    com.wushuangtech.wstechapi.internal.OmniRtcEngineImpl r3 = com.wushuangtech.wstechapi.internal.OmniRtcEngineImpl.this     // Catch:{ JSONException -> 0x0283 }
                    int r3 = r3.mVideoMixerWidth     // Catch:{ JSONException -> 0x0283 }
                    r2.put(r14, r3)     // Catch:{ JSONException -> 0x0283 }
                    com.wushuangtech.wstechapi.internal.OmniRtcEngineImpl r3 = com.wushuangtech.wstechapi.internal.OmniRtcEngineImpl.this     // Catch:{ JSONException -> 0x0283 }
                    int r3 = r3.mVideoMixerHeight     // Catch:{ JSONException -> 0x0283 }
                    r2.put(r13, r3)     // Catch:{ JSONException -> 0x0283 }
                    goto L_0x022d
                L_0x0202:
                    com.wushuangtech.api.ExternalVideoModule r3 = com.wushuangtech.api.ExternalVideoModule.getInstance()     // Catch:{ JSONException -> 0x0283 }
                    com.wushuangtech.api.ExternalVideoModuleImpl r3 = (com.wushuangtech.api.ExternalVideoModuleImpl) r3     // Catch:{ JSONException -> 0x0283 }
                    int[] r3 = r3.getEncodeSize()     // Catch:{ JSONException -> 0x0283 }
                    if (r3 == 0) goto L_0x0223
                    r4 = 0
                    r5 = r3[r4]     // Catch:{ JSONException -> 0x0283 }
                    if (r5 == 0) goto L_0x0223
                    r5 = 1
                    r6 = r3[r5]     // Catch:{ JSONException -> 0x0283 }
                    if (r6 == 0) goto L_0x0223
                    r6 = r3[r4]     // Catch:{ JSONException -> 0x0283 }
                    r2.put(r14, r6)     // Catch:{ JSONException -> 0x0283 }
                    r3 = r3[r5]     // Catch:{ JSONException -> 0x0283 }
                    r2.put(r13, r3)     // Catch:{ JSONException -> 0x0283 }
                    goto L_0x022d
                L_0x0223:
                    r3 = 352(0x160, float:4.93E-43)
                    r2.put(r14, r3)     // Catch:{ JSONException -> 0x0283 }
                    r3 = 640(0x280, float:8.97E-43)
                    r2.put(r13, r3)     // Catch:{ JSONException -> 0x0283 }
                L_0x022d:
                    org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x0283 }
                    r3.<init>()     // Catch:{ JSONException -> 0x0283 }
                    com.wushuangtech.expansion.bean.VideoCompositingLayout r4 = r5     // Catch:{ JSONException -> 0x0283 }
                    int[] r4 = r4.backgroundColor     // Catch:{ JSONException -> 0x0283 }
                    r5 = 0
                    r4 = r4[r5]     // Catch:{ JSONException -> 0x0283 }
                    org.json.JSONArray r4 = r3.put(r4)     // Catch:{ JSONException -> 0x0283 }
                    com.wushuangtech.expansion.bean.VideoCompositingLayout r5 = r5     // Catch:{ JSONException -> 0x0283 }
                    int[] r5 = r5.backgroundColor     // Catch:{ JSONException -> 0x0283 }
                    r6 = 1
                    r5 = r5[r6]     // Catch:{ JSONException -> 0x0283 }
                    org.json.JSONArray r4 = r4.put(r5)     // Catch:{ JSONException -> 0x0283 }
                    com.wushuangtech.expansion.bean.VideoCompositingLayout r5 = r5     // Catch:{ JSONException -> 0x0283 }
                    int[] r5 = r5.backgroundColor     // Catch:{ JSONException -> 0x0283 }
                    r6 = 2
                    r5 = r5[r6]     // Catch:{ JSONException -> 0x0283 }
                    r4.put(r5)     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r4 = "bgrgb"
                    r2.put(r4, r3)     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r3 = "canvas"
                    r1.put(r3, r2)     // Catch:{ JSONException -> 0x0283 }
                    boolean r2 = r1 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x0283 }
                    if (r2 != 0) goto L_0x0265
                    java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x0283 }
                    goto L_0x026b
                L_0x0265:
                    org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r1 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r1)     // Catch:{ JSONException -> 0x0283 }
                L_0x026b:
                    com.wushuangtech.wstechapi.internal.OmniRtcEngineImpl r2 = com.wushuangtech.wstechapi.internal.OmniRtcEngineImpl.this     // Catch:{ JSONException -> 0x0283 }
                    r2.executingSeiContentInsert(r1)     // Catch:{ JSONException -> 0x0283 }
                    com.wushuangtech.api.EnterConfApi r2 = com.wushuangtech.api.EnterConfApi.getInstance()     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r3 = com.wushuangtech.library.GlobalConfig.mLocalRoomName     // Catch:{ JSONException -> 0x0283 }
                    com.wushuangtech.expansion.bean.VideoCompositingLayout r4 = r5     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r4 = r4.mExtInfos     // Catch:{ JSONException -> 0x0283 }
                    com.wushuangtech.expansion.bean.VideoCompositingLayout r5 = r5     // Catch:{ JSONException -> 0x0283 }
                    java.lang.String r5 = r5.mStreamUrl     // Catch:{ JSONException -> 0x0283 }
                    r2.setSei(r3, r1, r4, r5)     // Catch:{ JSONException -> 0x0283 }
                    r1 = 0
                    return r1
                L_0x0283:
                    r1 = -6
                    goto L_0x0286
                L_0x0285:
                    r1 = r6
                L_0x0286:
                    return r1
                L_0x0287:
                    return r7
                L_0x0288:
                    r1 = r5
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.wstechapi.internal.OmniRtcEngineImpl.AnonymousClass49.run():int");
            }
        });
    }

    public int enableAudioVolumeIndication(final int i, final int i2) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("enableAudioVolumeIndication interval : " + i, new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("enableAudioVolumeIndication", Integer.valueOf(i), Integer.valueOf(i2));
                int i = i;
                if (i <= 0) {
                    i = Integer.MAX_VALUE;
                }
                EnterConfApi.getInstance().setAudioLevelReportInterval(i);
                return 0;
            }
        });
    }

    public int startAudioMixing(String str, boolean z, boolean z2, int i) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str2 = str;
        final boolean z3 = z;
        final boolean z4 = z2;
        final int i2 = i;
        return omniInterSyncHelperImpl.executeInter("startAudioMixing filePath : " + str + " | loopback : " + z + " | replace : " + z2 + " | cycle : " + i, new OmniInterSyncHelper() {
            public int run() {
                int i;
                OmniRtcEngineImpl.this.buildReportLogAndSend("startAudioMixing", str2, Boolean.valueOf(z3), Boolean.valueOf(z4), Integer.valueOf(i2));
                if (TextUtils.isEmpty(str2) || ((i = i2) <= 0 && i != -1)) {
                    return -5;
                }
                String str = str2;
                String transformToPath = AssertUtils.transformToPath(str);
                if (!TextUtils.isEmpty(transformToPath)) {
                    str = AssertUtils.transformToFile(OmniRtcEngineImpl.this.mContext, transformToPath);
                    if (TextUtils.isEmpty(str)) {
                        return -5;
                    }
                }
                int i2 = i2;
                if (i2 == -1) {
                    i2 = Integer.MAX_VALUE;
                }
                boolean startAudioFileMixing = MyAudioApi.getInstance(OmniRtcEngineImpl.this.mContext).startAudioFileMixing(str, z3, i2);
                if (startAudioFileMixing) {
                    if (z4) {
                        MyAudioApi.getInstance(OmniRtcEngineImpl.this.mContext).adjustAudioSoloVolumeScale(0.0d);
                    } else {
                        MyAudioApi.getInstance(OmniRtcEngineImpl.this.mContext).adjustAudioSoloVolumeScale(OmniRtcEngineImpl.this.mAudioMixSoloVolume);
                    }
                }
                if (startAudioFileMixing) {
                    return 0;
                }
                return -3;
            }
        });
    }

    public int stopAudioMixing() {
        return this.mOmniInterSyncHelperImpl.executeInter("stopAudioMixing invoked!", new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("stopAudioMixing", new Object[0]);
                MyAudioApi.getInstance(OmniRtcEngineImpl.this.mContext).stopAudioFileMixing();
                OmniRtcEngineImpl.this.mCurrentAudioMixingPosition = 0;
                OmniRtcEngineImpl.this.mCurrentAudioMixingDuration = 0;
                return 0;
            }
        });
    }

    public int pauseAudioMixing() {
        return this.mOmniInterSyncHelperImpl.executeInter("pauseAudioMixing invoked!", new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("pauseAudioMixing", new Object[0]);
                MyAudioApi.getInstance(OmniRtcEngineImpl.this.mContext).pauseAudioFileMix();
                return 0;
            }
        });
    }

    public int resumeAudioMixing() {
        return this.mOmniInterSyncHelperImpl.executeInter("resumeAudioMixing invoked!", new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("resumeAudioMixing", new Object[0]);
                MyAudioApi.getInstance(OmniRtcEngineImpl.this.mContext).resumeAudioFileMix();
                return 0;
            }
        });
    }

    public int getAudioMixingDuration() {
        return this.mCurrentAudioMixingDuration;
    }

    public boolean kickChannelUser(final long j) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInterBool(invokedMethodName, "uid : " + j, new OmniInterSyncHelper() {
            public boolean runBool() {
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Long.valueOf(j));
                if (EnterConfApi.getInstance().kickUser(GlobalConfig.mLocalRoomName, j) == 0) {
                    return true;
                }
                return false;
            }
        });
    }

    public int muteRemoteSpeaking(long j, boolean z) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str = invokedMethodName;
        final long j2 = j;
        final boolean z2 = z;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "uid : " + j + " | muted : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend(str, Long.valueOf(j2), Boolean.valueOf(z2));
                if (!GlobalConfig.mIsInRoom.get() || GlobalConfig.mCurrentChannelMode != 1 || GlobalConfig.mLocalRole != 1) {
                    return -3;
                }
                if (z2) {
                    RoomJni.getInstance().RoomGrantPermission(j2, 1, 1);
                } else {
                    RoomJni.getInstance().RoomGrantPermission(j2, 1, 3);
                }
                return 0;
            }
        });
    }

    public int getAudioMixingCurrentPosition() {
        return this.mCurrentAudioMixingPosition;
    }

    public int setAudioMixingPosition(long j) {
        MyAudioApi.getInstance((Context) null).seekAudioFileTo((int) (j / 1000));
        return 0;
    }

    public boolean isTextureEncodeSupported() {
        if (!Arrays.asList(H264_HW_BLACKLIST).contains(Build.MODEL) && Build.VERSION.SDK_INT > 18) {
            return true;
        }
        return false;
    }

    public int setExternalVideoSource(final boolean z, final boolean z2, boolean z3) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "enable : " + z + " | useTexture : " + z2 + " | pushMode : " + z3, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Boolean.valueOf(z), Boolean.valueOf(z2));
                boolean z = z && z2 && OmniRtcEngineImpl.this.isTextureEncodeSupported();
                if (!z || OmniRtcEngineImpl.this.isTextureEncodeSupported()) {
                    Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(16, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z)}));
                    if (handleVideoModule == null) {
                        return -6;
                    }
                    if (((Boolean) handleVideoModule).booleanValue()) {
                        return 0;
                    }
                    return -6;
                }
                OmniLog.e("Set external video source failed! Model: " + Build.MODEL + " has black listed H.264 encoder.");
                return -6;
            }
        });
    }

    public boolean pushExternalVideoFrame(OmniVideoFrame omniVideoFrame) {
        Object handleVideoModule = handleVideoModule(new OmniLocalModuleConfig(18, new Object[]{omniVideoFrame}));
        if (handleVideoModule == null || !((Boolean) handleVideoModule).booleanValue()) {
            return false;
        }
        return true;
    }

    public int setExternalAudioSource(boolean z, int i, int i2) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str = invokedMethodName;
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "enable : " + z + " | sampleRate : " + i + " | channels : " + i2, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend(str, Boolean.valueOf(z2), Integer.valueOf(i3), Integer.valueOf(i4));
                if (GlobalConfig.mIsInRoom.get()) {
                    return -3;
                }
                int i = i4;
                if (i != 1 && i != 2) {
                    return -5;
                }
                int i2 = i3;
                if (i2 != 8000 && i2 != 16000 && i2 != 32000 && i2 != 44100 && i2 != 48000) {
                    return -5;
                }
                GlobalConfig.mExternalAudioSource = z2;
                if (z2) {
                    int unused = OmniRtcEngineImpl.this.mExternalAudioSampleRate = i3;
                    int unused2 = OmniRtcEngineImpl.this.mExternalAudioChannels = i4;
                    MyAudioApi.getInstance(OmniRtcEngineImpl.this.mContext).useExtPcm(true, false);
                } else {
                    MyAudioApi.getInstance(OmniRtcEngineImpl.this.mContext).useExtPcm(false, false);
                }
                return 0;
            }
        });
    }

    public int pushExternalAudioFrame(byte[] bArr, long j) {
        if (bArr == null || j <= 0) {
            return -5;
        }
        if (this.mExternalAudioSampleRate == 0 || this.mExternalAudioChannels == 0 || !GlobalConfig.mExternalAudioSource) {
            return -3;
        }
        FastLogCacheBean fastLogCacheBean = this.mExternalAudioPushWatcher;
        fastLogCacheBean.mMessage = "recv external audio data : " + bArr.length + " | timestamp : " + j + " | sample rate : " + this.mExternalAudioSampleRate + " | audio channel : " + this.mExternalAudioChannels;
        OmniLog.fd(this.mExternalAudioPushWatcher);
        ((MyAudioApiImpl) MyAudioApi.getInstance(this.mContext)).PushRecordData(bArr, this.mExternalAudioSampleRate, this.mExternalAudioChannels);
        return 0;
    }

    public int pushExternalAudioFrame(byte[] bArr, long j, int i, int i2, int i3, int i4) {
        return MyAudioApi.getInstance().pushExternalAudioFrame(bArr, j, i, i2, i3, i4);
    }

    public int adjustAudioMixingVolume(final int i) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return ((Integer) omniInterSyncHelperImpl.executeInterObj(invokedMethodName, "volume : " + i, new OmniInterSyncHelper() {
            public Object runObj(String str) {
                OmniRtcEngineImpl.this.buildReportLogAndSend(str, Integer.valueOf(i));
                double checkAudioMixingVolume = OmniRtcEngineImpl.this.mRtcInvokeSafetyChecker.checkAudioMixingVolume(i);
                if (checkAudioMixingVolume < 0.0d) {
                    return Double.valueOf(checkAudioMixingVolume);
                }
                MyAudioApi.getInstance().adjustAudioFileVolumeScale(checkAudioMixingVolume);
                return 0;
            }
        })).intValue();
    }

    public int adjustAudioMixingPlayoutVolume(final int i) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return ((Integer) omniInterSyncHelperImpl.executeInterObj(invokedMethodName, "volume : " + i, new OmniInterSyncHelper() {
            public Object runObj(String str) {
                OmniRtcEngineImpl.this.buildReportLogAndSend(str, Integer.valueOf(i));
                double checkAudioMixingVolume = OmniRtcEngineImpl.this.mRtcInvokeSafetyChecker.checkAudioMixingVolume(i);
                if (checkAudioMixingVolume < 0.0d) {
                    return Double.valueOf(checkAudioMixingVolume);
                }
                MyAudioApi.getInstance().adjustAudioFilePlayoutTrackVol(checkAudioMixingVolume);
                return 0;
            }
        })).intValue();
    }

    public int adjustAudioMixingPublishVolume(final int i) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return ((Integer) omniInterSyncHelperImpl.executeInterObj(invokedMethodName, "volume : " + i, new OmniInterSyncHelper() {
            public Object runObj(String str) {
                OmniRtcEngineImpl.this.buildReportLogAndSend(str, Integer.valueOf(i));
                double checkAudioMixingVolume = OmniRtcEngineImpl.this.mRtcInvokeSafetyChecker.checkAudioMixingVolume(i);
                if (checkAudioMixingVolume < 0.0d) {
                    return Double.valueOf(checkAudioMixingVolume);
                }
                MyAudioApi.getInstance().adjustAudioFilePublishTrackVol(checkAudioMixingVolume);
                return 0;
            }
        })).intValue();
    }

    public int configPublisher(final PublisherConfiguration publisherConfiguration) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        StringBuilder sb = new StringBuilder();
        sb.append("configPublisher url : ");
        sb.append(publisherConfiguration == null ? "null" : publisherConfiguration.toString());
        return omniInterSyncHelperImpl.executeInter(sb.toString(), new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                Object[] objArr = new Object[1];
                PublisherConfiguration publisherConfiguration = publisherConfiguration;
                objArr[0] = publisherConfiguration == null ? "null" : publisherConfiguration.toString();
                omniRtcEngineImpl.buildReportLogAndSend("configPublisher", objArr);
                PublisherConfiguration publisherConfiguration2 = publisherConfiguration;
                if (publisherConfiguration2 == null) {
                    return -5;
                }
                String unused = OmniRtcEngineImpl.this.mRtmpUrl = publisherConfiguration2.getPushUrl();
                GlobalConfig.mIsPureAudio = publisherConfiguration.ismPureAudio();
                return 0;
            }
        });
    }

    public int addPublishStreamUrl(final String str, boolean z) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "url : " + str + " | transcodingEnabled : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                int addPublishStreamUrl = EnterConfApi.getInstance().addPublishStreamUrl(str);
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, str, Integer.valueOf(addPublishStreamUrl));
                return addPublishStreamUrl;
            }
        });
    }

    public int removePublishStreamUrl(final String str) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "url : " + str, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                int removePublishStreamUrl = EnterConfApiImpl.getInstance().removePublishStreamUrl(str);
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, str, Integer.valueOf(removePublishStreamUrl));
                return removePublishStreamUrl;
            }
        });
    }

    public int startChannelMediaRelay(final ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        StringBuilder sb = new StringBuilder();
        sb.append("config : ");
        sb.append(channelMediaRelayConfiguration == null ? "null" : channelMediaRelayConfiguration.toString());
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, sb.toString(), (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                int startChannelMediaRelay = EnterConfApi.getInstance().startChannelMediaRelay(channelMediaRelayConfiguration);
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Integer.valueOf(startChannelMediaRelay));
                return startChannelMediaRelay;
            }
        });
    }

    public int stopChannelMediaRelay() {
        final String invokedMethodName = getInvokedMethodName();
        return this.mOmniInterSyncHelperImpl.executeInter(invokedMethodName, new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, new Object[0]);
                EnterConfApi.getInstance().stopChannelMediaRelay();
                return 0;
            }
        });
    }

    public int updateChannelMediaRelay(final ChannelMediaRelayConfiguration channelMediaRelayConfiguration) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        StringBuilder sb = new StringBuilder();
        sb.append("config : ");
        sb.append(channelMediaRelayConfiguration == null ? "null" : channelMediaRelayConfiguration.toString());
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, sb.toString(), (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                int updateChannelMediaRelay = EnterConfApi.getInstance().updateChannelMediaRelay(channelMediaRelayConfiguration);
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Integer.valueOf(updateChannelMediaRelay));
                return updateChannelMediaRelay;
            }
        });
    }

    public int enableAudioEffect(final boolean z, final int i) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("enableAudioEffect enabled : " + z + " | effectType : " + i, new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("enableAudioEffect", Boolean.valueOf(z), Integer.valueOf(i));
                if (z) {
                    AudioEffect.getInstance().setup(48000, 1);
                    AudioEffect.getInstance().chooseEffectType(i);
                    AudioEffect.getInstance().enableAudioEffect(true);
                } else {
                    AudioEffect.getInstance().enableAudioEffect(false);
                }
                return 0;
            }
        });
    }

    public int uploadLocalVideo(final boolean z) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("uploadLocalVideo uploadVideo : " + z, new OmniInterSyncHelper() {
            public int run() {
                if (!GlobalConfig.mIsInRoom.get()) {
                    return -3;
                }
                if (GlobalHolder.getInstance().getUserDefaultDevice(GlobalConfig.mLocalUserID) == null) {
                    return -6;
                }
                EnterConfApi.getInstance().uploadLocalVideo(z);
                return 0;
            }
        });
    }

    public int createDataStream(final boolean z, final boolean z2) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "reliable : " + z + " | ordered : " + z2, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (!OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    return EnterConfApi.getInstance().createDataStream(z, z2);
                }
                OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                omniRtcEngineImpl.debugLogW("RtcEngine not created! " + invokedMethodName);
                return 0;
            }
        });
    }

    public int sendStreamMessage(final int i, final byte[] bArr) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        StringBuilder sb = new StringBuilder();
        sb.append("streamId : ");
        sb.append(i);
        sb.append(" | message : ");
        sb.append(bArr == null ? "null" : Integer.valueOf(bArr.length));
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, sb.toString(), (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (!OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    return EnterConfApi.getInstance().sendStreamMessage(i, bArr);
                }
                OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                omniRtcEngineImpl.debugLogW("RtcEngine not created! " + invokedMethodName);
                return 0;
            }
        });
    }

    public String getChannelSessionId() {
        return (String) this.mOmniInterSyncHelperImpl.executeInterObj(getInvokedMethodName(), new OmniInterSyncHelper() {
            public Object runObj(String str) {
                String engineSessionId = EnterConfApi.getInstance().getEngineSessionId();
                OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                omniRtcEngineImpl.buildReportLogAndSend("getChannelSessionId", engineSessionId, Boolean.valueOf(omniRtcEngineImpl.mRtcEngineDestroyed));
                if (!OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    return engineSessionId;
                }
                OmniRtcEngineImpl omniRtcEngineImpl2 = OmniRtcEngineImpl.this;
                omniRtcEngineImpl2.debugLogW("RtcEngine not created! " + str);
                return "";
            }
        });
    }

    public int enableContentInspect(final boolean z, final int i) {
        return ((Integer) this.mOmniInterSyncHelperImpl.executeInterObj(getInvokedMethodName(), new OmniInterSyncHelper() {
            public Object runObj(String str) {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + str);
                    return 0;
                }
                ContentInspectHandler contentInspectHandler = OmniRtcEngineImpl.this.mOmniRtcEngineAssist.getContentInspectHandler();
                if (contentInspectHandler == null) {
                    return -3;
                }
                return Integer.valueOf(contentInspectHandler.enableContentInspect(z, i));
            }
        })).intValue();
    }

    public int contentInspectExtra(final String str, final int[] iArr) {
        return ((Integer) this.mOmniInterSyncHelperImpl.executeInterObj(getInvokedMethodName(), new OmniInterSyncHelper() {
            public Object runObj(String str) {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + str);
                    return 0;
                }
                ContentInspectHandler contentInspectHandler = OmniRtcEngineImpl.this.mOmniRtcEngineAssist.getContentInspectHandler();
                if (contentInspectHandler == null) {
                    return -3;
                }
                return Integer.valueOf(contentInspectHandler.contentInspectExtra(str, iArr));
            }
        })).intValue();
    }

    public int setAVSyncSource(final String str, final long j) {
        return ((Integer) this.mOmniInterSyncHelperImpl.executeInterObj(getInvokedMethodName(), new OmniInterSyncHelper() {
            public Object runObj(String str) {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + str);
                    return 0;
                }
                return OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(30, new Object[]{str, Long.valueOf(j)}));
            }
        })).intValue();
    }

    public int setParameters(final String str, final String str2) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "key : " + str + " | params : " + str2, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                int i = 0;
                try {
                    if (!TextUtils.isEmpty(str)) {
                        if (!TextUtils.isEmpty(str2)) {
                            int i2 = OmniRtcEngineImpl.this.mCustomFuncHandler.processParams(str, str2) ? i : -6;
                            OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, str, str2, Integer.valueOf(i2));
                            return i2;
                        }
                    }
                    i = -5;
                    Object[] objArr = {str, str2, Integer.valueOf(i)};
                    return i;
                } finally {
                    OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, str, str2, Integer.valueOf(i));
                }
            }
        });
    }

    public int setBusinessUserRole(final int i) {
        return ((Integer) this.mOmniInterSyncHelperImpl.executeInterObj(getInvokedMethodName(), new OmniInterSyncHelper() {
            public Object runObj(String str) {
                return Integer.valueOf(EnterConfApi.getInstance().setBusinessUserRole(i));
            }
        })).intValue();
    }

    public int takeLocalViewSnapshot() {
        return ((Integer) this.mOmniInterSyncHelperImpl.executeInterObj(getInvokedMethodName(), new OmniInterSyncHelper() {
            public Object runObj(String str) {
                RtcEngineEventReporter rtcEngineEventReporter = GlobalHolder.getInstance().getRtcEngineEventReporter();
                if (rtcEngineEventReporter != null) {
                    rtcEngineEventReporter.takeLocalViewSnapshot();
                }
                return 0;
            }
        })).intValue();
    }

    public int takeRemoteViewSnapshot(final long j) {
        return ((Integer) this.mOmniInterSyncHelperImpl.executeInterObj(getInvokedMethodName(), new OmniInterSyncHelper() {
            public Object runObj(String str) {
                GlobalHolder.getInstance().sendSyncGlobalMessage(1013, GlobalConfig.mLocalRoomName, Long.valueOf(j));
                return 0;
            }
        })).intValue();
    }

    public int setParameters(final String str) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "config : " + str, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                int i = 0;
                try {
                    if (TextUtils.isEmpty(str)) {
                        i = -5;
                        Object[] objArr = {str, Integer.valueOf(i)};
                        return i;
                    }
                    int i2 = OmniRtcEngineImpl.this.mCustomFuncHandler.processParams(str) ? i : -6;
                    OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, str, Integer.valueOf(i2));
                    return i2;
                } finally {
                    OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, str, Integer.valueOf(i));
                }
            }
        });
    }

    public int tryRecordScreen(Activity activity) {
        buildReportLogAndSend("tryRecordScreen", new Object[0]);
        if (activity == null) {
            return -5;
        }
        if ((GlobalConfig.mBranch != LocalSDKConstants.BRANCH_CLIENT_XIAOYUN && GlobalConfig.mBranch != LocalSDKConstants.BRANCH_CLIENT_TY && Build.VERSION.SDK_INT >= 29) || Build.VERSION.SDK_INT < 21) {
            return -6;
        }
        try {
            this.mRecorderLock.lock();
            if (this.mScreenCapture == null) {
                ScreenCapture screenCapture = new ScreenCapture();
                this.mScreenCapture = screenCapture;
                screenCapture.setRecordCallback(new ScreenCapture.RecordCallback() {
                    public String onRecordMoveFile(String str) {
                        return MyFileUtils.moveVideoFileToDCIM(OmniRtcEngineImpl.this.mContext, str);
                    }

                    public void onRecordSuccess(String str, long j) {
                        GlobalConfig.mIsScreenRecording.set(false);
                        String access$900 = OmniRtcEngineImpl.TAG;
                        OmniLog.screen_d(access$900, "Screen record over! filePath : " + str + " | duration : " + j);
                    }

                    public void onRecordFailed(String str, long j) {
                        GlobalConfig.mIsScreenRecording.set(false);
                        String access$900 = OmniRtcEngineImpl.TAG;
                        OmniLog.screen_e(access$900, "Screen record failed! errorMsg : " + str + " | duration : " + j);
                    }

                    public void onRecordedDurationChanged(long j) {
                        if (GlobalConfig.mIsScreenRecording.get()) {
                            String access$900 = OmniRtcEngineImpl.TAG;
                            OmniLog.screen_d(access$900, "Screen record progress ...timePos : " + j);
                        }
                    }
                });
            }
            if (!this.mScreenCapture.isProjecting()) {
                if (!this.mScreenCapture.isRecording()) {
                    String str = TAG;
                    OmniLog.screen_d(str, "--------- tryRecordScreen invoked! activity : " + activity);
                    this.mScreenCapture.setActivityRef(activity);
                    if (!this.mScreenCapture.requestScreenCapture()) {
                        this.mRecorderLock.unlock();
                        return -6;
                    }
                    this.mRecorderLock.unlock();
                    return 0;
                }
            }
            return 0;
        } finally {
            this.mRecorderLock.unlock();
        }
    }

    public int startRecordScreen(Intent intent, ScreenRecordConfig screenRecordConfig) {
        Object[] objArr = new Object[1];
        objArr[0] = screenRecordConfig == null ? "null" : screenRecordConfig.toString();
        buildReportLogAndSend("startRecordScreen", objArr);
        if (screenRecordConfig == null) {
            return -5;
        }
        try {
            this.mRecorderLock.lock();
            String str = TAG;
            OmniLog.screen_d(str, "--------- startRecordScreen invoked! mConfig : " + screenRecordConfig.toString());
            return realStartRecordScreen(true, intent, screenRecordConfig);
        } finally {
            this.mRecorderLock.unlock();
        }
    }

    public int startRecordScreenAndSave(Intent intent, ScreenRecordConfig screenRecordConfig) {
        Object[] objArr = new Object[1];
        objArr[0] = screenRecordConfig == null ? "null" : screenRecordConfig.toString();
        buildReportLogAndSend("startRecordScreenAndSave", objArr);
        if (screenRecordConfig == null) {
            return -5;
        }
        try {
            this.mRecorderLock.lock();
            String str = TAG;
            OmniLog.i(str, "startRecordScreenAndSave invoked! mConfig : " + screenRecordConfig.toString());
            return realStartRecordScreen(false, intent, screenRecordConfig);
        } finally {
            this.mRecorderLock.unlock();
        }
    }

    public int stopScreenCapture() {
        buildReportLogAndSend("stopScreenCapture", new Object[0]);
        try {
            this.mRecorderLock.lock();
            String str = TAG;
            OmniLog.screen_d(str, "--------- stopScreenCapture invoked!");
            if (Build.VERSION.SDK_INT < 21) {
                return -3;
            }
            if (this.mScreenCapture != null) {
                long currentTimeMillis = System.currentTimeMillis();
                this.mScreenCapture.stopBlockingCapture();
                OmniLog.i(str, "Stop screen record over, spend time : " + (System.currentTimeMillis() - currentTimeMillis));
                if (GlobalConfig.mIsScreenRecordShare.get()) {
                    VideoJni.getInstance().VideoChangeDefaultMediaType(String.valueOf(GlobalConfig.mLocalUserID), 0);
                }
                GlobalConfig.mIsScreenRecordShare.set(false);
            }
            this.mRecorderLock.unlock();
            return 0;
        } finally {
            this.mRecorderLock.unlock();
        }
    }

    public boolean isScreenRecording() {
        ScreenCapture screenCapture = this.mScreenCapture;
        return screenCapture != null && screenCapture.isRecording();
    }

    public int startRtmpPublish(final String str) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("startRtmpPublish rtmpUrl : " + str, new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("startRtmpPublish", str);
                if (TextUtils.isEmpty(str)) {
                    return -5;
                }
                Object access$3000 = OmniRtcEngineImpl.this.handleRTMPModule(new OmniLocalModuleConfig(1, new Object[]{str}));
                if (access$3000 != null) {
                    return ((Integer) access$3000).intValue();
                }
                return -3;
            }
        });
    }

    public int stopRtmpPublish() {
        return this.mOmniInterSyncHelperImpl.executeInter("stopRtmpPublish", new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("stopRtmpPublish", new Object[0]);
                Object access$3000 = OmniRtcEngineImpl.this.handleRTMPModule(new OmniLocalModuleConfig(2, (Object[]) null));
                if (access$3000 != null) {
                    return ((Integer) access$3000).intValue();
                }
                return -3;
            }
        });
    }

    public int pauseRtmpPublish() {
        return this.mOmniInterSyncHelperImpl.executeInter("pauseRtmpPublish", new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("pauseRtmpPublish", new Object[0]);
                Object access$3000 = OmniRtcEngineImpl.this.handleRTMPModule(new OmniLocalModuleConfig(3, new Object[]{true}));
                if (access$3000 != null) {
                    return ((Integer) access$3000).intValue();
                }
                return -3;
            }
        });
    }

    public int resumeRtmpPublish() {
        return this.mOmniInterSyncHelperImpl.executeInter("resumeRtmpPublish", new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("resumeRtmpPublish", new Object[0]);
                Object access$3000 = OmniRtcEngineImpl.this.handleRTMPModule(new OmniLocalModuleConfig(4, new Object[]{false}));
                if (access$3000 != null) {
                    return ((Integer) access$3000).intValue();
                }
                return -3;
            }
        });
    }

    public int enableAudioEarBack(final boolean z) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("enableAudioEarBack enableEarsBack : " + z, new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("enableAudioEarBack", Boolean.valueOf(z));
                MyAudioApi.getInstance((Context) null).enableEarsBack(z);
                return 0;
            }
        });
    }

    public int setAudioEarBackVolume(final int i) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("setAudioEarBackVolume volume : " + i, new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("setAudioEarBackVolume", Integer.valueOf(i));
                ((MyAudioApiImpl) MyAudioApi.getInstance((Context) null)).setAudioEarbackVol((float) i);
                return 0;
            }
        });
    }

    public int insertH264SeiContent(final String str) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("insertH264SeiContent content : " + str, new OmniInterSyncHelper() {
            public int run() {
                String str = str;
                if (str == null) {
                    return -5;
                }
                OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(15, new Object[]{str}));
                return 0;
            }
        });
    }

    public int setRemoteSubscribeFallbackOption(final int i) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "option : " + i, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + invokedMethodName);
                    return -7;
                }
                int remoteSubscribeFallbackOption = EnterConfApi.getInstance().setRemoteSubscribeFallbackOption(i);
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Integer.valueOf(i), Integer.valueOf(remoteSubscribeFallbackOption));
                return remoteSubscribeFallbackOption;
            }
        });
    }

    public int enableDualStreamMode(final boolean z) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "enabled : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Boolean.valueOf(z));
                EnterConfApi.getInstance().enableDualVideoStream(z);
                return 0;
            }
        });
    }

    public int setRemoteVideoStreamType(long j, int i) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str = invokedMethodName;
        final long j2 = j;
        final int i2 = i;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "uid : " + j + " | steamType : " + i, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    String access$900 = OmniRtcEngineImpl.TAG;
                    OmniLog.e(access$900, "RtcEngine not created! " + str);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(str, Long.valueOf(j2), Integer.valueOf(i2));
                String str = GlobalConfig.mLocalRoomName;
                VideoDualStreamManager videoDualStreamManager = GlobalHolder.getInstance().getVideoDualStreamManager(str);
                if (videoDualStreamManager != null) {
                    return videoDualStreamManager.setRemoteVideoStreamType(j2, i2);
                }
                String access$9002 = OmniRtcEngineImpl.TAG;
                OmniLog.i(OmniLog.DUAL_VIDEO, access$9002, "Engine not found VideoDualStreamManager... cache : " + j2 + " | " + i2 + " | " + str);
                EnterConfApi.getInstance().cacheVideoRemoteStreamType(new VideoRemoteStreamType(j2, i2));
                return 0;
            }
        });
    }

    public int setRemoteDefaultVideoStreamType(final int i) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "streamType : " + i, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    String access$900 = OmniRtcEngineImpl.TAG;
                    OmniLog.e(access$900, invokedMethodName + " mRtcEngineDestoryed:" + OmniRtcEngineImpl.this.mRtcEngineDestroyed);
                    return 0;
                }
                int i = i;
                if (i != 0 && i != 1) {
                    String access$9002 = OmniRtcEngineImpl.TAG;
                    OmniLog.e(access$9002, invokedMethodName + " streamType:" + i);
                    return -5;
                } else if (GlobalConfig.mIsInRoom.get()) {
                    String access$9003 = OmniRtcEngineImpl.TAG;
                    OmniLog.e(access$9003, invokedMethodName + " mIsInRoom:" + GlobalConfig.mIsInRoom.get());
                    return -3;
                } else {
                    GlobalConfig.mDualDefStream = i;
                    String access$9004 = OmniRtcEngineImpl.TAG;
                    OmniLog.i(access$9004, invokedMethodName + " setRemoteDefaultVideoStreamType:" + 0);
                    return 0;
                }
            }
        });
    }

    public int lowBitRateStreamParameter(int i, int i2, int i3, int i4) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str = invokedMethodName;
        final int i5 = i;
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "width : " + i + " | height : " + i2 + " | frameRate : " + i3 + " | bitrate : " + i4, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                int i;
                int i2;
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    String access$900 = OmniRtcEngineImpl.TAG;
                    OmniLog.e(access$900, str + " mRtcEngineDestoryed:" + OmniRtcEngineImpl.this.mRtcEngineDestroyed);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(str, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
                int i3 = i5;
                if (i3 <= 0 || (i = i6) <= 0 || (i2 = i7) <= 0 || i8 <= 0) {
                    String access$9002 = OmniRtcEngineImpl.TAG;
                    OmniLog.e(access$9002, str + " width:" + i5 + " height:" + i6 + " frameRate:" + i7 + " bitrate:" + i8);
                    return -5;
                } else if (i3 * i > 2073600 || i2 > 30) {
                    String access$9003 = OmniRtcEngineImpl.TAG;
                    OmniLog.e(access$9003, str + " width:" + i5 + " height:" + i6 + " frameRate:" + i7);
                    return -5;
                } else {
                    GlobalHolder.getInstance().getGlobalVideoConfig().setUserVideoDualEncodeParams(i5, i6, i7, i8);
                    OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(OmniModuleConstants.VIDEO_LOCAL_DUAL_ENCODER_PARAMS, new Object[]{Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}));
                    String access$9004 = OmniRtcEngineImpl.TAG;
                    OmniLog.i(access$9004, str + " ret:" + 0);
                    return 0;
                }
            }
        });
    }

    public void setServerIp(final String str, final int i) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        omniInterSyncHelperImpl.executeInterBool("setServerIp ip : " + str + " | port : " + i, new OmniInterSyncHelper() {
            public boolean runBool() {
                OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                Object[] objArr = new Object[2];
                objArr[0] = TextUtils.isEmpty(str) ? "null" : str;
                objArr[1] = Integer.valueOf(i);
                omniRtcEngineImpl.buildReportLogAndSend("setServerIp", objArr);
                EnterConfApi.getInstance().setServerAddress(str, i);
                return true;
            }
        });
    }

    public void setVideoMirrored(final boolean z, final boolean z2) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        omniInterSyncHelperImpl.executeInterBool(invokedMethodName, "horMirror : " + z + " | verMirror : " + z2, new OmniInterSyncHelper() {
            public boolean runBool() {
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Boolean.valueOf(z), Boolean.valueOf(z2));
                OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(27, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}));
                return true;
            }
        });
    }

    public void setRemoteVideoMirrored(final boolean z) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        omniInterSyncHelperImpl.executeInterBool(invokedMethodName, "horMirror : " + z, new OmniInterSyncHelper() {
            public boolean runBool() {
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Boolean.valueOf(z));
                OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(28, new Object[]{Boolean.valueOf(z)}));
                return true;
            }
        });
    }

    public boolean isCameraZoomSupported() {
        return this.mOmniInterSyncHelperImpl.executeInterBool("isCameraZoomSupported", new OmniInterSyncHelper() {
            public boolean runBool() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("isCameraZoomSupported", new Object[0]);
                Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(152, new Object[]{1}));
                if (handleVideoModule != null) {
                    return ((Boolean) handleVideoModule).booleanValue();
                }
                return false;
            }
        });
    }

    public boolean isCameraTorchSupported() {
        return this.mOmniInterSyncHelperImpl.executeInterBool("isCameraTorchSupported", new OmniInterSyncHelper() {
            public boolean runBool() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("isCameraTorchSupported", new Object[0]);
                Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(152, new Object[]{2}));
                if (handleVideoModule != null) {
                    return ((Boolean) handleVideoModule).booleanValue();
                }
                return false;
            }
        });
    }

    public boolean isCameraFocusSupported() {
        return this.mOmniInterSyncHelperImpl.executeInterBool("isCameraFocusSupported", new OmniInterSyncHelper() {
            public boolean runBool() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("isCameraFocusSupported", new Object[0]);
                Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(152, new Object[]{3}));
                if (handleVideoModule != null) {
                    return ((Boolean) handleVideoModule).booleanValue();
                }
                return false;
            }
        });
    }

    public boolean isCameraExposurePositionSupported() {
        return this.mOmniInterSyncHelperImpl.executeInterBool("isCameraExposurePositionSupported", new OmniInterSyncHelper() {
            public boolean runBool() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("isCameraExposurePositionSupported", new Object[0]);
                Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(152, new Object[]{4}));
                if (handleVideoModule != null) {
                    return ((Boolean) handleVideoModule).booleanValue();
                }
                return false;
            }
        });
    }

    public boolean setCameraZoomFactor(final int i) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInterBool("setCameraZoomFactor, factor : " + i, new OmniInterSyncHelper() {
            public boolean runBool() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("setCameraZoomFactor", Integer.valueOf(i));
                int i = i;
                Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(154, new Object[]{Integer.valueOf(i)}));
                if (handleVideoModule != null) {
                    return ((Boolean) handleVideoModule).booleanValue();
                }
                return false;
            }
        });
    }

    public int getCameraMaxZoomFactor() {
        return this.mOmniInterSyncHelperImpl.executeInter("getCameraMaxZoomFactor", new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("getCameraMaxZoomFactor", new Object[0]);
                Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(155, new Object[0]));
                if (handleVideoModule != null) {
                    return ((Integer) handleVideoModule).intValue();
                }
                return 0;
            }
        });
    }

    public boolean setCameraTorchOn(final boolean z) {
        return this.mOmniInterSyncHelperImpl.executeInterBool("setCameraTorchOn", new OmniInterSyncHelper() {
            public boolean runBool() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("setCameraTorchOn", Boolean.valueOf(z));
                Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(153, new Object[]{Boolean.valueOf(z)}));
                if (handleVideoModule != null) {
                    return ((Boolean) handleVideoModule).booleanValue();
                }
                return false;
            }
        });
    }

    public boolean isCameraAutoFocusFaceModeSupported() {
        return this.mOmniInterSyncHelperImpl.executeInterBool("isCameraAutoFocusFaceModeSupported", new OmniInterSyncHelper() {
            public boolean runBool() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("isCameraAutoFocusFaceModeSupported", new Object[0]);
                Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(152, new Object[]{5}));
                if (handleVideoModule != null) {
                    return ((Boolean) handleVideoModule).booleanValue();
                }
                return false;
            }
        });
    }

    public void enableAudioDataReport(final boolean z, final boolean z2) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        omniInterSyncHelperImpl.executeInter(invokedMethodName, "isLocalEable : " + z + " | isRemoteEnable : " + z2, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Boolean.valueOf(z), Boolean.valueOf(z2));
                MyAudioApi instance = MyAudioApi.getInstance(OmniRtcEngineImpl.this.mContext);
                if (z) {
                    instance.startRecordMix();
                } else {
                    instance.stopRecordMix();
                }
                if (z2) {
                    instance.startPlayMix();
                } else {
                    instance.stopPlayMix();
                }
                return 0;
            }
        });
    }

    public void enableMixAudioDataReport(final boolean z) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        omniInterSyncHelperImpl.executeInter(invokedMethodName, "enabled : " + z, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Boolean.valueOf(z));
                MyAudioApi instance = MyAudioApi.getInstance(OmniRtcEngineImpl.this.mContext);
                if (z) {
                    instance.startRemoteAndLocalMix();
                } else {
                    instance.stopRemoteAndLocalMix();
                }
                return 0;
            }
        });
    }

    public int setRecordingAudioFrameParameters(int i, int i2, int i3, int i4) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str = invokedMethodName;
        final int i5 = i;
        final int i6 = i2;
        final int i7 = i4;
        final int i8 = i3;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "sampleRate : " + i + " | channel : " + i2 + " | mode : " + i3 + " | samplesPerCall : " + i4, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend(str, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
                int recordMixParameters = MyAudioApi.getInstance(OmniRtcEngineImpl.this.mContext).setRecordMixParameters(i5, i6, i8, i7 * 2);
                if (recordMixParameters != 0) {
                    return recordMixParameters;
                }
                return 0;
            }
        });
    }

    public int setPlaybackAudioFrameParameters(int i, int i2, int i3) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str = invokedMethodName;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "sampleRate : " + i + " | channel : " + i2 + " | samplesPerCall : " + i3, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend(str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
                MyAudioApi.getInstance(OmniRtcEngineImpl.this.mContext).setPlayMixParamatars(i4, i5, i6 * 2);
                return 0;
            }
        });
    }

    public int setMixedAudioFrameParameters(int i, int i2, int i3) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str = invokedMethodName;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "sampleRate : " + i + " | channel : " + i2 + " | samplesPerCall : " + i3, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend(str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
                MyAudioApi.getInstance(OmniRtcEngineImpl.this.mContext).setRemoteAndLocalMixParamatars(i4, i5, i6 * 2);
                return 0;
            }
        });
    }

    public int enableLastmileTest() {
        String invokedMethodName = getInvokedMethodName();
        String str = TAG;
        OmniLog.i(str, invokedMethodName + " -> execute...");
        if (this.mRtcEngineDestroyed) {
            OmniLog.e(str, "RtcEngine not created! " + invokedMethodName);
            return 0;
        }
        buildReportLogAndSend(invokedMethodName, new Object[0]);
        EnterConfApi.getInstance().controlLastmileTest(true);
        return 0;
    }

    public int disableLastmileTest() {
        String invokedMethodName = getInvokedMethodName();
        String str = TAG;
        OmniLog.i(str, invokedMethodName + " -> execute...");
        if (this.mRtcEngineDestroyed) {
            OmniLog.e(str, "RtcEngine not created! " + invokedMethodName);
            return 0;
        }
        buildReportLogAndSend(invokedMethodName, new Object[0]);
        EnterConfApi.getInstance().controlLastmileTest(false);
        return 0;
    }

    public int setBeautyFaceStatus(final boolean z, final float f, final float f2) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("setBeautyFaceStatus enabled : " + z + " beautyLevel : " + f + " | brightLevel : " + f2, new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("setBeautyFaceStatus", Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2));
                float f = f;
                if (f >= CropImageView.DEFAULT_ASPECT_RATIO && f <= 1.0f) {
                    float f2 = f2;
                    if (f2 >= CropImageView.DEFAULT_ASPECT_RATIO && f2 <= 1.0f) {
                        OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(26, new Object[]{Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2)}));
                        return 0;
                    }
                }
                return -5;
            }
        });
    }

    public int setLocalRenderMode(final int i, final int i2) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "renderMode : " + i + " | mirrorMode : " + i2, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    String access$900 = OmniRtcEngineImpl.TAG;
                    OmniLog.e(access$900, "RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Integer.valueOf(i), Integer.valueOf(i2));
                Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(OmniModuleConstants.VIDEO_LOCAL_RENDER_MIRROR, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                if (handleVideoModule != null) {
                    return ((Integer) handleVideoModule).intValue();
                }
                return -6;
            }
        });
    }

    public int setRemoteRenderMode(final int i) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "renderMode: " + i, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    String access$900 = OmniRtcEngineImpl.TAG;
                    OmniLog.e(access$900, "RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                int remoteRenderMode = EnterConfApi.getInstance().setRemoteRenderMode(i);
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Integer.valueOf(i), Integer.valueOf(remoteRenderMode));
                return remoteRenderMode;
            }
        });
    }

    public int setRemoteRenderMirror(final int i) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "mirrorMode: " + i, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    String access$900 = OmniRtcEngineImpl.TAG;
                    OmniLog.e(access$900, "RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                int remoteRenderMirror = EnterConfApi.getInstance().setRemoteRenderMirror(i);
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Integer.valueOf(i), Integer.valueOf(remoteRenderMirror));
                return remoteRenderMirror;
            }
        });
    }

    public int setRemoteRenderMode(long j, int i, int i2) {
        final String invokedMethodName = getInvokedMethodName();
        final long j2 = j;
        final int i3 = i;
        final int i4 = i2;
        return this.mOmniInterSyncHelperImpl.executeInter("", new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    String access$900 = OmniRtcEngineImpl.TAG;
                    OmniLog.e(access$900, "RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                int remoteRenderMode = EnterConfApi.getInstance().setRemoteRenderMode(j2, i3, i4);
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Long.valueOf(j2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(remoteRenderMode));
                return remoteRenderMode;
            }
        });
    }

    public int setVideoMixerBackgroundImgUrl(final String str) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("setVideoMixerBackgroundImgUrl url : " + str, new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("setVideoMixerBackgroundImgUrl", str);
                return 0;
            }
        });
    }

    public int setVideoMixerBackgroundImgUrl(final String str, final String str2) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("setVideoMixerBackgroundImgUrl url : " + str + " | streamUrl : " + str2, new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("setVideoMixerBackgroundImgUrl", str, str2);
                return 0;
            }
        });
    }

    public int getAkamai(String str, String str2) {
        final GlobalHolder instance = GlobalHolder.getInstance();
        HttpUtil.doGetAsyn("http://tempa.3ttech.cn:18000/live/record/queryserverid?appid=" + str + "&roomid=" + str2, RtcEngineEvent.AudioEvent.EVENT_AUDIO_START_POINT, new HttpUtil.CallBack("") {
            public void onRequestComplete(String str) {
                OmniLog.i("getAkamai -> Get server json : " + str);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String string = jSONObject.getString("reason");
                    instance.notifyAKamaiServerID(jSONObject.getString("serverid"), string);
                } catch (JSONException e) {
                    instance.notifyAKamaiServerID("", e.getLocalizedMessage());
                }
            }

            public void onRequestError(String str) {
                instance.notifyAKamaiServerID("", str);
            }
        });
        return 0;
    }

    public int getCameraFace() {
        return this.mOmniInterSyncHelperImpl.executeInter(getInvokedMethodName(), new OmniInterSyncHelper() {
            public int run() {
                Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(OmniModuleConstants.VIDEO_LOCAL_CAMERA_ID, new Object[0]));
                if (handleVideoModule != null) {
                    return ((Integer) handleVideoModule).intValue();
                }
                return -6;
            }
        });
    }

    public int setCameraPreviewResolution(final int i, final int i2) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "width : " + i + " | height : " + i2, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                Object handleVideoModule = OmniRtcEngineImpl.this.handleVideoModule(new OmniLocalModuleConfig(156, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                if (handleVideoModule != null) {
                    return ((Integer) handleVideoModule).intValue();
                }
                return -6;
            }
        });
    }

    public int getConnectionState() {
        return this.mOmniInterSyncHelperImpl.executeInter("getConnectionState", new OmniInterSyncHelper() {
            public int run() {
                return EnterConfApi.getInstance().getConnectionState();
            }
        });
    }

    public int startAudioRecording(final String str, final int i) {
        return this.mOmniInterSyncHelperImpl.executeInter("startAudioRecording", new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                Object[] objArr = new Object[2];
                objArr[0] = TextUtils.isEmpty(str) ? "null" : str;
                objArr[1] = Integer.valueOf(i);
                omniRtcEngineImpl.buildReportLogAndSend("startAudioRecording", objArr);
                if (TextUtils.isEmpty(str) || !str.endsWith("aac")) {
                    return -5;
                }
                File parentFile = new File(str).getParentFile();
                if ((parentFile != null && !parentFile.exists()) || OmniRtcEngineImpl.this.mAudioEncoder != null) {
                    return -5;
                }
                AudioEncoder unused = OmniRtcEngineImpl.this.mAudioEncoder = new AudioEncoder(str, i);
                OmniRtcEngineImpl.this.mAudioEncoder.startReocrding();
                return 0;
            }
        });
    }

    public int stopAudioRecording() {
        return this.mOmniInterSyncHelperImpl.executeInter("stopAudioRecording", new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("stopAudioRecording", new Object[0]);
                if (OmniRtcEngineImpl.this.mAudioEncoder != null) {
                    OmniRtcEngineImpl.this.mAudioEncoder.stopRecording(new AudioEncoder.AudioEncodeCallBack() {
                        public void onAudioRecordStopFinish() {
                            AudioEncoder unused = OmniRtcEngineImpl.this.mAudioEncoder = null;
                        }
                    });
                }
                return 0;
            }
        });
    }

    public int sendAudioLyric(final String str) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("sendAudioLyric lyric : " + str, new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.isEmpty(str) ? "null" : str;
                omniRtcEngineImpl.buildReportLogAndSend("sendAudioLyric", objArr);
                EnterConfApi.getInstance().sendLyrics(GlobalConfig.mLocalRoomName, str);
                return 0;
            }
        });
    }

    public int setAudioApplicationScene(final int i) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "scene : " + i, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Integer.valueOf(i));
                if (GlobalConfig.mIsInRoom.get()) {
                    return -3;
                }
                ExternalAudioModule.getInstance().setAudioApplicationScene(i);
                return 0;
            }
        });
    }

    public int enableVideoMixer(final boolean z) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("enableVideoMixer enable : " + z, new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("enableVideoMixer", Boolean.valueOf(z));
                GlobalConfig.mIsEnableVideoMixer.set(z);
                if (GlobalConfig.mIsInRoom.get()) {
                    EnterConfApi instance = EnterConfApi.getInstance();
                    if (z) {
                        instance.uploadLocalVideo(true);
                    } else {
                        instance.uploadLocalVideo(false);
                    }
                }
                return 0;
            }
        });
    }

    public int setAudioProfile(final int i, final int i2) {
        final String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "profile : " + i + " | scenario : " + i2, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + invokedMethodName);
                    return 0;
                }
                int profile = ExternalAudioModule.getInstance().setProfile(i, i2);
                OmniRtcEngineImpl.this.buildReportLogAndSend(invokedMethodName, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(profile));
                return profile;
            }
        });
    }

    public int setPreferAudioCodec(int i, int i2, int i3) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        final String str = invokedMethodName;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        return omniInterSyncHelperImpl.executeInter(invokedMethodName, "codecType : " + i + " | bitrate : " + i2, (OmniInterSyncHelper) new OmniInterSyncHelper() {
            public int run() {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + str);
                    return 0;
                }
                int encodeParams = ExternalAudioModule.getInstance().setEncodeParams(i4, i5, i6);
                OmniRtcEngineImpl.this.buildReportLogAndSend(str, Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(encodeParams));
                return encodeParams;
            }
        });
    }

    public int adjustRecordingSignalVolume(final int i) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return ((Integer) omniInterSyncHelperImpl.executeInterObj(invokedMethodName, "volume : " + i, new OmniInterSyncHelper() {
            public Object runObj(String str) {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + str);
                    return 0;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(str, Integer.valueOf(i));
                double checkAudioRecordingSignalVolume = OmniRtcEngineImpl.this.mRtcInvokeSafetyChecker.checkAudioRecordingSignalVolume(i);
                if (checkAudioRecordingSignalVolume < 0.0d) {
                    return Double.valueOf(checkAudioRecordingSignalVolume);
                }
                double unused = OmniRtcEngineImpl.this.mAudioMixSoloVolume = checkAudioRecordingSignalVolume;
                MyAudioApi.getInstance(OmniRtcEngineImpl.this.mContext).adjustAudioSoloVolumeScale(checkAudioRecordingSignalVolume);
                return 0;
            }
        })).intValue();
    }

    public int adjustPlaybackSignalVolume(final String str, final int i) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return ((Integer) omniInterSyncHelperImpl.executeInterObj(invokedMethodName, "channelName : " + str, new OmniInterSyncHelper() {
            public Object runObj(String str) {
                if (!OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    return Integer.valueOf(EnterConfApi.getInstance().adjustPlaybackSignalVolume(str, i));
                }
                OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                omniRtcEngineImpl.debugLogW("RtcEngine not created! " + str);
                return 0;
            }
        })).intValue();
    }

    public int adjustUserPlaybackSignalVolume(final long j, final int i) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return ((Integer) omniInterSyncHelperImpl.executeInterObj(invokedMethodName, "uid : " + j + " | volume : " + i, new OmniInterSyncHelper() {
            public Object runObj(String str) {
                if (!OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    return Integer.valueOf(EnterConfApi.getInstance().adjustUserPlaybackSignalVolume(j, i));
                }
                OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                omniRtcEngineImpl.debugLogW("RtcEngine not created! " + str);
                return 0;
            }
        })).intValue();
    }

    public void enableCrossRoom(final boolean z) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        omniInterSyncHelperImpl.executeInter("enableCrossRoom enabled : " + z, new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("enableCrossRoom", Boolean.valueOf(z));
                return 0;
            }
        });
    }

    public int setSignalTimeout(final int i) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("setSignalTimeout timeout : " + i, new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("setSignalTimeout", Integer.valueOf(i));
                return EnterConfApi.getInstance().setReconnectTimeoutSeconds(i);
            }
        });
    }

    public int updateRtmpUrl(final String str) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("updateRtmpUrl rtmpUrl : " + str, new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("updateRtmpUrl", str);
                return EnterConfApi.getInstance().updateRtmpUrl(GlobalConfig.mLocalRoomName, str);
            }
        });
    }

    public double getEffectsVolume() {
        return MyAudioApi.getInstance((Context) null).getEffectsVolume() * 100.0d;
    }

    public int setEffectsVolume(double d) {
        if (d < 0.0d || d > 100.0d) {
            return -5;
        }
        MyAudioApi.getInstance((Context) null).setEffectsVolume(d / 100.0d);
        return 0;
    }

    public int setVolumeOfEffect(int i, double d) {
        if (d < 0.0d || d > 100.0d) {
            return -5;
        }
        MyAudioApi.getInstance((Context) null).setVolumeOfEffect(i, d / 100.0d);
        return 0;
    }

    public int playEffect(int i, String str, int i2, double d, double d2, double d3, boolean z) {
        String str2;
        int i3 = i2;
        double d4 = d;
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = TextUtils.isEmpty(str) ? "null" : str;
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Double.valueOf(d);
        objArr[4] = Double.valueOf(d2);
        objArr[5] = Double.valueOf(d3);
        objArr[6] = Boolean.valueOf(z);
        buildReportLogAndSend("playEffect", objArr);
        if (TextUtils.isEmpty(str) || i3 < -1 || d4 < 0.5d || d4 > 2.0d || d3 < 0.0d || d3 > 100.0d) {
            return -5;
        }
        String transformToPath = AssertUtils.transformToPath(str);
        if (!TextUtils.isEmpty(transformToPath)) {
            String transformToFile = AssertUtils.transformToFile(this.mContext, transformToPath);
            if (TextUtils.isEmpty(transformToFile)) {
                return -5;
            }
            str2 = transformToFile;
        } else {
            str2 = str;
        }
        if (i3 == -1) {
            i3 = Integer.MAX_VALUE;
        }
        double d5 = d3 / 100.0d;
        boolean playEffect = MyAudioApi.getInstance((Context) null).playEffect(i, str2, i3, d, d5, !z);
        String str3 = TAG;
        OmniLog.ped(str3, "playEffect -> soundId : " + i + " | pitch : " + d4 + " | localGain : " + d5 + " | result : " + playEffect);
        if (playEffect) {
            return 0;
        }
        return -6;
    }

    public int stopEffect(int i) {
        buildReportLogAndSend("stopEffect", Integer.valueOf(i));
        MyAudioApi.getInstance((Context) null).stopEffect(i);
        String str = TAG;
        OmniLog.ped(str, "stopEffect -> soundId : " + i);
        return 0;
    }

    public int stopAllEffects() {
        buildReportLogAndSend("stopAllEffects", new Object[0]);
        MyAudioApi.getInstance((Context) null).stopAllEffect();
        OmniLog.ped(TAG, "stopAllEffects -> ...");
        return 0;
    }

    public int pauseEffect(int i) {
        buildReportLogAndSend("pauseEffect", Integer.valueOf(i));
        MyAudioApi.getInstance((Context) null).pauseEffect(i);
        return 0;
    }

    public int pauseAllEffects() {
        buildReportLogAndSend("pauseAllEffects", new Object[0]);
        MyAudioApi.getInstance((Context) null).pauseAllEffect();
        return 0;
    }

    public int resumeEffect(int i) {
        buildReportLogAndSend("resumeEffect", Integer.valueOf(i));
        MyAudioApi.getInstance((Context) null).resumeEffect(i);
        return 0;
    }

    public int resumeAllEffects() {
        buildReportLogAndSend("resumeAllEffects", new Object[0]);
        MyAudioApi.getInstance((Context) null).resumeAllEffect();
        return 0;
    }

    public OmniRtcChannel createRtcChannel(final String str) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return (OmniRtcChannel) omniInterSyncHelperImpl.executeInterObj(invokedMethodName, "channelName : " + str, new OmniInterSyncHelper() {
            public Object runObj(String str) {
                if (OmniRtcEngineImpl.this.mRtcEngineDestroyed) {
                    OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                    omniRtcEngineImpl.debugLogW("RtcEngine not created! " + str);
                    return 0;
                }
                String str2 = str;
                if (str2 == null || TextUtils.isEmpty(str2)) {
                    return null;
                }
                OmniRtcEngineImpl.this.buildReportLogAndSend(str, str);
                return OmniRtcEngineImpl.this.executingCreateRtcChannel(str);
            }
        });
    }

    public int startIjkPlayer(final String str, final boolean z) {
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return omniInterSyncHelperImpl.executeInter("startIjkPlayer pullAddress : " + str + " | mIsNormalPull : " + z, new OmniInterSyncHelper() {
            public int run() {
                AudioManager audioManager;
                OmniRtcEngineImpl omniRtcEngineImpl = OmniRtcEngineImpl.this;
                Object[] objArr = new Object[2];
                objArr[0] = TextUtils.isEmpty(str) ? "null" : str;
                objArr[1] = Boolean.valueOf(z);
                omniRtcEngineImpl.buildReportLogAndSend("startIjkPlayer", objArr);
                if (GlobalConfig.mIsInPullRoom) {
                    return 0;
                }
                if (!z) {
                    GlobalConfig.mExternalVideoSource = true;
                    if (!ExternalVideoSource.getInstance().startExterVideoSource(true)) {
                        return -6;
                    }
                }
                GlobalConfig.mIsInPullRoom = true;
                Object access$3300 = OmniRtcEngineImpl.this.handleIJKModule(new OmniLocalModuleConfig(1, new Object[]{str}));
                if (access$3300 == null) {
                    return 0;
                }
                int intValue = ((Integer) access$3300).intValue();
                if (intValue == 0 && (audioManager = (AudioManager) OmniRtcEngineImpl.this.mContext.getSystemService("audio")) != null) {
                    audioManager.setMode(0);
                }
                return intValue;
            }
        });
    }

    public int stopIjkPlayer() {
        return this.mOmniInterSyncHelperImpl.executeInter("stopIjkPlayer", new OmniInterSyncHelper() {
            public int run() {
                OmniRtcEngineImpl.this.buildReportLogAndSend("stopIjkPlayer", new Object[0]);
                if (GlobalConfig.mIsInPullRoom) {
                    ExternalVideoSource.getInstance().stopExterVideoSource();
                    Object access$3300 = OmniRtcEngineImpl.this.handleIJKModule(new OmniLocalModuleConfig(2, new Object[0]));
                    if (access$3300 != null) {
                        return ((Integer) access$3300).intValue();
                    }
                }
                return 0;
            }
        });
    }

    public OmniRtcEngineExtend getOmniRtcEngineExtend() {
        return this.mOmniRtcEngineExtend;
    }

    private boolean compareString(String str, String str2) {
        return (str == null && str2 == null) || (str != null && str.equals(str2));
    }

    public void OnReportFileDuration(int i) {
        this.mCurrentAudioMixingDuration = i;
    }

    public void OnReportPlayoutSeconds(int i) {
        this.mCurrentAudioMixingPosition = i;
    }

    public void removeChannel(String str) {
        ConcurrentHashMap<String, OmniRtcChannel> concurrentHashMap;
        if (!TextUtils.isEmpty(str)) {
            getInvokedMethodName();
            if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.mRtcChannels) != null) {
                concurrentHashMap.remove(str);
            }
        }
    }

    /* access modifiers changed from: private */
    public int executingJoinChannel(String str, String str2, long j) {
        String str3;
        if (GlobalConfig.mCurrentChannelMode != 0 && GlobalConfig.mCurrentChannelMode != 1 && GlobalConfig.mCurrentChannelMode != 2) {
            String str4 = TAG;
            OmniLog.e(str4, "executingJoinChannel channelKey:" + str + " channelName:" + str2 + " optionalUid:" + j);
            return -5;
        } else if (!this.mRtcInvokeSafetyChecker.checkJoinChannelArgs(str2, j)) {
            String str5 = TAG;
            OmniLog.e(str5, "executingJoinChannel checkJoinChannelArgs checkResult:" + str);
            return -5;
        } else {
            String str6 = str == null ? "" : str;
            if (GlobalConfig.mIsInRoom.get()) {
                String str7 = TAG;
                OmniLog.e(str7, "joinChannel -> Already in room! " + str2 + " | current room id : " + GlobalConfig.mLocalRoomName);
                return 0;
            }
            int i = GlobalConfig.mLocalRole;
            boolean isChannelAVNotMuted = GlobalHolder.getInstance().getAVStreamPublishHandler().isChannelAVNotMuted();
            if (i == 1 && isChannelAVNotMuted) {
                String str8 = TAG;
                OmniLog.e(str8, "executingJoinChannel channelAVNotMuted:" + isChannelAVNotMuted + " role:" + i);
                return -5;
            } else if (!GlobalConfig.mIsLogining.get() || !compareString(this.mCurrentLoginChanelKey, str6) || !compareString(this.mCurrentLoginChannel, str2) || j != this.mCurrentLoginUserID) {
                int i2 = GlobalConfig.mCurrentChannelMode;
                this.mCurrentLoginChanelKey = str6;
                this.mCurrentLoginUserID = j;
                GlobalConfig.mIsLogining.set(true);
                if (this.mCurrentLoginChannel != null) {
                    EnterConfApi.getInstance().exitRoom(str2);
                    this.mCurrentLoginChannel = null;
                }
                this.mCurrentLoginChannel = str2;
                String str9 = this.mRtmpUrl;
                if (i2 == 1 && i == 1) {
                    str3 = str9;
                } else {
                    str3 = "";
                }
                if (i2 == 1) {
                    GlobalConfig.mIsRequireChair = true;
                    GlobalConfig.mIsCreateVideoMixer = true;
                } else {
                    GlobalConfig.mIsRequireChair = false;
                    GlobalConfig.mIsCreateVideoMixer = false;
                }
                String str10 = TAG;
                OmniLog.i(str10, "joinChannel -> token : " + str6 + " | channel id : " + str2 + " | uid : " + j + " | role : " + i + " | url : " + str3);
                return EnterConfApi.getInstance().enterRoom(str6, j, str2, i, str3);
            } else {
                OmniLog.e(TAG, "joinChannel -> Already joining room!");
                return 0;
            }
        }
    }

    private void resetEngineStatusForLeaveChannel() {
        ExternalVideoSource.getInstance().stopExterVideoSource();
        this.mCurrentLoginChannel = "";
        this.mCurrentLoginChanelKey = "";
        this.mCurrentLoginUserID = 0;
        this.mRtmpUrl = "";
        GlobalConfig.mIsLogining.set(false);
        this.mAudioMixSoloVolume = 1.0d;
        this.mVideoMixerWidth = -1;
        this.mVideoMixerHeight = -1;
    }

    /* access modifiers changed from: private */
    public int executingSetupLocalVideo(VideoCanvas videoCanvas, boolean z, int i, VideoRotate videoRotate) {
        if (videoCanvas == null) {
            OmniLog.i(TAG, "executingSetupLocalVideo canvas is null");
            return -5;
        }
        SurfaceView surface = videoCanvas.getSurface();
        TextureView viewRenderView = videoCanvas.getViewRenderView();
        if (surface == null && viewRenderView == null) {
            OmniLog.i(TAG, "executingSetupLocalVideo canvas is null");
            return -5;
        } else if (!z || videoRotate != null) {
            Object handleVideoModule = handleVideoModule(new OmniLocalModuleConfig(7, new Object[]{surface, viewRenderView, Boolean.valueOf(z), Integer.valueOf(i), videoRotate, Integer.valueOf(videoCanvas.getShowMode()), videoCanvas.getmWaterMarkPosition()}));
            if (handleVideoModule != null) {
                return ((Integer) handleVideoModule).intValue();
            }
            OmniLog.i(TAG, "executingSetupLocalVideo ret:-6");
            return -6;
        } else {
            String str = TAG;
            OmniLog.i(str, "executingSetupLocalVideo rotate:" + videoRotate);
            return -5;
        }
    }

    /* access modifiers changed from: private */
    public OmniRtcChannel executingCreateRtcChannel(String str) {
        OmniRtcChannel omniRtcChannel = this.mRtcChannels.get(str);
        if (omniRtcChannel != null) {
            OmniLog.e("executingCreateRtcChannel channelName:" + str);
            return omniRtcChannel;
        }
        OnRtcChannelImpl onRtcChannelImpl = new OnRtcChannelImpl(str, false);
        this.mRtcChannels.put(str, onRtcChannelImpl);
        return onRtcChannelImpl;
    }

    /* access modifiers changed from: private */
    public int switchChannelInternal(String str, String str2, ChannelMediaOptions channelMediaOptions) {
        if (GlobalConfig.mLocalRole != 2 || TextUtils.isEmpty(str2)) {
            return -5;
        }
        if (str2.equals(GlobalConfig.mLocalRoomName)) {
            return 0;
        }
        long j = GlobalConfig.mLocalOwnerUid;
        executeLeaveChannel();
        GlobalConfig.mLocalRole = 2;
        GlobalConfig.mAudioLocalStreamEnabled = false;
        GlobalConfig.mVideoLocalStreamEnabled = false;
        if (channelMediaOptions != null) {
            if (!channelMediaOptions.autoSubscribeAudio) {
                EnterConfApi.getInstance().muteAllRemoteAudioForChannel(true);
            }
            if (!channelMediaOptions.autoSubscribeVideo) {
                EnterConfApi.getInstance().muteAllRemoteVideoForChannel(true);
            }
        }
        return executingJoinChannel(str, str2, j);
    }

    public int setRemoteVolumeAll(int i) {
        return this.mOmniAudioModule.setRemoteVolumeAll(i);
    }

    public int takePreEncodeSnapshot() {
        return ((Integer) this.mOmniInterSyncHelperImpl.executeInterObj(getInvokedMethodName(), new OmniInterSyncHelper() {
            public Object runObj(String str) {
                RtcEngineEventReporter rtcEngineEventReporter = GlobalHolder.getInstance().getRtcEngineEventReporter();
                if (rtcEngineEventReporter != null) {
                    rtcEngineEventReporter.takePreEncodeSnapshot();
                }
                return 0;
            }
        })).intValue();
    }

    public int setSlbAddress(final String str, final String str2) {
        return ((Integer) this.mOmniInterSyncHelperImpl.executeInterObj(getInvokedMethodName(), new OmniInterSyncHelper() {
            public Object runObj(String str) {
                RoomJni.getInstance().SetSlbAddress(str, str2);
                return 0;
            }
        })).intValue();
    }

    public int setServerLogAddress(final String str) {
        return ((Integer) this.mOmniInterSyncHelperImpl.executeInterObj(getInvokedMethodName(), new OmniInterSyncHelper() {
            public Object runObj(String str) {
                GlobalConfig.mServerLogUrl = str;
                ReportLogJni.getInstance().setupLogConnection(str);
                return 0;
            }
        })).intValue();
    }

    public int setImageReportUrl(final String str) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return ((Integer) omniInterSyncHelperImpl.executeInterObj(invokedMethodName, "url = " + str, new OmniInterSyncHelper() {
            public Object runObj(String str) {
                return Integer.valueOf(EnterConfApi.getInstance().setImageReportUrl(str));
            }
        })).intValue();
    }

    public int setAppExtensionInfo(final String str) {
        String invokedMethodName = getInvokedMethodName();
        OmniInterSyncHelperImpl omniInterSyncHelperImpl = this.mOmniInterSyncHelperImpl;
        return ((Integer) omniInterSyncHelperImpl.executeInterObj(invokedMethodName, "jsonInfo = " + str, new OmniInterSyncHelper() {
            public Object runObj(String str) {
                return Integer.valueOf(EnterConfApi.getInstance().setAppExtensionInfo(str));
            }
        })).intValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object[]} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executingSeiContentInsert(java.lang.String r8) {
        /*
            r7 = this;
            boolean r0 = r7.mIsNeedInsert
            r1 = 0
            if (r0 != 0) goto L_0x0008
            r7.mInsertBytes = r1
            return
        L_0x0008:
            java.lang.String r0 = "UTF-8"
            byte[] r0 = r8.getBytes(r0)     // Catch:{ UnsupportedEncodingException -> 0x000f }
            goto L_0x0014
        L_0x000f:
            r0 = move-exception
            r0.printStackTrace()
            r0 = r1
        L_0x0014:
            if (r0 != 0) goto L_0x002d
            r7.mInsertBytes = r1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "insertH264Content watcher : Get sei content failed !!: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            com.wushuangtech.utils.OmniLog.i(r8)
            return
        L_0x002d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "insertH264Content watcher : Get sei content : "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            com.wushuangtech.utils.OmniLog.d(r8)
            com.wushuangtech.wstechapi.bean.OmniLocalModuleConfig r8 = new com.wushuangtech.wstechapi.bean.OmniLocalModuleConfig
            r2 = 21
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            int r5 = r0.length
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6 = 0
            r4[r6] = r5
            r8.<init>(r2, r4)
            java.lang.Object r8 = r7.handleVideoModule((com.wushuangtech.wstechapi.bean.OmniLocalModuleConfig) r8)
            if (r8 == 0) goto L_0x007a
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            byte[] r8 = new byte[r8]
            r7.mInsertBytes = r8
            com.wushuangtech.wstechapi.bean.OmniLocalModuleConfig r1 = new com.wushuangtech.wstechapi.bean.OmniLocalModuleConfig
            r2 = 22
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r6] = r8
            r4[r3] = r0
            r1.<init>(r2, r4)
            r7.handleVideoModule((com.wushuangtech.wstechapi.bean.OmniLocalModuleConfig) r1)
            java.lang.String r8 = "insertH264Content watcher : SeiPacket Over!"
            com.wushuangtech.utils.OmniLog.d(r8)
            goto L_0x0081
        L_0x007a:
            r7.mInsertBytes = r1
            java.lang.String r8 = "insertH264Content watcher : SeiPacket failed!"
            com.wushuangtech.utils.OmniLog.d(r8)
        L_0x0081:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.wstechapi.internal.OmniRtcEngineImpl.executingSeiContentInsert(java.lang.String):void");
    }

    private int realStartRecordScreen(boolean z, Intent intent, ScreenRecordConfig screenRecordConfig) {
        final boolean z2 = z;
        final ScreenRecordConfig screenRecordConfig2 = screenRecordConfig;
        if ((GlobalConfig.mBranch != LocalSDKConstants.BRANCH_CLIENT_XIAOYUN && GlobalConfig.mBranch != LocalSDKConstants.BRANCH_CLIENT_TY && Build.VERSION.SDK_INT >= 29) || Build.VERSION.SDK_INT < 21) {
            return -6;
        }
        if (!z2) {
            GlobalAudioConfig globalAudioConfig = GlobalHolder.getInstance().getGlobalAudioConfig();
            if (globalAudioConfig == null) {
                return -6;
            }
            AudioEncodedConfig audioEncodedConfig = globalAudioConfig.getAudioEncodedConfig();
            if (audioEncodedConfig.mEncodeType != 1 && audioEncodedConfig.mEncodeBitrate < 48) {
                return -6;
            }
        }
        File file = null;
        if (!z2 && (file = getScreenRecordSaveFile()) == null) {
            return -3;
        }
        ScreenEncoderConfig screenEncoderConfig = new ScreenEncoderConfig(file, screenRecordConfig2.mRecordWidth, screenRecordConfig2.mRecordHeight, screenRecordConfig2.mRecordBitRate, screenRecordConfig2.mRecordFrameRate, screenRecordConfig2.mRecordIFrameInterval, screenRecordConfig2.mBitrateMode == 0 ? 0 : 1);
        this.mScreenCapture.setOnScreenStartListener(new ScreenCapture.OnScreenStartListener() {
            public void onScreenStartResult(boolean z) {
                String access$900 = OmniRtcEngineImpl.TAG;
                OmniLog.screen_d(access$900, "Q screen start result coming! " + z);
                if (z && z2) {
                    VideoJni.getInstance().VideoChangeDefaultMediaType(String.valueOf(GlobalConfig.mLocalUserID), 1);
                }
                if (screenRecordConfig2.mOnScreenStartListener != null) {
                    screenRecordConfig2.mOnScreenStartListener.onScreenStartResult(z);
                }
            }
        });
        long currentTimeMillis = System.currentTimeMillis();
        this.mScreenCapture.setScreenCaptureType(z2);
        int startBlockingCapture = this.mScreenCapture.startBlockingCapture(intent, screenEncoderConfig);
        String str = TAG;
        OmniLog.screen_d(str, "Start screen record over, spend time : " + (System.currentTimeMillis() - currentTimeMillis));
        if (startBlockingCapture != 0) {
            return -6;
        }
        if (Build.VERSION.SDK_INT < 29 && z2) {
            VideoJni.getInstance().VideoChangeDefaultMediaType(String.valueOf(GlobalConfig.mLocalUserID), 1);
        }
        return 0;
    }

    private File getScreenRecordSaveFile() {
        File file;
        if (Build.VERSION.SDK_INT < 29) {
            file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            if (file == null) {
                return null;
            }
        } else {
            file = this.mContext.getExternalFilesDir((String) null);
            if (file == null) {
                return null;
            }
        }
        String absolutePath = file.getAbsolutePath();
        File file2 = new File(absolutePath, System.currentTimeMillis() + ".temp");
        String str = TAG;
        OmniLog.screen_d(str, "System Image Path : " + absolutePath);
        return file2;
    }

    /* access modifiers changed from: package-private */
    public void responseForJoinChannel(final ChannelJoinResponse channelJoinResponse) {
        String str = TAG;
        OmniLog.rw_i(str, "responseForJoinChannel response:" + channelJoinResponse);
        this.mOmniInterSyncHelperImpl.executeInterBool("", new OmniInterSyncHelper() {
            public boolean runBool() {
                String channelName = channelJoinResponse.getChannelName();
                String access$900 = OmniRtcEngineImpl.TAG;
                OmniLog.rw_i(access$900, "responseForJoinChannel channelName:" + channelName);
                if (!OmniRtcEngineImpl.this.mCurrentLoginChannel.equals(channelName)) {
                    String access$9002 = OmniRtcEngineImpl.TAG;
                    OmniLog.rw_e(access$9002, "executeJoinRoom failed! mCurrentLoginChannel : " + OmniRtcEngineImpl.this.mCurrentLoginChannel + " | channel id: " + channelName);
                    return false;
                }
                String unused = OmniRtcEngineImpl.this.mCurrentLoginChanelKey = "";
                String unused2 = OmniRtcEngineImpl.this.mCurrentLoginChannel = "";
                long unused3 = OmniRtcEngineImpl.this.mCurrentLoginUserID = 0;
                ((EnterConfApiImpl) EnterConfApi.getInstance()).handleJoinChannelResponse(channelJoinResponse);
                if (!GlobalConfig.mIsNeedSetRole) {
                    return true;
                }
                EnterConfApi.getInstance().changeUserRole(GlobalConfig.mLocalRole);
                GlobalConfig.mIsNeedSetRole = false;
                return true;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public String getInvokedMethodName() {
        return Thread.currentThread().getStackTrace()[3].getMethodName();
    }

    /* access modifiers changed from: private */
    public void buildReportLogAndSend(String str, Object... objArr) {
        this.mOmniInterSyncHelperImpl.buildReportLogAndSend(str, objArr);
    }

    /* access modifiers changed from: private */
    public void buildReportLogAndSend(int i, String str, Object... objArr) {
        this.mOmniInterSyncHelperImpl.buildReportLogAndSend(i, str, objArr);
    }

    /* access modifiers changed from: private */
    public void log(String str) {
        OmniLog.i(TAG, str);
    }

    /* access modifiers changed from: private */
    public void debugLogW(String str) {
        OmniLog.w(TAG, str);
    }
}
