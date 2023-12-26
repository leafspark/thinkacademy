package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.google.android.material.imageview.ShapeableImageView;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessHomeworkItemCorrectBinding implements ViewBinding {
    public final ImageView ivLiveBusinessHomeworkBoard;
    public final ImageView ivLiveBusinessHomeworkCoin;
    public final ShapeableImageView ivLiveBusinessHomeworkPhotoThumb;
    public final ImageView ivLiveBusinessHomeworkStatus;
    private final LinearLayout rootView;
    public final Space spaceLiveBusinessHomeworkBottom;
    public final Space spaceLiveBusinessHomeworkTop;
    public final TextView tvLiveBusinessHomeworkCoin;
    public final TextView tvLiveBusinessHomeworkIndex;
    public final TextView tvLiveBusinessHomeworkStatus;

    private LiveBusinessHomeworkItemCorrectBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ShapeableImageView shapeableImageView, ImageView imageView3, Space space, Space space2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.ivLiveBusinessHomeworkBoard = imageView;
        this.ivLiveBusinessHomeworkCoin = imageView2;
        this.ivLiveBusinessHomeworkPhotoThumb = shapeableImageView;
        this.ivLiveBusinessHomeworkStatus = imageView3;
        this.spaceLiveBusinessHomeworkBottom = space;
        this.spaceLiveBusinessHomeworkTop = space2;
        this.tvLiveBusinessHomeworkCoin = textView;
        this.tvLiveBusinessHomeworkIndex = textView2;
        this.tvLiveBusinessHomeworkStatus = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessHomeworkItemCorrectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessHomeworkItemCorrectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_homework_item_correct;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_photo_thumb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkItemCorrectBinding bind(android.view.View r13) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_board
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_coin
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_photo_thumb
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r6 = r1
            com.google.android.material.imageview.ShapeableImageView r6 = (com.google.android.material.imageview.ShapeableImageView) r6
            if (r6 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_status
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.space_live_business_homework_bottom
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            android.widget.Space r8 = (android.widget.Space) r8
            if (r8 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.space_live_business_homework_top
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            android.widget.Space r9 = (android.widget.Space) r9
            if (r9 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_coin
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_index
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x006d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_status
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x006d
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkItemCorrectBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkItemCorrectBinding
            r3 = r13
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L_0x006d:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkItemCorrectBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkItemCorrectBinding");
    }
}
