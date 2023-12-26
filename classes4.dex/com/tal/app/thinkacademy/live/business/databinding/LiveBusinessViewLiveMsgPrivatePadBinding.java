package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxListPluginView;

public final class LiveBusinessViewLiveMsgPrivatePadBinding implements ViewBinding {
    public final ChatBoxListPluginView chatBoxListView;
    public final ConstraintLayout clLiveBusinessLiveMsgPrivateContent;
    public final ConstraintLayout clLiveBusinessLiveMsgPrivateFloat;
    public final ConstraintLayout clLiveBusinessLiveMsgPrivateRoot;
    public final ImageView ivLiveBusinessLiveMsgPrivate;
    public final ImageView ivLiveBusinessTutorClose;
    public final LinearLayout llLiveBusinessTutorTitle;
    private final ConstraintLayout rootView;
    public final TextView tvFrequently;
    public final TextView tvIrcConnecting;
    public final TextView tvLiveBusinessLiveMsgPrivateCount;
    public final TextView tvLiveBusinessLiveMsgPrivateHint;
    public final TextView tvLiveBusinessTutorName;

    private LiveBusinessViewLiveMsgPrivatePadBinding(ConstraintLayout constraintLayout, ChatBoxListPluginView chatBoxListPluginView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.chatBoxListView = chatBoxListPluginView;
        this.clLiveBusinessLiveMsgPrivateContent = constraintLayout2;
        this.clLiveBusinessLiveMsgPrivateFloat = constraintLayout3;
        this.clLiveBusinessLiveMsgPrivateRoot = constraintLayout4;
        this.ivLiveBusinessLiveMsgPrivate = imageView;
        this.ivLiveBusinessTutorClose = imageView2;
        this.llLiveBusinessTutorTitle = linearLayout;
        this.tvFrequently = textView;
        this.tvIrcConnecting = textView2;
        this.tvLiveBusinessLiveMsgPrivateCount = textView3;
        this.tvLiveBusinessLiveMsgPrivateHint = textView4;
        this.tvLiveBusinessTutorName = textView5;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessViewLiveMsgPrivatePadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessViewLiveMsgPrivatePadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_view_live_msg_private_pad;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.cl_live_business_live_msg_private_content;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.cl_live_business_live_msg_private_float;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewLiveMsgPrivatePadBinding bind(android.view.View r17) {
        /*
            r0 = r17
            int r1 = com.tal.app.thinkacademy.live.business.R.id.chat_box_list_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxListPluginView r5 = (com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxListPluginView) r5
            if (r5 == 0) goto L_0x0087
            int r1 = com.tal.app.thinkacademy.live.business.R.id.cl_live_business_live_msg_private_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x0087
            int r1 = com.tal.app.thinkacademy.live.business.R.id.cl_live_business_live_msg_private_float
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x0087
            r8 = r0
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_live_msg_private
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            if (r9 == 0) goto L_0x0087
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_tutor_close
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x0087
            int r1 = com.tal.app.thinkacademy.live.business.R.id.ll_live_business_tutor_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.LinearLayout r11 = (android.widget.LinearLayout) r11
            if (r11 == 0) goto L_0x0087
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_frequently
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0087
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_irc_connecting
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.TextView r13 = (android.widget.TextView) r13
            if (r13 == 0) goto L_0x0087
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_live_msg_private_count
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.TextView r14 = (android.widget.TextView) r14
            if (r14 == 0) goto L_0x0087
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_live_msg_private_hint
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.TextView r15 = (android.widget.TextView) r15
            if (r15 == 0) goto L_0x0087
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_tutor_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.TextView r16 = (android.widget.TextView) r16
            if (r16 == 0) goto L_0x0087
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewLiveMsgPrivatePadBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewLiveMsgPrivatePadBinding
            r3 = r0
            r4 = r8
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r0
        L_0x0087:
            android.content.res.Resources r0 = r17.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewLiveMsgPrivatePadBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewLiveMsgPrivatePadBinding");
    }
}
