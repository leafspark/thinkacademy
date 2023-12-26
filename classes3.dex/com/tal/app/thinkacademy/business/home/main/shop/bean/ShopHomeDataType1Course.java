package com.tal.app.thinkacademy.business.home.main.shop.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B¿\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015¢\u0006\u0002\u0010\u0017J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u00100\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010'J\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u00104\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0019JÈ\u0001\u0010=\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020\b2\b\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\u0003HÖ\u0001J\t\u0010C\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u0007\u0010\u001eR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b \u0010\u0019R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b!\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b#\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b%\u0010\u0019R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b)\u0010\u0019R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001cR\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006D"}, d2 = {"Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeDataType1Course;", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopItemNormalNode;", "courseId", "", "description", "", "headFigure", "isSame", "", "lessonCount", "levelDegree", "levelDegreeName", "showName", "showPrice", "perShowPrice", "sortWeight", "", "startPrice", "subjectTag", "suitableStudents", "teacherList", "", "Lcom/tal/app/thinkacademy/business/home/main/shop/bean/Teacher;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getCourseId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDescription", "()Ljava/lang/String;", "getHeadFigure", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLessonCount", "getLevelDegree", "getLevelDegreeName", "getPerShowPrice", "getShowName", "getShowPrice", "getSortWeight", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getStartPrice", "getSubjectTag", "getSuitableStudents", "getTeacherList", "()Ljava/util/List;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/tal/app/thinkacademy/business/home/main/shop/bean/ShopHomeDataType1Course;", "equals", "other", "", "hashCode", "toString", "bus_shop_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShopHomeDataType1.kt */
public final class ShopHomeDataType1Course extends ShopItemNormalNode {
    private final Integer courseId;
    private final String description;
    private final String headFigure;
    private final Boolean isSame;
    private final Integer lessonCount;
    private final Integer levelDegree;
    private final String levelDegreeName;
    private final Integer perShowPrice;
    private final String showName;
    private final Integer showPrice;
    private final Double sortWeight;
    private final Integer startPrice;
    private final String subjectTag;
    private final String suitableStudents;
    private final List<Teacher> teacherList;

