package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessListEmojiAllonstageBinding implements ViewBinding {
    public final View bgLayoutTitle;
    public final ImageView btnClose;
    private final ConstraintLayout rootView;
    public final RecyclerView rvEmoji;
    public final TextView tvLayoutTitle;

    private LiveBusinessListEmojiAllonstageBinding(ConstraintLayout constraintLayout, View view, ImageView imageView, RecyclerView recyclerView, TextView textView) {
        this.rootView = constraintLayout;
        this.bgLayoutTitle = view;
        this.btnClose = imageView;
        this.rvEmoji = recyclerView;
        this.tvLayoutTitle = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessListEmojiAllonstageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessListEmojiAllonstageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_list_emoji_allonstage;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.rv_emoji;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessListEmojiAllonstageBinding bind(android.view.View r7) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.bg_layout_title
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r7, r0)
            if (r3 == 0) goto L_0x0033
            int r0 = com.tal.app.thinkacademy.live.business.R.id.btn_close
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r7, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0033
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rv_emoji
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r7, r0)
            r5 = r1
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            if (r5 == 0) goto L_0x0033
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_layout_title
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r7, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0033
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessListEmojiAllonstageBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessListEmojiAllonstageBinding
            r2 = r7
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            return r0
        L_0x0033:
            android.content.res.Resources r7 = r7.getResources()
            java.lang.String r7 = r7.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessListEmojiAllonstageBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessListEmojiAllonstageBinding");
    }
}
