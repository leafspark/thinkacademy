package io.ktor.utils.io;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lio/ktor/utils/io/WriterSuspendSession;", "Lio/ktor/utils/io/WriterSession;", "tryAwait", "", "n", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Use writeMemory instead.")
/* compiled from: WriterSession.kt */
public interface WriterSuspendSession extends WriterSession {
    Object tryAwait(int i, Continuation<? super Unit> continuation);
}
