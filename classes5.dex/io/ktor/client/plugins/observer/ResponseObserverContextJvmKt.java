package io.ktor.client.plugins.observer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.slf4j.MDCContext;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u0003"}, d2 = {"getResponseObserverContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ResponseObserverContextJvm.kt */
public final class ResponseObserverContextJvmKt {
    public static final Object getResponseObserverContext(Continuation<? super CoroutineContext> continuation) {
        EmptyCoroutineContext emptyCoroutineContext = (MDCContext) continuation.getContext().get(MDCContext.Key);
        if (emptyCoroutineContext == null) {
            emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return (CoroutineContext) emptyCoroutineContext;
    }
}
