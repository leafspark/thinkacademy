package com.tal.user.global.trade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.user.global.trade.R;
import com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay;
import com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout;
import com.tal.user.global.trade.widget.TimeCountDownTextView;

public final class ActivityTalAppCheckoutBinding implements ViewBinding {
    public final ImageView ivTalTradeTancengCloseIcon;
    public final ImageView ivTalTradeWvCloseIcon;
    public final LinearLayout llBottom;
    public final LinearLayout llTop;
    public final LinearLayout llwxGotoPay;
    public final TalTradeSecondaryConfirmationLayout rlSc;
    public final TalTradeSecondaryConfirmationLayout rlScFail;
    public final TalTradeSecondaryConfirmationLayout rlScPaying;
    public final TalTradeSecondaryConfirmationLayout rlScTimeout;
    private final RelativeLayout rootView;
    public final RecyclerView rvTalTradePayWay;
    public final TextView tvTalTradeGoodsCurrencySymbol;
    public final TextView tvTalTradeGoodsDetail;
    public final TextView tvTalTradeGoodsName;
    public final TimeCountDownTextView tvTalTradeGoodsTimmer;
    public final TextView tvTalTradeGoodsTotalFee;
    public final TextView tvTalTradeGotoPay;
    public final TextView tvTalTradeWebViewCloseIcon;
    public final TalTradeCommentWebViewWithPay wvGotoPay;

    private ActivityTalAppCheckoutBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, TalTradeSecondaryConfirmationLayout talTradeSecondaryConfirmationLayout, TalTradeSecondaryConfirmationLayout talTradeSecondaryConfirmationLayout2, TalTradeSecondaryConfirmationLayout talTradeSecondaryConfirmationLayout3, TalTradeSecondaryConfirmationLayout talTradeSecondaryConfirmationLayout4, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TimeCountDownTextView timeCountDownTextView, TextView textView4, TextView textView5, TextView textView6, TalTradeCommentWebViewWithPay talTradeCommentWebViewWithPay) {
        this.rootView = relativeLayout;
        this.ivTalTradeTancengCloseIcon = imageView;
        this.ivTalTradeWvCloseIcon = imageView2;
        this.llBottom = linearLayout;
        this.llTop = linearLayout2;
        this.llwxGotoPay = linearLayout3;
        this.rlSc = talTradeSecondaryConfirmationLayout;
        this.rlScFail = talTradeSecondaryConfirmationLayout2;
        this.rlScPaying = talTradeSecondaryConfirmationLayout3;
        this.rlScTimeout = talTradeSecondaryConfirmationLayout4;
        this.rvTalTradePayWay = recyclerView;
        this.tvTalTradeGoodsCurrencySymbol = textView;
        this.tvTalTradeGoodsDetail = textView2;
        this.tvTalTradeGoodsName = textView3;
        this.tvTalTradeGoodsTimmer = timeCountDownTextView;
        this.tvTalTradeGoodsTotalFee = textView4;
        this.tvTalTradeGotoPay = textView5;
        this.tvTalTradeWebViewCloseIcon = textView6;
        this.wvGotoPay = talTradeCommentWebViewWithPay;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTalAppCheckoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTalAppCheckoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_tal_app_checkout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
        r1 = com.tal.user.global.trade.R.id.rvTalTradePayWay;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding bind(android.view.View r23) {
        /*
            r0 = r23
            int r1 = com.tal.user.global.trade.R.id.ivTalTradeTancengCloseIcon
            android.view.View r2 = r0.findViewById(r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x00d9
            int r1 = com.tal.user.global.trade.R.id.ivTalTradeWvCloseIcon
            android.view.View r2 = r0.findViewById(r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x00d9
            int r1 = com.tal.user.global.trade.R.id.llBottom
            android.view.View r2 = r0.findViewById(r1)
            r7 = r2
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x00d9
            int r1 = com.tal.user.global.trade.R.id.llTop
            android.view.View r2 = r0.findViewById(r1)
            r8 = r2
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x00d9
            int r1 = com.tal.user.global.trade.R.id.llwxGotoPay
            android.view.View r2 = r0.findViewById(r1)
            r9 = r2
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            if (r9 == 0) goto L_0x00d9
            int r1 = com.tal.user.global.trade.R.id.rlSc
            android.view.View r2 = r0.findViewById(r1)
            r10 = r2
            com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout r10 = (com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout) r10
            if (r10 == 0) goto L_0x00d9
            int r1 = com.tal.user.global.trade.R.id.rlScFail
            android.view.View r2 = r0.findViewById(r1)
            r11 = r2
            com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout r11 = (com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout) r11
            if (r11 == 0) goto L_0x00d9
            int r1 = com.tal.user.global.trade.R.id.rlScPaying
            android.view.View r2 = r0.findViewById(r1)
            r12 = r2
            com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout r12 = (com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout) r12
            if (r12 == 0) goto L_0x00d9
            int r1 = com.tal.user.global.trade.R.id.rlScTimeout
            android.view.View r2 = r0.findViewById(r1)
            r13 = r2
            com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout r13 = (com.tal.user.global.trade.widget.TalTradeSecondaryConfirmationLayout) r13
            if (r13 == 0) goto L_0x00d9
            int r1 = com.tal.user.global.trade.R.id.rvTalTradePayWay
            android.view.View r2 = r0.findViewById(r1)
            r14 = r2
            androidx.recyclerview.widget.RecyclerView r14 = (androidx.recyclerview.widget.RecyclerView) r14
            if (r14 == 0) goto L_0x00d9
            int r1 = com.tal.user.global.trade.R.id.tvTalTradeGoodsCurrencySymbol
            android.view.View r2 = r0.findViewById(r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00d9
            int r1 = com.tal.user.global.trade.R.id.tvTalTradeGoodsDetail
            android.view.View r2 = r0.findViewById(r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00d9
            int r1 = com.tal.user.global.trade.R.id.tvTalTradeGoodsName
            android.view.View r2 = r0.findViewById(r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00d9
            int r1 = com.tal.user.global.trade.R.id.tvTalTradeGoodsTimmer
            android.view.View r2 = r0.findViewById(r1)
            r18 = r2
            com.tal.user.global.trade.widget.TimeCountDownTextView r18 = (com.tal.user.global.trade.widget.TimeCountDownTextView) r18
            if (r18 == 0) goto L_0x00d9
            int r1 = com.tal.user.global.trade.R.id.tvTalTradeGoodsTotalFee
            android.view.View r2 = r0.findViewById(r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00d9
            int r1 = com.tal.user.global.trade.R.id.tvTalTradeGotoPay
            android.view.View r2 = r0.findViewById(r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00d9
            int r1 = com.tal.user.global.trade.R.id.tvTalTradeWebViewCloseIcon
            android.view.View r2 = r0.findViewById(r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x00d9
            int r1 = com.tal.user.global.trade.R.id.wvGotoPay
            android.view.View r2 = r0.findViewById(r1)
            r22 = r2
            com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay r22 = (com.tal.user.global.trade.widget.TalTradeCommentWebViewWithPay) r22
            if (r22 == 0) goto L_0x00d9
            com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding r1 = new com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding
            r3 = r1
            r4 = r0
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return r1
        L_0x00d9:
            android.content.res.Resources r0 = r23.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding.bind(android.view.View):com.tal.user.global.trade.databinding.ActivityTalAppCheckoutBinding");
    }
}
