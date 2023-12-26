package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import com.tal.app.thinkcademy.lib.commui.widget.ClearEditText;

public final class ActivityAddStudentBinding implements ViewBinding {
    public final ClearEditText etEmail;
    public final ClearEditText etNameOne;
    public final ClearEditText etNameTwo;
    public final ClearEditText etNickname;
    public final LinearLayout layoutEmail;
    public final LinearLayout layoutGrade;
    public final LinearLayout layoutGroup;
    public final LinearLayout layoutNameOne;
    public final LinearLayout layoutNameTwo;
    public final LinearLayout layoutNickname;
    private final LinearLayout rootView;
    public final TitleBar titleBarAdd;
    public final RoundTextView tvAdd;
    public final TextView tvGrade;
    public final TextView tvNameOne;
    public final TextView tvNameTwo;

    private ActivityAddStudentBinding(LinearLayout linearLayout, ClearEditText clearEditText, ClearEditText clearEditText2, ClearEditText clearEditText3, ClearEditText clearEditText4, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, TitleBar titleBar, RoundTextView roundTextView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.etEmail = clearEditText;
        this.etNameOne = clearEditText2;
        this.etNameTwo = clearEditText3;
        this.etNickname = clearEditText4;
        this.layoutEmail = linearLayout2;
        this.layoutGrade = linearLayout3;
        this.layoutGroup = linearLayout4;
        this.layoutNameOne = linearLayout5;
        this.layoutNameTwo = linearLayout6;
        this.layoutNickname = linearLayout7;
        this.titleBarAdd = titleBar;
        this.tvAdd = roundTextView;
        this.tvGrade = textView;
        this.tvNameOne = textView2;
        this.tvNameTwo = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAddStudentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityAddStudentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_add_student;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.titleBar_add;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.tv_add;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.ActivityAddStudentBinding bind(android.view.View r20) {
        /*
            r0 = r20
            int r1 = com.tal.app.thinkacademy.business.login.R.id.et_email
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r5 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r5
            if (r5 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.login.R.id.etNameOne
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r6 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r6
            if (r6 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.login.R.id.etNameTwo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r7 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r7
            if (r7 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.login.R.id.et_nickname
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            com.tal.app.thinkcademy.lib.commui.widget.ClearEditText r8 = (com.tal.app.thinkcademy.lib.commui.widget.ClearEditText) r8
            if (r8 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_email
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            if (r9 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_grade
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            if (r10 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_group
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layoutNameOne
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            if (r12 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layoutNameTwo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            if (r13 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_nickname
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            if (r14 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.login.R.id.titleBar_add
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r15 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r15
            if (r15 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_add
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            com.flyco.roundview.RoundTextView r16 = (com.flyco.roundview.RoundTextView) r16
            if (r16 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_grade
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tvNameOne
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tvNameTwo
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00b5
            com.tal.app.thinkacademy.business.login.databinding.ActivityAddStudentBinding r1 = new com.tal.app.thinkacademy.business.login.databinding.ActivityAddStudentBinding
            r3 = r1
            r4 = r0
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r1
        L_0x00b5:
            android.content.res.Resources r0 = r20.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.ActivityAddStudentBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.ActivityAddStudentBinding");
    }
}
