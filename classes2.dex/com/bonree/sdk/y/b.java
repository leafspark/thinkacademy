package com.bonree.sdk.y;

import ohos.eventhandler.EventRunner;

public final class b extends com.bonree.sdk.g.a<a, d> {
    private static String a;

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
    }

    static class a {
        /* access modifiers changed from: private */
        public static final b a = new b((byte) 0);

        private a() {
        }
    }

    public static b a() {
        return a.a;
    }

    /* access modifiers changed from: protected */
    public final void startEngine() {
        super.startEngine();
        com.bonree.sdk.be.a.a().c("abilitySlice engine is start.", new Object[0]);
    }

    /* access modifiers changed from: protected */
    public final void stopEngine() {
        super.stopEngine();
        com.bonree.sdk.be.a.a().c("abilitySlice engine is stop.", new Object[0]);
    }

    public final void a(String str, Object obj) {
        a(str, obj, a.l, 0);
    }

    public final void b(String str, Object obj) {
        a(str, obj, a.l, 1);
    }

    public final void c(String str, Object obj) {
        a(str, obj, a.n, 0);
    }

    public final void d(String str, Object obj) {
        a(str, obj, a.n, 1);
    }

    public final void e(String str, Object obj) {
        a(str, obj, a.p, 0);
    }

    public final void f(String str, Object obj) {
        a(str, obj, a.p, 1);
    }

    public final void g(String str, Object obj) {
        a(str, obj, a.o, 0);
    }

    public final void h(String str, Object obj) {
        a(str, obj, a.o, 1);
    }

    private void i(String str, Object obj) {
        a(str, obj, a.m, 0);
    }

    private void j(String str, Object obj) {
        a(str, obj, a.m, 1);
    }

    private void a(String str, Object obj, String str2, int i) {
        a(str, obj, str2, i, false, false);
    }

    private void a(String str, Object obj, String str2, int i, boolean z, boolean z2) {
        if (!isEmptyServices() && obj != null) {
            a aVar = new a();
            aVar.a(str);
            aVar.c(str2);
            aVar.b(i);
            aVar.a(com.bonree.sdk.d.a.b());
            aVar.b(com.bonree.sdk.d.a.l());
            aVar.b(obj.getClass().getName());
            aVar.d(System.identityHashCode(obj));
            boolean z3 = false;
            aVar.c(false);
            aVar.d(false);
            aVar.a(0);
            aVar.d(Thread.currentThread().getName());
            aVar.f(String.valueOf(Thread.currentThread().getId()));
            if (EventRunner.current() == EventRunner.getMainEventRunner()) {
                z3 = true;
            }
            aVar.a(z3);
            notifyService(aVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void notifyService(a aVar) {
        this.readWriteLock.readLock().lock();
        try {
            for (d a2 : this.services) {
                a2.a(aVar);
            }
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    private static String b() {
        return a;
    }

    private static void a(String str) {
        a = str;
    }
}
