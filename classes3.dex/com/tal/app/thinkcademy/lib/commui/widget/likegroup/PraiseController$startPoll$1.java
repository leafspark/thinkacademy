package com.tal.app.thinkcademy.lib.commui.widget.likegroup;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "url", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PraiseController.kt */
final class PraiseController$startPoll$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ PraiseController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PraiseController$startPoll$1(PraiseController praiseController) {
        super(1);
        this.this$0 = praiseController;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        FlyAnimGroup access$getMFlyAnimGroup$p = this.this$0.mFlyAnimGroup;
        if (access$getMFlyAnimGroup$p != null) {
            access$getMFlyAnimGroup$p.addFlyViews(3, str);
        }
    }
}
