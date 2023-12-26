package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;

public final class ActivityMaterialListBinding implements ViewBinding {
    public final TitleBar activityMaterialTitle;
    public final LoadStatusView loadviewMaterialList;
    private final RelativeLayout rootView;
    public final RecyclerView rvMaterialList;
    public final RoundTextView tvMaterialDate;
    public final TextView tvMaterialOrder;
    public final TextView tvMaterialTitle;

    private ActivityMaterialListBinding(RelativeLayout relativeLayout, TitleBar titleBar, LoadStatusView loadStatusView, RecyclerView recyclerView, RoundTextView roundTextView, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.activityMaterialTitle = titleBar;
        this.loadviewMaterialList = loadStatusView;
        this.rvMaterialList = recyclerView;
        this.tvMaterialDate = roundTextView;
        this.tvMaterialOrder = textView;
        this.tvMaterialTitle = textView2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMaterialListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityMaterialListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_material_list;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.loadview_Material_list;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.rvMaterialList;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvMaterialDate;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.ActivityMaterialListBinding bind(android.view.View r10) {
        /*
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.activity_material_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r4 = r1
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r4 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r4
            if (r4 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.loadview_Material_list
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r5 = r1
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r5 = (com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView) r5
            if (r5 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.rvMaterialList
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r6 = r1
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            if (r6 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvMaterialDate
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r7 = r1
            com.flyco.roundview.RoundTextView r7 = (com.flyco.roundview.RoundTextView) r7
            if (r7 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvMaterialOrder
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvMaterialTitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x004c
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityMaterialListBinding r0 = new com.tal.app.thinkacademy.business.studycenter.databinding.ActivityMaterialListBinding
            r3 = r10
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.ActivityMaterialListBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.ActivityMaterialListBinding");
    }
}
