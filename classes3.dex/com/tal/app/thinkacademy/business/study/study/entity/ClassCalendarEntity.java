package com.tal.app.thinkacademy.business.study.study.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/ClassCalendarEntity;", "", "classInfo", "Lcom/tal/app/thinkacademy/business/study/study/entity/ClassInfo;", "schedule", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/Schedule;", "(Lcom/tal/app/thinkacademy/business/study/study/entity/ClassInfo;Ljava/util/List;)V", "getClassInfo", "()Lcom/tal/app/thinkacademy/business/study/study/entity/ClassInfo;", "getSchedule", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassCalendarEntity.kt */
public final class ClassCalendarEntity {
    private final ClassInfo classInfo;
    private final List<Schedule> schedule;

    public static /* synthetic */ ClassCalendarEntity copy$default(ClassCalendarEntity classCalendarEntity, ClassInfo classInfo2, List<Schedule> list, int i, Object obj) {
        if ((i & 1) != 0) {
            classInfo2 = classCalendarEntity.classInfo;
        }
        if ((i & 2) != 0) {
            list = classCalendarEntity.schedule;
        }
        return classCalendarEntity.copy(classInfo2, list);
    }

    public final ClassInfo component1() {
        return this.classInfo;
    }

    public final List<Schedule> component2() {
        return this.schedule;
    }

    public final ClassCalendarEntity copy(ClassInfo classInfo2, List<Schedule> list) {
        return new ClassCalendarEntity(classInfo2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClassCalendarEntity)) {
            return false;
        }
        ClassCalendarEntity classCalendarEntity = (ClassCalendarEntity) obj;
        return Intrinsics.areEqual((Object) this.classInfo, (Object) classCalendarEntity.classInfo) && Intrinsics.areEqual((Object) this.schedule, (Object) classCalendarEntity.schedule);
    }

    public int hashCode() {
        ClassInfo classInfo2 = this.classInfo;
        int i = 0;
        int hashCode = (classInfo2 == null ? 0 : classInfo2.hashCode()) * 31;
        List<Schedule> list = this.schedule;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ClassCalendarEntity(classInfo=" + this.classInfo + ", schedule=" + this.schedule + ')';
    }

    public ClassCalendarEntity(ClassInfo classInfo2, List<Schedule> list) {
        this.classInfo = classInfo2;
        this.schedule = list;
    }

    public final ClassInfo getClassInfo() {
        return this.classInfo;
    }

    public final List<Schedule> getSchedule() {
        return this.schedule;
    }
}
