package com.tal.app.thinkacademy.live.business.drawing;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.drawing.DrawPluginDriver", f = "DrawPluginDriver.kt", i = {0, 1}, l = {528, 528}, m = "aswSuccess", n = {"this", "this"}, s = {"L$0", "L$0"})
/* compiled from: DrawPluginDriver.kt */
final class DrawPluginDriver$aswSuccess$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DrawPluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DrawPluginDriver$aswSuccess$1(DrawPluginDriver drawPluginDriver, Continuation<? super DrawPluginDriver$aswSuccess$1> continuation) {
        super(continuation);
        this.this$0 = drawPluginDriver;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.aswSuccess((Long) null, (Long) null, (Long) null, (String) null, (String) null, (Continuation) this);
    }
}
