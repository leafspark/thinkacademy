package com.tal.app.thinkacademy.lib.player.ijkplayer;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/ijkplayer/IjkPlayerInfo;", "", "mTcpSpeed", "", "mIsPlaying", "", "mBufferingPercent", "(JZJ)V", "getMBufferingPercent", "()J", "setMBufferingPercent", "(J)V", "getMIsPlaying", "()Z", "setMIsPlaying", "(Z)V", "getMTcpSpeed", "setMTcpSpeed", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IjkPlayerInfo.kt */
public final class IjkPlayerInfo {
    private long mBufferingPercent;
    private boolean mIsPlaying;
    private long mTcpSpeed;

    public IjkPlayerInfo() {
        this(0, false, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ IjkPlayerInfo copy$default(IjkPlayerInfo ijkPlayerInfo, long j, boolean z, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = ijkPlayerInfo.mTcpSpeed;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            z = ijkPlayerInfo.mIsPlaying;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            j2 = ijkPlayerInfo.mBufferingPercent;
        }
        return ijkPlayerInfo.copy(j3, z2, j2);
    }

    public final long component1() {
        return this.mTcpSpeed;
    }

    public final boolean component2() {
        return this.mIsPlaying;
    }

    public final long component3() {
        return this.mBufferingPercent;
    }

    public final IjkPlayerInfo copy(long j, boolean z, long j2) {
        return new IjkPlayerInfo(j, z, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IjkPlayerInfo)) {
            return false;
        }
        IjkPlayerInfo ijkPlayerInfo = (IjkPlayerInfo) obj;
        return this.mTcpSpeed == ijkPlayerInfo.mTcpSpeed && this.mIsPlaying == ijkPlayerInfo.mIsPlaying && this.mBufferingPercent == ijkPlayerInfo.mBufferingPercent;
    }

    public int hashCode() {
        int m = SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.mTcpSpeed) * 31;
        boolean z = this.mIsPlaying;
        if (z) {
            z = true;
        }
        return ((m + (z ? 1 : 0)) * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.mBufferingPercent);
    }

    public String toString() {
        return "IjkPlayerInfo(mTcpSpeed=" + this.mTcpSpeed + ", mIsPlaying=" + this.mIsPlaying + ", mBufferingPercent=" + this.mBufferingPercent + ')';
    }

    public IjkPlayerInfo(long j, boolean z, long j2) {
        this.mTcpSpeed = j;
        this.mIsPlaying = z;
        this.mBufferingPercent = j2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ IjkPlayerInfo(long r5, boolean r7, long r8, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0008
            r2 = r0
            goto L_0x0009
        L_0x0008:
            r2 = r5
        L_0x0009:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r7 = 0
        L_0x000e:
            r11 = r7
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r9 = r0
            goto L_0x0016
        L_0x0015:
            r9 = r8
        L_0x0016:
            r5 = r4
            r6 = r2
            r8 = r11
            r5.<init>(r6, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.player.ijkplayer.IjkPlayerInfo.<init>(long, boolean, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final long getMTcpSpeed() {
        return this.mTcpSpeed;
    }

    public final void setMTcpSpeed(long j) {
        this.mTcpSpeed = j;
    }

    public final boolean getMIsPlaying() {
        return this.mIsPlaying;
    }

    public final void setMIsPlaying(boolean z) {
        this.mIsPlaying = z;
    }

    public final long getMBufferingPercent() {
        return this.mBufferingPercent;
    }

    public final void setMBufferingPercent(long j) {
        this.mBufferingPercent = j;
    }
}
