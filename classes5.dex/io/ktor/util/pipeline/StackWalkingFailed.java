package io.ktor.util.pipeline;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/util/pipeline/StackWalkingFailed;", "", "()V", "failedToCaptureStackFrame", "", "ktor-utils"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StackWalkingFailed.kt */
public final class StackWalkingFailed {
    public static final StackWalkingFailed INSTANCE = new StackWalkingFailed();

    private StackWalkingFailed() {
    }

    public final void failedToCaptureStackFrame() {
        throw new IllegalStateException("Failed to capture stack frame. This is usually happens when a coroutine is running so the frame stack is changing quickly and the coroutine debug agent is unable to capture it concurrently. You may retry running your test to see this particular trace.".toString());
    }
}
