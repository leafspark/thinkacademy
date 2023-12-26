package com.didi.hummer.pool;

import com.didi.hummer.lifecycle.IFullLifeCycle;
import com.didi.hummer.lifecycle.ILifeCycle;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ComponentPool implements ObjectPool, IFullLifeCycle {
    private ConcurrentHashMap<Long, Object> mInstance = new ConcurrentHashMap<>();

    public void onCreate() {
    }

    public void put(long j, Object obj) {
        if (obj != null) {
            this.mInstance.put(Long.valueOf(j), obj);
        }
    }

    public <T> T get(long j) {
        return this.mInstance.get(Long.valueOf(j));
    }

    public <T> T remove(long j) {
        return this.mInstance.remove(Long.valueOf(j));
    }

    public void onStart() {
        for (Map.Entry<Long, Object> value : this.mInstance.entrySet()) {
            Object value2 = value.getValue();
            if (value2 instanceof IFullLifeCycle) {
                ((IFullLifeCycle) value2).onStart();
            }
        }
    }

    public void onResume() {
        for (Map.Entry<Long, Object> value : this.mInstance.entrySet()) {
            Object value2 = value.getValue();
            if (value2 instanceof IFullLifeCycle) {
                ((IFullLifeCycle) value2).onResume();
            }
        }
    }

    public void onPause() {
        for (Map.Entry<Long, Object> value : this.mInstance.entrySet()) {
            Object value2 = value.getValue();
            if (value2 instanceof IFullLifeCycle) {
                ((IFullLifeCycle) value2).onPause();
            }
        }
    }

    public void onStop() {
        for (Map.Entry<Long, Object> value : this.mInstance.entrySet()) {
            Object value2 = value.getValue();
            if (value2 instanceof IFullLifeCycle) {
                ((IFullLifeCycle) value2).onStop();
            }
        }
    }

    public void onDestroy() {
        Iterator<Map.Entry<Long, Object>> it = this.mInstance.entrySet().iterator();
        while (it.hasNext()) {
            Object value = it.next().getValue();
            it.remove();
            if (value instanceof ILifeCycle) {
                ((ILifeCycle) value).onDestroy();
            }
        }
    }
}
