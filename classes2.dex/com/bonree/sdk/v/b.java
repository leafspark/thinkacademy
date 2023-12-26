package com.bonree.sdk.v;

import com.bonree.sdk.agent.engine.network.socket.external.e;
import java.net.Socket;
import java.net.SocketImpl;
import java.net.SocketImplFactory;

public final class b implements SocketImplFactory {
    private static boolean a = false;

    public static boolean a() {
        boolean z = a;
        if (z) {
            return z;
        }
        b bVar = new b();
        try {
            bVar.createSocketImpl();
            Socket.setSocketImplFactory(bVar);
            a = true;
            return true;
        } catch (Throwable unused) {
            return a;
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.net.SocketImpl, com.bonree.sdk.agent.engine.network.socket.external.e] */
    public final SocketImpl createSocketImpl() {
        return new e();
    }
}
