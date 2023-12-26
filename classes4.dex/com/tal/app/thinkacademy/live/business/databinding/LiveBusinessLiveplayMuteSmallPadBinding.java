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
import com.tal.app.thinkacademy.lib.commui.widget.MarqueeText;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessLiveplayMuteSmallPadBinding implements ViewBinding {
    public final RelativeLayout bottomLayout;
    public final ImageView ivStudentMic;
    public final ImageView noTeacherBg;
    public final ConstraintLayout onStageLayout;
    public final TextView onStageText;
    public final MarqueeText privatChatTips;
    private final ConstraintLayout rootView;
    public final MarqueeText studentName;
    public final ImageView teacherAvatar;

    private LiveBusinessLiveplayMuteSmallPadBinding(ConstraintLayout constraintLayout, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, TextView textView, MarqueeText marqueeText, MarqueeText marqueeText2, ImageView imageView3) {
        this.rootView = constraintLayout;
        this.bottomLayout = relativeLayout;
        this.ivStudentMic = imageView;
        this.noTeacherBg = imageView2;
        this.onStageLayout = constraintLayout2;
        this.onStageText = textView;
        this.privatChatTips = marqueeText;
        this.studentName = marqueeText2;
        this.teacherAvatar = imageView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessLiveplayMuteSmallPadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessLiveplayMuteSmallPadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_liveplay_mute_small_pad;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.on_stage_layout;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveplayMuteSmallPadBinding bind(android.view.View r12) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.bottom_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            if (r4 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivStudentMic
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.live.business.R.id.no_teacher_bg
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.live.business.R.id.on_stage_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r7 = r1
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.live.business.R.id.on_stage_text
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.live.business.R.id.privat_chat_tips
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r9 = r1
            com.tal.app.thinkacademy.lib.commui.widget.MarqueeText r9 = (com.tal.app.thinkacademy.lib.commui.widget.MarqueeText) r9
            if (r9 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.live.business.R.id.student_name
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r10 = r1
            com.tal.app.thinkacademy.lib.commui.widget.MarqueeText r10 = (com.tal.app.thinkacademy.lib.commui.widget.MarqueeText) r10
            if (r10 == 0) goto L_0x0062
            int r0 = com.tal.app.thinkacademy.live.business.R.id.teacher_avatar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x0062
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveplayMuteSmallPadBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveplayMuteSmallPadBinding
            r3 = r12
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x0062:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveplayMuteSmallPadBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveplayMuteSmallPadBinding");
    }
}
