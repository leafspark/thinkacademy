package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/GetSchoolListRequest;", "", "v", "", "(Ljava/lang/String;)V", "getV", "()Ljava/lang/String;", "setV", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GetSchoolListRequest.kt */
public final class GetSchoolListRequest {
    private String v;

    public GetSchoolListRequest() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GetSchoolListRequest copy$default(GetSchoolListRequest getSchoolListRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = getSchoolListRequest.v;
        }
        return getSchoolListRequest.copy(str);
    }

    public final String component1() {
        return this.v;
    }

    public final GetSchoolListRequest copy(String str) {
        return new GetSchoolListRequest(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetSchoolListRequest) && Intrinsics.areEqual(this.v, ((GetSchoolListRequest) obj).v);
    }

    public int hashCode() {
        String str = this.v;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "GetSchoolListRequest(v=" + this.v + ')';
    }

    public GetSchoolListRequest(String str) {
        this.v = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetSchoolListRequest(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getV() {
        return this.v;
    }

    public final void setV(String str) {
        this.v = str;
    }
}
