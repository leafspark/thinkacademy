package com.xueersi.lib.graffiti.view;

import android.util.SparseArray;
import com.xueersi.lib.graffiti.WorkExecutor;

public class DrawingExecutorGroup {
    private SparseArray<WorkExecutor> map = new SparseArray<>();

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.xueersi.lib.graffiti.WorkExecutor getExecutorByCanvasId(int r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            android.util.SparseArray<com.xueersi.lib.graffiti.WorkExecutor> r0 = r3.map     // Catch:{ all -> 0x0032 }
            if (r0 != 0) goto L_0x000d
            java.lang.String r4 = "绘制线程组已经销毁"
            com.xueersi.lib.graffiti.utils.XesLog.d(r4)     // Catch:{ all -> 0x0032 }
            r4 = 0
            monitor-exit(r3)
            return r4
        L_0x000d:
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0032 }
            com.xueersi.lib.graffiti.WorkExecutor r0 = (com.xueersi.lib.graffiti.WorkExecutor) r0     // Catch:{ all -> 0x0032 }
            if (r0 != 0) goto L_0x0030
            com.xueersi.lib.graffiti.WorkExecutor r0 = new com.xueersi.lib.graffiti.WorkExecutor     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0032 }
            r1.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = "GraffitiDrawingThread_"
            r1.append(r2)     // Catch:{ all -> 0x0032 }
            r1.append(r4)     // Catch:{ all -> 0x0032 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0032 }
            r0.<init>(r1)     // Catch:{ all -> 0x0032 }
            android.util.SparseArray<com.xueersi.lib.graffiti.WorkExecutor> r1 = r3.map     // Catch:{ all -> 0x0032 }
            r1.put(r4, r0)     // Catch:{ all -> 0x0032 }
        L_0x0030:
            monitor-exit(r3)
            return r0
        L_0x0032:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xueersi.lib.graffiti.view.DrawingExecutorGroup.getExecutorByCanvasId(int):com.xueersi.lib.graffiti.WorkExecutor");
    }

    public synchronized void destroy() {
        SparseArray<WorkExecutor> sparseArray = this.map;
        if (sparseArray != null && sparseArray.size() > 0) {
            for (int i = 0; i < this.map.size(); i++) {
                WorkExecutor valueAt = this.map.valueAt(i);
                if (valueAt != null) {
                    valueAt.destroy();
                }
            }
            this.map.clear();
            this.map = null;
        }
    }
}
