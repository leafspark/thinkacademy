package com.eaydu.omni.log;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.bonree.sdk.agent.engine.external.JSONArrayInstrumentation;
import com.didi.hummer.render.event.base.TraceEvent;
import com.didi.hummer.render.style.HummerStyleUtils;
import com.eaydu.omni.EngineConfig;
import com.eaydu.omni.listener.LogEventListener;
import com.eaydu.omni.log.LogReportBase;
import com.eaydu.omni.log.bean.LogAudioLocalStatistics;
import com.eaydu.omni.log.bean.LogAudioRemoteStatistics;
import com.eaydu.omni.log.bean.LogMemoryStatistics;
import com.eaydu.omni.log.bean.LogVideoLocalStatistics;
import com.eaydu.omni.log.bean.LogVideoRemoteStatistics;
import com.eaydu.omni.log.bean.StatsCaculation;
import com.eaydu.omni.logger.Logger;
import com.eaydu.omni.net.okhttp3.Call;
import com.eaydu.omni.net.okhttp3.Callback;
import com.eaydu.omni.net.okhttp3.MediaType;
import com.eaydu.omni.net.okhttp3.Request;
import com.eaydu.omni.net.okhttp3.RequestBody;
import com.eaydu.omni.net.okhttp3.Response;
import com.eaydu.omni.net.okio.BufferedSink;
import com.eaydu.omni.net.okio.GzipSink;
import com.eaydu.omni.net.okio.Okio;
import com.eaydu.omni.net.okio.Sink;
import com.eaydu.omni.utils.HttpUtils;
import com.google.firebase.messaging.Constants;
import com.huawei.multimedia.audiokit.config.ResultCode;
import com.igexin.assist.sdk.AssistPushConsts;
import com.luck.picture.lib.config.PictureConfig;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

