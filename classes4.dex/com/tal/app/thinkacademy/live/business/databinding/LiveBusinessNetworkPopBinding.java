package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessNetworkPopBinding implements ViewBinding {
    public final RoundLinearLayout layoutPopNetworkGood;
    public final RoundLinearLayout layoutPopNetworkNormal;
    public final RoundLinearLayout layoutPopNetworkWeak;
    private final RelativeLayout rootView;

    private LiveBusinessNetworkPopBinding(RelativeLayout relativeLayout, RoundLinearLayout roundLinearLayout, RoundLinearLayout roundLinearLayout2, RoundLinearLayout roundLinearLayout3) {
        this.rootView = relativeLayout;
        this.layoutPopNetworkGood = roundLinearLayout;
        this.layoutPopNetworkNormal = roundLinearLayout2;
        this.layoutPopNetworkWeak = roundLinearLayout3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessNetworkPopBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessNetworkPopBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_network_pop;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.layout_pop_network_normal;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.layout_pop_network_weak;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessNetworkPopBinding bind(android.view.View r4) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_pop_network_good
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            com.flyco.roundview.RoundLinearLayout r1 = (com.flyco.roundview.RoundLinearLayout) r1
            if (r1 == 0) goto L_0x0026
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_pop_network_normal
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            com.flyco.roundview.RoundLinearLayout r2 = (com.flyco.roundview.RoundLinearLayout) r2
            if (r2 == 0) goto L_0x0026
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_pop_network_weak
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            com.flyco.roundview.RoundLinearLayout r3 = (com.flyco.roundview.RoundLinearLayout) r3
            if (r3 == 0) goto L_0x0026
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessNetworkPopBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessNetworkPopBinding
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            r0.<init>(r4, r1, r2, r3)
            return r0
        L_0x0026:
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessNetworkPopBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessNetworkPopBinding");
    }
}
