package com.tal.app.thinkacademy.business.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B©\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J­\u0001\u00106\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0006HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017¨\u0006<"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/CouponRecommendUseCouponInfo;", "", "categoryName", "", "description", "discount", "", "effectEnd", "effectStart", "feeName", "goodsCategoryId", "id", "name", "products", "", "Lcom/tal/app/thinkacademy/business/shop/bean/CouponRecommendProduct;", "style", "typeFields", "Lcom/tal/app/thinkacademy/business/shop/bean/CouponRecommendTypeFields;", "typeId", "typeName", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/util/List;ILcom/tal/app/thinkacademy/business/shop/bean/CouponRecommendTypeFields;ILjava/lang/String;)V", "getCategoryName", "()Ljava/lang/String;", "getDescription", "getDiscount", "()I", "getEffectEnd", "getEffectStart", "getFeeName", "getGoodsCategoryId", "getId", "getName", "getProducts", "()Ljava/util/List;", "getStyle", "getTypeFields", "()Lcom/tal/app/thinkacademy/business/shop/bean/CouponRecommendTypeFields;", "getTypeId", "getTypeName", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopCouponRecommendBean.kt */
public final class CouponRecommendUseCouponInfo {
    private final String categoryName;
    private final String description;
    private final int discount;
    private final String effectEnd;
    private final String effectStart;
    private final String feeName;
    private final int goodsCategoryId;
    private final int id;
    private final String name;
    private final List<CouponRecommendProduct> products;
    private final int style;
    private final CouponRecommendTypeFields typeFields;
    private final int typeId;
    private final String typeName;

