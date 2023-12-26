package com.tal.app.thinkacademy.business.home.main.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeData;", "", "cta", "", "filters", "", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeDataFilter;", "moduleContents", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeDataModuleContent;", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getCta", "()Ljava/lang/String;", "getFilters", "()Ljava/util/List;", "getModuleContents", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeData.kt */
public final class ShopHomeData {
    private final String cta;
    private final List<ShopHomeDataFilter> filters;
    private final List<ShopHomeDataModuleContent> moduleContents;

    public static /* synthetic */ ShopHomeData copy$default(ShopHomeData shopHomeData, String str, List<ShopHomeDataFilter> list, List<ShopHomeDataModuleContent> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopHomeData.cta;
        }
        if ((i & 2) != 0) {
            list = shopHomeData.filters;
        }
        if ((i & 4) != 0) {
            list2 = shopHomeData.moduleContents;
        }
        return shopHomeData.copy(str, list, list2);
    }

    public final String component1() {
        return this.cta;
    }

    public final List<ShopHomeDataFilter> component2() {
        return this.filters;
    }

    public final List<ShopHomeDataModuleContent> component3() {
        return this.moduleContents;
    }

    public final ShopHomeData copy(String str, List<ShopHomeDataFilter> list, List<ShopHomeDataModuleContent> list2) {
        return new ShopHomeData(str, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopHomeData)) {
            return false;
        }
        ShopHomeData shopHomeData = (ShopHomeData) obj;
        return Intrinsics.areEqual((Object) this.cta, (Object) shopHomeData.cta) && Intrinsics.areEqual((Object) this.filters, (Object) shopHomeData.filters) && Intrinsics.areEqual((Object) this.moduleContents, (Object) shopHomeData.moduleContents);
    }

    public int hashCode() {
        String str = this.cta;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<ShopHomeDataFilter> list = this.filters;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<ShopHomeDataModuleContent> list2 = this.moduleContents;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ShopHomeData(cta=" + this.cta + ", filters=" + this.filters + ", moduleContents=" + this.moduleContents + ')';
    }

    public ShopHomeData(String str, List<ShopHomeDataFilter> list, List<ShopHomeDataModuleContent> list2) {
        this.cta = str;
        this.filters = list;
        this.moduleContents = list2;
    }

    public final String getCta() {
        return this.cta;
    }

    public final List<ShopHomeDataFilter> getFilters() {
        return this.filters;
    }

    public final List<ShopHomeDataModuleContent> getModuleContents() {
        return this.moduleContents;
    }
}
