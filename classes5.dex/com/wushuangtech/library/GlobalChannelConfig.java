package com.wushuangtech.library;

import android.app.Application;
import android.content.Context;
import com.wushuangtech.api.EnterConfApi;
import com.wushuangtech.api.EnterConfApiImpl;
import com.wushuangtech.api.ExternalAudioModule;
import com.wushuangtech.api.ExternalVideoModule;
import com.wushuangtech.jni.ReportLogJni;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.thread.WorkerThread;
import com.wushuangtech.utils.DeviceUtils;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.utils.PhoneUtils;

public class GlobalChannelConfig {
    public static final String TAG = "GlobalChannelConfig";
    private ActivityLifecycleCallbacksImpl mActivityLifecycleCallbacksImpl;
    private String mAudioLinkedIp;
    private int mAudioLinkedPort;
    private boolean mConfiged;
    private String mConnectId;
    private DeviceUtils mDeviceUtils;
    private int mJoiningChannelCount;
    private final Object mJoiningChannelLock = new Object();
    private final Object mLock = new Object();
    private String mVideoLinkedIp;
    private int mVideoLinkedPort;
    private WorkerThread mWorkerThread;

    public void clearResource(Context context) {
    }

    public String getConnectId() {
        String str;
        synchronized (this.mJoiningChannelLock) {
            str = this.mConnectId;
        }
        return str;
    }

    public DeviceUtils getDeviceUtils() {
        return this.mDeviceUtils;
    }

    public String getAudioLinkedIp() {
        return this.mAudioLinkedIp;
    }

    public String getVideoLinkedIp() {
        return this.mVideoLinkedIp;
    }

    public int getAudioLinkedPort() {
        return this.mAudioLinkedPort;
    }

    public int getVideoLinkedPort() {
        return this.mVideoLinkedPort;
    }

    public void configChannelBeforeJoinChannel() {
        GlobalHolder instance = GlobalHolder.getInstance();
        EnterConfApiImpl enterConfApiImpl = (EnterConfApiImpl) EnterConfApi.getInstance();
        Context context = instance.getContext();
        updateJoiningChannelCount(true);
        synchronized (this.mLock) {
            if (!this.mConfiged) {
                this.mConfiged = true;
                ReportLogJni.getInstance().setupLogConnection(GlobalConfig.mServerLogUrl);
                configPhoneNetStats(instance);
                configRtcStream();
                enterConfApiImpl.registerSystemService(true);
                configForOldBranch();
                initGlobalChannel(context);
                ExternalAudioModule.getInstance().configChannelBeforeJoinChannel();
                ExternalVideoModule.getInstance().initVideoGlobalConfig();
                log("Config channel for global, chair? : " + GlobalConfig.mIsRequireChair + " | video mode? : " + GlobalConfig.mVideoEnabled + " | audio mixer? : " + GlobalConfig.mIsEnableAudioMixer.get());
            }
        }
    }

