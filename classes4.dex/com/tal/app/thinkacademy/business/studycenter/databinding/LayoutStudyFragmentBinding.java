package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;

public final class LayoutStudyFragmentBinding implements ViewBinding {
    public final FrameLayout fragment;
    public final ImageView ivTimeZoneClose;
    public final LinearLayout layoutLogin;
    public final LinearLayout llSchoolMars;
    public final LinearLayout llTimeZoneTip;
    public final LoadStatusView loadStatusView;
    public final RelativeLayout rlLive;
    public final RelativeLayout rlRecorded;
    private final LinearLayout rootView;
    public final View statusBarView;
    public final View studyFragmentTop;
    public final ConstraintLayout studyRootCl;
    public final LinearLayout studyTab;
    public final TextView tvLive;
    public final TextView tvLogin;
    public final TextView tvRecorded;
    public final TextView tvTimeZone;

    private LayoutStudyFragmentBinding(LinearLayout linearLayout, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LoadStatusView loadStatusView2, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, View view, View view2, ConstraintLayout constraintLayout, LinearLayout linearLayout5, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.fragment = frameLayout;
        this.ivTimeZoneClose = imageView;
        this.layoutLogin = linearLayout2;
        this.llSchoolMars = linearLayout3;
        this.llTimeZoneTip = linearLayout4;
        this.loadStatusView = loadStatusView2;
        this.rlLive = relativeLayout;
        this.rlRecorded = relativeLayout2;
        this.statusBarView = view;
        this.studyFragmentTop = view2;
        this.studyRootCl = constraintLayout;
        this.studyTab = linearLayout5;
        this.tvLive = textView;
        this.tvLogin = textView2;
        this.tvRecorded = textView3;
        this.tvTimeZone = textView4;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutStudyFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutStudyFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_study_fragment;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.loadStatusView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005a, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.status_bar_view;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0062, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.studyFragmentTop;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006a, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.study_root_cl;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.LayoutStudyFragmentBinding bind(android.view.View r21) {
        /*
            r0 = r21
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.fragment
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            if (r5 == 0) goto L_0x00bb
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.ivTimeZoneClose
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x00bb
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_login
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x00bb
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.llSchoolMars
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x00bb
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.llTimeZoneTip
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            if (r9 == 0) goto L_0x00bb
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.loadStatusView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r10 = (com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView) r10
            if (r10 == 0) goto L_0x00bb
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.rlLive
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            if (r11 == 0) goto L_0x00bb
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.rlRecorded
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            if (r12 == 0) goto L_0x00bb
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.status_bar_view
            android.view.View r13 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r13 == 0) goto L_0x00bb
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.studyFragmentTop
            android.view.View r14 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r14 == 0) goto L_0x00bb
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.study_root_cl
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            androidx.constraintlayout.widget.ConstraintLayout r15 = (androidx.constraintlayout.widget.ConstraintLayout) r15
            if (r15 == 0) goto L_0x00bb
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.studyTab
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.LinearLayout r16 = (android.widget.LinearLayout) r16
            if (r16 == 0) goto L_0x00bb
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvLive
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00bb
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_login
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00bb
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvRecorded
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00bb
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tvTimeZone
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00bb
            com.tal.app.thinkacademy.business.studycenter.databinding.LayoutStudyFragmentBinding r1 = new com.tal.app.thinkacademy.business.studycenter.databinding.LayoutStudyFragmentBinding
            r3 = r1
            r4 = r0
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r1
        L_0x00bb:
            android.content.res.Resources r0 = r21.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.LayoutStudyFragmentBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.LayoutStudyFragmentBinding");
    }
}
