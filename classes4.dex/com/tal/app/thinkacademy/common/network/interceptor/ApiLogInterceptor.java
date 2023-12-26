package com.tal.app.thinkacademy.common.network.interceptor;

import com.google.gson.JsonObject;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/common/network/interceptor/ApiLogInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "isPlaintext", "", "buffer", "Lokio/Buffer;", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ApiLogInterceptor.kt */
public final class ApiLogInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        RequestBody body = request.body();
        long nanoTime = System.nanoTime();
        Response proceed = chain.proceed(request);
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
        ResponseBody body2 = proceed.body();
        if (proceed.isSuccessful()) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("apiPath", request.url().encodedPath());
            jsonObject.addProperty("apiDomain", request.url().host());
            jsonObject.addProperty("apiFailedMsg", proceed.message());
            String query = request.url().query();
            if (body != null) {
                BufferedSink buffer = new Buffer();
                body.writeTo(buffer);
                Charset forName = Charset.forName("UTF-8");
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    forName = contentType.charset(Charset.forName("UTF-8"));
                }
                if (isPlaintext(buffer)) {
                    Intrinsics.checkNotNullExpressionValue(forName, "charset");
                    query = buffer.readString(forName);
                }
            }
            jsonObject.addProperty("apiRequestParam", query);
            String str = null;
            if (body2 != null) {
                long contentLength = body2.contentLength();
                BufferedSource source = body2.source();
                source.request(Long.MAX_VALUE);
                Buffer buffer2 = source.getBuffer();
                Charset forName2 = Charset.forName("UTF-8");
                Intrinsics.checkNotNullExpressionValue(forName2, "forName(\"UTF-8\")");
                if (contentLength != 0) {
                    str = buffer2.clone().readString(forName2);
                }
                jsonObject.addProperty("apiResponseResult", str);
            }
            jsonObject.addProperty("apiRequestTime", millis + "ms");
            XesLog.ut("apiRequestFailed", jsonObject);
        }
        return proceed;
    }

    public final boolean isPlaintext(Buffer buffer) throws EOFException {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, buffer.size() < 64 ? buffer.size() : 64);
            int i = 0;
            while (true) {
                if (i >= 16) {
                    break;
                }
                i++;
                if (buffer2.exhausted()) {
                    break;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
