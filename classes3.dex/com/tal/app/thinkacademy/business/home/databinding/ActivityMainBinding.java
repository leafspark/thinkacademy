package com.tal.app.thinkacademy.business.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.home.R;
import com.tal.app.thinkacademy.common.base.tab.XesFragmentTabView;
import com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomLayout;

public final class ActivityMainBinding implements ViewBinding {
    public final XesFragmentTabView fragmentTabView;
    private final FrameLayout rootView;
    public final XesTabBottomLayout tabBottomLayout;

    private ActivityMainBinding(FrameLayout frameLayout, XesFragmentTabView xesFragmentTabView, XesTabBottomLayout xesTabBottomLayout) {
        this.rootView = frameLayout;
        this.fragmentTabView = xesFragmentTabView;
        this.tabBottomLayout = xesTabBottomLayout;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_main;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.tal.app.thinkacademy.business.home.R.id.tab_bottom_layout;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.home.databinding.ActivityMainBinding bind(android.view.View r3) {
        /*
            int r0 = com.tal.app.thinkacademy.business.home.R.id.fragment_tab_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            com.tal.app.thinkacademy.common.base.tab.XesFragmentTabView r1 = (com.tal.app.thinkacademy.common.base.tab.XesFragmentTabView) r1
            if (r1 == 0) goto L_0x001c
            int r0 = com.tal.app.thinkacademy.business.home.R.id.tab_bottom_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomLayout r2 = (com.tal.app.thinkacademy.lib.commui.tab.bottom.XesTabBottomLayout) r2
            if (r2 == 0) goto L_0x001c
            com.tal.app.thinkacademy.business.home.databinding.ActivityMainBinding r0 = new com.tal.app.thinkacademy.business.home.databinding.ActivityMainBinding
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.databinding.ActivityMainBinding.bind(android.view.View):com.tal.app.thinkacademy.business.home.databinding.ActivityMainBinding");
    }
}
