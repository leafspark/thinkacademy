package com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.net;

import com.tal.app.thinkacademy.live.core.live.abilitypack.livedata.listener.ListenerBody;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00000\u0002B\u0007\b\u0004¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J@\u0010\u0014\u001a\u00020\f28\u0010\u0015\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005J@\u0010\u0016\u001a\u00020\f28\u0010\u0015\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005J)\u0010\u0017\u001a\u00020\f2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\f0\u0010RB\u0010\u0004\u001a6\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000RB\u0010\r\u001a6\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\f\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000\u0001\u0003\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/net/ApiResponse;", "T", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/listener/ListenerBody;", "()V", "errorAction", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "errorCode", "", "errorMsg", "", "failAction", "status", "successAction", "Lkotlin/Function1;", "data", "dispatch", "listener", "error", "action", "fail", "success", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/net/ApiSuccess;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/net/ApiError;", "Lcom/tal/app/thinkacademy/live/core/live/abilitypack/livedata/net/ApiFailed;", "bus_livebase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetWork.kt */
public abstract class ApiResponse<T> extends ListenerBody<ApiResponse<T>> {
    private Function2<? super Integer, ? super String, Unit> errorAction;
    private Function2<? super Integer, ? super String, Unit> failAction;
    private Function1<? super T, Unit> successAction;

    public /* synthetic */ ApiResponse(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ApiResponse() {
    }

    public void dispatch(ApiResponse<T> apiResponse) {
        Function2<? super Integer, ? super String, Unit> function2;
        Intrinsics.checkNotNullParameter(apiResponse, "listener");
        if (apiResponse instanceof ApiSuccess) {
            Function1<? super T, Unit> function1 = this.successAction;
            if (function1 != null) {
                function1.invoke(((ApiSuccess) apiResponse).getData());
            }
        } else if (apiResponse instanceof ApiError) {
            Function2<? super Integer, ? super String, Unit> function22 = this.errorAction;
            if (function22 != null) {
                ApiError apiError = (ApiError) apiResponse;
                function22.invoke(Integer.valueOf(apiError.getErrorCode()), apiError.getErrorMsg());
            }
        } else if ((apiResponse instanceof ApiFailed) && (function2 = this.failAction) != null) {
            ApiFailed apiFailed = (ApiFailed) apiResponse;
            function2.invoke(Integer.valueOf(apiFailed.getStatus()), apiFailed.getErrorMsg());
        }
    }

    public final void success(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        this.successAction = function1;
    }

    public final void error(Function2<? super Integer, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        this.errorAction = function2;
    }

    public final void fail(Function2<? super Integer, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        this.failAction = function2;
    }
}
