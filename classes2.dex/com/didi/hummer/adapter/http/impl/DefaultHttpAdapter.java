package com.didi.hummer.adapter.http.impl;

import android.text.TextUtils;
import com.amazonaws.services.s3.util.Mimetypes;
import com.bonree.sdk.agent.engine.external.OkHttp3Instrumentation;
import com.bumptech.glide.load.Key;
import com.didi.hummer.adapter.http.HttpCallback;
import com.didi.hummer.adapter.http.HttpResponse;
import com.didi.hummer.adapter.http.IHttpAdapter;
import com.didi.hummer.core.util.HMGsonUtil;
import com.didi.hummer.utils.UIThreadUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class DefaultHttpAdapter implements IHttpAdapter {
    public static final String CONTENT_TYPE = "content-type";
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json;charset=utf-8");
    public static final MediaType MEDIA_TYPE_MULTIPART_FORM = MediaType.parse("multipart/form-data;charset=utf-8");
    public static final MediaType MEDIA_TYPE_NORMAL_FORM = MediaType.parse("application/x-www-form-urlencoded;charset=utf-8");
    public static final MediaType MEDIA_TYPE_STREAM = MediaType.parse(Mimetypes.MIMETYPE_OCTET_STREAM);
    public static final MediaType MEDIA_TYPE_TEXT = MediaType.parse("text/plain;charset=utf-8");
    private OkHttpClient httpClient;

    public String onUrlIntercept(String str) {
        return null;
    }

    public DefaultHttpAdapter() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        SSLSocketFactory allowAllSSL = FakeX509TrustManager.allowAllSSL();
        FakeX509TrustManager fakeX509TrustManager = new FakeX509TrustManager();
        OkHttpClient.Builder sslSocketFactory = !(builder instanceof OkHttpClient.Builder) ? builder.sslSocketFactory(allowAllSSL, fakeX509TrustManager) : OkHttp3Instrumentation.sslSocketFactory(builder, allowAllSSL, fakeX509TrustManager);
        this.httpClient = !(sslSocketFactory instanceof OkHttpClient.Builder) ? sslSocketFactory.build() : OkHttp3Instrumentation.builderInit(sslSocketFactory);
    }

    public <T> void request(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, HttpCallback<T> httpCallback, Type type) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String upperCase = str2.toUpperCase();
            upperCase.hashCode();
            if (upperCase.equals(IHttpAdapter.METHOD_GET)) {
                get(str, i, map, map2, httpCallback, type);
            } else if (upperCase.equals(IHttpAdapter.METHOD_POST)) {
                post(str, i, map, map2, httpCallback, type);
            }
        }
    }

    private <T> void get(String str, int i, Map<String, Object> map, Map<String, Object> map2, final HttpCallback<T> httpCallback, final Type type) {
        String buildUrlWithParams = buildUrlWithParams(str, map2);
        long j = (long) i;
        OkHttpClient.Builder writeTimeout = this.httpClient.newBuilder().connectTimeout(j, TimeUnit.MILLISECONDS).readTimeout(j, TimeUnit.SECONDS).writeTimeout(j, TimeUnit.SECONDS);
        OkHttpClient build = !(writeTimeout instanceof OkHttpClient.Builder) ? writeTimeout.build() : OkHttp3Instrumentation.builderInit(writeTimeout);
        Request.Builder url = new Request.Builder().url(buildUrlWithParams);
        addHeaders(url, map);
        Request build2 = url.build();
        (!(build instanceof OkHttpClient) ? build.newCall(build2) : OkHttp3Instrumentation.newCall(build, build2)).enqueue(new Callback() {
            public void onResponse(Call call, Response response) throws IOException {
                UIThreadUtil.runOnUiThread(new DefaultHttpAdapter$1$$ExternalSyntheticLambda0(httpCallback, DefaultHttpAdapter.this.processResponse(response, type)));
            }

            static /* synthetic */ void lambda$onResponse$0(HttpCallback httpCallback, HttpResponse httpResponse) {
                if (httpCallback != null) {
                    httpCallback.onResult(httpResponse);
                }
            }

            public void onFailure(Call call, IOException iOException) {
                UIThreadUtil.runOnUiThread(new DefaultHttpAdapter$1$$ExternalSyntheticLambda1(this, httpCallback, iOException));
            }

            public /* synthetic */ void lambda$onFailure$1$DefaultHttpAdapter$1(HttpCallback httpCallback, IOException iOException) {
                if (httpCallback != null) {
                    httpCallback.onResult(DefaultHttpAdapter.this.processError(iOException));
                }
            }
        });
    }

    private <T> void post(String str, int i, Map<String, Object> map, Map<String, Object> map2, final HttpCallback<T> httpCallback, final Type type) {
        long j = (long) i;
        OkHttpClient.Builder writeTimeout = this.httpClient.newBuilder().connectTimeout(j, TimeUnit.MILLISECONDS).readTimeout(j, TimeUnit.SECONDS).writeTimeout(j, TimeUnit.SECONDS);
        OkHttpClient build = !(writeTimeout instanceof OkHttpClient.Builder) ? writeTimeout.build() : OkHttp3Instrumentation.builderInit(writeTimeout);
        Request.Builder url = new Request.Builder().url(str);
        addHeaders(url, map);
        Request build2 = url.post(createBody(map, map2)).build();
        (!(build instanceof OkHttpClient) ? build.newCall(build2) : OkHttp3Instrumentation.newCall(build, build2)).enqueue(new Callback() {
            public void onResponse(Call call, Response response) throws IOException {
                UIThreadUtil.runOnUiThread(new DefaultHttpAdapter$2$$ExternalSyntheticLambda0(httpCallback, DefaultHttpAdapter.this.processResponse(response, type)));
            }

            static /* synthetic */ void lambda$onResponse$0(HttpCallback httpCallback, HttpResponse httpResponse) {
                if (httpCallback != null) {
                    httpCallback.onResult(httpResponse);
                }
            }

            public void onFailure(Call call, IOException iOException) {
                UIThreadUtil.runOnUiThread(new DefaultHttpAdapter$2$$ExternalSyntheticLambda1(this, httpCallback, iOException));
            }

            public /* synthetic */ void lambda$onFailure$1$DefaultHttpAdapter$2(HttpCallback httpCallback, IOException iOException) {
                if (httpCallback != null) {
                    httpCallback.onResult(DefaultHttpAdapter.this.processError(iOException));
                }
            }
        });
    }

    private String buildUrlWithParams(String str, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder(str);
        String encodeEachParam = encodeEachParam(map);
        if (!TextUtils.isEmpty(encodeEachParam)) {
            if (str.contains("?")) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            sb.append(encodeEachParam);
        }
        return sb.toString();
    }

    private void addHeaders(Request.Builder builder, Map<String, Object> map) {
        if (map != null) {
            for (String next : map.keySet()) {
                String valueOf = String.valueOf(map.get(next));
                if (!TextUtils.isEmpty(valueOf)) {
                    builder.addHeader(next, valueOf);
                }
            }
        }
    }

    private RequestBody createBody(Map<String, Object> map, Map<String, Object> map2) {
        MediaType mediaTypeFromHeaders = getMediaTypeFromHeaders(map);
        if (String.valueOf(mediaTypeFromHeaders).contains("text/plain")) {
            return createTextRequestBody(mediaTypeFromHeaders, map2);
        }
        if (String.valueOf(mediaTypeFromHeaders).contains("application/x-www-form-urlencoded")) {
            return createFormRequestBody(map2);
        }
        return createJsonRequestBody(mediaTypeFromHeaders, map2);
    }

    private RequestBody createJsonRequestBody(MediaType mediaType, Map<String, Object> map) {
        return RequestBody.create(mediaType, getWholeParamsString(map));
    }

    private RequestBody createTextRequestBody(MediaType mediaType, Map<String, Object> map) {
        return RequestBody.create(mediaType, encodeWholeParamsString(map));
    }

    private RequestBody createFormRequestBody(Map<String, Object> map) {
        FormBody.Builder builder = new FormBody.Builder();
        if (map != null && !map.isEmpty()) {
            for (String next : map.keySet()) {
                builder.add(next, String.valueOf(map.get(next)));
            }
        }
        return builder.build();
    }

    private MediaType getMediaTypeFromHeaders(Map<String, Object> map) {
        if (map == null) {
            return MEDIA_TYPE_JSON;
        }
        String str = null;
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            if (it.hasNext()) {
                String next = it.next();
                if (next != null && next.toLowerCase().equals(CONTENT_TYPE) && map.get(next) != null) {
                    str = String.valueOf(map.get(next));
                    break;
                }
            } else {
                break;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return MEDIA_TYPE_JSON;
        }
        return MediaType.parse(str);
    }

    private String encodeEachParam(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String next : map.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            String valueOf = String.valueOf(map.get(next));
            try {
                next = URLEncoder.encode(next, Key.STRING_CHARSET_NAME);
                valueOf = URLEncoder.encode(valueOf, Key.STRING_CHARSET_NAME);
            } catch (Exception e) {
                e.printStackTrace();
            }
            sb.append(next);
            sb.append("=");
            sb.append(valueOf);
        }
        return sb.toString();
    }

    private String getWholeParamsString(Map<String, Object> map) {
        String json = HMGsonUtil.toJson(map);
        return json == null ? "" : json;
    }

    private String encodeWholeParamsString(Map<String, Object> map) {
        String json = HMGsonUtil.toJson(map);
        if (json == null) {
            json = "";
        }
        try {
            return URLEncoder.encode(json, Key.STRING_CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return json;
        }
    }

    /* access modifiers changed from: private */
    public HttpResponse processResponse(Response response, Type type) throws IOException {
        HttpResponse httpResponse = new HttpResponse();
        Headers headers = response.headers();
        if (headers != null && headers.size() > 0) {
            httpResponse.header = new HashMap();
            for (String str : headers.names()) {
                httpResponse.header.put(str, headers.get(str));
            }
        }
        httpResponse.status = response.code();
        httpResponse.message = response.message();
        httpResponse.data = parseResponseBody(response.body(), type);
        if (!response.isSuccessful()) {
            httpResponse.error = new HttpResponse.Error(httpResponse.status, httpResponse.message);
        }
        return httpResponse;
    }

    private Object parseResponseBody(ResponseBody responseBody, Type type) throws IOException {
        if (responseBody == null) {
            return null;
        }
        String string = responseBody.string();
        return (!HMGsonUtil.isValidJsonString(string) || type == null) ? string : HMGsonUtil.fromJson(string, type);
    }

    /* access modifiers changed from: private */
    public HttpResponse processError(Exception exc) {
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.message = exc.toString();
        httpResponse.error = new HttpResponse.Error(-102, exc.toString());
        return httpResponse;
    }
}
