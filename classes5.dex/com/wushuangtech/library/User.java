package com.wushuangtech.library;

public class User implements Cloneable {
    private int mAudioLevel;
    private int mAudioLevelFullRange;
    private boolean mAudioMuted;
    private boolean mAudioRemoteFirstPackRecv;
    private boolean mCrossRoomUser;
    private String mDeviceIdWithOpened;
    private boolean mIsEnableDualVideo;
    private boolean mIsLinkAnchor;
    private long mJoinedTimestamp = System.currentTimeMillis();
    private int mLastAudioLastJitterMs;
    private long mLinkRoomID;
    private boolean mTimestampTrusted;
    private final long mUserId;
    private int mUserIdentity;
    private boolean mVideoFirstReportDecoded;
    private boolean mVideoMuted;

    public User(long j, int i) {
        this.mUserId = j;
        this.mDeviceIdWithOpened = String.valueOf(j);
        this.mUserIdentity = i;
    }

    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public long getUid() {
        return this.mUserId;
    }

    public int getIdentity() {
        return this.mUserIdentity;
    }

    public long getJoinedTimestamp() {
        return this.mJoinedTimestamp;
    }

    public long getLinkedChannelId() {
        return this.mLinkRoomID;
    }

    public String getDeviceIdWithOpened() {
        return this.mDeviceIdWithOpened;
    }

    public int getAudioLevel() {
        return this.mAudioLevel;
    }

    public int getAudioLevelFullRange() {
        return this.mAudioLevelFullRange;
    }

    public int getLastAudioLastJitterMs() {
        return this.mLastAudioLastJitterMs;
    }

    public boolean isLinkedAnchor() {
        return this.mIsLinkAnchor;
    }

    public boolean ismTimestampTrusted() {
        return this.mTimestampTrusted;
    }

    public boolean isAudioMuted() {
        return this.mAudioMuted;
    }

    public boolean isVideoMuted() {
        return this.mVideoMuted;
    }

    public boolean isEnableDualVideo() {
        return this.mIsEnableDualVideo;
    }

    /* access modifiers changed from: package-private */
    public boolean isCrossRoomUser() {
        return this.mCrossRoomUser;
    }

    public boolean isAudioRemoteFirstPackRecv() {
        return this.mAudioRemoteFirstPackRecv;
    }

    public boolean isVideoFirstReportDecoded() {
        return this.mVideoFirstReportDecoded;
    }

    public void setUserIdentity(int i) {
        this.mUserIdentity = i;
    }

    public void setTimestampTrusted(boolean z) {
        this.mTimestampTrusted = z;
    }

    public void setAudioMuted(boolean z) {
        this.mAudioMuted = z;
    }

    public void setVideoMuted(boolean z) {
        this.mVideoMuted = z;
    }

    /* access modifiers changed from: package-private */
    public void setCrossRoomUser(boolean z) {
        this.mCrossRoomUser = z;
    }

    public void setEnableDualVideo(boolean z) {
        this.mIsEnableDualVideo = z;
    }

    public void setLinkedAnchor(boolean z) {
        this.mIsLinkAnchor = z;
    }

    public void setLinkedChannelId(long j) {
        this.mLinkRoomID = j;
    }

    public void setAudioRemoteFirstPackRecv(boolean z) {
        this.mAudioRemoteFirstPackRecv = z;
    }

    public void setDeviceIdWithOpened(String str) {
        this.mDeviceIdWithOpened = str;
    }

    public void setVideoFirstReportDecoded(boolean z) {
        this.mVideoFirstReportDecoded = z;
    }

    public void setAudioLevel(int i) {
        this.mAudioLevel = i;
    }

    public void setAudioLevelFullRange(int i) {
        this.mAudioLevelFullRange = i;
    }

    public void setLastAudioLastJitterMs(int i) {
        this.mLastAudioLastJitterMs = i;
    }

    public String toString() {
        return "User{mUserId=" + this.mUserId + ", mUserIdentity=" + this.mUserIdentity + ", mIsLinkAnchor=" + this.mIsLinkAnchor + ", mLinkRoomID=" + this.mLinkRoomID + ", mCrossRoomUser=" + this.mCrossRoomUser + ", mAudioMuted=" + this.mAudioMuted + ", mAudioRemoteFirstPackRecv=" + this.mAudioRemoteFirstPackRecv + ", mVideoMuted=" + this.mVideoMuted + ", mIsEnableDualVideo=" + this.mIsEnableDualVideo + ", mTimestampTrusted=" + this.mTimestampTrusted + ", mDeviceIdWithOpened='" + this.mDeviceIdWithOpened + '\'' + '}';
    }
}
