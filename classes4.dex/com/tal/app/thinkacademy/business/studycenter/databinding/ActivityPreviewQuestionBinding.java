package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView;

public final class ActivityPreviewQuestionBinding implements ViewBinding {
    public final LinearLayout layoutSubmit;
    public final LinearLayout llContent;
    public final LoadStatusView loadStatusView;
    public final TitleBar previewTitleBar;
    public final RecyclerView recyclerView;
    private final LinearLayout rootView;
    public final TextView tvStart;

    private ActivityPreviewQuestionBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LoadStatusView loadStatusView2, TitleBar titleBar, RecyclerView recyclerView2, TextView textView) {
        this.rootView = linearLayout;
        this.layoutSubmit = linearLayout2;
        this.llContent = linearLayout3;
        this.loadStatusView = loadStatusView2;
        this.previewTitleBar = titleBar;
        this.recyclerView = recyclerView2;
        this.tvStart = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPreviewQuestionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityPreviewQuestionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_preview_question;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.loadStatusView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.recyclerView;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPreviewQuestionBinding bind(android.view.View r10) {
        /*
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_submit
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r4 = r1
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.llContent
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r5 = r1
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            if (r5 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.loadStatusView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r6 = r1
            com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView r6 = (com.tal.app.thinkcademy.lib.commui.widget.LoadStatusView) r6
            if (r6 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.preview_titleBar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r7 = r1
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r7 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r7
            if (r7 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.recyclerView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r8 = r1
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            if (r8 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_start
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x004c
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPreviewQuestionBinding r0 = new com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPreviewQuestionBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPreviewQuestionBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPreviewQuestionBinding");
    }
}
