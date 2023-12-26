package com.eaydu.omni;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.eaydu.omni.RTCEngine;
import com.eaydu.omni.jwt.Claim;
import com.eaydu.omni.jwt.JWT;
import com.eaydu.omni.listener.RTCConnectionStateType;
import com.eaydu.omni.log.LogReport;
import com.eaydu.omni.logger.Logger;
import com.eaydu.omni.urls.UrlManager;
import com.eaydu.omni.utils.CommonUtils;
import com.igexin.assist.sdk.AssistPushConsts;
import java.util.Map;

public class RTCChannel {
    private static final String TAG = "RTCChannel";
    private String VERSION_SYS = EngineConfig.SDK_VERSION;
    private BaseRTCChannel baseRTCChannel;
    private LogReport logReport = null;
    private String mAppid = "";
    private RTCEngine mEngine;
    private int mEngineTypeValue = 0;
    private IRTCChannelEventListener mListener = null;
    private String mRoomId;
    private String mToken;
    private long mUid;
    private String mcip = "";
    private String mpsUserid = "";
    private String planId = "";

    public static abstract class IRTCChannelEventListener {
        public void connectionChangedToState(String str, RTCConnectionStateType rTCConnectionStateType, String str2) {
        }

        public void didAudioMuted(String str, long j, boolean z) {
        }

        public void didOccurError(String str, RTCEngine.RTCEngineErrorCode rTCEngineErrorCode) {
        }

        public void didOfflineOfUid(String str, long j) {
        }

        public void didOfflineOfUid(String str, long j, int i) {
        }

        public void didVideoMuted(String str, long j, boolean z) {
        }

        public void localUserJoinedWithUid(String str, long j) {
        }

        public void onChannelMediaRelayEvent(String str, int i) {
        }

        public void onChannelMediaRelayStateChanged(String str, int i, int i2) {
        }

        public void onKick(String str, int i) {
        }

        public void onLeaveChannel(String str) {
        }

        public void onNetworkQuality(String str, long j, int i, int i2) {
        }

        public void onPublishAudioStateChanged(String str, int i, int i2) {
        }

        public void onPublishVideoStateChanged(String str, int i, int i2) {
        }

        public void onRemoteAudioStats(String str, RTCEngine.RemoteAudioStats remoteAudioStats) {
        }

        public void onRemoteStreamSubscribeAdvice(String str, long j, int i, int i2) {
        }

        public void onRemoteVideoStateChanged(String str, long j, int i) {
        }

        public void onRemoteVideoStats(String str, RTCEngine.RemoteVideoStats remoteVideoStats) {
        }

        @Deprecated
        public void onStreamMessage(long j, byte[] bArr) {
        }

        public void onStreamMessage(String str, long j, byte[] bArr) {
        }

        public void onSubscribeAudioStateChanged(String str, int i, int i2, int i3) {
        }

        public void onSubscribeVideoStateChanged(String str, int i, int i2, int i3) {
        }

        public void onTakeRemoteViewSnapshot(String str, long j, Bitmap bitmap) {
        }

        @Deprecated
        public void onVideoBufferingStateChanged(long j, int i, long j2) {
        }

        public void onVideoBufferingStateChanged(String str, long j, int i, long j2) {
        }

        public void onVideoSizeChanged(String str, long j, int i, int i2, int i3) {
        }

        public void remoteUserJoinWithUid(String str, long j) {
        }

        public void remotefirstAudioRecvWithUid(String str, long j) {
        }

        public void remotefirstVideoRecvWithUid(String str, long j) {
        }

        public void reportRtcStats(String str, RTCEngine.ReportRtcStats reportRtcStats) {
        }
    }

    public RTCChannel(RTCEngine rTCEngine) {
        this.mEngine = rTCEngine;
    }

    /* access modifiers changed from: protected */
    public synchronized int realInit() {
        RTCEngine rTCEngine = this.mEngine;
        if (rTCEngine == null) {
            return -12;
        }
        BaseRTCChannel createChannel = rTCEngine.createChannel(this.mRoomId);
        this.baseRTCChannel = createChannel;
        if (createChannel == null) {
            return -11;
        }
        createChannel.setEventListener(this.mListener);
        Context context = this.mEngine.getmContext();
        if (context != null) {
            this.logReport = new LogReport(context);
            this.logReport.initWithParam(this.mRoomId, this.mUid, EngineConfig.getEngineReportName(this.mEngine.getmEngineType()), this.VERSION_SYS, this.mAppid, this.mpsUserid, this.mcip, UrlManager.getInstance().getUrlKibana(), this.planId, this.mEngine.getmEngineType().getValue());
        }
        this.baseRTCChannel.setLogReport(this.logReport);
        return 0;
    }

