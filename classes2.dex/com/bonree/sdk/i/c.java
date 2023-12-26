package com.bonree.sdk.i;

import android.bluetooth.le.ScanSettings;
import android.os.IBinder;
import android.os.IInterface;
import com.bonree.sdk.be.f;
import com.bonree.sdk.i.k;
import com.bonree.sdk.i.l;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;

public class c extends k implements l.b {
    private static final String c = "BRSDK.BluetoothHooker";
    /* access modifiers changed from: private */
    public f d = com.bonree.sdk.be.a.a();
    private l.b e = this;

    public interface a extends k.a {
        void a();

        void b();

        void c();

        void d();
    }

    /* access modifiers changed from: protected */
    public final void a(Method method, Object[] objArr) {
    }

    public void a_(Method method, Object[] objArr) {
    }

    public c() {
        this.b = new l("bluetooth_manager", "android.bluetooth.IBluetoothManager", this);
        a(this.b);
    }

    /* access modifiers changed from: private */
    public Object a(Object obj) {
        try {
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{IBinder.class, IInterface.class, Class.forName("android.bluetooth.IBluetooth")}, new e(this, obj));
        } catch (Throwable th) {
            this.d.d("BRSDK.BluetoothHooker proxyBluetooth fail", th);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public Object b(Object obj) {
        try {
            return Proxy.newProxyInstance(obj.getClass().getClassLoader(), new Class[]{IBinder.class, IInterface.class, Class.forName("android.bluetooth.IBluetoothGatt")}, new f(this, obj));
        } catch (Throwable th) {
            this.d.d("BRSDK.BluetoothHooker proxyBluetoothGatt fail", th);
            return null;
        }
    }

    private void b() {
        for (k.a aVar : this.a) {
            if (aVar instanceof a) {
                ((a) aVar).a();
            }
        }
    }

    private void c() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private void a(int i, ScanSettings scanSettings) {
        for (k.a aVar : this.a) {
            if (aVar instanceof a) {
                ((a) aVar).c();
            }
        }
    }

    private void a(ScanSettings scanSettings) {
        for (k.a aVar : this.a) {
            if (aVar instanceof a) {
                ((a) aVar).d();
            }
        }
    }

    /* access modifiers changed from: private */
    public Object b(Object obj, Method method, Object[] objArr) {
        Object obj2;
        try {
            obj2 = method.invoke(obj, objArr);
        } catch (Throwable th) {
            this.d.d("BRSDK.BluetoothHooker reflect invocation fail", th);
            obj2 = null;
        }
        if (obj2 != null) {
            return obj2;
        }
        Class<?> returnType = method.getReturnType();
        if (returnType == null || !returnType.isPrimitive()) {
            return null;
        }
        if (returnType == Byte.TYPE || returnType == Short.TYPE || returnType == Integer.TYPE) {
            return 0;
        }
        if (returnType == Long.TYPE) {
            return 0L;
        }
        if (returnType == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (returnType == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (returnType == Character.TYPE) {
            return 0;
        }
        if (returnType == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static c a() {
        return b.a;
    }

    static class b {
        /* access modifiers changed from: private */
        public static final c a = new c();

        private b() {
        }
    }

    static /* synthetic */ void a(c cVar) {
        for (k.a aVar : cVar.a) {
            if (aVar instanceof a) {
                ((a) aVar).a();
            }
        }
    }

    static /* synthetic */ void c(c cVar) {
        Iterator it = cVar.a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    static /* synthetic */ void a(c cVar, int i, ScanSettings scanSettings) {
        for (k.a aVar : cVar.a) {
            if (aVar instanceof a) {
                ((a) aVar).c();
            }
        }
    }

    static /* synthetic */ void a(c cVar, ScanSettings scanSettings) {
        for (k.a aVar : cVar.a) {
            if (aVar instanceof a) {
                ((a) aVar).d();
            }
        }
    }

    public Object a(Object obj, Method method, Object[] objArr) throws Throwable {
        if ("registerAdapter".equals(method.getName())) {
            Object invoke = method.invoke(obj, objArr);
            Object a2 = a(invoke);
            return a2 == null ? invoke : a2;
        } else if (!"getBluetoothGatt".equals(method.getName())) {
            return null;
        } else {
            Object invoke2 = method.invoke(obj, objArr);
            Object b2 = b(invoke2);
            return b2 == null ? invoke2 : b2;
        }
    }
}
