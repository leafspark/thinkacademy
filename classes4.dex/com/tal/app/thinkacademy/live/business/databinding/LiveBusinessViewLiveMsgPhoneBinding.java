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
import com.yy.mobile.rollingtextview.RollingTextView;

public final class LiveBusinessViewLiveMsgPhoneBinding implements ViewBinding {
    public final ChatBoxListPluginView chatBoxListView;
    public final ConstraintLayout clLiveBusinessMessageRoot;
    public final ConstraintLayout clLiveBusinessMessageTop;
    public final ImageView ivLiveBusinessMessageCoins;
    private final ConstraintLayout rootView;
    public final RollingTextView tvLiveBusinessMessageUsercoins;
    public final TextView tvLiveBusinessMessageUsercoinsDesc;
    public final View vLiveBusinessMessageMiddleLine;

    private LiveBusinessViewLiveMsgPhoneBinding(ConstraintLayout constraintLayout, ChatBoxListPluginView chatBoxListPluginView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, RollingTextView rollingTextView, TextView textView, View view) {
        this.rootView = constraintLayout;
        this.chatBoxListView = chatBoxListPluginView;
        this.clLiveBusinessMessageRoot = constraintLayout2;
        this.clLiveBusinessMessageTop = constraintLayout3;
        this.ivLiveBusinessMessageCoins = imageView;
        this.tvLiveBusinessMessageUsercoins = rollingTextView;
        this.tvLiveBusinessMessageUsercoinsDesc = textView;
        this.vLiveBusinessMessageMiddleLine = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessViewLiveMsgPhoneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessViewLiveMsgPhoneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_view_live_msg_phone;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003a, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.v_live_business_message_middle_line;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_message_usercoins;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewLiveMsgPhoneBinding bind(android.view.View r11) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.chat_box_list_view
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxListPluginView r4 = (com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxListPluginView) r4
            if (r4 == 0) goto L_0x004a
            r5 = r11
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            int r0 = com.tal.app.thinkacademy.live.business.R.id.cl_live_business_message_top
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x004a
            int r0 = com.tal.app.thinkacademy.live.business.R.id.iv_live_business_message_coins
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            if (r7 == 0) goto L_0x004a
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_message_usercoins
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            com.yy.mobile.rollingtextview.RollingTextView r8 = (com.yy.mobile.rollingtextview.RollingTextView) r8
            if (r8 == 0) goto L_0x004a
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_live_business_message_usercoins_desc
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x004a
            int r0 = com.tal.app.thinkacademy.live.business.R.id.v_live_business_message_middle_line
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r10 == 0) goto L_0x004a
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewLiveMsgPhoneBinding r11 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewLiveMsgPhoneBinding
            r2 = r11
            r3 = r5
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r11
        L_0x004a:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewLiveMsgPhoneBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewLiveMsgPhoneBinding");
    }
}