    public int initWithToken(String str) {
        try {
            Map<String, Claim> claims = new JWT(str).getClaims();
            Claim claim = claims.get("roomStr");
            if (claim != null) {
                this.mRoomId = claim.asString();
            }
            if (!CommonUtils.checkRoomID(this.mRoomId)) {
                return -64;
            }
            Claim claim2 = claims.get("attachToken");
            if (claim2 != null) {
                this.mToken = claim2.asString();
            } else {
                Claim claim3 = claims.get(AssistPushConsts.MSG_TYPE_TOKEN);
                if (claim3 != null) {
                    this.mToken = claim3.asString();
                }
            }
            Claim claim4 = claims.get("attachAppid");
            if (claim4 != null) {
                this.mAppid = claim4.asString();
            } else {
                Claim claim5 = claims.get("appid");
                if (claim5 != null) {
                    this.mAppid = claim5.asString();
                }
            }
            Claim claim6 = claims.get("psuser");
            if (claim6 != null) {
                this.mpsUserid = claim6.asString();
            }
            Claim claim7 = claims.get("ip");
            if (claim7 != null) {
                this.mcip = claim7.asString();
            }
            Claim claim8 = claims.get("planid");
            if (claim8 != null) {
                this.planId = claim8.asString();
            }
            Claim claim9 = claims.get("user");
            if (claim9 != null) {
                this.mUid = Long.parseLong(claim9.asString());
            }
            Claim claim10 = claims.get(HummerStyleUtils.Hummer.TYPE);
            if (claim10 != null) {
                this.mEngineTypeValue = claim10.asInt().intValue();
            }
            Claim claim11 = claims.get("uploadLogLevel");
            if (claim11 != null) {
                EngineConfig.LogLevelConfig = claim11.asInt().intValue();
            }
            if (this.mEngine.getBaseRtcEngine() == null) {
                this.mEngine.initWithToken(str, false);
            }
            Logger.i("RTCChannel initWithToken: " + str + ",appId:" + this.mAppid, new Object[0]);
            RTCEngine rTCEngine = this.mEngine;
            if (rTCEngine != null && rTCEngine.getEngineType() != this.mEngineTypeValue) {
                return RTCEngine.RTCEngineErrorCode.RTC_ERR_TOKEN_ENGINE_TYPE_ERROR.getValue();
            }
            int realInit = realInit();
            String str2 = TAG;
            Log.i(str2, "initWithToken room: " + this.mRoomId + " uid: " + this.mUid + " " + this.baseRTCChannel);
            return realInit;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int init(String str) {
        this.mRoomId = str;
        if (!CommonUtils.checkRoomID(str)) {
            return -64;
        }
        RTCEngine rTCEngine = this.mEngine;
        if (rTCEngine == null) {
            return -1;
        }
        this.mAppid = rTCEngine.getAppId();
        this.mUid = this.mEngine.getUserId();
        return realInit();
    }

    public SurfaceView createRendererView() {
        RTCEngine rTCEngine = this.mEngine;
        if (rTCEngine == null || rTCEngine.mBaseRtcEngine == null) {
            return null;
        }
        return (SurfaceView) this.mEngine.mBaseRtcEngine.createRendererView();
    }

    public TextureView createTextureView() {
        RTCEngine rTCEngine = this.mEngine;
        if (rTCEngine == null || rTCEngine.mBaseRtcEngine == null) {
            return null;
        }
        return this.mEngine.mBaseRtcEngine.createTextureView();
    }

    public void setupRemoteVideo(View view, long j) {
        RTCEngine rTCEngine = this.mEngine;
        if (rTCEngine != null && rTCEngine.mBaseRtcEngine != null) {
            this.mEngine.mBaseRtcEngine.setupRemoteVideo(view, j, this.mRoomId);
        }
    }

    public void setRemoteVolume(long j, int i) {
        RTCEngine rTCEngine = this.mEngine;
        if (rTCEngine != null && rTCEngine.mBaseRtcEngine != null) {
            this.mEngine.mBaseRtcEngine.setVolume(j, i, this.mRoomId);
        }
    }

    public void setRemoteRenderMode(long j, RTCEngine.RTCVideoRenderMode rTCVideoRenderMode) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 != null) {
            baseRTCChannel2.setRemoteRenderMode(j, rTCVideoRenderMode);
        }
    }

