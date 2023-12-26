package com.tal.app.thinkacademy.live.business.schulte.view;

import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTablePluginView.kt */
final class SchulteTablePluginView$loadResultView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $next;
    final /* synthetic */ SchulteTablePluginView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SchulteTablePluginView$loadResultView$1(SchulteTablePluginView schulteTablePluginView, Function0<Unit> function0) {
        super(0);
        this.this$0 = schulteTablePluginView;
        this.$next = function0;
    }

    public final void invoke() {
        TransitionDrawable access$getMBgTransition$p = this.this$0.mBgTransition;
        if (access$getMBgTransition$p != null) {
            access$getMBgTransition$p.resetTransition();
        }
        this.$next.invoke();
        SchulteTableGameView access$getMGameView$p = this.this$0.mGameView;
        if (access$getMGameView$p != null) {
            access$getMGameView$p.destroy();
        }
        SchulteTablePluginView schulteTablePluginView = this.this$0;
        SchulteTableGameView access$getMGameView$p2 = schulteTablePluginView.mGameView;
        schulteTablePluginView.removeSceneView((View) (access$getMGameView$p2 == null ? null : access$getMGameView$p2.getMRootView()));
    }
}
