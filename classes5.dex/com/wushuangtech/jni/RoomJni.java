package com.wushuangtech.jni;

import android.os.Build;
import android.util.Log;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.constants.RtcGlobalServerMessage;
import com.wushuangtech.jni.callback.RtcChannelSignalDispatcher;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.utils.OmniLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RoomJni {
    public static final int AUDIOCODEC_AAC = 1;
    public static final int AUDIOCODEC_DEFAULT = 0;
    public static final int AUDIOCODEC_HEAAC = 5;
    public static final int AUDIOCODEC_OPUS = 4;
    public static final int AUDIOCODEC_UWB = 3;
    public static final int AUDIOCODEC_WB = 2;
    public static final int NETWORK_TYPE_CMCC = 3;
    public static final int NETWORK_TYPE_CTCC = 5;
    public static final int NETWORK_TYPE_CUCC = 4;
    public static final int NETWORK_TYPE_NULL = 1;
    public static final int NETWORK_TYPE_OTHER = 6;
    public static final int NETWORK_TYPE_WIFI = 2;
    public static final int PERMISSIONSTATUS_APPLYING = 2;
    public static final int PERMISSIONSTATUS_GRANTED = 3;
    public static final int PERMISSIONSTATUS_NORMAL = 1;
    public static final int PERMISSIONTYPE_SPEAK = 1;
    public static final int ROOM_MODE_COMMUNICATION = 1;
    public static final int ROOM_MODE_LIVE = 0;
    private static RoomJni mRoomJni;
    private int mAppCpuUsage;
    private final Object mAppCpuUsageLock = new Object();
    private final RtcChannelSignalDispatcher<RoomJniCallback> mChannelSignalDispatcher;
    private long mLastTimestamp;

    public interface RoomJniCallback {
        void OnAudioLevelReport(String str, long j, int i, int i2);

        void OnAudioMsgLog(int i, long j);

        void OnAudioPublishStateChanged(String str, int i, int i2, int i3);

        void OnAudioRemoteFirstFrame(String str, long j);

        void OnAudioSubscribeStateChanged(String str, long j, int i, int i2, int i3);

        void OnAudioTryReconnect();

        void OnAudioUpstreamStatus(String str, long j, int i);

        void OnCheckNetQuality(int i, int i2, int i3);

        void OnConfRefreshToken(String str, String str2, int i, int i2, int i3);

        void OnConnect(String str, String str2, int i);

        void OnConnectFailed(String str, String str2, int i);

        void OnConnectIdReport(String str);

        void OnConnectServerResult(String str, int i, String str2);

        void OnEnterAuthed();

        void OnEnterTimeout(String str, String str2, long j, int i, int i2, long j2, long j3, long j4, long j5, long j6, String str3);

        void OnFirstAudioSent();

        void OnFirstVideoSent();

        void OnGlobalSessionId(String str, String str2);

        void OnMediaReconnect(int i, String str);

        void OnMediaRelayEvent(String str, String str2, int i);

        void OnMediaRelayModeUpdate(int i);

        void OnMediaRelayStateChanged(String str, String str2, int i, int i2);

        void OnMixAudioLevelReport(String str, long j, int i, int i2);

        void OnNetTestQuality(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

        void OnReceiveLyric(String str, long j, String str2);

        void OnReconnectTimeout();

        void OnRecvAudioMsg(String str, long j, int i, byte[] bArr);

        void OnRecvCmdMsg(String str, long j, String str2);

        void OnRecvVideoMsg(String str, String str2);

        void OnRejoin(String str, int i);

        void OnRemoteAudioMuted(String str, long j, boolean z);

        void OnRemoteStreamSubscribeAdvice(String str, long j, int i, int i2);

        void OnRemoteVideoMuted(String str, long j, boolean z);

        void OnReportFirstIFrameSent();

        void OnReportImageFireEvent();

        void OnReportMediaAddr(String str, int i, String str2, String str3, int i2, String str4);

        void OnRoomChairChanged(String str, long j);

        void OnRoomConnectSuccess();

        void OnRoomDisconnected(String str);

        void OnRoomEnter(String str, int i, int i2, long j, int i3, int i4, long j2, long j3, long j4, long j5, long j6, long j7, String str2);

        void OnRoomKicked(String str, long j, long j2, int i, String str2, int i2);

        void OnRoomMemberEnter(String str, long j, String str2, int i, int i2, boolean z, boolean z2);

        void OnRoomMemberExit(String str, long j, int i);

        void OnRoomPermissionGranted(long j, int i, int i2);

        void OnRtpRtcp(boolean z, boolean z2);

        void OnSendDataFail(String str, int i, int i2);

        void OnSetAudioCodecParams(int i, int i2);

        void OnStartSendAudio();

        void OnStartSendVideo(boolean z, boolean z2);

        void OnStopSendAudio();

        void OnStopSendVideo(int i);

        void OnUpdateAudioStatus(String str, long j, boolean z, boolean z2);

        void OnUpdateDevParam(String str);

        void OnUpdateMediaChannelState(int i, int i2, String str, int i3, int i4);

        void OnUpdateRtmpError(String str, String str2);

        void OnUpdateRtmpStatus(String str, String str2, int i);

        void OnUpdateVideoDev(String str, long j, String str2);

        void OnUserRoleChanged(String str, long j, int i);

        void OnVideoBufferingStateChanged(String str, long j, boolean z, int i, long j2);

        void OnVideoMixerCreate(String str, String str2, String str3);

        void OnVideoPublishStateChanged(String str, int i, int i2, int i3);

        void OnVideoSubscribeStateChanged(String str, long j, int i, int i2, int i3);

        void OnVideoTryReconnect();
    }

    public enum RoomNativeEvent {
        ENTER_ROOM,
        NETWORK_TYPE,
        LOWER_VIDEO_MIXER,
        UPLINK_ACCELERATE,
        LINK_OTHER_ROOM,
        UNLINK_OTHER_ROOM,
        UPLOAD_VIDEO,
        SET_ROOM_CHAIR,
        ENABLE_REPORT_IMAGE,
        SET_REPORT_IMAGE_PARAMS,
        SEND_IMAGE_DATA,
        UPDATE_AV_SOURCE,
        ROLE_CHANGE,
        AUDIO_LOCAL_MUTED,
        AUDIO_REMOTE_MUTED,
        AUDIO_REMOTE_ALL_MUTED,
        VIDEO_LOCAL_MUTED,
        VIDEO_REMOTE_ALL_MUTED
    }

    private native int CalcAppRusage();

    private void OnConnectSuccess(String str, String str2, int i) {
    }

    private void OnRoomPermissionApply(long j, int i) {
    }

    public native void AddPublishStreamUrl(String str, String str2);

    public native void AdjRemoteUserVolume(long j, double d);

    public native void AdjSpeakerVolume(double d);

    public native void EnableCrossRoom(boolean z);

    public native void EnableDualVideoStream(boolean z);

    public native void EnableReportImage(boolean z, int i);

    public native int GetCpuInfo(int i);

    public native void LinkOtherAnchor(long j, long j2);

    public native void MuteAllRemoteAudio(String str, boolean z);

    public native void MuteAllRemoteVideo(String str, boolean z);

    public native void MuteAllRoomRemoteVideo(boolean z);

    public native void MuteLocalAudio(String str, boolean z);

    public native void MuteLocalVideo(String str, boolean z);

    public native void MuteRemoteAudio(String str, long j, boolean z);

    public native void NativeTeardown();

    public native void PauseMediaRelay(String str);

    public native void RemovePublishStreamUrl(String str, String str2);

    public native void RenewToken(String str, String str2);

    public native void ResumeMediaRelay(String str);

    public native void RoomApplyChairman(String str);

    public native void RoomApplyPermission(int i);

    public native void RoomChangeChairman(long j);

    public native void RoomChangeMyRole(String str, int i);

    public native void RoomExit(String str);

    public native void RoomGrantPermission(long j, int i, int i2);

    public native void RoomKickUser(String str, long j);

    public native void RoomNormalEnter(String str, long j, String str2, String str3, boolean z, String str4, String str5, boolean z2);

    public native void RoomQuickEnter(String str, long j, String str2, int i, String str3, String str4, String str5, boolean z, String str6);

    public native void RoomQuickEnter(String str, long j, String str2, int i, String str3, String str4, boolean z, String str5);

    public native void RoomReleasePermission(int i);

    public native void RoomSendAECParam(String str, int i);

    public native void RoomSetUUID(String str);

    public native void SendCmdMsg(String str, long j, String str2);

    public native void SendCustomizedAudioMsg(String str, int i, byte[] bArr);

    public native void SendCustomizedVideoMsg(String str, String str2);

    public native void SendImageData(byte[] bArr);

    public native void SendLyric(String str, String str2);

    public native int SetAppExtensionInfo(String str);

    public native void SetAudioLevelReportInterval(int i);

    public native void SetAudioMixerParams(int i, int i2, int i3);

    public native void SetBusinessUserRole(int i);

    public native void SetImageReportUrl(String str);

    public native void SetNetworkType(int i);

    public native void SetPreferAudioCodec(int i, int i2, int i3);

    public native void SetRemoteSubscribeFallbackOption(int i);

    public native void SetRemoteUserPriority(long j, int i);

    public native void SetRemoteVideoStreamType(long j, String str, int i);

    public native void SetReportImageParams(String str, int[] iArr);

    public native void SetRoomCreateVideoMixer(boolean z);

    public native void SetRoomLowerVideoMixer(boolean z);

    public native void SetRoomRequireChair(boolean z);

    public native void SetRoomUseUplinkAccelerate(boolean z);

    public native void SetSandboxPath(String str);

    public native void SetSignalTimeout(int i);

    public native void SetSlbAddress(String str, String str2);

    public native void SetSverifyCode(String str);

    public native void SetSystemInfo(String str, String str2, String str3);

    public native void SetToken(String str);

    public native void SetUseAudioServerMixer(boolean z);

    public native void SetVideoMixerBackgroundImgUrl(String str, String str2, String str3, int i, int i2, int i3, int i4);

    public native void SetVideoMixerParams(int i, int i2, int i3, int i4, int i5, int i6);

    public native void SetVideoStuckIgnore(boolean z);

    public native void StartCheckNet(String str, String str2);

    public native void StartMediaRelay(String str, Object obj, Object[] objArr);

    public native void StopCheckNet();

    public native void StopMediaRelay(String str);

    public native void SubscribeOtherRoom(String str);

    public native void UnSubscribeOtherRoom(String str);

    public native void UnlinkOtherAnchor(long j, long j2, String str);

    public native void UpdateAVSyncSource(String str, long j);

    public native void UpdateMediaRelay(String str, Object obj, Object[] objArr);

    public native void UpdateNetworkType(int i);

    public native void UpdateRtmpUrl(String str, String str2);

    public native void UploadMyVideo(String str, String str2, boolean z);

    public native boolean initialize(RoomJni roomJni);

    public native void setServerAddress(String str, int i);

    public native void unInitialize();

    private RoomJni() {
        RtcChannelSignalDispatcher<RoomJniCallback> rtcChannelSignalDispatcher = new RtcChannelSignalDispatcher<>("RoomJni");
        this.mChannelSignalDispatcher = rtcChannelSignalDispatcher;
        rtcChannelSignalDispatcher.setClassType(1);
    }

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
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized com.wushuangtech.jni.RoomJni getInstance() {
        /*
            java.lang.Class<com.wushuangtech.jni.RoomJni> r0 = com.wushuangtech.jni.RoomJni.class
            monitor-enter(r0)
            com.wushuangtech.jni.RoomJni r1 = mRoomJni     // Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x0027
            monitor-enter(r0)     // Catch:{ all -> 0x002b }
            com.wushuangtech.jni.RoomJni r1 = mRoomJni     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x0022
            com.wushuangtech.jni.RoomJni r1 = new com.wushuangtech.jni.RoomJni     // Catch:{ all -> 0x0024 }
            r1.<init>()     // Catch:{ all -> 0x0024 }
            mRoomJni = r1     // Catch:{ all -> 0x0024 }
            boolean r1 = r1.initialize(r1)     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x001a
            goto L_0x0022
        L_0x001a:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0024 }
            java.lang.String r2 = "can't initilaize RoomJni"
            r1.<init>(r2)     // Catch:{ all -> 0x0024 }
            throw r1     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            goto L_0x0027
        L_0x0024:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            throw r1     // Catch:{ all -> 0x002b }
        L_0x0027:
            com.wushuangtech.jni.RoomJni r1 = mRoomJni     // Catch:{ all -> 0x002b }
            monitor-exit(r0)
            return r1
        L_0x002b:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.jni.RoomJni.getInstance():com.wushuangtech.jni.RoomJni");
    }

    public void addCallback(RoomJniCallback roomJniCallback) {
        this.mChannelSignalDispatcher.addCallback(roomJniCallback);
    }

    public void removeCallback(RoomJniCallback roomJniCallback) {
        this.mChannelSignalDispatcher.removeCallback(roomJniCallback);
    }

    public Object invokeNativeMethod(RoomNativeEvent roomNativeEvent, Object... objArr) {
        RoomNativeEvent roomNativeEvent2 = roomNativeEvent;
        if (roomNativeEvent2 != RoomNativeEvent.ENTER_ROOM) {
            if (roomNativeEvent2 != RoomNativeEvent.UPLOAD_VIDEO) {
                if (roomNativeEvent2 != RoomNativeEvent.AUDIO_LOCAL_MUTED) {
                    if (roomNativeEvent2 != RoomNativeEvent.AUDIO_REMOTE_MUTED) {
                        if (roomNativeEvent2 != RoomNativeEvent.AUDIO_REMOTE_ALL_MUTED) {
                            if (roomNativeEvent2 != RoomNativeEvent.VIDEO_LOCAL_MUTED) {
                                if (roomNativeEvent2 != RoomNativeEvent.VIDEO_REMOTE_ALL_MUTED) {
                                    if (roomNativeEvent2 != RoomNativeEvent.ENABLE_REPORT_IMAGE) {
                                        if (roomNativeEvent2 != RoomNativeEvent.SET_REPORT_IMAGE_PARAMS) {
                                            if (roomNativeEvent2 != RoomNativeEvent.SEND_IMAGE_DATA) {
                                                if (roomNativeEvent2 != RoomNativeEvent.UPDATE_AV_SOURCE) {
                                                    if (roomNativeEvent2 != RoomNativeEvent.ROLE_CHANGE) {
                                                        if (GlobalConfig.mBranch != LocalSDKConstants.BRANCH_CLIENT_NEW) {
                                                            switch (AnonymousClass1.$SwitchMap$com$wushuangtech$jni$RoomJni$RoomNativeEvent[roomNativeEvent.ordinal()]) {
                                                                case 1:
                                                                    SetNetworkType(objArr[0].intValue());
                                                                    break;
                                                                case 2:
                                                                    SetRoomLowerVideoMixer(objArr[0].booleanValue());
                                                                    break;
                                                                case 3:
                                                                    SetRoomUseUplinkAccelerate(objArr[0].booleanValue());
                                                                    break;
                                                                case 4:
                                                                    LinkOtherAnchor(objArr[0].longValue(), objArr[1].longValue());
                                                                    break;
                                                                case 5:
                                                                    UnlinkOtherAnchor(objArr[0].longValue(), objArr[1].longValue(), objArr[2]);
                                                                    break;
                                                                case 6:
                                                                    SetRoomRequireChair(objArr[0].booleanValue());
                                                                    break;
                                                            }
                                                        } else {
                                                            return null;
                                                        }
                                                    } else {
                                                        RoomChangeMyRole(objArr[0], objArr[1].intValue());
                                                    }
                                                } else {
                                                    UpdateAVSyncSource(objArr[0], objArr[1].longValue());
                                                }
                                            } else {
                                                SendImageData(objArr[0]);
                                            }
                                        } else {
                                            SetReportImageParams(objArr[0], objArr[1]);
                                        }
                                    } else {
                                        EnableReportImage(objArr[0].booleanValue(), objArr[1].intValue());
                                    }
                                } else {
                                    MuteAllRemoteVideo(objArr[0], objArr[1].booleanValue());
                                }
                            } else {
                                String str = objArr[0];
                                boolean booleanValue = objArr[1].booleanValue();
                                Log.i("RoomJniJava", " MuteLocalVideo channelName:" + str + " muted:" + booleanValue);
                                MuteLocalVideo(str, booleanValue);
                            }
                        } else {
                            MuteAllRemoteAudio(objArr[0], objArr[1].booleanValue());
                        }
                    } else {
                        MuteRemoteAudio(objArr[0], objArr[1].longValue(), objArr[2].booleanValue());
                    }
                } else {
                    MuteLocalAudio(objArr[0], objArr[1].booleanValue());
                }
            } else {
                UploadMyVideo(objArr[0], objArr[1], objArr[2].booleanValue());
            }
        } else if (GlobalConfig.mBranch == LocalSDKConstants.BRANCH_CLIENT_NEW) {
            GlobalHolder.getInstance().sendSyncGlobalServerMessage(RtcGlobalServerMessage.NETWORK_CONNECT_STATE_CHANGED, 2, 0);
            long longValue = objArr[1].longValue();
            int intValue = objArr[3].intValue();
            String str2 = Build.MODEL;
            boolean booleanValue2 = objArr[6].booleanValue();
            RoomQuickEnter(objArr[0], longValue, objArr[2], intValue, objArr[4], str2, objArr[5], booleanValue2, objArr[7]);
        } else {
            long longValue2 = objArr[1].longValue();
            int intValue2 = objArr[3].intValue();
            String str3 = Build.MODEL;
            RoomQuickEnter(objArr[0], longValue2, objArr[2], intValue2, objArr[4], str3, false, objArr[5]);
        }
        return null;
    }

    /* renamed from: com.wushuangtech.jni.RoomJni$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$wushuangtech$jni$RoomJni$RoomNativeEvent;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.wushuangtech.jni.RoomJni$RoomNativeEvent[] r0 = com.wushuangtech.jni.RoomJni.RoomNativeEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$wushuangtech$jni$RoomJni$RoomNativeEvent = r0
                com.wushuangtech.jni.RoomJni$RoomNativeEvent r1 = com.wushuangtech.jni.RoomJni.RoomNativeEvent.NETWORK_TYPE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$wushuangtech$jni$RoomJni$RoomNativeEvent     // Catch:{ NoSuchFieldError -> 0x001d }
                com.wushuangtech.jni.RoomJni$RoomNativeEvent r1 = com.wushuangtech.jni.RoomJni.RoomNativeEvent.LOWER_VIDEO_MIXER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$wushuangtech$jni$RoomJni$RoomNativeEvent     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.wushuangtech.jni.RoomJni$RoomNativeEvent r1 = com.wushuangtech.jni.RoomJni.RoomNativeEvent.UPLINK_ACCELERATE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$wushuangtech$jni$RoomJni$RoomNativeEvent     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.wushuangtech.jni.RoomJni$RoomNativeEvent r1 = com.wushuangtech.jni.RoomJni.RoomNativeEvent.LINK_OTHER_ROOM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$wushuangtech$jni$RoomJni$RoomNativeEvent     // Catch:{ NoSuchFieldError -> 0x003e }
                com.wushuangtech.jni.RoomJni$RoomNativeEvent r1 = com.wushuangtech.jni.RoomJni.RoomNativeEvent.UNLINK_OTHER_ROOM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$wushuangtech$jni$RoomJni$RoomNativeEvent     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.wushuangtech.jni.RoomJni$RoomNativeEvent r1 = com.wushuangtech.jni.RoomJni.RoomNativeEvent.SET_ROOM_CHAIR     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.jni.RoomJni.AnonymousClass1.<clinit>():void");
        }
    }

    private void OnRoomEnter(String str, int i, int i2, long j, int i3, int i4, long j2, long j3, long j4, long j5, long j6, long j7, String str2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i3), Integer.valueOf(i4), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), str2);
    }

    public void OnRoomMemberEnter(String str, long j, String str2, int i, int i2, boolean z, boolean z2) {
        GlobalConfig.testUpdateUserSize(true);
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j), str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public void OnRoomMemberExit(String str, long j, int i) {
        GlobalConfig.testUpdateUserSize(false);
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j), Integer.valueOf(i));
    }

    private void OnRoomKicked(String str, long j, long j2, int i, String str2, int i2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), str2, Integer.valueOf(i2));
    }

    private void OnRoomPermissionGranted(long j, int i, int i2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
    }

    private void OnRoomChairChanged(String str, long j) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j));
    }

    private void OnRoomDisconnected(String str) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str);
    }

    private void OnRoomConnectSuccess() {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(new Object[0]);
    }

    private void OnRejoin(String str, long j) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Integer.valueOf((int) j));
    }

    private void OnUpdateDevParam(String str) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str);
    }

    private void OnUpdateRtmpStatus(String str, String str2, int i) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, str2, Integer.valueOf(i));
    }

    private void OnUpdateRtmpError(String str, String str2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, str2);
    }

    private void OnRecvCmdMsg(String str, long j, String str2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j), str2);
    }

    private void OnReportMediaAddr(String str, int i, String str2, String str3, int i2, String str4) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), str4);
    }

    private void OnMediaReconnect(int i, String str) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(Integer.valueOf(i), str);
    }

    private void OnUpdateVideoDev(String str, long j, String str2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j), str2);
    }

    private void OnAudioLevelReport(String str, long j, int i, int i2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
    }

    private void OnMixAudioLevelReport(String str, long j, int i, int i2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void OnUpdateMediaChannelState(int i, int i2, String str, int i3, int i4) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), Integer.valueOf(i4));
    }

    private void OnRecvAudioMsg(String str, long j, int i, byte[] bArr) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j), Integer.valueOf(i), bArr);
    }

    private void OnRecvVideoMsg(String str, String str2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, str2);
    }

    private void OnStartSendVideo(boolean z, boolean z2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    private void OnStopSendVideo(int i) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(Integer.valueOf(i));
    }

    private void OnStartSendAudio() {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(new Object[0]);
    }

    private void OnStopSendAudio() {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(new Object[0]);
    }

    private void OnUpdateAudioStatus(String str, long j, boolean z, boolean z2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j), Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    private void OnRemoteAudioMuted(String str, long j, boolean z) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j), Boolean.valueOf(z));
    }

    private void OnUserRoleChanged(String str, long j, int i) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j), Integer.valueOf(i));
    }

    private void OnFirstAudioSent() {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(new Object[0]);
    }

    private void OnFirstVideoSent() {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(new Object[0]);
    }

    private void OnRtpRtcp(boolean z, boolean z2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    private void OnConnect(String str, String str2, int i) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, str2, Integer.valueOf(i));
    }

    private void OnReconnectTimeout() {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(new Object[0]);
    }

    private void OnReportFirstIFrameSent() {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(new Object[0]);
    }

    private void OnSetAudioCodecParams(int i, int i2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(Integer.valueOf(i), Integer.valueOf(i2));
    }

    private void OnReceiveLyric(String str, long j, String str2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j), str2);
    }

    private void OnNativeLog(String str, int i) {
        Log.e("qq", str);
        GlobalHolder.getInstance().sendSyncRtcEngineEvent(1, Integer.valueOf(i), str);
    }

    private void OnVideoMixerCreate(String str, String str2, String str3) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, str2, str3);
    }

    private void OnEnterTimeout(String str, String str2, long j, int i, int i2, long j2, long j3, long j4, long j5, long j6, String str3) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, str2, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), str3);
    }

    private void OnConnectServerResult(String str, int i, String str2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Integer.valueOf(i), str2);
    }

    private void OnGlobalSessionId(String str, String str2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, str2);
    }

    private void OnConfRefreshToken(String str, String str2, int i, int i2, int i3) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    private void OnSendDataFail(String str, int i, int i2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    private void OnEnterAuthed() {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(new Object[0]);
    }

    private void OnAudioMsgLog(int i, long j) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(Integer.valueOf(i), Long.valueOf(j));
    }

    private void OnAudioTryReconnect() {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(new Object[0]);
    }

    private void OnVideoTryReconnect() {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(new Object[0]);
    }

    private void OnRemoteVideoMuted(String str, long j, boolean z) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j), Boolean.valueOf(z));
    }

    private void OnAudioRemoteFirstFrame(String str, long j) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j));
    }

    private void OnCheckNetQuality(int i, int i2, int i3) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    private void OnConnectIdReport(String str) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str);
    }

    private void OnConnectFailed(String str, String str2, int i) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, str2, Integer.valueOf(i));
    }

    private void OnNetTestQuality(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
    }

    private void OnVideoBufferingStateChanged(String str, long j, boolean z, int i, long j2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(i), Long.valueOf(j2));
    }

    public void OnAudioUpstreamStatus(String str, long j, int i) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j), Integer.valueOf(i));
    }

    private void OnReportImageFireEvent() {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(new Object[0]);
    }

    private void OnRemoteStreamSubscribeAdvice(String str, long j, int i, int i2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2));
    }

    private void OnVideoEncoderBSlicedThreads(int i) {
        OmniLog.i("OnVideoEncoderBSlicedThreads nBSlicedThreads:" + i);
        GlobalConfig.setEncoderBSlicedThread(i);
    }

    private void OnVideoPublishStateChanged(String str, int i, int i2, int i3) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    private void OnAudioPublishStateChanged(String str, int i, int i2, int i3) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    private void OnVideoSubscribeStateChanged(String str, long j, int i, int i2, int i3) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    private void OnAudioSubscribeStateChanged(String str, long j, int i, int i2, int i3) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    private void OnMediaRelayModeUpdate(int i) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(Integer.valueOf(i));
    }

    private void OnMediaRelayStateChanged(String str, String str2, int i, int i2) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, str2, Integer.valueOf(i), Integer.valueOf(i2));
    }

    private void OnMediaRelayEvent(String str, String str2, int i) {
        this.mChannelSignalDispatcher.receiveChannelSignalEvent(str, str2, Integer.valueOf(i));
    }

    private void OnPolicy(String str) {
        try {
            HashMap hashMap = new HashMap();
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        hashMap.put(next, jSONObject.getJSONObject(next));
                    } catch (Exception e) {
                        OmniLog.i("OnPolicy Exception:" + e);
                    }
                }
            }
            if (hashMap.containsKey("jpegSnapQuality")) {
                JSONObject jSONObject2 = (JSONObject) hashMap.get("jpegSnapQuality");
                if (jSONObject2.has("quality")) {
                    GlobalConfig.mJpgQuality = jSONObject2.getInt("quality");
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public double getCpuUsage() {
        boolean z;
        synchronized (this.mAppCpuUsageLock) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.mLastTimestamp;
            z = true;
            if (j == 0) {
                this.mLastTimestamp = currentTimeMillis;
            } else if (currentTimeMillis - j > 1000) {
                this.mLastTimestamp = currentTimeMillis;
            } else {
                z = false;
            }
        }
        if (z) {
            this.mAppCpuUsage = CalcAppRusage();
        }
        return ((double) this.mAppCpuUsage) / 10000.0d;
    }
}
