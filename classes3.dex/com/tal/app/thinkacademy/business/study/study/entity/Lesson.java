package com.tal.app.thinkacademy.business.study.study.entity;

import com.chad.library.adapter.base.entity.SectionEntity;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b=\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u001fJ\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010*J\t\u0010N\u001a\u00020\u001dHÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010*J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010*J\u0010\u0010V\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010*J \u0002\u0010W\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010XJ\u0013\u0010Y\u001a\u00020\u001d2\b\u0010Z\u001a\u0004\u0018\u00010[HÖ\u0003J\t\u0010\\\u001a\u00020\u000bHÖ\u0001J\u0006\u0010\f\u001a\u00020\u001dJ\u0006\u0010\n\u001a\u00020\u001dJ\u0006\u0010\u000e\u001a\u00020\u0003J\u000e\u0010]\u001a\u00020^2\u0006\u0010\n\u001a\u00020\u001dJ\t\u0010_\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010+\u001a\u0004\b\u001e\u0010*R\u001e\u0010\f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b\f\u0010*\"\u0004\b,\u0010-R\u0014\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010.R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b\n\u0010*\"\u0004\b/\u0010-R\u0014\u00100\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010#R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010#R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010#R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010#R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b;\u0010!R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010#R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010#R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010+\u001a\u0004\b>\u0010*R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010+\u001a\u0004\b?\u0010*¨\u0006`"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/Lesson;", "Lcom/chad/library/adapter/base/entity/SectionEntity;", "date", "", "classId", "bizId", "classDate", "classDateDesc", "endTimeDesc", "endTime", "isShow", "", "isChange", "lessonName", "orderNum", "planId", "startTime", "startTimeDesc", "status", "platformType", "assignment", "Lcom/tal/app/thinkacademy/business/study/study/entity/AssignmentEntity;", "previewQuestion", "material", "Lcom/tal/app/thinkacademy/business/study/study/entity/MaterialEntity;", "performance", "Lcom/tal/app/thinkacademy/business/study/study/entity/Performance;", "subPlatformType", "isHeader", "", "isAudition", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/study/study/entity/AssignmentEntity;Lcom/tal/app/thinkacademy/business/study/study/entity/AssignmentEntity;Lcom/tal/app/thinkacademy/business/study/study/entity/MaterialEntity;Lcom/tal/app/thinkacademy/business/study/study/entity/Performance;Ljava/lang/Integer;ZLjava/lang/Integer;)V", "getAssignment", "()Lcom/tal/app/thinkacademy/business/study/study/entity/AssignmentEntity;", "getBizId", "()Ljava/lang/String;", "getClassDate", "getClassDateDesc", "getClassId", "getDate", "getEndTime", "getEndTimeDesc", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "setChange", "(Ljava/lang/Integer;)V", "()Z", "setShow", "itemType", "getItemType", "()I", "getLessonName", "getMaterial", "()Lcom/tal/app/thinkacademy/business/study/study/entity/MaterialEntity;", "getOrderNum", "getPerformance", "()Lcom/tal/app/thinkacademy/business/study/study/entity/Performance;", "getPlanId", "getPlatformType", "getPreviewQuestion", "getStartTime", "getStartTimeDesc", "getStatus", "getSubPlatformType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/study/study/entity/AssignmentEntity;Lcom/tal/app/thinkacademy/business/study/study/entity/AssignmentEntity;Lcom/tal/app/thinkacademy/business/study/study/entity/MaterialEntity;Lcom/tal/app/thinkacademy/business/study/study/entity/Performance;Ljava/lang/Integer;ZLjava/lang/Integer;)Lcom/tal/app/thinkacademy/business/study/study/entity/Lesson;", "equals", "other", "", "hashCode", "setIsShow", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StudyPlanListEntity.kt */
public final class Lesson implements SectionEntity {
    private final AssignmentEntity assignment;
    private final String bizId;
    private final String classDate;
    private final String classDateDesc;
    private final String classId;
    private final String date;
    private final String endTime;
    private final String endTimeDesc;
    private final Integer isAudition;
    private Integer isChange;
    private final boolean isHeader;
    private Integer isShow;
    private final String lessonName;
    private final MaterialEntity material;
    private final String orderNum;
    private final Performance performance;
    private final String planId;
    private final String platformType;
    private final AssignmentEntity previewQuestion;
    private final String startTime;
    private final String startTimeDesc;
    private final Integer status;
    private final Integer subPlatformType;

