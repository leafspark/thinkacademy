package com.tal.app.thinkacademy.business.login.entity.post;

import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/business/login/entity/post/SubmitFeedback;", "", "data", "Lcom/tal/app/thinkacademy/business/login/entity/post/Feedback;", "(Lcom/tal/app/thinkacademy/business/login/entity/post/Feedback;)V", "getData", "()Lcom/tal/app/thinkacademy/business/login/entity/post/Feedback;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bus_login_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubmitFeedback.kt */
public final class SubmitFeedback {
    private final Feedback data;

    public static /* synthetic */ SubmitFeedback copy$default(SubmitFeedback submitFeedback, Feedback feedback, int i, Object obj) {
        if ((i & 1) != 0) {
            feedback = submitFeedback.data;
        }
        return submitFeedback.copy(feedback);
    }

    public final Feedback component1() {
        return this.data;
    }

    public final SubmitFeedback copy(Feedback feedback) {
        Intrinsics.checkNotNullParameter(feedback, DbParams.KEY_DATA);
        return new SubmitFeedback(feedback);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SubmitFeedback) && Intrinsics.areEqual((Object) this.data, (Object) ((SubmitFeedback) obj).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "SubmitFeedback(data=" + this.data + ')';
    }

    public SubmitFeedback(Feedback feedback) {
        Intrinsics.checkNotNullParameter(feedback, DbParams.KEY_DATA);
        this.data = feedback;
    }

    public final Feedback getData() {
        return this.data;
    }
}
