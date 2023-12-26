package io.ktor.client.statement;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u000b\u001a\u0002H\f\"\u0006\b\u0000\u0010\f\u0018\u0001HHø\u0001\u0000¢\u0006\u0002\u0010\rJT\u0010\u000b\u001a\u0002H\u000e\"\u0006\b\u0000\u0010\f\u0018\u0001\"\u0004\b\u0001\u0010\u000e23\b\u0004\u0010\u000f\u001a-\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000e0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010HHø\u0001\u0000¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0011\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\rJJ\u0010\u0018\u001a\u0002H\f\"\u0004\b\u0000\u0010\f21\u0010\u000f\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0011\u0010\u001a\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0015\u0010\u001d\u001a\u00020\u0017*\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u00020\u00058\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lio/ktor/client/statement/HttpStatement;", "", "builder", "Lio/ktor/client/request/HttpRequestBuilder;", "client", "Lio/ktor/client/HttpClient;", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/client/HttpClient;)V", "getClient$annotations", "()V", "getClient", "()Lio/ktor/client/HttpClient;", "body", "T", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "R", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "response", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkCapabilities", "", "execute", "Lio/ktor/client/statement/HttpResponse;", "executeUnsafe", "toString", "", "cleanup", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpStatement.kt */
public final class HttpStatement {
    private final HttpRequestBuilder builder;
    private final HttpClient client;

    public static /* synthetic */ void getClient$annotations() {
    }

