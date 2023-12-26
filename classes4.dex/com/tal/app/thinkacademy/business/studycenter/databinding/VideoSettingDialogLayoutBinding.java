package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundTextView;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class VideoSettingDialogLayoutBinding implements ViewBinding {
    public final ImageView playerFunctionMore;
    private final ConstraintLayout rootView;
    public final RoundTextView switchLineBtn;

    private VideoSettingDialogLayoutBinding(ConstraintLayout constraintLayout, ImageView imageView, RoundTextView roundTextView) {
        this.rootView = constraintLayout;
        this.playerFunctionMore = imageView;
        this.switchLineBtn = roundTextView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static VideoSettingDialogLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static VideoSettingDialogLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.video_setting_dialog_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.tal.app.thinkacademy.business.studycenter.R.id.switchLineBtn;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.studycenter.databinding.VideoSettingDialogLayoutBinding bind(android.view.View r3) {
        /*
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.player_function_more
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            if (r1 == 0) goto L_0x001c
            int r0 = com.tal.app.thinkacademy.business.studycenter.R.id.switchLineBtn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r3, r0)
            com.flyco.roundview.RoundTextView r2 = (com.flyco.roundview.RoundTextView) r2
            if (r2 == 0) goto L_0x001c
            com.tal.app.thinkacademy.business.studycenter.databinding.VideoSettingDialogLayoutBinding r0 = new com.tal.app.thinkacademy.business.studycenter.databinding.VideoSettingDialogLayoutBinding
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r0.<init>(r3, r1, r2)
            return r0
        L_0x001c:
            android.content.res.Resources r3 = r3.getResources()
            java.lang.String r3 = r3.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r3 = r1.concat(r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.studycenter.databinding.VideoSettingDialogLayoutBinding.bind(android.view.View):com.tal.app.thinkacademy.business.studycenter.databinding.VideoSettingDialogLayoutBinding");
    }
}
