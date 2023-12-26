package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;

public final class LiveBusinessParentAuditSmallPadBinding implements ViewBinding {
    public final RelativeLayout bottomLayout;
    public final EmojiView emojiView;
    public final LinearLayout emojiViewBg;
    public final ImageView handUpImage;
    public final View handUpViewBg;
    public final ImageView ivStudentMic;
    public final TextView offlineView;
    public final RelativeLayout rootAudit;
    private final RelativeLayout rootView;
    public final ImageView studentHead;
    public final RelativeLayout studentHeadBgParent;
    public final ImageView studentHeadStage;
    public final ImageView studentLevel;
    public final TextView studentName;
    public final FrameLayout studentVideoContainer;

    private LiveBusinessParentAuditSmallPadBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, EmojiView emojiView2, LinearLayout linearLayout, ImageView imageView, View view, ImageView imageView2, TextView textView, RelativeLayout relativeLayout3, ImageView imageView3, RelativeLayout relativeLayout4, ImageView imageView4, ImageView imageView5, TextView textView2, FrameLayout frameLayout) {
        this.rootView = relativeLayout;
        this.bottomLayout = relativeLayout2;
        this.emojiView = emojiView2;
        this.emojiViewBg = linearLayout;
        this.handUpImage = imageView;
        this.handUpViewBg = view;
        this.ivStudentMic = imageView2;
        this.offlineView = textView;
        this.rootAudit = relativeLayout3;
        this.studentHead = imageView3;
        this.studentHeadBgParent = relativeLayout4;
        this.studentHeadStage = imageView4;
        this.studentLevel = imageView5;
        this.studentName = textView2;
        this.studentVideoContainer = frameLayout;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessParentAuditSmallPadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessParentAuditSmallPadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_parent_audit_small_pad;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.hand_up_view_bg;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessParentAuditSmallPadBinding bind(android.view.View r19) {
        /*
            r0 = r19
            int r1 = com.tal.app.thinkacademy.live.business.R.id.bottom_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            if (r5 == 0) goto L_0x009c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.emoji_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.tal.app.thinkacademy.live.business.emoji.view.EmojiView r6 = (com.tal.app.thinkacademy.live.business.emoji.view.EmojiView) r6
            if (r6 == 0) goto L_0x009c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.emoji_view_bg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x009c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.hand_up_image
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x009c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.hand_up_view_bg
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r9 == 0) goto L_0x009c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.ivStudentMic
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x009c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.offline_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x009c
            r12 = r0
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            int r1 = com.tal.app.thinkacademy.live.business.R.id.student_head
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x009c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.student_head_bg_parent
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.RelativeLayout r14 = (android.widget.RelativeLayout) r14
            if (r14 == 0) goto L_0x009c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.student_head_stage
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            if (r15 == 0) goto L_0x009c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.student_level
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.ImageView r16 = (android.widget.ImageView) r16
            if (r16 == 0) goto L_0x009c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.student_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x009c
            int r1 = com.tal.app.thinkacademy.live.business.R.id.student_video_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.FrameLayout r18 = (android.widget.FrameLayout) r18
            if (r18 == 0) goto L_0x009c
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessParentAuditSmallPadBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessParentAuditSmallPadBinding
            r3 = r0
            r4 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r0
        L_0x009c:
            android.content.res.Resources r0 = r19.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessParentAuditSmallPadBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessParentAuditSmallPadBinding");
    }
}
