package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.yy.mobile.rollingtextview.RollingTextView;

public final class LiveBusinessStudentvideoBinding implements ViewBinding {
    public final RelativeLayout flLiveBusinessStudent1;
    public final RelativeLayout flLiveBusinessStudent2;
    public final RelativeLayout flLiveBusinessStudent3;
    public final RelativeLayout flLiveBusinessStudent4;
    public final ImageView ivLiveBusinessCamera1;
    public final ImageView ivLiveBusinessCoins;
    public final ImageView ivLiveBusinessHead1;
    public final ImageView ivLiveBusinessHead2;
    public final ImageView ivLiveBusinessHead2Exam;
    public final ImageView ivLiveBusinessHead3;
    public final ImageView ivLiveBusinessHead3Exam;
    public final ImageView ivLiveBusinessHead4;
    public final ImageView ivLiveBusinessHead4Exam;
    public final ImageView ivLiveBusinessLevel2;
    public final ImageView ivLiveBusinessLevel3;
    public final ImageView ivLiveBusinessLevel4;
    public final ImageView ivLiveBusinessMyLevel;
    public final ImageView ivLiveBusinessVideo2;
    public final ImageView ivLiveBusinessVideo3;
    public final ImageView ivLiveBusinessVideo4;
    public final LottieAnimationView livLiveBusinessVideoVoice2;
    public final LottieAnimationView livLiveBusinessVideoVoice3;
    public final LottieAnimationView livLiveBusinessVideoVoice4;
    public final RelativeLayout rlLiveBusinessHeadParent1;
    public final RelativeLayout rlLiveBusinessHeadParent2;
    public final RelativeLayout rlLiveBusinessHeadParent2Exam;
    public final RelativeLayout rlLiveBusinessHeadParent3;
    public final RelativeLayout rlLiveBusinessHeadParent3Exam;
    public final RelativeLayout rlLiveBusinessHeadParent4;
    public final RelativeLayout rlLiveBusinessHeadParent4Exam;
    public final RelativeLayout rlLiveBusinessStudent1;
    public final RelativeLayout rlLiveBusinessStudent2;
    public final RelativeLayout rlLiveBusinessStudent3;
    public final RelativeLayout rlLiveBusinessStudent4;
    private final ConstraintLayout rootView;
    public final TextView tvLiveBusinessName1;
    public final TextView tvLiveBusinessName2;
    public final TextView tvLiveBusinessName3;
    public final TextView tvLiveBusinessName4;
    public final RollingTextView tvLiveBusinessUserCoins;

