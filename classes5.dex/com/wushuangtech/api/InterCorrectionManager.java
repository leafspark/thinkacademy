package com.wushuangtech.api;

import com.wushuangtech.bean.InterCorrectUserBean;
import com.wushuangtech.bean.InterCorrectionBean;
import com.wushuangtech.bean.InterCorrectionEnum;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.utils.OmniLog;
import java.util.HashMap;
import java.util.Map;

public class InterCorrectionManager {
    private static final String TAG = "InterCorrectionManager";
    private final HashMap<InterCorrectionEnum, InterCorrectionBean> mData = new HashMap<>();
    private final HashMap<String, HashMap<Long, HashMap<InterCorrectionEnum, InterCorrectUserBean>>> mInterUserData = new HashMap<>();
    private final Object mLock = new Object();

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0089, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addInterCorrection(com.wushuangtech.bean.InterCorrectionBean r7) {
        /*
            r6 = this;
            if (r7 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Object r0 = r6.mLock
            monitor-enter(r0)
            java.lang.String r1 = "INTER_CORRECT_WATCH"
            java.lang.String r2 = TAG     // Catch:{ all -> 0x008a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008a }
            r3.<init>()     // Catch:{ all -> 0x008a }
            java.lang.String r4 = "Add a new cache, bean: "
            r3.append(r4)     // Catch:{ all -> 0x008a }
            java.lang.String r4 = r7.toString()     // Catch:{ all -> 0x008a }
            r3.append(r4)     // Catch:{ all -> 0x008a }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x008a }
            com.wushuangtech.utils.OmniLog.i(r1, r2, r3)     // Catch:{ all -> 0x008a }
            boolean r1 = r6.isNormalCache(r7)     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x0081
            r1 = r7
            com.wushuangtech.bean.InterCorrectUserBean r1 = (com.wushuangtech.bean.InterCorrectUserBean) r1     // Catch:{ all -> 0x008a }
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.Long, java.util.HashMap<com.wushuangtech.bean.InterCorrectionEnum, com.wushuangtech.bean.InterCorrectUserBean>>> r2 = r6.mInterUserData     // Catch:{ all -> 0x008a }
            java.lang.String r3 = r1.mChannelName     // Catch:{ all -> 0x008a }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x008a }
            java.util.HashMap r2 = (java.util.HashMap) r2     // Catch:{ all -> 0x008a }
            if (r2 != 0) goto L_0x0058
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x008a }
            r2.<init>()     // Catch:{ all -> 0x008a }
            java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.Long, java.util.HashMap<com.wushuangtech.bean.InterCorrectionEnum, com.wushuangtech.bean.InterCorrectUserBean>>> r3 = r6.mInterUserData     // Catch:{ all -> 0x008a }
            java.lang.String r4 = r1.mChannelName     // Catch:{ all -> 0x008a }
            r3.put(r4, r2)     // Catch:{ all -> 0x008a }
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x008a }
            r3.<init>()     // Catch:{ all -> 0x008a }
            long r4 = r1.mUid     // Catch:{ all -> 0x008a }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x008a }
            r2.put(r4, r3)     // Catch:{ all -> 0x008a }
            com.wushuangtech.bean.InterCorrectionEnum r7 = r7.mAction     // Catch:{ all -> 0x008a }
            r3.put(r7, r1)     // Catch:{ all -> 0x008a }
            monitor-exit(r0)     // Catch:{ all -> 0x008a }
            return
        L_0x0058:
            long r3 = r1.mUid     // Catch:{ all -> 0x008a }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x008a }
            java.lang.Object r3 = r2.get(r3)     // Catch:{ all -> 0x008a }
            java.util.HashMap r3 = (java.util.HashMap) r3     // Catch:{ all -> 0x008a }
            if (r3 != 0) goto L_0x007b
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x008a }
            r3.<init>()     // Catch:{ all -> 0x008a }
            long r4 = r1.mUid     // Catch:{ all -> 0x008a }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x008a }
            r2.put(r4, r3)     // Catch:{ all -> 0x008a }
            com.wushuangtech.bean.InterCorrectionEnum r7 = r7.mAction     // Catch:{ all -> 0x008a }
            r3.put(r7, r1)     // Catch:{ all -> 0x008a }
            monitor-exit(r0)     // Catch:{ all -> 0x008a }
            return
        L_0x007b:
            com.wushuangtech.bean.InterCorrectionEnum r7 = r1.mAction     // Catch:{ all -> 0x008a }
            r3.put(r7, r1)     // Catch:{ all -> 0x008a }
            goto L_0x0088
        L_0x0081:
            java.util.HashMap<com.wushuangtech.bean.InterCorrectionEnum, com.wushuangtech.bean.InterCorrectionBean> r1 = r6.mData     // Catch:{ all -> 0x008a }
            com.wushuangtech.bean.InterCorrectionEnum r2 = r7.mAction     // Catch:{ all -> 0x008a }
            r1.put(r2, r7)     // Catch:{ all -> 0x008a }
        L_0x0088:
            monitor-exit(r0)     // Catch:{ all -> 0x008a }
            return
        L_0x008a:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008a }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.InterCorrectionManager.addInterCorrection(com.wushuangtech.bean.InterCorrectionBean):void");
    }

    public InterCorrectionBean recoveryInterWithNoNotify(InterCorrectionBean interCorrectionBean) {
        return recoveryInter(interCorrectionBean, false, false);
    }

    public InterCorrectionBean recoveryInter(InterCorrectionBean interCorrectionBean, boolean z, boolean z2) {
        InterCorrectionBean interCorrectionBean2;
        InterCorrectionBean interCorrectionBean3;
        if (interCorrectionBean == null) {
            return null;
        }
        synchronized (this.mLock) {
            String str = TAG;
            OmniLog.i(OmniLog.INTER_CORRECT_WATCH, str, "Prepare Recovery, bean = " + interCorrectionBean.toString());
            if (isNormalCache(interCorrectionBean)) {
                InterCorrectUserBean interCorrectUserBean = (InterCorrectUserBean) interCorrectionBean;
                String str2 = interCorrectUserBean.mChannelName;
                if (str2.equals(GlobalConfig.mLocalRoomName)) {
                    str2 = LocalSDKConstants.ENGINE_CHANNEL_ID;
                }
                HashMap hashMap = this.mInterUserData.get(str2);
                if (hashMap == null) {
                    OmniLog.w(OmniLog.INTER_CORRECT_WATCH, str, "Recovery failed, map1 is null, bean = " + interCorrectionBean.toString());
                    return null;
                }
                HashMap hashMap2 = (HashMap) hashMap.get(Long.valueOf(interCorrectUserBean.mUid));
                if (hashMap2 == null) {
                    OmniLog.w(OmniLog.INTER_CORRECT_WATCH, str, "Recovery failed, map2 is null, bean = " + interCorrectionBean.toString());
                    return null;
                }
                if (z) {
                    interCorrectionBean2 = (InterCorrectUserBean) hashMap2.remove(interCorrectUserBean.mAction);
                } else {
                    interCorrectionBean2 = (InterCorrectUserBean) hashMap2.get(interCorrectUserBean.mAction);
                }
                if (interCorrectionBean2 == null) {
                    OmniLog.w(OmniLog.INTER_CORRECT_WATCH, str, "Recovery failed, InterCorrectUserBean is null, bean = " + interCorrectionBean.toString());
                    return null;
                } else if (z2) {
                    GlobalHolder.getInstance().sendSyncGlobalMessage(5, interCorrectionBean2);
                }
            } else {
                InterCorrectionEnum interCorrectionEnum = interCorrectionBean.mAction;
                if (z) {
                    interCorrectionBean3 = this.mData.remove(interCorrectionEnum);
                } else {
                    interCorrectionBean3 = this.mData.get(interCorrectionEnum);
                }
                if (interCorrectionBean2 == null) {
                    OmniLog.w(OmniLog.INTER_CORRECT_WATCH, str, "Recovery failed, cacheBean is null, bean = " + interCorrectionBean.toString());
                    return null;
                } else if (z2) {
                    GlobalHolder.getInstance().sendSyncGlobalMessage(5, interCorrectionBean2);
                }
            }
            OmniLog.i(OmniLog.INTER_CORRECT_WATCH, str, "Find cache, bean=" + interCorrectionBean2.toString());
            return interCorrectionBean2;
        }
    }

    public InterCorrectionBean getInterCacheBean(InterCorrectionBean interCorrectionBean) {
        if (interCorrectionBean == null) {
            return null;
        }
        synchronized (this.mLock) {
            if (isNormalCache(interCorrectionBean)) {
                InterCorrectUserBean interCorrectUserBean = (InterCorrectUserBean) interCorrectionBean;
                String str = interCorrectUserBean.mChannelName;
                if (str.equals(GlobalConfig.mLocalRoomName)) {
                    str = LocalSDKConstants.ENGINE_CHANNEL_ID;
                }
                HashMap hashMap = this.mInterUserData.get(str);
                if (hashMap == null) {
                    return null;
                }
                HashMap hashMap2 = (HashMap) hashMap.get(Long.valueOf(interCorrectUserBean.mUid));
                if (hashMap2 == null) {
                    return null;
                }
                InterCorrectionBean interCorrectionBean2 = (InterCorrectionBean) hashMap2.get(interCorrectUserBean.mAction);
                return interCorrectionBean2;
            }
            InterCorrectionBean interCorrectionBean3 = this.mData.get(interCorrectionBean.mAction);
            return interCorrectionBean3;
        }
    }

    public void clearResource(String str) {
        synchronized (this.mLock) {
            String str2 = TAG;
            OmniLog.i(OmniLog.INTER_CORRECT_WATCH, str2, "Clear channel resource, channelName = " + str);
            HashMap remove = this.mInterUserData.remove(str);
            if (remove != null) {
                for (Map.Entry value : remove.entrySet()) {
                    HashMap hashMap = (HashMap) value.getValue();
                    if (hashMap != null) {
                        hashMap.clear();
                    }
                }
                remove.clear();
            }
        }
    }

    public void clearResource() {
        synchronized (this.mLock) {
            OmniLog.i(OmniLog.INTER_CORRECT_WATCH, TAG, "Clear all channel resource");
            this.mData.clear();
            for (Map.Entry<String, HashMap<Long, HashMap<InterCorrectionEnum, InterCorrectUserBean>>> value : this.mInterUserData.entrySet()) {
                HashMap hashMap = (HashMap) value.getValue();
                if (hashMap != null) {
                    for (Map.Entry value2 : hashMap.entrySet()) {
                        HashMap hashMap2 = (HashMap) value2.getValue();
                        if (hashMap2 != null) {
                            hashMap2.clear();
                        }
                    }
                }
            }
            this.mInterUserData.clear();
        }
    }

    private boolean isNormalCache(InterCorrectionBean interCorrectionBean) {
        return interCorrectionBean.mAction == InterCorrectionEnum.INTER_SETUP_REMOTE_VIDEO || interCorrectionBean.mAction == InterCorrectionEnum.INTER_MUTE_REMOTE_VIDEO || interCorrectionBean.mAction == InterCorrectionEnum.INTER_MUTE_REMOTE_AUDIO;
    }
}
