package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b/\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u00104\u001a\u00020\u00032\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0006HÖ\u0001J\t\u00107\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018¨\u00068"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/ShopClassDetailAttachedItem;", "", "required", "", "selected", "category", "", "fee", "feeName", "", "leftStore", "needPostAdd", "onSell", "orgPrice", "price", "skuId", "spuId", "tax", "title", "(ZZIILjava/lang/String;ZIZIIIIILjava/lang/String;)V", "getCategory", "()I", "getFee", "getFeeName", "()Ljava/lang/String;", "getLeftStore", "()Z", "getNeedPostAdd", "getOnSell", "getOrgPrice", "getPrice", "getRequired", "getSelected", "getSkuId", "getSpuId", "getTax", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopClassDetailInfoBean.kt */
public final class ShopClassDetailAttachedItem {
    private final int category;
    private final int fee;
    private final String feeName;
    private final boolean leftStore;
    private final int needPostAdd;
    private final boolean onSell;
    private final int orgPrice;
    private final int price;
    private final boolean required;
    private final boolean selected;
    private final int skuId;
    private final int spuId;
    private final int tax;
    private final String title;

    public ShopClassDetailAttachedItem() {
        this(false, false, 0, 0, (String) null, false, 0, false, 0, 0, 0, 0, 0, (String) null, 16383, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopClassDetailAttachedItem copy$default(ShopClassDetailAttachedItem shopClassDetailAttachedItem, boolean z, boolean z2, int i, int i2, String str, boolean z3, int i3, boolean z4, int i4, int i5, int i6, int i7, int i8, String str2, int i9, Object obj) {
        ShopClassDetailAttachedItem shopClassDetailAttachedItem2 = shopClassDetailAttachedItem;
        int i10 = i9;
        return shopClassDetailAttachedItem.copy((i10 & 1) != 0 ? shopClassDetailAttachedItem2.required : z, (i10 & 2) != 0 ? shopClassDetailAttachedItem2.selected : z2, (i10 & 4) != 0 ? shopClassDetailAttachedItem2.category : i, (i10 & 8) != 0 ? shopClassDetailAttachedItem2.fee : i2, (i10 & 16) != 0 ? shopClassDetailAttachedItem2.feeName : str, (i10 & 32) != 0 ? shopClassDetailAttachedItem2.leftStore : z3, (i10 & 64) != 0 ? shopClassDetailAttachedItem2.needPostAdd : i3, (i10 & 128) != 0 ? shopClassDetailAttachedItem2.onSell : z4, (i10 & 256) != 0 ? shopClassDetailAttachedItem2.orgPrice : i4, (i10 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? shopClassDetailAttachedItem2.price : i5, (i10 & 1024) != 0 ? shopClassDetailAttachedItem2.skuId : i6, (i10 & 2048) != 0 ? shopClassDetailAttachedItem2.spuId : i7, (i10 & ConstantsKt.DEFAULT_BLOCK_SIZE) != 0 ? shopClassDetailAttachedItem2.tax : i8, (i10 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? shopClassDetailAttachedItem2.title : str2);
    }

    public final boolean component1() {
        return this.required;
    }

    public final int component10() {
        return this.price;
    }

    public final int component11() {
        return this.skuId;
    }

    public final int component12() {
        return this.spuId;
    }

    public final int component13() {
        return this.tax;
    }

    public final String component14() {
        return this.title;
    }

    public final boolean component2() {
        return this.selected;
    }

    public final int component3() {
        return this.category;
    }

    public final int component4() {
        return this.fee;
    }

    public final String component5() {
        return this.feeName;
    }

    public final boolean component6() {
        return this.leftStore;
    }

    public final int component7() {
        return this.needPostAdd;
    }

    public final boolean component8() {
        return this.onSell;
    }

    public final int component9() {
        return this.orgPrice;
    }

    public final ShopClassDetailAttachedItem copy(boolean z, boolean z2, int i, int i2, String str, boolean z3, int i3, boolean z4, int i4, int i5, int i6, int i7, int i8, String str2) {
        return new ShopClassDetailAttachedItem(z, z2, i, i2, str, z3, i3, z4, i4, i5, i6, i7, i8, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopClassDetailAttachedItem)) {
            return false;
        }
        ShopClassDetailAttachedItem shopClassDetailAttachedItem = (ShopClassDetailAttachedItem) obj;
        return this.required == shopClassDetailAttachedItem.required && this.selected == shopClassDetailAttachedItem.selected && this.category == shopClassDetailAttachedItem.category && this.fee == shopClassDetailAttachedItem.fee && Intrinsics.areEqual((Object) this.feeName, (Object) shopClassDetailAttachedItem.feeName) && this.leftStore == shopClassDetailAttachedItem.leftStore && this.needPostAdd == shopClassDetailAttachedItem.needPostAdd && this.onSell == shopClassDetailAttachedItem.onSell && this.orgPrice == shopClassDetailAttachedItem.orgPrice && this.price == shopClassDetailAttachedItem.price && this.skuId == shopClassDetailAttachedItem.skuId && this.spuId == shopClassDetailAttachedItem.spuId && this.tax == shopClassDetailAttachedItem.tax && Intrinsics.areEqual((Object) this.title, (Object) shopClassDetailAttachedItem.title);
    }

    public int hashCode() {
        boolean z = this.required;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.selected;
        if (z3) {
            z3 = true;
        }
        int i2 = (((((i + (z3 ? 1 : 0)) * 31) + this.category) * 31) + this.fee) * 31;
        String str = this.feeName;
        int i3 = 0;
        int hashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        boolean z4 = this.leftStore;
        if (z4) {
            z4 = true;
        }
        int i4 = (((hashCode + (z4 ? 1 : 0)) * 31) + this.needPostAdd) * 31;
        boolean z5 = this.onSell;
        if (!z5) {
            z2 = z5;
        }
        int i5 = (((((((((((i4 + (z2 ? 1 : 0)) * 31) + this.orgPrice) * 31) + this.price) * 31) + this.skuId) * 31) + this.spuId) * 31) + this.tax) * 31;
        String str2 = this.title;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i5 + i3;
    }

    public String toString() {
        return "ShopClassDetailAttachedItem(required=" + this.required + ", selected=" + this.selected + ", category=" + this.category + ", fee=" + this.fee + ", feeName=" + this.feeName + ", leftStore=" + this.leftStore + ", needPostAdd=" + this.needPostAdd + ", onSell=" + this.onSell + ", orgPrice=" + this.orgPrice + ", price=" + this.price + ", skuId=" + this.skuId + ", spuId=" + this.spuId + ", tax=" + this.tax + ", title=" + this.title + ')';
    }

    public ShopClassDetailAttachedItem(boolean z, boolean z2, int i, int i2, String str, boolean z3, int i3, boolean z4, int i4, int i5, int i6, int i7, int i8, String str2) {
        this.required = z;
        this.selected = z2;
        this.category = i;
        this.fee = i2;
        this.feeName = str;
        this.leftStore = z3;
        this.needPostAdd = i3;
        this.onSell = z4;
        this.orgPrice = i4;
        this.price = i5;
        this.skuId = i6;
        this.spuId = i7;
        this.tax = i8;
        this.title = str2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShopClassDetailAttachedItem(boolean r17, boolean r18, int r19, int r20, java.lang.String r21, boolean r22, int r23, boolean r24, int r25, int r26, int r27, int r28, int r29, java.lang.String r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r16 = this;
            r0 = r31
            r1 = r0 & 1
            r2 = 1
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r2 = r18
        L_0x0012:
            r3 = r0 & 4
            r4 = 0
            if (r3 == 0) goto L_0x0019
            r3 = r4
            goto L_0x001b
        L_0x0019:
            r3 = r19
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = r4
            goto L_0x0023
        L_0x0021:
            r5 = r20
        L_0x0023:
            r6 = r0 & 16
            r7 = 0
            if (r6 == 0) goto L_0x002a
            r6 = r7
            goto L_0x002c
        L_0x002a:
            r6 = r21
        L_0x002c:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0032
            r8 = r4
            goto L_0x0034
        L_0x0032:
            r8 = r22
        L_0x0034:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003a
            r9 = r4
            goto L_0x003c
        L_0x003a:
            r9 = r23
        L_0x003c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0042
            r10 = r4
            goto L_0x0044
        L_0x0042:
            r10 = r24
        L_0x0044:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004a
            r11 = r4
            goto L_0x004c
        L_0x004a:
            r11 = r25
        L_0x004c:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0052
            r12 = r4
            goto L_0x0054
        L_0x0052:
            r12 = r26
        L_0x0054:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005a
            r13 = r4
            goto L_0x005c
        L_0x005a:
            r13 = r27
        L_0x005c:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0062
            r14 = r4
            goto L_0x0064
        L_0x0062:
            r14 = r28
        L_0x0064:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r4 = r29
        L_0x006b:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r7 = r30
        L_0x0072:
            r17 = r16
            r18 = r1
            r19 = r2
            r20 = r3
            r21 = r5
            r22 = r6
            r23 = r8
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
            r28 = r13
            r29 = r14
            r30 = r4
            r31 = r7
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.ShopClassDetailAttachedItem.<init>(boolean, boolean, int, int, java.lang.String, boolean, int, boolean, int, int, int, int, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean getRequired() {
        return this.required;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final int getCategory() {
        return this.category;
    }

    public final int getFee() {
        return this.fee;
    }

    public final String getFeeName() {
        return this.feeName;
    }

    public final boolean getLeftStore() {
        return this.leftStore;
    }

    public final int getNeedPostAdd() {
        return this.needPostAdd;
    }

    public final boolean getOnSell() {
        return this.onSell;
    }

    public final int getOrgPrice() {
        return this.orgPrice;
    }

    public final int getPrice() {
        return this.price;
    }

    public final int getSkuId() {
        return this.skuId;
    }

    public final int getSpuId() {
        return this.spuId;
    }

    public final int getTax() {
        return this.tax;
    }

    public final String getTitle() {
        return this.title;
    }
}
