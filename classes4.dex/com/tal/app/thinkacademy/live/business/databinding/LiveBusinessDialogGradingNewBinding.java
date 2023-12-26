package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessDialogGradingNewBinding implements ViewBinding {
    public final ImageView ivClose;
    public final RoundLinearLayout liveBusinessHomeworkLayoutTip;
    private final ConstraintLayout rootView;
    public final RoundTextView tvView;

    private LiveBusinessDialogGradingNewBinding(ConstraintLayout constraintLayout, ImageView imageView, RoundLinearLayout roundLinearLayout, RoundTextView roundTextView) {
        this.rootView = constraintLayout;
        this.ivClose = imageView;
        this.liveBusinessHomeworkLayoutTip = roundLinearLayout;
        this.tvView = roundTextView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessDialogGradingNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessDialogGradingNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_dialog_grading_new;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_homework_layout_tip;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.tv_view;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDialogGradingNewBinding bind(android.view.View r4) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_close
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0026
            int r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_homework_layout_tip
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            com.flyco.roundview.RoundLinearLayout r2 = (com.flyco.roundview.RoundLinearLayout) r2
            if (r2 == 0) goto L_0x0026
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_view
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            com.flyco.roundview.RoundTextView r3 = (com.flyco.roundview.RoundTextView) r3
            if (r3 == 0) goto L_0x0026
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDialogGradingNewBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDialogGradingNewBinding
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r0.<init>(r4, r1, r2, r3)
            return r0
        L_0x0026:
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDialogGradingNewBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDialogGradingNewBinding");
    }
}
