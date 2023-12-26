package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LayoutWrongAnswerHighestPadBinding implements ViewBinding {
    public final ImageView ivResultClose;
    public final ImageView ivResultWrongCoins;
    private final ConstraintLayout rootView;
    public final TextView tvResultWrongCoins;
    public final View viewResultWrong;
    public final View viewResultWrongCoins;
    public final View viewResultWrongInner;

    private LayoutWrongAnswerHighestPadBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, View view, View view2, View view3) {
        this.rootView = constraintLayout;
        this.ivResultClose = imageView;
        this.ivResultWrongCoins = imageView2;
        this.tvResultWrongCoins = textView;
        this.viewResultWrong = view;
        this.viewResultWrongCoins = view2;
        this.viewResultWrongInner = view3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutWrongAnswerHighestPadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutWrongAnswerHighestPadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_wrong_answer_highest_pad;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.view_result_wrong_inner;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.view_result_wrong;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.view_result_wrong_coins;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LayoutWrongAnswerHighestPadBinding bind(android.view.View r10) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_result_close
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0043
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_result_wrong_coins
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0043
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_result_wrong_coins
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0043
            int r0 = com.tal.app.thinkacademy.live.business.R.id.view_result_wrong
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            if (r7 == 0) goto L_0x0043
            int r0 = com.tal.app.thinkacademy.live.business.R.id.view_result_wrong_coins
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            if (r8 == 0) goto L_0x0043
            int r0 = com.tal.app.thinkacademy.live.business.R.id.view_result_wrong_inner
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            if (r9 == 0) goto L_0x0043
            com.tal.app.thinkacademy.live.business.databinding.LayoutWrongAnswerHighestPadBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LayoutWrongAnswerHighestPadBinding
            r3 = r10
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r0
        L_0x0043:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r10 = r1.concat(r10)
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LayoutWrongAnswerHighestPadBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LayoutWrongAnswerHighestPadBinding");
    }
}
