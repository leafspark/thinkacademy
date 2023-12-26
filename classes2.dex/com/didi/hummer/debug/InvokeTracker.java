package com.didi.hummer.debug;

import java.text.SimpleDateFormat;
import java.util.Arrays;

public class InvokeTracker {
    public long beginTime;
    public String className;
    public String desc;
    public long endTime;
    public String methodName;
    public long objectID;
    public Object[] params;
    public long timeCost;
    public String timeFormat;
    public long timestamp;

    public InvokeTracker start(String str, long j, String str2, Object[] objArr) {
        this.beginTime = System.nanoTime();
        this.timestamp = System.currentTimeMillis();
        this.timeFormat = new SimpleDateFormat("HH:mm:ss.SSS").format(Long.valueOf(this.timestamp));
        this.className = str;
        this.objectID = j;
        this.methodName = str2;
        this.params = objArr;
        if (str2.startsWith("constructor") && objArr.length > 0) {
            this.params = Arrays.copyOfRange(objArr, 1, objArr.length);
        }
        return this;
    }

    public InvokeTracker stop() {
        long nanoTime = System.nanoTime();
        this.endTime = nanoTime;
        this.timeCost = nanoTime - this.beginTime;
        return this;
    }
}
