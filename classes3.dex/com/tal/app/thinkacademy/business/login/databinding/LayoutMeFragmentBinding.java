package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.business.login.widget.MyCardView;

public final class LayoutMeFragmentBinding implements ViewBinding {
    public final MyCardView cardCoupons;
    public final MyCardView cardOrders;
    public final LinearLayout cardParent;
    public final View cardSpace;
    public final MyCardView cardUnpaidCourse;
    public final ImageView cardUnpaidCourseNotify;
    public final TextView cardUnpaidCourseNum;
    public final ConstraintLayout cardView;
    public final ConstraintLayout clCoins;
    public final Group groupEdit;
    public final Group groupGuest;
    public final Group groupUser;
    public final ImageView ivBanner;
    public final ImageView ivCoins;
    public final ImageView ivCoinsNext;
    public final ImageView ivEdit;
    public final ImageView ivSwitchAccount;
    public final ImageView ivUser;
    public final ConstraintLayout layoutInfo;
    public final LinearLayout llEditTip;
    public final RoundLinearLayout llTimeZoneTip;
    private final LinearLayout rootView;
    public final RecyclerView rvShowDetail;
    public final TextView tvCard;
    public final TextView tvCoinsAmount;
    public final RoundTextView tvCopy;
    public final RoundTextView tvCorners;
    public final TextView tvLogin;
    public final TextView tvLoginTip;
    public final TextView tvName;
    public final TextView tvTimeZone;

    private LayoutMeFragmentBinding(LinearLayout linearLayout, MyCardView myCardView, MyCardView myCardView2, LinearLayout linearLayout2, View view, MyCardView myCardView3, ImageView imageView, TextView textView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Group group, Group group2, Group group3, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ConstraintLayout constraintLayout3, LinearLayout linearLayout3, RoundLinearLayout roundLinearLayout, RecyclerView recyclerView, TextView textView2, TextView textView3, RoundTextView roundTextView, RoundTextView roundTextView2, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = linearLayout;
        this.cardCoupons = myCardView;
        this.cardOrders = myCardView2;
        this.cardParent = linearLayout2;
        this.cardSpace = view;
        this.cardUnpaidCourse = myCardView3;
        this.cardUnpaidCourseNotify = imageView;
        this.cardUnpaidCourseNum = textView;
        this.cardView = constraintLayout;
        this.clCoins = constraintLayout2;
        this.groupEdit = group;
        this.groupGuest = group2;
        this.groupUser = group3;
        this.ivBanner = imageView2;
        this.ivCoins = imageView3;
        this.ivCoinsNext = imageView4;
        this.ivEdit = imageView5;
        this.ivSwitchAccount = imageView6;
        this.ivUser = imageView7;
        this.layoutInfo = constraintLayout3;
        this.llEditTip = linearLayout3;
        this.llTimeZoneTip = roundLinearLayout;
        this.rvShowDetail = recyclerView;
        this.tvCard = textView2;
        this.tvCoinsAmount = textView3;
        this.tvCopy = roundTextView;
        this.tvCorners = roundTextView2;
        this.tvLogin = textView4;
        this.tvLoginTip = textView5;
        this.tvName = textView6;
        this.tvTimeZone = textView7;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutMeFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutMeFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_me_fragment;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004c, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.cardView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.cl_coins;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0062, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.group_edit;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006d, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.group_guest;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0078, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.group_user;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cc, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.layout_info;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e4, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.llTimeZoneTip;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.rv_show_detail;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0114, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.tv_copy;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0120, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.tv_corners;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.card_space;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.LayoutMeFragmentBinding bind(android.view.View r35) {
        /*
            r0 = r35
            int r1 = com.tal.app.thinkacademy.business.login.R.id.card_coupons
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.tal.app.thinkacademy.business.login.widget.MyCardView r5 = (com.tal.app.thinkacademy.business.login.widget.MyCardView) r5
            if (r5 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.card_orders
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.tal.app.thinkacademy.business.login.widget.MyCardView r6 = (com.tal.app.thinkacademy.business.login.widget.MyCardView) r6
            if (r6 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.card_parent
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.card_space
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r8 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.card_unpaid_course
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            com.tal.app.thinkacademy.business.login.widget.MyCardView r9 = (com.tal.app.thinkacademy.business.login.widget.MyCardView) r9
            if (r9 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.card_unpaid_course_notify
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.card_unpaid_course_num
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.cardView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            if (r12 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.cl_coins
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            if (r13 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.group_edit
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            androidx.constraintlayout.widget.Group r14 = (androidx.constraintlayout.widget.Group) r14
            if (r14 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.group_guest
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            androidx.constraintlayout.widget.Group r15 = (androidx.constraintlayout.widget.Group) r15
            if (r15 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.group_user
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.constraintlayout.widget.Group r16 = (androidx.constraintlayout.widget.Group) r16
            if (r16 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.ivBanner
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.ImageView r17 = (android.widget.ImageView) r17
            if (r17 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_coins
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.ImageView r18 = (android.widget.ImageView) r18
            if (r18 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_coins_next
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.ImageView r19 = (android.widget.ImageView) r19
            if (r19 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_edit
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.ImageView r20 = (android.widget.ImageView) r20
            if (r20 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_switch_account
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.ImageView r21 = (android.widget.ImageView) r21
            if (r21 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_user
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.ImageView r22 = (android.widget.ImageView) r22
            if (r22 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_info
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            androidx.constraintlayout.widget.ConstraintLayout r23 = (androidx.constraintlayout.widget.ConstraintLayout) r23
            if (r23 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.ll_edit_tip
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.LinearLayout r24 = (android.widget.LinearLayout) r24
            if (r24 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.llTimeZoneTip
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            com.flyco.roundview.RoundLinearLayout r25 = (com.flyco.roundview.RoundLinearLayout) r25
            if (r25 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.rv_show_detail
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            androidx.recyclerview.widget.RecyclerView r26 = (androidx.recyclerview.widget.RecyclerView) r26
            if (r26 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_card
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            android.widget.TextView r27 = (android.widget.TextView) r27
            if (r27 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_coins_amount
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            android.widget.TextView r28 = (android.widget.TextView) r28
            if (r28 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_copy
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r29 = r2
            com.flyco.roundview.RoundTextView r29 = (com.flyco.roundview.RoundTextView) r29
            if (r29 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_corners
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r30 = r2
            com.flyco.roundview.RoundTextView r30 = (com.flyco.roundview.RoundTextView) r30
            if (r30 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_login
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r31 = r2
            android.widget.TextView r31 = (android.widget.TextView) r31
            if (r31 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_login_tip
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r32 = r2
            android.widget.TextView r32 = (android.widget.TextView) r32
            if (r32 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r33 = r2
            android.widget.TextView r33 = (android.widget.TextView) r33
            if (r33 == 0) goto L_0x0166
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tvTimeZone
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r34 = r2
            android.widget.TextView r34 = (android.widget.TextView) r34
            if (r34 == 0) goto L_0x0166
            com.tal.app.thinkacademy.business.login.databinding.LayoutMeFragmentBinding r1 = new com.tal.app.thinkacademy.business.login.databinding.LayoutMeFragmentBinding
            r3 = r1
            r4 = r0
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            return r1
        L_0x0166:
            android.content.res.Resources r0 = r35.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.LayoutMeFragmentBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.LayoutMeFragmentBinding");
    }
}
