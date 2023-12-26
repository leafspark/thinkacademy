package com.bonree.sdk.bf;

import com.bonree.sdk.bf.i;
import com.bonree.sdk.bg.c;
import com.bonree.sdk.bj.a;
import com.bonree.sdk.bp.h;
import com.bonree.sdk.bp.m;
import com.bonree.sdk.bp.v;
import com.bonree.sdk.bq.b;
import java.io.IOException;
import java.net.InetAddress;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class a {
    protected static final Logger a = Logger.getLogger(a.class.getName());
    protected static C0012a e = C0012a.v4v6;
    private static c g = new c();
    protected final Random b;
    protected final d c;
    protected b d;
    protected C0012a f;
    private final b.a h;
    private Random i;

    /* access modifiers changed from: protected */
    public abstract com.bonree.sdk.bl.c a(a.C0014a aVar) throws IOException;

    /* access modifiers changed from: protected */
    public abstract a.C0014a c(a.C0014a aVar);

    /* renamed from: com.bonree.sdk.bf.a$a  reason: collision with other inner class name */
    public enum C0012a {
        v4only(true, false),
        v6only(false, true),
        v4v6(true, true),
        v6v4(true, true);
        
        public final boolean v4;
        public final boolean v6;

        private C0012a(boolean z, boolean z2) {
            this.v4 = z;
            this.v6 = z2;
        }
    }

    private static void a(C0012a aVar) {
        if (aVar != null) {
            e = aVar;
            return;
        }
        throw new IllegalArgumentException();
    }

    private void b(C0012a aVar) {
        if (aVar != null) {
            this.f = aVar;
            return;
        }
        throw new IllegalArgumentException();
    }

    private C0012a b() {
        return this.f;
    }

    protected a(d dVar) {
        SecureRandom secureRandom;
        this.h = new b(this);
        this.b = new Random();
        this.d = new com.bonree.sdk.bq.c();
        this.f = e;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException unused) {
            secureRandom = new SecureRandom();
        }
        this.i = secureRandom;
        this.c = dVar;
    }

    protected a() {
        this(g);
    }

    private com.bonree.sdk.bl.c a(String str, v.b bVar, v.a aVar) throws IOException {
        return a(new com.bonree.sdk.bj.c((CharSequence) str, bVar, aVar));
    }

    private com.bonree.sdk.bl.c a(com.bonree.sdk.bk.a aVar, v.b bVar) throws IOException {
        return a(new com.bonree.sdk.bj.c(aVar, bVar, v.a.IN));
    }

    private com.bonree.sdk.bl.c a(CharSequence charSequence, v.b bVar) throws IOException {
        return a(new com.bonree.sdk.bj.c(charSequence, bVar, v.a.IN));
    }

    private com.bonree.sdk.bl.c a(com.bonree.sdk.bj.c cVar) throws IOException {
        return a(c(cVar));
    }

    private i<com.bonree.sdk.bl.c, IOException> b(CharSequence charSequence, v.b bVar) {
        return b(c(new com.bonree.sdk.bj.c(charSequence, bVar, v.a.IN)));
    }

    private i<com.bonree.sdk.bl.c, IOException> b(com.bonree.sdk.bj.c cVar) {
        return b(c(cVar));
    }

    /* access modifiers changed from: protected */
    public i<com.bonree.sdk.bl.c, IOException> b(a.C0014a aVar) {
        i.b bVar = new i.b();
        try {
            bVar.b(a(aVar));
            return bVar;
        } catch (IOException e2) {
            bVar.a(e2);
            return bVar;
        }
    }

    private com.bonree.sdk.bl.c a(com.bonree.sdk.bj.c cVar, InetAddress inetAddress, int i2) throws IOException {
        return a(d(cVar), inetAddress, i2);
    }

    public final com.bonree.sdk.bl.c a(com.bonree.sdk.bj.a aVar, InetAddress inetAddress, int i2) throws IOException {
        d dVar = this.c;
        com.bonree.sdk.bl.a a2 = dVar == null ? null : dVar.a(aVar);
        if (a2 != null) {
            return a2;
        }
        com.bonree.sdk.bj.c b2 = aVar.b();
        Level level = Level.FINE;
        Logger logger = a;
        logger.log(level, "Asking {0} on {1} for {2} with:\n{3}", new Object[]{inetAddress, Integer.valueOf(i2), b2, aVar});
        try {
            com.bonree.sdk.bl.c a3 = this.d.a(aVar, inetAddress, i2);
            logger.log(level, "Response from {0} on {1} for {2}:\n{3}", new Object[]{inetAddress, Integer.valueOf(i2), b2, a3});
            this.h.a(aVar, a3);
            return a3;
        } catch (IOException e2) {
            a.log(level, "IOException {0} on {1} while resolving {2}: {3}", new Object[]{inetAddress, Integer.valueOf(i2), b2, e2});
            throw e2;
        }
    }

    private i<com.bonree.sdk.bl.c, IOException> b(com.bonree.sdk.bj.a aVar, InetAddress inetAddress, int i2) {
        d dVar = this.c;
        com.bonree.sdk.bl.a a2 = dVar == null ? null : dVar.a(aVar);
        if (a2 != null) {
            return i.a(a2);
        }
        com.bonree.sdk.bj.c b2 = aVar.b();
        a.log(Level.FINE, "Asynchronusly asking {0} on {1} for {2} with:\n{3}", new Object[]{inetAddress, 53, b2, aVar});
        return this.d.b(aVar, inetAddress, 53);
    }

    protected static boolean a(com.bonree.sdk.bj.c cVar, com.bonree.sdk.bl.c cVar2) {
        for (v<? extends h> a2 : cVar2.a.l) {
            if (a2.a(cVar)) {
                return true;
            }
        }
        return false;
    }

    private a.C0014a c(com.bonree.sdk.bj.c cVar) {
        a.C0014a f2 = com.bonree.sdk.bj.a.f();
        f2.b(cVar);
        f2.a(this.i.nextInt());
        return c(f2);
    }

    private com.bonree.sdk.bl.c a(String str, v.b bVar, v.a aVar, InetAddress inetAddress, int i2) throws IOException {
        return a(new com.bonree.sdk.bj.c((CharSequence) str, bVar, aVar), inetAddress, i2);
    }

    private com.bonree.sdk.bl.c a(String str, v.b bVar, v.a aVar, InetAddress inetAddress) throws IOException {
        return a(new com.bonree.sdk.bj.c((CharSequence) str, bVar, aVar), inetAddress);
    }

    private com.bonree.sdk.bl.c a(String str, v.b bVar, InetAddress inetAddress) throws IOException {
        return a(new com.bonree.sdk.bj.c((CharSequence) str, bVar, v.a.IN), inetAddress);
    }

    public final com.bonree.sdk.bl.c a(com.bonree.sdk.bj.a aVar, InetAddress inetAddress) throws IOException {
        return a(aVar, inetAddress, 53);
    }

    private com.bonree.sdk.bl.c a(com.bonree.sdk.bj.c cVar, InetAddress inetAddress) throws IOException {
        return a(cVar, inetAddress, 53);
    }

    public final b a() {
        return this.d;
    }

    private void a(b bVar) {
        if (bVar != null) {
            this.d = bVar;
            return;
        }
        throw new IllegalArgumentException();
    }

    private d c() {
        return this.c;
    }

    private com.bonree.sdk.bj.a d(com.bonree.sdk.bj.c cVar) {
        return c(cVar).b();
    }

    private <D extends h> Set<D> b(com.bonree.sdk.bk.a aVar, v.b bVar) {
        if (this.c == null) {
            return Collections.emptySet();
        }
        com.bonree.sdk.bj.c cVar = new com.bonree.sdk.bj.c(aVar, bVar);
        com.bonree.sdk.bl.a a2 = this.c.a(d(cVar));
        if (a2 == null) {
            return Collections.emptySet();
        }
        return a2.a.a(cVar);
    }

    private Set<m> a(com.bonree.sdk.bk.a aVar) {
        return b(aVar, v.b.NS);
    }

    private Set<com.bonree.sdk.bp.a> b(com.bonree.sdk.bk.a aVar) {
        return b(aVar, v.b.A);
    }

    private Set<com.bonree.sdk.bp.b> c(com.bonree.sdk.bk.a aVar) {
        return b(aVar, v.b.AAAA);
    }

    private Set<com.bonree.sdk.bp.a> d(com.bonree.sdk.bk.a aVar) {
        return c(aVar, v.b.A);
    }

    private Set<com.bonree.sdk.bp.b> e(com.bonree.sdk.bk.a aVar) {
        return c(aVar, v.b.AAAA);
    }

    public final i<com.bonree.sdk.bl.c, IOException> b(com.bonree.sdk.bj.a aVar, InetAddress inetAddress) {
        d dVar = this.c;
        com.bonree.sdk.bl.a a2 = dVar == null ? null : dVar.a(aVar);
        if (a2 != null) {
            return i.a(a2);
        }
        com.bonree.sdk.bj.c b2 = aVar.b();
        a.log(Level.FINE, "Asynchronusly asking {0} on {1} for {2} with:\n{3}", new Object[]{inetAddress, 53, b2, aVar});
        return this.d.b(aVar, inetAddress, 53);
    }

    private <D extends h> Set<D> c(com.bonree.sdk.bk.a aVar, v.b bVar) {
        Set set;
        Set<m> b2 = b(aVar, v.b.NS);
        if (b2.isEmpty()) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(b2.size() * 3);
        for (m mVar : b2) {
            int i2 = c.a[bVar.ordinal()];
            if (i2 == 1) {
                set = b(mVar.a, v.b.A);
            } else if (i2 == 2) {
                set = b(mVar.a, v.b.AAAA);
            } else {
                throw new AssertionError();
            }
            hashSet.addAll(set);
        }
        return hashSet;
    }
}
