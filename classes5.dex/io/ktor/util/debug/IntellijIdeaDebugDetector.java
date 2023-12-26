package io.ktor.util.debug;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\u0005¨\u0006\b"}, d2 = {"Lio/ktor/util/debug/IntellijIdeaDebugDetector;", "", "()V", "isDebuggerConnected", "", "()Z", "isDebuggerConnected$delegate", "Lkotlin/Lazy;", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IntellijIdeaDebugDetectorJvm.kt */
public final class IntellijIdeaDebugDetector {
    public static final IntellijIdeaDebugDetector INSTANCE = new IntellijIdeaDebugDetector();
    private static final Lazy isDebuggerConnected$delegate = LazyKt.lazy(IntellijIdeaDebugDetector$isDebuggerConnected$2.INSTANCE);

    private IntellijIdeaDebugDetector() {
    }

    public final boolean isDebuggerConnected() {
        return ((Boolean) isDebuggerConnected$delegate.getValue()).booleanValue();
    }
}
