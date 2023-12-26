package com.tal.app.thinkacademy.business.study.study.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b#\b\b\u0018\u00002\u00020\u0001BG\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\rJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\\\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\bHÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0004\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006/"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedPaperDetailEntity;", "", "title", "", "isSubmit", "", "duration", "totalScore", "", "homeworkUrl", "questions", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/Question;", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getDuration", "()Ljava/lang/String;", "setDuration", "(Ljava/lang/String;)V", "getHomeworkUrl", "setHomeworkUrl", "()Ljava/lang/Boolean;", "setSubmit", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getQuestions", "()Ljava/util/List;", "setQuestions", "(Ljava/util/List;)V", "getTitle", "setTitle", "getTotalScore", "()Ljava/lang/Integer;", "setTotalScore", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedPaperDetailEntity;", "equals", "other", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedPaperDetailEntity.kt */
public final class RecordedPaperDetailEntity {
    private String duration;
    private String homeworkUrl;
    private Boolean isSubmit;
    private List<Question> questions;
    private String title;
    private Integer totalScore;

    public static /* synthetic */ RecordedPaperDetailEntity copy$default(RecordedPaperDetailEntity recordedPaperDetailEntity, String str, Boolean bool, String str2, Integer num, String str3, List<Question> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recordedPaperDetailEntity.title;
        }
        if ((i & 2) != 0) {
            bool = recordedPaperDetailEntity.isSubmit;
        }
        Boolean bool2 = bool;
        if ((i & 4) != 0) {
            str2 = recordedPaperDetailEntity.duration;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            num = recordedPaperDetailEntity.totalScore;
        }
        Integer num2 = num;
        if ((i & 16) != 0) {
            str3 = recordedPaperDetailEntity.homeworkUrl;
        }
        String str5 = str3;
        if ((i & 32) != 0) {
            list = recordedPaperDetailEntity.questions;
        }
        return recordedPaperDetailEntity.copy(str, bool2, str4, num2, str5, list);
    }

    public final String component1() {
        return this.title;
    }

    public final Boolean component2() {
        return this.isSubmit;
    }

    public final String component3() {
        return this.duration;
    }

    public final Integer component4() {
        return this.totalScore;
    }

    public final String component5() {
        return this.homeworkUrl;
    }

    public final List<Question> component6() {
        return this.questions;
    }

    public final RecordedPaperDetailEntity copy(String str, Boolean bool, String str2, Integer num, String str3, List<Question> list) {
        return new RecordedPaperDetailEntity(str, bool, str2, num, str3, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordedPaperDetailEntity)) {
            return false;
        }
        RecordedPaperDetailEntity recordedPaperDetailEntity = (RecordedPaperDetailEntity) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) recordedPaperDetailEntity.title) && Intrinsics.areEqual((Object) this.isSubmit, (Object) recordedPaperDetailEntity.isSubmit) && Intrinsics.areEqual((Object) this.duration, (Object) recordedPaperDetailEntity.duration) && Intrinsics.areEqual((Object) this.totalScore, (Object) recordedPaperDetailEntity.totalScore) && Intrinsics.areEqual((Object) this.homeworkUrl, (Object) recordedPaperDetailEntity.homeworkUrl) && Intrinsics.areEqual((Object) this.questions, (Object) recordedPaperDetailEntity.questions);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.isSubmit;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.duration;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.totalScore;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.homeworkUrl;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<Question> list = this.questions;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "RecordedPaperDetailEntity(title=" + this.title + ", isSubmit=" + this.isSubmit + ", duration=" + this.duration + ", totalScore=" + this.totalScore + ", homeworkUrl=" + this.homeworkUrl + ", questions=" + this.questions + ')';
    }

    public RecordedPaperDetailEntity(String str, Boolean bool, String str2, Integer num, String str3, List<Question> list) {
        this.title = str;
        this.isSubmit = bool;
        this.duration = str2;
        this.totalScore = num;
        this.homeworkUrl = str3;
        this.questions = list;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final Boolean isSubmit() {
        return this.isSubmit;
    }

    public final void setSubmit(Boolean bool) {
        this.isSubmit = bool;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final void setDuration(String str) {
        this.duration = str;
    }

    public final Integer getTotalScore() {
        return this.totalScore;
    }

    public final void setTotalScore(Integer num) {
        this.totalScore = num;
    }

    public final String getHomeworkUrl() {
        return this.homeworkUrl;
    }

    public final void setHomeworkUrl(String str) {
        this.homeworkUrl = str;
    }

    public final List<Question> getQuestions() {
        return this.questions;
    }

    public final void setQuestions(List<Question> list) {
        this.questions = list;
    }
}
