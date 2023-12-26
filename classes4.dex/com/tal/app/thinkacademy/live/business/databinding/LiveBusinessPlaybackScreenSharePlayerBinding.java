package com.tal.app.thinkacademy.live.business.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import com.tal.app.thinkacademy.lib.player.view.PlayerTextureView;
import com.tal.app.thinkacademy.live.business.R;

public final class LiveBusinessPlaybackScreenSharePlayerBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final PlayerTextureView vvLiveBusinessPlaybackVideo;

    private LiveBusinessPlaybackScreenSharePlayerBinding(FrameLayout frameLayout, PlayerTextureView playerTextureView) {
        this.rootView = frameLayout;
        this.vvLiveBusinessPlaybackVideo = playerTextureView;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LiveBusinessPlaybackScreenSharePlayerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LiveBusinessPlaybackScreenSharePlayerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        int i = R.layout.live_business_playback_screen_share_player;
        View inflate = !(layoutInflater instanceof LayoutInflater) ? layoutInflater.inflate(i, viewGroup, false) : XMLParseInstrumentation.inflate(layoutInflater, i, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LiveBusinessPlaybackScreenSharePlayerBinding bind(View view) {
        int i = R.id.vv_live_business_playback_video;
        PlayerTextureView playerTextureView = (PlayerTextureView) ViewBindings.findChildViewById(view, i);
        if (playerTextureView != null) {
            return new LiveBusinessPlaybackScreenSharePlayerBinding((FrameLayout) view, playerTextureView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
