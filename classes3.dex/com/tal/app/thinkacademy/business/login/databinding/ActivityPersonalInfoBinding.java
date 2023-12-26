package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;

public final class ActivityPersonalInfoBinding implements ViewBinding {
    public final TextView contactDesc;
    public final LinearLayout contactInfoLayout;
    public final ClearEditText etNameOne;
    public final ClearEditText etNameTwo;
    public final ClearEditText etNickname;
    public final ImageView ivUser;
    public final ImageView ivWarning;
    public final LinearLayout layoutGrade;
    public final LinearLayout layoutGroup;
    public final LinearLayout layoutName;
    public final ConstraintLayout personalHeadLayout;
    public final TitleBar personalTitleBar;
    private final ConstraintLayout rootView;
    public final LoadStatusView statusLoading;
    public final TextView tvGrade;
    public final TextView tvNameOne;
    public final TextView tvNameTwo;
    public final TextView tvSave;
    public final TextView tvWarning;

    private ActivityPersonalInfoBinding(ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout, ClearEditText clearEditText, ClearEditText clearEditText2, ClearEditText clearEditText3, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ConstraintLayout constraintLayout2, TitleBar titleBar, LoadStatusView loadStatusView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.contactDesc = textView;
        this.contactInfoLayout = linearLayout;
        this.etNameOne = clearEditText;
        this.etNameTwo = clearEditText2;
        this.etNickname = clearEditText3;
        this.ivUser = imageView;
        this.ivWarning = imageView2;
        this.layoutGrade = linearLayout2;
        this.layoutGroup = linearLayout3;
        this.layoutName = linearLayout4;
        this.personalHeadLayout = constraintLayout2;
        this.personalTitleBar = titleBar;
        this.statusLoading = loadStatusView;
        this.tvGrade = textView2;
        this.tvNameOne = textView3;
        this.tvNameTwo = textView4;
        this.tvSave = textView5;
        this.tvWarning = textView6;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPersonalInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityPersonalInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_personal_info;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.personalHeadLayout;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.personal_titleBar;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.ActivityPersonalInfoBinding bind(android.view.View r23) {
        /*
            r0 = r23
            int r1 = com.tal.app.thinkacademy.business.login.R.id.contact_desc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.login.R.id.contact_info_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.login.R.id.etNameOne
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r7 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r7
            if (r7 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.login.R.id.etNameTwo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r8 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r8
            if (r8 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.login.R.id.et_nickname
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r9 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r9
            if (r9 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_user
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_warning
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layoutGrade
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            if (r12 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layoutGroup
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            if (r13 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            if (r14 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.login.R.id.personalHeadLayout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            androidx.constraintlayout.widget.ConstraintLayout r15 = (androidx.constraintlayout.widget.ConstraintLayout) r15
            if (r15 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.login.R.id.personal_titleBar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r16 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r16
            if (r16 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.login.R.id.statusLoading
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r17 = (com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView) r17
            if (r17 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_grade
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tvNameOne
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tvNameTwo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_save
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x00d9
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_warning
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x00d9
            com.tal.app.thinkacademy.business.login.databinding.ActivityPersonalInfoBinding r1 = new com.tal.app.thinkacademy.business.login.databinding.ActivityPersonalInfoBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.ActivityPersonalInfoBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.ActivityPersonalInfoBinding");
    }
}
