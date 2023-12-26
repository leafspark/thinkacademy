package com.tal.app.thinkacademy.live.business.bulletscreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tal.app.thinkacademy.common.widget.HwPagView;
import com.tal.app.thinkacademy.live.business.databinding.LiveBusinessBulletScreenBinding;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseVBLivePluginView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ \u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0006\u0010\u0011\u001a\u00020\bJ\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/bulletscreen/BulletScreenView;", "Lcom/tal/app/thinkacademy/live/core/plugin/pluginview/BaseVBLivePluginView;", "Lcom/tal/app/thinkacademy/live/business/databinding/LiveBusinessBulletScreenBinding;", "Lcom/tal/app/thinkacademy/common/widget/HwPagView$PagAnimatorListener;", "context", "Landroid/content/Context;", "callback", "Lkotlin/Function0;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "createViewBinding", "inflater", "Landroid/view/LayoutInflater;", "group", "Landroid/view/ViewGroup;", "attach", "", "destroy", "onAnimationEnd", "p0", "Lorg/libpag/PAGView;", "play", "resId", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BulletScreenView.kt */
public final class BulletScreenView extends BaseVBLivePluginView<LiveBusinessBulletScreenBinding> implements HwPagView.PagAnimatorListener {
    private final Function0<Unit> callback;

    public void onAnimationCancel(PAGView pAGView) {
        HwPagView.PagAnimatorListener.DefaultImpls.onAnimationCancel(this, pAGView);
    }

    public void onAnimationRepeat(PAGView pAGView) {
        HwPagView.PagAnimatorListener.DefaultImpls.onAnimationRepeat(this, pAGView);
    }

    public void onAnimationStart(PAGView pAGView) {
        HwPagView.PagAnimatorListener.DefaultImpls.onAnimationStart(this, pAGView);
    }

    public void onAnimationUpdate(PAGView pAGView) {
        HwPagView.PagAnimatorListener.DefaultImpls.onAnimationUpdate(this, pAGView);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BulletScreenView(Context context, Function0<Unit> function0) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.callback = function0;
        this.mBinding.pagBullet.addListener((PAGView.PAGViewListener) this);
        this.mBinding.pagBullet.setClickable(true);
    }

    public final void play(String str) {
        Intrinsics.checkNotNullParameter(str, "resId");
        HwPagView hwPagView = this.mBinding.pagBullet;
        hwPagView.playWithSound("pags/" + str + ".pag");
    }

    public final void destroy() {
        this.mBinding.pagBullet.pause();
        this.mBinding.pagBullet.removeListener((PAGView.PAGViewListener) this);
    }

    /* access modifiers changed from: protected */
    public LiveBusinessBulletScreenBinding createViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "group");
        LiveBusinessBulletScreenBinding inflate = LiveBusinessBulletScreenBinding.inflate(layoutInflater, viewGroup, z);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, group, attach)");
        return inflate;
    }

    public void onAnimationEnd(PAGView pAGView) {
        Function0<Unit> function0 = this.callback;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
