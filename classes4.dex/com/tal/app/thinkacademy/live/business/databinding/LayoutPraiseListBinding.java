package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LayoutPraiseListBinding implements ViewBinding {
    public final ImageView bgTemplate;
    public final ImageView btGroupLine1;
    public final ImageView btGroupLine2;
    public final ImageView btGroupLine3;
    public final ConstraintLayout emptyView;
    public final ImageView ivEmpty;
    public final ImageView ivInfoSignet;
    public final LottieAnimationView lottieView;
    private final ConstraintLayout rootView;
    public final RecyclerView rvStuList;
    public final TextView tvListSubTitle;
    public final TextView tvListTitle;
    public final TextView tvTopInfoClass;
    public final TextView tvTopInfoDate;
    public final TextView tvTopInfoLevel;

    private LayoutPraiseListBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout2, ImageView imageView5, ImageView imageView6, LottieAnimationView lottieAnimationView, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.bgTemplate = imageView;
        this.btGroupLine1 = imageView2;
        this.btGroupLine2 = imageView3;
        this.btGroupLine3 = imageView4;
        this.emptyView = constraintLayout2;
        this.ivEmpty = imageView5;
        this.ivInfoSignet = imageView6;
        this.lottieView = lottieAnimationView;
        this.rvStuList = recyclerView;
        this.tvListSubTitle = textView;
        this.tvListTitle = textView2;
        this.tvTopInfoClass = textView3;
        this.tvTopInfoDate = textView4;
        this.tvTopInfoLevel = textView5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutPraiseListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutPraiseListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_praise_list;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.lottieView;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005a, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.rvStuList;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.empty_view;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LayoutPraiseListBinding bind(android.view.View r19) {
        /*
            r0 = r19
            int r1 = com.tal.app.thinkacademy.live.business.R.id.bg_template
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.live.business.R.id.btGroupLine1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.live.business.R.id.btGroupLine2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.live.business.R.id.btGroupLine3
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.live.business.R.id.empty_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            if (r9 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_empty
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.live.business.R.id.ivInfoSignet
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.live.business.R.id.lottieView
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            com.airbnb.lottie.LottieAnimationView r12 = (com.airbnb.lottie.LottieAnimationView) r12
            if (r12 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rvStuList
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            androidx.recyclerview.widget.RecyclerView r13 = (androidx.recyclerview.widget.RecyclerView) r13
            if (r13 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tvListSubTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tvListTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tvTopInfoClass
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tvTopInfoDate
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00a9
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tvTopInfoLevel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00a9
            com.tal.app.thinkacademy.live.business.databinding.LayoutPraiseListBinding r1 = new com.tal.app.thinkacademy.live.business.databinding.LayoutPraiseListBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r1
        L_0x00a9:
            android.content.res.Resources r0 = r19.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LayoutPraiseListBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LayoutPraiseListBinding");
    }
}
