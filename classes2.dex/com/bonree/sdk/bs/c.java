package com.bonree.sdk.bs;

import com.google.firebase.messaging.ServiceStarter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class c extends f {
    Object a;
    private f b;
    private CountDownLatch c;
    private a d;
    private int e;

    public interface a {
        Object a();
    }

    public c(int i, a aVar) {
        this(i, aVar, (byte) 0);
    }

    private c(int i, a aVar, byte b2) {
        this(i, "CDL", aVar, new CountDownLatch(1));
    }

    private c(int i, String str, a aVar, CountDownLatch countDownLatch) {
        super(str);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = ServiceStarter.ERROR_UNKNOWN;
        this.a = null;
        this.c = countDownLatch;
        this.d = aVar;
        if (i > 0) {
            this.e = i;
        }
    }

    public final void a() {
        try {
            start();
            CountDownLatch countDownLatch = this.c;
            if (countDownLatch != null && countDownLatch.getCount() > 0) {
                this.c.await((long) this.e, TimeUnit.MILLISECONDS);
            }
        } catch (Throwable unused) {
        }
    }

    public final void run() {
        a aVar = this.d;
        if (aVar != null) {
            this.a = aVar.a();
        }
        CountDownLatch countDownLatch = this.c;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public final Object b() {
        return this.a;
    }
}
