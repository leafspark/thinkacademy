package com.tal.app.thinkacademy.business.login.entity;

import com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00063"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/Record;", "", "classId", "", "className", "endDate", "lessonNum", "planId", "startDate", "teachers", "", "Lcom/tal/app/thinkacademy/business/login/entity/Teacher;", "classType", "status", "startEndTime", "bizId", "platformType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBizId", "()Ljava/lang/String;", "getClassId", "getClassName", "getClassType", "getEndDate", "getLessonNum", "getPlanId", "getPlatformType", "getStartDate", "getStartEndTime", "getStatus", "getTeachers", "()Ljava/util/List;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TemClassListData.kt */
public final class Record {
    private final String bizId;
    private final String classId;
    private final String className;
    private final String classType;
    private final String endDate;
    private final String lessonNum;
    private final String planId;
    private final String platformType;
    private final String startDate;
    private final String startEndTime;
    private final String status;
    private final List<Teacher> teachers;

    public static /* synthetic */ Record copy$default(Record record, String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, String str8, String str9, String str10, String str11, int i, Object obj) {
        Record record2 = record;
        int i2 = i;
        return record.copy((i2 & 1) != 0 ? record2.classId : str, (i2 & 2) != 0 ? record2.className : str2, (i2 & 4) != 0 ? record2.endDate : str3, (i2 & 8) != 0 ? record2.lessonNum : str4, (i2 & 16) != 0 ? record2.planId : str5, (i2 & 32) != 0 ? record2.startDate : str6, (i2 & 64) != 0 ? record2.teachers : list, (i2 & 128) != 0 ? record2.classType : str7, (i2 & 256) != 0 ? record2.status : str8, (i2 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? record2.startEndTime : str9, (i2 & 1024) != 0 ? record2.bizId : str10, (i2 & 2048) != 0 ? record2.platformType : str11);
    }

    public final String component1() {
        return this.classId;
    }

    public final String component10() {
        return this.startEndTime;
    }

    public final String component11() {
        return this.bizId;
    }

    public final String component12() {
        return this.platformType;
    }

    public final String component2() {
        return this.className;
    }

    public final String component3() {
        return this.endDate;
    }

    public final String component4() {
        return this.lessonNum;
    }

    public final String component5() {
        return this.planId;
    }

    public final String component6() {
        return this.startDate;
    }

    public final List<Teacher> component7() {
        return this.teachers;
    }

    public final String component8() {
        return this.classType;
    }

    public final String component9() {
        return this.status;
    }

    public final Record copy(String str, String str2, String str3, String str4, String str5, String str6, List<Teacher> list, String str7, String str8, String str9, String str10, String str11) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        String str12 = str2;
        Intrinsics.checkNotNullParameter(str12, "className");
        String str13 = str3;
        Intrinsics.checkNotNullParameter(str13, "endDate");
        String str14 = str4;
        Intrinsics.checkNotNullParameter(str14, "lessonNum");
        String str15 = str5;
        Intrinsics.checkNotNullParameter(str15, LearnMaterialsListActivityKt.PLANID);
        String str16 = str6;
        Intrinsics.checkNotNullParameter(str16, "startDate");
        List<Teacher> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "teachers");
        String str17 = str7;
        Intrinsics.checkNotNullParameter(str17, "classType");
        String str18 = str8;
        Intrinsics.checkNotNullParameter(str18, "status");
        String str19 = str9;
        Intrinsics.checkNotNullParameter(str19, "startEndTime");
        String str20 = str10;
        Intrinsics.checkNotNullParameter(str20, "bizId");
        String str21 = str11;
        Intrinsics.checkNotNullParameter(str21, "platformType");
        return new Record(str, str12, str13, str14, str15, str16, list2, str17, str18, str19, str20, str21);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Record)) {
            return false;
        }
        Record record = (Record) obj;
        return Intrinsics.areEqual((Object) this.classId, (Object) record.classId) && Intrinsics.areEqual((Object) this.className, (Object) record.className) && Intrinsics.areEqual((Object) this.endDate, (Object) record.endDate) && Intrinsics.areEqual((Object) this.lessonNum, (Object) record.lessonNum) && Intrinsics.areEqual((Object) this.planId, (Object) record.planId) && Intrinsics.areEqual((Object) this.startDate, (Object) record.startDate) && Intrinsics.areEqual((Object) this.teachers, (Object) record.teachers) && Intrinsics.areEqual((Object) this.classType, (Object) record.classType) && Intrinsics.areEqual((Object) this.status, (Object) record.status) && Intrinsics.areEqual((Object) this.startEndTime, (Object) record.startEndTime) && Intrinsics.areEqual((Object) this.bizId, (Object) record.bizId) && Intrinsics.areEqual((Object) this.platformType, (Object) record.platformType);
    }

    public int hashCode() {
        return (((((((((((((((((((((this.classId.hashCode() * 31) + this.className.hashCode()) * 31) + this.endDate.hashCode()) * 31) + this.lessonNum.hashCode()) * 31) + this.planId.hashCode()) * 31) + this.startDate.hashCode()) * 31) + this.teachers.hashCode()) * 31) + this.classType.hashCode()) * 31) + this.status.hashCode()) * 31) + this.startEndTime.hashCode()) * 31) + this.bizId.hashCode()) * 31) + this.platformType.hashCode();
    }

    public String toString() {
        return "Record(classId=" + this.classId + ", className=" + this.className + ", endDate=" + this.endDate + ", lessonNum=" + this.lessonNum + ", planId=" + this.planId + ", startDate=" + this.startDate + ", teachers=" + this.teachers + ", classType=" + this.classType + ", status=" + this.status + ", startEndTime=" + this.startEndTime + ", bizId=" + this.bizId + ", platformType=" + this.platformType + ')';
    }

    public Record(String str, String str2, String str3, String str4, String str5, String str6, List<Teacher> list, String str7, String str8, String str9, String str10, String str11) {
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        Intrinsics.checkNotNullParameter(str2, "className");
        Intrinsics.checkNotNullParameter(str3, "endDate");
        Intrinsics.checkNotNullParameter(str4, "lessonNum");
        Intrinsics.checkNotNullParameter(str5, LearnMaterialsListActivityKt.PLANID);
        Intrinsics.checkNotNullParameter(str6, "startDate");
        Intrinsics.checkNotNullParameter(list, "teachers");
        Intrinsics.checkNotNullParameter(str7, "classType");
        Intrinsics.checkNotNullParameter(str8, "status");
        Intrinsics.checkNotNullParameter(str9, "startEndTime");
        Intrinsics.checkNotNullParameter(str10, "bizId");
        Intrinsics.checkNotNullParameter(str11, "platformType");
        this.classId = str;
        this.className = str2;
        this.endDate = str3;
        this.lessonNum = str4;
        this.planId = str5;
        this.startDate = str6;
        this.teachers = list;
        this.classType = str7;
        this.status = str8;
        this.startEndTime = str9;
        this.bizId = str10;
        this.platformType = str11;
    }

    public final String getClassId() {
        return this.classId;
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final String getLessonNum() {
        return this.lessonNum;
    }

    public final String getPlanId() {
        return this.planId;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final List<Teacher> getTeachers() {
        return this.teachers;
    }

    public final String getClassType() {
        return this.classType;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getStartEndTime() {
        return this.startEndTime;
    }

    public final String getBizId() {
        return this.bizId;
    }

    public final String getPlatformType() {
        return this.platformType;
    }
}
