package com.tal.app.thinkacademy.lib.player.widget;

import com.tal.app.thinkacademy.lib.player.rtcplayer.SimpleRtcPlayerEngineEventListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/tal/app/thinkacademy/lib/player/widget/RtcTest$setupRtc$1", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/SimpleRtcPlayerEngineEventListener;", "onOnceLastMileQuality", "", "quality", "", "type", "", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcTest.kt */
public final class RtcTest$setupRtc$1 extends SimpleRtcPlayerEngineEventListener {
    final /* synthetic */ RtcTest this$0;

    RtcTest$setupRtc$1(RtcTest rtcTest) {
        this.this$0 = rtcTest;
    }

    public void onOnceLastMileQuality(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        RtcNetTestCallback access$getMRtcNetTestCallback$p = this.this$0.mRtcNetTestCallback;
        if (access$getMRtcNetTestCallback$p != null) {
            access$getMRtcNetTestCallback$p.onRtcOnceLastMileQuality(i, str);
        }
    }
}
