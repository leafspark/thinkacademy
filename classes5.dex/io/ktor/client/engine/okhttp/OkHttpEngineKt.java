package io.ktor.client.engine.okhttp;

import io.ktor.client.call.UnsupportedContentTypeException;
import io.ktor.client.engine.UtilsKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;
import okio.BufferedSource;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002\u001a\u0014\u0010\f\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¨\u0006\u0015"}, d2 = {"mapExceptions", "", "cause", "request", "Lio/ktor/client/request/HttpRequestData;", "convertToOkHttpBody", "Lokhttp3/RequestBody;", "Lio/ktor/http/content/OutgoingContent;", "callContext", "Lkotlin/coroutines/CoroutineContext;", "convertToOkHttpRequest", "Lokhttp3/Request;", "setupTimeoutAttributes", "Lokhttp3/OkHttpClient$Builder;", "timeoutAttributes", "Lio/ktor/client/plugins/HttpTimeout$HttpTimeoutCapabilityConfiguration;", "toChannel", "Lio/ktor/utils/io/ByteReadChannel;", "Lokio/BufferedSource;", "context", "requestData", "ktor-client-okhttp"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkHttpEngine.kt */
public final class OkHttpEngineKt {
    /* access modifiers changed from: private */
    public static final ByteReadChannel toChannel(BufferedSource bufferedSource, CoroutineContext coroutineContext, HttpRequestData httpRequestData) {
        return CoroutinesKt.writer$default((CoroutineScope) GlobalScope.INSTANCE, coroutineContext, false, new OkHttpEngineKt$toChannel$1(bufferedSource, coroutineContext, httpRequestData, (Continuation<? super OkHttpEngineKt$toChannel$1>) null), 2, (Object) null).getChannel();
    }

    /* access modifiers changed from: private */
    public static final Throwable mapExceptions(Throwable th, HttpRequestData httpRequestData) {
        return th instanceof SocketTimeoutException ? HttpTimeoutKt.SocketTimeoutException(httpRequestData, th) : th;
    }

    /* access modifiers changed from: private */
    public static final Request convertToOkHttpRequest(HttpRequestData httpRequestData, CoroutineContext coroutineContext) {
        Request.Builder builder = new Request.Builder();
        builder.url(httpRequestData.getUrl().toString());
        UtilsKt.mergeHeaders(httpRequestData.getHeaders(), httpRequestData.getBody(), new OkHttpEngineKt$convertToOkHttpRequest$1$1(builder));
        builder.method(httpRequestData.getMethod().getValue(), HttpMethod.permitsRequestBody(httpRequestData.getMethod().getValue()) ? convertToOkHttpBody(httpRequestData.getBody(), coroutineContext) : null);
        return builder.build();
    }

    public static final RequestBody convertToOkHttpBody(OutgoingContent outgoingContent, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(outgoingContent, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "callContext");
        if (outgoingContent instanceof OutgoingContent.ByteArrayContent) {
            byte[] bytes = ((OutgoingContent.ByteArrayContent) outgoingContent).bytes();
            return RequestBody.Companion.create(bytes, (MediaType) null, 0, bytes.length);
        } else if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
            return new StreamRequestBody(outgoingContent.getContentLength(), new OkHttpEngineKt$convertToOkHttpBody$2(outgoingContent));
        } else {
            if (outgoingContent instanceof OutgoingContent.WriteChannelContent) {
                return new StreamRequestBody(outgoingContent.getContentLength(), new OkHttpEngineKt$convertToOkHttpBody$3(coroutineContext, outgoingContent));
            }
            if (outgoingContent instanceof OutgoingContent.NoContent) {
                return RequestBody.Companion.create(new byte[0], (MediaType) null, 0, 0);
            }
            throw new UnsupportedContentTypeException(outgoingContent);
        }
    }

    /* access modifiers changed from: private */
    public static final OkHttpClient.Builder setupTimeoutAttributes(OkHttpClient.Builder builder, HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration) {
        Long connectTimeoutMillis = httpTimeoutCapabilityConfiguration.getConnectTimeoutMillis();
        if (connectTimeoutMillis != null) {
            builder.connectTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(connectTimeoutMillis.longValue()), TimeUnit.MILLISECONDS);
        }
        Long socketTimeoutMillis = httpTimeoutCapabilityConfiguration.getSocketTimeoutMillis();
        if (socketTimeoutMillis != null) {
            long longValue = socketTimeoutMillis.longValue();
            builder.readTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(longValue), TimeUnit.MILLISECONDS);
            builder.writeTimeout(HttpTimeoutKt.convertLongTimeoutToLongWithInfiniteAsZero(longValue), TimeUnit.MILLISECONDS);
        }
        return builder;
    }
}
