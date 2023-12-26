package io.ktor.client.engine;

import io.ktor.client.engine.HttpClientEngineConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003J#\u0010\u0004\u001a\u00020\u00052\u0019\b\u0002\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH&¨\u0006\n"}, d2 = {"Lio/ktor/client/engine/HttpClientEngineFactory;", "T", "Lio/ktor/client/engine/HttpClientEngineConfig;", "", "create", "Lio/ktor/client/engine/HttpClientEngine;", "block", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpClientEngine.kt */
public interface HttpClientEngineFactory<T extends HttpClientEngineConfig> {
    HttpClientEngine create(Function1<? super T, Unit> function1);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HttpClientEngine.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ HttpClientEngine create$default(HttpClientEngineFactory httpClientEngineFactory, Function1 function1, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    function1 = (Function1) HttpClientEngineFactory$create$1.INSTANCE;
                }
                return httpClientEngineFactory.create(function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: create");
        }
    }
}
