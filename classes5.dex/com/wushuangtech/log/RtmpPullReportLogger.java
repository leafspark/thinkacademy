package com.wushuangtech.log;

import android.os.Build;
import com.bonree.sdk.agent.engine.external.JSONArrayInstrumentation;
import com.wushuangtech.api.ExternalRtmpPublishModule;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.expansion.bean.LocalAudioStats;
import com.wushuangtech.expansion.bean.LocalVideoStats;
import com.wushuangtech.inter.OnRtmpPullModuleApiCallBack;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.video.VideoStatus;
import com.wushuangtech.log.BaseReportLogger;
import com.wushuangtech.thread.EngineCallbackThread;
import com.wushuangtech.utils.OmniLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RtmpPullReportLogger extends BaseReportLogger {
    private static final int MODULE_RTMP = 1;
    private static final String TAG = "RtmpPullReportLogger";
    private final String mAppId;
    private int mLastPushStatus;
    private int mModuleType;
    private OnRtmpPullModuleApiCallBack mOnRtmpPullModuleApiCallBack;
    private List<RtmpPullStatistics> mPullStatusBeans;
    private List<ExternalRtmpPublishModule.RtmpPushStatistics> mStatusBeans;
    private final String mStreamUUID;
    private final String mStreamUrl;

    public static class RtmpPullStatistics {
        long mADelay;
        int mRecvABR;
        int mRecvBR;
        int mRecvFps;
        long mVDelay;
    }

    public RtmpPullReportLogger(String str, String str2, String str3) {
        this.mModuleType = 1;
        this.mAppId = str;
        this.mStreamUrl = str2;
        this.mStreamUUID = str3;
        this.logReportInterval = 10;
        this.mStatusBeans = new ArrayList();
        initTimer();
    }

    public RtmpPullReportLogger(String str, String str2, String str3, OnRtmpPullModuleApiCallBack onRtmpPullModuleApiCallBack) {
        this.mOnRtmpPullModuleApiCallBack = onRtmpPullModuleApiCallBack;
        this.mAppId = str;
        this.mStreamUrl = str2;
        this.mStreamUUID = str3;
        this.logReportInterval = 10;
        this.mPullStatusBeans = new ArrayList();
        initTimer();
    }

    public void Release() {
        if (this.timer != null) {
            this.timer.cancel();
            this.timer = null;
        }
    }

    public void reportStartRtmpPush() {
        buildCommonJsonContentAndSend("PUSH_START", new HashMap());
    }

    public void reportNtpSync(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("sync_result", Boolean.valueOf(z));
        buildCommonJsonContentAndSend("PUSH_NTP", hashMap);
    }

    public void reportStopRtmpPush(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("stop_result", Boolean.valueOf(z));
        buildCommonJsonContentAndSend("PUSH_STOP", hashMap);
    }

    public void reportRtmpPushStatus(int i) {
        if (this.mLastPushStatus != i) {
            HashMap hashMap = new HashMap();
            hashMap.put("stats", Integer.valueOf(i));
            buildCommonJsonContentAndSend("PUSH_STATS", hashMap);
            this.mLastPushStatus = i;
        }
    }

    public void reportStartPull() {
        buildCommonJsonContentAndSend("PULL_START", new HashMap());
    }

    public void reportStopPull() {
        buildCommonJsonContentAndSend("PULL_STOP", new HashMap());
    }

    public void reportPullStatus(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("stats", Integer.valueOf(i));
        buildCommonJsonContentAndSend("PULL_STATS", hashMap);
    }

    public void reportPullFirstFrame(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("elapsed", Integer.valueOf(i));
        buildCommonJsonContentAndSend("PULL_VIDEO_FIRST_DECODER", hashMap);
    }

    private void initTimer() {
        this.timer = new Timer(VideoStatus.THREAD_LOG_RTMP_REPORT);
        this.timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                RtmpPullReportLogger.this.DoReport();
            }
        }, 1000, 1000);
    }

    /* access modifiers changed from: protected */
    public boolean buildCommonJsonContent(JSONObject jSONObject) {
        try {
            jSONObject.put("glbId", UUID.randomUUID().toString());
            jSONObject.put("appId", this.mAppId);
            jSONObject.put("os", "Android_" + Build.MODEL);
            jSONObject.put("logTime", getFormatDateStr());
            jSONObject.put("streamId", this.mStreamUUID);
            if (GlobalConfig.mBranch == LocalSDKConstants.BRANCH_CLIENT_TC) {
                return true;
            }
            jSONObject.put("streamUrl", this.mStreamUrl);
            return true;
        } catch (Exception e) {
            String str = TAG;
            OmniLog.e(str, "buildCommonJosnContent Json Exception : " + e.getLocalizedMessage());
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void DoReport() {
        String str;
        this.timerTicks++;
        if (this.timerTicks % 2 == 0) {
            if (this.mModuleType == 1) {
                ExternalRtmpPublishModule.RtmpPushStatistics rtmpPushStatus = ExternalRtmpPublishModule.getInstance().getRtmpPushStatus();
                this.mStatusBeans.add(rtmpPushStatus);
                EngineCallbackThread workerThread = GlobalHolder.getInstance().getWorkerThread();
                LocalAudioStats localAudioStats = new LocalAudioStats();
                localAudioStats.sentBitrate = rtmpPushStatus.mAudioRealBitrate;
                workerThread.sendMessage(21, new Object[]{localAudioStats});
                LocalVideoStats localVideoStats = new LocalVideoStats();
                localVideoStats.sentBitrate = rtmpPushStatus.mVideoRealBitrate;
                localVideoStats.sentFrameRate = rtmpPushStatus.mFps;
                workerThread.sendMessage(12, new Object[]{localVideoStats});
            } else {
                Object[] pullStatus = this.mOnRtmpPullModuleApiCallBack.getPullStatus();
                if (pullStatus != null && pullStatus.length == 5) {
                    RtmpPullStatistics rtmpPullStatistics = new RtmpPullStatistics();
                    rtmpPullStatistics.mRecvFps = ((Integer) pullStatus[0]).intValue();
                    rtmpPullStatistics.mRecvBR = ((Integer) pullStatus[1]).intValue();
                    rtmpPullStatistics.mRecvABR = ((Integer) pullStatus[2]).intValue();
                    rtmpPullStatistics.mVDelay = ((Long) pullStatus[3]).longValue();
                    rtmpPullStatistics.mADelay = ((Long) pullStatus[4]).longValue();
                    this.mPullStatusBeans.add(rtmpPullStatistics);
                }
            }
        }
        if (this.timerTicks % this.logReportInterval == 0) {
            JSONArray jSONArray = new JSONArray();
            if (this.mModuleType == 1) {
                for (ExternalRtmpPublishModule.RtmpPushStatistics next : this.mStatusBeans) {
                    JSONObject jSONObject = new JSONObject();
                    buildCommonJsonContent(jSONObject);
                    try {
                        jSONObject.put("event", "PUSH_HEART");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    JSONObject initJsonString = initJsonString(jSONObject, next);
                    if (initJsonString != null) {
                        jSONArray.put(initJsonString);
                    }
                }
                this.mStatusBeans.clear();
            } else {
                for (RtmpPullStatistics next2 : this.mPullStatusBeans) {
                    JSONObject jSONObject2 = new JSONObject();
                    buildCommonJsonContent(jSONObject2);
                    try {
                        jSONObject2.put("event", "PULL_HEART");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    JSONObject initPullJsonString = initPullJsonString(jSONObject2, next2);
                    if (initPullJsonString != null) {
                        jSONArray.put(initPullJsonString);
                    }
                }
                this.mPullStatusBeans.clear();
            }
            try {
                if (this.mModuleType == 1) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("event=PUSH_HEART ");
                    sb.append(!(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray));
                    str = sb.toString();
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("event=PULL_HEART ");
                    sb2.append(!(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray));
                    str = sb2.toString();
                }
                BaseReportLogger.ReportLogMsg reportLogMsg = new BaseReportLogger.ReportLogMsg();
                reportLogMsg.logType = 16;
                reportLogMsg.logMsg = str;
                reportLogMsg.msgType = 0;
                SendLogMsg(reportLogMsg);
            } catch (Exception e3) {
                OmniLog.e(TAG, "DoReport Exception : " + e3.getLocalizedMessage());
            }
        }
    }

    private JSONObject initJsonString(JSONObject jSONObject, ExternalRtmpPublishModule.RtmpPushStatistics rtmpPushStatistics) {
        try {
            jSONObject.put("V_FPS", rtmpPushStatistics.mFps);
            jSONObject.put("V_BR", rtmpPushStatistics.mVideoRealBitrate);
            jSONObject.put("A_BR", rtmpPushStatistics.mAudioRealBitrate);
            return jSONObject;
        } catch (JSONException e) {
            String str = TAG;
            OmniLog.e(str, "initJsonString Json Exception : " + e.getLocalizedMessage());
            return null;
        }
    }

    private JSONObject initPullJsonString(JSONObject jSONObject, RtmpPullStatistics rtmpPullStatistics) {
        try {
            jSONObject.put("V_FPS", rtmpPullStatistics.mRecvFps);
            jSONObject.put("V_BR", rtmpPullStatistics.mRecvBR);
            jSONObject.put("A_BR", rtmpPullStatistics.mRecvABR);
            jSONObject.put("V_DELAY", rtmpPullStatistics.mVDelay);
            jSONObject.put("A_DELAY", rtmpPullStatistics.mADelay);
            return jSONObject;
        } catch (JSONException e) {
            String str = TAG;
            OmniLog.e(str, "initPullJsonString Json Exception : " + e.getLocalizedMessage());
            return null;
        }
    }

    public enum RtmpPushStatus {
        RTMP_PUSH_SUCCESS(1),
        RTMP_PUSH_FAILED(2),
        RTMP_PUSH_DISCONNECTED(3),
        RTMP_PUSH_STOP(4),
        RTMP_PUSH_UNKNOW(5);
        
        private int value;

        private RtmpPushStatus(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
