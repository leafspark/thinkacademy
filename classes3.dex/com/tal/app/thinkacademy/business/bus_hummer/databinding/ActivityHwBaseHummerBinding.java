package com.tal.app.thinkacademy.business.bus_hummer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.didi.hummer.render.style.HummerLayout;
import com.tal.app.thinkacademy.business.bus_hummer.R;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;

public final class ActivityHwBaseHummerBinding implements ViewBinding {
    public final HummerLayout hummerContainer;
    public final TitleBar nativeTopBar;
    private final LinearLayout rootView;

    private ActivityHwBaseHummerBinding(LinearLayout linearLayout, HummerLayout hummerLayout, TitleBar titleBar) {
        this.rootView = linearLayout;
        this.hummerContainer = hummerLayout;
        this.nativeTopBar = titleBar;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityHwBaseHummerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityHwBaseHummerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_hw_base_hummer;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.tal.app.thinkacademy.business.bus_hummer.R.id.nativeTopBar;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.bus_hummer.databinding.ActivityHwBaseHummerBinding bind(android.view.View r3) {
        /*
            int r0 = com.tal.app.thinkacademy.business.bus_hummer.R.id.hummer_container
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            com.didi.hummer.render.style.HummerLayout r1 = (com.didi.hummer.render.style.HummerLayout) r1
            if (r1 == 0) goto L_0x001c
            int r0 = com.tal.app.thinkacademy.business.bus_hummer.R.id.nativeTopBar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r2 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r2
            if (r2 == 0) goto L_0x001c
            com.tal.app.thinkacademy.business.bus_hummer.databinding.ActivityHwBaseHummerBinding r0 = new com.tal.app.thinkacademy.business.bus_hummer.databinding.ActivityHwBaseHummerBinding
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r0.<init>(r3, r1, r2)
            return r0
        L_0x001c:
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r3 = r3.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r3 = r1.concat(r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.bus_hummer.databinding.ActivityHwBaseHummerBinding.bind(android.view.View):com.tal.app.thinkacademy.business.bus_hummer.databinding.ActivityHwBaseHummerBinding");
    }
}
