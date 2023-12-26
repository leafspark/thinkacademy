package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/GameRewardCoin;", "", "rightCoin", "", "userLatestCoin", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getRightCoin", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUserLatestCoin", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/common/entity/GameRewardCoin;", "equals", "", "other", "hashCode", "toString", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameRewardCoin.kt */
public final class GameRewardCoin {
    private final Integer rightCoin;
    private final Integer userLatestCoin;

    public GameRewardCoin() {
        this((Integer) null, (Integer) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GameRewardCoin copy$default(GameRewardCoin gameRewardCoin, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = gameRewardCoin.rightCoin;
        }
        if ((i & 2) != 0) {
            num2 = gameRewardCoin.userLatestCoin;
        }
        return gameRewardCoin.copy(num, num2);
    }

    public final Integer component1() {
        return this.rightCoin;
    }

    public final Integer component2() {
        return this.userLatestCoin;
    }

    public final GameRewardCoin copy(Integer num, Integer num2) {
        return new GameRewardCoin(num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameRewardCoin)) {
            return false;
        }
        GameRewardCoin gameRewardCoin = (GameRewardCoin) obj;
        return Intrinsics.areEqual(this.rightCoin, gameRewardCoin.rightCoin) && Intrinsics.areEqual(this.userLatestCoin, gameRewardCoin.userLatestCoin);
    }

    public int hashCode() {
        Integer num = this.rightCoin;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.userLatestCoin;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "GameRewardCoin(rightCoin=" + this.rightCoin + ", userLatestCoin=" + this.userLatestCoin + ')';
    }

    public GameRewardCoin(Integer num, Integer num2) {
        this.rightCoin = num;
        this.userLatestCoin = num2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GameRewardCoin(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? 0 : num2);
    }

    public final Integer getRightCoin() {
        return this.rightCoin;
    }

    public final Integer getUserLatestCoin() {
        return this.userLatestCoin;
    }
}
