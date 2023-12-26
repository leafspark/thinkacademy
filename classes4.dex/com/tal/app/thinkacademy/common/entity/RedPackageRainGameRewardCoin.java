package com.tal.app.thinkacademy.common.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J>\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/RedPackageRainGameRewardCoin;", "", "coin", "", "grabRedbagQueue", "", "grabBombQueue", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)V", "getCoin", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGrabBombQueue", "()Ljava/util/List;", "getGrabRedbagQueue", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)Lcom/tal/app/thinkacademy/common/entity/RedPackageRainGameRewardCoin;", "equals", "", "other", "hashCode", "toString", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RedPackageRainGameRewardCoin.kt */
public final class RedPackageRainGameRewardCoin {
    private final Integer coin;
    private final List<Integer> grabBombQueue;
    private final List<Integer> grabRedbagQueue;

    public static /* synthetic */ RedPackageRainGameRewardCoin copy$default(RedPackageRainGameRewardCoin redPackageRainGameRewardCoin, Integer num, List<Integer> list, List<Integer> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = redPackageRainGameRewardCoin.coin;
        }
        if ((i & 2) != 0) {
            list = redPackageRainGameRewardCoin.grabRedbagQueue;
        }
        if ((i & 4) != 0) {
            list2 = redPackageRainGameRewardCoin.grabBombQueue;
        }
        return redPackageRainGameRewardCoin.copy(num, list, list2);
    }

    public final Integer component1() {
        return this.coin;
    }

    public final List<Integer> component2() {
        return this.grabRedbagQueue;
    }

    public final List<Integer> component3() {
        return this.grabBombQueue;
    }

    public final RedPackageRainGameRewardCoin copy(Integer num, List<Integer> list, List<Integer> list2) {
        return new RedPackageRainGameRewardCoin(num, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedPackageRainGameRewardCoin)) {
            return false;
        }
        RedPackageRainGameRewardCoin redPackageRainGameRewardCoin = (RedPackageRainGameRewardCoin) obj;
        return Intrinsics.areEqual(this.coin, redPackageRainGameRewardCoin.coin) && Intrinsics.areEqual(this.grabRedbagQueue, redPackageRainGameRewardCoin.grabRedbagQueue) && Intrinsics.areEqual(this.grabBombQueue, redPackageRainGameRewardCoin.grabBombQueue);
    }

    public int hashCode() {
        Integer num = this.coin;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<Integer> list = this.grabRedbagQueue;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<Integer> list2 = this.grabBombQueue;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "RedPackageRainGameRewardCoin(coin=" + this.coin + ", grabRedbagQueue=" + this.grabRedbagQueue + ", grabBombQueue=" + this.grabBombQueue + ')';
    }

    public RedPackageRainGameRewardCoin(Integer num, List<Integer> list, List<Integer> list2) {
        this.coin = num;
        this.grabRedbagQueue = list;
        this.grabBombQueue = list2;
    }

    public final Integer getCoin() {
        return this.coin;
    }

    public final List<Integer> getGrabRedbagQueue() {
        return this.grabRedbagQueue;
    }

    public final List<Integer> getGrabBombQueue() {
        return this.grabBombQueue;
    }
}
