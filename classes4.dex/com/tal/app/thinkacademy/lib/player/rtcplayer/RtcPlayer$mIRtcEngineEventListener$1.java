package com.tal.app.thinkacademy.lib.player.rtcplayer;

import android.os.Handler;
import android.text.TextUtils;
import android.view.SurfaceView;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.eaydu.omni.RTCEngine;
import com.eaydu.omni.listener.RTCConnectionStateType;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.player.Tag;
import com.tal.app.thinkacademy.lib.player.track.RtcFailEventType;
import com.tal.app.thinkacademy.lib.player.track.RtcTrackUtil;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000I\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\u0012\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016¨\u0006 "}, d2 = {"com/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayer$mIRtcEngineEventListener$1", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcEnginEventListenerAbs;", "connectionChangedToState", "", "state", "Lcom/eaydu/omni/listener/RTCConnectionStateType;", "reason", "", "didAudioMuted", "uid", "", "muted", "", "didOccurError", "code", "Lcom/eaydu/omni/RTCEngine$RTCEngineErrorCode;", "didOfflineOfUid", "didVideoMuted", "localUserJoindWithUid", "onOnceLastMileQuality", "lastmileQuality", "Lcom/eaydu/omni/RTCEngine$RTC_LASTMILE_QUALITY;", "onRemoteVideoStateChanged", "", "remoteUserJoinWitnUid", "remotefirstAudioRecvWithUid", "remotefirstVideoRecvWithUid", "reportAudioVolumeOfSpeaker", "volume", "reportRtcStats", "stats", "Lcom/eaydu/omni/RTCEngine$ReportRtcStats;", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcPlayer.kt */
public final class RtcPlayer$mIRtcEngineEventListener$1 extends RtcEnginEventListenerAbs {
    final /* synthetic */ RtcPlayer this$0;

    RtcPlayer$mIRtcEngineEventListener$1(RtcPlayer rtcPlayer) {
        this.this$0 = rtcPlayer;
    }

    public void reportRtcStats(RTCEngine.ReportRtcStats reportRtcStats) {
        super.reportRtcStats(reportRtcStats);
        RtcPlayEventListener mPlayEventListener = this.this$0.getMPlayEventListener();
        if (mPlayEventListener != null) {
            mPlayEventListener.onRtcStats(reportRtcStats);
        }
    }

