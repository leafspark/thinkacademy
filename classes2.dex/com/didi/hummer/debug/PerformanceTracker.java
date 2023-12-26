package com.didi.hummer.debug;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PerformanceTracker {
    public long beginTime;
    public long endTime;
    public long invokeCost;
    public long otherCost;
    public List<Map.Entry<String, TimeCost>> sortTimeCostList;
    public List<String> sourceCallStack;
    public Map<String, TimeCost> timeCostMap = new HashMap();
    public String timeFormat;
    public long timestamp;
    public long totalCost;
    public List<InvokeTracker> trackerList = new ArrayList();

    public static class TimeCost {
        public long cost;
        public int count;

        public void increase(long j) {
            this.count++;
            this.cost += j;
        }
    }

    public PerformanceTracker start() {
        this.beginTime = System.nanoTime();
        this.timestamp = System.currentTimeMillis();
        this.timeFormat = new SimpleDateFormat("HH:mm:ss.SSS").format(Long.valueOf(this.timestamp));
        this.sourceCallStack = getSourceCallStack(Thread.currentThread().getStackTrace());
        return this;
    }

    public PerformanceTracker track(InvokeTracker invokeTracker) {
        this.trackerList.add(invokeTracker);
        this.invokeCost += invokeTracker.timeCost;
        String str = invokeTracker.className + "." + invokeTracker.methodName;
        TimeCost timeCost = this.timeCostMap.get(str);
        if (timeCost == null) {
            timeCost = new TimeCost();
            this.timeCostMap.put(str, timeCost);
        }
        timeCost.increase(invokeTracker.timeCost);
        return this;
    }

    public PerformanceTracker stop() {
        long nanoTime = System.nanoTime();
        this.endTime = nanoTime;
        long j = nanoTime - this.beginTime;
        this.totalCost = j;
        this.otherCost = j - this.invokeCost;
        ArrayList arrayList = new ArrayList(this.timeCostMap.entrySet());
        this.sortTimeCostList = arrayList;
        Collections.sort(arrayList, PerformanceTracker$$ExternalSyntheticLambda0.INSTANCE);
        return this;
    }

    static /* synthetic */ int lambda$stop$0(Map.Entry entry, Map.Entry entry2) {
        return -Long.compare(((TimeCost) entry.getValue()).cost, ((TimeCost) entry2.getValue()).cost);
    }

    private List<String> getSourceCallStack(StackTraceElement[] stackTraceElementArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String stackTraceElement2 = stackTraceElement.toString();
            if ((stackTraceElement2.contains("evaluateJavaScript(Native Method)") || stackTraceElement2.contains("evaluateBytecode(Native Method)") || stackTraceElement2.contains("callFunction(Native Method)")) && i + 4 < stackTraceElementArr.length) {
                for (int i2 = 0; i2 <= 4; i2++) {
                    arrayList.add(stackTraceElementArr[i + i2].toString());
                }
            }
            i++;
        }
        return arrayList;
    }
}
