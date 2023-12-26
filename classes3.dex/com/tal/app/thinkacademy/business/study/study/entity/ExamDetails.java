package com.tal.app.thinkacademy.business.study.study.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\b\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0016Jn\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001c\u0010\u0010¨\u0006+"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/ExamDetails;", "", "examStatus", "", "examName", "", "jumpParams", "Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;", "canViewReport", "", "supportAfterAnswer", "canViewTime", "reportURI", "status", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getCanViewReport", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCanViewTime", "()Ljava/lang/String;", "getExamName", "getExamStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getJumpParams", "()Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;", "getReportURI", "getStatus", "getSupportAfterAnswer", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/study/study/entity/ExamDetails;", "equals", "other", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassCalendarEntity.kt */
public final class ExamDetails {
    private final Boolean canViewReport;
    private final String canViewTime;
    private final String examName;
    private final Integer examStatus;
    private final JumpParamsEntity jumpParams;
    private final String reportURI;
    private final Integer status;
    private final Boolean supportAfterAnswer;

    public static /* synthetic */ ExamDetails copy$default(ExamDetails examDetails, Integer num, String str, JumpParamsEntity jumpParamsEntity, Boolean bool, Boolean bool2, String str2, String str3, Integer num2, int i, Object obj) {
        ExamDetails examDetails2 = examDetails;
        int i2 = i;
        return examDetails.copy((i2 & 1) != 0 ? examDetails2.examStatus : num, (i2 & 2) != 0 ? examDetails2.examName : str, (i2 & 4) != 0 ? examDetails2.jumpParams : jumpParamsEntity, (i2 & 8) != 0 ? examDetails2.canViewReport : bool, (i2 & 16) != 0 ? examDetails2.supportAfterAnswer : bool2, (i2 & 32) != 0 ? examDetails2.canViewTime : str2, (i2 & 64) != 0 ? examDetails2.reportURI : str3, (i2 & 128) != 0 ? examDetails2.status : num2);
    }

    public final Integer component1() {
        return this.examStatus;
    }

    public final String component2() {
        return this.examName;
    }

    public final JumpParamsEntity component3() {
        return this.jumpParams;
    }

    public final Boolean component4() {
        return this.canViewReport;
    }

    public final Boolean component5() {
        return this.supportAfterAnswer;
    }

    public final String component6() {
        return this.canViewTime;
    }

    public final String component7() {
        return this.reportURI;
    }

    public final Integer component8() {
        return this.status;
    }

    public final ExamDetails copy(Integer num, String str, JumpParamsEntity jumpParamsEntity, Boolean bool, Boolean bool2, String str2, String str3, Integer num2) {
        return new ExamDetails(num, str, jumpParamsEntity, bool, bool2, str2, str3, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExamDetails)) {
            return false;
        }
        ExamDetails examDetails = (ExamDetails) obj;
        return Intrinsics.areEqual((Object) this.examStatus, (Object) examDetails.examStatus) && Intrinsics.areEqual((Object) this.examName, (Object) examDetails.examName) && Intrinsics.areEqual((Object) this.jumpParams, (Object) examDetails.jumpParams) && Intrinsics.areEqual((Object) this.canViewReport, (Object) examDetails.canViewReport) && Intrinsics.areEqual((Object) this.supportAfterAnswer, (Object) examDetails.supportAfterAnswer) && Intrinsics.areEqual((Object) this.canViewTime, (Object) examDetails.canViewTime) && Intrinsics.areEqual((Object) this.reportURI, (Object) examDetails.reportURI) && Intrinsics.areEqual((Object) this.status, (Object) examDetails.status);
    }

    public int hashCode() {
        Integer num = this.examStatus;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.examName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        JumpParamsEntity jumpParamsEntity = this.jumpParams;
        int hashCode3 = (hashCode2 + (jumpParamsEntity == null ? 0 : jumpParamsEntity.hashCode())) * 31;
        Boolean bool = this.canViewReport;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.supportAfterAnswer;
        int hashCode5 = (hashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str2 = this.canViewTime;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.reportURI;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.status;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode7 + i;
    }

    public String toString() {
        return "ExamDetails(examStatus=" + this.examStatus + ", examName=" + this.examName + ", jumpParams=" + this.jumpParams + ", canViewReport=" + this.canViewReport + ", supportAfterAnswer=" + this.supportAfterAnswer + ", canViewTime=" + this.canViewTime + ", reportURI=" + this.reportURI + ", status=" + this.status + ')';
    }

    public ExamDetails(Integer num, String str, JumpParamsEntity jumpParamsEntity, Boolean bool, Boolean bool2, String str2, String str3, Integer num2) {
        this.examStatus = num;
        this.examName = str;
        this.jumpParams = jumpParamsEntity;
        this.canViewReport = bool;
        this.supportAfterAnswer = bool2;
        this.canViewTime = str2;
        this.reportURI = str3;
        this.status = num2;
    }

    public final Integer getExamStatus() {
        return this.examStatus;
    }

    public final String getExamName() {
        return this.examName;
    }

    public final JumpParamsEntity getJumpParams() {
        return this.jumpParams;
    }

    public final Boolean getCanViewReport() {
        return this.canViewReport;
    }

    public final Boolean getSupportAfterAnswer() {
        return this.supportAfterAnswer;
    }

    public final String getCanViewTime() {
        return this.canViewTime;
    }

    public final String getReportURI() {
        return this.reportURI;
    }

    public final Integer getStatus() {
        return this.status;
    }
}
