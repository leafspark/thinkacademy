package com.tal.app.thinkacademy.business.study.study.speaker.viewmodel;

import com.tal.app.thinkacademy.business.study.study.entity.AssignmentEntity;
import com.tal.app.thinkacademy.business.study.study.entity.JumpParamsEntity;
import com.tal.app.thinkacademy.business.study.study.speaker.network.PlanListRepositoryKt;
import com.tal.app.thinkacademy.common.base.StateLiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.study.study.speaker.viewmodel.PlanListVM$requestHomeWorkJumpUrl$2", f = "PlanListVM.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PlanListVM.kt */
final class PlanListVM$requestHomeWorkJumpUrl$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JumpParamsEntity $jumpParamsEntity;
    Object L$0;
    int label;
    final /* synthetic */ PlanListVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlanListVM$requestHomeWorkJumpUrl$2(PlanListVM planListVM, JumpParamsEntity jumpParamsEntity, Continuation<? super PlanListVM$requestHomeWorkJumpUrl$2> continuation) {
        super(2, continuation);
        this.this$0 = planListVM;
        this.$jumpParamsEntity = jumpParamsEntity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlanListVM$requestHomeWorkJumpUrl$2(this.this$0, this.$jumpParamsEntity, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlanListVM$requestHomeWorkJumpUrl$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        StateLiveData<AssignmentEntity> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<AssignmentEntity> homeWorkJumpUrl = this.this$0.getHomeWorkJumpUrl();
            this.L$0 = homeWorkJumpUrl;
            this.label = 1;
            obj2 = PlanListRepositoryKt.getHomeWorkJumpUrl(this.$jumpParamsEntity, this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = homeWorkJumpUrl;
        } else if (i == 1) {
            stateLiveData = (StateLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str = (String) obj2;
        JumpParamsEntity jumpParamsEntity = this.$jumpParamsEntity;
        Integer num = null;
        Integer classId = jumpParamsEntity == null ? null : jumpParamsEntity.getClassId();
        JumpParamsEntity jumpParamsEntity2 = this.$jumpParamsEntity;
        String homeworkId = jumpParamsEntity2 == null ? null : jumpParamsEntity2.getHomeworkId();
        JumpParamsEntity jumpParamsEntity3 = this.$jumpParamsEntity;
        if (jumpParamsEntity3 != null) {
            num = jumpParamsEntity3.getPlanId();
        }
        stateLiveData.postSuccess(new AssignmentEntity((String) null, (String) null, (Integer) null, str, (Integer) null, new JumpParamsEntity((String) null, num, classId, homeworkId, (Integer) null, (String) null, (String) null, 113, (DefaultConstructorMarker) null), 23, (DefaultConstructorMarker) null));
        return Unit.INSTANCE;
    }
}
