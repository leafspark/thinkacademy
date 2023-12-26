package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessLiveplayMuteBinding implements ViewBinding {
    public final RoundLinearLayout layoutLivebusinessLiveplayMute;
    public final ImageView noTeacherBg;
    public final ConstraintLayout onStageLayout;
    public final RoundTextView onStageText;
    private final ConstraintLayout rootView;
    public final ImageView teacherAvatar;

    private LiveBusinessLiveplayMuteBinding(ConstraintLayout constraintLayout, RoundLinearLayout roundLinearLayout, ImageView imageView, ConstraintLayout constraintLayout2, RoundTextView roundTextView, ImageView imageView2) {
        this.rootView = constraintLayout;
        this.layoutLivebusinessLiveplayMute = roundLinearLayout;
        this.noTeacherBg = imageView;
        this.onStageLayout = constraintLayout2;
        this.onStageText = roundTextView;
        this.teacherAvatar = imageView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessLiveplayMuteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessLiveplayMuteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_liveplay_mute;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.on_stage_layout;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.on_stage_text;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveplayMuteBinding bind(android.view.View r9) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_livebusiness_liveplay_mute
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            com.flyco.roundview.RoundLinearLayout r4 = (com.flyco.roundview.RoundLinearLayout) r4
            if (r4 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.live.business.R.id.no_teacher_bg
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.live.business.R.id.on_stage_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r6 = r1
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.live.business.R.id.on_stage_text
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            com.flyco.roundview.RoundTextView r7 = (com.flyco.roundview.RoundTextView) r7
            if (r7 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.live.business.R.id.teacher_avatar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0041
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveplayMuteBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveplayMuteBinding
            r3 = r9
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x0041:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveplayMuteBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLiveplayMuteBinding");
    }
}
