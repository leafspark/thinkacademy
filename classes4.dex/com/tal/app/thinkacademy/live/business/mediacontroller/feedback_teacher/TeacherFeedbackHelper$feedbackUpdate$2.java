package com.tal.app.thinkacademy.live.business.mediacontroller.feedback_teacher;

import com.tal.app.thinkacademy.lib.logger.XesLog;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.mediacontroller.feedback_teacher.TeacherFeedbackHelper$feedbackUpdate$2", f = "TeacherFeedbackHelper.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TeacherFeedbackHelper.kt */
final class TeacherFeedbackHelper$feedbackUpdate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $result;
    int label;
    final /* synthetic */ TeacherFeedbackHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TeacherFeedbackHelper$feedbackUpdate$2(TeacherFeedbackHelper teacherFeedbackHelper, String str, Continuation<? super TeacherFeedbackHelper$feedbackUpdate$2> continuation) {
        super(2, continuation);
        this.this$0 = teacherFeedbackHelper;
        this.$result = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new TeacherFeedbackHelper$feedbackUpdate$2(this.this$0, this.$result, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.postFeedbackSever(this.$result, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.isDoFeedback = false;
        this.this$0.mFeedbackId = "";
        XesLog.s(this.this$0.TAG, "反馈成功");
        return Unit.INSTANCE;
    }
}
