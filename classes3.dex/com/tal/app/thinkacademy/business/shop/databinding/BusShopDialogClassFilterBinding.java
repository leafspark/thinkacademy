package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.widget.view.SelectTabListGroup;

public final class BusShopDialogClassFilterBinding implements ViewBinding {
    public final CheckedTextView checkboxDialogRegistered;
    public final View dialogBottom;
    public final View dialogTop;
    private final LinearLayout rootView;
    public final SelectTabListGroup tabDialogTitle;
    public final ViewPager viewPager;

    private BusShopDialogClassFilterBinding(LinearLayout linearLayout, CheckedTextView checkedTextView, View view, View view2, SelectTabListGroup selectTabListGroup, ViewPager viewPager2) {
        this.rootView = linearLayout;
        this.checkboxDialogRegistered = checkedTextView;
        this.dialogBottom = view;
        this.dialogTop = view2;
        this.tabDialogTitle = selectTabListGroup;
        this.viewPager = viewPager2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BusShopDialogClassFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BusShopDialogClassFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.bus_shop_dialog_class_filter;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.dialog_bottom;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.dialog_top;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.view_pager;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogClassFilterBinding bind(android.view.View r9) {
        /*
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.checkbox_dialog_registered
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            android.widget.CheckedTextView r4 = (android.widget.CheckedTextView) r4
            if (r4 == 0) goto L_0x003b
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.dialog_bottom
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r5 == 0) goto L_0x003b
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.dialog_top
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r6 == 0) goto L_0x003b
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.tab_dialog_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            com.tal.app.thinkacademy.business.shop.widget.view.SelectTabListGroup r7 = (com.tal.app.thinkacademy.business.shop.widget.view.SelectTabListGroup) r7
            if (r7 == 0) goto L_0x003b
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.view_pager
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            androidx.viewpager.widget.ViewPager r8 = (androidx.viewpager.widget.ViewPager) r8
            if (r8 == 0) goto L_0x003b
            com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogClassFilterBinding r0 = new com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogClassFilterBinding
            r3 = r9
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x003b:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogClassFilterBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.BusShopDialogClassFilterBinding");
    }
}
