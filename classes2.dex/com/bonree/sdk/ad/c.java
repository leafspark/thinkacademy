package com.bonree.sdk.ad;

import android.os.Looper;
import com.bonree.sdk.agent.business.entity.MethodInfoBean;
import com.bonree.sdk.agent.business.entity.ThreadMethodInfoBean;
import com.bonree.sdk.agent.engine.external.AppStateInfo;
import com.bonree.sdk.bs.ad;
import com.bonree.sdk.bs.k;
import com.bonree.sdk.d.a;
import com.bonree.sdk.g.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class c {
    private static final int a = 200;
    private Map<String, ThreadMethodInfoBean> b = new k();
    private final Map<String, b> c = new k();

    private static long c(long j, long j2) {
        return j > 0 ? j + j2 : j - j2;
    }

    /* access modifiers changed from: protected */
    public abstract long a(long j);

    /* access modifiers changed from: protected */
    public abstract boolean b(b bVar);

    protected c() {
    }

    /* access modifiers changed from: protected */
    public final void a(b bVar) {
        if (!b(bVar)) {
            int e = bVar.e();
            if (e != 0) {
                if (e == 1) {
                    d(bVar);
                }
            } else if (bVar != null) {
                try {
                    if ((a.L() ? AppStateInfo.RECORD_LAUNCH_TIME_OHOS : AppStateInfo.RECORD_LAUNCH_TIME).equals(bVar.c())) {
                        a(bVar, bVar.f(), bVar.j());
                    } else if (AppStateInfo.RECORD_CUSTOM_LAUNCH_END.equals(bVar.c())) {
                        a(bVar, bVar.f(), bVar.j());
                    } else {
                        String o = bVar.o();
                        if (!this.c.containsKey(o)) {
                            synchronized (this.c) {
                                if (this.c.size() >= a) {
                                    this.c.remove(this.c.keySet().iterator().next());
                                }
                                this.c.put(o, bVar);
                            }
                        }
                        if (com.bonree.sdk.z.a.q.equals(bVar.c())) {
                            d(bVar);
                        }
                    }
                } catch (Throwable th) {
                    com.bonree.sdk.be.a.a().e("BaseSnapshot beginMethod is error %s.", th.getMessage());
                }
            }
        }
    }

    private void c(b bVar) {
        if (bVar != null) {
            try {
                if ((a.L() ? AppStateInfo.RECORD_LAUNCH_TIME_OHOS : AppStateInfo.RECORD_LAUNCH_TIME).equals(bVar.c())) {
                    a(bVar, bVar.f(), bVar.j());
                } else if (AppStateInfo.RECORD_CUSTOM_LAUNCH_END.equals(bVar.c())) {
                    a(bVar, bVar.f(), bVar.j());
                } else {
                    String o = bVar.o();
                    if (!this.c.containsKey(o)) {
                        synchronized (this.c) {
                            if (this.c.size() >= a) {
                                this.c.remove(this.c.keySet().iterator().next());
                            }
                            this.c.put(o, bVar);
                        }
                    }
                    if (com.bonree.sdk.z.a.q.equals(bVar.c())) {
                        d(bVar);
                    }
                }
            } catch (Throwable th) {
                com.bonree.sdk.be.a.a().e("BaseSnapshot beginMethod is error %s.", th.getMessage());
            }
        }
    }

    private void d(b bVar) {
        if (bVar != null) {
            try {
                String o = bVar.o();
                b bVar2 = this.c.get(o);
                if (bVar2 != null) {
                    synchronized (this.c) {
                        this.c.remove(o);
                    }
                    bVar.b(c(bVar2.j(), ad.a(bVar.f() - bVar2.f())));
                    a(bVar2, bVar);
                }
            } catch (Exception e) {
                com.bonree.sdk.be.a.a().a("BaseSnapshot endMethod is error %s.", (Throwable) e);
            }
        }
    }

    public void a(long j, long j2) {
        b(j);
    }

    private void b(long j) {
        if (!this.c.isEmpty()) {
            synchronized (this.c) {
                Iterator<Map.Entry<String, b>> it = this.c.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry next = it.next();
                    if (!(next == null || next.getValue() == null)) {
                        com.bonree.sdk.be.a.a().c("BaseSnapshot %s methodBeginCacheClose method is %s.", getClass().getName(), next);
                        b bVar = (b) next.getValue();
                        a(bVar, j, c(bVar.j(), ad.a(j - bVar.f())));
                        it.remove();
                    }
                }
            }
        }
    }

    private void a(b bVar, b bVar2) {
        a(bVar, a(bVar, bVar2, bVar2.f(), bVar2.j()));
    }

    private void a(b bVar, long j, long j2) {
        a(bVar, a(bVar, (b) null, j, j2));
    }

    private void a(b bVar, MethodInfoBean methodInfoBean) {
        try {
            synchronized (this.b) {
                String g = bVar.g();
                ThreadMethodInfoBean threadMethodInfoBean = this.b.get(g);
                if (threadMethodInfoBean == null) {
                    threadMethodInfoBean = new ThreadMethodInfoBean();
                    threadMethodInfoBean.isMain = bVar.i();
                    threadMethodInfoBean.mId = bVar.g();
                    threadMethodInfoBean.mName = bVar.h();
                    threadMethodInfoBean.mMethodInfo = new ArrayList();
                    if (this.b.size() >= a) {
                        long id = Looper.getMainLooper().getThread().getId();
                        Iterator<String> it = this.b.keySet().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                String next = it.next();
                                if (next != null && !next.equals(String.valueOf(id))) {
                                    it.remove();
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    this.b.put(g, threadMethodInfoBean);
                }
                if (threadMethodInfoBean.mMethodInfo != null) {
                    if (threadMethodInfoBean.mMethodInfo.size() >= a) {
                        int i = methodInfoBean.mMethodType;
                        if (i == 0 || i == 5 || i == 6) {
                            Iterator<MethodInfoBean> it2 = threadMethodInfoBean.mMethodInfo.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                MethodInfoBean next2 = it2.next();
                                if (next2.mMethodType != 0 && next2.mMethodType != 5) {
                                    it2.remove();
                                    break;
                                }
                            }
                        } else {
                            return;
                        }
                    }
                    threadMethodInfoBean.mMethodInfo.add(methodInfoBean);
                }
            }
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().e("BaseSnapshot createThreadBean error %s.", th.toString());
        }
    }

    private MethodInfoBean a(b bVar, b bVar2, long j, long j2) {
        MethodInfoBean methodInfoBean = new MethodInfoBean();
        methodInfoBean.mStartRealTimeMs = bVar.f();
        methodInfoBean.mEndRealTimeMs = j;
        methodInfoBean.mStartTimeUs = a(bVar.j());
        methodInfoBean.mEndTimeUs = j2;
        if (!ad.a(bVar.b())) {
            methodInfoBean.mName = ad.q(bVar.b()) + "/" + bVar.c();
        } else if (bVar.k() == b.a.START_ASYNC.a() || bVar.k() == b.a.TASK_EXEC.a()) {
            methodInfoBean.mName = bVar.c();
        } else {
            methodInfoBean.mName = ad.q(bVar.a()) + "/" + bVar.c();
        }
        methodInfoBean.mMethodType = bVar.d();
        methodInfoBean.mParam = b(bVar, bVar2);
        if (bVar.d() == 6) {
            methodInfoBean.isCustom = true;
        }
        return methodInfoBean;
    }

    private static String b(b bVar, b bVar2) {
        String str = null;
        if (bVar == null) {
            return null;
        }
        if ((bVar.d() == 1 || bVar.d() == 13 || bVar.d() == 14) && (bVar instanceof com.bonree.sdk.k.c)) {
            com.bonree.sdk.k.c cVar = (com.bonree.sdk.k.c) bVar;
            if (cVar == null || ad.a(cVar.q())) {
                return null;
            }
            return cVar.q();
        } else if (bVar.d() != 6 || !(bVar instanceof com.bonree.sdk.k.c)) {
            return null;
        } else {
            if (bVar2 instanceof com.bonree.sdk.k.c) {
                str = ((com.bonree.sdk.k.c) bVar2).v();
            }
            com.bonree.sdk.k.c cVar2 = (com.bonree.sdk.k.c) bVar;
            if (cVar2.v() != null) {
                return (cVar2.v().length() > 0 || str == null) ? cVar2.v() : str;
            }
            return str;
        }
    }

    public List<ThreadMethodInfoBean> a() {
        ArrayList arrayList;
        synchronized (this.b) {
            arrayList = new ArrayList(this.b.values());
        }
        return arrayList;
    }

    public List<ThreadMethodInfoBean> b(long j, long j2) {
        ArrayList arrayList;
        long j3 = j2;
        b(j3);
        synchronized (this.b) {
            arrayList = new ArrayList();
            for (ThreadMethodInfoBean next : this.b.values()) {
                if (!(next == null || next.mMethodInfo == null || next.mMethodInfo.isEmpty())) {
                    ArrayList arrayList2 = new ArrayList();
                    for (MethodInfoBean next2 : next.mMethodInfo) {
                        long j4 = next2.mStartRealTimeMs;
                        long j5 = next2.mEndRealTimeMs;
                        int i = (j4 > j ? 1 : (j4 == j ? 0 : -1));
                        if ((i > 0 || j5 < j || j5 > j3) && ((i < 0 || j5 > j3) && (j4 > j3 || j5 < j3 || i < 0))) {
                            com.bonree.sdk.be.a.a().a("BaseSnapshot %s ThreadMethodInfo filter ct %s st %s mi %s.", getClass().getSimpleName(), Long.valueOf(j), Long.valueOf(j2), next2);
                        } else {
                            arrayList2.add(next2);
                        }
                    }
                    if (arrayList2.size() > 0) {
                        ThreadMethodInfoBean threadMethodInfoBean = new ThreadMethodInfoBean();
                        threadMethodInfoBean.isMain = next.isMain;
                        threadMethodInfoBean.mId = next.mId;
                        threadMethodInfoBean.mName = next.mName;
                        threadMethodInfoBean.mMethodInfo = arrayList2;
                        arrayList.add(threadMethodInfoBean);
                    }
                }
            }
        }
        return arrayList;
    }

    private static void a(List<ThreadMethodInfoBean> list, ThreadMethodInfoBean threadMethodInfoBean, List<MethodInfoBean> list2) {
        ThreadMethodInfoBean threadMethodInfoBean2 = new ThreadMethodInfoBean();
        threadMethodInfoBean2.isMain = threadMethodInfoBean.isMain;
        threadMethodInfoBean2.mId = threadMethodInfoBean.mId;
        threadMethodInfoBean2.mName = threadMethodInfoBean.mName;
        threadMethodInfoBean2.mMethodInfo = list2;
        list.add(threadMethodInfoBean2);
    }

    public final void b() {
        if (!this.b.isEmpty()) {
            synchronized (this.b) {
                this.b.clear();
            }
        }
    }

    public void c() {
        if (!this.c.isEmpty()) {
            synchronized (this.c) {
                this.c.clear();
            }
        }
    }
}
