package com.tal.app.thinkacademy.business.home.main.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeBodyHeader;", "", "schoolCode", "", "(Ljava/lang/String;)V", "getSchoolCode", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeBody.kt */
public final class ShopHomeBodyHeader {
    private final String schoolCode;

    public static /* synthetic */ ShopHomeBodyHeader copy$default(ShopHomeBodyHeader shopHomeBodyHeader, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopHomeBodyHeader.schoolCode;
        }
        return shopHomeBodyHeader.copy(str);
    }

    public final String component1() {
        return this.schoolCode;
    }

    public final ShopHomeBodyHeader copy(String str) {
        return new ShopHomeBodyHeader(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ShopHomeBodyHeader) && Intrinsics.areEqual((Object) this.schoolCode, (Object) ((ShopHomeBodyHeader) obj).schoolCode);
    }

    public int hashCode() {
        String str = this.schoolCode;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "ShopHomeBodyHeader(schoolCode=" + this.schoolCode + ')';
    }

    public ShopHomeBodyHeader(String str) {
        this.schoolCode = str;
    }

    public final String getSchoolCode() {
        return this.schoolCode;
    }
}
