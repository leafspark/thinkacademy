package io.ktor.utils.io;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lio/ktor/utils/io/SuspendableReadSession;", "Lio/ktor/utils/io/ReadSession;", "await", "", "atLeast", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Use read { } instead.")
/* compiled from: ReadSession.kt */
public interface SuspendableReadSession extends ReadSession {
    Object await(int i, Continuation<? super Boolean> continuation);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ReadSession.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object await$default(SuspendableReadSession suspendableReadSession, int i, Continuation continuation, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    i = 1;
                }
                return suspendableReadSession.await(i, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: await");
        }
    }
}
