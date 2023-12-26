package com.tal.app.thinkacademy.business.study.study.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.tal.app.thinkacademy.business.study.study.SwitchType;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B±\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010N\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010Q\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u00103J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jº\u0001\u0010S\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010TJ\u0013\u0010U\u001a\u00020\u00052\b\u0010V\u001a\u0004\u0018\u00010WHÖ\u0003J\t\u0010X\u001a\u00020\tHÖ\u0001J\t\u0010Y\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010\u001bR\u001a\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001bR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\u001bR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0010\n\u0002\u00106\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0019\"\u0004\b8\u0010\u001bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0019\"\u0004\b:\u0010\u001bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0019\"\u0004\b<\u0010\u001bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006Z"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedCourse;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "expirationTime", "", "expired", "", "id", "skuId", "lessonAmount", "", "name", "permanent", "studentCourseId", "", "subjectTag", "teachers", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedTeacher;", "itemType", "switchTip", "switchBtn", "switchType", "Lcom/tal/app/thinkacademy/business/study/study/SwitchType;", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/study/study/SwitchType;)V", "getExpirationTime", "()Ljava/lang/String;", "setExpirationTime", "(Ljava/lang/String;)V", "getExpired", "()Ljava/lang/Boolean;", "setExpired", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getId", "setId", "getItemType", "()I", "setItemType", "(I)V", "getLessonAmount", "()Ljava/lang/Integer;", "setLessonAmount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getName", "setName", "getPermanent", "setPermanent", "getSkuId", "setSkuId", "getStudentCourseId", "()Ljava/lang/Long;", "setStudentCourseId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getSubjectTag", "setSubjectTag", "getSwitchBtn", "setSwitchBtn", "getSwitchTip", "setSwitchTip", "getSwitchType", "()Lcom/tal/app/thinkacademy/business/study/study/SwitchType;", "setSwitchType", "(Lcom/tal/app/thinkacademy/business/study/study/SwitchType;)V", "getTeachers", "()Ljava/util/List;", "setTeachers", "(Ljava/util/List;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/study/study/SwitchType;)Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedCourse;", "equals", "other", "", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedClassList.kt */
public final class RecordedCourse implements MultiItemEntity {
    private String expirationTime;
    private Boolean expired;
    private String id;
    private int itemType;
    private Integer lessonAmount;
    private String name;
    private Boolean permanent;
    private String skuId;
    private Long studentCourseId;
    private String subjectTag;
    private String switchBtn;
    private String switchTip;
    private SwitchType switchType;
    private List<RecordedTeacher> teachers;

