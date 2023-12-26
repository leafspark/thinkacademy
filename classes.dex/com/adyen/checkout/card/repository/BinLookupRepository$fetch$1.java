package com.adyen.checkout.card.repository;

import com.adyen.checkout.card.CardConfiguration;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.adyen.checkout.card.repository.BinLookupRepository", f = "BinLookupRepository.kt", i = {0, 0}, l = {65}, m = "fetch", n = {"this", "cardNumber"}, s = {"L$0", "L$1"})
/* compiled from: BinLookupRepository.kt */
final class BinLookupRepository$fetch$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BinLookupRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BinLookupRepository$fetch$1(BinLookupRepository binLookupRepository, Continuation<? super BinLookupRepository$fetch$1> continuation) {
        super(continuation);
        this.this$0 = binLookupRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetch((String) null, (String) null, (CardConfiguration) null, (Continuation) this);
    }
}
