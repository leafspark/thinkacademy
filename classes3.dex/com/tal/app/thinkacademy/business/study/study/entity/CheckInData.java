package com.tal.app.thinkacademy.business.study.study.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/CheckInData;", "", "userLatestCoin", "", "rightCoin", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getRightCoin", "()Ljava/lang/Integer;", "setRightCoin", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUserLatestCoin", "setUserLatestCoin", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/study/study/entity/CheckInData;", "equals", "", "other", "hashCode", "toString", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CheckInData.kt */
public final class CheckInData {
    private Integer rightCoin;
    private Integer userLatestCoin;

    public CheckInData() {
        this((Integer) null, (Integer) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CheckInData copy$default(CheckInData checkInData, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = checkInData.userLatestCoin;
        }
        if ((i & 2) != 0) {
            num2 = checkInData.rightCoin;
        }
        return checkInData.copy(num, num2);
    }

    public final Integer component1() {
        return this.userLatestCoin;
    }

    public final Integer component2() {
        return this.rightCoin;
    }

    public final CheckInData copy(Integer num, Integer num2) {
        return new CheckInData(num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckInData)) {
            return false;
        }
        CheckInData checkInData = (CheckInData) obj;
        return Intrinsics.areEqual((Object) this.userLatestCoin, (Object) checkInData.userLatestCoin) && Intrinsics.areEqual((Object) this.rightCoin, (Object) checkInData.rightCoin);
    }

    public int hashCode() {
        Integer num = this.userLatestCoin;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.rightCoin;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CheckInData(userLatestCoin=" + this.userLatestCoin + ", rightCoin=" + this.rightCoin + ')';
    }

    public CheckInData(Integer num, Integer num2) {
        this.userLatestCoin = num;
        this.rightCoin = num2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CheckInData(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? 0 : num2);
    }

    public final Integer getUserLatestCoin() {
        return this.userLatestCoin;
    }

    public final void setUserLatestCoin(Integer num) {
        this.userLatestCoin = num;
    }

    public final Integer getRightCoin() {
        return this.rightCoin;
    }

    public final void setRightCoin(Integer num) {
        this.rightCoin = num;
    }
}
