package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class ItemPlanTeacherListBinding implements ViewBinding {
    public final ImageView ivTeacherIcon;
    public final ImageView ivTeacherInformation;
    private final LinearLayout rootView;
    public final RoundTextView tvTeacherIdentity;
    public final TextView tvTeacherName;

    private ItemPlanTeacherListBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, RoundTextView roundTextView, TextView textView) {
        this.rootView = linearLayout;
        this.ivTeacherIcon = imageView;
        this.ivTeacherInformation = imageView2;
        this.tvTeacherIdentity = roundTextView;
        this.tvTeacherName = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemPlanTeacherListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ItemPlanTeacherListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.item_plan_teacher_list;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvTeacherIdentity;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.ItemPlanTeacherListBinding bind(android.view.View r8) {
        /*
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.ivTeacherIcon
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0036
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.ivTeacherInformation
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0036
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvTeacherIdentity
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r6 = r1
            com.flyco.roundview.RoundTextView r6 = (com.flyco.roundview.RoundTextView) r6
            if (r6 == 0) goto L_0x0036
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tvTeacherName
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0036
            com.tal.app.thinkacademy.business.studycenter.databinding.ItemPlanTeacherListBinding r0 = new com.tal.app.thinkacademy.business.studycenter.databinding.ItemPlanTeacherListBinding
            r3 = r8
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.ItemPlanTeacherListBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.ItemPlanTeacherListBinding");
    }
}
