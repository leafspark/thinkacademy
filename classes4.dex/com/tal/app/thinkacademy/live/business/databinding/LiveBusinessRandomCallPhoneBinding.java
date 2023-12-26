package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.randomcall.CustomViewGroup;

public final class LiveBusinessRandomCallPhoneBinding implements ViewBinding {
    public final CustomViewGroup liveBusinessRandomCallClMachine;
    public final ConstraintLayout liveBusinessRandomCallClUser;
    public final ImageView liveBusinessRandomCallIvControl;
    public final ImageView liveBusinessRandomCallIvMachine;
    public final ImageView liveBusinessRandomCallIvUserClose;
    public final ImageView liveBusinessRandomCallIvUserHead;
    public final ImageView liveBusinessRandomCallIvUserLevel;
    public final LottieAnimationView liveBusinessRandomCallLivLight;
    public final RecyclerView liveBusinessRandomCallRvUserPicker;
    public final TextView liveBusinessRandomCallTvTitle;
    public final TextView liveBusinessRandomCallTvUserName;
    private final ConstraintLayout rootView;

    private LiveBusinessRandomCallPhoneBinding(ConstraintLayout constraintLayout, CustomViewGroup customViewGroup, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LottieAnimationView lottieAnimationView, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.liveBusinessRandomCallClMachine = customViewGroup;
        this.liveBusinessRandomCallClUser = constraintLayout2;
        this.liveBusinessRandomCallIvControl = imageView;
        this.liveBusinessRandomCallIvMachine = imageView2;
        this.liveBusinessRandomCallIvUserClose = imageView3;
        this.liveBusinessRandomCallIvUserHead = imageView4;
        this.liveBusinessRandomCallIvUserLevel = imageView5;
        this.liveBusinessRandomCallLivLight = lottieAnimationView;
        this.liveBusinessRandomCallRvUserPicker = recyclerView;
        this.liveBusinessRandomCallTvTitle = textView;
        this.liveBusinessRandomCallTvUserName = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessRandomCallPhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessRandomCallPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_random_call_phone;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_random_call_liv_light;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_random_call_rv_user_picker;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_random_call_cl_user;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessRandomCallPhoneBinding bind(android.view.View r15) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_random_call_cl_machine
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r4 = r1
            com.tal.app.thinkacademy.live.business.randomcall.CustomViewGroup r4 = (com.tal.app.thinkacademy.live.business.randomcall.CustomViewGroup) r4
            if (r4 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_random_call_cl_user
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r5 = r1
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_random_call_iv_control
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_random_call_iv_machine
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_random_call_iv_user_close
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_random_call_iv_user_head
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r9 = r1
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_random_call_iv_user_level
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r10 = r1
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_random_call_liv_light
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r11 = r1
            com.airbnb.lottie.LottieAnimationView r11 = (com.airbnb.lottie.LottieAnimationView) r11
            if (r11 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_random_call_rv_user_picker
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r12 = r1
            androidx.recyclerview.widget.RecyclerView r12 = (androidx.recyclerview.widget.RecyclerView) r12
            if (r12 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_random_call_tv_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r13 = r1
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_random_call_tv_user_name
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r14 = r1
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0083
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessRandomCallPhoneBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessRandomCallPhoneBinding
            r3 = r15
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r0
        L_0x0083:
            android.content.res.Resources r15 = r15.getResources()
            java.lang.String r15 = r15.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r15 = r1.concat(r15)
            r0.<init>(r15)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessRandomCallPhoneBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessRandomCallPhoneBinding");
    }
}
