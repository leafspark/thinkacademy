package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.live.business.R;
import com.yy.mobile.rollingtextview.RollingTextView;

public final class LiveBusinessViewMediaControllerSmallLiveTopPadBinding implements ViewBinding {
    public final ImageView ivLiveBusinessScreenshot;
    public final ImageView ivMediaControllerBack;
    public final ImageView ivMediaControllerExamReport;
    public final ImageView ivMediaControllerFeedback;
    public final ImageView ivMediaControllerMore;
    public final ImageView ivMediaControllerNetwork;
    public final ImageView ivMediaControllerRefresh;
    public final ImageView ivMediaControllerStar;
    public final RelativeLayout layoutMediaControllerHomework;
    public final RoundLinearLayout llMediaControllerStar;
    public final LinearLayout rlMediaControllerRootTop;
    private final LinearLayout rootView;
    public final RoundTextView tvMediaControllerHomeworkDot;
    public final RollingTextView tvMediaControllerStarCount;
    public final TextView tvMediaControllerTitle;
    public final View vMediaControllerStarLine;

    private LiveBusinessViewMediaControllerSmallLiveTopPadBinding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, RelativeLayout relativeLayout, RoundLinearLayout roundLinearLayout, LinearLayout linearLayout2, RoundTextView roundTextView, RollingTextView rollingTextView, TextView textView, View view) {
        this.rootView = linearLayout;
        this.ivLiveBusinessScreenshot = imageView;
        this.ivMediaControllerBack = imageView2;
        this.ivMediaControllerExamReport = imageView3;
        this.ivMediaControllerFeedback = imageView4;
        this.ivMediaControllerMore = imageView5;
        this.ivMediaControllerNetwork = imageView6;
        this.ivMediaControllerRefresh = imageView7;
        this.ivMediaControllerStar = imageView8;
        this.layoutMediaControllerHomework = relativeLayout;
        this.llMediaControllerStar = roundLinearLayout;
        this.rlMediaControllerRootTop = linearLayout2;
        this.tvMediaControllerHomeworkDot = roundTextView;
        this.tvMediaControllerStarCount = rollingTextView;
        this.tvMediaControllerTitle = textView;
        this.vMediaControllerStarLine = view;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessViewMediaControllerSmallLiveTopPadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessViewMediaControllerSmallLiveTopPadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_view_media_controller_small_live_top_pad;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0065, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.ll_media_controller_star;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007f, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.tv_media_controller_star_count;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0097, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.v_media_controller_star_line;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerSmallLiveTopPadBinding bind(android.view.View r20) {
        /*
            r0 = r20
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_screenshot
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x00a7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_media_controller_back
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x00a7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_media_controller_exam_report
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x00a7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_media_controller_feedback
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x00a7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_media_controller_more
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x00a7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_media_controller_network
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00a7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_media_controller_refresh
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x00a7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_media_controller_star
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x00a7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.layout_media_controller_homework
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.RelativeLayout r13 = (android.widget.RelativeLayout) r13
            if (r13 == 0) goto L_0x00a7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.ll_media_controller_star
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            com.flyco.roundview.RoundLinearLayout r14 = (com.flyco.roundview.RoundLinearLayout) r14
            if (r14 == 0) goto L_0x00a7
            r15 = r0
            android.widget.LinearLayout r15 = (android.widget.LinearLayout) r15
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_media_controller_homework_dot
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            com.flyco.roundview.RoundTextView r16 = (com.flyco.roundview.RoundTextView) r16
            if (r16 == 0) goto L_0x00a7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_media_controller_star_count
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            com.yy.mobile.rollingtextview.RollingTextView r17 = (com.yy.mobile.rollingtextview.RollingTextView) r17
            if (r17 == 0) goto L_0x00a7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_media_controller_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00a7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.v_media_controller_star_line
            android.view.View r19 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r19 == 0) goto L_0x00a7
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerSmallLiveTopPadBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerSmallLiveTopPadBinding
            r3 = r0
            r4 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r0
        L_0x00a7:
            android.content.res.Resources r0 = r20.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerSmallLiveTopPadBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewMediaControllerSmallLiveTopPadBinding");
    }
}
