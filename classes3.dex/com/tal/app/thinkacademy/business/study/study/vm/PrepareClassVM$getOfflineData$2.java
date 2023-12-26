package com.tal.app.thinkacademy.business.study.study.vm;

import com.tal.app.thinkacademy.business.study.study.entity.PlaybackOfflineBean;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.study.study.vm.PrepareClassVM$getOfflineData$2", f = "PrepareClassVM.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PrepareClassVM.kt */
final class PrepareClassVM$getOfflineData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $planId;
    int label;
    final /* synthetic */ PrepareClassVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PrepareClassVM$getOfflineData$2(Integer num, PrepareClassVM prepareClassVM, Continuation<? super PrepareClassVM$getOfflineData$2> continuation) {
        super(2, continuation);
        this.$planId = num;
        this.this$0 = prepareClassVM;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PrepareClassVM$getOfflineData$2(this.$planId, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PrepareClassVM$getOfflineData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = PlanListRepositoryKt.getPlaybackOfflineData(this.$planId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.getOfflineZip().postSuccess((PlaybackOfflineBean) obj);
        return Unit.INSTANCE;
    }
}
