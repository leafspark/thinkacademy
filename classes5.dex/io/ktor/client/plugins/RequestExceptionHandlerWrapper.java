package io.ktor.client.plugins;

import io.ktor.client.request.HttpRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001BP\u0012F\u0010\u0002\u001aB\b\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0003ø\u0001\u0000¢\u0006\u0002\u0010\rRV\u0010\u0002\u001aB\b\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0003ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lio/ktor/client/plugins/RequestExceptionHandlerWrapper;", "Lio/ktor/client/plugins/HandlerWrapper;", "handler", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "cause", "Lio/ktor/client/request/HttpRequest;", "request", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlin/jvm/functions/Function3;)V", "getHandler", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpCallValidator.kt */
public final class RequestExceptionHandlerWrapper implements HandlerWrapper {
    private final Function3<Throwable, HttpRequest, Continuation<? super Unit>, Object> handler;

    public RequestExceptionHandlerWrapper(Function3<? super Throwable, ? super HttpRequest, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(function3, "handler");
        this.handler = function3;
    }

    public final Function3<Throwable, HttpRequest, Continuation<? super Unit>, Object> getHandler() {
        return this.handler;
    }
}
