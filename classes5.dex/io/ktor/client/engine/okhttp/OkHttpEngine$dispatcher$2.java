package io.ktor.client.engine.okhttp;

import io.ktor.client.utils.CoroutineDispatcherUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/CoroutineDispatcher;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OkHttpEngine.kt */
final class OkHttpEngine$dispatcher$2 extends Lambda implements Function0<CoroutineDispatcher> {
    final /* synthetic */ OkHttpEngine this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkHttpEngine$dispatcher$2(OkHttpEngine okHttpEngine) {
        super(0);
        this.this$0 = okHttpEngine;
    }

    public final CoroutineDispatcher invoke() {
        return CoroutineDispatcherUtilsKt.clientDispatcher(Dispatchers.INSTANCE, this.this$0.getConfig().getThreadsCount(), "ktor-okhttp-dispatcher");
    }
}
