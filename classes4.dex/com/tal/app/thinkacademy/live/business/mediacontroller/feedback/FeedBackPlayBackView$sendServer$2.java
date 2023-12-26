package com.tal.app.thinkacademy.live.business.mediacontroller.feedback;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.ToastUtils;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.mediacontroller.live.IFeedbackAction;
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
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.mediacontroller.feedback.FeedBackPlayBackView$sendServer$2", f = "FeedBackPlayBackView.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: FeedBackPlayBackView.kt */
final class FeedBackPlayBackView$sendServer$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $screenUrl;
    int label;
    final /* synthetic */ FeedBackPlayBackView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedBackPlayBackView$sendServer$2(FeedBackPlayBackView feedBackPlayBackView, String str, Continuation<? super FeedBackPlayBackView$sendServer$2> continuation) {
        super(2, continuation);
        this.this$0 = feedBackPlayBackView;
        this.$screenUrl = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return (Continuation) new FeedBackPlayBackView$sendServer$2(this.this$0, this.$screenUrl, continuation);
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
            if (this.this$0.postFeedbackSever(this.$screenUrl, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        XesLog.s(FeedBackPlayBackView.TAG, "反馈成功");
        this.this$0.hideLoading();
        IFeedbackAction access$getMFeedbackAction$p = this.this$0.mFeedbackAction;
        if (access$getMFeedbackAction$p != null) {
            access$getMFeedbackAction$p.dismissPopup();
        }
        ToastUtils.showLong(R.string.playback_feedback_submit_success);
        return Unit.INSTANCE;
    }
}
