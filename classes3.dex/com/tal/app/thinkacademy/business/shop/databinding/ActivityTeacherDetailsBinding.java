package com.tal.app.thinkacademy.business.shop.databinding;

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
import com.flyco.roundview.RoundLinearLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.widget.view.AutoLineFeedLayout;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;

public final class ActivityTeacherDetailsBinding implements ViewBinding {
    public final AppBarLayout appBarLayout;
    public final AutoLineFeedLayout autoLineFeedLayout;
    public final LinearLayout headerLabel;
    public final RoundLinearLayout headerLabelInOne;
    public final RoundLinearLayout headerLabelInTwo;
    public final LinearLayout headerLabelOne;
    public final TextView headerLabelTvOne;
    public final TextView headerLabelTvTwo;
    public final LinearLayout headerLabelTwo;
    public final LinearLayout headerView;
    public final ImageView ivTeacherAv;
    public final ImageView ivTeacherAvBg;
    public final LoadStatusView loadStatusView;
    public final RecyclerView recycleView;
    private final ConstraintLayout rootView;
    public final TitleBar titleView;
    public final TextView tvTeacherIdentity;
    public final TextView tvTeacherName;
    public final TextView tvTeacherSchool;

    private ActivityTeacherDetailsBinding(ConstraintLayout constraintLayout, AppBarLayout appBarLayout2, AutoLineFeedLayout autoLineFeedLayout2, LinearLayout linearLayout, RoundLinearLayout roundLinearLayout, RoundLinearLayout roundLinearLayout2, LinearLayout linearLayout2, TextView textView, TextView textView2, LinearLayout linearLayout3, LinearLayout linearLayout4, ImageView imageView, ImageView imageView2, LoadStatusView loadStatusView2, RecyclerView recyclerView, TitleBar titleBar, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.appBarLayout = appBarLayout2;
        this.autoLineFeedLayout = autoLineFeedLayout2;
        this.headerLabel = linearLayout;
        this.headerLabelInOne = roundLinearLayout;
        this.headerLabelInTwo = roundLinearLayout2;
        this.headerLabelOne = linearLayout2;
        this.headerLabelTvOne = textView;
        this.headerLabelTvTwo = textView2;
        this.headerLabelTwo = linearLayout3;
        this.headerView = linearLayout4;
        this.ivTeacherAv = imageView;
        this.ivTeacherAvBg = imageView2;
        this.loadStatusView = loadStatusView2;
        this.recycleView = recyclerView;
        this.titleView = titleBar;
        this.tvTeacherIdentity = textView3;
        this.tvTeacherName = textView4;
        this.tvTeacherSchool = textView5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTeacherDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTeacherDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_teacher_details;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.recycleView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009f, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.titleView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.headerLabelInOne;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.headerLabelInTwo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.ActivityTeacherDetailsBinding bind(android.view.View r23) {
        /*
            r0 = r23
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.appBarLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.google.android.material.appbar.AppBarLayout r5 = (com.google.android.material.appbar.AppBarLayout) r5
            if (r5 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.autoLineFeedLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.tal.app.thinkacademy.business.shop.widget.view.AutoLineFeedLayout r6 = (com.tal.app.thinkacademy.business.shop.widget.view.AutoLineFeedLayout) r6
            if (r6 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.headerLabel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.headerLabelInOne
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            com.flyco.roundview.RoundLinearLayout r8 = (com.flyco.roundview.RoundLinearLayout) r8
            if (r8 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.headerLabelInTwo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            com.flyco.roundview.RoundLinearLayout r9 = (com.flyco.roundview.RoundLinearLayout) r9
            if (r9 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.headerLabelOne
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            if (r10 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.headerLabelTvOne
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.headerLabelTvTwo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.headerLabelTwo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            if (r13 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.headerView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            if (r14 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.ivTeacherAv
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            if (r15 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.ivTeacherAvBg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.ImageView r16 = (android.widget.ImageView) r16
            if (r16 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.loadStatusView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r17 = (com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView) r17
            if (r17 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.recycleView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            androidx.recyclerview.widget.RecyclerView r18 = (androidx.recyclerview.widget.RecyclerView) r18
            if (r18 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.titleView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r19 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r19
            if (r19 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tvTeacherIdentity
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tvTeacherName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.tvTeacherSchool
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x00d9
            com.tal.app.thinkacademy.business.shop.databinding.ActivityTeacherDetailsBinding r1 = new com.tal.app.thinkacademy.business.shop.databinding.ActivityTeacherDetailsBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return r1
        L_0x00d9:
            android.content.res.Resources r0 = r23.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.ActivityTeacherDetailsBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.ActivityTeacherDetailsBinding");
    }
}
