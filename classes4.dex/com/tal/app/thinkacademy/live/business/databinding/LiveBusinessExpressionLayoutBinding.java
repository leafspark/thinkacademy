package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessExpressionLayoutBinding implements ViewBinding {
    public final ImageView ivLivevideoMessageExpressionCancle;
    public final LinearLayout llChatExpressionPageSelect;
    public final RelativeLayout rlLivevideoMessageExpression;
    private final RelativeLayout rootView;
    public final RecyclerView rvChatExpressionCustomList;
    public final View vChatExpressionPage0Select;
    public final View vChatExpressionPage1Select;
    public final View vChatExpressionPage2Select;
    public final View vChatExpressionPage3Select;
    public final View vChatExpressionPage4Select;
    public final View vChatExpressionPage5Select;
    public final View vChatExpressionPage6Select;
    public final ViewPager vpChatExpressionView;

    private LiveBusinessExpressionLayoutBinding(RelativeLayout relativeLayout, ImageView imageView, LinearLayout linearLayout, RelativeLayout relativeLayout2, RecyclerView recyclerView, View view, View view2, View view3, View view4, View view5, View view6, View view7, ViewPager viewPager) {
        this.rootView = relativeLayout;
        this.ivLivevideoMessageExpressionCancle = imageView;
        this.llChatExpressionPageSelect = linearLayout;
        this.rlLivevideoMessageExpression = relativeLayout2;
        this.rvChatExpressionCustomList = recyclerView;
        this.vChatExpressionPage0Select = view;
        this.vChatExpressionPage1Select = view2;
        this.vChatExpressionPage2Select = view3;
        this.vChatExpressionPage3Select = view4;
        this.vChatExpressionPage4Select = view5;
        this.vChatExpressionPage5Select = view6;
        this.vChatExpressionPage6Select = view7;
        this.vpChatExpressionView = viewPager;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessExpressionLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessExpressionLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_expression_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0036, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.v_chat_expression_page1_select;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.v_chat_expression_page2_select;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.v_chat_expression_page3_select;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.v_chat_expression_page4_select;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.v_chat_expression_page5_select;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005e, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.v_chat_expression_page6_select;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0066, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.vp_chat_expression_view;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.rv_chat_expression_customList;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.v_chat_expression_page0_select;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessExpressionLayoutBinding bind(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_livevideo_message_expression_cancle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x007c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.ll_chat_expression_page_select
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x007c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_livevideo_message_expression
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7
            if (r7 == 0) goto L_0x007c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rv_chat_expression_customList
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            if (r8 == 0) goto L_0x007c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.v_chat_expression_page0_select
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r9 == 0) goto L_0x007c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.v_chat_expression_page1_select
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r10 == 0) goto L_0x007c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.v_chat_expression_page2_select
            android.view.View r11 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r11 == 0) goto L_0x007c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.v_chat_expression_page3_select
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r12 == 0) goto L_0x007c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.v_chat_expression_page4_select
            android.view.View r13 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r13 == 0) goto L_0x007c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.v_chat_expression_page5_select
            android.view.View r14 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r14 == 0) goto L_0x007c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.v_chat_expression_page6_select
            android.view.View r15 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r15 == 0) goto L_0x007c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.vp_chat_expression_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.viewpager.widget.ViewPager r16 = (androidx.viewpager.widget.ViewPager) r16
            if (r16 == 0) goto L_0x007c
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessExpressionLayoutBinding r1 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessExpressionLayoutBinding
            r4 = r0
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r1
        L_0x007c:
            android.content.res.Resources r0 = r17.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessExpressionLayoutBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessExpressionLayoutBinding");
    }
}
