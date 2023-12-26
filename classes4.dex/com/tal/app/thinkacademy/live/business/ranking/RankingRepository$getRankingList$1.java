package com.tal.app.thinkacademy.live.business.ranking;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.ranking.RankingRepository", f = "RankingRepository.kt", i = {}, l = {23, 23}, m = "getRankingList", n = {}, s = {})
/* compiled from: RankingRepository.kt */
final class RankingRepository$getRankingList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RankingRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RankingRepository$getRankingList$1(RankingRepository rankingRepository, Continuation<? super RankingRepository$getRankingList$1> continuation) {
        super(continuation);
        this.this$0 = rankingRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getRankingList((Integer) null, (Integer) null, (Continuation) this);
    }
}
