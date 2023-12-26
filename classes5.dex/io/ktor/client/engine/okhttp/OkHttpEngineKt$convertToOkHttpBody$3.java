package io.ktor.client.engine.okhttp;

import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lio/ktor/utils/io/ByteReadChannel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkHttpEngine.kt */
final class OkHttpEngineKt$convertToOkHttpBody$3 extends Lambda implements Function0<ByteReadChannel> {
    final /* synthetic */ CoroutineContext $callContext;
    final /* synthetic */ OutgoingContent $this_convertToOkHttpBody;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkHttpEngineKt$convertToOkHttpBody$3(CoroutineContext coroutineContext, OutgoingContent outgoingContent) {
        super(0);
        this.$callContext = coroutineContext;
        this.$this_convertToOkHttpBody = outgoingContent;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpBody$3$1", f = "OkHttpEngine.kt", i = {}, l = {211}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.client.engine.okhttp.OkHttpEngineKt$convertToOkHttpBody$3$1  reason: invalid class name */
    /* compiled from: OkHttpEngine.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> r0 = new AnonymousClass1(outgoingContent, continuation);
            r0.L$0 = obj;
            return (Continuation) r0;
        }

        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return create(writerScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (((OutgoingContent.WriteChannelContent) outgoingContent).writeTo(((WriterScope) this.L$0).getChannel(), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final ByteReadChannel invoke() {
        CoroutineContext coroutineContext = this.$callContext;
        final OutgoingContent outgoingContent = this.$this_convertToOkHttpBody;
        return CoroutinesKt.writer$default((CoroutineScope) GlobalScope.INSTANCE, coroutineContext, false, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 2, (Object) null).getChannel();
    }
}
