package com.sensorsdata.analytics.android.sdk.network;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SALog;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class HttpCallback<T> {
    static Handler sMainHandler = new Handler(Looper.getMainLooper());

    public static abstract class StringCallback extends HttpCallback<String> {
        public String onParseResponse(String str) {
            return str;
        }
    }

    public abstract void onAfter();

    public abstract void onFailure(int i, String str);

    public abstract T onParseResponse(String str);

    public abstract void onResponse(T t);

    /* access modifiers changed from: package-private */
    public void onError(final RealResponse realResponse) {
        final String str;
        if (!TextUtils.isEmpty(realResponse.result)) {
            str = realResponse.result;
        } else if (!TextUtils.isEmpty(realResponse.errorMsg)) {
            str = realResponse.errorMsg;
        } else {
            str = realResponse.exception != null ? realResponse.exception.toString() : "unknown error";
        }
        sMainHandler.post(new Runnable() {
            public void run() {
                HttpCallback.this.onFailure(realResponse.code, str);
                HttpCallback.this.onAfter();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void onSuccess(RealResponse realResponse) {
        final Object onParseResponse = onParseResponse(realResponse.result);
        sMainHandler.post(new Runnable() {
            public void run() {
                HttpCallback.this.onResponse(onParseResponse);
                HttpCallback.this.onAfter();
            }
        });
    }

    public static abstract class JsonCallback extends HttpCallback<JSONObject> {
        public void onAfter() {
        }

        public JSONObject onParseResponse(String str) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return new JSONObject(str);
                }
                return null;
            } catch (JSONException e) {
                SALog.printStackTrace(e);
                return null;
            }
        }
    }
}
