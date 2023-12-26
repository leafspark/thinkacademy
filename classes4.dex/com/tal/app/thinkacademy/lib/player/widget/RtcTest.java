package com.tal.app.thinkacademy.lib.player.widget;

import android.content.Context;
import android.view.SurfaceView;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0015\u001a\u00020\fR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/widget/RtcTest;", "", "context", "Landroid/content/Context;", "uid", "", "(Landroid/content/Context;J)V", "mRtcNetTestCallback", "Lcom/tal/app/thinkacademy/lib/player/widget/RtcNetTestCallback;", "mRtcPlayer", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayer;", "destroyRtc", "", "disableLastMileProbeTest", "enableLastMileProbeTest", "setupRtc", "token", "", "callback", "startPreview", "Landroid/view/SurfaceView;", "stopPreview", "Companion", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcTest.kt */
public final class RtcTest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "RtcTest";
    /* access modifiers changed from: private */
    public RtcNetTestCallback mRtcNetTestCallback;
    private final RtcPlayer mRtcPlayer;
    private final long uid;

    public RtcTest(Context context, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.uid = j;
        this.mRtcPlayer = new RtcPlayer(context);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/widget/RtcTest$Companion;", "", "()V", "TAG", "", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RtcTest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void setupRtc(String str, RtcNetTestCallback rtcNetTestCallback) {
        Intrinsics.checkNotNullParameter(str, "token");
        Intrinsics.checkNotNullParameter(rtcNetTestCallback, "callback");
        if (!this.mRtcPlayer.isRtcInit()) {
            this.mRtcNetTestCallback = rtcNetTestCallback;
            this.mRtcPlayer.addEtcEngineEventListener("deviceTest", new RtcTest$setupRtc$1(this));
            this.mRtcPlayer.initPlay(str, (String) null, true);
        }
    }

    public final void destroyRtc() {
        this.mRtcNetTestCallback = null;
        this.mRtcPlayer.destroyPlayer();
    }

    public final void enableLastMileProbeTest() {
        this.mRtcPlayer.enableLastMileProbeTest();
    }

    public final void disableLastMileProbeTest() {
        this.mRtcPlayer.disableLastMileProbeTest();
    }

    public final SurfaceView startPreview() {
        SurfaceView remoteSurfaceView = this.mRtcPlayer.getRemoteSurfaceView(this.uid);
        if (remoteSurfaceView == null) {
            return null;
        }
        this.mRtcPlayer.startPreview(remoteSurfaceView);
        return remoteSurfaceView;
    }

    public final void stopPreview() {
        this.mRtcPlayer.stopPreview();
    }
}
