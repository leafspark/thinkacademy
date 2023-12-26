package io.ktor.client.plugins;

import io.ktor.client.HttpClientConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0002¨\u0006\u0004"}, d2 = {"BrowserUserAgent", "", "Lio/ktor/client/HttpClientConfig;", "CurlUserAgent", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserAgent.kt */
public final class UserAgentKt {
    public static final void BrowserUserAgent(HttpClientConfig<?> httpClientConfig) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        httpClientConfig.install((HttpClientPlugin<? extends TBuilder, TPlugin>) UserAgent.Plugin, (Function1<? super TBuilder, Unit>) UserAgentKt$BrowserUserAgent$1.INSTANCE);
    }

    public static final void CurlUserAgent(HttpClientConfig<?> httpClientConfig) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        httpClientConfig.install((HttpClientPlugin<? extends TBuilder, TPlugin>) UserAgent.Plugin, (Function1<? super TBuilder, Unit>) UserAgentKt$CurlUserAgent$1.INSTANCE);
    }
}
