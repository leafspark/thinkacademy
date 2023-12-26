package com.tal.app.thinkacademy.live.business.interactivegames.activity;

import com.tal.app.thinkacademy.live.business.interactivegames.bean.body.SubmitGameDataBody;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.interactivegames.activity.GameRepository", f = "GameRepository.kt", i = {}, l = {20, 20}, m = "submitGameData", n = {}, s = {})
/* compiled from: GameRepository.kt */
final class GameRepository$submitGameData$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GameRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GameRepository$submitGameData$1(GameRepository gameRepository, Continuation<? super GameRepository$submitGameData$1> continuation) {
        super(continuation);
        this.this$0 = gameRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.submitGameData((String) null, (SubmitGameDataBody) null, (Continuation) this);
    }
}
