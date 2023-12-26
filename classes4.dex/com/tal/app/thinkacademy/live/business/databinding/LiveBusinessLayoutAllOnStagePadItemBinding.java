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
import com.flyco.roundview.RoundFrameLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;

public final class LiveBusinessLayoutAllOnStagePadItemBinding implements ViewBinding {
    public final RelativeLayout bottomLayout;
    public final EmojiView emojiView;
    public final LinearLayout emojiViewBg;
    public final ImageView micShow;
    public final RelativeLayout rlStudentRoot;
    public final RoundFrameLayout rootView;
    private final RoundFrameLayout rootView_;
    public final ImageView studentHead;
    public final RelativeLayout studentHeadBgParent;
    public final TextView studentName;
    public final FrameLayout studentVideoContainer;
    public final RoundTextView videoControlBtn;
    public final FrameLayout videoControlParent;

    private LiveBusinessLayoutAllOnStagePadItemBinding(RoundFrameLayout roundFrameLayout, RelativeLayout relativeLayout, EmojiView emojiView2, LinearLayout linearLayout, ImageView imageView, RelativeLayout relativeLayout2, RoundFrameLayout roundFrameLayout2, ImageView imageView2, RelativeLayout relativeLayout3, TextView textView, FrameLayout frameLayout, RoundTextView roundTextView, FrameLayout frameLayout2) {
        this.rootView_ = roundFrameLayout;
        this.bottomLayout = relativeLayout;
        this.emojiView = emojiView2;
        this.emojiViewBg = linearLayout;
        this.micShow = imageView;
        this.rlStudentRoot = relativeLayout2;
        this.rootView = roundFrameLayout2;
        this.studentHead = imageView2;
        this.studentHeadBgParent = relativeLayout3;
        this.studentName = textView;
        this.studentVideoContainer = frameLayout;
        this.videoControlBtn = roundTextView;
        this.videoControlParent = frameLayout2;
    }

    public RoundFrameLayout getRoot() {
        return this.rootView_;
    }

    public static LiveBusinessLayoutAllOnStagePadItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessLayoutAllOnStagePadItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_layout_all_on_stage_pad_item;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0068, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.video_control_btn;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutAllOnStagePadItemBinding bind(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.tal.app.thinkacademy.live.business.R.id.bottom_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            if (r5 == 0) goto L_0x0087
            int r1 = com.tal.app.thinkacademy.live.business.R.id.emoji_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.tal.app.thinkacademy.live.business.emoji.view.EmojiView r6 = (com.tal.app.thinkacademy.live.business.emoji.view.EmojiView) r6
            if (r6 == 0) goto L_0x0087
            int r1 = com.tal.app.thinkacademy.live.business.R.id.emoji_view_bg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x0087
            int r1 = com.tal.app.thinkacademy.live.business.R.id.mic_show
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0087
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_student_root
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.RelativeLayout r9 = (android.widget.RelativeLayout) r9
            if (r9 == 0) goto L_0x0087
            r10 = r0
            com.flyco.roundview.RoundFrameLayout r10 = (com.flyco.roundview.RoundFrameLayout) r10
            int r1 = com.tal.app.thinkacademy.live.business.R.id.student_head
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x0087
            int r1 = com.tal.app.thinkacademy.live.business.R.id.student_head_bg_parent
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            if (r12 == 0) goto L_0x0087
            int r1 = com.tal.app.thinkacademy.live.business.R.id.student_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0087
            int r1 = com.tal.app.thinkacademy.live.business.R.id.student_video_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.FrameLayout r14 = (android.widget.FrameLayout) r14
            if (r14 == 0) goto L_0x0087
            int r1 = com.tal.app.thinkacademy.live.business.R.id.video_control_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            com.flyco.roundview.RoundTextView r15 = (com.flyco.roundview.RoundTextView) r15
            if (r15 == 0) goto L_0x0087
            int r1 = com.tal.app.thinkacademy.live.business.R.id.video_control_parent
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.FrameLayout r16 = (android.widget.FrameLayout) r16
            if (r16 == 0) goto L_0x0087
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutAllOnStagePadItemBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutAllOnStagePadItemBinding
            r3 = r0
            r4 = r10
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r0
        L_0x0087:
            android.content.res.Resources r0 = r17.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutAllOnStagePadItemBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutAllOnStagePadItemBinding");
    }
}
