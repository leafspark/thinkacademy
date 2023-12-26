package com.wushuangtech.log;

import android.os.Build;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.tekartik.sqflite.Constant;
import com.wushuangtech.api.ExternalAudioModule;
import com.wushuangtech.bean.LogEvent;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.constants.RtcNativeCallBackFun;
import com.wushuangtech.jni.NativeInitializer;
import com.wushuangtech.jni.ReportLogJni;
import com.wushuangtech.jni.bean.MediaRelayInfo;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.JNIResponse;
import com.wushuangtech.log.BaseReportLogger;
import com.wushuangtech.utils.OmniLog;
import io.ktor.http.LinkHeader;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportLogger extends BaseReportLogger {
    private static final String TAG = "ReportLogger";
    private final String mAppId;
    private String mChannelName;
    private String mConnectId;
    private final String[] mGlobalEvent = {RtcNativeCallBackFun.CHANNEL_AV_MEDIA_ADDRESS, RtcNativeCallBackFun.CHANNEL_CONNECT_LOST, RtcNativeCallBackFun.CHANNEL_RECONNECT_SUCCESS, RtcNativeCallBackFun.CHANNEL_RECONNECT_FAILED};
    private long mJoinChannelTimestamp;
    private int mRole;
    private String mSessionId = "";
    private long mUid;

    private int booleanToInt(boolean z) {
        return z ? 1 : 0;
    }

    private long checkValueOverflow(long j) {
        if (j < 0) {
            return 0;
        }
        return j;
    }

    /* access modifiers changed from: protected */
    public boolean buildCommonJsonContent(JSONObject jSONObject) {
        return false;
    }

    public void clearResource() {
    }

    public ReportLogger(String str, long j, int i, String str2) {
        this.mUid = j;
        this.mChannelName = str;
        this.mRole = i;
        this.mConnectId = str2;
        this.mAppId = GlobalConfig.mAppId;
    }

    public void setParams(String str, long j, int i, String str2) {
        this.mUid = j;
        this.mChannelName = str;
        this.mRole = i;
        this.mConnectId = str2;
        String str3 = TAG;
        OmniLog.d(str3, "Update params : " + str + " | " + j + " | " + i + " | " + str2);
    }

    public void setRole(int i) {
        this.mRole = i;
    }

    public void SendLogMsg(BaseReportLogger.ReportLogMsg reportLogMsg) {
        ReportLogJni.getInstance().ReportLog(reportLogMsg.logMsg, reportLogMsg.msgType, this.mAppId);
    }

    /* renamed from: com.wushuangtech.log.ReportLogger$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$wushuangtech$bean$LogEvent;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(3:27|28|30)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.wushuangtech.bean.LogEvent[] r0 = com.wushuangtech.bean.LogEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$wushuangtech$bean$LogEvent = r0
                com.wushuangtech.bean.LogEvent r1 = com.wushuangtech.bean.LogEvent.CHANNEL_TOKEN_AUTH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$wushuangtech$bean$LogEvent     // Catch:{ NoSuchFieldError -> 0x001d }
                com.wushuangtech.bean.LogEvent r1 = com.wushuangtech.bean.LogEvent.CHANNEL_TOKEN_EXPIRED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$wushuangtech$bean$LogEvent     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.wushuangtech.bean.LogEvent r1 = com.wushuangtech.bean.LogEvent.CHANNEL_RENEW_TOKEN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$wushuangtech$bean$LogEvent     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.wushuangtech.bean.LogEvent r1 = com.wushuangtech.bean.LogEvent.CHANNEL_MEDIA_RELAY2     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$wushuangtech$bean$LogEvent     // Catch:{ NoSuchFieldError -> 0x003e }
                com.wushuangtech.bean.LogEvent r1 = com.wushuangtech.bean.LogEvent.CHANNEL_MEDIA_RELAY_STATE2     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$wushuangtech$bean$LogEvent     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.wushuangtech.bean.LogEvent r1 = com.wushuangtech.bean.LogEvent.AUDIO_LOCAL_START_SEND     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$wushuangtech$bean$LogEvent     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.wushuangtech.bean.LogEvent r1 = com.wushuangtech.bean.LogEvent.AUDIO_LOCAL_STOP_SEND     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$wushuangtech$bean$LogEvent     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.wushuangtech.bean.LogEvent r1 = com.wushuangtech.bean.LogEvent.AUDIO_REMOTE_FIRST_FRAME_DECODED     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$wushuangtech$bean$LogEvent     // Catch:{ NoSuchFieldError -> 0x006c }
                com.wushuangtech.bean.LogEvent r1 = com.wushuangtech.bean.LogEvent.VIDEO_LOCAL_ENC_PARAMS     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$wushuangtech$bean$LogEvent     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.wushuangtech.bean.LogEvent r1 = com.wushuangtech.bean.LogEvent.VIDEO_LOCAL_UPSTREAM_STUCK     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$wushuangtech$bean$LogEvent     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.wushuangtech.bean.LogEvent r1 = com.wushuangtech.bean.LogEvent.VIDEO_LOCAL_DOWNSTREAM_STUCK     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$wushuangtech$bean$LogEvent     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.wushuangtech.bean.LogEvent r1 = com.wushuangtech.bean.LogEvent.VIDEO_REMOTE_FIRST_FRAME_DECODED     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$wushuangtech$bean$LogEvent     // Catch:{ NoSuchFieldError -> 0x009c }
                com.wushuangtech.bean.LogEvent r1 = com.wushuangtech.bean.LogEvent.VIDEO_REMOTE_FIRST_FRAME_DRAN     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$wushuangtech$bean$LogEvent     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.wushuangtech.bean.LogEvent r1 = com.wushuangtech.bean.LogEvent.MEDIA_RELAY_JOIN     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.log.ReportLogger.AnonymousClass1.<clinit>():void");
        }
    }

    public void reportLogEvent(LogEvent logEvent, Object... objArr) {
        switch (AnonymousClass1.$SwitchMap$com$wushuangtech$bean$LogEvent[logEvent.ordinal()]) {
            case 1:
                executeReportTokenAuth(objArr);
                return;
            case 2:
                reportKeyExpired();
                return;
            case 3:
                reportRenewKey(objArr[0], false);
                return;
            case 4:
                reportChannelMediaRelay2(objArr);
                return;
            case 5:
                reportChannelMediaRelayState2(objArr[0], objArr[1], objArr[2].intValue(), objArr[3].intValue());
                return;
            case 6:
                reportStartSendAudio();
                return;
            case 7:
                reportStopSendAudio();
                return;
            case 8:
                reportAudioRemoteFirstDecoded(objArr[0].longValue(), objArr[1].intValue());
                return;
            case 9:
                reportVideoEncParams(objArr[0].intValue());
                return;
            case 10:
                reportVideoUpstreamStuck(objArr[0], objArr[1].intValue(), objArr[2].intValue());
                return;
            case 11:
                reportVideoDownstreamStuck(objArr[0], objArr[1].intValue(), objArr[2].intValue());
                return;
            case 12:
                reportVideoRemoteFirstDecoded(objArr[0], objArr[1].intValue(), objArr[2].intValue(), objArr[3].intValue());
                return;
            case 13:
                reportVideoRemoteFirstDran(objArr[0], objArr[1].intValue(), objArr[2].intValue(), objArr[3].intValue());
                return;
            case 14:
                ReportJoinMediaRelay(objArr[0], objArr[1], objArr[2].intValue(), objArr[3].intValue());
                return;
            default:
                return;
        }
    }

    public void reportLogEvent(String str, String str2, Object[] objArr) {
        boolean z;
        String str3 = str2;
        String[] strArr = this.mGlobalEvent;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (strArr[i].equals(str3)) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        char c = 65535;
        if (z) {
            str2.hashCode();
            switch (str2.hashCode()) {
                case -1119386923:
                    if (str3.equals(RtcNativeCallBackFun.CHANNEL_CONNECT_LOST)) {
                        c = 0;
                        break;
                    }
                    break;
                case -254043607:
                    if (str3.equals(RtcNativeCallBackFun.CHANNEL_RECONNECT_FAILED)) {
                        c = 1;
                        break;
                    }
                    break;
                case 1532486434:
                    if (str3.equals(RtcNativeCallBackFun.CHANNEL_AV_MEDIA_ADDRESS)) {
                        c = 2;
                        break;
                    }
                    break;
                case 1762687443:
                    if (str3.equals(RtcNativeCallBackFun.CHANNEL_RECONNECT_SUCCESS)) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    reportSignalDisconnect();
                    return;
                case 1:
                    reportReconnectTimeout();
                    return;
                case 2:
                    reportMediaAddr(objArr[0], objArr[1].intValue(), objArr[2], objArr[3], objArr[4].intValue(), objArr[5]);
                    return;
                case 3:
                    reportConnectSuccess();
                    return;
                default:
                    return;
            }
        } else if (!TextUtils.isEmpty(str)) {
            if (str.equals(this.mChannelName)) {
                str2.hashCode();
                switch (str2.hashCode()) {
                    case -1000779000:
                        if (str3.equals(RtcNativeCallBackFun.CHANNEL_JOIN_TIMEOUT)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -563671566:
                        if (str3.equals(RtcNativeCallBackFun.CHANNEL_USER_OFFLINE)) {
                            c = 1;
                            break;
                        }
                        break;
                    case -294237052:
                        if (str3.equals(RtcNativeCallBackFun.CHANNEL_USER_JOINED)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 545508222:
                        if (str3.equals(RtcNativeCallBackFun.CHANNEL_JOINED)) {
                            c = 3;
                            break;
                        }
                        break;
                    case 2024100335:
                        if (str3.equals(RtcNativeCallBackFun.CHANNEL_SESSION_ID)) {
                            c = 4;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        reportEnterTimeout(objArr[2].longValue(), objArr[3].intValue(), objArr[4].intValue(), objArr[5].longValue(), objArr[6].longValue(), objArr[7].longValue(), objArr[8].longValue(), objArr[9].longValue(), objArr[10]);
                        return;
                    case 1:
                        reportMemberQuit(objArr[0], objArr[1].longValue(), objArr[2].intValue());
                        return;
                    case 2:
                        reportMemberEnter(this.mChannelName, objArr[1].longValue(), objArr[0], objArr[3].intValue());
                        return;
                    case 3:
                        int intValue = objArr[1].intValue();
                        if (intValue == 0) {
                            reportEnterSuccess(objArr[0], objArr[2].intValue(), objArr[3].longValue(), objArr[4].intValue(), objArr[5].intValue(), objArr[6].longValue(), objArr[7].longValue(), objArr[8].longValue(), objArr[9].longValue(), objArr[10].longValue(), objArr[11].longValue(), objArr[12]);
                            return;
                        }
                        ReportEnterFail(objArr[0], objArr[2].intValue(), intValue, objArr[3].longValue(), objArr[4].intValue(), objArr[5].intValue(), objArr[6].longValue(), objArr[7].longValue(), objArr[8].longValue(), objArr[9].longValue(), objArr[10].longValue(), objArr[11].longValue(), objArr[12]);
                        return;
                    case 4:
                        String str4 = objArr[1];
                        this.mSessionId = str4;
                        reportGlobalSessionId(str4);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void reportEnterBegin(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("sdkVersion", NativeInitializer.getIntance().getVersion());
        hashMap.put("javaVersion", GlobalConfig.LOCAL_SDK_VERSION_NAME);
        hashMap.put("javaTestVersion", GlobalConfig.SDK_VERSION_TEST_NUMBER);
        hashMap.put("channelMode", Integer.valueOf(GlobalConfig.mCurrentChannelMode));
        hashMap.put("rtmp", str);
        hashMap.put("branch", Integer.valueOf(GlobalConfig.mBranch));
        hashMap.put("gitBranch", GlobalConfig.GIT_BRANCH);
        hashMap.put("serverIP", GlobalConfig.mServerIP);
        hashMap.put("serverPort", Integer.valueOf(GlobalConfig.mServerPort));
        this.mJoinChannelTimestamp = System.currentTimeMillis();
        buildJsonContent("enter_begin", hashMap);
    }

    public void ReportSimpleEnterFail(JNIResponse.Result result, int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("totalDiff", Long.valueOf(System.currentTimeMillis() - this.mJoinChannelTimestamp));
        if (str.length() > 0) {
            hashMap.put("gwIp", str);
        }
        hashMap.put(Constant.PARAM_RESULT, result.toString());
        hashMap.put("error_code", Integer.valueOf(i));
        buildJsonContent("enter_fail", hashMap);
    }

    public void ReportExit(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("totalDiff", Long.valueOf(System.currentTimeMillis() - this.mJoinChannelTimestamp));
        hashMap.put("invokeRoomID", str);
        buildJsonContent("exit_channel", hashMap);
    }

    public void reportGlobalSessionId(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("session_id", str);
        buildJsonContent("global_session_id", hashMap);
    }

    public void ReportKicked(long j, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("memberId", Long.valueOf(j));
        hashMap.put(Constant.PARAM_ERROR_CODE, 0);
        hashMap.put("stat", 3);
        hashMap.put("kickReason", Integer.valueOf(i));
        buildJsonContent("member_state", hashMap);
    }

    public void ReportSpeakPermission(long j, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("speaker", Long.valueOf(j));
        hashMap.put("status", Integer.valueOf(i));
        buildJsonContent("speak_permission", hashMap);
    }

    public void ReportChangeRole(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("newRole", Integer.valueOf(i));
        buildJsonContent("user_role", hashMap);
    }

    public void ReportStartSendVideo(boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("isLocalVideoMuted", Integer.valueOf(booleanToInt(z)));
        hashMap.put("isOpenVideo", Integer.valueOf(booleanToInt(z2)));
        buildJsonContent("start_send_video", hashMap);
    }

    public void ReportStopSendVideo(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("rsn", Integer.valueOf(i));
        buildJsonContent("stop_send_video", hashMap);
    }

    public void reportStartSendAudio() {
        buildJsonContent("start_send_audio", new HashMap());
    }

    public void reportStopSendAudio() {
        buildJsonContent("stop_send_audio", new HashMap());
    }

    public void ReportInBackgroud(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isBg", Integer.valueOf(booleanToInt(z)));
        hashMap.put("ts", Long.valueOf(System.currentTimeMillis()));
        buildJsonContent("switch_background_state", hashMap);
    }

    public void ReportFirstIFrameSent() {
        buildJsonContent("first_i_sent", new HashMap());
    }

    public void ReportAudioCodecParams(int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("codecType", Integer.valueOf(i));
        hashMap.put("bitrate", Integer.valueOf(i2));
        buildJsonContent("audio_codec", hashMap);
    }

    public void ReportUserRoleChanged(long j, int i) {
        HashMap hashMap = new HashMap();
        if (GlobalConfig.mLocalUserID != j) {
            hashMap.put("remoteId", Long.valueOf(j));
            hashMap.put("userRole", Integer.valueOf(i));
        }
        buildJsonContent("remote_user_role", hashMap);
    }

    public void ReportUpdateRtmpUrl(String str) {
        HashMap hashMap = new HashMap();
        if (GlobalConfig.mBranch != LocalSDKConstants.BRANCH_CLIENT_TC) {
            hashMap.put("url", str);
        }
        buildJsonContent("update_rtmp", hashMap);
    }

    public void ReportSei(String str, boolean z, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("sei", str);
        hashMap.put("receive", Integer.valueOf(booleanToInt(z)));
        hashMap.put("sei_ext", str2);
        buildJsonContent("user_sei", hashMap);
    }

    public void ReportSendDataFail(String str, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("mediaID", str);
        hashMap.put(Constant.PARAM_ERROR, Integer.valueOf(i));
        hashMap.put(LinkHeader.Parameters.Type, Integer.valueOf(i2));
        buildJsonContent("send_data_fail", hashMap);
    }

    public void ReportAudioFirstPackReceived() {
        buildJsonContent("recv_fst_rmt_audio_frm", new HashMap());
    }

    public void ReportOnEnterAuthed() {
        buildJsonContent("c2s_enter_authed", new HashMap());
    }

    public void ReportOnAudioConnectSuccess() {
        buildJsonContent("audio_connect_success", new HashMap());
    }

    public void ReportAudioTryReconnect() {
        buildJsonContent("audio_try_reconnect", new HashMap());
    }

    public void ReportVideoTryReconnect() {
        buildJsonContent("video_try_reconnect", new HashMap());
    }

    public void reportVideoDualStream(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("enabled", Integer.valueOf(booleanToInt(z)));
        buildJsonContent("inter_dual_stream", hashMap);
    }

    public void reportVideoSettingParams(int i, int i2, int i3, int i4) {
        HashMap hashMap = new HashMap();
        hashMap.put("width", Integer.valueOf(i));
        hashMap.put("height", Integer.valueOf(i2));
        hashMap.put("fps", Integer.valueOf(i3));
        hashMap.put("bitrate", Integer.valueOf(i4));
    }

    public void reportVideoOpened(boolean z, String str, long j, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("enabled", Integer.valueOf(booleanToInt(z)));
        hashMap.put("channelId", str);
        hashMap.put("userid", Long.valueOf(j));
        hashMap.put("devId", str2);
        buildJsonContent("inter_open_video", hashMap);
    }

    public void ReportVideoDecoderCreated(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("deviceId", str);
        hashMap.put("decoder", str2);
        buildJsonContent("video_decoder_created", hashMap);
    }

    public void ReportCameraPreview(int i, int i2, int i3, int i4) {
        HashMap hashMap = new HashMap();
        hashMap.put("width", Integer.valueOf(i));
        hashMap.put("height", Integer.valueOf(i2));
        hashMap.put("previewRotation", Integer.valueOf(i3));
        hashMap.put(Constant.PARAM_RESULT, Integer.valueOf(i4));
        buildJsonContent("camera_preview", hashMap);
    }

    public void ReportEncodeInfos(int i, int i2, int i3, int i4, int i5, String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("encodeType", str);
        hashMap.put("width", Integer.valueOf(i));
        hashMap.put("height", Integer.valueOf(i2));
        hashMap.put("frameRate", Integer.valueOf(i3));
        hashMap.put("bitrate", Integer.valueOf(i4));
        hashMap.put("hardwareEncodeMode", Integer.valueOf(i5));
        hashMap.put("openResult", Integer.valueOf(booleanToInt(z)));
        buildJsonContent("video_encode_info", hashMap);
    }

    public void ReportAudioRecErr(ExternalAudioModule.RecordErrInfo recordErrInfo) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constant.PARAM_ERROR, Integer.valueOf(recordErrInfo.errorCode));
        hashMap.put("am", Integer.valueOf(recordErrInfo.audioMode));
        hashMap.put("rm", Integer.valueOf(recordErrInfo.recordmode));
        hashMap.put("spkon", Boolean.valueOf(recordErrInfo.speakerphoneon));
        hashMap.put("focus", Boolean.valueOf(recordErrInfo.audiofocus));
        hashMap.put("ch", Integer.valueOf(recordErrInfo.channels));
        hashMap.put("freq", Integer.valueOf(recordErrInfo.samplerate));
        buildJsonContent("a_rec_err", hashMap);
    }

    public void ReportAudioPlayErr() {
        buildJsonContent("a_play_err", new HashMap());
    }

    public void ReportMuteLocalErr(int i) {
        if (i != 98 && i != -2) {
            HashMap hashMap = new HashMap();
            hashMap.put(Constant.PARAM_ERROR, Integer.valueOf(i));
            buildJsonContent("mute_local_err", hashMap);
        }
    }

    public void ReportRtmpSendState(String str, int i) {
        HashMap hashMap = new HashMap();
        if (GlobalConfig.mBranch != LocalSDKConstants.BRANCH_CLIENT_TC) {
            hashMap.put("rtmpUrl", str);
        }
        hashMap.put("status", Integer.valueOf(i));
        buildJsonContent("cb_rtmp_status", hashMap);
    }

    public void ReportUpdateAudioStatus(long j, boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("userid", Long.valueOf(j));
        hashMap.put("speak", Integer.valueOf(booleanToInt(z)));
        hashMap.put("server_mix", Integer.valueOf(booleanToInt(z2)));
        buildJsonContent("cb_audio_status", hashMap);
    }

    public void ReportJoinMediaRelay(String str, String str2, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("srcChannelId", str);
        hashMap.put("dstChannelId", str2);
        hashMap.put(Constant.PARAM_ERROR_CODE, Integer.valueOf(i));
        hashMap.put("stat", Integer.valueOf(i2));
        buildJsonContent("channel_media_relay", hashMap);
    }

    private void executeReportTokenAuth(Object[] objArr) {
        String str = objArr[0];
        String str2 = objArr[1];
        ReportAuth(str, str, (String) null, !TextUtils.isEmpty(str2), str2);
    }

    private void reportEnterSuccess(String str, int i, long j, int i2, int i3, long j2, long j3, long j4, long j5, long j6, long j7, String str2) {
        long j8 = j;
        HashMap hashMap = new HashMap();
        hashMap.put("enterLiveTs", Long.valueOf(checkValueOverflow(j)));
        hashMap.put("serGwIp", str2);
        hashMap.put("sendIpLocDur", Long.valueOf(checkValueOverflow(j4 - j8)));
        hashMap.put("linkIpLocTimes", Long.valueOf(checkValueOverflow((long) i2)));
        hashMap.put("linkIpLocDur", Long.valueOf(checkValueOverflow(j2 - j8)));
        hashMap.put("sendGwDur", Long.valueOf(checkValueOverflow(j5 - j8)));
        hashMap.put("linkGwTimes", Long.valueOf(checkValueOverflow((long) i3)));
        hashMap.put("linkGwDur", Long.valueOf(checkValueOverflow(j3 - j8)));
        hashMap.put("sendGwEnterDur", Long.valueOf(checkValueOverflow(j6 - j8)));
        hashMap.put("innerDiff", Long.valueOf(checkValueOverflow(j6 - j7)));
        hashMap.put("totalDiff", Long.valueOf(System.currentTimeMillis() - this.mJoinChannelTimestamp));
        String str3 = str;
        hashMap.put("recvChannelName", str);
        hashMap.put("recvRoleType", Integer.valueOf(i));
        hashMap.put("enterStat", 1);
        buildJsonContent("enter_state", hashMap);
    }

    private void reportEnterTimeout(long j, int i, int i2, long j2, long j3, long j4, long j5, long j6, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("enterLiveTs", Long.valueOf(checkValueOverflow(j)));
        hashMap.put("serGwIp", str);
        hashMap.put("sendIpLocDur", Long.valueOf(checkValueOverflow(j4 - j)));
        hashMap.put("linkIpLocTimes", Long.valueOf(checkValueOverflow((long) i)));
        hashMap.put("linkIpLocDur", Long.valueOf(checkValueOverflow(j2 - j)));
        hashMap.put("sendGwDur", Long.valueOf(checkValueOverflow(j5 - j)));
        hashMap.put("linkGwTimes", Long.valueOf(checkValueOverflow((long) i2)));
        hashMap.put("linkGwDur", Long.valueOf(checkValueOverflow(j3 - j)));
        hashMap.put("sendGwEnterDur", Long.valueOf(checkValueOverflow(j6 - j)));
        hashMap.put("totalDiff", Long.valueOf(System.currentTimeMillis() - this.mJoinChannelTimestamp));
        hashMap.put("enterStat", 2);
        buildJsonContent("enter_state", hashMap);
    }

    private void ReportEnterFail(String str, int i, int i2, long j, int i3, int i4, long j2, long j3, long j4, long j5, long j6, long j7, String str2) {
        long j8 = j;
        HashMap hashMap = new HashMap();
        hashMap.put("enterLiveTs", Long.valueOf(checkValueOverflow(j)));
        hashMap.put("serGwIp", str2);
        hashMap.put("sendIpLocDur", Long.valueOf(checkValueOverflow(j4 - j8)));
        hashMap.put("linkIpLocTimes", Long.valueOf(checkValueOverflow((long) i3)));
        hashMap.put("linkIpLocDur", Long.valueOf(checkValueOverflow(j2 - j8)));
        hashMap.put("sendGwDur", Long.valueOf(checkValueOverflow(j5 - j8)));
        hashMap.put("linkGwTimes", Long.valueOf(checkValueOverflow((long) i4)));
        hashMap.put("linkGwDur", Long.valueOf(checkValueOverflow(j3 - j8)));
        hashMap.put("sendGwEnterDur", Long.valueOf(checkValueOverflow(j6 - j8)));
        hashMap.put("innerDiff", Long.valueOf(checkValueOverflow(j6 - j7)));
        hashMap.put("totalDiff", Long.valueOf(System.currentTimeMillis() - this.mJoinChannelTimestamp));
        String str3 = str;
        hashMap.put("recvChannelName", str);
        hashMap.put("recvRoleType", Integer.valueOf(i));
        hashMap.put("errorCode", Integer.valueOf(i2));
        hashMap.put("enterStat", 3);
        buildJsonContent("enter_state", hashMap);
    }

    private void reportMemberEnter(String str, long j, String str2, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("channelId", str);
        hashMap.put("memberId", Long.valueOf(j));
        hashMap.put("recv_roomId", str2);
        hashMap.put("roleType", Integer.valueOf(i));
        hashMap.put(Constant.PARAM_ERROR_CODE, 1);
        hashMap.put("stat", 0);
        buildJsonContent("member_state", hashMap);
    }

    private void reportMemberQuit(String str, long j, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("channelId", str);
        hashMap.put("memberId", Long.valueOf(j));
        hashMap.put("reason", Integer.valueOf(i));
        hashMap.put(Constant.PARAM_ERROR_CODE, 0);
        hashMap.put("stat", 0);
        buildJsonContent("member_state", hashMap);
    }

    public void reportVideoNoAVSend(boolean z, boolean z2, boolean z3) {
        HashMap hashMap = new HashMap();
        hashMap.put("audio", Integer.valueOf(booleanToInt(z)));
        hashMap.put("video", Integer.valueOf(booleanToInt(z2)));
        hashMap.put("audioRoom", Integer.valueOf(booleanToInt(z3)));
        buildJsonContent("no_av_data_send", hashMap);
    }

    private void reportMediaAddr(String str, int i, String str2, String str3, int i2, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("A_IP", str);
        hashMap.put("A_PORT", Integer.valueOf(i));
        hashMap.put("A_SID", str2);
        hashMap.put("V_IP", str3);
        hashMap.put("V_PORT", Integer.valueOf(i2));
        hashMap.put("V_SID", str4);
        buildJsonContent("media_addr", hashMap);
    }

    private void reportSignalDisconnect() {
        buildJsonContent("signal_lost", new HashMap());
    }

    private void reportReconnectTimeout() {
        buildJsonContent("reconnect_timeout", new HashMap());
    }

    private void reportConnectSuccess() {
        buildJsonContent("cb_connect_success", new HashMap());
    }

    public void ReportAuth(String str, String str2, String str3, boolean z, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("key", str2);
        hashMap.put("channelKey", str);
        if (GlobalConfig.mBranch != LocalSDKConstants.BRANCH_CLIENT_TC) {
            hashMap.put("url", str3);
        }
        hashMap.put("authType", GlobalConfig.mIsServerAuth ? "server_auth" : "http_auth");
        hashMap.put("authStatus", Integer.valueOf(booleanToInt(z)));
        hashMap.put("authResult", str4);
        buildJsonContent("auth", hashMap);
    }

    public void reportRenewKey(String str, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("key", str);
        hashMap.put("authType", GlobalConfig.mIsServerAuth ? "server_auth" : "http_auth");
        hashMap.put("isExiting", Integer.valueOf(booleanToInt(z)));
        buildJsonContent("renew_key", hashMap);
    }

    public void reportKeyExpired() {
        HashMap hashMap = new HashMap();
        hashMap.put("authType", GlobalConfig.mIsServerAuth ? "server_auth" : "http_auth");
        buildJsonContent("key_expired", hashMap);
    }

    public void reportCallBackSlowWarn(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("methodName", str);
        buildJsonContent("call_back_slow_warn", hashMap);
    }

    public void reportChannelMediaRelay2(Object[] objArr) {
        int i;
        MediaRelayInfo[] mediaRelayInfoArr;
        int length = objArr.length;
        MediaRelayInfo mediaRelayInfo = null;
        if (length == 1) {
            i = objArr[0].intValue();
            mediaRelayInfoArr = null;
        } else if (length == 2) {
            if (objArr[0] instanceof MediaRelayInfo) {
                i = objArr[1].intValue();
                mediaRelayInfo = objArr[0];
                mediaRelayInfoArr = null;
            } else if (objArr[0] instanceof MediaRelayInfo[]) {
                mediaRelayInfoArr = objArr[0];
                i = objArr[1].intValue();
            } else {
                OmniLog.e(TAG, "ARGS ERROR, Failed to report <channel_media_relay_2> event! First args = " + objArr[0]);
                return;
            }
        } else if (length == 3) {
            mediaRelayInfo = objArr[0];
            mediaRelayInfoArr = objArr[1];
            i = objArr[2].intValue();
        } else {
            OmniLog.e(TAG, "ARGS ERROR, Failed to report <channel_media_relay_2> event! args len = " + length);
            return;
        }
        try {
            JSONObject buildBaseContent = buildBaseContent("channel_media_relay_2");
            JSONObject jSONObject = new JSONObject();
            buildBaseContent.put(Constant.PARAM_ERROR_CODE, i);
            buildBaseContent.put("srcInfo", jSONObject);
            if (mediaRelayInfo != null) {
                jSONObject.put("channelName", mediaRelayInfo.mChannelId);
                jSONObject.put("token", mediaRelayInfo.mToken);
                jSONObject.put("uid", mediaRelayInfo.mUid);
            }
            JSONArray jSONArray = new JSONArray();
            buildBaseContent.put("dstInfo", jSONArray);
            if (mediaRelayInfoArr != null) {
                for (MediaRelayInfo mediaRelayInfo2 : mediaRelayInfoArr) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("channelName", mediaRelayInfo2.mChannelId);
                    jSONObject2.put("token", mediaRelayInfo2.mToken);
                    jSONObject2.put("uid", mediaRelayInfo2.mUid);
                    jSONArray.put(jSONObject2);
                }
            }
            sendJsonContent("channel_media_relay_2", buildBaseContent);
        } catch (JSONException e) {
            OmniLog.e(TAG, "Failed to report <channel_media_relay_2> event! exception = " + e.getLocalizedMessage());
        }
    }

    public void reportChannelMediaRelayState2(String str, String str2, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("relayId", str);
        hashMap.put("relaySrcRoomId", str2);
        hashMap.put("state", Integer.valueOf(i));
        hashMap.put(Constant.PARAM_ERROR, Integer.valueOf(i2));
        buildJsonContent("channel_media_relay_state_2", hashMap);
    }

    public void reportAudioRemoteFirstDecoded(long j, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("userid", Long.valueOf(j));
        hashMap.put("elapsed", Integer.valueOf(i));
        buildJsonContent("recv_fst_rmt_audio_dec", hashMap);
    }

    public void reportVideoEncParams(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", getFormatDateStr());
            jSONObject.put("aid", this.mAppId);
            jSONObject.put("rid", this.mChannelName);
            if (!TextUtils.isEmpty(this.mSessionId)) {
                jSONObject.put("sid", this.mSessionId);
            }
            jSONObject.put("userid", String.valueOf(this.mUid));
            jSONObject.put("cid", this.mConnectId);
            jSONObject.put("os", "Android_" + Build.MODEL);
            jSONObject.put("r", this.mRole);
            jSONObject.put("br", i / 1000);
            StringBuilder sb = new StringBuilder();
            sb.append("event=setVideoBR ");
            sb.append(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            sendJsonContent(sb.toString());
        } catch (Exception e) {
            String str = TAG;
            OmniLog.e(str, "buildJosnContent Exception : " + e.getLocalizedMessage());
        }
    }

    private void reportVideoUpstreamStuck(String str, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("mediaId", str);
        hashMap.put(Constant.PARAM_ERROR_CODE, Integer.valueOf(i));
        hashMap.put("dur", Integer.valueOf(i2));
        buildJsonContent("video_upstream_stuck", hashMap);
    }

    private void reportVideoDownstreamStuck(String str, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("mediaId", str);
        hashMap.put(Constant.PARAM_ERROR_CODE, Integer.valueOf(i));
        hashMap.put("dur", Integer.valueOf(i2));
        buildJsonContent("video_downstream_stuck", hashMap);
    }

    private void reportVideoRemoteFirstDecoded(String str, int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("deviceID", str);
        hashMap.put("width", Integer.valueOf(i));
        hashMap.put("height", Integer.valueOf(i2));
        hashMap.put("elapsed", Integer.valueOf(i3));
        buildJsonContent("recv_fst_rmt_video_dec", hashMap);
    }

    private void reportVideoRemoteFirstDran(String str, int i, int i2, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("deviceID", str);
        hashMap.put("width", Integer.valueOf(i));
        hashMap.put("height", Integer.valueOf(i2));
        hashMap.put("elapsed", Integer.valueOf(i3));
        buildJsonContent("cb_remote_video_first_draw", hashMap);
    }

    private void buildJsonContent(String str, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", getFormatDateStr());
            jSONObject.put("event", str);
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("uid", String.valueOf(this.mUid));
            jSONObject.put("roomStr", this.mChannelName);
            jSONObject.put("sid", this.mSessionId);
            jSONObject.put("connId", this.mConnectId);
            jSONObject.put("uosv", String.valueOf(Build.VERSION.SDK_INT));
            jSONObject.put("userDevInfo", "Android_" + Build.MODEL);
            jSONObject.put("uRole", this.mRole);
            jSONObject.put("sdkPublicVer", GlobalConfig.SDK_VERSION_NAME);
            jSONObject.put("sdkSignalVer", GlobalConfig.LOCAL_SDK_VERSION_NAME);
            jSONObject.put("logVersion", GlobalConfig.LOG_VERSION);
            if (map.size() > 0) {
                for (Map.Entry next : map.entrySet()) {
                    String str2 = (String) next.getKey();
                    Object value = next.getValue();
                    if (value instanceof Integer) {
                        jSONObject.put(str2, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        jSONObject.put(str2, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        jSONObject.put(str2, (double) ((Float) value).floatValue());
                    } else if (value instanceof Double) {
                        jSONObject.put(str2, ((Double) value).doubleValue());
                    } else if (value instanceof String) {
                        jSONObject.put(str2, (String) value);
                    } else if (value instanceof Boolean) {
                        jSONObject.put(str2, booleanToInt(((Boolean) value).booleanValue()));
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("event=");
            sb.append(str);
            sb.append(" ");
            sb.append(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            String sb2 = sb.toString();
            String str3 = TAG;
            OmniLog.i(OmniLog.LOG_WATCH, str3, "Report event >>> " + sb2);
            sendJsonContent(sb2);
        } catch (Exception e) {
            String str4 = TAG;
            OmniLog.e(str4, "buildJosnContent Exception : " + e.getLocalizedMessage());
        }
    }

    private JSONObject buildBaseContent(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("time", getFormatDateStr());
        jSONObject.put("event", str);
        jSONObject.put("appId", this.mAppId);
        jSONObject.put("uid", String.valueOf(this.mUid));
        jSONObject.put("roomStr", this.mChannelName);
        if (!TextUtils.isEmpty(this.mSessionId)) {
            jSONObject.put("sid", this.mSessionId);
        }
        jSONObject.put("connId", this.mConnectId);
        jSONObject.put("uosv", "Android_" + Build.MODEL);
        jSONObject.put("userDevInfo", Build.VERSION.RELEASE);
        jSONObject.put("uRole", this.mRole);
        jSONObject.put("sdkPublicVer", GlobalConfig.SDK_VERSION_NAME);
        jSONObject.put("sdkSignalVer", GlobalConfig.LOCAL_SDK_VERSION_NAME);
        jSONObject.put("logVersion", GlobalConfig.LOG_VERSION);
        return jSONObject;
    }

    private void sendJsonContent(String str) {
        BaseReportLogger.ReportLogMsg reportLogMsg = new BaseReportLogger.ReportLogMsg();
        reportLogMsg.logType = 16;
        reportLogMsg.logMsg = str;
        reportLogMsg.msgType = 0;
        SendLogMsg(reportLogMsg);
    }

    private void sendJsonContent(String str, JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        sb.append("event=");
        sb.append(str);
        sb.append(" ");
        sb.append(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
        String sb2 = sb.toString();
        String str2 = TAG;
        OmniLog.i(OmniLog.LOG_WATCH, str2, "Report event >>> " + sb2);
        BaseReportLogger.ReportLogMsg reportLogMsg = new BaseReportLogger.ReportLogMsg();
        reportLogMsg.logType = 16;
        reportLogMsg.logMsg = sb2;
        reportLogMsg.msgType = 0;
        SendLogMsg(reportLogMsg);
    }
}
