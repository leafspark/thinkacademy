package com.bonree.sdk.ar;

import android.text.TextUtils;
import com.bonree.sdk.agent.business.entity.NetworkEventInfoBean;
import com.bonree.sdk.agent.business.util.g;
import com.bonree.sdk.be.a;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.u;
import com.bonree.sdk.d.a;
import com.bonree.sdk.m.n;
import com.bonree.sdk.n.b;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class d {
    private static f a = a.a();

    static n a(b bVar, Map<String, g> map) {
        String f = bVar.f();
        n a2 = a(u.c(f), bVar, f.startsWith("https://"), map);
        if (a2 != null) {
            return a2;
        }
        if (bVar.a().isEmpty()) {
            return null;
        }
        Iterator<String> it = bVar.a().iterator();
        while (true) {
            if (it.hasNext()) {
                a2 = a(it.next(), bVar, f.startsWith("https://"), map);
                if (a2 != null) {
                    a.c("data ip get socketData", new Object[0]);
                    break;
                }
            } else {
                break;
            }
        }
        return a2;
    }

    private static n a(String str, b bVar, boolean z, Map<String, g> map) {
        g gVar;
        n a2;
        n a3;
        n a4;
        if (!TextUtils.isEmpty(bVar.L())) {
            str = bVar.L();
        }
        if (str == null || !map.containsKey(str) || (gVar = map.get(str)) == null) {
            return null;
        }
        gVar.a(true);
        Map<Long, n> c = gVar.c();
        if (c == null) {
            return null;
        }
        for (n next : c.values()) {
            if (!a(next, bVar, z) && next.x() != null && next.x().contains(Long.valueOf(bVar.b())) && (a4 = a(next, bVar)) != null) {
                a.c(" start time equal", new Object[0]);
                return a4;
            }
        }
        for (n next2 : c.values()) {
            if (!a(next2, bVar, z) && next2.v().contains(Long.valueOf(bVar.I())) && (a3 = a(next2, bVar)) != null) {
                a.c(" thread id contails", new Object[0]);
                return a3;
            }
        }
        if (c.size() == 1) {
            for (n next3 : c.values()) {
                if (!a(next3, bVar, z) && (a2 = a(next3, bVar)) != null) {
                    a.c(" this domain is one", new Object[0]);
                    return a2;
                }
            }
        }
        return a(c, bVar, z);
    }

    private static n a(n nVar, b bVar) {
        long j;
        long j2;
        int i;
        int i2;
        long j3;
        long j4;
        int i3;
        long j5;
        long j6;
        List<com.bonree.sdk.l.b> a2 = nVar.a();
        List<a.b> b = nVar.b();
        if (nVar.g() <= bVar.b() || nVar.h() >= bVar.c()) {
            i = 0;
            j2 = 0;
            j = 0;
        } else {
            long g = nVar.g();
            long h = nVar.h();
            i = (int) nVar.e();
            j2 = g;
            j = h;
        }
        if (b == null || b.isEmpty()) {
            i2 = 0;
            j4 = 0;
            j3 = 0;
        } else {
            int i4 = 0;
            int i5 = 0;
            boolean z = false;
            long j7 = 0;
            long j8 = 0;
            while (true) {
                if (i4 < b.size()) {
                    if (bVar.l() > 0 && bVar.l() <= ((long) i5)) {
                        a.c("receive body big", new Object[0]);
                        break;
                    }
                    if (b.get(i4).b() >= bVar.b() && b.get(i4).b() <= bVar.c()) {
                        if (j7 == 0 || (j7 > b.get(i4).b() && b.get(i4).b() > 0)) {
                            j7 = b.get(i4).b();
                        }
                        if (j8 < b.get(i4).b()) {
                            j8 = b.get(i4).b();
                        }
                        i5 += b.get(i4).a();
                        z = true;
                    } else if (b.get(i4).b() >= bVar.b() && z) {
                        if (!b.get(i4).c()) {
                            a.c("receive time again send", new Object[0]);
                            break;
                        } else if (j8 < b.get(i4).b()) {
                            j8 = b.get(i4).b();
                            i5 += b.get(i4).a();
                        }
                    }
                    i4++;
                } else {
                    break;
                }
            }
            i2 = i5;
            j4 = j7;
            j3 = j8;
        }
        if (a2 == null || a2.isEmpty()) {
            i3 = 0;
            j6 = 0;
            j5 = 0;
        } else {
            int i6 = 0;
            long j9 = 0;
            long j10 = 0;
            for (int i7 = 0; i7 < a2.size(); i7++) {
                if (a2.get(i7).b() >= bVar.b() && a2.get(i7).c() <= bVar.c()) {
                    if (j9 == 0 || j9 > a2.get(i7).b()) {
                        j9 = a2.get(i7).b();
                    }
                    if ((j10 == 0 || j10 < j4) && j10 < a2.get(i7).c()) {
                        j10 = a2.get(i7).c();
                    }
                    i6 += a2.get(i7).a();
                }
            }
            i3 = i6;
            j6 = j9;
            j5 = j10;
        }
        if ((i3 <= 0 || i2 <= 0) && !h.a(bVar.f()) && bVar.k() <= 0) {
            return null;
        }
        return a(nVar, j6, j5, j4, j3, i3, i2, i, j2, j);
    }

    private static n a(n nVar, long j, long j2, long j3, long j4, int i, int i2, int i3, long j5, long j6) {
        n nVar2 = new n(nVar);
        n nVar3 = nVar2;
        nVar2.a(j, j2, j3, j4, i, i2, i3, j5, j6);
        return nVar3;
    }

    private static n a(Map<Long, n> map, b bVar, boolean z) {
        for (n next : map.values()) {
            if (!a(next, bVar, z)) {
                return a(next, 0, 0, 0, 0, 0, 0, (int) next.e(), next.g(), next.h());
            }
        }
        return null;
    }

    private static boolean a(n nVar, b bVar, boolean z) {
        if (nVar == null) {
            return true;
        }
        if ((z && nVar.s() == 80) || (!z && nVar.s() == 443)) {
            return true;
        }
        if (nVar.o() < 600 || bVar.k() == nVar.o()) {
            return false;
        }
        return true;
    }

    static void a(NetworkEventInfoBean networkEventInfoBean, String str, b bVar, Map<String, g> map) {
        g gVar;
        if ((bVar.c() - bVar.b()) - ((long) (((((networkEventInfoBean.mDnsTimeUs + networkEventInfoBean.mConnectTimeUs) + networkEventInfoBean.mSslTimeUs) + networkEventInfoBean.mRequestTimeUs) + networkEventInfoBean.mResponseTimeUs) + networkEventInfoBean.mDownloadTimeUs)) > 3000000 && str != null && map.containsKey(str) && (gVar = map.get(str)) != null) {
            gVar.a(true);
            Map<Long, n> c = gVar.c();
            if (c != null && !c.isEmpty()) {
                long j = -1;
                long j2 = -1;
                for (n next : c.values()) {
                    if (next != null && bVar.b() <= next.g() && bVar.c() >= next.h() && next.v().contains(Long.valueOf(bVar.I()))) {
                        if (j < 0 || j > next.g()) {
                            j = next.g();
                        }
                        if (j2 < 0 || j2 < next.h()) {
                            j2 = next.h();
                        }
                    }
                }
                if (j2 > j) {
                    long j3 = (j2 * 1000) - (j * 1000);
                    if (j3 > ((long) networkEventInfoBean.mConnectTimeUs)) {
                        a.c("javaconnectTime:" + j3 + "   one :" + networkEventInfoBean.mConnectTimeUs, new Object[0]);
                        if ((bVar.c() - bVar.b()) - j3 > 0) {
                            networkEventInfoBean.mConnectTimeUs = (int) j3;
                        }
                    }
                }
            }
        }
    }

    private static void b(NetworkEventInfoBean networkEventInfoBean, String str, b bVar, Map<String, g> map) {
        g gVar;
        if (str != null && map.containsKey(str) && (gVar = map.get(str)) != null) {
            gVar.a(true);
            Map<Long, n> c = gVar.c();
            if (c != null && !c.isEmpty()) {
                long j = -1;
                long j2 = -1;
                for (n next : c.values()) {
                    if (next != null && bVar.b() <= next.g() && bVar.c() >= next.h() && next.v().contains(Long.valueOf(bVar.I()))) {
                        if (j < 0 || j > next.g()) {
                            j = next.g();
                        }
                        if (j2 < 0 || j2 < next.h()) {
                            j2 = next.h();
                        }
                    }
                }
                a(networkEventInfoBean, j, j2, bVar);
            }
        }
    }

    private static void a(NetworkEventInfoBean networkEventInfoBean, long j, long j2, b bVar) {
        if (j2 > j) {
            long j3 = (j2 * 1000) - (j * 1000);
            if (j3 > ((long) networkEventInfoBean.mConnectTimeUs)) {
                f fVar = a;
                fVar.c("javaconnectTime:" + j3 + "   one :" + networkEventInfoBean.mConnectTimeUs, new Object[0]);
                if ((bVar.c() - bVar.b()) - j3 > 0) {
                    networkEventInfoBean.mConnectTimeUs = (int) j3;
                }
            }
        }
    }
}
