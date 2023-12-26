package io.ktor.client.plugins.websocket;

import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.plugins.websocket.WebSockets;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u001a'\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006\u001aW\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0001\u0010\u0007\u001a\u00020\u0001*\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aa\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a.\u0010\u001b\u001a\u00020\r*\u00020\b2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a^\u0010\u001b\u001a\u00020\r*\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a8\u0010\u001b\u001a\u00020\r*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00142\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001aW\u0010\u001f\u001a\u00020\u0001*\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0001\u0010\u001f\u001a\u00020\u0001*\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aa\u0010\u001f\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001aW\u0010 \u001a\u00020\u0001*\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0001\u0010 \u001a\u00020\u0001*\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aa\u0010 \u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"WebSockets", "", "Lio/ktor/client/HttpClientConfig;", "config", "Lkotlin/Function1;", "Lio/ktor/client/plugins/websocket/WebSockets$Config;", "Lkotlin/ExtensionFunctionType;", "webSocket", "Lio/ktor/client/HttpClient;", "request", "Lio/ktor/client/request/HttpRequestBuilder;", "block", "Lkotlin/Function2;", "Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;", "Lkotlin/coroutines/Continuation;", "", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "method", "Lio/ktor/http/HttpMethod;", "host", "", "port", "", "path", "(Lio/ktor/client/HttpClient;Lio/ktor/http/HttpMethod;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urlString", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "webSocketSession", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Lio/ktor/http/HttpMethod;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ws", "wss", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: builders.kt */
public final class BuildersKt {
    public static final void WebSockets(HttpClientConfig<?> httpClientConfig, Function1<? super WebSockets.Config, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(function1, "config");
        httpClientConfig.install((HttpClientPlugin<? extends TBuilder, TPlugin>) WebSockets.Plugin, (Function1<? super TBuilder, Unit>) new BuildersKt$WebSockets$1(function1));
    }

    public static final Object webSocketSession(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super DefaultClientWebSocketSession> continuation) {
        HttpClientPluginKt.plugin(httpClient, WebSockets.Plugin);
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.url(BuildersKt$webSocketSession$statement$1$1.INSTANCE);
        function1.invoke(httpRequestBuilder);
        Job unused = BuildersKt__Builders_commonKt.launch$default(httpClient, (CoroutineContext) null, (CoroutineStart) null, new BuildersKt$webSocketSession$2(new HttpStatement(httpRequestBuilder, httpClient), CompletableDeferred$default, (Continuation<? super BuildersKt$webSocketSession$2>) null), 3, (Object) null);
        return CompletableDeferred$default.await(continuation);
    }

