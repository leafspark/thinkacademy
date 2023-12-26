package com.tal.app.thinkacademy.business.study.study.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001Bo\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0001\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015¨\u00061"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/ClassInfo;", "", "classId", "", "courseType", "className", "", "courseId", "endDate", "startDate", "timeDesc", "timeDesc2", "tag", "teachers", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/Teacher;", "(Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getClassId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getClassName", "()Ljava/lang/String;", "getCourseId", "getCourseType", "()I", "getEndDate", "getStartDate", "getTag", "getTeachers", "()Ljava/util/List;", "getTimeDesc", "getTimeDesc2", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/tal/app/thinkacademy/business/study/study/entity/ClassInfo;", "equals", "", "other", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassCalendarEntity.kt */
public final class ClassInfo {
    private final Integer classId;
    private final String className;
    private final Integer courseId;
    private final int courseType;
    private final String endDate;
    private final String startDate;
    private final String tag;
    private final List<Teacher> teachers;
    private final String timeDesc;
    private final String timeDesc2;

    public static /* synthetic */ ClassInfo copy$default(ClassInfo classInfo, Integer num, int i, String str, Integer num2, String str2, String str3, String str4, String str5, String str6, List list, int i2, Object obj) {
        ClassInfo classInfo2 = classInfo;
        int i3 = i2;
        return classInfo.copy((i3 & 1) != 0 ? classInfo2.classId : num, (i3 & 2) != 0 ? classInfo2.courseType : i, (i3 & 4) != 0 ? classInfo2.className : str, (i3 & 8) != 0 ? classInfo2.courseId : num2, (i3 & 16) != 0 ? classInfo2.endDate : str2, (i3 & 32) != 0 ? classInfo2.startDate : str3, (i3 & 64) != 0 ? classInfo2.timeDesc : str4, (i3 & 128) != 0 ? classInfo2.timeDesc2 : str5, (i3 & 256) != 0 ? classInfo2.tag : str6, (i3 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? classInfo2.teachers : list);
    }

    public final Integer component1() {
        return this.classId;
    }

    public final List<Teacher> component10() {
        return this.teachers;
    }

    public final int component2() {
        return this.courseType;
    }

    public final String component3() {
        return this.className;
    }

    public final Integer component4() {
        return this.courseId;
    }

    public final String component5() {
        return this.endDate;
    }

    public final String component6() {
        return this.startDate;
    }

    public final String component7() {
        return this.timeDesc;
    }

    public final String component8() {
        return this.timeDesc2;
    }

    public final String component9() {
        return this.tag;
    }

    public final ClassInfo copy(Integer num, int i, String str, Integer num2, String str2, String str3, String str4, String str5, String str6, List<Teacher> list) {
        return new ClassInfo(num, i, str, num2, str2, str3, str4, str5, str6, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassInfo)) {
            return false;
        }
        ClassInfo classInfo = (ClassInfo) obj;
        return Intrinsics.areEqual((Object) this.classId, (Object) classInfo.classId) && this.courseType == classInfo.courseType && Intrinsics.areEqual((Object) this.className, (Object) classInfo.className) && Intrinsics.areEqual((Object) this.courseId, (Object) classInfo.courseId) && Intrinsics.areEqual((Object) this.endDate, (Object) classInfo.endDate) && Intrinsics.areEqual((Object) this.startDate, (Object) classInfo.startDate) && Intrinsics.areEqual((Object) this.timeDesc, (Object) classInfo.timeDesc) && Intrinsics.areEqual((Object) this.timeDesc2, (Object) classInfo.timeDesc2) && Intrinsics.areEqual((Object) this.tag, (Object) classInfo.tag) && Intrinsics.areEqual((Object) this.teachers, (Object) classInfo.teachers);
    }

    public int hashCode() {
        Integer num = this.classId;
        int i = 0;
        int hashCode = (((num == null ? 0 : num.hashCode()) * 31) + this.courseType) * 31;
        String str = this.className;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.courseId;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.endDate;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.startDate;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.timeDesc;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.timeDesc2;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.tag;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        List<Teacher> list = this.teachers;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode8 + i;
    }

    public String toString() {
        return "ClassInfo(classId=" + this.classId + ", courseType=" + this.courseType + ", className=" + this.className + ", courseId=" + this.courseId + ", endDate=" + this.endDate + ", startDate=" + this.startDate + ", timeDesc=" + this.timeDesc + ", timeDesc2=" + this.timeDesc2 + ", tag=" + this.tag + ", teachers=" + this.teachers + ')';
    }

    public ClassInfo(Integer num, int i, String str, Integer num2, String str2, String str3, String str4, String str5, String str6, List<Teacher> list) {
        this.classId = num;
        this.courseType = i;
        this.className = str;
        this.courseId = num2;
        this.endDate = str2;
        this.startDate = str3;
        this.timeDesc = str4;
        this.timeDesc2 = str5;
        this.tag = str6;
        this.teachers = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClassInfo(Integer num, int i, String str, Integer num2, String str2, String str3, String str4, String str5, String str6, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, (i2 & 2) != 0 ? 0 : i, str, num2, str2, str3, str4, str5, str6, list);
    }

    public final Integer getClassId() {
        return this.classId;
    }

    public final int getCourseType() {
        return this.courseType;
    }

    public final String getClassName() {
        return this.className;
    }

    public final Integer getCourseId() {
        return this.courseId;
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final String getTimeDesc() {
        return this.timeDesc;
    }

    public final String getTimeDesc2() {
        return this.timeDesc2;
    }

    public final String getTag() {
        return this.tag;
    }

    public final List<Teacher> getTeachers() {
        return this.teachers;
    }
}
