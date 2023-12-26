package com.bonree.sdk.k;

import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.bonree.sdk.bs.q;
import com.bonree.sdk.g.b;
import java.util.ArrayList;
import java.util.Arrays;
import ohos.agp.components.Component;
import ohos.eventhandler.EventRunner;

public final class d extends com.bonree.sdk.g.a<c, b> {
    private static final String c = "startActivity";
    private static final String d = "startActivities";
    private static final ArrayList<Integer> e = new ArrayList<>();
    private static final int f = 1;
    private final a a;
    private final ArrayList<String> b;

    /* synthetic */ d(byte b2) {
        this();
    }

    public final /* bridge */ /* synthetic */ void registerService(Object obj) {
        super.registerService((b) obj);
    }

    private d() {
        this.b = new ArrayList<>(Arrays.asList(new String[]{"android.app.Fragment", "androidx.fragment.app.Fragment", "androidx.fragment.app.DialogFragment", "androidx.fragment.app.ListFragment"}));
        this.a = new a();
    }

    static class a {
        /* access modifiers changed from: private */
        public static final d a = new d((byte) 0);

        private a() {
        }
    }

    public static d a() {
        return a.a;
    }

    /* access modifiers changed from: protected */
    public final void startEngine() {
        super.startEngine();
        com.bonree.sdk.be.a.a().c("method engine is start.", new Object[0]);
    }

    public final void a(b bVar) {
        super.registerService(bVar);
    }

    /* access modifiers changed from: protected */
    public final void stopEngine() {
        super.stopEngine();
        com.bonree.sdk.be.a.a().c("method engine is stop.", new Object[0]);
    }

    public static void a(String str, Object[] objArr) {
        if (c.equals(str) || d.equals(str)) {
            a.a.a(str, a(objArr), 0);
        }
    }

    public static void b(String str, Object[] objArr) {
        if (c.equals(str) || d.equals(str)) {
            a.a.a(str, a(objArr), 1);
        }
    }

