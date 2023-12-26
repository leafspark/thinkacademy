package com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.net;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/net/ApiSuccess;", "T", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/net/ApiResponse;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/net/ApiSuccess;", "equals", "", "other", "", "hashCode", "", "toString", "", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetWork.kt */
public final class ApiSuccess<T> extends ApiResponse<T> {
    private final T data;

    public static /* synthetic */ ApiSuccess copy$default(ApiSuccess apiSuccess, T t, int i, Object obj) {
        if ((i & 1) != 0) {
            t = apiSuccess.data;
        }
        return apiSuccess.copy(t);
    }

    public final T component1() {
        return this.data;
    }

    public final ApiSuccess<T> copy(T t) {
        return new ApiSuccess<>(t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ApiSuccess) && Intrinsics.areEqual((Object) this.data, (Object) ((ApiSuccess) obj).data);
    }

    public int hashCode() {
        T t = this.data;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public String toString() {
        return "ApiSuccess(data=" + this.data + ')';
    }

    public ApiSuccess(T t) {
        super((DefaultConstructorMarker) null);
        this.data = t;
    }

    public final T getData() {
        return this.data;
    }
}
