package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessItemEmojiPayBinding implements ViewBinding {
    public final View bottomDiv;
    public final ImageView ivEmoji;
    public final View rightDiv;
    private final LinearLayout rootView;

    private LiveBusinessItemEmojiPayBinding(LinearLayout linearLayout, View view, ImageView imageView, View view2) {
        this.rootView = linearLayout;
        this.bottomDiv = view;
        this.ivEmoji = imageView;
        this.rightDiv = view2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessItemEmojiPayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessItemEmojiPayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_item_emoji_pay;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.rightDiv;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessItemEmojiPayBinding bind(android.view.View r4) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.bottomDiv
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            if (r1 == 0) goto L_0x0022
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivEmoji
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            if (r2 == 0) goto L_0x0022
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rightDiv
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r4, r0)
            if (r3 == 0) goto L_0x0022
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessItemEmojiPayBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessItemEmojiPayBinding
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            r0.<init>(r4, r1, r2, r3)
            return r0
        L_0x0022:
            android.content.res.Resources r4 = r4.getResources()
            java.lang.String r4 = r4.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessItemEmojiPayBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessItemEmojiPayBinding");
    }
}
