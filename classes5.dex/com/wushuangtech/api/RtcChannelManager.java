package com.wushuangtech.api;

import android.text.TextUtils;
import com.wushuangtech.bean.CommonEventBean;
import com.wushuangtech.bean.RtcChannelConfigBean;
import com.wushuangtech.bean.RtcGlobalConfigBean;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.handler.RtcTokenHandler;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.library.GlobalChannelConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.JNIResponse;
import com.wushuangtech.library.RtcInvokeSafetyChecker;
import com.wushuangtech.library.RtcRequestServerManager;
import com.wushuangtech.library.User;
import com.wushuangtech.log.ReportLogger;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class RtcChannelManager implements RtcRequestServerManager.OnRequestEventCallBack {
    private static final String TAG = "RtcChannelManager";
    private RtcChannelConfigBean mChannelConfigBean;
    private final String mChannelName;
    private String mChannelSessionId;
    private long mChannelUid;
    private boolean mDefaultChannel;
    private ReportLogger mEventReporter;
    private RtcGlobalConfigBean mGlobalConfigBean;
    private boolean mIsMediaRelay;
    private long mJoinChannelTimestamp;
    private boolean mJoinedChannel;
    private long mJoinedChannelTimestamp;
    private boolean mJoiningChannel;
    private final Object mLock = new Object();
    private int mOleRole;
    private int mResetRole = -1;
    private int mRole = 2;
    private WeakReference<RtcChannelAVManager> mRtcChannelAVManagerRef;
    private WeakReference<RtcChannelEventManager> mRtcChannelEventManagerRef;
    private final RtcInvokeSafetyChecker mRtcInvokeSafetyChecker = new RtcInvokeSafetyChecker();
    private RtcRequestServerManager mRtcRequestServerManager;
    private RtcTokenHandler mRtcTokenHandler;
    private final List<String> mRtmpUrlList = new ArrayList();
    private String mSrcChannelName = "";

    private void configureDefaultChannel() {
    }

    public RtcChannelManager(String str) {
        this.mChannelName = str;
        this.mRtcRequestServerManager = new RtcRequestServerManager(str);
    }

    public void setRtcChannelEventManager(RtcChannelEventManager rtcChannelEventManager) {
        this.mRtcChannelEventManagerRef = new WeakReference<>(rtcChannelEventManager);
    }

    public void setRtcChannelAVManager(RtcChannelAVManager rtcChannelAVManager) {
        this.mRtcChannelAVManagerRef = new WeakReference<>(rtcChannelAVManager);
    }

    public RtcChannelAVManager getRtcChannelAVManagerRef() {
        return (RtcChannelAVManager) this.mRtcChannelAVManagerRef.get();
    }

    public int getJoinChannelSpentTime() {
        synchronized (this.mLock) {
            if (!this.mJoinedChannel) {
                return 0;
            }
            int i = (int) (this.mJoinedChannelTimestamp - this.mJoinChannelTimestamp);
            return i;
        }
    }

    public long getChannelUid() {
        long j;
        synchronized (this.mLock) {
            j = this.mChannelUid;
        }
        return j;
    }

    public int getRole() {
        int i;
        synchronized (this.mLock) {
            i = this.mRole;
        }
        return i;
    }

    public String getChannelSessionId() {
        String str;
        synchronized (this.mLock) {
            str = this.mChannelSessionId;
        }
        return str;
    }

    public int getOleRole() {
        int i;
        synchronized (this.mLock) {
            i = this.mOleRole;
        }
        return i;
    }

    public RtcChannelConfigBean getChannelConfigBean() {
        return this.mChannelConfigBean;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0075, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int setRole(int r5) {
        /*
            r4 = this;
            com.wushuangtech.library.GlobalHolder r0 = com.wushuangtech.library.GlobalHolder.getInstance()
            com.wushuangtech.handler.AVStreamPublishHandler r0 = r0.getAVStreamPublishHandler()
            java.lang.String r1 = r4.mChannelName
            boolean r1 = r0.isPublishStats(r1)
            r2 = -5
            if (r1 == 0) goto L_0x002d
            r1 = 2
            if (r5 != r1) goto L_0x002d
            java.lang.String r5 = TAG
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Set role failed... Pushing stream! "
            r0.append(r1)
            java.lang.String r1 = r4.mChannelName
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.wushuangtech.utils.OmniLog.w(r5, r0)
            return r2
        L_0x002d:
            com.wushuangtech.library.GlobalHolder r1 = com.wushuangtech.library.GlobalHolder.getInstance()
            java.lang.String r3 = r4.mChannelName
            int r1 = r1.setRoleForBroadcaster(r3, r5)
            if (r1 == 0) goto L_0x0052
            java.lang.String r5 = TAG
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Set role failed... Only one can be set broadcaster at the same time!"
            r0.append(r1)
            java.lang.String r1 = r4.mChannelName
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.wushuangtech.utils.OmniLog.w(r5, r0)
            return r2
        L_0x0052:
            java.lang.String r1 = r4.mChannelName
            r0.updateRole(r1, r5)
            java.lang.Object r0 = r4.mLock
            monitor-enter(r0)
            int r1 = r4.mRole     // Catch:{ all -> 0x0076 }
            r4.mOleRole = r1     // Catch:{ all -> 0x0076 }
            r4.mRole = r5     // Catch:{ all -> 0x0076 }
            boolean r1 = r4.mJoinedChannel     // Catch:{ all -> 0x0076 }
            r2 = 0
            if (r1 != 0) goto L_0x006d
            boolean r3 = r4.mJoiningChannel     // Catch:{ all -> 0x0076 }
            if (r3 == 0) goto L_0x006d
            r4.mResetRole = r5     // Catch:{ all -> 0x0076 }
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            return r2
        L_0x006d:
            if (r1 == 0) goto L_0x0074
            java.lang.String r1 = r4.mChannelName     // Catch:{ all -> 0x0076 }
            r4.nativeSetRoomChangeMyRole(r1, r5)     // Catch:{ all -> 0x0076 }
        L_0x0074:
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            return r2
        L_0x0076:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.RtcChannelManager.setRole(int):int");
    }

    public void setisMediaRelay(boolean z) {
        this.mIsMediaRelay = z;
    }

    public void setSrcChannelName(String str) {
        this.mSrcChannelName = str;
    }

    public boolean isDefaultChannel() {
        return this.mDefaultChannel;
    }

    public boolean isJoiningChannel() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mJoiningChannel;
        }
        return z;
    }

    public boolean isJoinedChannel() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mJoinedChannel;
        }
        return z;
    }

    public boolean isMediaRelay() {
        return this.mIsMediaRelay;
    }

    public int destroy() {
        leaveChannel();
        synchronized (this.mLock) {
            RtcRequestServerManager rtcRequestServerManager = this.mRtcRequestServerManager;
            if (rtcRequestServerManager != null) {
                rtcRequestServerManager.clearResource();
                this.mRtcRequestServerManager = null;
            }
        }
        return 0;
    }

    public int joinChannel(RtcChannelConfigBean rtcChannelConfigBean, RtcGlobalConfigBean rtcGlobalConfigBean) {
        Object obj;
        RtcChannelConfigBean rtcChannelConfigBean2 = rtcChannelConfigBean;
        RtcGlobalConfigBean rtcGlobalConfigBean2 = rtcGlobalConfigBean;
        if (this.mJoinedChannel) {
            String str = TAG;
            OmniLog.rw_e(str, "Alread joined this channel... " + rtcChannelConfigBean2.mChannelName);
            return 0;
        }
        int i = 1;
        if (rtcGlobalConfigBean2.mChannelMode == 0 || rtcGlobalConfigBean2.mChannelMode == 1 || rtcGlobalConfigBean2.mChannelMode == 2) {
            String str2 = rtcGlobalConfigBean2.mAppId;
            String str3 = rtcChannelConfigBean2.mChannelName;
            long j = rtcChannelConfigBean2.mChannelUid;
            int i2 = this.mRole;
            String str4 = rtcChannelConfigBean2.mChannelToken;
            this.mDefaultChannel = rtcChannelConfigBean2.mIsDefaultChannel;
            if (!this.mRtcInvokeSafetyChecker.checkJoinChannelArgs(str3, j)) {
                String str5 = TAG;
                OmniLog.rw_e(str5, "Channel name or user id is error... " + str3 + " | " + j);
                return -5;
            }
            if (str4 == null) {
                str4 = "";
            }
            String str6 = TAG;
            OmniLog.rw_i(str6, "join channel -> token : " + str4 + " | channelName : " + str3 + " | uid : " + j + " | " + this.mDefaultChannel);
            Object obj2 = this.mLock;
            synchronized (obj2) {
                try {
                    if (this.mJoiningChannel) {
                        if (this.mRtcInvokeSafetyChecker.checkJoinChannelRepeat(str4, str3, j)) {
                            OmniLog.rw_e(str6, "joinChannel -> Already joining room!");
                            return 0;
                        }
                        exitJoiningChannel();
                    }
                    RtcRequestServerManager rtcRequestServerManager = this.mRtcRequestServerManager;
                    if (rtcRequestServerManager == null) {
                        OmniLog.rw_e(str6, "joinChannel -> RtcRequestServerManager is null!");
                        return -3;
                    }
                    this.mJoiningChannel = true;
                    this.mChannelUid = j;
                    if (TextUtils.isEmpty(str4)) {
                        str4 = LocalSDKConstants.OMNI_DEFAULT_TOKEN;
                    } else {
                        this.mRtcTokenHandler = new RtcTokenHandler(str3, this);
                    }
                    String str7 = str4;
                    GlobalChannelConfig globalChannelConfig = GlobalHolder.getInstance().getGlobalChannelConfig();
                    globalChannelConfig.configChannelBeforeJoinChannel();
                    String connectId = globalChannelConfig.getConnectId();
                    String str8 = "";
                    if (rtcChannelConfigBean2.mIsDefaultChannel) {
                        configureDefaultChannel();
                        str8 = rtcGlobalConfigBean2.mChannelDefaultRtmpUrl;
                    }
                    String str9 = str8;
                    RtcRequestServerManager rtcRequestServerManager2 = rtcRequestServerManager;
                    obj = obj2;
                    long j2 = j;
                    configureLogReport(str2, connectId, str7, str3, j, i2);
                    RtcChannelAVManager rtcChannelAVManager = (RtcChannelAVManager) this.mRtcChannelAVManagerRef.get();
                    if (rtcChannelAVManager != null) {
                        rtcChannelAVManager.configJoinChannel(rtcChannelConfigBean2);
                    }
                    Object[] objArr = new Object[8];
                    objArr[0] = str2;
                    objArr[1] = Long.valueOf(j2);
                    objArr[2] = str3;
                    if (!this.mIsMediaRelay) {
                        i = this.mRole;
                    }
                    objArr[3] = Integer.valueOf(i);
                    objArr[4] = str9;
                    objArr[5] = str7;
                    objArr[6] = Boolean.valueOf(this.mIsMediaRelay);
                    objArr[7] = this.mSrcChannelName;
                    rtcRequestServerManager2.requestServer(501, objArr, this);
                    this.mJoinChannelTimestamp = System.currentTimeMillis();
                    this.mGlobalConfigBean = rtcGlobalConfigBean2;
                    this.mChannelConfigBean = rtcChannelConfigBean2;
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            }
        } else {
            String str10 = TAG;
            OmniLog.rw_e(str10, "Channel mode is error... " + rtcGlobalConfigBean2.mChannelMode);
            return -5;
        }
    }

    private void configureLogReport(String str, String str2, String str3, String str4, long j, int i) {
        if (!TextUtils.isEmpty(str2)) {
            String str5 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("channel configureLogReport... connectId : ");
            String str6 = str2;
            sb.append(str2);
            OmniLog.d(str5, sb.toString());
            GlobalHolder instance = GlobalHolder.getInstance();
            ReportLogger initChannelEventReporter = instance.initChannelEventReporter(str4, j, i, str2);
            this.mEventReporter = initChannelEventReporter;
            if (initChannelEventReporter != null) {
                initChannelEventReporter.reportEnterBegin("");
            }
            instance.initUserActionReporter(this.mIsMediaRelay ? LocalSDKConstants.USER_ACTION_PREFIX_RELAY : LocalSDKConstants.USER_ACTION_PREFIX_CHANNEL, str, str3, str4, j, i, str2);
        }
    }

    public void leaveChannel() {
        ReportLogger reportLogger;
        if (this.mJoinedChannel && (reportLogger = this.mEventReporter) != null) {
            reportLogger.ReportExit(this.mChannelName);
        }
        synchronized (this.mLock) {
            String str = TAG;
            OmniLog.rw_i(str, "SESSION_WATCH Executing leave channel! joined = " + this.mJoinedChannel + " | joining = " + this.mJoiningChannel);
            if (this.mJoinedChannel) {
                RoomJni.getInstance().RoomExit(this.mChannelName);
                this.mJoinedChannel = false;
                this.mJoinChannelTimestamp = 0;
                this.mJoinedChannelTimestamp = 0;
                this.mOleRole = 0;
                this.mChannelSessionId = "";
                this.mRtmpUrlList.clear();
            } else if (this.mJoiningChannel) {
                exitJoiningChannel();
            }
        }
        RtcTokenHandler rtcTokenHandler = this.mRtcTokenHandler;
        if (rtcTokenHandler != null) {
            rtcTokenHandler.clearResource();
            this.mRtcTokenHandler = null;
        }
    }

    public int renewToken(String str) {
        RtcTokenHandler rtcTokenHandler = this.mRtcTokenHandler;
        if (rtcTokenHandler == null) {
            return 0;
        }
        rtcTokenHandler.refreshToken(str);
        return 0;
    }

    private void exitJoiningChannel() {
        this.mRtcRequestServerManager.cannelRequest(501);
        String str = TAG;
        OmniLog.rw_i(str, "Leaving current channel... " + this.mChannelName);
        this.mJoiningChannel = false;
        this.mChannelUid = 0;
    }

    /* access modifiers changed from: package-private */
    public boolean createLocalUserManager(String str, long j, int i, boolean z) {
        RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(str);
        if (userManager == null) {
            return false;
        }
        User user = new User(j, i);
        user.setEnableDualVideo(z);
        userManager.putOrUpdateUser(user);
        userManager.setOwnerId(j);
        String str2 = TAG;
        OmniLog.debugD(OmniLog.ROOM_WATCH, str2, "Add Local User " + user.toString());
        return true;
    }

    public void nativeSetRoomChangeMyRole(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            ReportLogger reportLogger = this.mEventReporter;
            if (reportLogger != null) {
                reportLogger.ReportChangeRole(i);
            }
            RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.ROLE_CHANGE, str, Integer.valueOf(i));
            boolean isPublishStats = GlobalHolder.getInstance().getAVStreamPublishHandler().isPublishStats(this.mChannelName);
            RtcChannelAVManager rtcChannelAVManager = (RtcChannelAVManager) this.mRtcChannelAVManagerRef.get();
            if (rtcChannelAVManager != null) {
                rtcChannelAVManager.updateAudioMuteStats();
                rtcChannelAVManager.updateVideoMuteStats();
                rtcChannelAVManager.uploadLocalVideo(isPublishStats);
            }
        }
    }

    public void onJoinChannelEvent(JNIResponse jNIResponse) {
        RtcChannelEventManager rtcChannelEventManager = (RtcChannelEventManager) this.mRtcChannelEventManagerRef.get();
        if (rtcChannelEventManager != null) {
            rtcChannelEventManager.executingJoinChannelCallBack(jNIResponse);
        }
    }

    /* access modifiers changed from: package-private */
    public void onConnectIdReport(String str) {
        RtcGlobalConfigBean rtcGlobalConfigBean = this.mGlobalConfigBean;
        RtcChannelConfigBean rtcChannelConfigBean = this.mChannelConfigBean;
        if (rtcGlobalConfigBean != null && rtcChannelConfigBean != null) {
            configureLogReport(rtcGlobalConfigBean.mAppId, str, rtcChannelConfigBean.mChannelToken, rtcChannelConfigBean.mChannelName, rtcChannelConfigBean.mChannelUid, this.mRole);
        }
    }

    /* access modifiers changed from: package-private */
    public void onEventJoinedChannelSuccess(int i, boolean z, String str) {
        if (i == 1) {
            if (!z) {
                this.mResetRole = -1;
            }
            this.mJoiningChannel = false;
            this.mJoinedChannelTimestamp = System.currentTimeMillis();
            return;
        }
        String str2 = TAG;
        OmniLog.rv_i(str2, "Handle channel join success... uid : " + this.mChannelUid);
        this.mJoinedChannel = true;
        if (!this.mIsMediaRelay) {
            CommonEventBean commonEventBean = new CommonEventBean();
            commonEventBean.mObjects = new Object[]{str, Long.valueOf(this.mChannelUid), true};
            ExternalVideoModule.getInstance().resetVideoDecoderStatus(commonEventBean);
            int i2 = this.mResetRole;
            if (i2 != -1) {
                nativeSetRoomChangeMyRole(this.mChannelName, i2);
                this.mResetRole = -1;
            }
            for (String next : this.mRtmpUrlList) {
                RtcPublishStreamManager rtcPublishStreamManager = GlobalHolder.getInstance().getRtcPublishStreamManager(this.mChannelName);
                if (rtcPublishStreamManager != null) {
                    rtcPublishStreamManager.addPublishStreamUrl(next);
                }
                this.mRtmpUrlList.clear();
            }
        }
    }

    public void onChannelError(int i) {
        RtcChannelEventManager rtcChannelEventManager = (RtcChannelEventManager) this.mRtcChannelEventManagerRef.get();
        if (rtcChannelEventManager != null) {
            rtcChannelEventManager.onChannelError(i);
        }
    }

    public void onConnectionStateChanged(int i, int i2) {
        RtcChannelEventManager rtcChannelEventManager = (RtcChannelEventManager) this.mRtcChannelEventManagerRef.get();
        if (rtcChannelEventManager != null) {
            rtcChannelEventManager.onConnectionStateChanged(i, i2);
        }
    }

    public void onChannelRefreshToken(String str, int i, int i2, int i3) {
        RtcTokenHandler rtcTokenHandler = this.mRtcTokenHandler;
        if (rtcTokenHandler != null) {
            rtcTokenHandler.receiveTokenAuthResult(str, i, i2, i3);
        }
    }

    public void onChannelTokenWillExpire(String str) {
        RtcChannelEventManager rtcChannelEventManager = (RtcChannelEventManager) this.mRtcChannelEventManagerRef.get();
        if (rtcChannelEventManager != null) {
            rtcChannelEventManager.onTokenPrivilegeWillExpire(str);
        }
    }

    public void onChannelRequestToken() {
        RtcChannelEventManager rtcChannelEventManager = (RtcChannelEventManager) this.mRtcChannelEventManagerRef.get();
        if (rtcChannelEventManager != null) {
            rtcChannelEventManager.onRequestToken();
        }
    }

    public void setSessionId(String str) {
        synchronized (this.mLock) {
            String str2 = TAG;
            OmniLog.i(OmniLog.SESSION_WATCH, str2, "Recv channel session id = " + str + ", channel = " + this.mChannelName);
            this.mChannelSessionId = str;
        }
    }

    public Object getLock() {
        return this.mLock;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (r4 != null) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        return -3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r4.addPublishStreamUrl(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        r4 = com.wushuangtech.library.GlobalHolder.getInstance().getRtcPublishStreamManager(r2.mChannelName);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int addPublishStreamUrl(java.lang.String r3, boolean r4) {
        /*
            r2 = this;
            java.lang.Object r4 = r2.mLock
            monitor-enter(r4)
            boolean r0 = r2.mJoinedChannel     // Catch:{ all -> 0x0022 }
            r1 = 0
            if (r0 != 0) goto L_0x000f
            java.util.List<java.lang.String> r0 = r2.mRtmpUrlList     // Catch:{ all -> 0x0022 }
            r0.add(r3)     // Catch:{ all -> 0x0022 }
            monitor-exit(r4)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x000f:
            monitor-exit(r4)     // Catch:{ all -> 0x0022 }
            com.wushuangtech.library.GlobalHolder r4 = com.wushuangtech.library.GlobalHolder.getInstance()
            java.lang.String r0 = r2.mChannelName
            com.wushuangtech.api.RtcPublishStreamManager r4 = r4.getRtcPublishStreamManager(r0)
            if (r4 != 0) goto L_0x001e
            r3 = -3
            return r3
        L_0x001e:
            r4.addPublishStreamUrl(r3)
            return r1
        L_0x0022:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0022 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.RtcChannelManager.addPublishStreamUrl(java.lang.String, boolean):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (r0 != null) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        return -3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r0.removePublishStreamUrl(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        r0 = com.wushuangtech.library.GlobalHolder.getInstance().getRtcPublishStreamManager(r3.mChannelName);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int removePublishStreamUrl(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mLock
            monitor-enter(r0)
            boolean r1 = r3.mJoinedChannel     // Catch:{ all -> 0x0022 }
            r2 = 0
            if (r1 != 0) goto L_0x000f
            java.util.List<java.lang.String> r1 = r3.mRtmpUrlList     // Catch:{ all -> 0x0022 }
            r1.remove(r4)     // Catch:{ all -> 0x0022 }
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            return r2
        L_0x000f:
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            com.wushuangtech.library.GlobalHolder r0 = com.wushuangtech.library.GlobalHolder.getInstance()
            java.lang.String r1 = r3.mChannelName
            com.wushuangtech.api.RtcPublishStreamManager r0 = r0.getRtcPublishStreamManager(r1)
            if (r0 != 0) goto L_0x001e
            r4 = -3
            return r4
        L_0x001e:
            r0.removePublishStreamUrl(r4)
            return r2
        L_0x0022:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0022 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.RtcChannelManager.removePublishStreamUrl(java.lang.String):int");
    }
}
