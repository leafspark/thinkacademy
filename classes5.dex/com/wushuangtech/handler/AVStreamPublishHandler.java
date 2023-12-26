package com.wushuangtech.handler;

import android.text.TextUtils;
import com.wushuangtech.bean.AVStreamPublishBean;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.utils.OmniLog;
import java.util.HashMap;
import java.util.Map;

public class AVStreamPublishHandler {
    private static final String TAG = "AVStreamPublishHandler";
    private AVStreamPublishBean mAVStreamPublishBean;
    private HashMap<String, AVStreamPublishBean> mChannels = new HashMap<>();
    private final Object mLock = new Object();
    private boolean mPublished;

    public void init() {
        OmniLog.i(OmniLog.CHANNEL_PUSH, TAG, "Init stream publish handler... ");
        if (this.mChannels == null) {
            this.mChannels = new HashMap<>();
        }
    }

    public void clearResource() {
        OmniLog.i(OmniLog.CHANNEL_PUSH, TAG, "Uninit stream publish handler... ");
        HashMap<String, AVStreamPublishBean> hashMap = this.mChannels;
        if (hashMap != null) {
            hashMap.clear();
            this.mChannels = null;
        }
    }

    public void setAVStreamPublishBean(AVStreamPublishBean aVStreamPublishBean) {
        this.mAVStreamPublishBean = aVStreamPublishBean;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0059, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addAVStreamPublishBean(com.wushuangtech.bean.AVStreamPublishBean r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L_0x005d
            java.lang.String r0 = r6.mChannelName
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x000b
            goto L_0x005d
        L_0x000b:
            java.lang.Object r0 = r5.mLock
            monitor-enter(r0)
            java.util.HashMap<java.lang.String, com.wushuangtech.bean.AVStreamPublishBean> r1 = r5.mChannels     // Catch:{ all -> 0x005a }
            if (r1 != 0) goto L_0x001d
            java.lang.String r6 = "CHANNEL_PUSH"
            java.lang.String r1 = "AVStreamPublishHandler"
            java.lang.String r2 = "Add a new stream publish bean failed, channel map is null!"
            com.wushuangtech.utils.OmniLog.e((java.lang.String) r6, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x005a }
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return
        L_0x001d:
            java.lang.String r2 = r6.mChannelName     // Catch:{ all -> 0x005a }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x005a }
            com.wushuangtech.bean.AVStreamPublishBean r1 = (com.wushuangtech.bean.AVStreamPublishBean) r1     // Catch:{ all -> 0x005a }
            if (r1 != 0) goto L_0x0058
            java.util.HashMap<java.lang.String, com.wushuangtech.bean.AVStreamPublishBean> r1 = r5.mChannels     // Catch:{ all -> 0x005a }
            java.lang.String r2 = r6.mChannelName     // Catch:{ all -> 0x005a }
            r1.put(r2, r6)     // Catch:{ all -> 0x005a }
            java.lang.String r1 = "CHANNEL_PUSH"
            java.lang.String r2 = "AVStreamPublishHandler"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            r3.<init>()     // Catch:{ all -> 0x005a }
            java.lang.String r4 = "Add a new stream publish bean... "
            r3.append(r4)     // Catch:{ all -> 0x005a }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x005a }
            r3.append(r6)     // Catch:{ all -> 0x005a }
            java.lang.String r6 = " | "
            r3.append(r6)     // Catch:{ all -> 0x005a }
            java.util.HashMap<java.lang.String, com.wushuangtech.bean.AVStreamPublishBean> r6 = r5.mChannels     // Catch:{ all -> 0x005a }
            int r6 = r6.size()     // Catch:{ all -> 0x005a }
            r3.append(r6)     // Catch:{ all -> 0x005a }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x005a }
            com.wushuangtech.utils.OmniLog.i(r1, r2, r6)     // Catch:{ all -> 0x005a }
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return
        L_0x005a:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            throw r6
        L_0x005d:
            java.lang.String r0 = "CHANNEL_PUSH"
            java.lang.String r1 = "AVStreamPublishHandler"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Add a new stream publish bean failed, args error! "
            r2.append(r3)
            if (r6 != 0) goto L_0x0070
            java.lang.String r6 = "null"
            goto L_0x0074
        L_0x0070:
            java.lang.String r6 = r6.toString()
        L_0x0074:
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            com.wushuangtech.utils.OmniLog.e((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.handler.AVStreamPublishHandler.addAVStreamPublishBean(com.wushuangtech.bean.AVStreamPublishBean):void");
    }

    public void removeAVStreamPublishBean(String str) {
        if (TextUtils.isEmpty(str)) {
            OmniLog.e(OmniLog.CHANNEL_PUSH, TAG, "Remove a new stream publish bean failed, args error! " + str);
            return;
        }
        synchronized (this.mLock) {
            if (this.mChannels == null) {
                OmniLog.e(OmniLog.CHANNEL_PUSH, TAG, "Remove a new stream publish bean failed, channel map is null! " + str);
                return;
            }
            AVStreamPublishBean aVStreamPublishBean = this.mAVStreamPublishBean;
            if (aVStreamPublishBean != null && aVStreamPublishBean.mChannelName.equals(str)) {
                this.mPublished = false;
                this.mAVStreamPublishBean = null;
            }
            AVStreamPublishBean remove = this.mChannels.remove(str);
            StringBuilder sb = new StringBuilder();
            sb.append("Remove a new stream publish bean... ");
            sb.append(remove == null ? "null" : remove.toString());
            sb.append(" | ");
            sb.append(this.mChannels.size());
            OmniLog.i(OmniLog.CHANNEL_PUSH, TAG, sb.toString());
        }
    }

    public void resetEngineAVStreamPublishBean() {
        AVStreamPublishBean aVStreamPublishBean = this.mChannels.get(GlobalConfig.ENGINE_NAME);
        if (aVStreamPublishBean != null) {
            aVStreamPublishBean.mRole = GlobalConfig.mLocalRole;
            aVStreamPublishBean.mAudioMuted = !GlobalConfig.mAudioLocalStreamEnabled;
            aVStreamPublishBean.mVideoMuted = !GlobalConfig.mVideoLocalStreamEnabled;
        }
    }

    public boolean isPublishStats() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mPublished;
        }
        return z;
    }

    public boolean isPublishStats(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this.mLock) {
            AVStreamPublishBean aVStreamPublishBean = this.mAVStreamPublishBean;
            if (aVStreamPublishBean == null) {
                return false;
            }
            boolean equals = aVStreamPublishBean.mChannelName.equals(str);
            return equals;
        }
    }

