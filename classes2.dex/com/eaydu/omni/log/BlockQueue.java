package com.eaydu.omni.log;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockQueue<T> {
    private BlockingDeque<T> blockingDeque = new LinkedBlockingDeque(5000);

    public void add(T t) {
        try {
            this.blockingDeque.put(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public T remove() {
        try {
            return this.blockingDeque.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
