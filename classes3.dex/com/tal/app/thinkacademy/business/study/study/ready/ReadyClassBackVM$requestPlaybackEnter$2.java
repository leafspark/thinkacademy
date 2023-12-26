package com.tal.app.thinkacademy.business.study.study.ready;

import com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.study.study.ready.ReadyClassBackVM$requestPlaybackEnter$2", f = "ReadyClassBackVM.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ReadyClassBackVM.kt */
final class ReadyClassBackVM$requestPlaybackEnter$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bizId;
    final /* synthetic */ String $courseId;
    final /* synthetic */ String $planId;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReadyClassBackVM$requestPlaybackEnter$2(String str, String str2, String str3, Continuation<? super ReadyClassBackVM$requestPlaybackEnter$2> continuation) {
        super(2, continuation);
        this.$planId = str;
        this.$courseId = str2;
        this.$bizId = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReadyClassBackVM$requestPlaybackEnter$2(this.$planId, this.$courseId, this.$bizId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReadyClassBackVM$requestPlaybackEnter$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (PlanListRepositoryKt.getPlaybackEnter(this.$planId, this.$courseId, this.$bizId, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}