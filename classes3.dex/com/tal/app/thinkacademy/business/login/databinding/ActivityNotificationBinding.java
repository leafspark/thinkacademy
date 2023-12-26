package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.login.R;
import com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar;

public final class ActivityNotificationBinding implements ViewBinding {
    public final ImageView ivNotificationState;
    public final TitleBar notificationTitleBar;
    private final LinearLayout rootView;
    public final TextView tvNotificationState;
    public final TextView tvNotificationTip;

    private ActivityNotificationBinding(LinearLayout linearLayout, ImageView imageView, TitleBar titleBar, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.ivNotificationState = imageView;
        this.notificationTitleBar = titleBar;
        this.tvNotificationState = textView;
        this.tvNotificationTip = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityNotificationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityNotificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_notification;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.business.login.R.id.notification_titleBar;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.ActivityNotificationBinding bind(android.view.View r8) {
        /*
            int r0 = com.tal.app.thinkacademy.business.login.R.id.iv_notification_state
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0036
            int r0 = com.tal.app.thinkacademy.business.login.R.id.notification_titleBar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r5 = r1
            com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar r5 = (com.tal.app.thinkacademy.lib.commui.widget.bar.TitleBar) r5
            if (r5 == 0) goto L_0x0036
            int r0 = com.tal.app.thinkacademy.business.login.R.id.tv_notification_state
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0036
            int r0 = com.tal.app.thinkacademy.business.login.R.id.tv_notification_tip
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0036
            com.tal.app.thinkacademy.business.login.databinding.ActivityNotificationBinding r0 = new com.tal.app.thinkacademy.business.login.databinding.ActivityNotificationBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.ActivityNotificationBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.ActivityNotificationBinding");
    }
}
