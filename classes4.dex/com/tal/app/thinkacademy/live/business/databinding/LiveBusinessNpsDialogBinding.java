package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.lib.commui.widget.MyEditText;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessNpsDialogBinding implements ViewBinding {
    public final RatingBar RatingBar;
    public final MyEditText etContent;
    public final RoundLinearLayout etLayout;
    public final ImageView ivCancel;
    public final ImageView ivEmoji;
    public final LinearLayout layout;
    public final LinearLayout layoutTip;
    private final ConstraintLayout rootView;
    public final RecyclerView rvTags;
    public final TextView tvAccountTip;
    public final TextView tvMsg;
    public final TextView tvSubmit;
    public final TextView tvTitle;

    private LiveBusinessNpsDialogBinding(ConstraintLayout constraintLayout, RatingBar ratingBar, MyEditText myEditText, RoundLinearLayout roundLinearLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.RatingBar = ratingBar;
        this.etContent = myEditText;
        this.etLayout = roundLinearLayout;
        this.ivCancel = imageView;
        this.ivEmoji = imageView2;
        this.layout = linearLayout;
        this.layoutTip = linearLayout2;
        this.rvTags = recyclerView;
        this.tvAccountTip = textView;
        this.tvMsg = textView2;
        this.tvSubmit = textView3;
        this.tvTitle = textView4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessNpsDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessNpsDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_nps_dialog;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.rv_tags;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.et_layout;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessNpsDialogBinding bind(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.tal.app.thinkacademy.live.business.R.id.RatingBar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.RatingBar r5 = (android.widget.RatingBar) r5
            if (r5 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.et_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.tal.app.thinkacademy.lib.commui.widget.MyEditText r6 = (com.tal.app.thinkacademy.lib.commui.widget.MyEditText) r6
            if (r6 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.et_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            com.flyco.roundview.RoundLinearLayout r7 = (com.flyco.roundview.RoundLinearLayout) r7
            if (r7 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_cancel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_emoji
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            if (r10 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.layout_tip
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rv_tags
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            androidx.recyclerview.widget.RecyclerView r12 = (androidx.recyclerview.widget.RecyclerView) r12
            if (r12 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_account_tip
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_msg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_submit
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x0091
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessNpsDialogBinding r1 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessNpsDialogBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r1
        L_0x0091:
            android.content.res.Resources r0 = r17.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessNpsDialogBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessNpsDialogBinding");
    }
}
