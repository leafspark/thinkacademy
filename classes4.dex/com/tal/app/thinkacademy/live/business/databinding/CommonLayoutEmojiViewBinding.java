package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class CommonLayoutEmojiViewBinding implements ViewBinding {
    public final RecyclerView emojiChildRecycle;
    public final RecyclerView emojiPackageRecycle;
    private final LinearLayout rootView;

    private CommonLayoutEmojiViewBinding(LinearLayout linearLayout, RecyclerView recyclerView, RecyclerView recyclerView2) {
        this.rootView = linearLayout;
        this.emojiChildRecycle = recyclerView;
        this.emojiPackageRecycle = recyclerView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CommonLayoutEmojiViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static CommonLayoutEmojiViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.common_layout_emoji_view;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.emojiPackageRecycle;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.CommonLayoutEmojiViewBinding bind(android.view.View r3) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.emojiChildRecycle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            if (r1 == 0) goto L_0x001c
            int r0 = com.tal.app.thinkacademy.live.business.R.id.emojiPackageRecycle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            androidx.recyclerview.widget.RecyclerView r2 = (androidx.recyclerview.widget.RecyclerView) r2
            if (r2 == 0) goto L_0x001c
            com.tal.app.thinkacademy.live.business.databinding.CommonLayoutEmojiViewBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.CommonLayoutEmojiViewBinding
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r0.<init>(r3, r1, r2)
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.CommonLayoutEmojiViewBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.CommonLayoutEmojiViewBinding");
    }
}
