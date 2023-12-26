package com.tal.thinkacademy.networkprobe;

import android.util.Log;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientKt;
import io.ktor.client.engine.okhttp.OkHttp;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006¨\u0006\u000f"}, d2 = {"Lcom/tal/thinkacademy/networkprobe/Platform;", "", "()V", "appDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getUuid", "", "httpClient", "Lio/ktor/client/HttpClient;", "config", "Lcom/tal/thinkacademy/networkprobe/NetProbeConfig;", "log", "", "tag", "msg", "networkprobe_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Platform.kt */
public final class Platform {
    public final String getUuid() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        return uuid;
    }

    public final void log(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(str2, "msg");
        Log.e("NetProbeAndroid", str + '|' + str2);
    }

    public final CoroutineDispatcher appDispatcher() {
        return Dispatchers.getMain();
    }

    public final HttpClient httpClient(NetProbeConfig netProbeConfig) {
        Intrinsics.checkNotNullParameter(netProbeConfig, "config");
        return HttpClientKt.HttpClient(OkHttp.INSTANCE, new Platform$httpClient$1(netProbeConfig));
    }
}
