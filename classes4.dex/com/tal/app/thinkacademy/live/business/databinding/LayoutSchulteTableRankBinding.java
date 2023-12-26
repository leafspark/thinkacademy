package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import java.util.Objects;

public final class LayoutSchulteTableRankBinding implements ViewBinding {
    public final View bgRankTransCover;
    public final ImageView ivRankFlagsRight;
    public final FrameLayout layoutRankBoard;
    public final FrameLayout layoutRankFlags;
    public final LinearLayout layoutRankSelf;
    public final LottieAnimationView lottieRankHorn;
    public final TextView rankCoins;
    public final ImageView rankHead;
    public final TextView rankName;
    public final TextView rankNumber;
    public final TextView rankScore;
    private final View rootView;
    public final RecyclerView rvRank;
    public final TextView tvRankJoin;

    private LayoutSchulteTableRankBinding(View view, View view2, ImageView imageView, FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout, LottieAnimationView lottieAnimationView, TextView textView, ImageView imageView2, TextView textView2, TextView textView3, TextView textView4, RecyclerView recyclerView, TextView textView5) {
        this.rootView = view;
        this.bgRankTransCover = view2;
        this.ivRankFlagsRight = imageView;
        this.layoutRankBoard = frameLayout;
        this.layoutRankFlags = frameLayout2;
        this.layoutRankSelf = linearLayout;
        this.lottieRankHorn = lottieAnimationView;
        this.rankCoins = textView;
        this.rankHead = imageView2;
        this.rankName = textView2;
        this.rankNumber = textView3;
        this.rankScore = textView4;
        this.rvRank = recyclerView;
        this.tvRankJoin = textView5;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static LayoutSchulteTableRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        int i = R.layout.layout_schulte_table_rank;
        if (!(layoutInflater instanceof LayoutInflater)) {
            layoutInflater.inflate(i, viewGroup);
        } else {
            XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup);
        }
        return bind(viewGroup);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.lottie_rank_horn;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006e, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.rv_rank;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTableRankBinding bind(android.view.View r16) {
        /*
            r1 = r16
            int r0 = com.tal.app.thinkacademy.live.business.R.id.bg_rank_trans_cover
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            if (r2 == 0) goto L_0x008b
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_rank_flags_right
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            if (r3 == 0) goto L_0x008b
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_rank_board
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            if (r4 == 0) goto L_0x008b
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_rank_flags
            android.view.View r5 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            if (r5 == 0) goto L_0x008b
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_rank_self
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x008b
            int r0 = com.tal.app.thinkacademy.live.business.R.id.lottie_rank_horn
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            com.airbnb.lottie.LottieAnimationView r7 = (com.airbnb.lottie.LottieAnimationView) r7
            if (r7 == 0) goto L_0x008b
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rank_coins
            android.view.View r8 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x008b
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rank_head
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x008b
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rank_name
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x008b
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rank_number
            android.view.View r11 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x008b
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rank_score
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x008b
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rv_rank
            android.view.View r13 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            androidx.recyclerview.widget.RecyclerView r13 = (androidx.recyclerview.widget.RecyclerView) r13
            if (r13 == 0) goto L_0x008b
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_rank_join
            android.view.View r14 = androidx.viewbinding.ViewBindings.findChildViewById(r1, r0)
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x008b
            com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTableRankBinding r15 = new com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTableRankBinding
            r0 = r15
            r1 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r15
        L_0x008b:
            android.content.res.Resources r1 = r16.getResources()
            java.lang.String r0 = r1.getResourceName(r0)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTableRankBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTableRankBinding");
    }
}
