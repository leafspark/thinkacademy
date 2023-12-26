package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessHomeworkItemPhoneBinding implements ViewBinding {
    public final LinearLayout bgLiveBusinessHomeworkPhoto;
    public final ImageView ivLiveBusinessHomeworkPhotoThumb;
    public final LinearLayout ivLiveBusinessHomeworkResubmit;
    public final ImageView ivLiveBusinessHomeworkStatus;
    private final LinearLayout rootView;
    public final TextView tvLiveBusinessHomeworkCoin;
    public final RoundTextView tvLiveBusinessHomeworkIndex;
    public final TextView tvLiveBusinessHomeworkStatus;

    private LiveBusinessHomeworkItemPhoneBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, LinearLayout linearLayout3, ImageView imageView2, TextView textView, RoundTextView roundTextView, TextView textView2) {
        this.rootView = linearLayout;
        this.bgLiveBusinessHomeworkPhoto = linearLayout2;
        this.ivLiveBusinessHomeworkPhotoThumb = imageView;
        this.ivLiveBusinessHomeworkResubmit = linearLayout3;
        this.ivLiveBusinessHomeworkStatus = imageView2;
        this.tvLiveBusinessHomeworkCoin = textView;
        this.tvLiveBusinessHomeworkIndex = roundTextView;
        this.tvLiveBusinessHomeworkStatus = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessHomeworkItemPhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessHomeworkItemPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_homework_item_phone;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002f, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_index;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkItemPhoneBinding bind(android.view.View r9) {
        /*
            r2 = r9
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_photo_thumb
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r3 = r1
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            if (r3 == 0) goto L_0x004d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_resubmit
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            android.widget.LinearLayout r4 = (android.widget.LinearLayout) r4
            if (r4 == 0) goto L_0x004d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_homework_status
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x004d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_coin
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x004d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_index
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            com.flyco.roundview.RoundTextView r7 = (com.flyco.roundview.RoundTextView) r7
            if (r7 == 0) goto L_0x004d
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_homework_status
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x004d
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkItemPhoneBinding r9 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkItemPhoneBinding
            r0 = r9
            r1 = r2
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x004d:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkItemPhoneBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessHomeworkItemPhoneBinding");
    }
}
