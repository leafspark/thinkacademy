package com.bonree.sdk.i;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class e implements InvocationHandler {
    private /* synthetic */ Object a;
    private /* synthetic */ c b;

    e(c cVar, Object obj) {
        this.b = cVar;
        this.a = obj;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        if ("startDiscovery".equals(method.getName())) {
            c.a(this.b);
        }
        try {
            return this.b.b(this.a, method, objArr);
        } catch (Throwable th) {
            this.b.d.d("BRSDK.BluetoothHooker invokeBluetooth fail", th);
            return null;
        }
    }
}
