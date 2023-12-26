package com.bonree.sdk.ad;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bonree.sdk.ad.a;
import com.bonree.sdk.agent.business.entity.EventBean;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class g<T extends a> extends Handler {
    private static int c = 1000;
    private static final int d = 200;
    protected final List<EventBean> a;
    private final WeakReference<T> b;

    public g(Looper looper, T t) {
        super(looper);
        this.b = new WeakReference<>(t);
        this.a = Collections.synchronizedList(new ArrayList());
    }

    public void handleMessage(Message message) {
        if (this.b.get() != null) {
            ((a) this.b.get()).a(message);
        }
    }

    public final void b(EventBean eventBean) {
        if (eventBean != null) {
            synchronized (this.a) {
                if (this.a.size() >= d) {
                    this.a.remove(0);
                }
                this.a.add(eventBean);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        if (!this.a.isEmpty()) {
            synchronized (this.a) {
                this.a.clear();
            }
        }
    }

    private g(Looper looper) {
        super(looper);
    }
}
