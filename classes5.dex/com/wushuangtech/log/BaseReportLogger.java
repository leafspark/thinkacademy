package com.wushuangtech.log;

import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import com.wushuangtech.jni.ReportLogJni;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.utils.OmniLog;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import org.json.JSONObject;

public abstract class BaseReportLogger {
    private static final String TAG = "BaseReportLogger";
    protected int logReportInterval;
    private final SimpleDateFormat mLogTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);
    private final Object mTimeFormatLock = new Object();
    protected Timer timer = null;
    protected int timerTicks;

    public static final class ReportLogMsg {
        public static final int REPORTMSG_MSG_TYPE_NORMAL = 0;
        public static final int REPORTMSG_MSG_TYPE_WARNIING = 1;
        public static final int REPORTMSG_TYPE_DATA = 1;
        public static final int REPORTMSG_TYPE_EVENT = 16;
        public String logMsg;
        public int logType;
        public int msgType;
    }

    /* access modifiers changed from: protected */
    public abstract boolean buildCommonJsonContent(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    public String getFormatDateStr() {
        return getFormatDateStr(System.currentTimeMillis());
    }

    /* access modifiers changed from: protected */
    public String getFormatDateStr(long j) {
        String format;
        synchronized (this.mTimeFormatLock) {
            format = this.mLogTimeFormat.format(Long.valueOf(j));
        }
        return format;
    }

    /* access modifiers changed from: package-private */
    public boolean putObjToJson(JSONObject jSONObject, Map<String, Object> map) {
        if (map != null && map.size() > 0) {
            try {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    Object value = next.getValue();
                    if (value instanceof Integer) {
                        jSONObject.put(str, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        jSONObject.put(str, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        jSONObject.put(str, (double) ((Float) value).floatValue());
                    } else if (value instanceof Double) {
                        jSONObject.put(str, ((Double) value).doubleValue());
                    } else if (value instanceof String) {
                        jSONObject.put(str, value);
                    } else if (value instanceof Boolean) {
                        jSONObject.put(str, ((Boolean) value).booleanValue());
                    }
                }
                return true;
            } catch (Exception e) {
                String obj = toString();
                OmniLog.e(obj, "putObjsToJson Json Exception : " + e.getLocalizedMessage());
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void sendJsonObj(String str, JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        sb.append("event=");
        sb.append(str);
        sb.append(" ");
        sb.append(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
        String sb2 = sb.toString();
        ReportLogMsg reportLogMsg = new ReportLogMsg();
        reportLogMsg.logType = 16;
        reportLogMsg.logMsg = sb2;
        reportLogMsg.msgType = 0;
        SendLogMsg(reportLogMsg);
        OmniLog.i(OmniLog.LOG_WATCH, TAG, "Report event >>> " + sb2);
    }

    /* access modifiers changed from: package-private */
    public void buildCommonJsonContentAndSend(String str, Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        if (buildCommonJsonContent(jSONObject) && putObjToJson(jSONObject, map)) {
            sendJsonObj(str, jSONObject);
        }
    }

    /* access modifiers changed from: protected */
    public void SendLogMsg(ReportLogMsg reportLogMsg) {
        ReportLogJni.getInstance().ReportLog(reportLogMsg.logMsg, reportLogMsg.msgType, GlobalConfig.mAppId);
    }
}
