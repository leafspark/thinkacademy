package com.tal.app.thinkacademy.lib.network.javacallback;

import android.os.Bundle;
import com.tal.app.thinkacademy.lib.interfaces.route.RouteMap;
import com.tal.app.thinkacademy.lib.network.exception.HandlerException;
import com.tal.app.thinkacademy.lib.network.exception.IError;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.route.XesRoute;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J$\u0010\u0013\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016J\u0015\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0017R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/lib/network/javacallback/OmyCallback;", "T", "Lretrofit2/Callback;", "error", "Lcom/tal/app/thinkacademy/lib/network/exception/IError;", "(Lcom/tal/app/thinkacademy/lib/network/exception/IError;)V", "()V", "handlerException", "Lcom/tal/app/thinkacademy/lib/network/exception/HandlerException;", "getHandlerException", "()Lcom/tal/app/thinkacademy/lib/network/exception/HandlerException;", "setHandlerException", "(Lcom/tal/app/thinkacademy/lib/network/exception/HandlerException;)V", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "onSuccess", "(Ljava/lang/Object;)V", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OmyCallback.kt */
public abstract class OmyCallback<T> implements Callback<T> {
    private HandlerException handlerException;

    public abstract void onSuccess(T t);

    public OmyCallback() {
    }

    public final HandlerException getHandlerException() {
        return this.handlerException;
    }

    public final void setHandlerException(HandlerException handlerException2) {
        this.handlerException = handlerException2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OmyCallback(IError iError) {
        this();
        Intrinsics.checkNotNullParameter(iError, "error");
        this.handlerException = new HandlerException(iError);
    }

    public void onFailure(Call<T> call, Throwable th) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(th, "t");
        HandlerException handlerException2 = this.handlerException;
        if (handlerException2 != null) {
            handlerException2.handleException(th);
        }
    }

    public void onResponse(Call<T> call, Response<T> response) {
        HandlerException handlerException2;
        Unit unit;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        Object body = response.body();
        Unit unit2 = null;
        if (body != null) {
            if (body instanceof HiResponse) {
                HiResponse hiResponse = (HiResponse) body;
                if (hiResponse.successful()) {
                    int code = hiResponse.getCode();
                    if (code == 0) {
                        onSuccess(body);
                        unit = Unit.INSTANCE;
                    } else if (code != 9) {
                        HandlerException handlerException3 = getHandlerException();
                        if (handlerException3 != null) {
                            handlerException3.handleException(new HandlerException.BusinessThrowable(new HandlerException(), hiResponse.getCode(), hiResponse.getMsg()));
                            unit = Unit.INSTANCE;
                        }
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("isToken", true);
                        bundle.putString("message", hiResponse.getMsg());
                        XesRoute.getInstance().navigation(RouteMap.ROUTE_MAIN_ACTIVITY, bundle);
                        unit = Unit.INSTANCE;
                    }
                } else {
                    HandlerException handlerException4 = getHandlerException();
                    if (handlerException4 != null) {
                        handlerException4.handleException(new HandlerException.BusinessThrowable(new HandlerException(), hiResponse.getCode(), hiResponse.getMsg()));
                        unit = Unit.INSTANCE;
                    }
                }
            } else {
                onSuccess(body);
                unit = Unit.INSTANCE;
            }
            unit2 = unit;
        }
        if (unit2 == null) {
            OmyCallback omyCallback = this;
            okhttp3.Response raw = response.raw();
            if (raw != null && (handlerException2 = getHandlerException()) != null) {
                handlerException2.handleException(new HandlerException.BusinessThrowable(new HandlerException(), raw.code(), raw.message()));
            }
        }
    }
}
