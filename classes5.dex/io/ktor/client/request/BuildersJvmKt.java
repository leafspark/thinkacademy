package io.ktor.client.request;

import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsJvmKt;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a8\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a8\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a8\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a8\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a8\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a8\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a8\u0010\u0012\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a8\u0010\u0013\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a8\u0010\u0014\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a8\u0010\u0015\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a8\u0010\u0016\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a8\u0010\u0017\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a8\u0010\u0018\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a8\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a8\u0010\u001a\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0002\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"delete", "Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/HttpClient;", "url", "Ljava/net/URL;", "block", "Lkotlin/Function1;", "Lio/ktor/client/request/HttpRequestBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lio/ktor/client/HttpClient;Ljava/net/URL;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "head", "options", "patch", "post", "prepareDelete", "Lio/ktor/client/statement/HttpStatement;", "prepareGet", "prepareHead", "prepareOptions", "preparePatch", "preparePost", "preparePut", "prepareRequest", "put", "request", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: buildersJvm.kt */
public final class BuildersJvmKt {
    public static /* synthetic */ Object request$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersJvmKt$request$2.INSTANCE;
        }
        return request(httpClient, url, function1, continuation);
    }

    public static /* synthetic */ Object get$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersJvmKt$get$2.INSTANCE;
        }
        return get(httpClient, url, function1, continuation);
    }

    public static /* synthetic */ Object post$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersJvmKt$post$2.INSTANCE;
        }
        return post(httpClient, url, function1, continuation);
    }

    public static /* synthetic */ Object put$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersJvmKt$put$2.INSTANCE;
        }
        return put(httpClient, url, function1, continuation);
    }

    public static /* synthetic */ Object patch$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersJvmKt$patch$2.INSTANCE;
        }
        return patch(httpClient, url, function1, continuation);
    }

    public static /* synthetic */ Object options$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersJvmKt$options$2.INSTANCE;
        }
        return options(httpClient, url, function1, continuation);
    }

    public static /* synthetic */ Object head$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersJvmKt$head$2.INSTANCE;
        }
        return head(httpClient, url, function1, continuation);
    }

    public static /* synthetic */ Object delete$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersJvmKt$delete$2.INSTANCE;
        }
        return delete(httpClient, url, function1, continuation);
    }

    public static /* synthetic */ Object prepareRequest$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersJvmKt$prepareRequest$2.INSTANCE;
        }
        return prepareRequest(httpClient, url, function1, continuation);
    }

    public static /* synthetic */ Object prepareGet$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersJvmKt$prepareGet$2.INSTANCE;
        }
        return prepareGet(httpClient, url, function1, continuation);
    }

    public static /* synthetic */ Object preparePost$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersJvmKt$preparePost$2.INSTANCE;
        }
        return preparePost(httpClient, url, function1, continuation);
    }

    public static /* synthetic */ Object preparePut$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersJvmKt$preparePut$2.INSTANCE;
        }
        return preparePut(httpClient, url, function1, continuation);
    }

    public static /* synthetic */ Object preparePatch$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersJvmKt$preparePatch$2.INSTANCE;
        }
        return preparePatch(httpClient, url, function1, continuation);
    }

    public static /* synthetic */ Object prepareOptions$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersJvmKt$prepareOptions$2.INSTANCE;
        }
        return prepareOptions(httpClient, url, function1, continuation);
    }

    public static /* synthetic */ Object prepareHead$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersJvmKt$prepareHead$2.INSTANCE;
        }
        return prepareHead(httpClient, url, function1, continuation);
    }

    public static /* synthetic */ Object prepareDelete$default(HttpClient httpClient, URL url, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersJvmKt$prepareDelete$2.INSTANCE;
        }
        return prepareDelete(httpClient, url, function1, continuation);
    }

    public static final Object request(HttpClient httpClient, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static final Object get(HttpClient httpClient, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static final Object post(HttpClient httpClient, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static final Object put(HttpClient httpClient, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static final Object patch(HttpClient httpClient, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static final Object options(HttpClient httpClient, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static final Object head(HttpClient httpClient, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static final Object delete(HttpClient httpClient, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpResponse> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public static final Object prepareRequest(HttpClient httpClient, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareGet(HttpClient httpClient, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePost(HttpClient httpClient, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePut(HttpClient httpClient, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPut());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object preparePatch(HttpClient httpClient, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getPatch());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareOptions(HttpClient httpClient, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getOptions());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareHead(HttpClient httpClient, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getHead());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }

    public static final Object prepareDelete(HttpClient httpClient, URL url, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super HttpStatement> continuation) {
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        URLUtilsJvmKt.takeFrom(httpRequestBuilder.getUrl(), url);
        function1.invoke(httpRequestBuilder);
        httpRequestBuilder.setMethod(HttpMethod.Companion.getDelete());
        return new HttpStatement(httpRequestBuilder, httpClient);
    }
}
