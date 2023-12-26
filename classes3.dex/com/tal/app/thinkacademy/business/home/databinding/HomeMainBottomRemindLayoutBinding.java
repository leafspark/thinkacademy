package com.tal.app.thinkacademy.business.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundRelativeLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.home.R;

public final class HomeMainBottomRemindLayoutBinding implements ViewBinding {
    public final RoundRelativeLayout classesToRemind;
    public final ImageView ivStartClassClose;
    private final RoundRelativeLayout rootView;
    public final ImageView startClassIvBg;
    public final RoundTextView tvOrder;
    public final RoundTextView tvStartClassEnter;
    public final TextView tvStartClassTitle;
    public final RoundTextView tvTime;

    private HomeMainBottomRemindLayoutBinding(RoundRelativeLayout roundRelativeLayout, RoundRelativeLayout roundRelativeLayout2, ImageView imageView, ImageView imageView2, RoundTextView roundTextView, RoundTextView roundTextView2, TextView textView, RoundTextView roundTextView3) {
        this.rootView = roundRelativeLayout;
        this.classesToRemind = roundRelativeLayout2;
        this.ivStartClassClose = imageView;
        this.startClassIvBg = imageView2;
        this.tvOrder = roundTextView;
        this.tvStartClassEnter = roundTextView2;
        this.tvStartClassTitle = textView;
        this.tvTime = roundTextView3;
    }

    public RoundRelativeLayout getRoot() {
        return this.rootView;
    }

    public static HomeMainBottomRemindLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static HomeMainBottomRemindLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.home_main_bottom_remind_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003a, code lost:
        r0 = com.tal.app.thinkacademy.business.home.R.id.tvTime;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        r0 = com.tal.app.thinkacademy.business.home.R.id.tvOrder;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        r0 = com.tal.app.thinkacademy.business.home.R.id.tvStartClassEnter;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.home.databinding.HomeMainBottomRemindLayoutBinding bind(android.view.View r9) {
        /*
            r2 = r9
            com.flyco.roundview.RoundRelativeLayout r2 = (com.flyco.roundview.RoundRelativeLayout) r2
            int r0 = com.tal.app.thinkacademy.business.home.R.id.ivStartClassClose
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r3 = r1
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            if (r3 == 0) goto L_0x004d
            int r0 = com.tal.app.thinkacademy.business.home.R.id.startClassIvBg
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x004d
            int r0 = com.tal.app.thinkacademy.business.home.R.id.tvOrder
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            com.flyco.roundview.RoundTextView r5 = (com.flyco.roundview.RoundTextView) r5
            if (r5 == 0) goto L_0x004d
            int r0 = com.tal.app.thinkacademy.business.home.R.id.tvStartClassEnter
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r6 = r1
            com.flyco.roundview.RoundTextView r6 = (com.flyco.roundview.RoundTextView) r6
            if (r6 == 0) goto L_0x004d
            int r0 = com.tal.app.thinkacademy.business.home.R.id.tvStartClassTitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x004d
            int r0 = com.tal.app.thinkacademy.business.home.R.id.tvTime
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            com.flyco.roundview.RoundTextView r8 = (com.flyco.roundview.RoundTextView) r8
            if (r8 == 0) goto L_0x004d
            com.tal.app.thinkacademy.business.home.databinding.HomeMainBottomRemindLayoutBinding r9 = new com.tal.app.thinkacademy.business.home.databinding.HomeMainBottomRemindLayoutBinding
            r0 = r9
            r1 = r2
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x004d:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.databinding.HomeMainBottomRemindLayoutBinding.bind(android.view.View):com.tal.app.thinkacademy.business.home.databinding.HomeMainBottomRemindLayoutBinding");
    }
}
