package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;

public final class ActivityChooseTimeZoneBinding implements ViewBinding {
    public final RoundLinearLayout llInput;
    public final LoadStatusView loadStatusView;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TitleBar titleBar;

    private ActivityChooseTimeZoneBinding(ConstraintLayout constraintLayout, RoundLinearLayout roundLinearLayout, LoadStatusView loadStatusView2, RecyclerView recyclerView2, TitleBar titleBar2) {
        this.rootView = constraintLayout;
        this.llInput = roundLinearLayout;
        this.loadStatusView = loadStatusView2;
        this.recyclerView = recyclerView2;
        this.titleBar = titleBar2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityChooseTimeZoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityChooseTimeZoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_choose_time_zone;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.business.login.R.id.recyclerView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.business.login.R.id.titleBar;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.ActivityChooseTimeZoneBinding bind(android.view.View r8) {
        /*
            int r0 = com.tal.app.thinkacademy.business.login.R.id.llInput
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r4 = r1
            com.flyco.roundview.RoundLinearLayout r4 = (com.flyco.roundview.RoundLinearLayout) r4
            if (r4 == 0) goto L_0x0036
            int r0 = com.tal.app.thinkacademy.business.login.R.id.loadStatusView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r5 = r1
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r5 = (com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView) r5
            if (r5 == 0) goto L_0x0036
            int r0 = com.tal.app.thinkacademy.business.login.R.id.recyclerView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r6 = r1
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            if (r6 == 0) goto L_0x0036
            int r0 = com.tal.app.thinkacademy.business.login.R.id.titleBar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r7 = r1
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r7 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r7
            if (r7 == 0) goto L_0x0036
            com.tal.app.thinkacademy.business.login.databinding.ActivityChooseTimeZoneBinding r0 = new com.tal.app.thinkacademy.business.login.databinding.ActivityChooseTimeZoneBinding
            r3 = r8
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.ActivityChooseTimeZoneBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.ActivityChooseTimeZoneBinding");
    }
}
