package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundRelativeLayout;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;

public final class LiveBusinessParentAuditBigPadBinding implements ViewBinding {
    public final RelativeLayout bottomLayout;
    public final EmojiView emojiView;
    public final ImageView handUpImage;
    public final ImageView micHide;
    public final RoundRelativeLayout micParentView;
    public final ImageView micShow;
    public final TextView offlineView;
    public final RelativeLayout rootAudit;
    private final RelativeLayout rootView;
    public final ImageView studentHead;
    public final RelativeLayout studentHeadBgParent;
    public final ImageView studentHeadStage;
    public final FrameLayout studentHeadStageParent;
    public final ImageView studentLevel;
    public final TextView studentName;
    public final FrameLayout studentVideoContainer;

    private LiveBusinessParentAuditBigPadBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, EmojiView emojiView2, ImageView imageView, ImageView imageView2, RoundRelativeLayout roundRelativeLayout, ImageView imageView3, TextView textView, RelativeLayout relativeLayout3, ImageView imageView4, RelativeLayout relativeLayout4, ImageView imageView5, FrameLayout frameLayout, ImageView imageView6, TextView textView2, FrameLayout frameLayout2) {
        this.rootView = relativeLayout;
        this.bottomLayout = relativeLayout2;
        this.emojiView = emojiView2;
        this.handUpImage = imageView;
        this.micHide = imageView2;
        this.micParentView = roundRelativeLayout;
        this.micShow = imageView3;
        this.offlineView = textView;
        this.rootAudit = relativeLayout3;
        this.studentHead = imageView4;
        this.studentHeadBgParent = relativeLayout4;
        this.studentHeadStage = imageView5;
        this.studentHeadStageParent = frameLayout;
        this.studentLevel = imageView6;
        this.studentName = textView2;
        this.studentVideoContainer = frameLayout2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessParentAuditBigPadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessParentAuditBigPadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_parent_audit_big_pad;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.mic_parent_view;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessParentAuditBigPadBinding bind(android.view.View r20) {
        /*
            r0 = r20
            int r1 = com.tal.app.thinkacademy.live.business.R.id.bottom_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            if (r5 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.live.business.R.id.emoji_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.tal.app.thinkacademy.live.business.emoji.view.EmojiView r6 = (com.tal.app.thinkacademy.live.business.emoji.view.EmojiView) r6
            if (r6 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.live.business.R.id.hand_up_image
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.live.business.R.id.mic_hide
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.live.business.R.id.mic_parent_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            com.flyco.roundview.RoundRelativeLayout r9 = (com.flyco.roundview.RoundRelativeLayout) r9
            if (r9 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.live.business.R.id.mic_show
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.live.business.R.id.offline_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x00ab
            r12 = r0
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            int r1 = com.tal.app.thinkacademy.live.business.R.id.student_head
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.live.business.R.id.student_head_bg_parent
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.RelativeLayout r14 = (android.widget.RelativeLayout) r14
            if (r14 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.live.business.R.id.student_head_stage
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            if (r15 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.live.business.R.id.student_head_stage_parent
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.FrameLayout r16 = (android.widget.FrameLayout) r16
            if (r16 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.live.business.R.id.student_level
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.ImageView r17 = (android.widget.ImageView) r17
            if (r17 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.live.business.R.id.student_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00ab
            int r1 = com.tal.app.thinkacademy.live.business.R.id.student_video_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.FrameLayout r19 = (android.widget.FrameLayout) r19
            if (r19 == 0) goto L_0x00ab
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessParentAuditBigPadBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessParentAuditBigPadBinding
            r3 = r0
            r4 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        L_0x00ab:
            android.content.res.Resources r0 = r20.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessParentAuditBigPadBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessParentAuditBigPadBinding");
    }
}
