package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/BaseRequestBean;", "", "planId", "", "(Ljava/lang/Long;)V", "getPlanId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "copy", "(Ljava/lang/Long;)Lcom/tal/app/thinkacademy/common/entity/BaseRequestBean;", "equals", "", "other", "hashCode", "", "toString", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseRequestBean.kt */
public final class BaseRequestBean {
    private final Long planId;

    public BaseRequestBean() {
        this((Long) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BaseRequestBean copy$default(BaseRequestBean baseRequestBean, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = baseRequestBean.planId;
        }
        return baseRequestBean.copy(l);
    }

    public final Long component1() {
        return this.planId;
    }

    public final BaseRequestBean copy(Long l) {
        return new BaseRequestBean(l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BaseRequestBean) && Intrinsics.areEqual(this.planId, ((BaseRequestBean) obj).planId);
    }

    public int hashCode() {
        Long l = this.planId;
        if (l == null) {
            return 0;
        }
        return l.hashCode();
    }

    public String toString() {
        return "BaseRequestBean(planId=" + this.planId + ')';
    }

    public BaseRequestBean(Long l) {
        this.planId = l;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseRequestBean(Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : l);
    }

    public final Long getPlanId() {
        return this.planId;
    }
}
