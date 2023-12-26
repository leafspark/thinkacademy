package com.tal.app.thinkacademy.business.study.study.entity;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.tal.app.thinkacademy.common.entity.LessonType;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bC\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010!J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010Q\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010R\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010S\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010-J\u0010\u0010Y\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jº\u0002\u0010[\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\\J\u0013\u0010]\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010`\u001a\u00020\u000bHÖ\u0001J\u0006\u0010a\u001a\u00020^J\u0006\u0010\f\u001a\u00020^J\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010/\u001a\u00020b2\u0006\u0010\f\u001a\u00020^J\t\u0010c\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010.\u001a\u0004\b\n\u0010-R\u001e\u0010\f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b\f\u0010-\"\u0004\b/\u00100R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010%R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u0015\u0010 \u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010.\u001a\u0004\b7\u0010-R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010%R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010#R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010%R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u0010%R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010.\u001a\u0004\b?\u0010-R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010.\u001a\u0004\b@\u0010-R\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010.\u001a\u0004\bA\u0010-¨\u0006d"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/LessonDetails;", "", "assignment", "Lcom/tal/app/thinkacademy/business/study/study/entity/AssignmentEntity;", "classDate", "", "classDateDesc", "classId", "endTime", "endTimeDesc", "isChange", "", "isShow", "lessonName", "lessonType", "lessonFlag", "material", "Lcom/tal/app/thinkacademy/business/study/study/entity/MaterialEntity;", "orderNum", "performance", "Lcom/tal/app/thinkacademy/business/study/study/entity/Performance;", "planId", "bizId", "platformType", "previewQuestion", "exam", "Lcom/tal/app/thinkacademy/business/study/study/entity/ExamDetails;", "startTime", "startTimeDesc", "status", "subPlatformType", "tutorId", "packageId", "(Lcom/tal/app/thinkacademy/business/study/study/entity/AssignmentEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/study/study/entity/MaterialEntity;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/study/study/entity/Performance;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/study/study/entity/AssignmentEntity;Lcom/tal/app/thinkacademy/business/study/study/entity/ExamDetails;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAssignment", "()Lcom/tal/app/thinkacademy/business/study/study/entity/AssignmentEntity;", "getBizId", "()Ljava/lang/String;", "getClassDate", "getClassDateDesc", "getClassId", "getEndTime", "getEndTimeDesc", "getExam", "()Lcom/tal/app/thinkacademy/business/study/study/entity/ExamDetails;", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "setShow", "(Ljava/lang/Integer;)V", "getLessonFlag", "getLessonName", "getLessonType", "getMaterial", "()Lcom/tal/app/thinkacademy/business/study/study/entity/MaterialEntity;", "getOrderNum", "getPackageId", "getPerformance", "()Lcom/tal/app/thinkacademy/business/study/study/entity/Performance;", "getPlanId", "getPlatformType", "getPreviewQuestion", "getStartTime", "getStartTimeDesc", "getStatus", "getSubPlatformType", "getTutorId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/tal/app/thinkacademy/business/study/study/entity/AssignmentEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/study/study/entity/MaterialEntity;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/study/study/entity/Performance;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/study/study/entity/AssignmentEntity;Lcom/tal/app/thinkacademy/business/study/study/entity/ExamDetails;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/study/study/entity/LessonDetails;", "equals", "", "other", "hashCode", "isAudition", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassCalendarEntity.kt */
public final class LessonDetails {
    private final AssignmentEntity assignment;
    private final String bizId;
    private final String classDate;
    private final String classDateDesc;
    private final String classId;
    private final String endTime;
    private final String endTimeDesc;
    private final ExamDetails exam;
    private final Integer isChange;
    private Integer isShow;
    private final String lessonFlag;
    private final String lessonName;
    private final String lessonType;
    private final MaterialEntity material;
    private final String orderNum;
    private final Integer packageId;
    private final Performance performance;
    private final String planId;
    private final String platformType;
    private final AssignmentEntity previewQuestion;
    private final String startTime;
    private final String startTimeDesc;
    private final Integer status;
    private final Integer subPlatformType;
    private final Integer tutorId;

    public static /* synthetic */ LessonDetails copy$default(LessonDetails lessonDetails, AssignmentEntity assignmentEntity, String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, String str6, String str7, String str8, MaterialEntity materialEntity, String str9, Performance performance2, String str10, String str11, String str12, AssignmentEntity assignmentEntity2, ExamDetails examDetails, String str13, String str14, Integer num3, Integer num4, Integer num5, Integer num6, int i, Object obj) {
        LessonDetails lessonDetails2 = lessonDetails;
        int i2 = i;
        return lessonDetails.copy((i2 & 1) != 0 ? lessonDetails2.assignment : assignmentEntity, (i2 & 2) != 0 ? lessonDetails2.classDate : str, (i2 & 4) != 0 ? lessonDetails2.classDateDesc : str2, (i2 & 8) != 0 ? lessonDetails2.classId : str3, (i2 & 16) != 0 ? lessonDetails2.endTime : str4, (i2 & 32) != 0 ? lessonDetails2.endTimeDesc : str5, (i2 & 64) != 0 ? lessonDetails2.isChange : num, (i2 & 128) != 0 ? lessonDetails2.isShow : num2, (i2 & 256) != 0 ? lessonDetails2.lessonName : str6, (i2 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? lessonDetails2.lessonType : str7, (i2 & 1024) != 0 ? lessonDetails2.lessonFlag : str8, (i2 & 2048) != 0 ? lessonDetails2.material : materialEntity, (i2 & ConstantsKt.DEFAULT_BLOCK_SIZE) != 0 ? lessonDetails2.orderNum : str9, (i2 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? lessonDetails2.performance : performance2, (i2 & 16384) != 0 ? lessonDetails2.planId : str10, (i2 & 32768) != 0 ? lessonDetails2.bizId : str11, (i2 & 65536) != 0 ? lessonDetails2.platformType : str12, (i2 & 131072) != 0 ? lessonDetails2.previewQuestion : assignmentEntity2, (i2 & 262144) != 0 ? lessonDetails2.exam : examDetails, (i2 & 524288) != 0 ? lessonDetails2.startTime : str13, (i2 & 1048576) != 0 ? lessonDetails2.startTimeDesc : str14, (i2 & 2097152) != 0 ? lessonDetails2.status : num3, (i2 & 4194304) != 0 ? lessonDetails2.subPlatformType : num4, (i2 & 8388608) != 0 ? lessonDetails2.tutorId : num5, (i2 & 16777216) != 0 ? lessonDetails2.packageId : num6);
    }

    public final AssignmentEntity component1() {
        return this.assignment;
    }

    public final String component10() {
        return this.lessonType;
    }

    public final String component11() {
        return this.lessonFlag;
    }

    public final MaterialEntity component12() {
        return this.material;
    }

    public final String component13() {
        return this.orderNum;
    }

    public final Performance component14() {
        return this.performance;
    }

    public final String component15() {
        return this.planId;
    }

    public final String component16() {
        return this.bizId;
    }

    public final String component17() {
        return this.platformType;
    }

    public final AssignmentEntity component18() {
        return this.previewQuestion;
    }

    public final ExamDetails component19() {
        return this.exam;
    }

    public final String component2() {
        return this.classDate;
    }

    public final String component20() {
        return this.startTime;
    }

    public final String component21() {
        return this.startTimeDesc;
    }

    public final Integer component22() {
        return this.status;
    }

    public final Integer component23() {
        return this.subPlatformType;
    }

    public final Integer component24() {
        return this.tutorId;
    }

    public final Integer component25() {
        return this.packageId;
    }

    public final String component3() {
        return this.classDateDesc;
    }

    public final String component4() {
        return this.classId;
    }

    public final String component5() {
        return this.endTime;
    }

    public final String component6() {
        return this.endTimeDesc;
    }

    public final Integer component7() {
        return this.isChange;
    }

    public final Integer component8() {
        return this.isShow;
    }

    public final String component9() {
        return this.lessonName;
    }

    public final LessonDetails copy(AssignmentEntity assignmentEntity, String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, String str6, String str7, String str8, MaterialEntity materialEntity, String str9, Performance performance2, String str10, String str11, String str12, AssignmentEntity assignmentEntity2, ExamDetails examDetails, String str13, String str14, Integer num3, Integer num4, Integer num5, Integer num6) {
        return new LessonDetails(assignmentEntity, str, str2, str3, str4, str5, num, num2, str6, str7, str8, materialEntity, str9, performance2, str10, str11, str12, assignmentEntity2, examDetails, str13, str14, num3, num4, num5, num6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LessonDetails)) {
            return false;
        }
        LessonDetails lessonDetails = (LessonDetails) obj;
        return Intrinsics.areEqual((Object) this.assignment, (Object) lessonDetails.assignment) && Intrinsics.areEqual((Object) this.classDate, (Object) lessonDetails.classDate) && Intrinsics.areEqual((Object) this.classDateDesc, (Object) lessonDetails.classDateDesc) && Intrinsics.areEqual((Object) this.classId, (Object) lessonDetails.classId) && Intrinsics.areEqual((Object) this.endTime, (Object) lessonDetails.endTime) && Intrinsics.areEqual((Object) this.endTimeDesc, (Object) lessonDetails.endTimeDesc) && Intrinsics.areEqual((Object) this.isChange, (Object) lessonDetails.isChange) && Intrinsics.areEqual((Object) this.isShow, (Object) lessonDetails.isShow) && Intrinsics.areEqual((Object) this.lessonName, (Object) lessonDetails.lessonName) && Intrinsics.areEqual((Object) this.lessonType, (Object) lessonDetails.lessonType) && Intrinsics.areEqual((Object) this.lessonFlag, (Object) lessonDetails.lessonFlag) && Intrinsics.areEqual((Object) this.material, (Object) lessonDetails.material) && Intrinsics.areEqual((Object) this.orderNum, (Object) lessonDetails.orderNum) && Intrinsics.areEqual((Object) this.performance, (Object) lessonDetails.performance) && Intrinsics.areEqual((Object) this.planId, (Object) lessonDetails.planId) && Intrinsics.areEqual((Object) this.bizId, (Object) lessonDetails.bizId) && Intrinsics.areEqual((Object) this.platformType, (Object) lessonDetails.platformType) && Intrinsics.areEqual((Object) this.previewQuestion, (Object) lessonDetails.previewQuestion) && Intrinsics.areEqual((Object) this.exam, (Object) lessonDetails.exam) && Intrinsics.areEqual((Object) this.startTime, (Object) lessonDetails.startTime) && Intrinsics.areEqual((Object) this.startTimeDesc, (Object) lessonDetails.startTimeDesc) && Intrinsics.areEqual((Object) this.status, (Object) lessonDetails.status) && Intrinsics.areEqual((Object) this.subPlatformType, (Object) lessonDetails.subPlatformType) && Intrinsics.areEqual((Object) this.tutorId, (Object) lessonDetails.tutorId) && Intrinsics.areEqual((Object) this.packageId, (Object) lessonDetails.packageId);
    }

    public int hashCode() {
        AssignmentEntity assignmentEntity = this.assignment;
        int i = 0;
        int hashCode = (assignmentEntity == null ? 0 : assignmentEntity.hashCode()) * 31;
        String str = this.classDate;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.classDateDesc;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.classId;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.endTime;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.endTimeDesc;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.isChange;
        int hashCode7 = (hashCode6 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.isShow;
        int hashCode8 = (hashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str6 = this.lessonName;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.lessonType;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.lessonFlag;
        int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        MaterialEntity materialEntity = this.material;
        int hashCode12 = (hashCode11 + (materialEntity == null ? 0 : materialEntity.hashCode())) * 31;
        String str9 = this.orderNum;
        int hashCode13 = (hashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Performance performance2 = this.performance;
        int hashCode14 = (hashCode13 + (performance2 == null ? 0 : performance2.hashCode())) * 31;
        String str10 = this.planId;
        int hashCode15 = (hashCode14 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.bizId;
        int hashCode16 = (hashCode15 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.platformType;
        int hashCode17 = (hashCode16 + (str12 == null ? 0 : str12.hashCode())) * 31;
        AssignmentEntity assignmentEntity2 = this.previewQuestion;
        int hashCode18 = (hashCode17 + (assignmentEntity2 == null ? 0 : assignmentEntity2.hashCode())) * 31;
        ExamDetails examDetails = this.exam;
        int hashCode19 = (hashCode18 + (examDetails == null ? 0 : examDetails.hashCode())) * 31;
        String str13 = this.startTime;
        int hashCode20 = (hashCode19 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.startTimeDesc;
        int hashCode21 = (hashCode20 + (str14 == null ? 0 : str14.hashCode())) * 31;
        Integer num3 = this.status;
        int hashCode22 = (hashCode21 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.subPlatformType;
        int hashCode23 = (hashCode22 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.tutorId;
        int hashCode24 = (hashCode23 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.packageId;
        if (num6 != null) {
            i = num6.hashCode();
        }
        return hashCode24 + i;
    }

    public String toString() {
        return "LessonDetails(assignment=" + this.assignment + ", classDate=" + this.classDate + ", classDateDesc=" + this.classDateDesc + ", classId=" + this.classId + ", endTime=" + this.endTime + ", endTimeDesc=" + this.endTimeDesc + ", isChange=" + this.isChange + ", isShow=" + this.isShow + ", lessonName=" + this.lessonName + ", lessonType=" + this.lessonType + ", lessonFlag=" + this.lessonFlag + ", material=" + this.material + ", orderNum=" + this.orderNum + ", performance=" + this.performance + ", planId=" + this.planId + ", bizId=" + this.bizId + ", platformType=" + this.platformType + ", previewQuestion=" + this.previewQuestion + ", exam=" + this.exam + ", startTime=" + this.startTime + ", startTimeDesc=" + this.startTimeDesc + ", status=" + this.status + ", subPlatformType=" + this.subPlatformType + ", tutorId=" + this.tutorId + ", packageId=" + this.packageId + ')';
    }

    public LessonDetails(AssignmentEntity assignmentEntity, String str, String str2, String str3, String str4, String str5, Integer num, Integer num2, String str6, String str7, String str8, MaterialEntity materialEntity, String str9, Performance performance2, String str10, String str11, String str12, AssignmentEntity assignmentEntity2, ExamDetails examDetails, String str13, String str14, Integer num3, Integer num4, Integer num5, Integer num6) {
        this.assignment = assignmentEntity;
        this.classDate = str;
        this.classDateDesc = str2;
        this.classId = str3;
        this.endTime = str4;
        this.endTimeDesc = str5;
        this.isChange = num;
        this.isShow = num2;
        this.lessonName = str6;
        this.lessonType = str7;
        this.lessonFlag = str8;
        this.material = materialEntity;
        this.orderNum = str9;
        this.performance = performance2;
        this.planId = str10;
        this.bizId = str11;
        this.platformType = str12;
        this.previewQuestion = assignmentEntity2;
        this.exam = examDetails;
        this.startTime = str13;
        this.startTimeDesc = str14;
        this.status = num3;
        this.subPlatformType = num4;
        this.tutorId = num5;
        this.packageId = num6;
    }

    public final AssignmentEntity getAssignment() {
        return this.assignment;
    }

    public final String getClassDate() {
        return this.classDate;
    }

    public final String getClassDateDesc() {
        return this.classDateDesc;
    }

    public final String getClassId() {
        return this.classId;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getEndTimeDesc() {
        return this.endTimeDesc;
    }

    public final Integer isChange() {
        return this.isChange;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LessonDetails(com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.Integer r35, java.lang.Integer r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, com.tal.app.thinkacademy.business.study.study.entity.MaterialEntity r40, java.lang.String r41, com.tal.app.thinkacademy.business.study.study.entity.Performance r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity r46, com.tal.app.thinkacademy.business.study.study.entity.ExamDetails r47, java.lang.String r48, java.lang.String r49, java.lang.Integer r50, java.lang.Integer r51, java.lang.Integer r52, java.lang.Integer r53, int r54, kotlin.jvm.internal.DefaultConstructorMarker r55) {
        /*
            r28 = this;
            r0 = r54
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x000d
            r1 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10 = r1
            goto L_0x000f
        L_0x000d:
            r10 = r36
        L_0x000f:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0017
            java.lang.String r0 = "1"
            r15 = r0
            goto L_0x0019
        L_0x0017:
            r15 = r41
        L_0x0019:
            r2 = r28
            r3 = r29
            r4 = r30
            r5 = r31
            r6 = r32
            r7 = r33
            r8 = r34
            r9 = r35
            r11 = r37
            r12 = r38
            r13 = r39
            r14 = r40
            r16 = r42
            r17 = r43
            r18 = r44
            r19 = r45
            r20 = r46
            r21 = r47
            r22 = r48
            r23 = r49
            r24 = r50
            r25 = r51
            r26 = r52
            r27 = r53
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.entity.LessonDetails.<init>(com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, com.tal.app.thinkacademy.business.study.study.entity.MaterialEntity, java.lang.String, com.tal.app.thinkacademy.business.study.study.entity.Performance, java.lang.String, java.lang.String, java.lang.String, com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity, com.tal.app.thinkacademy.business.study.study.entity.ExamDetails, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer isShow() {
        return this.isShow;
    }

    public final void setShow(Integer num) {
        this.isShow = num;
    }

    public final String getLessonName() {
        return this.lessonName;
    }

    public final String getLessonType() {
        return this.lessonType;
    }

    public final String getLessonFlag() {
        return this.lessonFlag;
    }

    public final MaterialEntity getMaterial() {
        return this.material;
    }

    public final String getOrderNum() {
        return this.orderNum;
    }

    public final Performance getPerformance() {
        return this.performance;
    }

    public final String getPlanId() {
        return this.planId;
    }

    public final String getBizId() {
        return this.bizId;
    }

    public final String getPlatformType() {
        return this.platformType;
    }

    public final AssignmentEntity getPreviewQuestion() {
        return this.previewQuestion;
    }

    public final ExamDetails getExam() {
        return this.exam;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getStartTimeDesc() {
        return this.startTimeDesc;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Integer getSubPlatformType() {
        return this.subPlatformType;
    }

    public final Integer getTutorId() {
        return this.tutorId;
    }

    public final Integer getPackageId() {
        return this.packageId;
    }

    /* renamed from: isShow  reason: collision with other method in class */
    public final boolean m436isShow() {
        Integer num = this.isShow;
        return num != null && num.intValue() == 1;
    }

    public final void setShow(boolean z) {
        this.isShow = Integer.valueOf(z ? 1 : 0);
    }

    public final String orderNum() {
        String str = this.orderNum;
        if (str == null) {
            str = DbParams.GZIP_DATA_EVENT;
        }
        return str.length() <= 1 ? Intrinsics.stringPlus("0", this.orderNum) : String.valueOf(this.orderNum);
    }

    public final boolean isAudition() {
        return TextUtils.equals(this.lessonType, LessonType.AUDITION.name());
    }
}
