package com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.net;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/net/ApiError;", "T", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/net/ApiResponse;", "errorCode", "", "errorMsg", "", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetWork.kt */
public final class ApiError<T> extends ApiResponse<T> {
    private final int errorCode;
    private final String errorMsg;

    public static /* synthetic */ ApiError copy$default(ApiError apiError, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = apiError.errorCode;
        }
        if ((i2 & 2) != 0) {
            str = apiError.errorMsg;
        }
        return apiError.copy(i, str);
    }

    public final int component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.errorMsg;
    }

    public final ApiError<T> copy(int i, String str) {
        return new ApiError<>(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApiError)) {
            return false;
        }
        ApiError apiError = (ApiError) obj;
        return this.errorCode == apiError.errorCode && Intrinsics.areEqual((Object) this.errorMsg, (Object) apiError.errorMsg);
    }

    public int hashCode() {
        int i = this.errorCode * 31;
        String str = this.errorMsg;
        return i + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ApiError(errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ')';
    }

    public ApiError(int i, String str) {
        super((DefaultConstructorMarker) null);
        this.errorCode = i;
        this.errorMsg = str;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }
}
