package com.bonree.sdk.agent.engine.crash.anr;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import com.bonree.sdk.bs.f;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class d extends f {
    private static final int a = 5000;
    private static final b j = new f();
    private static final a k = new g();
    private b b;
    private a c;
    private final Handler d;
    /* access modifiers changed from: private */
    public AtomicInteger e;
    private AtomicBoolean f;
    private int g;
    private boolean h;
    private final Runnable i;

    public interface a {
        void a();
    }

    public interface b {
        void a(com.bonree.sdk.ag.a aVar);
    }

    public d() {
        this(a);
    }

    private d(int i2) {
        super("AnrWatchDog");
        this.b = j;
        this.c = k;
        this.d = new Handler(Looper.getMainLooper());
        this.e = new AtomicInteger(0);
        this.f = new AtomicBoolean(false);
        this.h = false;
        this.i = new e(this);
        this.g = a;
    }

    public final void run() {
        int i2 = -1;
        while (!this.f.get() && !isInterrupted()) {
            int i3 = this.e.get();
            this.d.post(this.i);
            try {
                Thread.sleep((long) this.g);
            } catch (InterruptedException unused) {
            }
            if (this.e.get() == i3) {
                if (this.h || !Debug.isDebuggerConnected()) {
                    this.b.a(com.bonree.sdk.ag.a.a());
                } else {
                    if (this.e.get() != i2) {
                        com.bonree.sdk.be.a.a().d("%s", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                    }
                    i2 = this.e.get();
                }
            }
        }
    }

    private boolean b() {
        return this.f.get();
    }

    public final void a() {
        this.f.compareAndSet(false, true);
    }

    private d a(boolean z) {
        this.h = z;
        return this;
    }

    public final d a(b bVar) {
        this.b = bVar;
        return this;
    }

    private d a(a aVar) {
        if (aVar != null) {
            this.c = aVar;
        }
        return this;
    }
}
