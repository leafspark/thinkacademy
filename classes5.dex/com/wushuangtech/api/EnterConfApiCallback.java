package com.wushuangtech.api;

import android.util.LongSparseArray;
import com.wushuangtech.api.EnterConfApi;
import java.util.ArrayList;

public interface EnterConfApiCallback {
    public static final int CHANNELKEYEXPIRED = 109;
    public static final int ENTERCONFAPI_BAD_VERSION = 4;
    public static final int ENTERCONFAPI_ENTER_FAILED = 2;
    public static final int ENTERCONFAPI_NOERROR = 0;
    public static final int ENTERCONFAPI_TIMEOUT = 1;
    public static final int ENTERCONFAPI_VERIFY_FAILED = 3;
    public static final int KICKEDBYHOST = 101;
    public static final int MASTER_EXIT = 104;
    public static final int NEWCHAIRENTER = 108;
    public static final int NOAUDIODATA = 106;
    public static final int NOVIDEODATA = 107;
    public static final int PUSHRTMPFAILED = 102;
    public static final int RELOGIN = 105;
    public static final int RE_NEW_CHANNEL_KEY_FAILD = 401;
    public static final int SERVEROVERLOAD = 103;
    public static final int USER_EXIT_REASON_LINKCLOSE = 203;
    public static final int USER_EXIT_REASON_TIMEOUT = 202;

    public static class GSAudioStats {
        public int bufferDuration;
        public int delayMs;
        public int lossRate;
        public long userId;
    }

    public static class GSVideoStats {
        public int bitrate;
        public int delayms;
        public int fps;
        public long userId;
    }

    public static class SpeakerLevel {
        public int audioLevel;
        public int audioLevelFullRange;
        public long nUserID;
    }

    void OnVideoMixerCreate(String str);

    void firstAudioFrameDecoded(long j);

    void onAnchorEnter(long j, long j2, String str, int i);

    void onAnchorExit(long j, long j2);

    void onAnchorLinkResponse(long j, long j2);

    void onAnchorUnlinkResponse(long j, long j2, int i);

    void onApplySpeakPermission(long j);

    void onAudioLevelReport(long j, int i, int i2);

    void onAudioMuted(boolean z, long j);

    void onConfChairmanChanged(long j, long j2);

    void onDisconnected(String str, int i);

    void onEnterRoom(int i, int i2);

    void onExitRoom();

    void onGrantPermissionCallback(long j, int i, int i2);

    void onKickedOut(long j, long j2, long j3, int i);

    void onMediaSending();

    void onMemberEnter(long j, long j2, String str, int i, int i2);

    void onMemberExit(long j, long j2, int i);

    void onMixAudioLevelReport(long j, int i, int i2);

    void onReceiveLyric(long j, String str);

    void onReconnectTimeout();

    void onRecvCustomizedAudioMsg(String str);

    void onRecvCustomizedMsg(long j, String str);

    void onRecvCustomizedVideoMsg(String str);

    void onRenewChannelKeyResult(int i);

    void onReportAudioLevelAll(LongSparseArray<EnterConfApi.AudioLevel> longSparseArray);

    void onReportLocalVideoLossRate(float f);

    void onReportLocalVideoStats(GSVideoStats gSVideoStats);

    void onReportRemoteAudioStats(ArrayList<GSAudioStats> arrayList);

    void onReportRemoteVideoStats(ArrayList<GSVideoStats> arrayList);

    void onRequestChannelKey();

    void onSetAudioCodecParams(int i, int i2);

    void onSetSei(long j, String str);

    void onSetSubVideoPosRation(long j, long j2, String str, double d, double d2, double d3, double d4);

    void onUpdateRtmpStatus(long j, String str, int i);

    void onUserRoleChanged(long j, int i);

    void onVideoMuted(boolean z, long j);

    void onVideoaDualStreamEnabled(boolean z, long j);

    void reportMediaServerIp(String str, String str2);

    void reportUseRtpRtcp(boolean z, boolean z2);
}
