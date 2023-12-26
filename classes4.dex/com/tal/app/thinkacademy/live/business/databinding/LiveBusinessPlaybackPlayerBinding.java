package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.commui.widget.MarqueeText;
import com.tal.app.thinkacademy.lib.player.view.PlayerTextureView;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessPlaybackPlayerBinding implements ViewBinding {
    public final PlayerTextureView ptvLiveBusinessPlaybackVideo;
    private final FrameLayout rootView;
    public final MarqueeText tvPrivateHelp;

    private LiveBusinessPlaybackPlayerBinding(FrameLayout frameLayout, PlayerTextureView playerTextureView, MarqueeText marqueeText) {
        this.rootView = frameLayout;
        this.ptvLiveBusinessPlaybackVideo = playerTextureView;
        this.tvPrivateHelp = marqueeText;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessPlaybackPlayerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessPlaybackPlayerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_playback_player;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessPlaybackPlayerBinding bind(View view) {
        int i = R.id.ptv_live_business_playback_video;
        PlayerTextureView playerTextureView = (PlayerTextureView) ViewBindings.findChildViewById(view, i);
        if (playerTextureView != null) {
            i = R.id.tv_private_help;
            MarqueeText marqueeText = (MarqueeText) ViewBindings.findChildViewById(view, i);
            if (marqueeText != null) {
                return new LiveBusinessPlaybackPlayerBinding((FrameLayout) view, playerTextureView, marqueeText);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
