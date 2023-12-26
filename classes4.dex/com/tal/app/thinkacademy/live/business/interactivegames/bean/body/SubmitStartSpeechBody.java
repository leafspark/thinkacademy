package com.tal.app.thinkacademy.live.business.interactivegames.bean.body;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/body/SubmitStartSpeechBody;", "", "planId", "", "interactId", "", "classId", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)V", "getClassId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getInteractId", "()Ljava/lang/String;", "getPlanId", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/body/SubmitStartSpeechBody;", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubmitStartSpeechBody.kt */
public final class SubmitStartSpeechBody {
    private final Long classId;
    private final String interactId;
    private final Long planId;

    public static /* synthetic */ SubmitStartSpeechBody copy$default(SubmitStartSpeechBody submitStartSpeechBody, Long l, String str, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = submitStartSpeechBody.planId;
        }
        if ((i & 2) != 0) {
            str = submitStartSpeechBody.interactId;
        }
        if ((i & 4) != 0) {
            l2 = submitStartSpeechBody.classId;
        }
        return submitStartSpeechBody.copy(l, str, l2);
    }

    public final Long component1() {
        return this.planId;
    }

    public final String component2() {
        return this.interactId;
    }

    public final Long component3() {
        return this.classId;
    }

    public final SubmitStartSpeechBody copy(Long l, String str, Long l2) {
        return new SubmitStartSpeechBody(l, str, l2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubmitStartSpeechBody)) {
            return false;
        }
        SubmitStartSpeechBody submitStartSpeechBody = (SubmitStartSpeechBody) obj;
        return Intrinsics.areEqual(this.planId, submitStartSpeechBody.planId) && Intrinsics.areEqual(this.interactId, submitStartSpeechBody.interactId) && Intrinsics.areEqual(this.classId, submitStartSpeechBody.classId);
    }

    public int hashCode() {
        Long l = this.planId;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.interactId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l2 = this.classId;
        if (l2 != null) {
            i = l2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "SubmitStartSpeechBody(planId=" + this.planId + ", interactId=" + this.interactId + ", classId=" + this.classId + ')';
    }

    public SubmitStartSpeechBody(Long l, String str, Long l2) {
        this.planId = l;
        this.interactId = str;
        this.classId = l2;
    }

    public final Long getPlanId() {
        return this.planId;
    }

    public final String getInteractId() {
        return this.interactId;
    }

    public final Long getClassId() {
        return this.classId;
    }
}
