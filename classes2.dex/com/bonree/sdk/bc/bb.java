package com.bonree.sdk.bc;

import com.facebook.soloader.MinElf;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class bb implements Cloneable {
    private static int d = 65535;
    private static int k = 0;
    private static int l = 1;
    private static int m = 2;
    private static int n = 3;
    private static int o = 4;
    private static ca[] p = new ca[0];
    private static bx[] q = new bx[0];
    int a;
    int b;
    int c;
    private ai e;
    private List[] f;
    private int g;
    private cx h;
    private cy i;
    private int j;

    private bb(ai aiVar) {
        this.f = new List[4];
        this.e = aiVar;
    }

    public bb(int i2) {
        this(new ai(i2));
    }

    public bb() {
        this(new ai());
    }

    public static bb a(ca caVar) {
        bb bbVar = new bb();
        bbVar.e.c(0);
        bbVar.e.a(7);
        bbVar.a(caVar, 0);
        return bbVar;
    }

    private static bb a(bn bnVar) {
        return new dm(bnVar);
    }

    private bb(t tVar) throws IOException {
        this(new ai(tVar));
        boolean z = this.e.d() == 5;
        boolean b2 = this.e.b(6);
        int i2 = 0;
        while (i2 < 4) {
            try {
                int f2 = this.e.f(i2);
                if (f2 > 0) {
                    this.f[i2] = new ArrayList(f2);
                }
                for (int i3 = 0; i3 < f2; i3++) {
                    int a2 = tVar.a();
                    ca a3 = ca.a(tVar, i2, z);
                    this.f[i2].add(a3);
                    if (i2 == 3) {
                        if (a3.p() == 250) {
                            this.a = a2;
                        }
                        if (a3.p() == 24 && ((cj) a3).l() == 0) {
                            this.c = a2;
                        }
                    }
                }
                i2++;
            } catch (Cdo e2) {
                if (!b2) {
                    throw e2;
                }
            }
        }
        this.g = tVar.a();
    }

    public bb(byte[] bArr) throws IOException {
        this(new t(bArr));
    }

    private void a(ai aiVar) {
        this.e = aiVar;
    }

    public final ai a() {
        return this.e;
    }

    public final void a(ca caVar, int i2) {
        List[] listArr = this.f;
        if (listArr[i2] == null) {
            listArr[i2] = new LinkedList();
        }
        this.e.d(i2);
        this.f[i2].add(caVar);
    }

    private boolean b(ca caVar, int i2) {
        List[] listArr = this.f;
        if (listArr[i2] == null || !listArr[i2].remove(caVar)) {
            return false;
        }
        this.e.e(i2);
        return true;
    }

    private void d(int i2) {
        this.f[i2] = null;
        this.e.a(i2, 0);
    }

    private boolean c(ca caVar, int i2) {
        List[] listArr = this.f;
        return listArr[i2] != null && listArr[i2].contains(caVar);
    }

    private boolean b(ca caVar) {
        for (int i2 = 1; i2 <= 3; i2++) {
            List[] listArr = this.f;
            if (listArr[i2] != null && listArr[i2].contains(caVar)) {
                return true;
            }
        }
        return false;
    }

    private boolean a(bn bnVar, int i2, int i3) {
        if (this.f[i3] == null) {
            return false;
        }
        for (int i4 = 0; i4 < this.f[i3].size(); i4++) {
            ca caVar = (ca) this.f[i3].get(i4);
            if (caVar.p() == i2 && bnVar.equals(caVar.o())) {
                return true;
            }
        }
        return false;
    }

    private boolean a(bn bnVar, int i2) {
        if (a(bnVar, i2, 1) || a(bnVar, i2, 2) || a(bnVar, i2, 3)) {
            return true;
        }
        return false;
    }

    public final ca b() {
        List list = this.f[0];
        if (list == null || list.size() == 0) {
            return null;
        }
        return (ca) list.get(0);
    }

    public final cy c() {
        int f2 = this.e.f(3);
        if (f2 == 0) {
            return null;
        }
        ca caVar = (ca) this.f[3].get(f2 - 1);
        if (caVar.g != 250) {
            return null;
        }
        return (cy) caVar;
    }

    private boolean h() {
        int i2 = this.b;
        return i2 == 3 || i2 == 1 || i2 == 4;
    }

    public final boolean d() {
        return this.b == 1;
    }

    public final bp e() {
        ca[] a2 = a(3);
        for (int i2 = 0; i2 < a2.length; i2++) {
            if (a2[i2] instanceof bp) {
                return (bp) a2[i2];
            }
        }
        return null;
    }

    public final int f() {
        int c2 = this.e.c();
        bp e2 = e();
        return e2 != null ? c2 + (e2.e() << 4) : c2;
    }

    public final ca[] a(int i2) {
        List[] listArr = this.f;
        if (listArr[i2] == null) {
            return p;
        }
        List list = listArr[i2];
        return (ca[]) list.toArray(new ca[list.size()]);
    }

    private static boolean a(ca caVar, ca caVar2) {
        return caVar.q() == caVar2.q() && caVar.r() == caVar2.r() && caVar.o().equals(caVar2.o());
    }

    public final bx[] b(int i2) {
        if (this.f[i2] == null) {
            return q;
        }
        LinkedList linkedList = new LinkedList();
        ca[] a2 = a(i2);
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < a2.length; i3++) {
            bn o2 = a2[i3].o();
            boolean z = true;
            if (hashSet.contains(o2)) {
                int size = linkedList.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    bx bxVar = (bx) linkedList.get(size);
                    if (bxVar.i().q() == a2[i3].q() && bxVar.i().r() == a2[i3].r() && bxVar.i().o().equals(o2)) {
                        bxVar.a(a2[i3]);
                        z = false;
                        break;
                    }
                    size--;
                }
            }
            if (z) {
                linkedList.add(new bx(a2[i3]));
                hashSet.add(o2);
            }
        }
        return (bx[]) linkedList.toArray(new bx[linkedList.size()]);
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar) {
        this.e.a(vVar);
        m mVar = new m();
        for (int i2 = 0; i2 < 4; i2++) {
            if (this.f[i2] != null) {
                for (int i3 = 0; i3 < this.f[i2].size(); i3++) {
                    ((ca) this.f[i2].get(i3)).a(vVar, i2, mVar);
                }
            }
        }
    }

    private int a(v vVar, int i2, m mVar, int i3) {
        int size = this.f[i2].size();
        int a2 = vVar.a();
        ca caVar = null;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            ca caVar2 = (ca) this.f[i2].get(i6);
            if (i2 != 3 || !(caVar2 instanceof bp)) {
                if (caVar != null) {
                    if (!(caVar2.q() == caVar.q() && caVar2.r() == caVar.r() && caVar2.o().equals(caVar.o()))) {
                        a2 = vVar.a();
                        i5 = i6;
                    }
                }
                caVar2.a(vVar, i2, mVar);
                if (vVar.a() > i3) {
                    vVar.a(a2);
                    return (size - i5) + i4;
                }
                caVar = caVar2;
            } else {
                i4++;
            }
        }
        return i4;
    }

    private boolean a(v vVar, int i2) {
        byte[] bArr;
        v vVar2 = vVar;
        int i3 = i2;
        int i4 = 0;
        if (i3 < 12) {
            return false;
        }
        cx cxVar = this.h;
        if (cxVar != null) {
            i3 -= cxVar.a();
        }
        bp e2 = e();
        ca caVar = null;
        if (e2 != null) {
            v vVar3 = new v();
            e2.a(vVar3, 3, (m) null);
            bArr = vVar3.d();
            i3 -= bArr.length;
        } else {
            bArr = null;
        }
        int a2 = vVar.a();
        this.e.a(vVar2);
        m mVar = new m();
        int e3 = this.e.e();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= 4) {
                break;
            }
            List[] listArr = this.f;
            if (listArr[i5] != null) {
                int size = listArr[i5].size();
                int a3 = vVar.a();
                int i7 = i4;
                int i8 = i7;
                int i9 = i8;
                ca caVar2 = caVar;
                while (true) {
                    if (i7 >= size) {
                        break;
                    }
                    ca caVar3 = (ca) this.f[i5].get(i7);
                    if (i5 != 3 || !(caVar3 instanceof bp)) {
                        if (caVar2 != null) {
                            if (!(caVar3.q() == caVar2.q() && caVar3.r() == caVar2.r() && caVar3.o().equals(caVar2.o()))) {
                                a3 = vVar.a();
                                i9 = i7;
                            }
                        }
                        caVar3.a(vVar2, i5, mVar);
                        if (vVar.a() > i3) {
                            vVar2.a(a3);
                            i8 = (size - i9) + i8;
                            break;
                        }
                        caVar2 = caVar3;
                    } else {
                        i8++;
                    }
                    i7++;
                }
                if (i8 == 0 || i5 == 3) {
                    i4 = 0;
                    if (i5 == 3) {
                        i6 = this.e.f(i5) - i8;
                    }
                } else {
                    e3 = ai.a(e3, 6, true);
                    int i10 = a2 + 4;
                    vVar2.a(this.e.f(i5) - i8, (i5 * 2) + i10);
                    for (int i11 = i5 + 1; i11 < 3; i11++) {
                        vVar2.a(0, (i11 * 2) + i10);
                    }
                }
            }
            i5++;
            caVar = null;
        }
        if (bArr != null) {
            vVar2.a(bArr);
            i6++;
        }
        if (e3 != this.e.e()) {
            vVar2.a(e3, a2 + 2);
        }
        if (i6 != this.e.f(3)) {
            vVar2.a(i6, a2 + 10);
        }
        cx cxVar2 = this.h;
        if (cxVar2 == null) {
            return true;
        }
        cxVar2.a(this, vVar.d(), this.j, this.i).a(vVar2, 3, mVar);
        vVar2.a(i6 + 1, a2 + 10);
        return true;
    }

    public final byte[] g() {
        v vVar = new v();
        a(vVar);
        this.g = vVar.a();
        return vVar.d();
    }

    public final byte[] c(int i2) {
        byte[] bArr;
        v vVar = new v();
        cx cxVar = this.h;
        int i3 = MinElf.PN_XNUM;
        if (cxVar != null) {
            i3 = MinElf.PN_XNUM - cxVar.a();
        }
        bp e2 = e();
        ca caVar = null;
        if (e2 != null) {
            v vVar2 = new v();
            e2.a(vVar2, 3, (m) null);
            bArr = vVar2.d();
            i3 -= bArr.length;
        } else {
            bArr = null;
        }
        int a2 = vVar.a();
        this.e.a(vVar);
        m mVar = new m();
        int e3 = this.e.e();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= 4) {
                break;
            }
            List[] listArr = this.f;
            if (listArr[i4] != null) {
                int size = listArr[i4].size();
                int a3 = vVar.a();
                ca caVar2 = caVar;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                while (true) {
                    if (i6 >= size) {
                        break;
                    }
                    ca caVar3 = (ca) this.f[i4].get(i6);
                    if (i4 != 3 || !(caVar3 instanceof bp)) {
                        if (caVar2 != null) {
                            if (!(caVar3.q() == caVar2.q() && caVar3.r() == caVar2.r() && caVar3.o().equals(caVar2.o()))) {
                                a3 = vVar.a();
                                i8 = i6;
                            }
                        }
                        caVar3.a(vVar, i4, mVar);
                        if (vVar.a() > i3) {
                            vVar.a(a3);
                            i7 = (size - i8) + i7;
                            break;
                        }
                        caVar2 = caVar3;
                    } else {
                        i7++;
                    }
                    i6++;
                }
                if (i7 != 0 && i4 != 3) {
                    e3 = ai.a(e3, 6, true);
                    int i9 = a2 + 4;
                    vVar.a(this.e.f(i4) - i7, (i4 * 2) + i9);
                    for (int i10 = i4 + 1; i10 < 3; i10++) {
                        vVar.a(0, (i10 * 2) + i9);
                    }
                } else if (i4 == 3) {
                    i5 = this.e.f(i4) - i7;
                }
            }
            i4++;
            caVar = null;
        }
        if (bArr != null) {
            vVar.a(bArr);
            i5++;
        }
        if (e3 != this.e.e()) {
            vVar.a(e3, a2 + 2);
        }
        if (i5 != this.e.f(3)) {
            vVar.a(i5, a2 + 10);
        }
        cx cxVar2 = this.h;
        if (cxVar2 != null) {
            cxVar2.a(this, vVar.d(), this.j, this.i).a(vVar, 3, mVar);
            vVar.a(i5 + 1, a2 + 10);
        }
        this.g = vVar.a();
        return vVar.d();
    }

    private void a(cx cxVar, int i2, cy cyVar) {
        this.h = cxVar;
        this.j = i2;
        this.i = cyVar;
    }

    private int i() {
        return this.g;
    }

    private String e(int i2) {
        if (i2 > 3) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        ca[] a2 = a(i2);
        for (ca caVar : a2) {
            if (i2 == 0) {
                stringBuffer.append(";;\t" + caVar.f);
                stringBuffer.append(", type = " + df.b(caVar.g));
                stringBuffer.append(", class = " + p.b(caVar.h));
            } else {
                stringBuffer.append(caVar);
            }
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (e() != null) {
            stringBuffer.append(this.e.g(f()) + "\n");
        } else {
            stringBuffer.append(this.e + "\n");
        }
        int i2 = this.b;
        boolean z = true;
        if (!(i2 == 3 || i2 == 1 || i2 == 4)) {
            z = false;
        }
        if (z) {
            stringBuffer.append(";; TSIG ");
            if (d()) {
                stringBuffer.append("ok");
            } else {
                stringBuffer.append("invalid");
            }
            stringBuffer.append(10);
        }
        for (int i3 = 0; i3 < 4; i3++) {
            if (this.e.d() != 5) {
                stringBuffer.append(";; " + co.b(i3) + ":\n");
            } else {
                stringBuffer.append(";; " + co.c(i3) + ":\n");
            }
            stringBuffer.append(e(i3) + "\n");
        }
        stringBuffer.append(";; Message size: " + this.g + " bytes");
        return stringBuffer.toString();
    }

    public Object clone() {
        bb bbVar = new bb();
        int i2 = 0;
        while (true) {
            List[] listArr = this.f;
            if (i2 < listArr.length) {
                if (listArr[i2] != null) {
                    bbVar.f[i2] = new LinkedList(this.f[i2]);
                }
                i2++;
            } else {
                bbVar.e = (ai) this.e.clone();
                bbVar.g = this.g;
                return bbVar;
            }
        }
    }
}
