package io.ktor.client.plugins;

import io.ktor.client.plugins.observer.DelegatedCallKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ByteChannelUtilsKt;
import io.ktor.http.HttpMessage;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.AttributeKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\\\u0010\f\u001a\u00020\t*\u00020\r2H\u0010\u000e\u001aD\b\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\\\u0010\u0010\u001a\u00020\t*\u00020\r2H\u0010\u000e\u001aD\b\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\\\u0010\u0011\u001a\u00020\u0012*\u00020\u00122F\u0010\u000e\u001aB\b\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0002H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0013\"W\u0010\u0000\u001aH\u0012D\u0012B\b\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\"W\u0010\u000b\u001aH\u0012D\u0012B\b\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"DownloadProgressListenerAttributeKey", "Lio/ktor/util/AttributeKey;", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "bytesSentTotal", "contentLength", "Lkotlin/coroutines/Continuation;", "", "", "UploadProgressListenerAttributeKey", "onDownload", "Lio/ktor/client/request/HttpRequestBuilder;", "listener", "(Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/jvm/functions/Function3;)V", "onUpload", "withObservableDownload", "Lio/ktor/client/statement/HttpResponse;", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/jvm/functions/Function3;)Lio/ktor/client/statement/HttpResponse;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BodyProgress.kt */
public final class BodyProgressKt {
    /* access modifiers changed from: private */
    public static final AttributeKey<Function3<Long, Long, Continuation<? super Unit>, Object>> DownloadProgressListenerAttributeKey = new AttributeKey<>("DownloadProgressListenerAttributeKey");
    /* access modifiers changed from: private */
    public static final AttributeKey<Function3<Long, Long, Continuation<? super Unit>, Object>> UploadProgressListenerAttributeKey = new AttributeKey<>("UploadProgressListenerAttributeKey");

    public static final HttpResponse withObservableDownload(HttpResponse httpResponse, Function3<? super Long, ? super Long, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        Intrinsics.checkNotNullParameter(function3, "listener");
        return DelegatedCallKt.wrapWithContent(httpResponse, ByteChannelUtilsKt.observable(httpResponse.getContent(), httpResponse.getCoroutineContext(), HttpMessagePropertiesKt.contentLength((HttpMessage) httpResponse), function3));
    }

    public static final void onDownload(HttpRequestBuilder httpRequestBuilder, Function3<? super Long, ? super Long, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        if (function3 == null) {
            httpRequestBuilder.getAttributes().remove(DownloadProgressListenerAttributeKey);
        } else {
            httpRequestBuilder.getAttributes().put(DownloadProgressListenerAttributeKey, function3);
        }
    }

    public static final void onUpload(HttpRequestBuilder httpRequestBuilder, Function3<? super Long, ? super Long, ? super Continuation<? super Unit>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        if (function3 == null) {
            httpRequestBuilder.getAttributes().remove(UploadProgressListenerAttributeKey);
        } else {
            httpRequestBuilder.getAttributes().put(UploadProgressListenerAttributeKey, function3);
        }
    }
}
