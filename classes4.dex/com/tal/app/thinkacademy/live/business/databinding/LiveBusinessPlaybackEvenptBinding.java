package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessPlaybackEvenptBinding implements ViewBinding {
    public final ImageView ivLiveplaybackPointArrow;
    public final ImageView ivLiveplaybackPointPlay;
    public final ImageView liveBusinessIvEventPt;
    public final RelativeLayout rlLiveplaybackPointTop;
    private final RelativeLayout rootView;
    public final TextView tvLiveplaybackPointName;

    private LiveBusinessPlaybackEvenptBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout2, TextView textView) {
        this.rootView = relativeLayout;
        this.ivLiveplaybackPointArrow = imageView;
        this.ivLiveplaybackPointPlay = imageView2;
        this.liveBusinessIvEventPt = imageView3;
        this.rlLiveplaybackPointTop = relativeLayout2;
        this.tvLiveplaybackPointName = textView;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessPlaybackEvenptBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessPlaybackEvenptBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_playback_evenpt;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessPlaybackEvenptBinding bind(View view) {
        int i = R.id.iv_liveplayback_point_arrow;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_liveplayback_point_play;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.live_business_iv_event_pt;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.rl_liveplayback_point_top;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                    if (relativeLayout != null) {
                        i = R.id.tv_liveplayback_point_name;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new LiveBusinessPlaybackEvenptBinding((RelativeLayout) view, imageView, imageView2, imageView3, relativeLayout, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
