package com.bonree.sdk.ap;

import android.os.SystemClock;
import com.bonree.sdk.agent.business.entity.ThreadDumpInfoBean;
import com.bonree.sdk.an.a;
import com.huawei.multimedia.audiokit.config.ResultCode;

final class b implements Runnable {
    private /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        if (this.a.g != null && this.a.g.e() && a.w != null && this.a.u == null && this.a.s == null && this.a.e.get() == this.a.c.get() - 1) {
            ThreadDumpInfoBean a2 = a.a(true);
            if (a2 == null) {
                com.bonree.sdk.be.a.a().a("LagService dumpInfo mDumpInfo is null", new Object[0]);
                return;
            }
            com.bonree.sdk.be.a.a().a("LagService dumpInfo mDumpInfo %s, time is %s ms", a2, Long.valueOf(SystemClock.uptimeMillis()));
            if (!this.a.a(a2)) {
                synchronized (a.class) {
                    ThreadDumpInfoBean unused = this.a.s = a2;
                    a aVar = this.a;
                    long unused2 = aVar.I = aVar.g.a() - ((long) ((ResultCode.KARAOKE_SUCCESS / this.a.b.get()) * ResultCode.KARAOKE_SUCCESS));
                }
            }
        }
    }
}
