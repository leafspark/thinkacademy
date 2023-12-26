package com.igexin.b.a.d;

import com.igexin.b.a.d.a.e;
import java.util.concurrent.ConcurrentLinkedQueue;

public class c {
    private final ConcurrentLinkedQueue<e> a;
    private final ConcurrentLinkedQueue<e> b = new ConcurrentLinkedQueue<>();
    private ConcurrentLinkedQueue<e> c;

    public c() {
        ConcurrentLinkedQueue<e> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.a = concurrentLinkedQueue;
        this.c = concurrentLinkedQueue;
    }

    public synchronized void a() {
        this.c = this.a;
    }

    public synchronized void a(e eVar) {
        this.c.offer(eVar);
    }

    public synchronized void b() {
        ConcurrentLinkedQueue<e> concurrentLinkedQueue = this.b;
        this.c = concurrentLinkedQueue;
        concurrentLinkedQueue.addAll(this.a);
        this.a.clear();
    }

    public synchronized boolean c() {
        return this.c.isEmpty();
    }

    public synchronized e d() {
        return this.c.poll();
    }
}
