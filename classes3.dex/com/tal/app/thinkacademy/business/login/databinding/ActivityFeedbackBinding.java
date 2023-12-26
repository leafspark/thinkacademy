package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.lib.commui.widget.MyEditText;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;

public final class ActivityFeedbackBinding implements ViewBinding {
    public final MyEditText etContent;
    public final LinearLayout layoutSubmit;
    private final ConstraintLayout rootView;
    public final RecyclerView rvPhotos;
    public final RecyclerView rvTags;
    public final TitleBar titleBarFeedback;
    public final TextView tvSubmit;

    private ActivityFeedbackBinding(ConstraintLayout constraintLayout, MyEditText myEditText, LinearLayout linearLayout, RecyclerView recyclerView, RecyclerView recyclerView2, TitleBar titleBar, TextView textView) {
        this.rootView = constraintLayout;
        this.etContent = myEditText;
        this.layoutSubmit = linearLayout;
        this.rvPhotos = recyclerView;
        this.rvTags = recyclerView2;
        this.titleBarFeedback = titleBar;
        this.tvSubmit = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityFeedbackBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityFeedbackBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_feedback;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.business.login.R.id.rv_photos;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.business.login.R.id.rv_tags;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.tal.app.thinkacademy.business.login.R.id.titleBar_feedback;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.ActivityFeedbackBinding bind(android.view.View r10) {
        /*
            int r0 = com.tal.app.thinkacademy.business.login.R.id.et_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r4 = r1
            com.tal.app.thinkacademy.lib.commui.widget.MyEditText r4 = (com.tal.app.thinkacademy.lib.commui.widget.MyEditText) r4
            if (r4 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.login.R.id.layout_submit
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r5 = r1
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            if (r5 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.login.R.id.rv_photos
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r6 = r1
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            if (r6 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.login.R.id.rv_tags
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r7 = r1
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            if (r7 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.login.R.id.titleBar_feedback
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r8 = r1
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r8 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r8
            if (r8 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.business.login.R.id.tv_submit
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x004c
            com.tal.app.thinkacademy.business.login.databinding.ActivityFeedbackBinding r0 = new com.tal.app.thinkacademy.business.login.databinding.ActivityFeedbackBinding
            r3 = r10
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.ActivityFeedbackBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.ActivityFeedbackBinding");
    }
}
