package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.google.android.material.appbar.AppBarLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.widget.view.SelectTabListGroup;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;

public final class ActivityShopClassListBinding implements ViewBinding {
    public final AppBarLayout appBar;
    public final CheckedTextView checkboxRegistered;
    public final LoadStatusView loadStatusView;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    private final ConstraintLayout rootView;
    public final SelectTabListGroup tabFilter;
    public final TitleBar titleView;
    public final TextView tvSubTitle;

    private ActivityShopClassListBinding(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, CheckedTextView checkedTextView, LoadStatusView loadStatusView2, RecyclerView recyclerView2, SmartRefreshLayout smartRefreshLayout, SelectTabListGroup selectTabListGroup, TitleBar titleBar, TextView textView) {
        this.rootView = constraintLayout;
        this.appBar = appBarLayout;
        this.checkboxRegistered = checkedTextView;
        this.loadStatusView = loadStatusView2;
        this.recyclerView = recyclerView2;
        this.refreshLayout = smartRefreshLayout;
        this.tabFilter = selectTabListGroup;
        this.titleView = titleBar;
        this.tvSubTitle = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityShopClassListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityShopClassListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_shop_class_list;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.title_view;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.recycler_view;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.refresh_layout;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassListBinding bind(android.view.View r12) {
        /*
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.app_bar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            com.google.android.material.appbar.AppBarLayout r4 = (com.google.android.material.appbar.AppBarLayout) r4
            if (r4 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.checkbox_registered
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r5 = r1
            android.widget.CheckedTextView r5 = (android.widget.CheckedTextView) r5
            if (r5 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.loadStatusView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r6 = r1
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r6 = (com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView) r6
            if (r6 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.recycler_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r7 = r1
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            if (r7 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.refresh_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r8 = r1
            com.scwang.smart.refresh.layout.SmartRefreshLayout r8 = (com.scwang.smart.refresh.layout.SmartRefreshLayout) r8
            if (r8 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.tab_filter
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r9 = r1
            com.tal.app.thinkacademy.business.shop.widget.view.SelectTabListGroup r9 = (com.tal.app.thinkacademy.business.shop.widget.view.SelectTabListGroup) r9
            if (r9 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.title_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r10 = r1
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r10 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r10
            if (r10 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.tv_sub_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0062
            com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassListBinding r0 = new com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassListBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassListBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassListBinding");
    }
}
