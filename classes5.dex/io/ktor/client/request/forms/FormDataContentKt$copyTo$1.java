package io.ktor.client.request.forms;

import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.core.Input;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.request.forms.FormDataContentKt", f = "FormDataContent.kt", i = {1, 1, 1, 2, 2}, l = {155, 170, 177, 177}, m = "copyTo", n = {"$this$copyTo", "channel", "$this$write_u24default$iv", "$this$copyTo", "channel"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
/* compiled from: FormDataContent.kt */
final class FormDataContentKt$copyTo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    FormDataContentKt$copyTo$1(Continuation<? super FormDataContentKt$copyTo$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FormDataContentKt.copyTo((Input) null, (ByteWriteChannel) null, (Continuation) this);
    }
}
