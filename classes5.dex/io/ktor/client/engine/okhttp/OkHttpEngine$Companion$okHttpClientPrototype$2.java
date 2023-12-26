package io.ktor.client.engine.okhttp;

import com.bonree.sdk.agent.engine.external.OkHttp3Instrumentation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lokhttp3/OkHttpClient;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkHttpEngine.kt */
final class OkHttpEngine$Companion$okHttpClientPrototype$2 extends Lambda implements Function0<OkHttpClient> {
    public static final OkHttpEngine$Companion$okHttpClientPrototype$2 INSTANCE = new OkHttpEngine$Companion$okHttpClientPrototype$2();

    OkHttpEngine$Companion$okHttpClientPrototype$2() {
        super(0);
    }

    public final OkHttpClient invoke() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        return !(builder instanceof OkHttpClient.Builder) ? builder.build() : OkHttp3Instrumentation.builderInit(builder);
    }
}
