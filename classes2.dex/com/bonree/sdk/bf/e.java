package com.bonree.sdk.bf;

import com.bonree.sdk.bf.a;
import com.bonree.sdk.bf.h;
import com.bonree.sdk.bj.a;
import com.bonree.sdk.bm.b;
import com.bonree.sdk.bm.c;
import com.bonree.sdk.bm.d;
import com.bonree.sdk.bp.v;
import com.bonree.sdk.br.g;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class e extends a {
    private static List<d> g = new CopyOnWriteArrayList();
    private static Set<Inet4Address> h = new CopyOnWriteArraySet();
    private static Set<Inet6Address> i = new CopyOnWriteArraySet();
    private static final Set<String> j = Collections.newSetFromMap(new ConcurrentHashMap(4));
    private static /* synthetic */ boolean o = true;
    private final Set<InetAddress> k = Collections.newSetFromMap(new ConcurrentHashMap(4));
    private boolean l = false;
    private boolean m = false;
    private boolean n = true;

    static {
        a(b.b);
        a(c.b);
        a(com.bonree.sdk.bm.e.b);
        try {
            h.add(g.a((CharSequence) "8.8.8.8"));
        } catch (IllegalArgumentException e) {
            a.log(Level.WARNING, "Could not add static IPv4 DNS Server", e);
        }
        try {
            i.add(g.b("[2001:4860:4860::8888]"));
        } catch (IllegalArgumentException e2) {
            a.log(Level.WARNING, "Could not add static IPv6 DNS Server", e2);
        }
    }

    public e() {
    }

    private e(d dVar) {
        super(dVar);
    }

    /* access modifiers changed from: protected */
    public final a.C0014a c(a.C0014a aVar) {
        aVar.c(true);
        aVar.a().a(this.d.b()).a(this.l);
        return aVar;
    }

    private List<InetAddress> b() {
        InetAddress inetAddress;
        List<InetAddress> d = d();
        if (this.n) {
            InetAddress inetAddress2 = null;
            int i2 = f.a[this.f.ordinal()];
            if (i2 == 1) {
                inetAddress = h();
                inetAddress2 = i();
            } else if (i2 == 2) {
                inetAddress = i();
                inetAddress2 = h();
            } else if (i2 == 3) {
                inetAddress = h();
            } else if (i2 == 4) {
                inetAddress = i();
            } else {
                throw new AssertionError("Unknown ipVersionSetting: " + this.f);
            }
            d.add(inetAddress);
            if (inetAddress2 != null) {
                d.add(inetAddress2);
            }
        }
        return d;
    }

    public final com.bonree.sdk.bl.c a(a.C0014a aVar) throws IOException {
        int i2;
        a b = c(aVar).b();
        com.bonree.sdk.bl.a a = this.c == null ? null : this.c.a(b);
        if (a != null) {
            return a;
        }
        List<InetAddress> b2 = b();
        ArrayList arrayList = new ArrayList(b2.size());
        for (InetAddress next : b2) {
            if (this.k.contains(next)) {
                a.finer("Skipping " + next + " because it was marked as \"recursion not available\"");
            } else {
                try {
                    com.bonree.sdk.bl.c a2 = a(b, next, 53);
                    a aVar2 = a2.a;
                    if (!aVar2.h) {
                        if (this.k.add(next)) {
                            a.warning("The DNS server " + next + " returned a response without the \"recursion available\" (RA) flag set. This likely indicates a misconfiguration because the server is not suitable for DNS resolution");
                        }
                    } else if (this.m || (i2 = f.b[aVar2.c.ordinal()]) == 1 || i2 == 2) {
                        return a2;
                    } else {
                        String str = "Response from " + next + " asked for " + b.b() + " with error code: " + aVar2.c + '.';
                        if (!a.isLoggable(Level.FINE)) {
                            str = str + "\n" + aVar2;
                        }
                        a.warning(str);
                        arrayList.add(new h.a(b, a2));
                    }
                } catch (IOException e) {
                    arrayList.add(e);
                }
            }
        }
        com.bonree.sdk.br.h.a((List<? extends IOException>) arrayList);
        throw new h.c(b);
    }

    /* access modifiers changed from: protected */
    public final i<com.bonree.sdk.bl.c, IOException> b(a.C0014a aVar) {
        a b = c(aVar).b();
        com.bonree.sdk.bl.a a = this.c == null ? null : this.c.a(b);
        if (a != null) {
            return i.a(a);
        }
        List<InetAddress> b2 = b();
        Iterator<InetAddress> it = b2.iterator();
        while (it.hasNext()) {
            InetAddress next = it.next();
            if (this.k.contains(next)) {
                it.remove();
                Logger logger = a;
                logger.finer("Skipping " + next + " because it was marked as \"recursion not available\"");
            }
        }
        ArrayList arrayList = new ArrayList(b2.size());
        for (InetAddress b3 : b2) {
            arrayList.add(b(b, b3));
        }
        return i.a(arrayList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        if (o != false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (r2.isEmpty() != false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        r4 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r4.hasNext() == false) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        r5 = r4.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        if (com.bonree.sdk.br.g.c(r5) != false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0050, code lost:
        a.warning("The DNS server lookup mechanism '" + r3.a() + "' returned an invalid non-IP address result: '" + r5 + "'");
        r4.remove();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007a, code lost:
        if (j.contains(r5) == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007c, code lost:
        a.fine("The DNS server lookup mechanism '" + r3.a() + "' returned a blacklisted result: '" + r5 + "'");
        r4.remove();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (r2.isEmpty() == false) goto L_0x00c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<java.lang.String> c() {
        /*
            java.util.List<com.bonree.sdk.bm.d> r0 = g
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0007:
            r2 = r1
        L_0x0008:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00c2
            java.lang.Object r3 = r0.next()
            com.bonree.sdk.bm.d r3 = (com.bonree.sdk.bm.d) r3
            java.util.List r2 = r3.c()     // Catch:{ SecurityException -> 0x0019 }
            goto L_0x0023
        L_0x0019:
            r4 = move-exception
            java.util.logging.Logger r5 = a
            java.util.logging.Level r6 = java.util.logging.Level.WARNING
            java.lang.String r7 = "Could not lookup DNS server"
            r5.log(r6, r7, r4)
        L_0x0023:
            if (r2 == 0) goto L_0x0008
            boolean r4 = o
            if (r4 != 0) goto L_0x0036
            boolean r4 = r2.isEmpty()
            if (r4 != 0) goto L_0x0030
            goto L_0x0036
        L_0x0030:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0036:
            java.util.Iterator r4 = r2.iterator()
        L_0x003a:
            boolean r5 = r4.hasNext()
            java.lang.String r6 = "The DNS server lookup mechanism '"
            if (r5 == 0) goto L_0x00a0
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            boolean r7 = com.bonree.sdk.br.g.c(r5)
            java.lang.String r8 = "'"
            if (r7 != 0) goto L_0x0074
            java.util.logging.Logger r7 = a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r6)
            java.lang.String r6 = r3.a()
            r9.append(r6)
            java.lang.String r6 = "' returned an invalid non-IP address result: '"
            r9.append(r6)
            r9.append(r5)
            r9.append(r8)
            java.lang.String r5 = r9.toString()
            r7.warning(r5)
            r4.remove()
            goto L_0x003a
        L_0x0074:
            java.util.Set<java.lang.String> r7 = j
            boolean r7 = r7.contains(r5)
            if (r7 == 0) goto L_0x003a
            java.util.logging.Logger r7 = a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r6)
            java.lang.String r6 = r3.a()
            r9.append(r6)
            java.lang.String r6 = "' returned a blacklisted result: '"
            r9.append(r6)
            r9.append(r5)
            r9.append(r8)
            java.lang.String r5 = r9.toString()
            r7.fine(r5)
            r4.remove()
            goto L_0x003a
        L_0x00a0:
            boolean r4 = r2.isEmpty()
            if (r4 == 0) goto L_0x00c2
            java.util.logging.Logger r2 = a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r6)
            java.lang.String r3 = r3.a()
            r4.append(r3)
            java.lang.String r3 = "' returned not a single valid IP address after sanitazion"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r2.warning(r3)
            goto L_0x0007
        L_0x00c2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.bf.e.c():java.util.List");
    }

    private static List<InetAddress> d() {
        List<String> c = c();
        if (c == null) {
            return new ArrayList();
        }
        a.C0012a aVar = e;
        ArrayList arrayList = null;
        ArrayList arrayList2 = aVar.v4 ? new ArrayList(c.size()) : null;
        if (aVar.v6) {
            arrayList = new ArrayList(c.size());
        }
        int i2 = 0;
        for (String next : c) {
            if (o || g.c(next)) {
                try {
                    InetAddress byName = InetAddress.getByName(next);
                    if (byName instanceof Inet4Address) {
                        if (aVar.v4) {
                            arrayList2.add((Inet4Address) byName);
                        }
                    } else if (!(byName instanceof Inet6Address)) {
                        throw new AssertionError("The address '" + byName + "' is neither of type Inet(4|6)Address");
                    } else if (aVar.v6) {
                        arrayList.add((Inet6Address) byName);
                    }
                    i2++;
                } catch (UnknownHostException e) {
                    Logger logger = a;
                    Level level = Level.SEVERE;
                    logger.log(level, "Could not transform '" + next + "' to InetAddress", e);
                }
            } else {
                throw new AssertionError();
            }
        }
        ArrayList arrayList3 = new ArrayList(i2);
        int i3 = f.a[aVar.ordinal()];
        if (i3 == 1) {
            arrayList3.addAll(arrayList2);
            arrayList3.addAll(arrayList);
        } else if (i3 == 2) {
            arrayList3.addAll(arrayList);
            arrayList3.addAll(arrayList2);
        } else if (i3 == 3) {
            arrayList3.addAll(arrayList2);
        } else if (i3 == 4) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    private static void a(d dVar) {
        if (!dVar.d()) {
            Logger logger = a;
            logger.fine("Not adding " + dVar.a() + " as it is not available.");
            return;
        }
        synchronized (g) {
            ArrayList arrayList = new ArrayList(g.size() + 1);
            arrayList.addAll(g);
            arrayList.add(dVar);
            Collections.sort(arrayList);
            g.clear();
            g.addAll(arrayList);
        }
    }

    private static boolean b(d dVar) {
        boolean remove;
        synchronized (g) {
            remove = g.remove(dVar);
        }
        return remove;
    }

    private static boolean a(String str) {
        return j.add(str);
    }

    private static boolean b(String str) {
        return j.remove(str);
    }

    private boolean e() {
        return this.l;
    }

    private void a(boolean z) {
        this.l = z;
    }

    private boolean f() {
        return this.m;
    }

    private void b(boolean z) {
        this.m = z;
    }

    private boolean g() {
        return this.n;
    }

    private void c(boolean z) {
        this.n = z;
    }

    private InetAddress h() {
        return (InetAddress) com.bonree.sdk.ak.a.a(h, this.b);
    }

    private InetAddress i() {
        return (InetAddress) com.bonree.sdk.ak.a.a(i, this.b);
    }

    private static com.bonree.sdk.bj.c a(com.bonree.sdk.bk.a aVar) {
        return new com.bonree.sdk.bj.c(aVar, v.b.PTR);
    }

    private static com.bonree.sdk.bj.c a(Inet4Address inet4Address) {
        return a(com.bonree.sdk.bk.a.a(g.a(inet4Address), com.bonree.sdk.bk.a.b));
    }

    private static com.bonree.sdk.bj.c a(Inet6Address inet6Address) {
        return a(com.bonree.sdk.bk.a.a(g.a(inet6Address), com.bonree.sdk.bk.a.c));
    }

    private static com.bonree.sdk.bj.c a(InetAddress inetAddress) {
        if (inetAddress instanceof Inet4Address) {
            return a(com.bonree.sdk.bk.a.a(g.a((Inet4Address) inetAddress), com.bonree.sdk.bk.a.b));
        }
        if (inetAddress instanceof Inet6Address) {
            return a(com.bonree.sdk.bk.a.a(g.a((Inet6Address) inetAddress), com.bonree.sdk.bk.a.c));
        }
        throw new IllegalArgumentException("The provided inetAddress '" + inetAddress + "' is neither of type Inet4Address nor Inet6Address");
    }
}
