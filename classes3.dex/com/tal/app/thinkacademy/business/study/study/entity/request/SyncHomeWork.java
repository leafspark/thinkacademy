package com.tal.app.thinkacademy.business.study.study.entity.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJV\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\t\u0010%\u001a\u00020\bHÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0016\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0010R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0018\u0010\r¨\u0006&"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/request/SyncHomeWork;", "", "classId", "", "planId", "HomeworkStatus", "", "homeworkId", "", "homeworkType", "syncType", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHomeworkStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getClassId", "()Ljava/lang/Long;", "setClassId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getHomeworkId", "()Ljava/lang/String;", "getHomeworkType", "getPlanId", "getSyncType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/study/study/entity/request/SyncHomeWork;", "equals", "", "other", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SyncHomeWork.kt */
public final class SyncHomeWork {
    private final Integer HomeworkStatus;
    private Long classId;
    private final String homeworkId;
    private final Integer homeworkType;
    private final Long planId;
    private final Integer syncType;

    public static /* synthetic */ SyncHomeWork copy$default(SyncHomeWork syncHomeWork, Long l, Long l2, Integer num, String str, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            l = syncHomeWork.classId;
        }
        if ((i & 2) != 0) {
            l2 = syncHomeWork.planId;
        }
        Long l3 = l2;
        if ((i & 4) != 0) {
            num = syncHomeWork.HomeworkStatus;
        }
        Integer num4 = num;
        if ((i & 8) != 0) {
            str = syncHomeWork.homeworkId;
        }
        String str2 = str;
        if ((i & 16) != 0) {
            num2 = syncHomeWork.homeworkType;
        }
        Integer num5 = num2;
        if ((i & 32) != 0) {
            num3 = syncHomeWork.syncType;
        }
        return syncHomeWork.copy(l, l3, num4, str2, num5, num3);
    }

    public final Long component1() {
        return this.classId;
    }

    public final Long component2() {
        return this.planId;
    }

    public final Integer component3() {
        return this.HomeworkStatus;
    }

    public final String component4() {
        return this.homeworkId;
    }

    public final Integer component5() {
        return this.homeworkType;
    }

    public final Integer component6() {
        return this.syncType;
    }

    public final SyncHomeWork copy(Long l, Long l2, Integer num, String str, Integer num2, Integer num3) {
        return new SyncHomeWork(l, l2, num, str, num2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SyncHomeWork)) {
            return false;
        }
        SyncHomeWork syncHomeWork = (SyncHomeWork) obj;
        return Intrinsics.areEqual((Object) this.classId, (Object) syncHomeWork.classId) && Intrinsics.areEqual((Object) this.planId, (Object) syncHomeWork.planId) && Intrinsics.areEqual((Object) this.HomeworkStatus, (Object) syncHomeWork.HomeworkStatus) && Intrinsics.areEqual((Object) this.homeworkId, (Object) syncHomeWork.homeworkId) && Intrinsics.areEqual((Object) this.homeworkType, (Object) syncHomeWork.homeworkType) && Intrinsics.areEqual((Object) this.syncType, (Object) syncHomeWork.syncType);
    }

    public int hashCode() {
        Long l = this.classId;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.planId;
        int hashCode2 = (hashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num = this.HomeworkStatus;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.homeworkId;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.homeworkType;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.syncType;
        if (num3 != null) {
            i = num3.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "SyncHomeWork(classId=" + this.classId + ", planId=" + this.planId + ", HomeworkStatus=" + this.HomeworkStatus + ", homeworkId=" + this.homeworkId + ", homeworkType=" + this.homeworkType + ", syncType=" + this.syncType + ')';
    }

    public SyncHomeWork(Long l, Long l2, Integer num, String str, Integer num2, Integer num3) {
        this.classId = l;
        this.planId = l2;
        this.HomeworkStatus = num;
        this.homeworkId = str;
        this.homeworkType = num2;
        this.syncType = num3;
    }

    public final Long getClassId() {
        return this.classId;
    }

    public final void setClassId(Long l) {
        this.classId = l;
    }

    public final Long getPlanId() {
        return this.planId;
    }

    public final Integer getHomeworkStatus() {
        return this.HomeworkStatus;
    }

    public final String getHomeworkId() {
        return this.homeworkId;
    }

    public final Integer getHomeworkType() {
        return this.homeworkType;
    }

    public final Integer getSyncType() {
        return this.syncType;
    }
}
