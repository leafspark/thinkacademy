package io.ktor.client.engine.okhttp;

import io.ktor.client.plugins.HttpTimeout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import okhttp3.OkHttpClient;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkHttpEngine.kt */
/* synthetic */ class OkHttpEngine$clientCache$1 extends FunctionReferenceImpl implements Function1<HttpTimeout.HttpTimeoutCapabilityConfiguration, OkHttpClient> {
    OkHttpEngine$clientCache$1(Object obj) {
        super(1, obj, OkHttpEngine.class, "createOkHttpClient", "createOkHttpClient(Lio/ktor/client/plugins/HttpTimeout$HttpTimeoutCapabilityConfiguration;)Lokhttp3/OkHttpClient;", 0);
    }

    public final OkHttpClient invoke(HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration) {
        return ((OkHttpEngine) this.receiver).createOkHttpClient(httpTimeoutCapabilityConfiguration);
    }
}
