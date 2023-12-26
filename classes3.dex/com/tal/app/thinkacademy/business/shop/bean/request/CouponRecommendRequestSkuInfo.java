package com.tal.app.thinkacademy.business.shop.bean.request;

import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u0003HÖ\u0001J\t\u00102\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001b¨\u00063"}, d2 = {"Lcom/tal/app/thinkacademy/business/shop/bean/request/CouponRecommendRequestSkuInfo;", "", "clazzId", "", "courseId", "courseType", "goodsCategoryId", "gradeIds", "", "levelDegreeId", "platformType", "", "skuId", "subPlatformType", "subjectId", "term", "year", "(IIIILjava/util/List;ILjava/lang/String;IIIILjava/lang/String;)V", "getClazzId", "()I", "getCourseId", "getCourseType", "getGoodsCategoryId", "getGradeIds", "()Ljava/util/List;", "getLevelDegreeId", "getPlatformType", "()Ljava/lang/String;", "getSkuId", "getSubPlatformType", "getSubjectId", "getTerm", "getYear", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CouponRecommendRequest.kt */
public final class CouponRecommendRequestSkuInfo {
    private final int clazzId;
    private final int courseId;
    private final int courseType;
    private final int goodsCategoryId;
    private final List<Integer> gradeIds;
    private final int levelDegreeId;
    private final String platformType;
    private final int skuId;
    private final int subPlatformType;
    private final int subjectId;
    private final int term;
    private final String year;

