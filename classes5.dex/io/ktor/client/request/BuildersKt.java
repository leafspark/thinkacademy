package io.ktor.client.request;

import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005\u001a\u001d\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0001HHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a.\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a8\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010\u000f\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0001HHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a.\u0010\u000f\u001a\u00020\u0007*\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a8\u0010\u000f\u001a\u00020\u0007*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010\u0010\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0001HHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a.\u0010\u0010\u001a\u00020\u0007*\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a8\u0010\u0010\u001a\u00020\u0007*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010\u0011\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0001HHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a.\u0010\u0011\u001a\u00020\u0007*\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a8\u0010\u0011\u001a\u00020\u0007*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010\u0012\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0001HHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a.\u0010\u0012\u001a\u00020\u0007*\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a8\u0010\u0012\u001a\u00020\u0007*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010\u0013\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0001HHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a.\u0010\u0013\u001a\u00020\u0007*\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a8\u0010\u0013\u001a\u00020\u0007*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010\u0014\u001a\u00020\u0015*\u00020\b2\u0006\u0010\t\u001a\u00020\u0001HHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a.\u0010\u0014\u001a\u00020\u0015*\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a8\u0010\u0014\u001a\u00020\u0015*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010\u0016\u001a\u00020\u0015*\u00020\b2\u0006\u0010\t\u001a\u00020\u0001HHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a.\u0010\u0016\u001a\u00020\u0015*\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a8\u0010\u0016\u001a\u00020\u0015*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010\u0017\u001a\u00020\u0015*\u00020\b2\u0006\u0010\t\u001a\u00020\u0001HHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a.\u0010\u0017\u001a\u00020\u0015*\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a8\u0010\u0017\u001a\u00020\u0015*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010\u0018\u001a\u00020\u0015*\u00020\b2\u0006\u0010\t\u001a\u00020\u0001HHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a.\u0010\u0018\u001a\u00020\u0015*\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a8\u0010\u0018\u001a\u00020\u0015*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010\u0019\u001a\u00020\u0015*\u00020\b2\u0006\u0010\t\u001a\u00020\u0001HHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a.\u0010\u0019\u001a\u00020\u0015*\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a8\u0010\u0019\u001a\u00020\u0015*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010\u001a\u001a\u00020\u0015*\u00020\b2\u0006\u0010\t\u001a\u00020\u0001HHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a.\u0010\u001a\u001a\u00020\u0015*\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a8\u0010\u001a\u001a\u00020\u0015*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010\u001b\u001a\u00020\u0015*\u00020\b2\u0006\u0010\t\u001a\u00020\u0001HHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a.\u0010\u001b\u001a\u00020\u0015*\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a8\u0010\u001b\u001a\u00020\u0015*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001f\u0010\u001c\u001a\u00020\u0015*\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0001HHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a.\u0010\u001c\u001a\u00020\u0015*\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a8\u0010\u001c\u001a\u00020\u0015*\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001a8\u0010\u001c\u001a\u00020\u0015*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001d\u0010 \u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0001HHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a.\u0010 \u001a\u00020\u0007*\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a8\u0010 \u001a\u00020\u0007*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a\u001f\u0010\u0000\u001a\u00020\u0007*\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0001HHø\u0001\u0000¢\u0006\u0002\u0010\n\u001a.\u0010\u0000\u001a\u00020\u0007*\u00020\b2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a8\u0010\u0000\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001a8\u0010\u0000\u001a\u00020\u0007*\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0019\b\u0002\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005HHø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"request", "Lio/ktor/client/request/HttpRequestBuilder;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "delete", "Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/HttpClient;", "builder", "(Lio/ktor/client/HttpClient;Lio/ktor/client/request/HttpRequestBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urlString", "", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "head", "options", "patch", "post", "prepareDelete", "Lio/ktor/client/statement/HttpStatement;", "prepareGet", "prepareHead", "prepareOptions", "preparePatch", "preparePost", "preparePut", "prepareRequest", "url", "Lio/ktor/http/Url;", "(Lio/ktor/client/HttpClient;Lio/ktor/http/Url;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "put", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: builders.kt */
public final class BuildersKt {
    public static /* synthetic */ Object request$default(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            httpRequestBuilder = new HttpRequestBuilder();
        }
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object request(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpResponse> continuation) {
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object request$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpResponse> continuation) {
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object prepareRequest$default(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            httpRequestBuilder = new HttpRequestBuilder();
        }
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareRequest(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpStatement> continuation) {
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareRequest$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpStatement> continuation) {
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object request(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object request$$forInline(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object prepareRequest(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareRequest$$forInline(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object request$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$request$4.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object prepareRequest$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$prepareRequest$4.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object request$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$request$7.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, url);
        function1.invoke(httpRequestBuilder);
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object prepareRequest$default(HttpClient httpClient, Url url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$prepareRequest$7.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object get(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpResponse> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object get$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpResponse> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object post(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpResponse> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object post$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpResponse> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object put(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpResponse> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object put$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpResponse> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPut());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object delete(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpResponse> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object delete$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpResponse> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getDelete());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object options(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpResponse> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object options$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpResponse> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getOptions());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object patch(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpResponse> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object patch$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpResponse> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPatch());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object head(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpResponse> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object head$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpResponse> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getHead());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object prepareGet(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpStatement> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareGet$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpStatement> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePost(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpStatement> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePost$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpStatement> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePut(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpStatement> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePut$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpStatement> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareDelete(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpStatement> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareDelete$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpStatement> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareOptions(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpStatement> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareOptions$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpStatement> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePatch(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpStatement> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePatch$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpStatement> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareHead(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpStatement> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareHead$$forInline(HttpClient httpClient, HttpRequestBuilder httpRequestBuilder, Continuation<? super HttpStatement> continuation) {
        httpRequestBuilder.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object get(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object get$$forInline(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object post(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object post$$forInline(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object put(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object put$$forInline(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPut());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object delete(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object delete$$forInline(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getDelete());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object options(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object options$$forInline(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getOptions());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object patch(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object patch$$forInline(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPatch());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object head(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object head$$forInline(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getHead());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object prepareGet(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareGet$$forInline(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePost(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePost$$forInline(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePut(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePut$$forInline(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareDelete(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareDelete$$forInline(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareOptions(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareOptions$$forInline(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePatch(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePatch$$forInline(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareHead(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareHead$$forInline(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final HttpRequestBuilder request(Function1<? super HttpRequestBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        function1.invoke(httpRequestBuilder);
        return httpRequestBuilder;
    }

    public static /* synthetic */ Object get$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$get$4.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object post$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$post$4.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object put$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$put$4.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPut());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object delete$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$delete$4.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getDelete());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object options$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$options$4.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getOptions());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object patch$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$patch$4.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPatch());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object head$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$head$4.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getHead());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static /* synthetic */ Object prepareGet$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$prepareGet$4.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePost$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$preparePost$4.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePut$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$preparePut$4.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareDelete$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$prepareDelete$4.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareOptions$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$prepareOptions$4.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object preparePatch$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$preparePatch$4.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static /* synthetic */ Object prepareHead$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$prepareHead$4.INSTANCE;
        }
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object request(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object request$$forInline(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object prepareRequest(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareRequest$$forInline(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object request(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object request$$forInline(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, url);
        function1.invoke(httpRequestBuilder);
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object prepareRequest(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareRequest$$forInline(HttpClient httpClient, Url url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object get(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object get$$forInline(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object post(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object post$$forInline(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object put(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object put$$forInline(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPut());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object delete(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object delete$$forInline(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getDelete());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object options(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object options$$forInline(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getOptions());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object patch(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object patch$$forInline(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPatch());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object head(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    private static final Object head$$forInline(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getHead());
        HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, httpClient);
        InlineMarker.mark(0);
        Object execute = httpStatement.execute(continuation);
        InlineMarker.mark(1);
        return execute;
    }

    public static final Object prepareGet(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareGet$$forInline(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePost(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePost$$forInline(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePut(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePut$$forInline(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareDelete(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareDelete$$forInline(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareOptions(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareOptions$$forInline(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePatch(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object preparePatch$$forInline(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareHead(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    private static final Object prepareHead$$forInline(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        HttpRequestKt.url(httpRequestBuilder, str);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }
}
