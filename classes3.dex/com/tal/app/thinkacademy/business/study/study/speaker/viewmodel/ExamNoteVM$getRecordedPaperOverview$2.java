package com.tal.app.thinkacademy.business.study.study.speaker.viewmodel;

import com.tal.app.thinkacademy.business.study.study.entity.RecordedPaperDetailEntity;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.study.study.speaker.viewmodel.ExamNoteVM$getRecordedPaperOverview$2", f = "ExamNoteVM.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ExamNoteVM.kt */
final class ExamNoteVM$getRecordedPaperOverview$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $bindType;
    final /* synthetic */ String $entityId;
    final /* synthetic */ int $homeworkType;
    final /* synthetic */ String $platform;
    Object L$0;
    int label;
    final /* synthetic */ ExamNoteVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExamNoteVM$getRecordedPaperOverview$2(ExamNoteVM examNoteVM, String str, String str2, int i, int i2, Continuation<? super ExamNoteVM$getRecordedPaperOverview$2> continuation) {
        super(2, continuation);
        this.this$0 = examNoteVM;
        this.$entityId = str;
        this.$platform = str2;
        this.$bindType = i;
        this.$homeworkType = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExamNoteVM$getRecordedPaperOverview$2(this.this$0, this.$entityId, this.$platform, this.$bindType, this.$homeworkType, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ExamNoteVM$getRecordedPaperOverview$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData<RecordedPaperDetailEntity> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<RecordedPaperDetailEntity> recordedPaperDetail = this.this$0.getRecordedPaperDetail();
            this.L$0 = recordedPaperDetail;
            this.label = 1;
            Object recordedPaperOverview = PlanListRepositoryKt.recordedPaperOverview(this.$entityId, this.$platform, this.$bindType, this.$homeworkType, this);
            if (recordedPaperOverview == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = recordedPaperDetail;
            obj = recordedPaperOverview;
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
