package com.tal.app.thinkacademy.business.study.study.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/Sign;", "", "status", "", "rightCoin", "(Ljava/lang/String;Ljava/lang/String;)V", "getRightCoin", "()Ljava/lang/String;", "getStatus", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReadyClassBean.kt */
public final class Sign {
    private final String rightCoin;
    private final String status;

    public static /* synthetic */ Sign copy$default(Sign sign, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sign.status;
        }
        if ((i & 2) != 0) {
            str2 = sign.rightCoin;
        }
        return sign.copy(str, str2);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.rightCoin;
    }

    public final Sign copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
        return new Sign(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Sign)) {
            return false;
        }
        Sign sign = (Sign) obj;
        return Intrinsics.areEqual((Object) this.status, (Object) sign.status) && Intrinsics.areEqual((Object) this.rightCoin, (Object) sign.rightCoin);
    }

    public int hashCode() {
        int hashCode = this.status.hashCode() * 31;
        String str = this.rightCoin;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Sign(status=" + this.status + ", rightCoin=" + this.rightCoin + ')';
    }

    public Sign(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "status");
        this.status = str;
        this.rightCoin = str2;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getRightCoin() {
        return this.rightCoin;
    }
}
