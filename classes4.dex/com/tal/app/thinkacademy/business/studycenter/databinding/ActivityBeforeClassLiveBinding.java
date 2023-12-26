package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.studycenter.R;
import com.tal.app.thinkacademy.common.widget.gold.FlyCoinView;
import com.tal.app.thinkacademy.lib.commui.widget.RoundConstraintLayout;

public final class ActivityBeforeClassLiveBinding implements ViewBinding {
    public final ImageView btnBack;
    public final TextView btnCheckIn;
    public final View btnCheckInCover;
    public final TextView btnJoinClass;
    public final View btnJoinClassCover;
    public final ImageView iconDownload;
    public final RelativeLayout layoutDownload;
    public final RoundTextView layoutDownloadBg;
    public final RoundLinearLayout layoutEnvTest;
    public final ActivityBeforeClassErrorBinding layoutError;
    public final RoundConstraintLayout layoutSign;
    public final SeekBar progressDownload;
    public final View progressDownloadRef;
    private final ConstraintLayout rootView;
    public final FlyCoinView signLottie;
    public final Space space1;
    public final Space space2;
    public final TextView titleDownload;
    public final TextView tvCheckIn;
    public final TextView tvCheckInCoin;

    private ActivityBeforeClassLiveBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, View view, TextView textView2, View view2, ImageView imageView2, RelativeLayout relativeLayout, RoundTextView roundTextView, RoundLinearLayout roundLinearLayout, ActivityBeforeClassErrorBinding activityBeforeClassErrorBinding, RoundConstraintLayout roundConstraintLayout, SeekBar seekBar, View view3, FlyCoinView flyCoinView, Space space, Space space3, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.btnBack = imageView;
        this.btnCheckIn = textView;
        this.btnCheckInCover = view;
        this.btnJoinClass = textView2;
        this.btnJoinClassCover = view2;
        this.iconDownload = imageView2;
        this.layoutDownload = relativeLayout;
        this.layoutDownloadBg = roundTextView;
        this.layoutEnvTest = roundLinearLayout;
        this.layoutError = activityBeforeClassErrorBinding;
        this.layoutSign = roundConstraintLayout;
        this.progressDownload = seekBar;
        this.progressDownloadRef = view3;
        this.signLottie = flyCoinView;
        this.space1 = space;
        this.space2 = space3;
        this.titleDownload = textView3;
        this.tvCheckIn = textView4;
        this.tvCheckInCoin = textView5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBeforeClassLiveBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityBeforeClassLiveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_before_class_live;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_download_bg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0054, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_env_test;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005f, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_error;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.progress_download_ref;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.btn_check_in_cover;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002b, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.btn_join_class_cover;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.ActivityBeforeClassLiveBinding bind(android.view.View r24) {
        /*
            r0 = r24
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.btn_back
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.btn_check_in
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.btn_check_in_cover
            android.view.View r7 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r7 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.btn_join_class
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.btn_join_class_cover
            android.view.View r9 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r9 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.icon_download
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_download
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            if (r11 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_download_bg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            com.flyco.roundview.RoundTextView r12 = (com.flyco.roundview.RoundTextView) r12
            if (r12 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_env_test
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            com.flyco.roundview.RoundLinearLayout r13 = (com.flyco.roundview.RoundLinearLayout) r13
            if (r13 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_error
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r2 == 0) goto L_0x00dc
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityBeforeClassErrorBinding r14 = com.tal.app.thinkacademy.business.studycenter.databinding.ActivityBeforeClassErrorBinding.bind(r2)
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.layout_sign
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            com.tal.app.thinkacademy.lib.commui.widget.RoundConstraintLayout r15 = (com.tal.app.thinkacademy.lib.commui.widget.RoundConstraintLayout) r15
            if (r15 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.progress_download
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.SeekBar r16 = (android.widget.SeekBar) r16
            if (r16 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.progress_download_ref
            android.view.View r17 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r17 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.sign_lottie
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            com.tal.app.thinkacademy.common.widget.gold.FlyCoinView r18 = (com.tal.app.thinkacademy.common.widget.gold.FlyCoinView) r18
            if (r18 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.space_1
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.Space r19 = (android.widget.Space) r19
            if (r19 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.space_2
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.Space r20 = (android.widget.Space) r20
            if (r20 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.title_download
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.TextView r21 = (android.widget.TextView) r21
            if (r21 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_check_in
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x00dc
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_check_in_coin
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x00dc
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityBeforeClassLiveBinding r1 = new com.tal.app.thinkacademy.business.studycenter.databinding.ActivityBeforeClassLiveBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r1
        L_0x00dc:
            android.content.res.Resources r0 = r24.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.ActivityBeforeClassLiveBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.ActivityBeforeClassLiveBinding");
    }
}
