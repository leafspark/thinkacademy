package com.tal.app.thinkacademy.live.business.speedyhand.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/speedyhand/bean/SpeedyHandResult;", "", "studentId", "", "avatar", "", "nickName", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getNickName", "setNickName", "getStudentId", "()Ljava/lang/Long;", "setStudentId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lcom/tal/app/thinkacademy/live/business/speedyhand/bean/SpeedyHandResult;", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpeedyHandData.kt */
public final class SpeedyHandResult {
    private String avatar;
    private String nickName;
    private Long studentId;

    public static /* synthetic */ SpeedyHandResult copy$default(SpeedyHandResult speedyHandResult, Long l, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = speedyHandResult.studentId;
        }
        if ((i & 2) != 0) {
            str = speedyHandResult.avatar;
        }
        if ((i & 4) != 0) {
            str2 = speedyHandResult.nickName;
        }
        return speedyHandResult.copy(l, str, str2);
    }

    public final Long component1() {
        return this.studentId;
    }

    public final String component2() {
        return this.avatar;
    }

    public final String component3() {
        return this.nickName;
    }

    public final SpeedyHandResult copy(Long l, String str, String str2) {
        return new SpeedyHandResult(l, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpeedyHandResult)) {
            return false;
        }
        SpeedyHandResult speedyHandResult = (SpeedyHandResult) obj;
        return Intrinsics.areEqual(this.studentId, speedyHandResult.studentId) && Intrinsics.areEqual(this.avatar, speedyHandResult.avatar) && Intrinsics.areEqual(this.nickName, speedyHandResult.nickName);
    }

    public int hashCode() {
        Long l = this.studentId;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.avatar;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.nickName;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "SpeedyHandResult(studentId=" + this.studentId + ", avatar=" + this.avatar + ", nickName=" + this.nickName + ')';
    }

    public SpeedyHandResult(Long l, String str, String str2) {
        this.studentId = l;
        this.avatar = str;
        this.nickName = str2;
    }

    public final Long getStudentId() {
        return this.studentId;
    }

    public final void setStudentId(Long l) {
        this.studentId = l;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final void setNickName(String str) {
        this.nickName = str;
    }
}
