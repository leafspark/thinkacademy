package com.wushuangtech.library;

import android.os.Build;
import com.wushuangtech.api.ExternalAudioModule;
import com.wushuangtech.api.ExternalVideoModule;
import com.wushuangtech.bean.ServerConfigBean;
import com.wushuangtech.utils.OmniLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class ServerConfigManager {
    private static final String[] KEY_VIDEO_ARRAY = {ServerConfigConstants.KEY_VIDEO_ENCODER_INFO, ServerConfigConstants.KEY_VIDEO_DECODER_HARDWARE};

    public void updateServerConfig(String str) {
        try {
            JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
            handleAudioModule(jSONObject);
            handleVideoModule(jSONObject);
        } catch (JSONException unused) {
        }
    }

    private void handleAudioModule(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        try {
            if (jSONObject2.has("delay")) {
                int i = jSONObject2.getInt("delay");
                int i2 = jSONObject2.has("agnostic") ? jSONObject2.getInt("agnostic") : 0;
                int i3 = jSONObject2.has("sysaec") ? jSONObject2.getInt("sysaec") : 1;
                int i4 = jSONObject2.has("rvoip") ? jSONObject2.getInt("rvoip") : 1;
                int i5 = jSONObject2.has("ns") ? jSONObject2.getInt("ns") : 1;
                int i6 = jSONObject2.has("agc") ? jSONObject2.getInt("agc") : 1;
                int i7 = jSONObject2.has("low") ? jSONObject2.getInt("low") : 1;
                if ((jSONObject2.has("v") ? jSONObject2.getInt("v") : 1) == 1) {
                    ExternalAudioModule.getInstance().setServerDevParam(i, i2 == 1, i3 == 1, i6 == 1, i5 == 1, i4 == 1, i7 == 1);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void handleVideoModule(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        for (String str : KEY_VIDEO_ARRAY) {
            if (jSONObject.has(str)) {
                str.hashCode();
                if (str.equals(ServerConfigConstants.KEY_VIDEO_ENCODER_INFO)) {
                    parseVideoEncodeType(jSONObject, arrayList);
                } else if (str.equals(ServerConfigConstants.KEY_VIDEO_DECODER_HARDWARE)) {
                    parseVideoDecoderHardware(jSONObject, arrayList);
                }
            }
        }
        ExternalVideoModule.getInstance().updateServerConfig(arrayList);
    }

    private void parseVideoEncodeType(JSONObject jSONObject, List<ServerConfigBean> list) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(ServerConfigConstants.KEY_VIDEO_ENCODER_INFO);
            JSONArray jSONArray = jSONObject2.getJSONArray("ver");
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= jSONArray.length()) {
                    break;
                } else if (jSONArray.getString(i).equals(String.valueOf(Build.VERSION.SDK_INT))) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                int i2 = jSONObject2.getInt("mode");
                ServerConfigBean serverConfigBean = new ServerConfigBean();
                serverConfigBean.mConfigKey = ServerConfigConstants.KEY_CONFIG_VIDEO_ENCODER_INFO_TYPE;
                serverConfigBean.mConfigValue = i2;
                list.add(serverConfigBean);
            }
        } catch (JSONException e) {
            OmniLog.e("Parse server encode info json failed! exception: " + e.getLocalizedMessage() + ", tag: " + OmniLog.LOCAL_PREVIEW + "|" + OmniLog.VIDEO_ENCODER_WATCH);
        }
    }

    private void parseVideoDecoderHardware(JSONObject jSONObject, List<ServerConfigBean> list) {
        try {
            int i = jSONObject.getInt(ServerConfigConstants.KEY_VIDEO_DECODER_HARDWARE);
            ServerConfigBean serverConfigBean = new ServerConfigBean();
            serverConfigBean.mConfigKey = ServerConfigConstants.KEY_VIDEO_DECODER_HARDWARE;
            serverConfigBean.mConfigValue = i;
            list.add(serverConfigBean);
        } catch (JSONException e) {
            OmniLog.e("Parse server encode info json failed! exception: " + e.getLocalizedMessage() + ", tag: " + OmniLog.LOCAL_PREVIEW + "|" + OmniLog.VIDEO_ENCODER_WATCH);
        }
    }
}
