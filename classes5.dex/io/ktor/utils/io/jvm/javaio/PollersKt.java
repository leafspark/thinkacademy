package io.ktor.utils.io.jvm.javaio;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\b\u0010\u0007\u001a\u00020\bH\u0001\u001a\b\u0010\t\u001a\u00020\nH\u0001\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018AX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"parkingImpl", "Lio/ktor/utils/io/jvm/javaio/Parking;", "Ljava/lang/Thread;", "getParkingImpl", "()Lio/ktor/utils/io/jvm/javaio/Parking;", "parkingImplLocal", "Ljava/lang/ThreadLocal;", "isParkingAllowed", "", "prohibitParking", "", "ktor-io"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Pollers.kt */
public final class PollersKt {
    private static final ThreadLocal<Parking<Thread>> parkingImplLocal = new ThreadLocal<>();

    public static final Parking<Thread> getParkingImpl() {
        Parking<Thread> parking = parkingImplLocal.get();
        return parking == null ? DefaultParking.INSTANCE : parking;
    }

    public static final void prohibitParking() {
        parkingImplLocal.set(ProhibitParking.INSTANCE);
    }

    public static final boolean isParkingAllowed() {
        return getParkingImpl() != ProhibitParking.INSTANCE;
    }
}
