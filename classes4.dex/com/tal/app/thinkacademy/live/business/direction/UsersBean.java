package com.tal.app.thinkacademy.live.business.direction;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/direction/UsersBean;", "", "userId", "", "name", "", "nickName", "(ILjava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getNickName", "getUserId", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UsersBean.kt */
public final class UsersBean {
    private final String name;
    private final String nickName;
    private final int userId;

    public static /* synthetic */ UsersBean copy$default(UsersBean usersBean, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = usersBean.userId;
        }
        if ((i2 & 2) != 0) {
            str = usersBean.name;
        }
        if ((i2 & 4) != 0) {
            str2 = usersBean.nickName;
        }
        return usersBean.copy(i, str, str2);
    }

    public final int component1() {
        return this.userId;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.nickName;
    }

    public final UsersBean copy(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "nickName");
        return new UsersBean(i, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UsersBean)) {
            return false;
        }
        UsersBean usersBean = (UsersBean) obj;
        return this.userId == usersBean.userId && Intrinsics.areEqual(this.name, usersBean.name) && Intrinsics.areEqual(this.nickName, usersBean.nickName);
    }

    public int hashCode() {
        return (((this.userId * 31) + this.name.hashCode()) * 31) + this.nickName.hashCode();
    }

    public String toString() {
        return "UsersBean(userId=" + this.userId + ", name=" + this.name + ", nickName=" + this.nickName + ')';
    }

    public UsersBean(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "nickName");
        this.userId = i;
        this.name = str;
        this.nickName = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final int getUserId() {
        return this.userId;
    }
}
