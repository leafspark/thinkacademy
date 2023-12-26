package com.tal.app.thinkacademy.lib.player.rtcplayer;

import com.eaydu.omni.RTCEngine;
import com.tal.app.thinkacademy.lib.player.rtcplayer.entity.RtcAudioData;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, d2 = {"com/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayer$prePlay$2", "Lcom/eaydu/omni/RTCEngine$IRTCMediaAudioProcess;", "didCapturedAuidoData", "", "data", "Lcom/eaydu/omni/RTCEngine$RTCAudioData;", "didRenderAudioData", "uid", "", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcPlayer.kt */
public final class RtcPlayer$prePlay$2 implements RTCEngine.IRTCMediaAudioProcess {
    final /* synthetic */ RtcPlayer this$0;

    RtcPlayer$prePlay$2(RtcPlayer rtcPlayer) {
        this.this$0 = rtcPlayer;
    }

    public void didRenderAudioData(long j, RTCEngine.RTCAudioData rTCAudioData) {
        Integer num;
        if (rTCAudioData == null) {
            num = null;
        } else {
            num = Integer.valueOf(rTCAudioData.samples);
        }
        Intrinsics.checkNotNull(num);
        int intValue = num.intValue();
        int i = rTCAudioData.bytesPerSample;
        int i2 = rTCAudioData.channels;
        int i3 = rTCAudioData.samplesPerSec;
        int i4 = rTCAudioData.bufferLength;
        long j2 = rTCAudioData.renderTimeMs;
        byte[] bArr = rTCAudioData.buffer;
        Intrinsics.checkNotNullExpressionValue(bArr, "data.buffer");
        RtcAudioData rtcAudioData = new RtcAudioData(intValue, i, i2, i3, i4, j2, bArr);
        Iterator<IRTCMediaAudioProcess> it = this.this$0.getMAudioProcessListener().iterator();
        while (it.hasNext()) {
            it.next().didRenderAudioData(j, rtcAudioData);
        }
    }

    public void didCapturedAuidoData(RTCEngine.RTCAudioData rTCAudioData) {
        Integer num;
        if (rTCAudioData == null) {
            num = null;
        } else {
            num = Integer.valueOf(rTCAudioData.samples);
        }
        Intrinsics.checkNotNull(num);
        int intValue = num.intValue();
        int i = rTCAudioData.bytesPerSample;
        int i2 = rTCAudioData.channels;
        int i3 = rTCAudioData.samplesPerSec;
        int i4 = rTCAudioData.bufferLength;
        long j = rTCAudioData.renderTimeMs;
        byte[] bArr = rTCAudioData.buffer;
        Intrinsics.checkNotNullExpressionValue(bArr, "data.buffer");
        RtcAudioData rtcAudioData = new RtcAudioData(intValue, i, i2, i3, i4, j, bArr);
        Iterator<IRTCMediaAudioProcess> it = this.this$0.getMAudioProcessListener().iterator();
        while (it.hasNext()) {
            it.next().didCapturedAuidoData(rtcAudioData);
        }
    }
}
