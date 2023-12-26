package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;

public final class ActivityBindEmailBinding implements ViewBinding {
    public final TextView emailNextBt;
    public final TextView emailPhoneTips;
    public final ClearEditText etEmail;
    public final Group groupWarning;
    public final ImageView ivWarning;
    public final TextView loginLogo;
    private final ConstraintLayout rootView;
    public final TextView tvDecs;
    public final RoundTextView tvSkip;
    public final TextView tvWarning;

    private ActivityBindEmailBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ClearEditText clearEditText, Group group, ImageView imageView, TextView textView3, TextView textView4, RoundTextView roundTextView, TextView textView5) {
        this.rootView = constraintLayout;
        this.emailNextBt = textView;
        this.emailPhoneTips = textView2;
        this.etEmail = clearEditText;
        this.groupWarning = group;
        this.ivWarning = imageView;
        this.loginLogo = textView3;
        this.tvDecs = textView4;
        this.tvSkip = roundTextView;
        this.tvWarning = textView5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBindEmailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityBindEmailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_bind_email;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        r0 = com.tal.app.thinkacademy.business.login.R.id.tv_skip;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.business.login.R.id.group_warning;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.ActivityBindEmailBinding bind(android.view.View r13) {
        /*
            int r0 = com.tal.app.thinkacademy.business.login.R.id.email_next_bt
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.business.login.R.id.email_phone_tips
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.business.login.R.id.et_email
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r6 = r1
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r6 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r6
            if (r6 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.business.login.R.id.group_warning
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r7 = r1
            androidx.constraintlayout.widget.Group r7 = (androidx.constraintlayout.widget.Group) r7
            if (r7 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.business.login.R.id.iv_warning
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.business.login.R.id.login_logo
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.business.login.R.id.tv_decs
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.business.login.R.id.tv_skip
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            com.flyco.roundview.RoundTextView r11 = (com.flyco.roundview.RoundTextView) r11
            if (r11 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.business.login.R.id.tv_warning
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x006d
            com.tal.app.thinkacademy.business.login.databinding.ActivityBindEmailBinding r0 = new com.tal.app.thinkacademy.business.login.databinding.ActivityBindEmailBinding
            r3 = r13
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L_0x006d:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.ActivityBindEmailBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.ActivityBindEmailBinding");
    }
}
