package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.allonstage.view.TeacherView;

public final class LiveBusinessLayoutAllOnStagePhoneBinding implements ViewBinding {
    public final FrameLayout allStageFrameFunction;
    public final RecyclerView allStageStudentRecyclerview;
    public final TeacherView allStageTeacherRoot;
    public final TextView btnAudioMute;
    public final ImageView btnBack;
    public final TextView btnEmoji;
    public final ImageView ivAudioMute;
    public final ImageView ivWifi;
    private final ConstraintLayout rootView;
    public final TextView tvTitle;

    private LiveBusinessLayoutAllOnStagePhoneBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, RecyclerView recyclerView, TeacherView teacherView, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2, ImageView imageView3, TextView textView3) {
        this.rootView = constraintLayout;
        this.allStageFrameFunction = frameLayout;
        this.allStageStudentRecyclerview = recyclerView;
        this.allStageTeacherRoot = teacherView;
        this.btnAudioMute = textView;
        this.btnBack = imageView;
        this.btnEmoji = textView2;
        this.ivAudioMute = imageView2;
        this.ivWifi = imageView3;
        this.tvTitle = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessLayoutAllOnStagePhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessLayoutAllOnStagePhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_layout_all_on_stage_phone;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.all_stage_student_recyclerview;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutAllOnStagePhoneBinding bind(android.view.View r13) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.all_stage_frame_function
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            if (r4 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.all_stage_student_recyclerview
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            if (r5 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.all_stage_teacher_root
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r6 = r1
            com.tal.app.thinkacademy.live.business.allonstage.view.TeacherView r6 = (com.tal.app.thinkacademy.live.business.allonstage.view.TeacherView) r6
            if (r6 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.btn_audio_mute
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.btn_back
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.btn_emoji
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_audio_mute
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r10 = r1
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_wifi
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x006d
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutAllOnStagePhoneBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutAllOnStagePhoneBinding
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutAllOnStagePhoneBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutAllOnStagePhoneBinding");
    }
}
