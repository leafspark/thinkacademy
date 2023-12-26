package com.tal.app.thinkacademy.business.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.login.R;

public final class LayoutDeviceTestVoiceDriverBinding implements ViewBinding {
    public final View bottomPos;
    public final Group groupVoicePreview;
    public final Group groupVoiceState;
    public final ImageView ivVoiceState;
    public final LinearLayout layoutVoicePreview;
    public final TextView layoutVoiceState;
    public final View lineContent;
    public final ProgressBar progressVoice;
    private final ConstraintLayout rootView;
    public final View topPos;
    public final TextView tvErrorNext;
    public final TextView tvErrorRetest;
    public final TextView tvVoiceMsg;
    public final TextView tvVoicePreviewMsg;
    public final TextView tvVoicePreviewTitle;
    public final TextView tvVoiceResultNo;
    public final TextView tvVoiceResultYes;
    public final TextView tvVoiceSize;

    private LayoutDeviceTestVoiceDriverBinding(ConstraintLayout constraintLayout, View view, Group group, Group group2, ImageView imageView, LinearLayout linearLayout, TextView textView, View view2, ProgressBar progressBar, View view3, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = constraintLayout;
        this.bottomPos = view;
        this.groupVoicePreview = group;
        this.groupVoiceState = group2;
        this.ivVoiceState = imageView;
        this.layoutVoicePreview = linearLayout;
        this.layoutVoiceState = textView;
        this.lineContent = view2;
        this.progressVoice = progressBar;
        this.topPos = view3;
        this.tvErrorNext = textView2;
        this.tvErrorRetest = textView3;
        this.tvVoiceMsg = textView4;
        this.tvVoicePreviewMsg = textView5;
        this.tvVoicePreviewTitle = textView6;
        this.tvVoiceResultNo = textView7;
        this.tvVoiceResultYes = textView8;
        this.tvVoiceSize = textView9;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutDeviceTestVoiceDriverBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutDeviceTestVoiceDriverBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_device_test_voice_driver;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.line_content;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0054, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.top_pos;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.group_voice_preview;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
        r1 = com.tal.app.thinkacademy.business.login.R.id.group_voice_state;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestVoiceDriverBinding bind(android.view.View r21) {
        /*
            r0 = r21
            int r1 = com.tal.app.thinkacademy.business.login.R.id.bottom_pos
            android.view.View r4 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r4 == 0) goto L_0x00c3
            int r1 = com.tal.app.thinkacademy.business.login.R.id.group_voice_preview
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.constraintlayout.widget.Group r5 = (androidx.constraintlayout.widget.Group) r5
            if (r5 == 0) goto L_0x00c3
            int r1 = com.tal.app.thinkacademy.business.login.R.id.group_voice_state
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.constraintlayout.widget.Group r6 = (androidx.constraintlayout.widget.Group) r6
            if (r6 == 0) goto L_0x00c3
            int r1 = com.tal.app.thinkacademy.business.login.R.id.iv_voice_state
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x00c3
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_voice_preview
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x00c3
            int r1 = com.tal.app.thinkacademy.business.login.R.id.layout_voice_state
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x00c3
            int r1 = com.tal.app.thinkacademy.business.login.R.id.line_content
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r10 == 0) goto L_0x00c3
            int r1 = com.tal.app.thinkacademy.business.login.R.id.progress_voice
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ProgressBar r11 = (android.widget.ProgressBar) r11
            if (r11 == 0) goto L_0x00c3
            int r1 = com.tal.app.thinkacademy.business.login.R.id.top_pos
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r12 == 0) goto L_0x00c3
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_error_next
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x00c3
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_error_retest
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x00c3
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_voice_msg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x00c3
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_voice_preview_msg
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x00c3
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_voice_preview_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00c3
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_voice_result_no
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.TextView r18 = (android.widget.TextView) r18
            if (r18 == 0) goto L_0x00c3
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_voice_result_yes
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00c3
            int r1 = com.tal.app.thinkacademy.business.login.R.id.tv_voice_size
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.TextView r20 = (android.widget.TextView) r20
            if (r20 == 0) goto L_0x00c3
            com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestVoiceDriverBinding r1 = new com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestVoiceDriverBinding
            r2 = r1
            r3 = r0
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r1
        L_0x00c3:
            android.content.res.Resources r0 = r21.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestVoiceDriverBinding.bind(android.view.View):com.tal.app.thinkacademy.business.login.databinding.LayoutDeviceTestVoiceDriverBinding");
    }
}
