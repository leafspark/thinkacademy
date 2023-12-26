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

public final class ShopNotSupportActivityDialogLayoutBinding implements ViewBinding {
    public final ImageView dialogClose;
    public final TextView dialogTitle;
    public final RoundTextView notSupportBtn;
    public final TextView notSupportMsg;
    public final TextView notSupportTips;
    private final ConstraintLayout rootView;

    private ShopNotSupportActivityDialogLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, RoundTextView roundTextView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.dialogClose = imageView;
        this.dialogTitle = textView;
        this.notSupportBtn = roundTextView;
        this.notSupportMsg = textView2;
        this.notSupportTips = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ShopNotSupportActivityDialogLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ShopNotSupportActivityDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.shop_not_support_activity_dialog_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.not_support_btn;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.ShopNotSupportActivityDialogLayoutBinding bind(android.view.View r9) {
        /*
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.dialog_close
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.dialog_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.not_support_btn
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r6 = r1
            com.flyco.roundview.RoundTextView r6 = (com.flyco.roundview.RoundTextView) r6
            if (r6 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.not_support_msg
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.not_support_tips
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0041
            com.tal.app.thinkacademy.business.shop.databinding.ShopNotSupportActivityDialogLayoutBinding r0 = new com.tal.app.thinkacademy.business.shop.databinding.ShopNotSupportActivityDialogLayoutBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.ShopNotSupportActivityDialogLayoutBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.ShopNotSupportActivityDialogLayoutBinding");
    }
}
