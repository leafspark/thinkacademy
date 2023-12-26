package com.tal.app.thinkacademy.business.home.main.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopBannerResource;", "", "resId", "", "src", "", "target", "", "url", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSrc", "()Ljava/lang/String;", "getTarget", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUrl", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopBannerResource;", "equals", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BannerDataBean.kt */
public final class ShopBannerResource {
    private final Integer resId;
    private final String src;
    private final Boolean target;
    private final String url;

    public ShopBannerResource() {
        this((Integer) null, (String) null, (Boolean) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopBannerResource copy$default(ShopBannerResource shopBannerResource, Integer num, String str, Boolean bool, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = shopBannerResource.resId;
        }
        if ((i & 2) != 0) {
            str = shopBannerResource.src;
        }
        if ((i & 4) != 0) {
            bool = shopBannerResource.target;
        }
        if ((i & 8) != 0) {
            str2 = shopBannerResource.url;
        }
        return shopBannerResource.copy(num, str, bool, str2);
    }

    public final Integer component1() {
        return this.resId;
    }

    public final String component2() {
        return this.src;
    }

    public final Boolean component3() {
        return this.target;
    }

    public final String component4() {
        return this.url;
    }

    public final ShopBannerResource copy(Integer num, String str, Boolean bool, String str2) {
        return new ShopBannerResource(num, str, bool, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopBannerResource)) {
            return false;
        }
        ShopBannerResource shopBannerResource = (ShopBannerResource) obj;
        return Intrinsics.areEqual((Object) this.resId, (Object) shopBannerResource.resId) && Intrinsics.areEqual((Object) this.src, (Object) shopBannerResource.src) && Intrinsics.areEqual((Object) this.target, (Object) shopBannerResource.target) && Intrinsics.areEqual((Object) this.url, (Object) shopBannerResource.url);
    }

    public int hashCode() {
        Integer num = this.resId;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.src;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.target;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.url;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ShopBannerResource(resId=" + this.resId + ", src=" + this.src + ", target=" + this.target + ", url=" + this.url + ')';
    }

    public ShopBannerResource(Integer num, String str, Boolean bool, String str2) {
        this.resId = num;
        this.src = str;
        this.target = bool;
        this.url = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopBannerResource(Integer num, String str, Boolean bool, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? false : bool, (i & 8) != 0 ? "" : str2);
    }

    public final Integer getResId() {
        return this.resId;
    }

    public final String getSrc() {
        return this.src;
    }

    public final Boolean getTarget() {
        return this.target;
    }

    public final String getUrl() {
        return this.url;
    }
}
