package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003JJ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\r¨\u0006%"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/SubmitHomeworkData;", "", "planId", "", "classId", "homeworkStatus", "homeworkType", "homeworkId", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getClassId", "()Ljava/lang/Integer;", "setClassId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHomeworkId", "()Ljava/lang/String;", "setHomeworkId", "(Ljava/lang/String;)V", "getHomeworkStatus", "setHomeworkStatus", "getHomeworkType", "setHomeworkType", "getPlanId", "setPlanId", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tal/app/thinkacademy/common/entity/SubmitHomeworkData;", "equals", "", "other", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubmitHomeworkData.kt */
public final class SubmitHomeworkData {
    private Integer classId;
    private String homeworkId;
    private Integer homeworkStatus;
    private Integer homeworkType;
    private Integer planId;

    public static /* synthetic */ SubmitHomeworkData copy$default(SubmitHomeworkData submitHomeworkData, Integer num, Integer num2, Integer num3, Integer num4, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = submitHomeworkData.planId;
        }
        if ((i & 2) != 0) {
            num2 = submitHomeworkData.classId;
        }
        Integer num5 = num2;
        if ((i & 4) != 0) {
            num3 = submitHomeworkData.homeworkStatus;
        }
        Integer num6 = num3;
        if ((i & 8) != 0) {
            num4 = submitHomeworkData.homeworkType;
        }
        Integer num7 = num4;
        if ((i & 16) != 0) {
            str = submitHomeworkData.homeworkId;
        }
        return submitHomeworkData.copy(num, num5, num6, num7, str);
    }

    public final Integer component1() {
        return this.planId;
    }

    public final Integer component2() {
        return this.classId;
    }

    public final Integer component3() {
        return this.homeworkStatus;
    }

    public final Integer component4() {
        return this.homeworkType;
    }

    public final String component5() {
        return this.homeworkId;
    }

    public final SubmitHomeworkData copy(Integer num, Integer num2, Integer num3, Integer num4, String str) {
        return new SubmitHomeworkData(num, num2, num3, num4, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubmitHomeworkData)) {
            return false;
        }
        SubmitHomeworkData submitHomeworkData = (SubmitHomeworkData) obj;
        return Intrinsics.areEqual(this.planId, submitHomeworkData.planId) && Intrinsics.areEqual(this.classId, submitHomeworkData.classId) && Intrinsics.areEqual(this.homeworkStatus, submitHomeworkData.homeworkStatus) && Intrinsics.areEqual(this.homeworkType, submitHomeworkData.homeworkType) && Intrinsics.areEqual(this.homeworkId, submitHomeworkData.homeworkId);
    }

    public int hashCode() {
        Integer num = this.planId;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.classId;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.homeworkStatus;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.homeworkType;
        int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str = this.homeworkId;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "SubmitHomeworkData(planId=" + this.planId + ", classId=" + this.classId + ", homeworkStatus=" + this.homeworkStatus + ", homeworkType=" + this.homeworkType + ", homeworkId=" + this.homeworkId + ')';
    }

    public SubmitHomeworkData(Integer num, Integer num2, Integer num3, Integer num4, String str) {
        this.planId = num;
        this.classId = num2;
        this.homeworkStatus = num3;
        this.homeworkType = num4;
        this.homeworkId = str;
    }

    public final Integer getPlanId() {
        return this.planId;
    }

    public final void setPlanId(Integer num) {
        this.planId = num;
    }

    public final Integer getClassId() {
        return this.classId;
    }

    public final void setClassId(Integer num) {
        this.classId = num;
    }

    public final Integer getHomeworkStatus() {
        return this.homeworkStatus;
    }

    public final void setHomeworkStatus(Integer num) {
        this.homeworkStatus = num;
    }

    public final Integer getHomeworkType() {
        return this.homeworkType;
    }

    public final void setHomeworkType(Integer num) {
        this.homeworkType = num;
    }

    public final String getHomeworkId() {
        return this.homeworkId;
    }

    public final void setHomeworkId(String str) {
        this.homeworkId = str;
    }
}
