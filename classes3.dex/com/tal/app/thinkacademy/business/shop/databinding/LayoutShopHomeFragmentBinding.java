package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;

public final class LayoutShopHomeFragmentBinding implements ViewBinding {
    public final ImageView ivTimeZoneClose;
    public final LinearLayout llTimeZoneTip;
    public final LoadStatusView loadStatusView;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final RelativeLayout rlShopRoot;
    private final RelativeLayout rootView;
    public final TextView titleDes;
    public final LinearLayout titleLayout;
    public final RoundTextView titleName;
    public final TextView tvTimeZone;
    public final FrameLayout webParent;

    private LayoutShopHomeFragmentBinding(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, LoadStatusView loadStatusView2, RecyclerView recyclerView2, SmartRefreshLayout smartRefreshLayout, RelativeLayout relativeLayout2, TextView textView, LinearLayout linearLayout2, RoundTextView roundTextView, TextView textView2, FrameLayout frameLayout) {
        this.rootView = relativeLayout;
        this.ivTimeZoneClose = imageView;
        this.llTimeZoneTip = linearLayout;
        this.loadStatusView = loadStatusView2;
        this.recyclerView = recyclerView2;
        this.refreshLayout = smartRefreshLayout;
        this.rlShopRoot = relativeLayout2;
        this.titleDes = textView;
        this.titleLayout = linearLayout2;
        this.titleName = roundTextView;
        this.tvTimeZone = textView2;
        this.webParent = frameLayout;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutShopHomeFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutShopHomeFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_shop_home_fragment;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0050, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.title_name;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.recyclerView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.refresh_layout;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.LayoutShopHomeFragmentBinding bind(android.view.View r15) {
        /*
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.ivTimeZoneClose
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0079
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.llTimeZoneTip
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r5 = r1
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            if (r5 == 0) goto L_0x0079
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.loadStatusView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r6 = r1
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r6 = (com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView) r6
            if (r6 == 0) goto L_0x0079
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.recyclerView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r7 = r1
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            if (r7 == 0) goto L_0x0079
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.refresh_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r8 = r1
            com.scwang.smart.refresh.layout.SmartRefreshLayout r8 = (com.scwang.smart.refresh.layout.SmartRefreshLayout) r8
            if (r8 == 0) goto L_0x0079
            r9 = r15
            android.widget.RelativeLayout r9 = (android.widget.RelativeLayout) r9
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.title_des
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0079
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.title_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r11 = r1
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x0079
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.title_name
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r12 = r1
            com.flyco.roundview.RoundTextView r12 = (com.flyco.roundview.RoundTextView) r12
            if (r12 == 0) goto L_0x0079
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.tvTimeZone
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r13 = r1
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0079
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.web_parent
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r14 = r1
            android.widget.FrameLayout r14 = (android.widget.FrameLayout) r14
            if (r14 == 0) goto L_0x0079
            com.tal.app.thinkacademy.business.shop.databinding.LayoutShopHomeFragmentBinding r15 = new com.tal.app.thinkacademy.business.shop.databinding.LayoutShopHomeFragmentBinding
            r2 = r15
            r3 = r9
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r15
        L_0x0079:
            android.content.res.Resources r15 = r15.getResources()
            java.lang.String r15 = r15.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r15 = r1.concat(r15)
            r0.<init>(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.LayoutShopHomeFragmentBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.LayoutShopHomeFragmentBinding");
    }
}
