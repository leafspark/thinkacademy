package io.ktor.http.content;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.http.content.MultipartKt", f = "Multipart.kt", i = {0, 0, 1, 1}, l = {126, 127}, m = "forEachPart", n = {"$this$forEachPart", "partHandler", "$this$forEachPart", "partHandler"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: Multipart.kt */
final class MultipartKt$forEachPart$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    MultipartKt$forEachPart$1(Continuation<? super MultipartKt$forEachPart$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return MultipartKt.forEachPart((MultiPartData) null, (Function2<? super PartData, ? super Continuation<? super Unit>, ? extends Object>) null, (Continuation) this);
    }
}
