package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J[\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailActivityInfo;", "", "activityId", "", "activityParam", "", "activityType", "groupSize", "packagePrice", "sellPrice", "showPrice", "singleSellPrice", "(ILjava/lang/String;IIIIII)V", "getActivityId", "()I", "getActivityParam", "()Ljava/lang/String;", "getActivityType", "getGroupSize", "getPackagePrice", "getSellPrice", "getShowPrice", "getSingleSellPrice", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailInfoBean.kt */
public final class ShopClassDetailActivityInfo {
    private final int activityId;
    private final String activityParam;
    private final int activityType;
    private final int groupSize;
    private final int packagePrice;
    private final int sellPrice;
    private final int showPrice;
    private final int singleSellPrice;

    public ShopClassDetailActivityInfo() {
        this(0, (String) null, 0, 0, 0, 0, 0, 0, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopClassDetailActivityInfo copy$default(ShopClassDetailActivityInfo shopClassDetailActivityInfo, int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Object obj) {
        ShopClassDetailActivityInfo shopClassDetailActivityInfo2 = shopClassDetailActivityInfo;
        int i9 = i8;
        return shopClassDetailActivityInfo.copy((i9 & 1) != 0 ? shopClassDetailActivityInfo2.activityId : i, (i9 & 2) != 0 ? shopClassDetailActivityInfo2.activityParam : str, (i9 & 4) != 0 ? shopClassDetailActivityInfo2.activityType : i2, (i9 & 8) != 0 ? shopClassDetailActivityInfo2.groupSize : i3, (i9 & 16) != 0 ? shopClassDetailActivityInfo2.packagePrice : i4, (i9 & 32) != 0 ? shopClassDetailActivityInfo2.sellPrice : i5, (i9 & 64) != 0 ? shopClassDetailActivityInfo2.showPrice : i6, (i9 & 128) != 0 ? shopClassDetailActivityInfo2.singleSellPrice : i7);
    }

    public final int component1() {
        return this.activityId;
    }

    public final String component2() {
        return this.activityParam;
    }

    public final int component3() {
        return this.activityType;
    }

    public final int component4() {
        return this.groupSize;
    }

    public final int component5() {
        return this.packagePrice;
    }

    public final int component6() {
        return this.sellPrice;
    }

    public final int component7() {
        return this.showPrice;
    }

    public final int component8() {
        return this.singleSellPrice;
    }

    public final ShopClassDetailActivityInfo copy(int i, String str, int i2, int i3, int i4, int i5, int i6, int i7) {
        return new ShopClassDetailActivityInfo(i, str, i2, i3, i4, i5, i6, i7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopClassDetailActivityInfo)) {
            return false;
        }
        ShopClassDetailActivityInfo shopClassDetailActivityInfo = (ShopClassDetailActivityInfo) obj;
        return this.activityId == shopClassDetailActivityInfo.activityId && Intrinsics.areEqual((Object) this.activityParam, (Object) shopClassDetailActivityInfo.activityParam) && this.activityType == shopClassDetailActivityInfo.activityType && this.groupSize == shopClassDetailActivityInfo.groupSize && this.packagePrice == shopClassDetailActivityInfo.packagePrice && this.sellPrice == shopClassDetailActivityInfo.sellPrice && this.showPrice == shopClassDetailActivityInfo.showPrice && this.singleSellPrice == shopClassDetailActivityInfo.singleSellPrice;
    }

    public int hashCode() {
        int i = this.activityId * 31;
        String str = this.activityParam;
        return ((((((((((((i + (str == null ? 0 : str.hashCode())) * 31) + this.activityType) * 31) + this.groupSize) * 31) + this.packagePrice) * 31) + this.sellPrice) * 31) + this.showPrice) * 31) + this.singleSellPrice;
    }

    public String toString() {
        return "ShopClassDetailActivityInfo(activityId=" + this.activityId + ", activityParam=" + this.activityParam + ", activityType=" + this.activityType + ", groupSize=" + this.groupSize + ", packagePrice=" + this.packagePrice + ", sellPrice=" + this.sellPrice + ", showPrice=" + this.showPrice + ", singleSellPrice=" + this.singleSellPrice + ')';
    }

    public ShopClassDetailActivityInfo(int i, String str, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.activityId = i;
        this.activityParam = str;
        this.activityType = i2;
        this.groupSize = i3;
        this.packagePrice = i4;
        this.sellPrice = i5;
        this.showPrice = i6;
        this.singleSellPrice = i7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShopClassDetailActivityInfo(int r10, java.lang.String r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r17
        L_0x003c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailActivityInfo.<init>(int, java.lang.String, int, int, int, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getActivityId() {
        return this.activityId;
    }

    public final String getActivityParam() {
        return this.activityParam;
    }

    public final int getActivityType() {
        return this.activityType;
    }

    public final int getGroupSize() {
        return this.groupSize;
    }

    public final int getPackagePrice() {
        return this.packagePrice;
    }

    public final int getSellPrice() {
        return this.sellPrice;
    }

    public final int getShowPrice() {
        return this.showPrice;
    }

    public final int getSingleSellPrice() {
        return this.singleSellPrice;
    }
}
