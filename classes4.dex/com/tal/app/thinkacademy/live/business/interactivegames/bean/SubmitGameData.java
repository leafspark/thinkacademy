package com.tal.app.thinkacademy.live.business.interactivegames.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/SubmitGameData;", "", "rightCoin", "", "userLatestCoin", "(Ljava/lang/String;Ljava/lang/String;)V", "getRightCoin", "()Ljava/lang/String;", "getUserLatestCoin", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubmitGameData.kt */
public final class SubmitGameData {
    private final String rightCoin;
    private final String userLatestCoin;

    public static /* synthetic */ SubmitGameData copy$default(SubmitGameData submitGameData, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = submitGameData.rightCoin;
        }
        if ((i & 2) != 0) {
            str2 = submitGameData.userLatestCoin;
        }
        return submitGameData.copy(str, str2);
    }

    public final String component1() {
        return this.rightCoin;
    }

    public final String component2() {
        return this.userLatestCoin;
    }

    public final SubmitGameData copy(String str, String str2) {
        return new SubmitGameData(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubmitGameData)) {
            return false;
        }
        SubmitGameData submitGameData = (SubmitGameData) obj;
        return Intrinsics.areEqual(this.rightCoin, submitGameData.rightCoin) && Intrinsics.areEqual(this.userLatestCoin, submitGameData.userLatestCoin);
    }

    public int hashCode() {
        String str = this.rightCoin;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.userLatestCoin;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SubmitGameData(rightCoin=" + this.rightCoin + ", userLatestCoin=" + this.userLatestCoin + ')';
    }

    public SubmitGameData(String str, String str2) {
        this.rightCoin = str;
        this.userLatestCoin = str2;
    }

    public final String getRightCoin() {
        return this.rightCoin;
    }

    public final String getUserLatestCoin() {
        return this.userLatestCoin;
    }
}
