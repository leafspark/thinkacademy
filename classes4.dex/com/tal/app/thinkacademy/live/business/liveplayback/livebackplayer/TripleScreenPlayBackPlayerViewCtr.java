package com.tal.app.thinkacademy.live.business.liveplayback.livebackplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import com.tal.app.thinkacademy.common.playerpreload.PlayerPreLoadHelp;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.track.VideoPlayerSceneType;
import com.tal.app.thinkacademy.live.core.interfaces.ILiveRoomProvider;
import com.tal.app.thinkacademy.live.core.layout.LiveAreaContext;
import com.tal.app.thinkacademy.live.core.plugin.BaseLivePluginDriver;

public class TripleScreenPlayBackPlayerViewCtr extends BaseLivePlayBackPlayerViewCtr {
    public TripleScreenPlayBackPlayerViewCtr(Context context, String str, String str2, String str3, int i) {
        super(context, str, str2, str3, i, VideoPlayerSceneType.PLAYBACK);
        if (PlayerPreLoadHelp.Companion.getInstance().isStartPlaybackHlsCache()) {
            XesLog.dt("回放", "回放启动边下边播，云控允许!!!!");
            if (this.mPlayer != null) {
                this.mPlayer.enableHLSCache();
                return;
            }
            return;
        }
        XesLog.dt("回放", "回放不启动边下边播，云控不允许!!!!");
    }

    public void initView(BaseLivePluginDriver baseLivePluginDriver, ILiveRoomProvider iLiveRoomProvider, String str) {
        this.mPlayerView = new LivePlayBackPlayerView(this.mContext, new TextureView.SurfaceTextureListener() {
            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                TripleScreenPlayBackPlayerViewCtr.this.mSurface = new Surface(surfaceTexture);
                if (TripleScreenPlayBackPlayerViewCtr.this.mPlayer != null) {
                    TripleScreenPlayBackPlayerViewCtr.this.mPlayer.setSurface(TripleScreenPlayBackPlayerViewCtr.this.mSurface);
                }
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (TripleScreenPlayBackPlayerViewCtr.this.mPlayer == null) {
                    return false;
                }
                TripleScreenPlayBackPlayerViewCtr.this.mPlayer.releaseSurface();
                return false;
            }
        });
        iLiveRoomProvider.addView(baseLivePluginDriver, this.mPlayerView, str, LiveAreaContext.get().getHeadLp().newLp());
        LiveAreaContext.get().layoutObserver.observe(baseLivePluginDriver, new TripleScreenPlayBackPlayerViewCtr$$ExternalSyntheticLambda0(this));
    }

    public /* synthetic */ void lambda$initView$0$TripleScreenPlayBackPlayerViewCtr(LiveAreaContext liveAreaContext) {
        if (this.mPlayerView != null) {
            XesLog.it("LiveVideoPoint", "老师回放>>>videoSizeChange");
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPlayerView.getLayoutParams();
            liveAreaContext.getHeadLp().mergeLp(layoutParams);
            this.mPlayerView.setLayoutParams(layoutParams);
        }
    }
}
