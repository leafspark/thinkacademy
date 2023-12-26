package com.tal.app.thinkacademy.lib.player.rtcplayer;

import com.eaydu.omni.RTCEngine;
import com.eaydu.omni.listener.RTCConnectionStateType;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.Tag;
import com.tal.app.thinkacademy.lib.utils.HeartBeatUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcEnginEventListenerAbs;", "Lcom/eaydu/omni/RTCEngine$IRtcEngineEventListener;", "()V", "connectionChangedToState", "", "state", "Lcom/eaydu/omni/listener/RTCConnectionStateType;", "reason", "", "didAudioMuted", "uid", "", "muted", "", "didOccurError", "code", "Lcom/eaydu/omni/RTCEngine$RTCEngineErrorCode;", "didOfflineOfUid", "didVideoMuted", "localUserJoindWithUid", "onOnceLastMileQuality", "lastmileQuality", "Lcom/eaydu/omni/RTCEngine$RTC_LASTMILE_QUALITY;", "onRemoteVideoStateChanged", "", "remoteUserJoinWitnUid", "remotefirstAudioRecvWithUid", "remotefirstVideoRecvWithUid", "reportAudioVolumeOfSpeaker", "volume", "reportRtcStats", "stats", "Lcom/eaydu/omni/RTCEngine$ReportRtcStats;", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcEnginEventListenerAbs.kt */
public class RtcEnginEventListenerAbs implements RTCEngine.IRtcEngineEventListener {
    public void reportAudioVolumeOfSpeaker(long j, int i) {
    }

    public void localUserJoindWithUid(long j) {
        XesLog.i(Tag.RTC_BASE, Intrinsics.stringPlus("加入频道回调，uid=", Long.valueOf(j)));
    }

    public void remotefirstVideoRecvWithUid(long j) {
        XesLog.i(Tag.RTC_BASE, Intrinsics.stringPlus("已完成远端视频首帧解码回调，uid=", Long.valueOf(j)));
    }

    public void remotefirstAudioRecvWithUid(long j) {
        XesLog.i(Tag.RTC_BASE, Intrinsics.stringPlus("已接收远端音频首帧回调，uid=", Long.valueOf(j)));
    }

    public void remoteUserJoinWitnUid(long j) {
        XesLog.i(Tag.RTC_BASE, Intrinsics.stringPlus("远端用户（通信场景）/主播（直播场景）加入当前频道回调，uid=", Long.valueOf(j)));
    }

    public void didOfflineOfUid(long j) {
        XesLog.i(Tag.RTC_BASE, Intrinsics.stringPlus("远端用户（通信场景）/主播（直播场景）离开当前频道回调，uid=", Long.valueOf(j)));
    }

    public void didAudioMuted(long j, boolean z) {
        XesLog.i(Tag.RTC_BASE, "远端用户停止/恢复发送音频流回调，uid=" + j + "，该用户是否静音（true：已静音，false：已取消静音）=" + z);
    }

    public void didVideoMuted(long j, boolean z) {
        XesLog.i(Tag.RTC_BASE, "远端用户停止/恢复发送视频流回调，uid=" + j + "，该用户是否暂停发送视频流（true：已暂停，false：已恢复）=" + z);
    }

    public void didOccurError(RTCEngine.RTCEngineErrorCode rTCEngineErrorCode) {
        Intrinsics.checkNotNullParameter(rTCEngineErrorCode, "code");
        XesLog.i(Tag.RTC_BASE, Intrinsics.stringPlus("发生错误回调，错误码=", rTCEngineErrorCode.name()));
    }

    public void connectionChangedToState(RTCConnectionStateType rTCConnectionStateType, String str) {
        Intrinsics.checkNotNullParameter(rTCConnectionStateType, "state");
        Intrinsics.checkNotNullParameter(str, "reason");
        XesLog.i(Tag.RTC_BASE, "网络连接状态已改变回调，当前的网络连接状态=" + rTCConnectionStateType.name() + "，引起当前网络连接状态发生改变的原因=" + str);
    }

    public void onRemoteVideoStateChanged(long j, int i) {
        XesLog.i(Tag.RTC_BASE, "远端用户视频状态发生改变回调，uid=" + j + "，远端视频流状态（0：远端视频默认初始状态，1：本地用户已接收远端视频首包，2：远端视频流正在解码，正常播放，3：远端视频流卡顿，4：远端视频流播放失败）=" + i);
    }

    public void onOnceLastMileQuality(RTCEngine.RTC_LASTMILE_QUALITY rtc_lastmile_quality) {
        Intrinsics.checkNotNullParameter(rtc_lastmile_quality, "lastmileQuality");
        XesLog.i(Tag.RTC_BASE, Intrinsics.stringPlus("通话前网络上下行 last mile 质量报告回调，网络上下行质量，基于上下行网络的丢包率和抖动计算，探测结果主要反映上行网络的状态=", rtc_lastmile_quality.name()));
    }

    public void reportRtcStats(RTCEngine.ReportRtcStats reportRtcStats) {
        Double valueOf = reportRtcStats == null ? null : Double.valueOf(reportRtcStats.rxPacketsLostRate);
        Intrinsics.checkNotNull(valueOf);
        HeartBeatUtil.setRtcDownlinkPacketLossRate(((float) valueOf.doubleValue()) / ((float) 100));
    }
}
