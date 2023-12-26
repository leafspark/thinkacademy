package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import java.util.Objects;

public final class LayoutSchulteTableResultBinding implements ViewBinding {
    public final View bgTransCover;
    public final FrameLayout layoutResultBelt;
    public final FrameLayout layoutResultBestTime;
    public final FrameLayout layoutResultCurTime;
    public final LottieAnimationView lottieResultCup;
    private final View rootView;
    public final TextView tvResultBelt;
    public final TextView tvResultBestTime;
    public final TextView tvResultCurTime;
    public final TextView tvResultNewRecord;

    private LayoutSchulteTableResultBinding(View view, View view2, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, LottieAnimationView lottieAnimationView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = view;
        this.bgTransCover = view2;
        this.layoutResultBelt = frameLayout;
        this.layoutResultBestTime = frameLayout2;
        this.layoutResultCurTime = frameLayout3;
        this.lottieResultCup = lottieAnimationView;
        this.tvResultBelt = textView;
        this.tvResultBestTime = textView2;
        this.tvResultCurTime = textView3;
        this.tvResultNewRecord = textView4;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static LayoutSchulteTableResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Objects.requireNonNull(viewGroup, "parent");
        int i = R.layout.layout_schulte_table_result;
        if (!(layoutInflater instanceof LayoutInflater)) {
            layoutInflater.inflate(i, viewGroup);
        } else {
            XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup);
        }
        return bind(viewGroup);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.lottie_result_cup;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTableResultBinding bind(android.view.View r12) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.bg_trans_cover
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r3 == 0) goto L_0x0068
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_result_belt
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r4 = r1
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            if (r4 == 0) goto L_0x0068
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_result_best_time
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r5 = r1
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            if (r5 == 0) goto L_0x0068
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_result_cur_time
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r6 = r1
            android.widget.FrameLayout r6 = (android.widget.FrameLayout) r6
            if (r6 == 0) goto L_0x0068
            int r0 = com.tal.app.thinkacademy.live.business.R.id.lottie_result_cup
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r7 = r1
            com.airbnb.lottie.LottieAnimationView r7 = (com.airbnb.lottie.LottieAnimationView) r7
            if (r7 == 0) goto L_0x0068
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_result_belt
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0068
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_result_best_time
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0068
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_result_cur_time
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0068
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_result_new_record
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0068
            com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTableResultBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTableResultBinding
            r1 = r0
            r2 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r0
        L_0x0068:
            android.content.res.Resources r12 = r12.getResources()
            java.lang.String r12 = r12.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r12 = r1.concat(r12)
            r0.<init>(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTableResultBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LayoutSchulteTableResultBinding");
    }
}
