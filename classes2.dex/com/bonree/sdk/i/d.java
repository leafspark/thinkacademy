package com.bonree.sdk.i;

import com.bonree.sdk.i.l;
import java.lang.reflect.Method;

final class d implements l.b {
    private /* synthetic */ c a;

    public final void a_(Method method, Object[] objArr) {
    }

    private d(c cVar) {
        this.a = cVar;
    }

    public final Object a(Object obj, Method method, Object[] objArr) throws Throwable {
        if ("registerAdapter".equals(method.getName())) {
            Object invoke = method.invoke(obj, objArr);
            Object a2 = this.a.a(invoke);
            return a2 == null ? invoke : a2;
        } else if (!"getBluetoothGatt".equals(method.getName())) {
            return null;
        } else {
            Object invoke2 = method.invoke(obj, objArr);
            Object b = this.a.b(invoke2);
            return b == null ? invoke2 : b;
        }
    }
}
