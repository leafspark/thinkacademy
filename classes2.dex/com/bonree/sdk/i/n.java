package com.bonree.sdk.i;

import com.bonree.sdk.i.k;
import com.bonree.sdk.i.l;
import java.lang.reflect.Method;
import java.util.Iterator;

public class n extends k implements l.b {
    private static final String c = "BRSDK.WifiHooker";
    private l.b d = this;

    public interface a extends k.a {
        void a();

        void b();
    }

    public Object a(Object obj, Method method, Object[] objArr) {
        return null;
    }

    public n() {
        this.b = new l("wifi", "android.net.wifi.IWifiManager", this);
        a(this.b);
    }

    /* access modifiers changed from: protected */
    public final void a(Method method, Object[] objArr) {
        if ("startScan".equals(method.getName())) {
            for (k.a aVar : this.a) {
                if (aVar instanceof a) {
                    ((a) aVar).a();
                }
            }
        } else if ("getScanResults".equals(method.getName())) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                it.next();
            }
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

    public static n a() {
        return b.a;
    }

    static class b {
        /* access modifiers changed from: private */
        public static final n a = new n();

        private b() {
        }
    }

    public void a_(Method method, Object[] objArr) {
        a(method, objArr);
    }
}
