package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;

public final class ActivityMyAccountBinding implements ViewBinding {
    public final ImageView ivAvatar;
    public final ConstraintLayout layoutCard;
    public final LinearLayout layoutList;
    public final LoadStatusView loadStatusView;
    private final ConstraintLayout rootView;
    public final RecyclerView rvAccount;
    public final TitleBar titleBarAccount;
    public final TextView tvAccountTip;
    public final RoundTextView tvAdd;
    public final TextView tvCard;
    public final RoundTextView tvCopy;
    public final TextView tvNickname;
    public final TextView tvSubtitle;

    private ActivityMyAccountBinding(ConstraintLayout constraintLayout, ImageView imageView, ConstraintLayout constraintLayout2, LinearLayout linearLayout, LoadStatusView loadStatusView2, RecyclerView recyclerView, TitleBar titleBar, TextView textView, RoundTextView roundTextView, TextView textView2, RoundTextView roundTextView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.ivAvatar = imageView;
        this.layoutCard = constraintLayout2;
        this.layoutList = linearLayout;
        this.loadStatusView = loadStatusView2;
        this.rvAccount = recyclerView;
        this.titleBarAccount = titleBar;
        this.tvAccountTip = textView;
        this.tvAdd = roundTextView;
        this.tvCard = textView2;
        this.tvCopy = roundTextView2;
        this.tvNickname = textView3;
        this.tvSubtitle = textView4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMyAccountBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityMyAccountBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_my_account;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.titleBar_account;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.tv_add;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.tv_copy;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.layout_card;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.rv_account;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.ActivityMyAccountBinding bind(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_avatar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_card
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_list
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.business.login.R.id.loadStatusView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r8 = (com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView) r8
            if (r8 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.business.login.R.id.rv_account
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.recyclerview.widget.RecyclerView r9 = (androidx.recyclerview.widget.RecyclerView) r9
            if (r9 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.business.login.R.id.titleBar_account
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r10 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r10
            if (r10 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_account_tip
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_add
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            com.flyco.roundview.RoundTextView r12 = (com.flyco.roundview.RoundTextView) r12
            if (r12 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_card
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_copy
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            com.flyco.roundview.RoundTextView r14 = (com.flyco.roundview.RoundTextView) r14
            if (r14 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_nickname
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_subtitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x0091
            com.tal.app.thinkacademy.business.login.databinding.ActivityMyAccountBinding r1 = new com.tal.app.thinkacademy.business.login.databinding.ActivityMyAccountBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.ActivityMyAccountBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.ActivityMyAccountBinding");
    }
}
