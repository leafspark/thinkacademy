package io.ktor.client.plugins.websocket;

import io.ktor.client.statement.HttpStatement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2", f = "builders.kt", i = {0, 1, 1, 2, 2}, l = {239, 242, 49, 248, 248}, m = "invokeSuspend", n = {"this_$iv", "this_$iv", "response$iv", "this_$iv", "response$iv"}, s = {"L$0", "L$0", "L$2", "L$0", "L$1"})
/* compiled from: builders.kt */
final class BuildersKt$webSocketSession$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CompletableDeferred<DefaultClientWebSocketSession> $sessionDeferred;
    final /* synthetic */ HttpStatement $statement;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BuildersKt$webSocketSession$2(HttpStatement httpStatement, CompletableDeferred<DefaultClientWebSocketSession> completableDeferred, Continuation<? super BuildersKt$webSocketSession$2> continuation) {
        super(2, continuation);
        this.$statement = httpStatement;
        this.$sessionDeferred = completableDeferred;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new BuildersKt$webSocketSession$2(this.$statement, this.$sessionDeferred, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0062, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0108, code lost:
        throw io.ktor.client.utils.ExceptionUtilsJvmKt.unwrapCancellationException(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0109, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x010a, code lost:
        r14.$sessionDeferred.completeExceptionally(r15);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:10:0x0024, B:29:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ab A[SYNTHETIC, Splitter:B:43:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e4 A[SYNTHETIC, Splitter:B:54:0x00e4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r1 == 0) goto L_0x0065
            if (r1 == r6) goto L_0x0056
            if (r1 == r5) goto L_0x0042
            if (r1 == r4) goto L_0x0032
            if (r1 == r3) goto L_0x0029
            if (r1 == r2) goto L_0x0020
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0020:
            java.lang.Object r0 = r14.L$0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ CancellationException -> 0x0062 }
            goto L_0x0101
        L_0x0029:
            java.lang.Object r0 = r14.L$0
            kotlin.Unit r0 = (kotlin.Unit) r0
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ CancellationException -> 0x0062 }
            goto L_0x010f
        L_0x0032:
            java.lang.Object r1 = r14.L$1
            io.ktor.client.statement.HttpResponse r1 = (io.ktor.client.statement.HttpResponse) r1
            java.lang.Object r4 = r14.L$0
            io.ktor.client.statement.HttpStatement r4 = (io.ktor.client.statement.HttpStatement) r4
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x003f }
            goto L_0x00d5
        L_0x003f:
            r15 = move-exception
            goto L_0x00f1
        L_0x0042:
            java.lang.Object r1 = r14.L$2
            io.ktor.client.statement.HttpResponse r1 = (io.ktor.client.statement.HttpResponse) r1
            java.lang.Object r5 = r14.L$1
            kotlinx.coroutines.CompletableDeferred r5 = (kotlinx.coroutines.CompletableDeferred) r5
            java.lang.Object r8 = r14.L$0
            io.ktor.client.statement.HttpStatement r8 = (io.ktor.client.statement.HttpStatement) r8
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x0052 }
            goto L_0x00a9
        L_0x0052:
            r15 = move-exception
            r4 = r8
            goto L_0x00f1
        L_0x0056:
            java.lang.Object r1 = r14.L$1
            kotlinx.coroutines.CompletableDeferred r1 = (kotlinx.coroutines.CompletableDeferred) r1
            java.lang.Object r8 = r14.L$0
            io.ktor.client.statement.HttpStatement r8 = (io.ktor.client.statement.HttpStatement) r8
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ CancellationException -> 0x0062 }
            goto L_0x007c
        L_0x0062:
            r15 = move-exception
            goto L_0x0102
        L_0x0065:
            kotlin.ResultKt.throwOnFailure(r15)
            io.ktor.client.statement.HttpStatement r15 = r14.$statement     // Catch:{ all -> 0x0109 }
            kotlinx.coroutines.CompletableDeferred<io.ktor.client.plugins.websocket.DefaultClientWebSocketSession> r1 = r14.$sessionDeferred     // Catch:{ all -> 0x0109 }
            r14.L$0 = r15     // Catch:{ CancellationException -> 0x0062 }
            r14.L$1 = r1     // Catch:{ CancellationException -> 0x0062 }
            r14.label = r6     // Catch:{ CancellationException -> 0x0062 }
            java.lang.Object r8 = r15.executeUnsafe(r14)     // Catch:{ CancellationException -> 0x0062 }
            if (r8 != r0) goto L_0x0079
            return r0
        L_0x0079:
            r13 = r8
            r8 = r15
            r15 = r13
        L_0x007c:
            io.ktor.client.statement.HttpResponse r15 = (io.ktor.client.statement.HttpResponse) r15     // Catch:{ CancellationException -> 0x0062 }
            io.ktor.client.call.HttpClientCall r9 = r15.getCall()     // Catch:{ all -> 0x00ec }
            java.lang.Class<io.ktor.client.plugins.websocket.DefaultClientWebSocketSession> r10 = io.ktor.client.plugins.websocket.DefaultClientWebSocketSession.class
            kotlin.reflect.KType r10 = kotlin.jvm.internal.Reflection.typeOf(r10)     // Catch:{ all -> 0x00ec }
            java.lang.reflect.Type r11 = kotlin.reflect.TypesJVMKt.getJavaType(r10)     // Catch:{ all -> 0x00ec }
            java.lang.Class<io.ktor.client.plugins.websocket.DefaultClientWebSocketSession> r12 = io.ktor.client.plugins.websocket.DefaultClientWebSocketSession.class
            kotlin.reflect.KClass r12 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r12)     // Catch:{ all -> 0x00ec }
            io.ktor.util.reflect.TypeInfo r10 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r11, r12, r10)     // Catch:{ all -> 0x00ec }
            r14.L$0 = r8     // Catch:{ all -> 0x00ec }
            r14.L$1 = r1     // Catch:{ all -> 0x00ec }
            r14.L$2 = r15     // Catch:{ all -> 0x00ec }
            r14.label = r5     // Catch:{ all -> 0x00ec }
            java.lang.Object r5 = r9.body(r10, r14)     // Catch:{ all -> 0x00ec }
            if (r5 != r0) goto L_0x00a5
            return r0
        L_0x00a5:
            r13 = r1
            r1 = r15
            r15 = r5
            r5 = r13
        L_0x00a9:
            if (r15 == 0) goto L_0x00e4
            io.ktor.client.plugins.websocket.DefaultClientWebSocketSession r15 = (io.ktor.client.plugins.websocket.DefaultClientWebSocketSession) r15     // Catch:{ all -> 0x0052 }
            r9 = r14
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch:{ all -> 0x0052 }
            kotlinx.coroutines.CompletableDeferred r6 = kotlinx.coroutines.CompletableDeferredKt.CompletableDeferred$default(r7, r6, r7)     // Catch:{ all -> 0x0052 }
            r5.complete(r15)     // Catch:{ all -> 0x0052 }
            kotlinx.coroutines.channels.SendChannel r15 = r15.getOutgoing()     // Catch:{ all -> 0x0052 }
            io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2$1$1 r5 = new io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2$1$1     // Catch:{ all -> 0x0052 }
            r5.<init>(r6)     // Catch:{ all -> 0x0052 }
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5     // Catch:{ all -> 0x0052 }
            r15.invokeOnClose(r5)     // Catch:{ all -> 0x0052 }
            r14.L$0 = r8     // Catch:{ all -> 0x0052 }
            r14.L$1 = r1     // Catch:{ all -> 0x0052 }
            r14.L$2 = r7     // Catch:{ all -> 0x0052 }
            r14.label = r4     // Catch:{ all -> 0x0052 }
            java.lang.Object r15 = r6.await(r14)     // Catch:{ all -> 0x0052 }
            if (r15 != r0) goto L_0x00d4
            return r0
        L_0x00d4:
            r4 = r8
        L_0x00d5:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003f }
            r14.L$0 = r15     // Catch:{ CancellationException -> 0x0062 }
            r14.L$1 = r7     // Catch:{ CancellationException -> 0x0062 }
            r14.label = r3     // Catch:{ CancellationException -> 0x0062 }
            java.lang.Object r15 = r4.cleanup(r1, r14)     // Catch:{ CancellationException -> 0x0062 }
            if (r15 != r0) goto L_0x010f
            return r0
        L_0x00e4:
            java.lang.NullPointerException r15 = new java.lang.NullPointerException     // Catch:{ all -> 0x0052 }
            java.lang.String r3 = "null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession"
            r15.<init>(r3)     // Catch:{ all -> 0x0052 }
            throw r15     // Catch:{ all -> 0x0052 }
        L_0x00ec:
            r1 = move-exception
            r4 = r8
            r13 = r1
            r1 = r15
            r15 = r13
        L_0x00f1:
            r14.L$0 = r15     // Catch:{ CancellationException -> 0x0062 }
            r14.L$1 = r7     // Catch:{ CancellationException -> 0x0062 }
            r14.L$2 = r7     // Catch:{ CancellationException -> 0x0062 }
            r14.label = r2     // Catch:{ CancellationException -> 0x0062 }
            java.lang.Object r1 = r4.cleanup(r1, r14)     // Catch:{ CancellationException -> 0x0062 }
            if (r1 != r0) goto L_0x0100
            return r0
        L_0x0100:
            r0 = r15
        L_0x0101:
            throw r0     // Catch:{ CancellationException -> 0x0062 }
        L_0x0102:
            java.lang.Throwable r15 = (java.lang.Throwable) r15     // Catch:{ all -> 0x0109 }
            java.lang.Throwable r15 = io.ktor.client.utils.ExceptionUtilsJvmKt.unwrapCancellationException(r15)     // Catch:{ all -> 0x0109 }
            throw r15     // Catch:{ all -> 0x0109 }
        L_0x0109:
            r15 = move-exception
            kotlinx.coroutines.CompletableDeferred<io.ktor.client.plugins.websocket.DefaultClientWebSocketSession> r0 = r14.$sessionDeferred
            r0.completeExceptionally(r15)
        L_0x010f:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
