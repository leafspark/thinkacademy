package com.bonree.sdk.ap;

import android.os.SystemClock;
import com.bonree.sdk.agent.business.entity.LagEventInfoBean;
import com.bonree.sdk.agent.business.entity.ThreadDumpInfoBean;
import com.bonree.sdk.an.a;
import com.huawei.multimedia.audiokit.config.ResultCode;

final class d implements Runnable {
    private /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        if (this.a.g != null && this.a.g.e() && a.w != null) {
            ThreadDumpInfoBean a2 = a.a(true);
            if (a2 == null) {
                com.bonree.sdk.be.a.a().a("LagService dumpInfo mOnceDumpInfo is null", new Object[0]);
                return;
            }
            ThreadDumpInfoBean unused = this.a.t = a2;
            com.bonree.sdk.be.a.a().a("LagService dumpInfo mOnceDumpInfo %s, time is %s ms", this.a.t, Long.valueOf(SystemClock.uptimeMillis()));
            LagEventInfoBean lagEventInfoBean = new LagEventInfoBean();
            lagEventInfoBean.mLagTimeUs = this.a.g.a() - ((long) (((this.a.d.get() * ResultCode.KARAOKE_SUCCESS) - this.a.l) * ResultCode.KARAOKE_SUCCESS));
            a aVar = this.a;
            a.a(aVar, aVar.t, lagEventInfoBean);
        }
    }
}
