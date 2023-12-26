package com.tal.app.thinkacademy.live.business.liveplayback.livebackplayer;

import android.content.Context;
import android.view.TextureView;
import com.tal.app.thinkacademy.lib.player.view.PlayerTextureView;
import com.tal.app.thinkacademy.live.business.R;

class ScreenSharePlayerView extends LivePlayBackPlayerView {
    public ScreenSharePlayerView(Context context, TextureView.SurfaceTextureListener surfaceTextureListener) {
        super(context, surfaceTextureListener);
    }

    public int getLayoutId() {
        return R.layout.live_business_playback_screen_share_player;
    }

    public void initViews() {
        this.mTextureView = (PlayerTextureView) findViewById(R.id.vv_live_business_playback_video);
    }
}
