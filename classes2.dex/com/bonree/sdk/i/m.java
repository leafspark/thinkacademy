package com.bonree.sdk.i;

import com.bonree.sdk.i.l;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class m implements InvocationHandler {
    private /* synthetic */ l.b a;
    private /* synthetic */ Object b;

    m(l.b bVar, Object obj) {
        this.a = bVar;
        this.b = obj;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        l.b bVar = this.a;
        if (bVar != null) {
            bVar.a_(method, objArr);
            Object a2 = this.a.a(this.b, method, objArr);
            if (a2 != null) {
                return a2;
            }
        }
        return method.invoke(this.b, objArr);
    }
}
