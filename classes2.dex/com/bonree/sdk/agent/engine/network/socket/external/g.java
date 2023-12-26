package com.bonree.sdk.agent.engine.network.socket.external;

import android.os.Build;
import com.bonree.sdk.be.a;
import com.bonree.sdk.be.f;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.apache.harmony.security.fortress.Services;

public final class g extends Provider.Service {
    private static f a = a.a();
    private static String[] c = {"Default", "SSL", "TLSv1.1", "TLSv1.2", "TLSv1.3", "SSLv3", "TLSv1", "TLS"};
    private Provider.Service b;

    private g(Provider.Service service) {
        super(service.getProvider(), service.getType(), service.getAlgorithm(), service.getClassName(), (List) null, (Map) null);
        this.b = service;
    }

    private static g a(Provider.Service service) {
        g gVar = new g(service);
        try {
            Field[] fields = Provider.Service.class.getFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                fields[i].set(gVar, fields[i].get(service));
            }
            return gVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Provider b() {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            if (instance != null) {
                return instance.getProvider();
            }
            return null;
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static boolean a() {
        Provider b2;
        a.c("launchService", new Object[0]);
        if (!f.a() || (b2 = b()) == null) {
            return false;
        }
        f fVar = a;
        fVar.c("brservice bool start:" + false, new Object[0]);
        boolean z = false;
        for (int i = 0; i < 8; i++) {
            String str = c[i];
            Provider.Service service = b2.getService("SSLContext", str);
            if (service != null && !(service instanceof g)) {
                g a2 = a(service);
                f fVar2 = a;
                fVar2.c(str + " ssltype is load", new Object[0]);
                if (a2 != null) {
                    z |= a2.c();
                }
            }
        }
        f fVar3 = a;
        fVar3.c("brservice bool end:" + z, new Object[0]);
        return z;
    }

    private boolean c() {
        Provider provider = getProvider();
        if (provider == null) {
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT <= 23) {
                synchronized (Services.class) {
                    a(provider);
                }
                return true;
            }
            a(provider);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void a(Provider provider) throws Exception {
        Method declaredMethod = Provider.class.getDeclaredMethod("putService", new Class[]{Provider.Service.class});
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(provider, new Object[]{this});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        r0 = com.bonree.sdk.agent.engine.network.socket.external.f.a((javax.net.ssl.SSLContextSpi) r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object newInstance(java.lang.Object r4) throws java.security.NoSuchAlgorithmException {
        /*
            r3 = this;
            com.bonree.sdk.be.f r0 = a
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = "service newInstance"
            r0.c(r2, r1)
            java.lang.Object r4 = super.newInstance(r4)
            boolean r0 = r4 instanceof javax.net.ssl.SSLContextSpi     // Catch:{ ThreadDeath -> 0x001d, all -> 0x001c }
            if (r0 == 0) goto L_0x001c
            r0 = r4
            javax.net.ssl.SSLContextSpi r0 = (javax.net.ssl.SSLContextSpi) r0     // Catch:{ ThreadDeath -> 0x001d, all -> 0x001c }
            com.bonree.sdk.agent.engine.network.socket.external.f r0 = com.bonree.sdk.agent.engine.network.socket.external.f.a((javax.net.ssl.SSLContextSpi) r0)     // Catch:{ ThreadDeath -> 0x001d, all -> 0x001c }
            if (r0 == 0) goto L_0x001c
            r4 = r0
        L_0x001c:
            return r4
        L_0x001d:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.engine.network.socket.external.g.newInstance(java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = com.bonree.sdk.agent.engine.network.socket.external.f.a((javax.net.ssl.SSLContextSpi) r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object a(java.lang.Object r1) {
        /*
            boolean r0 = r1 instanceof javax.net.ssl.SSLContextSpi
            if (r0 == 0) goto L_0x000e
            r0 = r1
            javax.net.ssl.SSLContextSpi r0 = (javax.net.ssl.SSLContextSpi) r0
            com.bonree.sdk.agent.engine.network.socket.external.f r0 = com.bonree.sdk.agent.engine.network.socket.external.f.a((javax.net.ssl.SSLContextSpi) r0)
            if (r0 == 0) goto L_0x000e
            r1 = r0
        L_0x000e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.agent.engine.network.socket.external.g.a(java.lang.Object):java.lang.Object");
    }

    private Provider.Service d() {
        return this.b;
    }
}
