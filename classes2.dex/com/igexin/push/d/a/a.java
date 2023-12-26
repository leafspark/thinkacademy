package com.igexin.push.d.a;

import com.igexin.b.a.b.b;
import com.igexin.b.a.b.d;
import com.igexin.b.a.d.a.e;
import com.igexin.push.d.c.c;
import com.igexin.push.d.c.f;
import com.igexin.push.d.c.h;
import com.igexin.push.d.c.k;
import com.igexin.push.d.c.l;
import com.igexin.push.d.c.m;
import com.igexin.push.d.c.o;
import com.igexin.push.d.c.p;

public class a extends b {
    public a(String str, b bVar) {
        super(str, true);
        a(bVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        r4 = r4.getString("action");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.igexin.push.d.c.a r4, com.igexin.push.d.c.c r5) {
        /*
            r3 = this;
            java.lang.String r0 = "action"
            byte r4 = r4.b
            r1 = 0
            r2 = 26
            if (r4 == r2) goto L_0x000a
            return r1
        L_0x000a:
            com.igexin.push.d.c.m r5 = (com.igexin.push.d.c.m) r5
            boolean r4 = r5.b()
            if (r4 == 0) goto L_0x0050
            java.lang.Object r4 = r5.e
            if (r4 == 0) goto L_0x0050
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x0035 }
            java.lang.Object r5 = r5.e     // Catch:{ Exception -> 0x0035 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0035 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0035 }
            boolean r5 = r4.has(r0)     // Catch:{ Exception -> 0x0035 }
            if (r5 == 0) goto L_0x0050
            java.lang.String r4 = r4.getString(r0)     // Catch:{ Exception -> 0x0035 }
            if (r4 == 0) goto L_0x0050
            java.lang.String r5 = "redirect_server"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x0035 }
            if (r4 == 0) goto L_0x0050
            r4 = 1
            return r4
        L_0x0035:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "CommandFilter|"
            r5.append(r0)
            java.lang.String r4 = r4.toString()
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.Object[] r5 = new java.lang.Object[r1]
            com.igexin.b.a.c.b.a((java.lang.String) r4, (java.lang.Object[]) r5)
        L_0x0050:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.d.a.a.a(com.igexin.push.d.c.a, com.igexin.push.d.c.c):boolean");
    }

    public Object a(d dVar, Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            com.igexin.push.d.c.a aVar = new com.igexin.push.d.c.a();
            aVar.b = (byte) cVar.i;
            aVar.a(cVar.c());
            aVar.c = cVar.j;
            aVar.d = cVar.k;
            return aVar;
        } else if (!(obj instanceof c[])) {
            return null;
        } else {
            c[] cVarArr = (c[]) obj;
            com.igexin.push.d.c.a[] aVarArr = new com.igexin.push.d.c.a[cVarArr.length];
            for (int i = 0; i < cVarArr.length; i++) {
                aVarArr[i] = new com.igexin.push.d.c.a();
                aVarArr[i].b = (byte) cVarArr[i].i;
                aVarArr[i].a(cVarArr[i].c());
            }
            return aVarArr;
        }
    }

    /* renamed from: b */
    public e c(d dVar, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof f) {
            return (e) obj;
        }
        com.igexin.push.d.c.a aVar = (com.igexin.push.d.c.a) obj;
        byte b = aVar.b;
        c hVar = b != 5 ? b != 9 ? b != 20 ? b != 26 ? b != 37 ? b != 97 ? null : new h() : new l() : new m() : new p() : new o() : new k();
        if ((aVar.f != 1 && aVar.f != 7) || hVar == null) {
            return null;
        }
        hVar.a(aVar.e);
        if (aVar.f == 7) {
            if (aVar.g != 32 || a(aVar, hVar)) {
                return hVar;
            }
            return null;
        } else if (a(aVar, hVar)) {
            return hVar;
        } else {
            return null;
        }
    }
}
