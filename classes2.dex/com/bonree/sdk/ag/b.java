package com.bonree.sdk.ag;

import java.util.Comparator;

final class b implements Comparator<Thread> {
    private /* synthetic */ Thread a;

    b(Thread thread) {
        this.a = thread;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        Thread thread = (Thread) obj;
        Thread thread2 = (Thread) obj2;
        if (thread == thread2) {
            return 0;
        }
        Thread thread3 = this.a;
        if (thread == thread3) {
            return 1;
        }
        if (thread2 == thread3) {
            return -1;
        }
        return thread2.getName().compareTo(thread.getName());
    }

    private int a(Thread thread, Thread thread2) {
        if (thread == thread2) {
            return 0;
        }
        Thread thread3 = this.a;
        if (thread == thread3) {
            return 1;
        }
        if (thread2 == thread3) {
            return -1;
        }
        return thread2.getName().compareTo(thread.getName());
    }
}
