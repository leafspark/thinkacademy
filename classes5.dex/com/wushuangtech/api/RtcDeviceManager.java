package com.wushuangtech.api;

import android.text.TextUtils;
import android.util.LongSparseArray;
import com.wushuangtech.jni.VideoJni;
import com.wushuangtech.library.UserDeviceConfig;
import com.wushuangtech.utils.OmniLog;
import java.util.ArrayList;
import java.util.List;

public class RtcDeviceManager extends RtcBaseManager {
    private static final String TAG = "RtcDeviceManager";
    private LongSparseArray<List<UserDeviceConfig>> mUserDeviceList = new LongSparseArray<>();

    public RtcDeviceManager(String str) {
        super(str);
    }

    public void clearResource() {
        synchronized (this.mLock) {
            this.mUserDeviceList.clear();
            this.mUserDeviceList = null;
        }
    }

    public void clearUserDevice(long j) {
        synchronized (this.mLock) {
            List list = this.mUserDeviceList.get(j);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    UserDeviceConfig userDeviceConfig = (UserDeviceConfig) list.get(i);
                    if (userDeviceConfig.getUid() == j) {
                        arrayList.add(userDeviceConfig);
                    }
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    list.remove((UserDeviceConfig) arrayList.get(i2));
                }
                this.mUserDeviceList.delete(j);
            }
        }
    }

    public List<UserDeviceConfig> updateUserDevice(long j, List<UserDeviceConfig> list) {
        boolean z;
        boolean z2;
        if (list == null) {
            return null;
        }
        synchronized (this.mLock) {
            if (this.mUserDeviceList == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            OmniLog.pdw(TAG, "--------------------------------------- begin update device ---------------------------------------");
            for (int i = 0; i < list.size(); i++) {
                UserDeviceConfig userDeviceConfig = list.get(i);
                if (!"0".equals(userDeviceConfig.getDeviceId())) {
                    OmniLog.pdw(TAG, "The new device list member : " + userDeviceConfig.getDeviceId());
                    arrayList.add(userDeviceConfig);
                }
            }
            if (arrayList.size() <= 0) {
                OmniLog.pdwe(TAG, "The new device list is empty... because device id is zero...");
                return null;
            }
            List list2 = this.mUserDeviceList.get(j);
            if (list2 == null || list2.size() <= 0) {
                OmniLog.pdw(TAG, "The old device list is null...");
            } else {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    OmniLog.pdw(TAG, "The old device list member : " + ((UserDeviceConfig) list2.get(i2)).getDeviceId());
                }
            }
            ArrayList arrayList2 = new ArrayList();
            if (list2 == null) {
                OmniLog.pdw(TAG, "Put the new device list... ");
                this.mUserDeviceList.put(j, arrayList);
                arrayList2.addAll(arrayList);
                return arrayList2;
            }
            int i3 = 0;
            while (true) {
                boolean z3 = true;
                if (i3 >= list2.size()) {
                    break;
                }
                UserDeviceConfig userDeviceConfig2 = (UserDeviceConfig) list2.get(i3);
                if (userDeviceConfig2 != null) {
                    String deviceId = userDeviceConfig2.getDeviceId();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= arrayList.size()) {
                            z3 = false;
                            break;
                        }
                        UserDeviceConfig userDeviceConfig3 = (UserDeviceConfig) arrayList.get(i4);
                        if (userDeviceConfig3 != null && userDeviceConfig3.getDeviceId() != null && userDeviceConfig3.getDeviceId().equals(deviceId)) {
                            break;
                        }
                        i4++;
                    }
                    if (!z3) {
                        OmniLog.pdw(TAG, "Remove a old device... " + deviceId);
                        userDeviceConfig2.setIsUse(false);
                        userDeviceConfig2.setDualUse(false);
                        userDeviceConfig2.setDefaultDevice(false);
                        arrayList2.add(userDeviceConfig2);
                        list2.remove(i3);
                        VideoJni.getInstance().VideoCloseDevice(this.mChannelName, j, deviceId);
                    } else {
                        i3++;
                    }
                }
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                UserDeviceConfig userDeviceConfig4 = (UserDeviceConfig) arrayList.get(i5);
                int i6 = 0;
                while (true) {
                    if (i6 >= list2.size()) {
                        z = false;
                        z2 = false;
                        break;
                    }
                    UserDeviceConfig userDeviceConfig5 = (UserDeviceConfig) list2.get(i6);
                    if (userDeviceConfig5 != null) {
                        String deviceId2 = userDeviceConfig5.getDeviceId();
                        if (deviceId2 != null && deviceId2.equals(userDeviceConfig4.getDeviceId())) {
                            z = userDeviceConfig5.updateDevice(userDeviceConfig4);
                            OmniLog.pdw(TAG, "Update a old device : " + deviceId2 + " | update status : " + z);
                            z2 = true;
                            break;
                        }
                    }
                    i6++;
                }
                if (!z2) {
                    OmniLog.pdw(TAG, "Add a new device : " + userDeviceConfig4.getDeviceId());
                    list2.add(userDeviceConfig4);
                    arrayList2.add(userDeviceConfig4);
                } else if (z) {
                    arrayList2.add(userDeviceConfig4);
                }
            }
            for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                UserDeviceConfig userDeviceConfig6 = (UserDeviceConfig) arrayList2.get(i7);
                OmniLog.pdw(TAG, "Update device list... " + userDeviceConfig6.getDeviceId() + " | " + userDeviceConfig6.isUse());
            }
            return arrayList2;
        }
    }

    public List<UserDeviceConfig> clearUserDeviceAvailableStatus(long j) {
        synchronized (this.mLock) {
            List list = this.mUserDeviceList.get(j);
            if (list != null) {
                if (list.size() > 0) {
                    ArrayList arrayList = new ArrayList(list.size());
                    for (int i = 0; i < list.size(); i++) {
                        UserDeviceConfig userDeviceConfig = (UserDeviceConfig) list.get(i);
                        userDeviceConfig.setIsUse(false);
                        arrayList.add(userDeviceConfig.clone());
                    }
                    return arrayList;
                }
            }
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005c, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean updateDeviceStreamType(long r6, int r8) {
        /*
            r5 = this;
            r0 = -1
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            r1 = 0
            if (r0 > 0) goto L_0x0008
            return r1
        L_0x0008:
            android.util.LongSparseArray<java.util.List<com.wushuangtech.library.UserDeviceConfig>> r0 = r5.mUserDeviceList
            r2 = 1
            if (r0 != 0) goto L_0x000e
            return r2
        L_0x000e:
            java.lang.Object r3 = r5.mLock
            monitor-enter(r3)
            int r4 = r0.size()     // Catch:{ all -> 0x005d }
            if (r4 > 0) goto L_0x0019
            monitor-exit(r3)     // Catch:{ all -> 0x005d }
            return r2
        L_0x0019:
            java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x005d }
            java.util.List r6 = (java.util.List) r6     // Catch:{ all -> 0x005d }
            if (r6 != 0) goto L_0x0023
            monitor-exit(r3)     // Catch:{ all -> 0x005d }
            return r2
        L_0x0023:
            int r7 = r6.size()     // Catch:{ all -> 0x005d }
            if (r1 >= r7) goto L_0x005b
            java.lang.Object r7 = r6.get(r1)     // Catch:{ all -> 0x005d }
            com.wushuangtech.library.UserDeviceConfig r7 = (com.wushuangtech.library.UserDeviceConfig) r7     // Catch:{ all -> 0x005d }
            if (r7 != 0) goto L_0x0032
            goto L_0x0058
        L_0x0032:
            boolean r0 = r7.isDefaultDevice()     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0058
            int r6 = r7.getVideoSteamType()     // Catch:{ all -> 0x005d }
            if (r8 == r6) goto L_0x005b
            java.lang.String r6 = TAG     // Catch:{ all -> 0x005d }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r0.<init>()     // Catch:{ all -> 0x005d }
            java.lang.String r1 = "updateDeviceStreamType -> Update stream type success! "
            r0.append(r1)     // Catch:{ all -> 0x005d }
            r0.append(r8)     // Catch:{ all -> 0x005d }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x005d }
            com.wushuangtech.utils.OmniLog.pdw(r6, r0)     // Catch:{ all -> 0x005d }
            r7.setVideoSteamType(r8)     // Catch:{ all -> 0x005d }
            goto L_0x005b
        L_0x0058:
            int r1 = r1 + 1
            goto L_0x0023
        L_0x005b:
            monitor-exit(r3)     // Catch:{ all -> 0x005d }
            return r2
        L_0x005d:
            r6 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x005d }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.RtcDeviceManager.updateDeviceStreamType(long, int):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0040, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean updateDeviceOpenStatus(long r6, boolean r8, boolean r9, long r10) {
        /*
            r5 = this;
            r0 = 0
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            r1 = 0
            if (r0 > 0) goto L_0x0008
            return r1
        L_0x0008:
            android.util.LongSparseArray<java.util.List<com.wushuangtech.library.UserDeviceConfig>> r0 = r5.mUserDeviceList
            r2 = 1
            if (r0 != 0) goto L_0x000e
            return r2
        L_0x000e:
            java.lang.Object r3 = r5.mLock
            monitor-enter(r3)
            int r4 = r0.size()     // Catch:{ all -> 0x0041 }
            if (r4 > 0) goto L_0x0019
            monitor-exit(r3)     // Catch:{ all -> 0x0041 }
            return r2
        L_0x0019:
            java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x0041 }
            java.util.List r6 = (java.util.List) r6     // Catch:{ all -> 0x0041 }
            if (r6 != 0) goto L_0x0023
            monitor-exit(r3)     // Catch:{ all -> 0x0041 }
            return r2
        L_0x0023:
            int r7 = r6.size()     // Catch:{ all -> 0x0041 }
            if (r1 >= r7) goto L_0x003f
            java.lang.Object r7 = r6.get(r1)     // Catch:{ all -> 0x0041 }
            com.wushuangtech.library.UserDeviceConfig r7 = (com.wushuangtech.library.UserDeviceConfig) r7     // Catch:{ all -> 0x0041 }
            if (r7 != 0) goto L_0x0032
            goto L_0x003c
        L_0x0032:
            boolean r0 = r7.isDefaultDevice()     // Catch:{ all -> 0x0041 }
            if (r0 == 0) goto L_0x003c
            r7.updateDeviceOpenStatus(r8, r9, r10)     // Catch:{ all -> 0x0041 }
            goto L_0x003f
        L_0x003c:
            int r1 = r1 + 1
            goto L_0x0023
        L_0x003f:
            monitor-exit(r3)     // Catch:{ all -> 0x0041 }
            return r2
        L_0x0041:
            r6 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0041 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.RtcDeviceManager.updateDeviceOpenStatus(long, boolean, boolean, long):boolean");
    }

    public LongSparseArray<List<UserDeviceConfig>> getVideoDeviceForAll() {
        LongSparseArray<List<UserDeviceConfig>> longSparseArray = this.mUserDeviceList;
        if (longSparseArray == null) {
            return null;
        }
        LongSparseArray<List<UserDeviceConfig>> longSparseArray2 = new LongSparseArray<>();
        synchronized (this.mLock) {
            int size = longSparseArray.size();
            for (int i = 0; i < size; i++) {
                long keyAt = longSparseArray.keyAt(i);
                List<UserDeviceConfig> valueAt = longSparseArray.valueAt(i);
                if (keyAt > 0) {
                    ArrayList arrayList = new ArrayList();
                    if (valueAt != null && valueAt.size() > 0) {
                        for (UserDeviceConfig clone : valueAt) {
                            arrayList.add(clone.clone());
                        }
                    }
                    longSparseArray2.put(keyAt, arrayList);
                }
            }
        }
        return longSparseArray2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0048, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.wushuangtech.library.UserDeviceConfig getVideoDeviceForDefault(long r5) {
        /*
            r4 = this;
            r0 = 0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            r1 = 0
            if (r0 > 0) goto L_0x0008
            return r1
        L_0x0008:
            android.util.LongSparseArray<java.util.List<com.wushuangtech.library.UserDeviceConfig>> r0 = r4.mUserDeviceList
            if (r0 != 0) goto L_0x000d
            return r1
        L_0x000d:
            java.lang.Object r2 = r4.mLock
            monitor-enter(r2)
            int r3 = r0.size()     // Catch:{ all -> 0x0049 }
            if (r3 > 0) goto L_0x0018
            monitor-exit(r2)     // Catch:{ all -> 0x0049 }
            return r1
        L_0x0018:
            java.lang.Object r5 = r0.get(r5)     // Catch:{ all -> 0x0049 }
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x0049 }
            if (r5 == 0) goto L_0x0047
            int r6 = r5.size()     // Catch:{ all -> 0x0049 }
            if (r6 > 0) goto L_0x0027
            goto L_0x0047
        L_0x0027:
            r6 = 0
        L_0x0028:
            int r0 = r5.size()     // Catch:{ all -> 0x0049 }
            if (r6 >= r0) goto L_0x0045
            java.lang.Object r0 = r5.get(r6)     // Catch:{ all -> 0x0049 }
            com.wushuangtech.library.UserDeviceConfig r0 = (com.wushuangtech.library.UserDeviceConfig) r0     // Catch:{ all -> 0x0049 }
            if (r0 == 0) goto L_0x0042
            boolean r3 = r0.isDefaultDevice()     // Catch:{ all -> 0x0049 }
            if (r3 == 0) goto L_0x0042
            com.wushuangtech.library.UserDeviceConfig r5 = r0.clone()     // Catch:{ all -> 0x0049 }
            monitor-exit(r2)     // Catch:{ all -> 0x0049 }
            return r5
        L_0x0042:
            int r6 = r6 + 1
            goto L_0x0028
        L_0x0045:
            monitor-exit(r2)     // Catch:{ all -> 0x0049 }
            return r1
        L_0x0047:
            monitor-exit(r2)     // Catch:{ all -> 0x0049 }
            return r1
        L_0x0049:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0049 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.RtcDeviceManager.getVideoDeviceForDefault(long):com.wushuangtech.library.UserDeviceConfig");
    }

    public UserDeviceConfig getVideoDeviceByDeviceId(String str) {
        LongSparseArray<List<UserDeviceConfig>> longSparseArray;
        if (TextUtils.isEmpty(str) || (longSparseArray = this.mUserDeviceList) == null) {
            return null;
        }
        synchronized (this.mLock) {
            if (longSparseArray.size() <= 0) {
                return null;
            }
            int i = 0;
            while (i < longSparseArray.size()) {
                try {
                    List<UserDeviceConfig> valueAt = longSparseArray.valueAt(i);
                    if (valueAt != null) {
                        List list = valueAt;
                        if (list.size() > 0) {
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                UserDeviceConfig userDeviceConfig = (UserDeviceConfig) list.get(i2);
                                if (userDeviceConfig != null) {
                                    if (str.equals(userDeviceConfig.getDeviceId())) {
                                        UserDeviceConfig clone = userDeviceConfig.clone();
                                        return clone;
                                    }
                                }
                            }
                            continue;
                        }
                    }
                    i++;
                } catch (Exception e) {
                    OmniLog.e(TAG, "getUserDeviceByDeviceID invoke exception : " + e.getLocalizedMessage());
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0044, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.wushuangtech.library.UserDeviceConfig getVideoDeviceByType(long r5, int r7) {
        /*
            r4 = this;
            r0 = 0
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            r1 = 0
            if (r0 > 0) goto L_0x0008
            return r1
        L_0x0008:
            android.util.LongSparseArray<java.util.List<com.wushuangtech.library.UserDeviceConfig>> r0 = r4.mUserDeviceList
            if (r0 != 0) goto L_0x000d
            return r1
        L_0x000d:
            java.lang.Object r2 = r4.mLock
            monitor-enter(r2)
            int r3 = r0.size()     // Catch:{ all -> 0x0065 }
            if (r3 > 0) goto L_0x0018
            monitor-exit(r2)     // Catch:{ all -> 0x0065 }
            return r1
        L_0x0018:
            java.lang.Object r5 = r0.get(r5)     // Catch:{ Exception -> 0x0045 }
            java.util.List r5 = (java.util.List) r5     // Catch:{ Exception -> 0x0045 }
            if (r5 == 0) goto L_0x0043
            int r6 = r5.size()     // Catch:{ Exception -> 0x0045 }
            if (r6 > 0) goto L_0x0027
            goto L_0x0043
        L_0x0027:
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x0045 }
        L_0x002b:
            boolean r6 = r5.hasNext()     // Catch:{ Exception -> 0x0045 }
            if (r6 == 0) goto L_0x0063
            java.lang.Object r6 = r5.next()     // Catch:{ Exception -> 0x0045 }
            com.wushuangtech.library.UserDeviceConfig r6 = (com.wushuangtech.library.UserDeviceConfig) r6     // Catch:{ Exception -> 0x0045 }
            int r0 = r6.getVideoType()     // Catch:{ Exception -> 0x0045 }
            if (r0 != r7) goto L_0x002b
            com.wushuangtech.library.UserDeviceConfig r5 = r6.clone()     // Catch:{ Exception -> 0x0045 }
            monitor-exit(r2)     // Catch:{ all -> 0x0065 }
            return r5
        L_0x0043:
            monitor-exit(r2)     // Catch:{ all -> 0x0065 }
            return r1
        L_0x0045:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x0065 }
            java.lang.String r6 = TAG     // Catch:{ all -> 0x0065 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r7.<init>()     // Catch:{ all -> 0x0065 }
            java.lang.String r0 = "An exception occurred while finding the device : "
            r7.append(r0)     // Catch:{ all -> 0x0065 }
            java.lang.String r5 = r5.getLocalizedMessage()     // Catch:{ all -> 0x0065 }
            r7.append(r5)     // Catch:{ all -> 0x0065 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x0065 }
            com.wushuangtech.utils.OmniLog.e(r6, r5)     // Catch:{ all -> 0x0065 }
        L_0x0063:
            monitor-exit(r2)     // Catch:{ all -> 0x0065 }
            return r1
        L_0x0065:
            r5 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0065 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.RtcDeviceManager.getVideoDeviceByType(long, int):com.wushuangtech.library.UserDeviceConfig");
    }

    public long getUserByDeviceId(String str) {
        LongSparseArray<List<UserDeviceConfig>> longSparseArray;
        if (TextUtils.isEmpty(str) || (longSparseArray = this.mUserDeviceList) == null) {
            return -1;
        }
        synchronized (this.mLock) {
            if (longSparseArray.size() <= 0) {
                return -1;
            }
            int i = 0;
            while (i < longSparseArray.size()) {
                try {
                    List<UserDeviceConfig> valueAt = longSparseArray.valueAt(i);
                    if (valueAt != null) {
                        List list = valueAt;
                        if (list.size() > 0) {
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                UserDeviceConfig userDeviceConfig = (UserDeviceConfig) list.get(i2);
                                if (userDeviceConfig != null) {
                                    if (str.equals(userDeviceConfig.getDeviceId())) {
                                        long keyAt = longSparseArray.keyAt(i);
                                        return keyAt;
                                    }
                                }
                            }
                            continue;
                        }
                    }
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }
}
