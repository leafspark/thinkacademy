package com.tal.app.thinkacademy.business.study.study.ready;

import com.tal.app.thinkacademy.business.study.study.entity.ReadyClassBean;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.study.study.ready.ReadyClassLiveVM$requestPrepareData$2", f = "ReadyClassLiveVM.kt", i = {0}, l = {81}, m = "invokeSuspend", n = {"startTime"}, s = {"J$0"})
/* compiled from: ReadyClassLiveVM.kt */
final class ReadyClassLiveVM$requestPrepareData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $classId;
    final /* synthetic */ String $planId;
    long J$0;
    int label;
    final /* synthetic */ ReadyClassLiveVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReadyClassLiveVM$requestPrepareData$2(String str, String str2, ReadyClassLiveVM readyClassLiveVM, Continuation<? super ReadyClassLiveVM$requestPrepareData$2> continuation) {
        super(2, continuation);
        this.$planId = str;
        this.$classId = str2;
        this.this$0 = readyClassLiveVM;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReadyClassLiveVM$requestPrepareData$2(this.$planId, this.$classId, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ReadyClassLiveVM$requestPrepareData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        long j;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long currentTimeMillis = System.currentTimeMillis();
            this.J$0 = currentTimeMillis;
            this.label = 1;
            obj = PlanListRepositoryKt.getPrepareClass(this.$planId, this.$classId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            j = currentTimeMillis;
        } else if (i == 1) {
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ReadyClassBean readyClassBean = (ReadyClassBean) obj;
        if (readyClassBean != null) {
            this.this$0.setupServerTime(readyClassBean.getTimestamp(), System.currentTimeMillis() - j);
        }
        this.this$0.getMReadyClassBean().postSuccess(readyClassBean);
        return Unit.INSTANCE;
    }
}
