package io.ktor.client.network.sockets;

import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/client/network/sockets/SocketTimeoutException;", "Ljava/net/SocketTimeoutException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getCause", "()Ljava/lang/Throwable;", "ktor-client-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TimeoutExceptions.kt */
public final class SocketTimeoutException extends java.net.SocketTimeoutException {
    private final Throwable cause;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SocketTimeoutException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }

    public Throwable getCause() {
        return this.cause;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SocketTimeoutException(String str, Throwable th) {
        super(str);
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_MESSAGE);
        this.cause = th;
    }
}
