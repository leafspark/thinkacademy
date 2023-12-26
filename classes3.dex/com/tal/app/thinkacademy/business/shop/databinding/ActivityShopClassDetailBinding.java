package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.tal.app.thinkacademy.business.shop.R;
import com.tal.app.thinkacademy.business.shop.widget.view.StateTextView;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;

public final class ActivityShopClassDetailBinding implements ViewBinding {
    public final StateTextView btnGotoBuy;
    public final ImageView btnWish;
    public final ConstraintLayout buyAreaLayout;
    public final TextView couponDiscountedPrice;
    public final TextView couponDiscountedPriceCompany;
    public final RoundTextView couponDiscountedPriceLabel;
    public final Group couponGroup;
    public final TextView couponInfoDesc;
    public final TextView downtimeDayColon;
    public final TextView downtimeDayLabel;
    public final RoundTextView downtimeDayNum;
    public final Group downtimeGroup;
    public final TextView downtimeHourColon;
    public final TextView downtimeHourLabel;
    public final TextView downtimeHourNum;
    public final TextView downtimeMinColon;
    public final TextView downtimeMinLabel;
    public final TextView downtimeMinNum;
    public final TextView downtimeSecLabel;
    public final RoundTextView downtimeSecNum;
    public final LoadStatusView loadStatusView;
    public final TabLayout positionTabLayout;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    private final ConstraintLayout rootView;
    public final TitleBar titleView;

    private ActivityShopClassDetailBinding(ConstraintLayout constraintLayout, StateTextView stateTextView, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, RoundTextView roundTextView, Group group, TextView textView3, TextView textView4, TextView textView5, RoundTextView roundTextView2, Group group2, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, RoundTextView roundTextView3, LoadStatusView loadStatusView2, TabLayout tabLayout, RecyclerView recyclerView2, SmartRefreshLayout smartRefreshLayout, TitleBar titleBar) {
        this.rootView = constraintLayout;
        this.btnGotoBuy = stateTextView;
        this.btnWish = imageView;
        this.buyAreaLayout = constraintLayout2;
        this.couponDiscountedPrice = textView;
        this.couponDiscountedPriceCompany = textView2;
        this.couponDiscountedPriceLabel = roundTextView;
        this.couponGroup = group;
        this.couponInfoDesc = textView3;
        this.downtimeDayColon = textView4;
        this.downtimeDayLabel = textView5;
        this.downtimeDayNum = roundTextView2;
        this.downtimeGroup = group2;
        this.downtimeHourColon = textView6;
        this.downtimeHourLabel = textView7;
        this.downtimeHourNum = textView8;
        this.downtimeMinColon = textView9;
        this.downtimeMinLabel = textView10;
        this.downtimeMinNum = textView11;
        this.downtimeSecLabel = textView12;
        this.downtimeSecNum = roundTextView3;
        this.loadStatusView = loadStatusView2;
        this.positionTabLayout = tabLayout;
        this.recyclerView = recyclerView2;
        this.refreshLayout = smartRefreshLayout;
        this.titleView = titleBar;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityShopClassDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityShopClassDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_shop_class_detail;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.coupon_discounted_price_label;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.coupon_group;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.downtime_day_num;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.downtime_group;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00db, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.downtime_sec_num;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f3, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.position_tab_layout;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ff, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.recycler_view;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010b, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.refresh_layout;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0117, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.title_view;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r1 = com.tal.app.thinkacademy.business.shop.R.id.buy_area_layout;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassDetailBinding bind(android.view.View r30) {
        /*
            r0 = r30
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.btn_goto_buy
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.tal.app.thinkacademy.business.shop.widget.view.StateTextView r5 = (com.tal.app.thinkacademy.business.shop.widget.view.StateTextView) r5
            if (r5 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.btn_wish
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.buy_area_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.coupon_discounted_price
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.coupon_discounted_price_company
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.coupon_discounted_price_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            com.flyco.roundview.RoundTextView r10 = (com.flyco.roundview.RoundTextView) r10
            if (r10 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.coupon_group
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.constraintlayout.widget.Group r11 = (androidx.constraintlayout.widget.Group) r11
            if (r11 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.coupon_info_desc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.downtime_day_colon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.downtime_day_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.downtime_day_num
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            com.flyco.roundview.RoundTextView r15 = (com.flyco.roundview.RoundTextView) r15
            if (r15 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.downtime_group
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.constraintlayout.widget.Group r16 = (androidx.constraintlayout.widget.Group) r16
            if (r16 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.downtime_hour_colon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.downtime_hour_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.downtime_hour_num
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.downtime_min_colon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.downtime_min_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.downtime_min_num
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.downtime_sec_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.downtime_sec_num
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            com.flyco.roundview.RoundTextView r24 = (com.flyco.roundview.RoundTextView) r24
            if (r24 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.loadStatusView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r25 = (com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView) r25
            if (r25 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.position_tab_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            com.google.android.material.tabs.TabLayout r26 = (com.google.android.material.tabs.TabLayout) r26
            if (r26 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.recycler_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            androidx.recyclerview.widget.RecyclerView r27 = (androidx.recyclerview.widget.RecyclerView) r27
            if (r27 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.refresh_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            com.scwang.smart.refresh.layout.SmartRefreshLayout r28 = (com.scwang.smart.refresh.layout.SmartRefreshLayout) r28
            if (r28 == 0) goto L_0x012d
            int r1 = com.tal.app.thinkacademy.business.shop.R.id.title_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r29 = r2
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r29 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r29
            if (r29 == 0) goto L_0x012d
            com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassDetailBinding r1 = new com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassDetailBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            return r1
        L_0x012d:
            android.content.res.Resources r0 = r30.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassDetailBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.ActivityShopClassDetailBinding");
    }
}
