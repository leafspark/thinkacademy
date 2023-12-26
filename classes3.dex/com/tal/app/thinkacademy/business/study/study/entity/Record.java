package com.tal.app.thinkacademy.business.study.study.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.tal.app.thinkacademy.business.study.study.SwitchType;
import com.tal.app.thinkacademy.business.study.study.materials.LearnMaterialsListActivityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BÉ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\t\u00109\u001a\u00020\u0003HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0006HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0006HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003JÍ\u0001\u0010K\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001J\u0013\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010OHÖ\u0003J\t\u0010P\u001a\u00020\u0006HÖ\u0001J\t\u0010Q\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u001a\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010%R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010-R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010-R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001eR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001eR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001e¨\u0006R"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/Record;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "classId", "", "platformType", "cardStyle", "", "className", "startDate", "endDate", "nextLessonTime", "lastLessonStartTime", "tag", "teachers", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/Teacher;", "currentLesson", "Lcom/tal/app/thinkacademy/business/study/study/entity/Course;", "timeDesc", "timeDesc2", "itemType", "parentTitle", "switchTip", "switchBtn", "switchType", "Lcom/tal/app/thinkacademy/business/study/study/SwitchType;", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/tal/app/thinkacademy/business/study/study/entity/Course;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/study/study/SwitchType;)V", "getCardStyle", "()I", "getClassId", "()Ljava/lang/String;", "getClassName", "getCurrentLesson", "()Lcom/tal/app/thinkacademy/business/study/study/entity/Course;", "getEndDate", "getItemType", "setItemType", "(I)V", "getLastLessonStartTime", "getNextLessonTime", "getParentTitle", "getPlatformType", "getStartDate", "getSwitchBtn", "setSwitchBtn", "(Ljava/lang/String;)V", "getSwitchTip", "setSwitchTip", "getSwitchType", "()Lcom/tal/app/thinkacademy/business/study/study/SwitchType;", "setSwitchType", "(Lcom/tal/app/thinkacademy/business/study/study/SwitchType;)V", "getTag", "getTeachers", "()Ljava/util/List;", "getTimeDesc", "getTimeDesc2", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassListEntity.kt */
public final class Record implements MultiItemEntity {
    private final int cardStyle;
    private final String classId;
    private final String className;
    private final Course currentLesson;
    private final String endDate;
    private int itemType;
    private final String lastLessonStartTime;
    private final String nextLessonTime;
    private final String parentTitle;
    private final String platformType;
    private final String startDate;
    private String switchBtn;
    private String switchTip;
    private SwitchType switchType;
    private final String tag;
    private final List<Teacher> teachers;
    private final String timeDesc;
    private final String timeDesc2;

