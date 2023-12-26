package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.shop.R;

public final class ShopRedeemSuccessDialogLayoutBinding implements ViewBinding {
    public final RoundTextView btnGotoContinue;
    public final ImageView dialogClose;
    public final FrameLayout dialogRecommendBg;
    public final TextView dialogTitle;
    public final ImageView difficulty1;
    public final ImageView difficulty2;
    public final ImageView difficulty3;
    public final ImageView difficulty4;
    public final ImageView difficulty5;
    public final TextView difficultyText;
    public final TextView levelDegreeName;
    public final ImageView recommendIcon;
    public final RoundTextView recommendText;
    public final TextView redeemDesc;
    private final ConstraintLayout rootView;

    private ShopRedeemSuccessDialogLayoutBinding(ConstraintLayout constraintLayout, RoundTextView roundTextView, ImageView imageView, FrameLayout frameLayout, TextView textView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView2, TextView textView3, ImageView imageView7, RoundTextView roundTextView2, TextView textView4) {
        this.rootView = constraintLayout;
        this.btnGotoContinue = roundTextView;
        this.dialogClose = imageView;
        this.dialogRecommendBg = frameLayout;
        this.dialogTitle = textView;
        this.difficulty1 = imageView2;
        this.difficulty2 = imageView3;
        this.difficulty3 = imageView4;
        this.difficulty4 = imageView5;
        this.difficulty5 = imageView6;
        this.difficultyText = textView2;
        this.levelDegreeName = textView3;
        this.recommendIcon = imageView7;
        this.recommendText = roundTextView2;
        this.redeemDesc = textView4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ShopRedeemSuccessDialogLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ShopRedeemSuccessDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.shop_redeem_success_dialog_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.recommend_text;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.ShopRedeemSuccessDialogLayoutBinding bind(android.view.View r19) {
        /*
            r0 = r19
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.btn_goto_continue
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.flyco.roundview.RoundTextView r5 = (com.flyco.roundview.RoundTextView) r5
            if (r5 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.dialog_close
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.dialog_recommend_bg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.FrameLayout r7 = (android.widget.FrameLayout) r7
            if (r7 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.dialog_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.difficulty_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.difficulty_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.difficulty_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.difficulty_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.difficulty_5
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.difficulty_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.level_degree_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.recommend_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.ImageView r16 = (android.widget.ImageView) r16
            if (r16 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.recommend_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            com.flyco.roundview.RoundTextView r17 = (com.flyco.roundview.RoundTextView) r17
            if (r17 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.redeem_desc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00a9
            com.tal.app.thinkacademy.business.shop.databinding.ShopRedeemSuccessDialogLayoutBinding r1 = new com.tal.app.thinkacademy.business.shop.databinding.ShopRedeemSuccessDialogLayoutBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r1
        L_0x00a9:
            android.content.res.Resources r0 = r19.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.ShopRedeemSuccessDialogLayoutBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.ShopRedeemSuccessDialogLayoutBinding");
    }
}
