package io.ktor.util.pipeline;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¨\u0006\u0005"}, d2 = {"recoverStackTraceBridge", "", "exception", "continuation", "Lkotlin/coroutines/Continuation;", "ktor-utils"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: StackTraceRecover.kt */
public final class StackTraceRecoverKt {
    public static final Throwable recoverStackTraceBridge(Throwable th, Continuation<?> continuation) {
        Throwable th2;
        Intrinsics.checkNotNullParameter(th, "exception");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        try {
            if (DebugKt.getRECOVER_STACK_TRACES()) {
                if (continuation instanceof CoroutineStackFrame) {
                    th2 = StackTraceRecoveryKt.access$recoverFromStackFrame(th, (CoroutineStackFrame) continuation);
                    return StackTraceRecoverJvmKt.withCause(th2, th.getCause());
                }
            }
            th2 = th;
            return StackTraceRecoverJvmKt.withCause(th2, th.getCause());
        } catch (Throwable unused) {
            return th;
        }
    }
}
