package com.tal.app.thinkacademy.live.business.mediacontroller.feedback;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.tal.app.thinkacademy.live.business.mediacontroller.feedback.FeedBackPlayBackView", f = "FeedBackPlayBackView.kt", i = {}, l = {209, 209}, m = "postFeedbackSever", n = {}, s = {})
/* compiled from: FeedBackPlayBackView.kt */
final class FeedBackPlayBackView$postFeedbackSever$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FeedBackPlayBackView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FeedBackPlayBackView$postFeedbackSever$1(FeedBackPlayBackView feedBackPlayBackView, Continuation<? super FeedBackPlayBackView$postFeedbackSever$1> continuation) {
        super(continuation);
        this.this$0 = feedBackPlayBackView;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.postFeedbackSever((String) null, (Continuation) this);
    }
}
