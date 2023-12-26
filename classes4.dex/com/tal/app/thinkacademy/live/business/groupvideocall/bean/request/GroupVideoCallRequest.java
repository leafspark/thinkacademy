package com.tal.app.thinkacademy.live.business.groupvideocall.bean.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/groupvideocall/bean/request/GroupVideoCallRequest;", "", "planId", "", "(Ljava/lang/Long;)V", "getPlanId", "()Ljava/lang/Long;", "setPlanId", "Ljava/lang/Long;", "component1", "copy", "(Ljava/lang/Long;)Lcom/tal/app/thinkacademy/live/business/groupvideocall/bean/request/GroupVideoCallRequest;", "equals", "", "other", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GroupVideoCallRequest.kt */
public final class GroupVideoCallRequest {
    private Long planId;

    public static /* synthetic */ GroupVideoCallRequest copy$default(GroupVideoCallRequest groupVideoCallRequest, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = groupVideoCallRequest.planId;
        }
        return groupVideoCallRequest.copy(l);
    }

    public final Long component1() {
        return this.planId;
    }

    public final GroupVideoCallRequest copy(Long l) {
        return new GroupVideoCallRequest(l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GroupVideoCallRequest) && Intrinsics.areEqual(this.planId, ((GroupVideoCallRequest) obj).planId);
    }

    public int hashCode() {
        Long l = this.planId;
        if (l == null) {
            return 0;
        }
        return l.hashCode();
    }

    public String toString() {
        return "GroupVideoCallRequest(planId=" + this.planId + ')';
    }

    public GroupVideoCallRequest(Long l) {
        this.planId = l;
    }

    public final Long getPlanId() {
        return this.planId;
    }

    public final void setPlanId(Long l) {
        this.planId = l;
    }
}
