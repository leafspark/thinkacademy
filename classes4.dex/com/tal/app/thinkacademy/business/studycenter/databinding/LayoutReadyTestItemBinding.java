package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class LayoutReadyTestItemBinding implements ViewBinding {
    public final ImageView imgTestItem;
    public final ImageView imgTestItemResult;
    public final LottieAnimationView progressTestItem;
    private final LinearLayout rootView;
    public final TextView tvTestItem;

    private LayoutReadyTestItemBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, LottieAnimationView lottieAnimationView, TextView textView) {
        this.rootView = linearLayout;
        this.imgTestItem = imageView;
        this.imgTestItemResult = imageView2;
        this.progressTestItem = lottieAnimationView;
        this.tvTestItem = textView;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutReadyTestItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutReadyTestItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_ready_test_item;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.progress_test_item;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.LayoutReadyTestItemBinding bind(android.view.View r8) {
        /*
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.img_test_item
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0036
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.img_test_item_result
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0036
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.progress_test_item
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r6 = r1
            com.airbnb.lottie.LottieAnimationView r6 = (com.airbnb.lottie.LottieAnimationView) r6
            if (r6 == 0) goto L_0x0036
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_test_item
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r8, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0036
            com.tal.app.thinkacademy.business.studycenter.databinding.LayoutReadyTestItemBinding r0 = new com.tal.app.thinkacademy.business.studycenter.databinding.LayoutReadyTestItemBinding
            r3 = r8
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        L_0x0036:
            android.content.res.Resources r8 = r8.getResources()
            java.lang.String r8 = r8.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r8 = r1.concat(r8)
            r0.<init>(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.LayoutReadyTestItemBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.LayoutReadyTestItemBinding");
    }
}
