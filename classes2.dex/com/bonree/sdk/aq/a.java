package com.bonree.sdk.aq;

import com.bonree.sdk.agent.business.entity.BaseEventInfo;
import com.bonree.sdk.agent.business.entity.EventBean;
import com.bonree.sdk.agent.business.entity.LaunchEventInfoBean;
import com.bonree.sdk.agent.engine.state.e;
import com.bonree.sdk.k.c;

abstract class a implements f {
    protected final g a;
    protected volatile int b;
    protected long c;
    protected EventBean d;

    public void a(long j, long j2) {
    }

    public void a(com.bonree.sdk.aa.a aVar) {
    }

    public void a(e eVar) {
    }

    public void a(b bVar) {
    }

    public void a(c cVar) {
    }

    public a(g gVar) {
        this.a = gVar;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(long j) {
        try {
            EventBean eventBean = new EventBean();
            this.d = eventBean;
            eventBean.mEventType = BaseEventInfo.EVENT_TYPE_LAUNCH;
            this.d.mEventTime = this.a.a(j);
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().e("LaunchService onStartPackage is error %s.", th.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public void b(long j) {
        try {
            EventBean eventBean = this.d;
            eventBean.mStateIndex = eventBean.getStateIndex();
            BaseEventInfo baseEventInfo = this.d.mEventInfo;
            LaunchEventInfoBean launchEventInfoBean = baseEventInfo == null ? new LaunchEventInfoBean() : (LaunchEventInfoBean) baseEventInfo;
            launchEventInfoBean.mIsSlow = Boolean.FALSE;
            this.d.mEventInfo = launchEventInfoBean;
            this.d.uploadStateKey();
        } catch (Throwable th) {
            com.bonree.sdk.be.a.a().e("LaunchService onClosePackage is error %s.", th.getMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean c(long j) {
        return this.b >= 0 && j > ((long) this.b) && this.a.d() != null;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i) {
        this.b = i;
    }
}
