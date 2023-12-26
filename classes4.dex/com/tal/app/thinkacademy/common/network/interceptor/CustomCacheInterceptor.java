package com.tal.app.thinkacademy.common.network.interceptor;

import com.tal.app.thinkacademy.lib.entity.AppNetWorkConfigRemoteInfo;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.logger.util.MD5Utils;
import com.tal.app.thinkacademy.lib.network.logging.CustomHttpLoggingInterceptor;
import com.tal.app.thinkacademy.lib.restful.HiResponse;
import com.tal.app.thinkacademy.lib.util.CacheDiskUtils;
import com.tal.app.thinkacademy.lib.util.GsonUtils;
import com.tal.app.thinkacademy.lib.util.Utils;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/tal/app/thinkacademy/common/network/interceptor/CustomCacheInterceptor;", "Lokhttp3/Interceptor;", "()V", "cacheFile", "Ljava/io/File;", "kotlin.jvm.PlatformType", "cacheUtils", "Lcom/tal/app/thinkacademy/lib/util/CacheDiskUtils;", "generateKey", "", "request", "Lokhttp3/Request;", "path", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomCacheInterceptor.kt */
public final class CustomCacheInterceptor implements Interceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String cacheHeaderName = "tal_use_cache";
    private static final String[] cacheUrls = {"/classroom-hub/playback/student/initEntry", "/classroom-hub/classroom/student/initModule"};
    private final File cacheFile;
    private final CacheDiskUtils cacheUtils;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/tal/app/thinkacademy/common/network/interceptor/CustomCacheInterceptor$Companion;", "", "()V", "cacheHeaderName", "", "cacheUrls", "", "[Ljava/lang/String;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CustomCacheInterceptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public CustomCacheInterceptor() {
        File externalCacheDir = Utils.getApp().getExternalCacheDir();
        externalCacheDir = externalCacheDir == null ? Utils.getApp().getCacheDir() : externalCacheDir;
        this.cacheFile = externalCacheDir;
        this.cacheUtils = CacheDiskUtils.getInstance(new File(externalCacheDir, "net_cache"), 10485760, 100);
    }

    public Response intercept(Interceptor.Chain chain) {
        String str;
        ResponseBody body;
        byte[] bytes;
        byte[] bytes2;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        String httpUrl = request.url().toString();
        String[] strArr = cacheUrls;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str = "";
                break;
            }
            String str2 = strArr[i];
            i++;
            if (StringsKt.contains$default(httpUrl, str2, false, 2, (Object) null)) {
                str = generateKey(request, str2);
                XesLog.it("接口缓存", "缓存接口 path:" + str2 + " md5:" + str);
                break;
            }
        }
        boolean areEqual = Intrinsics.areEqual(request.header(cacheHeaderName), "true");
        CharSequence charSequence = str;
        if (!(charSequence.length() > 0) || !areEqual || (bytes2 = this.cacheUtils.getBytes(str)) == null) {
            Response proceed = chain.proceed(request);
            if (!(charSequence.length() > 0) || proceed.code() != 200 || (body = proceed.body()) == null || (bytes = body.bytes()) == null) {
                return proceed;
            }
            try {
                HiResponse hiResponse = (HiResponse) GsonUtils.fromJson(new String(bytes, Charsets.UTF_8), HiResponse.class);
                if (hiResponse.successful() && hiResponse.getCode() == 0) {
                    XesLog.it("接口缓存", "写缓存 url:" + httpUrl + ", " + new String(bytes, Charsets.UTF_8));
                    this.cacheUtils.put(str, bytes);
                }
            } catch (Exception e) {
                XesLog.et("接口缓存", "缓存失败 url:" + httpUrl + ", " + new String(bytes, Charsets.UTF_8) + ' ' + e.getMessage());
            }
            return proceed.newBuilder().body(ResponseBody.Companion.create$default(ResponseBody.Companion, bytes, (MediaType) null, 1, (Object) null)).build();
        }
        XesLog.it("接口缓存", "读缓存 url:" + httpUrl + ", " + new String(bytes2, Charsets.UTF_8));
        return new Response.Builder().request(chain.request()).protocol(Protocol.HTTP_1_1).code(AppNetWorkConfigRemoteInfo.MAX_TIME_OUT).message("cache data").body(ResponseBody.Companion.create$default(ResponseBody.Companion, bytes2, (MediaType) null, 1, (Object) null)).sentRequestAtMillis(-1).receivedResponseAtMillis(System.currentTimeMillis()).build();
    }

    private final String generateKey(Request request, String str) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add(Intrinsics.stringPlus("#method=", request.method()));
        Headers headers = request.headers();
        arrayList.add(Intrinsics.stringPlus("#schoolCode=", headers.get("schoolCode")));
        arrayList.add(Intrinsics.stringPlus("#timezone=", headers.get("timezone")));
        arrayList.add(Intrinsics.stringPlus("#appVersion=", headers.get("appVersion")));
        arrayList.add(Intrinsics.stringPlus("#Authorization=", headers.get("Authorization")));
        try {
            RequestBody body = request.body();
            if (body != null) {
                BufferedSink buffer = new Buffer();
                body.writeTo(buffer);
                Charset forName = Charset.forName("UTF-8");
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    Charset charset = contentType.charset(forName);
                    if (charset != null) {
                        forName = charset;
                    }
                }
                if (CustomHttpLoggingInterceptor.isPlaintext(buffer)) {
                    Intrinsics.checkNotNullExpressionValue(forName, "charset");
                    String readString = buffer.readString(forName);
                    if (StringsKt.startsWith$default(readString, "{", false, 2, (Object) null)) {
                        JSONObject jSONObject = new JSONObject(readString);
                        Iterator<String> keys = jSONObject.keys();
                        Intrinsics.checkNotNullExpressionValue(keys, "map.keys()");
                        while (keys.hasNext()) {
                            String next = keys.next();
                            arrayList.add(next + '=' + jSONObject.get(next));
                        }
                    } else if (StringsKt.startsWith$default(readString, "[", false, 2, (Object) null)) {
                        JSONArray jSONArray = new JSONArray(readString);
                        int length = jSONArray.length();
                        int i = 0;
                        while (i < length) {
                            int i2 = i + 1;
                            String optString = jSONArray.optString(i);
                            Intrinsics.checkNotNullExpressionValue(optString, "opt");
                            if (!(optString.length() > 0)) {
                                optString = null;
                            }
                            if (optString != null) {
                                arrayList.add('_' + optString + '=' + optString);
                            }
                            i = i2;
                        }
                    } else {
                        arrayList.add(Intrinsics.stringPlus("#*=", readString));
                    }
                }
            }
        } catch (Exception e) {
            XesLog.et("接口缓存", Intrinsics.stringPlus("缓存key，body参数拼接失败 ", e.getMessage()));
        }
        CollectionsKt.sort(arrayList);
        String stringPlus = Intrinsics.stringPlus(str, "?");
        for (String str2 : arrayList) {
            if (!StringsKt.endsWith$default(stringPlus, "?", false, 2, (Object) null)) {
                str2 = Intrinsics.stringPlus("&", str2);
            }
            stringPlus = Intrinsics.stringPlus(stringPlus, str2);
        }
        XesLog.it("接口缓存", Intrinsics.stringPlus("缓存key明文 ", stringPlus));
        String md5 = MD5Utils.md5(stringPlus);
        Intrinsics.checkNotNullExpressionValue(md5, "md5(paramStr)");
        return md5;
    }
}
