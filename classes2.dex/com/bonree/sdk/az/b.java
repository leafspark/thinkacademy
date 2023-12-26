package com.bonree.sdk.az;

import com.bonree.sdk.ad.a;
import com.bonree.sdk.agent.business.entity.UserInfoBean;
import com.bonree.sdk.be.f;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.k;
import com.bonree.sdk.d.e;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public final class b extends com.bonree.sdk.ad.a {
    private final String f;
    private final UserInfoBean g;
    private a h;
    private final Map<String, a> i;
    private final Map<String, UserInfoBean> j;
    private volatile String k;
    private volatile String l;
    private volatile String m;
    private UserInfoBean n;

    /* synthetic */ b(byte b) {
        this();
    }

    private b() {
        this((e) null);
    }

    private b(e eVar) {
        super((e) null);
        this.f = "User-";
        this.i = new k();
        this.j = new k();
        this.g = new UserInfoBean();
    }

    public final synchronized Map<String, UserInfoBean> a() {
        k kVar = new k(this.j);
        this.j.clear();
        Iterator<Map.Entry<String, a>> it = this.i.entrySet().iterator();
        while (it.hasNext()) {
            if (((a) it.next().getValue()).d() == 0) {
                it.remove();
            }
        }
        if (kVar.size() == 0) {
            return null;
        }
        this.c.c("User- getUserInfoBean:%s", kVar);
        return kVar;
    }

    public final synchronized String d() {
        a aVar;
        try {
            if (this.h != null || (this.g.userId == null && this.g.extraInfo == null)) {
                a aVar2 = this.h;
                if (aVar2 == null) {
                    f fVar = this.c;
                    fVar.c("User-tName=" + Thread.currentThread().getName() + " getUserInfoKey2:" + this.k, new Object[0]);
                    return "";
                }
                if (!aVar2.a().equals(this.g)) {
                    String str = this.k;
                    Iterator<String> it = this.i.keySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            String next = it.next();
                            a aVar3 = this.i.get(next);
                            if (aVar3 != null && aVar3.a().equals(this.g)) {
                                f fVar2 = this.c;
                                fVar2.c("User- repeat user info Key:" + this.k, new Object[0]);
                                str = next;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (ad.a(str) || !str.equals(this.k)) {
                        this.k = str;
                        this.h = this.i.get(this.k);
                    } else {
                        this.k = UUID.randomUUID().toString();
                        this.h = new a(this.g.userId, this.g.extraInfo);
                    }
                }
                if (!(this.k == null || (aVar = this.h) == null)) {
                    aVar.b();
                    this.i.put(this.k, this.h);
                    a(this.h.a());
                }
                return this.k;
            }
            this.h = new a(this.g.userId, this.g.extraInfo);
            this.k = UUID.randomUUID().toString();
            a(this.h.a());
            this.i.put(this.k, this.h);
            return this.k;
        } catch (Exception e) {
            this.c.a("User-", (Throwable) e);
        }
    }

    private void a(UserInfoBean userInfoBean) {
        if (this.l == null && userInfoBean.userId != null) {
            this.l = this.k;
            this.n = userInfoBean;
        }
    }

    public final void e() {
        this.l = null;
    }

    public final String b(String str) {
        if (ad.a(str) || str.equals(this.m) || this.l == null) {
            return null;
        }
        this.m = str;
        this.j.put(this.l, this.n);
        return this.l;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0026, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r1)
            return
        L_0x0009:
            java.util.Map<java.lang.String, com.bonree.sdk.az.a> r0 = r1.i     // Catch:{ all -> 0x0027 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0027 }
            com.bonree.sdk.az.a r0 = (com.bonree.sdk.az.a) r0     // Catch:{ all -> 0x0027 }
            if (r0 != 0) goto L_0x0015
            monitor-exit(r1)
            return
        L_0x0015:
            r0.c()     // Catch:{ all -> 0x0027 }
            if (r3 == 0) goto L_0x0025
            com.bonree.sdk.agent.business.entity.UserInfoBean r3 = r0.a()     // Catch:{ all -> 0x0027 }
            if (r3 == 0) goto L_0x0025
            java.util.Map<java.lang.String, com.bonree.sdk.agent.business.entity.UserInfoBean> r0 = r1.j     // Catch:{ all -> 0x0027 }
            r0.put(r2, r3)     // Catch:{ all -> 0x0027 }
        L_0x0025:
            monitor-exit(r1)
            return
        L_0x0027:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bonree.sdk.az.b.a(java.lang.String, boolean):void");
    }

    public final synchronized void c(String str) {
        if (!ad.a(str)) {
            this.g.userId = str;
        }
    }

    public final synchronized void d(String str) {
        if (!ad.a(str)) {
            this.g.extraInfo = str;
        }
    }

    public final synchronized UserInfoBean g() {
        if (this.g.userId == null && this.g.extraInfo == null) {
            return null;
        }
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.userId = this.g.userId;
        userInfoBean.extraInfo = this.g.extraInfo;
        return userInfoBean;
    }

    public final boolean b() {
        if (!this.a) {
            a("User-", a.d.a);
            this.a = true;
            a("User-", a.d.c);
        } else {
            a("User-", a.d.b);
        }
        return true;
    }

    public final boolean c() {
        if (this.a) {
            a("User-", a.d.d);
            this.a = false;
        } else {
            this.c.c("UserService no need stoped!", new Object[0]);
        }
        a("User-", a.d.e);
        return true;
    }

    public static b h() {
        return a.a;
    }

    static class a {
        /* access modifiers changed from: private */
        public static final b a = new b((byte) 0);

        private a() {
        }
    }
}