    private LiveBusinessStudentvideoBinding(ConstraintLayout constraintLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12, ImageView imageView13, ImageView imageView14, ImageView imageView15, ImageView imageView16, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, LottieAnimationView lottieAnimationView3, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, RelativeLayout relativeLayout10, RelativeLayout relativeLayout11, RelativeLayout relativeLayout12, RelativeLayout relativeLayout13, RelativeLayout relativeLayout14, RelativeLayout relativeLayout15, TextView textView, TextView textView2, TextView textView3, TextView textView4, RollingTextView rollingTextView) {
        this.rootView = constraintLayout;
        this.flLiveBusinessStudent1 = relativeLayout;
        this.flLiveBusinessStudent2 = relativeLayout2;
        this.flLiveBusinessStudent3 = relativeLayout3;
        this.flLiveBusinessStudent4 = relativeLayout4;
        this.ivLiveBusinessCamera1 = imageView;
        this.ivLiveBusinessCoins = imageView2;
        this.ivLiveBusinessHead1 = imageView3;
        this.ivLiveBusinessHead2 = imageView4;
        this.ivLiveBusinessHead2Exam = imageView5;
        this.ivLiveBusinessHead3 = imageView6;
        this.ivLiveBusinessHead3Exam = imageView7;
        this.ivLiveBusinessHead4 = imageView8;
        this.ivLiveBusinessHead4Exam = imageView9;
        this.ivLiveBusinessLevel2 = imageView10;
        this.ivLiveBusinessLevel3 = imageView11;
        this.ivLiveBusinessLevel4 = imageView12;
        this.ivLiveBusinessMyLevel = imageView13;
        this.ivLiveBusinessVideo2 = imageView14;
        this.ivLiveBusinessVideo3 = imageView15;
        this.ivLiveBusinessVideo4 = imageView16;
        this.livLiveBusinessVideoVoice2 = lottieAnimationView;
        this.livLiveBusinessVideoVoice3 = lottieAnimationView2;
        this.livLiveBusinessVideoVoice4 = lottieAnimationView3;
        this.rlLiveBusinessHeadParent1 = relativeLayout5;
        this.rlLiveBusinessHeadParent2 = relativeLayout6;
        this.rlLiveBusinessHeadParent2Exam = relativeLayout7;
        this.rlLiveBusinessHeadParent3 = relativeLayout8;
        this.rlLiveBusinessHeadParent3Exam = relativeLayout9;
        this.rlLiveBusinessHeadParent4 = relativeLayout10;
        this.rlLiveBusinessHeadParent4Exam = relativeLayout11;
        this.rlLiveBusinessStudent1 = relativeLayout12;
        this.rlLiveBusinessStudent2 = relativeLayout13;
        this.rlLiveBusinessStudent3 = relativeLayout14;
        this.rlLiveBusinessStudent4 = relativeLayout15;
        this.tvLiveBusinessName1 = textView;
        this.tvLiveBusinessName2 = textView2;
        this.tvLiveBusinessName3 = textView3;
        this.tvLiveBusinessName4 = textView4;
        this.tvLiveBusinessUserCoins = rollingTextView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessStudentvideoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessStudentvideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_studentvideo;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e7, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.liv_live_business_video_voice_2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f3, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.liv_live_business_video_voice_3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ff, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.liv_live_business_video_voice_4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01bf, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_user_coins;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessStudentvideoBinding bind(android.view.View r44) {
        /*
            r0 = r44
            int r1 = com.tal.app.thinkacademy.live.business.R.id.fl_live_business_student_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            if (r5 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.fl_live_business_student_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            if (r6 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.fl_live_business_student_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7
            if (r7 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.fl_live_business_student_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
            if (r8 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_camera_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_coins
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_head1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_head2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_head2_exam
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_head3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_head3_exam
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            if (r15 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_head4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.ImageView r16 = (android.widget.ImageView) r16
            if (r16 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_head4_exam
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.ImageView r17 = (android.widget.ImageView) r17
            if (r17 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_level_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.ImageView r18 = (android.widget.ImageView) r18
            if (r18 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_level_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.ImageView r19 = (android.widget.ImageView) r19
            if (r19 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_level_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.ImageView r20 = (android.widget.ImageView) r20
            if (r20 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_my_level
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.ImageView r21 = (android.widget.ImageView) r21
            if (r21 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_video_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.ImageView r22 = (android.widget.ImageView) r22
            if (r22 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_video_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.ImageView r23 = (android.widget.ImageView) r23
            if (r23 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_video_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.ImageView r24 = (android.widget.ImageView) r24
            if (r24 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.liv_live_business_video_voice_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            com.airbnb.lottie.LottieAnimationView r25 = (com.airbnb.lottie.LottieAnimationView) r25
            if (r25 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.liv_live_business_video_voice_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            com.airbnb.lottie.LottieAnimationView r26 = (com.airbnb.lottie.LottieAnimationView) r26
            if (r26 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.liv_live_business_video_voice_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            com.airbnb.lottie.LottieAnimationView r27 = (com.airbnb.lottie.LottieAnimationView) r27
            if (r27 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_head_parent1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            android.widget.RelativeLayout r28 = (android.widget.RelativeLayout) r28
            if (r28 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_head_parent2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r29 = r2
            android.widget.RelativeLayout r29 = (android.widget.RelativeLayout) r29
            if (r29 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_head_parent2_exam
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r30 = r2
            android.widget.RelativeLayout r30 = (android.widget.RelativeLayout) r30
            if (r30 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_head_parent3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r31 = r2
            android.widget.RelativeLayout r31 = (android.widget.RelativeLayout) r31
            if (r31 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_head_parent3_exam
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r32 = r2
            android.widget.RelativeLayout r32 = (android.widget.RelativeLayout) r32
            if (r32 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_head_parent4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r33 = r2
            android.widget.RelativeLayout r33 = (android.widget.RelativeLayout) r33
            if (r33 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_head_parent4_exam
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r34 = r2
            android.widget.RelativeLayout r34 = (android.widget.RelativeLayout) r34
            if (r34 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_student_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r35 = r2
            android.widget.RelativeLayout r35 = (android.widget.RelativeLayout) r35
            if (r35 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_student_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r36 = r2
            android.widget.RelativeLayout r36 = (android.widget.RelativeLayout) r36
            if (r36 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_student_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r37 = r2
            android.widget.RelativeLayout r37 = (android.widget.RelativeLayout) r37
            if (r37 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_live_business_student_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r38 = r2
            android.widget.RelativeLayout r38 = (android.widget.RelativeLayout) r38
            if (r38 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_name_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r39 = r2
            android.widget.TextView r39 = (android.widget.TextView) r39
            if (r39 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_name_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r40 = r2
            android.widget.TextView r40 = (android.widget.TextView) r40
            if (r40 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_name_3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r41 = r2
            android.widget.TextView r41 = (android.widget.TextView) r41
            if (r41 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_name_4
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r42 = r2
            android.widget.TextView r42 = (android.widget.TextView) r42
            if (r42 == 0) goto L_0x01d5
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_user_coins
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r43 = r2
            com.yy.mobile.rollingtextview.RollingTextView r43 = (com.yy.mobile.rollingtextview.RollingTextView) r43
            if (r43 == 0) goto L_0x01d5
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessStudentvideoBinding r1 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessStudentvideoBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43)
            return r1
        L_0x01d5:
            android.content.res.Resources r0 = r44.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessStudentvideoBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessStudentvideoBinding");
    }
}
