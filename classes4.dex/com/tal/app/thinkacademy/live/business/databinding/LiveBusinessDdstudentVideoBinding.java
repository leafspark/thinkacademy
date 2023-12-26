package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundRelativeLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.emoji.view.EmojiView;

public final class LiveBusinessDdstudentVideoBinding implements ViewBinding {
    public final EmojiView emojiView;
    public final LinearLayout emojiViewBg;
    public final ImageView ivHead;
    public final ImageView ivLevel;
    public final ImageView ivMic;
    public final ImageView ivPen;
    public final LottieAnimationView lottieAddCoin10;
    public final LottieAnimationView lottieAddCoin5;
    public final CardView rlBg;
    public final RoundRelativeLayout rlLottieMic;
    public final CardView rlSurfaceView;
    private final FrameLayout rootView;
    public final RoundTextView tvNickName;

    private LiveBusinessDdstudentVideoBinding(FrameLayout frameLayout, EmojiView emojiView2, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2, CardView cardView, RoundRelativeLayout roundRelativeLayout, CardView cardView2, RoundTextView roundTextView) {
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
        this.rlLottieMic = roundRelativeLayout;
        this.rlSurfaceView = cardView2;
        this.tvNickName = roundTextView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessDdstudentVideoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessDdstudentVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_ddstudent_video;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.lottieAddCoin10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.lottieAddCoin5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005a, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.rlBg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.rlLottieMic;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.rlSurfaceView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.tvNickName;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDdstudentVideoBinding bind(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.tal.app.thinkacademy.live.business.R.id.emojiView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.tal.app.thinkacademy.live.business.emoji.view.EmojiView r5 = (com.tal.app.thinkacademy.live.business.emoji.view.EmojiView) r5
            if (r5 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.emojiViewBg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.ivHead
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.ivLevel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.ivMic
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.ivPen
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.lottieAddCoin10
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            com.airbnb.lottie.LottieAnimationView r11 = (com.airbnb.lottie.LottieAnimationView) r11
            if (r11 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.lottieAddCoin5
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            com.airbnb.lottie.LottieAnimationView r12 = (com.airbnb.lottie.LottieAnimationView) r12
            if (r12 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rlBg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.cardview.widget.CardView r13 = (androidx.cardview.widget.CardView) r13
            if (r13 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rlLottieMic
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            com.flyco.roundview.RoundRelativeLayout r14 = (com.flyco.roundview.RoundRelativeLayout) r14
            if (r14 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rlSurfaceView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            androidx.cardview.widget.CardView r15 = (androidx.cardview.widget.CardView) r15
            if (r15 == 0) goto L_0x0091
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tvNickName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            com.flyco.roundview.RoundTextView r16 = (com.flyco.roundview.RoundTextView) r16
            if (r16 == 0) goto L_0x0091
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDdstudentVideoBinding r1 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDdstudentVideoBinding
            r4 = r0
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r1
        L_0x0091:
            android.content.res.Resources r0 = r17.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDdstudentVideoBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessDdstudentVideoBinding");
    }
}
