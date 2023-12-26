package io.ktor.client.engine;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lio/ktor/client/engine/HttpClientEngineConfig;", "invoke", "(Lio/ktor/client/engine/HttpClientEngineConfig;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpClientEngine.kt */
final class HttpClientEngineKt$config$1$create$1 extends Lambda implements Function1<T, Unit> {
    final /* synthetic */ Function1<T, Unit> $block;
    final /* synthetic */ Function1<T, Unit> $nested;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpClientEngineKt$config$1$create$1(Function1<? super T, Unit> function1, Function1<? super T, Unit> function12) {
        super(1);
        this.$nested = function1;
        this.$block = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((HttpClientEngineConfig) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(T t) {
        Intrinsics.checkNotNullParameter(t, "$this$create");
        this.$nested.invoke(t);
        this.$block.invoke(t);
    }
}
