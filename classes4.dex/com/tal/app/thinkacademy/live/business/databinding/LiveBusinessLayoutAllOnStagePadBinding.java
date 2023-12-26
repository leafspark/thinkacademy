package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.business.allonstage.view.TeacherView;
import com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxPluginView;

public final class LiveBusinessLayoutAllOnStagePadBinding implements ViewBinding {
    public final ChatBoxPluginView allStageChatBoxRoot;
    public final RecyclerView allStageStudentRecyclerview;
    public final TeacherView allStageTeacherRoot;
    public final LinearLayout bottomBtnLayout;
    public final LinearLayout bottomCameraBtn;
    public final View bottomDivider1;
    public final View bottomDivider2;
    public final LinearLayout bottomEmojiBtn;
    public final LinearLayout bottomMicBtn;
    public final ImageView btnBack;
    public final ImageView btnNetWorkQuality;
    public final ImageView cameraImage;
    public final TextView cameraText;
    public final ImageView emojiImage;
    public final TextView emojiText;
    public final FrameLayout listParent;
    public final ImageView micImage;
    public final TextView micText;
    private final RelativeLayout rootView;
    public final TextView tvTitle;

    private LiveBusinessLayoutAllOnStagePadBinding(RelativeLayout relativeLayout, ChatBoxPluginView chatBoxPluginView, RecyclerView recyclerView, TeacherView teacherView, LinearLayout linearLayout, LinearLayout linearLayout2, View view, View view2, LinearLayout linearLayout3, LinearLayout linearLayout4, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, ImageView imageView4, TextView textView2, FrameLayout frameLayout, ImageView imageView5, TextView textView3, TextView textView4) {
        this.rootView = relativeLayout;
        this.allStageChatBoxRoot = chatBoxPluginView;
        this.allStageStudentRecyclerview = recyclerView;
        this.allStageTeacherRoot = teacherView;
        this.bottomBtnLayout = linearLayout;
        this.bottomCameraBtn = linearLayout2;
        this.bottomDivider1 = view;
        this.bottomDivider2 = view2;
        this.bottomEmojiBtn = linearLayout3;
        this.bottomMicBtn = linearLayout4;
        this.btnBack = imageView;
        this.btnNetWorkQuality = imageView2;
        this.cameraImage = imageView3;
        this.cameraText = textView;
        this.emojiImage = imageView4;
        this.emojiText = textView2;
        this.listParent = frameLayout;
        this.micImage = imageView5;
        this.micText = textView3;
        this.tvTitle = textView4;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessLayoutAllOnStagePadBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessLayoutAllOnStagePadBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_layout_all_on_stage_pad;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.bottom_divider1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.bottom_divider2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.tal.app.thinkacademy.live.business.R.id.all_stage_student_recyclerview;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutAllOnStagePadBinding bind(android.view.View r24) {
        /*
            r0 = r24
            int r1 = com.tal.app.thinkacademy.live.business.R.id.all_stage_chat_box_root
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxPluginView r5 = (com.tal.app.thinkacademy.live.business.chatbox.widget.ChatBoxPluginView) r5
            if (r5 == 0) goto L_0x00df
            int r1 = com.tal.app.thinkacademy.live.business.R.id.all_stage_student_recyclerview
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
            if (r6 == 0) goto L_0x00df
            int r1 = com.tal.app.thinkacademy.live.business.R.id.all_stage_teacher_root
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            com.tal.app.thinkacademy.live.business.allonstage.view.TeacherView r7 = (com.tal.app.thinkacademy.live.business.allonstage.view.TeacherView) r7
            if (r7 == 0) goto L_0x00df
            int r1 = com.tal.app.thinkacademy.live.business.R.id.bottom_btn_layout
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            if (r8 == 0) goto L_0x00df
            int r1 = com.tal.app.thinkacademy.live.business.R.id.bottom_camera_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            if (r9 == 0) goto L_0x00df
            int r1 = com.tal.app.thinkacademy.live.business.R.id.bottom_divider1
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r10 == 0) goto L_0x00df
            int r1 = com.tal.app.thinkacademy.live.business.R.id.bottom_divider2
            android.view.View r11 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r11 == 0) goto L_0x00df
            int r1 = com.tal.app.thinkacademy.live.business.R.id.bottom_emoji_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            if (r12 == 0) goto L_0x00df
            int r1 = com.tal.app.thinkacademy.live.business.R.id.bottom_mic_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            if (r13 == 0) goto L_0x00df
            int r1 = com.tal.app.thinkacademy.live.business.R.id.btn_back
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.ImageView r14 = (android.widget.ImageView) r14
            if (r14 == 0) goto L_0x00df
            int r1 = com.tal.app.thinkacademy.live.business.R.id.btn_net_work_quality
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            if (r15 == 0) goto L_0x00df
            int r1 = com.tal.app.thinkacademy.live.business.R.id.camera_image
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.ImageView r16 = (android.widget.ImageView) r16
            if (r16 == 0) goto L_0x00df
            int r1 = com.tal.app.thinkacademy.live.business.R.id.camera_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.TextView r17 = (android.widget.TextView) r17
            if (r17 == 0) goto L_0x00df
            int r1 = com.tal.app.thinkacademy.live.business.R.id.emoji_image
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.ImageView r18 = (android.widget.ImageView) r18
            if (r18 == 0) goto L_0x00df
            int r1 = com.tal.app.thinkacademy.live.business.R.id.emoji_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.TextView r19 = (android.widget.TextView) r19
            if (r19 == 0) goto L_0x00df
            int r1 = com.tal.app.thinkacademy.live.business.R.id.list_parent
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.FrameLayout r20 = (android.widget.FrameLayout) r20
            if (r20 == 0) goto L_0x00df
            int r1 = com.tal.app.thinkacademy.live.business.R.id.mic_image
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.ImageView r21 = (android.widget.ImageView) r21
            if (r21 == 0) goto L_0x00df
            int r1 = com.tal.app.thinkacademy.live.business.R.id.mic_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x00df
            int r1 = com.tal.app.thinkacademy.live.business.R.id.tv_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x00df
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutAllOnStagePadBinding r1 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutAllOnStagePadBinding
            r3 = r1
            r4 = r0
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            return r1
        L_0x00df:
            android.content.res.Resources r0 = r24.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutAllOnStagePadBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessLayoutAllOnStagePadBinding");
    }
}
