package com.wushuangtech.library;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.wushuangtech.api.EnterConfApi;
import com.wushuangtech.api.EnterConfApiImpl;
import com.wushuangtech.api.ExternalAudioModule;
import com.wushuangtech.api.ExternalVideoModule;
import com.wushuangtech.api.InterCorrectionManager;
import com.wushuangtech.api.RtcBaseManager;
import com.wushuangtech.api.RtcDataStreamManager;
import com.wushuangtech.api.RtcDeviceManager;
import com.wushuangtech.api.RtcEngineEventReporter;
import com.wushuangtech.api.RtcPublishStreamManager;
import com.wushuangtech.api.RtcUserManager;
import com.wushuangtech.bean.AVStreamPublishBean;
import com.wushuangtech.bean.ChannelInfoBean;
import com.wushuangtech.bean.LogEvent;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.constants.RtcGlobalServerMessage;
import com.wushuangtech.constants.RtcNativeCallBackFun;
import com.wushuangtech.expansion.inter.OmniInterfaceTestCallBack;
import com.wushuangtech.expansion.inter.OmniRtcEngineEventInter;
import com.wushuangtech.handler.AVStreamPublishHandler;
import com.wushuangtech.handler.NetworkQualityHandler;
import com.wushuangtech.inter.OnRtcGlobalMessageCallBack;
import com.wushuangtech.inter.OnRtcGlobalServerMessageCallBack;
import com.wushuangtech.inter.OnTestCallBack;
import com.wushuangtech.inter.OnVideoCameraPreviewFrameListener;
import com.wushuangtech.inter.RtcGlobalAVInterface;
import com.wushuangtech.inter.RtcGlobalEventInterface;
import com.wushuangtech.jni.NativeInitializer;
import com.wushuangtech.jni.NetTestJni;
import com.wushuangtech.jni.ReportLogJni;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.jni.VideoJni;
import com.wushuangtech.jni.callback.RtcGlobalSignalCallBackImpl;
import com.wushuangtech.library.video.LibYuvManager;
import com.wushuangtech.library.video.VideoDualStreamManager;
import com.wushuangtech.library.video.VideoStatistical;
import com.wushuangtech.log.ReportLogger;
import com.wushuangtech.log.ReportLoggerImpl;
import com.wushuangtech.log.RtcHeartbeatReporter;
import com.wushuangtech.thread.EngineCallbackThread;
import com.wushuangtech.utils.GenericUtils;
import com.wushuangtech.utils.OmniLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GlobalHolder {
    private static final String TAG = "GlobalHolder";
    private static volatile GlobalHolder holder = null;
    public static volatile boolean trunOnCallback = true;
    private AVStreamPublishHandler mAVStreamPublishHandler;
    private final Lock mAudioStartLisenerLock = new ReentrantLock();
    private int mBluetoothBeforeAudioMode;
    private final HashMap<String, String> mCacheSessionIds = new HashMap<>();
    private final Object mCallBackLock = new Object();
    private String mChannelNameHoldBroadcaster = GlobalConfig.ENGINE_NAME;
    private Context mContext;
    private int mCurrentAudioRoute = -1;
    private HashMap<String, RtcDataStreamManager> mDataStreamArray;
    private final String[] mEvnetReportOnce = {RtcNativeCallBackFun.CHANNEL_AV_MEDIA_ADDRESS, RtcNativeCallBackFun.CHANNEL_CONNECT_LOST, RtcNativeCallBackFun.CHANNEL_RECONNECT_SUCCESS, RtcNativeCallBackFun.CHANNEL_RECONNECT_FAILED};
    private RtcGlobalAVInterface mGlobalAVInterface;
    private GlobalChannelConfig mGlobalChannelConfig;
    private InterCorrectionManager mInterCorrectionManager;
    private LocalGlobalEventInterface mLocalGlobalEventInterface;
    private final HashMap<String, String> mMixDeviceIds = new HashMap<>();
    private final Lock mMixVideoDeviceLock = new ReentrantLock();
    private NetworkQualityHandler mNetworkQualityHandler;
    private OmniInterfaceTestCallBack mOmniInterfaceTestCallBack;
    private CopyOnWriteArrayList<WeakReference<OnRtcGlobalMessageCallBack>> mOnRtcGlobalMessageCallBackList;
    private OnTestCallBack mOnTestCallBack;
    private final List<OnVideoCameraPreviewFrameListener> mOnVideoCameraPreviewFrameListeners = new ArrayList();
    private List<ChannelInfoBean> mRtcChannelNames;
    private RtcEngineEventReporter mRtcEngineEventReporter;
    private ConcurrentHashMap<String, ReportLogger> mRtcEventReporters = new ConcurrentHashMap<>();
    private RtcGlobalSignalCallBackImpl mRtcGlobalSignalCallBackImpl;
    private HashMap<String, RtcHeartbeatReporter> mRtcHeartbeatReporters = new HashMap<>();
    private ConcurrentHashMap<String, ReportLoggerImpl> mRtcInterInvokeReporters = new ConcurrentHashMap<>();
    private HashMap<String, RtcPublishStreamManager> mRtcPublishStreamManager = new HashMap<>();
    private int mSpeakState = -1;
    private HashMap<String, RtcDeviceManager> mUserDeviceList;
    /* access modifiers changed from: private */
    public final Object mUserManagerLock = new Object();
    /* access modifiers changed from: private */
    public HashMap<String, RtcUserManager> mUserManagers;
    private final Object mVideoCameraPreviewFrameListenersLock = new Object();
    private HashMap<String, VideoDualStreamManager> mVideoDualStreamManagerArray;
    private EngineCallbackThread mWorkerThread;
    private LibYuvManager mYuvManager;
    private ReportLoggerImpl reportLoggerImpl;

    public void notifyAudioStartPlayListener(boolean z) {
    }

    public void setAudioSpeaker(String str, AudioManager audioManager, boolean z) {
    }

    public void setBluetoothAudioMode(String str, AudioManager audioManager, boolean z) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0037, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int setRoleForBroadcaster(java.lang.String r5, int r6) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.mUserManagerLock
            monitor-enter(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0038 }
            if (r1 == 0) goto L_0x000c
            r5 = -1
            monitor-exit(r0)     // Catch:{ all -> 0x0038 }
            return r5
        L_0x000c:
            java.lang.String r1 = r4.mChannelNameHoldBroadcaster     // Catch:{ all -> 0x0038 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0038 }
            r2 = 1
            r1 = r1 ^ r2
            r3 = 0
            if (r6 != r2) goto L_0x0028
            if (r1 == 0) goto L_0x0024
            java.lang.String r6 = r4.mChannelNameHoldBroadcaster     // Catch:{ all -> 0x0038 }
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x0038 }
            if (r6 != 0) goto L_0x0024
            r5 = -5
            monitor-exit(r0)     // Catch:{ all -> 0x0038 }
            return r5
        L_0x0024:
            r4.mChannelNameHoldBroadcaster = r5     // Catch:{ all -> 0x0038 }
            monitor-exit(r0)     // Catch:{ all -> 0x0038 }
            return r3
        L_0x0028:
            if (r1 == 0) goto L_0x0036
            java.lang.String r6 = r4.mChannelNameHoldBroadcaster     // Catch:{ all -> 0x0038 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0038 }
            if (r5 == 0) goto L_0x0036
            java.lang.String r5 = ""
            r4.mChannelNameHoldBroadcaster = r5     // Catch:{ all -> 0x0038 }
        L_0x0036:
            monitor-exit(r0)     // Catch:{ all -> 0x0038 }
            return r3
        L_0x0038:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0038 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.library.GlobalHolder.setRoleForBroadcaster(java.lang.String, int):int");
    }

    private GlobalHolder() {
    }

    public static GlobalHolder getInstance() {
        if (holder == null) {
            synchronized (GlobalHolder.class) {
                if (holder == null) {
                    holder = new GlobalHolder();
                }
            }
        }
        return holder;
    }

    public void initSdk(Context context, String str, OmniRtcEngineEventInter omniRtcEngineEventInter) {
        EnterConfApi instance = EnterConfApi.getInstance();
        NativeInitializer intance = NativeInitializer.getIntance();
        intance.initialize(context, GlobalConfig.SDK_VERSION_NAME, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS) + File.separator + "rtcsdk", 5);
        RoomJni instance2 = RoomJni.getInstance();
        VideoJni instance3 = VideoJni.getInstance();
        ReportLogJni instance4 = ReportLogJni.getInstance();
        NetTestJni instance5 = NetTestJni.getInstance();
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            instance2.SetSandboxPath(filesDir.getAbsolutePath());
        }
        String valueOf = String.valueOf(Build.VERSION.SDK_INT);
        instance2.SetSystemInfo(valueOf, "Android_" + Build.MODEL, GlobalConfig.SDK_VERSION_NAME);
        this.mContext = context;
        GlobalConfig.mAppId = str;
        this.mGlobalChannelConfig = new GlobalChannelConfig();
        this.mRtcGlobalSignalCallBackImpl = new RtcGlobalSignalCallBackImpl();
        this.mLocalGlobalEventInterface = new LocalGlobalEventInterface(this);
        RtcGlobalAVInterfaceImpl rtcGlobalAVInterfaceImpl = new RtcGlobalAVInterfaceImpl();
        this.mGlobalAVInterface = rtcGlobalAVInterfaceImpl;
        rtcGlobalAVInterfaceImpl.setRtcGlobalSignalCallBack(this.mRtcGlobalSignalCallBackImpl);
        this.mGlobalAVInterface.setGlobalEventInterface(this.mLocalGlobalEventInterface);
        this.mGlobalAVInterface.init();
        this.mYuvManager = new LibYuvManager();
        this.mInterCorrectionManager = new InterCorrectionManager();
        this.mNetworkQualityHandler = new NetworkQualityHandler();
        this.reportLoggerImpl = new ReportLoggerImpl();
        this.mAVStreamPublishHandler = new AVStreamPublishHandler();
        AVStreamPublishBean aVStreamPublishBean = new AVStreamPublishBean(GlobalConfig.ENGINE_NAME);
        aVStreamPublishBean.mRole = GlobalConfig.mLocalRole;
        aVStreamPublishBean.mAudioMuted = !GlobalConfig.mAudioLocalStreamEnabled;
        aVStreamPublishBean.mVideoMuted = !GlobalConfig.mVideoLocalStreamEnabled;
        this.mAVStreamPublishHandler.addAVStreamPublishBean(aVStreamPublishBean);
        this.mAVStreamPublishHandler.setAVStreamPublishBean(aVStreamPublishBean);
        RtcEngineEventReporter rtcEngineEventReporter = new RtcEngineEventReporter();
        this.mRtcEngineEventReporter = rtcEngineEventReporter;
        rtcEngineEventReporter.addEventReceiver(omniRtcEngineEventInter);
        this.mOnRtcGlobalMessageCallBackList = new CopyOnWriteArrayList<>();
        instance2.addCallback(this.mRtcGlobalSignalCallBackImpl);
        instance2.addCallback(instance);
        instance3.addCallback(instance);
        instance4.addCallback(instance);
        instance5.addCallback(instance);
        this.mRtcGlobalSignalCallBackImpl.addRtcGlobalServerMessageCallback(instance);
        EngineCallbackThread engineCallbackThread = new EngineCallbackThread();
        this.mWorkerThread = engineCallbackThread;
        engineCallbackThread.startAndWaitReady();
        ((EnterConfApiImpl) instance).setEngineCallBackThread(this.mWorkerThread);
    }

    public void reinitialize(Context context, String str, OmniRtcEngineEventInter omniRtcEngineEventInter) {
        OmniLog.i(TAG, "Setup reinit sdk...");
        this.mContext = context;
        GlobalConfig.mAppId = str;
        this.mRtcEngineEventReporter.addEventReceiver(omniRtcEngineEventInter);
    }

    public void unInitSdk() {
        OmniLog.i(TAG, "Uninit sdk...");
        RtcEngineEventReporter rtcEngineEventReporter = this.mRtcEngineEventReporter;
        if (rtcEngineEventReporter != null) {
            rtcEngineEventReporter.clearReceiver();
        }
    }

    public void initGlobalChannelAfterJoinChannel(String str) {
        boolean z;
        List<ChannelInfoBean> list = this.mRtcChannelNames;
        if (list != null && list.size() > 0) {
            String str2 = null;
            synchronized (this.mUserManagerLock) {
                if (list.size() == 1) {
                    str2 = list.get(0).mChannelName;
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                RtcGlobalAVInterface rtcGlobalAVInterface = this.mGlobalAVInterface;
                if (rtcGlobalAVInterface != null) {
                    rtcGlobalAVInterface.configChannelAfterJoinChannel();
                }
                GlobalChannelConfig globalChannelConfig = this.mGlobalChannelConfig;
                if (globalChannelConfig != null) {
                    globalChannelConfig.configChannelAfterJoinChannel(this.mContext, str2);
                }
                sendSyncGlobalMessage(500, str);
            }
            RtcGlobalAVInterface rtcGlobalAVInterface2 = this.mGlobalAVInterface;
            if (rtcGlobalAVInterface2 != null) {
                rtcGlobalAVInterface2.initChannelAfterJoinChannel(str);
            }
        }
    }

    public void initChannel(String str, long j, int i, String str2) {
        String str3 = str;
        String str4 = str2;
        if (str3 == null) {
            String str5 = TAG;
            OmniLog.e(str5, "channelName is null uid:" + j + " role:" + i + " connectId:" + str4);
            return;
        }
        long j2 = j;
        int i2 = i;
        synchronized (this.mUserManagerLock) {
            initChannelInfoList(str);
            this.mUserManagers = initChannelManager(str, this.mUserManagers, RtcUserManager.class, str3);
            this.mUserDeviceList = initChannelManager(str, this.mUserDeviceList, RtcDeviceManager.class, str3);
            this.mDataStreamArray = initChannelManager(str, this.mDataStreamArray, RtcDataStreamManager.class, str3, Long.valueOf(j));
            this.mVideoDualStreamManagerArray = initChannelManager(str, this.mVideoDualStreamManagerArray, VideoDualStreamManager.class, str3);
            this.mRtcHeartbeatReporters = initChannelManager(str, this.mRtcHeartbeatReporters, RtcHeartbeatReporter.class, str3, Long.valueOf(j), Integer.valueOf(i), str4);
            this.mRtcPublishStreamManager = initChannelManager(str, this.mRtcPublishStreamManager, RtcPublishStreamManager.class, str3);
            RtcHeartbeatReporter rtcHeartbeatReporter = this.mRtcHeartbeatReporters.get(str);
            if (rtcHeartbeatReporter != null) {
                rtcHeartbeatReporter.setSessionId(this.mCacheSessionIds.remove(str));
                rtcHeartbeatReporter.initHeartBeatStatus(GlobalConfig.mAudioEnabled, GlobalConfig.mAudioLocalEnabled, GlobalConfig.mAudioLocalStreamEnabled, GlobalConfig.mVideoEnabled, GlobalConfig.mVideoLocalEnabled, GlobalConfig.mVideoLocalStreamEnabled);
            }
        }
        String str6 = LocalSDKConstants.USER_ACTION_PREFIX_ENGINE;
        if (!str.equals(GlobalConfig.mLocalRoomName)) {
            str6 = LocalSDKConstants.USER_ACTION_PREFIX_CHANNEL;
        }
        handleUserActionReport(str6, str, 4, new Object[0]);
    }

    public ReportLogger initChannelEventReporter(String str, long j, int i, String str2) {
        synchronized (this.mUserManagerLock) {
            ConcurrentHashMap<String, ReportLogger> concurrentHashMap = this.mRtcEventReporters;
            if (concurrentHashMap == null) {
                this.mRtcEventReporters = new ConcurrentHashMap<>();
            } else {
                ReportLogger reportLogger = concurrentHashMap.get(str);
                if (reportLogger != null) {
                    reportLogger.setParams(str, j, i, str2);
                    return reportLogger;
                }
            }
            ReportLogger reportLogger2 = new ReportLogger(str, j, i, str2);
            this.mRtcEventReporters.put(str, reportLogger2);
            return reportLogger2;
        }
    }

    public ReportLoggerImpl initChannelInterInvokeReporter(String str) {
        synchronized (this.mUserManagerLock) {
            ConcurrentHashMap<String, ReportLoggerImpl> concurrentHashMap = this.mRtcInterInvokeReporters;
            if (concurrentHashMap == null) {
                this.mRtcInterInvokeReporters = new ConcurrentHashMap<>();
            } else {
                ReportLoggerImpl reportLoggerImpl2 = concurrentHashMap.get(str);
                if (reportLoggerImpl2 != null) {
                    return reportLoggerImpl2;
                }
            }
            ReportLoggerImpl reportLoggerImpl3 = new ReportLoggerImpl();
            this.mRtcInterInvokeReporters.put(str, reportLoggerImpl3);
            return reportLoggerImpl3;
        }
    }

    public void clearChannelDatas(String str) {
        boolean z;
        RtcPublishStreamManager remove;
        RtcHeartbeatReporter remove2;
        ReportLogger remove3;
        synchronized (this.mUserManagerLock) {
            OmniLog.i(TAG, "Clear channel resource... " + str);
            z = false;
            if (this.mRtcChannelNames != null) {
                int i = 0;
                while (true) {
                    if (i >= this.mRtcChannelNames.size()) {
                        i = -1;
                        break;
                    } else if (this.mRtcChannelNames.get(i).mChannelName.equals(str)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    this.mRtcChannelNames.remove(i);
                    if (this.mRtcChannelNames.size() <= 0) {
                        z = true;
                    }
                }
            }
            if (str.equals(this.mChannelNameHoldBroadcaster)) {
                this.mChannelNameHoldBroadcaster = "";
            }
        }
        if (z) {
            destroy();
        } else {
            ExternalAudioModule.getInstance().leaveChannel(str);
            ExternalVideoModule.getInstance().stopPlay(str);
            GlobalVideoConfig globalVideoConfig = getGlobalVideoConfig();
            if (globalVideoConfig != null) {
                globalVideoConfig.clearResource(str);
            }
            InterCorrectionManager interCorrectionManager = this.mInterCorrectionManager;
            if (interCorrectionManager != null) {
                interCorrectionManager.clearResource(str);
            }
            synchronized (this.mUserManagerLock) {
                HashMap<String, RtcUserManager> hashMap = this.mUserManagers;
                if (hashMap != null) {
                    RtcUserManager rtcUserManager = hashMap.get(str);
                    if (rtcUserManager != null) {
                        rtcUserManager.clearResource();
                    }
                    this.mUserManagers.remove(str);
                }
                HashMap<String, RtcDeviceManager> hashMap2 = this.mUserDeviceList;
                if (hashMap2 != null) {
                    RtcDeviceManager rtcDeviceManager = hashMap2.get(str);
                    if (rtcDeviceManager != null) {
                        rtcDeviceManager.clearResource();
                    }
                    this.mUserDeviceList.remove(str);
                }
                HashMap<String, RtcDataStreamManager> hashMap3 = this.mDataStreamArray;
                if (hashMap3 != null) {
                    RtcDataStreamManager rtcDataStreamManager = hashMap3.get(str);
                    if (rtcDataStreamManager != null) {
                        rtcDataStreamManager.clearResource();
                    }
                    this.mDataStreamArray.remove(str);
                }
                HashMap<String, VideoDualStreamManager> hashMap4 = this.mVideoDualStreamManagerArray;
                if (hashMap4 != null) {
                    VideoDualStreamManager videoDualStreamManager = hashMap4.get(str);
                    if (videoDualStreamManager != null) {
                        videoDualStreamManager.clearResource();
                    }
                    this.mVideoDualStreamManagerArray.remove(str);
                }
                ConcurrentHashMap<String, ReportLogger> concurrentHashMap = this.mRtcEventReporters;
                if (!(concurrentHashMap == null || (remove3 = concurrentHashMap.remove(str)) == null)) {
                    remove3.clearResource();
                }
                HashMap<String, RtcHeartbeatReporter> hashMap5 = this.mRtcHeartbeatReporters;
                if (!(hashMap5 == null || (remove2 = hashMap5.remove(str)) == null)) {
                    remove2.clearResource();
                }
                HashMap<String, RtcPublishStreamManager> hashMap6 = this.mRtcPublishStreamManager;
                if (!(hashMap6 == null || (remove = hashMap6.remove(str)) == null)) {
                    remove.clearResource();
                }
                ConcurrentHashMap<String, ReportLoggerImpl> concurrentHashMap2 = this.mRtcInterInvokeReporters;
                if (concurrentHashMap2 != null) {
                    concurrentHashMap2.remove(str);
                }
                if (!str.equals(GlobalConfig.mLocalRoomName)) {
                    this.reportLoggerImpl.clearResource();
                }
            }
        }
        OmniLog.i(TAG, "Clear channel resource over... ");
    }

    public void destroy() {
        String str = TAG;
        OmniLog.i(str, "Starting destroy global resource...");
        GlobalChannelConfig globalChannelConfig = this.mGlobalChannelConfig;
        if (globalChannelConfig != null) {
            globalChannelConfig.unConfigChannelAfterJoinChannel();
        }
        RtcGlobalAVInterface rtcGlobalAVInterface = this.mGlobalAVInterface;
        if (rtcGlobalAVInterface != null) {
            rtcGlobalAVInterface.clearResource();
        }
        InterCorrectionManager interCorrectionManager = this.mInterCorrectionManager;
        if (interCorrectionManager != null) {
            interCorrectionManager.clearResource();
        }
        OmniLog.i(str, "Starting destroy global list...");
        synchronized (this.mUserManagerLock) {
            List<ChannelInfoBean> list = this.mRtcChannelNames;
            if (list != null) {
                list.clear();
                this.mRtcChannelNames = null;
            }
            unInitChannelManager(this.mUserManagers);
            unInitChannelManager(this.mUserDeviceList);
            unInitChannelManager(this.mDataStreamArray);
            unInitChannelManager(this.mVideoDualStreamManagerArray);
            unInitChannelManager(this.mRtcHeartbeatReporters);
            unInitChannelManager(this.mRtcPublishStreamManager);
            this.mUserManagers = null;
            this.mUserDeviceList = null;
            this.mDataStreamArray = null;
            this.mVideoDualStreamManagerArray = null;
            this.mRtcHeartbeatReporters = null;
            this.mRtcPublishStreamManager = null;
            this.reportLoggerImpl.clearResource();
            ConcurrentHashMap<String, ReportLogger> concurrentHashMap = this.mRtcEventReporters;
            if (concurrentHashMap != null) {
                for (Map.Entry<String, ReportLogger> value : concurrentHashMap.entrySet()) {
                    ((ReportLogger) value.getValue()).clearResource();
                }
                this.mRtcEventReporters.clear();
                this.mRtcEventReporters = null;
            }
            ConcurrentHashMap<String, ReportLoggerImpl> concurrentHashMap2 = this.mRtcInterInvokeReporters;
            if (concurrentHashMap2 != null) {
                concurrentHashMap2.clear();
                this.mRtcInterInvokeReporters = null;
            }
            RtcEngineEventReporter rtcEngineEventReporter = this.mRtcEngineEventReporter;
            if (rtcEngineEventReporter != null) {
                rtcEngineEventReporter.clearResource();
            }
            this.mMixDeviceIds.clear();
            GlobalConfig.resetGlobalConfig();
        }
        OmniLog.i(TAG, "Starting destroy global config...");
    }

    public boolean isJoinedChannel() {
        boolean z;
        synchronized (this.mUserManagerLock) {
            List<ChannelInfoBean> list = this.mRtcChannelNames;
            z = list != null && !list.isEmpty();
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isJoinedChannel(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.mUserManagerLock
            monitor-enter(r0)
            java.util.List<com.wushuangtech.bean.ChannelInfoBean> r1 = r4.mRtcChannelNames     // Catch:{ all -> 0x0032 }
            r2 = 0
            if (r1 == 0) goto L_0x0030
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x000f
            goto L_0x0030
        L_0x000f:
            r1 = r2
        L_0x0010:
            java.util.List<com.wushuangtech.bean.ChannelInfoBean> r3 = r4.mRtcChannelNames     // Catch:{ all -> 0x0032 }
            int r3 = r3.size()     // Catch:{ all -> 0x0032 }
            if (r1 >= r3) goto L_0x002e
            java.util.List<com.wushuangtech.bean.ChannelInfoBean> r3 = r4.mRtcChannelNames     // Catch:{ all -> 0x0032 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x0032 }
            com.wushuangtech.bean.ChannelInfoBean r3 = (com.wushuangtech.bean.ChannelInfoBean) r3     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = r3.mChannelName     // Catch:{ all -> 0x0032 }
            boolean r3 = r5.equals(r3)     // Catch:{ all -> 0x0032 }
            if (r3 == 0) goto L_0x002b
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            r5 = 1
            return r5
        L_0x002b:
            int r1 = r1 + 1
            goto L_0x0010
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r2
        L_0x0030:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r2
        L_0x0032:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.library.GlobalHolder.isJoinedChannel(java.lang.String):boolean");
    }

    public GlobalChannelConfig getGlobalChannelConfig() {
        return this.mGlobalChannelConfig;
    }

    public RtcEngineEventReporter getRtcEngineEventReporter() {
        return this.mRtcEngineEventReporter;
    }

    public GlobalAudioConfig getGlobalAudioConfig() {
        RtcGlobalAVInterface rtcGlobalAVInterface = this.mGlobalAVInterface;
        if (rtcGlobalAVInterface != null) {
            return rtcGlobalAVInterface.getAudioConfig();
        }
        return null;
    }

    public GlobalVideoConfig getGlobalVideoConfig() {
        RtcGlobalAVInterface rtcGlobalAVInterface = this.mGlobalAVInterface;
        if (rtcGlobalAVInterface != null) {
            return rtcGlobalAVInterface.getVideoConfig();
        }
        return null;
    }

    public VideoStatistical getGlobalVideoStatistical() {
        GlobalVideoConfig videoConfig;
        RtcGlobalAVInterface rtcGlobalAVInterface = this.mGlobalAVInterface;
        if (rtcGlobalAVInterface == null || (videoConfig = rtcGlobalAVInterface.getVideoConfig()) == null) {
            return null;
        }
        return videoConfig.getVideoStatistical();
    }

    public List<ChannelInfoBean> getRtcChannelNames() {
        synchronized (this.mUserManagerLock) {
            if (this.mRtcChannelNames == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(this.mRtcChannelNames);
            return arrayList;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004f, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getChannelNameByUid(long r11) {
        /*
            r10 = this;
            java.lang.Object r0 = r10.mUserManagerLock
            monitor-enter(r0)
            java.util.HashMap<java.lang.String, com.wushuangtech.api.RtcUserManager> r1 = r10.mUserManagers     // Catch:{ all -> 0x0050 }
            r2 = 0
            if (r1 == 0) goto L_0x004e
            int r3 = r1.size()     // Catch:{ all -> 0x0050 }
            if (r3 > 0) goto L_0x000f
            goto L_0x004e
        L_0x000f:
            java.util.Set r1 = r1.entrySet()     // Catch:{ all -> 0x0050 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0050 }
            r3 = 0
            r4 = r3
        L_0x0019:
            boolean r5 = r1.hasNext()     // Catch:{ all -> 0x0050 }
            if (r5 == 0) goto L_0x004c
            java.lang.Object r5 = r1.next()     // Catch:{ all -> 0x0050 }
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch:{ all -> 0x0050 }
            java.lang.Object r6 = r5.getKey()     // Catch:{ all -> 0x0050 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0050 }
            java.lang.Object r5 = r5.getValue()     // Catch:{ all -> 0x0050 }
            com.wushuangtech.api.RtcUserManager r5 = (com.wushuangtech.api.RtcUserManager) r5     // Catch:{ all -> 0x0050 }
            android.util.LongSparseArray r5 = r5.getUsers()     // Catch:{ all -> 0x0050 }
            r7 = r3
        L_0x0036:
            int r8 = r5.size()     // Catch:{ all -> 0x0050 }
            if (r7 >= r8) goto L_0x004a
            long r8 = r5.keyAt(r7)     // Catch:{ all -> 0x0050 }
            int r8 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r8 != 0) goto L_0x0047
            r4 = 1
            r2 = r6
            goto L_0x004a
        L_0x0047:
            int r7 = r7 + 1
            goto L_0x0036
        L_0x004a:
            if (r4 == 0) goto L_0x0019
        L_0x004c:
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            return r2
        L_0x004e:
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            return r2
        L_0x0050:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0050 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.library.GlobalHolder.getChannelNameByUid(long):java.lang.String");
    }

    public RtcUserManager getUserManager(String str) {
        HashMap<String, RtcUserManager> hashMap;
        RtcUserManager rtcUserManager;
        if (TextUtils.isEmpty(str) || (hashMap = this.mUserManagers) == null) {
            return null;
        }
        synchronized (this.mUserManagerLock) {
            rtcUserManager = hashMap.get(str);
        }
        return rtcUserManager;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        r4 = r4.getUsers();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001f, code lost:
        if (r4 != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0026, code lost:
        if (r4.size() > 0) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0028, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0029, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.LongSparseArray<com.wushuangtech.library.User> getUserArray(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            java.util.HashMap<java.lang.String, com.wushuangtech.api.RtcUserManager> r0 = r3.mUserManagers
            if (r0 != 0) goto L_0x000d
            return r1
        L_0x000d:
            java.lang.Object r2 = r3.mUserManagerLock
            monitor-enter(r2)
            java.lang.Object r4 = r0.get(r4)     // Catch:{ all -> 0x002a }
            com.wushuangtech.api.RtcUserManager r4 = (com.wushuangtech.api.RtcUserManager) r4     // Catch:{ all -> 0x002a }
            if (r4 != 0) goto L_0x001a
            monitor-exit(r2)     // Catch:{ all -> 0x002a }
            return r1
        L_0x001a:
            monitor-exit(r2)     // Catch:{ all -> 0x002a }
            android.util.LongSparseArray r4 = r4.getUsers()
            if (r4 != 0) goto L_0x0022
            return r1
        L_0x0022:
            int r0 = r4.size()
            if (r0 > 0) goto L_0x0029
            return r1
        L_0x0029:
            return r4
        L_0x002a:
            r4 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.library.GlobalHolder.getUserArray(java.lang.String):android.util.LongSparseArray");
    }

    public List<RtcUserManager> getUserManagerForAll() {
        HashMap<String, RtcUserManager> hashMap = this.mUserManagers;
        if (hashMap == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.mUserManagerLock) {
            for (Map.Entry<String, RtcUserManager> value : hashMap.entrySet()) {
                arrayList.add((RtcUserManager) value.getValue());
            }
        }
        return arrayList;
    }

    public RtcDeviceManager getDeviceManager(String str) {
        RtcDeviceManager rtcDeviceManager;
        HashMap<String, RtcDeviceManager> hashMap = this.mUserDeviceList;
        if (hashMap == null) {
            return null;
        }
        synchronized (this.mUserManagerLock) {
            rtcDeviceManager = hashMap.get(str);
        }
        return rtcDeviceManager;
    }

    public List<RtcDeviceManager> getDeviceManagerForAll() {
        HashMap<String, RtcDeviceManager> hashMap = this.mUserDeviceList;
        if (hashMap == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.mUserManagerLock) {
            for (Map.Entry<String, RtcDeviceManager> value : hashMap.entrySet()) {
                arrayList.add((RtcDeviceManager) value.getValue());
            }
        }
        return arrayList;
    }

    public RtcDataStreamManager getDataStreamManager(String str) {
        RtcDataStreamManager rtcDataStreamManager;
        HashMap<String, RtcDataStreamManager> hashMap = this.mDataStreamArray;
        if (hashMap == null) {
            return null;
        }
        synchronized (this.mUserManagerLock) {
            rtcDataStreamManager = hashMap.get(str);
        }
        return rtcDataStreamManager;
    }

    public VideoDualStreamManager getVideoDualStreamManager(String str) {
        VideoDualStreamManager videoDualStreamManager;
        HashMap<String, VideoDualStreamManager> hashMap = this.mVideoDualStreamManagerArray;
        if (hashMap == null) {
            return null;
        }
        synchronized (this.mUserManagerLock) {
            videoDualStreamManager = hashMap.get(str);
        }
        return videoDualStreamManager;
    }

    public ReportLogger getRtcEventReporter(String str) {
        ConcurrentHashMap<String, ReportLogger> concurrentHashMap;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.mRtcEventReporters) != null) {
            return concurrentHashMap.get(str);
        }
        return null;
    }

    public ReportLoggerImpl getRtcInterInvokeReporter(String str) {
        ConcurrentHashMap<String, ReportLoggerImpl> concurrentHashMap = this.mRtcInterInvokeReporters;
        if (concurrentHashMap == null) {
            return null;
        }
        return concurrentHashMap.get(str);
    }

    public RtcHeartbeatReporter getRtcHeartbeatReporter(String str) {
        HashMap<String, RtcHeartbeatReporter> hashMap;
        RtcHeartbeatReporter rtcHeartbeatReporter;
        if (TextUtils.isEmpty(str) || (hashMap = this.mRtcHeartbeatReporters) == null) {
            return null;
        }
        synchronized (this.mUserManagerLock) {
            rtcHeartbeatReporter = hashMap.get(str);
        }
        return rtcHeartbeatReporter;
    }

    public List<RtcHeartbeatReporter> getRtcHeartbeatReporterForAll() {
        HashMap<String, RtcHeartbeatReporter> hashMap = this.mRtcHeartbeatReporters;
        if (hashMap == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.mUserManagerLock) {
            for (Map.Entry<String, RtcHeartbeatReporter> value : hashMap.entrySet()) {
                arrayList.add((RtcHeartbeatReporter) value.getValue());
            }
        }
        return arrayList;
    }

    public RtcPublishStreamManager getRtcPublishStreamManager(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.mUserManagerLock) {
            HashMap<String, RtcPublishStreamManager> hashMap = this.mRtcPublishStreamManager;
            if (hashMap == null) {
                return null;
            }
            RtcPublishStreamManager rtcPublishStreamManager = hashMap.get(str);
            return rtcPublishStreamManager;
        }
    }

    public LocalGlobalEventInterface getGlobalEventInterface() {
        return this.mLocalGlobalEventInterface;
    }

    public LibYuvManager getYuvManager() {
        return this.mYuvManager;
    }

    public InterCorrectionManager getInterCorrectionManager() {
        return this.mInterCorrectionManager;
    }

    public NetworkQualityHandler getNetQualityHandler() {
        return this.mNetworkQualityHandler;
    }

    public AVStreamPublishHandler getAVStreamPublishHandler() {
        return this.mAVStreamPublishHandler;
    }

    public void addRtcEngineEventReceiver(OmniRtcEngineEventInter omniRtcEngineEventInter) {
        RtcEngineEventReporter rtcEngineEventReporter = this.mRtcEngineEventReporter;
        if (rtcEngineEventReporter != null) {
            rtcEngineEventReporter.addEventReceiver(omniRtcEngineEventInter);
        }
    }

    public void setOmniInterfaceTestCallBack(OmniInterfaceTestCallBack omniInterfaceTestCallBack) {
        this.mOmniInterfaceTestCallBack = omniInterfaceTestCallBack;
    }

    public void setAudioMode(String str, AudioManager audioManager, int i) {
        if (audioManager != null) {
            audioManager.setMode(i);
            String str2 = TAG;
            OmniLog.aw_d(str2, "setAudioMode -> [" + str + "] invoked! mode : " + i);
            return;
        }
        String str3 = TAG;
        OmniLog.aw_d(str3, "setAudioMode -> [" + str + "] invoked! AudioManager is null!");
    }

    public void setOnTestCallBack(OnTestCallBack onTestCallBack) {
        this.mOnTestCallBack = onTestCallBack;
    }

    public void putCacheForSessionId(String str, String str2) {
        if (!this.mCacheSessionIds.containsKey(str)) {
            this.mCacheSessionIds.put(str, str2);
        }
    }

    public EngineCallbackThread getWorkerThread() {
        return this.mWorkerThread;
    }

    public UserDeviceConfig getUserDefaultDevice(long j) {
        return getUserDefaultDevice(GlobalConfig.mLocalRoomName, j);
    }

    public UserDeviceConfig getUserDefaultDevice(String str, long j) {
        HashMap<String, RtcDeviceManager> hashMap = this.mUserDeviceList;
        if (hashMap == null) {
            return null;
        }
        synchronized (this.mUserManagerLock) {
            RtcDeviceManager rtcDeviceManager = hashMap.get(str);
            if (rtcDeviceManager == null) {
                return null;
            }
            return rtcDeviceManager.getVideoDeviceForDefault(j);
        }
    }

    public OnTestCallBack getTestCallBack() {
        return this.mOnTestCallBack;
    }

    public Context getContext() {
        return this.mContext;
    }

    public RtcGlobalAVInterface getGlobalAVInterface() {
        return this.mGlobalAVInterface;
    }

    public void notifyCHAudioRouteChanged(int i) {
        if (this.mCurrentAudioRoute != i) {
            this.mCurrentAudioRoute = i;
            EngineCallbackThread engineCallbackThread = this.mWorkerThread;
            if (engineCallbackThread != null) {
                engineCallbackThread.sendMessage(19, new Object[]{Integer.valueOf(i)});
            }
        }
    }

    public void notifyCHChannelError(int i) {
        EngineCallbackThread engineCallbackThread = this.mWorkerThread;
        if (engineCallbackThread != null) {
            engineCallbackThread.sendMessage(6, new Object[]{Integer.valueOf(i)});
        }
    }

    public void notifyCHRTMPStatus(int i) {
        EngineCallbackThread engineCallbackThread = this.mWorkerThread;
        if (engineCallbackThread != null) {
            engineCallbackThread.sendMessage(35, new Object[]{Integer.valueOf(i)});
        }
    }

    public void notifyCHIJKSei(String str) {
        EngineCallbackThread engineCallbackThread;
        if (!checkNullValue("notifyCHIJKSei", str) && (engineCallbackThread = this.mWorkerThread) != null) {
            engineCallbackThread.sendMessage(41, new Object[]{str});
        }
    }

    public void notifyCHTestString(String str) {
        OmniInterfaceTestCallBack omniInterfaceTestCallBack;
        if (!checkNullValue("notifyCHTestString", str) && (omniInterfaceTestCallBack = this.mOmniInterfaceTestCallBack) != null) {
            omniInterfaceTestCallBack.reportTestString(str);
        }
    }

    public void notifyAudioMixingPlayFinish() {
        EngineCallbackThread engineCallbackThread = this.mWorkerThread;
        if (engineCallbackThread != null) {
            engineCallbackThread.sendMessage(51, new Object[0]);
        }
    }

    public void notifyPlayEffectFinish(int i) {
        EngineCallbackThread engineCallbackThread = this.mWorkerThread;
        if (engineCallbackThread != null) {
            engineCallbackThread.sendMessage(58, new Object[]{Integer.valueOf(i)});
        }
    }

    public void notifyAKamaiServerID(String str, String str2) {
        EngineCallbackThread engineCallbackThread;
        if (!checkNullValue("notifyAKamaiServerID", str, str2) && (engineCallbackThread = this.mWorkerThread) != null) {
            engineCallbackThread.sendMessage(52, new Object[]{str, str2});
        }
    }

    public void notifyAudioRecordFinish() {
        EngineCallbackThread engineCallbackThread = this.mWorkerThread;
        if (engineCallbackThread != null) {
            engineCallbackThread.sendMessage(64, new Object[0]);
        }
    }

    public void notifyCameraStartPreview(int i, int i2, int i3, int i4) {
        EnterConfApiImpl.getInstance().reportCameraPreview(i, i2, i3, i4);
        EngineCallbackThread engineCallbackThread = this.mWorkerThread;
        if (engineCallbackThread == null) {
            return;
        }
        if (i4 == 0) {
            engineCallbackThread.sendMessage(14, new Object[0]);
            OnTestCallBack onTestCallBack = this.mOnTestCallBack;
            if (onTestCallBack != null) {
                onTestCallBack.onVideoCapSize(i, i2);
            }
        } else if (i4 > 0) {
            engineCallbackThread.sendMessage(70, new Object[]{1});
        } else {
            engineCallbackThread.sendMessage(70, new Object[]{2});
        }
    }

    public void notifyGlobalFirstRemoteAudioDecoded(long j) {
        RtcGlobalSignalCallBackImpl rtcGlobalSignalCallBackImpl;
        List<RtcUserManager> userManagerForAll = getUserManagerForAll();
        if (userManagerForAll != null) {
            Iterator<RtcUserManager> it = userManagerForAll.iterator();
            String str = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RtcUserManager next = it.next();
                String channelName = next.getChannelName();
                if (next.getUser(j) != null) {
                    str = channelName;
                    break;
                }
                str = channelName;
            }
            if (!TextUtils.isEmpty(str) && (rtcGlobalSignalCallBackImpl = this.mRtcGlobalSignalCallBackImpl) != null) {
                rtcGlobalSignalCallBackImpl.onFirstRemoteAudioDecodeded(str, j);
            }
        }
    }

    public void handleRtcEventReport(String str, LogEvent logEvent, Object... objArr) {
        handleRtcEventReport(str, logEvent, true, (String) null, objArr);
    }

    public void handleRtcEventReport(String str, String str2, Object... objArr) {
        handleRtcEventReport(str, (LogEvent) null, false, str2, objArr);
    }

    private void handleRtcEventReport(String str, LogEvent logEvent, boolean z, String str2, Object... objArr) {
        ConcurrentHashMap<String, ReportLogger> concurrentHashMap;
        ReportLogger reportLogger;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.mRtcEventReporters) != null) {
            String[] strArr = this.mEvnetReportOnce;
            int length = strArr.length;
            boolean z2 = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (strArr[i].equals(str2)) {
                    z2 = true;
                    break;
                } else {
                    i++;
                }
            }
            Iterator<Map.Entry<String, ReportLogger>> it = concurrentHashMap.entrySet().iterator();
            if (z2) {
                while (it.hasNext()) {
                    ReportLogger reportLogger2 = (ReportLogger) it.next().getValue();
                    if (reportLogger2 != null) {
                        if (z) {
                            reportLogger2.reportLogEvent(logEvent, objArr);
                            return;
                        } else {
                            reportLogger2.reportLogEvent(str, str2, objArr);
                            return;
                        }
                    }
                }
            } else if (TextUtils.isEmpty(str)) {
                while (it.hasNext()) {
                    ReportLogger reportLogger3 = (ReportLogger) it.next().getValue();
                    if (reportLogger3 != null) {
                        if (z) {
                            reportLogger3.reportLogEvent(logEvent, objArr);
                        } else {
                            reportLogger3.reportLogEvent(str, str2, objArr);
                        }
                    }
                }
            } else {
                while (it.hasNext()) {
                    Map.Entry next = it.next();
                    String str3 = (String) next.getKey();
                    if (!TextUtils.isEmpty(str3) && str3.equals(str) && (reportLogger = (ReportLogger) next.getValue()) != null) {
                        if (z) {
                            reportLogger.reportLogEvent(logEvent, objArr);
                        } else {
                            reportLogger.reportLogEvent(str, str2, objArr);
                        }
                    }
                }
            }
        }
    }

    public void handleUserActionReport(String str, String str2, int i, Object... objArr) {
        ReportLoggerImpl reportLoggerImpl2;
        if (!TextUtils.isEmpty(str2) && !str2.equals(GlobalConfig.mLocalRoomName)) {
            ConcurrentHashMap<String, ReportLoggerImpl> concurrentHashMap = this.mRtcInterInvokeReporters;
            if (concurrentHashMap != null) {
                for (Map.Entry next : concurrentHashMap.entrySet()) {
                    if (((String) next.getKey()).equals(str2) && (reportLoggerImpl2 = (ReportLoggerImpl) next.getValue()) != null) {
                        if (objArr.length > 0 && (objArr[0] instanceof ReportLoggerImpl.EventBean)) {
                            objArr[0].prefix = str;
                        }
                        reportLoggerImpl2.handleReportEvent(i, objArr);
                    }
                }
            }
        } else if (this.reportLoggerImpl != null) {
            if (objArr.length > 0 && (objArr[0] instanceof ReportLoggerImpl.EventBean)) {
                objArr[0].prefix = str;
            }
            this.reportLoggerImpl.handleReportEvent(i, objArr);
        }
    }

    public void initUserActionReporter(String str, String str2, String str3, String str4, long j, int i, String str5) {
        ReportLoggerImpl reportLoggerImpl2;
        String str6 = str;
        String str7 = str4;
        if (!TextUtils.isEmpty(str4)) {
            if (str7.equals(GlobalConfig.mLocalRoomName)) {
                ReportLoggerImpl reportLoggerImpl3 = this.reportLoggerImpl;
                if (reportLoggerImpl3 != null) {
                    reportLoggerImpl3.handleReportEvent(1, str5, str2, Long.valueOf(j), str7, Integer.valueOf(i));
                    ReportLoggerImpl.EventBean eventBean = new ReportLoggerImpl.EventBean();
                    eventBean.timestamp = System.currentTimeMillis();
                    eventBean.funName = "joinChannel";
                    eventBean.objs = new Object[]{str3, str7, Long.valueOf(j)};
                    eventBean.prefix = str6;
                    this.reportLoggerImpl.handleReportEvent(5, eventBean);
                    return;
                }
                return;
            }
            ConcurrentHashMap<String, ReportLoggerImpl> concurrentHashMap = this.mRtcInterInvokeReporters;
            if (concurrentHashMap != null) {
                for (Map.Entry next : concurrentHashMap.entrySet()) {
                    if (((String) next.getKey()).equals(str7) && (reportLoggerImpl2 = (ReportLoggerImpl) next.getValue()) != null) {
                        reportLoggerImpl2.handleReportEvent(1, str5, str2, Long.valueOf(j), str7, Integer.valueOf(i));
                        ReportLoggerImpl.EventBean eventBean2 = new ReportLoggerImpl.EventBean();
                        eventBean2.timestamp = System.currentTimeMillis();
                        eventBean2.funName = "joinChannel";
                        eventBean2.objs = new Object[]{str3, str7, Long.valueOf(j)};
                        eventBean2.prefix = str6;
                        reportLoggerImpl2.handleReportEvent(5, eventBean2);
                    }
                }
            }
        }
    }

    public void addMixDeviceId(String str, String str2) {
        this.mMixVideoDeviceLock.lock();
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.mMixDeviceIds.put(str, str2);
                this.mMixVideoDeviceLock.unlock();
            }
        } finally {
            this.mMixVideoDeviceLock.unlock();
        }
    }

    public boolean checkMixDeviceIdExist(String str, String str2) {
        boolean equals;
        this.mMixVideoDeviceLock.lock();
        try {
            if (TextUtils.isEmpty(str2)) {
                equals = false;
            } else {
                equals = str2.equals(this.mMixDeviceIds.get(str));
            }
            return equals;
        } finally {
            this.mMixVideoDeviceLock.unlock();
        }
    }

    private boolean checkNullValue(String str, Object... objArr) {
        for (Object obj : objArr) {
            if (obj == null) {
                OmniLog.e(TAG, "checkNullValue -> " + str + " receive empty args!");
                return true;
            }
        }
        return false;
    }

    private void initChannelInfoList(String str) {
        List<ChannelInfoBean> list = this.mRtcChannelNames;
        if (list == null) {
            this.mRtcChannelNames = new ArrayList();
        } else {
            for (ChannelInfoBean channelInfoBean : list) {
                if (channelInfoBean.mChannelName.equals(str)) {
                    return;
                }
            }
        }
        ChannelInfoBean channelInfoBean2 = new ChannelInfoBean();
        channelInfoBean2.mChannelName = str;
        channelInfoBean2.mJoinChannelTimestamp = System.currentTimeMillis();
        this.mRtcChannelNames.add(channelInfoBean2);
    }

    private <V> HashMap<String, V> initChannelManager(String str, HashMap<String, V> hashMap, Class<V> cls, Object... objArr) {
        V v;
        if (hashMap == null) {
            hashMap = new HashMap<>();
            v = null;
        } else {
            v = hashMap.get(str);
            if (v != null) {
                return hashMap;
            }
        }
        try {
            v = GenericUtils.newInstance(cls, objArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (v != null) {
            hashMap.put(str, v);
        }
        return hashMap;
    }

    private <T> void unInitChannelManager(HashMap<String, T> hashMap) {
        if (hashMap != null) {
            for (Map.Entry<String, T> value : hashMap.entrySet()) {
                ((RtcBaseManager) value.getValue()).clearResource();
            }
            hashMap.clear();
        }
    }

    public void addRtcGlobalMessageCallBack(OnRtcGlobalMessageCallBack onRtcGlobalMessageCallBack) {
        CopyOnWriteArrayList<WeakReference<OnRtcGlobalMessageCallBack>> copyOnWriteArrayList;
        if (onRtcGlobalMessageCallBack != null && (copyOnWriteArrayList = this.mOnRtcGlobalMessageCallBackList) != null) {
            copyOnWriteArrayList.add(new WeakReference(onRtcGlobalMessageCallBack));
            if (this.mOnRtcGlobalMessageCallBackList.size() > 50) {
                OmniLog.e(TAG, "CallBack too many!!!!!!");
            }
        }
    }

    public void sendSyncGlobalMessage(int i, Object... objArr) {
        CopyOnWriteArrayList<WeakReference<OnRtcGlobalMessageCallBack>> copyOnWriteArrayList = this.mOnRtcGlobalMessageCallBackList;
        if (copyOnWriteArrayList != null) {
            try {
                Iterator<WeakReference<OnRtcGlobalMessageCallBack>> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    OnRtcGlobalMessageCallBack onRtcGlobalMessageCallBack = (OnRtcGlobalMessageCallBack) it.next().get();
                    if (onRtcGlobalMessageCallBack != null) {
                        onRtcGlobalMessageCallBack.onGlobalMessage(i, objArr);
                    }
                }
            } catch (Exception unused) {
                String str = TAG;
                OmniLog.e(str, "Failed to send global message! type: " + i + ", args: " + Arrays.toString(objArr));
            }
        }
    }

    public Object sendSyncRtcEngineEvent(int i, Object... objArr) {
        RtcEngineEventReporter rtcEngineEventReporter = this.mRtcEngineEventReporter;
        if (rtcEngineEventReporter != null) {
            return rtcEngineEventReporter.receiveEvent(true, i, objArr);
        }
        return null;
    }

    public void sendRtcEngineEvent(int i, Object... objArr) {
        synchronized (this.mCallBackLock) {
            EngineCallbackThread engineCallbackThread = this.mWorkerThread;
            if (engineCallbackThread != null) {
                engineCallbackThread.sendMessage(i, objArr);
            }
        }
    }

    public void sendSyncGlobalServerMessage(RtcGlobalServerMessage rtcGlobalServerMessage, Object... objArr) {
        RtcGlobalSignalCallBackImpl rtcGlobalSignalCallBackImpl = this.mRtcGlobalSignalCallBackImpl;
        if (rtcGlobalSignalCallBackImpl != null) {
            rtcGlobalSignalCallBackImpl.recvServerMessage(rtcGlobalServerMessage, objArr);
        }
    }

    public void addRtcGlobalServerMessageCallback(OnRtcGlobalServerMessageCallBack onRtcGlobalServerMessageCallBack) {
        RtcGlobalSignalCallBackImpl rtcGlobalSignalCallBackImpl = this.mRtcGlobalSignalCallBackImpl;
        if (rtcGlobalSignalCallBackImpl != null) {
            rtcGlobalSignalCallBackImpl.addRtcGlobalServerMessageCallback(onRtcGlobalServerMessageCallBack);
        }
    }

    public void removeRtcGlobalServerMessageCallback(OnRtcGlobalServerMessageCallBack onRtcGlobalServerMessageCallBack) {
        RtcGlobalSignalCallBackImpl rtcGlobalSignalCallBackImpl = this.mRtcGlobalSignalCallBackImpl;
        if (rtcGlobalSignalCallBackImpl != null) {
            rtcGlobalSignalCallBackImpl.removeRtcGlobalServerMessageCallback(onRtcGlobalServerMessageCallBack);
        }
    }

    public boolean checkChannelExist(String str) {
        boolean z;
        synchronized (this.mUserManagerLock) {
            z = false;
            int i = 0;
            while (true) {
                if (i >= this.mRtcChannelNames.size()) {
                    i = -1;
                    break;
                } else if (this.mRtcChannelNames.get(i).mChannelName.equals(str)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                z = true;
            }
        }
        return z;
    }

    public void addOnVideoCameraPreviewFrameListener(OnVideoCameraPreviewFrameListener onVideoCameraPreviewFrameListener) {
        synchronized (this.mVideoCameraPreviewFrameListenersLock) {
            this.mOnVideoCameraPreviewFrameListeners.add(onVideoCameraPreviewFrameListener);
        }
    }

    public void removeOnVideoCameraPreviewFrameListener(OnVideoCameraPreviewFrameListener onVideoCameraPreviewFrameListener) {
        synchronized (this.mVideoCameraPreviewFrameListenersLock) {
            this.mOnVideoCameraPreviewFrameListeners.remove(onVideoCameraPreviewFrameListener);
        }
    }

    public void sendSyncGlobalVideoCameraPreviewFrame(byte[] bArr, int i, int i2, int i3, long j) {
        ArrayList<OnVideoCameraPreviewFrameListener> arrayList;
        synchronized (this.mVideoCameraPreviewFrameListenersLock) {
            arrayList = new ArrayList<>(this.mOnVideoCameraPreviewFrameListeners);
        }
        for (OnVideoCameraPreviewFrameListener onPreviewFrame : arrayList) {
            onPreviewFrame.onPreviewFrame(bArr, i, i2, i3, j);
        }
    }

    private static class LocalGlobalEventInterface implements RtcGlobalEventInterface {
        private final WeakReference<GlobalHolder> mHolder;

        public LocalGlobalEventInterface(GlobalHolder globalHolder) {
            this.mHolder = new WeakReference<>(globalHolder);
        }

        public List<RtcUserManager> getAllUserManager() {
            HashMap access$000;
            GlobalHolder globalHolder = (GlobalHolder) this.mHolder.get();
            if (globalHolder == null || (access$000 = globalHolder.mUserManagers) == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            synchronized (globalHolder.mUserManagerLock) {
                for (Map.Entry value : access$000.entrySet()) {
                    arrayList.add((RtcUserManager) value.getValue());
                }
            }
            return arrayList;
        }
    }
}
