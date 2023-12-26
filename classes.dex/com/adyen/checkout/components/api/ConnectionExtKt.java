package com.adyen.checkout.components.api;

import com.adyen.checkout.core.api.Connection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002HHø\u0001\u0000¢\u0006\u0002\u0010\u0003\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"suspendedCall", "T", "Lcom/adyen/checkout/core/api/Connection;", "(Lcom/adyen/checkout/core/api/Connection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "components-core_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: ConnectionExt.kt */
public final class ConnectionExtKt {
    public static final /* synthetic */ <T> Object suspendedCall(Connection<T> connection, Continuation<? super T> continuation) {
        Intrinsics.needClassReification();
        InlineMarker.mark(0);
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ConnectionExtKt$suspendedCall$2(connection, (Continuation<? super ConnectionExtKt$suspendedCall$2>) null), continuation);
        InlineMarker.mark(1);
        return withContext;
    }
}