    public static /* synthetic */ Object webSocketSession$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            httpMethod = HttpMethod.Companion.getGet();
        }
        HttpMethod httpMethod2 = httpMethod;
        String str3 = (i & 2) != 0 ? null : str;
        Integer num2 = (i & 4) != 0 ? null : num;
        String str4 = (i & 8) != 0 ? null : str2;
        if ((i & 16) != 0) {
            function1 = BuildersKt$webSocketSession$4.INSTANCE;
        }
        return webSocketSession(httpClient, httpMethod2, str3, num2, str4, function1, continuation);
    }

    public static final Object webSocketSession(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super DefaultClientWebSocketSession> continuation) {
        return webSocketSession(httpClient, new BuildersKt$webSocketSession$5(httpMethod, str, num, str2, function1), continuation);
    }

    public static /* synthetic */ Object webSocketSession$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$webSocketSession$7.INSTANCE;
        }
        return webSocketSession(httpClient, str, function1, continuation);
    }

    public static final Object webSocketSession(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super DefaultClientWebSocketSession> continuation) {
        return webSocketSession(httpClient, new BuildersKt$webSocketSession$8(str, function1), continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: kotlin.jvm.functions.Function2<? super io.ktor.client.plugins.websocket.DefaultClientWebSocketSession, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: io.ktor.client.statement.HttpResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: io.ktor.client.statement.HttpStatement} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v34, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: io.ktor.client.statement.HttpResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v35, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: io.ktor.client.statement.HttpStatement} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: io.ktor.client.plugins.websocket.BuildersKt$webSocket$1} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c5, code lost:
        r9 = (io.ktor.client.statement.HttpResponse) r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r11 = r9.getCall();
        r2 = kotlin.jvm.internal.Reflection.typeOf(io.ktor.client.plugins.websocket.DefaultClientWebSocketSession.class);
        r2 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(kotlin.reflect.TypesJVMKt.getJavaType(r2), kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(io.ktor.client.plugins.websocket.DefaultClientWebSocketSession.class), r2);
        r0.L$0 = r10;
        r0.L$1 = r8;
        r0.L$2 = r9;
        r0.label = 2;
        r11 = r11.body(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ed, code lost:
        if (r11 != r1) goto L_0x00f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ef, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f0, code lost:
        r7 = r10;
        r10 = r8;
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f3, code lost:
        if (r11 == null) goto L_0x0144;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r11 = (io.ktor.client.plugins.websocket.DefaultClientWebSocketSession) r11;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r0.L$0 = r10;
        r0.L$1 = r9;
        r0.L$2 = r11;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0107, code lost:
        if (r8.invoke(r11, r0) != r1) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0109, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x010a, code lost:
        r8 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r0.L$0 = r10;
        r0.L$1 = r9;
        r0.L$2 = null;
        r0.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x011a, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.close$default(r8, (io.ktor.websocket.CloseReason) null, r0, 1, (java.lang.Object) null) != r1) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x011c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r0.L$0 = kotlin.Unit.INSTANCE;
        r0.L$1 = null;
        r0.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x012a, code lost:
        if (r10.cleanup(r9, r0) != r1) goto L_0x012d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x012c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x012f, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0130, code lost:
        r8 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r0.L$0 = r10;
        r0.L$1 = r9;
        r0.L$2 = r8;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0140, code lost:
        if (io.ktor.websocket.WebSocketSessionKt.close$default(r11, (io.ktor.websocket.CloseReason) null, r0, 1, (java.lang.Object) null) == r1) goto L_0x0142;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0142, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0143, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x014b, code lost:
        throw new java.lang.NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x014c, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x014d, code lost:
        r7 = r10;
        r10 = r8;
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r0.L$0 = r8;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x015d, code lost:
        if (r10.cleanup(r9, r0) == r1) goto L_0x015f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x015f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0160, code lost:
        throw r8;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:66:0x0131=Splitter:B:66:0x0131, B:54:0x010b=Splitter:B:54:0x010b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object webSocket(io.ktor.client.HttpClient r8, kotlin.jvm.functions.Function1<? super io.ktor.client.request.HttpRequestBuilder, kotlin.Unit> r9, kotlin.jvm.functions.Function2<? super io.ktor.client.plugins.websocket.DefaultClientWebSocketSession, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            boolean r0 = r11 instanceof io.ktor.client.plugins.websocket.BuildersKt$webSocket$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.ktor.client.plugins.websocket.BuildersKt$webSocket$1 r0 = (io.ktor.client.plugins.websocket.BuildersKt$webSocket$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.ktor.client.plugins.websocket.BuildersKt$webSocket$1 r0 = new io.ktor.client.plugins.websocket.BuildersKt$webSocket$1
            r0.<init>(r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            switch(r2) {
                case 0: goto L_0x0099;
                case 1: goto L_0x008c;
                case 2: goto L_0x0077;
                case 3: goto L_0x0060;
                case 4: goto L_0x0051;
                case 5: goto L_0x0040;
                case 6: goto L_0x0037;
                case 7: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x002e:
            java.lang.Object r8 = r0.L$0
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CancellationException -> 0x0161 }
            goto L_0x0160
        L_0x0037:
            java.lang.Object r8 = r0.L$0
            kotlin.Unit r8 = (kotlin.Unit) r8
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CancellationException -> 0x0161 }
            goto L_0x012d
        L_0x0040:
            java.lang.Object r8 = r0.L$2
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            java.lang.Object r9 = r0.L$1
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            java.lang.Object r10 = r0.L$0
            io.ktor.client.statement.HttpStatement r10 = (io.ktor.client.statement.HttpStatement) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0089 }
            goto L_0x0143
        L_0x0051:
            java.lang.Object r8 = r0.L$1
            r9 = r8
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            java.lang.Object r8 = r0.L$0
            r10 = r8
            io.ktor.client.statement.HttpStatement r10 = (io.ktor.client.statement.HttpStatement) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0089 }
            goto L_0x011d
        L_0x0060:
            java.lang.Object r8 = r0.L$2
            io.ktor.client.plugins.websocket.DefaultClientWebSocketSession r8 = (io.ktor.client.plugins.websocket.DefaultClientWebSocketSession) r8
            java.lang.Object r9 = r0.L$1
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            java.lang.Object r10 = r0.L$0
            io.ktor.client.statement.HttpStatement r10 = (io.ktor.client.statement.HttpStatement) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0071 }
            goto L_0x010b
        L_0x0071:
            r11 = move-exception
            r7 = r11
            r11 = r8
            r8 = r7
            goto L_0x0131
        L_0x0077:
            java.lang.Object r8 = r0.L$2
            r9 = r8
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            java.lang.Object r8 = r0.L$1
            r10 = r8
            io.ktor.client.statement.HttpStatement r10 = (io.ktor.client.statement.HttpStatement) r10
            java.lang.Object r8 = r0.L$0
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0089 }
            goto L_0x00f3
        L_0x0089:
            r8 = move-exception
            goto L_0x0150
        L_0x008c:
            java.lang.Object r8 = r0.L$1
            io.ktor.client.statement.HttpStatement r8 = (io.ktor.client.statement.HttpStatement) r8
            java.lang.Object r9 = r0.L$0
            r10 = r9
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CancellationException -> 0x0161 }
            goto L_0x00c5
        L_0x0099:
            kotlin.ResultKt.throwOnFailure(r11)
            io.ktor.client.plugins.websocket.WebSockets$Plugin r11 = io.ktor.client.plugins.websocket.WebSockets.Plugin
            io.ktor.client.plugins.HttpClientPlugin r11 = (io.ktor.client.plugins.HttpClientPlugin) r11
            io.ktor.client.plugins.HttpClientPluginKt.plugin(r8, r11)
            io.ktor.client.request.HttpRequestBuilder r11 = new io.ktor.client.request.HttpRequestBuilder
            r11.<init>()
            io.ktor.client.plugins.websocket.BuildersKt$webSocket$session$1$1 r2 = io.ktor.client.plugins.websocket.BuildersKt$webSocket$session$1$1.INSTANCE
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r11.url(r2)
            r9.invoke(r11)
            io.ktor.client.statement.HttpStatement r9 = new io.ktor.client.statement.HttpStatement
            r9.<init>(r11, r8)
            r0.L$0 = r10     // Catch:{ CancellationException -> 0x0161 }
            r0.L$1 = r9     // Catch:{ CancellationException -> 0x0161 }
            r0.label = r3     // Catch:{ CancellationException -> 0x0161 }
            java.lang.Object r11 = r9.executeUnsafe(r0)     // Catch:{ CancellationException -> 0x0161 }
            if (r11 != r1) goto L_0x00c4
            return r1
        L_0x00c4:
            r8 = r9
        L_0x00c5:
            r9 = r11
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9     // Catch:{ CancellationException -> 0x0161 }
            io.ktor.client.call.HttpClientCall r11 = r9.getCall()     // Catch:{ all -> 0x014c }
            java.lang.Class<io.ktor.client.plugins.websocket.DefaultClientWebSocketSession> r2 = io.ktor.client.plugins.websocket.DefaultClientWebSocketSession.class
            kotlin.reflect.KType r2 = kotlin.jvm.internal.Reflection.typeOf(r2)     // Catch:{ all -> 0x014c }
            java.lang.reflect.Type r5 = kotlin.reflect.TypesJVMKt.getJavaType(r2)     // Catch:{ all -> 0x014c }
            java.lang.Class<io.ktor.client.plugins.websocket.DefaultClientWebSocketSession> r6 = io.ktor.client.plugins.websocket.DefaultClientWebSocketSession.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)     // Catch:{ all -> 0x014c }
            io.ktor.util.reflect.TypeInfo r2 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r5, r6, r2)     // Catch:{ all -> 0x014c }
            r0.L$0 = r10     // Catch:{ all -> 0x014c }
            r0.L$1 = r8     // Catch:{ all -> 0x014c }
            r0.L$2 = r9     // Catch:{ all -> 0x014c }
            r5 = 2
            r0.label = r5     // Catch:{ all -> 0x014c }
            java.lang.Object r11 = r11.body(r2, r0)     // Catch:{ all -> 0x014c }
            if (r11 != r1) goto L_0x00f0
            return r1
        L_0x00f0:
            r7 = r10
            r10 = r8
            r8 = r7
        L_0x00f3:
            if (r11 == 0) goto L_0x0144
            io.ktor.client.plugins.websocket.DefaultClientWebSocketSession r11 = (io.ktor.client.plugins.websocket.DefaultClientWebSocketSession) r11     // Catch:{ all -> 0x0089 }
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch:{ all -> 0x0089 }
            r0.L$0 = r10     // Catch:{ all -> 0x0130 }
            r0.L$1 = r9     // Catch:{ all -> 0x0130 }
            r0.L$2 = r11     // Catch:{ all -> 0x0130 }
            r2 = 3
            r0.label = r2     // Catch:{ all -> 0x0130 }
            java.lang.Object r8 = r8.invoke(r11, r0)     // Catch:{ all -> 0x0130 }
            if (r8 != r1) goto L_0x010a
            return r1
        L_0x010a:
            r8 = r11
        L_0x010b:
            io.ktor.websocket.WebSocketSession r8 = (io.ktor.websocket.WebSocketSession) r8     // Catch:{ all -> 0x0089 }
            r0.L$0 = r10     // Catch:{ all -> 0x0089 }
            r0.L$1 = r9     // Catch:{ all -> 0x0089 }
            r0.L$2 = r4     // Catch:{ all -> 0x0089 }
            r11 = 4
            r0.label = r11     // Catch:{ all -> 0x0089 }
            java.lang.Object r8 = io.ktor.websocket.WebSocketSessionKt.close$default(r8, r4, r0, r3, r4)     // Catch:{ all -> 0x0089 }
            if (r8 != r1) goto L_0x011d
            return r1
        L_0x011d:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0089 }
            r0.L$0 = r8     // Catch:{ CancellationException -> 0x0161 }
            r0.L$1 = r4     // Catch:{ CancellationException -> 0x0161 }
            r8 = 6
            r0.label = r8     // Catch:{ CancellationException -> 0x0161 }
            java.lang.Object r8 = r10.cleanup(r9, r0)     // Catch:{ CancellationException -> 0x0161 }
            if (r8 != r1) goto L_0x012d
            return r1
        L_0x012d:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x0130:
            r8 = move-exception
        L_0x0131:
            io.ktor.websocket.WebSocketSession r11 = (io.ktor.websocket.WebSocketSession) r11     // Catch:{ all -> 0x0089 }
            r0.L$0 = r10     // Catch:{ all -> 0x0089 }
            r0.L$1 = r9     // Catch:{ all -> 0x0089 }
            r0.L$2 = r8     // Catch:{ all -> 0x0089 }
            r2 = 5
            r0.label = r2     // Catch:{ all -> 0x0089 }
            java.lang.Object r11 = io.ktor.websocket.WebSocketSessionKt.close$default(r11, r4, r0, r3, r4)     // Catch:{ all -> 0x0089 }
            if (r11 != r1) goto L_0x0143
            return r1
        L_0x0143:
            throw r8     // Catch:{ all -> 0x0089 }
        L_0x0144:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException     // Catch:{ all -> 0x0089 }
            java.lang.String r11 = "null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession"
            r8.<init>(r11)     // Catch:{ all -> 0x0089 }
            throw r8     // Catch:{ all -> 0x0089 }
        L_0x014c:
            r10 = move-exception
            r7 = r10
            r10 = r8
            r8 = r7
        L_0x0150:
            r0.L$0 = r8     // Catch:{ CancellationException -> 0x0161 }
            r0.L$1 = r4     // Catch:{ CancellationException -> 0x0161 }
            r0.L$2 = r4     // Catch:{ CancellationException -> 0x0161 }
            r11 = 7
            r0.label = r11     // Catch:{ CancellationException -> 0x0161 }
            java.lang.Object r9 = r10.cleanup(r9, r0)     // Catch:{ CancellationException -> 0x0161 }
            if (r9 != r1) goto L_0x0160
            return r1
        L_0x0160:
            throw r8     // Catch:{ CancellationException -> 0x0161 }
        L_0x0161:
            r8 = move-exception
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            java.lang.Throwable r8 = io.ktor.client.utils.ExceptionUtilsJvmKt.unwrapCancellationException(r8)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.websocket.BuildersKt.webSocket(io.ktor.client.HttpClient, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object webSocket$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        return webSocket(httpClient, (i & 1) != 0 ? HttpMethod.Companion.getGet() : httpMethod, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? (Function1) BuildersKt$webSocket$4.INSTANCE : function1, function2, continuation);
    }

    public static final Object webSocket(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket(httpClient, new BuildersKt$webSocket$5(httpMethod, str, num, str2, function1), function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }

    public static /* synthetic */ Object webSocket$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$webSocket$7.INSTANCE;
        }
        return webSocket(httpClient, str, function1, function2, continuation);
    }

    public static final Object webSocket(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket(httpClient, HttpMethod.Companion.getGet(), (String) null, (Integer) null, (String) null, new BuildersKt$webSocket$8(str, function1), function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }

    public static /* synthetic */ Object ws$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        return ws(httpClient, (i & 1) != 0 ? HttpMethod.Companion.getGet() : httpMethod, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? (Function1) BuildersKt$ws$2.INSTANCE : function1, function2, continuation);
    }

    public static final Object ws(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket(httpClient, httpMethod, str, num, str2, function1, function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }

    public static final Object ws(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket(httpClient, function1, function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }

    public static /* synthetic */ Object ws$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$ws$5.INSTANCE;
        }
        return ws(httpClient, str, function1, function2, continuation);
    }

    public static final Object ws(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket(httpClient, str, function1, function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }

    public static final Object wss(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket(httpClient, new BuildersKt$wss$2(function1), function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }

    public static /* synthetic */ Object wss$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) BuildersKt$wss$4.INSTANCE;
        }
        return wss(httpClient, str, function1, function2, continuation);
    }

    public static final Object wss(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object wss = wss(httpClient, new BuildersKt$wss$5(str, function1), function2, continuation);
        return wss == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? wss : Unit.INSTANCE;
    }

    public static /* synthetic */ Object wss$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        return wss(httpClient, (i & 1) != 0 ? HttpMethod.Companion.getGet() : httpMethod, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? (Function1) BuildersKt$wss$7.INSTANCE : function1, function2, continuation);
    }

    public static final Object wss(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Function1<? super HttpRequestBuilder, Unit> function12 = function1;
        Object webSocket = webSocket(httpClient, httpMethod, str, num, str2, new BuildersKt$wss$8(num, function1), function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }
}
