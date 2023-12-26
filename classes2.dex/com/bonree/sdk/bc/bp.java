package com.bonree.sdk.bc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class bp extends ca {
    private static final long a = -6254521894809367938L;
    private List b;

    bp() {
    }

    /* access modifiers changed from: package-private */
    public final ca a() {
        return new bp();
    }

    public bp(int i, int i2, int i3, int i4, List list) {
        super(bn.a, 41, i, 0);
        b("payloadSize", i);
        a("xrcode", i2);
        a("version", i3);
        b("flags", i4);
        this.i = (((long) i2) << 24) + (((long) i3) << 16) + ((long) i4);
        if (list != null) {
            this.b = new ArrayList(list);
        }
    }

    private bp(int i, int i2, int i3, int i4) {
        this(i, i2, i3, i4, (List) null);
    }

    private bp(int i, int i2, int i3) {
        this(i, i2, i3, 0, (List) null);
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        if (tVar.b() > 0) {
            this.b = new ArrayList();
        }
        while (tVar.b() > 0) {
            this.b.add(y.b(tVar));
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        throw ddVar.a("no text format defined for OPT");
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        List list = this.b;
        if (list != null) {
            stringBuffer.append(list);
            stringBuffer.append(" ");
        }
        stringBuffer.append(" ; payload ");
        stringBuffer.append(this.h);
        stringBuffer.append(", xrcode ");
        stringBuffer.append(e());
        stringBuffer.append(", version ");
        stringBuffer.append((int) ((this.i >>> 16) & 255));
        stringBuffer.append(", flags ");
        stringBuffer.append((int) (this.i & 65535));
        return stringBuffer.toString();
    }

    public final int d() {
        return this.h;
    }

    public final int e() {
        return (int) (this.i >>> 24);
    }

    private int f() {
        return (int) ((this.i >>> 16) & 255);
    }

    private int g() {
        return (int) (this.i & 65535);
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        List<y> list = this.b;
        if (list != null) {
            for (y b2 : list) {
                b2.b(vVar);
            }
        }
    }

    private List h() {
        List list = this.b;
        if (list == null) {
            return Collections.EMPTY_LIST;
        }
        return Collections.unmodifiableList(list);
    }

    private List b(int i) {
        if (this.b == null) {
            return Collections.EMPTY_LIST;
        }
        List list = Collections.EMPTY_LIST;
        for (y yVar : this.b) {
            if (yVar.b() == i) {
                if (list == Collections.EMPTY_LIST) {
                    list = new ArrayList();
                }
                list.add(yVar);
            }
        }
        return list;
    }

    public final boolean equals(Object obj) {
        return super.equals(obj) && this.i == ((bp) obj).i;
    }
}
