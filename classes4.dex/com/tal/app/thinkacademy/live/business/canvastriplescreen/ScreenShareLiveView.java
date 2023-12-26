package com.tal.app.thinkacademy.live.business.canvastriplescreen;

import android.content.Context;
import com.eaydu.omni.RTCEngine;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.rtcplayer.IRTCEngineProvider;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RTCEngineProvider;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RTCEngineProviderUtils;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayer;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayerUtil;
import com.tal.app.thinkacademy.live.Tag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/ScreenShareLiveView;", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/BaseScreenShareView;", "context", "Landroid/content/Context;", "mUid", "", "(Landroid/content/Context;J)V", "TAG", "Lcom/tal/app/thinkacademy/live/Tag;", "mPlayer", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayer;", "mProvider", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RTCEngineProvider;", "mRTCEngineCallback", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/IRTCEngineProvider$RTCEngineCallback;", "mRtcEngine", "Lcom/eaydu/omni/RTCEngine;", "getMUid", "()J", "setMUid", "(J)V", "initView", "", "notifyDataChange", "couse", "Lcom/tal/app/thinkacademy/live/business/canvastriplescreen/CourseWareBean;", "release", "startPull", "stopPull", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScreenShareLiveView.kt */
public final class ScreenShareLiveView extends BaseScreenShareView {
    /* access modifiers changed from: private */
    public final Tag TAG = Tag.SCREEN_SHARE;
    private RtcPlayer mPlayer;
    private RTCEngineProvider mProvider;
    private final IRTCEngineProvider.RTCEngineCallback mRTCEngineCallback = new ScreenShareLiveView$mRTCEngineCallback$1(this);
    /* access modifiers changed from: private */
    public RTCEngine mRtcEngine;
    private long mUid;

    public final long getMUid() {
        return this.mUid;
    }

    public final void setMUid(long j) {
        this.mUid = j;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScreenShareLiveView(Context context, long j) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mUid = j;
    }

    /* access modifiers changed from: private */
    public final void startPull() {
        XesLog.i(this.TAG, "startPull");
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine != null) {
            rTCEngine.muteRemoteVideo(this.mUid, false);
        }
        RTCEngine rTCEngine2 = this.mRtcEngine;
        if (rTCEngine2 != null) {
            rTCEngine2.muteRemoteAudio(this.mUid, false);
        }
    }

    private final void stopPull() {
        XesLog.i(this.TAG, "stopPull");
        RTCEngine rTCEngine = this.mRtcEngine;
        if (rTCEngine != null) {
            rTCEngine.muteRemoteVideo(this.mUid, true);
        }
        RTCEngine rTCEngine2 = this.mRtcEngine;
        if (rTCEngine2 != null) {
            rTCEngine2.muteRemoteAudio(this.mUid, true);
        }
    }

    public void initView() {
        RtcPlayer rtcPlayer = RtcPlayerUtil.getInstance().get("Live");
        this.mPlayer = rtcPlayer;
        if (rtcPlayer == null) {
            this.mPlayer = new RtcPlayer(getMContext());
            RtcPlayerUtil.getInstance().put("Live", this.mPlayer);
            XesLog.i(this.TAG, Intrinsics.stringPlus("mPlayer is", this.mPlayer));
        }
        RTCEngineProvider rTCEngineProvider = RTCEngineProviderUtils.getInstance().get("Live");
        this.mProvider = rTCEngineProvider;
        if (rTCEngineProvider == null) {
            this.mProvider = new RTCEngineProvider(this.mPlayer);
            RTCEngineProviderUtils.getInstance().put("Live", this.mProvider);
            XesLog.i(this.TAG, Intrinsics.stringPlus("provider is", this.mProvider));
        }
        RTCEngineProvider rTCEngineProvider2 = this.mProvider;
        if (rTCEngineProvider2 != null) {
            rTCEngineProvider2.provide((String) null, this.mRTCEngineCallback);
        }
    }

    public void release() {
        stopPull();
        removeAllViews();
    }

    public void notifyDataChange(CourseWareBean courseWareBean) {
        Intrinsics.checkNotNullParameter(courseWareBean, "couse");
        if (this.mUid != courseWareBean.shareInfoUid) {
            stopPull();
            this.mUid = courseWareBean.shareInfoUid;
            startPull();
        }
    }
}
