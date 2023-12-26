package com.tal.app.thinkacademy.business.login.presenter;

import com.tal.app.thinkacademy.business.login.entity.CurriculumListData;
import com.tal.app.thinkacademy.common.base.StateLiveData;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.login.presenter.TempClassViewModel$getStudentCurriculumList$2", f = "TempClassViewModel.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TempClassViewModel.kt */
final class TempClassViewModel$getStudentCurriculumList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CurriculumListData $data;
    Object L$0;
    int label;
    final /* synthetic */ TempClassViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TempClassViewModel$getStudentCurriculumList$2(TempClassViewModel tempClassViewModel, CurriculumListData curriculumListData, Continuation<? super TempClassViewModel$getStudentCurriculumList$2> continuation) {
        super(2, continuation);
        this.this$0 = tempClassViewModel;
        this.$data = curriculumListData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TempClassViewModel$getStudentCurriculumList$2(this.this$0, this.$data, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TempClassViewModel$getStudentCurriculumList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData access$get_tempClassLiveData$p = this.this$0._tempClassLiveData;
            this.L$0 = access$get_tempClassLiveData$p;
            this.label = 1;
            Object studentCurriculumList = this.this$0.repository.getStudentCurriculumList(this.$data, this);
            if (studentCurriculumList == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = access$get_tempClassLiveData$p;
            obj = studentCurriculumList;
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
