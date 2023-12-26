package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;

public final class ActivityChangeEmailBinding implements ViewBinding {
    public final ClearEditText etEmail;
    public final ImageView ivWarning;
    public final ConstraintLayout layoutTitle;
    public final TitleBar personalTitleBar;
    private final ConstraintLayout rootView;
    public final TextView tvSave;

    private ActivityChangeEmailBinding(ConstraintLayout constraintLayout, ClearEditText clearEditText, ImageView imageView, ConstraintLayout constraintLayout2, TitleBar titleBar, TextView textView) {
        this.rootView = constraintLayout;
        this.etEmail = clearEditText;
        this.ivWarning = imageView;
        this.layoutTitle = constraintLayout2;
        this.personalTitleBar = titleBar;
        this.tvSave = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityChangeEmailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityChangeEmailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_change_email;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.business.login.R.id.layout_title;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.business.login.R.id.personal_titleBar;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.ActivityChangeEmailBinding bind(android.view.View r9) {
        /*
            int r0 = com.tal.app.thinkacademy.business.login.R.id.et_email
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r4 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r4
            if (r4 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.login.R.id.iv_warning
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.login.R.id.layout_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r6 = r1
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.login.R.id.personal_titleBar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r7 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r7
            if (r7 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.login.R.id.tv_save
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0041
            com.tal.app.thinkacademy.business.login.databinding.ActivityChangeEmailBinding r0 = new com.tal.app.thinkacademy.business.login.databinding.ActivityChangeEmailBinding
            r3 = r9
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x0041:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.ActivityChangeEmailBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.ActivityChangeEmailBinding");
    }
}
