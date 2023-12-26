package com.tal.app.thinkacademy.business.home.main.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopBannerBodyData;", "", "channelIds", "", "", "locationKey", "", "(Ljava/util/List;Ljava/lang/String;)V", "getChannelIds", "()Ljava/util/List;", "getLocationKey", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BannerDataBean.kt */
public final class ShopBannerBodyData {
    private final List<Integer> channelIds;
    private final String locationKey;

    public ShopBannerBodyData() {
        this((List) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopBannerBodyData copy$default(ShopBannerBodyData shopBannerBodyData, List<Integer> list, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = shopBannerBodyData.channelIds;
        }
        if ((i & 2) != 0) {
            str = shopBannerBodyData.locationKey;
        }
        return shopBannerBodyData.copy(list, str);
    }

    public final List<Integer> component1() {
        return this.channelIds;
    }

    public final String component2() {
        return this.locationKey;
    }

    public final ShopBannerBodyData copy(List<Integer> list, String str) {
        return new ShopBannerBodyData(list, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopBannerBodyData)) {
            return false;
        }
        ShopBannerBodyData shopBannerBodyData = (ShopBannerBodyData) obj;
        return Intrinsics.areEqual((Object) this.channelIds, (Object) shopBannerBodyData.channelIds) && Intrinsics.areEqual((Object) this.locationKey, (Object) shopBannerBodyData.locationKey);
    }

    public int hashCode() {
        List<Integer> list = this.channelIds;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.locationKey;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ShopBannerBodyData(channelIds=" + this.channelIds + ", locationKey=" + this.locationKey + ')';
    }

    public ShopBannerBodyData(List<Integer> list, String str) {
        this.channelIds = list;
        this.locationKey = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopBannerBodyData(List list, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? "Touch-shop_home_screen" : str);
    }

    public final List<Integer> getChannelIds() {
        return this.channelIds;
    }

    public final String getLocationKey() {
        return this.locationKey;
    }
}
