package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import cn.dreamtobe.kpswitch.widget.KPSwitchFSPanelLinearLayout;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.flyco.roundview.RoundLinearLayout;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveMsgInputLayoutBinding implements ViewBinding {
    public final RoundLinearLayout btLivevideoMessageSend;
    public final EditText etLivevideoMessageContent;
    public final TextView liveBusinessTvInputWordsCount;
    public final RelativeLayout rlLivevideoMessageContent2;
    public final KPSwitchFSPanelLinearLayout rlLivevideoMessagePanelroot;
    private final ConstraintLayout rootView;

    private LiveMsgInputLayoutBinding(ConstraintLayout constraintLayout, RoundLinearLayout roundLinearLayout, EditText editText, TextView textView, RelativeLayout relativeLayout, KPSwitchFSPanelLinearLayout kPSwitchFSPanelLinearLayout) {
        this.rootView = constraintLayout;
        this.btLivevideoMessageSend = roundLinearLayout;
        this.etLivevideoMessageContent = editText;
        this.liveBusinessTvInputWordsCount = textView;
        this.rlLivevideoMessageContent2 = relativeLayout;
        this.rlLivevideoMessagePanelroot = kPSwitchFSPanelLinearLayout;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LiveMsgInputLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveMsgInputLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_msg_input_layout;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = com.tal.app.thinkacademy.live.business.R.id.rl_livevideo_message_panelroot;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tal.app.thinkacademy.live.business.databinding.LiveMsgInputLayoutBinding bind(android.view.View r9) {
        /*
            int r0 = com.tal.app.thinkacademy.live.business.R.id.bt_livevideo_message_send
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r4 = r1
            com.flyco.roundview.RoundLinearLayout r4 = (com.flyco.roundview.RoundLinearLayout) r4
            if (r4 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.live.business.R.id.et_livevideo_message_content
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r5 = r1
            android.widget.EditText r5 = (android.widget.EditText) r5
            if (r5 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.live.business.R.id.live_business_tv_input_words_count
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r6 = r1
            android.widget.TextView r6 = (android.widget.TextView) r6
            if (r6 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rl_livevideo_message_content2
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r7 = r1
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7
            if (r7 == 0) goto L_0x0041
            int r0 = com.tal.app.thinkacademy.live.business.R.id.rl_livevideo_message_panelroot
            android.view.View r1 = androidx.viewbinding.ViewBindings.findChildViewById(r9, r0)
            r8 = r1
            cn.dreamtobe.kpswitch.widget.KPSwitchFSPanelLinearLayout r8 = (cn.dreamtobe.kpswitch.widget.KPSwitchFSPanelLinearLayout) r8
            if (r8 == 0) goto L_0x0041
            com.tal.app.thinkacademy.live.business.databinding.LiveMsgInputLayoutBinding r0 = new com.tal.app.thinkacademy.live.business.databinding.LiveMsgInputLayoutBinding
            r3 = r9
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r0
        L_0x0041:
            android.content.res.Resources r9 = r9.getResources()
            java.lang.String r9 = r9.getResourceName(r0)
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Missing required view with ID: "
            java.lang.String r9 = r1.concat(r9)
            r0.<init>(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.databinding.LiveMsgInputLayoutBinding.bind(android.view.View):com.tal.app.thinkacademy.live.business.databinding.LiveMsgInputLayoutBinding");
    }
}
