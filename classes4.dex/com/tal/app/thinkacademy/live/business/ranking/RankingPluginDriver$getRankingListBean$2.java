package com.tal.app.thinkacademy.live.business.ranking;

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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.ranking.RankingPluginDriver$getRankingListBean$2", f = "RankingPluginDriver.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: RankingPluginDriver.kt */
final class RankingPluginDriver$getRankingListBean$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RankingPluginDriver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RankingPluginDriver$getRankingListBean$2(RankingPluginDriver rankingPluginDriver, Continuation<? super RankingPluginDriver$getRankingListBean$2> continuation) {
        super(2, continuation);
        this.this$0 = rankingPluginDriver;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new RankingPluginDriver$getRankingListBean$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        RankingPluginDriver rankingPluginDriver;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RankingPluginDriver rankingPluginDriver2 = this.this$0;
            this.L$0 = rankingPluginDriver2;
            this.label = 1;
            Object rankingList = new RankingRepository().getRankingList(this.this$0.mPlanId, this.this$0.mClassId, (Continuation) this);
            if (rankingList == coroutine_suspended) {
                return coroutine_suspended;
            }
            rankingPluginDriver = rankingPluginDriver2;
            obj = rankingList;
        } else if (i == 1) {
            rankingPluginDriver = (RankingPluginDriver) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        rankingPluginDriver.mRankingList = (List) obj;
        List access$getMRankingList$p = this.this$0.mRankingList;
        if (access$getMRankingList$p != null) {
            this.this$0.addPluginView(access$getMRankingList$p);
        }
        return Unit.INSTANCE;
    }
}
