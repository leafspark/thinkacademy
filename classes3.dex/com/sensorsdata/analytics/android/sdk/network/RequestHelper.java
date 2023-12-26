package com.sensorsdata.analytics.android.sdk.network;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.util.Base64Coder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class RequestHelper {
    /* access modifiers changed from: private */
    public boolean isRedirected;

    /* renamed from: com.sensorsdata.analytics.android.sdk.network.RequestHelper$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$sensorsdata$analytics$android$sdk$network$HttpMethod;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.sensorsdata.analytics.android.sdk.network.HttpMethod[] r0 = com.sensorsdata.analytics.android.sdk.network.HttpMethod.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$sensorsdata$analytics$android$sdk$network$HttpMethod = r0
                com.sensorsdata.analytics.android.sdk.network.HttpMethod r1 = com.sensorsdata.analytics.android.sdk.network.HttpMethod.GET     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$sensorsdata$analytics$android$sdk$network$HttpMethod     // Catch:{ NoSuchFieldError -> 0x001d }
                com.sensorsdata.analytics.android.sdk.network.HttpMethod r1 = com.sensorsdata.analytics.android.sdk.network.HttpMethod.POST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.network.RequestHelper.AnonymousClass3.<clinit>():void");
        }
    }

    private RequestHelper(HttpMethod httpMethod, String str, Map<String, String> map, Map<String, String> map2, int i, HttpCallback httpCallback) {
        this.isRedirected = false;
        int i2 = AnonymousClass3.$SwitchMap$com$sensorsdata$analytics$android$sdk$network$HttpMethod[httpMethod.ordinal()];
        if (i2 == 1) {
            urlHttpGet(str, map, map2, i, httpCallback);
        } else if (i2 == 2) {
            urlHttpPost(str, map, "", map2, i, httpCallback);
        }
    }

    private RequestHelper(String str, String str2, Map<String, String> map, int i, HttpCallback httpCallback) {
        this.isRedirected = false;
        urlHttpPost(str, (Map<String, String>) null, str2, map, i, httpCallback);
    }

    /* access modifiers changed from: private */
    public void urlHttpGet(String str, Map<String, String> map, Map<String, String> map2, int i, HttpCallback httpCallback) {
        final int i2 = i - 1;
        final String str2 = str;
        final Map<String, String> map3 = map;
        final Map<String, String> map4 = map2;
        final HttpCallback httpCallback2 = httpCallback;
        final int i3 = i;
        HttpTaskManager.execute(new Runnable() {
            public void run() {
                RealResponse data = new RealRequest().getData(RequestHelper.this.getUrl(str2, map3), map4);
                if (data.code == 200 || data.code == 204) {
                    HttpCallback httpCallback = httpCallback2;
                    if (httpCallback != null) {
                        httpCallback.onSuccess(data);
                    }
                } else if (RequestHelper.this.isRedirected || !HttpUtils.needRedirects(data.code)) {
                    int i = i2;
                    if (i != 0) {
                        RequestHelper.this.urlHttpGet(str2, map3, map4, i, httpCallback2);
                        return;
                    }
                    HttpCallback httpCallback2 = httpCallback2;
                    if (httpCallback2 != null) {
                        httpCallback2.onError(data);
                    }
                } else {
                    boolean unused = RequestHelper.this.isRedirected = true;
                    RequestHelper.this.urlHttpGet(data.location, map3, map4, i3, httpCallback2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void urlHttpPost(String str, Map<String, String> map, String str2, Map<String, String> map2, int i, HttpCallback httpCallback) {
        final int i2 = i - 1;
        final String str3 = str;
        final Map<String, String> map3 = map;
        final String str4 = str2;
        final Map<String, String> map4 = map2;
        final HttpCallback httpCallback2 = httpCallback;
        final int i3 = i;
        HttpTaskManager.execute(new Runnable() {
            public void run() {
                RealResponse postData = new RealRequest().postData(str3, RequestHelper.this.getPostBody(map3, str4), RequestHelper.this.getPostBodyType(map3, str4), map4);
                if (postData.code == 200 || postData.code == 204) {
                    HttpCallback httpCallback = httpCallback2;
                    if (httpCallback != null) {
                        httpCallback.onSuccess(postData);
                    }
                } else if (RequestHelper.this.isRedirected || !HttpUtils.needRedirects(postData.code)) {
                    int i = i2;
                    if (i != 0) {
                        RequestHelper.this.urlHttpPost(str3, map3, str4, map4, i, httpCallback2);
                        return;
                    }
                    HttpCallback httpCallback2 = httpCallback2;
                    if (httpCallback2 != null) {
                        httpCallback2.onError(postData);
                    }
                } else {
                    boolean unused = RequestHelper.this.isRedirected = true;
                    RequestHelper.this.urlHttpPost(postData.location, map3, str4, map4, i3, httpCallback2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public String getUrl(String str, Map<String, String> map) {
        String str2;
        if (str == null || map == null) {
            return str;
        }
        if (!str.contains("?")) {
            str2 = str + "?";
        } else {
            str2 = str + "&";
        }
        for (String next : map.keySet()) {
            str2 = str2 + next + "=" + map.get(next) + "&";
        }
        return str2.substring(0, str2.length() - 1);
    }

    /* access modifiers changed from: private */
    public String getPostBody(Map<String, String> map, String str) {
        if (map != null) {
            return getPostBodyFormParamsMap(map);
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return null;
    }

    private String getPostBodyFormParamsMap(Map<String, String> map) {
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            try {
                for (Map.Entry next : map.entrySet()) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    sb.append(URLEncoder.encode((String) next.getKey(), Base64Coder.CHARSET_UTF8));
                    sb.append("=");
                    sb.append(URLEncoder.encode((String) next.getValue(), Base64Coder.CHARSET_UTF8));
                }
                return sb.toString();
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public String getPostBodyType(Map<String, String> map, String str) {
        if (map == null && !TextUtils.isEmpty(str)) {
            return "application/json;charset=utf-8";
        }
        return null;
    }

    public static class Builder {
        private HttpCallback callBack;
        private Map<String, String> headerMap;
        private HttpMethod httpMethod;
        private String httpUrl;
        private String jsonData;
        private Map<String, String> paramsMap;
        private int retryCount = 1;

        public Builder(HttpMethod httpMethod2, String str) {
            this.httpMethod = httpMethod2;
            this.httpUrl = str;
        }

        public Builder params(Map<String, String> map) {
            this.paramsMap = map;
            return this;
        }

        public Builder jsonData(String str) {
            this.jsonData = str;
            return this;
        }

        public Builder header(Map<String, String> map) {
            this.headerMap = map;
            return this;
        }

        public Builder callback(HttpCallback httpCallback) {
            this.callBack = httpCallback;
            return this;
        }

        public Builder retryCount(int i) {
            this.retryCount = i;
            return this;
        }

        public void execute() {
            if (this.httpMethod == HttpMethod.POST && this.paramsMap == null) {
                new RequestHelper(this.httpUrl, this.jsonData, (Map) this.headerMap, this.retryCount, this.callBack);
            } else {
                new RequestHelper(this.httpMethod, this.httpUrl, this.paramsMap, this.headerMap, this.retryCount, this.callBack);
            }
        }
    }
}
