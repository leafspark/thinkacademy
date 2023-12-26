package com.tal.app.thinkacademy.live.abilitypack.rtc;

import android.os.Handler;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.eaydu.omni.listener.RTCConnectionStateType;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayer;
import com.tal.app.thinkacademy.lib.player.rtcplayer.RtcPlayerEngineEventListener;
import com.tal.app.thinkacademy.lib.player.rtcplayer.entity.RtcUserState;
import com.tal.app.thinkacademy.lib.util.ThreadUtils;
import com.tal.app.thinkacademy.live.abilitypack.rtc.listenbody.RtcPlayerListenerBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0013H\u0016¨\u0006\u001a"}, d2 = {"com/tal/app/thinkacademy/live/abilitypack/rtc/RtcViewModel$mPlayerEventListener$1", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/RtcPlayerEngineEventListener;", "didAudioMuted", "", "uid", "", "muted", "", "type", "", "didOfflineOfUid", "didVideoMuted", "dispatchConnectionState", "state", "Lcom/eaydu/omni/listener/RTCConnectionStateType;", "reason", "localUserJoindWithUid", "onOnceLastMileQuality", "quality", "", "onRemoteVideoStateChanged", "remoteUserJoinWitnUid", "remotefirstAudioRecvWithUid", "remotefirstVideoRecvWithUid", "reportAudioVolumeOfSpeaker", "volume", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcViewModel.kt */
public final class RtcViewModel$mPlayerEventListener$1 implements RtcPlayerEngineEventListener {
    final /* synthetic */ RtcViewModel this$0;

    public void dispatchConnectionState(RTCConnectionStateType rTCConnectionStateType, String str, String str2) {
        Intrinsics.checkNotNullParameter(rTCConnectionStateType, "state");
        Intrinsics.checkNotNullParameter(str, "reason");
        Intrinsics.checkNotNullParameter(str2, "type");
    }

    public void localUserJoindWithUid(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
    }

    public void onOnceLastMileQuality(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
    }

    RtcViewModel$mPlayerEventListener$1(RtcViewModel rtcViewModel) {
        this.this$0 = rtcViewModel;
    }

    public void remoteUserJoinWitnUid(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        Handler mainHandler = ThreadUtils.getMainHandler();
        RtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda2 rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda2 = new RtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda2(this.this$0, j);
        if (!(mainHandler instanceof Handler)) {
            mainHandler.post(rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda2);
        } else {
            AsynchronousInstrumentation.handlerPost(mainHandler, rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda2);
        }
        this.this$0.checkAndRequestData(j);
    }

    /* access modifiers changed from: private */
    /* renamed from: remoteUserJoinWitnUid$lambda-1  reason: not valid java name */
    public static final void m150remoteUserJoinWitnUid$lambda1(RtcViewModel rtcViewModel, long j) {
        RtcUserState remoteState;
        Intrinsics.checkNotNullParameter(rtcViewModel, "this$0");
        RtcPlayer access$getPlayer = rtcViewModel.getPlayer();
        if (access$getPlayer != null && (remoteState = access$getPlayer.getRemoteState(j)) != null) {
            rtcViewModel.getMRtcPlayerListener().setStickyData(new RtcPlayerListenerBody.IsOnline(j, remoteState));
        }
    }

