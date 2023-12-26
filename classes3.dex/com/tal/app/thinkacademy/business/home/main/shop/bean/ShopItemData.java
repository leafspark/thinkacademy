package com.tal.app.thinkacademy.business.home.main.shop.bean;

import com.tal.app.thinkacademy.business.shop.bean.ShopItemRecordedGoodsCardNode;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\rJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jh\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\tHÖ\u0001J\t\u0010*\u001a\u00020\u0006HÖ\u0001R\u001b\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0019\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012¨\u0006+"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopItemData;", "Lcom/tal/app/thinkacademy/business/shop/bean/ShopItemRecordedGoodsCardNode;", "id", "", "banners", "", "", "title", "showOrgPrice", "", "showPrice", "categoryType", "categoryName", "(Ljava/lang/Long;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getBanners", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getCategoryName", "()Ljava/lang/String;", "getCategoryType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getShowOrgPrice", "getShowPrice", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopItemData;", "equals", "", "other", "", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopGeneralShopData.kt */
public final class ShopItemData extends ShopItemRecordedGoodsCardNode {
    private final String[] banners;
    private final String categoryName;
    private final Integer categoryType;
    private final Long id;
    private final Integer showOrgPrice;
    private final Integer showPrice;
    private final String title;

    public ShopItemData() {
        this((Long) null, (String[]) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopItemData copy$default(ShopItemData shopItemData, Long l, String[] strArr, String str, Integer num, Integer num2, Integer num3, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = shopItemData.id;
        }
        if ((i & 2) != 0) {
            strArr = shopItemData.banners;
        }
        String[] strArr2 = strArr;
        if ((i & 4) != 0) {
            str = shopItemData.title;
        }
        String str3 = str;
        if ((i & 8) != 0) {
            num = shopItemData.showOrgPrice;
        }
        Integer num4 = num;
        if ((i & 16) != 0) {
            num2 = shopItemData.showPrice;
        }
        Integer num5 = num2;
        if ((i & 32) != 0) {
            num3 = shopItemData.categoryType;
        }
        Integer num6 = num3;
        if ((i & 64) != 0) {
            str2 = shopItemData.categoryName;
        }
        return shopItemData.copy(l, strArr2, str3, num4, num5, num6, str2);
    }

    public final Long component1() {
        return this.id;
    }

    public final String[] component2() {
        return this.banners;
    }

    public final String component3() {
        return this.title;
    }

    public final Integer component4() {
        return this.showOrgPrice;
    }

    public final Integer component5() {
        return this.showPrice;
    }

    public final Integer component6() {
        return this.categoryType;
    }

    public final String component7() {
        return this.categoryName;
    }

    public final ShopItemData copy(Long l, String[] strArr, String str, Integer num, Integer num2, Integer num3, String str2) {
        return new ShopItemData(l, strArr, str, num, num2, num3, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopItemData)) {
            return false;
        }
        ShopItemData shopItemData = (ShopItemData) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) shopItemData.id) && Intrinsics.areEqual((Object) this.banners, (Object) shopItemData.banners) && Intrinsics.areEqual((Object) this.title, (Object) shopItemData.title) && Intrinsics.areEqual((Object) this.showOrgPrice, (Object) shopItemData.showOrgPrice) && Intrinsics.areEqual((Object) this.showPrice, (Object) shopItemData.showPrice) && Intrinsics.areEqual((Object) this.categoryType, (Object) shopItemData.categoryType) && Intrinsics.areEqual((Object) this.categoryName, (Object) shopItemData.categoryName);
    }

    public int hashCode() {
        Long l = this.id;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String[] strArr = this.banners;
        int hashCode2 = (hashCode + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        String str = this.title;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.showOrgPrice;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.showPrice;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.categoryType;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str2 = this.categoryName;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "ShopItemData(id=" + this.id + ", banners=" + Arrays.toString(this.banners) + ", title=" + this.title + ", showOrgPrice=" + this.showOrgPrice + ", showPrice=" + this.showPrice + ", categoryType=" + this.categoryType + ", categoryName=" + this.categoryName + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShopItemData(java.lang.Long r6, java.lang.String[] r7, java.lang.String r8, java.lang.Integer r9, java.lang.Integer r10, java.lang.Integer r11, java.lang.String r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x000a
            r0 = 0
            java.lang.Long r6 = java.lang.Long.valueOf(r0)
        L_0x000a:
            r14 = r13 & 2
            r0 = 0
            if (r14 == 0) goto L_0x0015
            java.lang.String[] r7 = new java.lang.String[r0]
            java.lang.Object[] r7 = (java.lang.Object[]) r7
            java.lang.String[] r7 = (java.lang.String[]) r7
        L_0x0015:
            r14 = r7
            r7 = r13 & 4
            java.lang.String r1 = ""
            if (r7 == 0) goto L_0x001e
            r2 = r1
            goto L_0x001f
        L_0x001e:
            r2 = r8
        L_0x001f:
            r7 = r13 & 8
            if (r7 == 0) goto L_0x0027
            java.lang.Integer r9 = java.lang.Integer.valueOf(r0)
        L_0x0027:
            r3 = r9
            r7 = r13 & 16
            if (r7 == 0) goto L_0x0030
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)
        L_0x0030:
            r0 = r10
            r7 = r13 & 32
            if (r7 == 0) goto L_0x003a
            r7 = 2
            java.lang.Integer r11 = java.lang.Integer.valueOf(r7)
        L_0x003a:
            r4 = r11
            r7 = r13 & 64
            if (r7 == 0) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r1 = r12
        L_0x0041:
            r7 = r5
            r8 = r6
            r9 = r14
            r10 = r2
            r11 = r3
            r12 = r0
            r13 = r4
            r14 = r1
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.bean.ShopItemData.<init>(java.lang.Long, java.lang.String[], java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Long getId() {
        return this.id;
    }

    public final String[] getBanners() {
        return this.banners;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getShowOrgPrice() {
        return this.showOrgPrice;
    }

    public final Integer getShowPrice() {
        return this.showPrice;
    }

    public final Integer getCategoryType() {
        return this.categoryType;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public ShopItemData(Long l, String[] strArr, String str, Integer num, Integer num2, Integer num3, String str2) {
        super((List) null, 1, (DefaultConstructorMarker) null);
        this.id = l;
        this.banners = strArr;
        this.title = str;
        this.showOrgPrice = num;
        this.showPrice = num2;
        this.categoryType = num3;
        this.categoryName = str2;
    }
}
