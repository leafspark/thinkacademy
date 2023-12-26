package com.tal.app.thinkacademy.live.business.studentvideo.bean;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J3\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/tal/app/thinkacademy/live/business/studentvideo/bean/OtherMaxVolumeStudent;", "", "uid", "", "volume", "", "userName", "", "modifyTime", "(JILjava/lang/String;J)V", "getModifyTime", "()J", "setModifyTime", "(J)V", "getUid", "setUid", "getUserName", "()Ljava/lang/String;", "setUserName", "(Ljava/lang/String;)V", "getVolume", "()I", "setVolume", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OtherMaxVolumeStudent.kt */
public final class OtherMaxVolumeStudent {
    private long modifyTime;
    private long uid;
    private String userName;
    private int volume;

    public OtherMaxVolumeStudent() {
        this(0, 0, (String) null, 0, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OtherMaxVolumeStudent copy$default(OtherMaxVolumeStudent otherMaxVolumeStudent, long j, int i, String str, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = otherMaxVolumeStudent.uid;
        }
        long j3 = j;
        if ((i2 & 2) != 0) {
            i = otherMaxVolumeStudent.volume;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str = otherMaxVolumeStudent.userName;
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            j2 = otherMaxVolumeStudent.modifyTime;
        }
        return otherMaxVolumeStudent.copy(j3, i3, str2, j2);
    }

    public final long component1() {
        return this.uid;
    }

    public final int component2() {
        return this.volume;
    }

    public final String component3() {
        return this.userName;
    }

    public final long component4() {
        return this.modifyTime;
    }

    public final OtherMaxVolumeStudent copy(long j, int i, String str, long j2) {
        return new OtherMaxVolumeStudent(j, i, str, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OtherMaxVolumeStudent)) {
            return false;
        }
        OtherMaxVolumeStudent otherMaxVolumeStudent = (OtherMaxVolumeStudent) obj;
        return this.uid == otherMaxVolumeStudent.uid && this.volume == otherMaxVolumeStudent.volume && Intrinsics.areEqual(this.userName, otherMaxVolumeStudent.userName) && this.modifyTime == otherMaxVolumeStudent.modifyTime;
    }

    public int hashCode() {
        int m = ((SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.uid) * 31) + this.volume) * 31;
        String str = this.userName;
        return ((m + (str == null ? 0 : str.hashCode())) * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.modifyTime);
    }

    public String toString() {
        return "OtherMaxVolumeStudent(uid=" + this.uid + ", volume=" + this.volume + ", userName=" + this.userName + ", modifyTime=" + this.modifyTime + ')';
    }

    public OtherMaxVolumeStudent(long j, int i, String str, long j2) {
        this.uid = j;
        this.volume = i;
        this.userName = str;
        this.modifyTime = j2;
    }

    public final long getUid() {
        return this.uid;
    }

    public final void setUid(long j) {
        this.uid = j;
    }

    public final int getVolume() {
        return this.volume;
    }

    public final void setVolume(int i) {
        this.volume = i;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(String str) {
        this.userName = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OtherMaxVolumeStudent(long j, int i, String str, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : j, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? System.currentTimeMillis() : j2);
    }

    public final long getModifyTime() {
        return this.modifyTime;
    }

    public final void setModifyTime(long j) {
        this.modifyTime = j;
    }
}
