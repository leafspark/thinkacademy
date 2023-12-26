package com.bonree.sdk.agent.engine.network.okhttp3.external;

import com.bonree.sdk.be.f;
import okhttp3.Call;
import okhttp3.EventListener;

public class Ok3EventFactory implements EventListener.Factory {
    private EventListener.Factory a;

    static class a {
        /* access modifiers changed from: private */
        public static final Ok3EventFactory a = new Ok3EventFactory();

        private a() {
        }
    }

    private static Ok3EventFactory a() {
        return a.a;
    }

    public final void a(EventListener.Factory factory) {
        if (factory != null && !(factory instanceof Ok3EventFactory)) {
            f a2 = com.bonree.sdk.be.a.a();
            a2.c("User EventFactory is " + factory, new Object[0]);
            this.a = factory;
        }
    }

    public EventListener create(Call call) {
        EventListener eventListener;
        try {
            eventListener = EventListener.NONE;
        } catch (Throwable unused) {
            eventListener = null;
        }
        EventListener.Factory factory = this.a;
        if (factory != null) {
            eventListener = factory.create(call);
            if (this.a.getClass().toString().contains("com.tencent")) {
                return eventListener;
            }
        }
        return new Ok3EventListener(eventListener);
    }
}
