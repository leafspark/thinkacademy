package com.tal.app.thinkacademy.live.abilitypack.coincenter.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.abilitypack.coincenter.api.CoinCenterRepository", f = "CoinCenterRepository.kt", i = {}, l = {19, 19}, m = "studentCoinAndMedal", n = {}, s = {})
/* compiled from: CoinCenterRepository.kt */
final class CoinCenterRepository$studentCoinAndMedal$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoinCenterRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoinCenterRepository$studentCoinAndMedal$1(CoinCenterRepository coinCenterRepository, Continuation<? super CoinCenterRepository$studentCoinAndMedal$1> continuation) {
        super(continuation);
        this.this$0 = coinCenterRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.studentCoinAndMedal(0, (Continuation) this);
    }
}
