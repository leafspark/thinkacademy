package com.tal.app.thinkacademy.live.business.schulte.view;

import android.content.Context;
import com.tal.app.thinkacademy.live.business.schulte.api.ISceneChange;
import com.tal.app.thinkacademy.live.business.schulte.bean.SchulteTableUserDataBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTablePluginView.kt */
final class SchulteTablePluginView$loadResultView$next$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SchulteTableUserDataBean $userData;
    final /* synthetic */ SchulteTablePluginView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SchulteTablePluginView$loadResultView$next$1(SchulteTablePluginView schulteTablePluginView, SchulteTableUserDataBean schulteTableUserDataBean) {
        super(0);
        this.this$0 = schulteTablePluginView;
        this.$userData = schulteTableUserDataBean;
    }

    public final void invoke() {
        SchulteTablePluginView schulteTablePluginView = this.this$0;
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        schulteTablePluginView.mResultView = new SchulteTableResultView(context, this.$userData);
        SchulteTablePluginView schulteTablePluginView2 = this.this$0;
        schulteTablePluginView2.addSceneView(schulteTablePluginView2.mResultView);
        this.this$0.mBinding.lottieResultRibbon.setVisibility(0);
        this.this$0.mBinding.lottieResultRibbon.playAnimation();
        SchulteTableResultView access$getMResultView$p = this.this$0.mResultView;
        if (access$getMResultView$p != null) {
            ISceneChange.DefaultImpls.show$default(access$getMResultView$p, (Function0) null, 1, (Object) null);
        }
        SchulteTablePluginView.showBaseView$default(this.this$0, (Function0) null, 1, (Object) null);
    }
}
