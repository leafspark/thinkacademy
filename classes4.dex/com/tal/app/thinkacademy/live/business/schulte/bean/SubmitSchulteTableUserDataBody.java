package com.tal.app.thinkacademy.live.business.schulte.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J0\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/bean/SubmitSchulteTableUserDataBody;", "", "planId", "", "interactId", "", "duration", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Number;)V", "getDuration", "()Ljava/lang/Number;", "getInteractId", "()Ljava/lang/String;", "getPlanId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Number;)Lcom/tal/app/thinkacademy/live/business/schulte/bean/SubmitSchulteTableUserDataBody;", "equals", "", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CheckSchulteTableUserDataBody.kt */
public final class SubmitSchulteTableUserDataBody {
    private final Number duration;
    private final String interactId;
    private final Integer planId;

    public static /* synthetic */ SubmitSchulteTableUserDataBody copy$default(SubmitSchulteTableUserDataBody submitSchulteTableUserDataBody, Integer num, String str, Number number, int i, Object obj) {
        if ((i & 1) != 0) {
            num = submitSchulteTableUserDataBody.planId;
        }
        if ((i & 2) != 0) {
            str = submitSchulteTableUserDataBody.interactId;
        }
        if ((i & 4) != 0) {
            number = submitSchulteTableUserDataBody.duration;
        }
        return submitSchulteTableUserDataBody.copy(num, str, number);
    }

    public final Integer component1() {
        return this.planId;
    }

    public final String component2() {
        return this.interactId;
    }

    public final Number component3() {
        return this.duration;
    }

    public final SubmitSchulteTableUserDataBody copy(Integer num, String str, Number number) {
        Intrinsics.checkNotNullParameter(number, "duration");
        return new SubmitSchulteTableUserDataBody(num, str, number);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubmitSchulteTableUserDataBody)) {
            return false;
        }
        SubmitSchulteTableUserDataBody submitSchulteTableUserDataBody = (SubmitSchulteTableUserDataBody) obj;
        return Intrinsics.areEqual(this.planId, submitSchulteTableUserDataBody.planId) && Intrinsics.areEqual(this.interactId, submitSchulteTableUserDataBody.interactId) && Intrinsics.areEqual(this.duration, submitSchulteTableUserDataBody.duration);
    }

    public int hashCode() {
        Integer num = this.planId;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.interactId;
        if (str != null) {
            i = str.hashCode();
        }
        return ((hashCode + i) * 31) + this.duration.hashCode();
    }

    public String toString() {
        return "SubmitSchulteTableUserDataBody(planId=" + this.planId + ", interactId=" + this.interactId + ", duration=" + this.duration + ')';
    }

    public SubmitSchulteTableUserDataBody(Integer num, String str, Number number) {
        Intrinsics.checkNotNullParameter(number, "duration");
        this.planId = num;
        this.interactId = str;
        this.duration = number;
    }

    public final Number getDuration() {
        return this.duration;
    }

    public final String getInteractId() {
        return this.interactId;
    }

    public final Integer getPlanId() {
        return this.planId;
    }
}
