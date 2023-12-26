package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;
import net.lucode.hackware.magicindicator.MagicIndicator;

public final class ActivityTempClassBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final MagicIndicator tempClassIndicator;
    public final TitleBar tempClassTitleBar;
    public final ViewPager tempClassViewPager;
    public final TextView tvRegistrationCourse;
    public final View vRegister;

    private ActivityTempClassBinding(ConstraintLayout constraintLayout, MagicIndicator magicIndicator, TitleBar titleBar, ViewPager viewPager, TextView textView, View view) {
        this.rootView = constraintLayout;
        this.tempClassIndicator = magicIndicator;
        this.tempClassTitleBar = titleBar;
        this.tempClassViewPager = viewPager;
        this.tvRegistrationCourse = textView;
        this.vRegister = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTempClassBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityTempClassBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_temp_class;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.business.login.R.id.tempClass_titleBar;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.business.login.R.id.tempClass_viewPager;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.tal.app.thinkacademy.business.login.R.id.v_register;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.ActivityTempClassBinding bind(android.view.View r9) {
        /*
            int r0 = com.tal.app.thinkacademy.business.login.R.id.tempClass_indicator
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            net.lucode.hackware.magicindicator.MagicIndicator r4 = (net.lucode.hackware.magicindicator.MagicIndicator) r4
            if (r4 == 0) goto L_0x003e
            int r0 = com.tal.app.thinkacademy.business.login.R.id.tempClass_titleBar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r5 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r5
            if (r5 == 0) goto L_0x003e
            int r0 = com.tal.app.thinkacademy.business.login.R.id.tempClass_viewPager
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r6 = r1
            androidx.viewpager.widget.ViewPager r6 = (androidx.viewpager.widget.ViewPager) r6
            if (r6 == 0) goto L_0x003e
            int r0 = com.tal.app.thinkacademy.business.login.R.id.tv_registration_course
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x003e
            int r0 = com.tal.app.thinkacademy.business.login.R.id.v_register
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            if (r8 == 0) goto L_0x003e
            com.tal.app.thinkacademy.business.login.databinding.ActivityTempClassBinding r0 = new com.tal.app.thinkacademy.business.login.databinding.ActivityTempClassBinding
            r3 = r9
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x003e:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.ActivityTempClassBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.ActivityTempClassBinding");
    }
}
