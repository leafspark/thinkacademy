package com.tal.app.thinkacademy.live.business.mediacontroller.feedback_teacher;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.mediacontroller.feedback_teacher.TeacherFeedbackHelper", f = "TeacherFeedbackHelper.kt", i = {}, l = {151, 150}, m = "postFeedbackSever", n = {}, s = {})
/* compiled from: TeacherFeedbackHelper.kt */
final class TeacherFeedbackHelper$postFeedbackSever$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TeacherFeedbackHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TeacherFeedbackHelper$postFeedbackSever$1(TeacherFeedbackHelper teacherFeedbackHelper, Continuation<? super TeacherFeedbackHelper$postFeedbackSever$1> continuation) {
        super(continuation);
        this.this$0 = teacherFeedbackHelper;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.postFeedbackSever((String) null, (Continuation) this);
    }
}
