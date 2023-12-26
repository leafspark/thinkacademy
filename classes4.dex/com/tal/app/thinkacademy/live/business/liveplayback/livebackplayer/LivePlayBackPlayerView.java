package com.tal.app.thinkacademy.live.business.liveplayback.livebackplayer;

import android.content.Context;
import android.view.TextureView;
import android.widget.TextView;
import com.tal.app.thinkacademy.common.util.PadUtils;
import com.tal.app.thinkacademy.lib.player.view.PlayerTextureView;
import com.tal.app.thinkacademy.live.business.R;
import com.tal.app.thinkacademy.live.core.plugin.pluginview.BaseLivePluginView;

class LivePlayBackPlayerView extends BaseLivePluginView {
    private TextView mPrivateHelp;
    private TextureView.SurfaceTextureListener mSurfaceCallback;
    protected PlayerTextureView mTextureView;

    public LivePlayBackPlayerView(Context context, TextureView.SurfaceTextureListener surfaceTextureListener) {
        super(context);
        this.mSurfaceCallback = surfaceTextureListener;
        initVideoView();
    }

    public int getLayoutId() {
        return R.layout.live_business_playback_player;
    }

    public void initViews() {
        LivePlayBackPlayerView.super.initViews();
        this.mTextureView = (PlayerTextureView) findViewById(R.id.ptv_live_business_playback_video);
        this.mPrivateHelp = (TextView) findViewById(R.id.tv_private_help);
        if (this.mContext != null && PadUtils.isPad(this.mContext)) {
            this.mPrivateHelp.setTextSize(2, 16.0f);
        }
    }

    public void initData() {
        LivePlayBackPlayerView.super.initData();
    }

    private void initVideoView() {
        PlayerTextureView playerTextureView = this.mTextureView;
        if (playerTextureView != null) {
            playerTextureView.setSurfaceTextureListener(this.mSurfaceCallback);
        }
    }

    public PlayerTextureView getTextureView() {
        return this.mTextureView;
    }

    public void showHelpTitle(boolean z) {
        this.mPrivateHelp.setVisibility(z ? 0 : 4);
    }
}
