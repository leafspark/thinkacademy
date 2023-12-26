package com.tal.app.thinkcademy.lib.commui.widget;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tal/app/thinkcademy/lib/commui/widget/FullLoadingView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoadStatusView.kt */
final class LoadStatusView$mFullLoadingView$2 extends Lambda implements Function0<FullLoadingView> {
    final /* synthetic */ LoadStatusView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoadStatusView$mFullLoadingView$2(LoadStatusView loadStatusView) {
        super(0);
        this.this$0 = loadStatusView;
    }

    public final FullLoadingView invoke() {
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new FullLoadingView(context);
    }
}
