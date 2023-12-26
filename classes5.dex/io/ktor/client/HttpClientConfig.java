package io.ktor.client;

import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import io.ktor.util.PlatformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@KtorDsl
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\f\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\u001f\u0010$\u001a\u00020\n2\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u0012J\u000e\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\tJI\u0010&\u001a\u00020\n\"\b\b\u0001\u0010(*\u00020\u0003\"\b\b\u0002\u0010)*\u00020\u00032\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H)0+2\u0019\b\u0002\u0010,\u001a\u0013\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u0012J'\u0010&\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00072\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u0012J\u0019\u0010.\u001a\u00020\n2\u000e\u0010/\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0000H\u0002R&\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R+\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R/\u0010\u001d\u001a#\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001e\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u00120\u0006X\u0004¢\u0006\u0002\n\u0000R*\u0010\u001f\u001a\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010¨\u00060"}, d2 = {"Lio/ktor/client/HttpClientConfig;", "T", "Lio/ktor/client/engine/HttpClientEngineConfig;", "", "()V", "customInterceptors", "", "", "Lkotlin/Function1;", "Lio/ktor/client/HttpClient;", "", "developmentMode", "", "getDevelopmentMode", "()Z", "setDevelopmentMode", "(Z)V", "engineConfig", "Lkotlin/ExtensionFunctionType;", "getEngineConfig$ktor_client_core", "()Lkotlin/jvm/functions/Function1;", "setEngineConfig$ktor_client_core", "(Lkotlin/jvm/functions/Function1;)V", "expectSuccess", "getExpectSuccess", "setExpectSuccess", "followRedirects", "getFollowRedirects", "setFollowRedirects", "pluginConfigurations", "Lio/ktor/util/AttributeKey;", "plugins", "useDefaultTransformers", "getUseDefaultTransformers", "setUseDefaultTransformers", "clone", "engine", "block", "install", "client", "TBuilder", "TPlugin", "plugin", "Lio/ktor/client/plugins/HttpClientPlugin;", "configure", "key", "plusAssign", "other", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpClientConfig.kt */
public final class HttpClientConfig<T extends HttpClientEngineConfig> {
    private final Map<String, Function1<HttpClient, Unit>> customInterceptors = new LinkedHashMap();
    private boolean developmentMode = PlatformUtils.INSTANCE.getIS_DEVELOPMENT_MODE();
    private Function1<? super T, Unit> engineConfig = ((Function1) HttpClientConfig$engineConfig$1.INSTANCE);
    private boolean expectSuccess;
    private boolean followRedirects = true;
    /* access modifiers changed from: private */
    public final Map<AttributeKey<?>, Function1<Object, Unit>> pluginConfigurations = new LinkedHashMap();
    private final Map<AttributeKey<?>, Function1<HttpClient, Unit>> plugins = new LinkedHashMap();
    private boolean useDefaultTransformers = true;

    public final Function1<T, Unit> getEngineConfig$ktor_client_core() {
        return this.engineConfig;
    }

    public final void setEngineConfig$ktor_client_core(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.engineConfig = function1;
    }

    public final void engine(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        this.engineConfig = (Function1) new HttpClientConfig$engine$1(this.engineConfig, function1);
    }

    public final boolean getFollowRedirects() {
        return this.followRedirects;
    }

    public final void setFollowRedirects(boolean z) {
        this.followRedirects = z;
    }

    public final boolean getUseDefaultTransformers() {
        return this.useDefaultTransformers;
    }

    public final void setUseDefaultTransformers(boolean z) {
        this.useDefaultTransformers = z;
    }

    public final boolean getExpectSuccess() {
        return this.expectSuccess;
    }

    public final void setExpectSuccess(boolean z) {
        this.expectSuccess = z;
    }

    public final boolean getDevelopmentMode() {
        return this.developmentMode;
    }

    public final void setDevelopmentMode(boolean z) {
        this.developmentMode = z;
    }

    public static /* synthetic */ void install$default(HttpClientConfig httpClientConfig, HttpClientPlugin httpClientPlugin, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = (Function1) HttpClientConfig$install$1.INSTANCE;
        }
        httpClientConfig.install(httpClientPlugin, function1);
    }

    public final <TBuilder, TPlugin> void install(HttpClientPlugin<? extends TBuilder, TPlugin> httpClientPlugin, Function1<? super TBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpClientPlugin, "plugin");
        Intrinsics.checkNotNullParameter(function1, "configure");
        this.pluginConfigurations.put(httpClientPlugin.getKey(), new HttpClientConfig$install$2((Function1) this.pluginConfigurations.get(httpClientPlugin.getKey()), function1));
        if (!this.plugins.containsKey(httpClientPlugin.getKey())) {
            this.plugins.put(httpClientPlugin.getKey(), new HttpClientConfig$install$3(httpClientPlugin));
        }
    }

    public final void install(String str, Function1<? super HttpClient, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(function1, "block");
        this.customInterceptors.put(str, function1);
    }

    public final void install(HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "client");
        Iterator it = this.plugins.values().iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(httpClient);
        }
        Iterator it2 = this.customInterceptors.values().iterator();
        while (it2.hasNext()) {
            ((Function1) it2.next()).invoke(httpClient);
        }
    }

    public final HttpClientConfig<T> clone() {
        HttpClientConfig<T> httpClientConfig = new HttpClientConfig<>();
        httpClientConfig.plusAssign(this);
        return httpClientConfig;
    }

    public final void plusAssign(HttpClientConfig<? extends T> httpClientConfig) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "other");
        this.followRedirects = httpClientConfig.followRedirects;
        this.useDefaultTransformers = httpClientConfig.useDefaultTransformers;
        this.expectSuccess = httpClientConfig.expectSuccess;
        this.plugins.putAll(httpClientConfig.plugins);
        this.pluginConfigurations.putAll(httpClientConfig.pluginConfigurations);
        this.customInterceptors.putAll(httpClientConfig.customInterceptors);
    }
}
