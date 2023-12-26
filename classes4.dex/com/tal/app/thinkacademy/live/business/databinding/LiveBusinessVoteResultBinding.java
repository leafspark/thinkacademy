package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessVoteResultBinding implements ViewBinding {
    public final TextView liveBusinessResultBottom;
    public final LinearLayout liveBusinessResultLayout;
    public final TextView liveBusinessResultTop;
    private final LinearLayout rootView;

    private LiveBusinessVoteResultBinding(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2, TextView textView2) {
        this.rootView = linearLayout;
        this.liveBusinessResultBottom = textView;
        this.liveBusinessResultLayout = linearLayout2;
        this.liveBusinessResultTop = textView2;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessVoteResultBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessVoteResultBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_vote_result;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessVoteResultBinding bind(View view) {
        int i = R.id.live_business_result_bottom;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            int i2 = R.id.live_business_result_top;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i2);
            if (textView2 != null) {
                return new LiveBusinessVoteResultBinding(linearLayout, textView, linearLayout, textView2);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
