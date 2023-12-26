package com.tal.app.thinkacademy.live.business.groupvideocall.driver;

import com.tal.app.thinkacademy.lib.player.rtcplayer.SimpleRtcPlayerEngineEventListener;
import com.tal.app.thinkacademy.live.business.function.bean.EnterRoomMuteData;
import com.tal.app.thinkacademy.live.business.groupvideocall.VideoCallBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"com/tal/app/thinkacademy/live/business/groupvideocall/driver/GroupVideoCallPluginDriver$initEngine$2", "Lcom/tal/app/thinkacademy/lib/player/rtcplayer/SimpleRtcPlayerEngineEventListener;", "didAudioMuted", "", "uid", "", "muted", "", "type", "", "didOfflineOfUid", "didVideoMuted", "reportAudioVolumeOfSpeaker", "volume", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GroupVideoCallPluginDriver.kt */
public final class GroupVideoCallPluginDriver$initEngine$2 extends SimpleRtcPlayerEngineEventListener {
    final /* synthetic */ GroupVideoCallPluginDriver this$0;

    GroupVideoCallPluginDriver$initEngine$2(GroupVideoCallPluginDriver groupVideoCallPluginDriver) {
        this.this$0 = groupVideoCallPluginDriver;
    }

    public void didOfflineOfUid(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        super.didOfflineOfUid(j, str);
        if (!Intrinsics.areEqual("Engine", str)) {
            return;
        }
        if (Intrinsics.areEqual(this.this$0.mPcTeacherId, String.valueOf(j)) || Intrinsics.areEqual(this.this$0.mIpadTeacherId, String.valueOf(j))) {
            this.this$0.interactiveClosed();
        }
    }

    public void didVideoMuted(long j, boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        super.didVideoMuted(j, z, str);
        if (Intrinsics.areEqual("Engine", str)) {
            String valueOf = String.valueOf(j);
            if (this.this$0.mLocalStudent.get(valueOf) != null) {
                VideoCallBean videoCallBean = (VideoCallBean) this.this$0.mLocalStudent.get(valueOf);
                if (videoCallBean != null) {
                    videoCallBean.setCameraIsOpen(z ? 2 : 1);
                }
                VideoCallBean videoCallBean2 = (VideoCallBean) this.this$0.mLocalStudent.get(valueOf);
                if (videoCallBean2 != null) {
                    videoCallBean2.setCameraIsInit(1);
                }
            }
            this.this$0.remotefirstVideoRecvWithUid(valueOf, !z);
        }
    }

    public void didAudioMuted(long j, boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        super.didAudioMuted(j, z, str);
        if (Intrinsics.areEqual("Engine", str)) {
            String valueOf = String.valueOf(j);
            if (this.this$0.mLocalStudent.get(valueOf) != null) {
                VideoCallBean videoCallBean = (VideoCallBean) this.this$0.mLocalStudent.get(valueOf);
                if (videoCallBean != null) {
                    videoCallBean.setMicIsOpen(z ? 2 : 1);
                }
                VideoCallBean videoCallBean2 = (VideoCallBean) this.this$0.mLocalStudent.get(valueOf);
                if (videoCallBean2 != null) {
                    videoCallBean2.setMicIsInit(1);
                }
            }
            this.this$0.updateMic(valueOf, z ? -1 : 0);
        }
    }

    public void reportAudioVolumeOfSpeaker(long j, int i) {
        Integer micIsOpen;
        super.reportAudioVolumeOfSpeaker(j, i);
        boolean z = true;
        if (Intrinsics.areEqual(String.valueOf(j), EnterRoomMuteData.STATUS_UN_MUTE)) {
            GroupVideoCallPluginDriver groupVideoCallPluginDriver = this.this$0;
            String access$getMUserId$p = groupVideoCallPluginDriver.mUserId;
            if (this.this$0.isMuteAudio != 1) {
                i = -1;
            }
            groupVideoCallPluginDriver.updateMic(access$getMUserId$p, i);
            return;
        }
        GroupVideoCallPluginDriver groupVideoCallPluginDriver2 = this.this$0;
        String valueOf = String.valueOf(j);
        VideoCallBean videoCallBean = (VideoCallBean) this.this$0.mLocalStudent.get(String.valueOf(j));
        if (videoCallBean == null || (micIsOpen = videoCallBean.getMicIsOpen()) == null || micIsOpen.intValue() != 1) {
            z = false;
        }
        if (!z) {
            i = -1;
        }
        groupVideoCallPluginDriver2.updateMic(valueOf, i);
    }
}
