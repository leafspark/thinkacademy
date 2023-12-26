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
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;

public final class BusShopAggregateLeaveinfoItemInputBinding implements ViewBinding {
    public final LinearLayout btnSelectPhonePrefix;
    public final RoundRelativeLayout inputTextGroup;
    public final ClearEditText inputTextView;
    public final RoundLinearLayout parentBgView;
    public final TextView promptTextView;
    private final LinearLayout rootView;
    public final TextView textPhonePrefix;

    private BusShopAggregateLeaveinfoItemInputBinding(LinearLayout linearLayout, LinearLayout linearLayout2, RoundRelativeLayout roundRelativeLayout, ClearEditText clearEditText, RoundLinearLayout roundLinearLayout, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.btnSelectPhonePrefix = linearLayout2;
        this.inputTextGroup = roundRelativeLayout;
        this.inputTextView = clearEditText;
        this.parentBgView = roundLinearLayout;
        this.promptTextView = textView;
        this.textPhonePrefix = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BusShopAggregateLeaveinfoItemInputBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static BusShopAggregateLeaveinfoItemInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.bus_shop_aggregate_leaveinfo_item_input;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.inputTextGroup;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.business.shop.R.id.parentBgView;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.shop.databinding.BusShopAggregateLeaveinfoItemInputBinding bind(android.view.View r10) {
        /*
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.btn_select_phone_prefix
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r4 = r1
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.inputTextGroup
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r5 = r1
            com.flyco.roundview.RoundRelativeLayout r5 = (com.flyco.roundview.RoundRelativeLayout) r5
            if (r5 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.inputTextView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r6 = r1
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r6 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r6
            if (r6 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.parentBgView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r7 = r1
            com.flyco.roundview.RoundLinearLayout r7 = (com.flyco.roundview.RoundLinearLayout) r7
            if (r7 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.promptTextView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.shop.R.id.text_phone_prefix
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x004c
            com.tal.app.thinkacademy.business.shop.databinding.BusShopAggregateLeaveinfoItemInputBinding r0 = new com.tal.app.thinkacademy.business.shop.databinding.BusShopAggregateLeaveinfoItemInputBinding
            r3 = r10
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.shop.databinding.BusShopAggregateLeaveinfoItemInputBinding.bind(android.view.View):com.tal.app.thinkacademy.business.shop.databinding.BusShopAggregateLeaveinfoItemInputBinding");
    }
}