    public CouponRecommendRequestSkuInfo() {
        this(0, 0, 0, 0, (List) null, 0, (String) null, 0, 0, 0, 0, (String) null, 4095, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CouponRecommendRequestSkuInfo copy$default(CouponRecommendRequestSkuInfo couponRecommendRequestSkuInfo, int i, int i2, int i3, int i4, List list, int i5, String str, int i6, int i7, int i8, int i9, String str2, int i10, Object obj) {
        CouponRecommendRequestSkuInfo couponRecommendRequestSkuInfo2 = couponRecommendRequestSkuInfo;
        int i11 = i10;
        return couponRecommendRequestSkuInfo.copy((i11 & 1) != 0 ? couponRecommendRequestSkuInfo2.clazzId : i, (i11 & 2) != 0 ? couponRecommendRequestSkuInfo2.courseId : i2, (i11 & 4) != 0 ? couponRecommendRequestSkuInfo2.courseType : i3, (i11 & 8) != 0 ? couponRecommendRequestSkuInfo2.goodsCategoryId : i4, (i11 & 16) != 0 ? couponRecommendRequestSkuInfo2.gradeIds : list, (i11 & 32) != 0 ? couponRecommendRequestSkuInfo2.levelDegreeId : i5, (i11 & 64) != 0 ? couponRecommendRequestSkuInfo2.platformType : str, (i11 & 128) != 0 ? couponRecommendRequestSkuInfo2.skuId : i6, (i11 & 256) != 0 ? couponRecommendRequestSkuInfo2.subPlatformType : i7, (i11 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? couponRecommendRequestSkuInfo2.subjectId : i8, (i11 & 1024) != 0 ? couponRecommendRequestSkuInfo2.term : i9, (i11 & 2048) != 0 ? couponRecommendRequestSkuInfo2.year : str2);
    }

    public final int component1() {
        return this.clazzId;
    }

    public final int component10() {
        return this.subjectId;
    }

    public final int component11() {
        return this.term;
    }

    public final String component12() {
        return this.year;
    }

    public final int component2() {
        return this.courseId;
    }

    public final int component3() {
        return this.courseType;
    }

    public final int component4() {
        return this.goodsCategoryId;
    }

    public final List<Integer> component5() {
        return this.gradeIds;
    }

    public final int component6() {
        return this.levelDegreeId;
    }

    public final String component7() {
        return this.platformType;
    }

    public final int component8() {
        return this.skuId;
    }

    public final int component9() {
        return this.subPlatformType;
    }

    public final CouponRecommendRequestSkuInfo copy(int i, int i2, int i3, int i4, List<Integer> list, int i5, String str, int i6, int i7, int i8, int i9, String str2) {
        return new CouponRecommendRequestSkuInfo(i, i2, i3, i4, list, i5, str, i6, i7, i8, i9, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CouponRecommendRequestSkuInfo)) {
            return false;
        }
        CouponRecommendRequestSkuInfo couponRecommendRequestSkuInfo = (CouponRecommendRequestSkuInfo) obj;
        return this.clazzId == couponRecommendRequestSkuInfo.clazzId && this.courseId == couponRecommendRequestSkuInfo.courseId && this.courseType == couponRecommendRequestSkuInfo.courseType && this.goodsCategoryId == couponRecommendRequestSkuInfo.goodsCategoryId && Intrinsics.areEqual((Object) this.gradeIds, (Object) couponRecommendRequestSkuInfo.gradeIds) && this.levelDegreeId == couponRecommendRequestSkuInfo.levelDegreeId && Intrinsics.areEqual((Object) this.platformType, (Object) couponRecommendRequestSkuInfo.platformType) && this.skuId == couponRecommendRequestSkuInfo.skuId && this.subPlatformType == couponRecommendRequestSkuInfo.subPlatformType && this.subjectId == couponRecommendRequestSkuInfo.subjectId && this.term == couponRecommendRequestSkuInfo.term && Intrinsics.areEqual((Object) this.year, (Object) couponRecommendRequestSkuInfo.year);
    }

    public int hashCode() {
        int i = ((((((this.clazzId * 31) + this.courseId) * 31) + this.courseType) * 31) + this.goodsCategoryId) * 31;
        List<Integer> list = this.gradeIds;
        int i2 = 0;
        int hashCode = (((i + (list == null ? 0 : list.hashCode())) * 31) + this.levelDegreeId) * 31;
        String str = this.platformType;
        int hashCode2 = (((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.skuId) * 31) + this.subPlatformType) * 31) + this.subjectId) * 31) + this.term) * 31;
        String str2 = this.year;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "CouponRecommendRequestSkuInfo(clazzId=" + this.clazzId + ", courseId=" + this.courseId + ", courseType=" + this.courseType + ", goodsCategoryId=" + this.goodsCategoryId + ", gradeIds=" + this.gradeIds + ", levelDegreeId=" + this.levelDegreeId + ", platformType=" + this.platformType + ", skuId=" + this.skuId + ", subPlatformType=" + this.subPlatformType + ", subjectId=" + this.subjectId + ", term=" + this.term + ", year=" + this.year + ')';
    }

    public CouponRecommendRequestSkuInfo(int i, int i2, int i3, int i4, List<Integer> list, int i5, String str, int i6, int i7, int i8, int i9, String str2) {
        this.clazzId = i;
        this.courseId = i2;
        this.courseType = i3;
        this.goodsCategoryId = i4;
        this.gradeIds = list;
        this.levelDegreeId = i5;
        this.platformType = str;
        this.skuId = i6;
        this.subPlatformType = i7;
        this.subjectId = i8;
        this.term = i9;
        this.year = str2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CouponRecommendRequestSkuInfo(int r15, int r16, int r17, int r18, java.util.List r19, int r20, java.lang.String r21, int r22, int r23, int r24, int r25, java.lang.String r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r14 = this;
            r0 = r27
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0012
        L_0x0010:
            r3 = r16
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = r2
            goto L_0x001a
        L_0x0018:
            r4 = r17
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = r2
            goto L_0x0022
        L_0x0020:
            r5 = r18
        L_0x0022:
            r6 = r0 & 16
            r7 = 0
            if (r6 == 0) goto L_0x0029
            r6 = r7
            goto L_0x002b
        L_0x0029:
            r6 = r19
        L_0x002b:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0031
            r8 = r2
            goto L_0x0033
        L_0x0031:
            r8 = r20
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0039
            r9 = r7
            goto L_0x003b
        L_0x0039:
            r9 = r21
        L_0x003b:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0041
            r10 = r2
            goto L_0x0043
        L_0x0041:
            r10 = r22
        L_0x0043:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0049
            r11 = r2
            goto L_0x004b
        L_0x0049:
            r11 = r23
        L_0x004b:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0051
            r12 = r2
            goto L_0x0053
        L_0x0051:
            r12 = r24
        L_0x0053:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0058
            goto L_0x005a
        L_0x0058:
            r2 = r25
        L_0x005a:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x005f
            goto L_0x0061
        L_0x005f:
            r7 = r26
        L_0x0061:
            r15 = r14
            r16 = r1
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r2
            r27 = r7
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.bean.request.CouponRecommendRequestSkuInfo.<init>(int, int, int, int, java.util.List, int, java.lang.String, int, int, int, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getClazzId() {
        return this.clazzId;
    }

    public final int getCourseId() {
        return this.courseId;
    }

    public final int getCourseType() {
        return this.courseType;
    }

    public final int getGoodsCategoryId() {
        return this.goodsCategoryId;
    }

    public final List<Integer> getGradeIds() {
        return this.gradeIds;
    }

    public final int getLevelDegreeId() {
        return this.levelDegreeId;
    }

    public final String getPlatformType() {
        return this.platformType;
    }

    public final int getSkuId() {
        return this.skuId;
    }

    public final int getSubPlatformType() {
        return this.subPlatformType;
    }

    public final int getSubjectId() {
        return this.subjectId;
    }

    public final int getTerm() {
        return this.term;
    }

    public final String getYear() {
        return this.year;
    }
}
