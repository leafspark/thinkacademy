package com.adyen.threeds2.internal;

import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Consumer;
import com.adyen.threeds2.CompletionEvent;
import com.adyen.threeds2.ProtocolErrorEvent;
import com.adyen.threeds2.RuntimeErrorEvent;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class f implements atd.a.c<atd.d.j> {
    private static f i;
    private atd.b.b a;
    private AtomicInteger b;
    private Timer c;
    private atd.d.i d;
    private atd.d.j e;
    private a f;
    /* access modifiers changed from: private */
    public atd.d.b g;
    private boolean h;

    class a implements Consumer<atd.d.i> {
        final /* synthetic */ atd.d.e a;

        a(atd.d.e eVar) {
            this.a = eVar;
        }

        /* renamed from: a */
        public void accept(atd.d.i iVar) {
            f.this.a((ProtocolErrorEvent) new atd.z.c(iVar.f(), new atd.z.b(iVar.f(), this.a.g(), this.a.h(), this.a.i())));
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                atd.e.d[] r0 = atd.e.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                atd.e.d r1 = atd.e.d.CHALLENGE_RESPONSE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                atd.e.d r1 = atd.e.d.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.threeds2.internal.f.b.<clinit>():void");
        }
    }

    class c implements Consumer<atd.d.i> {
        final /* synthetic */ atd.e.c a;
        final /* synthetic */ String b;

        c(atd.e.c cVar, String str) {
            this.a = cVar;
            this.b = str;
        }

        /* renamed from: a */
        public void accept(atd.d.i iVar) {
            f.this.a((atd.d.i) this.a.a(iVar, this.b));
        }
    }

    class d implements Consumer<atd.d.i> {
        final /* synthetic */ atd.e.c a;
        final /* synthetic */ String b;

        d(atd.e.c cVar, String str) {
            this.a = cVar;
            this.b = str;
        }

        /* renamed from: a */
        public void accept(atd.d.i iVar) {
            f.this.a(this.a.a(iVar.f(), this.b));
        }
    }

    class e implements Consumer<atd.d.j> {
        final /* synthetic */ atd.c.c a;
        final /* synthetic */ String b;

        e(atd.c.c cVar, String str) {
            this.a = cVar;
            this.b = str;
        }

        /* renamed from: a */
        public void accept(atd.d.j jVar) {
            f.this.a((atd.d.i) new atd.d.b(f.this.g.d(), f.this.g.h(), f.this.g.b(), f.this.g.f(), f.this.g.g(), this.a, this.b));
        }
    }

    /* renamed from: com.adyen.threeds2.internal.f$f  reason: collision with other inner class name */
    class C0008f implements Consumer<atd.d.i> {
        C0008f() {
        }

        /* renamed from: a */
        public void accept(atd.d.i iVar) {
            f.this.a((atd.d.i) atd.e.c.TRANSACTION_TIMED_OUT.a(iVar, atd.s0.a.a(-103975527180864L)));
        }
    }

    class g implements Consumer<AtomicInteger> {
        final /* synthetic */ atd.d.i a;

        g(f fVar, atd.d.i iVar) {
            this.a = iVar;
        }

        /* renamed from: a */
        public void accept(AtomicInteger atomicInteger) {
            this.a.a(atomicInteger.getAndIncrement());
        }
    }

    class h implements Consumer<atd.b.b> {
        final /* synthetic */ atd.d.i a;

        h(f fVar, atd.d.i iVar) {
            this.a = iVar;
        }

        /* renamed from: a */
        public void accept(atd.b.b bVar) {
            bVar.a(this.a);
        }
    }

    class i implements Consumer<atd.d.i> {
        i() {
        }

        /* renamed from: a */
        public void accept(atd.d.i iVar) {
            f.this.a(atd.e.c.MESSAGE_RECEIVED_INVALID.a(iVar.f(), atd.s0.a.a(-104233225218624L)));
        }
    }

    class j implements Consumer<atd.d.i> {
        j() {
        }

        /* renamed from: a */
        public void accept(atd.d.i iVar) {
            if (atd.e.d.ERROR.equals(iVar.c())) {
                f.this.a((CompletionEvent) new atd.z.a(iVar.f(), atd.e.e.Y.a()));
            } else {
                f.this.a(atd.e.c.MESSAGE_RECEIVED_INVALID.a(iVar.f(), atd.s0.a.a(-103357051890240L)));
            }
        }
    }

    class k implements Consumer<atd.d.i> {
        final /* synthetic */ atd.d.c a;

        k(atd.d.c cVar) {
            this.a = cVar;
        }

        /* renamed from: a */
        public void accept(atd.d.i iVar) {
            if (!iVar.d().equals(this.a.c())) {
                f.this.a(atd.y.b.MESSAGE_VERSIONS_MISMATCH.a());
            } else if (iVar.e() != this.a.g()) {
                f.this.a(atd.y.b.MESSAGE_INDICES_MISMATCH.a());
            } else if (!this.a.j()) {
                f.this.a(this.a.h());
            } else if (f.this.g()) {
                f.this.a();
            } else {
                f.this.a((CompletionEvent) new atd.z.a(this.a.d(), this.a.i()));
            }
        }
    }

    private static final class l extends TimerTask {

        class a implements Runnable {
            a(l lVar) {
            }

            public void run() {
                f.d().h();
            }
        }

        l() {
        }

        public void run() {
            Handler handler = new Handler(Looper.getMainLooper());
            a aVar = new a(this);
            if (!(handler instanceof Handler)) {
                handler.post(aVar);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, aVar);
            }
        }
    }

    private f() {
    }

    private a c() {
        if (this.h) {
            return this.f;
        }
        return null;
    }

    public static synchronized f d() {
        f fVar;
        synchronized (f.class) {
            if (i == null) {
                i = new f();
            }
            fVar = i;
        }
        return fVar;
    }

    private void e() {
        a c2 = c();
        if (c2 != null) {
            c2.a();
        }
    }

    private void f() {
        a c2 = c();
        if (c2 != null) {
            c2.timedout();
        }
    }

    private boolean i() {
        if (this.h) {
            return false;
        }
        atd.s0.a.a(-103666289535552L);
        return true;
    }

    /* renamed from: b */
    public void a(atd.d.j jVar) {
        a(jVar);
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        atd.d.i iVar = this.d;
        if (!(iVar instanceof atd.d.b)) {
            return false;
        }
        return ((atd.d.b) iVar).j() instanceof atd.c.b;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        if (!i()) {
            a(this.d, new C0008f());
            f();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void b() {
        if (!i()) {
            this.a = null;
            this.b = null;
            Timer timer = this.c;
            if (timer != null) {
                timer.cancel();
                this.c = null;
            }
            this.d = null;
            this.e = null;
            if (this.f != null) {
                this.f = null;
            }
            this.g = null;
            this.h = false;
        }
    }

    public void a(Throwable th, String str) {
        if (th instanceof atd.a0.a) {
            atd.a0.a aVar = (atd.a0.a) th;
            atd.e.c b2 = aVar.b();
            String a2 = aVar.a();
            if (!atd.e.c.SYSTEM_CONNECTION_FAILURE.equals(b2) && !a(aVar)) {
                a(this.d, new c(b2, a2));
            }
            if (atd.e.c.TRANSACTION_TIMED_OUT.equals(b2) || atd.e.c.SYSTEM_CONNECTION_FAILURE.equals(b2)) {
                a(b2.a(a2));
            } else {
                a(this.d, new d(b2, a2));
            }
        } else {
            a(atd.y.b.UNKNOWN.a(str + atd.s0.a.a(-103829498292800L) + th.getLocalizedMessage()));
        }
    }

    private boolean a(atd.a0.a aVar) {
        return aVar.b().equals(atd.e.c.DATA_ELEMENT_INVALID_FORMAT) && aVar.a().contains(atd.s0.a.a(-103820908358208L));
    }

    public void a(atd.c.c cVar, String str) {
        if (!i()) {
            a(this.e, new e(cVar, str));
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, atd.f0.a aVar, atd.d.b bVar, int i2, a aVar2) {
        a(str, aVar, i2, aVar2);
        this.g = bVar;
        a((atd.d.i) bVar);
    }

    private <T> void a(T t, Consumer<T> consumer) {
        if (t != null) {
            consumer.accept(t);
        }
    }

    private synchronized void a(String str, atd.f0.a aVar, int i2, a aVar2) {
        this.a = new atd.b.b(str, aVar, this);
        this.f = aVar2;
        this.b = new AtomicInteger();
        Timer timer = new Timer();
        this.c = timer;
        timer.schedule(new l(), TimeUnit.MINUTES.toMillis((long) i2));
        this.h = true;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        a c2;
        if (!i() && (c2 = c()) != null) {
            c2.cancelled();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(atd.d.i iVar) {
        if (!i()) {
            if (iVar instanceof atd.d.b) {
                e();
            }
            a(this.b, new g(this, iVar));
            this.d = iVar;
            a(this.a, new h(this, iVar));
        }
    }

    private void a(atd.d.j jVar) {
        if (!i()) {
            if (jVar != null) {
                this.e = jVar;
                int i2 = b.a[jVar.b().ordinal()];
                if (i2 == 1) {
                    a((atd.d.c) jVar);
                } else if (i2 != 2) {
                    a(this.d, new i());
                } else {
                    a((atd.d.e) jVar);
                }
            } else {
                a(this.d, new j());
            }
        }
    }

    private void a(atd.d.c cVar) {
        a(this.d, new k(cVar));
    }

    private void a(atd.d.e eVar) {
        a(this.d, new a(eVar));
    }

    /* access modifiers changed from: package-private */
    public void a(atd.d.a aVar) {
        a c2 = c();
        if (c2 != null) {
            c2.a(aVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(CompletionEvent completionEvent) {
        a c2 = c();
        if (c2 != null) {
            c2.completed(completionEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ProtocolErrorEvent protocolErrorEvent) {
        a c2 = c();
        if (c2 != null) {
            c2.protocolError(protocolErrorEvent);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(RuntimeErrorEvent runtimeErrorEvent) {
        a c2 = c();
        if (c2 != null) {
            c2.runtimeError(runtimeErrorEvent);
        }
    }
}
