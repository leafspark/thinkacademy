package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;

public final class LiveBusinessDdstudentVideoSmallPadBinding implements ViewBinding {
    public final EmojiView emojiView;
    public final LinearLayout emojiViewBg;
    public final ImageView ivHead;
    public final ImageView ivLevel;
    public final ImageView ivMic;
    public final ImageView ivPen;
    public final LottieAnimationView lottieAddCoin10;
    public final LottieAnimationView lottieAddCoin5;
    public final CardView rlBg;
    public final CardView rlSurfaceView;
    private final FrameLayout rootView;
    public final TextView tvNickName;

    private LiveBusinessDdstudentVideoSmallPadBinding(FrameLayout frameLayout, EmojiView emojiView2, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, CardView cardView, CardView cardView2, TextView textView) {
        this.rootView = frameLayout;
        this.emojiView = emojiView2;
        this.emojiViewBg = linearLayout;
        this.ivHead = imageView;
        this.ivLevel = imageView2;
        this.ivMic = imageView3;
        this.ivPen = imageView4;
        this.lottieAddCoin10 = lottieAnimationView;
        this.lottieAddCoin5 = lottieAnimationView2;
        this.rlBg = cardView;
        this.rlSurfaceView = cardView2;
        this.tvNickName = textView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessDdstudentVideoSmallPadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessDdstudentVideoSmallPadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_ddstudent_video_small_pad;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.lottieAddCoin10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.lottieAddCoin5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0058, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.rlBg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0063, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.rlSurfaceView;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDdstudentVideoSmallPadBinding bind(android.view.View r15) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.emojiView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r4 = r1
            com.tal.app.thinkacademy.live.business.emoji.view.EmojiView r4 = (com.tal.app.thinkacademy.live.business.emoji.view.EmojiView) r4
            if (r4 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.emojiViewBg
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r5 = r1
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            if (r5 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivHead
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivLevel
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivMic
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivPen
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r9 = r1
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.lottieAddCoin10
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r10 = r1
            com.airbnb.lottie.LottieAnimationView r10 = (com.airbnb.lottie.LottieAnimationView) r10
            if (r10 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.lottieAddCoin5
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r11 = r1
            com.airbnb.lottie.LottieAnimationView r11 = (com.airbnb.lottie.LottieAnimationView) r11
            if (r11 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rlBg
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r12 = r1
            androidx.cardview.widget.CardView r12 = (androidx.cardview.widget.CardView) r12
            if (r12 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rlSurfaceView
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r13 = r1
            androidx.cardview.widget.CardView r13 = (androidx.cardview.widget.CardView) r13
            if (r13 == 0) goto L_0x0083
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tvNickName
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r15, r0)
            r14 = r1
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0083
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDdstudentVideoSmallPadBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDdstudentVideoSmallPadBinding
            r3 = r15
            android.widget.FrameLayout r3 = (android.widget.FrameLayout) r3
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDdstudentVideoSmallPadBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDdstudentVideoSmallPadBinding");
    }
}
