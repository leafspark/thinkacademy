package com.tal.user.global.trade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.user.global.trade.R;

public final class ViewTalTradeSecondaryConfirmationBinding implements ViewBinding {
    public final View dividerLine;
    public final LinearLayout llTop;
    private final ConstraintLayout rootView;
    public final TextView tvCancel;
    public final TextView tvConfirm;
    public final TextView tvDescrip;
    public final TextView tvTitle;
    public final View viewCenterLine;

    private ViewTalTradeSecondaryConfirmationBinding(ConstraintLayout constraintLayout, View view, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view2) {
        this.rootView = constraintLayout;
        this.dividerLine = view;
        this.llTop = linearLayout;
        this.tvCancel = textView;
        this.tvConfirm = textView2;
        this.tvDescrip = textView3;
        this.tvTitle = textView4;
        this.viewCenterLine = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewTalTradeSecondaryConfirmationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ViewTalTradeSecondaryConfirmationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.view_tal_trade_secondary_confirmation;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        r0 = com.tal.user.global.trade.R.id.viewCenterLine;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.user.global.trade.databinding.ViewTalTradeSecondaryConfirmationBinding bind(android.view.View r10) {
        /*
            int r0 = com.tal.user.global.trade.R.id.divider_line
            android.view.View r3 = r10.findViewById(r0)
            if (r3 == 0) goto L_0x0051
            int r0 = com.tal.user.global.trade.R.id.llTop
            android.view.View r1 = r10.findViewById(r0)
            r4 = r1
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x0051
            int r0 = com.tal.user.global.trade.R.id.tv_cancel
            android.view.View r1 = r10.findViewById(r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0051
            int r0 = com.tal.user.global.trade.R.id.tv_confirm
            android.view.View r1 = r10.findViewById(r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0051
            int r0 = com.tal.user.global.trade.R.id.tv_descrip
            android.view.View r1 = r10.findViewById(r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0051
            int r0 = com.tal.user.global.trade.R.id.tv_title
            android.view.View r1 = r10.findViewById(r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0051
            int r0 = com.tal.user.global.trade.R.id.viewCenterLine
            android.view.View r9 = r10.findViewById(r0)
            if (r9 == 0) goto L_0x0051
            com.tal.user.global.trade.databinding.ViewTalTradeSecondaryConfirmationBinding r0 = new com.tal.user.global.trade.databinding.ViewTalTradeSecondaryConfirmationBinding
            r2 = r10
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return r0
        L_0x0051:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r10 = r1.concat(r10)
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.user.global.trade.databinding.ViewTalTradeSecondaryConfirmationBinding.bind(android.view.View):com.tal.user.global.trade.databinding.ViewTalTradeSecondaryConfirmationBinding");
    }
}
