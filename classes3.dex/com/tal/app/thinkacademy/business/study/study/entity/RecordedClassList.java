package com.tal.app.thinkacademy.business.study.study.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedClassList;", "", "courseList", "", "Lcom/tal/app/thinkacademy/business/study/study/entity/RecordedCourse;", "(Ljava/util/List;)V", "getCourseList", "()Ljava/util/List;", "setCourseList", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedClassList.kt */
public final class RecordedClassList {
    private List<RecordedCourse> courseList;

    public static /* synthetic */ RecordedClassList copy$default(RecordedClassList recordedClassList, List<RecordedCourse> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = recordedClassList.courseList;
        }
        return recordedClassList.copy(list);
    }

    public final List<RecordedCourse> component1() {
        return this.courseList;
    }

    public final RecordedClassList copy(List<RecordedCourse> list) {
        return new RecordedClassList(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RecordedClassList) && Intrinsics.areEqual((Object) this.courseList, (Object) ((RecordedClassList) obj).courseList);
    }

    public int hashCode() {
        List<RecordedCourse> list = this.courseList;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "RecordedClassList(courseList=" + this.courseList + ')';
    }

    public RecordedClassList(List<RecordedCourse> list) {
        this.courseList = list;
    }

    public final List<RecordedCourse> getCourseList() {
        return this.courseList;
    }

    public final void setCourseList(List<RecordedCourse> list) {
        this.courseList = list;
    }
}
