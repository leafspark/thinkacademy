package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class StudyDialogZoomBinding implements ViewBinding {
    public final RoundLinearLayout llCopyId;
    public final RoundLinearLayout llCopyPassword;
    private final RelativeLayout rootView;
    public final TextView tvDownload;
    public final TextView tvGotIt;
    public final TextView tvZoomId;
    public final TextView tvZoomPasswork;

    private StudyDialogZoomBinding(RelativeLayout relativeLayout, RoundLinearLayout roundLinearLayout, RoundLinearLayout roundLinearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = relativeLayout;
        this.llCopyId = roundLinearLayout;
        this.llCopyPassword = roundLinearLayout2;
        this.tvDownload = textView;
        this.tvGotIt = textView2;
        this.tvZoomId = textView3;
        this.tvZoomPasswork = textView4;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static StudyDialogZoomBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static StudyDialogZoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.study_dialog_zoom;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.llCopyPassword;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.StudyDialogZoomBinding bind(android.view.View r10) {
        /*
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.llCopyId
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r4 = r1
            com.flyco.roundview.RoundLinearLayout r4 = (com.flyco.roundview.RoundLinearLayout) r4
            if (r4 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.llCopyPassword
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r5 = r1
            com.flyco.roundview.RoundLinearLayout r5 = (com.flyco.roundview.RoundLinearLayout) r5
            if (r5 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvDownload
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvGotIt
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvZoomId
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvZoomPasswork
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x004c
            com.tal.app.thinkacademy.business.studycenter.databinding.StudyDialogZoomBinding r0 = new com.tal.app.thinkacademy.business.studycenter.databinding.StudyDialogZoomBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.StudyDialogZoomBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.StudyDialogZoomBinding");
    }
}
