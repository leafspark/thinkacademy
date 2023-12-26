package com.tal.app.thinkacademy.live.business.speedyhand.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/speedyhand/api/SpeedyHandBody;", "", "planId", "", "classId", "interactId", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getClassId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getInteractId", "()Ljava/lang/String;", "getPlanId", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tal/app/thinkacademy/live/business/speedyhand/api/SpeedyHandBody;", "equals", "", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpeedyHandBody.kt */
public final class SpeedyHandBody {
    private final Integer classId;
    private final String interactId;
    private final Integer planId;

    public static /* synthetic */ SpeedyHandBody copy$default(SpeedyHandBody speedyHandBody, Integer num, Integer num2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = speedyHandBody.planId;
        }
        if ((i & 2) != 0) {
            num2 = speedyHandBody.classId;
        }
        if ((i & 4) != 0) {
            str = speedyHandBody.interactId;
        }
        return speedyHandBody.copy(num, num2, str);
    }

    public final Integer component1() {
        return this.planId;
    }

    public final Integer component2() {
        return this.classId;
    }

    public final String component3() {
        return this.interactId;
    }

    public final SpeedyHandBody copy(Integer num, Integer num2, String str) {
        return new SpeedyHandBody(num, num2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpeedyHandBody)) {
            return false;
        }
        SpeedyHandBody speedyHandBody = (SpeedyHandBody) obj;
        return Intrinsics.areEqual(this.planId, speedyHandBody.planId) && Intrinsics.areEqual(this.classId, speedyHandBody.classId) && Intrinsics.areEqual(this.interactId, speedyHandBody.interactId);
    }

    public int hashCode() {
        Integer num = this.planId;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.classId;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.interactId;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "SpeedyHandBody(planId=" + this.planId + ", classId=" + this.classId + ", interactId=" + this.interactId + ')';
    }

    public SpeedyHandBody(Integer num, Integer num2, String str) {
        this.planId = num;
        this.classId = num2;
        this.interactId = str;
    }

    public final Integer getPlanId() {
        return this.planId;
    }

    public final Integer getClassId() {
        return this.classId;
    }

    public final String getInteractId() {
        return this.interactId;
    }
}
