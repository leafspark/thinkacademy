package io.ktor.client.engine;

import io.ktor.client.plugins.HttpTimeout;
import io.ktor.util.AttributeKey;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"*\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\t0\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"DEFAULT_CAPABILITIES", "", "Lio/ktor/client/plugins/HttpTimeout$Plugin;", "getDEFAULT_CAPABILITIES", "()Ljava/util/Set;", "ENGINE_CAPABILITIES_KEY", "Lio/ktor/util/AttributeKey;", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "", "getENGINE_CAPABILITIES_KEY", "()Lio/ktor/util/AttributeKey;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpClientEngineCapability.kt */
public final class HttpClientEngineCapabilityKt {
    private static final Set<HttpTimeout.Plugin> DEFAULT_CAPABILITIES = SetsKt.setOf(HttpTimeout.Plugin);
    private static final AttributeKey<Map<HttpClientEngineCapability<?>, Object>> ENGINE_CAPABILITIES_KEY = new AttributeKey<>("EngineCapabilities");

    public static final AttributeKey<Map<HttpClientEngineCapability<?>, Object>> getENGINE_CAPABILITIES_KEY() {
        return ENGINE_CAPABILITIES_KEY;
    }

    public static final Set<HttpTimeout.Plugin> getDEFAULT_CAPABILITIES() {
        return DEFAULT_CAPABILITIES;
    }
}
