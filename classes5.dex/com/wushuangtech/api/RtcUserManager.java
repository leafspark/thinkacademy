package com.wushuangtech.api;

import android.util.LongSparseArray;
import com.wushuangtech.library.User;
import com.wushuangtech.library.UserDataHolder;
import com.wushuangtech.utils.OmniLog;

public class RtcUserManager extends RtcBaseManager {
    private long mOwnerId;
    private LongSparseArray<UserDataHolder> mRemoteUserDataHolder = new LongSparseArray<>();
    private LongSparseArray<User> mUserHolder = new LongSparseArray<>();

    public RtcUserManager(String str) {
        super(str);
    }

    public long getOwnerId() {
        return this.mOwnerId;
    }

    public void setOwnerId(long j) {
        this.mOwnerId = j;
    }

    public void clearResource() {
        synchronized (this.mLock) {
            LongSparseArray<User> longSparseArray = this.mUserHolder;
            if (longSparseArray != null) {
                longSparseArray.clear();
                this.mUserHolder = null;
            }
            LongSparseArray<UserDataHolder> longSparseArray2 = this.mRemoteUserDataHolder;
            if (longSparseArray2 != null) {
                longSparseArray2.clear();
                this.mRemoteUserDataHolder = null;
            }
        }
    }

    public void putOrUpdateUser(User user) {
        if (user != null) {
            LongSparseArray<User> longSparseArray = this.mUserHolder;
            LongSparseArray<UserDataHolder> longSparseArray2 = this.mRemoteUserDataHolder;
            if (longSparseArray == null || longSparseArray2 == null) {
                OmniLog.w("User's holder is null, maybe already exit the room...");
                return;
            }
            long uid = user.getUid();
            synchronized (this.mLock) {
                User user2 = longSparseArray.get(uid);
                if (user2 != null) {
                    updateUserInfo(user2, user);
                } else {
                    longSparseArray.put(uid, user);
                }
            }
        }
    }

    public User getUser(long j) {
        LongSparseArray<User> longSparseArray;
        if (j <= 0 || (longSparseArray = this.mUserHolder) == null) {
            return null;
        }
        synchronized (this.mLock) {
            User user = longSparseArray.get(j);
            if (user == null) {
                return null;
            }
            User clone = user.clone();
            return clone;
        }
    }

    public boolean isUserExist(long j) {
        LongSparseArray<User> longSparseArray;
        boolean z = false;
        if (j <= 0 || (longSparseArray = this.mUserHolder) == null) {
            return false;
        }
        synchronized (this.mLock) {
            if (longSparseArray.get(j) != null) {
                z = true;
            }
        }
        return z;
    }

    public LongSparseArray<User> getUsers() {
        LongSparseArray<User> clone;
        LongSparseArray<User> longSparseArray = this.mUserHolder;
        if (longSparseArray == null) {
            return null;
        }
        synchronized (this.mLock) {
            clone = longSparseArray.clone();
        }
        return clone;
    }

    public void delUser(long j) {
        LongSparseArray<User> longSparseArray = this.mUserHolder;
        if (longSparseArray != null) {
            synchronized (this.mLock) {
                longSparseArray.delete(j);
            }
        }
    }

