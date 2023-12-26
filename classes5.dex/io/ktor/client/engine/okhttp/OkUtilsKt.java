package io.ktor.client.engine.okhttp;

import com.bonree.sdk.agent.engine.external.OkHttp3Instrumentation;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import java.io.IOException;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a%\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0000\u001a\f\u0010\f\u001a\u00020\u000f*\u00020\u0010H\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0005H\u0002\u001a\f\u0010\u0013\u001a\u00020\u0001*\u00020\u0005H\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"mapOkHttpException", "", "requestData", "Lio/ktor/client/request/HttpRequestData;", "origin", "Ljava/io/IOException;", "execute", "Lokhttp3/Response;", "Lokhttp3/OkHttpClient;", "request", "Lokhttp3/Request;", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fromOkHttp", "Lio/ktor/http/Headers;", "Lokhttp3/Headers;", "Lio/ktor/http/HttpProtocolVersion;", "Lokhttp3/Protocol;", "isConnectException", "", "unwrapSuppressed", "ktor-client-okhttp"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkUtils.kt */
public final class OkUtilsKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OkUtils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Protocol.values().length];
            iArr[Protocol.HTTP_1_0.ordinal()] = 1;
            iArr[Protocol.HTTP_1_1.ordinal()] = 2;
            iArr[Protocol.SPDY_3.ordinal()] = 3;
            iArr[Protocol.HTTP_2.ordinal()] = 4;
            iArr[Protocol.H2_PRIOR_KNOWLEDGE.ordinal()] = 5;
            iArr[Protocol.QUIC.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Headers fromOkHttp(okhttp3.Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        return new OkUtilsKt$fromOkHttp$1(headers);
    }

    public static final HttpProtocolVersion fromOkHttp(Protocol protocol) {
        Intrinsics.checkNotNullParameter(protocol, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[protocol.ordinal()]) {
            case 1:
                return HttpProtocolVersion.Companion.getHTTP_1_0();
            case 2:
                return HttpProtocolVersion.Companion.getHTTP_1_1();
            case 3:
                return HttpProtocolVersion.Companion.getSPDY_3();
            case 4:
                return HttpProtocolVersion.Companion.getHTTP_2_0();
            case 5:
                return HttpProtocolVersion.Companion.getHTTP_2_0();
            case 6:
                return HttpProtocolVersion.Companion.getQUIC();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* access modifiers changed from: private */
    public static final Throwable mapOkHttpException(HttpRequestData httpRequestData, IOException iOException) {
        IOException iOException2;
        Throwable unwrapSuppressed = unwrapSuppressed(iOException);
        if (!(unwrapSuppressed instanceof SocketTimeoutException)) {
            return unwrapSuppressed;
        }
        if (isConnectException((IOException) unwrapSuppressed)) {
            iOException2 = HttpTimeoutKt.ConnectTimeoutException(httpRequestData, unwrapSuppressed);
        } else {
            iOException2 = HttpTimeoutKt.SocketTimeoutException(httpRequestData, unwrapSuppressed);
        }
        return iOException2;
    }

    private static final boolean isConnectException(IOException iOException) {
        String message = iOException.getMessage();
        return message != null && StringsKt.contains((CharSequence) message, (CharSequence) "connect", true);
    }

    private static final Throwable unwrapSuppressed(IOException iOException) {
        Throwable[] suppressed = iOException.getSuppressed();
        Intrinsics.checkNotNullExpressionValue(suppressed, "suppressed");
        if (!(!(((Object[]) suppressed).length == 0))) {
            return iOException;
        }
        Throwable th = iOException.getSuppressed()[0];
        Intrinsics.checkNotNullExpressionValue(th, "suppressed[0]");
        return th;
    }

    public static final Object execute(OkHttpClient okHttpClient, Request request, HttpRequestData httpRequestData, Continuation<? super Response> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        Call newCall = !(okHttpClient instanceof OkHttpClient) ? okHttpClient.newCall(request) : OkHttp3Instrumentation.newCall(okHttpClient, request);
        newCall.enqueue(new OkHttpCallback(httpRequestData, cancellableContinuation));
        cancellableContinuation.invokeOnCancellation(new OkUtilsKt$execute$2$1(newCall));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
