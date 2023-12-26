package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import cn.dreamtobe.kpswitch.widget.KPSwitchFSPanelLinearLayout;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessViewChatBoxInputBinding implements ViewBinding {
    public final EditText etInput;
    public final LinearLayout llChatBoxHotWords;
    public final KPSwitchFSPanelLinearLayout llPanel;
    public final ConstraintLayout rlChatBoxInput;
    public final RelativeLayout rlSend;
    private final ConstraintLayout rootView;
    public final TextView tvInputWordsCount;
    public final View viewChatBoxInputBg;

    private LiveBusinessViewChatBoxInputBinding(ConstraintLayout constraintLayout, EditText editText, LinearLayout linearLayout, KPSwitchFSPanelLinearLayout kPSwitchFSPanelLinearLayout, ConstraintLayout constraintLayout2, RelativeLayout relativeLayout, TextView textView, View view) {
        this.rootView = constraintLayout;
        this.etInput = editText;
        this.llChatBoxHotWords = linearLayout;
        this.llPanel = kPSwitchFSPanelLinearLayout;
        this.rlChatBoxInput = constraintLayout2;
        this.rlSend = relativeLayout;
        this.tvInputWordsCount = textView;
        this.viewChatBoxInputBg = view;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessViewChatBoxInputBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessViewChatBoxInputBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_view_chat_box_input;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0042, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.view_chat_box_input_bg;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0016, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.ll_panel;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.rl_chat_box_input;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewChatBoxInputBinding bind(android.view.View r11) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.et_input
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r4 = r1
            android.widget.EditText r4 = (android.widget.EditText) r4
            if (r4 == 0) goto L_0x0054
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ll_chat_box_hot_words
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r5 = r1
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            if (r5 == 0) goto L_0x0054
            int r0 = com.tal.app.thinkacademy.live.business.R.id.ll_panel
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r6 = r1
            cn.dreamtobe.kpswitch.widget.KPSwitchFSPanelLinearLayout r6 = (cn.dreamtobe.kpswitch.widget.KPSwitchFSPanelLinearLayout) r6
            if (r6 == 0) goto L_0x0054
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rl_chat_box_input
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r7 = r1
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            if (r7 == 0) goto L_0x0054
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rl_send
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r8 = r1
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
            if (r8 == 0) goto L_0x0054
            int r0 = com.tal.app.thinkacademy.live.business.R.id.tv_input_words_count
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0054
            int r0 = com.tal.app.thinkacademy.live.business.R.id.view_chat_box_input_bg
            android.view.View r10 = androidx.viewbinding.ViewBindings.findChildViewById(r11, r0)
            if (r10 == 0) goto L_0x0054
            com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewChatBoxInputBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewChatBoxInputBinding
            r3 = r11
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return r0
        L_0x0054:
            android.content.res.Resources r11 = r11.getResources()
            java.lang.String r11 = r11.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r11 = r1.concat(r11)
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewChatBoxInputBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveBusinessViewChatBoxInputBinding");
    }
}
