package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessVoteToastPrimaryBinding implements ViewBinding {
    public final RelativeLayout rlLiveBusinessVoteFailBackground;
    public final RelativeLayout rlLiveBusinessVoteSuccessBackground;
    public final RelativeLayout rlLiveBusinessVoteToastParent;
    private final RelativeLayout rootView;
    public final TextView tvLiveBusinessVoteCoins;
    public final TextView tvLiveBusinessVoteCongratulation;
    public final TextView tvLiveBusinessVoteOops;

    private LiveBusinessVoteToastPrimaryBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.rlLiveBusinessVoteFailBackground = relativeLayout2;
        this.rlLiveBusinessVoteSuccessBackground = relativeLayout3;
        this.rlLiveBusinessVoteToastParent = relativeLayout4;
        this.tvLiveBusinessVoteCoins = textView;
        this.tvLiveBusinessVoteCongratulation = textView2;
        this.tvLiveBusinessVoteOops = textView3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessVoteToastPrimaryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessVoteToastPrimaryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_vote_toast_primary;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessVoteToastPrimaryBinding bind(View view) {
        int i = R.id.rl_live_business_vote_fail_background;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
        if (relativeLayout != null) {
            i = R.id.rl_live_business_vote_success_background;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout2 != null) {
                RelativeLayout relativeLayout3 = (RelativeLayout) view;
                i = R.id.tv_live_business_vote_coins;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tv_live_business_vote_congratulation;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tv_live_business_vote_oops;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new LiveBusinessVoteToastPrimaryBinding(relativeLayout3, relativeLayout, relativeLayout2, relativeLayout3, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
