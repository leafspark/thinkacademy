package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundRelativeLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.shop.R;

public final class BusShopDialogChooseStudentBinding implements ViewBinding {
    public final ImageView ivClose;
    public final RecyclerView recyclerView;
    public final TextView rlTip;
    public final RelativeLayout rlTitle;
    private final RelativeLayout rootView;
    public final RoundRelativeLayout rvBg;
    public final RoundTextView tvAddStudent;
    public final RoundTextView tvContinue;
    public final RoundTextView tvMatchContinue;

    private BusShopDialogChooseStudentBinding(RelativeLayout relativeLayout, ImageView imageView, RecyclerView recyclerView2, TextView textView, RelativeLayout relativeLayout2, RoundRelativeLayout roundRelativeLayout, RoundTextView roundTextView, RoundTextView roundTextView2, RoundTextView roundTextView3) {
        this.rootView = relativeLayout;
        this.ivClose = imageView;
        this.recyclerView = recyclerView2;
        this.rlTip = textView;
        this.rlTitle = relativeLayout2;
        this.rvBg = roundRelativeLayout;
        this.tvAddStudent = roundTextView;
        this.tvContinue = roundTextView2;
        this.tvMatchContinue = roundTextView3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BusShopDialogChooseStudentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BusShopDialogChooseStudentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.bus_shop_dialog_choose_student;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.tvAddStudent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.tvContinue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.tvMatchContinue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.recyclerView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.rvBg;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogChooseStudentBinding bind(android.view.View r12) {
        /*
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.ivClose
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.recyclerView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r5 = r1
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            if (r5 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.rlTip
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.rlTitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r7 = r1
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7
            if (r7 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.rvBg
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r8 = r1
            com.flyco.roundview.RoundRelativeLayout r8 = (com.flyco.roundview.RoundRelativeLayout) r8
            if (r8 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.tvAddStudent
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r9 = r1
            com.flyco.roundview.RoundTextView r9 = (com.flyco.roundview.RoundTextView) r9
            if (r9 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.tvContinue
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r10 = r1
            com.flyco.roundview.RoundTextView r10 = (com.flyco.roundview.RoundTextView) r10
            if (r10 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.tvMatchContinue
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            com.flyco.roundview.RoundTextView r11 = (com.flyco.roundview.RoundTextView) r11
            if (r11 == 0) goto L_0x0062
            com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogChooseStudentBinding r0 = new com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogChooseStudentBinding
            r3 = r12
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x0062:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogChooseStudentBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogChooseStudentBinding");
    }
}
