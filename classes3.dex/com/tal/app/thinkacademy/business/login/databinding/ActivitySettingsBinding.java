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

public final class ActivitySettingsBinding implements ViewBinding {
    public final LinearLayout layoutAboutUs;
    public final LinearLayout layoutAddress;
    public final LinearLayout layoutClearCache;
    public final LinearLayout layoutCountry;
    public final LinearLayout layoutDeleteAccount;
    public final LinearLayout layoutGroup;
    public final LinearLayout layoutLanguage;
    public final LinearLayout layoutNotification;
    public final LinearLayout layoutSetPassword;
    public final LinearLayout layoutSwitchAccount;
    public final LinearLayout layoutVersion;
    private final LinearLayout rootView;
    public final TitleBar settingsTitleBar;
    public final TextView tvCacheSize;
    public final TextView tvCountryName;
    public final TextView tvCountryTip;
    public final TextView tvSelectLanguage;
    public final TextView tvSignOut;
    public final RoundTextView tvSwitchTip;
    public final TextView tvVersionNumber;
    public final TextView tvVersionTip;

    private ActivitySettingsBinding(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, LinearLayout linearLayout9, LinearLayout linearLayout10, LinearLayout linearLayout11, LinearLayout linearLayout12, TitleBar titleBar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, RoundTextView roundTextView, TextView textView6, TextView textView7) {
        this.rootView = linearLayout;
        this.layoutAboutUs = linearLayout2;
        this.layoutAddress = linearLayout3;
        this.layoutClearCache = linearLayout4;
        this.layoutCountry = linearLayout5;
        this.layoutDeleteAccount = linearLayout6;
        this.layoutGroup = linearLayout7;
        this.layoutLanguage = linearLayout8;
        this.layoutNotification = linearLayout9;
        this.layoutSetPassword = linearLayout10;
        this.layoutSwitchAccount = linearLayout11;
        this.layoutVersion = linearLayout12;
        this.settingsTitleBar = titleBar;
        this.tvCacheSize = textView;
        this.tvCountryName = textView2;
        this.tvCountryTip = textView3;
        this.tvSelectLanguage = textView4;
        this.tvSignOut = textView5;
        this.tvSwitchTip = roundTextView;
        this.tvVersionNumber = textView6;
        this.tvVersionTip = textView7;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivitySettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_settings;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.settings_titleBar;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c3, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.tv_switch_tip;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.ActivitySettingsBinding bind(android.view.View r25) {
        /*
            r0 = r25
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_about_us
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            if (r5 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_address
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_clear_cache
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_country
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_delete_account
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            if (r9 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_group
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            if (r10 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_language
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_notification
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            if (r12 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_set_password
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            if (r13 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_switch_account
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            if (r14 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_version
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.LinearLayout r15 = (android.widget.LinearLayout) r15
            if (r15 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.login.R.id.settings_titleBar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r16 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r16
            if (r16 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_cache_size
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_country_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_country_tip
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tvSelectLanguage
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_sign_out
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_switch_tip
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            com.flyco.roundview.RoundTextView r22 = (com.flyco.roundview.RoundTextView) r22
            if (r22 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_version_number
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x00f1
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_version_tip
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.TextView r24 = (android.widget.TextView) r24
            if (r24 == 0) goto L_0x00f1
            com.tal.app.thinkacademy.business.login.databinding.ActivitySettingsBinding r1 = new com.tal.app.thinkacademy.business.login.databinding.ActivitySettingsBinding
            r3 = r1
            r4 = r0
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r1
        L_0x00f1:
            android.content.res.Resources r0 = r25.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.ActivitySettingsBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.ActivitySettingsBinding");
    }
}
