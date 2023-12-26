package com.eaydu.omni.fullLog;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.amazonaws.services.s3.util.Mimetypes;
import com.eaydu.omni.EngineConfig;
import com.eaydu.omni.fullLog.UmsAgent_rtc;
import com.eaydu.omni.log.DeviceInfo;
import com.eaydu.omni.logger.Logger;
import com.eaydu.omni.net.okhttp3.Call;
import com.eaydu.omni.net.okhttp3.Callback;
import com.eaydu.omni.net.okhttp3.MediaType;
import com.eaydu.omni.net.okhttp3.OkHttpClient;
import com.eaydu.omni.net.okhttp3.Request;
import com.eaydu.omni.net.okhttp3.RequestBody;
import com.eaydu.omni.net.okhttp3.Response;
import com.eaydu.omni.urls.UrlManager;
import com.eaydu.omni.utils.HttpUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class RtcSystemLogReport {
    private String PREFIX = "rtc";
    private Object Tag;
    Context context;
    boolean isMethod = true;
    OkHttpClient mHttpClient = null;
    public String mRtcLog;
    public long mUid;

    public RtcSystemLogReport(Context context2) {
        this.context = context2;
        String curProcessName = CommonUtil_rtc.getCurProcessName(context2);
        if (!TextUtils.isEmpty(curProcessName)) {
            String[] split = curProcessName.split(":");
            if (split.length >= 2) {
                this.PREFIX += split[1];
            }
        }
        try {
            if (this.mHttpClient == null) {
                this.mHttpClient = HttpUtils.getHttpClient();
            }
        } catch (Exception unused) {
        }
    }

    public void updateClientLogPostUrl() {
        String optString;
        Context context2 = this.context;
        if (context2 != null) {
            try {
                if (CommonUtil_rtc.isNetworkAvailable(context2)) {
                    HashMap hashMap = new HashMap();
                    String str = this.mUid + "";
                    String str2 = this.mRtcLog;
                    if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                        hashMap.put("appVersion", EngineConfig.SDK_VERSION);
                        hashMap.put("appVersionNumber", "what");
                        hashMap.put("systemName", "android");
                        hashMap.put("systemVersion", DeviceInfo.getOsVersion());
                        hashMap.put("deviceModel", DeviceInfo.getDeviceName());
                        hashMap.put("identifierForClient", DeviceInfo.getDeviceId());
                        hashMap.put("appChannel", "channel");
                        hashMap.put(FirebaseAnalytics.Param.LOCATION, "");
                        hashMap.put("subAppVersionNumber", UmsConstants_rtc.TINKER_ID);
                        String str3 = NetworkNewUtil_rtc.get(UrlManager.getInstance().getUrlFullLog(), hashMap);
                        if (str3 != null && (optString = new JSONObject(str3).optString(Constants.ScionAnalytics.MessageType.DATA_MESSAGE)) != null) {
                            String[] split = optString.replace("[", "").replace("]", "").replace("\"", "").replace("\\", "").split(",");
                            if (split.length > 1 && URLUtil.isNetworkUrl(split[1])) {
                                CommonUtil_rtc.saveUmsClientPosUrl(split[1]);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void uploadHistroy() {
        try {
            String stringBuffer = Logger.getMemoryLogData().toString();
            Logger.getMemoryLogData().setLength(0);
            if (stringBuffer.length() > 0 && CommonUtil_rtc.getReportPolicyMode(this.context) == UmsAgent_rtc.SendPolicy.REALTIME && CommonUtil_rtc.isNetworkAvailable(this.context)) {
                HashMap hashMap = new HashMap();
                byte[] compress = SystemLogUtil_rtc.compress(stringBuffer.getBytes());
                String str = this.mUid + "";
                String str2 = this.mRtcLog;
                if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                    hashMap.put("fn", SystemLogUtil_rtc.getFn(str, str2));
                    hashMap.put("tk", SystemLogUtil_rtc.getTk(compress));
                    hashMap.put("Content-Type", Mimetypes.MIMETYPE_OCTET_STREAM);
                    hashMap.put("Content-Length", compress.length + "");
                    Log.e("xyj", "result===========:" + postLiberal(CommonUtil_rtc.getUmsClientPosUrl(), compress, hashMap));
                }
            }
        } catch (Exception e) {
            Log.e("xyj", "JSONObject----------Exception=:" + e.getMessage());
        }
    }

    private boolean postLiberal(String str, byte[] bArr, Map<String, String> map) {
        if (this.mHttpClient == null) {
            return false;
        }
        Request.Builder post = new Request.Builder().url(str).post(RequestBody.create(MediaType.parse(Mimetypes.MIMETYPE_OCTET_STREAM), bArr));
        for (String next : map.keySet()) {
            post.addHeader(next, map.get(next));
        }
        this.mHttpClient.newCall(post.build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
            }

            public void onResponse(Call call, Response response) throws IOException {
                try {
                    response.close();
                } catch (Exception unused) {
                }
            }
        });
        return true;
    }

    private String readFromFile(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
