package com.bonree.sdk.g;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class a<DATA, SERVICE> {
    protected ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    protected List<SERVICE> services = Collections.synchronizedList(new ArrayList());

    public abstract void notifyService(DATA data);

    /* access modifiers changed from: protected */
    public void startEngine() {
    }

    /* access modifiers changed from: protected */
    public void stopEngine() {
    }

    public void registerService(SERVICE service) {
        this.readWriteLock.writeLock().lock();
        try {
            if (!this.services.contains(service)) {
                this.services.add(service);
            }
            if (this.services.size() == 1) {
                startEngine();
            }
        } finally {
            this.readWriteLock.writeLock().unlock();
        }
    }

    public void unRegisterService(SERVICE service) {
        this.readWriteLock.writeLock().lock();
        try {
            if (!this.services.isEmpty()) {
                this.services.remove(service);
            }
            if (isEmptyServices()) {
                stopEngine();
            }
        } finally {
            this.readWriteLock.writeLock().unlock();
        }
    }

    public boolean isEmptyServices() {
        List<SERVICE> list = this.services;
        return list == null || list.isEmpty();
    }
}
