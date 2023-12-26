package com.tal.app.thinkacademy.live.business.liveplayback.livebackplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import com.tal.app.thinkacademy.lib.player.track.VideoPlayerSceneType;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;

public class ScreenSharePlayerViewCtr extends BaseLivePlayBackPlayerViewCtr {
    public void initView(BaseLivePluginDriver baseLivePluginDriver, ILiveRoomProvider iLiveRoomProvider, String str) {
    }

    public ScreenSharePlayerViewCtr(Context context, String str, String str2, String str3, int i) {
        super(context, str, str2, str3, i, VideoPlayerSceneType.SCREEN_SHARE);
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.tal.app.thinkacademy.live.business.liveplayback.livebackplayer.LivePlayBackPlayerView, android.view.View] */
    public void initView(ViewGroup viewGroup) {
        this.mPlayerView = new ScreenSharePlayerView(this.mContext, new TextureView.SurfaceTextureListener() {
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                ScreenSharePlayerViewCtr.this.mSurface = new Surface(surfaceTexture);
                if (ScreenSharePlayerViewCtr.this.mPlayer != null) {
                    ScreenSharePlayerViewCtr.this.mPlayer.setSurface(ScreenSharePlayerViewCtr.this.mSurface);
                }
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (ScreenSharePlayerViewCtr.this.mPlayer == null) {
                    return false;
                }
                ScreenSharePlayerViewCtr.this.mPlayer.releaseSurface();
                return false;
            }
        });
        if (viewGroup != null) {
            viewGroup.addView(this.mPlayerView, new ViewGroup.LayoutParams(-1, -1));
        }
    }
}
