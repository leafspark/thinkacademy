package com.tal.app.thinkacademy.live.business.speedyhand.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/speedyhand/bean/StudentInfo;", "", "userId", "", "nickName", "", "avatar", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getNickName", "setNickName", "getUserId", "()Ljava/lang/Long;", "setUserId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/tal/app/thinkacademy/live/business/speedyhand/bean/StudentInfo;", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpeedyHandApiResult.kt */
public final class StudentInfo {
    private String avatar;
    private String nickName;
    private Long userId;

    public StudentInfo() {
        this((Long) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ StudentInfo copy$default(StudentInfo studentInfo, Long l, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = studentInfo.userId;
        }
        if ((i & 2) != 0) {
            str = studentInfo.nickName;
        }
        if ((i & 4) != 0) {
            str2 = studentInfo.avatar;
        }
        return studentInfo.copy(l, str, str2);
    }

    public final Long component1() {
        return this.userId;
    }

    public final String component2() {
        return this.nickName;
    }

    public final String component3() {
        return this.avatar;
    }

    public final StudentInfo copy(Long l, String str, String str2) {
        return new StudentInfo(l, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StudentInfo)) {
            return false;
        }
        StudentInfo studentInfo = (StudentInfo) obj;
        return Intrinsics.areEqual(this.userId, studentInfo.userId) && Intrinsics.areEqual(this.nickName, studentInfo.nickName) && Intrinsics.areEqual(this.avatar, studentInfo.avatar);
    }

    public int hashCode() {
        Long l = this.userId;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.nickName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.avatar;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "StudentInfo(userId=" + this.userId + ", nickName=" + this.nickName + ", avatar=" + this.avatar + ')';
    }

    public StudentInfo(Long l, String str, String str2) {
        this.userId = l;
        this.nickName = str;
        this.avatar = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StudentInfo(Long l, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? -1L : l, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2);
    }

    public final Long getUserId() {
        return this.userId;
    }

    public final void setUserId(Long l) {
        this.userId = l;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final void setNickName(String str) {
        this.nickName = str;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }
}
