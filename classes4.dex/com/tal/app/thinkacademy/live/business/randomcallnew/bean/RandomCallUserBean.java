package com.tal.app.thinkacademy.live.business.randomcallnew.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b \b\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003JR\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\bHÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallUserBean;", "", "userId", "", "nickName", "", "avatar", "level", "", "pullStreamState", "isSelected", "", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IZ)V", "getAvatar", "()Ljava/lang/String;", "()Z", "setSelected", "(Z)V", "getLevel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNickName", "getPullStreamState", "()I", "setPullStreamState", "(I)V", "getUserId", "()Ljava/lang/Long;", "setUserId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IZ)Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallUserBean;", "equals", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RandomCallUserBean.kt */
public final class RandomCallUserBean {
    private final String avatar;
    private boolean isSelected;
    private final Integer level;
    private final String nickName;
    private int pullStreamState;
    private Long userId;

    public static /* synthetic */ RandomCallUserBean copy$default(RandomCallUserBean randomCallUserBean, Long l, String str, String str2, Integer num, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            l = randomCallUserBean.userId;
        }
        if ((i2 & 2) != 0) {
            str = randomCallUserBean.nickName;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = randomCallUserBean.avatar;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            num = randomCallUserBean.level;
        }
        Integer num2 = num;
        if ((i2 & 16) != 0) {
            i = randomCallUserBean.pullStreamState;
        }
        int i3 = i;
        if ((i2 & 32) != 0) {
            z = randomCallUserBean.isSelected;
        }
        return randomCallUserBean.copy(l, str3, str4, num2, i3, z);
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

    public final Integer component4() {
        return this.level;
    }

    public final int component5() {
        return this.pullStreamState;
    }

    public final boolean component6() {
        return this.isSelected;
    }

    public final RandomCallUserBean copy(Long l, String str, String str2, Integer num, int i, boolean z) {
        return new RandomCallUserBean(l, str, str2, num, i, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RandomCallUserBean)) {
            return false;
        }
        RandomCallUserBean randomCallUserBean = (RandomCallUserBean) obj;
        return Intrinsics.areEqual(this.userId, randomCallUserBean.userId) && Intrinsics.areEqual(this.nickName, randomCallUserBean.nickName) && Intrinsics.areEqual(this.avatar, randomCallUserBean.avatar) && Intrinsics.areEqual(this.level, randomCallUserBean.level) && this.pullStreamState == randomCallUserBean.pullStreamState && this.isSelected == randomCallUserBean.isSelected;
    }

    public int hashCode() {
        Long l = this.userId;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.nickName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.avatar;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.level;
        if (num != null) {
            i = num.hashCode();
        }
        int i2 = (((hashCode3 + i) * 31) + this.pullStreamState) * 31;
        boolean z = this.isSelected;
        if (z) {
            z = true;
        }
        return i2 + (z ? 1 : 0);
    }

    public String toString() {
        return "RandomCallUserBean(userId=" + this.userId + ", nickName=" + this.nickName + ", avatar=" + this.avatar + ", level=" + this.level + ", pullStreamState=" + this.pullStreamState + ", isSelected=" + this.isSelected + ')';
    }

    public RandomCallUserBean(Long l, String str, String str2, Integer num, int i, boolean z) {
        this.userId = l;
        this.nickName = str;
        this.avatar = str2;
        this.level = num;
        this.pullStreamState = i;
        this.isSelected = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RandomCallUserBean(Long l, String str, String str2, Integer num, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, str, str2, num, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? false : z);
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

    public final String getAvatar() {
        return this.avatar;
    }

    public final Integer getLevel() {
        return this.level;
    }

    public final int getPullStreamState() {
        return this.pullStreamState;
    }

    public final void setPullStreamState(int i) {
        this.pullStreamState = i;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
