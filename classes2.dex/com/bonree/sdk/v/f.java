package com.bonree.sdk.v;

import android.os.Build;
import com.bonree.sdk.agent.engine.network.socket.external.BrSSLSocketFactoryBeforeV14;
import com.bonree.sdk.agent.engine.network.socket.external.BrSocketFactory;
import com.bonree.sdk.agent.engine.network.socket.external.g;
import com.bonree.sdk.be.a;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.z;
import java.net.Socket;
import java.net.SocketImpl;

public final class f {
    private static com.bonree.sdk.be.f a = a.a();

    public static boolean a() {
        boolean z;
        try {
            ad.h();
        } catch (Throwable unused) {
        }
        try {
            if (Build.VERSION.SDK_INT > 23) {
                b();
            } else {
                b.a();
            }
            if (Build.VERSION.SDK_INT < 19 || Build.VERSION.SDK_INT >= 27) {
                z = (Build.VERSION.SDK_INT < 14 || Build.VERSION.SDK_INT >= 27) ? false : BrSSLSocketFactoryBeforeV14.a();
            } else {
                z = BrSocketFactory.a();
            }
            com.bonree.sdk.be.f fVar = a;
            fVar.c(Build.VERSION.SDK_INT + " sslsocket:" + z, new Object[0]);
            if (z) {
                z = g.a();
            }
            com.bonree.sdk.be.f fVar2 = a;
            fVar2.c("sslinit : " + z, new Object[0]);
            return z;
        } catch (Throwable th) {
            com.bonree.sdk.be.f fVar3 = a;
            fVar3.d("sslinit throwable : " + th.toString(), new Object[0]);
            return false;
        }
    }

    private static boolean b() {
        Class<? extends SocketImpl> c = c();
        if (!(c == null || c == null)) {
            try {
                Socket.setSocketImplFactory(new c(c));
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static Class<? extends SocketImpl> c() {
        try {
            SocketImpl socketImpl = (SocketImpl) z.a(z.a((Class<?>) Socket.class, (Class<?>) SocketImpl.class), new Socket());
            if (socketImpl == null) {
                return null;
            }
            return socketImpl.getClass();
        } catch (Throwable unused) {
            return null;
        }
    }
}
