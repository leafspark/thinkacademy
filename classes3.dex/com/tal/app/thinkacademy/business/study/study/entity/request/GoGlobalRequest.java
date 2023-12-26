package com.tal.app.thinkacademy.business.study.study.entity.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0001¢\u0006\u0002\u0010\u0006R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0001X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/request/GoGlobalRequest;", "H", "D", "", "header", "data", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getHeader", "setHeader", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GoGlobalRequest.kt */
public final class GoGlobalRequest<H, D> {
    private D data;
    private H header;

    public GoGlobalRequest() {
        this((Object) null, (Object) null, 3, (DefaultConstructorMarker) null);
    }

    public GoGlobalRequest(H h, D d) {
        this.header = h;
        this.data = d;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GoGlobalRequest(Object obj, Object obj2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj, (i & 2) != 0 ? null : obj2);
    }

    public final H getHeader() {
        return this.header;
    }

    public final void setHeader(H h) {
        this.header = h;
    }

    public final D getData() {
        return this.data;
    }

    public final void setData(D d) {
        this.data = d;
    }
}
