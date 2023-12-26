package com.bonree.sdk.i;

import com.bonree.sdk.i.k;
import com.bonree.sdk.i.l;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Method;

public class g extends k implements l.b {
    private static final String c = "BRSDK.LocationHooker";

    public interface a extends k.a {
        void a(int i);

        void b(int i);
    }

    public Object a(Object obj, Method method, Object[] objArr) {
        return null;
    }

    /* synthetic */ g(byte b2) {
        this();
    }

    private g() {
        this.b = new l(FirebaseAnalytics.Param.LOCATION, "android.location.ILocationManager", this);
    }

    /* access modifiers changed from: protected */
    public final void a(Method method, Object[] objArr) {
        if ("requestLocationUpdates".equals(method.getName())) {
            if (objArr[0] != null && objArr[1] != null) {
                b(System.identityHashCode(objArr[1]));
            } else if (objArr[1] == null && objArr[2] != null && "android.app.PendingIntent".equals(objArr[2].getClass().getName())) {
                b(System.identityHashCode(objArr[2]));
            }
        } else if ("registerLocationListener".equals(method.getName())) {
            if (objArr[2] != null) {
                b(System.identityHashCode(objArr[2]));
            }
        } else if ("registerLocationPendingIntent".equals(method.getName())) {
            if (objArr[2] != null) {
                b(System.identityHashCode(objArr[2]));
            }
        } else if ("removeUpdates".equals(method.getName()) || "unregisterLocationListener".equals(method.getName())) {
            if (objArr[0] != null) {
                a(System.identityHashCode(objArr[0]));
            } else if (objArr[1] != null && "android.app.PendingIntent".equals(objArr[1].getClass().getName())) {
                a(System.identityHashCode(objArr[1]));
            }
        } else if ("unregisterLocationPendingIntent".equals(method.getName()) && objArr[0] != null) {
            a(System.identityHashCode(objArr[0]));
        }
    }

    private void a(int i) {
        for (k.a aVar : this.a) {
            if (aVar instanceof a) {
                ((a) aVar).b(i);
            }
        }
    }

    private void b(int i) {
        for (k.a aVar : this.a) {
            if (aVar instanceof a) {
                ((a) aVar).a(i);
            }
        }
    }

    public static g a() {
        return b.a;
    }

    static class b {
        /* access modifiers changed from: private */
        public static final g a = new g((byte) 0);

        private b() {
        }
    }

    public void a_(Method method, Object[] objArr) {
        a(method, objArr);
    }
}
