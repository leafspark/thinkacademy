package com.tal.app.thinkacademy.business.study.study.speaker.viewmodel;

import com.tal.app.thinkacademy.business.study.study.entity.RecordedCalendarListEntity;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.business.study.study.speaker.viewmodel.PlanListVM$getRecordedCalendar$2", f = "PlanListVM.kt", i = {}, l = {171}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PlanListVM.kt */
final class PlanListVM$getRecordedCalendar$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $studentCourseId;
    Object L$0;
    int label;
    final /* synthetic */ PlanListVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PlanListVM$getRecordedCalendar$2(PlanListVM planListVM, long j, Continuation<? super PlanListVM$getRecordedCalendar$2> continuation) {
        super(2, continuation);
        this.this$0 = planListVM;
        this.$studentCourseId = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlanListVM$getRecordedCalendar$2(this.this$0, this.$studentCourseId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlanListVM$getRecordedCalendar$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        StateLiveData<RecordedCalendarListEntity> stateLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateLiveData<RecordedCalendarListEntity> recordedCalendar = this.this$0.getRecordedCalendar();
            this.L$0 = recordedCalendar;
            this.label = 1;
            Object recordedCalendarData = PlanListRepositoryKt.getRecordedCalendarData(this.$studentCourseId, this);
            if (recordedCalendarData == coroutine_suspended) {
                return coroutine_suspended;
            }
            stateLiveData = recordedCalendar;
            obj = recordedCalendarData;
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
