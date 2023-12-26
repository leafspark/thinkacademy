package com.tal.app.thinkacademy.business.study.study.entity.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J2\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0005\u0010\u0007R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0004\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/request/InitModuleRequest;", "", "planId", "", "isPlayback", "isParentAudition", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPlanId", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/study/study/entity/request/InitModuleRequest;", "equals", "", "other", "hashCode", "toString", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReadyRequest.kt */
public final class InitModuleRequest {
    private final Integer isParentAudition;
    private final Integer isPlayback;
    private final Integer planId;

    public InitModuleRequest() {
        this((Integer) null, (Integer) null, (Integer) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ InitModuleRequest copy$default(InitModuleRequest initModuleRequest, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = initModuleRequest.planId;
        }
        if ((i & 2) != 0) {
            num2 = initModuleRequest.isPlayback;
        }
        if ((i & 4) != 0) {
            num3 = initModuleRequest.isParentAudition;
        }
        return initModuleRequest.copy(num, num2, num3);
    }

    public final Integer component1() {
        return this.planId;
    }

    public final Integer component2() {
        return this.isPlayback;
    }

    public final Integer component3() {
        return this.isParentAudition;
    }

    public final InitModuleRequest copy(Integer num, Integer num2, Integer num3) {
        return new InitModuleRequest(num, num2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InitModuleRequest)) {
            return false;
        }
        InitModuleRequest initModuleRequest = (InitModuleRequest) obj;
        return Intrinsics.areEqual((Object) this.planId, (Object) initModuleRequest.planId) && Intrinsics.areEqual((Object) this.isPlayback, (Object) initModuleRequest.isPlayback) && Intrinsics.areEqual((Object) this.isParentAudition, (Object) initModuleRequest.isParentAudition);
    }

    public int hashCode() {
        Integer num = this.planId;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.isPlayback;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.isParentAudition;
        if (num3 != null) {
            i = num3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "InitModuleRequest(planId=" + this.planId + ", isPlayback=" + this.isPlayback + ", isParentAudition=" + this.isParentAudition + ')';
    }

    public InitModuleRequest(Integer num, Integer num2, Integer num3) {
        this.planId = num;
        this.isPlayback = num2;
        this.isParentAudition = num3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InitModuleRequest(Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? 0 : num2, (i & 4) != 0 ? 0 : num3);
    }

    public final Integer getPlanId() {
        return this.planId;
    }

    public final Integer isPlayback() {
        return this.isPlayback;
    }

    public final Integer isParentAudition() {
        return this.isParentAudition;
    }
}
