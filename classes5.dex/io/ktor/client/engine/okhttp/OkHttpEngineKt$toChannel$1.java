package io.ktor.client.engine.okhttp;

import io.ktor.client.request.HttpRequestData;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterScope;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.JobKt;
import okio.BufferedSource;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngineKt$toChannel$1", f = "OkHttpEngine.kt", i = {0, 0, 0}, l = {165}, m = "invokeSuspend", n = {"$this$writer", "source", "lastRead"}, s = {"L$0", "L$4", "L$5"})
/* compiled from: OkHttpEngine.kt */
final class OkHttpEngineKt$toChannel$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ HttpRequestData $requestData;
    final /* synthetic */ BufferedSource $this_toChannel;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkHttpEngineKt$toChannel$1(BufferedSource bufferedSource, CoroutineContext coroutineContext, HttpRequestData httpRequestData, Continuation<? super OkHttpEngineKt$toChannel$1> continuation) {
        super(2, continuation);
        this.$this_toChannel = bufferedSource;
        this.$context = coroutineContext;
        this.$requestData = httpRequestData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> okHttpEngineKt$toChannel$1 = new OkHttpEngineKt$toChannel$1(this.$this_toChannel, this.$context, this.$requestData, continuation);
        okHttpEngineKt$toChannel$1.L$0 = obj;
        return (Continuation) okHttpEngineKt$toChannel$1;
    }

    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return create(writerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: finally extract failed */
    public final Object invokeSuspend(Object obj) {
        OkHttpEngineKt$toChannel$1 okHttpEngineKt$toChannel$1;
        WriterScope writerScope;
        BufferedSource bufferedSource;
        CoroutineContext coroutineContext;
        HttpRequestData httpRequestData;
        BufferedSource bufferedSource2;
        Ref.IntRef intRef;
        Throwable th;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WriterScope writerScope2 = (WriterScope) this.L$0;
            bufferedSource = (Closeable) this.$this_toChannel;
            CoroutineContext coroutineContext2 = this.$context;
            httpRequestData = this.$requestData;
            okHttpEngineKt$toChannel$1 = this;
            writerScope = writerScope2;
            intRef = new Ref.IntRef();
            coroutineContext = coroutineContext2;
            bufferedSource2 = bufferedSource;
        } else if (i == 1) {
            intRef = (Ref.IntRef) this.L$5;
            bufferedSource2 = (BufferedSource) this.L$4;
            httpRequestData = (HttpRequestData) this.L$3;
            coroutineContext = (CoroutineContext) this.L$2;
            bufferedSource = (Closeable) this.L$1;
            writerScope = (WriterScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                okHttpEngineKt$toChannel$1 = this;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                CloseableKt.closeFinally(bufferedSource, th);
                throw th3;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (bufferedSource2.isOpen() && JobKt.isActive(coroutineContext) && intRef.element >= 0) {
            okHttpEngineKt$toChannel$1.L$0 = writerScope;
            okHttpEngineKt$toChannel$1.L$1 = bufferedSource;
            okHttpEngineKt$toChannel$1.L$2 = coroutineContext;
            okHttpEngineKt$toChannel$1.L$3 = httpRequestData;
            okHttpEngineKt$toChannel$1.L$4 = bufferedSource2;
            okHttpEngineKt$toChannel$1.L$5 = intRef;
            okHttpEngineKt$toChannel$1.label = 1;
            if (ByteWriteChannel.DefaultImpls.write$default(writerScope.getChannel(), 0, new OkHttpEngineKt$toChannel$1$1$1(intRef, bufferedSource2, httpRequestData), okHttpEngineKt$toChannel$1, 1, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Unit unit = Unit.INSTANCE;
        CloseableKt.closeFinally(bufferedSource, (Throwable) null);
        return Unit.INSTANCE;
    }
}