    public void remotefirstVideoRecvWithUid(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        Handler mainHandler = ThreadUtils.getMainHandler();
        RtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda6 rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda6 = new RtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda6(this.this$0, j);
        if (!(mainHandler instanceof Handler)) {
            mainHandler.post(rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda6);
        } else {
            AsynchronousInstrumentation.handlerPost(mainHandler, rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda6);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: remotefirstVideoRecvWithUid$lambda-3  reason: not valid java name */
    public static final void m152remotefirstVideoRecvWithUid$lambda3(RtcViewModel rtcViewModel, long j) {
        RtcUserState remoteState;
        Intrinsics.checkNotNullParameter(rtcViewModel, "this$0");
        RtcPlayer access$getPlayer = rtcViewModel.getPlayer();
        if (access$getPlayer != null && (remoteState = access$getPlayer.getRemoteState(j)) != null) {
            rtcViewModel.getMRtcPlayerListener().setStickyData(new RtcPlayerListenerBody.OnRtcStateChanged(j, remoteState));
        }
    }

    public void remotefirstAudioRecvWithUid(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        Handler mainHandler = ThreadUtils.getMainHandler();
        RtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda0 rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda0 = new RtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda0(this.this$0, j);
        if (!(mainHandler instanceof Handler)) {
            mainHandler.post(rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda0);
        } else {
            AsynchronousInstrumentation.handlerPost(mainHandler, rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: remotefirstAudioRecvWithUid$lambda-5  reason: not valid java name */
    public static final void m151remotefirstAudioRecvWithUid$lambda5(RtcViewModel rtcViewModel, long j) {
        RtcUserState remoteState;
        Intrinsics.checkNotNullParameter(rtcViewModel, "this$0");
        RtcPlayer access$getPlayer = rtcViewModel.getPlayer();
        if (access$getPlayer != null && (remoteState = access$getPlayer.getRemoteState(j)) != null) {
            rtcViewModel.getMRtcPlayerListener().setStickyData(new RtcPlayerListenerBody.OnRtcStateChanged(j, remoteState));
        }
    }

    public void didOfflineOfUid(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        Handler mainHandler = ThreadUtils.getMainHandler();
        RtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda1 rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda1 = new RtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda1(this.this$0, j);
        if (!(mainHandler instanceof Handler)) {
            mainHandler.post(rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda1);
        } else {
            AsynchronousInstrumentation.handlerPost(mainHandler, rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: didOfflineOfUid$lambda-7  reason: not valid java name */
    public static final void m147didOfflineOfUid$lambda7(RtcViewModel rtcViewModel, long j) {
        RtcUserState remoteState;
        Intrinsics.checkNotNullParameter(rtcViewModel, "this$0");
        RtcPlayer access$getPlayer = rtcViewModel.getPlayer();
        if (access$getPlayer != null && (remoteState = access$getPlayer.getRemoteState(j)) != null) {
            rtcViewModel.getMRtcPlayerListener().setStickyData(new RtcPlayerListenerBody.IsOnline(j, remoteState));
        }
    }

    public void didAudioMuted(long j, boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        Handler mainHandler = ThreadUtils.getMainHandler();
        RtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda4 rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda4 = new RtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda4(this.this$0, j);
        if (!(mainHandler instanceof Handler)) {
            mainHandler.post(rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda4);
        } else {
            AsynchronousInstrumentation.handlerPost(mainHandler, rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda4);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: didAudioMuted$lambda-9  reason: not valid java name */
    public static final void m146didAudioMuted$lambda9(RtcViewModel rtcViewModel, long j) {
        RtcUserState remoteState;
        Intrinsics.checkNotNullParameter(rtcViewModel, "this$0");
        RtcPlayer access$getPlayer = rtcViewModel.getPlayer();
        if (access$getPlayer != null && (remoteState = access$getPlayer.getRemoteState(j)) != null) {
            rtcViewModel.getMRtcPlayerListener().setStickyData(new RtcPlayerListenerBody.OnRtcStateChanged(j, remoteState));
        }
    }

    public void didVideoMuted(long j, boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        Handler mainHandler = ThreadUtils.getMainHandler();
        RtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda3 rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda3 = new RtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda3(this.this$0, j);
        if (!(mainHandler instanceof Handler)) {
            mainHandler.post(rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda3);
        } else {
            AsynchronousInstrumentation.handlerPost(mainHandler, rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: didVideoMuted$lambda-11  reason: not valid java name */
    public static final void m148didVideoMuted$lambda11(RtcViewModel rtcViewModel, long j) {
        RtcUserState remoteState;
        Intrinsics.checkNotNullParameter(rtcViewModel, "this$0");
        RtcPlayer access$getPlayer = rtcViewModel.getPlayer();
        if (access$getPlayer != null && (remoteState = access$getPlayer.getRemoteState(j)) != null) {
            rtcViewModel.getMRtcPlayerListener().setStickyData(new RtcPlayerListenerBody.OnRtcStateChanged(j, remoteState));
        }
    }

    public void onRemoteVideoStateChanged(long j, int i, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        Handler mainHandler = ThreadUtils.getMainHandler();
        RtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda5 rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda5 = new RtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda5(this.this$0, j);
        if (!(mainHandler instanceof Handler)) {
            mainHandler.post(rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda5);
        } else {
            AsynchronousInstrumentation.handlerPost(mainHandler, rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda5);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onRemoteVideoStateChanged$lambda-13  reason: not valid java name */
    public static final void m149onRemoteVideoStateChanged$lambda13(RtcViewModel rtcViewModel, long j) {
        RtcUserState remoteState;
        Intrinsics.checkNotNullParameter(rtcViewModel, "this$0");
        RtcPlayer access$getPlayer = rtcViewModel.getPlayer();
        if (access$getPlayer != null && (remoteState = access$getPlayer.getRemoteState(j)) != null) {
            rtcViewModel.getMRtcPlayerListener().setStickyData(new RtcPlayerListenerBody.OnRtcStateChanged(j, remoteState));
        }
    }

    public void reportAudioVolumeOfSpeaker(long j, int i) {
        Handler mainHandler = ThreadUtils.getMainHandler();
        RtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda7 rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda7 = new RtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda7(this.this$0, j, i);
        if (!(mainHandler instanceof Handler)) {
            mainHandler.post(rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda7);
        } else {
            AsynchronousInstrumentation.handlerPost(mainHandler, rtcViewModel$mPlayerEventListener$1$$ExternalSyntheticLambda7);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: reportAudioVolumeOfSpeaker$lambda-14  reason: not valid java name */
    public static final void m153reportAudioVolumeOfSpeaker$lambda14(RtcViewModel rtcViewModel, long j, int i) {
        Intrinsics.checkNotNullParameter(rtcViewModel, "this$0");
        rtcViewModel.getMRtcPlayerListener().setStickyData(new RtcPlayerListenerBody.VolumeChange(j, i));
    }
}
