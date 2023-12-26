package com.tal.app.thinkacademy.live.business.interactivegames.bean.body;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/body/WhoCanSpeakBody;", "", "planId", "", "classId", "(Ljava/lang/Long;Ljava/lang/Long;)V", "getClassId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPlanId", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/Long;)Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/body/WhoCanSpeakBody;", "equals", "", "other", "hashCode", "", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WhoCanSpeakBody.kt */
public final class WhoCanSpeakBody {
    private final Long classId;
    private final Long planId;

    public static /* synthetic */ WhoCanSpeakBody copy$default(WhoCanSpeakBody whoCanSpeakBody, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = whoCanSpeakBody.planId;
        }
        if ((i & 2) != 0) {
            l2 = whoCanSpeakBody.classId;
        }
        return whoCanSpeakBody.copy(l, l2);
    }

    public final Long component1() {
        return this.planId;
    }

    public final Long component2() {
        return this.classId;
    }

    public final WhoCanSpeakBody copy(Long l, Long l2) {
        return new WhoCanSpeakBody(l, l2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WhoCanSpeakBody)) {
            return false;
        }
        WhoCanSpeakBody whoCanSpeakBody = (WhoCanSpeakBody) obj;
        return Intrinsics.areEqual(this.planId, whoCanSpeakBody.planId) && Intrinsics.areEqual(this.classId, whoCanSpeakBody.classId);
    }

    public int hashCode() {
        Long l = this.planId;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.classId;
        if (l2 != null) {
            i = l2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "WhoCanSpeakBody(planId=" + this.planId + ", classId=" + this.classId + ')';
    }

    public WhoCanSpeakBody(Long l, Long l2) {
        this.planId = l;
        this.classId = l2;
    }

    public final Long getPlanId() {
        return this.planId;
    }

    public final Long getClassId() {
        return this.classId;
    }
}
