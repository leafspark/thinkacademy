package com.tal.app.thinkacademy.common.network.interceptor;

import com.tal.app.thinkacademy.common.Tag;
import com.tal.app.thinkacademy.common.imconfig.HostUrlsInfo;
import com.tal.app.thinkacademy.common.imconfig.HwNetProbe;
import com.tal.app.thinkacademy.common.imconfig.ImConfig;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.io.IOException;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0015\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u0016J\u0015\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/common/network/interceptor/RetryInterceptor;", "Lokhttp3/Interceptor;", "()V", "oneHostIndex", "", "overseaHostIndex", "changeOneHostIndex", "", "request", "Lokhttp3/Request;", "changeOverseaHostIndex", "checkOneHost", "host", "", "scheme", "checkOverseaHost", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "oneHosts", "", "()[Ljava/lang/String;", "overseaHosts", "reBuildOneRequest", "index", "reBuildOverSeaRequest", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RetryInterceptor.kt */
public final class RetryInterceptor implements Interceptor {
    /* access modifiers changed from: private */
    public int oneHostIndex;
    /* access modifiers changed from: private */
    public int overseaHostIndex;

    public RetryInterceptor() {
        HwNetProbe.Companion.get().netProbeFinishCall(new Function1<String, Unit>(this) {
            final /* synthetic */ RetryInterceptor this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "it");
                if (Intrinsics.areEqual(str, "one")) {
                    this.this$0.oneHostIndex = 0;
                } else {
                    this.this$0.overseaHostIndex = 0;
                }
            }
        });
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        String host = request.url().host();
        String stringPlus = Intrinsics.stringPlus(request.url().scheme(), "://");
        int checkOneHost = checkOneHost(host, stringPlus);
        if (checkOneHost != -1) {
            int i = this.oneHostIndex;
            Request reBuildOneRequest = i != checkOneHost ? reBuildOneRequest(i, request) : request;
            try {
                return chain.proceed(reBuildOneRequest);
            } catch (IOException e) {
                if (e instanceof SocketTimeoutException) {
                    changeOneHostIndex(reBuildOneRequest);
                }
            }
        }
        int checkOverseaHost = checkOverseaHost(host, stringPlus);
        if (checkOverseaHost != -1) {
            int i2 = this.overseaHostIndex;
            Request reBuildOverSeaRequest = i2 != checkOverseaHost ? reBuildOverSeaRequest(i2, request) : request;
            try {
                return chain.proceed(reBuildOverSeaRequest);
            } catch (IOException e2) {
                if (e2 instanceof SocketTimeoutException) {
                    changeOverseaHostIndex(reBuildOverSeaRequest);
                }
            }
        }
        return chain.proceed(request);
    }

    private final synchronized String[] oneHosts() {
        String[] oneHostArray;
        RetryInterceptor retryInterceptor = this;
        oneHostArray = HwNetProbe.Companion.get().oneHostArray();
        if (!(!(oneHostArray.length == 0))) {
            HostUrlsInfo hostUrls = ImConfig.INSTANCE.getHostUrls();
            oneHostArray = hostUrls == null ? null : hostUrls.getOneHost();
        }
        return oneHostArray;
    }

    private final synchronized String[] overseaHosts() {
        String[] overseaHostArray;
        RetryInterceptor retryInterceptor = this;
        overseaHostArray = HwNetProbe.Companion.get().overseaHostArray();
        if (!(!(overseaHostArray.length == 0))) {
            HostUrlsInfo hostUrls = ImConfig.INSTANCE.getHostUrls();
            overseaHostArray = hostUrls == null ? null : hostUrls.getOverseaApiHost();
        }
        return overseaHostArray;
    }

    private final void changeOneHostIndex(Request request) {
        String stringPlus = Intrinsics.stringPlus(request.url().scheme(), "://");
        String host = request.url().host();
        String[] oneHosts = oneHosts();
        if (oneHosts != null) {
            int length = oneHosts.length;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = i3 + 1;
                if (Intrinsics.areEqual(host, StringsKt.replace$default(oneHosts[i2], stringPlus, "", false, 4, (Object) null))) {
                    if (i3 != oneHosts.length - 1) {
                        i = i4;
                    }
                    this.oneHostIndex = i;
                    return;
                }
                i2++;
                i3 = i4;
            }
        }
    }

    private final void changeOverseaHostIndex(Request request) {
        String stringPlus = Intrinsics.stringPlus(request.url().scheme(), "://");
        String host = request.url().host();
        String[] overseaHosts = overseaHosts();
        if (overseaHosts != null) {
            int length = overseaHosts.length;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = i3 + 1;
                if (Intrinsics.areEqual(host, StringsKt.replace$default(overseaHosts[i2], stringPlus, "", false, 4, (Object) null))) {
                    if (i3 != overseaHosts.length - 1) {
                        i = i4;
                    }
                    this.overseaHostIndex = i;
                    return;
                }
                i2++;
                i3 = i4;
            }
        }
    }

    private final Request reBuildOneRequest(int i, Request request) {
        String[] oneHosts = oneHosts();
        if (oneHosts == null || i < 0 || i >= oneHosts.length) {
            return request;
        }
        String replace$default = StringsKt.replace$default(oneHosts[i], Intrinsics.stringPlus(request.url().scheme(), "://"), "", false, 4, (Object) null);
        HttpUrl build = request.url().newBuilder().scheme(request.url().scheme()).host(replace$default).port(request.url().port()).build();
        Request build2 = request.newBuilder().url(build).build();
        XesLog.i(Tag.NET_PROBE, "重建请求，替换one host，old:" + request.url().host() + ", new:" + replace$default + ", newUrl:" + build);
        return build2;
    }

    private final Request reBuildOverSeaRequest(int i, Request request) {
        String[] overseaHosts = overseaHosts();
        if (overseaHosts == null || i < 0 || i >= overseaHosts.length) {
            return request;
        }
        String replace$default = StringsKt.replace$default(overseaHosts[i], Intrinsics.stringPlus(request.url().scheme(), "://"), "", false, 4, (Object) null);
        HttpUrl build = request.url().newBuilder().scheme(request.url().scheme()).host(replace$default).port(request.url().port()).build();
        Request build2 = request.newBuilder().url(build).build();
        XesLog.i(Tag.NET_PROBE, "重建请求，替换oversea host，old:" + request.url().host() + ", new:" + replace$default + ", newUrl:" + build);
        return build2;
    }

    private final int checkOneHost(String str, String str2) {
        String[] oneHosts = oneHosts();
        if (oneHosts == null) {
            return -1;
        }
        int length = oneHosts.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            if (Intrinsics.areEqual(str, StringsKt.replace$default(oneHosts[i], str2, "", false, 4, (Object) null))) {
                return i2;
            }
            i++;
            i2 = i3;
        }
        return -1;
    }

    private final int checkOverseaHost(String str, String str2) {
        String[] overseaHosts = overseaHosts();
        if (overseaHosts == null) {
            return -1;
        }
        int length = overseaHosts.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            if (Intrinsics.areEqual(str, StringsKt.replace$default(overseaHosts[i], str2, "", false, 4, (Object) null))) {
                return i2;
            }
            i++;
            i2 = i3;
        }
        return -1;
    }
}