    public void remoteUserJoinWitnUid(long j) {
        super.remoteUserJoinWitnUid(j);
        RtcPlayer rtcPlayer = this.this$0;
        rtcPlayer.trackLog("RtcPlayerEngine", "remoteUserJoinWithUid 【" + j + "】加入房间");
        XesLog.i(this.this$0.TAG, "remoteUserJoinWithUid 【" + j + "】加入房间");
        if (!this.this$0.isTargeVideotUser(j) && !this.this$0.isTargeAudioUser(j) && !this.this$0.isTargeTutorUser(j)) {
            this.this$0.setRemoteStateOnLine(j, true);
            this.this$0.addRemoteUser(j);
        }
        ThreadUtils.getMainHandler().postDelayed(new RtcPlayer$mIRtcEngineEventListener$1$$ExternalSyntheticLambda9(this.this$0, j), 1000);
        if (this.this$0.getMIsExquisite()) {
            XesLog.i(this.this$0.TAG, Intrinsics.stringPlus("远端用户加入房间： uid:", Long.valueOf(j)));
            if (this.this$0.isTargeVideotUser(j)) {
                this.this$0.setVideoTeacherJoined(true);
                XesLog.i(this.this$0.TAG, Intrinsics.stringPlus("视频老师加入房间： uid:", Long.valueOf(j)));
                ThreadUtils.runOnUiThread(new RtcPlayer$mIRtcEngineEventListener$1$$ExternalSyntheticLambda2(this.this$0));
            }
            if (this.this$0.isTargeAudioUser(j)) {
                XesLog.i(this.this$0.TAG, Intrinsics.stringPlus("音频老师加入房间： uid:", Long.valueOf(j)));
                this.this$0.setAudioTeacherJoined(true);
                ThreadUtils.runOnUiThread(new RtcPlayer$mIRtcEngineEventListener$1$$ExternalSyntheticLambda5(this.this$0));
            }
            if (this.this$0.isPcTeacher(j)) {
                XesLog.s(this.this$0.TAG, Intrinsics.stringPlus("pc老师加入房间:uid:", Long.valueOf(j)));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: remoteUserJoinWitnUid$lambda-0  reason: not valid java name */
    public static final void m117remoteUserJoinWitnUid$lambda0(RtcPlayer rtcPlayer, long j) {
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        XesLog.i(rtcPlayer.TAG, "dispatchRemoteUserJoinWitnUid start");
        rtcPlayer.dispatchRemoteUserJoinWitnUid(j, "Engine");
    }

    /* access modifiers changed from: private */
    /* renamed from: remoteUserJoinWitnUid$lambda-1  reason: not valid java name */
    public static final void m118remoteUserJoinWitnUid$lambda1(RtcPlayer rtcPlayer) {
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
    /* renamed from: remoteUserJoinWitnUid$lambda-2  reason: not valid java name */
    public static final void m119remoteUserJoinWitnUid$lambda2(RtcPlayer rtcPlayer) {
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        RtcPlayEventListener mPlayEventListener = rtcPlayer.getMPlayEventListener();
        if (mPlayEventListener != null) {
            mPlayEventListener.onAudioTeacherJointRoom();
        }
    }

    public void remotefirstVideoRecvWithUid(long j) {
        super.remotefirstVideoRecvWithUid(j);
        RtcPlayer.setRemoteStateOpenCamera$default(this.this$0, j, true, false, 4, (Object) null);
        RtcPlayer rtcPlayer = this.this$0;
        rtcPlayer.trackLog("RtcPlayerEngine", "remoteUserJoinWithUid 【" + j + "】首帧firstVideo数据");
        XesLog.i(this.this$0.TAG, "remoteUserJoinWithUid 【" + j + "】首帧数据");
        ThreadUtils.getMainHandler().postDelayed(new RtcPlayer$mIRtcEngineEventListener$1$$ExternalSyntheticLambda1(this.this$0, j), 1000);
        if (this.this$0.getMIsExquisite()) {
            XesLog.i(this.this$0.TAG, Intrinsics.stringPlus("收到首帧视频： uid:", Long.valueOf(j)));
            if (this.this$0.isTargeVideotUser(j)) {
                ThreadUtils.runOnUiThread(new RtcPlayer$mIRtcEngineEventListener$1$$ExternalSyntheticLambda3(this.this$0));
            }
            if (this.this$0.isPcTeacher(j)) {
                XesLog.s(this.this$0.TAG, Intrinsics.stringPlus("pc老师，视频首帧收到:uid:", Long.valueOf(j)));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: remotefirstVideoRecvWithUid$lambda-3  reason: not valid java name */
    public static final void m121remotefirstVideoRecvWithUid$lambda3(RtcPlayer rtcPlayer, long j) {
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        rtcPlayer.dispatchRemoteFirstVideoRecvWithUid(j, "Engine");
    }

    /* access modifiers changed from: private */
    /* renamed from: remotefirstVideoRecvWithUid$lambda-4  reason: not valid java name */
    public static final void m122remotefirstVideoRecvWithUid$lambda4(RtcPlayer rtcPlayer) {
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        RtcPlayEventListener mPlayEventListener = rtcPlayer.getMPlayEventListener();
        if (mPlayEventListener != null) {
            mPlayEventListener.onRemotefirstVideoRecvWithUid();
        }
    }

    public void remotefirstAudioRecvWithUid(long j) {
        super.remotefirstAudioRecvWithUid(j);
        this.this$0.setRemoteStateOpenMic(j, true);
        this.this$0.dispatchRemoteFirstAudioRecvWithUid(j, "Engine");
        RtcPlayer rtcPlayer = this.this$0;
        rtcPlayer.trackLog("RtcPlayerEngine", "remoteUserJoinWithUid 【" + j + "】首帧firstAudio数据");
        if (this.this$0.getMIsExquisite()) {
            XesLog.i(this.this$0.TAG, Intrinsics.stringPlus("收到首帧音频： uid:", Long.valueOf(j)));
            if (this.this$0.isTargeAudioUser(j)) {
                ThreadUtils.runOnUiThread(new RtcPlayer$mIRtcEngineEventListener$1$$ExternalSyntheticLambda8(this.this$0, j));
            }
            if (this.this$0.isPcTeacher(j)) {
                XesLog.s(this.this$0.TAG, Intrinsics.stringPlus("pc老师，音频首帧收到:uid:", Long.valueOf(j)));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: remotefirstAudioRecvWithUid$lambda-5  reason: not valid java name */
    public static final void m120remotefirstAudioRecvWithUid$lambda5(RtcPlayer rtcPlayer, long j) {
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        RTCEngine mRtcEngine = rtcPlayer.getMRtcEngine();
        if (mRtcEngine != null) {
            mRtcEngine.setRemoteVolume(j, rtcPlayer.getMCurrentVolume());
        }
    }

    public void connectionChangedToState(RTCConnectionStateType rTCConnectionStateType, String str) {
        Intrinsics.checkNotNullParameter(rTCConnectionStateType, "state");
        Intrinsics.checkNotNullParameter(str, "reason");
        super.connectionChangedToState(rTCConnectionStateType, str);
        if (RTCConnectionStateType.RTCConnectionStateTypeDisconnected == rTCConnectionStateType) {
            if (TextUtils.isEmpty(str)) {
                XesLog.e(Tag.RTC_MONITOR, "网络连接中断，且SDK无法在10秒内连接服务器");
            } else {
                XesLog.e(Tag.RTC_MONITOR, Intrinsics.stringPlus("网络连接断开，引起当前网络连接状态发生改变的原因=", str));
            }
        } else if (RTCConnectionStateType.RTCConnectionStateTypeConnecting == rTCConnectionStateType) {
            XesLog.i(Tag.RTC_MONITOR, Intrinsics.stringPlus("建立网络连接中，引起当前网络连接状态发生改变的原因=", str));
        } else if (RTCConnectionStateType.RTCConnectionStateTypeConnected == rTCConnectionStateType) {
            XesLog.s(Tag.RTC_MONITOR, Intrinsics.stringPlus("网络连接成功，引起当前网络连接状态发生改变的原因=", str));
        } else if (RTCConnectionStateType.RTCConnectionStateTypeFailed == rTCConnectionStateType) {
            XesLog.e(Tag.RTC_MONITOR, Intrinsics.stringPlus("建立连接失败，引起当前网络连接状态发生改变的原因=", str));
            RtcTrackUtil.INSTANCE.trackFailEvent(RtcFailEventType.CONNECT_FAIL, Intrinsics.stringPlus("错误原因=", str));
        } else if (RTCConnectionStateType.RTCConnectionStateTypeReconnecting == rTCConnectionStateType) {
            XesLog.i(Tag.RTC_MONITOR, Intrinsics.stringPlus("重新建立网络连接中，引起当前网络连接状态发生改变的原因=", str));
            RtcTrackUtil.INSTANCE.trackReStartEvent();
        }
        this.this$0.dispatchConnectionState(rTCConnectionStateType, str, "Engine");
        if (this.this$0.getMIsExquisite()) {
            XesLog.i(this.this$0.TAG, Intrinsics.stringPlus("rtc  connectionChangedToState ：", rTCConnectionStateType));
            if (RTCConnectionStateType.RTCConnectionStateTypeConnected == rTCConnectionStateType) {
                XesLog.s(this.this$0.TAG, "rtc  连接建立： ");
                if (this.this$0.getMPlayEventListener() != null) {
                    ThreadUtils.runOnUiThread(new RtcPlayer$mIRtcEngineEventListener$1$$ExternalSyntheticLambda0(this.this$0));
                }
            } else if (RTCConnectionStateType.RTCConnectionStateTypeDisconnected == rTCConnectionStateType) {
                XesLog.e(this.this$0.TAG, "rtc  断开连接");
            } else if (RTCConnectionStateType.RTCConnectionStateTypeReconnecting == rTCConnectionStateType) {
                XesLog.e(this.this$0.TAG, "rtc  重连");
                this.this$0.setRtcIsReconnecting(true);
                ThreadUtils.runOnUiThread(new RtcPlayer$mIRtcEngineEventListener$1$$ExternalSyntheticLambda4(this.this$0));
            } else if (RTCConnectionStateType.RTCConnectionStateTypeFailed == rTCConnectionStateType) {
                XesLog.e(this.this$0.TAG, "rtc 连接失败");
                ThreadUtils.runOnUiThread(new RtcPlayer$mIRtcEngineEventListener$1$$ExternalSyntheticLambda6(this.this$0));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: connectionChangedToState$lambda-6  reason: not valid java name */
    public static final void m112connectionChangedToState$lambda6(RtcPlayer rtcPlayer) {
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
    /* renamed from: connectionChangedToState$lambda-7  reason: not valid java name */
    public static final void m113connectionChangedToState$lambda7(RtcPlayer rtcPlayer) {
        RtcPlayEventListener mPlayEventListener;
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        if (rtcPlayer.getRtcIsReconnecting() && (mPlayEventListener = rtcPlayer.getMPlayEventListener()) != null) {
            mPlayEventListener.onNeterror();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: connectionChangedToState$lambda-8  reason: not valid java name */
    public static final void m114connectionChangedToState$lambda8(RtcPlayer rtcPlayer) {
        RtcPlayEventListener mPlayEventListener;
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        if (rtcPlayer.getRtcIsReconnecting() && (mPlayEventListener = rtcPlayer.getMPlayEventListener()) != null) {
            mPlayEventListener.onConnectionFaild();
        }
    }

    public void didOfflineOfUid(long j) {
        super.didOfflineOfUid(j);
        RtcPlayer rtcPlayer = this.this$0;
        rtcPlayer.trackLog("RtcPlayerEngine", "didOfflineOfUid:【" + j + "】离开");
        XesLog.i(this.this$0.TAG, "用户:【" + j + "】离开房间---" + Thread.currentThread().getName());
        this.this$0.setRemoteStateOnLine(j, false);
        this.this$0.removeRemoteUser(j);
        Handler mainHandler = ThreadUtils.getMainHandler();
        RtcPlayer$mIRtcEngineEventListener$1$$ExternalSyntheticLambda10 rtcPlayer$mIRtcEngineEventListener$1$$ExternalSyntheticLambda10 = new RtcPlayer$mIRtcEngineEventListener$1$$ExternalSyntheticLambda10(this.this$0, j);
        if (!(mainHandler instanceof Handler)) {
            mainHandler.post(rtcPlayer$mIRtcEngineEventListener$1$$ExternalSyntheticLambda10);
        } else {
            AsynchronousInstrumentation.handlerPost(mainHandler, rtcPlayer$mIRtcEngineEventListener$1$$ExternalSyntheticLambda10);
        }
        if (this.this$0.getMIsExquisite()) {
            if (this.this$0.isPcTeacher(j)) {
                XesLog.s(this.this$0.TAG, Intrinsics.stringPlus("pc老师，离开房间:uid:", Long.valueOf(j)));
            }
            ThreadUtils.runOnUiThread(new RtcPlayer$mIRtcEngineEventListener$1$$ExternalSyntheticLambda7(this.this$0, j));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: didOfflineOfUid$lambda-9  reason: not valid java name */
    public static final void m116didOfflineOfUid$lambda9(RtcPlayer rtcPlayer, long j) {
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        rtcPlayer.dispatchOfflineOfUid(j, "Engine");
    }

    /* access modifiers changed from: private */
    /* renamed from: didOfflineOfUid$lambda-10  reason: not valid java name */
    public static final void m115didOfflineOfUid$lambda10(RtcPlayer rtcPlayer, long j) {
        RtcPlayEventListener mPlayEventListener;
        RtcPlayEventListener mPlayEventListener2;
        Intrinsics.checkNotNullParameter(rtcPlayer, "this$0");
        if (rtcPlayer.isTargeAudioUser(j)) {
            XesLog.i(rtcPlayer.TAG, Intrinsics.stringPlus("音频老师离开房间 uid： ", Long.valueOf(j)));
            rtcPlayer.setAudioTeacherJoined(false);
            if (!(rtcPlayer.getMPlayEventListener() == null || (mPlayEventListener2 = rtcPlayer.getMPlayEventListener()) == null)) {
                mPlayEventListener2.onPadTeacherleaveRoom();
            }
        }
        if (rtcPlayer.isTargeVideotUser(j)) {
            XesLog.i(rtcPlayer.TAG, Intrinsics.stringPlus("视频老师离开房间 uid： ", Long.valueOf(j)));
            if (!(rtcPlayer.getMPlayEventListener() == null || (mPlayEventListener = rtcPlayer.getMPlayEventListener()) == null)) {
                mPlayEventListener.onVideoTeacherLeaveRoom();
            }
            rtcPlayer.setVideoTeacherJoined(false);
        }
    }

    public void onOnceLastMileQuality(RTCEngine.RTC_LASTMILE_QUALITY rtc_lastmile_quality) {
        Intrinsics.checkNotNullParameter(rtc_lastmile_quality, "lastmileQuality");
        super.onOnceLastMileQuality(rtc_lastmile_quality);
        this.this$0.setMNetworkQuality(rtc_lastmile_quality.ordinal());
        RtcPlayer rtcPlayer = this.this$0;
        rtcPlayer.trackLog("RtcPlayerEngine", Intrinsics.stringPlus("onOnceLastMileQuality:", Integer.valueOf(rtcPlayer.getMNetworkQuality())));
        this.this$0.onRtcEngineOnceLastMileQuality(rtc_lastmile_quality.ordinal(), "Engine");
    }

    public void didAudioMuted(long j, boolean z) {
        super.didAudioMuted(j, z);
        XesLog.i(this.this$0.TAG, "didAudioMuted:【" + j + "】muted:" + z);
        RtcPlayer rtcPlayer = this.this$0;
        rtcPlayer.trackLog("RtcPlayerEngine", "didAudioMuted:【" + j + "】muted:" + z);
        this.this$0.setRemoteStateOpenMic(j, z ^ true);
        this.this$0.dispatchDidAudioMuted(j, z, "Engine");
    }

    public void didVideoMuted(long j, boolean z) {
        super.didVideoMuted(j, z);
        this.this$0.setRemoteStateOpenCamera(j, !z, true);
        XesLog.i(this.this$0.TAG, "didVideoMuted:【" + j + "】muted:" + z);
        RtcPlayer rtcPlayer = this.this$0;
        rtcPlayer.trackLog("RtcPlayerEngine", "didVideoMuted:【" + j + "】muted:" + z);
        this.this$0.dispatchDidVideoMuted(j, z, "Engine");
    }

    public void onRemoteVideoStateChanged(long j, int i) {
        super.onRemoteVideoStateChanged(j, i);
        if (i == 2) {
            RtcPlayer.setRemoteStateOpenCamera$default(this.this$0, j, true, false, 4, (Object) null);
        } else {
            RtcPlayer.setRemoteStateOpenCamera$default(this.this$0, j, false, false, 4, (Object) null);
        }
        RtcPlayer rtcPlayer = this.this$0;
        rtcPlayer.trackLog("RtcPlayerEngine", "onRemoteVideoStateChanged:【" + j + "】state:" + i);
        XesLog.i(this.this$0.TAG, "onRemoteVideoStateChanged:【" + j + "】state:" + i);
        this.this$0.dispatchRemoteVideoStateChanged(j, i, "Engine");
    }

    public void localUserJoindWithUid(long j) {
        super.localUserJoindWithUid(j);
        XesLog.s(Tag.RTC_MONITOR, Intrinsics.stringPlus("加入房间成功，uid=", Long.valueOf(j)));
        RtcTrackUtil.INSTANCE.trackSuccessEvent();
        this.this$0.dispatchlocalUserJoindWithUid(j, "Engine");
    }

    public void reportAudioVolumeOfSpeaker(long j, int i) {
        super.reportAudioVolumeOfSpeaker(j, i);
        this.this$0.dispatchReportAudioVolumeOfSpeaker(j, i);
    }

    public void didOccurError(RTCEngine.RTCEngineErrorCode rTCEngineErrorCode) {
        Intrinsics.checkNotNullParameter(rTCEngineErrorCode, "code");
        super.didOccurError(rTCEngineErrorCode);
        XesLog.e(this.this$0.TAG, Intrinsics.stringPlus("加入房间失败 code = ", Integer.valueOf(rTCEngineErrorCode.getValue())));
    }
}
