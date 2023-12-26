package atd.l0;

import atd.m0.d;
import atd.s0.a;
import com.adyen.threeds2.Warning;
import java.util.Collection;

final class e extends f {
    private final String a;
    private final Collection<String> b;
    private final Collection<String> c;
    private final d d;

    static {
        a.a(-785170225228352L);
        a.a(-785500937710144L);
    }

    e(String str, Collection<String> collection, Collection<String> collection2, d dVar) {
        this.a = str;
        this.b = collection;
        this.c = collection2;
        this.d = dVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        r0 = r2.a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(android.content.Context r3) {
        /*
            r2 = this;
            atd.m0.d r0 = r2.d
            boolean r0 = r0.a(r3)
            if (r0 != 0) goto L_0x003b
            atd.m0.d r0 = r2.d
            boolean r0 = r0.b(r3)
            if (r0 != 0) goto L_0x003b
            atd.m0.d r0 = r2.d
            boolean r0 = r0.a()
            if (r0 != 0) goto L_0x003b
            atd.m0.d r0 = r2.d
            java.util.Collection<java.lang.String> r1 = r2.c
            boolean r0 = r0.b(r3, r1)
            if (r0 != 0) goto L_0x003b
            atd.m0.d r0 = r2.d
            java.util.Collection<java.lang.String> r1 = r2.b
            boolean r0 = r0.a((android.content.Context) r3, (java.util.Collection<java.lang.String>) r1)
            if (r0 == 0) goto L_0x003b
            java.lang.String r0 = r2.a
            if (r0 == 0) goto L_0x0039
            atd.m0.d r1 = r2.d
            boolean r3 = r1.a((android.content.Context) r3, (java.lang.String) r0)
            if (r3 != 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r3 = 0
            goto L_0x003c
        L_0x003b:
            r3 = 1
        L_0x003c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: atd.l0.e.b(android.content.Context):boolean");
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return a.a(-785788700518976L);
    }

    /* access modifiers changed from: package-private */
    public String d() {
        return a.a(-785844535093824L);
    }

    /* access modifiers changed from: package-private */
    public Warning.Severity e() {
        return Warning.Severity.HIGH;
    }
}