    public void configChannelAfterJoinChannel(Context context, String str) {
        ExternalAudioModule.getInstance().configChannelAfterJoinChannel(context);
        if (this.mWorkerThread == null) {
            WorkerThread workerThread = new WorkerThread();
            this.mWorkerThread = workerThread;
            workerThread.start();
            this.mWorkerThread.waitForReady();
        }
        DeviceUtils deviceUtils = new DeviceUtils(context);
        this.mDeviceUtils = deviceUtils;
        deviceUtils.initCpuInfos();
        this.mDeviceUtils.initCpuCoreNum();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        r2 = r7.mWorkerThread;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        if (r2 == null) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        r2.exit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r7.mWorkerThread.join(2000);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        r2.printStackTrace();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void unConfigChannelAfterJoinChannel() {
        /*
            r7 = this;
            com.wushuangtech.library.GlobalHolder r0 = com.wushuangtech.library.GlobalHolder.getInstance()
            com.wushuangtech.api.EnterConfApi r1 = com.wushuangtech.api.EnterConfApi.getInstance()
            com.wushuangtech.api.EnterConfApiImpl r1 = (com.wushuangtech.api.EnterConfApiImpl) r1
            android.content.Context r0 = r0.getContext()
            if (r0 != 0) goto L_0x0011
            return
        L_0x0011:
            java.lang.String r2 = "Starting uninit global channel resource!"
            r7.logD(r2)
            java.lang.Object r2 = r7.mLock
            monitor-enter(r2)
            boolean r3 = r7.mConfiged     // Catch:{ all -> 0x0074 }
            if (r3 != 0) goto L_0x001f
            monitor-exit(r2)     // Catch:{ all -> 0x0074 }
            return
        L_0x001f:
            r3 = 0
            r7.mConfiged = r3     // Catch:{ all -> 0x0074 }
            monitor-exit(r2)     // Catch:{ all -> 0x0074 }
            com.wushuangtech.thread.WorkerThread r2 = r7.mWorkerThread
            r4 = 0
            if (r2 == 0) goto L_0x0039
            r2.exit()
            com.wushuangtech.thread.WorkerThread r2 = r7.mWorkerThread     // Catch:{ InterruptedException -> 0x0033 }
            r5 = 2000(0x7d0, double:9.88E-321)
            r2.join(r5)     // Catch:{ InterruptedException -> 0x0033 }
            goto L_0x0037
        L_0x0033:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0037:
            r7.mWorkerThread = r4
        L_0x0039:
            com.wushuangtech.utils.DeviceUtils r2 = r7.mDeviceUtils
            if (r2 == 0) goto L_0x0042
            r2.clearResource()
            r7.mDeviceUtils = r4
        L_0x0042:
            r1.registerSystemService(r3)
            java.lang.String r1 = "Uninit system service resource over!"
            r7.logD(r1)
            r7.unInitGlobalChannel(r0)
            java.lang.String r0 = "Uninit global channel resource over!"
            r7.logD(r0)
            com.wushuangtech.jni.RoomJni r0 = com.wushuangtech.jni.RoomJni.getInstance()
            r0.NativeTeardown()
            java.lang.Object r0 = r7.mJoiningChannelLock
            monitor-enter(r0)
            r7.mJoiningChannelCount = r3     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = ""
            r7.mConnectId = r1     // Catch:{ all -> 0x0071 }
            r7.mAudioLinkedIp = r4     // Catch:{ all -> 0x0071 }
            r7.mVideoLinkedIp = r4     // Catch:{ all -> 0x0071 }
            r7.mAudioLinkedPort = r3     // Catch:{ all -> 0x0071 }
            r7.mVideoLinkedPort = r3     // Catch:{ all -> 0x0071 }
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            java.lang.String r0 = "Uninit config channel for global..."
            r7.log(r0)
            return
        L_0x0071:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            throw r1
        L_0x0074:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0074 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.library.GlobalChannelConfig.unConfigChannelAfterJoinChannel():void");
    }

    public void setConnectId(String str) {
        synchronized (this.mJoiningChannelLock) {
            this.mConnectId = str;
        }
    }

    public void setAVServerMediaInfo(String str, int i, String str2, int i2) {
        synchronized (this.mJoiningChannelLock) {
            this.mAudioLinkedIp = str;
            this.mVideoLinkedIp = str2;
            this.mAudioLinkedPort = i;
            this.mVideoLinkedPort = i2;
        }
    }

    private void initGlobalChannel(Context context) {
        Application application;
        GlobalHolder.trunOnCallback = true;
        if (this.mActivityLifecycleCallbacksImpl == null) {
            this.mActivityLifecycleCallbacksImpl = new ActivityLifecycleCallbacksImpl();
            if (context instanceof Application) {
                application = (Application) context;
            } else {
                application = (Application) context.getApplicationContext();
            }
            application.registerActivityLifecycleCallbacks(this.mActivityLifecycleCallbacksImpl);
        }
    }

    public void updateJoiningChannelCount(boolean z) {
        synchronized (this.mJoiningChannelLock) {
            if (z) {
                this.mJoiningChannelCount++;
            } else {
                this.mJoiningChannelCount--;
            }
            logD("Update joining channel count : " + z + " | " + this.mJoiningChannelCount);
            if (this.mJoiningChannelCount == 0) {
                this.mConnectId = "";
            }
        }
    }

    private void configPhoneNetStats(GlobalHolder globalHolder) {
        int internalServiceCompany = PhoneUtils.getInternalServiceCompany(globalHolder.getContext());
        RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.NETWORK_TYPE, Integer.valueOf(internalServiceCompany));
    }

    private void configRtcStream() {
        if (!GlobalConfig.mVideoEnabled || !GlobalConfig.mIsCreateVideoMixer) {
            RoomJni.getInstance().SetRoomCreateVideoMixer(false);
        } else {
            RoomJni.getInstance().SetRoomCreateVideoMixer(!GlobalConfig.mIsPureAudio);
        }
        RoomJni.getInstance().SetUseAudioServerMixer(GlobalConfig.mIsEnableAudioMixer.get());
    }

    private void configForOldBranch() {
        RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.SET_ROOM_CHAIR, Boolean.valueOf(GlobalConfig.mIsRequireChair));
    }

    private void unInitGlobalChannel(Context context) {
        Application application;
        GlobalHolder.trunOnCallback = false;
        if (this.mActivityLifecycleCallbacksImpl != null) {
            if (context instanceof Application) {
                application = (Application) context;
            } else {
                application = (Application) context.getApplicationContext();
            }
            application.unregisterActivityLifecycleCallbacks(this.mActivityLifecycleCallbacksImpl);
            this.mActivityLifecycleCallbacksImpl = null;
        }
    }

    private void log(String str) {
        OmniLog.i(TAG, str);
    }

    private void logD(String str) {
        OmniLog.d(TAG, str);
    }
}
