package com.tal.app.thinkacademy.business.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.home.R;

public final class HomeDialogPaymentReminderBinding implements ViewBinding {
    public final RoundLinearLayout bgDialog;
    private final RelativeLayout rootView;
    public final RoundTextView tvCancel;
    public final TextView tvGo;
    public final TextView tvMessage;
    public final TextView tvTitle;

    private HomeDialogPaymentReminderBinding(RelativeLayout relativeLayout, RoundLinearLayout roundLinearLayout, RoundTextView roundTextView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.bgDialog = roundLinearLayout;
        this.tvCancel = roundTextView;
        this.tvGo = textView;
        this.tvMessage = textView2;
        this.tvTitle = textView3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static HomeDialogPaymentReminderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HomeDialogPaymentReminderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.home_dialog_payment_reminder;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.business.home.R.id.tv_cancel;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.home.databinding.HomeDialogPaymentReminderBinding bind(android.view.View r9) {
        /*
            int r0 = com.tal.app.thinkacademy.business.home.R.id.bg_dialog
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            com.flyco.roundview.RoundLinearLayout r4 = (com.flyco.roundview.RoundLinearLayout) r4
            if (r4 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.home.R.id.tv_cancel
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            com.flyco.roundview.RoundTextView r5 = (com.flyco.roundview.RoundTextView) r5
            if (r5 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.home.R.id.tv_go
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.home.R.id.tv_message
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.home.R.id.tv_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0041
            com.tal.app.thinkacademy.business.home.databinding.HomeDialogPaymentReminderBinding r0 = new com.tal.app.thinkacademy.business.home.databinding.HomeDialogPaymentReminderBinding
            r3 = r9
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.databinding.HomeDialogPaymentReminderBinding.bind(android.view.View):com.tal.app.thinkacademy.business.home.databinding.HomeDialogPaymentReminderBinding");
    }
}
