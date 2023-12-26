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
import com.airbnb.lottie.LottieAnimationView;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessPhotosOnTheWallSubmitDialogBinding implements ViewBinding {
    public final LottieAnimationView homeworkLottie;
    public final ImageView ivResultSuccessTitle;
    public final Group layoutDialog;
    public final ConstraintLayout llResultSuccess;
    public final LinearLayout llResultSuccessBg;
    public final RoundLinearLayout llResultSuccessBgCoins;
    private final ConstraintLayout rootView;
    public final Space space;
    public final TextView tvResultSuccessBgCoins;
    public final TextView tvResultSuccessTitle;

    private LiveBusinessPhotosOnTheWallSubmitDialogBinding(ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, ImageView imageView, Group group, ConstraintLayout constraintLayout2, LinearLayout linearLayout, RoundLinearLayout roundLinearLayout, Space space2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.homeworkLottie = lottieAnimationView;
        this.ivResultSuccessTitle = imageView;
        this.layoutDialog = group;
        this.llResultSuccess = constraintLayout2;
        this.llResultSuccessBg = linearLayout;
        this.llResultSuccessBgCoins = roundLinearLayout;
        this.space = space2;
        this.tvResultSuccessBgCoins = textView;
        this.tvResultSuccessTitle = textView2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessPhotosOnTheWallSubmitDialogBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessPhotosOnTheWallSubmitDialogBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_photos_on_the_wall_submit_dialog;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.layout_dialog;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002f, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.llResultSuccessBgCoins;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPhotosOnTheWallSubmitDialogBinding bind(android.view.View r13) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.homeworkLottie
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            com.airbnb.lottie.LottieAnimationView r4 = (com.airbnb.lottie.LottieAnimationView) r4
            if (r4 == 0) goto L_0x0063
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivResultSuccessTitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            if (r5 == 0) goto L_0x0063
            int r0 = com.tal.app.thinkacademy.live.business.R.id.layout_dialog
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r6 = r1
            androidx.constraintlayout.widget.Group r6 = (androidx.constraintlayout.widget.Group) r6
            if (r6 == 0) goto L_0x0063
            r7 = r13
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            int r0 = com.tal.app.thinkacademy.live.business.R.id.llResultSuccessBg
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x0063
            int r0 = com.tal.app.thinkacademy.live.business.R.id.llResultSuccessBgCoins
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            com.flyco.roundview.RoundLinearLayout r9 = (com.flyco.roundview.RoundLinearLayout) r9
            if (r9 == 0) goto L_0x0063
            int r0 = com.tal.app.thinkacademy.live.business.R.id.space
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r10 = r1
            android.widget.Space r10 = (android.widget.Space) r10
            if (r10 == 0) goto L_0x0063
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tvResultSuccessBgCoins
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x0063
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tvResultSuccessTitle
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0063
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPhotosOnTheWallSubmitDialogBinding r13 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPhotosOnTheWallSubmitDialogBinding
            r2 = r13
            r3 = r7
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r13
        L_0x0063:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPhotosOnTheWallSubmitDialogBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessPhotosOnTheWallSubmitDialogBinding");
    }
}
