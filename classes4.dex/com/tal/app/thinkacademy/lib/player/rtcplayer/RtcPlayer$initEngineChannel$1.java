package com.tal.app.thinkacademy.lib.player.rtcplayer;

import android.view.SurfaceView;
import com.eaydu.omni.RTCChannel;
import com.eaydu.omni.RTCEngine;
import com.eaydu.omni.listener.RTCConnectionStateType;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.util.JsonUtil;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u0013\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J*\u0010\u0014\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\"\u0010\u0018\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0016H\u0016J\u001a\u0010\u0019\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\u001a\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\u001b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\u001c\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016¨\u0006\u001f"}, d2 = {"com/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayer$initEngineChannel$1", "Lcom/eaydu/omni/RTCChannel$IRTCChannelEventListener;", "connectionChangedToState", "", "channelId", "", "state", "Lcom/eaydu/omni/listener/RTCConnectionStateType;", "reason", "didAudioMuted", "uid", "", "muted", "", "didOccurError", "code", "Lcom/eaydu/omni/RTCEngine$RTCEngineErrorCode;", "didOfflineOfUid", "didVideoMuted", "localUserJoinedWithUid", "onNetworkQuality", "txQuality", "", "rxQuality", "onRemoteVideoStateChanged", "remoteUserJoinWithUid", "remotefirstAudioRecvWithUid", "remotefirstVideoRecvWithUid", "reportRtcStats", "stats", "Lcom/eaydu/omni/RTCEngine$ReportRtcStats;", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcPlayer.kt */
public final class RtcPlayer$initEngineChannel$1 extends RTCChannel.IRTCChannelEventListener {
    final /* synthetic */ RtcPlayer this$0;

    RtcPlayer$initEngineChannel$1(RtcPlayer rtcPlayer) {
        this.this$0 = rtcPlayer;
    }

    public void didOfflineOfUid(String str, long j) {
        RtcPlayer$initEngineChannel$1.super.didOfflineOfUid(str, j);
        RtcPlayer rtcPlayer = this.this$0;
        rtcPlayer.trackLog("RtcPlayerChannel", "didOfflineOfUid:【" + j + "】离开,channelId:【" + str + 12305);
        XesLog.i(this.this$0.TAG, "channel频道,didOfflineOfUid:【" + j + "】离开,channelId:【" + str + 12305);
        XesLog.i(this.this$0.TAG, Intrinsics.stringPlus("老师离开房间 uid： ", Long.valueOf(j)));
        this.this$0.dispatchOfflineOfUid(j, "Channel");
        ThreadUtils.runOnUiThread(new RtcPlayer$initEngineChannel$1$$ExternalSyntheticLambda7(this.this$0, j));
    }

    /* access modifiers changed from: private */
    /* renamed from: didOfflineOfUid$lambda-0  reason: not valid java name */
    public static final void m105didOfflineOfUid$lambda0(RtcPlayer rtcPlayer, long j) {
        RtcPlayEventListener mPlayEventListener;
        RtcPlayEventListener mPlayEventListener2;
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        if (rtcPlayer.isTargeAudioUser(j)) {
            XesLog.i(rtcPlayer.TAG, Intrinsics.stringPlus("channel频道,音频老师离开房间 uid： ", Long.valueOf(j)));
            rtcPlayer.setAudioTeacherJoined(false);
            if (!(rtcPlayer.getMPlayEventListener() == null || (mPlayEventListener2 = rtcPlayer.getMPlayEventListener()) == null)) {
                mPlayEventListener2.onPadTeacherleaveRoom();
            }
        }
        if (rtcPlayer.isTargeVideotUser(j)) {
            XesLog.i(rtcPlayer.TAG, Intrinsics.stringPlus("channel频道,视频老师离开房间 uid： ", Long.valueOf(j)));
            if (!(rtcPlayer.getMPlayEventListener() == null || (mPlayEventListener = rtcPlayer.getMPlayEventListener()) == null)) {
                mPlayEventListener.onVideoTeacherLeaveRoom();
            }
            rtcPlayer.setVideoTeacherJoined(false);
        }
    }

    public void onRemoteVideoStateChanged(String str, long j, int i) {
        RtcPlayer$initEngineChannel$1.super.onRemoteVideoStateChanged(str, j, i);
        RtcPlayer rtcPlayer = this.this$0;
        rtcPlayer.trackLog("RtcPlayerChannel", "onRemoteVideoStateChanged uid:【" + j + "】state:" + i + " channelId:【" + str + 12305);
        this.this$0.dispatchRemoteVideoStateChanged(j, i, "Channel");
    }

    public void didOccurError(String str, RTCEngine.RTCEngineErrorCode rTCEngineErrorCode) {
        RtcPlayer$initEngineChannel$1.super.didOccurError(str, rTCEngineErrorCode);
        RtcPlayer rtcPlayer = this.this$0;
        rtcPlayer.trackLog("RtcPlayerChannel", "didOccurError code:【" + rTCEngineErrorCode + "】 channelId:【" + str + 12305);
        RtcPlayPrePlayEventListener mPrePlayEventListener = this.this$0.getMPrePlayEventListener();
        if (mPrePlayEventListener != null) {
            mPrePlayEventListener.onInitChannelError();
        }
    }

    public void remoteUserJoinWithUid(String str, long j) {
        RtcPlayer$initEngineChannel$1.super.remoteUserJoinWithUid(str, j);
        RtcPlayer rtcPlayer = this.this$0;
        rtcPlayer.trackLog("RtcPlayerChannel", "remoteUserJoinWithUid 【" + j + "】加入房间 channelId【" + str + "】 ");
        XesLog.i(this.this$0.TAG, Intrinsics.stringPlus("channel频道,远端用户加入房间： uid:", Long.valueOf(j)));
        this.this$0.dispatchRemoteUserJoinWitnUid(j, "Channel");
        if (this.this$0.isTargeVideotUser(j)) {
            this.this$0.setVideoTeacherJoined(true);
            XesLog.i(this.this$0.TAG, Intrinsics.stringPlus("channel频道,视频老师加入房间： uid:", Long.valueOf(j)));
            ThreadUtils.runOnUiThread(new RtcPlayer$initEngineChannel$1$$ExternalSyntheticLambda4(this.this$0));
        }
        if (this.this$0.isTargeAudioUser(j)) {
            XesLog.i(this.this$0.TAG, Intrinsics.stringPlus("channel频道,音频老师加入房间： uid:", Long.valueOf(j)));
            this.this$0.setAudioTeacherJoined(true);
            ThreadUtils.runOnUiThread(new RtcPlayer$initEngineChannel$1$$ExternalSyntheticLambda3(this.this$0));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: remoteUserJoinWithUid$lambda-1  reason: not valid java name */
    public static final void m106remoteUserJoinWithUid$lambda1(RtcPlayer rtcPlayer) {
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        RTCEngine mRtcEngine = rtcPlayer.getMRtcEngine();
        rtcPlayer.setMRendererView(mRtcEngine == null ? null : mRtcEngine.createRendererView());
        if (rtcPlayer.getMRendererView() != null) {
            SurfaceView mRendererView = rtcPlayer.getMRendererView();
            if (mRendererView != null) {
                mRendererView.setZOrderOnTop(false);
            }
            RtcPlayPrePlayEventListener mPrePlayEventListener = rtcPlayer.getMPrePlayEventListener();
            if (mPrePlayEventListener != null) {
                mPrePlayEventListener.onRenderViewCreated(rtcPlayer.getMRendererView());
                return;
            }
            return;
        }
        RtcPlayEventListener mPlayEventListener = rtcPlayer.getMPlayEventListener();
        if (mPlayEventListener != null) {
            mPlayEventListener.onPlayFaild();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: remoteUserJoinWithUid$lambda-2  reason: not valid java name */
    public static final void m107remoteUserJoinWithUid$lambda2(RtcPlayer rtcPlayer) {
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        RtcPlayEventListener mPlayEventListener = rtcPlayer.getMPlayEventListener();
        if (mPlayEventListener != null) {
            mPlayEventListener.onAudioTeacherJointRoom();
        }
    }

    public void onNetworkQuality(String str, long j, int i, int i2) {
        RtcPlayer$initEngineChannel$1.super.onNetworkQuality(str, j, i, i2);
    }

    public void connectionChangedToState(String str, RTCConnectionStateType rTCConnectionStateType, String str2) {
        Intrinsics.checkNotNullParameter(rTCConnectionStateType, "state");
        RtcPlayer$initEngineChannel$1.super.connectionChangedToState(str, rTCConnectionStateType, str2);
        XesLog.i(this.this$0.TAG, Intrinsics.stringPlus("channel频道,rtc  connectionChangedToState ：", rTCConnectionStateType));
        RtcPlayer rtcPlayer = this.this$0;
        rtcPlayer.trackLog("RtcPlayerChannel", "connectionChangedToState:state" + JsonUtil.toJson(rTCConnectionStateType) + "reason:" + str2 + "channelId:【" + str + 12305);
        if (RTCConnectionStateType.RTCConnectionStateTypeConnected == rTCConnectionStateType) {
            XesLog.i(this.this$0.TAG, "channel频道,connectionChangedToState,rtc  连接建立： ");
            if (this.this$0.getMPlayEventListener() != null) {
                ThreadUtils.runOnUiThread(new RtcPlayer$initEngineChannel$1$$ExternalSyntheticLambda5(this.this$0));
            }
        } else if (RTCConnectionStateType.RTCConnectionStateTypeDisconnected == rTCConnectionStateType) {
            XesLog.i(this.this$0.TAG, "channel频道,connectionChangedToState,rtc  断开连接");
        } else if (RTCConnectionStateType.RTCConnectionStateTypeReconnecting == rTCConnectionStateType) {
            XesLog.i(this.this$0.TAG, "channel频道,connectionChangedToState,rtc  重连");
            this.this$0.setRtcIsReconnecting(true);
            ThreadUtils.runOnUiThread(new RtcPlayer$initEngineChannel$1$$ExternalSyntheticLambda2(this.this$0));
        } else if (RTCConnectionStateType.RTCConnectionStateTypeFailed == rTCConnectionStateType) {
            ThreadUtils.runOnUiThread(new RtcPlayer$initEngineChannel$1$$ExternalSyntheticLambda0(this.this$0));
        }
        RtcPlayer rtcPlayer2 = this.this$0;
        if (str2 == null) {
            str2 = "";
        }
        rtcPlayer2.dispatchConnectionState(rTCConnectionStateType, str2, "Channel");
    }

    /* access modifiers changed from: private */
    /* renamed from: connectionChangedToState$lambda-3  reason: not valid java name */
    public static final void m102connectionChangedToState$lambda3(RtcPlayer rtcPlayer) {
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        if (rtcPlayer.getRtcIsReconnecting()) {
            RtcPlayEventListener mPlayEventListener = rtcPlayer.getMPlayEventListener();
            if (mPlayEventListener != null) {
                mPlayEventListener.onRtcConnected();
            }
            rtcPlayer.setRtcIsReconnecting(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: connectionChangedToState$lambda-4  reason: not valid java name */
    public static final void m103connectionChangedToState$lambda4(RtcPlayer rtcPlayer) {
        RtcPlayEventListener mPlayEventListener;
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        if (rtcPlayer.getRtcIsReconnecting() && (mPlayEventListener = rtcPlayer.getMPlayEventListener()) != null) {
            mPlayEventListener.onNeterror();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: connectionChangedToState$lambda-5  reason: not valid java name */
    public static final void m104connectionChangedToState$lambda5(RtcPlayer rtcPlayer) {
        RtcPlayEventListener mPlayEventListener;
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        if (rtcPlayer.getRtcIsReconnecting() && (mPlayEventListener = rtcPlayer.getMPlayEventListener()) != null) {
            mPlayEventListener.onConnectionFaild();
        }
    }

    public void didAudioMuted(String str, long j, boolean z) {
        RtcPlayer$initEngineChannel$1.super.didAudioMuted(str, j, z);
        this.this$0.dispatchDidAudioMuted(j, z, "Channel");
        RtcPlayer rtcPlayer = this.this$0;
        rtcPlayer.trackLog("RtcPlayerChannel", "didAudioMuted muted:+ 【" + z + "】 uid:【" + j + "】 channelId:【" + str + 12305);
    }

    public void reportRtcStats(String str, RTCEngine.ReportRtcStats reportRtcStats) {
        RtcPlayer$initEngineChannel$1.super.reportRtcStats(str, reportRtcStats);
    }

    public void remotefirstAudioRecvWithUid(String str, long j) {
        RtcPlayer$initEngineChannel$1.super.remotefirstAudioRecvWithUid(str, j);
        RtcPlayer rtcPlayer = this.this$0;
        rtcPlayer.trackLog("RtcPlayerChannel", "remotefirstAudioRecvWithUid 【" + j + "】首帧数据,channelId:【" + str + 12305);
        XesLog.i(this.this$0.TAG, Intrinsics.stringPlus("channel频道,connectionChangedToState,收到首帧音频： uid:", Long.valueOf(j)));
        if (this.this$0.isTargeAudioUser(j)) {
            ThreadUtils.runOnUiThread(new RtcPlayer$initEngineChannel$1$$ExternalSyntheticLambda6(this.this$0, j));
        }
        this.this$0.dispatchRemoteFirstAudioRecvWithUid(j, "Channel");
    }

    /* access modifiers changed from: private */
    /* renamed from: remotefirstAudioRecvWithUid$lambda-6  reason: not valid java name */
    public static final void m108remotefirstAudioRecvWithUid$lambda6(RtcPlayer rtcPlayer, long j) {
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        RTCEngine mRtcEngine = rtcPlayer.getMRtcEngine();
        if (mRtcEngine != null) {
            mRtcEngine.setRemoteVolume(j, rtcPlayer.getMCurrentVolume());
        }
    }

    public void localUserJoinedWithUid(String str, long j) {
        RtcPlayer$initEngineChannel$1.super.localUserJoinedWithUid(str, j);
        RtcPlayer rtcPlayer = this.this$0;
        rtcPlayer.trackLog("RtcPlayerChannel", "localUserJoindWithUid:【" + j + "】加入房间,channelId:【" + str + 12305);
        this.this$0.dispatchlocalUserJoindWithUid(j, "Channel");
    }

    public void didVideoMuted(String str, long j, boolean z) {
        RtcPlayer$initEngineChannel$1.super.didVideoMuted(str, j, z);
        RtcPlayer rtcPlayer = this.this$0;
        rtcPlayer.trackLog("RtcPlayerChannel", "didVideoMuted:uid:【" + j + "】,channelId:【" + str + "】,muted:【" + z + 12305);
        this.this$0.dispatchDidVideoMuted(j, z, "Channel");
    }

    public void remotefirstVideoRecvWithUid(String str, long j) {
        RtcPlayer$initEngineChannel$1.super.remotefirstVideoRecvWithUid(str, j);
        RtcPlayer rtcPlayer = this.this$0;
        rtcPlayer.trackLog("RtcPlayerChannel", "remotefirstVideoRecvWithUid 【" + j + "】首帧数据,channelId:【" + str + 12305);
        XesLog.i(this.this$0.TAG, Intrinsics.stringPlus("channel频道,connectionChangedToState,收到首帧视频： uid:", Long.valueOf(j)));
        if (this.this$0.isTargeVideotUser(j)) {
            ThreadUtils.runOnUiThread(new RtcPlayer$initEngineChannel$1$$ExternalSyntheticLambda1(this.this$0));
        }
        this.this$0.dispatchRemoteFirstVideoRecvWithUid(j, "Channel");
    }

    /* access modifiers changed from: private */
    /* renamed from: remotefirstVideoRecvWithUid$lambda-7  reason: not valid java name */
    public static final void m109remotefirstVideoRecvWithUid$lambda7(RtcPlayer rtcPlayer) {
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        RtcPlayEventListener mPlayEventListener = rtcPlayer.getMPlayEventListener();
        if (mPlayEventListener != null) {
            mPlayEventListener.onRemotefirstVideoRecvWithUid();
        }
    }
}
