package com.amazonaws.util;

import com.amazonaws.ResponseMetadata;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseMetadataCache {
    private final InternalCache internalCache;

    public ResponseMetadataCache(int i) {
        this.internalCache = new InternalCache(i);
    }

    public synchronized void add(Object obj, ResponseMetadata responseMetadata) {
        if (obj != null) {
            this.internalCache.put(Integer.valueOf(System.identityHashCode(obj)), responseMetadata);
        }
    }

    public ResponseMetadata get(Object obj) {
        return (ResponseMetadata) this.internalCache.get(Integer.valueOf(System.identityHashCode(obj)));
    }

    private static final class InternalCache extends LinkedHashMap<Integer, ResponseMetadata> {
        private int maxSize;

        public InternalCache(int i) {
            super(i);
            this.maxSize = i;
        }

        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry entry) {
            return size() > this.maxSize;
        }
    }
}
