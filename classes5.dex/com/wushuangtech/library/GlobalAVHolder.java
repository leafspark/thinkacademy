package com.wushuangtech.library;

import android.text.TextUtils;
import android.util.LongSparseArray;
import com.wushuangtech.api.ExternalAudioModule;
import com.wushuangtech.api.ExternalVideoModule;
import com.wushuangtech.api.RtcUserManager;
import com.wushuangtech.bean.AVSourceSyncBean;
import com.wushuangtech.bean.ChannelInfoBean;
import com.wushuangtech.expansion.bean.LocalAudioStats;
import com.wushuangtech.expansion.bean.LocalVideoStats;
import com.wushuangtech.expansion.bean.RemoteAudioStats;
import com.wushuangtech.expansion.bean.RemoteVideoStats;
import com.wushuangtech.expansion.bean.RtcStats;
import com.wushuangtech.handler.AVRouterHandler;
import com.wushuangtech.inter.RtcGlobalAVInterface;
import com.wushuangtech.inter.RtcGlobalEventInterface;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.jni.callback.RtcGlobalSignalCallBackImpl;
import com.wushuangtech.utils.OmniLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class GlobalAVHolder implements RtcGlobalAVInterface {
    private static final String TAG = "GlobalAVHolder";
    private AVRouterHandler mAVRouterHandler;
    private final Object mAVSourceSyncLock = new Object();
    private final List<AVSourceSyncBean> mCacheAVSourceSyncOpts = new ArrayList();
    private GlobalAudioConfig mGlobalAudioConfig;
    private RtcGlobalEventInterface mGlobalEventInterface;
    private GlobalVideoConfig mGlobalVideoConfig;
    private RtcAVStatistics mRtcAVStatistics;
    private RtcGlobalSignalCallBackImpl mRtcGlobalSignalCallBack;

    public void unInit() {
    }

    GlobalAVHolder() {
    }

    public void init() {
        this.mRtcAVStatistics = new RtcAVStatistics();
        this.mGlobalAudioConfig = new GlobalAudioConfig();
        this.mGlobalVideoConfig = new GlobalVideoConfig();
        this.mAVRouterHandler = new AVRouterHandler();
        this.mGlobalVideoConfig.init();
    }

    public GlobalAudioConfig getAudioConfig() {
        return this.mGlobalAudioConfig;
    }

    public GlobalVideoConfig getVideoConfig() {
        return this.mGlobalVideoConfig;
    }

    public AVRouterHandler getAVRouterHandler() {
        return this.mAVRouterHandler;
    }

    public void setGlobalEventInterface(RtcGlobalEventInterface rtcGlobalEventInterface) {
        this.mGlobalEventInterface = rtcGlobalEventInterface;
    }

    public void setRtcGlobalSignalCallBack(RtcGlobalSignalCallBackImpl rtcGlobalSignalCallBackImpl) {
        this.mRtcGlobalSignalCallBack = rtcGlobalSignalCallBackImpl;
    }

    public void configChannelAfterJoinChannel() {
        this.mGlobalAudioConfig.configChannelAfterJoinChannel();
    }

    public void initChannelAfterJoinChannel(String str) {
        ExternalAudioModule.getInstance().initChannelResAfterJoined(str);
        ExternalVideoModule.getInstance().initVideoConfig(str);
        checkCacheForAVSourceSyncOpt(str);
    }

    public void cacheAVSourceSyncOpt(AVSourceSyncBean aVSourceSyncBean) {
        if (aVSourceSyncBean != null && !TextUtils.isEmpty(aVSourceSyncBean.mChannelName) && aVSourceSyncBean.mUid != 0) {
            synchronized (this.mAVSourceSyncLock) {
                int i = 0;
                while (i < this.mCacheAVSourceSyncOpts.size()) {
                    AVSourceSyncBean aVSourceSyncBean2 = this.mCacheAVSourceSyncOpts.get(i);
                    if (!aVSourceSyncBean2.mChannelName.equals(aVSourceSyncBean.mChannelName) || aVSourceSyncBean2.mUid != aVSourceSyncBean.mUid) {
                        i++;
                    } else {
                        return;
                    }
                }
                this.mCacheAVSourceSyncOpts.add(aVSourceSyncBean);
                String str = TAG;
                OmniLog.d(str, "AVSOURCE Add cache... " + aVSourceSyncBean.toString() + " | " + this.mCacheAVSourceSyncOpts.size());
            }
        }
    }

    public void clearResource() {
        ExternalAudioModule.getInstance().unConfigChannelAfterJoinChannel();
        ExternalVideoModule.getInstance().stopAllPlay();
        this.mGlobalAudioConfig.clearResource();
        this.mGlobalVideoConfig.clearResource();
    }

    public void startAVStatistical() {
        this.mRtcAVStatistics.startCalcAVStatistical();
    }

    public void updateAVStatistical() {
        this.mRtcAVStatistics.updateAVStatistical();
    }

    public void resetAVStatistical() {
        this.mRtcAVStatistics.resetAVStatistical();
    }

    public void resetChannelAVStatistical(String str) {
        this.mRtcAVStatistics.resetChannelAVStatistical(str);
    }

    public int getLocalVideoSentFps() {
        return this.mRtcAVStatistics.getLocalVideoSendFps();
    }

    public LocalAudioStats getLocalAudioStatus() {
        return this.mRtcAVStatistics.getLocalAudioStats();
    }

    public RtcStats getRtcStats(String str) {
        return this.mRtcAVStatistics.getRtcStats(str);
    }

    public void reportAVStatistical() {
        reportGlobalRemoteAVStats();
    }

    private void checkCacheForAVSourceSyncOpt(String str) {
        synchronized (this.mAVSourceSyncLock) {
            ArrayList arrayList = new ArrayList();
            String str2 = TAG;
            OmniLog.debugD(str2, "AVSOURCE Check cache size: " + this.mCacheAVSourceSyncOpts.size() + " | " + str);
            for (int i = 0; i < this.mCacheAVSourceSyncOpts.size(); i++) {
                AVSourceSyncBean aVSourceSyncBean = this.mCacheAVSourceSyncOpts.get(i);
                if (aVSourceSyncBean.mChannelName.equals(str)) {
                    arrayList.add(aVSourceSyncBean);
                    RoomJni.getInstance().invokeNativeMethod(RoomJni.RoomNativeEvent.UPDATE_AV_SOURCE, str, Long.valueOf(aVSourceSyncBean.mUid));
                    String str3 = TAG;
                    OmniLog.d(str3, "AVSOURCE Update av source... " + str + " | " + aVSourceSyncBean.mUid);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                this.mCacheAVSourceSyncOpts.remove((AVSourceSyncBean) arrayList.get(i2));
            }
            String str4 = TAG;
            OmniLog.d(str4, "AVSOURCE Cache size... " + this.mCacheAVSourceSyncOpts.size());
        }
    }

    private void reportGlobalRemoteAVStats() {
        RtcGlobalEventInterface rtcGlobalEventInterface = this.mGlobalEventInterface;
        if (this.mRtcGlobalSignalCallBack != null && rtcGlobalEventInterface != null) {
            List<RtcUserManager> allUserManager = rtcGlobalEventInterface.getAllUserManager();
            if (allUserManager == null) {
                logD("Get all user manager is null...");
                return;
            }
            LocalAudioStats localAudioStats = this.mRtcAVStatistics.getLocalAudioStats();
            LocalVideoStats localVideoStats = this.mRtcAVStatistics.getLocalVideoStats();
            LongSparseArray<RemoteAudioStats> remoteAudioStats = this.mRtcAVStatistics.getRemoteAudioStats();
            HashMap<String, LongSparseArray<RemoteVideoStats>> remoteVideoStats = this.mRtcAVStatistics.getRemoteVideoStats();
            reportLocalAudioStats(localAudioStats);
            reportLocalVideoStats(localVideoStats);
            reportAllAudioRemoteStats(allUserManager, remoteAudioStats);
            reportAllVideoRemoteStats(remoteVideoStats);
            List<ChannelInfoBean> rtcChannelNames = GlobalHolder.getInstance().getRtcChannelNames();
            if (rtcChannelNames == null) {
                logD("Get channel size is zero!!!");
                return;
            }
            for (ChannelInfoBean channelInfoBean : rtcChannelNames) {
                reportRtcStats(this.mRtcAVStatistics.getRtcStats(channelInfoBean.mChannelName));
            }
        }
    }

    private void reportRtcStats(RtcStats rtcStats) {
        RtcGlobalSignalCallBackImpl rtcGlobalSignalCallBackImpl;
        if (rtcStats != null && (rtcGlobalSignalCallBackImpl = this.mRtcGlobalSignalCallBack) != null) {
            rtcGlobalSignalCallBackImpl.onRtcStats(rtcStats);
        }
    }

    private void reportLocalAudioStats(LocalAudioStats localAudioStats) {
        RtcGlobalSignalCallBackImpl rtcGlobalSignalCallBackImpl;
        if (localAudioStats != null && (rtcGlobalSignalCallBackImpl = this.mRtcGlobalSignalCallBack) != null) {
            rtcGlobalSignalCallBackImpl.onLocalAudioStats(localAudioStats);
        }
    }

    private void reportLocalVideoStats(LocalVideoStats localVideoStats) {
        RtcGlobalSignalCallBackImpl rtcGlobalSignalCallBackImpl;
        if (localVideoStats != null && (rtcGlobalSignalCallBackImpl = this.mRtcGlobalSignalCallBack) != null) {
            rtcGlobalSignalCallBackImpl.onLocalVideoStats(localVideoStats);
        }
    }

    private void reportAllAudioRemoteStats(List<RtcUserManager> list, LongSparseArray<RemoteAudioStats> longSparseArray) {
        RtcGlobalSignalCallBackImpl rtcGlobalSignalCallBackImpl;
        if (list != null && longSparseArray != null) {
            int size = longSparseArray.size();
            for (int i = 0; i < size; i++) {
                long keyAt = longSparseArray.keyAt(i);
                RemoteAudioStats valueAt = longSparseArray.valueAt(i);
                if (valueAt != null) {
                    String findChannelByUid = findChannelByUid(list, keyAt);
                    if (!TextUtils.isEmpty(findChannelByUid) && (rtcGlobalSignalCallBackImpl = this.mRtcGlobalSignalCallBack) != null) {
                        rtcGlobalSignalCallBackImpl.onRemoteAudioStats(findChannelByUid, keyAt, valueAt);
                    }
                }
            }
        }
    }

    private void reportAllVideoRemoteStats(HashMap<String, LongSparseArray<RemoteVideoStats>> hashMap) {
        RtcGlobalSignalCallBackImpl rtcGlobalSignalCallBackImpl;
        if (hashMap != null) {
            for (String next : hashMap.keySet()) {
                LongSparseArray longSparseArray = hashMap.get(next);
                if (longSparseArray != null) {
                    for (int i = 0; i < longSparseArray.size(); i++) {
                        long keyAt = longSparseArray.keyAt(i);
                        RemoteVideoStats remoteVideoStats = (RemoteVideoStats) longSparseArray.valueAt(i);
                        if (!(remoteVideoStats == null || (rtcGlobalSignalCallBackImpl = this.mRtcGlobalSignalCallBack) == null)) {
                            rtcGlobalSignalCallBackImpl.onRemoteVideoStats(next, keyAt, remoteVideoStats);
                        }
                    }
                }
            }
        }
    }

    private String findChannelByUid(List<RtcUserManager> list, long j) {
        String str = null;
        for (RtcUserManager next : list) {
            String channelName = next.getChannelName();
            if (next.getUser(j) != null) {
                return channelName;
            }
            str = channelName;
        }
        return str;
    }

    private void logD(String str) {
        OmniLog.debugD(TAG, str);
    }
}
