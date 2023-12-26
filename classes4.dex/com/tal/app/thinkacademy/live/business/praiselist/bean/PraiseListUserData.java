package com.tal.app.thinkacademy.live.business.praiselist.bean;

import com.tal.app.thinkacademy.common.aws.AwsS3Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/praiselist/bean/PraiseListUserData;", "", "studentId", "", "nickname", "avatar", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getNickname", "getStudentId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseListUserData.kt */
public final class PraiseListUserData {
    private final String avatar;
    private final String nickname;
    private final String studentId;

    public static /* synthetic */ PraiseListUserData copy$default(PraiseListUserData praiseListUserData, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = praiseListUserData.studentId;
        }
        if ((i & 2) != 0) {
            str2 = praiseListUserData.nickname;
        }
        if ((i & 4) != 0) {
            str3 = praiseListUserData.avatar;
        }
        return praiseListUserData.copy(str, str2, str3);
    }

    public final String component1() {
        return this.studentId;
    }

    public final String component2() {
        return this.nickname;
    }

    public final String component3() {
        return this.avatar;
    }

    public final PraiseListUserData copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "studentId");
        Intrinsics.checkNotNullParameter(str2, "nickname");
        Intrinsics.checkNotNullParameter(str3, AwsS3Util.scene_avatar);
        return new PraiseListUserData(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PraiseListUserData)) {
            return false;
        }
        PraiseListUserData praiseListUserData = (PraiseListUserData) obj;
        return Intrinsics.areEqual(this.studentId, praiseListUserData.studentId) && Intrinsics.areEqual(this.nickname, praiseListUserData.nickname) && Intrinsics.areEqual(this.avatar, praiseListUserData.avatar);
    }

    public int hashCode() {
        return (((this.studentId.hashCode() * 31) + this.nickname.hashCode()) * 31) + this.avatar.hashCode();
    }

    public String toString() {
        return "PraiseListUserData(studentId=" + this.studentId + ", nickname=" + this.nickname + ", avatar=" + this.avatar + ')';
    }

    public PraiseListUserData(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "studentId");
        Intrinsics.checkNotNullParameter(str2, "nickname");
        Intrinsics.checkNotNullParameter(str3, AwsS3Util.scene_avatar);
        this.studentId = str;
        this.nickname = str2;
        this.avatar = str3;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getStudentId() {
        return this.studentId;
    }
}
