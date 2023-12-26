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
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;

public final class ActivitySearchTimeZoneBinding implements ViewBinding {
    public final ClearEditText editTimeZone;
    public final RoundLinearLayout llInput;
    public final LoadStatusView loadStatusView;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TitleBar titleBar;

    private ActivitySearchTimeZoneBinding(ConstraintLayout constraintLayout, ClearEditText clearEditText, RoundLinearLayout roundLinearLayout, LoadStatusView loadStatusView2, RecyclerView recyclerView2, TitleBar titleBar2) {
        this.rootView = constraintLayout;
        this.editTimeZone = clearEditText;
        this.llInput = roundLinearLayout;
        this.loadStatusView = loadStatusView2;
        this.recyclerView = recyclerView2;
        this.titleBar = titleBar2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySearchTimeZoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivitySearchTimeZoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_search_time_zone;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.business.login.R.id.llInput;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.business.login.R.id.recyclerView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.tal.app.thinkacademy.business.login.R.id.titleBar;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.ActivitySearchTimeZoneBinding bind(android.view.View r9) {
        /*
            int r0 = com.tal.app.thinkacademy.business.login.R.id.editTimeZone
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r4 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r4
            if (r4 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.login.R.id.llInput
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            com.flyco.roundview.RoundLinearLayout r5 = (com.flyco.roundview.RoundLinearLayout) r5
            if (r5 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.login.R.id.loadStatusView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r6 = r1
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r6 = (com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView) r6
            if (r6 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.login.R.id.recyclerView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            if (r7 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.business.login.R.id.titleBar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r8 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r8
            if (r8 == 0) goto L_0x0041
            com.tal.app.thinkacademy.business.login.databinding.ActivitySearchTimeZoneBinding r0 = new com.tal.app.thinkacademy.business.login.databinding.ActivitySearchTimeZoneBinding
            r3 = r9
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x0041:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.ActivitySearchTimeZoneBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.ActivitySearchTimeZoneBinding");
    }
}
