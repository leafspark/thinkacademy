package com.tal.app.thinkacademy.business.study.study.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedCalendarListEntity;", "", "course", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedCalendarCourse;", "scheduleList", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedSchedule;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedCalendarCourse;Ljava/util/List;)V", "getCourse", "()Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedCalendarCourse;", "setCourse", "(Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedCalendarCourse;)V", "getScheduleList", "()Ljava/util/List;", "setScheduleList", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedCalendarListEntity.kt */
public final class RecordedCalendarListEntity {
    private RecordedCalendarCourse course;
    private List<RecordedSchedule> scheduleList;

    public static /* synthetic */ RecordedCalendarListEntity copy$default(RecordedCalendarListEntity recordedCalendarListEntity, RecordedCalendarCourse recordedCalendarCourse, List<RecordedSchedule> list, int i, Object obj) {
        if ((i & 1) != 0) {
            recordedCalendarCourse = recordedCalendarListEntity.course;
        }
        if ((i & 2) != 0) {
            list = recordedCalendarListEntity.scheduleList;
        }
        return recordedCalendarListEntity.copy(recordedCalendarCourse, list);
    }

    public final RecordedCalendarCourse component1() {
        return this.course;
    }

    public final List<RecordedSchedule> component2() {
        return this.scheduleList;
    }

    public final RecordedCalendarListEntity copy(RecordedCalendarCourse recordedCalendarCourse, List<RecordedSchedule> list) {
        return new RecordedCalendarListEntity(recordedCalendarCourse, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordedCalendarListEntity)) {
            return false;
        }
        RecordedCalendarListEntity recordedCalendarListEntity = (RecordedCalendarListEntity) obj;
        return Intrinsics.areEqual((Object) this.course, (Object) recordedCalendarListEntity.course) && Intrinsics.areEqual((Object) this.scheduleList, (Object) recordedCalendarListEntity.scheduleList);
    }

    public int hashCode() {
        RecordedCalendarCourse recordedCalendarCourse = this.course;
        int i = 0;
        int hashCode = (recordedCalendarCourse == null ? 0 : recordedCalendarCourse.hashCode()) * 31;
        List<RecordedSchedule> list = this.scheduleList;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "RecordedCalendarListEntity(course=" + this.course + ", scheduleList=" + this.scheduleList + ')';
    }

    public RecordedCalendarListEntity(RecordedCalendarCourse recordedCalendarCourse, List<RecordedSchedule> list) {
        this.course = recordedCalendarCourse;
        this.scheduleList = list;
    }

    public final RecordedCalendarCourse getCourse() {
        return this.course;
    }

    public final void setCourse(RecordedCalendarCourse recordedCalendarCourse) {
        this.course = recordedCalendarCourse;
    }

    public final List<RecordedSchedule> getScheduleList() {
        return this.scheduleList;
    }

    public final void setScheduleList(List<RecordedSchedule> list) {
        this.scheduleList = list;
    }
}
