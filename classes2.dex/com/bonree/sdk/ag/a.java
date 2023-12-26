package com.bonree.sdk.ag;

import android.os.Looper;
import com.bonree.sdk.ag.e;
import java.util.Map;
import java.util.TreeMap;

public final class a extends Error {
    private a(e.a aVar) {
        super("Application Not Responding", aVar);
    }

    public static a a() {
        String str;
        Thread thread = Looper.getMainLooper().getThread();
        TreeMap treeMap = new TreeMap(new b(thread));
        Thread currentThread = Thread.currentThread();
        for (Map.Entry next : Thread.getAllStackTraces().entrySet()) {
            if (currentThread != next.getKey()) {
                treeMap.put(next.getKey(), next.getValue());
            }
        }
        if (thread != null && !treeMap.containsKey(thread)) {
            treeMap.put(thread, thread.getStackTrace());
        }
        e.a aVar = null;
        for (Map.Entry entry : treeMap.entrySet()) {
            Thread thread2 = (Thread) entry.getKey();
            if (thread2 == null) {
                str = "unknow thread";
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("\"" + thread2.getName() + "\"");
                sb.append(thread2.isDaemon() ? " daemon" : "");
                sb.append(" prio = " + thread2.getPriority());
                sb.append(" tid = " + thread2.getId());
                sb.append(" " + thread2.getState());
                str = sb.toString();
            }
            aVar = new e.a(aVar);
        }
        return new a(aVar);
    }

    private static String a(Thread thread) {
        if (thread == null) {
            return "unknow thread";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\"" + thread.getName() + "\"");
        sb.append(thread.isDaemon() ? " daemon" : "");
        sb.append(" prio = " + thread.getPriority());
        sb.append(" tid = " + thread.getId());
        sb.append(" " + thread.getState());
        return sb.toString();
    }

    public final synchronized Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
