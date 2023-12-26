package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.live.business.R;
import org.libpag.PAGImageView;

public final class LiveBusinessVoteSubmitDialogBinding implements ViewBinding {
    public final ImageView imgMedalArrow;
    public final ImageView imgMedalLast;
    public final ImageView imgMedalNew;
    public final ImageView ivResultSuccessTitle;
    public final Group layoutDialog;
    public final LinearLayout layoutMedal;
    public final ConstraintLayout llResultSuccess;
    public final LinearLayout llResultSuccessBg;
    public final RoundLinearLayout llResultSuccessBgCoins;
    public final PAGImageView pagResultSuccessTitle;
    private final ConstraintLayout rootView;
    public final Space space;
    public final TextView tvMedalDesc;
    public final TextView tvResultSuccessBgCoins;
    public final TextView tvResultSuccessTitle;

    private LiveBusinessVoteSubmitDialogBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, Group group, LinearLayout linearLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout2, RoundLinearLayout roundLinearLayout, PAGImageView pAGImageView, Space space2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.imgMedalArrow = imageView;
        this.imgMedalLast = imageView2;
        this.imgMedalNew = imageView3;
        this.ivResultSuccessTitle = imageView4;
        this.layoutDialog = group;
        this.layoutMedal = linearLayout;
        this.llResultSuccess = constraintLayout2;
        this.llResultSuccessBg = linearLayout2;
        this.llResultSuccessBgCoins = roundLinearLayout;
        this.pagResultSuccessTitle = pAGImageView;
        this.space = space2;
        this.tvMedalDesc = textView;
        this.tvResultSuccessBgCoins = textView2;
        this.tvResultSuccessTitle = textView3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessVoteSubmitDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessVoteSubmitDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_vote_submit_dialog;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0052, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.llResultSuccessBgCoins;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005d, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.pagResultSuccessTitle;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.layout_dialog;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessVoteSubmitDialogBinding bind(android.view.View r19) {
        /*
            r0 = r19
            int r1 = com.tal.app.thinkacademy.live.business.R.id.imgMedalArrow
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.imgMedalLast
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.imgMedalNew
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.ivResultSuccessTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.layout_dialog
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.constraintlayout.widget.Group r9 = (androidx.constraintlayout.widget.Group) r9
            if (r9 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.layoutMedal
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            if (r10 == 0) goto L_0x009f
            r11 = r0
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            int r1 = com.tal.app.thinkacademy.live.business.R.id.llResultSuccessBg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            if (r12 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.llResultSuccessBgCoins
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            com.flyco.roundview.RoundLinearLayout r13 = (com.flyco.roundview.RoundLinearLayout) r13
            if (r13 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.pagResultSuccessTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            org.libpag.PAGImageView r14 = (org.libpag.PAGImageView) r14
            if (r14 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.space
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.Space r15 = (android.widget.Space) r15
            if (r15 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tvMedalDesc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tvResultSuccessBgCoins
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x009f
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tvResultSuccessTitle
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x009f
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessVoteSubmitDialogBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessVoteSubmitDialogBinding
            r3 = r0
            r4 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r0
        L_0x009f:
            android.content.res.Resources r0 = r19.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessVoteSubmitDialogBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessVoteSubmitDialogBinding");
    }
}
