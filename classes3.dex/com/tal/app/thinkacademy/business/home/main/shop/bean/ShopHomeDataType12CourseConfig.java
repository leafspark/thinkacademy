package com.tal.app.thinkacademy.business.home.main.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b¢\u0006\u0002\u0010\u0012J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000bHÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000bHÆ\u0001J\u0013\u0010-\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0007HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0017R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016¨\u00062"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeDataType12CourseConfig;", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopItemNormalNode;", "description", "", "isSame", "", "goodsPrice", "", "perGoodsPrice", "subjectTag", "levelDegreeList", "", "name", "pageId", "weight", "suitableStudents", "teacherList", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Teacher;", "(Ljava/lang/String;ZIILjava/lang/String;Ljava/util/List;Ljava/lang/String;IILjava/lang/String;Ljava/util/List;)V", "getDescription", "()Ljava/lang/String;", "getGoodsPrice", "()I", "()Z", "getLevelDegreeList", "()Ljava/util/List;", "getName", "getPageId", "getPerGoodsPrice", "getSubjectTag", "getSuitableStudents", "getTeacherList", "getWeight", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeDataType12.kt */
public final class ShopHomeDataType12CourseConfig extends ShopItemNormalNode {
    private final String description;
    private final int goodsPrice;
    private final boolean isSame;
    private final List<String> levelDegreeList;
    private final String name;
    private final int pageId;
    private final int perGoodsPrice;
    private final String subjectTag;
    private final String suitableStudents;
    private final List<Teacher> teacherList;
    private final int weight;

