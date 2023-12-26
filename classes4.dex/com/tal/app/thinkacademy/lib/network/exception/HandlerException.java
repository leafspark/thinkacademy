package com.tal.app.thinkacademy.lib.network.exception;

import android.os.Handler;
import android.os.Looper;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.google.gson.JsonParseException;
import java.io.InterruptedIOException;
import java.io.NotSerializableException;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.json.JSONException;
import retrofit2.HttpException;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0003\u0017\u0018\u0019B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/tal/app/thinkacademy/lib/network/exception/HandlerException;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "error", "Lcom/tal/app/thinkacademy/lib/network/exception/IError;", "(Lcom/tal/app/thinkacademy/lib/network/exception/IError;)V", "()V", "getError", "()Lcom/tal/app/thinkacademy/lib/network/exception/IError;", "setError", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "handleException", "", "e", "", "context", "Lkotlin/coroutines/CoroutineContext;", "BusinessThrowable", "Companion", "NetThrowable", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HandlerException.kt */
public final class HandlerException implements CoroutineExceptionHandler {
    private static final int BAD_GATEWAY = 502;
    private static final int CONNECT_ERROR = 1009;
    private static final int CONNECT_TIMEOUT_ERROR = 1005;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int FORBIDDEN = 403;
    private static final int GATEWAY_TIMEOUT = 504;
    private static final int HTTP_ERROR = 600;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int INTERRUPTED_ERROR = 1006;
    private static final int JSON_PARSE_ERROR = 800;
    private static final int NOT_FOUND = 404;
    private static final int NOT_SERIALIZABLE_ERROR = 1004;
    private static final int NO_NET_CONNECT = 1000;
    private static final int OTHER_ERROR = 9999;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int SSL_HANDSHAKE_ERROR = 1007;
    private static final int SSL_PEER_UNVERIFIED_ERROR = 1008;
    private static final int UNAUTHORIZED = 401;
    private static final int UNKNOWN_HOST_ERROR = 1002;
    private static final int UNKNOWN_SERVICE_ERROR = 1003;
    private static final int URL_ERROR = 1001;
    private IError error;
    private final Handler handler;

    public HandlerException() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return CoroutineExceptionHandler.DefaultImpls.fold((CoroutineExceptionHandler) this, r, function2);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return CoroutineExceptionHandler.DefaultImpls.get((CoroutineExceptionHandler) this, key);
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return CoroutineExceptionHandler.DefaultImpls.minusKey((CoroutineExceptionHandler) this, key);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineExceptionHandler.DefaultImpls.plus((CoroutineExceptionHandler) this, coroutineContext);
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final IError getError() {
        return this.error;
    }

    public final void setError(IError iError) {
        this.error = iError;
    }

