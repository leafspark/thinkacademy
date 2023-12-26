package com.igexin.push.c;

import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.JSONArrayInstrumentation;
import com.igexin.b.a.c.b;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.config.l;
import com.igexin.push.core.b.i;
import com.igexin.push.core.c;
import com.igexin.push.core.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

public class a {
    private static final String f = ("DT_" + a.class.getName());
    public volatile d a = d.NORMAL;
    public AtomicBoolean b = new AtomicBoolean(false);
    protected int c;
    protected volatile long d;
    protected volatile long e;
    private int g;
    private int h;
    private int i;
    private j j;
    private final List<e> k = new ArrayList();
    private final List<j> l = new ArrayList();
    private final Object m = new Object();
    private final Object n = new Object();
    private int o = 0;
    private boolean p;
    private final Comparator<j> q = new b(this);

    private synchronized void a(d dVar) {
        StringBuilder sb = new StringBuilder();
        String str = f;
        sb.append(str);
        sb.append("|set domain type = ");
        sb.append(dVar);
        b.a(sb.toString(), new Object[0]);
        if (l.f) {
            if (this.a != dVar) {
                a((List<e>) null);
            }
            int i2 = c.a[dVar.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    this.b.set(true);
                    if (this.a != dVar) {
                        this.d = System.currentTimeMillis();
                    }
                    SDKUrlConfig.setCmAddress(SDKUrlConfig.XFR_ADDRESS_BAK[0]);
                    b.a(str + "|set domain type backup cm = " + SDKUrlConfig.getCmAddress(), new Object[0]);
                } else if (i2 == 3) {
                    if (this.a != dVar) {
                        this.o = 0;
                    }
                }
                this.a = dVar;
                i.a().f().m();
            }
            this.g = 0;
            SDKUrlConfig.setCmAddress(c(true));
            if (dVar == d.NORMAL) {
                this.b.set(false);
            }
            b.a(str + "|set domain type normal cm = " + SDKUrlConfig.getCmAddress(), new Object[0]);
            this.a = dVar;
            i.a().f().m();
        }
    }

    private void a(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                this.k.add(new e().a(jSONArray.getJSONObject(i2)));
            }
            b.a(f + "|get cm from cache, isWifi = " + this.p + ", lastCmList = " + str, new Object[0]);
        } catch (Throwable th) {
            b.a(f + "|" + th.toString(), new Object[0]);
        }
    }

    private String b(boolean z) {
        try {
            synchronized (this.n) {
                String str = this.p ? d.aq : d.ar;
                if (!this.k.isEmpty() || !TextUtils.isEmpty(str)) {
                    if (this.k.isEmpty() && !TextUtils.isEmpty(str)) {
                        a(str);
                    }
                    StringBuilder sb = new StringBuilder();
                    String str2 = f;
                    sb.append(str2);
                    sb.append("cm try = ");
                    sb.append(this.i);
                    sb.append(" times");
                    b.a(sb.toString(), new Object[0]);
                    if (this.i >= this.k.size() * 1) {
                        b.a(str2 + "cm invalid", new Object[0]);
                        this.i = 0;
                        this.h = 0;
                        this.k.clear();
                        return null;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator<e> it = this.k.iterator();
                    while (it.hasNext()) {
                        e next = it.next();
                        if (next.b < currentTimeMillis) {
                            b.a(f + "|add[" + next.a + "] outDate", new Object[0]);
                            it.remove();
                        }
                    }
                    d();
                    if (this.k.isEmpty()) {
                        return null;
                    }
                    if (z) {
                        this.i++;
                    }
                    int i2 = this.h >= this.k.size() ? 0 : this.h;
                    this.h = i2;
                    String str3 = this.k.get(i2).a;
                    this.h++;
                    return str3;
                }
                b.a(f + "cm list size = 0", new Object[0]);
                this.i = 0;
                this.h = 0;
                return null;
            }
        } catch (Exception e2) {
            b.a(f + "|" + e2.toString(), new Object[0]);
            return null;
        }
    }

    private String c(boolean z) {
        String b2;
        synchronized (this.m) {
            int i2 = this.g >= this.l.size() ? 0 : this.g;
            this.g = i2;
            j jVar = this.l.get(i2);
            this.j = jVar;
            b2 = jVar.b(z);
        }
        return b2;
    }

    private void j() {
        d dVar;
        b.a(f + "|before disconnect, type = " + this.a, new Object[0]);
        int i2 = c.a[this.a.ordinal()];
        if (i2 != 1) {
            if (i2 == 2 && System.currentTimeMillis() - this.d > l.n) {
                dVar = d.TRY_NORMAL;
            } else {
                return;
            }
        } else if (System.currentTimeMillis() - this.e > 86400000 && this.c > l.p) {
            dVar = d.BACKUP;
        } else {
            return;
        }
        a(dVar);
    }

    public void a(List<e> list) {
        synchronized (this.n) {
            this.h = 0;
            this.i = 0;
            this.k.clear();
            if (list != null) {
                this.k.addAll(list);
                b.a(f + "|set cm list: " + list.toString(), new Object[0]);
            }
            d();
        }
    }

    public void a(boolean z) {
        this.p = z;
    }

    public boolean a() {
        boolean z;
        try {
            z = true;
            boolean z2 = !c.a().i().h();
            String b2 = b(z2);
            StringBuilder sb = new StringBuilder();
            String str = f;
            sb.append(str);
            sb.append("|get from cm = ");
            sb.append(b2);
            b.a(sb.toString(), new Object[0]);
            if (b2 == null) {
                if (!l.f || this.a != d.BACKUP) {
                    j jVar = this.j;
                    if (jVar != null && !jVar.f()) {
                        this.g++;
                    }
                    b2 = c(z2);
                    z = false;
                } else {
                    this.g = this.g >= SDKUrlConfig.XFR_ADDRESS_BAK.length ? 0 : this.g;
                    String[] strArr = SDKUrlConfig.XFR_ADDRESS_BAK;
                    int i2 = this.g;
                    String str2 = strArr[i2];
                    this.g = i2 + 1;
                    z = false;
                    b2 = str2;
                }
            }
            try {
                if (!SDKUrlConfig.getCmAddress().equals(b2)) {
                    b.a(str + "|address changed : form [" + SDKUrlConfig.getCmAddress() + "] to [" + b2 + "]", new Object[0]);
                }
                SDKUrlConfig.setCmAddress(b2);
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                b.a(f + "|switch address|" + e.toString(), new Object[0]);
                return z;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            e.printStackTrace();
            b.a(f + "|switch address|" + e.toString(), new Object[0]);
            return z;
        }
        return z;
    }

    public synchronized void b() {
        this.i = 0;
        j jVar = this.j;
        if (jVar != null) {
            jVar.g();
        }
    }

    public void b(List<j> list) {
        synchronized (this.m) {
            this.l.clear();
            this.l.addAll(list);
            Collections.sort(this.l, this.q);
        }
    }

    public synchronized void c() {
        this.c++;
        b.a(f + "|loginFailedlCnt = " + this.c, new Object[0]);
    }

    public void d() {
        JSONArray jSONArray = new JSONArray();
        for (e a2 : this.k) {
            jSONArray.put(a2.a());
        }
        i.a().c(jSONArray.length() == 0 ? "null" : !(jSONArray instanceof JSONArray) ? jSONArray.toString() : JSONArrayInstrumentation.toString(jSONArray), !this.p);
    }

    public void e() {
        synchronized (this.m) {
            this.g = 0;
            Collections.sort(this.l, this.q);
        }
    }

    public void f() {
        b.a(f + "|detect success, current type = " + this.a, new Object[0]);
        if (this.a == d.BACKUP) {
            a(d.TRY_NORMAL);
            c.a().i().a(true);
        }
    }

    public void g() {
        if (c.a[this.a.ordinal()] == 2 && System.currentTimeMillis() - this.d > l.n) {
            a(d.TRY_NORMAL);
        }
    }

    public void h() {
        if (this.a != d.BACKUP) {
            this.c = 0;
        }
        int i2 = c.a[this.a.ordinal()];
        if (i2 == 1) {
            this.e = System.currentTimeMillis();
            i.a().f().m();
        } else if (i2 == 3) {
            a(d.NORMAL);
        } else {
            return;
        }
        this.b.set(false);
    }

    public void i() {
        j();
        if (d.n && this.a != d.BACKUP) {
            this.e = System.currentTimeMillis();
            i.a().f().m();
        }
        if (c.a[this.a.ordinal()] == 3) {
            int i2 = this.o + 1;
            this.o = i2;
            if (i2 >= 10) {
                this.c = 0;
                this.d = System.currentTimeMillis();
                a(d.BACKUP);
            }
        }
    }
}