    public HttpStatement(HttpRequestBuilder httpRequestBuilder, HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "builder");
        Intrinsics.checkNotNullParameter(httpClient, "client");
        this.builder = httpRequestBuilder;
        this.client = httpClient;
        checkCapabilities();
    }

    public final HttpClient getClient() {
        return this.client;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0083 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0093 A[Catch:{ CancellationException -> 0x00a5 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0094 A[Catch:{ CancellationException -> 0x00a5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.lang.Object execute(kotlin.jvm.functions.Function2<? super io.ktor.client.statement.HttpResponse, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r10, kotlin.coroutines.Continuation<? super T> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof io.ktor.client.statement.HttpStatement$execute$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            io.ktor.client.statement.HttpStatement$execute$1 r0 = (io.ktor.client.statement.HttpStatement$execute$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            io.ktor.client.statement.HttpStatement$execute$1 r0 = new io.ktor.client.statement.HttpStatement$execute$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L_0x0064
            if (r2 == r7) goto L_0x0058
            if (r2 == r6) goto L_0x0047
            if (r2 == r5) goto L_0x0041
            if (r2 == r4) goto L_0x0038
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0038:
            java.lang.Object r10 = r0.L$0
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CancellationException -> 0x00a5 }
            goto L_0x00a4
        L_0x0041:
            java.lang.Object r10 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CancellationException -> 0x00a5 }
            goto L_0x0095
        L_0x0047:
            java.lang.Object r10 = r0.L$1
            io.ktor.client.statement.HttpResponse r10 = (io.ktor.client.statement.HttpResponse) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.client.statement.HttpStatement r2 = (io.ktor.client.statement.HttpStatement) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0053 }
            goto L_0x0087
        L_0x0053:
            r11 = move-exception
            r8 = r11
            r11 = r10
            r10 = r8
            goto L_0x0097
        L_0x0058:
            java.lang.Object r10 = r0.L$1
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            java.lang.Object r2 = r0.L$0
            io.ktor.client.statement.HttpStatement r2 = (io.ktor.client.statement.HttpStatement) r2
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ CancellationException -> 0x00a5 }
            goto L_0x0075
        L_0x0064:
            kotlin.ResultKt.throwOnFailure(r11)
            r0.L$0 = r9     // Catch:{ CancellationException -> 0x00a5 }
            r0.L$1 = r10     // Catch:{ CancellationException -> 0x00a5 }
            r0.label = r7     // Catch:{ CancellationException -> 0x00a5 }
            java.lang.Object r11 = r9.executeUnsafe(r0)     // Catch:{ CancellationException -> 0x00a5 }
            if (r11 != r1) goto L_0x0074
            return r1
        L_0x0074:
            r2 = r9
        L_0x0075:
            io.ktor.client.statement.HttpResponse r11 = (io.ktor.client.statement.HttpResponse) r11     // Catch:{ CancellationException -> 0x00a5 }
            r0.L$0 = r2     // Catch:{ all -> 0x0096 }
            r0.L$1 = r11     // Catch:{ all -> 0x0096 }
            r0.label = r6     // Catch:{ all -> 0x0096 }
            java.lang.Object r10 = r10.invoke(r11, r0)     // Catch:{ all -> 0x0096 }
            if (r10 != r1) goto L_0x0084
            return r1
        L_0x0084:
            r8 = r11
            r11 = r10
            r10 = r8
        L_0x0087:
            r0.L$0 = r11     // Catch:{ CancellationException -> 0x00a5 }
            r0.L$1 = r3     // Catch:{ CancellationException -> 0x00a5 }
            r0.label = r5     // Catch:{ CancellationException -> 0x00a5 }
            java.lang.Object r10 = r2.cleanup(r10, r0)     // Catch:{ CancellationException -> 0x00a5 }
            if (r10 != r1) goto L_0x0094
            return r1
        L_0x0094:
            r10 = r11
        L_0x0095:
            return r10
        L_0x0096:
            r10 = move-exception
        L_0x0097:
            r0.L$0 = r10     // Catch:{ CancellationException -> 0x00a5 }
            r0.L$1 = r3     // Catch:{ CancellationException -> 0x00a5 }
            r0.label = r4     // Catch:{ CancellationException -> 0x00a5 }
            java.lang.Object r11 = r2.cleanup(r11, r0)     // Catch:{ CancellationException -> 0x00a5 }
            if (r11 != r1) goto L_0x00a4
            return r1
        L_0x00a4:
            throw r10     // Catch:{ CancellationException -> 0x00a5 }
        L_0x00a5:
            r10 = move-exception
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            java.lang.Throwable r10 = io.ktor.client.utils.ExceptionUtilsJvmKt.unwrapCancellationException(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.execute(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object execute(Continuation<? super HttpResponse> continuation) {
        return execute(new HttpStatement$execute$4((Continuation<? super HttpStatement$execute$4>) null), continuation);
    }

    public final /* synthetic */ <T> Object body(Continuation<? super T> continuation) {
        HttpResponse httpResponse;
        try {
            InlineMarker.mark(3);
            InlineMarker.mark(0);
            Object executeUnsafe = executeUnsafe((Continuation<? super HttpResponse>) null);
            InlineMarker.mark(1);
            httpResponse = (HttpResponse) executeUnsafe;
            InlineMarker.mark(3);
            HttpClientCall call = httpResponse.getCall();
            Intrinsics.reifiedOperationMarker(6, "T");
            Type javaType = TypesJVMKt.getJavaType((KType) null);
            Intrinsics.reifiedOperationMarker(4, "T");
            TypeInfo typeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), (KType) null);
            InlineMarker.mark(0);
            Object body = call.body(typeInfoImpl, (Continuation<Object>) null);
            InlineMarker.mark(1);
            Intrinsics.reifiedOperationMarker(1, "T");
            Object obj = body;
            InlineMarker.finallyStart(1);
            HttpResponseKt.complete(httpResponse);
            InlineMarker.finallyEnd(1);
            return obj;
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            HttpResponseKt.complete(httpResponse);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    public final /* synthetic */ <T, R> Object body(Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        HttpResponse httpResponse;
        try {
            InlineMarker.mark(3);
            InlineMarker.mark(0);
            Object executeUnsafe = executeUnsafe((Continuation<? super HttpResponse>) null);
            InlineMarker.mark(1);
            httpResponse = (HttpResponse) executeUnsafe;
            InlineMarker.mark(3);
            HttpClientCall call = httpResponse.getCall();
            Intrinsics.reifiedOperationMarker(6, "T");
            Type javaType = TypesJVMKt.getJavaType((KType) null);
            Intrinsics.reifiedOperationMarker(4, "T");
            TypeInfo typeInfoImpl = TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), (KType) null);
            InlineMarker.mark(0);
            Object body = call.body(typeInfoImpl, (Continuation<Object>) null);
            InlineMarker.mark(1);
            Intrinsics.reifiedOperationMarker(1, "T");
            InlineMarker.mark(3);
            Object invoke = function2.invoke(body, (Object) null);
            InlineMarker.finallyStart(1);
            InlineMarker.mark(3);
            InlineMarker.mark(0);
            cleanup(httpResponse, (Continuation<? super Unit>) null);
            InlineMarker.mark(1);
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            InlineMarker.mark(3);
            InlineMarker.mark(0);
            cleanup(httpResponse, (Continuation<? super Unit>) null);
            InlineMarker.mark(1);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object executeUnsafe(kotlin.coroutines.Continuation<? super io.ktor.client.statement.HttpResponse> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof io.ktor.client.statement.HttpStatement$executeUnsafe$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            io.ktor.client.statement.HttpStatement$executeUnsafe$1 r0 = (io.ktor.client.statement.HttpStatement$executeUnsafe$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            io.ktor.client.statement.HttpStatement$executeUnsafe$1 r0 = new io.ktor.client.statement.HttpStatement$executeUnsafe$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ CancellationException -> 0x0052 }
            goto L_0x004b
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            io.ktor.client.request.HttpRequestBuilder r5 = new io.ktor.client.request.HttpRequestBuilder     // Catch:{ CancellationException -> 0x0052 }
            r5.<init>()     // Catch:{ CancellationException -> 0x0052 }
            io.ktor.client.request.HttpRequestBuilder r2 = r4.builder     // Catch:{ CancellationException -> 0x0052 }
            io.ktor.client.request.HttpRequestBuilder r5 = r5.takeFromWithExecutionContext(r2)     // Catch:{ CancellationException -> 0x0052 }
            io.ktor.client.HttpClient r2 = r4.client     // Catch:{ CancellationException -> 0x0052 }
            r0.label = r3     // Catch:{ CancellationException -> 0x0052 }
            java.lang.Object r5 = r2.execute$ktor_client_core(r5, r0)     // Catch:{ CancellationException -> 0x0052 }
            if (r5 != r1) goto L_0x004b
            return r1
        L_0x004b:
            io.ktor.client.call.HttpClientCall r5 = (io.ktor.client.call.HttpClientCall) r5     // Catch:{ CancellationException -> 0x0052 }
            io.ktor.client.statement.HttpResponse r5 = r5.getResponse()     // Catch:{ CancellationException -> 0x0052 }
            return r5
        L_0x0052:
            r5 = move-exception
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            java.lang.Throwable r5 = io.ktor.client.utils.ExceptionUtilsJvmKt.unwrapCancellationException(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.executeUnsafe(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object cleanup(io.ktor.client.statement.HttpResponse r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.statement.HttpStatement$cleanup$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.ktor.client.statement.HttpStatement$cleanup$1 r0 = (io.ktor.client.statement.HttpStatement$cleanup$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.ktor.client.statement.HttpStatement$cleanup$1 r0 = new io.ktor.client.statement.HttpStatement$cleanup$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.CompletableJob r5 = (kotlinx.coroutines.CompletableJob) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005f
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlin.coroutines.CoroutineContext r6 = r5.getCoroutineContext()
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Key r2 = (kotlin.coroutines.CoroutineContext.Key) r2
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            kotlinx.coroutines.CompletableJob r6 = (kotlinx.coroutines.CompletableJob) r6
            r6.complete()
            io.ktor.utils.io.ByteReadChannel r5 = r5.getContent()     // Catch:{ all -> 0x0054 }
            io.ktor.utils.io.ByteReadChannelKt.cancel(r5)     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r5 = r6.join(r0)
            if (r5 != r1) goto L_0x005f
            return r1
        L_0x005f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.statement.HttpStatement.cleanup(io.ktor.client.statement.HttpResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void checkCapabilities() {
        Set keySet;
        Map map = (Map) this.builder.getAttributes().getOrNull(HttpClientEngineCapabilityKt.getENGINE_CAPABILITIES_KEY());
        if (map != null && (keySet = map.keySet()) != null) {
            Collection arrayList = new ArrayList();
            for (Object next : keySet) {
                if (next instanceof HttpClientPlugin) {
                    arrayList.add(next);
                }
            }
            for (HttpClientPlugin httpClientPlugin : (List) arrayList) {
                if (HttpClientPluginKt.pluginOrNull(this.client, httpClientPlugin) == null) {
                    throw new IllegalArgumentException(("Consider installing " + httpClientPlugin + " plugin because the request requires it to be installed").toString());
                }
            }
        }
    }

    public String toString() {
        return "HttpStatement[" + this.builder.getUrl().buildString() + ']';
    }
}
