package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundRelativeLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.shop.R;

public final class ShopBindEmailDialogLayoutBinding implements ViewBinding {
    public final TextView btnConfirm;
    public final ImageView dialogBack;
    public final ImageView dialogClose;
    public final TextView dialogSubTitle;
    public final TextView dialogTitle;
    public final RoundRelativeLayout editLayout;
    public final TextView linkNumberTips;
    public final EditText phoneEdit;
    private final ConstraintLayout rootView;
    public final RoundTextView sendCode;

    private ShopBindEmailDialogLayoutBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2, TextView textView3, RoundRelativeLayout roundRelativeLayout, TextView textView4, EditText editText, RoundTextView roundTextView) {
        this.rootView = constraintLayout;
        this.btnConfirm = textView;
        this.dialogBack = imageView;
        this.dialogClose = imageView2;
        this.dialogSubTitle = textView2;
        this.dialogTitle = textView3;
        this.editLayout = roundRelativeLayout;
        this.linkNumberTips = textView4;
        this.phoneEdit = editText;
        this.sendCode = roundTextView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ShopBindEmailDialogLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ShopBindEmailDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.shop_bind_email_dialog_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.edit_layout;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.send_code;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.ShopBindEmailDialogLayoutBinding bind(android.view.View r13) {
        /*
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.btn_confirm
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.dialog_back
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.dialog_close
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.dialog_sub_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.dialog_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.edit_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            com.flyco.roundview.RoundRelativeLayout r9 = (com.flyco.roundview.RoundRelativeLayout) r9
            if (r9 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.link_number_tips
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.phone_edit
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            android.widget.EditText r11 = (android.widget.EditText) r11
            if (r11 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.send_code
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r12 = r1
            com.flyco.roundview.RoundTextView r12 = (com.flyco.roundview.RoundTextView) r12
            if (r12 == 0) goto L_0x006d
            com.tal.app.thinkacademy.business.shop.databinding.ShopBindEmailDialogLayoutBinding r0 = new com.tal.app.thinkacademy.business.shop.databinding.ShopBindEmailDialogLayoutBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.ShopBindEmailDialogLayoutBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.ShopBindEmailDialogLayoutBinding");
    }
}
