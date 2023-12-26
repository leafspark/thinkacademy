package com.adyen.checkout.adyen3ds2;

import com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.adyen.checkout.adyen3ds2.Adyen3DS2Component$submitFingerprintAutomatically$2", f = "Adyen3DS2Component.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Adyen3DS2Component.kt */
final class Adyen3DS2Component$submitFingerprintAutomatically$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SubmitFingerprintResult $result;
    int label;
    final /* synthetic */ Adyen3DS2Component this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Adyen3DS2Component$submitFingerprintAutomatically$2(Adyen3DS2Component adyen3DS2Component, SubmitFingerprintResult submitFingerprintResult, Continuation<? super Adyen3DS2Component$submitFingerprintAutomatically$2> continuation) {
        super(2, continuation);
        this.this$0 = adyen3DS2Component;
        this.$result = submitFingerprintResult;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new Adyen3DS2Component$submitFingerprintAutomatically$2(this.this$0, this.$result, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.notifyDetails(((SubmitFingerprintResult.Completed) this.$result).getDetails());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