    public CouponRecommendUseCouponInfo() {
        this((String) null, (String) null, 0, (String) null, (String) null, (String) null, 0, 0, (String) null, (List) null, 0, (CouponRecommendTypeFields) null, 0, (String) null, 16383, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CouponRecommendUseCouponInfo copy$default(CouponRecommendUseCouponInfo couponRecommendUseCouponInfo, String str, String str2, int i, String str3, String str4, String str5, int i2, int i3, String str6, List list, int i4, CouponRecommendTypeFields couponRecommendTypeFields, int i5, String str7, int i6, Object obj) {
        CouponRecommendUseCouponInfo couponRecommendUseCouponInfo2 = couponRecommendUseCouponInfo;
        int i7 = i6;
        return couponRecommendUseCouponInfo.copy((i7 & 1) != 0 ? couponRecommendUseCouponInfo2.categoryName : str, (i7 & 2) != 0 ? couponRecommendUseCouponInfo2.description : str2, (i7 & 4) != 0 ? couponRecommendUseCouponInfo2.discount : i, (i7 & 8) != 0 ? couponRecommendUseCouponInfo2.effectEnd : str3, (i7 & 16) != 0 ? couponRecommendUseCouponInfo2.effectStart : str4, (i7 & 32) != 0 ? couponRecommendUseCouponInfo2.feeName : str5, (i7 & 64) != 0 ? couponRecommendUseCouponInfo2.goodsCategoryId : i2, (i7 & 128) != 0 ? couponRecommendUseCouponInfo2.id : i3, (i7 & 256) != 0 ? couponRecommendUseCouponInfo2.name : str6, (i7 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? couponRecommendUseCouponInfo2.products : list, (i7 & 1024) != 0 ? couponRecommendUseCouponInfo2.style : i4, (i7 & 2048) != 0 ? couponRecommendUseCouponInfo2.typeFields : couponRecommendTypeFields, (i7 & ConstantsKt.DEFAULT_BLOCK_SIZE) != 0 ? couponRecommendUseCouponInfo2.typeId : i5, (i7 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? couponRecommendUseCouponInfo2.typeName : str7);
    }

    public final String component1() {
        return this.categoryName;
    }

    public final List<CouponRecommendProduct> component10() {
        return this.products;
    }

    public final int component11() {
        return this.style;
    }

    public final CouponRecommendTypeFields component12() {
        return this.typeFields;
    }

    public final int component13() {
        return this.typeId;
    }

    public final String component14() {
        return this.typeName;
    }

    public final String component2() {
        return this.description;
    }

    public final int component3() {
        return this.discount;
    }

    public final String component4() {
        return this.effectEnd;
    }

    public final String component5() {
        return this.effectStart;
    }

    public final String component6() {
        return this.feeName;
    }

    public final int component7() {
        return this.goodsCategoryId;
    }

    public final int component8() {
        return this.id;
    }

    public final String component9() {
        return this.name;
    }

    public final CouponRecommendUseCouponInfo copy(String str, String str2, int i, String str3, String str4, String str5, int i2, int i3, String str6, List<CouponRecommendProduct> list, int i4, CouponRecommendTypeFields couponRecommendTypeFields, int i5, String str7) {
        return new CouponRecommendUseCouponInfo(str, str2, i, str3, str4, str5, i2, i3, str6, list, i4, couponRecommendTypeFields, i5, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CouponRecommendUseCouponInfo)) {
            return false;
        }
        CouponRecommendUseCouponInfo couponRecommendUseCouponInfo = (CouponRecommendUseCouponInfo) obj;
        return Intrinsics.areEqual((Object) this.categoryName, (Object) couponRecommendUseCouponInfo.categoryName) && Intrinsics.areEqual((Object) this.description, (Object) couponRecommendUseCouponInfo.description) && this.discount == couponRecommendUseCouponInfo.discount && Intrinsics.areEqual((Object) this.effectEnd, (Object) couponRecommendUseCouponInfo.effectEnd) && Intrinsics.areEqual((Object) this.effectStart, (Object) couponRecommendUseCouponInfo.effectStart) && Intrinsics.areEqual((Object) this.feeName, (Object) couponRecommendUseCouponInfo.feeName) && this.goodsCategoryId == couponRecommendUseCouponInfo.goodsCategoryId && this.id == couponRecommendUseCouponInfo.id && Intrinsics.areEqual((Object) this.name, (Object) couponRecommendUseCouponInfo.name) && Intrinsics.areEqual((Object) this.products, (Object) couponRecommendUseCouponInfo.products) && this.style == couponRecommendUseCouponInfo.style && Intrinsics.areEqual((Object) this.typeFields, (Object) couponRecommendUseCouponInfo.typeFields) && this.typeId == couponRecommendUseCouponInfo.typeId && Intrinsics.areEqual((Object) this.typeName, (Object) couponRecommendUseCouponInfo.typeName);
    }

    public int hashCode() {
        String str = this.categoryName;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.discount) * 31;
        String str3 = this.effectEnd;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.effectStart;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.feeName;
        int hashCode5 = (((((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.goodsCategoryId) * 31) + this.id) * 31;
        String str6 = this.name;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<CouponRecommendProduct> list = this.products;
        int hashCode7 = (((hashCode6 + (list == null ? 0 : list.hashCode())) * 31) + this.style) * 31;
        CouponRecommendTypeFields couponRecommendTypeFields = this.typeFields;
        int hashCode8 = (((hashCode7 + (couponRecommendTypeFields == null ? 0 : couponRecommendTypeFields.hashCode())) * 31) + this.typeId) * 31;
        String str7 = this.typeName;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode8 + i;
    }

    public String toString() {
        return "CouponRecommendUseCouponInfo(categoryName=" + this.categoryName + ", description=" + this.description + ", discount=" + this.discount + ", effectEnd=" + this.effectEnd + ", effectStart=" + this.effectStart + ", feeName=" + this.feeName + ", goodsCategoryId=" + this.goodsCategoryId + ", id=" + this.id + ", name=" + this.name + ", products=" + this.products + ", style=" + this.style + ", typeFields=" + this.typeFields + ", typeId=" + this.typeId + ", typeName=" + this.typeName + ')';
    }

    public CouponRecommendUseCouponInfo(String str, String str2, int i, String str3, String str4, String str5, int i2, int i3, String str6, List<CouponRecommendProduct> list, int i4, CouponRecommendTypeFields couponRecommendTypeFields, int i5, String str7) {
        this.categoryName = str;
        this.description = str2;
        this.discount = i;
        this.effectEnd = str3;
        this.effectStart = str4;
        this.feeName = str5;
        this.goodsCategoryId = i2;
        this.id = i3;
        this.name = str6;
        this.products = list;
        this.style = i4;
        this.typeFields = couponRecommendTypeFields;
        this.typeId = i5;
        this.typeName = str7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CouponRecommendUseCouponInfo(java.lang.String r17, java.lang.String r18, int r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, int r23, int r24, java.lang.String r25, java.util.List r26, int r27, com.tal.app.thinkacademy.business.shop.bean.CouponRecommendTypeFields r28, int r29, java.lang.String r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r16 = this;
            r0 = r31
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = r2
            goto L_0x0013
        L_0x0011:
            r3 = r18
        L_0x0013:
            r4 = r0 & 4
            r5 = 0
            if (r4 == 0) goto L_0x001a
            r4 = r5
            goto L_0x001c
        L_0x001a:
            r4 = r19
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0022
            r6 = r2
            goto L_0x0024
        L_0x0022:
            r6 = r20
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002a
            r7 = r2
            goto L_0x002c
        L_0x002a:
            r7 = r21
        L_0x002c:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0032
            r8 = r2
            goto L_0x0034
        L_0x0032:
            r8 = r22
        L_0x0034:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003a
            r9 = r5
            goto L_0x003c
        L_0x003a:
            r9 = r23
        L_0x003c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0042
            r10 = r5
            goto L_0x0044
        L_0x0042:
            r10 = r24
        L_0x0044:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004a
            r11 = r2
            goto L_0x004c
        L_0x004a:
            r11 = r25
        L_0x004c:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0052
            r12 = r2
            goto L_0x0054
        L_0x0052:
            r12 = r26
        L_0x0054:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005a
            r13 = r5
            goto L_0x005c
        L_0x005a:
            r13 = r27
        L_0x005c:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0062
            r14 = r2
            goto L_0x0064
        L_0x0062:
            r14 = r28
        L_0x0064:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r5 = r29
        L_0x006b:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r2 = r30
        L_0x0072:
            r17 = r16
            r18 = r1
            r19 = r3
            r20 = r4
            r21 = r6
            r22 = r7
            r23 = r8
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
            r28 = r13
            r29 = r14
            r30 = r5
            r31 = r2
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.CouponRecommendUseCouponInfo.<init>(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, int, int, java.lang.String, java.util.List, int, com.tal.app.thinkacademy.business.shop.bean.CouponRecommendTypeFields, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getDiscount() {
        return this.discount;
    }

    public final String getEffectEnd() {
        return this.effectEnd;
    }

    public final String getEffectStart() {
        return this.effectStart;
    }

    public final String getFeeName() {
        return this.feeName;
    }

    public final int getGoodsCategoryId() {
        return this.goodsCategoryId;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<CouponRecommendProduct> getProducts() {
        return this.products;
    }

    public final int getStyle() {
        return this.style;
    }

    public final CouponRecommendTypeFields getTypeFields() {
        return this.typeFields;
    }

    public final int getTypeId() {
        return this.typeId;
    }

    public final String getTypeName() {
        return this.typeName;
    }
}