public class LogReport extends LogReportBase implements LogEventListener {
    /* access modifiers changed from: private */
    public static final String TAG = "LogReport";
    private static int TIMEOFTIMER = 16;
    private int REPORTTERVAL = 15;
    private String VERSION_VER = EngineConfig.SDK_VERSION;
    private LogRpt_Header commonHeader = null;
    private boolean hasCameraPermission;
    private boolean hasRecordAudioPermission;
    private volatile boolean isPublishAudio = false;
    private volatile boolean isPublishVideo = false;
    private Lock lockStats = new ReentrantLock();
    /* access modifiers changed from: private */
    public String mAppId = "";
    private int mEngineId = 0;
    private String mEngineReal = "";
    /* access modifiers changed from: private */
    public int mFailecount = 0;
    private Boolean mJoinedRoom = false;
    private LogReportBase.LogSendListener mLogSendreport = new LogReportBase.LogSendListener<LogMessage>() {
        public void onNeedlogUpload(LogMessage logMessage, boolean z) {
            String str;
            String str2;
            if (z) {
                try {
                    MediaType parse = MediaType.parse("application/json; charset=utf-8");
                    if (logMessage.param instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) logMessage.param;
                        str = !(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray);
                    } else {
                        str = "";
                    }
                    if (LogReport.this.mFailecount == 0) {
                        long unused = LogReport.this.mbegineScheduler = System.currentTimeMillis();
                    }
                    int i = logMessage.delayTime;
                    logMessage.delayTime = i - 1;
                    if (i > 0) {
                        if (LogReport.this.planId != null) {
                            if (!LogReport.this.planId.isEmpty()) {
                                str2 = LogReport.this.planId;
                                RequestBody create = RequestBody.create(parse, str);
                                Request.Builder addHeader = new Request.Builder().url(LogReport.this.mpostSever).addHeader("Content-Encoding", "gzip").addHeader("logversion", "1.7.0");
                                HttpUtils.getHttpClient().newCall(addHeader.addHeader("localtimestamp", System.currentTimeMillis() + "").addHeader("projectid", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_ST).addHeader("plan", str2).addHeader("app", LogReport.this.mAppId).post(gzip(create)).build()).enqueue(new Callback() {
                                    public void onFailure(Call call, IOException iOException) {
                                        LogReport.access$108(LogReport.this);
                                    }

                                    public void onResponse(Call call, Response response) throws IOException {
                                        int unused = LogReport.this.mFailecount;
                                        int unused2 = LogReport.this.mFailecount = 0;
                                        try {
                                            response.close();
                                        } catch (Exception unused3) {
                                        }
                                    }
                                });
                            }
                        }
                        str2 = AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE;
                        RequestBody create2 = RequestBody.create(parse, str);
                        Request.Builder addHeader2 = new Request.Builder().url(LogReport.this.mpostSever).addHeader("Content-Encoding", "gzip").addHeader("logversion", "1.7.0");
                        HttpUtils.getHttpClient().newCall(addHeader2.addHeader("localtimestamp", System.currentTimeMillis() + "").addHeader("projectid", AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_ST).addHeader("plan", str2).addHeader("app", LogReport.this.mAppId).post(gzip(create2)).build()).enqueue(new Callback() {
                            public void onFailure(Call call, IOException iOException) {
                                LogReport.access$108(LogReport.this);
                            }

                            public void onResponse(Call call, Response response) throws IOException {
                                int unused = LogReport.this.mFailecount;
                                int unused2 = LogReport.this.mFailecount = 0;
                                try {
                                    response.close();
                                } catch (Exception unused3) {
                                }
                            }
                        });
                    }
                } catch (Exception e) {
                    String access$500 = LogReport.TAG;
                    Log.e(access$500, "report log " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }

        private RequestBody gzip(final RequestBody requestBody) {
            return new RequestBody() {
                public long contentLength() {
                    return -1;
                }

                public MediaType contentType() {
                    return requestBody.contentType();
                }

                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    BufferedSink buffer = Okio.buffer((Sink) new GzipSink(bufferedSink));
                    requestBody.writeTo(buffer);
                    buffer.close();
                }
            };
        }
    };
    private String[] mPermissions = {"android.permission.CAMERA", "android.permission.RECORD_AUDIO"};
    private String mRoomid = "";
    private String mSessionId = "";
    private Timer mStatisticsTimer = null;
    private String mStreamId = "";
    private long mUserid = 0;
    /* access modifiers changed from: private */
    public long mbegineScheduler = 0;
    private MessageConsumer mconsumer = null;
    private Context mcontext;
    public Map<String, StatsCaculation> mmapStats = new HashMap();
    public String mpostSever = "";
    /* access modifiers changed from: private */
    public String planId = "";
    private int timesOfSeconds = (TIMEOFTIMER / 2);

    static /* synthetic */ int access$108(LogReport logReport) {
        int i = logReport.mFailecount;
        logReport.mFailecount = i + 1;
        return i;
    }

    public synchronized void setVideoPublished(boolean z) {
        this.isPublishVideo = z;
    }

    public synchronized void setAudioPublished(boolean z) {
        this.isPublishAudio = z;
    }

    private static boolean lacksPermission(Context context, String str) {
        if (context != null && Build.VERSION.SDK_INT >= 23 && context.checkSelfPermission(str) == 0) {
            return true;
        }
        return false;
    }

    public void lacksPermissions(Context context, String[] strArr) {
        for (String str : strArr) {
            if (str.equals("android.permission.CAMERA")) {
                this.hasCameraPermission = lacksPermission(context, str);
            } else {
                this.hasRecordAudioPermission = lacksPermission(this.mcontext, str);
            }
        }
    }

    /* access modifiers changed from: private */
    public void statisticsForTimer() {
        JSONArray jSONArray;
        LogReport logReport = this;
        logReport.mmapStats.size();
        if (logReport.mJoinedRoom.booleanValue()) {
            JSONArray jSONArray2 = new JSONArray();
            logReport.lacksPermissions(logReport.mcontext, logReport.mPermissions);
            for (Map.Entry next : logReport.mmapStats.entrySet()) {
                if (((String) next.getKey()).equals(String.valueOf(logReport.mUserid))) {
                    StatsCaculation statsCaculation = (StatsCaculation) next.getValue();
                    int volumeAndReset = LogCommonInfo.getInstance().getVolumeAndReset(AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE);
                    if ((!logReport.isPublishVideo && !logReport.isPublishAudio) || (statsCaculation = LogCommonInfo.getInstance().getPublishInfo(String.valueOf(logReport.mUserid))) != null) {
                        StatsCaculation statsCaculation2 = statsCaculation;
                        String str = logReport.mRoomid;
                        long j = logReport.mUserid;
                        int i = statsCaculation2.localDelay;
                        int i2 = statsCaculation2.videoEncoded;
                        int i3 = statsCaculation2.audioEncoded;
                        String str2 = str;
                        StatsCaculation statsCaculation3 = statsCaculation2;
                        int i4 = statsCaculation2.gatewayRtt;
                        int i5 = statsCaculation3.appcpu;
                        long j2 = j;
                        int i6 = (int) statsCaculation3.audioBps;
                        int i7 = (int) statsCaculation3.videoLost;
                        int i8 = (int) statsCaculation3.audioLost;
                        double d = statsCaculation3.appMem;
                        int i9 = statsCaculation3.vRtt;
                        int i10 = statsCaculation3.aRtt;
                        JSONArray jSONArray3 = jSONArray2;
                        LogReport logReport2 = logReport;
                        StatsCaculation statsCaculation4 = statsCaculation3;
                        JSONArray jSONArray4 = jSONArray3;
                        heartbeatReportLocal(str2, j2, statsCaculation2.videoWidth, statsCaculation2.videoHeight, statsCaculation2.videoFps, (int) statsCaculation2.videoTargetFps, (int) statsCaculation2.videoBps, (int) statsCaculation2.videoTargetBps, i, i2, i3, volumeAndReset, i4, i5, i6, i7, i8, d, i9, i10);
                        StatsCaculation statsCaculation5 = statsCaculation4;
                        statsCaculation5.videoBps = 0;
                        statsCaculation5.videoFps = 0;
                        statsCaculation5.videoFpsArray.clear();
                        statsCaculation5.videoTargetBps = 0;
                        statsCaculation5.videoTargetFps = 0.0f;
                        statsCaculation5.videoEncoded = 0;
                        statsCaculation5.volume = 0;
                        statsCaculation5.videoLost = 0;
                        statsCaculation5.audioLost = 0;
                        jSONArray = jSONArray4;
                    }
                } else {
                    JSONArray jSONArray5 = jSONArray2;
                    StatsCaculation statsCaculation6 = (StatsCaculation) next.getValue();
                    long longValue = Long.valueOf((String) next.getKey()).longValue();
                    int volumeAndReset2 = LogCommonInfo.getInstance().getVolumeAndReset(String.valueOf(longValue));
                    int i11 = (int) statsCaculation6.audioBps;
                    int i12 = statsCaculation6.videoDecode;
                    int i13 = statsCaculation6.audioDecode;
                    long j3 = longValue;
                    StatsCaculation statsCaculation7 = statsCaculation6;
                    int i14 = statsCaculation6.endToEndDelay;
                    int i15 = statsCaculation7.avSyncDeltaInMS;
                    ArrayList<Integer> arrayList = statsCaculation7.videoFpsArray;
                    int i16 = statsCaculation7.vRtt;
                    int i17 = statsCaculation7.aRtt;
                    int i18 = statsCaculation7.vJitter;
                    int i19 = statsCaculation7.aJitter;
                    int i20 = statsCaculation7.vDecodeDur;
                    int i21 = statsCaculation7.aDecodeDur;
                    StatsCaculation statsCaculation8 = statsCaculation7;
                    JSONObject ItemReportRemote = ItemReportRemote(j3, ((StatsCaculation) next.getValue()).videoWidth, ((StatsCaculation) next.getValue()).videoHeight, (float) statsCaculation6.videoFps, (int) statsCaculation6.videoBps, (int) statsCaculation6.videoDelay, (int) statsCaculation6.videoLost, (int) statsCaculation6.audioDelay, (int) statsCaculation6.audioLost, i11, i12, i13, volumeAndReset2, i14, i15, arrayList, i16, i17, i18, i19, i20, i21);
                    jSONArray = jSONArray5;
                    if (ItemReportRemote != null) {
                        jSONArray.put(ItemReportRemote);
                    }
                    StatsCaculation statsCaculation9 = statsCaculation8;
                    statsCaculation9.videoFps = 0;
                    statsCaculation9.videoFpsArray.clear();
                    statsCaculation9.audioLost = 0;
                    statsCaculation9.audioDelay = 0;
                    statsCaculation9.audioBps = 0;
                    statsCaculation9.videoLost = 0;
                    statsCaculation9.videoDelay = 0;
                    statsCaculation9.videoBps = 0;
                    statsCaculation9.videoDecode = 0;
                    statsCaculation9.endToEndDelay = 0;
                    statsCaculation9.avSyncDeltaInMS = 0;
                }
                logReport = this;
                jSONArray2 = jSONArray;
            }
            JSONArray jSONArray6 = jSONArray2;
            if (jSONArray6.length() > 0) {
                ArraryJsonRemote(jSONArray6);
            }
        }
    }

    private JSONObject ItemReportRemote(long j, int i, int i2, float f, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, ArrayList<Integer> arrayList, int i14, int i15, int i16, int i17, int i18, int i19) {
        JSONObject jSONObject = new JSONObject();
        long j2 = j;
        try {
            jSONObject.put("senderId", j);
            int i20 = i;
            jSONObject.put("videoWidth", i);
            int i21 = i2;
            jSONObject.put("videoHeight", i2);
            jSONObject.put("videoFps", (double) f);
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().intValue());
            }
            jSONObject.put("videoFpsArray", jSONArray);
            int i22 = i3;
            jSONObject.put("videoBps", i3);
            int i23 = i4;
            jSONObject.put("videoDelay", i4);
            int i24 = i5;
            jSONObject.put("videoLost", i5);
            int i25 = i6;
            jSONObject.put("audioDelay", i6);
            int i26 = i7;
            jSONObject.put("audioLost", i7);
            int i27 = i8;
            jSONObject.put("audioBps", i8);
            jSONObject.put("videoDecFps", i9);
            jSONObject.put("audioDecFps", i10);
            jSONObject.put("audioVolume", i11);
            jSONObject.put("latency", i12);
            jSONObject.put("avDiff", i13);
            try {
                jSONObject.put("hbDur", this.REPORTTERVAL * ResultCode.KARAOKE_SUCCESS);
                jSONObject.put("vRtt", i14);
                jSONObject.put("aRtt", i15);
                jSONObject.put("vJitter", i16);
                jSONObject.put("aJitter", i17);
                jSONObject.put("vDecodeDur", i18);
                jSONObject.put("aDecodeDur", i19);
            } catch (Exception e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            Log.d(TAG, "jitterRemote Error for create  json log");
            return jSONObject;
        }
        return jSONObject;
    }

