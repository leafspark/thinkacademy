package com.tal.app.thinkacademy.live.business.canvastriplescreen;

import android.view.SurfaceView;
import android.widget.FrameLayout;
import com.eaydu.omni.RTCChannel;
import com.eaydu.omni.RTCEngine;
import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.player.rtcplayer.IRTCEngineProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"com/tal/app/thinkacademy/live/business/canvastriplescreen/ScreenShareLiveView$mRTCEngineCallback$1", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/IRTCEngineProvider$RTCEngineCallback;", "onGetRTCEngine", "", "rtcEngine", "Lcom/eaydu/omni/RTCEngine;", "rtcChannel", "Lcom/eaydu/omni/RTCChannel;", "onGetRTCEngineFail", "code", "", "subCode", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScreenShareLiveView.kt */
public final class ScreenShareLiveView$mRTCEngineCallback$1 implements IRTCEngineProvider.RTCEngineCallback {
    final /* synthetic */ ScreenShareLiveView this$0;

    ScreenShareLiveView$mRTCEngineCallback$1(ScreenShareLiveView screenShareLiveView) {
        this.this$0 = screenShareLiveView;
    }

    public void onGetRTCEngine(RTCEngine rTCEngine, RTCChannel rTCChannel) {
        XesLog.i(this.this$0.TAG, "onGetRTCEngine");
        this.this$0.mRtcEngine = rTCEngine;
        RTCEngine access$getMRtcEngine$p = this.this$0.mRtcEngine;
        SurfaceView createRendererView = access$getMRtcEngine$p == null ? null : access$getMRtcEngine$p.createRendererView();
        if (createRendererView != null) {
            ScreenShareLiveView screenShareLiveView = this.this$0;
            createRendererView.setZOrderMediaOverlay(false);
            RTCEngine access$getMRtcEngine$p2 = screenShareLiveView.mRtcEngine;
            if (access$getMRtcEngine$p2 != null) {
                access$getMRtcEngine$p2.setupRemoteVideo(createRendererView, screenShareLiveView.getMUid());
            }
            RTCEngine access$getMRtcEngine$p3 = screenShareLiveView.mRtcEngine;
            if (access$getMRtcEngine$p3 != null) {
                access$getMRtcEngine$p3.setRemoteRenderMode(screenShareLiveView.getMUid(), RTCEngine.RTCVideoRenderMode.RTCVideoRenderModeFit);
            }
            screenShareLiveView.startPull();
            screenShareLiveView.addView(createRendererView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void onGetRTCEngineFail(int i, int i2) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("onGetRTCEngineFail", "RTC回调失败");
        XesLog.ut((XesLogTag) this.this$0.TAG, jsonObject);
    }
}
