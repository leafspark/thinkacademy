package com.tal.app.thinkacademy.live.business.schulte.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableRankListUserDataBean;", "", "userId", "", "avatar", "nickName", "duration", "coin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getCoin", "getDuration", "getNickName", "getUserId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTableRankListUserDataBean.kt */
public final class SchulteTableRankListUserDataBean {
    private final String avatar;
    private final String coin;
    private final String duration;
    private final String nickName;
    private final String userId;

    public static /* synthetic */ SchulteTableRankListUserDataBean copy$default(SchulteTableRankListUserDataBean schulteTableRankListUserDataBean, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = schulteTableRankListUserDataBean.userId;
        }
        if ((i & 2) != 0) {
            str2 = schulteTableRankListUserDataBean.avatar;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = schulteTableRankListUserDataBean.nickName;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = schulteTableRankListUserDataBean.duration;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = schulteTableRankListUserDataBean.coin;
        }
        return schulteTableRankListUserDataBean.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.avatar;
    }

    public final String component3() {
        return this.nickName;
    }

    public final String component4() {
        return this.duration;
    }

    public final String component5() {
        return this.coin;
    }

    public final SchulteTableRankListUserDataBean copy(String str, String str2, String str3, String str4, String str5) {
        return new SchulteTableRankListUserDataBean(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SchulteTableRankListUserDataBean)) {
            return false;
        }
        SchulteTableRankListUserDataBean schulteTableRankListUserDataBean = (SchulteTableRankListUserDataBean) obj;
        return Intrinsics.areEqual(this.userId, schulteTableRankListUserDataBean.userId) && Intrinsics.areEqual(this.avatar, schulteTableRankListUserDataBean.avatar) && Intrinsics.areEqual(this.nickName, schulteTableRankListUserDataBean.nickName) && Intrinsics.areEqual(this.duration, schulteTableRankListUserDataBean.duration) && Intrinsics.areEqual(this.coin, schulteTableRankListUserDataBean.coin);
    }

    public int hashCode() {
        String str = this.userId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.avatar;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.nickName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.duration;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.coin;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "SchulteTableRankListUserDataBean(userId=" + this.userId + ", avatar=" + this.avatar + ", nickName=" + this.nickName + ", duration=" + this.duration + ", coin=" + this.coin + ')';
    }

    public SchulteTableRankListUserDataBean(String str, String str2, String str3, String str4, String str5) {
        this.userId = str;
        this.avatar = str2;
        this.nickName = str3;
        this.duration = str4;
        this.coin = str5;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getCoin() {
        return this.coin;
    }
}
