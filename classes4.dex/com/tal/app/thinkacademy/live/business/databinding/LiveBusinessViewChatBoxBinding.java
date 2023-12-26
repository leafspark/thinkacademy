package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxListPluginView;

public final class LiveBusinessViewChatBoxBinding implements ViewBinding {
    public final ChatBoxListPluginView chatBoxListView;
    public final ConstraintLayout clChatBoxMsgContent;
    public final ConstraintLayout clChatBoxRoot;
    public final ConstraintLayout clChatBoxTitle;
    public final ConstraintLayout clChoose;
    public final ConstraintLayout clIrc;
    public final ImageView ivChooseAll;
    public final ImageView ivChooseTeacher;
    public final ImageView ivSend;
    public final ImageView ivSendToArrow;
    public final View lineView;
    public final RelativeLayout rlChoose;
    public final RelativeLayout rlClose;
    public final RelativeLayout rlSaySomething;
    public final RelativeLayout rlSend;
    public final RelativeLayout rlSendTo;
    private final ConstraintLayout rootView;
    public final RecyclerView rvQuickReply;
    public final ScrollView scrollViewMsgContent;
    public final TextView tvChooseAll;
    public final TextView tvChooseTeacher;
    public final TextView tvClose;
    public final TextView tvFrequently;
    public final TextView tvIrc;
    public final TextView tvMsgContent;
    public final TextView tvSend;
    public final TextView tvSendTo;
    public final View viewSaySomethingCursor;

    private LiveBusinessViewChatBoxBinding(ConstraintLayout constraintLayout, ChatBoxListPluginView chatBoxListPluginView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, View view, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RecyclerView recyclerView, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, View view2) {
        this.rootView = constraintLayout;
        this.chatBoxListView = chatBoxListPluginView;
        this.clChatBoxMsgContent = constraintLayout2;
        this.clChatBoxRoot = constraintLayout3;
        this.clChatBoxTitle = constraintLayout4;
        this.clChoose = constraintLayout5;
        this.clIrc = constraintLayout6;
        this.ivChooseAll = imageView;
        this.ivChooseTeacher = imageView2;
        this.ivSend = imageView3;
        this.ivSendToArrow = imageView4;
        this.lineView = view;
        this.rlChoose = relativeLayout;
        this.rlClose = relativeLayout2;
        this.rlSaySomething = relativeLayout3;
        this.rlSend = relativeLayout4;
        this.rlSendTo = relativeLayout5;
        this.rvQuickReply = recyclerView;
        this.scrollViewMsgContent = scrollView;
        this.tvChooseAll = textView;
        this.tvChooseTeacher = textView2;
        this.tvClose = textView3;
        this.tvFrequently = textView4;
        this.tvIrc = textView5;
        this.tvMsgContent = textView6;
        this.tvSend = textView7;
        this.tvSendTo = textView8;
        this.viewSaySomethingCursor = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessViewChatBoxBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessViewChatBoxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_view_chat_box;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0068, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.line_view;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.cl_chat_box_msg_content;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ac, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.rv_quick_reply;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0124, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.view_say_something_cursor;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0026, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.cl_choose;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0031, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.cl_irc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewChatBoxBinding bind(android.view.View r32) {
        /*
            r0 = r32
            int r1 = com.tal.app.thinkacademy.live.business.R.id.chat_box_list_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxListPluginView r5 = (com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxListPluginView) r5
            if (r5 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.cl_chat_box_msg_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            if (r6 == 0) goto L_0x0134
            r7 = r0
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            int r1 = com.tal.app.thinkacademy.live.business.R.id.cl_chat_box_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.cl_choose
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            if (r9 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.cl_irc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            if (r10 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_choose_all
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.ImageView r11 = (android.widget.ImageView) r11
            if (r11 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_choose_teacher
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            if (r12 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_send
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            if (r13 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.iv_send_to_arrow
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.line_view
            android.view.View r15 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r15 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_choose
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.RelativeLayout r16 = (android.widget.RelativeLayout) r16
            if (r16 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_close
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.RelativeLayout r17 = (android.widget.RelativeLayout) r17
            if (r17 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_say_something
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.RelativeLayout r18 = (android.widget.RelativeLayout) r18
            if (r18 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_send
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.RelativeLayout r19 = (android.widget.RelativeLayout) r19
            if (r19 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rl_send_to
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.RelativeLayout r20 = (android.widget.RelativeLayout) r20
            if (r20 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.rv_quick_reply
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            androidx.recyclerview.widget.RecyclerView r21 = (androidx.recyclerview.widget.RecyclerView) r21
            if (r21 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.scroll_view_msg_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.ScrollView r22 = (android.widget.ScrollView) r22
            if (r22 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_choose_all
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_choose_teacher
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.TextView r24 = (android.widget.TextView) r24
            if (r24 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_close
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            android.widget.TextView r25 = (android.widget.TextView) r25
            if (r25 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_frequently
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            android.widget.TextView r26 = (android.widget.TextView) r26
            if (r26 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_irc
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            android.widget.TextView r27 = (android.widget.TextView) r27
            if (r27 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_msg_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            android.widget.TextView r28 = (android.widget.TextView) r28
            if (r28 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_send
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r29 = r2
            android.widget.TextView r29 = (android.widget.TextView) r29
            if (r29 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_send_to
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r30 = r2
            android.widget.TextView r30 = (android.widget.TextView) r30
            if (r30 == 0) goto L_0x0134
            int r1 = com.tal.app.thinkacademy.live.business.R.id.view_say_something_cursor
            android.view.View r31 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r31 == 0) goto L_0x0134
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewChatBoxBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewChatBoxBinding
            r3 = r0
            r4 = r7
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            return r0
        L_0x0134:
            android.content.res.Resources r0 = r32.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewChatBoxBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewChatBoxBinding");
    }
}
