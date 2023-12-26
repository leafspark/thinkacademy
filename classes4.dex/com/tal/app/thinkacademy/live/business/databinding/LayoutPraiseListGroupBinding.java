package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundFrameLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkcademy.lib.commui.widget.likegroup.FlyAnimGroup;

public final class LayoutPraiseListGroupBinding implements ViewBinding {
    public final View bgScreenshot;
    public final View bgScreenshotWhite;
    public final FlyAnimGroup flyAnimGroup;
    public final ImageView ivDownload;
    public final ImageView ivLike;
    public final ImageView ivScreenshot;
    public final LayoutPraiseListBinding layoutContent;
    public final RoundFrameLayout layoutScreenshot;
    private final ConstraintLayout rootView;
    public final RoundTextView tvLikeCount;

    private LayoutPraiseListGroupBinding(ConstraintLayout constraintLayout, View view, View view2, FlyAnimGroup flyAnimGroup2, ImageView imageView, ImageView imageView2, ImageView imageView3, LayoutPraiseListBinding layoutPraiseListBinding, RoundFrameLayout roundFrameLayout, RoundTextView roundTextView) {
        this.rootView = constraintLayout;
        this.bgScreenshot = view;
        this.bgScreenshotWhite = view2;
        this.flyAnimGroup = flyAnimGroup2;
        this.ivDownload = imageView;
        this.ivLike = imageView2;
        this.ivScreenshot = imageView3;
        this.layoutContent = layoutPraiseListBinding;
        this.layoutScreenshot = roundFrameLayout;
        this.tvLikeCount = roundTextView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutPraiseListGroupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutPraiseListGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_praise_list_group;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003c, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.layoutContent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.tvLikeCount;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.bgScreenshotWhite;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.flyAnimGroup;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LayoutPraiseListGroupBinding bind(android.view.View r12) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.bgScreenshot
            android.view.View r3 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r3 == 0) goto L_0x0068
            int r0 = com.tal.app.thinkacademy.live.business.R.id.bgScreenshotWhite
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r4 == 0) goto L_0x0068
            int r0 = com.tal.app.thinkacademy.live.business.R.id.flyAnimGroup
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r5 = r1
            com.tal.app.thinkcademy.lib.commui.widget.likegroup.FlyAnimGroup r5 = (com.tal.app.thinkcademy.lib.commui.widget.likegroup.FlyAnimGroup) r5
            if (r5 == 0) goto L_0x0068
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivDownload
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0068
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivLike
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x0068
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivScreenshot
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0068
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layoutContent
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            if (r1 == 0) goto L_0x0068
            com.tal.app.thinkacademy.live.business.databinding.LayoutPraiseListBinding r9 = com.tal.app.thinkacademy.live.business.databinding.LayoutPraiseListBinding.bind(r1)
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layoutScreenshot
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r10 = r1
            com.flyco.roundview.RoundFrameLayout r10 = (com.flyco.roundview.RoundFrameLayout) r10
            if (r10 == 0) goto L_0x0068
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tvLikeCount
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r12, r0)
            r11 = r1
            com.flyco.roundview.RoundTextView r11 = (com.flyco.roundview.RoundTextView) r11
            if (r11 == 0) goto L_0x0068
            com.tal.app.thinkacademy.live.business.databinding.LayoutPraiseListGroupBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LayoutPraiseListGroupBinding
            r2 = r12
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            r1 = r0
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
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LayoutPraiseListGroupBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LayoutPraiseListGroupBinding");
    }
}
