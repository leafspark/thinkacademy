package com.tal.app.thinkacademy.business.home.main.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeDataFilter;", "", "id", "", "shortName", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShortName", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeDataFilter;", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeData.kt */
public final class ShopHomeDataFilter {
    private final Integer id;
    private final String shortName;

    public static /* synthetic */ ShopHomeDataFilter copy$default(ShopHomeDataFilter shopHomeDataFilter, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = shopHomeDataFilter.id;
        }
        if ((i & 2) != 0) {
            str = shopHomeDataFilter.shortName;
        }
        return shopHomeDataFilter.copy(num, str);
    }

    public final Integer component1() {
        return this.id;
    }

    public final String component2() {
        return this.shortName;
    }

    public final ShopHomeDataFilter copy(Integer num, String str) {
        return new ShopHomeDataFilter(num, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopHomeDataFilter)) {
            return false;
        }
        ShopHomeDataFilter shopHomeDataFilter = (ShopHomeDataFilter) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) shopHomeDataFilter.id) && Intrinsics.areEqual((Object) this.shortName, (Object) shopHomeDataFilter.shortName);
    }

    public int hashCode() {
        Integer num = this.id;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.shortName;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ShopHomeDataFilter(id=" + this.id + ", shortName=" + this.shortName + ')';
    }

    public ShopHomeDataFilter(Integer num, String str) {
        this.id = num;
        this.shortName = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopHomeDataFilter(Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, str);
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getShortName() {
        return this.shortName;
    }
}
