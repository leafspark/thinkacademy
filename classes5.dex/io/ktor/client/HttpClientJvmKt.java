package io.ktor.client;

import io.ktor.client.engine.HttpClientEngineFactory;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0005\u001a\u00020\u00062\u001d\b\u0002\u0010\u0007\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b\"\u0012\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"FACTORY", "Lio/ktor/client/engine/HttpClientEngineFactory;", "engines", "", "Lio/ktor/client/HttpClientEngineContainer;", "HttpClient", "Lio/ktor/client/HttpClient;", "block", "Lkotlin/Function1;", "Lio/ktor/client/HttpClientConfig;", "", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpClientJvm.kt */
public final class HttpClientJvmKt {
    private static final HttpClientEngineFactory<?> FACTORY;
    private static final List<HttpClientEngineContainer> engines;

    public static final HttpClient HttpClient(Function1<? super HttpClientConfig<?>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        return HttpClientKt.HttpClient(FACTORY, function1);
    }

    public static /* synthetic */ HttpClient HttpClient$default(Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = (Function1) HttpClientJvmKt$HttpClient$1.INSTANCE;
        }
        return HttpClient(function1);
    }

    static {
        HttpClientEngineFactory<?> factory;
        Class<HttpClientEngineContainer> cls = HttpClientEngineContainer.class;
        ServiceLoader<S> load = ServiceLoader.load(cls, cls.getClassLoader());
        Intrinsics.checkNotNullExpressionValue(load, "load(it, it.classLoader)");
        List<HttpClientEngineContainer> list = CollectionsKt.toList(load);
        engines = list;
        HttpClientEngineContainer httpClientEngineContainer = (HttpClientEngineContainer) CollectionsKt.firstOrNull(list);
        if (httpClientEngineContainer == null || (factory = httpClientEngineContainer.getFactory()) == null) {
            throw new IllegalStateException("Failed to find HTTP client engine implementation in the classpath: consider adding client engine dependency. See https://ktor.io/docs/http-client-engines.html".toString());
        }
        FACTORY = factory;
    }
}
