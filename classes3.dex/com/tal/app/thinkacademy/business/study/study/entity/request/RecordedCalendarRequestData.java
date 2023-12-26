package com.tal.app.thinkacademy.business.study.study.entity.request;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/request/RecordedCalendarRequestData;", "", "studentCourseId", "", "(J)V", "getStudentCourseId", "()J", "setStudentCourseId", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedCalendarRequestData.kt */
public final class RecordedCalendarRequestData {
    private long studentCourseId;

    public static /* synthetic */ RecordedCalendarRequestData copy$default(RecordedCalendarRequestData recordedCalendarRequestData, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = recordedCalendarRequestData.studentCourseId;
        }
        return recordedCalendarRequestData.copy(j);
    }

    public final long component1() {
        return this.studentCourseId;
    }

    public final RecordedCalendarRequestData copy(long j) {
        return new RecordedCalendarRequestData(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RecordedCalendarRequestData) && this.studentCourseId == ((RecordedCalendarRequestData) obj).studentCourseId;
    }

    public int hashCode() {
        return SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.studentCourseId);
    }

    public String toString() {
        return "RecordedCalendarRequestData(studentCourseId=" + this.studentCourseId + ')';
    }

    public RecordedCalendarRequestData(long j) {
        this.studentCourseId = j;
    }

    public final long getStudentCourseId() {
        return this.studentCourseId;
    }

    public final void setStudentCourseId(long j) {
        this.studentCourseId = j;
    }
}