    public long getTimestamp(int i) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 != null) {
            return baseRTCChannel2.getTimestamp(i);
        }
        return -1;
    }

    public void joinChannel() {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 != null) {
            baseRTCChannel2.joinChannel(this.mToken, this.mUid);
        }
    }

    public void muteRemoteVideo(long j, boolean z) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 != null) {
            baseRTCChannel2.muteRemoteVideo(j, z);
        }
    }

    public void muteRemoteAudio(long j, boolean z) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 != null) {
            baseRTCChannel2.muteRemoteAudio(j, z);
        }
    }

    public void muteAllRemoteVideo(boolean z) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 != null) {
            baseRTCChannel2.muteAllRemoteVideo(z);
        }
    }

    public void muteAllRemoteAudio(boolean z) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 != null) {
            baseRTCChannel2.muteAllRemoteAudio(z);
        }
    }

    public void leaveChannel() {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 != null) {
            baseRTCChannel2.leaveChannel();
        }
    }

    public void destroy() {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 != null) {
            baseRTCChannel2.destroy();
        }
        LogReport logReport2 = this.logReport;
        if (logReport2 != null) {
            logReport2.destroyLogManger();
            this.logReport = null;
        }
    }

    public int setRemoteVideoStreamType(long j, int i) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 == null) {
            return -1;
        }
        return baseRTCChannel2.setRemoteVideoStreamType((long) ((int) j), i);
    }

    public void setEventListener(IRTCChannelEventListener iRTCChannelEventListener) {
        this.mListener = iRTCChannelEventListener;
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 != null) {
            baseRTCChannel2.setEventListener(iRTCChannelEventListener);
        }
    }

    private int publish() {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 == null) {
            return -1;
        }
        return baseRTCChannel2.publish();
    }

    private int unPublish() {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 == null) {
            return -1;
        }
        return baseRTCChannel2.unPublish();
    }

    public int setRole(RTCEngine.RTCRole rTCRole) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 != null) {
            return baseRTCChannel2.setRole(rTCRole);
        }
        return -1;
    }

    public int muteLocalVideo(boolean z) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 != null) {
            return baseRTCChannel2.muteLocalVideo(z);
        }
        return -1;
    }

    public int muteLocalAudio(boolean z) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 != null) {
            return baseRTCChannel2.muteLocalAudio(z);
        }
        return -1;
    }

    public int startChannelMediaRelay(RTCEngine.RTCChannelMediaRelayConfiguration rTCChannelMediaRelayConfiguration) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 == null) {
            return -1;
        }
        return baseRTCChannel2.startChannelMediaRelay(rTCChannelMediaRelayConfiguration);
    }

    public int stopChannelMediaRelay() {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 == null) {
            return -1;
        }
        return baseRTCChannel2.stopChannelMediaRelay();
    }

    public int updateChannelMediaRelay(RTCEngine.RTCChannelMediaRelayConfiguration rTCChannelMediaRelayConfiguration) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 == null) {
            return -1;
        }
        return baseRTCChannel2.updateChannelMediaRelay(rTCChannelMediaRelayConfiguration);
    }

    public int addPublishStreamUrl(String str, boolean z) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 == null) {
            return -1;
        }
        return baseRTCChannel2.addPublishStreamUrl(str, z);
    }

    public int removePublishStreamUrl(String str) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 == null) {
            return -1;
        }
        return baseRTCChannel2.removePublishStreamUrl(str);
    }

    public int setRtmpConfig(RTCEngine.RTCRtmpConfig rTCRtmpConfig) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 == null) {
            return -1;
        }
        return baseRTCChannel2.setRtmpConfig(rTCRtmpConfig);
    }

    public int sendStreamMessage(long j, byte[] bArr) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 == null || bArr == null) {
            return -1;
        }
        return baseRTCChannel2.sendStreamMessage(j, bArr);
    }

    public int applyRemoteStreamSubscribeAdvice(long j, int i) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 == null) {
            return -1;
        }
        return baseRTCChannel2.applyRemoteStreamSubscribeAdvice(j, i);
    }

    public int takeRemoteViewSnapshot(long j) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 == null) {
            return -1;
        }
        return baseRTCChannel2.takeRemoteViewSnapshot(j);
    }

    public int setupRemoteVideo(long j, TextureView textureView) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 == null) {
            return -1;
        }
        return baseRTCChannel2.setupRemoteVideo(j, textureView);
    }

    public int setDefaultMuteAllRemoteAudioStreams(boolean z) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 == null) {
            return -1;
        }
        return baseRTCChannel2.setDefaultMuteAllRemoteAudioStreams(z);
    }

    public int setDefaultMuteAllRemoteVideoStreams(boolean z) {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 == null) {
            return -1;
        }
        return baseRTCChannel2.setDefaultMuteAllRemoteVideoStreams(z);
    }

    public String getChannelCallId() {
        BaseRTCChannel baseRTCChannel2 = this.baseRTCChannel;
        if (baseRTCChannel2 == null) {
            return "";
        }
        return baseRTCChannel2.getChannelCallId();
    }
}
