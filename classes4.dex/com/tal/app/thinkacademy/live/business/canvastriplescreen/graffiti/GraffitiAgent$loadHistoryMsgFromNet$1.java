package com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.canvastriplescreen.graffiti.GraffitiAgent", f = "GraffitiAgent.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {380, 404}, m = "loadHistoryMsgFromNet", n = {"this", "dbkey", "list", "url", "body", "startMsgId", "pageNum", "this", "list", "url", "body", "res"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4"})
/* compiled from: GraffitiAgent.kt */
final class GraffitiAgent$loadHistoryMsgFromNet$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GraffitiAgent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraffitiAgent$loadHistoryMsgFromNet$1(GraffitiAgent graffitiAgent, Continuation<? super GraffitiAgent$loadHistoryMsgFromNet$1> continuation) {
        super(continuation);
        this.this$0 = graffitiAgent;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadHistoryMsgFromNet((String) null, 0, 0, (Continuation) this);
    }
}
