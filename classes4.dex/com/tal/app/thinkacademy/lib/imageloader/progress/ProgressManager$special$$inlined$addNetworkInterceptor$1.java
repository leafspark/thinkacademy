package com.tal.app.thinkacademy.lib.imageloader.progress;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "intercept", "okhttp3/OkHttpClient$Builder$addNetworkInterceptor$2"}, k = 3, mv = {1, 6, 0})
/* renamed from: com.tal.app.thinkacademy.lib.imageloader.progress.ProgressManager$special$$inlined$-addNetworkInterceptor$1  reason: invalid class name */
/* compiled from: OkHttpClient.kt */
public final class ProgressManager$special$$inlined$addNetworkInterceptor$1 implements Interceptor {
    public final Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        Response.Builder newBuilder = proceed.newBuilder();
        ResponseBody body = proceed.body();
        if (body != null) {
            newBuilder.body(new ProgressResponseBody(request.url().toString(), ProgressManager.LISTENER, body));
        }
        return newBuilder.build();
    }
}
