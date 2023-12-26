package com.eaydu.omni;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.didi.hummer.render.event.base.TraceEvent;
import com.eaydu.omni.fullLog.RtcSystemLogReport;
import com.eaydu.omni.gson.JsonObject;
import com.eaydu.omni.inspect.ContentInspectManager;
import com.eaydu.omni.listener.RTCConnectionStateType;
import com.eaydu.omni.log.CoreRtcLogUpload;
import com.eaydu.omni.log.LogCommonInfo;
import com.eaydu.omni.log.LogReport;
import com.eaydu.omni.logger.AndroidLogAdapter;
import com.eaydu.omni.logger.DiskLogAdapter;
import com.eaydu.omni.logger.Logger;
import com.eaydu.omni.logger.MemoryLogAdapter;
import com.eaydu.omni.net.okhttp3.Call;
import com.eaydu.omni.net.okhttp3.Callback;
import com.eaydu.omni.net.okhttp3.OkHttpClient;
import com.eaydu.omni.net.okhttp3.Request;
import com.eaydu.omni.net.okhttp3.Response;
import com.eaydu.omni.urls.UrlManager;
import com.eaydu.omni.utils.CommonUtils;
import com.eaydu.omni.utils.FilePathUtils;
import com.eaydu.omni.utils.HttpUtils;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.ServiceStarter;
import com.huawei.multimedia.audiokit.config.ResultCode;
import com.igexin.assist.control.fcm.GTJobService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public class RTCEngine {
    private static final String HTTP_MATADATE_URL = "http://media.xesv5.com/api/addHTTPPoint";
    private static final String RECORD_URL = "http://39.98.34.183:80";
    /* access modifiers changed from: private */
    public static final String TAG = "RTCEngine";
    private static final String TIME_INIT_URL = "https://time.xueersi.com/api/timestamp";
    private static CoreRtcLogUpload coreRtcLogUpload = null;
    private static boolean sHasLogInited = false;
    private String VERSION_SYS = EngineConfig.SDK_VERSION;
    /* access modifiers changed from: private */
    public TimerTask autoSeiTask = new TimerTask() {
        public void run() {
            if (!RTCEngine.this.isInitTimeStamp) {
                if (((float) RTCEngine.this.mSendTimestampNoServerTimes) > RTCEngine.this.mSendSEIFreq * 2.0f) {
                    if (RTCEngine.this.mRtcEngineEventListener != null) {
                        RTCEngine.this.mRtcEngineEventListener.didOccurError(RTCEngineErrorCode.RTCEngineErrorCodeNoServerTime);
                    }
                    int unused = RTCEngine.this.mSendTimestampNoServerTimes = 0;
                }
                RTCEngine.access$108(RTCEngine.this);
            } else if (RTCEngine.this.mBaseRtcEngine != null) {
                int timestamp = RTCEngine.this.mBaseRtcEngine.setTimestamp(System.currentTimeMillis() + RTCEngine.this.timeDifference);
                if (timestamp == 0) {
                    int unused2 = RTCEngine.this.mSendTimestampFailTimes = 0;
                } else if (timestamp < 0) {
                    if (((float) RTCEngine.this.mSendTimestampFailTimes) > RTCEngine.this.mSendSEIFreq * 10.0f) {
                        int unused3 = RTCEngine.this.mSendTimestampFailTimes = 0;
                        if (RTCEngine.this.mRtcEngineEventListener != null) {
                            RTCEngine.this.mRtcEngineEventListener.didOccurError(RTCEngineErrorCode.RTCEngineErrorCodeSEIFail);
                        }
                    }
                    RTCEngine.access$508(RTCEngine.this);
                }
            }
        }
    };
    private Timer autoSeiTimer;
    /* access modifiers changed from: private */
    public int initTimeCount = 0;
    /* access modifiers changed from: private */
    public boolean isInitTimeStamp;
    private boolean isReportImage;
    private boolean isUploadUserLog;
    private Application.ActivityLifecycleCallbacks lifecycleCallbacks = new Application.ActivityLifecycleCallbacks() {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (activity == RTCEngine.this.mContext && RTCEngine.this.mBaseRtcEngine != null) {
                RTCEngine.this.mBaseRtcEngine.setActivityState(0);
            }
        }

        public void onActivityStopped(Activity activity) {
            if (activity == RTCEngine.this.mContext && RTCEngine.this.mBaseRtcEngine != null) {
                RTCEngine.this.mBaseRtcEngine.setActivityState(1);
            }
        }
    };
    private String mAppid = "";
    protected BaseRtcEngine mBaseRtcEngine = null;
    /* access modifiers changed from: private */
    public Context mContext = null;
    private String mEngineReal = "";
    private EngineType mEngineType = EngineType.Agora;
    /* access modifiers changed from: private */
    public RtcSystemLogReport mFullLogReport = null;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private IRTCAudioObserver mIRTCAudioObserver = null;
    private IRTCMediaAudioProcess mIRTCMediaAudioProcess;
    private IRTCMediaVideoProcess mIRTCMediaVideoProcess;
    private String mRoomid = "";
    /* access modifiers changed from: private */
    public IRtcEngineEventListener mRtcEngineEventListener = null;
    /* access modifiers changed from: private */
    public RtcEngineEventObserver mRtcEngineEventObserver;
    /* access modifiers changed from: private */
    public float mSendSEIFreq = 0.0f;
    /* access modifiers changed from: private */
    public int mSendTimestampFailTimes = 0;
    /* access modifiers changed from: private */
    public int mSendTimestampNoServerTimes = 0;
    private Object mServerTimestampLock = new Object();
    private String mToken = "";
    private long mUserid;
    private String mcip = "";
    private OkHttpClient mhttpClient = null;
    protected LogReport mlogReport = null;
    private String mpsUserid = "";
    private String planId = "";
    private Timer reportTimer = null;
    /* access modifiers changed from: private */
    public long timeDifference;

    public interface ContentInspectListener {
        void onTakePreEncodeSnapshot(String str, int i, String str2, int i2, int i3, int i4);

        void onTakePreEncodeSnapshot(byte[] bArr);
    }

    public static class EnterConfig {
        public String appId;
        public EngineType engineType;
        public String planId;
        public String roomId;
        public String token;
        public long uid;
    }

    public interface IMetadataObserver {
        public static final int UNKNOWN_METADATA = -1;
        public static final int VIDEO_METADATA = 0;

        int getMaxMetadataSize();

        void onMetadataReceived(byte[] bArr, int i, long j);

        byte[] onReadyToSendMetadata(long j);
    }

    public static abstract class IRTCAudioObserver {
        public void onPlaybackAudioData(RTCPlayBackAudioFrame rTCPlayBackAudioFrame) {
        }
    }

    public interface IRTCMediaAudioProcess {
        void didCapturedAuidoData(RTCAudioData rTCAudioData);

        void didRenderAudioData(long j, RTCAudioData rTCAudioData);
    }

    public interface IRTCMediaVideoProcess {
        void didCapturedVideoData(RTCVideoData rTCVideoData);

        void didRenderVideoData(long j, RTCVideoData rTCVideoData);
    }

    public interface IRtcEngineEventListener {
        void connectionChangedToState(RTCConnectionStateType rTCConnectionStateType, String str);

        void didAudioMuted(long j, boolean z);

        void didOccurError(RTCEngineErrorCode rTCEngineErrorCode);

        void didOfflineOfUid(long j);

        void didVideoMuted(long j, boolean z);

        void localUserJoindWithUid(long j);

        void onOnceLastMileQuality(RTC_LASTMILE_QUALITY rtc_lastmile_quality);

        void onRemoteVideoStateChanged(long j, int i);

        void remoteUserJoinWitnUid(long j);

        void remotefirstAudioRecvWithUid(long j);

        void remotefirstVideoRecvWithUid(long j);

        void reportAudioVolumeOfSpeaker(long j, int i);

        void reportRtcStats(ReportRtcStats reportRtcStats);
    }

    public static class LocalAudioStats {
        public int audioFps;
        public int numChannels;
        public int rtt;
        public int sentBitrate;
        public int sentSampleRate;
        public int txPacketLossRate;
    }

    public static class LocalVideoStats {
        public int captureFrameRate;
        public int encodedBitrate;
        public int encodedFrameHeight;
        public int encodedFrameWidth;
        public int packetLossRate;
        public int rtt;
        public int sentBitrate;
        public int sentFrameRate;
        public int targetBitrate;
        public int targetFrameRate;
    }

    public static class RTCAudioData {
        public byte[] buffer;
        public int bufferLength;
        public int bytesPerSample;
        public int channels;
        public long renderTimeMs;
        public int samples;
        public int samplesPerSec;
    }

    public static class RTCAudioStats {
        public int audioLossRate;
        public int jitterBufferDelay;
        public int networkTransportDelay;
        public int uid;
    }

    public static class RTCBusinessLiveMode {
        public static final int RTCBusinessLiveModeStandardLive = 0;
        public static final int RTCBusinessLiveModeStandardRecord = 1;
    }

    public static class RTCCameraPosition {
        public static final int RTCCameraPositionBack = 1;
        public static final int RTCCameraPositionFront = 0;
    }

    public static class RTCConnectionChangedReason {
        public static final String RTCConnectionChangedBannedByServer = "banned by server";
        public static final String RTCConnectionChangedConnecting = "connecting";
        public static final String RTCConnectionChangedInterrupted = "interrupted";
        public static final String RTCConnectionChangedJoinFailed = "join failed";
        public static final String RTCConnectionChangedJoinSuccess = "join success";
        public static final String RTCConnectionChangedLeaveChannel = "leave channel";
        public static final String RTCConnectionChangedUnknown = "未知原因";
    }

    public static class RTCCreateEngineErrorReason {
        public static final String RTCCreateEngineErrorUnSupport = "unsupport";
    }

    public static class RTCHowlingMode {
        public static final int RTCHolingModeCheck = 1;
        public static final int RTCHolingModeDisable = 0;
        public static final int RTCHolingModeSuppression = 2;
    }

    public static class RTCPlayBackAudioFrame {
        public byte[] buffer;
        public int bufferLength;
        public int bytesPerSample;
        public int channels;
        public long renderTimeMs;
        public int samples;
        public int samplesPerSec;
    }

    public static class RTCPlayMusicState {
        public static final int ERROR = 3;
        public static final int PAUSED = 1;
        public static final int PLAY = 0;
        public static final int STOPPED = 2;
    }

    public static class RTCPushRtmpState {
        public static final int CONNECTING = 1;
        public static final int FAIL = 4;
        public static final int IDlE = 0;
        public static final int RECOVERING = 3;
        public static final int RUNNING = 2;
    }

    public static class RTCRtmpErrorCode {
        public static final int RTCRtmpErrorCodeCDNError = 151;
        public static final int RTCRtmpErrorCodeServerError = 154;
        public static final int RTCRtmpErrorCodeTimeOut = 10;
    }

    public static class RTCStreamApplyStreamType {
        public static final int RTCStreamApplyStreamTypeAudio = 2;
        public static final int RTCStreamApplyStreamTypeHigh = 0;
        public static final int RTCStreamApplyStreamTypeLow = 1;
    }

    public static class RTCStreamFallbackOption {
        public static final int RTCStreamTypeAudio = 2;
        public static final int RTCStreamTypeDisable = 0;
        public static final int RTCStreamTypeLow = 1;
    }

    public static class RTCVideoData {
        public byte[] data;
        public int height;
        public long renderTimeMs;
        public int rotation;
        public int uStride;
        public int vStride;
        public int width;
        public int yStride;
    }

    public static class RemoteAudioStats {
        public int audioFps;
        public int audioLossRate;
        public int avDiff;
        public int numChannels;
        public int quality;
        public int receivedBitrate;
        public int receivedSampleRate;
        public int rtt;
        public long uid;
    }

    public static class RemoteVideoStats {
        public int avDiff;
        public int decoderOutputFrameRate;
        @Deprecated
        public int delay;
        public int height;
        public int packetLossRate;
        public int receivedBitrate;
        public int rendererOutputFrameRate;
        public int rtt;
        public long uid;
        public int width;
    }

    public static abstract class RtcEngineEventObserver {
        public void didOfflineOfUid(long j, int i) {
        }

        public void onAudioStats(RTCAudioStats rTCAudioStats) {
        }

        public void onCaptureVideoSize(int i, int i2) {
        }

        public void onChannelMediaRelayEvent(int i) {
        }

        public void onChannelMediaRelayStateChanged(int i, int i2) {
        }

        public void onEngineChangeNotify() {
        }

        public void onEngineCreateError(int i, String str) {
        }

        /* access modifiers changed from: protected */
        public void onHttpMetadataStateStateChanged(String str, int i, int i2, int i3) {
        }

        public void onKick(int i) {
        }

        public void onLeaveChannel() {
        }

        public void onLocalAudioStateChanged(int i, int i2) {
        }

        public void onLocalAudioStats(LocalAudioStats localAudioStats) {
        }

        public void onLocalVideoStateChanged(int i, int i2) {
        }

        public void onLocalVideoStats(LocalVideoStats localVideoStats) {
        }

        public void onNetworkQuality(long j, int i, int i2) {
        }

        public void onPlayMusicSateChanged(int i, int i2) {
        }

        public void onPublishAudioStateChanged(int i, int i2) {
        }

        public void onPublishVideoStateChanged(int i, int i2) {
        }

        public void onRemoteAudioStats(RemoteAudioStats remoteAudioStats) {
        }

        public void onRemoteStreamSubscribeAdvice(long j, int i, int i2) {
        }

        public void onRemoteVideoStats(RemoteVideoStats remoteVideoStats) {
        }

        public void onRtmpStreamingStateChanged(String str, int i, int i2) {
        }

        public void onStreamMessage(long j, byte[] bArr) {
        }

        public void onStreamPublished(String str, int i) {
        }

        public void onStreamUnpublished(String str) {
        }

        public void onSubscribeAudioStateChanged(int i, int i2, int i3) {
        }

        public void onSubscribeVideoStateChanged(int i, int i2, int i3) {
        }

        public void onTakeLocalViewSnapshot(Bitmap bitmap) {
        }

        public void onTakeRemoteViewSnapshot(long j, Bitmap bitmap) {
        }

        public void onVideoBufferingStateChanged(long j, int i, long j2) {
        }

        public void reportAudioVolumeOfSpeaker(String str, long j, int i) {
        }
    }

    public String getErrorDes(int i) {
        if (i == 1) {
            return "RTCEngineErrorCodeInvalidToken";
        }
        if (i == 2) {
            return "RTCEngineErrorCodeTokenExpired";
        }
        if (i == 4) {
            return "RTCEngineErrorCodesAudioError";
        }
        if (i == 1109) {
            return "RTC_ERR_AUDIOTRACKOVERFLOW";
        }
        if (i == 6) {
            return "RTCEngineErrorCodeStartCamera";
        }
        if (i == 7) {
            return "RTCEngineErrorCodeStartVideoRender";
        }
        if (i == 10) {
            return "RTCEngineErrorCodeNoServerTime";
        }
        if (i == 11) {
            return "RTCEngineErrorCodeSEIFail";
        }
        switch (i) {
            case 1080:
                return "RTC_ERR_PUBLISH_FAILED";
            case 1081:
                return "RTC_ERR_REPUBLISH_FAILED";
            case 1082:
                return "RTC_ERR_SUBSCRIBE_FAILED";
            case 1083:
                return "RTC_ERR_RESUBSCRIBE_FAILED";
            case 1084:
                return "RTC_ERR_ROLE_FAILED";
            default:
                return "unKnown";
        }
    }

    static /* synthetic */ int access$108(RTCEngine rTCEngine) {
        int i = rTCEngine.mSendTimestampNoServerTimes;
        rTCEngine.mSendTimestampNoServerTimes = i + 1;
        return i;
    }

    static /* synthetic */ int access$508(RTCEngine rTCEngine) {
        int i = rTCEngine.mSendTimestampFailTimes;
        rTCEngine.mSendTimestampFailTimes = i + 1;
        return i;
    }

    static /* synthetic */ int access$908(RTCEngine rTCEngine) {
        int i = rTCEngine.initTimeCount;
        rTCEngine.initTimeCount = i + 1;
        return i;
    }

    public Context getmContext() {
        return this.mContext;
    }

    @Deprecated
    public EngineType getmEngineType() {
        return this.mEngineType;
    }

    /* access modifiers changed from: protected */
    public long getUserId() {
        return this.mUserid;
    }

    /* access modifiers changed from: protected */
    public String getAppId() {
        return this.mAppid;
    }

    public enum RTCRole {
        RTCRoleBroadcaster(1),
        RTCRoleAudience(2);
        
        private final int value;

        private RTCRole(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum RTCUserBusinessType {
        RTCUserBusinessTypeStudent(0),
        RTCUserBusinessTypeTeacher(1),
        RTCUserBusinessTypeTutor(2);
        
        private final int value;

        private RTCUserBusinessType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum RTCEngineErrorCode {
        RTCEngineErrorCodeInvalidToken(1),
        RTCEngineErrorCodeTokenExpired(2),
        RTCEngineErrorCodesAudioError(4),
        RTCEngineErrorCodeStartCamera(6),
        RTCEngineErrorCodeStartVideoRender(7),
        RTCEngineErrorCodeNoServerTime(10),
        RTCEngineErrorCodeSEIFail(11),
        RTC_ERR_PUBLISH_FAILED(1080),
        RTC_ERR_REPUBLISH_FAILED(1081),
        RTC_ERR_SUBSCRIBE_FAILED(1082),
        RTC_ERR_RESUBSCRIBE_FAILED(1083),
        RTC_ERR_AUDIOTRACKOVERFLOW(1109),
        RTC_ERR_ROLE_FAILED(1084),
        RTC_ERR_TOKEN_ENGINE_TYPE_ERROR(1088),
        RTC_ERR_HOWLING(14);
        
        private final int value;

        private RTCEngineErrorCode(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum EngineType {
        Agora(1),
        Tencent(2),
        OMNI(7),
        VOLC(8);
        
        /* access modifiers changed from: private */
        public final int value;

        private EngineType(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum RTCFeature {
        FeatureAudioBeauty(ServiceStarter.ERROR_UNKNOWN);
        
        private final int value;

        private RTCFeature(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum RTC_LASTMILE_QUALITY {
        RTC_QUALITY_UNKNOWN(0),
        RTC_QUALITY_EXCELLENT(1),
        RTC_QUALITY_GOOD(2),
        RTC_QUALITY_POOR(3),
        RTC_QUALITY_BAD(4),
        RTC_QUALITY_VBAD(5),
        RTC_QUALITY_DOWN(6),
        RTC_QUALITY_DETECTING(8);
        
        private int value;

        private RTC_LASTMILE_QUALITY(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum RTC_ORIENTATION_MODE {
        RTC_ORIENTATION_MODE_ADAPTIVE(0),
        RTC_ORIENTATION_MODE_FIXED_LANDSCAPE(1),
        RTC_ORIENTATION_MODE_FIXED_PORTRAIT(2);
        
        private int value;

        private RTC_ORIENTATION_MODE(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum RTCEngineLogLevel {
        RTCENGINE_LOG_FILTER_DEBUG(2063),
        RTCENGINE_LOG_FILTER_INFO(15),
        RTCENGINE_LOG_FILTER_WARNING(14),
        RTCENGINE_LOG_FILTER_ERROR(12),
        RTCENGINE_LOG_FILTER_CRITICAL(8),
        RTCENGINE_LOG_FILTER_OFF(0);
        
        private int value;

        private RTCEngineLogLevel(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum RTCEngineVideoBitrate {
        VIDEO_BITRATE_100(100),
        VIDEO_BITRATE_200(200),
        VIDEO_BITRATE_350(350),
        VIDEO_BITRATE_400(400),
        VIDEO_BITRATE_600(600),
        VIDEO_BITRATE_1000(ResultCode.KARAOKE_SUCCESS);
        
        private final int value;

        private RTCEngineVideoBitrate(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum RTCVideoRenderMode {
        RTCVideoRenderModeHidden(1),
        RTCVideoRenderModeFit(2);
        
        private final int value;

        private RTCVideoRenderMode(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum RTCAudioMode {
        Mode_Default(0),
        Mode_Call(1),
        Mode_Music(2);
        
        private final int value;

        private RTCAudioMode(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum RawAudioFrameOpMode {
        MODE_READ_ONLY(0),
        MODE_WRITE_ONLY(1),
        MODE_READ_WRITE(2);
        
        private final int value;

        private RawAudioFrameOpMode(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum RTCVideoFrameRate {
        FRAME_RATE_FPS_1(1),
        FRAME_RATE_FPS_7(7),
        FRAME_RATE_FPS_10(10),
        FRAME_RATE_FPS_15(15),
        FRAME_RATE_FPS_24(24),
        FRAME_RATE_FPS_30(30);
        
        private int value;

        private RTCVideoFrameRate(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum RTCAppState {
        APP_STATE_FOREGROUND(0),
        APP_STATE_BACKGROUND(1);
        
        private int value;

        private RTCAppState(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static class RTCChannelMediaInfo {
        public String token = null;

        public RTCChannelMediaInfo(String str) {
            this.token = str;
        }

        public String toString() {
            return "RTCChannelMediaInfo{token='" + this.token + '\'' + '}';
        }
    }

    public static class RTCChannelMediaRelayConfiguration {
        private RTCChannelMediaInfo[] destInfos;
        private RTCChannelMediaInfo srcInfo;

        public RTCChannelMediaRelayConfiguration() {
            this.srcInfo = null;
            this.destInfos = null;
            this.srcInfo = new RTCChannelMediaInfo((String) null);
        }

        public void setSrcChannelInfo(RTCChannelMediaInfo rTCChannelMediaInfo) {
            this.srcInfo = rTCChannelMediaInfo;
        }

        public void setDestChannelInfo(RTCChannelMediaInfo[] rTCChannelMediaInfoArr) {
            this.destInfos = rTCChannelMediaInfoArr;
        }

        public RTCChannelMediaInfo getSrcChannelMediaInfo() {
            return this.srcInfo;
        }

        public RTCChannelMediaInfo[] getDestChannelMediaInfos() {
            return this.destInfos;
        }

        public String toString() {
            return "RTCChannelMediaRelayConfiguration{srcInfo=" + this.srcInfo + ", destInfos=" + Arrays.toString(this.destInfos) + '}';
        }
    }

    public static class RTCRtmpConfig {
        public int audioChannel;
        public int audioSampleRate;
        public int backgroundColor = -1;
        public RTCRtmpBackGroundImage backgroundImage;
        public int fps;
        public int gop;
        public int height;
        public final List<RTCRtmpUser> users = new ArrayList();
        public int videoBitrate;
        public int width;

        public String toString() {
            return "RTCRtmpConfig{audioChannel=" + this.audioChannel + ", audioSampleRate=" + this.audioSampleRate + ", width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", gop=" + this.gop + ", videoBitrate=" + this.videoBitrate + ", backgroundImage=" + this.backgroundImage + ", backgroundColor=" + this.backgroundColor + ", users=" + Arrays.toString(this.users.toArray()) + '}';
        }
    }

    public static class RTCRtmpBackGroundImage {
        public int height;
        public String url;
        public int width;
        public int x;
        public int y;

        public String toString() {
            return "RTCRtmpBackGroundImage{url='" + this.url + '\'' + ", x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + '}';
        }
    }

    public static class RTCRtmpUser {
        public int height;
        public int uid;
        public int width;
        public int x;
        public int y;
        public int zorder;

        public String toString() {
            return "RTCRtmpUser{uid=" + (((long) this.uid) & 4294967295L) + ", x=" + this.x + ", y=" + this.y + ", zorder=" + this.zorder + ", width=" + this.width + ", height=" + this.height + '}';
        }
    }

    public static class ReportRtcStats {
        public double cpuAppUsage;
        public double cpuTotalUsage;
        public int gateWayRtt;
        public int lastmileDelay;
        public int rxAudioBytes;
        public int rxAudioKBitRate;
        public double rxPacketsLostRate;
        public int rxVideoBytes;
        public int rxVideoKBitRate;
        public int txAudioBytes;
        public int txAudioKBitRate;
        public double txPacketsLostRate;
        public int txVideoBytes;
        public int txVideoKBitRate;

        public String toString() {
            return "ReportRtcStats{txAudioBytes=" + this.txAudioBytes + ", txVideoBytes=" + this.txVideoBytes + ", rxAudioBytes=" + this.rxAudioBytes + ", rxVideoBytes=" + this.rxVideoBytes + ", txAudioKBitRate=" + this.txAudioKBitRate + ", rxAudioKBitRate=" + this.rxAudioKBitRate + ", txVideoKBitRate=" + this.txVideoKBitRate + ", rxVideoKBitRate=" + this.rxVideoKBitRate + ", cpuTotalUsage=" + this.cpuTotalUsage + ", cpuAppUsage=" + this.cpuAppUsage + ", txPacketsLostRate=" + this.txPacketsLostRate + ", rxPacketsLostRate=" + this.rxPacketsLostRate + '}';
        }
    }

    public static class InspectMode {
        public static final int AICheck = 2;
        public static final int PornCheck = 1;
        public int mode;
        public int rate = 1;

        public String toString() {
            return "InspectMode{ rate = " + this.rate + " mode = " + this.mode + "}";
        }
    }

    private static synchronized void addLog(boolean z) {
        synchronized (RTCEngine.class) {
            if (!sHasLogInited) {
                sHasLogInited = true;
                Logger.clearLogAdapters();
                Logger.addLogAdapter(new MemoryLogAdapter());
                if (z) {
                    Logger.addLogAdapter(new DiskLogAdapter());
                    Logger.addLogAdapter(new AndroidLogAdapter());
                }
            }
            Logger.i("==========new engine create=========", new Object[0]);
        }
    }

    private void initLogManager() {
        if (this.mlogReport == null) {
            this.mEngineReal = EngineConfig.getEngineReportName(this.mEngineType);
            LogReport logReport = new LogReport(this.mContext);
            this.mlogReport = logReport;
            logReport.initWithParam(this.mRoomid, this.mUserid, this.mEngineReal, this.VERSION_SYS, this.mAppid, this.mpsUserid, this.mcip, UrlManager.getInstance().getUrlKibana(), this.planId, this.mEngineType.getValue());
        }
        if (this.mFullLogReport == null) {
            RtcSystemLogReport rtcSystemLogReport = new RtcSystemLogReport(this.mContext);
            this.mFullLogReport = rtcSystemLogReport;
            rtcSystemLogReport.mUid = this.mUserid;
            RtcSystemLogReport rtcSystemLogReport2 = this.mFullLogReport;
            rtcSystemLogReport2.mRtcLog = this.mAppid + "_RTC";
        }
        FilePathUtils.setLogRootPath(this.mContext.getExternalFilesDir((String) null).getAbsolutePath());
        if (this.isUploadUserLog) {
            if (coreRtcLogUpload == null) {
                coreRtcLogUpload = new CoreRtcLogUpload();
            }
            if (!coreRtcLogUpload.isRun()) {
                coreRtcLogUpload.start(this.mUserid, this.mAppid, this.mRoomid);
            }
        }
        if (this.reportTimer == null) {
            Timer timer = new Timer();
            this.reportTimer = timer;
            timer.schedule(new TimerTask() {
                public void run() {
                    RTCEngine.this.mFullLogReport.updateClientLogPostUrl();
                    RTCEngine.this.mFullLogReport.uploadHistroy();
                    Log.d(RTCEngine.TAG, "mFullLogReport====================");
                }
            }, 0, GTJobService.WAIT_TIME);
        }
    }

    public RTCEngine(Context context, IRtcEngineEventListener iRtcEngineEventListener) {
        this.mContext = context;
        this.mRtcEngineEventListener = iRtcEngineEventListener;
        addLog(CommonUtils.isApkInDebug(context));
        initHttpClient();
    }

    @Deprecated
    public RTCEngine(Context context) {
        this.mContext = context;
        addLog(CommonUtils.isApkInDebug(context));
        initHttpClient();
    }

    private void initHttpClient() {
        if (this.mhttpClient == null) {
            this.mhttpClient = HttpUtils.getHttpClient();
        }
    }

    public void setAppState(RTCAppState rTCAppState) {
        if (this.mBaseRtcEngine == null) {
            return;
        }
        if (rTCAppState == RTCAppState.APP_STATE_FOREGROUND) {
            this.mBaseRtcEngine.setActivityState(0);
        } else {
            this.mBaseRtcEngine.setActivityState(1);
        }
    }

    private void registerActivityObserver() {
        Context context = this.mContext;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().registerActivityLifecycleCallbacks(this.lifecycleCallbacks);
        }
    }

    private void unregisterActivityObserver() {
        Context context = this.mContext;
        if (context instanceof Activity) {
            ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this.lifecycleCallbacks);
        }
    }

    @Deprecated
    public void setRtcEngineEventListener(IRtcEngineEventListener iRtcEngineEventListener) {
        this.mRtcEngineEventListener = iRtcEngineEventListener;
    }

    public void setRtcEngineEventObserver(RtcEngineEventObserver rtcEngineEventObserver) {
        this.mRtcEngineEventObserver = rtcEngineEventObserver;
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.setObserver(rtcEngineEventObserver);
        }
    }

    public void setAudioObserver(IRTCAudioObserver iRTCAudioObserver) {
        this.mIRTCAudioObserver = iRTCAudioObserver;
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.setPlayBackAudioObserver(iRTCAudioObserver);
        }
    }

    public void setMediaVideoProcessListener(IRTCMediaVideoProcess iRTCMediaVideoProcess) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.setMediaVideoProcessListener(iRTCMediaVideoProcess);
        }
        this.mIRTCMediaVideoProcess = iRTCMediaVideoProcess;
    }

    public int setMediaVideoProcessOptions(boolean z, boolean z2) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            return baseRtcEngine.setMediaVideoProcessOptions(z, z2);
        }
        return -1;
    }

    public void setMediaAudioProcessListener(IRTCMediaAudioProcess iRTCMediaAudioProcess) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.setMediaAudioProcessListener(iRTCMediaAudioProcess);
        }
        this.mIRTCMediaAudioProcess = iRTCMediaAudioProcess;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e5, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int realInit(boolean r7, java.lang.String r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            int[] r0 = com.eaydu.omni.EngineConfig.EXPORT_SO_ENGINES     // Catch:{ all -> 0x00e6 }
            r1 = 0
            if (r0 == 0) goto L_0x0020
            int[] r0 = com.eaydu.omni.EngineConfig.EXPORT_SO_ENGINES     // Catch:{ all -> 0x00e6 }
            int r0 = r0.length     // Catch:{ all -> 0x00e6 }
            if (r0 <= 0) goto L_0x0020
            int[] r0 = com.eaydu.omni.EngineConfig.EXPORT_SO_ENGINES     // Catch:{ all -> 0x00e6 }
            int r2 = r0.length     // Catch:{ all -> 0x00e6 }
            r3 = r1
        L_0x000f:
            if (r3 >= r2) goto L_0x0020
            r4 = r0[r3]     // Catch:{ all -> 0x00e6 }
            com.eaydu.omni.RTCEngine$EngineType r5 = r6.mEngineType     // Catch:{ all -> 0x00e6 }
            int r5 = r5.getValue()     // Catch:{ all -> 0x00e6 }
            if (r4 != r5) goto L_0x001d
            r0 = 1
            goto L_0x0021
        L_0x001d:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x0020:
            r0 = r1
        L_0x0021:
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = com.eaydu.omni.ExternalConfig.LibraryLoadPath     // Catch:{ all -> 0x00e6 }
            if (r0 == 0) goto L_0x003e
            java.lang.String r0 = com.eaydu.omni.ExternalConfig.LibraryLoadPath     // Catch:{ all -> 0x00e6 }
            java.lang.String r2 = ""
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x00e6 }
            if (r0 == 0) goto L_0x0032
            goto L_0x003e
        L_0x0032:
            com.eaydu.omni.RTCEngine$EngineType r0 = r6.mEngineType     // Catch:{ all -> 0x00e6 }
            java.lang.String r2 = com.eaydu.omni.ExternalConfig.LibraryLoadPath     // Catch:{ all -> 0x00e6 }
            int r0 = com.eaydu.omni.BaseFactory.externalSoLoad(r0, r2)     // Catch:{ all -> 0x00e6 }
            if (r0 == 0) goto L_0x0041
            monitor-exit(r6)
            return r0
        L_0x003e:
            r7 = -4
            monitor-exit(r6)
            return r7
        L_0x0041:
            com.eaydu.omni.BaseRtcEngine r0 = r6.mBaseRtcEngine     // Catch:{ all -> 0x00e6 }
            if (r0 != 0) goto L_0x0091
            r6.initLogManager()     // Catch:{ all -> 0x00e6 }
            com.eaydu.omni.BaseFactory$Builder r7 = com.eaydu.omni.BaseFactory.builder()     // Catch:{ all -> 0x00e6 }
            android.content.Context r0 = r6.mContext     // Catch:{ all -> 0x00e6 }
            com.eaydu.omni.BaseFactory$Builder r7 = r7.setContext(r0)     // Catch:{ all -> 0x00e6 }
            com.eaydu.omni.RTCEngine$IRtcEngineEventListener r0 = r6.mRtcEngineEventListener     // Catch:{ all -> 0x00e6 }
            com.eaydu.omni.BaseFactory$Builder r7 = r7.setListener(r0)     // Catch:{ all -> 0x00e6 }
            java.lang.String r0 = r6.mAppid     // Catch:{ all -> 0x00e6 }
            com.eaydu.omni.BaseFactory$Builder r7 = r7.setAppid(r0)     // Catch:{ all -> 0x00e6 }
            java.lang.String r0 = r6.mRoomid     // Catch:{ all -> 0x00e6 }
            com.eaydu.omni.BaseFactory$Builder r7 = r7.setRoomid(r0)     // Catch:{ all -> 0x00e6 }
            java.lang.String r0 = r6.mToken     // Catch:{ all -> 0x00e6 }
            com.eaydu.omni.BaseFactory$Builder r7 = r7.setToken(r0)     // Catch:{ all -> 0x00e6 }
            com.eaydu.omni.RTCEngine$EngineType r0 = r6.mEngineType     // Catch:{ all -> 0x00e6 }
            com.eaydu.omni.BaseFactory$Builder r7 = r7.setType(r0)     // Catch:{ all -> 0x00e6 }
            long r2 = r6.mUserid     // Catch:{ all -> 0x00e6 }
            com.eaydu.omni.BaseFactory$Builder r7 = r7.setUserid(r2)     // Catch:{ all -> 0x00e6 }
            com.eaydu.omni.BaseFactory$Builder r7 = r7.setmSourceToken(r8)     // Catch:{ all -> 0x00e6 }
            com.eaydu.omni.log.LogReport r8 = r6.mlogReport     // Catch:{ all -> 0x00e6 }
            com.eaydu.omni.BaseFactory$Builder r7 = r7.setMlogReport(r8)     // Catch:{ all -> 0x00e6 }
            java.lang.String r8 = r6.planId     // Catch:{ all -> 0x00e6 }
            com.eaydu.omni.BaseFactory$Builder r7 = r7.setPlanId(r8)     // Catch:{ all -> 0x00e6 }
            com.eaydu.omni.BaseRtcEngine r7 = r7.crteateEngine()     // Catch:{ all -> 0x00e6 }
            r6.mBaseRtcEngine = r7     // Catch:{ all -> 0x00e6 }
            if (r7 != 0) goto L_0x00c0
            r7 = -2
            monitor-exit(r6)
            return r7
        L_0x0091:
            if (r7 == 0) goto L_0x00aa
            com.eaydu.omni.log.LogReport r7 = r6.mlogReport     // Catch:{ all -> 0x00e6 }
            if (r7 == 0) goto L_0x009c
            java.lang.String r8 = r6.mRoomid     // Catch:{ all -> 0x00e6 }
            r7.setRoomid(r8)     // Catch:{ all -> 0x00e6 }
        L_0x009c:
            com.eaydu.omni.BaseRtcEngine r7 = r6.mBaseRtcEngine     // Catch:{ all -> 0x00e6 }
            java.lang.String r8 = r6.mRoomid     // Catch:{ all -> 0x00e6 }
            r7.setRoomId(r8)     // Catch:{ all -> 0x00e6 }
            com.eaydu.omni.BaseRtcEngine r7 = r6.mBaseRtcEngine     // Catch:{ all -> 0x00e6 }
            java.lang.String r8 = r6.mToken     // Catch:{ all -> 0x00e6 }
            r7.setToken(r8)     // Catch:{ all -> 0x00e6 }
        L_0x00aa:
            com.eaydu.omni.BaseRtcEngine r7 = r6.mBaseRtcEngine     // Catch:{ all -> 0x00e6 }
            int r7 = r7.getEngineType()     // Catch:{ all -> 0x00e6 }
            com.eaydu.omni.RTCEngine$EngineType r8 = r6.mEngineType     // Catch:{ all -> 0x00e6 }
            int r8 = r8.getValue()     // Catch:{ all -> 0x00e6 }
            if (r7 == r8) goto L_0x00c0
            com.eaydu.omni.RTCEngine$RTCEngineErrorCode r7 = com.eaydu.omni.RTCEngine.RTCEngineErrorCode.RTC_ERR_TOKEN_ENGINE_TYPE_ERROR     // Catch:{ all -> 0x00e6 }
            int r7 = r7.getValue()     // Catch:{ all -> 0x00e6 }
            monitor-exit(r6)
            return r7
        L_0x00c0:
            com.eaydu.omni.RTCEngine$RtcEngineEventObserver r7 = r6.mRtcEngineEventObserver     // Catch:{ all -> 0x00e6 }
            if (r7 == 0) goto L_0x00c9
            com.eaydu.omni.BaseRtcEngine r8 = r6.mBaseRtcEngine     // Catch:{ all -> 0x00e6 }
            r8.setObserver(r7)     // Catch:{ all -> 0x00e6 }
        L_0x00c9:
            com.eaydu.omni.RTCEngine$IRTCAudioObserver r7 = r6.mIRTCAudioObserver     // Catch:{ all -> 0x00e6 }
            if (r7 == 0) goto L_0x00d2
            com.eaydu.omni.BaseRtcEngine r8 = r6.mBaseRtcEngine     // Catch:{ all -> 0x00e6 }
            r8.setPlayBackAudioObserver(r7)     // Catch:{ all -> 0x00e6 }
        L_0x00d2:
            com.eaydu.omni.RTCEngine$IRTCMediaVideoProcess r7 = r6.mIRTCMediaVideoProcess     // Catch:{ all -> 0x00e6 }
            if (r7 == 0) goto L_0x00db
            com.eaydu.omni.BaseRtcEngine r8 = r6.mBaseRtcEngine     // Catch:{ all -> 0x00e6 }
            r8.setMediaVideoProcessListener(r7)     // Catch:{ all -> 0x00e6 }
        L_0x00db:
            com.eaydu.omni.RTCEngine$IRTCMediaAudioProcess r7 = r6.mIRTCMediaAudioProcess     // Catch:{ all -> 0x00e6 }
            if (r7 == 0) goto L_0x00e4
            com.eaydu.omni.BaseRtcEngine r8 = r6.mBaseRtcEngine     // Catch:{ all -> 0x00e6 }
            r8.setMediaAudioProcessListener(r7)     // Catch:{ all -> 0x00e6 }
        L_0x00e4:
            monitor-exit(r6)
            return r1
        L_0x00e6:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.RTCEngine.realInit(boolean, java.lang.String):int");
    }

    /* access modifiers changed from: protected */
    public synchronized int initWithToken(String str, boolean z) {
        int i;
        if (!z) {
            if (this.mBaseRtcEngine != null) {
                Logger.e("RTCEngine initWithToken subChannel want create but has created!", new Object[0]);
                return -1;
            }
        }
        try {
            i = parseToken(str);
        } catch (Exception e) {
            e.printStackTrace();
            i = -3;
        }
        if (i == 0) {
            i = realInit(z, str);
        }
        Logger.i("RTCEngine initWithToken isMain = : " + z + ", token =" + str + " result:" + i, new Object[0]);
        return i;
    }

    public int initWithToken(String str) {
        return initWithToken(str, true);
    }

    @Deprecated
    public int init(EngineType engineType, long j, String str, String str2) {
        this.mEngineType = engineType;
        this.mAppid = str;
        this.mRoomid = str2;
        this.mUserid = j;
        if (!CommonUtils.checkRoomID(str2)) {
            return -64;
        }
        return realInit(true, "");
    }

    public int init(EnterConfig enterConfig) {
        if (enterConfig == null) {
            return -1;
        }
        this.mEngineType = enterConfig.engineType;
        this.mAppid = enterConfig.appId;
        this.mRoomid = enterConfig.roomId;
        this.mUserid = enterConfig.uid;
        this.planId = enterConfig.planId;
        if (!CommonUtils.checkRoomID(this.mRoomid)) {
            return -64;
        }
        return realInit(true, enterConfig.token);
    }

    /* access modifiers changed from: private */
    public void initTime() {
        final long currentTimeMillis = System.currentTimeMillis();
        this.mhttpClient.newCall(new Request.Builder().url(TIME_INIT_URL).build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
            }

            public void onResponse(Call call, Response response) throws IOException {
                long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                if (currentTimeMillis > 500) {
                    RTCEngine.access$908(RTCEngine.this);
                    if (RTCEngine.this.initTimeCount < 3) {
                        RTCEngine.this.initTime();
                    } else if (RTCEngine.this.mRtcEngineEventListener != null) {
                        int unused = RTCEngine.this.initTimeCount = 0;
                        RTCEngine.this.mRtcEngineEventListener.didOccurError(RTCEngineErrorCode.RTCEngineErrorCodeNoServerTime);
                    }
                } else {
                    int unused2 = RTCEngine.this.initTimeCount = 0;
                    try {
                        JSONObject jSONObject = new JSONObject(response.body().string());
                        if (jSONObject.has(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
                            if (jSONObject2.has(TraceEvent.TIMESTAMP)) {
                                long parseLong = Long.parseLong(jSONObject2.getString(TraceEvent.TIMESTAMP));
                                if (!RTCEngine.this.isInitTimeStamp) {
                                    long unused3 = RTCEngine.this.timeDifference = (parseLong + (currentTimeMillis / 2)) - System.currentTimeMillis();
                                    boolean unused4 = RTCEngine.this.isInitTimeStamp = true;
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int parseToken(java.lang.String r9) {
        /*
            r8 = this;
            com.eaydu.omni.jwt.JWT r0 = new com.eaydu.omni.jwt.JWT
            r0.<init>(r9)
            java.util.Map r9 = r0.getClaims()
            java.lang.String r0 = "roomStr"
            java.lang.Object r0 = r9.get(r0)
            com.eaydu.omni.jwt.Claim r0 = (com.eaydu.omni.jwt.Claim) r0
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = r0.asString()
            r8.mRoomid = r0
        L_0x0019:
            java.lang.String r0 = r8.mRoomid
            boolean r0 = com.eaydu.omni.utils.CommonUtils.checkRoomID(r0)
            if (r0 != 0) goto L_0x0024
            r9 = -64
            return r9
        L_0x0024:
            java.lang.String r0 = "attachToken"
            java.lang.Object r0 = r9.get(r0)
            com.eaydu.omni.jwt.Claim r0 = (com.eaydu.omni.jwt.Claim) r0
            if (r0 == 0) goto L_0x0035
            java.lang.String r0 = r0.asString()
            r8.mToken = r0
            goto L_0x0045
        L_0x0035:
            java.lang.String r0 = "token"
            java.lang.Object r0 = r9.get(r0)
            com.eaydu.omni.jwt.Claim r0 = (com.eaydu.omni.jwt.Claim) r0
            if (r0 == 0) goto L_0x0045
            java.lang.String r0 = r0.asString()
            r8.mToken = r0
        L_0x0045:
            java.lang.String r0 = "attachAppid"
            java.lang.Object r0 = r9.get(r0)
            com.eaydu.omni.jwt.Claim r0 = (com.eaydu.omni.jwt.Claim) r0
            if (r0 == 0) goto L_0x0056
            java.lang.String r0 = r0.asString()
            r8.mAppid = r0
            goto L_0x0066
        L_0x0056:
            java.lang.String r0 = "appid"
            java.lang.Object r0 = r9.get(r0)
            com.eaydu.omni.jwt.Claim r0 = (com.eaydu.omni.jwt.Claim) r0
            if (r0 == 0) goto L_0x0066
            java.lang.String r0 = r0.asString()
            r8.mAppid = r0
        L_0x0066:
            java.lang.String r0 = "psuser"
            java.lang.Object r0 = r9.get(r0)
            com.eaydu.omni.jwt.Claim r0 = (com.eaydu.omni.jwt.Claim) r0
            if (r0 == 0) goto L_0x0076
            java.lang.String r0 = r0.asString()
            r8.mpsUserid = r0
        L_0x0076:
            java.lang.String r0 = "user"
            java.lang.Object r0 = r9.get(r0)
            com.eaydu.omni.jwt.Claim r0 = (com.eaydu.omni.jwt.Claim) r0
            if (r0 == 0) goto L_0x008a
            java.lang.String r0 = r0.asString()
            long r0 = java.lang.Long.parseLong(r0)
            r8.mUserid = r0
        L_0x008a:
            java.lang.String r0 = "ip"
            java.lang.Object r0 = r9.get(r0)
            com.eaydu.omni.jwt.Claim r0 = (com.eaydu.omni.jwt.Claim) r0
            if (r0 == 0) goto L_0x009a
            java.lang.String r0 = r0.asString()
            r8.mcip = r0
        L_0x009a:
            java.lang.String r0 = "planid"
            java.lang.Object r0 = r9.get(r0)
            com.eaydu.omni.jwt.Claim r0 = (com.eaydu.omni.jwt.Claim) r0
            if (r0 == 0) goto L_0x00aa
            java.lang.String r0 = r0.asString()
            r8.planId = r0
        L_0x00aa:
            java.lang.String r0 = "uploadLogLevel"
            java.lang.Object r0 = r9.get(r0)
            com.eaydu.omni.jwt.Claim r0 = (com.eaydu.omni.jwt.Claim) r0
            if (r0 == 0) goto L_0x00be
            java.lang.Integer r0 = r0.asInt()
            int r0 = r0.intValue()
            com.eaydu.omni.EngineConfig.LogLevelConfig = r0
        L_0x00be:
            java.lang.String r0 = "isUserLog"
            java.lang.Object r0 = r9.get(r0)
            com.eaydu.omni.jwt.Claim r0 = (com.eaydu.omni.jwt.Claim) r0
            if (r0 == 0) goto L_0x00d2
            java.lang.Boolean r0 = r0.asBoolean()
            boolean r0 = r0.booleanValue()
            r8.isUploadUserLog = r0
        L_0x00d2:
            java.lang.String r0 = "reportImage"
            java.lang.Object r0 = r9.get(r0)
            com.eaydu.omni.jwt.Claim r0 = (com.eaydu.omni.jwt.Claim) r0
            if (r0 == 0) goto L_0x00e6
            java.lang.Boolean r0 = r0.asBoolean()
            boolean r0 = r0.booleanValue()
            r8.isReportImage = r0
        L_0x00e6:
            r0 = -1
            java.lang.String r1 = "type"
            java.lang.Object r1 = r9.get(r1)
            com.eaydu.omni.jwt.Claim r1 = (com.eaydu.omni.jwt.Claim) r1
            r2 = 0
            if (r1 == 0) goto L_0x011e
            java.lang.Integer r0 = r1.asInt()
            int r0 = r0.intValue()
            com.eaydu.omni.RTCEngine$EngineType[] r1 = com.eaydu.omni.RTCEngine.EngineType.values()
            int r3 = r1.length
            r4 = r2
        L_0x0100:
            if (r4 >= r3) goto L_0x010f
            r5 = r1[r4]
            int r6 = r5.value
            if (r6 != r0) goto L_0x010c
            r8.mEngineType = r5
        L_0x010c:
            int r4 = r4 + 1
            goto L_0x0100
        L_0x010f:
            int[] r1 = com.eaydu.omni.EngineConfig.SUPPORT_ENGINES
            int r3 = r1.length
            r4 = r2
        L_0x0113:
            if (r4 >= r3) goto L_0x011e
            r5 = r1[r4]
            if (r5 != r0) goto L_0x011b
            r1 = 1
            goto L_0x011f
        L_0x011b:
            int r4 = r4 + 1
            goto L_0x0113
        L_0x011e:
            r1 = r2
        L_0x011f:
            java.lang.String r3 = "wsUrl"
            java.lang.Object r3 = r9.get(r3)
            com.eaydu.omni.jwt.Claim r3 = (com.eaydu.omni.jwt.Claim) r3
            if (r3 == 0) goto L_0x012c
            r3.asString()
        L_0x012c:
            java.lang.String r3 = "urls"
            java.lang.Object r9 = r9.get(r3)
            com.eaydu.omni.jwt.Claim r9 = (com.eaydu.omni.jwt.Claim) r9
            if (r9 == 0) goto L_0x013f
            com.eaydu.omni.gson.JsonObject r9 = r9.asJsonObject()
            int r9 = r8.parseUrlsFromToken(r9)
            goto L_0x0140
        L_0x013f:
            r9 = r2
        L_0x0140:
            java.lang.String r3 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "mAppid: "
            r4.append(r5)
            java.lang.String r5 = r8.mAppid
            r4.append(r5)
            java.lang.String r5 = " mRoomStr:"
            r4.append(r5)
            java.lang.String r6 = r8.mRoomid
            r4.append(r6)
            java.lang.String r6 = " mUserid: "
            r4.append(r6)
            long r6 = r8.mUserid
            r4.append(r6)
            java.lang.String r6 = " mEngineType: "
            r4.append(r6)
            com.eaydu.omni.RTCEngine$EngineType r6 = r8.mEngineType
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            android.util.Log.e(r3, r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "appid ="
            r3.append(r4)
            java.lang.String r4 = r8.mAppid
            r3.append(r4)
            r3.append(r5)
            java.lang.String r4 = r8.mRoomid
            r3.append(r4)
            java.lang.String r4 = " userid = "
            r3.append(r4)
            long r4 = r8.mUserid
            r3.append(r4)
            java.lang.String r4 = " enginetype = "
            r3.append(r4)
            com.eaydu.omni.RTCEngine$EngineType r4 = r8.mEngineType
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r4 = new java.lang.Object[r2]
            com.eaydu.omni.logger.Logger.i(r3, r4)
            if (r1 != 0) goto L_0x01db
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "RTCEngine unsupported Engine Type type = "
            r9.append(r1)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            java.lang.Object[] r1 = new java.lang.Object[r2]
            com.eaydu.omni.logger.Logger.i(r9, r1)
            com.eaydu.omni.RTCEngine$RtcEngineEventObserver r9 = r8.mRtcEngineEventObserver
            if (r9 == 0) goto L_0x01da
            android.os.Handler r9 = r8.mHandler
            com.eaydu.omni.RTCEngine$5 r1 = new com.eaydu.omni.RTCEngine$5
            r1.<init>(r0)
            boolean r0 = r9 instanceof android.os.Handler
            if (r0 != 0) goto L_0x01d5
            r9.post(r1)
            goto L_0x01da
        L_0x01d5:
            android.os.Handler r9 = (android.os.Handler) r9
            com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation.handlerPost(r9, r1)
        L_0x01da:
            r9 = -5
        L_0x01db:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.RTCEngine.parseToken(java.lang.String):int");
    }

    private int parseUrlsFromToken(JsonObject jsonObject) {
        try {
            String asString = jsonObject.get(UrlManager.URL_FULL_LOG_KEY).getAsString();
            if (!TextUtils.isEmpty(asString)) {
                UrlManager.getInstance().setUrlFullLog(asString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String asString2 = jsonObject.get(UrlManager.URL_KIBANA_KEY).getAsString();
            if (!TextUtils.isEmpty(asString2)) {
                UrlManager.getInstance().setUrlKibana(asString2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            String asString3 = jsonObject.get(UrlManager.URL_INSPECT_KEY).getAsString();
            if (!TextUtils.isEmpty(asString3)) {
                UrlManager.getInstance().setUrlInspect(asString3);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            String asString4 = jsonObject.get(UrlManager.URL_UPLOAD_LOG_KEY).getAsString();
            if (!TextUtils.isEmpty(asString4)) {
                UrlManager.getInstance().setUrlUploadLog(asString4);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return cacheURLForOMNIEngine(jsonObject);
    }

    private int cacheURLForOMNIEngine(JsonObject jsonObject) {
        int i;
        String str = "";
        try {
            String asString = jsonObject.get(UrlManager.URL_OMNI_CORE_SLB_KEY).getAsString();
            if (asString == null) {
                asString = str;
            }
            UrlManager.getInstance().setUrlCoreSlbOMNI(asString);
            i = 0;
        } catch (Exception e) {
            e.printStackTrace();
            i = 1;
        }
        try {
            String asString2 = jsonObject.get(UrlManager.URL_OMNI_CORE_SLB_BACKUP_KEY).getAsString();
            if (asString2 == null) {
                asString2 = str;
            }
            UrlManager.getInstance().setUrlCoreSlbBackupOMNI(asString2);
        } catch (Exception e2) {
            e2.printStackTrace();
            i = 1;
        }
        try {
            String asString3 = jsonObject.get(UrlManager.URL_OMNI_CORE_SERVER_LOG_KEY).getAsString();
            if (asString3 != null) {
                str = asString3;
            }
            UrlManager.getInstance().setUrlCoreServerLogOMNI(str);
            return i;
        } catch (Exception e3) {
            e3.printStackTrace();
            return 1;
        }
    }

    /* access modifiers changed from: protected */
    public BaseRtcEngine getBaseRtcEngine() {
        return this.mBaseRtcEngine;
    }

    /* access modifiers changed from: protected */
    public BaseRTCChannel createChannel(String str) {
        return this.mBaseRtcEngine.createChannel(str);
    }

    public int setRole(RTCRole rTCRole) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            return baseRtcEngine.setRole(rTCRole);
        }
        return -1;
    }

    public int setBusinessUserRole(RTCUserBusinessType rTCUserBusinessType) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            return baseRtcEngine.setBusinessUserRole(rTCUserBusinessType);
        }
        return -1;
    }

    public int setRtcEngineLog(String str, RTCEngineLogLevel rTCEngineLogLevel) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            return baseRtcEngine.setRtcEngineLog(str, rTCEngineLogLevel);
        }
        return -1;
    }

    public int setRecordingAudioParameters(int i, int i2) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            return baseRtcEngine.setRecordingAudioParameters(i, i2);
        }
        return -1;
    }

    public void enableLastmileProbeTest() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.enableLastmileProbeTest();
        }
    }

    public void disableLastmileProbeTest() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.disableLastmileProbeTest();
        }
    }

    public int joinRoom() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            return baseRtcEngine.joinRoom();
        }
        return -1;
    }

    public void leaveRoom() {
        Timer timer = this.autoSeiTimer;
        if (timer != null) {
            timer.cancel();
            this.autoSeiTimer = null;
        }
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.leaveRoom();
        }
    }

    public void destroy() {
        destory();
    }

    @Deprecated
    public void destory() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.destory();
            this.mBaseRtcEngine = null;
        }
        Timer timer = this.reportTimer;
        if (timer != null) {
            timer.cancel();
            this.reportTimer = null;
        }
        Timer timer2 = this.autoSeiTimer;
        if (timer2 != null) {
            timer2.cancel();
            this.autoSeiTimer = null;
        }
        clearStoredData();
        LogReport logReport = this.mlogReport;
        if (logReport != null) {
            logReport.destroyLogManger();
            this.mlogReport = null;
        }
        LogCommonInfo.getInstance().clearVolumes();
        LogCommonInfo.getInstance().clearPublishInfo();
        ContentInspectManager.getInstance().destroy();
        UrlManager.getInstance().onDestroy();
    }

    public void enableVideo() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.enableVideo();
        }
        Log.d(TAG, "enable video is default..");
    }

    public void enableLocalVideo(boolean z) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.enableLocalVideo(z);
        }
    }

    public void enableLocalAudio(boolean z) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.enableLocalAudio(z);
        }
    }

    public int muteLocalVideo(boolean z) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            return baseRtcEngine.muteLocalVideo(z);
        }
        return -1;
    }

    public int muteLocalAudio(boolean z) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            return baseRtcEngine.muteLocalAudio(z);
        }
        return -1;
    }

    public void muteRemoteVideo(long j, boolean z) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.muteRemoteVideo(j, z);
        }
    }

    public void muteRemoteAudio(long j, boolean z) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.muteRemoteAudio(j, z);
        }
    }

    public void muteAllRemoteVideo(boolean z) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.muteAllRemoteVideo(z);
        }
    }

    public void muteAllRemoteAudio(boolean z) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.muteAllRemoteAudio(z);
        }
    }

    public int setupLocalVideo(View view) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            return baseRtcEngine.setupLocalVideo(view);
        }
        return -1;
    }

    public void setLocalRenderMode(RTCVideoRenderMode rTCVideoRenderMode) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.setLocalRenderMode(rTCVideoRenderMode);
        }
    }

    public void setupRemoteVideo(View view, long j) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.setupRemoteVideo(view, j);
        }
    }

    public void setRemoteRenderMode(long j, RTCVideoRenderMode rTCVideoRenderMode) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.setRemoteRenderMode(j, rTCVideoRenderMode);
        }
    }

    public void setRemoteRenderMode(long j, RTCVideoRenderMode rTCVideoRenderMode, int i) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.setRemoteRenderMode(j, rTCVideoRenderMode, i);
        }
    }

    public SurfaceView createRendererView() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            return (SurfaceView) baseRtcEngine.createRendererView();
        }
        return null;
    }

    public void startPreview() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.startPreview();
        }
    }

    public void stopPreview() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.stopPreview();
        }
    }

    public void switchCamera() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.switchCamera();
        }
    }

    public int setCameraPosition(int i) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.setCameraPosition(i);
    }

    public int getCameraPosition() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.getCameraPosition();
    }

    public void setMirror(boolean z) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.setMirror(z);
        }
    }

    public void setRemoteMirror(boolean z) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.setRemoteMirror(z);
        }
    }

    public void setVideoEncoderConfiguration(int i, int i2, RTCEngineVideoBitrate rTCEngineVideoBitrate, RTC_ORIENTATION_MODE rtc_orientation_mode) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.setVideoEncoderConfiguration(i, i2, rTCEngineVideoBitrate, rtc_orientation_mode);
        }
    }

    public void setVideoEncoderConfiguration(int i, int i2, int i3, int i4, RTC_ORIENTATION_MODE rtc_orientation_mode) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.setVideoEncoderConfiguration(i, i2, i3, i4, rtc_orientation_mode);
        }
    }

    public int setAudioEncoderConfiguration(int i, int i2) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.setAudioEncoderConfiguration(i, i2);
    }

    public void muteVideo(boolean z) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.muteVideo(z);
        }
    }

    public void muteAudio(boolean z) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.muteAudio(z);
        }
    }

    public void enableExternalVideo(boolean z) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.enableExternalVideo(z);
        }
    }

    public boolean sendCustomVideoData(byte[] bArr, int i, int i2, int i3, int i4) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            return baseRtcEngine.sendCustomVideoData(bArr, i, i2, i3, i4);
        }
        return false;
    }

    public void enableExternalAudio(boolean z, int i, int i2) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.enableExternalAudio(z, i, i2);
        }
    }

    public void sendCustomPCMData(byte[] bArr) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.sendCustomPCMData(bArr);
        }
    }

    public void setRemoteVolume(long j, int i) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            baseRtcEngine.setVolume(j, i);
        }
    }

    public String getSdkVersion() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        return baseRtcEngine != null ? baseRtcEngine.getSdkVersion() : "unKnown";
    }

    public int setTimestamp(long j) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            return baseRtcEngine.setTimestamp(j);
        }
        return -1;
    }

    public int sendStreamMessage(long j, byte[] bArr) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null || bArr == null) {
            return -1;
        }
        return baseRtcEngine.sendStreamMessage(j, bArr);
    }

    public long getTimestamp(int i) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            return baseRtcEngine.getTimestamp(i);
        }
        return -1;
    }

    public int addPublishStreamUrl(String str, boolean z) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.addPublishStreamUrl(str, z);
    }

    public int removePublishStreamUrl(String str) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.removePublishStreamUrl(str);
    }

    public int setRtmpConfig(RTCRtmpConfig rTCRtmpConfig) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.setRtmpConfig(rTCRtmpConfig);
    }

    public int startPlayMusic(String str) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.startPlayMusic(str);
    }

    public int startPlayMusic(String str, boolean z, boolean z2, int i) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.startPlayMusic(str, z, z2, i);
    }

    public int stopPlayMusic() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.stopPlayMusic();
    }

    public int pauseAudioMusic() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.pauseAudioMusic();
    }

    public int resumeAudioMusic() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.resumeAudioMusic();
    }

    public int getAudioMusicDuration() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.getAudioMusicDuration();
    }

    public int getAudioMusicCurrentPosition() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.getAudioMusicCurrentPosition();
    }

    public int setAudioMusicPosition(int i) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.setAudioMusicPosition(i);
    }

    public int playMusicVolume(int i) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.playMusicVolume(i);
    }

    public int setParams(String str) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.setParams(str);
    }

    public int setDefaultMuteAllRemoteAudioStreams(boolean z) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.setDefaultMuteAllRemoteAudioStreams(z);
    }

    public int setDefaultMuteAllRemoteVideoStreams(boolean z) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.setDefaultMuteAllRemoteVideoStreams(z);
    }

    @Deprecated
    public int switchRoomWithToken(String str) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.switchRoomWithToken(str);
    }

    private void setServerTimestamp(long j) {
        synchronized (this.mServerTimestampLock) {
            this.timeDifference = j - System.currentTimeMillis();
            this.isInitTimeStamp = true;
        }
        Logger.i("RTCEngine -- setServerTimestamp  :: ts:" + j + " timeDifference:" + this.timeDifference, new Object[0]);
    }

    private long getServerTimestamp() {
        if (!this.isInitTimeStamp) {
            return -1;
        }
        return System.currentTimeMillis() + this.timeDifference;
    }

    private void enableAutoTimestamp(boolean z, float f) {
        if (f > 10.0f) {
            f = 10.0f;
        }
        if (f <= 0.0f) {
            f = 3.0f;
        }
        this.mSendSEIFreq = f;
        Logger.i("RTCEngine -- enableAutoTimestamp  :: enable:" + z + " freq:" + f, new Object[0]);
        if (!z) {
            Timer timer = this.autoSeiTimer;
            if (timer != null) {
                timer.cancel();
                this.autoSeiTimer = null;
                return;
            }
            return;
        }
        if (!this.isInitTimeStamp) {
            initTime();
        }
        if (this.autoSeiTimer == null) {
            Timer timer2 = new Timer();
            this.autoSeiTimer = timer2;
            timer2.schedule(new TimerTask() {
                public void run() {
                    RTCEngine.this.autoSeiTask.run();
                }
            }, 0, (long) (1000.0f / f));
        }
    }

    private void sendHttpMetadata(final String str, String str2, final int i, String str3, long j) {
        String str4 = "http://media.xesv5.com/api/addHTTPPoint?stream_name=" + str + "&info=" + str2 + "&category=" + i + "&path=" + str3 + "&timestamp=" + (j / 1000) + "&token=eyJVc2VybmFtZSI6InJ0YyIsIlRva2VuIjoiZGJiNjA4ZTEtNjdmYS00MjU1LTkzZjgtYzRhZjU2MDI1ODBhIn0=";
        Logger.i("RTCEngine sendHttpMetadata url = " + str4, new Object[0]);
        this.mhttpClient.newCall(new Request.Builder().url(str4).build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                Logger.i("RTCEngine sendHttpMetadata onFailure e = " + iOException.toString(), new Object[0]);
                if (RTCEngine.this.mRtcEngineEventObserver != null) {
                    RTCEngine.this.mRtcEngineEventObserver.onHttpMetadataStateStateChanged(str, i, -1, -9999);
                }
            }

            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                int i = 0;
                Logger.i("RTCEngine sendHttpMetadata onResponse responseStr = " + string, new Object[0]);
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    if (jSONObject.has("Status")) {
                        if (Integer.parseInt(jSONObject.getString("Status")) != 1) {
                            i = -1;
                        }
                        if (jSONObject.has("Code")) {
                            int parseInt = Integer.parseInt(jSONObject.getString("Code"));
                            if (RTCEngine.this.mRtcEngineEventObserver != null) {
                                RTCEngine.this.mRtcEngineEventObserver.onHttpMetadataStateStateChanged(str, i, i, parseInt);
                            }
                        }
                    }
                } catch (JSONException unused) {
                    if (RTCEngine.this.mRtcEngineEventObserver != null) {
                        RTCEngine.this.mRtcEngineEventObserver.onHttpMetadataStateStateChanged(str, i, -1, -9999);
                    }
                }
            }
        });
    }

    private void sendHttpMetadataStartRtmpRecord(String str, String str2, String str3, long j) {
        sendHttpMetadata(str, str2, 6, str3, j);
    }

    private void sendHttpMetadataStopRtmpRecord(String str, String str2, String str3, long j) {
        sendHttpMetadata(str, str2, 7, str3, j);
    }

    public int enableContentInspect(boolean z, int i) {
        Logger.i(TAG + "enableContentInspect enable: " + z + " timeInterval: " + i, new Object[0]);
        if (this.mBaseRtcEngine == null) {
            return -1;
        }
        int i2 = i < 5 ? 5 : i;
        if (!this.isReportImage || (getmEngineType() != EngineType.OMNI && getmEngineType() != EngineType.Agora)) {
            return this.mBaseRtcEngine.enableContentInspect(z, i2);
        }
        if (z) {
            return ContentInspectManager.getInstance().start(i2, this.mBaseRtcEngine, this.mAppid, this.mRoomid, Long.valueOf(this.mUserid));
        }
        return ContentInspectManager.getInstance().stop();
    }

    public int contentInspectExtra(String str, InspectMode[] inspectModeArr) {
        Logger.i(TAG + "contentInspectExtra arguments: " + str + " modes: " + inspectModeArr, new Object[0]);
        if (this.mBaseRtcEngine == null) {
            return -1;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                ContentInspectManager.getInstance().setArguments(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (inspectModeArr != null) {
            try {
                int i = 0;
                int i2 = 0;
                for (InspectMode inspectMode : inspectModeArr) {
                    if (inspectMode.mode == 1) {
                        i = inspectMode.rate;
                    } else if (inspectMode.mode == 2) {
                        i2 = inspectMode.rate;
                    }
                }
                ContentInspectManager.getInstance().setRatePorn(i);
                ContentInspectManager.getInstance().setRateAI(i2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.mBaseRtcEngine.contentInspectExtra(str, inspectModeArr);
    }

    public int setAVSyncSource(long j, long j2) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.setAVSyncSource(j, j2);
    }

    public int setAVSyncSource(long j) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.setAVSyncSource(j);
    }

    public int setRemoteVideoStreamType(long j, int i) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.setRemoteVideoStreamType((long) ((int) j), i);
    }

    public int setAudioMode(RTCAudioMode rTCAudioMode) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.setAudioMode(rTCAudioMode);
    }

    private int publish() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.publish();
    }

    private int unPublish() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.unPublish();
    }

    public int setServerAddress(String str, int i) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.setServerAddress(str, i);
    }

    public int setPlaybackAudioFrameParameters(int i, int i2, RawAudioFrameOpMode rawAudioFrameOpMode, int i3) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.setPlaybackAudioFrameParameters(i, i2, rawAudioFrameOpMode, i3);
    }

    public int startChannelMediaRelay(RTCChannelMediaRelayConfiguration rTCChannelMediaRelayConfiguration) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.startChannelMediaRelay(rTCChannelMediaRelayConfiguration);
    }

    public int stopChannelMediaRelay() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.stopChannelMediaRelay();
    }

    public int updateChannelMediaRelay(RTCChannelMediaRelayConfiguration rTCChannelMediaRelayConfiguration) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.updateChannelMediaRelay(rTCChannelMediaRelayConfiguration);
    }

    private void clearStoredData() {
        this.mIRTCMediaAudioProcess = null;
        this.mIRTCMediaVideoProcess = null;
    }

    public int checkFeatureSupport(RTCFeature rTCFeature) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.checkFeatureSupport(rTCFeature);
    }

    public int getEngineType() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.getEngineType();
    }

    public int pushExternalAudioFrame(byte[] bArr, long j, int i, int i2, int i3, int i4) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.pushExternalAudioFrame(bArr, j, i, i2, i3, i4);
    }

    public int setExternalAudioSourceVolume(int i, int i2) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.setExternalAudioSourceVolume(i, i2);
    }

    public int setRemoteSubscribeFallbackOption(int i) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.setRemoteSubscribeFallbackOption(i);
    }

    public int applyRemoteStreamSubscribeAdvice(long j, int i) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.applyRemoteStreamSubscribeAdvice((long) ((int) j), i);
    }

    public int setRemoteMixedVolume(int i) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.setRemoteMixedVolume(i);
    }

    public int takeLocalViewSnapshot() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.takeLocalViewSnapshot();
    }

    public int takeRemoteViewSnapshot(long j) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.takeRemoteViewSnapshot(j);
    }

    public int setupLocalVideo(TextureView textureView) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.setupLocalVideo(textureView);
    }

    public int setupRemoteVideo(long j, TextureView textureView) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.setupRemoteVideo(j, textureView);
    }

    public int setPreviewResolution(int i, int i2) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine == null) {
            return -1;
        }
        return baseRtcEngine.setPreviewResolution(i, i2);
    }

    public static int setLibraryLoadPath(String str) {
        if (str == null) {
            str = "";
        }
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        ExternalConfig.LibraryLoadPath = str;
        return 0;
    }

    public void uploadLog(int i, String str) {
        EngineType engineType = EngineType.OMNI;
    }

    public int getConnectionState() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            return baseRtcEngine.getConnectionState();
        }
        return -1;
    }

    public int setAudioProfile(int i, int i2) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            return baseRtcEngine.setAudioProfile(i, i2);
        }
        return 0;
    }

    public int disableVideo() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            return baseRtcEngine.disableVideo();
        }
        return 0;
    }

    public TextureView createTextureView() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            return baseRtcEngine.createTextureView();
        }
        return null;
    }

    public int setHowlingMode(int i) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            return baseRtcEngine.setHowlingMode(i);
        }
        return -2;
    }

    public String getChannelCallId() {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        return baseRtcEngine != null ? baseRtcEngine.getChannelCallId() : "";
    }

    public int setLiveMode(int i) {
        BaseRtcEngine baseRtcEngine = this.mBaseRtcEngine;
        if (baseRtcEngine != null) {
            return baseRtcEngine.setLiveMode(i);
        }
        return -2;
    }

    public int switchChannelWithRealToken(String str, String str2) {
        if (this.mBaseRtcEngine == null) {
            return -2;
        }
        LogReport logReport = this.mlogReport;
        if (logReport != null) {
            logReport.setRoomid(str2);
        }
        this.mBaseRtcEngine.setRoomId(str2);
        this.mBaseRtcEngine.setToken(str);
        RtcEngineEventObserver rtcEngineEventObserver = this.mRtcEngineEventObserver;
        if (rtcEngineEventObserver != null) {
            this.mBaseRtcEngine.setObserver(rtcEngineEventObserver);
        }
        IRTCAudioObserver iRTCAudioObserver = this.mIRTCAudioObserver;
        if (iRTCAudioObserver != null) {
            this.mBaseRtcEngine.setPlayBackAudioObserver(iRTCAudioObserver);
        }
        IRTCMediaVideoProcess iRTCMediaVideoProcess = this.mIRTCMediaVideoProcess;
        if (iRTCMediaVideoProcess != null) {
            this.mBaseRtcEngine.setMediaVideoProcessListener(iRTCMediaVideoProcess);
        }
        IRTCMediaAudioProcess iRTCMediaAudioProcess = this.mIRTCMediaAudioProcess;
        if (iRTCMediaAudioProcess != null) {
            this.mBaseRtcEngine.setMediaAudioProcessListener(iRTCMediaAudioProcess);
        }
        return this.mBaseRtcEngine.switchChannel(str, str2);
    }
}
