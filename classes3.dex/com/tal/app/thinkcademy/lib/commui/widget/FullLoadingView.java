package com.tal.app.thinkcademy.lib.commui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.commui.R;
import com.tal.app.thinkacademy.lib.commui.widget.ArcLoadingView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u000eJ\b\u0010\u0012\u001a\u00020\u000eH\u0002J\u0006\u0010\u0013\u001a\u00020\u000eJ\u0010\u0010\u0014\u001a\u00020\u000e2\b\b\u0001\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkcademy/lib/commui/widget/FullLoadingView;", "", "mContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "img_loading", "Lcom/tal/app/thinkacademy/lib/commui/widget/ArcLoadingView;", "layout", "Landroid/view/View;", "loadAnimation", "Landroid/view/animation/Animation;", "param", "Landroid/widget/FrameLayout$LayoutParams;", "addView", "", "viewGroup", "Landroid/view/ViewGroup;", "dismissView", "initLoadView", "loadAnimLayout", "setBackgroundColor", "colorId", "", "startAnimation", "stopAnimation", "lib_commui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FullLoadingView.kt */
public final class FullLoadingView {
    private ArcLoadingView img_loading;
    private View layout;
    private Animation loadAnimation;
    private final Context mContext;
    private FrameLayout.LayoutParams param;

    public FullLoadingView(Context context) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
    }

    private final void initLoadView() {
        View view = this.layout;
        ArcLoadingView arcLoadingView = null;
        if (view == null) {
            LayoutInflater from = LayoutInflater.from(this.mContext);
            int i = R.layout.full_loading_view;
            view = !(from instanceof LayoutInflater) ? from.inflate(i, (ViewGroup) null) : XMLParseInstrumentation.inflate(from, i, (ViewGroup) null);
        }
        this.layout = view;
        FrameLayout.LayoutParams layoutParams = this.param;
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        }
        this.param = layoutParams;
        ArcLoadingView arcLoadingView2 = this.img_loading;
        if (arcLoadingView2 == null) {
            View view2 = this.layout;
            if (view2 != null) {
                arcLoadingView = view2.findViewById(R.id.img_loading);
            }
        } else {
            arcLoadingView = arcLoadingView2;
        }
        this.img_loading = arcLoadingView;
        View view3 = this.layout;
        if (view3 != null) {
            view3.setVisibility(8);
        }
    }

    public final void addView(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        initLoadView();
        View view = this.layout;
        if ((view == null ? null : view.getParent()) != viewGroup) {
            viewGroup.addView(this.layout, this.param);
        }
    }

    public final void loadAnimLayout() {
        View view;
        startAnimation();
        View view2 = this.layout;
        if (!(view2 != null && view2.getVisibility() == 0) && (view = this.layout) != null) {
            view.setVisibility(0);
        }
        ArcLoadingView arcLoadingView = this.img_loading;
        if (arcLoadingView != null) {
            arcLoadingView.setVisibility(0);
        }
    }

    private final void stopAnimation() {
        ArcLoadingView arcLoadingView = this.img_loading;
        if (arcLoadingView != null) {
            arcLoadingView.clearAnimation();
        }
    }

    private final void startAnimation() {
        Animation animation = this.loadAnimation;
        if (animation == null) {
            animation = AnimationUtils.loadAnimation(this.mContext, R.anim.loading_animation);
        }
        this.loadAnimation = animation;
        ArcLoadingView arcLoadingView = this.img_loading;
        if (arcLoadingView != null) {
            arcLoadingView.startAnimation(animation);
        }
    }

    public final void dismissView() {
        View view = this.layout;
        if (view != null) {
            boolean z = false;
            if (view != null && view.getVisibility() == 0) {
                z = true;
            }
            if (z) {
                stopAnimation();
                View view2 = this.layout;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            }
        }
    }

    public final void setBackgroundColor(int i) {
        View view = this.layout;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }
}
