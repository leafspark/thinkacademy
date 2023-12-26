package com.bonree.sdk.v;

import com.bonree.sdk.agent.engine.network.socket.external.h;
import com.bonree.sdk.be.g;
import com.bonree.sdk.bs.z;
import java.lang.reflect.Constructor;
import java.net.Socket;
import java.net.SocketImpl;
import java.net.SocketImplFactory;

public final class c implements SocketImplFactory {
    private Class<? extends SocketImpl> a;
    private SocketImplFactory b;

    public c(Class<? extends SocketImpl> cls) {
        this.a = cls;
    }

    private c(SocketImplFactory socketImplFactory) {
        this.b = socketImplFactory;
    }

    public final SocketImpl createSocketImpl() {
        SocketImplFactory socketImplFactory = this.b;
        h createSocketImpl = socketImplFactory != null ? socketImplFactory.createSocketImpl() : null;
        if (createSocketImpl == null) {
            try {
                createSocketImpl = (SocketImpl) z.a(z.a((Class<?>) Socket.class, (Class<?>) SocketImpl.class), b());
            } catch (Throwable unused) {
            }
        }
        if (createSocketImpl != null) {
            if (a()) {
                return createSocketImpl;
            }
            createSocketImpl = new h(createSocketImpl);
        }
        return createSocketImpl;
    }

    private static boolean a() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace == null || stackTrace.length <= 0) {
                return false;
            }
            for (int i = 0; i < stackTrace.length; i++) {
                if (stackTrace[i] != null && stackTrace[i].toString().contains("java.net.ServerSocket")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            g.a("serverSocketLoad:" + th, new Object[0]);
            return false;
        }
    }

    private static Socket b() {
        try {
            Constructor<Socket> declaredConstructor = Socket.class.getDeclaredConstructor(new Class[]{SocketImpl.class});
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(new Object[]{c()});
        } catch (Throwable th) {
            g.a("getLocalSocket:" + th, new Object[0]);
            return null;
        }
    }

    private static SocketImpl c() {
        try {
            Constructor<?> declaredConstructor = Class.forName("java.net.SocksSocketImpl").getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            return (SocketImpl) declaredConstructor.newInstance(new Object[0]);
        } catch (Throwable th) {
            g.a("getLocalSocketImpl:" + th, new Object[0]);
            return null;
        }
    }
}
