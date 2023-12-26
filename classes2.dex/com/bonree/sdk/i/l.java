package com.bonree.sdk.i;

import android.os.IBinder;
import android.os.IInterface;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import com.bonree.sdk.be.f;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URI;
import java.net.URL;
import java.util.Map;

public class l {
    private static final String a = "BRSDK.Hooker";
    private final String b;
    private final String c;
    private final b d;
    private IBinder e;
    private IBinder f;
    private f g;

    public interface b {
        Object a(Object obj, Method method, Object[] objArr) throws Throwable;

        void a_(Method method, Object[] objArr);
    }

    public l(String str, String str2, b bVar) {
        this.g = com.bonree.sdk.be.a.a();
        this.b = str;
        this.c = str2;
        this.d = bVar;
    }

    public final boolean a() {
        f fVar = this.g;
        fVar.c("BRSDK.Hooker doHook: serviceName:" + this.b + ", serviceClsName:" + this.c, new Object[0]);
        try {
            a aVar = new a(this.b, this.c, this.d);
            Class<?> cls = Class.forName("android.os.ServiceManager");
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader != null) {
                IBinder iBinder = (IBinder) Proxy.newProxyInstance(classLoader, new Class[]{IBinder.class}, aVar);
                Field declaredField = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
                declaredField.setAccessible(true);
                ((Map) declaredField.get((Object) null)).put(this.b, iBinder);
                this.f = iBinder;
                this.e = aVar.a();
                return true;
            }
            throw new IllegalStateException("Can not get ClassLoader of " + cls.getName());
        } catch (Throwable th) {
            f fVar2 = this.g;
            fVar2.d("BRSDK.Hooker #doHook exp: " + th.getLocalizedMessage(), new Object[0]);
            return false;
        }
    }

    public final boolean b() {
        if (this.e == null) {
            this.g.d("BRSDK.Hooker #stopHook mOriginServiceBinder null", new Object[0]);
            return false;
        } else if (this.f == null) {
            this.g.d("BRSDK.Hooker #stopHook mDelegateServiceBinder null", new Object[0]);
            return false;
        } else {
            try {
                if (this.f != a.a(this.b)) {
                    this.g.d("BRSDK.Hooker #stopHook mDelegateServiceBinder != currentBinder", new Object[0]);
                    return false;
                }
                Field declaredField = Class.forName("android.os.ServiceManager").getDeclaredField("sCache");
                declaredField.setAccessible(true);
                ((Map) declaredField.get((Object) null)).put(this.b, this.e);
                return true;
            } catch (Throwable th) {
                f fVar = this.g;
                fVar.d("BRSDK.Hooker #stopHook exp: " + th.getLocalizedMessage(), new Object[0]);
                return false;
            }
        }
    }

    static final class a implements InvocationHandler {
        private final IBinder a;
        private final Object b;

        a(String str, String str2, b bVar) throws Exception {
            if (str.equals("activity")) {
                Method declaredMethod = Class.forName("android.app.ActivityManagerNative").getDeclaredMethod("getDefault", new Class[0]);
                this.a = (IBinder) declaredMethod.invoke(declaredMethod, new Object[0]);
            } else {
                this.a = a(str);
            }
            IBinder iBinder = this.a;
            Class<?> cls = Class.forName(str2);
            Class<?> cls2 = Class.forName(str2 + "$Stub");
            ClassLoader classLoader = cls2.getClassLoader();
            if (classLoader != null) {
                Object invoke = cls2.getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke((Object) null, new Object[]{iBinder});
                this.b = Proxy.newProxyInstance(classLoader, new Class[]{IBinder.class, IInterface.class, cls}, new m(bVar, invoke));
                return;
            }
            throw new IllegalStateException("get service manager ClassLoader fail!");
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if ("queryLocalInterface".equals(method.getName())) {
                return this.b;
            }
            return method.invoke(this.a, objArr);
        }

        public final IBinder a() {
            return this.a;
        }

        public final IBinder b() throws Exception {
            Class<?> cls = Class.forName("android.os.ServiceManager");
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader != null) {
                return (IBinder) Proxy.newProxyInstance(classLoader, new Class[]{IBinder.class}, this);
            }
            throw new IllegalStateException("Can not get ClassLoader of " + cls.getName());
        }

        static IBinder a(String str) throws Exception {
            return (IBinder) Class.forName("android.os.ServiceManager").getDeclaredMethod("getService", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
        }

        private static Object a(String str, IBinder iBinder, b bVar) throws Exception {
            Class<?> cls = Class.forName(str);
            Class<?> cls2 = Class.forName(str + "$Stub");
            ClassLoader classLoader = cls2.getClassLoader();
            if (classLoader != null) {
                Object invoke = cls2.getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke((Object) null, new Object[]{iBinder});
                return Proxy.newProxyInstance(classLoader, new Class[]{IBinder.class, IInterface.class, cls}, new m(bVar, invoke));
            }
            throw new IllegalStateException("get service manager ClassLoader fail!");
        }
    }

    public l() {
    }

    private static void c(String str, URI uri, String str2) {
        if (uri != null) {
            MethodInfo.beforeMethod(str, 1, uri.toString(), str2);
        }
    }

    public static void a(String str, URL url, String str2) {
        if (url != null) {
            MethodInfo.beforeMethod(str, 1, url.toString(), str2);
        }
    }

    private static void c(String str, URL url, String str2, int i) {
        if (url != null) {
            MethodInfo.beforeMethod(str, 1, url.toString(), str2, i);
        }
    }

    public static void a(String str, String str2, String str3) {
        MethodInfo.beforeMethod(str, 1, str2, str3);
    }

    private static void c(String str, String str2, String str3, int i) {
        MethodInfo.beforeMethod(str, 1, str2, str3, i);
    }

    public static void a(String str, URI uri, String str2) {
        if (uri != null) {
            e(str, uri.toString(), str2);
        }
    }

    public static void a(String str, URI uri, String str2, int i) {
        if (uri != null) {
            a(str, uri.toString(), str2, i);
        }
    }

    private static void c(String str, URL url, String str2) {
        if (url != null) {
            e(str, url.toString(), str2);
        }
    }

    public static void a(String str, URL url, String str2, int i) {
        if (url != null) {
            a(str, url.toString(), str2, i);
        }
    }

    private static void e(String str, String str2, String str3) {
        MethodInfo.beforeMethod(str, 13, str2, str3);
    }

    public static void a(String str, String str2, String str3, int i) {
        MethodInfo.beforeMethod(str, 13, str2, str3, i);
    }

    private static void d(String str, URI uri, String str2) {
        if (uri != null) {
            b(str, uri.toString(), str2);
        }
    }

    private static void d(String str, URL url, String str2) {
        if (url != null) {
            b(str, url.toString(), str2);
        }
    }

    public static void b(String str, String str2, String str3) {
        MethodInfo.beforeMethod(str, 14, str2, str3);
    }

    private static void e(String str, URI uri, String str2) {
        if (uri != null) {
            MethodInfo.afterMethod(str, 1, uri.toString(), str2);
        }
    }

    public static void b(String str, URL url, String str2) {
        if (url != null) {
            MethodInfo.afterMethod(str, 1, url.toString(), str2);
        }
    }

    public static void c(String str, String str2, String str3) {
        MethodInfo.afterMethod(str, 1, str2, str3);
    }

    public static void b(String str, URI uri, String str2) {
        if (uri != null) {
            f(str, uri.toString(), str2);
        }
    }

    public static void b(String str, URI uri, String str2, int i) {
        if (uri != null) {
            b(str, uri.toString(), str2, i);
        }
    }

    private static void e(String str, URL url, String str2) {
        if (url != null) {
            f(str, url.toString(), str2);
        }
    }

    public static void b(String str, URL url, String str2, int i) {
        if (url != null) {
            b(str, url.toString(), str2, i);
        }
    }

    private static void f(String str, String str2, String str3) {
        MethodInfo.afterMethod(str, 13, str2, str3);
    }

    public static void b(String str, String str2, String str3, int i) {
        MethodInfo.afterMethod(str, 13, str2, str3, i);
    }

    private static void f(String str, URI uri, String str2) {
        if (uri != null) {
            d(str, uri.toString(), str2);
        }
    }

    private static void f(String str, URL url, String str2) {
        if (url != null) {
            d(str, url.toString(), str2);
        }
    }

    public static void d(String str, String str2, String str3) {
        MethodInfo.afterMethod(str, 14, str2, str3);
    }
}
