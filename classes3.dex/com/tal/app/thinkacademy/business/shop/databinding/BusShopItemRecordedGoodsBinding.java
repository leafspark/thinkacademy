package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.shop.R;

public final class BusShopItemRecordedGoodsBinding implements ViewBinding {
    public final ConstraintLayout cardClassInfo;
    public final ImageView ivRecordedGoods;
    public final ConstraintLayout layoutPrice;
    private final ConstraintLayout rootView;
    public final TextView tvOrgPrice;
    public final TextView tvRecordedGoods;
    public final TextView tvShowPrice;

    private BusShopItemRecordedGoodsBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ConstraintLayout constraintLayout3, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.cardClassInfo = constraintLayout2;
        this.ivRecordedGoods = imageView;
        this.layoutPrice = constraintLayout3;
        this.tvOrgPrice = textView;
        this.tvRecordedGoods = textView2;
        this.tvShowPrice = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static BusShopItemRecordedGoodsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BusShopItemRecordedGoodsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.bus_shop_item_recorded_goods;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.layoutPrice;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.BusShopItemRecordedGoodsBinding bind(android.view.View r10) {
        /*
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.cardClassInfo
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r4 = r1
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            if (r4 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.ivRecordedGoods
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.layoutPrice
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r6 = r1
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.tvOrgPrice
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.tvRecordedGoods
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.tvShowPrice
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x004c
            com.tal.app.thinkacademy.business.shop.databinding.BusShopItemRecordedGoodsBinding r0 = new com.tal.app.thinkacademy.business.shop.databinding.BusShopItemRecordedGoodsBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.BusShopItemRecordedGoodsBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.BusShopItemRecordedGoodsBinding");
    }
}