    public boolean isAudioMuted(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this.mLock) {
            AVStreamPublishBean aVStreamPublishBean = this.mAVStreamPublishBean;
            if (aVStreamPublishBean == null) {
                return false;
            }
            boolean z = aVStreamPublishBean.mAudioMuted;
            return z;
        }
    }

    public boolean isVideoMuted(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this.mLock) {
            AVStreamPublishBean aVStreamPublishBean = this.mAVStreamPublishBean;
            if (aVStreamPublishBean == null) {
                return false;
            }
            boolean z = aVStreamPublishBean.mVideoMuted;
            return z;
        }
    }

    public boolean updateAudioMuted(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            OmniLog.e(OmniLog.CHANNEL_PUSH, TAG, "Update audio mute stats, " + "args error! " + str);
            return false;
        }
        synchronized (this.mLock) {
            HashMap<String, AVStreamPublishBean> hashMap = this.mChannels;
            if (hashMap == null) {
                OmniLog.e(OmniLog.CHANNEL_PUSH, TAG, "Update audio mute stats, " + "channel map is null! " + str);
                return false;
            }
            AVStreamPublishBean aVStreamPublishBean = hashMap.get(str);
            if (aVStreamPublishBean == null) {
                OmniLog.e(OmniLog.CHANNEL_PUSH, TAG, "Update audio mute stats, " + "AVStreamPublishBean is null... " + str);
                return false;
            }
            if (!z) {
                AVStreamPublishBean aVStreamPublishBean2 = this.mAVStreamPublishBean;
                if (aVStreamPublishBean2 == null) {
                    for (Map.Entry<String, AVStreamPublishBean> value : this.mChannels.entrySet()) {
                        AVStreamPublishBean aVStreamPublishBean3 = (AVStreamPublishBean) value.getValue();
                        if ((!aVStreamPublishBean3.mAudioMuted || !aVStreamPublishBean3.mVideoMuted) && !aVStreamPublishBean3.mChannelName.equals(str)) {
                            return false;
                        }
                    }
                    aVStreamPublishBean.mAudioMuted = false;
                } else if (!aVStreamPublishBean2.mAudioMuted && !this.mAVStreamPublishBean.mChannelName.equals(str)) {
                    return false;
                } else {
                    OmniLog.w(OmniLog.CHANNEL_PUSH, TAG, "Update audio mute stats, " + "already pushed... " + str + " | current bean " + this.mAVStreamPublishBean.toString());
                    boolean equals = this.mAVStreamPublishBean.mChannelName.equals(str);
                    return equals;
                }
            } else {
                aVStreamPublishBean.mAudioMuted = true;
                AVStreamPublishBean aVStreamPublishBean4 = this.mAVStreamPublishBean;
                if (aVStreamPublishBean4 == null) {
                    OmniLog.w(OmniLog.CHANNEL_PUSH, TAG, "Update audio mute stats, " + "Current stream publish bean is null, not push... " + str + " | " + aVStreamPublishBean.toString());
                    return true;
                } else if (!aVStreamPublishBean4.mChannelName.equals(str)) {
                    OmniLog.w(OmniLog.CHANNEL_PUSH, TAG, "Update audio mute stats, " + "The channel name not equals... " + str + " | " + this.mAVStreamPublishBean.mChannelName);
                    return true;
                }
            }
            updatePublishStats(aVStreamPublishBean);
            return true;
        }
    }

    public boolean updateVideoMuted(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            OmniLog.e(OmniLog.CHANNEL_PUSH, TAG, "Update video mute stats, " + "args error! " + str);
            return false;
        }
        synchronized (this.mLock) {
            HashMap<String, AVStreamPublishBean> hashMap = this.mChannels;
            if (hashMap == null) {
                OmniLog.e(OmniLog.CHANNEL_PUSH, TAG, "Update video mute stats, " + "channel map is null! " + str);
                return false;
            }
            AVStreamPublishBean aVStreamPublishBean = hashMap.get(str);
            if (aVStreamPublishBean == null) {
                OmniLog.e(OmniLog.CHANNEL_PUSH, TAG, "Update video mute stats, " + "AVStreamPublishBean is null... " + str);
                return false;
            }
            if (z) {
                aVStreamPublishBean.mVideoMuted = true;
                AVStreamPublishBean aVStreamPublishBean2 = this.mAVStreamPublishBean;
                if (aVStreamPublishBean2 == null) {
                    OmniLog.w(OmniLog.CHANNEL_PUSH, TAG, "Update video mute stats, " + "Current stream publish bean is null, not push... " + str + " | " + aVStreamPublishBean.toString());
                    return true;
                } else if (!aVStreamPublishBean2.mChannelName.equals(str)) {
                    OmniLog.w(OmniLog.CHANNEL_PUSH, TAG, "Update video mute stats, " + "The channel name not equals... " + str + " | " + this.mAVStreamPublishBean.mChannelName);
                    return true;
                }
            } else if (this.mAVStreamPublishBean != null) {
                OmniLog.i(OmniLog.CHANNEL_PUSH, TAG, "Update video mute stats, " + "already pushed... " + str + " | current bean " + this.mAVStreamPublishBean.toString());
                if (!this.mAVStreamPublishBean.mVideoMuted && !this.mAVStreamPublishBean.mChannelName.equals(str)) {
                    return false;
                }
                boolean equals = this.mAVStreamPublishBean.mChannelName.equals(str);
                return equals;
            } else {
                for (Map.Entry<String, AVStreamPublishBean> value : this.mChannels.entrySet()) {
                    AVStreamPublishBean aVStreamPublishBean3 = (AVStreamPublishBean) value.getValue();
                    if ((!aVStreamPublishBean3.mAudioMuted || !aVStreamPublishBean3.mVideoMuted) && !aVStreamPublishBean3.mChannelName.equals(str)) {
                        return false;
                    }
                }
                aVStreamPublishBean.mVideoMuted = false;
            }
            updatePublishStats(aVStreamPublishBean);
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isChannelAVNotMuted() {
        /*
            r6 = this;
            java.lang.String r0 = "Check channel av not muted, "
            java.lang.Object r1 = r6.mLock
            monitor-enter(r1)
            java.util.HashMap<java.lang.String, com.wushuangtech.bean.AVStreamPublishBean> r2 = r6.mChannels     // Catch:{ all -> 0x0053 }
            r3 = 0
            if (r2 != 0) goto L_0x0024
            java.lang.String r2 = "CHANNEL_PUSH"
            java.lang.String r4 = "AVStreamPublishHandler"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0053 }
            r5.<init>()     // Catch:{ all -> 0x0053 }
            r5.append(r0)     // Catch:{ all -> 0x0053 }
            java.lang.String r0 = "channel map is null! "
            r5.append(r0)     // Catch:{ all -> 0x0053 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0053 }
            com.wushuangtech.utils.OmniLog.e((java.lang.String) r2, (java.lang.String) r4, (java.lang.String) r0)     // Catch:{ all -> 0x0053 }
            monitor-exit(r1)     // Catch:{ all -> 0x0053 }
            return r3
        L_0x0024:
            java.util.Set r0 = r2.entrySet()     // Catch:{ all -> 0x0053 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0053 }
        L_0x002c:
            boolean r2 = r0.hasNext()     // Catch:{ all -> 0x0053 }
            if (r2 == 0) goto L_0x0051
            java.lang.Object r2 = r0.next()     // Catch:{ all -> 0x0053 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0053 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0053 }
            com.wushuangtech.bean.AVStreamPublishBean r2 = (com.wushuangtech.bean.AVStreamPublishBean) r2     // Catch:{ all -> 0x0053 }
            boolean r4 = r2.mAudioMuted     // Catch:{ all -> 0x0053 }
            if (r4 == 0) goto L_0x0046
            boolean r4 = r2.mVideoMuted     // Catch:{ all -> 0x0053 }
            if (r4 != 0) goto L_0x002c
        L_0x0046:
            java.lang.String r2 = r2.mChannelName     // Catch:{ all -> 0x0053 }
            java.lang.String r4 = "Engine"
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0053 }
            if (r2 != 0) goto L_0x002c
            r3 = 1
        L_0x0051:
            monitor-exit(r1)     // Catch:{ all -> 0x0053 }
            return r3
        L_0x0053:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0053 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.handler.AVStreamPublishHandler.isChannelAVNotMuted():boolean");
    }

    public void updateRole(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            OmniLog.e(OmniLog.CHANNEL_PUSH, TAG, "Update role stats, " + "args error! " + str);
            return;
        }
        synchronized (this.mLock) {
            HashMap<String, AVStreamPublishBean> hashMap = this.mChannels;
            if (hashMap == null) {
                OmniLog.e(OmniLog.CHANNEL_PUSH, TAG, "Update role stats, " + "channel map is null! " + str);
                return;
            }
            AVStreamPublishBean aVStreamPublishBean = hashMap.get(str);
            if (aVStreamPublishBean == null) {
                OmniLog.e(OmniLog.CHANNEL_PUSH, TAG, "Update role stats, " + "AVStreamPublishBean is null... " + str);
                return;
            }
            aVStreamPublishBean.mRole = i;
            AVStreamPublishBean aVStreamPublishBean2 = this.mAVStreamPublishBean;
            if (aVStreamPublishBean2 == null || aVStreamPublishBean2.mChannelName.equals(str)) {
                updatePublishStats(aVStreamPublishBean);
                return;
            }
            OmniLog.w(OmniLog.CHANNEL_PUSH, TAG, "Update role stats, " + "Current stream publish bean not equals channel name, already pushed... " + str + " | " + this.mAVStreamPublishBean.toString());
        }
    }

    private void updatePublishStats(AVStreamPublishBean aVStreamPublishBean) {
        boolean z = true;
        if ((aVStreamPublishBean.mAudioMuted && aVStreamPublishBean.mVideoMuted) || aVStreamPublishBean.mRole != 1) {
            z = false;
        }
        this.mPublished = z;
        OmniLog.i(OmniLog.CHANNEL_PUSH, TAG, "Update publish stats, " + aVStreamPublishBean.toString() + " | " + this.mPublished);
        if (this.mPublished) {
            this.mAVStreamPublishBean = aVStreamPublishBean;
            if (aVStreamPublishBean.mChannelName.equals(GlobalConfig.ENGINE_NAME)) {
                GlobalConfig.mAVUploadChannelName = String.valueOf(GlobalConfig.mLocalRoomName);
            } else {
                GlobalConfig.mAVUploadChannelName = aVStreamPublishBean.mChannelName;
            }
        } else {
            this.mAVStreamPublishBean = null;
            GlobalConfig.mAVUploadChannelName = "";
        }
    }
}
