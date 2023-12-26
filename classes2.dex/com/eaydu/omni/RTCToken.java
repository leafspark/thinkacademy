package com.eaydu.omni;

import android.text.TextUtils;
import android.util.Base64;
import com.bumptech.glide.load.Key;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class RTCToken {
    private String app_key;
    private String iceTransportPolicy;
    private String room;
    private String token;
    private String user;
    private String wsUrl;

    public String getUser() {
        return this.user;
    }

    public void setUser(String str) {
        this.user = str;
    }

    public String getRoom() {
        return this.room;
    }

    public void setRoom(String str) {
        this.room = str;
    }

    public String getWsUrl() {
        return this.wsUrl;
    }

    public void setWsUrl(String str) {
        this.wsUrl = str;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getAppKey() {
        return this.app_key;
    }

    public void setAppKey(String str) {
        this.app_key = str;
    }

    public String getIceTransportPolicy() {
        return this.iceTransportPolicy;
    }

    public static RTCToken parseToken(String str) {
        String[] split = str.split("[.]");
        if (split.length != 3) {
            return null;
        }
        try {
            String str2 = new String(Base64.decode(split[1], 8), Key.STRING_CHARSET_NAME);
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            RTCToken rTCToken = new RTCToken();
            try {
                JSONObject jSONObject = new JSONObject(str2);
                rTCToken.setRoom(jSONObject.optString("room"));
                rTCToken.setWsUrl(jSONObject.optString("wsUrl"));
                rTCToken.setUser(jSONObject.optString("user"));
                rTCToken.setAppKey(jSONObject.optString("appkey"));
                rTCToken.setToken(str);
                return rTCToken;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