    private void ArraryJsonRemote(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            jSONObject.put("roomStr", this.mRoomid);
            jSONObject.put("uid", this.mUserid);
            jSONObject.put("plan", this.planId);
            jSONObject.put("describe", jSONArray);
            jSONObject.put("sessionId", this.mSessionId);
            jSONObject.put("streamId", this.mStreamId);
        } catch (Exception e) {
            Log.d(TAG, "jitterRemote Error for create  json log");
            e.printStackTrace();
        }
        LogRpt_Header cloneLogHeader = getCloneLogHeader();
        if (cloneLogHeader != null) {
            cloneLogHeader.pri = LOGSatusCode.LOG_REPORT_REMOTE.value;
            addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
        }
    }

    public LogReport(Context context) {
        this.mcontext = context.getApplicationContext();
        if (this.commonHeader == null) {
            this.commonHeader = new LogRpt_Header();
        }
        if (this.mconsumer == null) {
            this.mconsumer = new MessageConsumer(this.mLogSendreport);
        }
        this.mconsumer.start();
    }

    public void destroyLogManger() {
        Timer timer = this.mStatisticsTimer;
        if (timer != null) {
            timer.cancel();
        }
        MessageConsumer messageConsumer = this.mconsumer;
        if (messageConsumer != null) {
            messageConsumer.stop();
        }
    }

    private String getUUIDRandom() {
        try {
            return UUID.randomUUID().toString().replace("-", "");
        } catch (Exception e) {
            e.printStackTrace();
            return "secret";
        }
    }

    private LogRpt_Header getCloneLogHeader() {
        LogRpt_Header logRpt_Header = this.commonHeader;
        if (logRpt_Header == null) {
            return null;
        }
        try {
            return (LogRpt_Header) logRpt_Header.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void initWithParam(String str, long j, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        this.mRoomid = str;
        this.mUserid = j;
        this.mEngineReal = str2;
        this.mEngineId = i;
        this.mAppId = str4;
        this.planId = str8;
        this.commonHeader.appId = str4;
        this.commonHeader.psId = str5;
        this.commonHeader.agent = "OmniRtc_Android_V3.26.1102";
        this.commonHeader.engineId = this.mEngineId;
        DeviceInfo.init(this.mcontext);
        Context context = this.mcontext;
        if (context != null) {
            this.commonHeader.refuresh(context);
        }
        try {
            this.commonHeader.os = DeviceInfo.getOSver();
            this.commonHeader.dev = DeviceInfo.getDeviceName();
            this.commonHeader.cip = str6;
            this.commonHeader.tid = getUUIDRandom();
            this.commonHeader.lip = "";
            this.commonHeader.sip = "";
        } catch (Exception e) {
            e.printStackTrace();
        }
        String encode = URLEncoder.encode(str4);
        this.mpostSever = str7 + "&appid=" + encode;
        if (this.mStatisticsTimer == null) {
            Timer timer = new Timer();
            this.mStatisticsTimer = timer;
            timer.schedule(new TimerTask() {
                public void run() {
                    try {
                        LogReport.this.statisticsForTimer();
                    } catch (Exception e) {
                        Logger.i("LogReport mStatisticsTimer.schedule " + e.getMessage(), new Object[0]);
                    }
                }
            }, 0, (long) (this.REPORTTERVAL * ResultCode.KARAOKE_SUCCESS));
        }
    }

    public void setRoomid(String str) {
        this.mRoomid = str;
    }

    public void setSessionId(String str) {
        this.mSessionId = str;
    }

    public void setStreamId(String str) {
        this.mStreamId = str;
    }

    public String getmRoomid() {
        return this.mRoomid;
    }

    public long getmUserid() {
        return this.mUserid;
    }

    private void heartbeatReportLocal(String str, long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, double d, int i16, int i17) {
        Context context;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            String str2 = str;
            jSONObject.put("roomStr", str);
            jSONObject.put("plan", this.planId);
            long j2 = j;
            jSONObject.put("uid", j);
            int i18 = i;
            jSONObject.put("videoWidth", i);
            int i19 = i2;
            jSONObject.put("videoHeight", i2);
            int i20 = i3;
            jSONObject.put("videoFps", i3);
            int i21 = i4;
            jSONObject.put("videoTargetFps", i4);
            int i22 = i5;
            jSONObject.put("videoBps", i5);
            int i23 = i6;
            jSONObject.put("videoTargetBps", i6);
            jSONObject.put("audioBps", i13);
            jSONObject.put("delay", i7);
            jSONObject.put("volume", i10);
            jSONObject.put("videoEncodeFps", i8);
            jSONObject.put("audioEncodeFps", i9);
            String str3 = "1";
            jSONObject.put("audioPermission", this.hasRecordAudioPermission ? str3 : AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE);
            if (!this.hasCameraPermission) {
                str3 = AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE_NONE;
            }
            jSONObject.put("videoPermission", str3);
            jSONObject.put("sessionId", this.mSessionId);
            jSONObject.put("streamId", this.mStreamId);
            jSONObject.put("gatewayRtt", i11);
            int i24 = 100;
            int i25 = i12;
            if (i25 <= 100) {
                i24 = i25;
            }
            jSONObject.put("appcpu", i24);
            jSONObject.put("videoLostRate", i14);
            jSONObject.put("audioLostRate", i15);
            jSONObject.put("appMem", d);
            jSONObject.put("vRtt", i16);
            jSONObject.put("aRtt", i17);
            LogRpt_Header logRpt_Header = this.commonHeader;
            if (!(logRpt_Header == null || (context = this.mcontext) == null)) {
                logRpt_Header.flushNet(context);
            }
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_REPORT_LOCAL.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "jitterRemote Error for create  json log");
            e.printStackTrace();
        }
    }

    private void heartbeatReportRemote(String str, long j, long j2, int i, int i2, float f, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, ArrayList<Integer> arrayList) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            String str2 = str;
            jSONObject.put("roomStr", str);
            jSONObject.put("plan", this.planId);
            long j3 = j;
            jSONObject.put("uid", j);
            long j4 = j2;
            jSONObject.put("senderId", j2);
            int i14 = i;
            jSONObject.put("videoWidth", i);
            int i15 = i2;
            jSONObject.put("videoHeight", i2);
            jSONObject.put("videoFps", (double) f);
            if (arrayList != null) {
                jSONObject.put("videoFpsArray", arrayList.toString());
            }
            int i16 = i3;
            jSONObject.put("videoBps", i3);
            int i17 = i4;
            jSONObject.put("videoDelay", i4);
            jSONObject.put("videoLost", i5);
            jSONObject.put("audioDelay", i6);
            jSONObject.put("audioLost", i7);
            jSONObject.put("audioBps", i8);
            jSONObject.put("videoDecFps", i9);
            jSONObject.put("audioDecFps", i10);
            jSONObject.put("audioVolume", i11);
            jSONObject.put("latency", i12);
            jSONObject.put("avDiff", i13);
            jSONObject.put("hbDur", this.REPORTTERVAL * ResultCode.KARAOKE_SUCCESS);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_REPORT_REMOTE.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "jitterRemote Error for create  json log");
            e.printStackTrace();
        }
    }

    private void jitterRemote(String str, long j, long j2, int i, String str2, int i2, long j3, long j4, int i3, float f, int i4, int i5) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            String str3 = str;
            jSONObject.put("roomStr", str);
            long j5 = j;
            jSONObject.put("uid", j);
            jSONObject.put("plan", this.planId);
            long j6 = j2;
            jSONObject.put("senderId", j2);
            int i6 = i;
            jSONObject.put("code", i);
            String str4 = str2;
            jSONObject.put("msg", str2);
            int i7 = i2;
            jSONObject.put(HummerStyleUtils.Hummer.TYPE, i2);
            long j7 = j3;
            jSONObject.put("startTime", j3);
            jSONObject.put("endTime", j4);
            jSONObject.put("receivedBps", i3);
            jSONObject.put("receivedFps", (double) f);
            jSONObject.put("latency", i4);
            jSONObject.put("avDiff", i5);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_JITTER_REMOTE_REPORT.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "jitterRemote Error for create  json log");
            e.printStackTrace();
        }
    }

    private void jitterLocal(String str, long j, int i, String str2, int i2, long j2, long j3, int i3, float f, int i4, float f2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            String str3 = str;
            jSONObject.put("roomStr", str);
            jSONObject.put("plan", this.planId);
            long j4 = j;
            jSONObject.put("uid", j);
            int i5 = i;
            jSONObject.put("code", i);
            String str4 = str2;
            jSONObject.put("msg", str2);
            int i6 = i2;
            jSONObject.put(HummerStyleUtils.Hummer.TYPE, i2);
            long j5 = j2;
            jSONObject.put("startTime", j2);
            long j6 = j3;
            jSONObject.put("endTime", j3);
            jSONObject.put("sendBps", i3);
            jSONObject.put("sendFps", (double) f);
            jSONObject.put("sendTargetBps", i4);
            jSONObject.put("sendTargetFps", (double) f2);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_JITTER_LOCAL_REPORT.value;
                cloneLogHeader.toString(jSONObject);
            }
        } catch (Exception e) {
            Log.d(TAG, "jitterRemote Error for create  json log");
            e.printStackTrace();
        }
    }

    public void jitterRender(long j, long j2, long j3, long j4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            jSONObject.put("startTime", j);
            jSONObject.put("endTime", j2);
            jSONObject.put("cotonDur", j3);
            jSONObject.put("roomStr", this.mRoomid);
            jSONObject.put("plan", this.planId);
            jSONObject.put("senderId", j4);
            jSONObject.put("uid", this.mUserid);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_JITTER_RENDER_REPORT.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "jitterRemote Error for create  json log");
            e.printStackTrace();
        }
    }

    public void jitterRenderDelayStart(long j, long j2, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            jSONObject.put(TraceEvent.TIMESTAMP, j + "");
            jSONObject.put("roomStr", this.mRoomid);
            jSONObject.put("plan", this.planId);
            jSONObject.put("senderId", j2);
            jSONObject.put("uid", this.mUserid);
            jSONObject.put("sessionId", this.mSessionId);
            jSONObject.put("streamId", this.mStreamId);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_JITTER_RENDER_START_REPORT.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "jitterRemote Error for create  json log");
            e.printStackTrace();
        }
    }

    public void jitterRenderDelayEnd(long j, long j2, String str, long j3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            jSONObject.put(TraceEvent.TIMESTAMP, j + "");
            jSONObject.put("catonDur", j3);
            jSONObject.put("roomStr", this.mRoomid);
            jSONObject.put("plan", this.planId);
            jSONObject.put("senderId", j2);
            jSONObject.put("uid", this.mUserid);
            jSONObject.put("sessionId", this.mSessionId);
            jSONObject.put("streamId", this.mStreamId);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_JITTER_RENDER_END_REPORT.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "jitterRemote Error for create  json log");
            e.printStackTrace();
        }
    }

    public void audioJitterRenderDelayStart(long j, long j2, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            jSONObject.put(TraceEvent.TIMESTAMP, j + "");
            jSONObject.put("roomStr", this.mRoomid);
            jSONObject.put("plan", this.planId);
            jSONObject.put("senderId", j2);
            jSONObject.put("uid", this.mUserid);
            jSONObject.put("sessionId", this.mSessionId);
            jSONObject.put("streamId", this.mStreamId);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_AUDIO_JITTER_RENDER_START_REPORT.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "audio jitterRemote Error for create  json log");
            e.printStackTrace();
        }
    }

    public void audioJitterRenderDelayEnd(long j, long j2, String str, long j3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            jSONObject.put(TraceEvent.TIMESTAMP, j + "");
            jSONObject.put("catonDur", j3);
            jSONObject.put("roomStr", str);
            jSONObject.put("senderId", j2);
            jSONObject.put("uid", this.mUserid);
            jSONObject.put("sessionId", this.mSessionId);
            jSONObject.put("streamId", this.mStreamId);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_AUDIO_JITTER_RENDER_END_REPORT.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "audio jitterRemote Error for create  json log");
            e.printStackTrace();
        }
    }

    public void updateClientIp(String str) {
        this.commonHeader.cip = str;
    }

    private void startPublish(String str, long j, int i, String str2, int i2, int i3, int i4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            jSONObject.put("roomStr", str);
            jSONObject.put("plan", this.planId);
            jSONObject.put("uid", j);
            jSONObject.put("code", i);
            jSONObject.put("msg", str2);
            jSONObject.put(HummerStyleUtils.Hummer.TYPE, i2);
            jSONObject.put("audioDelay", i3);
            jSONObject.put("videoDelay", i4);
            jSONObject.put("sessionId", this.mSessionId);
            jSONObject.put("streamId", this.mStreamId);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_START_PUSH_MEDIA.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "startPublish Error for create  json log");
            e.printStackTrace();
        }
    }

    private void stopPublish(String str, long j, int i, String str2, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            jSONObject.put("roomStr", str);
            jSONObject.put("plan", this.planId);
            jSONObject.put("uid", j);
            jSONObject.put("code", i);
            jSONObject.put("msg", str2);
            jSONObject.put(HummerStyleUtils.Hummer.TYPE, i2);
            jSONObject.put("sessionId", this.mSessionId);
            jSONObject.put("streamId", this.mStreamId);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_END_PUSH_MEDIA.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "stopPublish Error for create  json log");
            e.printStackTrace();
        }
    }

    private void startRemotePlay(String str, long j, long j2, int i, String str2, int i2, int i3, int i4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            jSONObject.put("roomStr", str);
            jSONObject.put("plan", this.planId);
            jSONObject.put("uid", j);
            jSONObject.put("code", i);
            jSONObject.put("msg", str2);
            jSONObject.put(HummerStyleUtils.Hummer.TYPE, i2);
            jSONObject.put("audioDelay", i3);
            jSONObject.put("videoDelay", i4);
            jSONObject.put("senderId", j2);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_START_REMOTE_MEDIA.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "startRemotePlay Error for create  json log");
            e.printStackTrace();
        }
    }

    private void stopRemotePlay(String str, long j, long j2, int i, String str2, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            jSONObject.put("roomStr", str);
            jSONObject.put("plan", this.planId);
            jSONObject.put("uid", j);
            jSONObject.put("senderId", j2);
            jSONObject.put("code", i);
            jSONObject.put("msg", str2);
            jSONObject.put(HummerStyleUtils.Hummer.TYPE, i2);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_END_REMOTE_MEDIA.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "stopRemotePlay Error for create  json log");
            e.printStackTrace();
        }
    }

    private void sendLogFailed(String str, long j, long j2, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            jSONObject.put("url", str);
            LogRpt_Header logRpt_Header = this.commonHeader;
            if (logRpt_Header != null) {
                jSONObject.put("cip", logRpt_Header.cip);
                jSONObject.put("lip", this.commonHeader.lip);
                jSONObject.put("sip", this.commonHeader.sip);
            }
            jSONObject.put("fts", j);
            jSONObject.put("lts", j2);
            jSONObject.put(PictureConfig.EXTRA_DATA_COUNT, i);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_FAIL_REPORT.value;
                cloneLogHeader.serv = this.commonHeader.pri;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "sendLogFailed Error for create  json log");
            e.printStackTrace();
        }
        LogRpt_Header logRpt_Header2 = this.commonHeader;
        if (logRpt_Header2 != null) {
            logRpt_Header2.serv = 320;
        }
    }

    /* access modifiers changed from: protected */
    public void addToBlockingQueue(JSONObject jSONObject) {
        LogMessage logMessage = new LogMessage(jSONObject);
        MessageConsumer messageConsumer = this.mconsumer;
        if (messageConsumer != null) {
            messageConsumer.add(logMessage);
        }
    }

    public void scheduler(String str, long j, int i, String str2, int i2, String str3) {
        this.mJoinedRoom = true;
        this.planId = str3;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            jSONObject.put("roomStr", this.mRoomid);
            jSONObject.put("uid", j);
            jSONObject.put("code", i);
            jSONObject.put("msg", str2);
            jSONObject.put("plan", str3);
            jSONObject.put("delay", i2);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_SCHEDULER.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "scheduler Error for create  json log");
            e.printStackTrace();
        }
    }

    public void joinRoom(int i, long j, int i2, String str, int i3) {
        this.mJoinedRoom = true;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            jSONObject.put("roomStr", this.mRoomid);
            jSONObject.put("plan", this.planId);
            jSONObject.put("uid", j);
            jSONObject.put("code", i2);
            jSONObject.put("msg", str);
            jSONObject.put("delay", i);
            jSONObject.put("sessionId", this.mSessionId);
            jSONObject.put("streamId", this.mStreamId);
            jSONObject.put("joinType", i3);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_JOIN_ROOM.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
            if (this.mmapStats.get(String.valueOf(this.mUserid)) == null) {
                this.mmapStats.put(String.valueOf(this.mUserid), new StatsCaculation(this.mUserid, this.timesOfSeconds));
            }
        } catch (Exception e) {
            Log.d(TAG, "joinRoom Error for create  json log");
            e.printStackTrace();
        }
    }

    public void leaveRoom(String str, long j, int i, String str2, long j2) {
        if (j == this.mUserid) {
            this.mJoinedRoom = false;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            if (str.isEmpty()) {
                jSONObject.put("roomStr", this.mRoomid);
            } else {
                jSONObject.put("roomStr", str);
            }
            if (j == 0) {
                jSONObject.put("uid", this.mUserid);
            } else {
                jSONObject.put("uid", j);
            }
            jSONObject.put("plan", this.planId);
            jSONObject.put("code", i);
            jSONObject.put("delay", j2);
            jSONObject.put("msg", str2);
            jSONObject.put("sessionId", this.mSessionId);
            jSONObject.put("streamId", this.mStreamId);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_LEAVE_ROOM.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "joinRoom Error for create  json log");
            e.printStackTrace();
        }
    }

    public void roomDisconnect(String str, long j, int i, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            if (str.isEmpty()) {
                jSONObject.put("roomStr", this.mRoomid);
            } else {
                jSONObject.put("roomStr", str);
            }
            if (j == 0) {
                jSONObject.put("uid", this.mUserid);
            } else {
                jSONObject.put("uid", j);
            }
            jSONObject.put("code", i);
            jSONObject.put("plan", this.planId);
            jSONObject.put("url", this.mpostSever);
            jSONObject.put("reason", str2);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_NETWORK_LOST.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "networkLost Error for create  json log");
            e.printStackTrace();
        }
    }

    public void roomReconnect(String str, long j, int i, long j2, long j3, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            if (str.isEmpty()) {
                jSONObject.put("roomStr", this.mRoomid);
            } else {
                jSONObject.put("roomStr", str);
            }
            if (j == 0) {
                jSONObject.put("uid", this.mUserid);
            } else {
                jSONObject.put("uid", j);
            }
            jSONObject.put("plan", this.planId);
            jSONObject.put("code", i);
            jSONObject.put("url", this.mpostSever);
            jSONObject.put("startTime", j2);
            jSONObject.put("endTime", j3);
            jSONObject.put(PictureConfig.EXTRA_DATA_COUNT, i2);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_NETWORK_RECONNECT.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "networkLost Error for create  json log");
            e.printStackTrace();
        }
    }

    public void LogStaticRemoteVideoIn(long j, int i) {
        this.lockStats.lock();
        try {
            StatsCaculation statsCaculation = this.mmapStats.get(String.valueOf(j));
            if (statsCaculation != null) {
                startRemotePlay(this.mRoomid, this.mUserid, j, LOGErrorCode.LOG_Success.value, "start recv romte media", LOGMediaType.LOG_MEDIA_VIDEO.value, statsCaculation.mRemoteMediaDelay, i);
                statsCaculation.mRemoteMediaDelay = i;
            } else {
                StatsCaculation statsCaculation2 = new StatsCaculation(j, this.timesOfSeconds);
                statsCaculation2.mRemoteMediaDelay = i;
                this.mmapStats.put(String.valueOf(j), statsCaculation2);
            }
        } finally {
            this.lockStats.unlock();
        }
    }

    public void LogStaticRemoteAudioIn(long j, int i) {
        int i2 = i;
        this.lockStats.lock();
        try {
            StatsCaculation statsCaculation = this.mmapStats.get(String.valueOf(j));
            if (statsCaculation != null) {
                startRemotePlay(this.mRoomid, this.mUserid, j, LOGErrorCode.LOG_Success.value, "remote media start recving now ", LOGMediaType.LOG_MEDIA_AUDIO.value, i, statsCaculation.mRemoteMediaDelay);
                statsCaculation.mRemoteMediaDelay = i2;
            } else {
                StatsCaculation statsCaculation2 = new StatsCaculation(j, this.timesOfSeconds);
                statsCaculation2.mRemoteMediaDelay = i2;
                this.mmapStats.put(String.valueOf(j), statsCaculation2);
                startRemotePlay(this.mRoomid, this.mUserid, j, LOGErrorCode.LOG_Success.value, "remote media start recving now ", LOGMediaType.LOG_MEDIA_AUDIO.value, i, statsCaculation2.mRemoteMediaDelay);
            }
        } finally {
            this.lockStats.unlock();
        }
    }

    public void LogStaticLocalVideoIn(int i, int i2, int i3) {
        this.lockStats.lock();
        try {
            StatsCaculation statsCaculation = this.mmapStats.get(String.valueOf(this.mUserid));
            if (statsCaculation != null) {
                statsCaculation.mLocalMediaDelayVideo = i;
                statsCaculation.videoWidth = i2;
                statsCaculation.videoHeight = i3;
            } else {
                StatsCaculation statsCaculation2 = new StatsCaculation(this.mUserid, this.timesOfSeconds);
                statsCaculation2.mLocalMediaDelayVideo = i;
                statsCaculation2.videoHeight = i3;
                statsCaculation2.videoWidth = i2;
                this.mmapStats.put(String.valueOf(this.mUserid), statsCaculation2);
            }
        } finally {
            this.lockStats.unlock();
        }
    }

    public void LogStaticLocalAudioIn(int i) {
        this.lockStats.lock();
        try {
            StatsCaculation statsCaculation = this.mmapStats.get(String.valueOf(this.mUserid));
            if (statsCaculation != null) {
                statsCaculation.mLocalMediaDelayAudio = i;
            } else {
                StatsCaculation statsCaculation2 = new StatsCaculation(this.mUserid, this.timesOfSeconds);
                statsCaculation2.mLocalMediaDelayAudio = i;
                this.mmapStats.put(String.valueOf(this.mUserid), statsCaculation2);
            }
        } finally {
            this.lockStats.unlock();
        }
    }

    public void LogStartPublish(int i) {
        this.lockStats.lock();
        try {
            StatsCaculation statsCaculation = this.mmapStats.get(String.valueOf(this.mUserid));
            if (statsCaculation != null) {
                startPublish(this.mRoomid, this.mUserid, LOGErrorCode.LOG_Success.value, "start push media", i, statsCaculation.mLocalMediaDelayAudio, statsCaculation.mLocalMediaDelayVideo);
            }
        } finally {
            this.lockStats.unlock();
        }
    }

    public void LogStopPublish(long j, int i) {
        this.lockStats.lock();
        try {
            StatsCaculation statsCaculation = this.mmapStats.get(String.valueOf(j));
            stopPublish(this.mRoomid, j, LOGErrorCode.LOG_Success.value, "stop publish really!", i);
            if (statsCaculation != null) {
                statsCaculation.refresh();
            }
        } finally {
            this.lockStats.unlock();
        }
    }

    public void LogStopPlay(long j, int i) {
        this.lockStats.lock();
        try {
            stopRemotePlay(this.mRoomid, this.mUserid, j, LOGErrorCode.LOG_Success.value, "remote media stop now", i);
        } finally {
            this.lockStats.unlock();
        }
    }

    public void deleteUser(long j) {
        this.lockStats.lock();
        try {
            Iterator<Map.Entry<String, StatsCaculation>> it = this.mmapStats.entrySet().iterator();
            while (it.hasNext()) {
                if (((StatsCaculation) it.next().getValue()).uid == j) {
                    it.remove();
                }
            }
        } finally {
            this.lockStats.unlock();
        }
    }

    public void LogStaticRemoteVideoStats(LogVideoRemoteStatistics logVideoRemoteStatistics) {
        this.lockStats.lock();
        if (logVideoRemoteStatistics == null) {
            this.lockStats.unlock();
            return;
        }
        try {
            StatsCaculation statsCaculation = this.mmapStats.get(String.valueOf(logVideoRemoteStatistics.uid));
            if (statsCaculation != null) {
                statsCaculation.videoFps = logVideoRemoteStatistics.decoderOutputFrameRate;
                statsCaculation.videoFpsArray.add(Integer.valueOf(logVideoRemoteStatistics.decoderOutputFrameRate));
                statsCaculation.videoWidth = logVideoRemoteStatistics.width;
                statsCaculation.videoHeight = logVideoRemoteStatistics.height;
                statsCaculation.videoDecode = logVideoRemoteStatistics.decoderOutputFrameRate;
                statsCaculation.endToEndDelay = logVideoRemoteStatistics.latency;
                statsCaculation.avSyncDeltaInMS = logVideoRemoteStatistics.avDiff;
                statsCaculation.vRtt = logVideoRemoteStatistics.vRtt;
                statsCaculation.vJitter = logVideoRemoteStatistics.vJitter;
                statsCaculation.vDecodeDur = logVideoRemoteStatistics.vDecodeDur;
            }
        } finally {
            this.lockStats.unlock();
        }
    }

    public void LogStaticLocalVideoStats(LogVideoLocalStatistics logVideoLocalStatistics) {
        LogReport logReport;
        LogVideoLocalStatistics logVideoLocalStatistics2 = logVideoLocalStatistics;
        this.lockStats.lock();
        if (logVideoLocalStatistics2 == null) {
            this.lockStats.unlock();
            return;
        }
        try {
            StatsCaculation statsCaculation = this.mmapStats.get(String.valueOf(this.mUserid));
            if (statsCaculation != null) {
                statsCaculation.videoBps = (long) logVideoLocalStatistics2.sentBitrate;
                statsCaculation.videoFps = logVideoLocalStatistics2.sentFrameRate;
                statsCaculation.videoTargetBps = (long) logVideoLocalStatistics2.videoTargetBps;
                statsCaculation.videoTargetFps = (float) logVideoLocalStatistics2.videoTargetFps;
                statsCaculation.videoEncoded = logVideoLocalStatistics2.videoEncoded;
                statsCaculation.videoLost = (long) logVideoLocalStatistics2.mVideoLossRate;
                statsCaculation.vRtt = logVideoLocalStatistics2.vRtt;
                statsCaculation.videoWidth = logVideoLocalStatistics2.encodedFrameWidth;
                statsCaculation.videoHeight = logVideoLocalStatistics2.encodedFrameHeight;
            }
            if (logVideoLocalStatistics2.sentFrameRate > 0) {
                try {
                    if (((double) logVideoLocalStatistics2.sentFrameRate) <= 5.0d) {
                        long currentTimeMillis = System.currentTimeMillis();
                        jitterLocal(this.mRoomid, this.mUserid, LOGErrorCode.LOG_Success.value, "jittle msg coming ,be causion", LOGMediaType.LOG_MEDIA_VIDEO.value, currentTimeMillis - 2000, currentTimeMillis, logVideoLocalStatistics2.sentBitrate, (float) logVideoLocalStatistics2.sentFrameRate, logVideoLocalStatistics2.videoTargetBps, (float) logVideoLocalStatistics2.videoTargetFps);
                    }
                } catch (Throwable th) {
                    th = th;
                    logReport = this;
                    logReport.lockStats.unlock();
                    throw th;
                }
            }
            this.lockStats.unlock();
        } catch (Throwable th2) {
            th = th2;
            logReport = this;
            logReport.lockStats.unlock();
            throw th;
        }
    }

    public void LogStaticLocalAudioStats(LogAudioLocalStatistics logAudioLocalStatistics) {
        this.lockStats.lock();
        if (logAudioLocalStatistics == null) {
            this.lockStats.unlock();
            return;
        }
        try {
            StatsCaculation statsCaculation = this.mmapStats.get(String.valueOf(this.mUserid));
            if (statsCaculation != null) {
                statsCaculation.audioLost = (long) logAudioLocalStatistics.audioLossRate;
                statsCaculation.aRtt = logAudioLocalStatistics.aRtt;
            }
        } finally {
            this.lockStats.unlock();
        }
    }

    public void LogStaticRemoteAudioStats(LogAudioRemoteStatistics logAudioRemoteStatistics) {
        this.lockStats.lock();
        if (logAudioRemoteStatistics == null) {
            this.lockStats.unlock();
            return;
        }
        try {
            StatsCaculation statsCaculation = this.mmapStats.get(String.valueOf(logAudioRemoteStatistics.uid));
            if (statsCaculation != null) {
                statsCaculation.audioLost = (long) logAudioRemoteStatistics.audioLossRate;
                statsCaculation.audioDelay = (long) logAudioRemoteStatistics.jitterBufferDelay;
                statsCaculation.audioBps = (long) logAudioRemoteStatistics.receivedBitrate;
                statsCaculation.audioDecode = logAudioRemoteStatistics.audioDecFps;
                statsCaculation.aRtt = logAudioRemoteStatistics.aRtt;
                statsCaculation.aJitter = logAudioRemoteStatistics.aJitter;
                statsCaculation.aDecodeDur = logAudioRemoteStatistics.aDecodeDur;
            }
        } finally {
            this.lockStats.unlock();
        }
    }

    public void LogStaticRemoteVideoTransportStats(LogVideoRemoteStatistics logVideoRemoteStatistics) {
        this.lockStats.lock();
        if (logVideoRemoteStatistics == null) {
            this.lockStats.unlock();
            return;
        }
        try {
            StatsCaculation statsCaculation = this.mmapStats.get(String.valueOf(logVideoRemoteStatistics.uid));
            if (statsCaculation != null) {
                statsCaculation.videoLost = (long) logVideoRemoteStatistics.packetLossRate;
                statsCaculation.videoDelay = (long) logVideoRemoteStatistics.delay;
                statsCaculation.videoBps = (long) logVideoRemoteStatistics.receivedBitrate;
            }
        } finally {
            this.lockStats.unlock();
        }
    }

    public void LogStaticRemoteAudioTransportStats(LogAudioRemoteStatistics logAudioRemoteStatistics) {
        this.lockStats.lock();
        if (logAudioRemoteStatistics == null) {
            this.lockStats.unlock();
            return;
        }
        try {
            StatsCaculation statsCaculation = this.mmapStats.get(String.valueOf(logAudioRemoteStatistics.uid));
            if (statsCaculation != null) {
                statsCaculation.videoLost = (long) logAudioRemoteStatistics.audioLossRate;
                statsCaculation.videoDelay = (long) logAudioRemoteStatistics.jitterBufferDelay;
                statsCaculation.videoBps = (long) logAudioRemoteStatistics.receivedBitrate;
                statsCaculation.audioDecode = logAudioRemoteStatistics.audioDecFps;
                statsCaculation.aRtt = logAudioRemoteStatistics.aRtt;
                statsCaculation.aJitter = logAudioRemoteStatistics.aJitter;
                statsCaculation.aDecodeDur = logAudioRemoteStatistics.aDecodeDur;
            }
        } finally {
            this.lockStats.unlock();
        }
    }

    public void LogStatisticsMemoryStats(LogMemoryStatistics logMemoryStatistics) {
        this.lockStats.lock();
        if (logMemoryStatistics == null) {
            this.lockStats.unlock();
            return;
        }
        try {
            StatsCaculation statsCaculation = this.mmapStats.get(String.valueOf(this.mUserid));
            if (statsCaculation != null) {
                statsCaculation.appMem = logMemoryStatistics.memoryAppUsageRatio;
            }
        } finally {
            this.lockStats.unlock();
        }
    }

    public void LogLocalAudioSentBps(int i) {
        this.lockStats.lock();
        try {
            StatsCaculation statsCaculation = this.mmapStats.get(String.valueOf(this.mUserid));
            if (statsCaculation != null) {
                statsCaculation.audioBps = (long) i;
            }
        } finally {
            this.lockStats.unlock();
        }
    }

    public void LogStatistics(int i) {
        this.lockStats.lock();
        Context context = this.mcontext;
        if (context != null) {
            this.commonHeader.refuresh(context);
        }
        try {
            StatsCaculation statsCaculation = this.mmapStats.get(String.valueOf(this.mUserid));
            if (statsCaculation != null) {
                statsCaculation.localDelay = i;
            }
        } finally {
            this.lockStats.unlock();
        }
    }

    public void setGateWayRttAndAppCpu(int i, int i2) {
        this.lockStats.lock();
        try {
            StatsCaculation statsCaculation = this.mmapStats.get(String.valueOf(this.mUserid));
            if (statsCaculation != null) {
                statsCaculation.gatewayRtt = i;
                statsCaculation.appcpu = i2;
            }
        } finally {
            this.lockStats.unlock();
        }
    }

    public void LogStaticNetworkQuality(long j, int i, int i2) {
        if (j == 0) {
            j = this.mUserid;
        }
        StatsCaculation statsCaculation = this.mmapStats.get(String.valueOf(j));
        if (statsCaculation != null) {
            statsCaculation.txQuality = i;
            statsCaculation.rxQuality = i2;
        }
    }

    public void LogStaticUserAudioVolume(long j, int i) {
        this.lockStats.lock();
        try {
            Map<String, StatsCaculation> map = this.mmapStats;
            if (j == 0) {
                j = this.mUserid;
            }
            StatsCaculation statsCaculation = map.get(String.valueOf(j));
            if (statsCaculation != null) {
                statsCaculation.volume = i;
            }
        } finally {
            this.lockStats.unlock();
        }
    }

    public void pushRtmpState(String str, String str2, String str3) {
        super.pushRtmpState(str, str2, str3);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            jSONObject.put("roomStr", this.mRoomid);
            jSONObject.put("uid", this.mUserid);
            jSONObject.put("plan", this.planId);
            jSONObject.put("errorCode", str3);
            jSONObject.put("url", str);
            jSONObject.put("state", str2);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_RTMP_STATE.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "pushRtmpState Error for create  json log");
            e.printStackTrace();
        }
    }

    public void sendCommonError(String str, String str2, String str3, String str4) {
        super.sendCommonError(str, str2, str3, str4);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            jSONObject.put("roomStr", str2);
            jSONObject.put("uid", this.mUserid);
            jSONObject.put("plan", this.planId);
            jSONObject.put(Constants.IPC_BUNDLE_KEY_SEND_ERROR, str3);
            jSONObject.put("errorMsg", str4);
            jSONObject.put("module", str);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_COMMON_ERROR.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "sendCommonError Error for create  json log");
            e.printStackTrace();
        }
    }

    public void addDeviceInfo(String str, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            jSONObject.put("roomStr", this.mRoomid);
            jSONObject.put("uid", this.mUserid);
            jSONObject.put("plan", this.planId);
            jSONObject.put(HummerStyleUtils.Hummer.TYPE, str);
            jSONObject.put("subtype", str2);
            jSONObject.put("sessionId", this.mSessionId);
            jSONObject.put("streamId", this.mStreamId);
            JSONObject jSONObject2 = new JSONObject();
            if (str3 != null) {
                jSONObject2.put("reason", str3);
            }
            jSONObject.put("privdata", jSONObject2);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_DEVICE_INFO.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "addDeviceInfo Error for create  json log");
            e.printStackTrace();
        }
    }

    private void sendImportantEvents(String str, String str2, String str3, long j, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            jSONObject.put("roomStr", this.mRoomid);
            jSONObject.put("uid", this.mUserid);
            jSONObject.put("plan", this.planId);
            jSONObject.put(HummerStyleUtils.Hummer.TYPE, str);
            jSONObject.put("subtype", str2);
            jSONObject.put("sessionId", this.mSessionId);
            jSONObject.put("streamId", this.mStreamId);
            JSONObject jSONObject2 = new JSONObject();
            if (str3 != null) {
                jSONObject2.put("reason", str3);
            }
            if (j != -1) {
                jSONObject2.put("senderId", j);
            }
            if (str4 != null) {
                jSONObject2.put(HummerStyleUtils.Hummer.MODE, str4);
            }
            jSONObject.put("privdata", jSONObject2);
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_IMPORTANT_EVENTS.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "addDeviceInfo Error for create  json log");
            e.printStackTrace();
        }
    }

    public void addImportantEvents(String str, String str2, String str3, long j) {
        sendImportantEvents(str, str2, str3, j, (String) null);
    }

    public void addImportantEvents(String str, String str2, String str3) {
        sendImportantEvents(str, str2, (String) null, -1, str3);
    }

    public void appStateChanged(int i) {
        this.mJoinedRoom = true;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ver", this.VERSION_VER);
            jSONObject.put("engine", this.mEngineReal);
            jSONObject.put("roomStr", this.mRoomid);
            jSONObject.put("plan", this.planId);
            jSONObject.put("uid", this.mUserid);
            jSONObject.put("sessionId", this.mSessionId);
            jSONObject.put("streamId", this.mStreamId);
            jSONObject.put("state", i + "");
            LogRpt_Header cloneLogHeader = getCloneLogHeader();
            if (cloneLogHeader != null) {
                cloneLogHeader.pri = LOGSatusCode.LOG_APP_STATE.value;
                addToBlockingQueue(cloneLogHeader.toJson(jSONObject));
            }
        } catch (Exception e) {
            Log.d(TAG, "joinRoom Error for create  json log");
            e.printStackTrace();
        }
    }
}
