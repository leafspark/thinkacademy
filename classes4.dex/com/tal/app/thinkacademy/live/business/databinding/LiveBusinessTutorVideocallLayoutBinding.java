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

public final class LiveBusinessTutorVideocallLayoutBinding implements ViewBinding {
    public final FrameLayout rlLiveBusinessTutorVideocall;
    public final RelativeLayout rlLiveBusinessVideocallVideo1;
    private final ConstraintLayout rootView;
    public final ConstraintLayout tutorVideoButton;
    public final TextView tutorVideoCallDes;
    public final ConstraintLayout tutorVideoCallLayout;
    public final ImageView tutorVideoCallStudentHeader;
    public final ImageView tutorVideoCallStudentPhone;
    public final ImageView tutorVideoCallTutorHeader;
    public final ImageView tutorVideoCallTutorPhone;
    public final ImageView tutorVideoCallTutorPhoneBg;
    public final TextView tutorVideoCallTutorTimer;
    public final ImageView tutorVideoCallVoice;
    public final ImageView tutorVideoError;
    public final TextView tutorVideocallExit;
    public final TextView tutorVideocallTips;

    private LiveBusinessTutorVideocallLayoutBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, RelativeLayout relativeLayout, ConstraintLayout constraintLayout2, TextView textView, ConstraintLayout constraintLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, TextView textView2, ImageView imageView6, ImageView imageView7, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.rlLiveBusinessTutorVideocall = frameLayout;
        this.rlLiveBusinessVideocallVideo1 = relativeLayout;
        this.tutorVideoButton = constraintLayout2;
        this.tutorVideoCallDes = textView;
        this.tutorVideoCallLayout = constraintLayout3;
        this.tutorVideoCallStudentHeader = imageView;
        this.tutorVideoCallStudentPhone = imageView2;
        this.tutorVideoCallTutorHeader = imageView3;
        this.tutorVideoCallTutorPhone = imageView4;
        this.tutorVideoCallTutorPhoneBg = imageView5;
        this.tutorVideoCallTutorTimer = textView2;
        this.tutorVideoCallVoice = imageView6;
        this.tutorVideoError = imageView7;
        this.tutorVideocallExit = textView3;
        this.tutorVideocallTips = textView4;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessTutorVideocallLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessTutorVideocallLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_tutor_videocall_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.tutor_video_button;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.tutor_video_call_layout;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessTutorVideocallLayoutBinding bind(android.view.View r20) {
        /*
            r0 = r20
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_tutor_videocall
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            if (r5 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_videocall_video_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            if (r6 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tutor_video_button
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tutor_video_call_des
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tutor_video_call_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            if (r9 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tutor_video_call_student_header
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tutor_video_call_student_phone
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tutor_video_call_tutor_header
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tutor_video_call_tutor_phone
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tutor_video_call_tutor_phone_bg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tutor_video_call_tutor_timer
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tutor_video_call_voice
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.ImageView r16 = (android.widget.ImageView) r16
            if (r16 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tutor_video_error
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.ImageView r17 = (android.widget.ImageView) r17
            if (r17 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tutor_videocall_exit
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00b5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tutor_videocall_tips
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00b5
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessTutorVideocallLayoutBinding r1 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessTutorVideocallLayoutBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessTutorVideocallLayoutBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessTutorVideocallLayoutBinding");
    }
}
