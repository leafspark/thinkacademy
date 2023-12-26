package com.tal.app.thinkacademy.common.network;

import com.tal.app.thinkacademy.lib.restful.HiResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.common.network.NetData", f = "NetData.kt", i = {0}, l = {45}, m = "transform", n = {"data"}, s = {"L$0"})
/* compiled from: NetData.kt */
final class NetData$transform$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetData this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NetData$transform$1(NetData netData, Continuation<? super NetData$transform$1> continuation) {
        super(continuation);
        this.this$0 = netData;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.transform((HiResponse) null, (Continuation) this);
    }
}
