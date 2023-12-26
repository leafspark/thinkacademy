package com.bonree.sdk.ad;

import android.os.Message;
import com.bonree.sdk.ad.d;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.be.f;
import com.bonree.sdk.d.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class a {
    protected volatile boolean a;
    protected e b;
    protected f c = com.bonree.sdk.be.a.a();
    protected g<a> d;
    protected String e;

    public enum b {
        NETWORK,
        CRASH
    }

    public interface c {
        void a(b bVar, EventBean eventBean);
    }

    /* access modifiers changed from: protected */
    public void a(Message message) {
    }

    public abstract boolean b();

    public abstract boolean c();

    /* access modifiers changed from: protected */
    public final void a(String str, int i) {
        int i2 = b.a[i - 1];
        if (i2 == 1) {
            this.c.c("%s service is about to start.. ", str);
        } else if (i2 == 2) {
            this.c.d("%s service is running! ", str);
        } else if (i2 == 3) {
            this.c.c("%s service started successfully ! ", str);
        } else if (i2 == 4) {
            this.c.c("%s service is about to stop.. ", str);
        } else if (i2 == 5) {
            this.c.c("%s service closed successfully ! ", str);
        }
    }

    public a(e eVar) {
        this.b = eVar;
    }

    public enum d {
        ;
        
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;

        static {
            f = new int[]{1, 2, 3, 4, 5};
        }

        public static int[] a() {
            return (int[]) f.clone();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(String str) {
        this.e = str;
        this.d = new g<>(d.a.a.a(str), this);
    }

    /* access modifiers changed from: protected */
    public final void f() {
        try {
            g<a> gVar = this.d;
            if (gVar != null) {
                gVar.c();
                this.d.removeCallbacksAndMessages((Object) null);
            }
            d.a.a.b(this.e);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: com.bonree.sdk.ad.a$a  reason: collision with other inner class name */
    static class C0001a {
        private List<a> a = new ArrayList();
        private Map<b, List<c>> b = new HashMap();

        C0001a() {
        }

        public static C0001a a() {
            return C0002a.a;
        }

        /* renamed from: com.bonree.sdk.ad.a$a$a  reason: collision with other inner class name */
        static class C0002a {
            /* access modifiers changed from: private */
            public static final C0001a a = new C0001a();

            private C0002a() {
            }
        }

        /* access modifiers changed from: protected */
        public final void a(b bVar, EventBean eventBean) {
            synchronized (this.b) {
                List<c> list = this.b.get(bVar);
                if (list != null) {
                    for (c a2 : list) {
                        a2.a(bVar, eventBean);
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void a(b bVar, c cVar) {
            if (bVar != null && cVar != null) {
                synchronized (this.b) {
                    List list = this.b.get(bVar);
                    if (list == null) {
                        list = new ArrayList();
                        this.b.put(bVar, list);
                    }
                    if (!list.contains(cVar)) {
                        list.add(cVar);
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void b(b bVar, c cVar) {
            if (bVar != null && cVar != null) {
                synchronized (this.b) {
                    List list = this.b.get(bVar);
                    if (list != null) {
                        list.remove(cVar);
                    }
                }
            }
        }
    }

    private void b(int i) {
        try {
            if (d.a.a.a(this.e, this.d)) {
                this.d.obtainMessage(i).sendToTarget();
            }
        } catch (Exception unused) {
        }
    }

    public final void a(int i, Object obj) {
        try {
            if (d.a.a.a(this.e, this.d)) {
                this.d.obtainMessage(i, obj).sendToTarget();
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Message message, long j) {
        try {
            if (d.a.a.a(this.e, this.d)) {
                this.d.sendMessageDelayed(message, j);
            }
        } catch (Exception unused) {
        }
    }

    public final void a(int i, long j) {
        try {
            if (d.a.a.a(this.e, this.d)) {
                this.d.sendEmptyMessageDelayed(i, j);
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Runnable runnable, long j) {
        try {
            if (d.a.a.a(this.e, this.d)) {
                this.d.postDelayed(runnable, j);
            }
        } catch (Exception unused) {
        }
    }

    public final void a(int i) {
        try {
            if (d.a.a.a(this.e, this.d)) {
                this.d.removeMessages(i);
            }
        } catch (Exception unused) {
        }
    }

    protected static void a(b bVar, c cVar) {
        C0001a.C0002a.a.a(bVar, cVar);
    }

    protected static void b(b bVar, c cVar) {
        C0001a.C0002a.a.b(bVar, cVar);
    }

    public static void b(b bVar, EventBean eventBean) {
        C0001a.C0002a.a.a(bVar, eventBean);
    }
}
