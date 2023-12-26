package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.shop.R;

public final class ShopTakeAdmissionDialogLayoutBinding implements ViewBinding {
    public final ImageView dialogClose;
    public final TextView dialogTitle;
    public final RoundTextView reminderBtnLeft;
    public final RoundTextView reminderBtnRight;
    private final ConstraintLayout rootView;
    public final TextView takeAdmissionText;
    public final TextView takeAdmissionTipInfo;

    private ShopTakeAdmissionDialogLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, RoundTextView roundTextView, RoundTextView roundTextView2, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.dialogClose = imageView;
        this.dialogTitle = textView;
        this.reminderBtnLeft = roundTextView;
        this.reminderBtnRight = roundTextView2;
        this.takeAdmissionText = textView2;
        this.takeAdmissionTipInfo = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ShopTakeAdmissionDialogLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ShopTakeAdmissionDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.shop_take_admission_dialog_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.reminder_btn_left;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.reminder_btn_right;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.ShopTakeAdmissionDialogLayoutBinding bind(android.view.View r10) {
        /*
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.dialog_close
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.dialog_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.reminder_btn_left
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r6 = r1
            com.flyco.roundview.RoundTextView r6 = (com.flyco.roundview.RoundTextView) r6
            if (r6 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.reminder_btn_right
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r7 = r1
            com.flyco.roundview.RoundTextView r7 = (com.flyco.roundview.RoundTextView) r7
            if (r7 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.take_admission_text
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.take_admission_tip_info
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x004c
            com.tal.app.thinkacademy.business.shop.databinding.ShopTakeAdmissionDialogLayoutBinding r0 = new com.tal.app.thinkacademy.business.shop.databinding.ShopTakeAdmissionDialogLayoutBinding
            r3 = r10
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r0
        L_0x004c:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r10 = r1.concat(r10)
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.ShopTakeAdmissionDialogLayoutBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.ShopTakeAdmissionDialogLayoutBinding");
    }
}
