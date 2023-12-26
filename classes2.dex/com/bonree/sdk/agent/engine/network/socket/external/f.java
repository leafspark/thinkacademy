package com.bonree.sdk.agent.engine.network.socket.external;

import android.os.Build;
import com.bonree.sdk.be.a;
import com.bonree.sdk.bs.l;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.KeyManagementException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContextSpi;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public final class f extends SSLContextSpi {
    private static com.bonree.sdk.be.f a;
    private static Method[] b = new Method[7];
    private static boolean c;
    private SSLContextSpi d;

    static {
        com.bonree.sdk.be.f a2 = a.a();
        a = a2;
        c = false;
        try {
            a2.c("sslcontextSpi start:" + c, new Object[0]);
            b[0] = SSLContextSpi.class.getDeclaredMethod("engineCreateSSLEngine", new Class[0]);
            b[1] = SSLContextSpi.class.getDeclaredMethod("engineCreateSSLEngine", new Class[]{String.class, Integer.TYPE});
            b[2] = SSLContextSpi.class.getDeclaredMethod("engineGetClientSessionContext", new Class[0]);
            b[3] = SSLContextSpi.class.getDeclaredMethod("engineGetServerSessionContext", new Class[0]);
            b[4] = SSLContextSpi.class.getDeclaredMethod("engineGetServerSocketFactory", new Class[0]);
            b[5] = SSLContextSpi.class.getDeclaredMethod("engineGetSocketFactory", new Class[0]);
            b[6] = SSLContextSpi.class.getDeclaredMethod("engineInit", new Class[]{KeyManager[].class, TrustManager[].class, SecureRandom.class});
            for (Method method : b) {
                if (method != null) {
                    method.setAccessible(true);
                }
            }
            f fVar = new f();
            fVar.engineCreateSSLEngine();
            fVar.engineCreateSSLEngine((String) null, 0);
            fVar.engineGetClientSessionContext();
            fVar.engineGetServerSessionContext();
            fVar.engineGetServerSocketFactory();
            fVar.engineGetSocketFactory();
            fVar.engineInit((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
            c = true;
            a.c("sslcontextSpi end:" + c, new Object[0]);
        } catch (Throwable unused) {
            c = false;
            a.e("sslcontextSpi fail:" + c, new Object[0]);
        }
    }

    private f(SSLContextSpi sSLContextSpi) {
        this.d = sSLContextSpi;
    }

    public static f a(SSLContextSpi sSLContextSpi) {
        if (c) {
            return new f(sSLContextSpi);
        }
        return null;
    }

    private f() {
    }

    public static boolean a() {
        return c;
    }

    private Object a(int i, Object[] objArr) throws Exception {
        SSLContextSpi sSLContextSpi = this.d;
        if (sSLContextSpi == null) {
            return null;
        }
        try {
            return b[i].invoke(sSLContextSpi, objArr);
        } catch (IllegalArgumentException e) {
            throw new l((Throwable) e);
        } catch (IllegalAccessException e2) {
            throw new l((Throwable) e2);
        } catch (InvocationTargetException e3) {
            Throwable targetException = e3.getTargetException();
            if (targetException == null) {
                throw new l((Throwable) e3);
            } else if (targetException instanceof Exception) {
                throw ((Exception) targetException);
            } else if (targetException instanceof Error) {
                throw ((Error) targetException);
            } else {
                throw new l((Throwable) e3);
            }
        } catch (ClassCastException e4) {
            throw new l((Throwable) e4);
        }
    }

    private Object b(int i, Object[] objArr) {
        try {
            return a(i, objArr);
        } catch (RuntimeException e) {
            throw e;
        } catch (Throwable unused) {
            a.e("sslcontextSpi methodsReflect fail:", new Object[0]);
            return null;
        }
    }

    private Object a(Object[] objArr) throws KeyManagementException, l {
        try {
            return a(6, objArr);
        } catch (RuntimeException e) {
            throw e;
        } catch (KeyManagementException e2) {
            throw e2;
        } catch (Throwable th) {
            a.e("sslcontextSpi methodsReflect fail:", new Object[0]);
            throw new l(th);
        }
    }

    /* access modifiers changed from: protected */
    public final SSLEngine engineCreateSSLEngine() {
        return (SSLEngine) b(0, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public final SSLEngine engineCreateSSLEngine(String str, int i) {
        return (SSLEngine) b(1, new Object[]{str, Integer.valueOf(i)});
    }

    /* access modifiers changed from: protected */
    public final SSLSessionContext engineGetClientSessionContext() {
        return (SSLSessionContext) b(2, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public final SSLSessionContext engineGetServerSessionContext() {
        return (SSLSessionContext) b(3, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public final SSLServerSocketFactory engineGetServerSocketFactory() {
        return (SSLServerSocketFactory) b(4, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public final SSLSocketFactory engineGetSocketFactory() {
        SSLSocketFactory sSLSocketFactory = (SSLSocketFactory) b(5, new Object[0]);
        if (sSLSocketFactory == null) {
            a.c("localSSLSocketFactory is null", new Object[0]);
            return sSLSocketFactory;
        }
        a.c("localSSLSocketFactory engineGetSocketFactory", new Object[0]);
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                return new BrSocketFactory(sSLSocketFactory);
            }
            return Build.VERSION.SDK_INT >= 14 ? new BrSSLSocketFactoryBeforeV14(sSLSocketFactory) : sSLSocketFactory;
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            a.e("sslcontextSpi engineGetSocketFactory fail:", new Object[0]);
            return sSLSocketFactory;
        }
    }

    /* access modifiers changed from: protected */
    public final void engineInit(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom) throws KeyManagementException {
        try {
            a(new Object[]{keyManagerArr, trustManagerArr, secureRandom});
        } catch (l unused) {
            a.e("sslcontextSpi engineInit fail:", new Object[0]);
        }
    }

    public final boolean equals(Object obj) {
        return this.d.equals(obj);
    }

    public final int hashCode() {
        return this.d.hashCode();
    }

    public final String toString() {
        return this.d.toString();
    }
}
