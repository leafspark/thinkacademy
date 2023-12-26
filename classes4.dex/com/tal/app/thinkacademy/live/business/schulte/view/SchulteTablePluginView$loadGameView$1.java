package com.tal.app.thinkacademy.live.business.schulte.view;

import android.graphics.drawable.TransitionDrawable;
import android.media.MediaPlayer;
import android.view.View;
import com.tal.app.thinkacademy.lib.entity.AppNetWorkConfigRemoteInfo;
import com.tal.app.thinkacademy.live.business.schulte.api.ISceneChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTablePluginView.kt */
final class SchulteTablePluginView$loadGameView$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SchulteTablePluginView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SchulteTablePluginView$loadGameView$1(SchulteTablePluginView schulteTablePluginView) {
        super(0);
        this.this$0 = schulteTablePluginView;
    }

    public final void invoke() {
        SchulteTablePluginView.hideBaseView$default(this.this$0, (Function0) null, 1, (Object) null);
        SchulteTablePluginView schulteTablePluginView = this.this$0;
        SchulteTableGameView access$getMGameView$p = schulteTablePluginView.mGameView;
        schulteTablePluginView.addSceneView((View) (access$getMGameView$p == null ? null : access$getMGameView$p.getMRootView()));
        SchulteTableGameView access$getMGameView$p2 = this.this$0.mGameView;
        if (access$getMGameView$p2 != null) {
            ISceneChange.DefaultImpls.show$default(access$getMGameView$p2, (Function0) null, 1, (Object) null);
        }
        MediaPlayer access$getMPlayerBgm$p = this.this$0.mPlayerBgm;
        if (access$getMPlayerBgm$p != null) {
            access$getMPlayerBgm$p.start();
        }
        TransitionDrawable access$getMBgTransition$p = this.this$0.mBgTransition;
        if (access$getMBgTransition$p != null) {
            access$getMBgTransition$p.startTransition(AppNetWorkConfigRemoteInfo.MAX_TIME_OUT);
        }
    }
}
