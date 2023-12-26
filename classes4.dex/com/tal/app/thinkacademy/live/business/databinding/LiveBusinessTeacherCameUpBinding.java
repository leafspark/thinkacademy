package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundRelativeLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessTeacherCameUpBinding implements ViewBinding {
    public final ConstraintLayout clFullScreenBg;
    public final CardView cvFullSurfaceView;
    public final CardView cvRoundBg;
    public final CardView cvSurfaceView;
    public final ImageView ivMic1;
    public final ImageView ivMic2;
    public final RoundRelativeLayout micParentLayout;
    public final RoundTextView privateCallLabel;
    public final RoundTextView privateCallLabelFull;
    public final RelativeLayout rlFullScreenView;
    public final RoundRelativeLayout rlRoundView;
    private final FrameLayout rootView;
    public final ImageView teacherAvatarBg;
    public final TextView tvTeacherName1;
    public final TextView tvTeacherName2;
    public final FrameLayout videoArea;
    public final FrameLayout videoRemovableArea;

    private LiveBusinessTeacherCameUpBinding(FrameLayout frameLayout, ConstraintLayout constraintLayout, CardView cardView, CardView cardView2, CardView cardView3, ImageView imageView, ImageView imageView2, RoundRelativeLayout roundRelativeLayout, RoundTextView roundTextView, RoundTextView roundTextView2, RelativeLayout relativeLayout, RoundRelativeLayout roundRelativeLayout2, ImageView imageView3, TextView textView, TextView textView2, FrameLayout frameLayout2, FrameLayout frameLayout3) {
        this.rootView = frameLayout;
        this.clFullScreenBg = constraintLayout;
        this.cvFullSurfaceView = cardView;
        this.cvRoundBg = cardView2;
        this.cvSurfaceView = cardView3;
        this.ivMic1 = imageView;
        this.ivMic2 = imageView2;
        this.micParentLayout = roundRelativeLayout;
        this.privateCallLabel = roundTextView;
        this.privateCallLabelFull = roundTextView2;
        this.rlFullScreenView = relativeLayout;
        this.rlRoundView = roundRelativeLayout2;
        this.teacherAvatarBg = imageView3;
        this.tvTeacherName1 = textView;
        this.tvTeacherName2 = textView2;
        this.videoArea = frameLayout2;
        this.videoRemovableArea = frameLayout3;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessTeacherCameUpBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessTeacherCameUpBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_teacher_came_up;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.mic_parent_layout;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.privateCallLabel;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005a, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.privateCallLabelFull;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.rlRoundView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.cvFullSurfaceView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.cvRoundBg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.cvSurfaceView;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessTeacherCameUpBinding bind(android.view.View r21) {
        /*
            r0 = r21
            int r1 = com.tal.app.thinkacademy.live.business.R.id.clFullScreenBg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x00b8
            int r1 = com.tal.app.thinkacademy.live.business.R.id.cvFullSurfaceView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.cardview.widget.CardView r6 = (androidx.cardview.widget.CardView) r6
            if (r6 == 0) goto L_0x00b8
            int r1 = com.tal.app.thinkacademy.live.business.R.id.cvRoundBg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.cardview.widget.CardView r7 = (androidx.cardview.widget.CardView) r7
            if (r7 == 0) goto L_0x00b8
            int r1 = com.tal.app.thinkacademy.live.business.R.id.cvSurfaceView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.cardview.widget.CardView r8 = (androidx.cardview.widget.CardView) r8
            if (r8 == 0) goto L_0x00b8
            int r1 = com.tal.app.thinkacademy.live.business.R.id.ivMic1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x00b8
            int r1 = com.tal.app.thinkacademy.live.business.R.id.ivMic2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00b8
            int r1 = com.tal.app.thinkacademy.live.business.R.id.mic_parent_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            com.flyco.roundview.RoundRelativeLayout r11 = (com.flyco.roundview.RoundRelativeLayout) r11
            if (r11 == 0) goto L_0x00b8
            int r1 = com.tal.app.thinkacademy.live.business.R.id.privateCallLabel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            com.flyco.roundview.RoundTextView r12 = (com.flyco.roundview.RoundTextView) r12
            if (r12 == 0) goto L_0x00b8
            int r1 = com.tal.app.thinkacademy.live.business.R.id.privateCallLabelFull
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            com.flyco.roundview.RoundTextView r13 = (com.flyco.roundview.RoundTextView) r13
            if (r13 == 0) goto L_0x00b8
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rlFullScreenView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.RelativeLayout r14 = (android.widget.RelativeLayout) r14
            if (r14 == 0) goto L_0x00b8
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rlRoundView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            com.flyco.roundview.RoundRelativeLayout r15 = (com.flyco.roundview.RoundRelativeLayout) r15
            if (r15 == 0) goto L_0x00b8
            int r1 = com.tal.app.thinkacademy.live.business.R.id.teacher_avatar_bg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.ImageView r16 = (android.widget.ImageView) r16
            if (r16 == 0) goto L_0x00b8
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tvTeacherName1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00b8
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tvTeacherName2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00b8
            int r1 = com.tal.app.thinkacademy.live.business.R.id.videoArea
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.FrameLayout r19 = (android.widget.FrameLayout) r19
            if (r19 == 0) goto L_0x00b8
            r20 = r0
            android.widget.FrameLayout r20 = (android.widget.FrameLayout) r20
            r4 = r20
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessTeacherCameUpBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessTeacherCameUpBinding
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        L_0x00b8:
            android.content.res.Resources r0 = r21.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessTeacherCameUpBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessTeacherCameUpBinding");
    }
}
