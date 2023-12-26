package com.tal.app.thinkacademy.business.shop.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003JS\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006\""}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/CategoryTaxInfo;", "", "category", "", "fee", "feeName", "", "price", "skuId", "tax", "title", "(IILjava/lang/String;IIILjava/lang/String;)V", "getCategory", "()I", "getFee", "getFeeName", "()Ljava/lang/String;", "getPrice", "getSkuId", "getTax", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: QueryCategoryTaxInfoBean.kt */
public final class CategoryTaxInfo {
    private final int category;
    private final int fee;
    private final String feeName;
    private final int price;
    private final int skuId;
    private final int tax;
    private final String title;

    public CategoryTaxInfo() {
        this(0, 0, (String) null, 0, 0, 0, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CategoryTaxInfo copy$default(CategoryTaxInfo categoryTaxInfo, int i, int i2, String str, int i3, int i4, int i5, String str2, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = categoryTaxInfo.category;
        }
        if ((i6 & 2) != 0) {
            i2 = categoryTaxInfo.fee;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            str = categoryTaxInfo.feeName;
        }
        String str3 = str;
        if ((i6 & 8) != 0) {
            i3 = categoryTaxInfo.price;
        }
        int i8 = i3;
        if ((i6 & 16) != 0) {
            i4 = categoryTaxInfo.skuId;
        }
        int i9 = i4;
        if ((i6 & 32) != 0) {
            i5 = categoryTaxInfo.tax;
        }
        int i10 = i5;
        if ((i6 & 64) != 0) {
            str2 = categoryTaxInfo.title;
        }
        return categoryTaxInfo.copy(i, i7, str3, i8, i9, i10, str2);
    }

    public final int component1() {
        return this.category;
    }

    public final int component2() {
        return this.fee;
    }

    public final String component3() {
        return this.feeName;
    }

    public final int component4() {
        return this.price;
    }

    public final int component5() {
        return this.skuId;
    }

    public final int component6() {
        return this.tax;
    }

    public final String component7() {
        return this.title;
    }

    public final CategoryTaxInfo copy(int i, int i2, String str, int i3, int i4, int i5, String str2) {
        return new CategoryTaxInfo(i, i2, str, i3, i4, i5, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoryTaxInfo)) {
            return false;
        }
        CategoryTaxInfo categoryTaxInfo = (CategoryTaxInfo) obj;
        return this.category == categoryTaxInfo.category && this.fee == categoryTaxInfo.fee && Intrinsics.areEqual((Object) this.feeName, (Object) categoryTaxInfo.feeName) && this.price == categoryTaxInfo.price && this.skuId == categoryTaxInfo.skuId && this.tax == categoryTaxInfo.tax && Intrinsics.areEqual((Object) this.title, (Object) categoryTaxInfo.title);
    }

    public int hashCode() {
        int i = ((this.category * 31) + this.fee) * 31;
        String str = this.feeName;
        int i2 = 0;
        int hashCode = (((((((i + (str == null ? 0 : str.hashCode())) * 31) + this.price) * 31) + this.skuId) * 31) + this.tax) * 31;
        String str2 = this.title;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "CategoryTaxInfo(category=" + this.category + ", fee=" + this.fee + ", feeName=" + this.feeName + ", price=" + this.price + ", skuId=" + this.skuId + ", tax=" + this.tax + ", title=" + this.title + ')';
    }

    public CategoryTaxInfo(int i, int i2, String str, int i3, int i4, int i5, String str2) {
        this.category = i;
        this.fee = i2;
        this.feeName = str;
        this.price = i3;
        this.skuId = i4;
        this.tax = i5;
        this.title = str2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CategoryTaxInfo(int r6, int r7, java.lang.String r8, int r9, int r10, int r11, java.lang.String r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            r0 = 0
            if (r14 == 0) goto L_0x0007
            r14 = r0
            goto L_0x0008
        L_0x0007:
            r14 = r6
        L_0x0008:
            r6 = r13 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r13 & 4
            r7 = 0
            if (r6 == 0) goto L_0x0016
            r2 = r7
            goto L_0x0017
        L_0x0016:
            r2 = r8
        L_0x0017:
            r6 = r13 & 8
            if (r6 == 0) goto L_0x001d
            r3 = r0
            goto L_0x001e
        L_0x001d:
            r3 = r9
        L_0x001e:
            r6 = r13 & 16
            if (r6 == 0) goto L_0x0024
            r4 = r0
            goto L_0x0025
        L_0x0024:
            r4 = r10
        L_0x0025:
            r6 = r13 & 32
            if (r6 == 0) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            r0 = r11
        L_0x002b:
            r6 = r13 & 64
            if (r6 == 0) goto L_0x0031
            r13 = r7
            goto L_0x0032
        L_0x0031:
            r13 = r12
        L_0x0032:
            r6 = r5
            r7 = r14
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r12 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.CategoryTaxInfo.<init>(int, int, java.lang.String, int, int, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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

    public final int getPrice() {
        return this.price;
    }

    public final int getSkuId() {
        return this.skuId;
    }

    public final int getTax() {
        return this.tax;
    }

    public final String getTitle() {
        return this.title;
    }
}
