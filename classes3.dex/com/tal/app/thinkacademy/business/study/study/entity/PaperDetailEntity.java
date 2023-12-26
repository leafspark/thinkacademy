package com.tal.app.thinkacademy.business.study.study.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b&\b\b\u0018\u00002\u00020\u0001Bo\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0002\u0010\u0011J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010'\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0010\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\t2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0007HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u000f\u0010\u0019R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b!\u0010\u0016¨\u00062"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/PaperDetailEntity;", "", "deadline", "", "duration", "homeworkUrl", "homeworkStatus", "", "limitTime", "", "questions", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/Question;", "title", "totalScore", "isReward", "reportType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;I)V", "getDeadline", "()Ljava/lang/String;", "getDuration", "getHomeworkStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHomeworkUrl", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLimitTime", "getQuestions", "()Ljava/util/List;", "getReportType", "()I", "getTitle", "getTotalScore", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;I)Lcom/tal/app/thinkacademy/business/study/study/entity/PaperDetailEntity;", "equals", "other", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaperDetailEntity.kt */
public final class PaperDetailEntity {
    private final String deadline;
    private final String duration;
    private final Integer homeworkStatus;
    private final String homeworkUrl;
    private final Boolean isReward;
    private final Boolean limitTime;
    private final List<Question> questions;
    private final int reportType;
    private final String title;
    private final Integer totalScore;

    public static /* synthetic */ PaperDetailEntity copy$default(PaperDetailEntity paperDetailEntity, String str, String str2, String str3, Integer num, Boolean bool, List list, String str4, Integer num2, Boolean bool2, int i, int i2, Object obj) {
        PaperDetailEntity paperDetailEntity2 = paperDetailEntity;
        int i3 = i2;
        return paperDetailEntity.copy((i3 & 1) != 0 ? paperDetailEntity2.deadline : str, (i3 & 2) != 0 ? paperDetailEntity2.duration : str2, (i3 & 4) != 0 ? paperDetailEntity2.homeworkUrl : str3, (i3 & 8) != 0 ? paperDetailEntity2.homeworkStatus : num, (i3 & 16) != 0 ? paperDetailEntity2.limitTime : bool, (i3 & 32) != 0 ? paperDetailEntity2.questions : list, (i3 & 64) != 0 ? paperDetailEntity2.title : str4, (i3 & 128) != 0 ? paperDetailEntity2.totalScore : num2, (i3 & 256) != 0 ? paperDetailEntity2.isReward : bool2, (i3 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? paperDetailEntity2.reportType : i);
    }

    public final String component1() {
        return this.deadline;
    }

    public final int component10() {
        return this.reportType;
    }

    public final String component2() {
        return this.duration;
    }

    public final String component3() {
        return this.homeworkUrl;
    }

    public final Integer component4() {
        return this.homeworkStatus;
    }

    public final Boolean component5() {
        return this.limitTime;
    }

    public final List<Question> component6() {
        return this.questions;
    }

    public final String component7() {
        return this.title;
    }

    public final Integer component8() {
        return this.totalScore;
    }

    public final Boolean component9() {
        return this.isReward;
    }

    public final PaperDetailEntity copy(String str, String str2, String str3, Integer num, Boolean bool, List<Question> list, String str4, Integer num2, Boolean bool2, int i) {
        return new PaperDetailEntity(str, str2, str3, num, bool, list, str4, num2, bool2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaperDetailEntity)) {
            return false;
        }
        PaperDetailEntity paperDetailEntity = (PaperDetailEntity) obj;
        return Intrinsics.areEqual((Object) this.deadline, (Object) paperDetailEntity.deadline) && Intrinsics.areEqual((Object) this.duration, (Object) paperDetailEntity.duration) && Intrinsics.areEqual((Object) this.homeworkUrl, (Object) paperDetailEntity.homeworkUrl) && Intrinsics.areEqual((Object) this.homeworkStatus, (Object) paperDetailEntity.homeworkStatus) && Intrinsics.areEqual((Object) this.limitTime, (Object) paperDetailEntity.limitTime) && Intrinsics.areEqual((Object) this.questions, (Object) paperDetailEntity.questions) && Intrinsics.areEqual((Object) this.title, (Object) paperDetailEntity.title) && Intrinsics.areEqual((Object) this.totalScore, (Object) paperDetailEntity.totalScore) && Intrinsics.areEqual((Object) this.isReward, (Object) paperDetailEntity.isReward) && this.reportType == paperDetailEntity.reportType;
    }

    public int hashCode() {
        String str = this.deadline;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.duration;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.homeworkUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.homeworkStatus;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.limitTime;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<Question> list = this.questions;
        int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.title;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num2 = this.totalScore;
        int hashCode8 = (hashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool2 = this.isReward;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        return ((hashCode8 + i) * 31) + this.reportType;
    }

    public String toString() {
        return "PaperDetailEntity(deadline=" + this.deadline + ", duration=" + this.duration + ", homeworkUrl=" + this.homeworkUrl + ", homeworkStatus=" + this.homeworkStatus + ", limitTime=" + this.limitTime + ", questions=" + this.questions + ", title=" + this.title + ", totalScore=" + this.totalScore + ", isReward=" + this.isReward + ", reportType=" + this.reportType + ')';
    }

    public PaperDetailEntity(String str, String str2, String str3, Integer num, Boolean bool, List<Question> list, String str4, Integer num2, Boolean bool2, int i) {
        this.deadline = str;
        this.duration = str2;
        this.homeworkUrl = str3;
        this.homeworkStatus = num;
        this.limitTime = bool;
        this.questions = list;
        this.title = str4;
        this.totalScore = num2;
        this.isReward = bool2;
        this.reportType = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaperDetailEntity(String str, String str2, String str3, Integer num, Boolean bool, List list, String str4, Integer num2, Boolean bool2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, num, bool, list, str4, num2, bool2, (i2 & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? 0 : i);
    }

    public final String getDeadline() {
        return this.deadline;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getHomeworkUrl() {
        return this.homeworkUrl;
    }

    public final Integer getHomeworkStatus() {
        return this.homeworkStatus;
    }

    public final Boolean getLimitTime() {
        return this.limitTime;
    }

    public final List<Question> getQuestions() {
        return this.questions;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getTotalScore() {
        return this.totalScore;
    }

    public final Boolean isReward() {
        return this.isReward;
    }

    public final int getReportType() {
        return this.reportType;
    }
}