    public ShopHomeDataType12CourseConfig() {
        this((String) null, false, 0, 0, (String) null, (List) null, (String) null, 0, 0, (String) null, (List) null, 2047, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopHomeDataType12CourseConfig copy$default(ShopHomeDataType12CourseConfig shopHomeDataType12CourseConfig, String str, boolean z, int i, int i2, String str2, List list, String str3, int i3, int i4, String str4, List list2, int i5, Object obj) {
        ShopHomeDataType12CourseConfig shopHomeDataType12CourseConfig2 = shopHomeDataType12CourseConfig;
        int i6 = i5;
        return shopHomeDataType12CourseConfig.copy((i6 & 1) != 0 ? shopHomeDataType12CourseConfig2.description : str, (i6 & 2) != 0 ? shopHomeDataType12CourseConfig2.isSame : z, (i6 & 4) != 0 ? shopHomeDataType12CourseConfig2.goodsPrice : i, (i6 & 8) != 0 ? shopHomeDataType12CourseConfig2.perGoodsPrice : i2, (i6 & 16) != 0 ? shopHomeDataType12CourseConfig2.subjectTag : str2, (i6 & 32) != 0 ? shopHomeDataType12CourseConfig2.levelDegreeList : list, (i6 & 64) != 0 ? shopHomeDataType12CourseConfig2.name : str3, (i6 & 128) != 0 ? shopHomeDataType12CourseConfig2.pageId : i3, (i6 & 256) != 0 ? shopHomeDataType12CourseConfig2.weight : i4, (i6 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? shopHomeDataType12CourseConfig2.suitableStudents : str4, (i6 & 1024) != 0 ? shopHomeDataType12CourseConfig2.teacherList : list2);
    }

    public final String component1() {
        return this.description;
    }

    public final String component10() {
        return this.suitableStudents;
    }

    public final List<Teacher> component11() {
        return this.teacherList;
    }

    public final boolean component2() {
        return this.isSame;
    }

    public final int component3() {
        return this.goodsPrice;
    }

    public final int component4() {
        return this.perGoodsPrice;
    }

    public final String component5() {
        return this.subjectTag;
    }

    public final List<String> component6() {
        return this.levelDegreeList;
    }

    public final String component7() {
        return this.name;
    }

    public final int component8() {
        return this.pageId;
    }

    public final int component9() {
        return this.weight;
    }

    public final ShopHomeDataType12CourseConfig copy(String str, boolean z, int i, int i2, String str2, List<String> list, String str3, int i3, int i4, String str4, List<Teacher> list2) {
        return new ShopHomeDataType12CourseConfig(str, z, i, i2, str2, list, str3, i3, i4, str4, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopHomeDataType12CourseConfig)) {
            return false;
        }
        ShopHomeDataType12CourseConfig shopHomeDataType12CourseConfig = (ShopHomeDataType12CourseConfig) obj;
        return Intrinsics.areEqual((Object) this.description, (Object) shopHomeDataType12CourseConfig.description) && this.isSame == shopHomeDataType12CourseConfig.isSame && this.goodsPrice == shopHomeDataType12CourseConfig.goodsPrice && this.perGoodsPrice == shopHomeDataType12CourseConfig.perGoodsPrice && Intrinsics.areEqual((Object) this.subjectTag, (Object) shopHomeDataType12CourseConfig.subjectTag) && Intrinsics.areEqual((Object) this.levelDegreeList, (Object) shopHomeDataType12CourseConfig.levelDegreeList) && Intrinsics.areEqual((Object) this.name, (Object) shopHomeDataType12CourseConfig.name) && this.pageId == shopHomeDataType12CourseConfig.pageId && this.weight == shopHomeDataType12CourseConfig.weight && Intrinsics.areEqual((Object) this.suitableStudents, (Object) shopHomeDataType12CourseConfig.suitableStudents) && Intrinsics.areEqual((Object) this.teacherList, (Object) shopHomeDataType12CourseConfig.teacherList);
    }

    public int hashCode() {
        String str = this.description;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z = this.isSame;
        if (z) {
            z = true;
        }
        int i2 = (((((hashCode + (z ? 1 : 0)) * 31) + this.goodsPrice) * 31) + this.perGoodsPrice) * 31;
        String str2 = this.subjectTag;
        int hashCode2 = (i2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.levelDegreeList;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.name;
        int hashCode4 = (((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.pageId) * 31) + this.weight) * 31;
        String str4 = this.suitableStudents;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<Teacher> list2 = this.teacherList;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "ShopHomeDataType12CourseConfig(description=" + this.description + ", isSame=" + this.isSame + ", goodsPrice=" + this.goodsPrice + ", perGoodsPrice=" + this.perGoodsPrice + ", subjectTag=" + this.subjectTag + ", levelDegreeList=" + this.levelDegreeList + ", name=" + this.name + ", pageId=" + this.pageId + ", weight=" + this.weight + ", suitableStudents=" + this.suitableStudents + ", teacherList=" + this.teacherList + ')';
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean isSame() {
        return this.isSame;
    }

    public final int getGoodsPrice() {
        return this.goodsPrice;
    }

    public final int getPerGoodsPrice() {
        return this.perGoodsPrice;
    }

    public final String getSubjectTag() {
        return this.subjectTag;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShopHomeDataType12CourseConfig(java.lang.String r13, boolean r14, int r15, int r16, java.lang.String r17, java.util.List r18, java.lang.String r19, int r20, int r21, java.lang.String r22, java.util.List r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000b
        L_0x000a:
            r1 = r13
        L_0x000b:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0012
            r3 = r4
            goto L_0x0013
        L_0x0012:
            r3 = r14
        L_0x0013:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0019
            r5 = r4
            goto L_0x001a
        L_0x0019:
            r5 = r15
        L_0x001a:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0020
            r6 = r4
            goto L_0x0022
        L_0x0020:
            r6 = r16
        L_0x0022:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0028
            r7 = r2
            goto L_0x002a
        L_0x0028:
            r7 = r17
        L_0x002a:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0033
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0035
        L_0x0033:
            r8 = r18
        L_0x0035:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003b
            r9 = r2
            goto L_0x003d
        L_0x003b:
            r9 = r19
        L_0x003d:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0043
            r10 = r4
            goto L_0x0045
        L_0x0043:
            r10 = r20
        L_0x0045:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004a
            goto L_0x004c
        L_0x004a:
            r4 = r21
        L_0x004c:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            r2 = r22
        L_0x0053:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x005c
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x005e
        L_0x005c:
            r0 = r23
        L_0x005e:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r4
            r23 = r2
            r24 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType12CourseConfig.<init>(java.lang.String, boolean, int, int, java.lang.String, java.util.List, java.lang.String, int, int, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<String> getLevelDegreeList() {
        return this.levelDegreeList;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPageId() {
        return this.pageId;
    }

    public final int getWeight() {
        return this.weight;
    }

    public final String getSuitableStudents() {
        return this.suitableStudents;
    }

    public final List<Teacher> getTeacherList() {
        return this.teacherList;
    }

    public ShopHomeDataType12CourseConfig(String str, boolean z, int i, int i2, String str2, List<String> list, String str3, int i3, int i4, String str4, List<Teacher> list2) {
        super((List) null, 1, (DefaultConstructorMarker) null);
        this.description = str;
        this.isSame = z;
        this.goodsPrice = i;
        this.perGoodsPrice = i2;
        this.subjectTag = str2;
        this.levelDegreeList = list;
        this.name = str3;
        this.pageId = i3;
        this.weight = i4;
        this.suitableStudents = str4;
        this.teacherList = list2;
    }
}
