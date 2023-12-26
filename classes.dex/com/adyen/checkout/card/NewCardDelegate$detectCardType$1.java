package com.adyen.checkout.card;

import com.adyen.checkout.core.log.Logger;
import java.util.List;
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
@DebugMetadata(c = "com.adyen.checkout.card.NewCardDelegate$detectCardType$1", f = "NewCardDelegate.kt", i = {}, l = {163}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NewCardDelegate.kt */
final class NewCardDelegate$detectCardType$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cardNumber;
    final /* synthetic */ String $publicKey;
    int label;
    final /* synthetic */ NewCardDelegate this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NewCardDelegate$detectCardType$1(NewCardDelegate newCardDelegate, String str, String str2, Continuation<? super NewCardDelegate$detectCardType$1> continuation) {
        super(2, continuation);
        this.this$0 = newCardDelegate;
        this.$cardNumber = str;
        this.$publicKey = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new NewCardDelegate$detectCardType$1(this.this$0, this.$cardNumber, this.$publicKey, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.binLookupRepository.fetch(this.$cardNumber, this.$publicKey, this.this$0.getCardConfiguration(), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Logger.d(NewCardDelegateKt.TAG, "Emitting new detectedCardTypes");
        this.this$0._binLookupFlow.tryEmit((List) obj);
        return Unit.INSTANCE;
    }
}
