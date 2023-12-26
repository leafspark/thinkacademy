package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LayoutLiveMsgPrivateRemindBinding implements ViewBinding {
    public final TextView btnTutorMsgGotIt;
    public final TextView btnTutorMsgReply;
    public final ImageView ivTutorAvatar;
    private final ConstraintLayout rootView;
    public final TextView tvTutorMsg;
    public final TextView tvTutorName;
    public final TextView tvTutorRole;
    public final View viewBottomSpace;
    public final View viewContent;
    public final View viewTitle;

    private LayoutLiveMsgPrivateRemindBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, ImageView imageView, TextView textView3, TextView textView4, TextView textView5, View view, View view2, View view3) {
        this.rootView = constraintLayout;
        this.btnTutorMsgGotIt = textView;
        this.btnTutorMsgReply = textView2;
        this.ivTutorAvatar = imageView;
        this.tvTutorMsg = textView3;
        this.tvTutorName = textView4;
        this.tvTutorRole = textView5;
        this.viewBottomSpace = view;
        this.viewContent = view2;
        this.viewTitle = view3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutLiveMsgPrivateRemindBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutLiveMsgPrivateRemindBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.layout_live_msg_private_remind;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.viewBottomSpace;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.viewContent;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0052, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.viewTitle;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LayoutLiveMsgPrivateRemindBinding bind(android.view.View r13) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.btnTutorMsgGotIt
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r4 = r1
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x0064
            int r0 = com.tal.app.thinkacademy.live.business.R.id.btnTutorMsgReply
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r5 = r1
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x0064
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ivTutorAvatar
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r6 = r1
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            if (r6 == 0) goto L_0x0064
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tvTutorMsg
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            if (r7 == 0) goto L_0x0064
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tvTutorName
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            if (r8 == 0) goto L_0x0064
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tvTutorRole
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0064
            int r0 = com.tal.app.thinkacademy.live.business.R.id.viewBottomSpace
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r10 == 0) goto L_0x0064
            int r0 = com.tal.app.thinkacademy.live.business.R.id.viewContent
            android.view.View r11 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r11 == 0) goto L_0x0064
            int r0 = com.tal.app.thinkacademy.live.business.R.id.viewTitle
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r13, r0)
            if (r12 == 0) goto L_0x0064
            com.tal.app.thinkacademy.live.business.databinding.LayoutLiveMsgPrivateRemindBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LayoutLiveMsgPrivateRemindBinding
            r3 = r13
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r0
        L_0x0064:
            android.content.res.Resources r13 = r13.getResources()
            java.lang.String r13 = r13.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r13 = r1.concat(r13)
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LayoutLiveMsgPrivateRemindBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LayoutLiveMsgPrivateRemindBinding");
    }
}
