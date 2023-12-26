package com.tal.app.thinkacademy.business.study.study.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedSchedule;", "", "recordLesson", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordLesson;", "scheduleType", "", "(Lcom/tal/app/thinkacademy/business/study/study/entity/RecordLesson;Ljava/lang/String;)V", "getRecordLesson", "()Lcom/tal/app/thinkacademy/business/study/study/entity/RecordLesson;", "setRecordLesson", "(Lcom/tal/app/thinkacademy/business/study/study/entity/RecordLesson;)V", "getScheduleType", "()Ljava/lang/String;", "setScheduleType", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedCalendarListEntity.kt */
public final class RecordedSchedule {
    private RecordLesson recordLesson;
    private String scheduleType;

    public static /* synthetic */ RecordedSchedule copy$default(RecordedSchedule recordedSchedule, RecordLesson recordLesson2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            recordLesson2 = recordedSchedule.recordLesson;
        }
        if ((i & 2) != 0) {
            str = recordedSchedule.scheduleType;
        }
        return recordedSchedule.copy(recordLesson2, str);
    }

    public final RecordLesson component1() {
        return this.recordLesson;
    }

    public final String component2() {
        return this.scheduleType;
    }

    public final RecordedSchedule copy(RecordLesson recordLesson2, String str) {
        return new RecordedSchedule(recordLesson2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordedSchedule)) {
            return false;
        }
        RecordedSchedule recordedSchedule = (RecordedSchedule) obj;
        return Intrinsics.areEqual((Object) this.recordLesson, (Object) recordedSchedule.recordLesson) && Intrinsics.areEqual((Object) this.scheduleType, (Object) recordedSchedule.scheduleType);
    }

    public int hashCode() {
        RecordLesson recordLesson2 = this.recordLesson;
        int i = 0;
        int hashCode = (recordLesson2 == null ? 0 : recordLesson2.hashCode()) * 31;
        String str = this.scheduleType;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "RecordedSchedule(recordLesson=" + this.recordLesson + ", scheduleType=" + this.scheduleType + ')';
    }

    public RecordedSchedule(RecordLesson recordLesson2, String str) {
        this.recordLesson = recordLesson2;
        this.scheduleType = str;
    }

    public final RecordLesson getRecordLesson() {
        return this.recordLesson;
    }

    public final void setRecordLesson(RecordLesson recordLesson2) {
        this.recordLesson = recordLesson2;
    }

    public final String getScheduleType() {
        return this.scheduleType;
    }

    public final void setScheduleType(String str) {
        this.scheduleType = str;
    }
}
