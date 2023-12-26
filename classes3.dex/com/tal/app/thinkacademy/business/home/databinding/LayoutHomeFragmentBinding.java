package com.tal.app.thinkacademy.business.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.home.R;

public final class LayoutHomeFragmentBinding implements ViewBinding {
    public final Button btnTest;
    public final ConstraintLayout clContent;
    private final LinearLayout rootView;
    public final View statusBarView;
    public final RelativeLayout webParent;

    private LayoutHomeFragmentBinding(LinearLayout linearLayout, Button button, ConstraintLayout constraintLayout, View view, RelativeLayout relativeLayout) {
        this.rootView = linearLayout;
        this.btnTest = button;
        this.clContent = constraintLayout;
        this.statusBarView = view;
        this.webParent = relativeLayout;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutHomeFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutHomeFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_home_fragment;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.business.home.R.id.cl_content;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.business.home.R.id.status_bar_view;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.home.databinding.LayoutHomeFragmentBinding bind(android.view.View r8) {
        /*
            int r0 = com.tal.app.thinkacademy.business.home.R.id.btn_test
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r4 = r1
            android.widget.Button r4 = (android.widget.Button) r4
            if (r4 == 0) goto L_0x0033
            int r0 = com.tal.app.thinkacademy.business.home.R.id.cl_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r5 = r1
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x0033
            int r0 = com.tal.app.thinkacademy.business.home.R.id.status_bar_view
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            if (r6 == 0) goto L_0x0033
            int r0 = com.tal.app.thinkacademy.business.home.R.id.web_parent
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r7 = r1
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7
            if (r7 == 0) goto L_0x0033
            com.tal.app.thinkacademy.business.home.databinding.LayoutHomeFragmentBinding r0 = new com.tal.app.thinkacademy.business.home.databinding.LayoutHomeFragmentBinding
            r3 = r8
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        L_0x0033:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.home.databinding.LayoutHomeFragmentBinding.bind(android.view.View):com.tal.app.thinkacademy.business.home.databinding.LayoutHomeFragmentBinding");
    }
}
