package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;

public final class LayoutRecordedCoursesFragmentBinding implements ViewBinding {
    public final LayoutItemStudySwitchBinding includeView;
    public final LoadStatusView loadStatusView;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final SmartRefreshLayout srLayout;
    public final ConstraintLayout tvClickSwitchAccountOrSchool;

    private LayoutRecordedCoursesFragmentBinding(ConstraintLayout constraintLayout, LayoutItemStudySwitchBinding layoutItemStudySwitchBinding, LoadStatusView loadStatusView2, RecyclerView recyclerView2, SmartRefreshLayout smartRefreshLayout, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.includeView = layoutItemStudySwitchBinding;
        this.loadStatusView = loadStatusView2;
        this.recyclerView = recyclerView2;
        this.srLayout = smartRefreshLayout;
        this.tvClickSwitchAccountOrSchool = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutRecordedCoursesFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutRecordedCoursesFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_recorded_courses_fragment;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0017, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.recyclerView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.srLayout;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002d, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvClickSwitchAccountOrSchool;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.LayoutRecordedCoursesFragmentBinding bind(android.view.View r9) {
        /*
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.includeView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r1 == 0) goto L_0x0042
            com.tal.app.thinkacademy.business.studycenter.databinding.LayoutItemStudySwitchBinding r4 = com.tal.app.thinkacademy.business.studycenter.databinding.LayoutItemStudySwitchBinding.bind(r1)
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.loadStatusView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r5 = (com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView) r5
            if (r5 == 0) goto L_0x0042
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.recyclerView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r6 = r1
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            if (r6 == 0) goto L_0x0042
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.srLayout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            com.scwang.smart.refresh.layout.SmartRefreshLayout r7 = (com.scwang.smart.refresh.layout.SmartRefreshLayout) r7
            if (r7 == 0) goto L_0x0042
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvClickSwitchAccountOrSchool
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x0042
            com.tal.app.thinkacademy.business.studycenter.databinding.LayoutRecordedCoursesFragmentBinding r0 = new com.tal.app.thinkacademy.business.studycenter.databinding.LayoutRecordedCoursesFragmentBinding
            r3 = r9
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x0042:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.LayoutRecordedCoursesFragmentBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.LayoutRecordedCoursesFragmentBinding");
    }
}
