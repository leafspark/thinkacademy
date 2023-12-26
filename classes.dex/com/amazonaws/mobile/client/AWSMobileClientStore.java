package com.amazonaws.mobile.client;

import com.amazonaws.internal.keyvaluestore.AWSKeyValueStore;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

final class AWSMobileClientStore implements KeyValueStore {
    private final AWSKeyValueStore mAWSKeyValueStore;
    private final ReadWriteLock mReadWriteLock = new ReentrantReadWriteLock();

    AWSMobileClientStore(AWSMobileClient aWSMobileClient) {
        this.mAWSKeyValueStore = new AWSKeyValueStore(aWSMobileClient.mContext, "com.amazonaws.mobile.client", aWSMobileClient.mIsPersistenceEnabled);
    }

    public Map<String, String> get(String... strArr) {
        try {
            this.mReadWriteLock.readLock().lock();
            HashMap hashMap = new HashMap();
            for (String str : strArr) {
                hashMap.put(str, this.mAWSKeyValueStore.get(str));
            }
            return hashMap;
        } finally {
            this.mReadWriteLock.readLock().unlock();
        }
    }

    public String get(String str) {
        try {
            this.mReadWriteLock.readLock().lock();
            return this.mAWSKeyValueStore.get(str);
        } finally {
            this.mReadWriteLock.readLock().unlock();
        }
    }

    public void set(Map<String, String> map) {
        try {
            this.mReadWriteLock.writeLock().lock();
            for (String next : map.keySet()) {
                this.mAWSKeyValueStore.put(next, map.get(next));
            }
        } finally {
            this.mReadWriteLock.writeLock().unlock();
        }
    }

    public void set(String str, String str2) {
        try {
            this.mReadWriteLock.writeLock().lock();
            this.mAWSKeyValueStore.put(str, str2);
        } finally {
            this.mReadWriteLock.writeLock().unlock();
        }
    }

    public void clear() {
        this.mAWSKeyValueStore.clear();
    }
}
