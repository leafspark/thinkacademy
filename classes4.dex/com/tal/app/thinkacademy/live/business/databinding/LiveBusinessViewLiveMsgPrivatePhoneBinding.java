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
import com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxListPluginView;

public final class LiveBusinessViewLiveMsgPrivatePhoneBinding implements ViewBinding {
    public final ChatBoxListPluginView chatBoxListView;
    public final ConstraintLayout clLiveBusinessLiveMsgPrivateContent;
    public final ConstraintLayout clLiveBusinessLiveMsgPrivateFloat;
    public final ConstraintLayout clLiveBusinessLiveMsgPrivateRoot;
    public final ImageView ivLiveBusinessLiveMsgPrivate;
    private final ConstraintLayout rootView;
    public final TextView tvLiveBusinessLiveMsgPrivateCount;

    private LiveBusinessViewLiveMsgPrivatePhoneBinding(ConstraintLayout constraintLayout, ChatBoxListPluginView chatBoxListPluginView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.chatBoxListView = chatBoxListPluginView;
        this.clLiveBusinessLiveMsgPrivateContent = constraintLayout2;
        this.clLiveBusinessLiveMsgPrivateFloat = constraintLayout3;
        this.clLiveBusinessLiveMsgPrivateRoot = constraintLayout4;
        this.ivLiveBusinessLiveMsgPrivate = imageView;
        this.tvLiveBusinessLiveMsgPrivateCount = textView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessViewLiveMsgPrivatePhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessViewLiveMsgPrivatePhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_view_live_msg_private_phone;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.cl_live_business_live_msg_private_content;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.cl_live_business_live_msg_private_float;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewLiveMsgPrivatePhoneBinding bind(android.view.View r10) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.chat_box_list_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r4 = r1
            com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxListPluginView r4 = (com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxListPluginView) r4
            if (r4 == 0) goto L_0x0042
            int r0 = com.tal.app.thinkacademy.live.business.R.id.cl_live_business_live_msg_private_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r5 = r1
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            if (r5 == 0) goto L_0x0042
            int r0 = com.tal.app.thinkacademy.live.business.R.id.cl_live_business_live_msg_private_float
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r6 = r1
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x0042
            r7 = r10
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_live_msg_private
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            if (r8 == 0) goto L_0x0042
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_live_msg_private_count
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r10, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0042
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewLiveMsgPrivatePhoneBinding r10 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewLiveMsgPrivatePhoneBinding
            r2 = r10
            r3 = r7
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return r10
        L_0x0042:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r10 = r1.concat(r10)
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewLiveMsgPrivatePhoneBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewLiveMsgPrivatePhoneBinding");
    }
}