    private static Intent[] a(Object[] objArr) {
        try {
            int length = objArr.length;
            int i = 0;
            while (i < length) {
                Intent[] intentArr = objArr[i];
                if (intentArr instanceof Intent) {
                    return new Intent[]{(Intent) intentArr};
                } else if (intentArr instanceof Intent[]) {
                    return intentArr;
                } else {
                    i++;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private void a(String str, Intent[] intentArr, int i) {
        if (!isEmptyServices()) {
            c cVar = new c();
            cVar.c(str);
            cVar.a(10);
            cVar.b(i);
            cVar.a(intentArr);
            cVar.a(com.bonree.sdk.d.a.b());
            cVar.b(com.bonree.sdk.d.a.l());
            boolean z = true;
            if (!com.bonree.sdk.d.a.L() ? Looper.myLooper() != Looper.getMainLooper() : EventRunner.current() != EventRunner.getMainEventRunner()) {
                z = false;
            }
            cVar.a(z);
            cVar.d(Thread.currentThread().getName());
            notifyService(cVar);
        }
    }

    private void a(String str, long j, int i, int i2) {
        if (!isEmptyServices()) {
            c cVar = new c();
            cVar.c(str);
            cVar.a(11);
            boolean z = true;
            cVar.a(new int[]{i});
            cVar.b(i2);
            cVar.a(com.bonree.sdk.d.a.b());
            cVar.b(com.bonree.sdk.d.a.l());
            cVar.e(String.valueOf(j));
            if (!com.bonree.sdk.d.a.L() ? Looper.myLooper() != Looper.getMainLooper() : EventRunner.current() != EventRunner.getMainEventRunner()) {
                z = false;
            }
            cVar.a(z);
            cVar.d(Thread.currentThread().getName());
            cVar.c(b.a.START_ASYNC.a());
            notifyService(cVar);
        }
    }

    private void a(String str, int i, int i2) {
        if (!isEmptyServices()) {
            c cVar = new c();
            cVar.c(str);
            cVar.a(12);
            boolean z = true;
            cVar.a(new int[]{i});
            cVar.a(com.bonree.sdk.d.a.b());
            cVar.b(com.bonree.sdk.d.a.l());
            cVar.b(i2);
            if (!com.bonree.sdk.d.a.L() ? Looper.myLooper() != Looper.getMainLooper() : EventRunner.current() != EventRunner.getMainEventRunner()) {
                z = false;
            }
            cVar.a(z);
            cVar.d(Thread.currentThread().getName());
            cVar.c(b.a.TASK_EXEC.a());
            notifyService(cVar);
        }
    }

    private void b(String str, long j, int i, int i2) {
        if (!isEmptyServices()) {
            c cVar = new c();
            cVar.c(str);
            cVar.a(11);
            cVar.b(i2);
            cVar.e(String.valueOf(j));
            boolean z = true;
            cVar.a(new int[]{i});
            cVar.a(com.bonree.sdk.d.a.b());
            cVar.b(com.bonree.sdk.d.a.l());
            if (!com.bonree.sdk.d.a.L() ? Looper.myLooper() != Looper.getMainLooper() : EventRunner.current() != EventRunner.getMainEventRunner()) {
                z = false;
            }
            cVar.a(z);
            cVar.d(Thread.currentThread().getName());
            cVar.c(b.a.START_ASYNC.a());
            notifyService(cVar);
        }
    }

    private void a(String str, int i, int i2, int i3, int i4) {
        if (!isEmptyServices()) {
            c cVar = new c();
            cVar.c(str);
            cVar.a(12);
            cVar.b(i4);
            boolean z = false;
            cVar.a(new int[]{i, i2, i3});
            cVar.a(com.bonree.sdk.d.a.b());
            cVar.b(com.bonree.sdk.d.a.l());
            if (!com.bonree.sdk.d.a.L() ? Looper.myLooper() == Looper.getMainLooper() : EventRunner.current() == EventRunner.getMainEventRunner()) {
                z = true;
            }
            cVar.a(z);
            cVar.d(Thread.currentThread().getName());
            cVar.c(b.a.TASK_EXEC.a());
            notifyService(cVar);
        }
    }

    public final void a(String str, String str2, int i) {
        a(str, str2, i, 0);
    }

    public final void a(String str, String str2, int i, String str3, String str4) {
        a(str, str2, i, 0, str3, str4);
    }

    public final void a(String str, String str2, int i, String str3, String str4, int i2) {
        a(str, str2, i, 0, str3, str4, i2);
    }

    public final void b(String str, String str2, int i) {
        a(str, str2, i, 1);
    }

    public final void b(String str, String str2, int i, String str3, String str4) {
        a(str, str2, i, 1, str3, str4);
    }

    public final void b(String str, String str2, int i, String str3, String str4, int i2) {
        a(str, str2, i, 1, str3, str4, i2);
    }

    public final void a(Object obj, Object obj2) {
        this.a.a(obj).b(obj2);
        a(obj2, "onClick", 0, obj);
    }

    public final void b() {
        a(this.a.b(), "onClick", 1, this.a.a());
    }

    public final void b(Object obj, Object obj2) {
        this.a.a(obj).b(obj2);
        a(obj2, "onItemClicked", 0, obj);
    }

    public final void c() {
        a(this.a.b(), "onItemClicked", 1, this.a.a());
    }

    public final void a(View view, int i, Object obj) {
        if (view == null) {
            view = new View(com.bonree.sdk.bs.a.a());
        }
        this.a.a((Object) view).b(obj);
        view.setContentDescription("onItemSelected " + i);
        a(obj, "onItemSelected", 0, (Object) view);
    }

    public final void d() {
        a(this.a.b(), "onItemSelected", 1, this.a.a());
    }

    public static void a(int i, Object obj) {
        if (1 == i && obj != null) {
            e.add(Integer.valueOf(System.identityHashCode(obj)));
        }
    }

    public final void b(int i, Object obj) {
        try {
            if (com.bonree.sdk.d.a.L()) {
                new Component(q.a()).setComponentDescription("Pageslider position " + i);
            } else if (obj != null && (obj instanceof View)) {
                ((View) obj).setContentDescription("ViewPager position " + i);
            }
            this.a.a(obj).b(obj);
            String str = "onPageSelected";
            if (e.contains(Integer.valueOf(System.identityHashCode(obj)))) {
                str = "onPageScroll";
            }
            a(obj, str, 0, obj);
        } catch (Exception unused) {
        }
    }

    public final void e() {
        Object a2 = this.a.a();
        Object b2 = this.a.b();
        a(b2, e.remove(Integer.valueOf(System.identityHashCode(b2))) ? "onPageScroll" : "onPageSelected", 1, a2);
    }

    public final void c(Object obj, Object obj2) {
        View a2 = this.a.a(obj, com.bonree.sdk.bs.a.a());
        this.a.a((Object) a2).b(obj2);
        a(obj2, "onMenuItemClick", 0, (Object) a2);
    }

    public final void f() {
        a(this.a.b(), "onMenuItemClick", 1, this.a.a());
    }

    public final void d(Object obj, Object obj2) {
        View a2 = this.a.a(obj, com.bonree.sdk.bs.a.a());
        this.a.a((Object) a2).b(obj2);
        a(obj2, "onOptionsItemSelected", 0, (Object) a2);
    }

    public final void g() {
        a(this.a.b(), "onOptionsItemSelected", 1, this.a.a());
    }

    public final void a(String str, String str2) {
        a(com.bonree.sdk.d.a.L() ? com.bonree.sdk.x.b.a().b() : com.bonree.sdk.z.b.a().b(), str, 6, 0, str2);
    }

    public final void b(String str, String str2) {
        a(com.bonree.sdk.d.a.L() ? com.bonree.sdk.x.b.a().b() : com.bonree.sdk.z.b.a().b(), str, 6, 1, str2);
    }

    private void a(String str, String str2, int i, int i2) {
        a(str, str2, i, i2, (String) null);
    }

    private void a(String str, String str2, int i, int i2, String str3) {
        a(str, str2, i, i2, (String) null, (Object) null, 0, (String) null, str3);
    }

    private void a(Object obj, String str, int i, Object obj2) {
        String str2;
        String str3 = "";
        String name = obj2 instanceof View ? ((View) obj2).getContext().getClass().getName() : str3;
        if (TextUtils.isEmpty(name)) {
            if (obj != null) {
                str3 = obj.toString();
            }
            if (obj != null && str3.contains("class ")) {
                name = str3.substring(str3.indexOf(" ") + 1);
            } else if (!(obj == null || obj.getClass().getSuperclass() == null)) {
                if (this.b.contains(obj.getClass().getSuperclass().getName())) {
                    name = obj.getClass().getName();
                }
            }
        }
        if (TextUtils.isEmpty(name)) {
            if (com.bonree.sdk.d.a.L()) {
                str2 = com.bonree.sdk.x.b.a().b();
            } else {
                str2 = com.bonree.sdk.z.b.a().b();
            }
            name = str2;
        }
        a(name, str, 5, i, (String) null, obj2, 0, (String) null, (String) null);
    }

    private void a(String str, String str2, int i, int i2, String str3, String str4) {
        a(str, str2, i, i2, str3, (Object) null, 0, str4, (String) null);
    }

    private void a(String str, String str2, int i, int i2, String str3, String str4, int i3) {
        a(str, str2, i, i2, str3, (Object) null, 0, str4, (String) null, i3);
    }

    private void a(String str, String str2, int i, int i2, String str3, Object obj, int i3, String str4, String str5) {
        a(str, str2, i, i2, str3, obj, 0, str4, str5, 0);
    }

    private void a(String str, String str2, int i, int i2, String str3, Object obj, int i3, String str4, String str5, int i4) {
        if (!isEmptyServices()) {
            c cVar = new c();
            cVar.a(str);
            boolean z = true;
            if ("onPageScroll".equals(str2)) {
                cVar.c("onPageSelected");
                cVar.b(true);
            } else {
                cVar.c(str2);
            }
            cVar.a(i);
            cVar.b(i2);
            cVar.a(com.bonree.sdk.d.a.b());
            cVar.b(com.bonree.sdk.d.a.l());
            cVar.d(Thread.currentThread().getName());
            if (!com.bonree.sdk.d.a.L() ? Looper.myLooper() != Looper.getMainLooper() : EventRunner.current() != EventRunner.getMainEventRunner()) {
                z = false;
            }
            cVar.a(z);
            if (str3 != null) {
                cVar.g(str3);
            }
            if (str4 != null) {
                cVar.h(str4);
            }
            if (obj != null) {
                cVar.i(a.c(obj));
                cVar.j(this.a.a(obj, "onClick"));
                cVar.k(obj.getClass().getSimpleName());
                cVar.m(this.a.e(obj));
                cVar.n(a.d(obj));
            }
            if (i3 > 0) {
                cVar.d(i3);
            }
            if (str5 != null) {
                cVar.l(str5);
            }
            cVar.e(i4);
            notifyService(cVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void notifyService(c cVar) {
        this.readWriteLock.readLock().lock();
        try {
            for (b a2 : this.services) {
                a2.a(cVar);
            }
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    public static void a(String str, long j, int i) {
        a.a.a(str, j, i, 0);
    }

    public static void b(String str, long j, int i) {
        a.a.a(str, j, i, 1);
    }

    public static void a(String str, int i) {
        a.a.a(str, i, 0);
    }

    public static void b(String str, int i) {
        a.a.a(str, i, 1);
    }

    public static void c(String str, long j, int i) {
        a.a.b(str, j, i, 0);
    }

    public static void d(String str, long j, int i) {
        a.a.b(str, j, i, 1);
    }

    public static void a(String str, int i, int i2, int i3) {
        a.a.a(str, i, i2, i3, 0);
    }

    public static void a(String str) {
        a.a.a(str, 0, 0, 0, 1);
    }
}