    public Record() {
        this((String) null, (String) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (Course) null, (String) null, (String) null, 0, (String) null, (String) null, (String) null, (SwitchType) null, 262143, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Record copy$default(Record record, String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, String str8, List list, Course course, String str9, String str10, int i2, String str11, String str12, String str13, SwitchType switchType2, int i3, Object obj) {
        Record record2 = record;
        int i4 = i3;
        return record.copy((i4 & 1) != 0 ? record2.classId : str, (i4 & 2) != 0 ? record2.platformType : str2, (i4 & 4) != 0 ? record2.cardStyle : i, (i4 & 8) != 0 ? record2.className : str3, (i4 & 16) != 0 ? record2.startDate : str4, (i4 & 32) != 0 ? record2.endDate : str5, (i4 & 64) != 0 ? record2.nextLessonTime : str6, (i4 & 128) != 0 ? record2.lastLessonStartTime : str7, (i4 & 256) != 0 ? record2.tag : str8, (i4 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? record2.teachers : list, (i4 & 1024) != 0 ? record2.currentLesson : course, (i4 & 2048) != 0 ? record2.timeDesc : str9, (i4 & ConstantsKt.DEFAULT_BLOCK_SIZE) != 0 ? record2.timeDesc2 : str10, (i4 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? record.getItemType() : i2, (i4 & 16384) != 0 ? record2.parentTitle : str11, (i4 & 32768) != 0 ? record2.switchTip : str12, (i4 & 65536) != 0 ? record2.switchBtn : str13, (i4 & 131072) != 0 ? record2.switchType : switchType2);
    }

    public final String component1() {
        return this.classId;
    }

    public final List<Teacher> component10() {
        return this.teachers;
    }

    public final Course component11() {
        return this.currentLesson;
    }

    public final String component12() {
        return this.timeDesc;
    }

    public final String component13() {
        return this.timeDesc2;
    }

    public final int component14() {
        return getItemType();
    }

    public final String component15() {
        return this.parentTitle;
    }

    public final String component16() {
        return this.switchTip;
    }

    public final String component17() {
        return this.switchBtn;
    }

    public final SwitchType component18() {
        return this.switchType;
    }

    public final String component2() {
        return this.platformType;
    }

    public final int component3() {
        return this.cardStyle;
    }

    public final String component4() {
        return this.className;
    }

    public final String component5() {
        return this.startDate;
    }

    public final String component6() {
        return this.endDate;
    }

    public final String component7() {
        return this.nextLessonTime;
    }

    public final String component8() {
        return this.lastLessonStartTime;
    }

    public final String component9() {
        return this.tag;
    }

    public final Record copy(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, String str8, List<Teacher> list, Course course, String str9, String str10, int i2, String str11, String str12, String str13, SwitchType switchType2) {
        String str14 = str;
        Intrinsics.checkNotNullParameter(str14, LearnMaterialsListActivityKt.CLASSID);
        Intrinsics.checkNotNullParameter(str2, "platformType");
        Intrinsics.checkNotNullParameter(str3, "className");
        Intrinsics.checkNotNullParameter(str4, "startDate");
        Intrinsics.checkNotNullParameter(str5, "endDate");
        Intrinsics.checkNotNullParameter(str6, "nextLessonTime");
        Intrinsics.checkNotNullParameter(str7, "lastLessonStartTime");
        Intrinsics.checkNotNullParameter(str8, "tag");
        Intrinsics.checkNotNullParameter(list, "teachers");
        Intrinsics.checkNotNullParameter(str9, "timeDesc");
        Intrinsics.checkNotNullParameter(str10, "timeDesc2");
        return new Record(str14, str2, i, str3, str4, str5, str6, str7, str8, list, course, str9, str10, i2, str11, str12, str13, switchType2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Record)) {
            return false;
        }
        Record record = (Record) obj;
        return Intrinsics.areEqual((Object) this.classId, (Object) record.classId) && Intrinsics.areEqual((Object) this.platformType, (Object) record.platformType) && this.cardStyle == record.cardStyle && Intrinsics.areEqual((Object) this.className, (Object) record.className) && Intrinsics.areEqual((Object) this.startDate, (Object) record.startDate) && Intrinsics.areEqual((Object) this.endDate, (Object) record.endDate) && Intrinsics.areEqual((Object) this.nextLessonTime, (Object) record.nextLessonTime) && Intrinsics.areEqual((Object) this.lastLessonStartTime, (Object) record.lastLessonStartTime) && Intrinsics.areEqual((Object) this.tag, (Object) record.tag) && Intrinsics.areEqual((Object) this.teachers, (Object) record.teachers) && Intrinsics.areEqual((Object) this.currentLesson, (Object) record.currentLesson) && Intrinsics.areEqual((Object) this.timeDesc, (Object) record.timeDesc) && Intrinsics.areEqual((Object) this.timeDesc2, (Object) record.timeDesc2) && getItemType() == record.getItemType() && Intrinsics.areEqual((Object) this.parentTitle, (Object) record.parentTitle) && Intrinsics.areEqual((Object) this.switchTip, (Object) record.switchTip) && Intrinsics.areEqual((Object) this.switchBtn, (Object) record.switchBtn) && this.switchType == record.switchType;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((this.classId.hashCode() * 31) + this.platformType.hashCode()) * 31) + this.cardStyle) * 31) + this.className.hashCode()) * 31) + this.startDate.hashCode()) * 31) + this.endDate.hashCode()) * 31) + this.nextLessonTime.hashCode()) * 31) + this.lastLessonStartTime.hashCode()) * 31) + this.tag.hashCode()) * 31) + this.teachers.hashCode()) * 31;
        Course course = this.currentLesson;
        int i = 0;
        int hashCode2 = (((((((hashCode + (course == null ? 0 : course.hashCode())) * 31) + this.timeDesc.hashCode()) * 31) + this.timeDesc2.hashCode()) * 31) + getItemType()) * 31;
        String str = this.parentTitle;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.switchTip;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.switchBtn;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        SwitchType switchType2 = this.switchType;
        if (switchType2 != null) {
            i = switchType2.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "Record(classId=" + this.classId + ", platformType=" + this.platformType + ", cardStyle=" + this.cardStyle + ", className=" + this.className + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ", nextLessonTime=" + this.nextLessonTime + ", lastLessonStartTime=" + this.lastLessonStartTime + ", tag=" + this.tag + ", teachers=" + this.teachers + ", currentLesson=" + this.currentLesson + ", timeDesc=" + this.timeDesc + ", timeDesc2=" + this.timeDesc2 + ", itemType=" + getItemType() + ", parentTitle=" + this.parentTitle + ", switchTip=" + this.switchTip + ", switchBtn=" + this.switchBtn + ", switchType=" + this.switchType + ')';
    }

    public Record(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, String str8, List<Teacher> list, Course course, String str9, String str10, int i2, String str11, String str12, String str13, SwitchType switchType2) {
        String str14 = str3;
        String str15 = str4;
        String str16 = str5;
        String str17 = str6;
        String str18 = str7;
        String str19 = str8;
        List<Teacher> list2 = list;
        String str20 = str9;
        String str21 = str10;
        Intrinsics.checkNotNullParameter(str, LearnMaterialsListActivityKt.CLASSID);
        Intrinsics.checkNotNullParameter(str2, "platformType");
        Intrinsics.checkNotNullParameter(str14, "className");
        Intrinsics.checkNotNullParameter(str15, "startDate");
        Intrinsics.checkNotNullParameter(str16, "endDate");
        Intrinsics.checkNotNullParameter(str17, "nextLessonTime");
        Intrinsics.checkNotNullParameter(str18, "lastLessonStartTime");
        Intrinsics.checkNotNullParameter(str19, "tag");
        Intrinsics.checkNotNullParameter(list2, "teachers");
        Intrinsics.checkNotNullParameter(str20, "timeDesc");
        Intrinsics.checkNotNullParameter(str21, "timeDesc2");
        this.classId = str;
        this.platformType = str2;
        this.cardStyle = i;
        this.className = str14;
        this.startDate = str15;
        this.endDate = str16;
        this.nextLessonTime = str17;
        this.lastLessonStartTime = str18;
        this.tag = str19;
        this.teachers = list2;
        this.currentLesson = course;
        this.timeDesc = str20;
        this.timeDesc2 = str21;
        this.itemType = i2;
        this.parentTitle = str11;
        this.switchTip = str12;
        this.switchBtn = str13;
        this.switchType = switchType2;
    }

    public final String getClassId() {
        return this.classId;
    }

    public final String getPlatformType() {
        return this.platformType;
    }

    public final int getCardStyle() {
        return this.cardStyle;
    }

    public final String getClassName() {
        return this.className;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final String getNextLessonTime() {
        return this.nextLessonTime;
    }

    public final String getLastLessonStartTime() {
        return this.lastLessonStartTime;
    }

    public final String getTag() {
        return this.tag;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Record(java.lang.String r24, java.lang.String r25, int r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.util.List r33, com.tal.app.thinkacademy.business.study.study.entity.Course r34, java.lang.String r35, java.lang.String r36, int r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, com.tal.app.thinkacademy.business.study.study.SwitchType r41, int r42, kotlin.jvm.internal.DefaultConstructorMarker r43) {
        /*
            r23 = this;
            r0 = r42
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r24
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            r3 = r2
            goto L_0x0014
        L_0x0012:
            r3 = r25
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = 1
            goto L_0x001c
        L_0x001a:
            r4 = r26
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0022
            r5 = r2
            goto L_0x0024
        L_0x0022:
            r5 = r27
        L_0x0024:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002a
            r6 = r2
            goto L_0x002c
        L_0x002a:
            r6 = r28
        L_0x002c:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0032
            r7 = r2
            goto L_0x0034
        L_0x0032:
            r7 = r29
        L_0x0034:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003a
            r8 = r2
            goto L_0x003c
        L_0x003a:
            r8 = r30
        L_0x003c:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0042
            r9 = r2
            goto L_0x0044
        L_0x0042:
            r9 = r31
        L_0x0044:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004a
            r10 = r2
            goto L_0x004c
        L_0x004a:
            r10 = r32
        L_0x004c:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0058
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.util.List r11 = (java.util.List) r11
            goto L_0x005a
        L_0x0058:
            r11 = r33
        L_0x005a:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x008b
            com.tal.app.thinkacademy.business.study.study.entity.Course r12 = new com.tal.app.thinkacademy.business.study.study.entity.Course
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 255(0xff, float:3.57E-43)
            r22 = 0
            r24 = r12
            r25 = r13
            r26 = r14
            r27 = r15
            r28 = r16
            r29 = r17
            r30 = r18
            r31 = r19
            r32 = r20
            r33 = r21
            r34 = r22
            r24.<init>(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            goto L_0x008d
        L_0x008b:
            r12 = r34
        L_0x008d:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0093
            r13 = r2
            goto L_0x0095
        L_0x0093:
            r13 = r35
        L_0x0095:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x009b
            r14 = r2
            goto L_0x009d
        L_0x009b:
            r14 = r36
        L_0x009d:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x00a3
            r15 = 0
            goto L_0x00a5
        L_0x00a3:
            r15 = r37
        L_0x00a5:
            r43 = r2
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x00ae
            r2 = r43
            goto L_0x00b0
        L_0x00ae:
            r2 = r38
        L_0x00b0:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x00ba
            r16 = r43
            goto L_0x00bc
        L_0x00ba:
            r16 = r39
        L_0x00bc:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x00c5
            r17 = r43
            goto L_0x00c7
        L_0x00c5:
            r17 = r40
        L_0x00c7:
            r18 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r18
            if (r0 == 0) goto L_0x00d0
            com.tal.app.thinkacademy.business.study.study.SwitchType r0 = com.tal.app.thinkacademy.business.study.study.SwitchType.Account
            goto L_0x00d2
        L_0x00d0:
            r0 = r41
        L_0x00d2:
            r24 = r23
            r25 = r1
            r26 = r3
            r27 = r4
            r28 = r5
            r29 = r6
            r30 = r7
            r31 = r8
            r32 = r9
            r33 = r10
            r34 = r11
            r35 = r12
            r36 = r13
            r37 = r14
            r38 = r15
            r39 = r2
            r40 = r16
            r41 = r17
            r42 = r0
            r24.<init>(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.entity.Record.<init>(java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, com.tal.app.thinkacademy.business.study.study.entity.Course, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, com.tal.app.thinkacademy.business.study.study.SwitchType, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<Teacher> getTeachers() {
        return this.teachers;
    }

    public final Course getCurrentLesson() {
        return this.currentLesson;
    }

    public final String getTimeDesc() {
        return this.timeDesc;
    }

    public final String getTimeDesc2() {
        return this.timeDesc2;
    }

    public int getItemType() {
        return this.itemType;
    }

    public void setItemType(int i) {
        this.itemType = i;
    }

    public final String getParentTitle() {
        return this.parentTitle;
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
