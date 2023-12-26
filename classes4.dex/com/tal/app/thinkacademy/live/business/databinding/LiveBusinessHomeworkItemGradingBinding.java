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

public final class LiveBusinessHomeworkItemGradingBinding implements ViewBinding {
    public final ImageView ivLiveBusinessHomeworkBoard;
    public final ShapeableImageView ivLiveBusinessHomeworkPhotoThumb;
    public final ImageView ivLiveBusinessHomeworkStatus;
    private final LinearLayout rootView;
    public final Space spaceLiveBusinessHomeworkBottom;
    public final Space spaceLiveBusinessHomeworkTop;
    public final TextView tvLiveBusinessHomeworkIndex;
    public final TextView tvLiveBusinessHomeworkStatus;

    private LiveBusinessHomeworkItemGradingBinding(LinearLayout linearLayout, ImageView imageView, ShapeableImageView shapeableImageView, ImageView imageView2, Space space, Space space2, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.ivLiveBusinessHomeworkBoard = imageView;
        this.ivLiveBusinessHomeworkPhotoThumb = shapeableImageView;
        this.ivLiveBusinessHomeworkStatus = imageView2;
        this.spaceLiveBusinessHomeworkBottom = space;
        this.spaceLiveBusinessHomeworkTop = space2;
        this.tvLiveBusinessHomeworkIndex = textView;
        this.tvLiveBusinessHomeworkStatus = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessHomeworkItemGradingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessHomeworkItemGradingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_homework_item_grading;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_photo_thumb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkItemGradingBinding bind(android.view.View r11) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_board
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_photo_thumb
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            com.google.android.material.imageview.ShapeableImageView r5 = (com.google.android.material.imageview.ShapeableImageView) r5
            if (r5 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_status
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.live.business.R.id.space_live_business_homework_bottom
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            android.widget.Space r7 = (android.widget.Space) r7
            if (r7 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.live.business.R.id.space_live_business_homework_top
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            android.widget.Space r8 = (android.widget.Space) r8
            if (r8 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_index
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0057
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_status
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            if (r10 == 0) goto L_0x0057
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkItemGradingBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkItemGradingBinding
            r3 = r11
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0057:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkItemGradingBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkItemGradingBinding");
    }
}
