package com.tal.app.thinkacademy.live.business.canvastriplescreen.http;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.canvastriplescreen.http.CanvasRepository", f = "CanvasRepository.kt", i = {}, l = {31, 30}, m = "studentGetAllPageKey", n = {}, s = {})
/* compiled from: CanvasRepository.kt */
final class CanvasRepository$studentGetAllPageKey$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CanvasRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CanvasRepository$studentGetAllPageKey$1(CanvasRepository canvasRepository, Continuation<? super CanvasRepository$studentGetAllPageKey$1> continuation) {
        super(continuation);
        this.this$0 = canvasRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.studentGetAllPageKey((String) null, (Continuation) this);
    }
}