    public RecordedCourse() {
        this((String) null, (Boolean) null, (String) null, (String) null, (Integer) null, (String) null, (Boolean) null, (Long) null, (String) null, (List) null, 0, (String) null, (String) null, (SwitchType) null, 16383, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RecordedCourse copy$default(RecordedCourse recordedCourse, String str, Boolean bool, String str2, String str3, Integer num, String str4, Boolean bool2, Long l, String str5, List list, int i, String str6, String str7, SwitchType switchType2, int i2, Object obj) {
        RecordedCourse recordedCourse2 = recordedCourse;
        int i3 = i2;
        return recordedCourse.copy((i3 & 1) != 0 ? recordedCourse2.expirationTime : str, (i3 & 2) != 0 ? recordedCourse2.expired : bool, (i3 & 4) != 0 ? recordedCourse2.id : str2, (i3 & 8) != 0 ? recordedCourse2.skuId : str3, (i3 & 16) != 0 ? recordedCourse2.lessonAmount : num, (i3 & 32) != 0 ? recordedCourse2.name : str4, (i3 & 64) != 0 ? recordedCourse2.permanent : bool2, (i3 & 128) != 0 ? recordedCourse2.studentCourseId : l, (i3 & 256) != 0 ? recordedCourse2.subjectTag : str5, (i3 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? recordedCourse2.teachers : list, (i3 & 1024) != 0 ? recordedCourse.getItemType() : i, (i3 & 2048) != 0 ? recordedCourse2.switchTip : str6, (i3 & ConstantsKt.DEFAULT_BLOCK_SIZE) != 0 ? recordedCourse2.switchBtn : str7, (i3 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? recordedCourse2.switchType : switchType2);
    }

    public final String component1() {
        return this.expirationTime;
    }

    public final List<RecordedTeacher> component10() {
        return this.teachers;
    }

    public final int component11() {
        return getItemType();
    }

    public final String component12() {
        return this.switchTip;
    }

    public final String component13() {
        return this.switchBtn;
    }

    public final SwitchType component14() {
        return this.switchType;
    }

    public final Boolean component2() {
        return this.expired;
    }

    public final String component3() {
        return this.id;
    }

    public final String component4() {
        return this.skuId;
    }

    public final Integer component5() {
        return this.lessonAmount;
    }

    public final String component6() {
        return this.name;
    }

    public final Boolean component7() {
        return this.permanent;
    }

    public final Long component8() {
        return this.studentCourseId;
    }

    public final String component9() {
        return this.subjectTag;
    }

    public final RecordedCourse copy(String str, Boolean bool, String str2, String str3, Integer num, String str4, Boolean bool2, Long l, String str5, List<RecordedTeacher> list, int i, String str6, String str7, SwitchType switchType2) {
        return new RecordedCourse(str, bool, str2, str3, num, str4, bool2, l, str5, list, i, str6, str7, switchType2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordedCourse)) {
            return false;
        }
        RecordedCourse recordedCourse = (RecordedCourse) obj;
        return Intrinsics.areEqual((Object) this.expirationTime, (Object) recordedCourse.expirationTime) && Intrinsics.areEqual((Object) this.expired, (Object) recordedCourse.expired) && Intrinsics.areEqual((Object) this.id, (Object) recordedCourse.id) && Intrinsics.areEqual((Object) this.skuId, (Object) recordedCourse.skuId) && Intrinsics.areEqual((Object) this.lessonAmount, (Object) recordedCourse.lessonAmount) && Intrinsics.areEqual((Object) this.name, (Object) recordedCourse.name) && Intrinsics.areEqual((Object) this.permanent, (Object) recordedCourse.permanent) && Intrinsics.areEqual((Object) this.studentCourseId, (Object) recordedCourse.studentCourseId) && Intrinsics.areEqual((Object) this.subjectTag, (Object) recordedCourse.subjectTag) && Intrinsics.areEqual((Object) this.teachers, (Object) recordedCourse.teachers) && getItemType() == recordedCourse.getItemType() && Intrinsics.areEqual((Object) this.switchTip, (Object) recordedCourse.switchTip) && Intrinsics.areEqual((Object) this.switchBtn, (Object) recordedCourse.switchBtn) && this.switchType == recordedCourse.switchType;
    }

    public int hashCode() {
        String str = this.expirationTime;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.expired;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.id;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.skuId;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.lessonAmount;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str4 = this.name;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool2 = this.permanent;
        int hashCode7 = (hashCode6 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Long l = this.studentCourseId;
        int hashCode8 = (hashCode7 + (l == null ? 0 : l.hashCode())) * 31;
        String str5 = this.subjectTag;
        int hashCode9 = (hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<RecordedTeacher> list = this.teachers;
        int hashCode10 = (((hashCode9 + (list == null ? 0 : list.hashCode())) * 31) + getItemType()) * 31;
        String str6 = this.switchTip;
        int hashCode11 = (hashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.switchBtn;
        int hashCode12 = (hashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
        SwitchType switchType2 = this.switchType;
        if (switchType2 != null) {
            i = switchType2.hashCode();
        }
        return hashCode12 + i;
    }

    public String toString() {
        return "RecordedCourse(expirationTime=" + this.expirationTime + ", expired=" + this.expired + ", id=" + this.id + ", skuId=" + this.skuId + ", lessonAmount=" + this.lessonAmount + ", name=" + this.name + ", permanent=" + this.permanent + ", studentCourseId=" + this.studentCourseId + ", subjectTag=" + this.subjectTag + ", teachers=" + this.teachers + ", itemType=" + getItemType() + ", switchTip=" + this.switchTip + ", switchBtn=" + this.switchBtn + ", switchType=" + this.switchType + ')';
    }

    public RecordedCourse(String str, Boolean bool, String str2, String str3, Integer num, String str4, Boolean bool2, Long l, String str5, List<RecordedTeacher> list, int i, String str6, String str7, SwitchType switchType2) {
        this.expirationTime = str;
        this.expired = bool;
        this.id = str2;
        this.skuId = str3;
        this.lessonAmount = num;
        this.name = str4;
        this.permanent = bool2;
        this.studentCourseId = l;
        this.subjectTag = str5;
        this.teachers = list;
        this.itemType = i;
        this.switchTip = str6;
        this.switchBtn = str7;
        this.switchType = switchType2;
    }

    public final String getExpirationTime() {
        return this.expirationTime;
    }

    public final void setExpirationTime(String str) {
        this.expirationTime = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RecordedCourse(java.lang.String r16, java.lang.Boolean r17, java.lang.String r18, java.lang.String r19, java.lang.Integer r20, java.lang.String r21, java.lang.Boolean r22, java.lang.Long r23, java.lang.String r24, java.util.List r25, int r26, java.lang.String r27, java.lang.String r28, com.tal.app.thinkacademy.business.study.study.SwitchType r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
        /*
            r15 = this;
            r0 = r30
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r16
        L_0x000c:
            r3 = r0 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0016
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r4)
            goto L_0x0018
        L_0x0016:
            r3 = r17
        L_0x0018:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x0020
        L_0x001e:
            r5 = r18
        L_0x0020:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0026
            r6 = r2
            goto L_0x0028
        L_0x0026:
            r6 = r19
        L_0x0028:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0031
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            goto L_0x0033
        L_0x0031:
            r7 = r20
        L_0x0033:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0039
            r8 = r2
            goto L_0x003b
        L_0x0039:
            r8 = r21
        L_0x003b:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0044
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r4)
            goto L_0x0046
        L_0x0044:
            r9 = r22
        L_0x0046:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0051
            r10 = -1
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            goto L_0x0053
        L_0x0051:
            r10 = r23
        L_0x0053:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x0059
            r11 = r2
            goto L_0x005b
        L_0x0059:
            r11 = r24
        L_0x005b:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0067
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.List r12 = (java.util.List) r12
            goto L_0x0069
        L_0x0067:
            r12 = r25
        L_0x0069:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x006e
            goto L_0x0070
        L_0x006e:
            r4 = r26
        L_0x0070:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0076
            r13 = r2
            goto L_0x0078
        L_0x0076:
            r13 = r27
        L_0x0078:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x007d
            goto L_0x007f
        L_0x007d:
            r2 = r28
        L_0x007f:
            r0 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x0086
            com.tal.app.thinkacademy.business.study.study.SwitchType r0 = com.tal.app.thinkacademy.business.study.study.SwitchType.Account
            goto L_0x0088
        L_0x0086:
            r0 = r29
        L_0x0088:
            r16 = r15
            r17 = r1
            r18 = r3
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r8
            r23 = r9
            r24 = r10
            r25 = r11
            r26 = r12
            r27 = r4
            r28 = r13
            r29 = r2
            r30 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.entity.RecordedCourse.<init>(java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.Boolean, java.lang.Long, java.lang.String, java.util.List, int, java.lang.String, java.lang.String, com.tal.app.thinkacademy.business.study.study.SwitchType, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Boolean getExpired() {
        return this.expired;
    }

    public final void setExpired(Boolean bool) {
        this.expired = bool;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public final void setSkuId(String str) {
        this.skuId = str;
    }

    public final Integer getLessonAmount() {
        return this.lessonAmount;
    }

    public final void setLessonAmount(Integer num) {
        this.lessonAmount = num;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final Boolean getPermanent() {
        return this.permanent;
    }

    public final void setPermanent(Boolean bool) {
        this.permanent = bool;
    }

    public final Long getStudentCourseId() {
        return this.studentCourseId;
    }

    public final void setStudentCourseId(Long l) {
        this.studentCourseId = l;
    }

    public final String getSubjectTag() {
        return this.subjectTag;
    }

    public final void setSubjectTag(String str) {
        this.subjectTag = str;
    }

    public final List<RecordedTeacher> getTeachers() {
        return this.teachers;
    }

    public final void setTeachers(List<RecordedTeacher> list) {
        this.teachers = list;
    }

    public int getItemType() {
        return this.itemType;
    }

    public void setItemType(int i) {
        this.itemType = i;
    }

    public final String getSwitchTip() {
        return this.switchTip;
    }

    public final void setSwitchTip(String str) {
        this.switchTip = str;
    }

    public final String getSwitchBtn() {
        return this.switchBtn;
    }

    public final void setSwitchBtn(String str) {
        this.switchBtn = str;
    }

    public final SwitchType getSwitchType() {
        return this.switchType;
    }

    public final void setSwitchType(SwitchType switchType2) {
        this.switchType = switchType2;
    }
}
