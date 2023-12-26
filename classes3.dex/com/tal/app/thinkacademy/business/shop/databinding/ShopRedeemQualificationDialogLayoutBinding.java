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

public final class ShopRedeemQualificationDialogLayoutBinding implements ViewBinding {
    public final RoundTextView btnApply;
    public final ImageView dialogClose;
    public final TextView dialogTitle;
    public final RoundRelativeLayout editLayout;
    public final TextView idDesc;
    public final TextView idDescTitle;
    public final EditText redeemEdit;
    private final ConstraintLayout rootView;

    private ShopRedeemQualificationDialogLayoutBinding(ConstraintLayout constraintLayout, RoundTextView roundTextView, ImageView imageView, TextView textView, RoundRelativeLayout roundRelativeLayout, TextView textView2, TextView textView3, EditText editText) {
        this.rootView = constraintLayout;
        this.btnApply = roundTextView;
        this.dialogClose = imageView;
        this.dialogTitle = textView;
        this.editLayout = roundRelativeLayout;
        this.idDesc = textView2;
        this.idDescTitle = textView3;
        this.redeemEdit = editText;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ShopRedeemQualificationDialogLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ShopRedeemQualificationDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.shop_redeem_qualification_dialog_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.edit_layout;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.ShopRedeemQualificationDialogLayoutBinding bind(android.view.View r11) {
        /*
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.btn_apply
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            com.flyco.roundview.RoundTextView r4 = (com.flyco.roundview.RoundTextView) r4
            if (r4 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.dialog_close
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.dialog_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.edit_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            com.flyco.roundview.RoundRelativeLayout r7 = (com.flyco.roundview.RoundRelativeLayout) r7
            if (r7 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.id_desc
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.id_desc_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.redeem_edit
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r10 = r1
            android.widget.EditText r10 = (android.widget.EditText) r10
            if (r10 == 0) goto L_0x0057
            com.tal.app.thinkacademy.business.shop.databinding.ShopRedeemQualificationDialogLayoutBinding r0 = new com.tal.app.thinkacademy.business.shop.databinding.ShopRedeemQualificationDialogLayoutBinding
            r3 = r11
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0057:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.ShopRedeemQualificationDialogLayoutBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.ShopRedeemQualificationDialogLayoutBinding");
    }
}
