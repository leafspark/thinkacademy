package com.tal.app.thinkacademy.business.studycenter.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.business.study.study.vodplayer.HwVodVideoPlayerView;
import com.tal.app.thinkacademy.business.studycenter.R;

public final class VideoPlayerClassActivityBinding implements ViewBinding {
    public final HwVodVideoPlayerView playerView;
    private final ConstraintLayout rootView;

    private VideoPlayerClassActivityBinding(ConstraintLayout constraintLayout, HwVodVideoPlayerView hwVodVideoPlayerView) {
        this.rootView = constraintLayout;
        this.playerView = hwVodVideoPlayerView;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static VideoPlayerClassActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static VideoPlayerClassActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.video_player_class_activity;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static VideoPlayerClassActivityBinding bind(View view) {
        int i = R.id.playerView;
        HwVodVideoPlayerView findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            return new VideoPlayerClassActivityBinding((ConstraintLayout) view, findChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
