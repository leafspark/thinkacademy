package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.business.login.R;

public final class LiveItemChooseTimeZoneBinding implements ViewBinding {
    public final ImageView ivTimeZoneSeleted;
    public final RoundLinearLayout llItemBg;
    private final RoundLinearLayout rootView;
    public final TextView tvTimeZoneId;
    public final View viewDiv;

    private LiveItemChooseTimeZoneBinding(RoundLinearLayout roundLinearLayout, ImageView imageView, RoundLinearLayout roundLinearLayout2, TextView textView, View view) {
        this.rootView = roundLinearLayout;
        this.ivTimeZoneSeleted = imageView;
        this.llItemBg = roundLinearLayout2;
        this.tvTimeZoneId = textView;
        this.viewDiv = view;
    }

    public RoundLinearLayout getRoot() {
        return this.rootView;
    }

    public static LiveItemChooseTimeZoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveItemChooseTimeZoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_item_choose_time_zone;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        r0 = com.tal.app.thinkacademy.business.login.R.id.viewDiv;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.LiveItemChooseTimeZoneBinding bind(android.view.View r8) {
        /*
            int r0 = com.tal.app.thinkacademy.business.login.R.id.ivTimeZoneSeleted
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0029
            r5 = r8
            com.flyco.roundview.RoundLinearLayout r5 = (com.flyco.roundview.RoundLinearLayout) r5
            int r0 = com.tal.app.thinkacademy.business.login.R.id.tvTimeZoneId
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0029
            int r0 = com.tal.app.thinkacademy.business.login.R.id.viewDiv
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r7 == 0) goto L_0x0029
            com.tal.app.thinkacademy.business.login.databinding.LiveItemChooseTimeZoneBinding r8 = new com.tal.app.thinkacademy.business.login.databinding.LiveItemChooseTimeZoneBinding
            r2 = r8
            r3 = r5
            r2.<init>(r3, r4, r5, r6, r7)
            return r8
        L_0x0029:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.LiveItemChooseTimeZoneBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.LiveItemChooseTimeZoneBinding");
    }
}
