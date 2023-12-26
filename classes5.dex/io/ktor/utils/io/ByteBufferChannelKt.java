package io.ktor.utils.io;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"BYTE_BUFFER_CAPACITY", "", "DEFAULT_CLOSE_MESSAGE", "", "rethrowClosed", "", "cause", "", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteBufferChannel.kt */
public final class ByteBufferChannelKt {
    private static final int BYTE_BUFFER_CAPACITY = 4088;
    public static final String DEFAULT_CLOSE_MESSAGE = "Byte channel was closed";

    /* access modifiers changed from: private */
    public static final Void rethrowClosed(Throwable th) {
        Throwable tryCopyException = ExceptionUtilsJvmKt.tryCopyException(th, th);
        if (tryCopyException != null) {
            th = tryCopyException;
        }
        throw th;
    }
}
