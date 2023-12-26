package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class ActivityPrepareLayoutBinding implements ViewBinding {
    public final RoundTextView btCourseDownload;
    public final RoundTextView btNetRefresh;
    public final RoundTextView internetSafetyTips;
    public final ImageView prepareClassBackIcon;
    public final RoundLinearLayout prepareClassContentLayout;
    public final RelativeLayout prepareClassCourseDownLayout;
    public final RoundLinearLayout prepareClassJoinLayout;
    public final LottieAnimationView prepareClassLottie;
    public final ProgressBar prepareClassProgress;
    public final TextView prepareClassProgressContent;
    public final RelativeLayout prepareClassTitleLayout;
    public final TextView prepareDownloadExplanation;
    public final ImageView prepareDownloadIcon;
    public final TextView prepareDownloadTitle;
    public final TextView prepareNetExplanation;
    public final TextView prepareNetTitle;
    public final ImageView prepareWifiIcon;
    private final ConstraintLayout rootView;
    public final TextView tvDownStatusFailed;
    public final RoundTextView tvJoinClass;
    public final TextView tvJoinClassDifTime;
    public final TextView tvNetStatusContent;

    private ActivityPrepareLayoutBinding(ConstraintLayout constraintLayout, RoundTextView roundTextView, RoundTextView roundTextView2, RoundTextView roundTextView3, ImageView imageView, RoundLinearLayout roundLinearLayout, RelativeLayout relativeLayout, RoundLinearLayout roundLinearLayout2, LottieAnimationView lottieAnimationView, ProgressBar progressBar, TextView textView, RelativeLayout relativeLayout2, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4, TextView textView5, ImageView imageView3, TextView textView6, RoundTextView roundTextView4, TextView textView7, TextView textView8) {
        this.rootView = constraintLayout;
        this.btCourseDownload = roundTextView;
        this.btNetRefresh = roundTextView2;
        this.internetSafetyTips = roundTextView3;
        this.prepareClassBackIcon = imageView;
        this.prepareClassContentLayout = roundLinearLayout;
        this.prepareClassCourseDownLayout = relativeLayout;
        this.prepareClassJoinLayout = roundLinearLayout2;
        this.prepareClassLottie = lottieAnimationView;
        this.prepareClassProgress = progressBar;
        this.prepareClassProgressContent = textView;
        this.prepareClassTitleLayout = relativeLayout2;
        this.prepareDownloadExplanation = textView2;
        this.prepareDownloadIcon = imageView2;
        this.prepareDownloadTitle = textView3;
        this.prepareNetExplanation = textView4;
        this.prepareNetTitle = textView5;
        this.prepareWifiIcon = imageView3;
        this.tvDownStatusFailed = textView6;
        this.tvJoinClass = roundTextView4;
        this.tvJoinClassDifTime = textView7;
        this.tvNetStatusContent = textView8;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityPrepareLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityPrepareLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.activity_prepare_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.prepare_class_join_layout;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.prepare_class_lottie;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.bt_net_refresh;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cf, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_join_class;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.internetSafetyTips;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r1 = com.tal.app.thinkacademy.business.studycenter.R.id.prepare_class_content_layout;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPrepareLayoutBinding bind(android.view.View r26) {
        /*
            r0 = r26
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.bt_course_download
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.flyco.roundview.RoundTextView r5 = (com.flyco.roundview.RoundTextView) r5
            if (r5 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.bt_net_refresh
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.flyco.roundview.RoundTextView r6 = (com.flyco.roundview.RoundTextView) r6
            if (r6 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.internetSafetyTips
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            com.flyco.roundview.RoundTextView r7 = (com.flyco.roundview.RoundTextView) r7
            if (r7 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.prepare_class_back_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.prepare_class_content_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            com.flyco.roundview.RoundLinearLayout r9 = (com.flyco.roundview.RoundLinearLayout) r9
            if (r9 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.prepare_class_course_down_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.RelativeLayout r10 = (android.widget.RelativeLayout) r10
            if (r10 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.prepare_class_join_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            com.flyco.roundview.RoundLinearLayout r11 = (com.flyco.roundview.RoundLinearLayout) r11
            if (r11 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.prepare_class_lottie
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            com.airbnb.lottie.LottieAnimationView r12 = (com.airbnb.lottie.LottieAnimationView) r12
            if (r12 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.prepare_class_progress
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.ProgressBar r13 = (android.widget.ProgressBar) r13
            if (r13 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.prepare_class_progress_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.prepare_class_title_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            if (r15 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.prepare_download_explanation
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.prepare_download_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.ImageView r17 = (android.widget.ImageView) r17
            if (r17 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.prepare_download_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.prepare_net_explanation
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.prepare_net_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.prepare_wifi_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.ImageView r21 = (android.widget.ImageView) r21
            if (r21 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_down_status_failed
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_join_class
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            com.flyco.roundview.RoundTextView r23 = (com.flyco.roundview.RoundTextView) r23
            if (r23 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_join_class_dif_time
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.TextView r24 = (android.widget.TextView) r24
            if (r24 == 0) goto L_0x00fd
            int r1 = com.tal.app.thinkacademy.business.studycenter.R.id.tv_net_status_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            android.widget.TextView r25 = (android.widget.TextView) r25
            if (r25 == 0) goto L_0x00fd
            com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPrepareLayoutBinding r1 = new com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPrepareLayoutBinding
            r3 = r1
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            return r1
        L_0x00fd:
            android.content.res.Resources r0 = r26.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPrepareLayoutBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.ActivityPrepareLayoutBinding");
    }
}
