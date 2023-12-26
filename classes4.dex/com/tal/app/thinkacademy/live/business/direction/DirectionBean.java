package com.tal.app.thinkacademy.live.business.direction;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/direction/DirectionBean;", "", "userTotal", "", "rewardCoinNum", "latestCoin", "users", "", "Lcom/tal/app/thinkacademy/live/business/direction/UsersBean;", "(IIILjava/util/List;)V", "getLatestCoin", "()I", "getRewardCoinNum", "getUserTotal", "getUsers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DirectionBean.kt */
public final class DirectionBean {
    private final int latestCoin;
    private final int rewardCoinNum;
    private final int userTotal;
    private final List<UsersBean> users;

    public static /* synthetic */ DirectionBean copy$default(DirectionBean directionBean, int i, int i2, int i3, List<UsersBean> list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = directionBean.userTotal;
        }
        if ((i4 & 2) != 0) {
            i2 = directionBean.rewardCoinNum;
        }
        if ((i4 & 4) != 0) {
            i3 = directionBean.latestCoin;
        }
        if ((i4 & 8) != 0) {
            list = directionBean.users;
        }
        return directionBean.copy(i, i2, i3, list);
    }

    public final int component1() {
        return this.userTotal;
    }

    public final int component2() {
        return this.rewardCoinNum;
    }

    public final int component3() {
        return this.latestCoin;
    }

    public final List<UsersBean> component4() {
        return this.users;
    }

    public final DirectionBean copy(int i, int i2, int i3, List<UsersBean> list) {
        Intrinsics.checkNotNullParameter(list, "users");
        return new DirectionBean(i, i2, i3, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DirectionBean)) {
            return false;
        }
        DirectionBean directionBean = (DirectionBean) obj;
        return this.userTotal == directionBean.userTotal && this.rewardCoinNum == directionBean.rewardCoinNum && this.latestCoin == directionBean.latestCoin && Intrinsics.areEqual(this.users, directionBean.users);
    }

    public int hashCode() {
        return (((((this.userTotal * 31) + this.rewardCoinNum) * 31) + this.latestCoin) * 31) + this.users.hashCode();
    }

    public String toString() {
        return "DirectionBean(userTotal=" + this.userTotal + ", rewardCoinNum=" + this.rewardCoinNum + ", latestCoin=" + this.latestCoin + ", users=" + this.users + ')';
    }

    public DirectionBean(int i, int i2, int i3, List<UsersBean> list) {
        Intrinsics.checkNotNullParameter(list, "users");
        this.userTotal = i;
        this.rewardCoinNum = i2;
        this.latestCoin = i3;
        this.users = list;
    }

    public final int getLatestCoin() {
        return this.latestCoin;
    }

    public final int getRewardCoinNum() {
        return this.rewardCoinNum;
    }

    public final int getUserTotal() {
        return this.userTotal;
    }

    public final List<UsersBean> getUsers() {
        return this.users;
    }
}
