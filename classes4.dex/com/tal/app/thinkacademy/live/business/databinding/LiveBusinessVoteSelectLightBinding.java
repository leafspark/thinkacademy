package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessVoteSelectLightBinding implements ViewBinding {
    public final Button btLivevideoVoteNoanswerSelect;
    public final LinearLayout llVoteLightContain;
    public final LinearLayout llVoteLightSelects;
    private final LinearLayout rootView;

    private LiveBusinessVoteSelectLightBinding(LinearLayout linearLayout, Button button, LinearLayout linearLayout2, LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.btLivevideoVoteNoanswerSelect = button;
        this.llVoteLightContain = linearLayout2;
        this.llVoteLightSelects = linearLayout3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessVoteSelectLightBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessVoteSelectLightBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_vote_select_light;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessVoteSelectLightBinding bind(View view) {
        int i = R.id.bt_livevideo_vote_noanswer_select;
        Button button = (Button) ViewBindings.findChildViewById(view, i);
        if (button != null) {
            i = R.id.ll_vote_light_contain;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.ll_vote_light_selects;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    return new LiveBusinessVoteSelectLightBinding((LinearLayout) view, button, linearLayout, linearLayout2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
