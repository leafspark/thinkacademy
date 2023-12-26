package com.adyen.checkout.components.repository;

import com.adyen.checkout.core.api.Connection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u0001H\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0003H@¨\u0006\u0004"}, d2 = {"<anonymous>", "T", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;", "com/adyen/checkout/components/api/ConnectionExtKt$suspendedCall$2"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.adyen.checkout.components.api.ConnectionExtKt$suspendedCall$2", f = "ConnectionExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.adyen.checkout.components.repository.PublicKeyRepository$fetchPublicKey$lambda-0$$inlined$suspendedCall$1  reason: invalid class name */
/* compiled from: ConnectionExt.kt */
public final class PublicKeyRepository$fetchPublicKey$lambda0$$inlined$suspendedCall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Connection $this_suspendedCall;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublicKeyRepository$fetchPublicKey$lambda0$$inlined$suspendedCall$1(Connection connection, Continuation continuation) {
        super(2, continuation);
        this.$this_suspendedCall = connection;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new PublicKeyRepository$fetchPublicKey$lambda0$$inlined$suspendedCall$1(this.$this_suspendedCall, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.$this_suspendedCall.call();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
