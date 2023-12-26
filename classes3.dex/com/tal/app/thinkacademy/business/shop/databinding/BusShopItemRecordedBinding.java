package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;

public final class BusShopItemRecordedBinding implements ViewBinding {
    public final ConstraintLayout cardClassInfo;
    public final ConstraintLayout layoutPrice;
    public final LinearLayout llTabel;
    private final ConstraintLayout rootView;
    public final TextView tvClassName;
    public final TextView tvDiscipline;
    public final TextView tvLessonsCount;
    public final TextView tvOrgPrice;
    public final TextView tvShowPrice;

    private BusShopItemRecordedBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.cardClassInfo = constraintLayout2;
        this.layoutPrice = constraintLayout3;
        this.llTabel = linearLayout;
        this.tvClassName = textView;
        this.tvDiscipline = textView2;
        this.tvLessonsCount = textView3;
        this.tvOrgPrice = textView4;
        this.tvShowPrice = textView5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BusShopItemRecordedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BusShopItemRecordedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.bus_shop_item_recorded;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.layoutPrice;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.BusShopItemRecordedBinding bind(android.view.View r12) {
        /*
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.cardClassInfo
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            if (r4 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.layoutPrice
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r5 = r1
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.llTabel
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r6 = r1
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.tvClassName
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.tvDiscipline
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.tvLessonsCount
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.tvOrgPrice
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.tvShowPrice
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0062
            com.tal.app.thinkacademy.business.shop.databinding.BusShopItemRecordedBinding r0 = new com.tal.app.thinkacademy.business.shop.databinding.BusShopItemRecordedBinding
            r3 = r12
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.BusShopItemRecordedBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.BusShopItemRecordedBinding");
    }
}
