package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/PushRequestBean;", "", "header", "Lcom/tal/app/thinkacademy/common/entity/BodyHeaders;", "data", "Lcom/tal/app/thinkacademy/common/entity/PushData;", "(Lcom/tal/app/thinkacademy/common/entity/BodyHeaders;Lcom/tal/app/thinkacademy/common/entity/PushData;)V", "getData", "()Lcom/tal/app/thinkacademy/common/entity/PushData;", "getHeader", "()Lcom/tal/app/thinkacademy/common/entity/BodyHeaders;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PushRequestBean.kt */
public final class PushRequestBean {
    private final PushData data;
    private final BodyHeaders header;

    public static /* synthetic */ PushRequestBean copy$default(PushRequestBean pushRequestBean, BodyHeaders bodyHeaders, PushData pushData, int i, Object obj) {
        if ((i & 1) != 0) {
            bodyHeaders = pushRequestBean.header;
        }
        if ((i & 2) != 0) {
            pushData = pushRequestBean.data;
        }
        return pushRequestBean.copy(bodyHeaders, pushData);
    }

    public final BodyHeaders component1() {
        return this.header;
    }

    public final PushData component2() {
        return this.data;
    }

    public final PushRequestBean copy(BodyHeaders bodyHeaders, PushData pushData) {
        Intrinsics.checkNotNullParameter(bodyHeaders, "header");
        Intrinsics.checkNotNullParameter(pushData, "data");
        return new PushRequestBean(bodyHeaders, pushData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PushRequestBean)) {
            return false;
        }
        PushRequestBean pushRequestBean = (PushRequestBean) obj;
        return Intrinsics.areEqual(this.header, pushRequestBean.header) && Intrinsics.areEqual(this.data, pushRequestBean.data);
    }

    public int hashCode() {
        return (this.header.hashCode() * 31) + this.data.hashCode();
    }

    public String toString() {
        return "PushRequestBean(header=" + this.header + ", data=" + this.data + ')';
    }

    public PushRequestBean(BodyHeaders bodyHeaders, PushData pushData) {
        Intrinsics.checkNotNullParameter(bodyHeaders, "header");
        Intrinsics.checkNotNullParameter(pushData, "data");
        this.header = bodyHeaders;
        this.data = pushData;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PushRequestBean(BodyHeaders bodyHeaders, PushData pushData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new BodyHeaders((String) null, (String) null, 3, (DefaultConstructorMarker) null) : bodyHeaders, pushData);
    }

    public final PushData getData() {
        return this.data;
    }

    public final BodyHeaders getHeader() {
        return this.header;
    }
}