    public void updateRole(long j, int i) {
        updateUserInfo(j, Integer.valueOf(i), (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null);
    }

    public void updateAudioMuted(long j, boolean z) {
        updateUserInfo(j, (Integer) null, Boolean.valueOf(z), (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null);
    }

    public void updateVideoMuted(long j, boolean z) {
        updateUserInfo(j, (Integer) null, (Boolean) null, Boolean.valueOf(z), (Boolean) null, (Boolean) null, (Boolean) null);
    }

    public void updateTimestampTrusted(long j, boolean z) {
        updateUserInfo(j, (Integer) null, (Boolean) null, (Boolean) null, Boolean.valueOf(z), (Boolean) null, (Boolean) null);
    }

    public void updateDeviceForDual(long j, boolean z) {
        updateUserInfo(j, (Integer) null, (Boolean) null, (Boolean) null, (Boolean) null, Boolean.valueOf(z), (Boolean) null);
    }

    public void updateAudioRemoteFirstPackRecv(long j, boolean z) {
        updateUserInfo(j, (Integer) null, (Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, Boolean.valueOf(z));
    }

    public void updateUserDeviceIdWithOpened(long j, String str) {
        LongSparseArray<User> longSparseArray = this.mUserHolder;
        if (longSparseArray != null) {
            synchronized (this.mLock) {
                User user = longSparseArray.get(j);
                if (user != null) {
                    user.setDeviceIdWithOpened(str);
                }
            }
        }
    }

    public void updateVideoFirstDecodedReport(long j) {
        LongSparseArray<User> longSparseArray = this.mUserHolder;
        if (longSparseArray != null) {
            synchronized (this.mLock) {
                User user = longSparseArray.get(j);
                if (user != null) {
                    user.setVideoFirstReportDecoded(true);
                }
            }
        }
    }

    public void updateAudioLevel(long j, int i) {
        LongSparseArray<User> longSparseArray = this.mUserHolder;
        if (longSparseArray != null) {
            synchronized (this.mLock) {
                User user = longSparseArray.get(j);
                if (user != null) {
                    user.setAudioLevel(i);
                }
            }
        }
    }

    public void updateAudioFullRangeLevel(long j, int i) {
        LongSparseArray<User> longSparseArray = this.mUserHolder;
        if (longSparseArray != null) {
            synchronized (this.mLock) {
                User user = longSparseArray.get(j);
                if (user != null) {
                    user.setAudioLevelFullRange(i);
                }
            }
        }
    }

    public void updateLastAudioJitterMs(long j, int i) {
        LongSparseArray<User> longSparseArray = this.mUserHolder;
        if (longSparseArray != null) {
            synchronized (this.mLock) {
                User user = longSparseArray.get(j);
                if (user != null) {
                    user.setLastAudioLastJitterMs(i);
                }
            }
        }
    }

    private void updateUserInfo(User user, User user2) {
        user.setUserIdentity(user2.getIdentity());
    }

    private void updateUserInfo(long j, Integer num, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5) {
        LongSparseArray<User> longSparseArray = this.mUserHolder;
        if (longSparseArray != null) {
            synchronized (this.mLock) {
                User user = longSparseArray.get(j);
                if (user != null) {
                    if (num != null) {
                        user.setUserIdentity(num.intValue());
                    }
                    if (bool != null) {
                        user.setAudioMuted(bool.booleanValue());
                    }
                    if (bool2 != null) {
                        user.setVideoMuted(bool2.booleanValue());
                    }
                    if (bool3 != null) {
                        user.setTimestampTrusted(bool3.booleanValue());
                    }
                    if (bool4 != null) {
                        user.setEnableDualVideo(bool4.booleanValue());
                    }
                    if (bool5 != null) {
                        user.setAudioRemoteFirstPackRecv(bool5.booleanValue());
                    }
                }
            }
        }
    }

    public boolean getRemoteAudioMuteStats(long j) {
        synchronized (this.mLock) {
            LongSparseArray<UserDataHolder> longSparseArray = this.mRemoteUserDataHolder;
            if (longSparseArray == null) {
                return false;
            }
            UserDataHolder userDataHolder = longSparseArray.get(j);
            if (userDataHolder == null) {
                return false;
            }
            boolean isAudioRemoteStopRecv = userDataHolder.isAudioRemoteStopRecv();
            return isAudioRemoteStopRecv;
        }
    }

    public boolean getRemoteVideoMuteStats(long j) {
        synchronized (this.mLock) {
            LongSparseArray<UserDataHolder> longSparseArray = this.mRemoteUserDataHolder;
            if (longSparseArray == null) {
                return false;
            }
            UserDataHolder userDataHolder = longSparseArray.get(j);
            if (userDataHolder == null) {
                return false;
            }
            boolean isVideoRemoteStopRecv = userDataHolder.isVideoRemoteStopRecv();
            return isVideoRemoteStopRecv;
        }
    }

    public void updateRemoteAudioMuteStats(long j, boolean z) {
        synchronized (this.mLock) {
            LongSparseArray<UserDataHolder> longSparseArray = this.mRemoteUserDataHolder;
            if (longSparseArray != null) {
                UserDataHolder userDataHolder = longSparseArray.get(j);
                if (userDataHolder != null) {
                    userDataHolder.setAudioRemoteStopRecv(z);
                }
            }
        }
    }

    public void updateRemoteVideoMuteStats(long j, boolean z) {
        synchronized (this.mLock) {
            LongSparseArray<UserDataHolder> longSparseArray = this.mRemoteUserDataHolder;
            if (longSparseArray != null) {
                UserDataHolder userDataHolder = longSparseArray.get(j);
                if (userDataHolder != null) {
                    userDataHolder.setVideoRemoteStopRecv(z);
                }
            }
        }
    }
}
