package com.bonree.sdk.w;

import android.os.Build;
import com.bonree.sdk.be.f;
import com.bonree.sdk.k.d;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class a {
    private static Object a;
    private static Object b;
    private String c;
    private long d;
    private final boolean e;
    private boolean f;
    private int g;
    private Map<String, String> h;
    private String i;
    private String j;

    public a() {
    }

    public static boolean a() {
        Field field;
        Class<?> cls;
        try {
            if (Build.VERSION.SDK_INT < 26) {
                field = Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault");
            } else if (Build.VERSION.SDK_INT <= 28) {
                field = Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            } else {
                field = Class.forName("android.app.ActivityTaskManager").getDeclaredField("IActivityTaskManagerSingleton");
            }
            field.setAccessible(true);
            Object obj = field.get((Object) null);
            Field declaredField = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            a = obj2;
            if (obj2 == null) {
                com.bonree.sdk.be.a.a().e("proxyAMS field: manager == null", new Object[0]);
                return false;
            }
            if (Build.VERSION.SDK_INT <= 28) {
                cls = Class.forName("android.app.IActivityManager");
            } else {
                cls = Class.forName("android.app.IActivityTaskManager");
            }
            Object newProxyInstance = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, new C0024a(a));
            b = newProxyInstance;
            declaredField.set(obj, newProxyInstance);
            com.bonree.sdk.be.a.a().e("proxyAMS success", new Object[0]);
            return true;
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().e("proxyAMS field:%s", th.toString());
            return false;
        }
    }

    public static boolean b() {
        Field field;
        if (b == null || a == null) {
            d(FirebaseAnalytics.Param.SUCCESS);
            return true;
        }
        try {
            if (Build.VERSION.SDK_INT < 26) {
                field = Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault");
            } else if (Build.VERSION.SDK_INT <= 28) {
                field = Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            } else {
                field = Class.forName("android.app.ActivityTaskManager").getDeclaredField("IActivityTaskManagerSingleton");
            }
            field.setAccessible(true);
            Object obj = field.get((Object) null);
            Field declaredField = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 == null) {
                com.bonree.sdk.be.a.a().e("stop proxyAMS field: manager == null", new Object[0]);
                d("field");
                return false;
            }
            if (obj2 == b) {
                declaredField.set(obj, a);
                b = null;
                a = null;
                d(FirebaseAnalytics.Param.SUCCESS);
                return true;
            }
            d("field");
            return false;
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().c("proxyAMS field:%s", th.toString());
        }
    }

    private static void d(String str) {
        f a2 = com.bonree.sdk.be.a.a();
        a2.e("stop proxyAMS " + str, new Object[0]);
    }

    /* renamed from: com.bonree.sdk.w.a$a  reason: collision with other inner class name */
    public static class C0024a implements InvocationHandler {
        private Object a;

        public C0024a(Object obj) {
            this.a = obj;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            d.a(method.getName(), objArr);
            Object invoke = method.invoke(this.a, objArr);
            d.b(method.getName(), objArr);
            return invoke;
        }
    }

    public a(String str) {
        this(str, false);
    }

    public a(String str, int i2) {
        this(str, false);
        this.g = i2;
    }

    public a(String str, boolean z) {
        this.g = -1;
        this.c = str;
        this.f = z;
        this.d = com.bonree.sdk.d.a.l();
        this.e = com.bonree.sdk.d.a.k().J();
    }

    public String c() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public long d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public int g() {
        return this.g;
    }

    public void a(int i2) {
        this.g = i2;
    }

    public Map<String, String> h() {
        return this.h;
    }

    public void a(Map<String, String> map) {
        this.h = map;
    }

    public String i() {
        return this.i;
    }

    public void b(String str) {
        this.i = str;
    }

    public String j() {
        return this.j;
    }

    public void c(String str) {
        this.j = str;
    }
}
