package com.tal.app.thinkacademy.live.abilitypack.coincenter.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/coincenter/bean/CoinData;", "", "planIdCoin", "", "totalCoin", "medalNum", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMedalNum", "()Ljava/lang/String;", "getPlanIdCoin", "getTotalCoin", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CoinData.kt */
public final class CoinData {
    private final String medalNum;
    private final String planIdCoin;
    private final String totalCoin;

    public static /* synthetic */ CoinData copy$default(CoinData coinData, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = coinData.planIdCoin;
        }
        if ((i & 2) != 0) {
            str2 = coinData.totalCoin;
        }
        if ((i & 4) != 0) {
            str3 = coinData.medalNum;
        }
        return coinData.copy(str, str2, str3);
    }

    public final String component1() {
        return this.planIdCoin;
    }

    public final String component2() {
        return this.totalCoin;
    }

    public final String component3() {
        return this.medalNum;
    }

    public final CoinData copy(String str, String str2, String str3) {
        return new CoinData(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CoinData)) {
            return false;
        }
        CoinData coinData = (CoinData) obj;
        return Intrinsics.areEqual(this.planIdCoin, coinData.planIdCoin) && Intrinsics.areEqual(this.totalCoin, coinData.totalCoin) && Intrinsics.areEqual(this.medalNum, coinData.medalNum);
    }

    public int hashCode() {
        String str = this.planIdCoin;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.totalCoin;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.medalNum;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "CoinData(planIdCoin=" + this.planIdCoin + ", totalCoin=" + this.totalCoin + ", medalNum=" + this.medalNum + ')';
    }

    public CoinData(String str, String str2, String str3) {
        this.planIdCoin = str;
        this.totalCoin = str2;
        this.medalNum = str3;
    }

    public final String getMedalNum() {
        return this.medalNum;
    }

    public final String getPlanIdCoin() {
        return this.planIdCoin;
    }

    public final String getTotalCoin() {
        return this.totalCoin;
    }
}
