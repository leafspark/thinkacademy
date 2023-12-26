package com.igexin.push.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.igexin.b.a.b.e;
import com.igexin.b.a.c.b;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.b.i;
import com.igexin.push.core.d;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class o {
    private static final String e = ("DT_" + o.class.getName());
    protected long a;
    protected final Map<String, k> b = new LinkedHashMap();
    protected final Map<String, j> c = new HashMap();
    protected a d = new a();
    private final Object f = new Object();
    private final Object g = new Object();
    private final Comparator<Map.Entry<String, j>> h = new p(this);
    private Handler i;

    public o(String str, String str2) {
        if (SDKUrlConfig.hasMultipleXfr()) {
            b(str);
            c(str2);
            return;
        }
        a();
    }

    private j a(JSONObject jSONObject) {
        if (!jSONObject.has("domain")) {
            return null;
        }
        j jVar = new j();
        jVar.a(jSONObject.getString("domain"));
        if (jSONObject.has("port")) {
            jVar.a(jSONObject.getInt("port"));
        }
        if (jSONObject.has("ip")) {
            jVar.b(jSONObject.getString("ip"));
        }
        if (jSONObject.has("consumeTime")) {
            jVar.a(jSONObject.getLong("consumeTime"));
        }
        if (jSONObject.has("detectSuccessTime")) {
            jVar.b(jSONObject.getLong("detectSuccessTime"));
        }
        if (jSONObject.has("isDomain")) {
            jVar.a(jSONObject.getBoolean("isDomain"));
        }
        return jVar;
    }

    private List<String> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            try {
                arrayList.add(jSONArray.getJSONObject(i2).getString("domain"));
                i2++;
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private void a() {
        this.a = 0;
        if (q()) {
            if (d.am != null) {
                i.a().b("null", true);
            }
        } else if (d.an != null) {
            i.a().b("null", false);
        }
        List<String> n = n();
        ArrayList arrayList = new ArrayList();
        for (String next : n) {
            j jVar = new j(next, Integer.parseInt(e.a(next)[2]));
            if (n.size() > 1) {
                a(jVar);
            }
            arrayList.add(jVar);
        }
        this.d.b((List<j>) arrayList);
        n.clear();
    }

    private void a(j jVar) {
        k kVar = new k();
        kVar.a(b() == h.WIFI);
        kVar.a(c());
        kVar.a(jVar);
        synchronized (this.g) {
            this.b.put(jVar.a(), kVar);
        }
    }

    private void b(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            a();
            return;
        }
        JSONArray jSONArray = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            a();
            return;
        }
        if (jSONObject.has("lastDetectTime")) {
            try {
                this.a = jSONObject.getLong("lastDetectTime");
            } catch (JSONException unused2) {
            }
        }
        if (Math.abs(System.currentTimeMillis() - this.a) >= f.a) {
            a();
            return;
        }
        if (jSONObject.has("list")) {
            try {
                jSONArray = jSONObject.getJSONArray("list");
            } catch (JSONException unused3) {
            }
        }
        if (jSONArray == null || jSONArray.length() == 0) {
            a();
            return;
        }
        List<String> a2 = a(jSONArray);
        if (a2.isEmpty()) {
            a();
            return;
        }
        List<String> n = n();
        ArrayList arrayList = new ArrayList(n);
        arrayList.retainAll(a2);
        if (arrayList.size() != a2.size()) {
            b.a(e + " | db cache xfr != default, use default", new Object[0]);
            arrayList.clear();
            n.clear();
            a2.clear();
            a();
            return;
        }
        b.a(e + " | db cache xfr == default, use cache", new Object[0]);
        b(jSONArray);
    }

    private void b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                j a2 = a(jSONObject);
                if (a2 != null) {
                    this.c.put(a2.a(), a2);
                } else {
                    try {
                        a2 = d(jSONObject.getString("domain"));
                    } catch (Exception e2) {
                        b.a(e + "|initWithCacheData exception " + e2.toString(), new Object[0]);
                        this.c.clear();
                        a();
                        return;
                    }
                }
                if (a2 != null) {
                    a(a2);
                    arrayList.add(a2);
                }
                i2++;
            } catch (Exception e3) {
                b.a(e + "|initWithCacheData exception " + e3.toString(), new Object[0]);
                return;
            }
        }
        this.d.b((List<j>) arrayList);
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            JSONObject jSONObject = null;
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
            if (jSONObject != null && jSONObject.length() != 0) {
                if (jSONObject.has("loginFailedlCnt")) {
                    try {
                        this.d.c = jSONObject.getInt("loginFailedlCnt");
                    } catch (JSONException unused2) {
                    }
                }
                if (jSONObject.has("lastChange2BackupTime")) {
                    try {
                        this.d.d = jSONObject.getLong("lastChange2BackupTime");
                    } catch (JSONException unused3) {
                    }
                }
                if (jSONObject.has("lastOfflineTime")) {
                    try {
                        this.d.e = jSONObject.getLong("lastOfflineTime");
                    } catch (JSONException unused4) {
                    }
                }
                if (jSONObject.has("domainType")) {
                    try {
                        this.d.a = d.a(jSONObject.getInt("domainType"));
                        if (this.d.a == d.BACKUP) {
                            this.d.b.set(true);
                        }
                    } catch (JSONException unused5) {
                    }
                }
            }
        }
    }

    private j d(String str) {
        j jVar = new j();
        String[] a2 = e.a(str);
        jVar.a(str);
        jVar.a(Integer.parseInt(a2[2]));
        return jVar;
    }

    private List<String> n() {
        return SDKUrlConfig.getDefaultXfrList();
    }

    private void o() {
        synchronized (this.f) {
            this.c.clear();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x004b */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void p() {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r6.a = r0
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            java.lang.Object r2 = r6.g
            monitor-enter(r2)
            java.lang.String r3 = "lastDetectTime"
            long r4 = r6.a     // Catch:{ Exception -> 0x004b }
            r0.put(r3, r4)     // Catch:{ Exception -> 0x004b }
            java.lang.String r3 = "list"
            r0.put(r3, r1)     // Catch:{ Exception -> 0x004b }
            java.util.Map<java.lang.String, com.igexin.push.c.k> r3 = r6.b     // Catch:{ Exception -> 0x004b }
            java.util.Set r3 = r3.entrySet()     // Catch:{ Exception -> 0x004b }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x004b }
        L_0x0029:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x004b }
            if (r4 == 0) goto L_0x004b
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x004b }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ Exception -> 0x004b }
            java.lang.Object r4 = r4.getValue()     // Catch:{ Exception -> 0x004b }
            com.igexin.push.c.k r4 = (com.igexin.push.c.k) r4     // Catch:{ Exception -> 0x004b }
            com.igexin.push.c.j r4 = r4.b()     // Catch:{ Exception -> 0x004b }
            org.json.JSONObject r4 = r4.h()     // Catch:{ Exception -> 0x004b }
            if (r4 == 0) goto L_0x0029
            r1.put(r4)     // Catch:{ Exception -> 0x004b }
            goto L_0x0029
        L_0x0049:
            r0 = move-exception
            goto L_0x0085
        L_0x004b:
            monitor-exit(r2)     // Catch:{ all -> 0x0049 }
            int r1 = r0.length()
            if (r1 <= 0) goto L_0x0084
            boolean r1 = r6.q()
            if (r1 == 0) goto L_0x006d
            com.igexin.push.core.b.i r1 = com.igexin.push.core.b.i.a()
            boolean r2 = r0 instanceof org.json.JSONObject
            if (r2 != 0) goto L_0x0065
            java.lang.String r0 = r0.toString()
            goto L_0x006b
        L_0x0065:
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            java.lang.String r0 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r0)
        L_0x006b:
            r2 = 1
            goto L_0x0081
        L_0x006d:
            com.igexin.push.core.b.i r1 = com.igexin.push.core.b.i.a()
            boolean r2 = r0 instanceof org.json.JSONObject
            if (r2 != 0) goto L_0x007a
            java.lang.String r0 = r0.toString()
            goto L_0x0080
        L_0x007a:
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            java.lang.String r0 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r0)
        L_0x0080:
            r2 = 0
        L_0x0081:
            r1.b((java.lang.String) r0, (boolean) r2)
        L_0x0084:
            return
        L_0x0085:
            monitor-exit(r2)     // Catch:{ all -> 0x0049 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.o.p():void");
    }

    private boolean q() {
        return b() == h.MOBILE;
    }

    /* access modifiers changed from: protected */
    public k a(String str) {
        synchronized (this.g) {
            for (Map.Entry next : this.b.entrySet()) {
                if (((String) next.getKey()).equals(str)) {
                    k kVar = (k) next.getValue();
                    return kVar;
                }
            }
            return null;
        }
    }

    public abstract h b();

    /* access modifiers changed from: protected */
    public void b(j jVar) {
        synchronized (this.f) {
            this.c.put(jVar.a(), jVar);
        }
        this.d.e();
    }

    public abstract r c();

    public void d() {
        if (!j()) {
            b.a(e + "|startDetect detect = false, return !!!", new Object[0]);
            return;
        }
        b.a(e + "|startDetect detect = true, start detect !!!", new Object[0]);
        h();
    }

    public void e() {
        synchronized (this.g) {
            for (Map.Entry next : this.b.entrySet()) {
                ((k) next.getValue()).a((r) null);
                ((k) next.getValue()).d();
            }
        }
    }

    public void f() {
        e();
        o();
        List<String> n = n();
        synchronized (this.g) {
            int size = this.b.size();
            if (n.size() < size) {
                int size2 = size - n.size();
                Iterator<Map.Entry<String, k>> it = this.b.entrySet().iterator();
                int i2 = 0;
                while (it.hasNext() && i2 < size2) {
                    ((k) it.next().getValue()).e();
                    it.remove();
                    i2++;
                }
            }
            ArrayList arrayList = new ArrayList(this.b.values());
            this.b.clear();
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < n.size(); i3++) {
                j jVar = new j();
                String[] a2 = e.a(n.get(i3));
                jVar.a(n.get(i3));
                jVar.a(Integer.parseInt(a2[2]));
                if (i3 < size) {
                    k kVar = (k) arrayList.get(i3);
                    kVar.a(jVar);
                    this.b.put(jVar.a(), kVar);
                } else {
                    a(jVar);
                }
                arrayList2.add(jVar);
            }
            this.d.b((List<j>) arrayList2);
        }
    }

    public void g() {
        e();
        o();
        List<String> n = n();
        synchronized (this.g) {
            for (Map.Entry<String, k> value : this.b.entrySet()) {
                ((k) value.getValue()).e();
            }
            this.b.clear();
            ArrayList arrayList = new ArrayList();
            j jVar = new j();
            String[] a2 = e.a(n.get(0));
            jVar.a(n.get(0));
            jVar.a(Integer.parseInt(a2[2]));
            arrayList.add(jVar);
            this.d.b((List<j>) arrayList);
            arrayList.clear();
        }
    }

    public void h() {
        this.a = System.currentTimeMillis();
        synchronized (this.g) {
            for (Map.Entry next : this.b.entrySet()) {
                ((k) next.getValue()).a(c());
                if (((k) next.getValue()).b() != null) {
                    ((k) next.getValue()).b().b();
                }
                ((k) next.getValue()).c();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void i() {
        i.a().b("null", true);
        i.a().b("null", false);
    }

    /* access modifiers changed from: protected */
    public boolean j() {
        long abs = Math.abs(System.currentTimeMillis() - this.a);
        if (abs >= (f.a * 2) - 3600) {
            b.a(e + "|current time - last detect time > " + (f.a / 1000) + " s, detect = true", new Object[0]);
            m.a.set(true);
            return true;
        }
        if (!m.a.getAndSet(true)) {
            long abs2 = Math.abs(f.a - abs);
            m.c_().a(abs2);
            b.a(e + "|set next detect time = " + abs2, new Object[0]);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public synchronized void k() {
        this.d.f();
    }

    public void l() {
        synchronized (o.class) {
            if (this.i == null) {
                HandlerThread handlerThread = new HandlerThread("NetDetect-T");
                handlerThread.start();
                this.i = new Handler(handlerThread.getLooper());
            }
        }
        this.i.removeCallbacksAndMessages("detToken");
        this.i.postAtTime(new q(this), "detToken", SystemClock.uptimeMillis() + 5000);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:1|2|3|4|5|6|7|(2:9|(3:11|(1:13)(1:14)|15)(3:16|(1:18)(1:19)|20))|21) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x002e */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m() {
        /*
            r4 = this;
            monitor-enter(r4)
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x006b }
            r0.<init>()     // Catch:{ all -> 0x006b }
            java.lang.String r1 = "loginFailedlCnt"
            com.igexin.push.c.a r2 = r4.d     // Catch:{ Exception -> 0x002e }
            int r2 = r2.c     // Catch:{ Exception -> 0x002e }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x002e }
            java.lang.String r1 = "lastChange2BackupTime"
            com.igexin.push.c.a r2 = r4.d     // Catch:{ Exception -> 0x002e }
            long r2 = r2.d     // Catch:{ Exception -> 0x002e }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x002e }
            java.lang.String r1 = "lastOfflineTime"
            com.igexin.push.c.a r2 = r4.d     // Catch:{ Exception -> 0x002e }
            long r2 = r2.e     // Catch:{ Exception -> 0x002e }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x002e }
            java.lang.String r1 = "domainType"
            com.igexin.push.c.a r2 = r4.d     // Catch:{ Exception -> 0x002e }
            com.igexin.push.c.d r2 = r2.a     // Catch:{ Exception -> 0x002e }
            int r2 = r2.b()     // Catch:{ Exception -> 0x002e }
            r0.put(r1, r2)     // Catch:{ Exception -> 0x002e }
        L_0x002e:
            int r1 = r0.length()     // Catch:{ all -> 0x006b }
            if (r1 <= 0) goto L_0x0069
            boolean r1 = r4.q()     // Catch:{ all -> 0x006b }
            if (r1 == 0) goto L_0x0052
            com.igexin.push.core.b.i r1 = com.igexin.push.core.b.i.a()     // Catch:{ all -> 0x006b }
            boolean r2 = r0 instanceof org.json.JSONObject     // Catch:{ all -> 0x006b }
            if (r2 != 0) goto L_0x0047
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x006b }
            goto L_0x004d
        L_0x0047:
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x006b }
            java.lang.String r0 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r0)     // Catch:{ all -> 0x006b }
        L_0x004d:
            r2 = 1
            r1.a((java.lang.String) r0, (boolean) r2)     // Catch:{ all -> 0x006b }
            goto L_0x0069
        L_0x0052:
            com.igexin.push.core.b.i r1 = com.igexin.push.core.b.i.a()     // Catch:{ all -> 0x006b }
            boolean r2 = r0 instanceof org.json.JSONObject     // Catch:{ all -> 0x006b }
            if (r2 != 0) goto L_0x005f
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x006b }
            goto L_0x0065
        L_0x005f:
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ all -> 0x006b }
            java.lang.String r0 = com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation.toString(r0)     // Catch:{ all -> 0x006b }
        L_0x0065:
            r2 = 0
            r1.a((java.lang.String) r0, (boolean) r2)     // Catch:{ all -> 0x006b }
        L_0x0069:
            monitor-exit(r4)
            return
        L_0x006b:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.o.m():void");
    }
}
