package io.ktor.client.engine;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HttpClientJvmEngine.kt */
final class HttpClientJvmEngine$_dispatcher$2 extends Lambda implements Function0<ExecutorCoroutineDispatcher> {
    final /* synthetic */ HttpClientJvmEngine this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpClientJvmEngine$_dispatcher$2(HttpClientJvmEngine httpClientJvmEngine) {
        super(0);
        this.this$0 = httpClientJvmEngine;
    }

    public final ExecutorCoroutineDispatcher invoke() {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(this.this$0.getConfig().getThreadsCount(), HttpClientJvmEngine$_dispatcher$2$$ExternalSyntheticLambda0.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(newFixedThreadPool, "newFixedThreadPool(confi…e\n            }\n        }");
        return ExecutorsKt.from(newFixedThreadPool);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final Thread m4invoke$lambda1(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }
}
