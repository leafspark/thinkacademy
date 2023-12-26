package com.tal.app.thinkacademy.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.common.R;

public final class DialogUpdateVersionBinding implements ViewBinding {
    public final Button btnUpdate;
    public final ConstraintLayout clUpdate;
    public final ImageView ivClose;
    public final ImageView ivUpdate;
    public final ImageView ivUpdateVersionBg;
    public final ProgressBar pbUpdateVersionProcess;
    private final ConstraintLayout rootView;
    public final TextView tvContent;
    public final TextView tvProcess;
    public final TextView tvUpdating;
    public final TextView tvVersionGray;
    public final TextView tvVersionNumber;
    public final Group updateGroup;

    private DialogUpdateVersionBinding(ConstraintLayout constraintLayout, Button button, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ProgressBar progressBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, Group group) {
        this.rootView = constraintLayout;
        this.btnUpdate = button;
        this.clUpdate = constraintLayout2;
        this.ivClose = imageView;
        this.ivUpdate = imageView2;
        this.ivUpdateVersionBg = imageView3;
        this.pbUpdateVersionProcess = progressBar;
        this.tvContent = textView;
        this.tvProcess = textView2;
        this.tvUpdating = textView3;
        this.tvVersionGray = textView4;
        this.tvVersionNumber = textView5;
        this.updateGroup = group;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogUpdateVersionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogUpdateVersionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.dialog_update_version;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        r1 = com.tal.app.thinkacademy.common.R.id.update_group;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.tal.app.thinkacademy.common.R.id.cl_update;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.common.databinding.DialogUpdateVersionBinding bind(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.tal.app.thinkacademy.common.R.id.btn_update
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.Button r5 = (android.widget.Button) r5
            if (r5 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.common.R.id.cl_update
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.common.R.id.iv_close
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.common.R.id.iv_update
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.common.R.id.iv_update_version_bg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.common.R.id.pb_update_version_process
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ProgressBar r10 = (android.widget.ProgressBar) r10
            if (r10 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.common.R.id.tv_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.common.R.id.tv_process
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.common.R.id.tv_updating
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.common.R.id.tv_version_gray
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.common.R.id.tv_version_number
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.common.R.id.update_group
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.constraintlayout.widget.Group r16 = (androidx.constraintlayout.widget.Group) r16
            if (r16 == 0) goto L_0x0091
            com.tal.app.thinkacademy.common.databinding.DialogUpdateVersionBinding r1 = new com.tal.app.thinkacademy.common.databinding.DialogUpdateVersionBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.databinding.DialogUpdateVersionBinding.bind(android.view.View):com.tal.app.thinkacademy.common.databinding.DialogUpdateVersionBinding");
    }
}
