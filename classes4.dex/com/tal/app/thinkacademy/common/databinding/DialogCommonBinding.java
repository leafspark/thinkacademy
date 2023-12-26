package com.tal.app.thinkacademy.common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.common.R;

public final class DialogCommonBinding implements ViewBinding {
    public final RoundTextView dialogCommonBtnCancel;
    public final TextView dialogCommonBtnConfirm;
    public final View dialogCommonBtnSpace;
    public final TextView dialogCommonMsg;
    public final TextView dialogCommonTitle;
    private final RelativeLayout rootView;

    private DialogCommonBinding(RelativeLayout relativeLayout, RoundTextView roundTextView, TextView textView, View view, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.dialogCommonBtnCancel = roundTextView;
        this.dialogCommonBtnConfirm = textView;
        this.dialogCommonBtnSpace = view;
        this.dialogCommonMsg = textView2;
        this.dialogCommonTitle = textView3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DialogCommonBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogCommonBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.dialog_common;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.common.R.id.dialog_common_btn_space;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.common.databinding.DialogCommonBinding bind(android.view.View r9) {
        /*
            int r0 = com.tal.app.thinkacademy.common.R.id.dialog_common_btn_cancel
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            com.flyco.roundview.RoundTextView r4 = (com.flyco.roundview.RoundTextView) r4
            if (r4 == 0) goto L_0x003e
            int r0 = com.tal.app.thinkacademy.common.R.id.dialog_common_btn_confirm
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x003e
            int r0 = com.tal.app.thinkacademy.common.R.id.dialog_common_btn_space
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r6 == 0) goto L_0x003e
            int r0 = com.tal.app.thinkacademy.common.R.id.dialog_common_msg
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x003e
            int r0 = com.tal.app.thinkacademy.common.R.id.dialog_common_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x003e
            com.tal.app.thinkacademy.common.databinding.DialogCommonBinding r0 = new com.tal.app.thinkacademy.common.databinding.DialogCommonBinding
            r3 = r9
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x003e:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.databinding.DialogCommonBinding.bind(android.view.View):com.tal.app.thinkacademy.common.databinding.DialogCommonBinding");
    }
}
