package com.bonree.sdk.bc;

import com.bonree.sdk.bc.dd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

abstract class da extends ca {
    private static final long a = -4319510507246305931L;
    private List b;

    protected da() {
    }

    private da(bn bnVar, int i, int i2, long j) {
        super(bnVar, i, i2, j);
    }

    protected da(bn bnVar, int i, int i2, long j, List list) {
        super(bnVar, i, i2, j);
        if (list != null) {
            this.b = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                try {
                    this.b.add(a((String) it.next()));
                } catch (dc e) {
                    throw new IllegalArgumentException(e.getMessage());
                }
            }
            return;
        }
        throw new IllegalArgumentException("strings must not be null");
    }

    protected da(bn bnVar, int i, int i2, long j, String str) {
        this(bnVar, i, i2, j, Collections.singletonList(str));
    }

    /* access modifiers changed from: package-private */
    public final void a(t tVar) throws IOException {
        this.b = new ArrayList(2);
        while (tVar.b() > 0) {
            this.b.add(tVar.k());
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(dd ddVar, bn bnVar) throws IOException {
        this.b = new ArrayList(2);
        while (true) {
            dd.a a2 = ddVar.a();
            if (a2.a()) {
                try {
                    this.b.add(a(a2.b));
                } catch (dc e) {
                    throw ddVar.a(e.getMessage());
                }
            } else {
                ddVar.b();
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            stringBuffer.append(a((byte[]) it.next(), true));
            if (it.hasNext()) {
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }

    public List e() {
        ArrayList arrayList = new ArrayList(this.b.size());
        for (int i = 0; i < this.b.size(); i++) {
            arrayList.add(a((byte[]) this.b.get(i), false));
        }
        return arrayList;
    }

    public List d() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public final void a(v vVar, m mVar, boolean z) {
        for (byte[] b2 : this.b) {
            vVar.b(b2);
        }
    }
}
