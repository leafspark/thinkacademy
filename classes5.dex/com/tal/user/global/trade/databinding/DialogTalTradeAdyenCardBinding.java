package com.tal.user.global.trade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.adyen.checkout.card.CardView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.user.global.trade.R;

public final class DialogTalTradeAdyenCardBinding implements ViewBinding {
    public final CardView cardView;
    public final ImageView ivTalTradeCardCloseIcon;
    public final LinearLayout llBottom;
    public final RecyclerView recyclerViewCardList;
    private final ConstraintLayout rootView;
    public final TextView tvTalTradeGotoPay;
    public final TextView tvTitle;

    private DialogTalTradeAdyenCardBinding(ConstraintLayout constraintLayout, CardView cardView2, ImageView imageView, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.cardView = cardView2;
        this.ivTalTradeCardCloseIcon = imageView;
        this.llBottom = linearLayout;
        this.recyclerViewCardList = recyclerView;
        this.tvTalTradeGotoPay = textView;
        this.tvTitle = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogTalTradeAdyenCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogTalTradeAdyenCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.dialog_tal_trade_adyen_card;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.user.global.trade.R.id.recyclerViewCardList;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.user.global.trade.databinding.DialogTalTradeAdyenCardBinding bind(android.view.View r10) {
        /*
            int r0 = com.tal.user.global.trade.R.id.cardView
            android.view.View r1 = r10.findViewById(r0)
            r4 = r1
            com.adyen.checkout.card.CardView r4 = (com.adyen.checkout.card.CardView) r4
            if (r4 == 0) goto L_0x004c
            int r0 = com.tal.user.global.trade.R.id.ivTalTradeCardCloseIcon
            android.view.View r1 = r10.findViewById(r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x004c
            int r0 = com.tal.user.global.trade.R.id.llBottom
            android.view.View r1 = r10.findViewById(r0)
            r6 = r1
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x004c
            int r0 = com.tal.user.global.trade.R.id.recyclerViewCardList
            android.view.View r1 = r10.findViewById(r0)
            r7 = r1
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            if (r7 == 0) goto L_0x004c
            int r0 = com.tal.user.global.trade.R.id.tvTalTradeGotoPay
            android.view.View r1 = r10.findViewById(r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x004c
            int r0 = com.tal.user.global.trade.R.id.tvTitle
            android.view.View r1 = r10.findViewById(r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x004c
            com.tal.user.global.trade.databinding.DialogTalTradeAdyenCardBinding r0 = new com.tal.user.global.trade.databinding.DialogTalTradeAdyenCardBinding
            r3 = r10
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r0
        L_0x004c:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r10 = r1.concat(r10)
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.user.global.trade.databinding.DialogTalTradeAdyenCardBinding.bind(android.view.View):com.tal.user.global.trade.databinding.DialogTalTradeAdyenCardBinding");
    }
}
