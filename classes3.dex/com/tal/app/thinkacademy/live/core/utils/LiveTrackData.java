package com.tal.app.thinkacademy.live.core.utils;

import com.tal.app.thinkacademy.common.user.UserInfo;
import com.tal.app.thinkacademy.common.user.UserInfoBll;
import com.tal.app.thinkacademy.live.core.live.bean.LiveRoomData;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\tH\u0007J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\tH\u0007R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/utils/LiveTrackData;", "", "()V", "mClassId", "", "Ljava/lang/Integer;", "mCourseTraceId", "", "mEnterTime", "", "mGradeName", "mInLive", "", "mIrcState", "mLiveRoomData", "Lcom/tal/app/thinkacademy/live/core/live/bean/LiveRoomData;", "mLocalServerState", "mPlanMode", "mRoomId", "mTraceId", "mUserId", "getMUserId$annotations", "getMUserId", "()Ljava/lang/String;", "setMUserId", "(Ljava/lang/String;)V", "destroy", "", "newCourseTraceId", "t", "newTraceId", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveTrack.kt */
public final class LiveTrackData {
    public static final LiveTrackData INSTANCE = new LiveTrackData();
    public static Integer mClassId;
    public static String mCourseTraceId;
    public static long mEnterTime;
    public static String mGradeName;
    public static boolean mInLive;
    public static String mIrcState;
    public static LiveRoomData mLiveRoomData;
    public static String mLocalServerState;
    public static String mPlanMode;
    public static String mRoomId;
    public static String mTraceId;
    private static String mUserId;

    @JvmStatic
    public static /* synthetic */ void getMUserId$annotations() {
    }

    private LiveTrackData() {
    }

    @JvmStatic
    public static final void newTraceId(long j) {
        StringBuilder sb = new StringBuilder();
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        sb.append(userInfoEntity == null ? null : userInfoEntity.getUid());
        sb.append('_');
        sb.append(j);
        mTraceId = sb.toString();
    }

    @JvmStatic
    public static final void newCourseTraceId(long j) {
        StringBuilder sb = new StringBuilder();
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        sb.append(userInfoEntity == null ? null : userInfoEntity.getUid());
        sb.append('_');
        sb.append(j);
        mCourseTraceId = sb.toString();
    }

    static {
        UserInfo userInfoEntity = UserInfoBll.Companion.getInstance().getUserInfoEntity();
        mUserId = userInfoEntity == null ? null : userInfoEntity.getUid();
    }

    public static final String getMUserId() {
        return mUserId;
    }

    public static final void setMUserId(String str) {
        mUserId = str;
    }

    @JvmStatic
    public static final void destroy() {
        mInLive = false;
        mLiveRoomData = null;
        mPlanMode = null;
        mRoomId = null;
        mTraceId = null;
        mCourseTraceId = null;
        mIrcState = null;
        mLocalServerState = null;
        mClassId = null;
        mGradeName = null;
        mEnterTime = 0;
        mUserId = null;
    }
}
