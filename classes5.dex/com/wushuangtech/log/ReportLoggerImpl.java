package com.wushuangtech.log;

import android.os.Build;
import android.text.TextUtils;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.utils.OmniLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportLoggerImpl extends BaseReportLogger {
    public static final int EVENT_ENTER_ROOM = 2;
    public static final int EVENT_INIT = 1;
    public static final int EVENT_LEAVE_ROOM = 3;
    public static final int EVENT_NORMAL_CALLBACK = 6;
    public static final int EVENT_NORMAL_INVOKE = 5;
    public static final int EVENT_ROOM_SUCCESS = 4;
    public static final int EVENT_SESSION = 7;
    private static final String TAG = "ReportLoggerImpl";
    private String mAppId;
    private final List<EventBean> mCacheBeans = new ArrayList();
    private final List<EventBean> mCacheCallBackBeans = new ArrayList();
    private int mCallBackIndex;
    private String mChannelName;
    private String mConnectId;
    private int mInvokeIndex;
    private boolean mIsCanReport;
    private final Object mLock = new Object();
    private int mRole;
    private String mSessionId = "";
    private long mUid;

    /* access modifiers changed from: protected */
    public boolean buildCommonJsonContent(JSONObject jSONObject) {
        try {
            if (!TextUtils.isEmpty(this.mAppId) && !TextUtils.isEmpty(this.mChannelName) && !TextUtils.isEmpty(this.mConnectId)) {
                if (this.mUid != 0) {
                    jSONObject.put("time", getFormatDateStr());
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
                }
            }
            return true;
        } catch (Exception e) {
            OmniLog.e(TAG, "buildCommonJsonContent Json Exception : " + e.getLocalizedMessage());
            return false;
        }
    }

    public void handleReportEvent(int i, Object... objArr) {
        synchronized (this.mLock) {
            receiveMessage(i, objArr);
        }
    }

    public void clearResource() {
        synchronized (this.mLock) {
            this.mConnectId = "";
            this.mAppId = "";
            this.mUid = 0;
            this.mChannelName = "";
            this.mSessionId = "";
            this.mIsCanReport = false;
            this.mCacheBeans.clear();
            this.mCacheCallBackBeans.clear();
        }
    }

    private void receiveMessage(int i, Object... objArr) {
        if (i == 1) {
            this.mConnectId = objArr[0];
            this.mAppId = objArr[1];
            this.mUid = objArr[2].longValue();
            this.mChannelName = objArr[3];
            this.mRole = objArr[4].intValue();
        } else if (i == 2) {
            checkCacheBeans();
        } else if (i == 3) {
            handleLogEvent(objArr[0]);
        } else if (i == 4) {
            this.mIsCanReport = true;
            checkCacheBeans();
        } else if (i == 5) {
            EventBean eventBean = objArr[0];
            if (this.mIsCanReport) {
                handleLogEvent(eventBean);
            } else {
                this.mCacheBeans.add(eventBean);
            }
        } else if (i == 6) {
            EventBean eventBean2 = objArr[0];
            if (this.mIsCanReport) {
                handleLogCallBackEvent(eventBean2);
            } else {
                this.mCacheCallBackBeans.add(eventBean2);
            }
        } else if (i == 7 && objArr[0] != null) {
            this.mSessionId = objArr[0];
        }
    }

    private void checkCacheBeans() {
        if (this.mCacheBeans.size() > 0) {
            handleLogEvent(this.mCacheBeans);
            this.mCacheBeans.clear();
        }
        if (this.mCacheCallBackBeans.size() > 0) {
            handleLogCallBackEvent(this.mCacheCallBackBeans);
            this.mCacheCallBackBeans.clear();
        }
    }

    private void handleLogCallBackEvent(EventBean eventBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eventBean);
        handleLogEvent(arrayList, this.mCallBackIndex, true);
        this.mCallBackIndex++;
    }

    private void handleLogCallBackEvent(List<EventBean> list) {
        if (list != null && list.size() > 0) {
            handleLogEvent(list, this.mCallBackIndex, true);
            this.mCallBackIndex += list.size();
        }
    }

    private void handleLogEvent(EventBean eventBean) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(eventBean);
        handleLogEvent(arrayList, this.mInvokeIndex, false);
        this.mInvokeIndex++;
    }

    private void handleLogEvent(List<EventBean> list) {
        if (list != null && list.size() > 0) {
            handleLogEvent(list, this.mInvokeIndex, false);
            this.mInvokeIndex += list.size();
        }
    }

    private void handleLogEvent(List<EventBean> list, int i, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event", z ? "user_callback_logs" : "user_func_logs");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (buildCommonJsonContent(jSONObject)) {
            try {
                JSONArray jSONArray = new JSONArray();
                jSONObject.put("funcArr", jSONArray);
                for (EventBean buildEventBeanToJson : list) {
                    buildEventBeanToJson(buildEventBeanToJson, i, jSONArray);
                    i++;
                }
                if (z) {
                    sendJsonObj("user_callback_logs", jSONObject);
                } else {
                    sendJsonObj("user_func_logs", jSONObject);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void buildEventBeanToJson(EventBean eventBean, int i, JSONArray jSONArray) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            StringBuilder sb = new StringBuilder();
            HashMap hashMap = new HashMap();
            if (TextUtils.isEmpty(eventBean.prefix)) {
                str = "";
            } else {
                str = eventBean.prefix + eventBean.funName;
            }
            hashMap.put("func", str);
            hashMap.put("ts", getFormatDateStr(eventBean.timestamp));
            hashMap.put("idx", Integer.valueOf(i));
            if (eventBean.objs != null) {
                for (int i2 = 0; i2 < eventBean.objs.length; i2++) {
                    sb.append(eventBean.objs[i2]);
                    if (i2 != eventBean.objs.length - 1) {
                        sb.append(",");
                    }
                }
                hashMap.put("params", sb.toString());
            }
            putObjToJson(jSONObject, hashMap);
            jSONArray.put(jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class EventBean {
        public String funName;
        public Object[] objs;
        public String prefix;
        public long timestamp;

        public String toString() {
            return "EventBean{timestamp=" + this.timestamp + ", funName='" + this.funName + '\'' + ", objs=" + Arrays.toString(this.objs) + '}';
        }
    }
}
