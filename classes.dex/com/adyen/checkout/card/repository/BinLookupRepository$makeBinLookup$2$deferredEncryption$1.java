package com.adyen.checkout.card.repository;

import com.adyen.checkout.cse.CardEncrypter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.adyen.checkout.card.repository.BinLookupRepository$makeBinLookup$2$deferredEncryption$1", f = "BinLookupRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BinLookupRepository.kt */
final class BinLookupRepository$makeBinLookup$2$deferredEncryption$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $cardNumber;
    final /* synthetic */ String $publicKey;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BinLookupRepository$makeBinLookup$2$deferredEncryption$1(String str, String str2, Continuation<? super BinLookupRepository$makeBinLookup$2$deferredEncryption$1> continuation) {
        super(2, continuation);
        this.$cardNumber = str;
        this.$publicKey = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new BinLookupRepository$makeBinLookup$2$deferredEncryption$1(this.$cardNumber, this.$publicKey, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return CardEncrypter.encryptBin(this.$cardNumber, this.$publicKey);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
