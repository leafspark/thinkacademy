package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundRelativeLayout;
import com.tal.app.thinkacademy.business.shop.R;

public final class ItemShopClassDetailStepsInfoBinding implements ViewBinding {
    public final View bottomLine;
    public final TextView faqDesc;
    public final RoundRelativeLayout infoLayout;
    public final ImageView infoNumber;
    public final TextView mainTitle;
    private final ConstraintLayout rootView;
    public final ImageView stepIcon;
    public final ConstraintLayout stepInfoRoot;
    public final TextView subTitle;
    public final View topLine;

    private ItemShopClassDetailStepsInfoBinding(ConstraintLayout constraintLayout, View view, TextView textView, RoundRelativeLayout roundRelativeLayout, ImageView imageView, TextView textView2, ImageView imageView2, ConstraintLayout constraintLayout2, TextView textView3, View view2) {
        this.rootView = constraintLayout;
        this.bottomLine = view;
        this.faqDesc = textView;
        this.infoLayout = roundRelativeLayout;
        this.infoNumber = imageView;
        this.mainTitle = textView2;
        this.stepIcon = imageView2;
        this.stepInfoRoot = constraintLayout2;
        this.subTitle = textView3;
        this.topLine = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemShopClassDetailStepsInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemShopClassDetailStepsInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_shop_class_detail_steps_info;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.top_line;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.info_layout;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.ItemShopClassDetailStepsInfoBinding bind(android.view.View r12) {
        /*
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.bottom_line
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r3 == 0) goto L_0x005d
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.faq_desc
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x005d
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.info_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r5 = r1
            com.flyco.roundview.RoundRelativeLayout r5 = (com.flyco.roundview.RoundRelativeLayout) r5
            if (r5 == 0) goto L_0x005d
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.info_number
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x005d
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.main_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x005d
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.step_icon
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x005d
            r9 = r12
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.sub_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x005d
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.top_line
            android.view.View r11 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r11 == 0) goto L_0x005d
            com.tal.app.thinkacademy.business.shop.databinding.ItemShopClassDetailStepsInfoBinding r12 = new com.tal.app.thinkacademy.business.shop.databinding.ItemShopClassDetailStepsInfoBinding
            r1 = r12
            r2 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r12
        L_0x005d:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.ItemShopClassDetailStepsInfoBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.ItemShopClassDetailStepsInfoBinding");
    }
}
