package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.yy.mobile.rollingtextview.RollingTextView;

public final class LiveBusinessStudentvideoSmallClassPhoneBinding implements ViewBinding {
    public final RelativeLayout flLiveBusinessStudent1;
    public final ImageView ivLiveBusinessCamera1;
    public final ImageView ivLiveBusinessCoins;
    public final ImageView ivLiveBusinessHandUp;
    public final ImageView ivLiveBusinessHead1;
    public final ImageView ivLiveBusinessMyLevel;
    public final ConstraintLayout layoutLiveBusinessCoins;
    public final FrameLayout layoutLiveBusinessMyLevel;
    public final RelativeLayout rlLiveBusinessHeadParent1;
    public final RelativeLayout rlLiveBusinessStudent1;
    private final ConstraintLayout rootView;
    public final TextView tvLiveBusinessName1;
    public final RollingTextView tvLiveBusinessUserCoins;

    private LiveBusinessStudentvideoSmallClassPhoneBinding(ConstraintLayout constraintLayout, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ConstraintLayout constraintLayout2, FrameLayout frameLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView, RollingTextView rollingTextView) {
        this.rootView = constraintLayout;
        this.flLiveBusinessStudent1 = relativeLayout;
        this.ivLiveBusinessCamera1 = imageView;
        this.ivLiveBusinessCoins = imageView2;
        this.ivLiveBusinessHandUp = imageView3;
        this.ivLiveBusinessHead1 = imageView4;
        this.ivLiveBusinessMyLevel = imageView5;
        this.layoutLiveBusinessCoins = constraintLayout2;
        this.layoutLiveBusinessMyLevel = frameLayout;
        this.rlLiveBusinessHeadParent1 = relativeLayout2;
        this.rlLiveBusinessStudent1 = relativeLayout3;
        this.tvLiveBusinessName1 = textView;
        this.tvLiveBusinessUserCoins = rollingTextView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessStudentvideoSmallClassPhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessStudentvideoSmallClassPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_studentvideo_small_class_phone;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.layout_live_business_coins;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_user_coins;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessStudentvideoSmallClassPhoneBinding bind(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.tal.app.thinkacademy.live.business.R.id.fl_live_business_student_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            if (r5 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_camera_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_coins
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_hand_up
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_head1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_my_level
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.layout_live_business_coins
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            if (r11 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.layout_live_business_my_level
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.FrameLayout r12 = (android.widget.FrameLayout) r12
            if (r12 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_head_parent1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.RelativeLayout r13 = (android.widget.RelativeLayout) r13
            if (r13 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_student_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.RelativeLayout r14 = (android.widget.RelativeLayout) r14
            if (r14 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_name_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_user_coins
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            com.yy.mobile.rollingtextview.RollingTextView r16 = (com.yy.mobile.rollingtextview.RollingTextView) r16
            if (r16 == 0) goto L_0x0091
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessStudentvideoSmallClassPhoneBinding r1 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessStudentvideoSmallClassPhoneBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r1
        L_0x0091:
            android.content.res.Resources r0 = r17.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessStudentvideoSmallClassPhoneBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessStudentvideoSmallClassPhoneBinding");
    }
}
