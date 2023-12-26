package com.tal.app.thinkacademy.business.home.main.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopBannerBody;", "", "data", "", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopBannerBodyData;", "header", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopBannerBodyHead;", "(Ljava/util/List;Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopBannerBodyHead;)V", "getData", "()Ljava/util/List;", "getHeader", "()Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopBannerBodyHead;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BannerDataBean.kt */
public final class ShopBannerBody {
    private final List<ShopBannerBodyData> data;
    private final ShopBannerBodyHead header;

    public ShopBannerBody() {
        this((List) null, (ShopBannerBodyHead) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopBannerBody copy$default(ShopBannerBody shopBannerBody, List<ShopBannerBodyData> list, ShopBannerBodyHead shopBannerBodyHead, int i, Object obj) {
        if ((i & 1) != 0) {
            list = shopBannerBody.data;
        }
        if ((i & 2) != 0) {
            shopBannerBodyHead = shopBannerBody.header;
        }
        return shopBannerBody.copy(list, shopBannerBodyHead);
    }

    public final List<ShopBannerBodyData> component1() {
        return this.data;
    }

    public final ShopBannerBodyHead component2() {
        return this.header;
    }

    public final ShopBannerBody copy(List<ShopBannerBodyData> list, ShopBannerBodyHead shopBannerBodyHead) {
        return new ShopBannerBody(list, shopBannerBodyHead);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopBannerBody)) {
            return false;
        }
        ShopBannerBody shopBannerBody = (ShopBannerBody) obj;
        return Intrinsics.areEqual((Object) this.data, (Object) shopBannerBody.data) && Intrinsics.areEqual((Object) this.header, (Object) shopBannerBody.header);
    }

    public int hashCode() {
        List<ShopBannerBodyData> list = this.data;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        ShopBannerBodyHead shopBannerBodyHead = this.header;
        if (shopBannerBodyHead != null) {
            i = shopBannerBodyHead.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ShopBannerBody(data=" + this.data + ", header=" + this.header + ')';
    }

    public ShopBannerBody(List<ShopBannerBodyData> list, ShopBannerBodyHead shopBannerBodyHead) {
        this.data = list;
        this.header = shopBannerBodyHead;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopBannerBody(List list, ShopBannerBodyHead shopBannerBodyHead, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? new ShopBannerBodyHead((String) null, 1, (DefaultConstructorMarker) null) : shopBannerBodyHead);
    }

    public final List<ShopBannerBodyData> getData() {
        return this.data;
    }

    public final ShopBannerBodyHead getHeader() {
        return this.header;
    }
}
