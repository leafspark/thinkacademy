package atd.a;

import android.os.Handler;
import android.os.Looper;
import atd.d.j;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.util.concurrent.Callable;

public final class d<T extends j> implements Runnable {
    /* access modifiers changed from: private */
    public final c<T> a;
    private final Callable<T> b;

    class a implements Runnable {
        final /* synthetic */ j a;

        a(j jVar) {
            this.a = jVar;
        }

        public void run() {
            d.this.a.a(this.a);
        }
    }

    class b implements Runnable {
        final /* synthetic */ Exception a;
        final /* synthetic */ String b;

        b(Exception exc, String str) {
            this.a = exc;
            this.b = str;
        }

        public void run() {
            d.this.a.a(this.a, this.b);
        }
    }

    public d(c<T> cVar, Callable<T> callable) {
        this.a = cVar;
        this.b = callable;
    }

    public void run() {
        try {
            a((j) this.b.call());
        } catch (Exception e) {
            a(e, atd.s0.a.a(-102918965226048L));
        }
    }

    private void a(T t) {
        a((Runnable) new a(t));
    }

    private void a(Exception exc, String str) {
        a((Runnable) new b(exc, str));
    }

    private void a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        if (!(handler instanceof Handler)) {
            handler.post(runnable);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, runnable);
        }
    }
}
