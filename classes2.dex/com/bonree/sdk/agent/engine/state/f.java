package com.bonree.sdk.agent.engine.state;

import com.bonree.sdk.at.c;
import com.bonree.sdk.ba.p;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class f extends com.bonree.sdk.g.a<e, i> {
    protected final AtomicInteger activeActivityCount = new AtomicInteger(0);
    protected boolean isRegisterSuccessful;
    protected boolean mHappenBackground = false;
    protected String mViewName = "";

    public abstract String getViewName();

    /* access modifiers changed from: protected */
    public abstract void register();

    public abstract void setViewName(Object obj);

    /* access modifiers changed from: protected */
    public abstract void unRegister();

    public void registerService(i iVar) {
        super.registerService(iVar);
        register();
    }

    public void unRegisterService(i iVar) {
        super.unRegisterService(iVar);
        unRegister();
    }

    public void notifyService(e eVar) {
        try {
            this.readWriteLock.readLock().lock();
            if (eVar != null) {
                com.bonree.sdk.be.a.a().c("AppStateEngine AppState is: %s", eVar);
                for (i iVar : this.services) {
                    if (iVar instanceof c) {
                        iVar.a(eVar);
                    }
                }
                for (i iVar2 : this.services) {
                    if (iVar2 instanceof p) {
                        iVar2.a(eVar);
                    }
                }
                for (i iVar3 : this.services) {
                    if (!(iVar3 instanceof c) && !(iVar3 instanceof p)) {
                        iVar3.a(eVar);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.readWriteLock.readLock().unlock();
    }

    static class a {
        private static volatile f a;
        /* access modifiers changed from: private */
        public static final f b = (a == null ? new a() : a);

        private a() {
        }

        static {
            if (com.bonree.sdk.d.a.L()) {
                try {
                    a = (f) Class.forName("com.bonree.sdk.agent.engine.state.HarmonyAppStateEngine").newInstance();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static f getEngine() {
        return a.b;
    }
}
