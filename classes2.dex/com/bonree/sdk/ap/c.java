package com.bonree.sdk.ap;

import android.os.SystemClock;
import com.bonree.sdk.agent.business.entity.ThreadDumpInfoBean;
import com.bonree.sdk.an.a;
import com.huawei.multimedia.audiokit.config.ResultCode;

final class c implements Runnable {
    private /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        if (this.a.g != null && this.a.g.e() && a.w != null) {
            if (this.a.u == null || !this.a.F) {
                ThreadDumpInfoBean a2 = a.a(true);
                if (a2 == null) {
                    com.bonree.sdk.be.a.a().a("LagService dumpInfo mImportantDumpInfo is null", new Object[0]);
                    return;
                }
                com.bonree.sdk.be.a.a().a("LagService dumpInfo mImportantDumpInfo %s, time is %s ms", a2, Long.valueOf(SystemClock.uptimeMillis()));
                if (!this.a.a(a2)) {
                    synchronized (a.class) {
                        ThreadDumpInfoBean unused = this.a.u = a2;
                        a aVar = this.a;
                        long unused2 = aVar.H = aVar.g.a() - ((long) (((ResultCode.KARAOKE_SUCCESS / this.a.b.get()) * 10) * ResultCode.KARAOKE_SUCCESS));
                    }
                }
            }
        }
    }
}
