package io.ktor.client.plugins;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponseContainer;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0005\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponseContainer;", "Lio/ktor/client/call/HttpClientCall;", "<name for destructuring parameter 0>"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2", f = "DefaultTransform.kt", i = {5, 5, 5}, l = {62, 65, 65, 69, 69, 72, 79, 104, 108}, m = "invokeSuspend", n = {"$this$intercept", "info", "contentLength"}, s = {"L$0", "L$1", "J$0"})
/* compiled from: DefaultTransform.kt */
final class DefaultTransformKt$defaultTransformers$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponseContainer, HttpClientCall>, HttpResponseContainer, Continuation<? super Unit>, Object> {
    long J$0;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    DefaultTransformKt$defaultTransformers$2(Continuation<? super DefaultTransformKt$defaultTransformers$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(PipelineContext<HttpResponseContainer, HttpClientCall> pipelineContext, HttpResponseContainer httpResponseContainer, Continuation<? super Unit> continuation) {
        DefaultTransformKt$defaultTransformers$2 defaultTransformKt$defaultTransformers$2 = new DefaultTransformKt$defaultTransformers$2(continuation);
        defaultTransformKt$defaultTransformers$2.L$0 = pipelineContext;
        defaultTransformKt$defaultTransformers$2.L$1 = httpResponseContainer;
        return defaultTransformKt$defaultTransformers$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v21, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: io.ktor.util.pipeline.PipelineContext} */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00e0, code lost:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0101, code lost:
        if (r3.proceedWith(new io.ktor.client.statement.HttpResponseContainer(r8, kotlin.coroutines.jvm.internal.Boxing.boxInt(java.lang.Integer.parseInt(io.ktor.utils.io.core.Input.readText$default((io.ktor.utils.io.core.Input) r2, 0, 0, 3, (java.lang.Object) null)))), (kotlin.coroutines.Continuation) r0) != r1) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0103, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x013a, code lost:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x014d, code lost:
        if (r3.proceedWith(new io.ktor.client.statement.HttpResponseContainer(r8, r2), (kotlin.coroutines.Continuation) r0) != r1) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x014f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0171, code lost:
        r2 = (io.ktor.utils.io.core.ByteReadPacket) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0175, code lost:
        if (r11 >= io.ktor.client.plugins.HttpTimeout.INFINITE_TIMEOUT_MS) goto L_0x01ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x017d, code lost:
        if (r2.getRemaining() != r11) goto L_0x0181;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x017f, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0181, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0182, code lost:
        if (r3 == false) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01ab, code lost:
        throw new java.lang.IllegalStateException(("Expected " + r11 + ", actual " + r2.getRemaining()).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01ac, code lost:
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01c3, code lost:
        if (r10.proceedWith(new io.ktor.client.statement.HttpResponseContainer(r8, io.ktor.utils.io.core.StringsKt.readBytes$default(r2, 0, 1, (java.lang.Object) null)), (kotlin.coroutines.Continuation) r0) != r1) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01c5, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x024a, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            r21 = this;
            r0 = r21
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r5 = 1
            r6 = 0
            r7 = 0
            switch(r2) {
                case 0: goto L_0x0053;
                case 1: goto L_0x004e;
                case 2: goto L_0x003e;
                case 3: goto L_0x004e;
                case 4: goto L_0x002e;
                case 5: goto L_0x004e;
                case 6: goto L_0x001b;
                case 7: goto L_0x004e;
                case 8: goto L_0x004e;
                case 9: goto L_0x004e;
                default: goto L_0x0013;
            }
        L_0x0013:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x001b:
            long r8 = r0.J$0
            java.lang.Object r2 = r0.L$1
            io.ktor.util.reflect.TypeInfo r2 = (io.ktor.util.reflect.TypeInfo) r2
            java.lang.Object r10 = r0.L$0
            io.ktor.util.pipeline.PipelineContext r10 = (io.ktor.util.pipeline.PipelineContext) r10
            kotlin.ResultKt.throwOnFailure(r22)
            r11 = r8
            r8 = r2
            r2 = r22
            goto L_0x0171
        L_0x002e:
            java.lang.Object r2 = r0.L$1
            io.ktor.util.reflect.TypeInfo r2 = (io.ktor.util.reflect.TypeInfo) r2
            java.lang.Object r3 = r0.L$0
            io.ktor.util.pipeline.PipelineContext r3 = (io.ktor.util.pipeline.PipelineContext) r3
            kotlin.ResultKt.throwOnFailure(r22)
            r8 = r2
            r2 = r22
            goto L_0x013a
        L_0x003e:
            java.lang.Object r2 = r0.L$1
            io.ktor.util.reflect.TypeInfo r2 = (io.ktor.util.reflect.TypeInfo) r2
            java.lang.Object r3 = r0.L$0
            io.ktor.util.pipeline.PipelineContext r3 = (io.ktor.util.pipeline.PipelineContext) r3
            kotlin.ResultKt.throwOnFailure(r22)
            r8 = r2
            r2 = r22
            goto L_0x00e0
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r22)
            goto L_0x0248
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r22)
            java.lang.Object r2 = r0.L$0
            r10 = r2
            io.ktor.util.pipeline.PipelineContext r10 = (io.ktor.util.pipeline.PipelineContext) r10
            java.lang.Object r2 = r0.L$1
            io.ktor.client.statement.HttpResponseContainer r2 = (io.ktor.client.statement.HttpResponseContainer) r2
            io.ktor.util.reflect.TypeInfo r8 = r2.component1()
            java.lang.Object r2 = r2.component2()
            boolean r9 = r2 instanceof io.ktor.utils.io.ByteReadChannel
            if (r9 != 0) goto L_0x006e
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x006e:
            java.lang.Object r9 = r10.getContext()
            io.ktor.client.call.HttpClientCall r9 = (io.ktor.client.call.HttpClientCall) r9
            io.ktor.client.statement.HttpResponse r9 = r9.getResponse()
            io.ktor.http.Headers r11 = r9.getHeaders()
            io.ktor.http.HttpHeaders r12 = io.ktor.http.HttpHeaders.INSTANCE
            java.lang.String r12 = r12.getContentLength()
            java.lang.String r11 = r11.get(r12)
            if (r11 == 0) goto L_0x008d
            long r11 = java.lang.Long.parseLong(r11)
            goto L_0x008e
        L_0x008d:
            r11 = r3
        L_0x008e:
            kotlin.reflect.KClass r13 = r8.getType()
            java.lang.Class<kotlin.Unit> r14 = kotlin.Unit.class
            kotlin.reflect.KClass r14 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r14)
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r14)
            if (r14 == 0) goto L_0x00b8
            io.ktor.utils.io.ByteReadChannel r2 = (io.ktor.utils.io.ByteReadChannel) r2
            io.ktor.utils.io.ByteReadChannelKt.cancel(r2)
            io.ktor.client.statement.HttpResponseContainer r2 = new io.ktor.client.statement.HttpResponseContainer
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r2.<init>(r8, r3)
            r3 = r0
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r2 = r10.proceedWith(r2, r3)
            if (r2 != r1) goto L_0x0248
            return r1
        L_0x00b8:
            java.lang.Class r14 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r14 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r14)
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r14)
            if (r14 == 0) goto L_0x0104
            r15 = r2
            io.ktor.utils.io.ByteReadChannel r15 = (io.ktor.utils.io.ByteReadChannel) r15
            r16 = 0
            r18 = r0
            kotlin.coroutines.Continuation r18 = (kotlin.coroutines.Continuation) r18
            r19 = 1
            r20 = 0
            r0.L$0 = r10
            r0.L$1 = r8
            r2 = 2
            r0.label = r2
            java.lang.Object r2 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.readRemaining$default(r15, r16, r18, r19, r20)
            if (r2 != r1) goto L_0x00df
            return r1
        L_0x00df:
            r3 = r10
        L_0x00e0:
            io.ktor.utils.io.core.Input r2 = (io.ktor.utils.io.core.Input) r2
            r4 = 3
            java.lang.String r2 = io.ktor.utils.io.core.Input.readText$default(r2, r6, r6, r4, r7)
            int r2 = java.lang.Integer.parseInt(r2)
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            io.ktor.client.statement.HttpResponseContainer r5 = new io.ktor.client.statement.HttpResponseContainer
            r5.<init>(r8, r2)
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r2 = r3.proceedWith(r5, r2)
            if (r2 != r1) goto L_0x0248
            return r1
        L_0x0104:
            java.lang.Class<io.ktor.utils.io.core.ByteReadPacket> r14 = io.ktor.utils.io.core.ByteReadPacket.class
            kotlin.reflect.KClass r14 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r14)
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r14)
            if (r14 == 0) goto L_0x0112
            r14 = r5
            goto L_0x011c
        L_0x0112:
            java.lang.Class<io.ktor.utils.io.core.Input> r14 = io.ktor.utils.io.core.Input.class
            kotlin.reflect.KClass r14 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r14)
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r14)
        L_0x011c:
            if (r14 == 0) goto L_0x0150
            r15 = r2
            io.ktor.utils.io.ByteReadChannel r15 = (io.ktor.utils.io.ByteReadChannel) r15
            r16 = 0
            r18 = r0
            kotlin.coroutines.Continuation r18 = (kotlin.coroutines.Continuation) r18
            r19 = 1
            r20 = 0
            r0.L$0 = r10
            r0.L$1 = r8
            r2 = 4
            r0.label = r2
            java.lang.Object r2 = io.ktor.utils.io.ByteReadChannel.DefaultImpls.readRemaining$default(r15, r16, r18, r19, r20)
            if (r2 != r1) goto L_0x0139
            return r1
        L_0x0139:
            r3 = r10
        L_0x013a:
            io.ktor.client.statement.HttpResponseContainer r4 = new io.ktor.client.statement.HttpResponseContainer
            r4.<init>(r8, r2)
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r0.L$0 = r7
            r0.L$1 = r7
            r5 = 5
            r0.label = r5
            java.lang.Object r2 = r3.proceedWith(r4, r2)
            if (r2 != r1) goto L_0x0248
            return r1
        L_0x0150:
            java.lang.Class<byte[]> r14 = byte[].class
            kotlin.reflect.KClass r14 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r14)
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r14)
            if (r14 == 0) goto L_0x01c6
            io.ktor.utils.io.ByteReadChannel r2 = (io.ktor.utils.io.ByteReadChannel) r2
            r9 = r0
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r0.L$0 = r10
            r0.L$1 = r8
            r0.J$0 = r11
            r13 = 6
            r0.label = r13
            java.lang.Object r2 = r2.readRemaining(r11, r9)
            if (r2 != r1) goto L_0x0171
            return r1
        L_0x0171:
            io.ktor.utils.io.core.ByteReadPacket r2 = (io.ktor.utils.io.core.ByteReadPacket) r2
            int r3 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x01ac
            long r3 = r2.getRemaining()
            int r3 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0181
            r3 = r5
            goto L_0x0182
        L_0x0181:
            r3 = r6
        L_0x0182:
            if (r3 == 0) goto L_0x0185
            goto L_0x01ac
        L_0x0185:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Expected "
            r1.append(r3)
            r1.append(r11)
            java.lang.String r3 = ", actual "
            r1.append(r3)
            long r2 = r2.getRemaining()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            throw r2
        L_0x01ac:
            io.ktor.client.statement.HttpResponseContainer r3 = new io.ktor.client.statement.HttpResponseContainer
            byte[] r2 = io.ktor.utils.io.core.StringsKt.readBytes$default(r2, r6, r5, r7)
            r3.<init>(r8, r2)
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r0.L$0 = r7
            r0.L$1 = r7
            r4 = 7
            r0.label = r4
            java.lang.Object r2 = r10.proceedWith(r3, r2)
            if (r2 != r1) goto L_0x0248
            return r1
        L_0x01c6:
            java.lang.Class<io.ktor.utils.io.ByteReadChannel> r3 = io.ktor.utils.io.ByteReadChannel.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r3)
            if (r3 == 0) goto L_0x021e
            kotlin.coroutines.CoroutineContext r3 = r9.getCoroutineContext()
            kotlinx.coroutines.Job$Key r4 = kotlinx.coroutines.Job.Key
            kotlin.coroutines.CoroutineContext$Key r4 = (kotlin.coroutines.CoroutineContext.Key) r4
            kotlin.coroutines.CoroutineContext$Element r3 = r3.get(r4)
            kotlinx.coroutines.Job r3 = (kotlinx.coroutines.Job) r3
            kotlinx.coroutines.CompletableJob r3 = kotlinx.coroutines.JobKt.Job((kotlinx.coroutines.Job) r3)
            r11 = r10
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            kotlin.coroutines.CoroutineContext r12 = r9.getCoroutineContext()
            r13 = 0
            io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2$channel$1 r4 = new io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2$channel$1
            r4.<init>(r2, r9, r7)
            r14 = r4
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r15 = 2
            r16 = 0
            io.ktor.utils.io.WriterJob r2 = io.ktor.utils.io.CoroutinesKt.writer$default((kotlinx.coroutines.CoroutineScope) r11, (kotlin.coroutines.CoroutineContext) r12, (boolean) r13, (kotlin.jvm.functions.Function2) r14, (int) r15, (java.lang.Object) r16)
            io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2$channel$2$1 r4 = new io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2$channel$2$1
            r4.<init>(r3)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r2.invokeOnCompletion(r4)
            io.ktor.utils.io.ByteReadChannel r2 = r2.getChannel()
            io.ktor.client.statement.HttpResponseContainer r3 = new io.ktor.client.statement.HttpResponseContainer
            r3.<init>(r8, r2)
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r0.L$0 = r7
            r4 = 8
            r0.label = r4
            java.lang.Object r2 = r10.proceedWith(r3, r2)
            if (r2 != r1) goto L_0x0248
            return r1
        L_0x021e:
            java.lang.Class<io.ktor.http.HttpStatusCode> r3 = io.ktor.http.HttpStatusCode.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r3)
            if (r3 == 0) goto L_0x0248
            io.ktor.utils.io.ByteReadChannel r2 = (io.ktor.utils.io.ByteReadChannel) r2
            io.ktor.utils.io.ByteReadChannelKt.cancel(r2)
            io.ktor.client.statement.HttpResponseContainer r2 = new io.ktor.client.statement.HttpResponseContainer
            io.ktor.http.HttpStatusCode r3 = r9.getStatus()
            r2.<init>(r8, r3)
            r3 = r0
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r0.L$0 = r7
            r4 = 9
            r0.label = r4
            java.lang.Object r2 = r10.proceedWith(r2, r3)
            if (r2 != r1) goto L_0x0248
            return r1
        L_0x0248:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
