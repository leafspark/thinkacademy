package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.yy.mobile.rollingtextview.RollingTextView;

public final class LiveBusinessStudentvideoPhoneBinding implements ViewBinding {
    public final RelativeLayout flLiveBusinessStudent1;
    public final ImageView ivLiveBusinessCamera1;
    public final ImageView ivLiveBusinessCoins;
    public final ImageView ivLiveBusinessHead1;
    public final ImageView ivLiveBusinessMyLevel;
    public final RelativeLayout rlLiveBusinessHeadParent1;
    public final RelativeLayout rlLiveBusinessStudent1;
    private final ConstraintLayout rootView;
    public final TextView tvLiveBusinessName1;
    public final RollingTextView tvLiveBusinessUserCoins;

    private LiveBusinessStudentvideoPhoneBinding(ConstraintLayout constraintLayout, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView, RollingTextView rollingTextView) {
        this.rootView = constraintLayout;
        this.flLiveBusinessStudent1 = relativeLayout;
        this.ivLiveBusinessCamera1 = imageView;
        this.ivLiveBusinessCoins = imageView2;
        this.ivLiveBusinessHead1 = imageView3;
        this.ivLiveBusinessMyLevel = imageView4;
        this.rlLiveBusinessHeadParent1 = relativeLayout2;
        this.rlLiveBusinessStudent1 = relativeLayout3;
        this.tvLiveBusinessName1 = textView;
        this.tvLiveBusinessUserCoins = rollingTextView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessStudentvideoPhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessStudentvideoPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_studentvideo_phone;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_user_coins;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessStudentvideoPhoneBinding bind(android.view.View r13) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.fl_live_business_student_1
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            if (r4 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_camera_1
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_coins
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_head1
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_my_level
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_head_parent1
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            android.widget.RelativeLayout r9 = (android.widget.RelativeLayout) r9
            if (r9 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_student_1
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r10 = r1
            android.widget.RelativeLayout r10 = (android.widget.RelativeLayout) r10
            if (r10 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_name_1
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_user_coins
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r12 = r1
            com.yy.mobile.rollingtextview.RollingTextView r12 = (com.yy.mobile.rollingtextview.RollingTextView) r12
            if (r12 == 0) goto L_0x006d
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessStudentvideoPhoneBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessStudentvideoPhoneBinding
            r3 = r13
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L_0x006d:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessStudentvideoPhoneBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessStudentvideoPhoneBinding");
    }
}
