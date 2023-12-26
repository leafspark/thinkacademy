package com.tal.app.thinkacademy.business.shop.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundRelativeLayout;
import com.tal.app.thinkacademy.business.shop.R;

public final class BusShopAggregateLeaveinfoItemMoreSelectBinding implements ViewBinding {
    public final RoundRelativeLayout moreSelectGroup;
    public final TextView moreSelectText;
    public final RoundLinearLayout parentBgView;
    public final TextView promptTextView;
    private final LinearLayout rootView;

    private BusShopAggregateLeaveinfoItemMoreSelectBinding(LinearLayout linearLayout, RoundRelativeLayout roundRelativeLayout, TextView textView, RoundLinearLayout roundLinearLayout, TextView textView2) {
        this.rootView = linearLayout;
        this.moreSelectGroup = roundRelativeLayout;
        this.moreSelectText = textView;
        this.parentBgView = roundLinearLayout;
        this.promptTextView = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BusShopAggregateLeaveinfoItemMoreSelectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BusShopAggregateLeaveinfoItemMoreSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.bus_shop_aggregate_leaveinfo_item_more_select;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.parentBgView;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.BusShopAggregateLeaveinfoItemMoreSelectBinding bind(android.view.View r8) {
        /*
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.moreSelectGroup
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r4 = r1
            com.flyco.roundview.RoundRelativeLayout r4 = (com.flyco.roundview.RoundRelativeLayout) r4
            if (r4 == 0) goto L_0x0036
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.moreSelectText
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0036
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.parentBgView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r6 = r1
            com.flyco.roundview.RoundLinearLayout r6 = (com.flyco.roundview.RoundLinearLayout) r6
            if (r6 == 0) goto L_0x0036
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.promptTextView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0036
            com.tal.app.thinkacademy.business.shop.databinding.BusShopAggregateLeaveinfoItemMoreSelectBinding r0 = new com.tal.app.thinkacademy.business.shop.databinding.BusShopAggregateLeaveinfoItemMoreSelectBinding
            r3 = r8
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        L_0x0036:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.BusShopAggregateLeaveinfoItemMoreSelectBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.BusShopAggregateLeaveinfoItemMoreSelectBinding");
    }
}
