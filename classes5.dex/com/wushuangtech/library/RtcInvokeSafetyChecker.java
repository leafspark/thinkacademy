package com.wushuangtech.library;

import android.text.TextUtils;

public class RtcInvokeSafetyChecker {
    private String mJoiningChannelName;
    private String mJoiningChannelToken;
    private long mJoiningChannelUid;

    public double checkAudioMixingVolume(int i) {
        if (i < 0 || i > 100) {
            return -5.0d;
        }
        return ((double) i) / 100.0d;
    }

    public double checkAudioPlaybackSignalVolume(int i) {
        if (i < 0 || i > 400) {
            return -5.0d;
        }
        return ((double) i) / 100.0d;
    }

    public double checkAudioRecordingSignalVolume(int i) {
        if (i < 0 || i > 500) {
            return -5.0d;
        }
        return ((double) i) / 100.0d;
    }

    public boolean checkCurrentRoomStatus() {
        return GlobalConfig.mIsInRoom.get();
    }

    public boolean checkCurrentRole(int i) {
        return GlobalConfig.mLocalRole == i;
    }

    public boolean checkJoinChannelArgs(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            GlobalHolder.getInstance().notifyCHChannelError(1);
            return false;
        } else if (j > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkJoinChannelRepeat(String str, String str2, long j) {
        boolean z = compareString(this.mJoiningChannelToken, str) || compareString(this.mJoiningChannelName, str2) || j != this.mJoiningChannelUid;
        if (!z) {
            this.mJoiningChannelToken = str;
            this.mJoiningChannelName = str2;
            this.mJoiningChannelUid = j;
        }
        return z;
    }

    private boolean compareString(String str, String str2) {
        return !(str == null && str2 == null) && (str == null || !str.equals(str2));
    }
}
