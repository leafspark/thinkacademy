package com.tal.app.thinkacademy.business.study.study.speaker.viewmodel;

import com.tal.app.thinkacademy.business.study.study.entity.PaperDetailEntity;
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
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.business.study.study.speaker.viewmodel.ExamNoteVM$getPaperOverview$2", f = "ExamNoteVM.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ExamNoteVM.kt */
final class ExamNoteVM$getPaperOverview$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $classId;
    final /* synthetic */ Integer $homeworkType;
    final /* synthetic */ String $paperId;
    final /* synthetic */ Integer $planId;
    final /* synthetic */ String $platform;
    Object L$0;
    int label;
    final /* synthetic */ ExamNoteVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExamNoteVM$getPaperOverview$2(ExamNoteVM examNoteVM, String str, Integer num, Integer num2, Integer num3, String str2, Continuation<? super ExamNoteVM$getPaperOverview$2> continuation) {
        super(2, continuation);
        this.this$0 = examNoteVM;
        this.$paperId = str;
        this.$planId = num;
        this.$homeworkType = num2;
        this.$classId = num3;
        this.$platform = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExamNoteVM$getPaperOverview$2(this.this$0, this.$paperId, this.$planId, this.$homeworkType, this.$classId, this.$platform, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ExamNoteVM$getPaperOverview$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData<PaperDetailEntity> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<PaperDetailEntity> paperDetailData = this.this$0.getPaperDetailData();
            this.L$0 = paperDetailData;
            this.label = 1;
            Object paperOverview = PlanListRepositoryKt.paperOverview(this.$paperId, this.$planId, this.$homeworkType, this.$classId, this.$platform, this);
            if (paperOverview == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = paperDetailData;
            obj = paperOverview;
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
