package com.igexin.b.a.b;

import com.igexin.b.a.d.a.a;
import com.igexin.b.a.d.e;
import com.igexin.b.a.d.f;
import java.util.concurrent.TimeUnit;

public class c extends f {
    static c a;
    public volatile long b;
    public volatile long c;
    public volatile long d;
    public volatile long e;
    a<String, Integer, b, d> f;
    private byte[] v;
    private byte[] w;

    public static c b() {
        if (a == null) {
            a = new c();
        }
        return a;
    }

    public static void d() {
        a.b = 0;
        a.d = 0;
        a.c = 0;
        a.e = 0;
    }

    public d a(String str, int i, b bVar, Object obj, boolean z) {
        return a(str, i, bVar, obj, z, -1, -1, (byte) 0, (Object) null, (com.igexin.b.a.d.a.c) null);
    }

    public d a(String str, int i, b bVar, Object obj, boolean z, int i2, long j, byte b2, Object obj2, com.igexin.b.a.d.a.c cVar) {
        return a(str, i, bVar, obj, z, i2, j, b2, obj2, cVar, 0, (com.igexin.b.a.d.a.f) null);
    }

    public d a(String str, int i, b bVar, Object obj, boolean z, int i2, long j, byte b2, Object obj2, com.igexin.b.a.d.a.c cVar, int i3, com.igexin.b.a.d.a.f fVar) {
        com.igexin.b.a.d.a.f fVar2 = fVar;
        a<String, Integer, b, d> aVar = this.f;
        if (aVar == null) {
            return null;
        }
        String str2 = str;
        b bVar2 = bVar;
        d a2 = aVar.a(str, Integer.valueOf(i), bVar);
        if (a2 == null || a2.r()) {
            return null;
        }
        if (fVar2 != null) {
            a2.a(i3, fVar2);
        }
        a(a2, obj, z, i2, j, b2, obj2, cVar);
        return a2;
    }

    public d a(String str, int i, b bVar, Object obj, boolean z, int i2, com.igexin.b.a.d.a.f fVar) {
        return a(str, i, bVar, obj, z, -1, -1, (byte) 0, (Object) null, (com.igexin.b.a.d.a.c) null, i2, fVar);
    }

    public void a(a<String, Integer, b, d> aVar) {
        this.f = aVar;
    }

    public void a(byte[] bArr) {
        this.v = bArr;
        this.w = com.igexin.b.b.a.a(bArr);
    }

    /* access modifiers changed from: package-private */
    public boolean a(d dVar, Object obj, boolean z, int i, long j, byte b2, Object obj2, com.igexin.b.a.d.a.c cVar) {
        dVar.c = obj;
        dVar.a(j, TimeUnit.MILLISECONDS);
        dVar.w = i;
        dVar.a((int) b2);
        dVar.B = obj2;
        dVar.a(cVar);
        return a((e) dVar, z);
    }

    public byte[] a() {
        return this.w;
    }

    public final void c() {
        f();
    }
}