    public ShopHomeDataType1Course() {
        this((Integer) null, (String) null, (String) null, (Boolean) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (Integer) null, (Double) null, (Integer) null, (String) null, (String) null, (List) null, 32767, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShopHomeDataType1Course copy$default(ShopHomeDataType1Course shopHomeDataType1Course, Integer num, String str, String str2, Boolean bool, Integer num2, Integer num3, String str3, String str4, Integer num4, Integer num5, Double d, Integer num6, String str5, String str6, List list, int i, Object obj) {
        ShopHomeDataType1Course shopHomeDataType1Course2 = shopHomeDataType1Course;
        int i2 = i;
        return shopHomeDataType1Course.copy((i2 & 1) != 0 ? shopHomeDataType1Course2.courseId : num, (i2 & 2) != 0 ? shopHomeDataType1Course2.description : str, (i2 & 4) != 0 ? shopHomeDataType1Course2.headFigure : str2, (i2 & 8) != 0 ? shopHomeDataType1Course2.isSame : bool, (i2 & 16) != 0 ? shopHomeDataType1Course2.lessonCount : num2, (i2 & 32) != 0 ? shopHomeDataType1Course2.levelDegree : num3, (i2 & 64) != 0 ? shopHomeDataType1Course2.levelDegreeName : str3, (i2 & 128) != 0 ? shopHomeDataType1Course2.showName : str4, (i2 & 256) != 0 ? shopHomeDataType1Course2.showPrice : num4, (i2 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? shopHomeDataType1Course2.perShowPrice : num5, (i2 & 1024) != 0 ? shopHomeDataType1Course2.sortWeight : d, (i2 & 2048) != 0 ? shopHomeDataType1Course2.startPrice : num6, (i2 & ConstantsKt.DEFAULT_BLOCK_SIZE) != 0 ? shopHomeDataType1Course2.subjectTag : str5, (i2 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? shopHomeDataType1Course2.suitableStudents : str6, (i2 & 16384) != 0 ? shopHomeDataType1Course2.teacherList : list);
    }

    public final Integer component1() {
        return this.courseId;
    }

    public final Integer component10() {
        return this.perShowPrice;
    }

    public final Double component11() {
        return this.sortWeight;
    }

    public final Integer component12() {
        return this.startPrice;
    }

    public final String component13() {
        return this.subjectTag;
    }

    public final String component14() {
        return this.suitableStudents;
    }

    public final List<Teacher> component15() {
        return this.teacherList;
    }

    public final String component2() {
        return this.description;
    }

    public final String component3() {
        return this.headFigure;
    }

    public final Boolean component4() {
        return this.isSame;
    }

    public final Integer component5() {
        return this.lessonCount;
    }

    public final Integer component6() {
        return this.levelDegree;
    }

    public final String component7() {
        return this.levelDegreeName;
    }

    public final String component8() {
        return this.showName;
    }

    public final Integer component9() {
        return this.showPrice;
    }

    public final ShopHomeDataType1Course copy(Integer num, String str, String str2, Boolean bool, Integer num2, Integer num3, String str3, String str4, Integer num4, Integer num5, Double d, Integer num6, String str5, String str6, List<Teacher> list) {
        return new ShopHomeDataType1Course(num, str, str2, bool, num2, num3, str3, str4, num4, num5, d, num6, str5, str6, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShopHomeDataType1Course)) {
            return false;
        }
        ShopHomeDataType1Course shopHomeDataType1Course = (ShopHomeDataType1Course) obj;
        return Intrinsics.areEqual((Object) this.courseId, (Object) shopHomeDataType1Course.courseId) && Intrinsics.areEqual((Object) this.description, (Object) shopHomeDataType1Course.description) && Intrinsics.areEqual((Object) this.headFigure, (Object) shopHomeDataType1Course.headFigure) && Intrinsics.areEqual((Object) this.isSame, (Object) shopHomeDataType1Course.isSame) && Intrinsics.areEqual((Object) this.lessonCount, (Object) shopHomeDataType1Course.lessonCount) && Intrinsics.areEqual((Object) this.levelDegree, (Object) shopHomeDataType1Course.levelDegree) && Intrinsics.areEqual((Object) this.levelDegreeName, (Object) shopHomeDataType1Course.levelDegreeName) && Intrinsics.areEqual((Object) this.showName, (Object) shopHomeDataType1Course.showName) && Intrinsics.areEqual((Object) this.showPrice, (Object) shopHomeDataType1Course.showPrice) && Intrinsics.areEqual((Object) this.perShowPrice, (Object) shopHomeDataType1Course.perShowPrice) && Intrinsics.areEqual((Object) this.sortWeight, (Object) shopHomeDataType1Course.sortWeight) && Intrinsics.areEqual((Object) this.startPrice, (Object) shopHomeDataType1Course.startPrice) && Intrinsics.areEqual((Object) this.subjectTag, (Object) shopHomeDataType1Course.subjectTag) && Intrinsics.areEqual((Object) this.suitableStudents, (Object) shopHomeDataType1Course.suitableStudents) && Intrinsics.areEqual((Object) this.teacherList, (Object) shopHomeDataType1Course.teacherList);
    }

    public int hashCode() {
        Integer num = this.courseId;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.description;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.headFigure;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isSame;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num2 = this.lessonCount;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.levelDegree;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str3 = this.levelDegreeName;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.showName;
        int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num4 = this.showPrice;
        int hashCode9 = (hashCode8 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.perShowPrice;
        int hashCode10 = (hashCode9 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Double d = this.sortWeight;
        int hashCode11 = (hashCode10 + (d == null ? 0 : d.hashCode())) * 31;
        Integer num6 = this.startPrice;
        int hashCode12 = (hashCode11 + (num6 == null ? 0 : num6.hashCode())) * 31;
        String str5 = this.subjectTag;
        int hashCode13 = (hashCode12 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.suitableStudents;
        int hashCode14 = (hashCode13 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<Teacher> list = this.teacherList;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode14 + i;
    }

    public String toString() {
        return "ShopHomeDataType1Course(courseId=" + this.courseId + ", description=" + this.description + ", headFigure=" + this.headFigure + ", isSame=" + this.isSame + ", lessonCount=" + this.lessonCount + ", levelDegree=" + this.levelDegree + ", levelDegreeName=" + this.levelDegreeName + ", showName=" + this.showName + ", showPrice=" + this.showPrice + ", perShowPrice=" + this.perShowPrice + ", sortWeight=" + this.sortWeight + ", startPrice=" + this.startPrice + ", subjectTag=" + this.subjectTag + ", suitableStudents=" + this.suitableStudents + ", teacherList=" + this.teacherList + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ShopHomeDataType1Course(java.lang.Integer r17, java.lang.String r18, java.lang.String r19, java.lang.Boolean r20, java.lang.Integer r21, java.lang.Integer r22, java.lang.String r23, java.lang.String r24, java.lang.Integer r25, java.lang.Integer r26, java.lang.Double r27, java.lang.Integer r28, java.lang.String r29, java.lang.String r30, java.util.List r31, int r32, kotlin.jvm.internal.DefaultConstructorMarker r33) {
        /*
            r16 = this;
            r0 = r32
            r1 = r0 & 1
            r2 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            if (r1 == 0) goto L_0x000d
            r1 = r3
            goto L_0x000f
        L_0x000d:
            r1 = r17
        L_0x000f:
            r4 = r0 & 2
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x0017
            r4 = r5
            goto L_0x0019
        L_0x0017:
            r4 = r18
        L_0x0019:
            r6 = r0 & 4
            if (r6 == 0) goto L_0x001f
            r6 = r5
            goto L_0x0021
        L_0x001f:
            r6 = r19
        L_0x0021:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x002c
        L_0x002a:
            r2 = r20
        L_0x002c:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0032
            r7 = r3
            goto L_0x0034
        L_0x0032:
            r7 = r21
        L_0x0034:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x003a
            r8 = r3
            goto L_0x003c
        L_0x003a:
            r8 = r22
        L_0x003c:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0042
            r9 = r5
            goto L_0x0044
        L_0x0042:
            r9 = r23
        L_0x0044:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x004a
            r10 = r5
            goto L_0x004c
        L_0x004a:
            r10 = r24
        L_0x004c:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0052
            r11 = r3
            goto L_0x0054
        L_0x0052:
            r11 = r25
        L_0x0054:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x005a
            r12 = r3
            goto L_0x005c
        L_0x005a:
            r12 = r26
        L_0x005c:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0067
            r13 = 0
            java.lang.Double r13 = java.lang.Double.valueOf(r13)
            goto L_0x0069
        L_0x0067:
            r13 = r27
        L_0x0069:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x006e
            goto L_0x0070
        L_0x006e:
            r3 = r28
        L_0x0070:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0076
            r14 = r5
            goto L_0x0078
        L_0x0076:
            r14 = r29
        L_0x0078:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x007d
            goto L_0x007f
        L_0x007d:
            r5 = r30
        L_0x007f:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L_0x0088
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x008a
        L_0x0088:
            r0 = r31
        L_0x008a:
            r17 = r16
            r18 = r1
            r19 = r4
            r20 = r6
            r21 = r2
            r22 = r7
            r23 = r8
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
            r28 = r13
            r29 = r3
            r30 = r14
            r31 = r5
            r32 = r0
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.main.shop.bean.ShopHomeDataType1Course.<init>(java.lang.Integer, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Double, java.lang.Integer, java.lang.String, java.lang.String, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getCourseId() {
        return this.courseId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getHeadFigure() {
        return this.headFigure;
    }

    public final Boolean isSame() {
        return this.isSame;
    }

    public final Integer getLessonCount() {
        return this.lessonCount;
    }

    public final Integer getLevelDegree() {
        return this.levelDegree;
    }

    public final String getLevelDegreeName() {
        return this.levelDegreeName;
    }

    public final String getShowName() {
        return this.showName;
    }

    public final Integer getShowPrice() {
        return this.showPrice;
    }

    public final Integer getPerShowPrice() {
        return this.perShowPrice;
    }

    public final Double getSortWeight() {
        return this.sortWeight;
    }

    public final Integer getStartPrice() {
        return this.startPrice;
    }

    public final String getSubjectTag() {
        return this.subjectTag;
    }

    public final String getSuitableStudents() {
        return this.suitableStudents;
    }

    public final List<Teacher> getTeacherList() {
        return this.teacherList;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopHomeDataType1Course(Integer num, String str, String str2, Boolean bool, Integer num2, Integer num3, String str3, String str4, Integer num4, Integer num5, Double d, Integer num6, String str5, String str6, List<Teacher> list) {
        super((List) null, 1, (DefaultConstructorMarker) null);
        this.courseId = num;
        this.description = str;
        this.headFigure = str2;
        this.isSame = bool;
        this.lessonCount = num2;
        this.levelDegree = num3;
        this.levelDegreeName = str3;
        this.showName = str4;
        this.showPrice = num4;
        this.perShowPrice = num5;
        this.sortWeight = d;
        this.startPrice = num6;
        this.subjectTag = str5;
        this.suitableStudents = str6;
        this.teacherList = list;
    }
}
