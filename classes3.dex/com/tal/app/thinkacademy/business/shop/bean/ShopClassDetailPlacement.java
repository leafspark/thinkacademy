package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailPlacement;", "", "describe", "", "link", "(Ljava/lang/String;Ljava/lang/String;)V", "getDescribe", "()Ljava/lang/String;", "getLink", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailInfoBean.kt */
public final class ShopClassDetailPlacement {
    private final String describe;
    private final String link;

    public ShopClassDetailPlacement() {
        this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopClassDetailPlacement copy$default(ShopClassDetailPlacement shopClassDetailPlacement, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopClassDetailPlacement.describe;
        }
        if ((i & 2) != 0) {
            str2 = shopClassDetailPlacement.link;
        }
        return shopClassDetailPlacement.copy(str, str2);
    }

    public final String component1() {
        return this.describe;
    }

    public final String component2() {
        return this.link;
    }

    public final ShopClassDetailPlacement copy(String str, String str2) {
        return new ShopClassDetailPlacement(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopClassDetailPlacement)) {
            return false;
        }
        ShopClassDetailPlacement shopClassDetailPlacement = (ShopClassDetailPlacement) obj;
        return Intrinsics.areEqual((Object) this.describe, (Object) shopClassDetailPlacement.describe) && Intrinsics.areEqual((Object) this.link, (Object) shopClassDetailPlacement.link);
    }

    public int hashCode() {
        String str = this.describe;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.link;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ShopClassDetailPlacement(describe=" + this.describe + ", link=" + this.link + ')';
    }

    public ShopClassDetailPlacement(String str, String str2) {
        this.describe = str;
        this.link = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopClassDetailPlacement(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getDescribe() {
        return this.describe;
    }

    public final String getLink() {
        return this.link;
    }
}