    public HandlerException(IError iError) {
        this();
        this.error = iError;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/lib/network/exception/HandlerException$Companion;", "", "()V", "BAD_GATEWAY", "", "CONNECT_ERROR", "CONNECT_TIMEOUT_ERROR", "FORBIDDEN", "GATEWAY_TIMEOUT", "HTTP_ERROR", "INTERNAL_SERVER_ERROR", "INTERRUPTED_ERROR", "JSON_PARSE_ERROR", "NOT_FOUND", "NOT_SERIALIZABLE_ERROR", "NO_NET_CONNECT", "OTHER_ERROR", "REQUEST_TIMEOUT", "SERVICE_UNAVAILABLE", "SSL_HANDSHAKE_ERROR", "SSL_PEER_UNVERIFIED_ERROR", "UNAUTHORIZED", "UNKNOWN_HOST_ERROR", "UNKNOWN_SERVICE_ERROR", "URL_ERROR", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HandlerException.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public CoroutineContext.Key<?> getKey() {
        return (CoroutineContext.Key) CoroutineExceptionHandler.Key;
    }

    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(th, "e");
        handleException(th);
    }

    public final void handleException(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "e");
        if (th instanceof HttpException) {
            int code = ((HttpException) th).code();
            if (code == UNAUTHORIZED) {
                new NetThrowable(this, UNAUTHORIZED, th.getMessage());
            } else if (code == REQUEST_TIMEOUT) {
                new NetThrowable(this, REQUEST_TIMEOUT, th.getMessage());
            } else if (code == INTERNAL_SERVER_ERROR) {
                new NetThrowable(this, INTERNAL_SERVER_ERROR, th.getMessage());
            } else if (code == FORBIDDEN) {
                new NetThrowable(this, FORBIDDEN, th.getMessage());
            } else if (code != NOT_FOUND) {
                switch (code) {
                    case BAD_GATEWAY /*502*/:
                        new NetThrowable(this, BAD_GATEWAY, th.getMessage());
                        return;
                    case SERVICE_UNAVAILABLE /*503*/:
                        new NetThrowable(this, SERVICE_UNAVAILABLE, th.getMessage());
                        return;
                    case GATEWAY_TIMEOUT /*504*/:
                        new NetThrowable(this, GATEWAY_TIMEOUT, th.getMessage());
                        return;
                    default:
                        new NetThrowable(this, HTTP_ERROR, th.getMessage());
                        return;
                }
            } else {
                new NetThrowable(this, NOT_FOUND, th.getMessage());
            }
        } else if ((th instanceof JsonParseException) || (th instanceof JSONException)) {
            new NetThrowable(this, 800, th.getMessage());
        } else if (th instanceof MalformedURLException) {
            new NetThrowable(this, 1001, th.getMessage());
        } else if (th instanceof UnknownHostException) {
            new NetThrowable(this, 1002, th.getMessage());
        } else if (th instanceof UnknownServiceException) {
            new NetThrowable(this, 1003, th.getMessage());
        } else if (th instanceof NotSerializableException) {
            new NetThrowable(this, 1004, th.getMessage());
        } else if (th instanceof SocketTimeoutException) {
            new NetThrowable(this, 1005, th.getMessage());
        } else if (th instanceof InterruptedIOException) {
            new NetThrowable(this, 1006, th.getMessage());
        } else if (th instanceof SSLHandshakeException) {
            new NetThrowable(this, 1007, th.getMessage());
        } else if (th instanceof SSLPeerUnverifiedException) {
            new NetThrowable(this, SSL_PEER_UNVERIFIED_ERROR, th.getMessage());
        } else if (th instanceof ConnectException) {
            new NetThrowable(this, CONNECT_ERROR, th.getMessage());
        } else if (th instanceof BusinessThrowable) {
            BusinessThrowable businessThrowable = (BusinessThrowable) th;
            new BusinessThrowable(this, businessThrowable.getCode(), businessThrowable.getError_msg());
        } else {
            new NetThrowable(this, OTHER_ERROR, th.getMessage());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/lib/network/exception/HandlerException$NetThrowable;", "", "code", "", "message", "", "(Lcom/tal/app/thinkacademy/lib/network/exception/HandlerException;ILjava/lang/String;)V", "getCode", "()I", "setCode", "(I)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HandlerException.kt */
    public final class NetThrowable extends Throwable {
        private int code;
        private String message;
        final /* synthetic */ HandlerException this$0;

        public NetThrowable(HandlerException handlerException, int i, String str) {
            Intrinsics.checkNotNullParameter(handlerException, "this$0");
            this.this$0 = handlerException;
            this.code = i;
            this.message = str;
            Handler handler = handlerException.getHandler();
            HandlerException$NetThrowable$$ExternalSyntheticLambda0 handlerException$NetThrowable$$ExternalSyntheticLambda0 = new HandlerException$NetThrowable$$ExternalSyntheticLambda0(handlerException, this);
            if (!(handler instanceof Handler)) {
                handler.post(handlerException$NetThrowable$$ExternalSyntheticLambda0);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, handlerException$NetThrowable$$ExternalSyntheticLambda0);
            }
        }

        public final int getCode() {
            return this.code;
        }

        public String getMessage() {
            return this.message;
        }

        public final void setCode(int i) {
            this.code = i;
        }

        public void setMessage(String str) {
            this.message = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-1  reason: not valid java name */
        public static final void m93_init_$lambda1(HandlerException handlerException, NetThrowable netThrowable) {
            Intrinsics.checkNotNullParameter(handlerException, "this$0");
            Intrinsics.checkNotNullParameter(netThrowable, "this$1");
            IError error = handlerException.getError();
            if (error != null) {
                error.onFail(netThrowable.getCode(), netThrowable.getMessage());
            }
            PrintStream printStream = System.out;
            printStream.println("exception : code is " + netThrowable.code + "  message is " + netThrowable.getMessage());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/tal/app/thinkacademy/lib/network/exception/HandlerException$BusinessThrowable;", "", "code", "", "error_msg", "", "(Lcom/tal/app/thinkacademy/lib/network/exception/HandlerException;ILjava/lang/String;)V", "getCode", "()I", "setCode", "(I)V", "getError_msg", "()Ljava/lang/String;", "setError_msg", "(Ljava/lang/String;)V", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HandlerException.kt */
    public final class BusinessThrowable extends Throwable {
        private int code;
        private String error_msg;
        final /* synthetic */ HandlerException this$0;

        public BusinessThrowable(HandlerException handlerException, int i, String str) {
            Intrinsics.checkNotNullParameter(handlerException, "this$0");
            this.this$0 = handlerException;
            this.code = i;
            this.error_msg = str;
            Handler handler = handlerException.getHandler();
            HandlerException$BusinessThrowable$$ExternalSyntheticLambda0 handlerException$BusinessThrowable$$ExternalSyntheticLambda0 = new HandlerException$BusinessThrowable$$ExternalSyntheticLambda0(handlerException, this);
            if (!(handler instanceof Handler)) {
                handler.post(handlerException$BusinessThrowable$$ExternalSyntheticLambda0);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, handlerException$BusinessThrowable$$ExternalSyntheticLambda0);
            }
        }

        public final int getCode() {
            return this.code;
        }

        public final String getError_msg() {
            return this.error_msg;
        }

        public final void setCode(int i) {
            this.code = i;
        }

        public final void setError_msg(String str) {
            this.error_msg = str;
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-1  reason: not valid java name */
        public static final void m91_init_$lambda1(HandlerException handlerException, BusinessThrowable businessThrowable) {
            Intrinsics.checkNotNullParameter(handlerException, "this$0");
            Intrinsics.checkNotNullParameter(businessThrowable, "this$1");
            IError error = handlerException.getError();
            if (error != null) {
                error.onError(businessThrowable.getCode(), businessThrowable.getError_msg());
            }
            PrintStream printStream = System.out;
            printStream.println("exception : code is " + businessThrowable.code + "  message is " + businessThrowable.error_msg);
        }
    }
}
