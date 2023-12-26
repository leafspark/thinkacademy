package com.tal.app.thinkacademy.business.study.study.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/Schedule;", "", "date", "", "list", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/CalendarItem;", "(Ljava/lang/String;Ljava/util/List;)V", "getDate", "()Ljava/lang/String;", "getList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassCalendarEntity.kt */
public final class Schedule {
    private final String date;
    private final List<CalendarItem> list;

    public static /* synthetic */ Schedule copy$default(Schedule schedule, String str, List<CalendarItem> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = schedule.date;
        }
        if ((i & 2) != 0) {
            list2 = schedule.list;
        }
        return schedule.copy(str, list2);
    }

    public final String component1() {
        return this.date;
    }

    public final List<CalendarItem> component2() {
        return this.list;
    }

    public final Schedule copy(String str, List<CalendarItem> list2) {
        return new Schedule(str, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Schedule)) {
            return false;
        }
        Schedule schedule = (Schedule) obj;
        return Intrinsics.areEqual((Object) this.date, (Object) schedule.date) && Intrinsics.areEqual((Object) this.list, (Object) schedule.list);
    }

    public int hashCode() {
        String str = this.date;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<CalendarItem> list2 = this.list;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "Schedule(date=" + this.date + ", list=" + this.list + ')';
    }

    public Schedule(String str, List<CalendarItem> list2) {
        this.date = str;
        this.list = list2;
    }

    public final String getDate() {
        return this.date;
    }

    public final List<CalendarItem> getList() {
        return this.list;
    }
}
