package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessItemRankingListLayoutBinding implements ViewBinding {
    public final ImageView ivRankingListWow;
    public final ImageView rankingListBadge;
    public final TextView rankingListCoins;
    public final ImageView rankingListCoinsImage;
    public final ConstraintLayout rankingListLayout;
    public final TextView rankingListName;
    private final ConstraintLayout rootView;

    private LiveBusinessItemRankingListLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, ImageView imageView3, ConstraintLayout constraintLayout2, TextView textView2) {
        this.rootView = constraintLayout;
        this.ivRankingListWow = imageView;
        this.rankingListBadge = imageView2;
        this.rankingListCoins = textView;
        this.rankingListCoinsImage = imageView3;
        this.rankingListLayout = constraintLayout2;
        this.rankingListName = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessItemRankingListLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessItemRankingListLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_item_ranking_list_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.ranking_list_layout;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessItemRankingListLayoutBinding bind(android.view.View r10) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_ranking_list_wow
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ranking_list_badge
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ranking_list_coins
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ranking_list_coins_image
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ranking_list_layout
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r8 = r1
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x004c
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ranking_list_name
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x004c
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessItemRankingListLayoutBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessItemRankingListLayoutBinding
            r3 = r10
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r0
        L_0x004c:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r10 = r1.concat(r10)
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessItemRankingListLayoutBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessItemRankingListLayoutBinding");
    }
}
