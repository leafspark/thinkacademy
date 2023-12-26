package com.tal.app.thinkacademy.lib.player.rtcplayer;

import com.eaydu.omni.RTCEngine;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.XesLogTag;
import com.tal.app.thinkacademy.lib.player.rtcplayer.entity.RtcVideoData;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayer$prePlay$1", "Lcom/eaydu/omni/RTCEngine$IRTCMediaVideoProcess;", "didCapturedVideoData", "", "data", "Lcom/eaydu/omni/RTCEngine$RTCVideoData;", "didRenderVideoData", "uid", "", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcPlayer.kt */
public final class RtcPlayer$prePlay$1 implements RTCEngine.IRTCMediaVideoProcess {
    final /* synthetic */ RtcPlayer this$0;

    RtcPlayer$prePlay$1(RtcPlayer rtcPlayer) {
        this.this$0 = rtcPlayer;
    }

    public void didCapturedVideoData(RTCEngine.RTCVideoData rTCVideoData) {
        Integer num;
        if (rTCVideoData == null) {
            num = null;
        } else {
            num = Integer.valueOf(rTCVideoData.width);
        }
        Intrinsics.checkNotNull(num);
        int intValue = num.intValue();
        int i = rTCVideoData.height;
        int i2 = rTCVideoData.yStride;
        int i3 = rTCVideoData.uStride;
        int i4 = rTCVideoData.vStride;
        int i5 = rTCVideoData.rotation;
        long j = rTCVideoData.renderTimeMs;
        byte[] bArr = rTCVideoData.data;
        Intrinsics.checkNotNullExpressionValue(bArr, "data.data");
        RtcVideoData rtcVideoData = new RtcVideoData(intValue, i, i2, i3, i4, i5, j, bArr);
        Iterator<IRTCMediaVideoProcess> it = this.this$0.getMVideoProcessListener().iterator();
        while (it.hasNext()) {
            it.next().didCapturedVideoData(rtcVideoData);
        }
    }

    public void didRenderVideoData(long j, RTCEngine.RTCVideoData rTCVideoData) {
        Integer num;
        if (rTCVideoData == null) {
            num = null;
        } else {
            num = Integer.valueOf(rTCVideoData.width);
        }
        Intrinsics.checkNotNull(num);
        int intValue = num.intValue();
        int i = rTCVideoData.height;
        int i2 = rTCVideoData.yStride;
        int i3 = rTCVideoData.uStride;
        int i4 = rTCVideoData.vStride;
        int i5 = rTCVideoData.rotation;
        long j2 = rTCVideoData.renderTimeMs;
        byte[] bArr = rTCVideoData.data;
        Intrinsics.checkNotNullExpressionValue(bArr, "data.data");
        RtcVideoData rtcVideoData = new RtcVideoData(intValue, i, i2, i3, i4, i5, j2, bArr);
        Iterator<IRTCMediaVideoProcess> it = this.this$0.getMVideoProcessListener().iterator();
        while (it.hasNext()) {
            it.next().didRenderVideoData(j, rtcVideoData);
            XesLogTag access$getTAG$p = this.this$0.TAG;
            Object[] objArr = new Object[1];
            objArr[0] = Intrinsics.stringPlus("didRenderVideoData", rTCVideoData == null ? null : Long.valueOf(rTCVideoData.renderTimeMs));
            XesLog.i(access$getTAG$p, objArr);
        }
    }
}
