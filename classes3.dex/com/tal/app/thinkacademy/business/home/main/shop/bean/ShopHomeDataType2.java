package com.tal.app.thinkacademy.business.home.main.shop.bean;

import com.tal.app.thinkacademy.business.shop.bean.ShopClassGoodsData;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003JD\u0010\u0017\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeDataType2;", "", "clazzList", "", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassGoodsData;", "content", "", "showMore", "", "title", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getClazzList", "()Ljava/util/List;", "getContent", "()Ljava/lang/String;", "getShowMore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTitle", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeDataType2;", "equals", "other", "hashCode", "", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeDataType2.kt */
public final class ShopHomeDataType2 {
    private final List<ShopClassGoodsData> clazzList;
    private final String content;
    private final Boolean showMore;
    private final String title;

    public ShopHomeDataType2() {
        this((List) null, (String) null, (Boolean) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopHomeDataType2 copy$default(ShopHomeDataType2 shopHomeDataType2, List<ShopClassGoodsData> list, String str, Boolean bool, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = shopHomeDataType2.clazzList;
        }
        if ((i & 2) != 0) {
            str = shopHomeDataType2.content;
        }
        if ((i & 4) != 0) {
            bool = shopHomeDataType2.showMore;
        }
        if ((i & 8) != 0) {
            str2 = shopHomeDataType2.title;
        }
        return shopHomeDataType2.copy(list, str, bool, str2);
    }

    public final List<ShopClassGoodsData> component1() {
        return this.clazzList;
    }

    public final String component2() {
        return this.content;
    }

    public final Boolean component3() {
        return this.showMore;
    }

    public final String component4() {
        return this.title;
    }

    public final ShopHomeDataType2 copy(List<ShopClassGoodsData> list, String str, Boolean bool, String str2) {
        return new ShopHomeDataType2(list, str, bool, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopHomeDataType2)) {
            return false;
        }
        ShopHomeDataType2 shopHomeDataType2 = (ShopHomeDataType2) obj;
        return Intrinsics.areEqual((Object) this.clazzList, (Object) shopHomeDataType2.clazzList) && Intrinsics.areEqual((Object) this.content, (Object) shopHomeDataType2.content) && Intrinsics.areEqual((Object) this.showMore, (Object) shopHomeDataType2.showMore) && Intrinsics.areEqual((Object) this.title, (Object) shopHomeDataType2.title);
    }

    public int hashCode() {
        List<ShopClassGoodsData> list = this.clazzList;
        int i = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.content;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.showMore;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.title;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ShopHomeDataType2(clazzList=" + this.clazzList + ", content=" + this.content + ", showMore=" + this.showMore + ", title=" + this.title + ')';
    }

    public ShopHomeDataType2(List<ShopClassGoodsData> list, String str, Boolean bool, String str2) {
        this.clazzList = list;
        this.content = str;
        this.showMore = bool;
        this.title = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShopHomeDataType2(List list, String str, Boolean bool, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? false : bool, (i & 8) != 0 ? "" : str2);
    }

    public final List<ShopClassGoodsData> getClazzList() {
        return this.clazzList;
    }

    public final String getContent() {
        return this.content;
    }

    public final Boolean getShowMore() {
        return this.showMore;
    }

    public final String getTitle() {
        return this.title;
    }
}
