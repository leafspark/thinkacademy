package com.tal.app.thinkacademy.business.shop.viewmodel;

import com.tal.app.thinkacademy.common.base.StateLiveData;
import com.tal.app.thinkacademy.common.user.GradeStageList;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.shop.viewmodel.SeletedStudentViewModel$getGradeStageList$2", f = "SeletedStudentViewModel.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SeletedStudentViewModel.kt */
final class SeletedStudentViewModel$getGradeStageList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ SeletedStudentViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SeletedStudentViewModel$getGradeStageList$2(SeletedStudentViewModel seletedStudentViewModel, Continuation<? super SeletedStudentViewModel$getGradeStageList$2> continuation) {
        super(2, continuation);
        this.this$0 = seletedStudentViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SeletedStudentViewModel$getGradeStageList$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SeletedStudentViewModel$getGradeStageList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData<GradeStageList> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<GradeStageList> gradeStageList = this.this$0.getGradeStageList();
            this.L$0 = gradeStageList;
            this.label = 1;
            Object gradeStageList2 = this.this$0.getRepository().getGradeStageList(this);
            if (gradeStageList2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = gradeStageList;
            obj = gradeStageList2;
        } else if (i == 1) {
            stateLiveData = (StateLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        stateLiveData.postSuccess(obj);
        return Unit.INSTANCE;
    }
}
