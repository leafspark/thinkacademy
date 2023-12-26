package com.tal.app.thinkacademy.common.courseware.body;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/tal/app/thinkacademy/common/courseware/body/PlanIdBody;", "", "planId", "", "(Ljava/lang/Integer;)V", "getPlanId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/common/courseware/body/PlanIdBody;", "equals", "", "other", "hashCode", "toString", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlanIdBody.kt */
public final class PlanIdBody {
    private final Integer planId;

    public static /* synthetic */ PlanIdBody copy$default(PlanIdBody planIdBody, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = planIdBody.planId;
        }
        return planIdBody.copy(num);
    }

    public final Integer component1() {
        return this.planId;
    }

    public final PlanIdBody copy(Integer num) {
        return new PlanIdBody(num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PlanIdBody) && Intrinsics.areEqual(this.planId, ((PlanIdBody) obj).planId);
    }

    public int hashCode() {
        Integer num = this.planId;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public String toString() {
        return "PlanIdBody(planId=" + this.planId + ')';
    }

    public PlanIdBody(Integer num) {
        this.planId = num;
    }

    public final Integer getPlanId() {
        return this.planId;
    }
}
