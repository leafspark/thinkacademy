package com.wushuangtech.api;

import com.wushuangtech.bean.VideoRemoteStreamType;
import com.wushuangtech.expansion.bean.ChannelMediaRelayConfiguration;
import com.wushuangtech.inter.OnRtcGlobalServerMessageCallBack;
import com.wushuangtech.jni.NetTestJni;
import com.wushuangtech.jni.ReportLogJni;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.jni.VideoJni;

public abstract class EnterConfApi implements ReportLogJni.ReportLogJniCallback, VideoJni.VideoJniCallback, NetTestJni.NetTestJniCallback, RoomJni.RoomJniCallback, OnRtcGlobalServerMessageCallBack {
    public static final int LEVEL_LOG_DEBUG = 5;
    public static final int LEVEL_LOG_ERROR = 2;
    public static final int LEVEL_LOG_FATAL = 1;
    public static final int LEVEL_LOG_INFO = 4;
    public static final int LEVEL_LOG_OFF = 0;
    public static final int LEVEL_LOG_WARNING = 3;
    public static final int USER_ROLE_AUDIENCE = 3;
    public static final int USER_ROLE_HOST = 1;
    public static final int USER_ROLE_PARTICIPANT = 2;
    private static EnterConfApi mEnterConfApiImpl;

    public static class AudioLevel {
        public int audioLevel;
        public int audioLevelFullRange;
    }

    public enum RoomMode {
        ROOM_MODE_LIVE,
        ROOM_MODE_COMMUNICATION,
        ROOM_MODE_CONFERENCE,
        ROOM_MODE_MANUAL
    }

    public void OnAudioLevelReport(String str, long j, int i, int i2) {
    }

    public void OnAudioRemoteFirstFrame(String str, long j) {
    }

    public void OnAudioUpstreamStatus(String str, long j, int i) {
    }

    public void OnConfRefreshToken(String str, String str2, int i, int i2, int i3) {
    }

    public void OnConnect(String str, String str2, int i) {
    }

    public void OnConnectFailed(String str, String str2, int i) {
    }

    public void OnConnectIdReport(String str) {
    }

    public void OnConnectServerResult(String str, int i, String str2) {
    }

    public void OnEnterTimeout(String str, String str2, long j, int i, int i2, long j2, long j3, long j4, long j5, long j6, String str3) {
    }

    public void OnGlobalSessionId(String str, String str2) {
    }

    public void OnMediaRelayEvent(String str, String str2, int i) {
    }

    public void OnMediaRelayModeUpdate(int i) {
    }

    public void OnMediaRelayStateChanged(String str, String str2, int i, int i2) {
    }

    public void OnMixAudioLevelReport(String str, long j, int i, int i2) {
    }

    public void OnNetTestCallback(int i) {
    }

    public void OnNetTestQuality(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
    }

    public void OnReconnectTimeout() {
    }

    public void OnRecvAudioMsg(String str, long j, int i, byte[] bArr) {
    }

    public void OnRecvCmdMsg(String str, long j, String str2) {
    }

    public void OnRecvVideoMsg(String str, String str2) {
    }

    public void OnRejoin(String str, int i) {
    }

    public void OnRemoteAudioMuted(String str, long j, boolean z) {
    }

    public void OnRemoteStreamSubscribeAdvice(String str, long j, int i, int i2) {
    }

    public void OnReportImageFireEvent() {
    }

    public void OnRoomChairChanged(String str, long j) {
    }

    public void OnRoomConnectSuccess() {
    }

    public void OnRoomEnter(String str, int i, int i2, long j, int i3, int i4, long j2, long j3, long j4, long j5, long j6, long j7, String str2) {
    }

    public void OnRtpRtcp(boolean z, boolean z2) {
    }

    public void OnStartSendAudio() {
    }

    public void OnStopSendAudio() {
    }

    public void OnUpdateDevParam(String str) {
    }

    public void OnUserRoleChanged(String str, long j, int i) {
    }

    public void OnVideoBufferingStateChanged(String str, long j, boolean z, int i, long j2) {
    }

    public void OnVideoSubscribeStateChanged(String str, long j, int i, int i2, int i3) {
    }

    public abstract int addPublishStreamUrl(String str);

    public abstract int adjustPlaybackSignalVolume(String str, int i);

