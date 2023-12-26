package com.tal.app.thinkacademy;

import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: TestActivity.kt */
final class TestActivity$startObserve$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TestActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TestActivity$startObserve$1$2(TestActivity testActivity) {
        super(0);
        this.this$0 = testActivity;
    }

    public final void invoke() {
        LoadStatusView loadStatusView = this.this$0.getBinding().lsView;
        Intrinsics.checkNotNullExpressionValue(loadStatusView, "binding.lsView");
        LoadStatusView.showFullLoadingView$default(loadStatusView, 0, 1, (Object) null);
        this.this$0.getMViewModel().test("androidMonitor", "0", "72001", "android");
    }
}
