package com.bonree.sdk.bc;

import com.bonree.sdk.bc.dd;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;

final class dg implements Serializable {
    private static final long a = -125354057735389003L;
    private TreeSet b;

    private dg() {
        this.b = new TreeSet();
    }

    public dg(int[] iArr) {
        this();
        for (int i = 0; i < iArr.length; i++) {
            df.a(iArr[i]);
            this.b.add(new Integer(iArr[i]));
        }
    }

    public dg(t tVar) throws Cdo {
        this();
        while (tVar.b() > 0) {
            if (tVar.b() >= 2) {
                int g = tVar.g();
                if (g >= -1) {
                    int g2 = tVar.g();
                    if (g2 <= tVar.b()) {
                        for (int i = 0; i < g2; i++) {
                            int g3 = tVar.g();
                            if (g3 != 0) {
                                for (int i2 = 0; i2 < 8; i2++) {
                                    if (((1 << (7 - i2)) & g3) != 0) {
                                        this.b.add(bc.c((g << 8) + (i << 3) + i2));
                                    }
                                }
                            }
                        }
                    } else {
                        throw new Cdo("invalid bitmap");
                    }
                } else {
                    throw new Cdo("invalid ordering");
                }
            } else {
                throw new Cdo("invalid bitmap descriptor");
            }
        }
    }

    public dg(dd ddVar) throws IOException {
        this();
        while (true) {
            dd.a a2 = ddVar.a();
            if (a2.a()) {
                int a3 = df.a(a2.b);
                if (a3 >= 0) {
                    this.b.add(bc.c(a3));
                } else {
                    throw ddVar.a("Invalid type: " + a2.b);
                }
            } else {
                ddVar.b();
                return;
            }
        }
    }

    public final int[] a() {
        int[] iArr = new int[this.b.size()];
        Iterator it = this.b.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = ((Integer) it.next()).intValue();
            i++;
        }
        return iArr;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            stringBuffer.append(df.b(((Integer) it.next()).intValue()));
            if (it.hasNext()) {
                stringBuffer.append(' ');
            }
        }
        return stringBuffer.toString();
    }

    private static void a(v vVar, TreeSet treeSet, int i) {
        int intValue = ((((Integer) treeSet.last()).intValue() & 255) / 8) + 1;
        int[] iArr = new int[intValue];
        vVar.b(i);
        vVar.b(intValue);
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            int intValue2 = ((Integer) it.next()).intValue();
            int i2 = (intValue2 & 255) / 8;
            iArr[i2] = (1 << (7 - (intValue2 % 8))) | iArr[i2];
        }
        for (int i3 = 0; i3 < intValue; i3++) {
            vVar.b(iArr[i3]);
        }
    }

    public final void a(v vVar) {
        if (this.b.size() != 0) {
            int i = -1;
            TreeSet treeSet = new TreeSet();
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                int i2 = intValue >> 8;
                if (i2 != i) {
                    if (treeSet.size() > 0) {
                        a(vVar, treeSet, i);
                        treeSet.clear();
                    }
                    i = i2;
                }
                treeSet.add(Integer.valueOf(intValue));
            }
            a(vVar, treeSet, i);
        }
    }

    public final boolean b() {
        return this.b.isEmpty();
    }

    public final boolean a(int i) {
        return this.b.contains(bc.c(i));
    }
}