    public abstract int adjustUserPlaybackSignalVolume(long j, int i);

    public abstract void cacheVideoRemoteStreamType(VideoRemoteStreamType videoRemoteStreamType);

    public abstract boolean changeUserRole(int i);

    public abstract int controlDeviceVideoByType(boolean z, long j, int i);

    public abstract void controlLastmileTest(boolean z);

    public abstract boolean controlUserVideoDevice(String str, long j, String str2, boolean z);

    public abstract int createDataStream(boolean z, boolean z2);

    public abstract void enableDualVideoStream(boolean z);

    public abstract void enableLocalVideo(boolean z);

    public abstract int enterRoom(String str, long j, String str2, int i, String str3);

    public abstract void exitRoom(String str);

    public abstract int getConnectionState();

    public abstract String getEngineSessionId();

    public abstract void handleAppBackgroundStatus(boolean z);

    public abstract int kickUser(String str, long j);

    public abstract void mixGuestAudio(long j, boolean z, String str);

    public abstract boolean mixGuestVideo(long j, String str, boolean z, String str2);

    public abstract void muteAllRemoteAudio(boolean z);

    public abstract void muteAllRemoteAudioForChannel(boolean z);

    public abstract void muteAllRemoteVideo(boolean z);

    public abstract void muteAllRemoteVideoForChannel(boolean z);

    public abstract int muteLocalAudio(boolean z);

    public abstract int muteLocalVideo(boolean z);

    public abstract int muteRemoteAudio(long j, boolean z);

    public abstract int muteRemoteVideo(long j, boolean z);

    public abstract int removePublishStreamUrl(String str);

    public abstract void renewChannelKey(String str);

    public abstract int sendLyrics(String str, String str2);

    public abstract int sendStreamMessage(int i, byte[] bArr);

    public abstract int setAppExtensionInfo(String str);

    public abstract void setAudioLevelReportInterval(int i);

    public abstract int setBusinessUserRole(int i);

    public abstract int setImageReportUrl(String str);

    public abstract int setReconnectTimeoutSeconds(int i);

    public abstract int setRemoteRenderMirror(int i);

    public abstract int setRemoteRenderMode(int i);

    public abstract int setRemoteRenderMode(long j, int i, int i2);

    public abstract int setRemoteSubscribeFallbackOption(int i);

    public abstract int setSei(String str, String str2, String str3, String str4);

    public abstract void setServerAddress(String str, int i);

    public abstract void setSpeakerphoneOn(boolean z);

    public abstract void setVideoMixerParams(int i, int i2, int i3, int i4, int i5, int i6);

    public abstract int startChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration);

    public abstract void stopChannelMediaRelay();

    public abstract int updateChannelMediaRelay(ChannelMediaRelayConfiguration channelMediaRelayConfiguration);

    public abstract void updateHeartbeatReporterAudioStatus(Boolean bool, Boolean bool2, Boolean bool3);

    public abstract void updateHeartbeatReporterVideoStatus(Boolean bool, Boolean bool2, Boolean bool3);

    public abstract int updateRtmpUrl(String str, String str2);

    public abstract void uploadLocalVideo(boolean z);

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized com.wushuangtech.api.EnterConfApi getInstance() {
        /*
            java.lang.Class<com.wushuangtech.api.EnterConfApi> r0 = com.wushuangtech.api.EnterConfApi.class
            monitor-enter(r0)
            monitor-enter(r0)     // Catch:{ all -> 0x0016 }
            com.wushuangtech.api.EnterConfApi r1 = mEnterConfApiImpl     // Catch:{ all -> 0x0013 }
            if (r1 != 0) goto L_0x000e
            com.wushuangtech.api.EnterConfApiImpl r1 = com.wushuangtech.api.EnterConfApiImpl.getInstance()     // Catch:{ all -> 0x0013 }
            mEnterConfApiImpl = r1     // Catch:{ all -> 0x0013 }
        L_0x000e:
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            com.wushuangtech.api.EnterConfApi r1 = mEnterConfApiImpl     // Catch:{ all -> 0x0016 }
            monitor-exit(r0)
            return r1
        L_0x0013:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0013 }
            throw r1     // Catch:{ all -> 0x0016 }
        L_0x0016:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.EnterConfApi.getInstance():com.wushuangtech.api.EnterConfApi");
    }
}
