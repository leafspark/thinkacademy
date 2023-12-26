package io.ktor.utils.io.jvm.javaio;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lio/ktor/utils/io/jvm/javaio/DefaultParking;", "Lio/ktor/utils/io/jvm/javaio/Parking;", "Ljava/lang/Thread;", "()V", "park", "", "timeNanos", "", "token", "unpark", "ktor-io"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Pollers.kt */
final class DefaultParking implements Parking<Thread> {
    public static final DefaultParking INSTANCE = new DefaultParking();

    private DefaultParking() {
    }

    public Thread token() {
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "currentThread()");
        return currentThread;
    }

    public void park(long j) {
        if (j >= 0) {
            LockSupport.parkNanos(j);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public void unpark(Thread thread) {
        Intrinsics.checkNotNullParameter(thread, "token");
        LockSupport.unpark(thread);
    }
}
