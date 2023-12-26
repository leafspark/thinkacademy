package io.ktor.client.plugins;

import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelJVMKt;
import io.ktor.utils.io.WriterScope;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DefaultTransformKt$defaultTransformers$2$channel$1", f = "DefaultTransform.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DefaultTransform.kt */
final class DefaultTransformKt$defaultTransformers$2$channel$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $body;
    final /* synthetic */ HttpResponse $response;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultTransformKt$defaultTransformers$2$channel$1(Object obj, HttpResponse httpResponse, Continuation<? super DefaultTransformKt$defaultTransformers$2$channel$1> continuation) {
        super(2, continuation);
        this.$body = obj;
        this.$response = httpResponse;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> defaultTransformKt$defaultTransformers$2$channel$1 = new DefaultTransformKt$defaultTransformers$2$channel$1(this.$body, this.$response, continuation);
        defaultTransformKt$defaultTransformers$2$channel$1.L$0 = obj;
        return (Continuation) defaultTransformKt$defaultTransformers$2$channel$1;
    }

    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return create(writerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WriterScope writerScope = (WriterScope) this.L$0;
            this.label = 1;
            if (ByteReadChannelJVMKt.copyTo((ByteReadChannel) this.$body, writerScope.getChannel(), HttpTimeout.INFINITE_TIMEOUT_MS, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (CancellationException e) {
                CoroutineScopeKt.cancel(this.$response, e);
                throw e;
            } catch (Throwable th) {
                HttpResponseKt.complete(this.$response);
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        HttpResponseKt.complete(this.$response);
        return Unit.INSTANCE;
    }
}
