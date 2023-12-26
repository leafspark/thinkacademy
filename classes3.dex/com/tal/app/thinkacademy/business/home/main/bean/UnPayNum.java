package com.tal.app.thinkacademy.business.home.main.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/bean/UnPayNum;", "", "inCartSku", "", "toBeContinueSku", "(Ljava/lang/String;Ljava/lang/String;)V", "getInCartSku", "()Ljava/lang/String;", "getToBeContinueSku", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_home_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnPayNum.kt */
public final class UnPayNum {
    private final String inCartSku;
    private final String toBeContinueSku;

    public static /* synthetic */ UnPayNum copy$default(UnPayNum unPayNum, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = unPayNum.inCartSku;
        }
        if ((i & 2) != 0) {
            str2 = unPayNum.toBeContinueSku;
        }
        return unPayNum.copy(str, str2);
    }

    public final String component1() {
        return this.inCartSku;
    }

    public final String component2() {
        return this.toBeContinueSku;
    }

    public final UnPayNum copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "inCartSku");
        Intrinsics.checkNotNullParameter(str2, "toBeContinueSku");
        return new UnPayNum(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnPayNum)) {
            return false;
        }
        UnPayNum unPayNum = (UnPayNum) obj;
        return Intrinsics.areEqual((Object) this.inCartSku, (Object) unPayNum.inCartSku) && Intrinsics.areEqual((Object) this.toBeContinueSku, (Object) unPayNum.toBeContinueSku);
    }

    public int hashCode() {
        return (this.inCartSku.hashCode() * 31) + this.toBeContinueSku.hashCode();
    }

    public String toString() {
        return "UnPayNum(inCartSku=" + this.inCartSku + ", toBeContinueSku=" + this.toBeContinueSku + ')';
    }

    public UnPayNum(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "inCartSku");
        Intrinsics.checkNotNullParameter(str2, "toBeContinueSku");
        this.inCartSku = str;
        this.toBeContinueSku = str2;
    }

    public final String getInCartSku() {
        return this.inCartSku;
    }

    public final String getToBeContinueSku() {
        return this.toBeContinueSku;
    }
}
