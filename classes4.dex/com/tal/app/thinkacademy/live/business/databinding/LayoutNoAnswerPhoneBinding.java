package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LayoutNoAnswerPhoneBinding implements ViewBinding {
    public final ImageView ivResultClose;
    private final ConstraintLayout rootView;
    public final View viewResultNo;
    public final View viewResultNoInner;

    private LayoutNoAnswerPhoneBinding(ConstraintLayout constraintLayout, ImageView imageView, View view, View view2) {
        this.rootView = constraintLayout;
        this.ivResultClose = imageView;
        this.viewResultNo = view;
        this.viewResultNoInner = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutNoAnswerPhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutNoAnswerPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_no_answer_phone;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.view_result_no;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.view_result_no_inner;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LayoutNoAnswerPhoneBinding bind(android.view.View r4) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_result_close
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x0022
            int r0 = com.tal.app.thinkacademy.live.business.R.id.view_result_no
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            if (r2 == 0) goto L_0x0022
            int r0 = com.tal.app.thinkacademy.live.business.R.id.view_result_no_inner
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            if (r3 == 0) goto L_0x0022
            com.tal.app.thinkacademy.live.business.databinding.LayoutNoAnswerPhoneBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LayoutNoAnswerPhoneBinding
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r0.<init>(r4, r1, r2, r3)
            return r0
        L_0x0022:
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LayoutNoAnswerPhoneBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LayoutNoAnswerPhoneBinding");
    }
}
