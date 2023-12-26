package com.bonree.sdk.l;

import android.content.SharedPreferences;
import com.bonree.sdk.agent.engine.external.MethodInfo;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class b {
    private int a;
    private long b;
    private long c;

    public b() {
    }

    public static SharedPreferences a(SharedPreferences sharedPreferences, String str) {
        try {
            return (SharedPreferences) Proxy.newProxyInstance(sharedPreferences.getClass().getClassLoader(), sharedPreferences.getClass().getInterfaces(), new a(sharedPreferences, str));
        } catch (Throwable unused) {
            return sharedPreferences;
        }
    }

    static class a implements InvocationHandler {
        private final String a;
        private final SharedPreferences b;

        public a(SharedPreferences sharedPreferences, String str) {
            this.b = sharedPreferences;
            this.a = str;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            if (name.startsWith("get")) {
                String a2 = a(name, objArr);
                MethodInfo.beforeMethod(a2, 9);
                try {
                    return method.invoke(this.b, objArr);
                } finally {
                    MethodInfo.afterMethod(a2, 9);
                }
            } else if (name.equals("edit")) {
                return new a(this.b.edit(), this.a);
            } else {
                return method.invoke(this.b, objArr);
            }
        }

        private String a(String str, Object[] objArr) {
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        String str2 = objArr[0];
                        if (str2.length() > 20) {
                            str2 = str2.substring(0, 20);
                        }
                        return String.format("%s/%s(%s)", new Object[]{this.a, str, str2});
                    }
                } catch (Exception unused) {
                }
            }
            return String.format("%s/%s", new Object[]{this.a, str});
        }

        private static void a(String str) {
            MethodInfo.beforeMethod(str, 9);
        }

        private static void b(String str) {
            MethodInfo.afterMethod(str, 9);
        }
    }

    public b(int i, long j, long j2) {
        this.a = i;
        this.b = j;
        this.c = j2;
    }

    public int a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.c;
    }

    public String toString() {
        return "SocketSendPacketData{sendByte=" + this.a + ", sendStartTimeMs=" + this.b + ", sendEndTimeMs=" + this.c + '}';
    }
}
