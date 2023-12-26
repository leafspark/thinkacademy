package io.ktor.utils.io;

import io.ktor.utils.io.core.Input;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\f\b\u0000\u0010\u0002*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@"}, d2 = {"<anonymous>", "Lio/ktor/utils/io/core/Input;", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "size", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteChannelSequentialBase$readUTF8LineTo$2", f = "ByteChannelSequential.kt", i = {}, l = {715}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ByteChannelSequential.kt */
final class ByteChannelSequentialBase$readUTF8LineTo$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Input>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ ByteChannelSequentialBase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ByteChannelSequentialBase$readUTF8LineTo$2(ByteChannelSequentialBase byteChannelSequentialBase, Continuation<? super ByteChannelSequentialBase$readUTF8LineTo$2> continuation) {
        super(2, continuation);
        this.this$0 = byteChannelSequentialBase;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> byteChannelSequentialBase$readUTF8LineTo$2 = new ByteChannelSequentialBase$readUTF8LineTo$2(this.this$0, continuation);
        byteChannelSequentialBase$readUTF8LineTo$2.I$0 = ((Number) obj).intValue();
        return (Continuation) byteChannelSequentialBase$readUTF8LineTo$2;
    }

    public final Object invoke(int i, Continuation<? super Input> continuation) {
        return create(Integer.valueOf(i), continuation).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (Continuation<? super Input>) (Continuation) obj2);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int i2 = this.I$0;
            this.label = 1;
            obj = this.this$0.await(i2, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            return this.this$0.getReadable();
        }
        return null;
    }
}
