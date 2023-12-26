package com.wushuangtech.log;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.bonree.sdk.agent.engine.external.JSONArrayInstrumentation;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.wushuangtech.api.ExternalAudioModule;
import com.wushuangtech.api.ExternalAudioModuleImpl;
import com.wushuangtech.api.ExternalVideoModule;
import com.wushuangtech.api.ExternalVideoModuleImpl;
import com.wushuangtech.api.RtcBaseManager;
import com.wushuangtech.api.RtcDeviceManager;
import com.wushuangtech.api.RtcUserManager;
import com.wushuangtech.bean.SpeedCalcBean;
import com.wushuangtech.bean.VideoStuckStatsBean;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.inter.RtcGlobalAVInterface;
import com.wushuangtech.jni.NativeInitializer;
import com.wushuangtech.jni.ReportLogJni;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.library.GlobalChannelConfig;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.GlobalVideoConfig;
import com.wushuangtech.library.User;
import com.wushuangtech.library.UserDeviceConfig;
import com.wushuangtech.library.video.VideoStatus;
import com.wushuangtech.utils.DeviceUtils;
import com.wushuangtech.utils.MyMathUtils;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.utils.PhoneUtils;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RtcHeartbeatReporter extends RtcBaseManager {
    private static final String[] AUDIO_DOWNLOAD_KEY = {"ts", "sendUserId", "arSsrc", "arLostRate", "arBitrate", "arBufferSize", "arFractionLostRate", "arRtt", "arDelay", "arDecInputFps", "arDecOutputFps", "arDecodeLen", "arRenderFps", "arAvgJms", "arMaxJms", "arVolume", "arVolumeLevel", "arIsRemoteUserMute", "arVolumeLevelSum", "arIsLocalMute", "arE2eLost", "msInfo", "asIp", "asPort", "aChanState", "aChanIOType", "arVolumeLevelRmsA", "arVolumeLevelRms", "arSysPlayoutFps", "arFps", "arProcElapsedAvg", "arProcElapsedMax", "arDecElapsed"};
    private static final String[] AUDIO_UPLOAD_KEY = {"ts", "asBitrate", "asSsrc", "asRtt", "asIsLocalMute", "asCapFps", "asCapDataLen", "asEncInputFps", "asEncDataLen", "asEncOutputFps", "asFractionLostRate", "asReConnTimes", "asReConnArray", "connIp", "connTimes", "asMutedDur", "asIsMutedRemoteAll", "asVolumeLevelSum", "asVolume", "asVolumeLevel", "asVolumeAfter3A", "asCapStat", "asSpeakingState", "asPreSetBr", "asMicAuth", "msInfo", "asIp", "asPort", "aChanState", "aChanIOType", "asVolumeLevelRmsSend", "asVolumeLevelRmsA", "asVolumeLevelRms"};
    private static final int LEFT_DECIMAL_NUM = 3;
    private static final String[] VIDEO_DOWNLOAD_KEY = {"ts", "sendUserId", "vrMediaId", "vrSsrc", "vrFps", "vrWidth", "vrHeight", "vrBitrate", "vrPkgNum", "vrLostRate", "vrRtt", "vrJitter", "vrDelay", "vrBuf", "vrFractionLostRate", "vrMute", "vrAvDiff", "vrInuse", "vrRenderFps", "vrRenderErrTimes", "vrDecInputFps", "vrDecFps", "vrDecFailFps", "vrDecErrTimes", "vrExternalFps", "vrDecElapsed", "vrVideoFreeze", "ts", "stat", "freezeDur", "vrE2eLost", "msInfo", "vsIp", "vsPort", "vChanState", "vChanIOType", "vrTotalBr"};
    private static final String[] VIDEO_UPLOAD_KEY = {"ts", "vsMediaId", "vsSsrc", "vsBitrate", "vsTrgtBr", "vsResendBr", "vsFps", "vsCapFps", "vsCapWidth", "vsCapHeight", "vsPkgNum", "vsFractionLostRate", "vsRtt", "vsBuf", "vsEncErr", "vsEncNum", "vsMute", "vsQp", "vsCameraAuth", "vsInFps", "vsEncInputFps", "vsEncFps", "vsEncFailFps", "vsSendFps", "vsWidth", "vsHeight", "vsReConnTimes", "vsReConnArray", "connIp", "connTimes", "msInfo", "vsIp", "vsPort", "vChanState", "vChanIOType", "vsMainStreamBr", "vsMainStreamFps", "vsMinorStreamBr", "vsMinorStreamFps", "vsTotalBr", "vsCodecType"};
    private static final boolean mEnableCheck = false;
    private final String TAG;
    private final String mAppId;
    private int mAppRunTime;
    private float mAppTotalCpuUsage;
    private float mAppTotalMemUsage;
    private boolean mAudioEnabled;
    private String mAudioLinkIp = "";
    private int mAudioLinkPort;
    private boolean mAudioLocalEnabled;
    private boolean mAudioLocalStreamEnabled;
    public Map<String, Integer> mAudioReconnectMap;
    private String mAudioServerId = "";
    private int mAudioState;
    private final String mConnectId;
    private final String mEventName = "sdk_heartbeat";
    private boolean mJoinedChannel;
    private final LongSparseArray<LastCacheData> mLastAudioCaches = new LongSparseArray<>();
    private long mLastAudioSendDataSize;
    public long mLastBuildInfoTime;
    private float mLastMaxAppCpuUsage;
    private float mLastMaxAppMemUsage;
    public long mLastVideoCapFrame;
    public long mLastVideoEncFrames;
    public long mLastVideoSendFrames;
    private final ConcurrentLinkedQueue<InfoBean> mLogCaches = new ConcurrentLinkedQueue<>();
    private int mRole;
    private String mSessionId = "";
    private Map<String, String> mTravelJsonObjectMap;
    private final long mUid;
    private boolean mVideoEnabled;
    private final SpeedCalcBean mVideoEncodeErrorBean = new SpeedCalcBean();
    private final SpeedCalcBean mVideoEncodeRecvFpsBean = new SpeedCalcBean();
    private final SpeedCalcBean mVideoExternalEncodeRecvFpsBean = new SpeedCalcBean();
    private String mVideoLinkIp = "";
    private int mVideoLinkPort;
    private boolean mVideoLocalEnabled;
    private boolean mVideoLocalStreamEnabled;
    public Map<String, Integer> mVideoReconnectMap;
    private String mVideoServerId = "";
    private int mVideoState;

    public static class LastCacheData {
        long mLastAudioRecvDatas;
    }

    private void checkLogContent(String str, JSONObject jSONObject, String[] strArr) throws JSONException {
    }

    public RtcHeartbeatReporter(String str, Long l, Integer num, String str2) {
        super(str);
        this.mUid = l.longValue();
        this.mRole = num.intValue();
        this.mAppId = GlobalConfig.mAppId;
        this.mConnectId = str2;
        this.mAudioReconnectMap = new HashMap();
        this.mVideoReconnectMap = new HashMap();
        this.TAG = "RtcHeartbeatReporter<" + str + ">";
        logD("Create heartbeat object ... " + str + " | " + l + " | " + num);
    }

    public void setSessionId(String str) {
        if (!TextUtils.isEmpty(str)) {
            logI("SESSION_WATCH Setting heartbeat session id = " + str);
            this.mSessionId = str;
        }
    }

    public void setAudioMediaInfo(String str, int i, String str2) {
        if (str == null) {
            str = "";
        }
        this.mAudioLinkIp = str;
        this.mAudioLinkPort = i;
        if (str2 == null) {
            str2 = "";
        }
        this.mAudioServerId = str2;
    }

    public void setVideoMediaInfo(String str, int i, String str2) {
        if (str == null) {
            str = "";
        }
        this.mVideoLinkIp = str;
        this.mVideoLinkPort = i;
        if (str2 == null) {
            str2 = "";
        }
        this.mVideoServerId = str2;
    }

    public long getUserId() {
        return this.mUid;
    }

    public String getChannelName() {
        return this.mChannelName;
    }

    public void setAudioMediaState(int i) {
        this.mAudioState = i;
    }

    public void setVideoMediaState(int i) {
        this.mVideoState = i;
    }

    public void setMediaReconnectInfo(int i, String str) {
        if (i == 0) {
            if (this.mAudioReconnectMap.containsKey(str)) {
                this.mAudioReconnectMap.put(str, Integer.valueOf(this.mAudioReconnectMap.get(str).intValue() + 1));
            } else {
                this.mAudioReconnectMap.put(str, 1);
            }
        } else if (i != 1) {
        } else {
            if (this.mVideoReconnectMap.containsKey(str)) {
                this.mVideoReconnectMap.put(str, Integer.valueOf(this.mVideoReconnectMap.get(str).intValue() + 1));
            } else {
                this.mVideoReconnectMap.put(str, 1);
            }
        }
    }

    public void initHeartBeatStatus(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.mAudioEnabled = z;
        this.mAudioLocalEnabled = z2;
        this.mAudioLocalStreamEnabled = z3;
        this.mVideoEnabled = z4;
        this.mVideoLocalEnabled = z5;
        this.mVideoLocalStreamEnabled = z6;
        this.mJoinedChannel = true;
    }

    public void clearResource() {
        logD("Stop report heartbeat info...");
        this.mJoinedChannel = false;
    }

    public void setAudioEnabled(boolean z) {
        this.mAudioEnabled = z;
    }

    public void setAudioLocalEnabled(boolean z) {
        this.mAudioLocalEnabled = z;
    }

    public void setAudioLocalStreamEnabled(boolean z) {
        this.mAudioLocalStreamEnabled = z;
    }

    public void setVideoEnabled(boolean z) {
        this.mVideoEnabled = z;
    }

    public void setVideoLocalEnabled(boolean z) {
        this.mVideoLocalEnabled = z;
    }

    public void setVideoLocalStreamEnabled(boolean z) {
        this.mVideoLocalStreamEnabled = z;
    }

    public void setRoleType(int i) {
        this.mRole = i;
    }

    public static class InfoBean {
        String mAPPID;
        AecParamsInfo mAecParamsInfo = new AecParamsInfo();
        AudioInfo mAudioInfo = new AudioInfo();
        String mConnectID;
        EquipInfo mEquipInfo = new EquipInfo();
        String mEventName;
        String mLogTime;
        String mLogTimeStr;
        String mLogVersion;
        MediaServerInfo mMediaServerInfo = new MediaServerInfo();
        String mRoleType;
        String mRoomIDStr;
        String mSdkPublicVer;
        String mSdkSignalVer;
        String mSessionId;
        int mSignalReconnectTimes;
        SystemEnvironment mSystemEnvironment = new SystemEnvironment();
        String mUosv;
        String mUserDevInfo;
        String mUserID;
        VideoInfo mVideoInfo = new VideoInfo();

        public String toString() {
            return "InfoBean{mEventName='" + this.mEventName + '\'' + ", mLogTime='" + this.mLogTime + '\'' + ", mLogTimeStr='" + this.mLogTimeStr + '\'' + ", mAPPID='" + this.mAPPID + '\'' + ", mRoomIDStr='" + this.mRoomIDStr + '\'' + ", mSessionId='" + this.mSessionId + '\'' + ", mUserID='" + this.mUserID + '\'' + ", mConnectID='" + this.mConnectID + '\'' + ", mRoleType='" + this.mRoleType + '\'' + ", mSignalReconnectTimes=" + this.mSignalReconnectTimes + ", mUserDevInfo='" + this.mUserDevInfo + '\'' + ", mSdkPublicVer='" + this.mSdkPublicVer + '\'' + ", mSdkSignalVer='" + this.mSdkSignalVer + '\'' + ", mLogVersion='" + this.mLogVersion + '\'' + ", mUosv='" + this.mUosv + '\'' + '}';
        }
    }

    public static class EquipInfo {
        int mIsBg;
        String mUserNet;

        public String toString() {
            return "EquipInfo{mUserNet='" + this.mUserNet + '\'' + ", mIsBg=" + this.mIsBg + '}';
        }
    }

    public static class VideoInfo {
        List<VideoRecvInfo> mVideoRecvList = new ArrayList();
        List<VideoSendInfo> mVideoSendList = new ArrayList();

        public static class VideoSendInfo {
            boolean isValid;
            long mTs;
            long mVsBitrate;
            int mVsBuf;
            int mVsCameraAuth;
            int mVsCapFps;
            int mVsCapHeight;
            int mVsCapStats;
            int mVsCapWidth;
            int mVsCodecType;
            int mVsDynamic;
            int mVsEncErr;
            int mVsEncFailFps;
            int mVsEncFps;
            int mVsEncInputFps;
            long mVsEncNum;
            int mVsFps;
            float mVsFractionLostRate;
            int mVsHeight;
            int mVsInFps;
            int mVsMainStreamBr;
            int mVsMainStreamFps;
            String mVsMediaId;
            int mVsMinorStreamBr;
            int mVsMinorStreamFps;
            int mVsMute;
            long mVsPkgNum;
            int mVsPreviewStats;
            int mVsQp;
            List<VReconnect> mVsReConnArray = new ArrayList();
            long mVsResendBr;
            int mVsRtt;
            int mVsSendFps;
            long mVsSsrc;
            int mVsTotalBr;
            long mVsTrgtBr;
            String mVsViewAddress;
            int mVsViewNum;
            int mVsWidth;
            int msIOType;
            String msId;
            String msIp;
            int msPort;
            int msState;

            public String toString() {
                return "VideoSendInfo{mTs=" + this.mTs + ", mVsMediaId='" + this.mVsMediaId + '\'' + ", mVsSsrc=" + this.mVsSsrc + ", mVsBitrate=" + this.mVsBitrate + ", mVsTotalBr=" + this.mVsTotalBr + ", mVsTrgtBr=" + this.mVsTrgtBr + ", mVsResendBr=" + this.mVsResendBr + ", mVsMainStreamBr=" + this.mVsMainStreamBr + ", mVsMinorStreamBr=" + this.mVsMinorStreamBr + ", mVsSendFps=" + this.mVsSendFps + ", mVsFps=" + this.mVsFps + ", mVsCapFps=" + this.mVsCapFps + ", mVsMainStreamFps=" + this.mVsMainStreamFps + ", mVsMinorStreamFps=" + this.mVsMinorStreamFps + ", mVsInFps=" + this.mVsInFps + ", mVsEncInputFps=" + this.mVsEncInputFps + ", mVsEncFps=" + this.mVsEncFps + ", mVsEncFailFps=" + this.mVsEncFailFps + ", mVsCodecType=" + this.mVsCodecType + ", mVsCapWidth=" + this.mVsCapWidth + ", mVsCapHeight=" + this.mVsCapHeight + ", mVsWidth=" + this.mVsWidth + ", mVsHeight=" + this.mVsHeight + ", mVsPkgNum=" + this.mVsPkgNum + ", mVsFractionLostRate=" + this.mVsFractionLostRate + ", mVsRtt=" + this.mVsRtt + ", mVsBuf=" + this.mVsBuf + ", mVsEncErr=" + this.mVsEncErr + ", mVsEncNum=" + this.mVsEncNum + ", mVsMute=" + this.mVsMute + ", mVsQp=" + this.mVsQp + ", mVsCameraAuth=" + this.mVsCameraAuth + ", mVsReConnArray=" + this.mVsReConnArray + ", isValid=" + this.isValid + ", msIp='" + this.msIp + '\'' + ", msPort=" + this.msPort + ", msIOType=" + this.msIOType + ", msId='" + this.msId + '\'' + ", msState=" + this.msState + ", mVsDynamic=" + this.mVsDynamic + ", mVsCapStats=" + this.mVsCapStats + ", mVsPreviewStats=" + this.mVsPreviewStats + ", mVsViewNum=" + this.mVsViewNum + ", mVsViewAddress='" + this.mVsViewAddress + '\'' + '}';
            }
        }

        public static class VideoRecvInfo {
            boolean isValid;
            long mTs;
            long mVrAvDiff;
            long mVrBitrate;
            long mVrBuf;
            long mVrDecElapsed;
            long mVrDecErrTimes;
            long mVrDecFailFps;
            long mVrDecFps;
            long mVrDecInputFps;
            long mVrDelay;
            float mVrE2eLost;
            long mVrExternalFps;
            long mVrFps;
            float mVrFractionLostRate;
            long mVrHeight;
            long mVrInuse;
            long mVrJitter;
            float mVrLostRate;
            String mVrMediaId;
            long mVrMute;
            long mVrPkgNum;
            long mVrRenderErrTimes;
            long mVrRenderFps;
            long mVrRtt;
            String mVrSendUserId;
            long mVrSsrc;
            int mVrTotalBr;
            long mVrWidth;
            int msIOType;
            String msId;
            String msIp;
            int msPort;
            int msState;

            public String toString() {
                return "VideoRecvInfo{mTs=" + this.mTs + ", mVrSendUserId='" + this.mVrSendUserId + '\'' + ", mVrMediaId='" + this.mVrMediaId + '\'' + ", mVrSsrc=" + this.mVrSsrc + ", mVrBitrate=" + this.mVrBitrate + ", mVrTotalBr=" + this.mVrTotalBr + ", mVrFps=" + this.mVrFps + ", mVrPkgNum=" + this.mVrPkgNum + ", mVrMute=" + this.mVrMute + ", mVrInuse=" + this.mVrInuse + ", mVrLostRate=" + this.mVrLostRate + ", mVrE2eLost=" + this.mVrE2eLost + ", mVrFractionLostRate=" + this.mVrFractionLostRate + ", mVrRtt=" + this.mVrRtt + ", mVrJitter=" + this.mVrJitter + ", mVrDelay=" + this.mVrDelay + ", mVrBuf=" + this.mVrBuf + ", mVrAvDiff=" + this.mVrAvDiff + ", mVrWidth=" + this.mVrWidth + ", mVrHeight=" + this.mVrHeight + ", mVrDecFps=" + this.mVrDecFps + ", mVrDecInputFps=" + this.mVrDecInputFps + ", mVrRenderFps=" + this.mVrRenderFps + ", mVrDecFailFps=" + this.mVrDecFailFps + ", mVrRenderErrTimes=" + this.mVrRenderErrTimes + ", mVrDecErrTimes=" + this.mVrDecErrTimes + ", mVrExternalFps=" + this.mVrExternalFps + ", mVrDecElapsed=" + this.mVrDecElapsed + ", isValid=" + this.isValid + ", msIp='" + this.msIp + '\'' + ", msPort=" + this.msPort + ", msIOType=" + this.msIOType + ", msId='" + this.msId + '\'' + ", msState=" + this.msState + '}';
            }
        }
    }

    public static class AudioInfo {
        List<AudioRecvInfo> mAudioRecvList = new ArrayList();
        List<AudioSendInfo> mAudioSendList = new ArrayList();

        public static class AudioSendInfo {
            int mANlp;
            int mAsBitrate;
            long mAsCapDataLen;
            int mAsCapFps;
            int mAsCapStat;
            long mAsEncDataLen;
            int mAsEncInputFps;
            int mAsEncOutputFps;
            float mAsFractionLostRate;
            int mAsIsLocalMute;
            int mAsIsMutedRemoteAll;
            int mAsMicAuth;
            long mAsMutedDur;
            int mAsPreSetBr;
            List<AReconnect> mAsReConnTimes = new ArrayList();
            long mAsRtt;
            int mAsSpeakingState;
            long mAsSsrc;
            int mAsVolume;
            long mAsVolumeAfter3A;
            int mAsVolumeCallBackAfterLevel;
            int mAsVolumeCallBackBeforeLevel;
            long mAsVolumeLevel;
            int mAsVolumeLevelRms;
            int mAsVolumeLevelRmsA;
            long mAsVolumeLevelRmsSend;
            long mAsVolumeLevelSum;
            int mAsVolumeOriginalLevel;
            int mDelayMedian;
            int mDelayStd;
            int mErl;
            int mErle;
            float mFractionPoorDelays;
            String mOutAudioProcessEffeciency;
            int mReportType;
            int mSendAUDIO_FOCUS;
            long mSendA_MAXERRORUID;
            long mSendA_MUTEFRAME;
            long mSendA_RECVERROR;
            long mSendA_RECVERRORTIME;
            long mTs;

            public String toString() {
                return "AudioSendInfo{mTs=" + this.mTs + ", mAsSsrc=" + this.mAsSsrc + ", mAsBitrate=" + this.mAsBitrate + ", mAsCapFps=" + this.mAsCapFps + ", mAsCapDataLen=" + this.mAsCapDataLen + ", mAsEncInputFps=" + this.mAsEncInputFps + ", mAsEncDataLen=" + this.mAsEncDataLen + ", mAsEncOutputFps=" + this.mAsEncOutputFps + ", mAsIsLocalMute=" + this.mAsIsLocalMute + ", mAsIsMutedRemoteAll=" + this.mAsIsMutedRemoteAll + ", mAsMutedDur=" + this.mAsMutedDur + ", mAsFractionLostRate=" + this.mAsFractionLostRate + ", mAsRtt=" + this.mAsRtt + ", mAsVolumeLevelSum=" + this.mAsVolumeLevelSum + ", mAsVolumeLevelRmsSend=" + this.mAsVolumeLevelRmsSend + ", mAsVolumeLevelRmsA=" + this.mAsVolumeLevelRmsA + ", mAsVolumeLevelRms=" + this.mAsVolumeLevelRms + ", mAsVolume=" + this.mAsVolume + ", mAsVolumeLevel=" + this.mAsVolumeLevel + ", mAsVolumeAfter3A=" + this.mAsVolumeAfter3A + ", mAsVolumeOriginalLevel=" + this.mAsVolumeOriginalLevel + ", mAsVolumeCallBackAfterLevel=" + this.mAsVolumeCallBackAfterLevel + ", mAsVolumeCallBackBeforeLevel=" + this.mAsVolumeCallBackBeforeLevel + ", mAsCapStat=" + this.mAsCapStat + ", mAsSpeakingState=" + this.mAsSpeakingState + ", mAsPreSetBr=" + this.mAsPreSetBr + ", mAsMicAuth=" + this.mAsMicAuth + ", mAsReConnTimes=" + this.mAsReConnTimes + ", mSendA_RECVERROR=" + this.mSendA_RECVERROR + ", mSendA_MAXERRORUID=" + this.mSendA_MAXERRORUID + ", mSendA_RECVERRORTIME=" + this.mSendA_RECVERRORTIME + ", mSendA_MUTEFRAME=" + this.mSendA_MUTEFRAME + ", mSendAUDIO_FOCUS=" + this.mSendAUDIO_FOCUS + ", mOutAudioProcessEffeciency='" + this.mOutAudioProcessEffeciency + '\'' + ", mErl=" + this.mErl + ", mErle=" + this.mErle + ", mANlp=" + this.mANlp + ", mDelayMedian=" + this.mDelayMedian + ", mDelayStd=" + this.mDelayStd + ", mFractionPoorDelays=" + this.mFractionPoorDelays + ", mReportType=" + this.mReportType + '}';
            }
        }

        public static class AudioRecvInfo {
            long mArAvgJms;
            long mArBitrate;
            long mArBufferSize;
            int mArDecElapsed;
            int mArDecInputFps;
            int mArDecOutputFps;
            long mArDecodeLen;
            long mArDelay;
            float mArE2eLost;
            int mArFps;
            float mArFractionLostRate;
            long mArIsLocalMute;
            long mArIsRemoteUserMute;
            float mArLostRate;
            long mArMaxJms;
            long mArProcElapsedAvg;
            long mArProcElapsedMax;
            int mArRenderFps;
            long mArRtt;
            long mArSsrc;
            int mArSysPlayoutFps;
            long mArVolume;
            long mArVolumeLevel;
            int mArVolumeLevelRms;
            int mArVolumeLevelRmsA;
            long mArVolumeLevelSum;
            String mSendUserId;
            long mTs;

            public String toString() {
                return "AudioRecvInfo{mTs=" + this.mTs + ", mSendUserId='" + this.mSendUserId + '\'' + ", mArSsrc=" + this.mArSsrc + ", mArBitrate=" + this.mArBitrate + ", mArFps=" + this.mArFps + ", mArDecInputFps=" + this.mArDecInputFps + ", mArDecOutputFps=" + this.mArDecOutputFps + ", mArRenderFps=" + this.mArRenderFps + ", mArSysPlayoutFps=" + this.mArSysPlayoutFps + ", mArDecodeLen=" + this.mArDecodeLen + ", mArDecElapsed=" + this.mArDecElapsed + ", mArIsRemoteUserMute=" + this.mArIsRemoteUserMute + ", mArIsLocalMute=" + this.mArIsLocalMute + ", mArBufferSize=" + this.mArBufferSize + ", mArFractionLostRate=" + this.mArFractionLostRate + ", mArLostRate=" + this.mArLostRate + ", mArE2eLost=" + this.mArE2eLost + ", mArRtt=" + this.mArRtt + ", mArDelay=" + this.mArDelay + ", mArAvgJms=" + this.mArAvgJms + ", mArMaxJms=" + this.mArMaxJms + ", mArVolume=" + this.mArVolume + ", mArVolumeLevel=" + this.mArVolumeLevel + ", mArVolumeLevelSum=" + this.mArVolumeLevelSum + ", mArVolumeLevelRmsA=" + this.mArVolumeLevelRmsA + ", mArVolumeLevelRms=" + this.mArVolumeLevelRms + ", mArProcElapsedAvg=" + this.mArProcElapsedAvg + ", mArProcElapsedMax=" + this.mArProcElapsedMax + '}';
            }
        }
    }

    public static class SystemEnvironment {
        int mActCpuCore;
        float mAppCpu;
        float mAppRam;
        int mEnergyMode;
        int mSchedulElapse;
        int mSigNetLost;
        int mSigQuality;
        int mSigStrength = -1;
        float mSysCpu;
        float mSysRam;
        int mTotalCpuCore;

        public String toString() {
            return "SystemEnvironment{mSysCpu=" + this.mSysCpu + ", mAppCpu=" + this.mAppCpu + ", mSysRam=" + this.mSysRam + ", mAppRam=" + this.mAppRam + ", mSigStrength=" + this.mSigStrength + ", mSigNetLost=" + this.mSigNetLost + ", mSigQuality=" + this.mSigQuality + ", mSchedulElapse=" + this.mSchedulElapse + ", mEnergyMode=" + this.mEnergyMode + ", mActCpuCore=" + this.mActCpuCore + ", mTotalCpuCore=" + this.mTotalCpuCore + '}';
        }
    }

    public static class MediaServerInfo {
        String mAudioID;
        String mAudioIp;
        int mAudioPort;
        int mAudioState;
        String mVideoID;
        String mVideoIp;
        int mVideoPort;
        int mVideoState;

        public String toString() {
            return "{mAudioIp='" + this.mAudioIp + '\'' + ", mAudioPort=" + this.mAudioPort + ", mAudioID='" + this.mAudioID + '\'' + ", mAudioState=" + this.mAudioState + ", mVideoIp='" + this.mVideoIp + '\'' + ", mVideoPort=" + this.mVideoPort + ", mVideoID='" + this.mVideoID + '\'' + ", mVideoState=" + this.mVideoState + '}';
        }
    }

    public static class AecParamsInfo {
        public int delay_estimate;
        public int delay_median;
        public int delay_std;
        public double fraction_poor_delays;
        public String model;
        public int offset;
        public int open_delay_estimate;
        public int pre_offset;
        public boolean valid;
        public int voip_play;
        public int voip_record;

        public String toString() {
            return "{valid=" + this.valid + ", open_delay_estimate=" + this.open_delay_estimate + ", model='" + this.model + '\'' + ", voip_play=" + this.voip_play + ", voip_record=" + this.voip_record + ", pre_offset=" + this.pre_offset + ", offset=" + this.offset + ", delay_estimate=" + this.delay_estimate + ", delay_median=" + this.delay_median + ", delay_std=" + this.delay_std + ", fraction_poor_delays=" + this.fraction_poor_delays + '}';
        }
    }

    public static class VReconnect {
        String mKey;
        int mValue;

        public String toString() {
            return "VReconnect{mKey='" + this.mKey + '\'' + ", mValue=" + this.mValue + '}';
        }
    }

    public static class AReconnect {
        String mKey;
        int mValue;

        public String toString() {
            return "AReconnect{mKey='" + this.mKey + '\'' + ", mValue=" + this.mValue + '}';
        }
    }

    public boolean isJoinedChannel() {
        return this.mJoinedChannel;
    }

    public void collectClientJsonLog(int i, int i2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S", Locale.getDefault());
        ExternalVideoModuleImpl externalVideoModuleImpl = (ExternalVideoModuleImpl) ExternalVideoModule.getInstance();
        ExternalAudioModuleImpl externalAudioModuleImpl = (ExternalAudioModuleImpl) ExternalAudioModule.getInstance();
        LongSparseArray<ExternalAudioModule.AudioStatistics> audioStatistics = externalAudioModuleImpl.getAudioStatistics(this.mChannelName);
        ExternalVideoModule.LocalVideoStatistics localVideoStatistics = externalVideoModuleImpl.getLocalVideoStatistics();
        LongSparseArray<ExternalVideoModule.VideoStatistics> videoStatistics = externalVideoModuleImpl.getVideoStatistics(this.mChannelName);
        InfoBean infoBean = new InfoBean();
        infoBean.mEventName = "sdk_heartbeat";
        long currentTimeMillis = System.currentTimeMillis();
        infoBean.mLogTime = String.valueOf(currentTimeMillis);
        infoBean.mLogTimeStr = simpleDateFormat.format(Long.valueOf(currentTimeMillis));
        infoBean.mAPPID = this.mAppId;
        infoBean.mRoomIDStr = this.mChannelName;
        infoBean.mSessionId = this.mSessionId;
        infoBean.mUserID = String.valueOf(this.mUid);
        infoBean.mConnectID = this.mConnectId;
        int i3 = GlobalConfig.mNetworkType;
        int i4 = this.mRole;
        int i5 = 4;
        infoBean.mRoleType = String.valueOf(1 == i4 ? 1 : 2 == i4 ? 2 : 4);
        infoBean.mSignalReconnectTimes = (int) signalReconnectTimes();
        if (i3 == LocalSDKConstants.PHONE_NETWORK_WIFI) {
            i5 = 0;
        } else if (i3 == LocalSDKConstants.PHONE_NETWORK_4G) {
            i5 = 2;
        } else if (i3 == LocalSDKConstants.PHONE_NETWORK_5G) {
            i5 = 3;
        } else if (i3 == LocalSDKConstants.PHONE_NETWORK_NO_CONNECT) {
            i5 = -1;
        } else if (i3 == LocalSDKConstants.PHONE_NETWORK_3G || i3 == LocalSDKConstants.PHONE_NETWORK_2G) {
            i5 = 1;
        }
        infoBean.mEquipInfo.mUserNet = String.valueOf(i5);
        infoBean.mUserDevInfo = "Android_" + Build.MODEL;
        infoBean.mEquipInfo.mIsBg = GlobalConfig.mAppInBackground ? 1 : 0;
        infoBean.mUosv = String.valueOf(Build.VERSION.SDK_INT);
        infoBean.mSdkPublicVer = GlobalConfig.SDK_VERSION_NAME;
        infoBean.mSdkSignalVer = NativeInitializer.getIntance().getVersion();
        infoBean.mLogVersion = GlobalConfig.LOG_VERSION;
        logD("base infos : " + infoBean.toString());
        String str = GlobalConfig.mAVUploadChannelName;
        logD("begin ------------------------------------ " + this.mChannelName + " | " + str);
        if (GlobalHolder.getInstance().getDeviceManagerForAll() != null) {
            if (this.mChannelName.equals(str)) {
                buildLocalAudioSendInfo(infoBean, i, externalAudioModuleImpl);
                buildLocalSendInfo(infoBean, externalVideoModuleImpl, localVideoStatistics);
            }
            buildRemoteAudioInfo(infoBean, i, externalAudioModuleImpl, audioStatistics);
            buildRemoteVideoInfo(infoBean, externalVideoModuleImpl, videoStatistics);
            buildSystemEnvironment(infoBean, i2);
            buildMediaServerInfo(infoBean);
            buildAecParamsInfo(infoBean);
            if (this.mLogCaches.size() >= 1) {
                this.mLogCaches.poll();
            }
            this.mLogCaches.add(infoBean);
            logD("end ------------------------------------ size ： " + this.mLogCaches.size());
        }
    }

    public void reportClientJsonLog(LinkedList<VideoStuckStatsBean> linkedList) {
        boolean z;
        boolean z2;
        JSONObject jSONObject;
        ReportLogger rtcEventReporter;
        boolean equals = this.mChannelName.equals(GlobalConfig.mAVUploadChannelName);
        InfoBean poll = this.mLogCaches.poll();
        if (poll != null) {
            boolean z3 = false;
            if (equals) {
                List<AudioInfo.AudioSendInfo> list = poll.mAudioInfo.mAudioSendList;
                z2 = list.size() <= 0 || list.get(0).mAsBitrate <= 0;
                List<VideoInfo.VideoSendInfo> list2 = poll.mVideoInfo.mVideoSendList;
                z = list2.size() <= 0 || list2.get(0).mVsBitrate <= 0;
            } else {
                z2 = true;
                z = true;
            }
            String str = null;
            try {
                jSONObject = initJsonString(poll, linkedList);
            } catch (JSONException e) {
                logE("initJsonString Exception happend! msg : " + e.getLocalizedMessage());
                jSONObject = null;
            }
            if (!equals || !this.mAudioEnabled || !this.mAudioLocalEnabled || !this.mAudioLocalStreamEnabled) {
                z2 = false;
            }
            if (equals && this.mVideoEnabled && this.mVideoLocalEnabled && this.mVideoLocalStreamEnabled) {
                z3 = z;
            }
            if ((z3 || z2) && (rtcEventReporter = GlobalHolder.getInstance().getRtcEventReporter(this.mChannelName)) != null) {
                rtcEventReporter.reportVideoNoAVSend(z2, z3, !this.mVideoEnabled);
            }
            if (jSONObject != null) {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("event=sdk_heartbeat ");
                    sb.append(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                    str = sb.toString();
                } catch (Exception e2) {
                    logE("Exception happend! msg : " + e2.getLocalizedMessage());
                    return;
                }
            }
            logI("Report event >>> " + str);
            if (str != null) {
                ReportLogJni.getInstance().ReportLog(str, 16, this.mAppId);
            }
        }
    }

    private void buildLocalSendInfo(InfoBean infoBean, ExternalVideoModuleImpl externalVideoModuleImpl, ExternalVideoModule.LocalVideoStatistics localVideoStatistics) {
        UserDeviceConfig videoDeviceForDefault;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        InfoBean infoBean2 = infoBean;
        ExternalVideoModule.LocalVideoStatistics localVideoStatistics2 = localVideoStatistics;
        infoBean2.mVideoInfo.mVideoSendList.clear();
        RtcDeviceManager deviceManager = GlobalHolder.getInstance().getDeviceManager(this.mChannelName);
        if (deviceManager != null && (videoDeviceForDefault = deviceManager.getVideoDeviceForDefault(this.mUid)) != null) {
            if (localVideoStatistics2 == null) {
                logW("Video upload, src info obj is null!");
                return;
            }
            int i13 = 2;
            boolean isCapturing = externalVideoModuleImpl.isCapturing();
            GlobalVideoConfig globalVideoConfig = GlobalHolder.getInstance().getGlobalVideoConfig();
            int i14 = 0;
            if (globalVideoConfig != null) {
                if (!this.mVideoLocalEnabled || !isCapturing) {
                    i12 = 0;
                    i11 = 0;
                    i10 = 0;
                    i9 = 0;
                } else {
                    i12 = globalVideoConfig.getVideoEncodedMainBr();
                    i11 = globalVideoConfig.getVideoEncodedMainFps();
                    i10 = globalVideoConfig.getVideoEncodedMinorBr();
                    i9 = globalVideoConfig.getVideoEncodedMinorFps();
                }
                int i15 = globalVideoConfig.getVideoEncoderTargetParams()[1];
                int[] videoEncoderSize = globalVideoConfig.getVideoEncoderSize();
                int i16 = videoEncoderSize[0];
                int i17 = videoEncoderSize[1];
                int videoEncoderType = globalVideoConfig.getVideoEncoderType();
                int localVideoTotalSendBitrate = globalVideoConfig.getLocalVideoTotalSendBitrate();
                i8 = i12;
                i13 = videoEncoderType;
                i = i16;
                i2 = i17;
                i3 = i15;
                i4 = i9;
                i5 = i10;
                i6 = i11;
                i7 = localVideoTotalSendBitrate;
            } else {
                i8 = 0;
                i7 = 0;
                i6 = 0;
                i5 = 0;
                i4 = 0;
                i3 = 0;
                i2 = 0;
                i = 0;
            }
            RtcGlobalAVInterface globalAVInterface = GlobalHolder.getInstance().getGlobalAVInterface();
            if (globalAVInterface != null) {
                i14 = globalAVInterface.getLocalVideoSentFps();
            }
            int i18 = i2;
            this.mVideoExternalEncodeRecvFpsBean.mCount = VideoStatus.mVideoExternalEncodeRecvFrameTimes;
            this.mVideoEncodeRecvFpsBean.mCount = VideoStatus.mVideoEncodeRecvFrameTimes;
            this.mVideoEncodeErrorBean.mCount = VideoStatus.mVideoEncodeErrorFrames;
            VideoInfo.VideoSendInfo videoSendInfo = new VideoInfo.VideoSendInfo();
            videoSendInfo.mTs = System.currentTimeMillis();
            videoSendInfo.mVsMediaId = videoDeviceForDefault.getDeviceId();
            videoSendInfo.mVsSsrc = (long) localVideoStatistics2.V_SSRC;
            videoSendInfo.mVsBitrate = (long) Math.round(((float) localVideoStatistics2.V_VBR) / 1024.0f);
            videoSendInfo.mVsTotalBr = i7;
            videoSendInfo.mVsTrgtBr = (long) (i3 / 1000);
            videoSendInfo.mVsResendBr = (long) Math.round(((float) localVideoStatistics2.V_RBR) / 1024.0f);
            videoSendInfo.mVsMainStreamBr = i8;
            videoSendInfo.mVsMinorStreamBr = i5;
            videoSendInfo.mVsSendFps = calcVideoLocalSendFps(VideoStatus.mVideoSendFrames);
            videoSendInfo.mVsFps = i14;
            videoSendInfo.mVsCapFps = calcVideoLocalCapFps(VideoStatus.mVideoCapFrameTimes);
            videoSendInfo.mVsMainStreamFps = i6;
            videoSendInfo.mVsMinorStreamFps = i4;
            videoSendInfo.mVsInFps = MyMathUtils.calcFps(this.mVideoExternalEncodeRecvFpsBean);
            videoSendInfo.mVsEncInputFps = MyMathUtils.calcFps(this.mVideoEncodeRecvFpsBean);
            videoSendInfo.mVsEncFps = calcVideoLocalEncFps(VideoStatus.mVideoEncodeFrames);
            videoSendInfo.mVsEncFailFps = MyMathUtils.calcFps(this.mVideoEncodeErrorBean);
            videoSendInfo.mVsCodecType = i13;
            int i19 = i;
            videoSendInfo.mVsCapWidth = i19;
            int i20 = i18;
            videoSendInfo.mVsCapHeight = i20;
            videoSendInfo.mVsWidth = i19;
            videoSendInfo.mVsHeight = i20;
            videoSendInfo.mVsPkgNum = (long) localVideoStatistics2.V_SENDCOUNT;
            videoSendInfo.mVsFractionLostRate = (float) MyMathUtils.formatNumberDecimal(3, ((double) localVideoStatistics2.V_SENDFRACTIONLOST) / 255.0d);
            videoSendInfo.mVsRtt = localVideoStatistics2.V_RTT;
            videoSendInfo.mVsBuf = externalVideoModuleImpl.getBufferDuration();
            videoSendInfo.mVsEncErr = (int) VideoStatus.mVideoEncodeErrorFrames;
            videoSendInfo.mVsEncNum = externalVideoModuleImpl.getEncodeDataSize();
            videoSendInfo.mVsMute = this.mVideoLocalStreamEnabled ^ true ? 1 : 0;
            videoSendInfo.mVsQp = externalVideoModuleImpl.getLastSliceQp();
            videoSendInfo.mVsCameraAuth = permissionCheck("android.permission.CAMERA");
            videoSendInfo.mVsReConnArray.clear();
            if (this.mVideoReconnectMap.size() > 0) {
                for (Map.Entry next : this.mVideoReconnectMap.entrySet()) {
                    VReconnect vReconnect = new VReconnect();
                    vReconnect.mKey = (String) next.getKey();
                    vReconnect.mValue = ((Integer) next.getValue()).intValue();
                    videoSendInfo.mVsReConnArray.add(vReconnect);
                }
            }
            videoSendInfo.isValid = localVideoStatistics2.isValid;
            videoSendInfo.msIp = localVideoStatistics2.vmsInfo.msIp;
            videoSendInfo.msId = localVideoStatistics2.vmsInfo.msId;
            videoSendInfo.msPort = localVideoStatistics2.vmsInfo.msPort;
            videoSendInfo.msIOType = localVideoStatistics2.vmsInfo.msIOType;
            videoSendInfo.msState = localVideoStatistics2.vmsInfo.msState;
            ArrayList<ExternalVideoModuleImpl.VideoDynamicParam> videoDynamicParamHistory = externalVideoModuleImpl.getVideoDynamicParamHistory();
            if (videoDynamicParamHistory == null || videoDynamicParamHistory.size() <= 0) {
                videoSendInfo.mVsDynamic = 0;
            } else {
                videoSendInfo.mVsDynamic = Math.max(videoDynamicParamHistory.get(videoDynamicParamHistory.size() - 1).bitrate / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 0);
            }
            videoSendInfo.mVsCapStats = isCapturing ? 1 : 0;
            videoSendInfo.mVsPreviewStats = GlobalConfig.mLocalVideoPreview ? 1 : 0;
            videoSendInfo.mVsViewNum = VideoStatus.mLocalVideoEGLDisplaySurfaceNum;
            videoSendInfo.mVsViewAddress = VideoStatus.mLocalVideoRenderViewAttachSize;
            logD("Video upload, send info obj : " + videoSendInfo.toString());
            infoBean2.mVideoInfo.mVideoSendList.add(videoSendInfo);
            this.mLastBuildInfoTime = System.currentTimeMillis();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        r9 = r9.getUser(r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void buildRemoteVideoInfo(com.wushuangtech.log.RtcHeartbeatReporter.InfoBean r21, com.wushuangtech.api.ExternalVideoModule r22, android.util.LongSparseArray<com.wushuangtech.api.ExternalVideoModule.VideoStatistics> r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r23
            com.wushuangtech.log.RtcHeartbeatReporter$VideoInfo r3 = r1.mVideoInfo
            java.util.List<com.wushuangtech.log.RtcHeartbeatReporter$VideoInfo$VideoRecvInfo> r3 = r3.mVideoRecvList
            r3.clear()
            if (r2 != 0) goto L_0x0015
            java.lang.String r1 = "Video download, src infos obj is null!"
            r0.logW(r1)
            return
        L_0x0015:
            int r3 = r23.size()
            if (r3 > 0) goto L_0x001c
            return
        L_0x001c:
            r5 = 0
        L_0x001d:
            if (r5 >= r3) goto L_0x01a2
            long r6 = r2.keyAt(r5)
            java.lang.Object r8 = r2.valueAt(r5)
            com.wushuangtech.api.ExternalVideoModule$VideoStatistics r8 = (com.wushuangtech.api.ExternalVideoModule.VideoStatistics) r8
            if (r8 != 0) goto L_0x0034
            r16 = r5
            r19 = r1
            r1 = r0
            r0 = r19
            goto L_0x0197
        L_0x0034:
            com.wushuangtech.library.GlobalHolder r9 = com.wushuangtech.library.GlobalHolder.getInstance()
            java.lang.String r10 = r0.mChannelName
            com.wushuangtech.api.RtcUserManager r9 = r9.getUserManager(r10)
            if (r9 == 0) goto L_0x004b
            com.wushuangtech.library.User r9 = r9.getUser(r6)
            if (r9 == 0) goto L_0x004b
            boolean r9 = r9.isVideoMuted()
            goto L_0x004c
        L_0x004b:
            r9 = 0
        L_0x004c:
            com.wushuangtech.library.GlobalHolder r10 = com.wushuangtech.library.GlobalHolder.getInstance()
            java.lang.String r11 = r0.mChannelName
            com.wushuangtech.api.RtcDeviceManager r10 = r10.getDeviceManager(r11)
            if (r10 == 0) goto L_0x0063
            com.wushuangtech.library.UserDeviceConfig r10 = r10.getVideoDeviceForDefault(r6)
            if (r10 == 0) goto L_0x0063
            boolean r10 = r10.isUse()
            goto L_0x0064
        L_0x0063:
            r10 = 0
        L_0x0064:
            com.wushuangtech.library.GlobalHolder r11 = com.wushuangtech.library.GlobalHolder.getInstance()
            com.wushuangtech.library.GlobalVideoConfig r11 = r11.getGlobalVideoConfig()
            if (r11 == 0) goto L_0x0090
            java.lang.String r14 = r0.mChannelName
            com.wushuangtech.library.video.bean.VideoRemoteStatsBean r11 = r11.getVideoDecoderStatsBean(r14, r6)
            if (r11 == 0) goto L_0x0090
            int r14 = r11.mDecodedFrameRate
            int r15 = r11.mInputFpsForDecode
            int r4 = r11.mRenderFrameRate
            int r12 = r11.mDecodedElapsed
            long r12 = (long) r12
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Integer> r11 = r11.mDecodedFrameReportRate
            java.lang.Object r11 = r11.peek()
            java.lang.Integer r11 = (java.lang.Integer) r11
            if (r11 == 0) goto L_0x008e
            int r11 = r11.intValue()
            goto L_0x0096
        L_0x008e:
            r11 = 0
            goto L_0x0096
        L_0x0090:
            r4 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r15 = 0
        L_0x0096:
            com.wushuangtech.log.RtcHeartbeatReporter$VideoInfo$VideoRecvInfo r2 = new com.wushuangtech.log.RtcHeartbeatReporter$VideoInfo$VideoRecvInfo
            r2.<init>()
            long r0 = java.lang.System.currentTimeMillis()
            r2.mTs = r0
            java.lang.String r0 = java.lang.String.valueOf(r6)
            r2.mVrSendUserId = r0
            java.lang.String r0 = r8.devId
            r2.mVrMediaId = r0
            int r0 = r8.ssrc
            long r0 = (long) r0
            r2.mVrSsrc = r0
            int r0 = r8.decodeBitrate
            float r0 = (float) r0
            r1 = 1149239296(0x44800000, float:1024.0)
            float r0 = r0 / r1
            int r0 = java.lang.Math.round(r0)
            r16 = r5
            r17 = r6
            long r5 = (long) r0
            r2.mVrBitrate = r5
            int r0 = r8.recvBitrate
            float r0 = (float) r0
            float r0 = r0 / r1
            int r0 = java.lang.Math.round(r0)
            r2.mVrTotalBr = r0
            int r0 = r8.recvFramerate
            long r0 = (long) r0
            r2.mVrFps = r0
            int r0 = r8.recvPkts
            long r0 = (long) r0
            r2.mVrPkgNum = r0
            if (r9 == 0) goto L_0x00da
            r0 = 1
            goto L_0x00dc
        L_0x00da:
            r0 = 0
        L_0x00dc:
            r2.mVrMute = r0
            long r0 = (long) r10
            r2.mVrInuse = r0
            int r0 = r8.fractionLost
            double r0 = (double) r0
            r5 = 4643176031446892544(0x406fe00000000000, double:255.0)
            double r0 = r0 / r5
            r7 = 3
            double r0 = com.wushuangtech.utils.MyMathUtils.formatNumberDecimal((int) r7, (double) r0)
            float r0 = (float) r0
            r2.mVrLostRate = r0
            int r0 = r8.e2e_fraction_lost
            double r0 = (double) r0
            double r0 = r0 / r5
            double r0 = com.wushuangtech.utils.MyMathUtils.formatNumberDecimal((int) r7, (double) r0)
            float r0 = (float) r0
            r2.mVrE2eLost = r0
            int r0 = r8.fractionLost
            double r0 = (double) r0
            double r0 = r0 / r5
            double r0 = com.wushuangtech.utils.MyMathUtils.formatNumberDecimal((int) r7, (double) r0)
            float r0 = (float) r0
            r2.mVrFractionLostRate = r0
            int r0 = r8.rtt
            long r0 = (long) r0
            r2.mVrRtt = r0
            int r0 = r8.jitter
            long r0 = (long) r0
            r2.mVrJitter = r0
            int r0 = r8.delayMS
            long r0 = (long) r0
            r2.mVrDelay = r0
            int r0 = r8.bufferDuration
            long r0 = (long) r0
            r2.mVrBuf = r0
            int r0 = r8.av_sync_diff
            long r0 = (long) r0
            r2.mVrAvDiff = r0
            int r0 = r8.width
            long r0 = (long) r0
            r2.mVrWidth = r0
            int r0 = r8.height
            long r0 = (long) r0
            r2.mVrHeight = r0
            long r0 = (long) r14
            r2.mVrDecFps = r0
            long r0 = (long) r15
            r2.mVrDecInputFps = r0
            long r0 = (long) r4
            r2.mVrRenderFps = r0
            r0 = 0
            r2.mVrDecFailFps = r0
            long r0 = com.wushuangtech.library.video.VideoStatus.mVideoDisplayRenderErrorNum
            r2.mVrRenderErrTimes = r0
            long r0 = com.wushuangtech.library.video.VideoStatus.mVideoEncodeRenderErrorNum
            r2.mVrDecErrTimes = r0
            long r0 = (long) r11
            r2.mVrExternalFps = r0
            r0 = 1000(0x3e8, double:4.94E-321)
            long r12 = r12 * r0
            r2.mVrDecElapsed = r12
            boolean r0 = r8.isValid
            r2.isValid = r0
            com.wushuangtech.api.ExternalVideoModule$VideoMediaServerInfo r0 = r8.vmsInfo
            java.lang.String r0 = r0.msIp
            r2.msIp = r0
            com.wushuangtech.api.ExternalVideoModule$VideoMediaServerInfo r0 = r8.vmsInfo
            java.lang.String r0 = r0.msId
            r2.msId = r0
            com.wushuangtech.api.ExternalVideoModule$VideoMediaServerInfo r0 = r8.vmsInfo
            int r0 = r0.msPort
            r2.msPort = r0
            com.wushuangtech.api.ExternalVideoModule$VideoMediaServerInfo r0 = r8.vmsInfo
            int r0 = r0.msIOType
            r2.msIOType = r0
            com.wushuangtech.api.ExternalVideoModule$VideoMediaServerInfo r0 = r8.vmsInfo
            int r0 = r0.msState
            r2.msState = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Video download, send info obj, id : "
            r0.append(r1)
            r4 = r17
            r0.append(r4)
            java.lang.String r1 = " | obj : "
            r0.append(r1)
            java.lang.String r1 = r2.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = r20
            r1.logD(r0)
            r0 = r21
            com.wushuangtech.log.RtcHeartbeatReporter$VideoInfo r4 = r0.mVideoInfo
            java.util.List<com.wushuangtech.log.RtcHeartbeatReporter$VideoInfo$VideoRecvInfo> r4 = r4.mVideoRecvList
            r4.add(r2)
        L_0x0197:
            int r5 = r16 + 1
            r2 = r23
            r19 = r1
            r1 = r0
            r0 = r19
            goto L_0x001d
        L_0x01a2:
            r1 = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.log.RtcHeartbeatReporter.buildRemoteVideoInfo(com.wushuangtech.log.RtcHeartbeatReporter$InfoBean, com.wushuangtech.api.ExternalVideoModule, android.util.LongSparseArray):void");
    }

    private void buildLocalAudioSendInfo(InfoBean infoBean, int i, ExternalAudioModuleImpl externalAudioModuleImpl) {
        long j;
        int i2;
        int i3;
        int i4;
        long j2;
        long j3;
        int i5;
        float f;
        int i6;
        ExternalAudioModule.LocalAudioStatistics localAudioStatistics;
        int i7;
        long j4;
        int i8;
        long j5;
        long j6;
        int i9;
        int i10;
        infoBean.mAudioInfo.mAudioSendList.clear();
        AudioInfo.AudioSendInfo audioSendInfo = new AudioInfo.AudioSendInfo();
        ExternalAudioModule.LocalAudioStatistics localAudioStatistics2 = externalAudioModuleImpl.getLocalAudioStatistics();
        long totalSendBytes = externalAudioModuleImpl.getTotalSendBytes();
        long GetMicVolumeScale = (long) (externalAudioModuleImpl.GetMicVolumeScale() * 100.0f);
        if (GetMicVolumeScale < 0) {
            GetMicVolumeScale = 0;
        }
        if (localAudioStatistics2 != null) {
            long j7 = localAudioStatistics2.ssrc;
            int i11 = localAudioStatistics2.rttMs;
            int i12 = localAudioStatistics2.capFps;
            int i13 = localAudioStatistics2.encodeInputFps;
            long j8 = localAudioStatistics2.encodeDataSize;
            int i14 = localAudioStatistics2.encodeOutputFps;
            f = (float) localAudioStatistics2.fractionLost;
            long j9 = localAudioStatistics2.asVolumeLevelSum;
            long j10 = localAudioStatistics2.asVolumeLevelRmsSend;
            int i15 = localAudioStatistics2.asVolumeLevelRmsA;
            int i16 = localAudioStatistics2.asVolumeLevelRms;
            long j11 = localAudioStatistics2.aAfterlevelSum;
            int i17 = localAudioStatistics2.asVolumeOriginalLevel;
            int i18 = localAudioStatistics2.asVolumeCallBackAfterLevel;
            int i19 = i17;
            i10 = i11;
            long j12 = j7;
            localAudioStatistics = localAudioStatistics2;
            i6 = localAudioStatistics2.asVolumeCallBackBeforeLevel;
            i9 = i12;
            long j13 = j9;
            i5 = i18;
            j5 = j13;
            int i20 = i13;
            i7 = i14;
            j4 = j8;
            i8 = i20;
            long j14 = j11;
            i2 = i15;
            i3 = i16;
            i4 = i19;
            j = j10;
            j3 = j14;
            j2 = GetMicVolumeScale;
            j6 = j12;
        } else {
            localAudioStatistics = localAudioStatistics2;
            j2 = GetMicVolumeScale;
            f = 0.0f;
            i10 = 0;
            i9 = 0;
            j6 = 0;
            j5 = 0;
            i8 = 0;
            j4 = 0;
            i7 = 0;
            i6 = 0;
            i5 = 0;
            j3 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            j = 0;
        }
        audioSendInfo.mTs = System.currentTimeMillis();
        audioSendInfo.mAsSsrc = j6;
        audioSendInfo.mAsBitrate = calcAudioLocalBitrate(totalSendBytes, i);
        audioSendInfo.mAsCapFps = i9;
        audioSendInfo.mAsCapDataLen = externalAudioModuleImpl.getCaptureDataSzie();
        audioSendInfo.mAsEncInputFps = i8;
        audioSendInfo.mAsEncDataLen = j4;
        audioSendInfo.mAsEncOutputFps = i7;
        audioSendInfo.mAsFractionLostRate = MyMathUtils.formatNumberDecimal(3, f / 255.0f);
        audioSendInfo.mAsRtt = (long) i10;
        audioSendInfo.mAsIsLocalMute = externalAudioModuleImpl.isLocalMuted() ? 1 : 0;
        audioSendInfo.mAsIsMutedRemoteAll = externalAudioModuleImpl.IsAllRemoteAudioMuted() ? 1 : 0;
        audioSendInfo.mAsMutedDur = 0;
        audioSendInfo.mAsVolumeLevelSum = j5;
        audioSendInfo.mAsVolumeLevelRmsSend = j;
        audioSendInfo.mAsVolumeLevelRmsA = i2;
        audioSendInfo.mAsVolumeLevelRms = i3;
        audioSendInfo.mAsVolume = getAudioLevel(this.mUid);
        audioSendInfo.mAsVolumeLevel = j2;
        audioSendInfo.mAsVolumeAfter3A = j3;
        audioSendInfo.mAsVolumeOriginalLevel = i4;
        audioSendInfo.mAsVolumeCallBackAfterLevel = i5;
        audioSendInfo.mAsVolumeCallBackBeforeLevel = i6;
        audioSendInfo.mAsCapStat = externalAudioModuleImpl.isCapturing() ? 1 : 0;
        audioSendInfo.mAsSpeakingState = GlobalConfig.mSpeakStatus == 3 ? 1 : 0;
        audioSendInfo.mAsPreSetBr = GlobalConfig.mServerAudioBitrate;
        audioSendInfo.mAsMicAuth = permissionCheck("android.permission.RECORD_AUDIO");
        audioSendInfo.mAsReConnTimes.clear();
        if (this.mAudioReconnectMap.size() > 0) {
            for (Map.Entry next : this.mAudioReconnectMap.entrySet()) {
                AReconnect aReconnect = new AReconnect();
                aReconnect.mKey = (String) next.getKey();
                aReconnect.mValue = ((Integer) next.getValue()).intValue();
                audioSendInfo.mAsReConnTimes.add(aReconnect);
            }
        }
        audioSendInfo.mSendA_RECVERROR = (long) externalAudioModuleImpl.getUserErrorTimes();
        audioSendInfo.mSendA_MAXERRORUID = externalAudioModuleImpl.getMaxErrorUserid();
        audioSendInfo.mSendA_RECVERRORTIME = (long) externalAudioModuleImpl.getDataErrorTimes();
        audioSendInfo.mSendA_MUTEFRAME = (long) externalAudioModuleImpl.getSizeOfMuteAudioPlayed();
        audioSendInfo.mSendAUDIO_FOCUS = GlobalConfig.mLocalAudioFocus;
        audioSendInfo.mOutAudioProcessEffeciency = GlobalConfig.mLocalAudioDataProcessAvgEffeciency + "_" + GlobalConfig.mRemoteAudioDataProcessAvgEffeciency + "_" + GlobalConfig.mMixAudioDataProcessAvgEffeciency;
        if (localAudioStatistics != null) {
            ExternalAudioModule.LocalAudioStatistics localAudioStatistics3 = localAudioStatistics;
            audioSendInfo.mErl = localAudioStatistics3.erl;
            audioSendInfo.mErle = localAudioStatistics3.eRle;
            audioSendInfo.mANlp = localAudioStatistics3.aNlp;
            audioSendInfo.mDelayMedian = localAudioStatistics3.delayMedian;
            audioSendInfo.mDelayStd = localAudioStatistics3.delayStd;
            audioSendInfo.mFractionPoorDelays = localAudioStatistics3.fractionPoorDelays;
            audioSendInfo.mReportType = localAudioStatistics3.reportType;
        }
        logD("Audio upload, send info obj : " + audioSendInfo.toString());
        infoBean.mAudioInfo.mAudioSendList.add(audioSendInfo);
    }

    private void buildRemoteAudioInfo(InfoBean infoBean, int i, ExternalAudioModuleImpl externalAudioModuleImpl, LongSparseArray<ExternalAudioModule.AudioStatistics> longSparseArray) {
        int i2;
        boolean z;
        int i3;
        User user;
        InfoBean infoBean2 = infoBean;
        ExternalAudioModuleImpl externalAudioModuleImpl2 = externalAudioModuleImpl;
        LongSparseArray<ExternalAudioModule.AudioStatistics> longSparseArray2 = longSparseArray;
        infoBean2.mAudioInfo.mAudioRecvList.clear();
        if (longSparseArray2 == null) {
            logW("Audio download, src info objs is null!");
            return;
        }
        int size = longSparseArray.size();
        if (size > 0) {
            syncLastCacheData(longSparseArray2);
            int i4 = 0;
            while (i4 < size) {
                long keyAt = longSparseArray2.keyAt(i4);
                ExternalAudioModule.AudioStatistics valueAt = longSparseArray2.valueAt(i4);
                if (valueAt == null) {
                    logW("Audio download, src info obj is null! id : " + keyAt);
                    i2 = size;
                } else {
                    RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(this.mChannelName);
                    if (userManager == null || (user = userManager.getUser(keyAt)) == null) {
                        i3 = 0;
                        z = false;
                    } else {
                        boolean isAudioMuted = user.isAudioMuted();
                        i3 = user.getLastAudioLastJitterMs();
                        z = isAudioMuted;
                    }
                    AudioInfo.AudioRecvInfo audioRecvInfo = new AudioInfo.AudioRecvInfo();
                    audioRecvInfo.mTs = System.currentTimeMillis();
                    audioRecvInfo.mSendUserId = String.valueOf(keyAt);
                    audioRecvInfo.mArSsrc = valueAt.ssrc;
                    int i5 = i3;
                    AudioInfo.AudioRecvInfo audioRecvInfo2 = audioRecvInfo;
                    i2 = size;
                    RtcUserManager rtcUserManager = userManager;
                    audioRecvInfo2.mArBitrate = (long) calcAudioRemoteBitrate(keyAt, valueAt.recvLength, i);
                    audioRecvInfo2.mArFps = valueAt.recvFps;
                    audioRecvInfo2.mArDecInputFps = valueAt.decoderInputFps;
                    audioRecvInfo2.mArDecOutputFps = valueAt.decoderOutputFps;
                    audioRecvInfo2.mArRenderFps = valueAt.renderOutputFps;
                    audioRecvInfo2.mArSysPlayoutFps = valueAt.arSysPlayoutFps;
                    audioRecvInfo2.mArDecodeLen = valueAt.decodedLength;
                    audioRecvInfo2.mArDecElapsed = valueAt.decodeDur * 1000;
                    long j = 1;
                    audioRecvInfo2.mArIsRemoteUserMute = z ? 1 : 0;
                    if (!externalAudioModuleImpl2.RemoteAudioMutedByMyself(keyAt)) {
                        j = 0;
                    }
                    audioRecvInfo2.mArIsLocalMute = j;
                    audioRecvInfo2.mArBufferSize = (long) valueAt.jitterBufferMs;
                    audioRecvInfo2.mArFractionLostRate = (float) MyMathUtils.formatNumberDecimal(3, ((double) valueAt.fractionLost) / 255.0d);
                    audioRecvInfo2.mArLostRate = (float) MyMathUtils.formatNumberDecimal(3, ((double) valueAt.fractionLost) / 16384.0d);
                    audioRecvInfo2.mArE2eLost = CropImageView.DEFAULT_ASPECT_RATIO;
                    audioRecvInfo2.mArRtt = (long) valueAt.rttMs;
                    audioRecvInfo2.mArDelay = (long) valueAt.delayMs;
                    audioRecvInfo2.mArAvgJms = (long) valueAt.bufferDuration;
                    audioRecvInfo2.mArMaxJms = (long) Math.max(valueAt.bufferDuration, i5);
                    audioRecvInfo2.mArVolume = (long) (externalAudioModuleImpl2.GetRemoteVolumeScale(keyAt) * 100.0f);
                    audioRecvInfo2.mArVolumeLevel = (long) getAudioLevel(keyAt);
                    audioRecvInfo2.mArVolumeLevelSum = (long) valueAt.arVolumeLevelSum;
                    audioRecvInfo2.mArVolumeLevelRmsA = valueAt.arVolumeLevelRmsA;
                    audioRecvInfo2.mArVolumeLevelRms = valueAt.arVolumeLevelRms;
                    audioRecvInfo2.mArProcElapsedAvg = (long) valueAt.arProcElapsedAvg;
                    audioRecvInfo2.mArProcElapsedMax = (long) valueAt.arProcElapsedMax;
                    logD("Audio download, send info obj, id : " + keyAt + " | obj : " + audioRecvInfo2.toString());
                    infoBean2.mAudioInfo.mAudioRecvList.add(audioRecvInfo2);
                    if (rtcUserManager != null && valueAt.bufferDuration > i5) {
                        rtcUserManager.updateLastAudioJitterMs(keyAt, valueAt.bufferDuration);
                    }
                }
                i4++;
                longSparseArray2 = longSparseArray;
                size = i2;
            }
        }
    }

    private void buildSystemEnvironment(InfoBean infoBean, int i) {
        DeviceUtils deviceUtils;
        float f;
        GlobalChannelConfig globalChannelConfig = GlobalHolder.getInstance().getGlobalChannelConfig();
        if (globalChannelConfig != null && (deviceUtils = globalChannelConfig.getDeviceUtils()) != null) {
            float sysUsedMemory = deviceUtils.getSysUsedMemory();
            float f2 = CropImageView.DEFAULT_ASPECT_RATIO;
            if (sysUsedMemory == CropImageView.DEFAULT_ASPECT_RATIO) {
                infoBean.mSystemEnvironment.mSysRam = -1.0f;
            } else {
                infoBean.mSystemEnvironment.mSysRam = MyMathUtils.formatNumberDecimal(3, sysUsedMemory);
            }
            float appUsedMemory = deviceUtils.getAppUsedMemory();
            infoBean.mSystemEnvironment.mAppRam = MyMathUtils.formatNumberDecimal(3, appUsedMemory);
            if (Build.VERSION.SDK_INT >= 26) {
                f = (float) MyMathUtils.formatNumberDecimal(3, RoomJni.getInstance().getCpuUsage());
                infoBean.mSystemEnvironment.mSysCpu = CropImageView.DEFAULT_ASPECT_RATIO;
            } else {
                infoBean.mSystemEnvironment.mSysCpu = MyMathUtils.formatNumberDecimal(3, (float) deviceUtils.getSysCpuUsedRate());
                f2 = (float) deviceUtils.getAppCpuUsedRate();
                f = MyMathUtils.formatNumberDecimal(3, f2);
            }
            infoBean.mSystemEnvironment.mAppCpu = f;
            int i2 = GlobalConfig.mNetTestSigStrength;
            if (i2 == 0) {
                i2 = -1;
            }
            infoBean.mSystemEnvironment.mSigStrength = i2;
            infoBean.mSystemEnvironment.mSigNetLost = GlobalConfig.mNetTestSigLost;
            infoBean.mSystemEnvironment.mSigQuality = GlobalConfig.mNetTestSigQuality;
            infoBean.mSystemEnvironment.mSchedulElapse = i;
            infoBean.mSystemEnvironment.mEnergyMode = PhoneUtils.isPowerSaveMode(GlobalHolder.getInstance().getContext());
            infoBean.mSystemEnvironment.mActCpuCore = RoomJni.getInstance().GetCpuInfo(2);
            infoBean.mSystemEnvironment.mTotalCpuCore = RoomJni.getInstance().GetCpuInfo(1);
            this.mAppRunTime++;
            reportCpuUsage((double) f);
            reportMemUsage(appUsedMemory);
            logD("System info : " + infoBean.mSystemEnvironment.toString() + " | appCpuUsedRate : " + f + " | tempAppCpuUsedRate : " + f2);
        }
    }

    private int getAudioLevel(long j) {
        User user;
        RtcUserManager userManager = GlobalHolder.getInstance().getUserManager(this.mChannelName);
        if (userManager == null || (user = userManager.getUser(j)) == null) {
            return 0;
        }
        return user.getAudioLevel();
    }

    private void reportCpuUsage(double d) {
        this.mAppTotalCpuUsage = (float) (((double) this.mAppTotalCpuUsage) + d);
        if (((double) this.mLastMaxAppCpuUsage) < d) {
            float f = (float) d;
            GlobalConfig.mCpuMaxUseage = f;
            this.mLastMaxAppCpuUsage = f;
        }
        GlobalConfig.mCpuAvgUseage = MyMathUtils.formatNumberDecimal(3, this.mAppTotalCpuUsage / ((float) this.mAppRunTime));
        GlobalConfig.mCpuUseage = (float) d;
    }

    private void reportMemUsage(float f) {
        this.mAppTotalMemUsage += f;
        if (this.mLastMaxAppMemUsage < f) {
            GlobalConfig.mMemMaxUseage = f;
            this.mLastMaxAppMemUsage = f;
        }
        GlobalConfig.mMemAvgUseage = MyMathUtils.formatNumberDecimal(3, this.mAppTotalMemUsage / ((float) this.mAppRunTime));
        GlobalConfig.mMemUseage = f;
    }

    private void buildMediaServerInfo(InfoBean infoBean) {
        infoBean.mMediaServerInfo.mAudioIp = this.mAudioLinkIp;
        infoBean.mMediaServerInfo.mAudioPort = this.mAudioLinkPort;
        infoBean.mMediaServerInfo.mAudioID = this.mAudioServerId;
        infoBean.mMediaServerInfo.mAudioState = this.mAudioState;
        infoBean.mMediaServerInfo.mVideoIp = this.mVideoLinkIp;
        infoBean.mMediaServerInfo.mVideoPort = this.mVideoLinkPort;
        infoBean.mMediaServerInfo.mVideoID = this.mVideoServerId;
        infoBean.mMediaServerInfo.mVideoState = this.mVideoState;
        logD("Media info : " + infoBean.mMediaServerInfo.toString());
    }

    private void buildAecParamsInfo(InfoBean infoBean) {
        ExternalAudioModule.AecParams aecStats = ((ExternalAudioModuleImpl) ExternalAudioModule.getInstance()).getAecStats();
        ExternalAudioModule.AecDelayMetrics aecDelayMetrics = ((ExternalAudioModuleImpl) ExternalAudioModule.getInstance()).getAecDelayMetrics();
        if (aecStats != null && aecStats.valid) {
            infoBean.mAecParamsInfo.valid = true;
            infoBean.mAecParamsInfo.open_delay_estimate = aecStats.open_delay_estimate;
            infoBean.mAecParamsInfo.model = aecStats.model;
            infoBean.mAecParamsInfo.voip_play = aecStats.voip_play;
            infoBean.mAecParamsInfo.voip_record = aecStats.voip_record;
            infoBean.mAecParamsInfo.pre_offset = aecStats.pre_offset;
            infoBean.mAecParamsInfo.offset = aecStats.offset;
            infoBean.mAecParamsInfo.delay_estimate = aecStats.delay_estimate;
            if (aecDelayMetrics != null) {
                infoBean.mAecParamsInfo.delay_median = aecDelayMetrics.delay_median;
                infoBean.mAecParamsInfo.delay_std = aecDelayMetrics.delay_std;
                infoBean.mAecParamsInfo.fraction_poor_delays = aecDelayMetrics.fraction_poor_delays;
            }
            logD("Aec info : " + infoBean.mAecParamsInfo.toString());
        }
    }

    private void syncLastCacheData(LongSparseArray<ExternalAudioModule.AudioStatistics> longSparseArray) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        int size = this.mLastAudioCaches.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                long keyAt = this.mLastAudioCaches.keyAt(i);
                int i2 = 0;
                while (true) {
                    if (i2 >= longSparseArray.size()) {
                        z = false;
                        break;
                    } else if (longSparseArray.keyAt(i2) == keyAt) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z) {
                    arrayList.add(Long.valueOf(keyAt));
                }
            }
            int size2 = arrayList.size();
            if (size2 > 0) {
                for (int i3 = 0; i3 < size2; i3++) {
                    this.mLastAudioCaches.remove(((Long) arrayList.get(i3)).longValue());
                }
            }
        }
    }

    private JSONObject initJsonString(InfoBean infoBean, LinkedList<VideoStuckStatsBean> linkedList) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        addRootObj(infoBean, jSONObject);
        addEquipInfoObj(infoBean, jSONObject);
        addVideoInfoObj(infoBean, linkedList, jSONObject);
        addAudioInfoObj(infoBean, jSONObject);
        addSysEnviroment(infoBean, jSONObject);
        addMediaServerInfo(infoBean, jSONObject);
        addAecParamsInfo(infoBean, jSONObject);
        return jSONObject;
    }

    private void addRootObj(InfoBean infoBean, JSONObject jSONObject) throws JSONException {
        jSONObject.put("event", infoBean.mEventName);
        jSONObject.put("ts", infoBean.mLogTime);
        jSONObject.put("time", infoBean.mLogTimeStr);
        jSONObject.put("appId", infoBean.mAPPID);
        jSONObject.put("roomStr", infoBean.mRoomIDStr);
        jSONObject.put("sid", infoBean.mSessionId);
        jSONObject.put("uid", infoBean.mUserID);
        jSONObject.put("connId", infoBean.mConnectID);
        jSONObject.put("uRole", infoBean.mRoleType);
        jSONObject.put("signalReconnTimes", infoBean.mSignalReconnectTimes);
        jSONObject.put("userDevInfo", infoBean.mUserDevInfo);
        jSONObject.put("uosv", infoBean.mUosv);
        jSONObject.put("sdkPublicVer", infoBean.mSdkPublicVer);
        jSONObject.put("sdkSignalVer", infoBean.mSdkSignalVer);
        jSONObject.put("logVersion", infoBean.mLogVersion);
    }

    private void addEquipInfoObj(InfoBean infoBean, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("userDev", jSONObject2);
        jSONObject2.put("userNet", infoBean.mEquipInfo.mUserNet);
        jSONObject2.put("isBg", infoBean.mEquipInfo.mIsBg);
    }

    private void addVideoInfoObj(InfoBean infoBean, LinkedList<VideoStuckStatsBean> linkedList, JSONObject jSONObject) throws JSONException {
        List<VideoInfo.VideoRecvInfo> list;
        InfoBean infoBean2 = infoBean;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("videoInfo", jSONObject2);
        String str = "ts";
        if (infoBean2.mVideoInfo.mVideoSendList.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            jSONObject2.put("videoSend", jSONArray);
            List<VideoInfo.VideoSendInfo> list2 = infoBean2.mVideoInfo.mVideoSendList;
            int i = 0;
            while (i < list2.size()) {
                JSONObject jSONObject3 = new JSONObject();
                VideoInfo.VideoSendInfo videoSendInfo = list2.get(i);
                jSONObject3.put(str, videoSendInfo.mTs);
                jSONObject3.put("vsMediaId", videoSendInfo.mVsMediaId);
                List<VideoInfo.VideoSendInfo> list3 = list2;
                jSONObject3.put("vsSsrc", videoSendInfo.mVsSsrc);
                jSONObject3.put("vsBitrate", videoSendInfo.mVsBitrate);
                jSONObject3.put("vsTotalBr", videoSendInfo.mVsTotalBr);
                jSONObject3.put("vsTrgtBr", videoSendInfo.mVsTrgtBr);
                jSONObject3.put("vsResendBr", videoSendInfo.mVsResendBr);
                jSONObject3.put("vsMainStreamBr", videoSendInfo.mVsMainStreamBr);
                jSONObject3.put("vsMinorStreamBr", videoSendInfo.mVsMinorStreamBr);
                jSONObject3.put("vsSendFps", videoSendInfo.mVsSendFps);
                jSONObject3.put("vsFps", videoSendInfo.mVsFps);
                jSONObject3.put("vsCapFps", videoSendInfo.mVsCapFps);
                jSONObject3.put("vsMainStreamFps", videoSendInfo.mVsMainStreamFps);
                jSONObject3.put("vsMinorStreamFps", videoSendInfo.mVsMinorStreamFps);
                jSONObject3.put("vsInFps", videoSendInfo.mVsInFps);
                jSONObject3.put("vsEncInputFps", videoSendInfo.mVsEncInputFps);
                jSONObject3.put("vsEncFps", videoSendInfo.mVsEncFps);
                jSONObject3.put("vsEncFailFps", videoSendInfo.mVsEncFailFps);
                jSONObject3.put("vsCodecType", videoSendInfo.mVsCodecType);
                jSONObject3.put("vsCapWidth", videoSendInfo.mVsCapWidth);
                jSONObject3.put("vsCapHeight", videoSendInfo.mVsCapHeight);
                jSONObject3.put("vsWidth", videoSendInfo.mVsWidth);
                jSONObject3.put("vsHeight", videoSendInfo.mVsHeight);
                jSONObject3.put("vsPkgNum", videoSendInfo.mVsPkgNum);
                jSONObject3.put("vsFractionLostRate", (double) videoSendInfo.mVsFractionLostRate);
                jSONObject3.put("vsRtt", videoSendInfo.mVsRtt);
                jSONObject3.put("vsBuf", videoSendInfo.mVsBuf);
                jSONObject3.put("vsEncErr", videoSendInfo.mVsEncErr);
                jSONObject3.put("vsEncNum", videoSendInfo.mVsEncNum);
                jSONObject3.put("vsMute", videoSendInfo.mVsMute);
                jSONObject3.put("vsQp", videoSendInfo.mVsQp);
                jSONObject3.put("vsCameraAuth", videoSendInfo.mVsCameraAuth);
                JSONArray jSONArray2 = new JSONArray();
                jSONObject3.put("vsReConnArray", jSONArray2);
                Iterator<VReconnect> it = videoSendInfo.mVsReConnArray.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    Iterator<VReconnect> it2 = it;
                    VReconnect next = it.next();
                    String str2 = str;
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("connIp", next.mKey);
                    jSONObject4.put("connTimes", next.mValue);
                    jSONArray2.put(jSONObject4);
                    i2 += next.mValue;
                    InfoBean infoBean3 = infoBean;
                    str = str2;
                    it = it2;
                    jSONObject2 = jSONObject2;
                }
                JSONObject jSONObject5 = jSONObject2;
                String str3 = str;
                jSONObject3.put("vsReConnTimes", i2);
                if (videoSendInfo.isValid) {
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject3.put("msInfo", jSONObject6);
                    jSONObject6.put("vsIp", videoSendInfo.msIp);
                    jSONObject6.put("vsPort", videoSendInfo.msPort);
                    jSONObject6.put("vChanState", videoSendInfo.msState);
                    jSONObject6.put("vChanIOType", videoSendInfo.msIOType);
                }
                jSONObject3.put("vsDynamics", videoSendInfo.mVsDynamic);
                jSONObject3.put("vsCapStat", videoSendInfo.mVsCapStats);
                jSONObject3.put("vsPreview", videoSendInfo.mVsPreviewStats);
                jSONObject3.put("vsView", videoSendInfo.mVsViewNum);
                jSONObject3.put("vsViewAddress", videoSendInfo.mVsViewAddress);
                jSONArray.put(jSONObject3);
                checkLogContent("Video upload check", jSONObject3, VIDEO_UPLOAD_KEY);
                i++;
                InfoBean infoBean4 = infoBean;
                list2 = list3;
                str = str3;
                jSONObject2 = jSONObject5;
            }
        }
        JSONObject jSONObject7 = jSONObject2;
        String str4 = str;
        InfoBean infoBean5 = infoBean;
        if (infoBean5.mVideoInfo.mVideoRecvList.size() > 0) {
            JSONArray jSONArray3 = new JSONArray();
            jSONObject7.put("videoRecv", jSONArray3);
            int i3 = 0;
            for (List<VideoInfo.VideoRecvInfo> list4 = infoBean5.mVideoInfo.mVideoRecvList; i3 < list4.size(); list4 = list) {
                JSONObject jSONObject8 = new JSONObject();
                VideoInfo.VideoRecvInfo videoRecvInfo = list4.get(i3);
                String str5 = str4;
                jSONObject8.put(str5, videoRecvInfo.mTs);
                jSONObject8.put("sendUserId", videoRecvInfo.mVrSendUserId);
                jSONObject8.put("vrMediaId", videoRecvInfo.mVrMediaId);
                jSONObject8.put("vrSsrc", videoRecvInfo.mVrSsrc);
                jSONObject8.put("vrFps", videoRecvInfo.mVrFps);
                jSONObject8.put("vrWidth", videoRecvInfo.mVrWidth);
                jSONObject8.put("vrHeight", videoRecvInfo.mVrHeight);
                jSONObject8.put("vrBitrate", videoRecvInfo.mVrBitrate);
                jSONObject8.put("vrTotalBr", videoRecvInfo.mVrTotalBr);
                jSONObject8.put("vrPkgNum", videoRecvInfo.mVrPkgNum);
                jSONObject8.put("vrLostRate", (double) videoRecvInfo.mVrLostRate);
                jSONObject8.put("vrRtt", videoRecvInfo.mVrRtt);
                jSONObject8.put("vrJitter", videoRecvInfo.mVrJitter);
                jSONObject8.put("vrDelay", videoRecvInfo.mVrDelay);
                jSONObject8.put("vrBuf", videoRecvInfo.mVrBuf);
                jSONObject8.put("vrFractionLostRate", (double) videoRecvInfo.mVrFractionLostRate);
                jSONObject8.put("vrMute", videoRecvInfo.mVrMute);
                jSONObject8.put("vrAvDiff", videoRecvInfo.mVrAvDiff);
                jSONObject8.put("vrInuse", videoRecvInfo.mVrInuse);
                jSONObject8.put("vrRenderFps", videoRecvInfo.mVrRenderFps);
                jSONObject8.put("vrRenderErrTimes", videoRecvInfo.mVrRenderErrTimes);
                jSONObject8.put("vrDecInputFps", videoRecvInfo.mVrDecInputFps);
                jSONObject8.put("vrDecFps", videoRecvInfo.mVrDecFps);
                jSONObject8.put("vrDecFailFps", videoRecvInfo.mVrDecFailFps);
                jSONObject8.put("vrDecErrTimes", videoRecvInfo.mVrDecErrTimes);
                jSONObject8.put("vrExternalFps", videoRecvInfo.mVrExternalFps);
                jSONObject8.put("vrDecElapsed", videoRecvInfo.mVrDecElapsed);
                jSONObject8.put("vrE2eLost", (double) videoRecvInfo.mVrE2eLost);
                JSONArray addVideoRecvStuckInfo = addVideoRecvStuckInfo(videoRecvInfo.mVrSendUserId, linkedList);
                if (addVideoRecvStuckInfo == null) {
                    jSONObject8.put("vrVideoFreeze", "");
                    list = list4;
                } else {
                    jSONObject8.put("vrVideoFreeze", addVideoRecvStuckInfo);
                    String str6 = this.TAG;
                    list = list4;
                    StringBuilder sb = new StringBuilder();
                    sb.append("Heartbeat report video down link, channelName: ");
                    sb.append(infoBean5.mRoomIDStr);
                    sb.append(", uid: ");
                    sb.append(videoRecvInfo.mVrSendUserId);
                    sb.append(", mediaId: ");
                    sb.append(videoRecvInfo.mVrMediaId);
                    sb.append(", freeze: ");
                    sb.append(!(addVideoRecvStuckInfo instanceof JSONArray) ? addVideoRecvStuckInfo.toString() : JSONArrayInstrumentation.toString(addVideoRecvStuckInfo));
                    OmniLog.i("VIDEO_DOWNLOAD_FREEZE", str6, sb.toString());
                }
                if (videoRecvInfo.isValid) {
                    JSONObject jSONObject9 = new JSONObject();
                    jSONObject8.put("msInfo", jSONObject9);
                    jSONObject9.put("vsIp", videoRecvInfo.msIp);
                    jSONObject9.put("vsPort", videoRecvInfo.msPort);
                    jSONObject9.put("vChanState", videoRecvInfo.msState);
                    jSONObject9.put("vChanIOType", videoRecvInfo.msIOType);
                }
                jSONArray3.put(jSONObject8);
                checkLogContent("Video download check", jSONObject8, VIDEO_DOWNLOAD_KEY);
                i3++;
                str4 = str5;
            }
        }
    }

    private JSONArray addVideoRecvStuckInfo(String str, LinkedList<VideoStuckStatsBean> linkedList) {
        JSONArray jSONArray = new JSONArray();
        if (linkedList == null) {
            return null;
        }
        try {
            if (linkedList.size() <= 0) {
                return null;
            }
            long parseLong = Long.parseLong(str);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                VideoStuckStatsBean videoStuckStatsBean = (VideoStuckStatsBean) it.next();
                if (videoStuckStatsBean != null) {
                    if (videoStuckStatsBean.mUid == parseLong) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("ts", videoStuckStatsBean.mTimeStamp);
                        jSONObject.put("stat", videoStuckStatsBean.mStats);
                        if (videoStuckStatsBean.mStats == 1) {
                            jSONObject.put("freezeDur", videoStuckStatsBean.mStuckMs);
                        }
                        jSONArray.put(jSONObject);
                    }
                }
            }
            return jSONArray;
        } catch (JSONException e) {
            String str2 = this.TAG;
            OmniLog.e("VIDEO_DOWNLOAD_FREEZE", str2, "Failed to report heartbeat video down link freeze, exception: " + e.getLocalizedMessage());
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void addAudioInfoObj(com.wushuangtech.log.RtcHeartbeatReporter.InfoBean r20, org.json.JSONObject r21) throws org.json.JSONException {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            java.lang.String r3 = "audioInfo"
            r4 = r21
            r4.put(r3, r2)
            com.wushuangtech.log.RtcHeartbeatReporter$AudioInfo r3 = r1.mAudioInfo
            java.util.List<com.wushuangtech.log.RtcHeartbeatReporter$AudioInfo$AudioSendInfo> r3 = r3.mAudioSendList
            int r3 = r3.size()
            java.lang.String r5 = "aChanIOType"
            java.lang.String r6 = "aChanState"
            java.lang.String r7 = "asPort"
            java.lang.String r8 = "asIp"
            java.lang.String r9 = "msInfo"
            java.lang.String r10 = "ts"
            r11 = 0
            if (r3 <= 0) goto L_0x01d6
            org.json.JSONArray r3 = new org.json.JSONArray
            r3.<init>()
            java.lang.String r12 = "audioSend"
            r2.put(r12, r3)
            org.json.JSONObject r12 = new org.json.JSONObject
            r12.<init>()
            com.wushuangtech.log.RtcHeartbeatReporter$AudioInfo r13 = r1.mAudioInfo
            java.util.List<com.wushuangtech.log.RtcHeartbeatReporter$AudioInfo$AudioSendInfo> r13 = r13.mAudioSendList
            int r14 = r13.size()
            if (r14 <= 0) goto L_0x01d6
            java.lang.Object r13 = r13.get(r11)
            com.wushuangtech.log.RtcHeartbeatReporter$AudioInfo$AudioSendInfo r13 = (com.wushuangtech.log.RtcHeartbeatReporter.AudioInfo.AudioSendInfo) r13
            long r14 = r13.mTs
            r12.put(r10, r14)
            long r14 = r13.mAsSsrc
            java.lang.String r11 = "asSsrc"
            r12.put(r11, r14)
            int r11 = r13.mAsBitrate
            java.lang.String r14 = "asBitrate"
            r12.put(r14, r11)
            int r11 = r13.mAsCapFps
            java.lang.String r14 = "asCapFps"
            r12.put(r14, r11)
            long r14 = r13.mAsCapDataLen
            java.lang.String r11 = "asCapDataLen"
            r12.put(r11, r14)
            int r11 = r13.mAsEncInputFps
            java.lang.String r14 = "asEncInputFps"
            r12.put(r14, r11)
            long r14 = r13.mAsEncDataLen
            java.lang.String r11 = "asEncDataLen"
            r12.put(r11, r14)
            int r11 = r13.mAsEncOutputFps
            java.lang.String r14 = "asEncOutputFps"
            r12.put(r14, r11)
            int r11 = r13.mAsIsLocalMute
            java.lang.String r14 = "asIsLocalMute"
            r12.put(r14, r11)
            int r11 = r13.mAsIsMutedRemoteAll
            java.lang.String r14 = "asIsMutedRemoteAll"
            r12.put(r14, r11)
            long r14 = r13.mAsMutedDur
            java.lang.String r11 = "asMutedDur"
            r12.put(r11, r14)
            float r11 = r13.mAsFractionLostRate
            double r14 = (double) r11
            java.lang.String r11 = "asFractionLostRate"
            r12.put(r11, r14)
            long r14 = r13.mAsRtt
            java.lang.String r11 = "asRtt"
            r12.put(r11, r14)
            long r14 = r13.mAsVolumeLevelSum
            java.lang.String r11 = "asVolumeLevelSum"
            r12.put(r11, r14)
            long r14 = r13.mAsVolumeLevelRmsSend
            java.lang.String r11 = "asVolumeLevelRmsSend"
            r12.put(r11, r14)
            int r11 = r13.mAsVolumeLevelRmsA
            java.lang.String r14 = "asVolumeLevelRmsA"
            r12.put(r14, r11)
            int r11 = r13.mAsVolumeLevelRms
            java.lang.String r14 = "asVolumeLevelRms"
            r12.put(r14, r11)
            int r11 = r13.mAsVolume
            java.lang.String r14 = "asVolume"
            r12.put(r14, r11)
            long r14 = r13.mAsVolumeLevel
            java.lang.String r11 = "asVolumeLevel"
            r12.put(r11, r14)
            long r14 = r13.mAsVolumeAfter3A
            java.lang.String r11 = "asVolumeAfter3A"
            r12.put(r11, r14)
            int r11 = r13.mAsVolumeOriginalLevel
            java.lang.String r14 = "asVolumeOriginalLevel"
            r12.put(r14, r11)
            int r11 = r13.mAsVolumeCallBackAfterLevel
            java.lang.String r14 = "asVolumCallBackAfterLevel"
            r12.put(r14, r11)
            int r11 = r13.mAsVolumeCallBackBeforeLevel
            java.lang.String r14 = "asVolumCallBackBeforeLevel"
            r12.put(r14, r11)
            int r11 = r13.mAsCapStat
            java.lang.String r14 = "asCapStat"
            r12.put(r14, r11)
            int r11 = r13.mAsSpeakingState
            java.lang.String r14 = "asSpeakingState"
            r12.put(r14, r11)
            int r11 = r13.mAsPreSetBr
            java.lang.String r14 = "asPreSetBr"
            r12.put(r14, r11)
            int r11 = r13.mAsMicAuth
            java.lang.String r14 = "asMicAuth"
            r12.put(r14, r11)
            org.json.JSONArray r11 = new org.json.JSONArray
            r11.<init>()
            java.lang.String r14 = "asReConnArray"
            r12.put(r14, r11)
            java.util.List<com.wushuangtech.log.RtcHeartbeatReporter$AReconnect> r14 = r13.mAsReConnTimes
            java.util.Iterator r14 = r14.iterator()
            r15 = 0
        L_0x0113:
            boolean r16 = r14.hasNext()
            if (r16 == 0) goto L_0x0147
            java.lang.Object r16 = r14.next()
            r4 = r16
            com.wushuangtech.log.RtcHeartbeatReporter$AReconnect r4 = (com.wushuangtech.log.RtcHeartbeatReporter.AReconnect) r4
            r16 = r14
            org.json.JSONObject r14 = new org.json.JSONObject
            r14.<init>()
            r17 = r10
            java.lang.String r10 = r4.mKey
            r18 = r2
            java.lang.String r2 = "connIp"
            r14.put(r2, r10)
            int r2 = r4.mValue
            java.lang.String r10 = "connTimes"
            r14.put(r10, r2)
            r11.put(r14)
            int r2 = r4.mValue
            int r15 = r15 + r2
            r14 = r16
            r10 = r17
            r2 = r18
            goto L_0x0113
        L_0x0147:
            r18 = r2
            r17 = r10
            java.lang.String r2 = "asReConnTimes"
            r12.put(r2, r15)
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            r12.put(r9, r2)
            com.wushuangtech.log.RtcHeartbeatReporter$MediaServerInfo r4 = r1.mMediaServerInfo
            java.lang.String r4 = r4.mAudioIp
            r2.put(r8, r4)
            com.wushuangtech.log.RtcHeartbeatReporter$MediaServerInfo r4 = r1.mMediaServerInfo
            int r4 = r4.mAudioPort
            r2.put(r7, r4)
            com.wushuangtech.log.RtcHeartbeatReporter$MediaServerInfo r4 = r1.mMediaServerInfo
            int r4 = r4.mAudioState
            r2.put(r6, r4)
            r4 = 3
            r2.put(r5, r4)
            long r10 = r13.mSendA_RECVERROR
            java.lang.String r2 = "asRecvError"
            r12.put(r2, r10)
            long r10 = r13.mSendA_MAXERRORUID
            java.lang.String r2 = "asMaxErrorUid"
            r12.put(r2, r10)
            long r10 = r13.mSendA_RECVERRORTIME
            java.lang.String r2 = "asRecvErrorTime"
            r12.put(r2, r10)
            long r10 = r13.mSendA_MUTEFRAME
            java.lang.String r2 = "asMuteFrame"
            r12.put(r2, r10)
            int r2 = r13.mSendAUDIO_FOCUS
            java.lang.String r4 = "asFocus"
            r12.put(r4, r2)
            java.lang.String r2 = r13.mOutAudioProcessEffeciency
            java.lang.String r4 = "asProcess"
            r12.put(r4, r2)
            int r2 = r13.mReportType
            r4 = 1
            if (r2 != r4) goto L_0x01cb
            int r2 = r13.mErl
            java.lang.String r4 = "asErl"
            r12.put(r4, r2)
            int r2 = r13.mErle
            java.lang.String r4 = "asErle"
            r12.put(r4, r2)
            int r2 = r13.mANlp
            java.lang.String r4 = "asAnlp"
            r12.put(r4, r2)
            int r2 = r13.mDelayMedian
            java.lang.String r4 = "asDelayMedian"
            r12.put(r4, r2)
            int r2 = r13.mDelayStd
            java.lang.String r4 = "asDelayStd"
            r12.put(r4, r2)
            float r2 = r13.mFractionPoorDelays
            double r10 = (double) r2
            java.lang.String r2 = "asPoorDelays"
            r12.put(r2, r10)
        L_0x01cb:
            r3.put(r12)
            java.lang.String[] r2 = AUDIO_UPLOAD_KEY
            java.lang.String r3 = "Audio upload check"
            r0.checkLogContent(r3, r12, r2)
            goto L_0x01da
        L_0x01d6:
            r18 = r2
            r17 = r10
        L_0x01da:
            com.wushuangtech.log.RtcHeartbeatReporter$AudioInfo r2 = r1.mAudioInfo
            java.util.List<com.wushuangtech.log.RtcHeartbeatReporter$AudioInfo$AudioRecvInfo> r2 = r2.mAudioRecvList
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x02fc
            org.json.JSONArray r2 = new org.json.JSONArray
            r2.<init>()
            java.lang.String r3 = "audioRecv"
            r4 = r18
            r4.put(r3, r2)
            com.wushuangtech.log.RtcHeartbeatReporter$AudioInfo r3 = r1.mAudioInfo
            java.util.List<com.wushuangtech.log.RtcHeartbeatReporter$AudioInfo$AudioRecvInfo> r3 = r3.mAudioRecvList
            r11 = 0
        L_0x01f5:
            int r4 = r3.size()
            if (r11 >= r4) goto L_0x02fc
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            java.lang.Object r10 = r3.get(r11)
            com.wushuangtech.log.RtcHeartbeatReporter$AudioInfo$AudioRecvInfo r10 = (com.wushuangtech.log.RtcHeartbeatReporter.AudioInfo.AudioRecvInfo) r10
            long r12 = r10.mTs
            r14 = r17
            r4.put(r14, r12)
            java.lang.String r12 = r10.mSendUserId
            java.lang.String r13 = "sendUserId"
            r4.put(r13, r12)
            long r12 = r10.mArSsrc
            java.lang.String r15 = "arSsrc"
            r4.put(r15, r12)
            long r12 = r10.mArBitrate
            java.lang.String r15 = "arBitrate"
            r4.put(r15, r12)
            int r12 = r10.mArFps
            java.lang.String r13 = "arFps"
            r4.put(r13, r12)
            int r12 = r10.mArDecInputFps
            java.lang.String r13 = "arDecInputFps"
            r4.put(r13, r12)
            int r12 = r10.mArDecOutputFps
            java.lang.String r13 = "arDecOutputFps"
            r4.put(r13, r12)
            int r12 = r10.mArRenderFps
            java.lang.String r13 = "arRenderFps"
            r4.put(r13, r12)
            int r12 = r10.mArSysPlayoutFps
            java.lang.String r13 = "arSysPlayoutFps"
            r4.put(r13, r12)
            long r12 = r10.mArDecodeLen
            java.lang.String r15 = "arDecodeLen"
            r4.put(r15, r12)
            int r12 = r10.mArDecElapsed
            java.lang.String r13 = "arDecElapsed"
            r4.put(r13, r12)
            long r12 = r10.mArIsRemoteUserMute
            java.lang.String r15 = "arIsRemoteUserMute"
            r4.put(r15, r12)
            long r12 = r10.mArIsLocalMute
            java.lang.String r15 = "arIsLocalMute"
            r4.put(r15, r12)
            long r12 = r10.mArBufferSize
            java.lang.String r15 = "arBufferSize"
            r4.put(r15, r12)
            float r12 = r10.mArFractionLostRate
            double r12 = (double) r12
            java.lang.String r15 = "arFractionLostRate"
            r4.put(r15, r12)
            float r12 = r10.mArLostRate
            double r12 = (double) r12
            java.lang.String r15 = "arLostRate"
            r4.put(r15, r12)
            float r12 = r10.mArE2eLost
            double r12 = (double) r12
            java.lang.String r15 = "arE2eLost"
            r4.put(r15, r12)
            long r12 = r10.mArRtt
            java.lang.String r15 = "arRtt"
            r4.put(r15, r12)
            long r12 = r10.mArDelay
            java.lang.String r15 = "arDelay"
            r4.put(r15, r12)
            long r12 = r10.mArAvgJms
            java.lang.String r15 = "arAvgJms"
            r4.put(r15, r12)
            long r12 = r10.mArMaxJms
            java.lang.String r15 = "arMaxJms"
            r4.put(r15, r12)
            long r12 = r10.mArVolume
            java.lang.String r15 = "arVolume"
            r4.put(r15, r12)
            long r12 = r10.mArVolumeLevel
            java.lang.String r15 = "arVolumeLevel"
            r4.put(r15, r12)
            long r12 = r10.mArVolumeLevelSum
            java.lang.String r15 = "arVolumeLevelSum"
            r4.put(r15, r12)
            int r12 = r10.mArVolumeLevelRmsA
            java.lang.String r13 = "arVolumeLevelRmsA"
            r4.put(r13, r12)
            int r12 = r10.mArVolumeLevelRms
            java.lang.String r13 = "arVolumeLevelRms"
            r4.put(r13, r12)
            long r12 = r10.mArProcElapsedAvg
            java.lang.String r15 = "arProcElapsedAvg"
            r4.put(r15, r12)
            long r12 = r10.mArProcElapsedMax
            java.lang.String r10 = "arProcElapsedMax"
            r4.put(r10, r12)
            org.json.JSONObject r10 = new org.json.JSONObject
            r10.<init>()
            r4.put(r9, r10)
            com.wushuangtech.log.RtcHeartbeatReporter$MediaServerInfo r12 = r1.mMediaServerInfo
            java.lang.String r12 = r12.mAudioIp
            r10.put(r8, r12)
            com.wushuangtech.log.RtcHeartbeatReporter$MediaServerInfo r12 = r1.mMediaServerInfo
            int r12 = r12.mAudioPort
            r10.put(r7, r12)
            com.wushuangtech.log.RtcHeartbeatReporter$MediaServerInfo r12 = r1.mMediaServerInfo
            int r12 = r12.mAudioState
            r10.put(r6, r12)
            r12 = 3
            r10.put(r5, r12)
            r2.put(r4)
            java.lang.String[] r10 = AUDIO_DOWNLOAD_KEY
            java.lang.String r13 = "Audio download check"
            r0.checkLogContent(r13, r4, r10)
            int r11 = r11 + 1
            goto L_0x01f5
        L_0x02fc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.log.RtcHeartbeatReporter.addAudioInfoObj(com.wushuangtech.log.RtcHeartbeatReporter$InfoBean, org.json.JSONObject):void");
    }

    private void addSysEnviroment(InfoBean infoBean, JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        jSONObject.put("systemEnvironments", jSONArray);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ts", System.currentTimeMillis());
        jSONObject2.put("sysCpuPer", (double) infoBean.mSystemEnvironment.mSysCpu);
        jSONObject2.put("appCpuPer", (double) infoBean.mSystemEnvironment.mAppCpu);
        jSONObject2.put("sysMemPer", (double) infoBean.mSystemEnvironment.mSysRam);
        jSONObject2.put("appMemPer", (double) infoBean.mSystemEnvironment.mAppRam);
        jSONObject2.put("signalStrength", infoBean.mSystemEnvironment.mSigStrength);
        jSONObject2.put("signalNetLost", infoBean.mSystemEnvironment.mSigNetLost);
        jSONObject2.put("signalQuality", infoBean.mSystemEnvironment.mSigQuality);
        jSONObject2.put("schedulElapseDur", infoBean.mSystemEnvironment.mSchedulElapse);
        jSONObject2.put("energyMode", infoBean.mSystemEnvironment.mEnergyMode);
        jSONObject2.put("actCpuCore", infoBean.mSystemEnvironment.mActCpuCore);
        jSONObject2.put("totalCpuCore", infoBean.mSystemEnvironment.mTotalCpuCore);
        jSONArray.put(jSONObject2);
    }

    private void addMediaServerInfo(InfoBean infoBean, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("mediaServerInfo", jSONObject2);
        jSONObject2.put("aIp", infoBean.mMediaServerInfo.mAudioIp);
        jSONObject2.put("aPort", infoBean.mMediaServerInfo.mAudioPort);
        jSONObject2.put("aSid", infoBean.mMediaServerInfo.mAudioID);
        jSONObject2.put("aState", infoBean.mMediaServerInfo.mAudioState);
        jSONObject2.put("vIp", infoBean.mMediaServerInfo.mVideoIp);
        jSONObject2.put("vPort", infoBean.mMediaServerInfo.mVideoPort);
        jSONObject2.put("vSid", infoBean.mMediaServerInfo.mVideoID);
        jSONObject2.put("vState", infoBean.mMediaServerInfo.mVideoState);
    }

    private void addAecParamsInfo(InfoBean infoBean, JSONObject jSONObject) throws JSONException {
        if (infoBean.mAecParamsInfo.valid) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("aecParamsInfo", jSONObject2);
            jSONObject2.put("ODE", infoBean.mAecParamsInfo.open_delay_estimate);
            jSONObject2.put("VP", infoBean.mAecParamsInfo.voip_play);
            jSONObject2.put("VR", infoBean.mAecParamsInfo.voip_record);
            jSONObject2.put("PO", infoBean.mAecParamsInfo.pre_offset);
            jSONObject2.put("O", infoBean.mAecParamsInfo.offset);
            jSONObject2.put("DE", infoBean.mAecParamsInfo.delay_estimate);
            jSONObject2.put("DM", infoBean.mAecParamsInfo.delay_median);
            jSONObject2.put("DS", infoBean.mAecParamsInfo.delay_std);
            jSONObject2.put("FPD", infoBean.mAecParamsInfo.fraction_poor_delays);
        }
    }

    private int calcAudioLocalBitrate(long j, int i) {
        long j2 = this.mLastAudioSendDataSize;
        int formatSpeedKbps = (j2 <= 0 || j <= j2) ? 0 : (int) MyMathUtils.formatSpeedKbps((long) ((int) (j - j2)), (long) i);
        this.mLastAudioSendDataSize = j;
        return formatSpeedKbps;
    }

    private int calcAudioRemoteBitrate(long j, long j2, int i) {
        LastCacheData lastCacheData = this.mLastAudioCaches.get(j);
        int formatSpeedKbps = (lastCacheData == null || lastCacheData.mLastAudioRecvDatas <= 0 || j2 <= lastCacheData.mLastAudioRecvDatas) ? 0 : (int) MyMathUtils.formatSpeedKbps(j2 - lastCacheData.mLastAudioRecvDatas, (long) i);
        if (lastCacheData == null) {
            lastCacheData = new LastCacheData();
        }
        lastCacheData.mLastAudioRecvDatas = j2;
        this.mLastAudioCaches.put(j, lastCacheData);
        return formatSpeedKbps;
    }

    private int calcVideoLocalCapFps(long j) {
        long j2 = this.mLastVideoCapFrame;
        if (j <= j2) {
            this.mLastVideoCapFrame = 0;
            return 0;
        } else if (j2 == 0) {
            this.mLastVideoCapFrame = j;
            return 0;
        } else {
            int currentTimeMillis = (int) (((double) (((float) (j - this.mLastVideoCapFrame)) / (this.mLastBuildInfoTime == 0 ? 1.0f : ((float) (System.currentTimeMillis() - this.mLastBuildInfoTime)) / 1000.0f))) + 0.5d);
            this.mLastVideoCapFrame = j;
            if (currentTimeMillis > 60) {
                return 0;
            }
            return currentTimeMillis;
        }
    }

    private int calcVideoLocalEncFps(long j) {
        long j2 = this.mLastVideoEncFrames;
        if (j <= j2) {
            this.mLastVideoEncFrames = 0;
            return 0;
        } else if (j2 == 0) {
            this.mLastVideoEncFrames = j;
            return 0;
        } else {
            int currentTimeMillis = (int) (((double) (((float) (j - this.mLastVideoEncFrames)) / (this.mLastBuildInfoTime == 0 ? 1.0f : ((float) (System.currentTimeMillis() - this.mLastBuildInfoTime)) / 1000.0f))) + 0.5d);
            this.mLastVideoEncFrames = j;
            if (currentTimeMillis > 60) {
                return 0;
            }
            return currentTimeMillis;
        }
    }

    private int calcVideoLocalSendFps(long j) {
        long j2 = this.mLastVideoSendFrames;
        if (j <= j2) {
            this.mLastVideoSendFrames = 0;
            return 0;
        } else if (j2 == 0) {
            this.mLastVideoSendFrames = j;
            return 0;
        } else {
            int currentTimeMillis = (int) (((double) (((float) (j - this.mLastVideoSendFrames)) / (this.mLastBuildInfoTime == 0 ? 1.0f : ((float) (System.currentTimeMillis() - this.mLastBuildInfoTime)) / 1000.0f))) + 0.5d);
            this.mLastVideoSendFrames = j;
            if (currentTimeMillis > 60) {
                return 0;
            }
            return currentTimeMillis;
        }
    }

    private int permissionCheck(String str) {
        Context context = GlobalHolder.getInstance().getContext();
        int i = LocalSDKConstants.PERMISSION_LOW_VERSION;
        if (context == null) {
            return i;
        }
        int i2 = context.getApplicationInfo().targetSdkVersion;
        if (Build.VERSION.SDK_INT < 23) {
            return LocalSDKConstants.PERMISSION_LOW_VERSION;
        }
        if (i2 < 23) {
            return LocalSDKConstants.PERMISSION_LOW_VERSION;
        }
        if (context.checkSelfPermission(str) == -1) {
            return LocalSDKConstants.PERMISSION_DENIED;
        }
        return LocalSDKConstants.PERMISSION_GRANTED;
    }

    public long signalReconnectTimes() {
        return NativeInitializer.getIntance().signalReconnectTimes();
    }

    private void travelJsonObjectToMap(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONArray jSONArray = null;
            try {
                jSONObject2 = jSONObject.getJSONObject(next);
            } catch (Exception unused) {
                jSONObject2 = null;
            }
            if (jSONObject2 != null) {
                travelJsonObjectToMap(jSONObject2);
            }
            try {
                jSONArray = jSONObject.getJSONArray(next);
            } catch (Exception unused2) {
            }
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    travelJsonObjectToMap(jSONArray.getJSONObject(i));
                }
            }
            this.mTravelJsonObjectMap.put(next, "1");
        }
    }

    private void checkNumber(Class<?> cls, Object obj) {
        try {
            for (Field field : cls.getDeclaredFields()) {
                if (!"serialVersionUID".equals(field.getName())) {
                    Class<?> type = field.getType();
                    if (type == Long.TYPE) {
                        if (field.getLong(obj) < 0) {
                            field.setLong(obj, 0);
                        }
                    } else if (type == Double.TYPE && field.getDouble(obj) < 0.0d) {
                        field.setDouble(obj, 0.0d);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            logE("IllegalAccessException : " + e.getLocalizedMessage());
        }
    }

    private void logI(String str) {
        OmniLog.i(OmniLog.LOG_WATCH, this.TAG, str);
    }

    private void logD(String str) {
        OmniLog.d(OmniLog.LOG_WATCH, this.TAG, str, false);
    }

    private void logW(String str) {
        OmniLog.w(OmniLog.LOG_WATCH, this.TAG, str);
    }

    private void logE(String str) {
        OmniLog.e(OmniLog.LOG_WATCH, this.TAG, str);
    }
}
