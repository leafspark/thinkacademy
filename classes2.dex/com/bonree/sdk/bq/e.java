package com.bonree.sdk.bq;

import com.bonree.sdk.bl.d;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public final class e extends c {
    /* access modifiers changed from: private */
    public final AtomicInteger c = new AtomicInteger();
    /* access modifiers changed from: private */
    public final AtomicInteger d = new AtomicInteger();
    /* access modifiers changed from: private */
    public final AtomicInteger e = new AtomicInteger();
    /* access modifiers changed from: private */
    public final AtomicInteger f = new AtomicInteger();
    /* access modifiers changed from: private */
    public final AtomicInteger g = new AtomicInteger();
    /* access modifiers changed from: private */
    public final AtomicInteger h = new AtomicInteger();
    /* access modifiers changed from: private */
    public final AtomicInteger i = new AtomicInteger();
    /* access modifiers changed from: private */
    public final AtomicInteger j = new AtomicInteger();
    /* access modifiers changed from: private */
    public final AtomicInteger k = new AtomicInteger();

    /* renamed from: c */
    public final d a(com.bonree.sdk.bj.a aVar, InetAddress inetAddress, int i2) throws IOException {
        try {
            d c2 = super.a(aVar, inetAddress, i2);
            this.c.incrementAndGet();
            this.d.addAndGet(c2.a.a().length);
            return c2;
        } catch (IOException e2) {
            this.e.incrementAndGet();
            throw e2;
        }
    }

    /* access modifiers changed from: protected */
    public final com.bonree.sdk.bj.a d(com.bonree.sdk.bj.a aVar, InetAddress inetAddress, int i2) throws IOException {
        try {
            com.bonree.sdk.bj.a d2 = super.d(aVar, inetAddress, i2);
            this.f.incrementAndGet();
            this.g.addAndGet(d2.a().length);
            return d2;
        } catch (IOException e2) {
            this.h.incrementAndGet();
            throw e2;
        }
    }

    /* access modifiers changed from: protected */
    public final com.bonree.sdk.bj.a e(com.bonree.sdk.bj.a aVar, InetAddress inetAddress, int i2) throws IOException {
        try {
            com.bonree.sdk.bj.a e2 = super.e(aVar, inetAddress, i2);
            this.i.incrementAndGet();
            this.j.addAndGet(e2.a().length);
            return e2;
        } catch (IOException e3) {
            this.k.incrementAndGet();
            throw e3;
        }
    }

    private a d() {
        return new a(this, (byte) 0);
    }

    private static e a(com.bonree.sdk.bf.a aVar) {
        b a2 = aVar.a();
        if (a2 instanceof e) {
            return (e) a2;
        }
        return null;
    }

    public static final class a {
        private int a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;
        private int l;
        private String m;

        /* synthetic */ a(e eVar, byte b2) {
            this(eVar);
        }

        private a(e eVar) {
            this.a = eVar.c.get();
            this.b = eVar.d.get();
            this.d = eVar.e.get();
            this.e = eVar.f.get();
            this.f = eVar.g.get();
            this.h = eVar.h.get();
            this.i = eVar.i.get();
            this.j = eVar.j.get();
            this.l = eVar.k.get();
            int i2 = this.a;
            int i3 = 0;
            this.c = i2 > 0 ? this.b / i2 : 0;
            int i4 = this.e;
            this.g = i4 > 0 ? this.f / i4 : 0;
            int i5 = this.i;
            this.k = i5 > 0 ? this.j / i5 : i3;
        }

        public final String toString() {
            String str = this.m;
            if (str != null) {
                return str;
            }
            String str2 = "Stats\t# Successful" + 9 + "# Failed\t" + "Resp. Size\t" + "Avg. Resp. Size\n" + "Total\t" + a(this.a) + 9 + a(this.d) + 9 + a(this.b) + 9 + a(this.c) + 10 + "UDP\t" + a(this.e) + 9 + a(this.h) + 9 + a(this.f) + 9 + a(this.g) + 10 + "TCP\t" + a(this.i) + 9 + a(this.l) + 9 + a(this.j) + 9 + a(this.k) + 10;
            this.m = str2;
            return str2;
        }

        private static String a(int i2) {
            return String.format(Locale.US, "%,09d", new Object[]{Integer.valueOf(i2)});
        }
    }
}