    public Lesson() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (AssignmentEntity) null, (AssignmentEntity) null, (MaterialEntity) null, (Performance) null, (Integer) null, false, (Integer) null, 8388607, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Lesson copy$default(Lesson lesson, String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, Integer num2, String str8, String str9, String str10, String str11, String str12, Integer num3, String str13, AssignmentEntity assignmentEntity, AssignmentEntity assignmentEntity2, MaterialEntity materialEntity, Performance performance2, Integer num4, boolean z, Integer num5, int i, Object obj) {
        Lesson lesson2 = lesson;
        int i2 = i;
        return lesson.copy((i2 & 1) != 0 ? lesson2.date : str, (i2 & 2) != 0 ? lesson2.classId : str2, (i2 & 4) != 0 ? lesson2.bizId : str3, (i2 & 8) != 0 ? lesson2.classDate : str4, (i2 & 16) != 0 ? lesson2.classDateDesc : str5, (i2 & 32) != 0 ? lesson2.endTimeDesc : str6, (i2 & 64) != 0 ? lesson2.endTime : str7, (i2 & 128) != 0 ? lesson2.isShow : num, (i2 & 256) != 0 ? lesson2.isChange : num2, (i2 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? lesson2.lessonName : str8, (i2 & 1024) != 0 ? lesson2.orderNum : str9, (i2 & 2048) != 0 ? lesson2.planId : str10, (i2 & ConstantsKt.DEFAULT_BLOCK_SIZE) != 0 ? lesson2.startTime : str11, (i2 & ConstantsKt.DEFAULT_BUFFER_SIZE) != 0 ? lesson2.startTimeDesc : str12, (i2 & 16384) != 0 ? lesson2.status : num3, (i2 & 32768) != 0 ? lesson2.platformType : str13, (i2 & 65536) != 0 ? lesson2.assignment : assignmentEntity, (i2 & 131072) != 0 ? lesson2.previewQuestion : assignmentEntity2, (i2 & 262144) != 0 ? lesson2.material : materialEntity, (i2 & 524288) != 0 ? lesson2.performance : performance2, (i2 & 1048576) != 0 ? lesson2.subPlatformType : num4, (i2 & 2097152) != 0 ? lesson.isHeader() : z, (i2 & 4194304) != 0 ? lesson2.isAudition : num5);
    }

    public final String component1() {
        return this.date;
    }

    public final String component10() {
        return this.lessonName;
    }

    public final String component11() {
        return this.orderNum;
    }

    public final String component12() {
        return this.planId;
    }

    public final String component13() {
        return this.startTime;
    }

    public final String component14() {
        return this.startTimeDesc;
    }

    public final Integer component15() {
        return this.status;
    }

    public final String component16() {
        return this.platformType;
    }

    public final AssignmentEntity component17() {
        return this.assignment;
    }

    public final AssignmentEntity component18() {
        return this.previewQuestion;
    }

    public final MaterialEntity component19() {
        return this.material;
    }

    public final String component2() {
        return this.classId;
    }

    public final Performance component20() {
        return this.performance;
    }

    public final Integer component21() {
        return this.subPlatformType;
    }

    public final boolean component22() {
        return isHeader();
    }

    public final Integer component23() {
        return this.isAudition;
    }

    public final String component3() {
        return this.bizId;
    }

    public final String component4() {
        return this.classDate;
    }

    public final String component5() {
        return this.classDateDesc;
    }

    public final String component6() {
        return this.endTimeDesc;
    }

    public final String component7() {
        return this.endTime;
    }

    public final Integer component8() {
        return this.isShow;
    }

    public final Integer component9() {
        return this.isChange;
    }

    public final Lesson copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, Integer num2, String str8, String str9, String str10, String str11, String str12, Integer num3, String str13, AssignmentEntity assignmentEntity, AssignmentEntity assignmentEntity2, MaterialEntity materialEntity, Performance performance2, Integer num4, boolean z, Integer num5) {
        return new Lesson(str, str2, str3, str4, str5, str6, str7, num, num2, str8, str9, str10, str11, str12, num3, str13, assignmentEntity, assignmentEntity2, materialEntity, performance2, num4, z, num5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Lesson)) {
            return false;
        }
        Lesson lesson = (Lesson) obj;
        return Intrinsics.areEqual((Object) this.date, (Object) lesson.date) && Intrinsics.areEqual((Object) this.classId, (Object) lesson.classId) && Intrinsics.areEqual((Object) this.bizId, (Object) lesson.bizId) && Intrinsics.areEqual((Object) this.classDate, (Object) lesson.classDate) && Intrinsics.areEqual((Object) this.classDateDesc, (Object) lesson.classDateDesc) && Intrinsics.areEqual((Object) this.endTimeDesc, (Object) lesson.endTimeDesc) && Intrinsics.areEqual((Object) this.endTime, (Object) lesson.endTime) && Intrinsics.areEqual((Object) this.isShow, (Object) lesson.isShow) && Intrinsics.areEqual((Object) this.isChange, (Object) lesson.isChange) && Intrinsics.areEqual((Object) this.lessonName, (Object) lesson.lessonName) && Intrinsics.areEqual((Object) this.orderNum, (Object) lesson.orderNum) && Intrinsics.areEqual((Object) this.planId, (Object) lesson.planId) && Intrinsics.areEqual((Object) this.startTime, (Object) lesson.startTime) && Intrinsics.areEqual((Object) this.startTimeDesc, (Object) lesson.startTimeDesc) && Intrinsics.areEqual((Object) this.status, (Object) lesson.status) && Intrinsics.areEqual((Object) this.platformType, (Object) lesson.platformType) && Intrinsics.areEqual((Object) this.assignment, (Object) lesson.assignment) && Intrinsics.areEqual((Object) this.previewQuestion, (Object) lesson.previewQuestion) && Intrinsics.areEqual((Object) this.material, (Object) lesson.material) && Intrinsics.areEqual((Object) this.performance, (Object) lesson.performance) && Intrinsics.areEqual((Object) this.subPlatformType, (Object) lesson.subPlatformType) && isHeader() == lesson.isHeader() && Intrinsics.areEqual((Object) this.isAudition, (Object) lesson.isAudition);
    }

    public int hashCode() {
        String str = this.date;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.classId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.bizId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.classDate;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.classDateDesc;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.endTimeDesc;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.endTime;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num = this.isShow;
        int hashCode8 = (hashCode7 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.isChange;
        int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str8 = this.lessonName;
        int hashCode10 = (hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.orderNum;
        int hashCode11 = (hashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.planId;
        int hashCode12 = (hashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.startTime;
        int hashCode13 = (hashCode12 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.startTimeDesc;
        int hashCode14 = (hashCode13 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Integer num3 = this.status;
        int hashCode15 = (hashCode14 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str13 = this.platformType;
        int hashCode16 = (hashCode15 + (str13 == null ? 0 : str13.hashCode())) * 31;
        AssignmentEntity assignmentEntity = this.assignment;
        int hashCode17 = (hashCode16 + (assignmentEntity == null ? 0 : assignmentEntity.hashCode())) * 31;
        AssignmentEntity assignmentEntity2 = this.previewQuestion;
        int hashCode18 = (hashCode17 + (assignmentEntity2 == null ? 0 : assignmentEntity2.hashCode())) * 31;
        MaterialEntity materialEntity = this.material;
        int hashCode19 = (hashCode18 + (materialEntity == null ? 0 : materialEntity.hashCode())) * 31;
        Performance performance2 = this.performance;
        int hashCode20 = (hashCode19 + (performance2 == null ? 0 : performance2.hashCode())) * 31;
        Integer num4 = this.subPlatformType;
        int hashCode21 = (hashCode20 + (num4 == null ? 0 : num4.hashCode())) * 31;
        boolean isHeader2 = isHeader();
        if (isHeader2) {
            isHeader2 = true;
        }
        int i2 = (hashCode21 + (isHeader2 ? 1 : 0)) * 31;
        Integer num5 = this.isAudition;
        if (num5 != null) {
            i = num5.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "Lesson(date=" + this.date + ", classId=" + this.classId + ", bizId=" + this.bizId + ", classDate=" + this.classDate + ", classDateDesc=" + this.classDateDesc + ", endTimeDesc=" + this.endTimeDesc + ", endTime=" + this.endTime + ", isShow=" + this.isShow + ", isChange=" + this.isChange + ", lessonName=" + this.lessonName + ", orderNum=" + this.orderNum + ", planId=" + this.planId + ", startTime=" + this.startTime + ", startTimeDesc=" + this.startTimeDesc + ", status=" + this.status + ", platformType=" + this.platformType + ", assignment=" + this.assignment + ", previewQuestion=" + this.previewQuestion + ", material=" + this.material + ", performance=" + this.performance + ", subPlatformType=" + this.subPlatformType + ", isHeader=" + isHeader() + ", isAudition=" + this.isAudition + ')';
    }

    public Lesson(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num, Integer num2, String str8, String str9, String str10, String str11, String str12, Integer num3, String str13, AssignmentEntity assignmentEntity, AssignmentEntity assignmentEntity2, MaterialEntity materialEntity, Performance performance2, Integer num4, boolean z, Integer num5) {
        this.date = str;
        this.classId = str2;
        this.bizId = str3;
        this.classDate = str4;
        this.classDateDesc = str5;
        this.endTimeDesc = str6;
        this.endTime = str7;
        this.isShow = num;
        this.isChange = num2;
        this.lessonName = str8;
        this.orderNum = str9;
        this.planId = str10;
        this.startTime = str11;
        this.startTimeDesc = str12;
        this.status = num3;
        this.platformType = str13;
        this.assignment = assignmentEntity;
        this.previewQuestion = assignmentEntity2;
        this.material = materialEntity;
        this.performance = performance2;
        this.subPlatformType = num4;
        this.isHeader = z;
        this.isAudition = num5;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getClassId() {
        return this.classId;
    }

    public final String getBizId() {
        return this.bizId;
    }

    public final String getClassDate() {
        return this.classDate;
    }

    public final String getClassDateDesc() {
        return this.classDateDesc;
    }

    public final String getEndTimeDesc() {
        return this.endTimeDesc;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Lesson(java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.Integer r33, java.lang.Integer r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.Integer r40, java.lang.String r41, com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity r42, com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity r43, com.tal.app.thinkacademy.business.study.study.entity.MaterialEntity r44, com.tal.app.thinkacademy.business.study.study.entity.Performance r45, java.lang.Integer r46, boolean r47, java.lang.Integer r48, int r49, kotlin.jvm.internal.DefaultConstructorMarker r50) {
        /*
            r25 = this;
            r0 = r49
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r26
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            r3 = r2
            goto L_0x0014
        L_0x0012:
            r3 = r27
        L_0x0014:
            r4 = r0 & 4
            java.lang.String r5 = "1"
            if (r4 == 0) goto L_0x001c
            r4 = r5
            goto L_0x001e
        L_0x001c:
            r4 = r28
        L_0x001e:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0024
            r6 = r2
            goto L_0x0026
        L_0x0024:
            r6 = r29
        L_0x0026:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002e
        L_0x002c:
            r7 = r30
        L_0x002e:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0034
            r8 = r2
            goto L_0x0036
        L_0x0034:
            r8 = r31
        L_0x0036:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003c
            r9 = r2
            goto L_0x003e
        L_0x003c:
            r9 = r32
        L_0x003e:
            r10 = r0 & 128(0x80, float:1.794E-43)
            r11 = 0
            if (r10 == 0) goto L_0x0048
            java.lang.Integer r10 = java.lang.Integer.valueOf(r11)
            goto L_0x004a
        L_0x0048:
            r10 = r33
        L_0x004a:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x0053
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            goto L_0x0055
        L_0x0053:
            r12 = r34
        L_0x0055:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x005b
            r13 = r2
            goto L_0x005d
        L_0x005b:
            r13 = r35
        L_0x005d:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r5 = r36
        L_0x0064:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x006a
            r14 = r2
            goto L_0x006c
        L_0x006a:
            r14 = r37
        L_0x006c:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0072
            r15 = r2
            goto L_0x0074
        L_0x0072:
            r15 = r38
        L_0x0074:
            r11 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r11 == 0) goto L_0x007a
            r11 = r2
            goto L_0x007c
        L_0x007a:
            r11 = r39
        L_0x007c:
            r50 = r2
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0088
            r2 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x008a
        L_0x0088:
            r2 = r40
        L_0x008a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0094
            r16 = r50
            goto L_0x0096
        L_0x0094:
            r16 = r41
        L_0x0096:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            r18 = 0
            if (r17 == 0) goto L_0x00a1
            r17 = r18
            goto L_0x00a3
        L_0x00a1:
            r17 = r42
        L_0x00a3:
            r19 = 131072(0x20000, float:1.83671E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00ac
            r19 = r18
            goto L_0x00ae
        L_0x00ac:
            r19 = r43
        L_0x00ae:
            r20 = 262144(0x40000, float:3.67342E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b7
            r20 = r18
            goto L_0x00b9
        L_0x00b7:
            r20 = r44
        L_0x00b9:
            r21 = 524288(0x80000, float:7.34684E-40)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00c0
            goto L_0x00c2
        L_0x00c0:
            r18 = r45
        L_0x00c2:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00cf
            r21 = 0
            java.lang.Integer r22 = java.lang.Integer.valueOf(r21)
            goto L_0x00d3
        L_0x00cf:
            r21 = 0
            r22 = r46
        L_0x00d3:
            r23 = 2097152(0x200000, float:2.938736E-39)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00dc
            r23 = r21
            goto L_0x00de
        L_0x00dc:
            r23 = r47
        L_0x00de:
            r24 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r24
            if (r0 == 0) goto L_0x00e9
            java.lang.Integer r0 = java.lang.Integer.valueOf(r21)
            goto L_0x00eb
        L_0x00e9:
            r0 = r48
        L_0x00eb:
            r26 = r25
            r27 = r1
            r28 = r3
            r29 = r4
            r30 = r6
            r31 = r7
            r32 = r8
            r33 = r9
            r34 = r10
            r35 = r12
            r36 = r13
            r37 = r5
            r38 = r14
            r39 = r15
            r40 = r11
            r41 = r2
            r42 = r16
            r43 = r17
            r44 = r19
            r45 = r20
            r46 = r18
            r47 = r22
            r48 = r23
            r49 = r0
            r26.<init>(r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.entity.Lesson.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity, com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity, com.tal.app.thinkacademy.business.study.study.entity.MaterialEntity, com.tal.app.thinkacademy.business.study.study.entity.Performance, java.lang.Integer, boolean, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer isShow() {
        return this.isShow;
    }

    public final void setShow(Integer num) {
        this.isShow = num;
    }

    public final Integer isChange() {
        return this.isChange;
    }

    public final void setChange(Integer num) {
        this.isChange = num;
    }

    public final String getLessonName() {
        return this.lessonName;
    }

    public final String getOrderNum() {
        return this.orderNum;
    }

    public final String getPlanId() {
        return this.planId;
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

    public final String getPlatformType() {
        return this.platformType;
    }

    public final AssignmentEntity getAssignment() {
        return this.assignment;
    }

    public final AssignmentEntity getPreviewQuestion() {
        return this.previewQuestion;
    }

    public final MaterialEntity getMaterial() {
        return this.material;
    }

    public final Performance getPerformance() {
        return this.performance;
    }

    public final Integer getSubPlatformType() {
        return this.subPlatformType;
    }

    public boolean isHeader() {
        return this.isHeader;
    }

    public final Integer isAudition() {
        return this.isAudition;
    }

    /* renamed from: isShow  reason: collision with other method in class */
    public final boolean m435isShow() {
        Integer num = this.isShow;
        return num != null && num.intValue() == 1;
    }

    public final void setIsShow(boolean z) {
        this.isShow = Integer.valueOf(z ? 1 : 0);
    }

    /* renamed from: isChange  reason: collision with other method in class */
    public final boolean m434isChange() {
        Integer num = this.isChange;
        return num != null && num.intValue() == 1;
    }

    public final String orderNum() {
        String str = this.orderNum;
        if (str == null) {
            str = DbParams.GZIP_DATA_EVENT;
        }
        return str.length() <= 1 ? Intrinsics.stringPlus("0", this.orderNum) : String.valueOf(this.orderNum);
    }

    public int getItemType() {
        return SectionEntity.DefaultImpls.getItemType((SectionEntity) this);
    }
}
