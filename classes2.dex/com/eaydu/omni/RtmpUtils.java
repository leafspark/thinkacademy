package com.eaydu.omni;

import com.eaydu.omni.net.okhttp3.Call;
import com.eaydu.omni.net.okhttp3.Callback;
import com.eaydu.omni.net.okhttp3.OkHttpClient;
import com.eaydu.omni.net.okhttp3.Request;
import com.eaydu.omni.net.okhttp3.Response;
import com.eaydu.omni.utils.HttpUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RtmpUtils {
    private static String RequestBackupIP = "http://39.107.209.36/pushlocate?ver=1&appid=%s&lid=%s";
    private static String RequestRtmpURLFormat = "http://gslb.video.xescdn.com/pushlocate?ver=1&appid=%s&lid=%s";
    private static RtmpUtils instance;
    private OkHttpClient mOkHttpClient = null;

    public interface RtmpRequestCallback {
        void onFailure(int i, String str);

        void onSuccess(RtmpEntity rtmpEntity);
    }

    private RtmpUtils() {
        initHttpClient();
    }

    private static RtmpUtils getInstance() {
        if (instance == null) {
            instance = new RtmpUtils();
        }
        return instance;
    }

    private void initHttpClient() {
        if (this.mOkHttpClient == null) {
            this.mOkHttpClient = HttpUtils.getHttpClient();
        }
    }

    public void getRtmpUrlBackup(String str, String str2, RtmpRequestCallback rtmpRequestCallback) {
        requestRtmpUrl(RequestBackupIP, str, str2, rtmpRequestCallback);
    }

    public void getRtmpUrl(String str, String str2, RtmpRequestCallback rtmpRequestCallback) {
        requestRtmpUrl(RequestRtmpURLFormat, str, str2, rtmpRequestCallback);
    }

    private void requestRtmpUrl(String str, String str2, String str3, final RtmpRequestCallback rtmpRequestCallback) {
        this.mOkHttpClient.newCall(new Request.Builder().url(String.format(str, new Object[]{str2, str3})).build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                RtmpRequestCallback rtmpRequestCallback = rtmpRequestCallback;
                if (rtmpRequestCallback != null) {
                    rtmpRequestCallback.onFailure(-1, iOException.toString());
                }
            }

            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                try {
                    RtmpEntity rtmpEntity = new RtmpEntity();
                    JSONObject jSONObject = new JSONObject(string);
                    rtmpEntity.state = jSONObject.getInt("state");
                    rtmpEntity.message = jSONObject.getString("message");
                    if (rtmpEntity.state == 0) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(FirebaseAnalytics.Param.CONTENT);
                        rtmpEntity.lid = jSONObject2.getString("lid");
                        rtmpEntity.maxAge = jSONObject2.getInt("max-age");
                        JSONArray jSONArray = jSONObject2.getJSONArray("addrs");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                            RtmpAddress rtmpAddress = new RtmpAddress();
                            rtmpAddress.addr = jSONObject3.getString("addr");
                            rtmpAddress.direct = jSONObject3.getString("direct");
                            rtmpAddress.nid = jSONObject3.getString("nid");
                            rtmpAddress.loc = jSONObject3.getString("loc");
                            rtmpEntity.addresses.add(rtmpAddress);
                        }
                    }
                    if (rtmpRequestCallback != null) {
                        if (rtmpEntity.state != 0) {
                            rtmpRequestCallback.onFailure(rtmpEntity.state, rtmpEntity.message);
                        } else {
                            rtmpRequestCallback.onSuccess(rtmpEntity);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    RtmpRequestCallback rtmpRequestCallback = rtmpRequestCallback;
                    if (rtmpRequestCallback != null) {
                        rtmpRequestCallback.onFailure(-2, e.toString());
                    }
                }
                try {
                    response.close();
                } catch (Exception unused) {
                }
            }
        });
    }

    public class RtmpAddress {
        public String addr;
        public String direct;
        public String loc;
        public String nid;

        public RtmpAddress() {
        }
    }

    public class RtmpEntity {
        public ArrayList<RtmpAddress> addresses = new ArrayList<>();
        public String cip;
        public String lid;
        public int maxAge;
        public String message;
        public int state;

        public RtmpEntity() {
        }
    }
}
