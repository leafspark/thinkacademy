package com.tal.app.thinkacademy.lib.player.rtcplayer.entity;

import android.view.SurfaceView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/rtcplayer/entity/RtcUserState;", "", "online", "", "openMic", "uid", "", "(ZZJ)V", "mIsOnline", "getMIsOnline", "()Z", "setMIsOnline", "(Z)V", "mIsOpenCamera", "getMIsOpenCamera", "setMIsOpenCamera", "mIsOpenMic", "getMIsOpenMic", "setMIsOpenMic", "mIsVideoMute", "getMIsVideoMute", "setMIsVideoMute", "mSurfaceView", "Landroid/view/SurfaceView;", "getMSurfaceView", "()Landroid/view/SurfaceView;", "setMSurfaceView", "(Landroid/view/SurfaceView;)V", "mUid", "getMUid", "()J", "setMUid", "(J)V", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcUserState.kt */
public final class RtcUserState {
    private boolean mIsOnline;
    private boolean mIsOpenCamera;
    private boolean mIsOpenMic;
    private boolean mIsVideoMute;
    private SurfaceView mSurfaceView;
    private long mUid;

    public RtcUserState() {
        this(false, false, 0, 7, (DefaultConstructorMarker) null);
    }

    public RtcUserState(boolean z, boolean z2, long j) {
        this.mIsOnline = z;
        this.mIsOpenMic = z2;
        this.mUid = j;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RtcUserState(boolean z, boolean z2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? -1 : j);
    }

    public final boolean getMIsOnline() {
        return this.mIsOnline;
    }

    public final void setMIsOnline(boolean z) {
        this.mIsOnline = z;
    }

    public final boolean getMIsOpenMic() {
        return this.mIsOpenMic;
    }

    public final void setMIsOpenMic(boolean z) {
        this.mIsOpenMic = z;
    }

    public final long getMUid() {
        return this.mUid;
    }

    public final void setMUid(long j) {
        this.mUid = j;
    }

    public final boolean getMIsOpenCamera() {
        return this.mIsOpenCamera;
    }

    public final void setMIsOpenCamera(boolean z) {
        this.mIsOpenCamera = z;
    }

    public final SurfaceView getMSurfaceView() {
        return this.mSurfaceView;
    }

    public final void setMSurfaceView(SurfaceView surfaceView) {
        this.mSurfaceView = surfaceView;
    }

    public final boolean getMIsVideoMute() {
        return this.mIsVideoMute;
    }

    public final void setMIsVideoMute(boolean z) {
        this.mIsVideoMute = z;
    }
}
