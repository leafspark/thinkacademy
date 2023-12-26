package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LayoutEmojiViewBinding implements ViewBinding {
    public final ImageView emojiIV;
    public final LottieAnimationView emojiLV;
    public final RelativeLayout rootRL;
    private final RelativeLayout rootView;

    private LayoutEmojiViewBinding(RelativeLayout relativeLayout, ImageView imageView, LottieAnimationView lottieAnimationView, RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.emojiIV = imageView;
        this.emojiLV = lottieAnimationView;
        this.rootRL = relativeLayout2;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutEmojiViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutEmojiViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_emoji_view;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.emojiLV;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LayoutEmojiViewBinding bind(android.view.View r3) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.emojiIV
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x001c
            int r0 = com.tal.app.thinkacademy.live.business.R.id.emojiLV
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            com.airbnb.lottie.LottieAnimationView r2 = (com.airbnb.lottie.LottieAnimationView) r2
            if (r2 == 0) goto L_0x001c
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            com.tal.app.thinkacademy.live.business.databinding.LayoutEmojiViewBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LayoutEmojiViewBinding
            r0.<init>(r3, r1, r2, r3)
            return r0
        L_0x001c:
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r3 = r3.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r3 = r1.concat(r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LayoutEmojiViewBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LayoutEmojiViewBinding");
    }
}
