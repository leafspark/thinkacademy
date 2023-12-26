package com.tal.app.thinkacademy.common.network;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0002H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "it", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NetData.kt */
final class NetData$transform$4<T> implements FlowCollector, SuspendFunction {
    final /* synthetic */ Ref.ObjectRef<T> $data;

    NetData$transform$4(Ref.ObjectRef<T> objectRef) {
        this.$data = objectRef;
    }

    public final Object emit(T t, Continuation<? super Unit> continuation) {
        this.$data.element = t;
        return Unit.INSTANCE;
    }
}
