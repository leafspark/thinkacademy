package com.tal.app.thinkacademy.business.home.main.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003JD\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopGeneralShopData;", "", "title", "", "content", "sortType", "", "skuList", "", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopItemData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)V", "getContent", "()Ljava/lang/String;", "getSkuList", "()Ljava/util/List;", "getSortType", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTitle", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopGeneralShopData;", "equals", "", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopGeneralShopData.kt */
public final class ShopGeneralShopData {
    private final String content;
    private final List<ShopItemData> skuList;
    private final Long sortType;
    private final String title;

    public ShopGeneralShopData() {
        this((String) null, (String) null, (Long) null, (List) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopGeneralShopData copy$default(ShopGeneralShopData shopGeneralShopData, String str, String str2, Long l, List<ShopItemData> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shopGeneralShopData.title;
        }
        if ((i & 2) != 0) {
            str2 = shopGeneralShopData.content;
        }
        if ((i & 4) != 0) {
            l = shopGeneralShopData.sortType;
        }
        if ((i & 8) != 0) {
            list = shopGeneralShopData.skuList;
        }
        return shopGeneralShopData.copy(str, str2, l, list);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.content;
    }

    public final Long component3() {
        return this.sortType;
    }

    public final List<ShopItemData> component4() {
        return this.skuList;
    }

    public final ShopGeneralShopData copy(String str, String str2, Long l, List<ShopItemData> list) {
        return new ShopGeneralShopData(str, str2, l, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopGeneralShopData)) {
            return false;
        }
        ShopGeneralShopData shopGeneralShopData = (ShopGeneralShopData) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) shopGeneralShopData.title) && Intrinsics.areEqual((Object) this.content, (Object) shopGeneralShopData.content) && Intrinsics.areEqual((Object) this.sortType, (Object) shopGeneralShopData.sortType) && Intrinsics.areEqual((Object) this.skuList, (Object) shopGeneralShopData.skuList);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.content;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.sortType;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        List<ShopItemData> list = this.skuList;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ShopGeneralShopData(title=" + this.title + ", content=" + this.content + ", sortType=" + this.sortType + ", skuList=" + this.skuList + ')';
    }

    public ShopGeneralShopData(String str, String str2, Long l, List<ShopItemData> list) {
        this.title = str;
        this.content = str2;
        this.sortType = l;
        this.skuList = list;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopGeneralShopData(String str, String str2, Long l, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? 0L : l, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final Long getSortType() {
        return this.sortType;
    }

    public final List<ShopItemData> getSkuList() {
        return this.skuList;
    }
}
