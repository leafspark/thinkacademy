package com.sensorsdata.analytics.android.sdk;

import java.util.concurrent.TimeUnit;

class EventTimer {
    private long endTime;
    private long eventAccumulatedDuration;
    private boolean isPaused = false;
    private long startTime;
    private final TimeUnit timeUnit;

    EventTimer(TimeUnit timeUnit2, long j) {
        this.startTime = j;
        this.timeUnit = timeUnit2;
        this.eventAccumulatedDuration = 0;
        this.endTime = -1;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a A[Catch:{ Exception -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005f A[Catch:{ Exception -> 0x0076 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String duration() {
        /*
            r7 = this;
            boolean r0 = r7.isPaused
            r1 = 0
            if (r0 == 0) goto L_0x000b
            long r3 = r7.startTime
            r7.endTime = r3
            goto L_0x0017
        L_0x000b:
            long r3 = r7.endTime
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0015
            long r3 = android.os.SystemClock.elapsedRealtime()
        L_0x0015:
            r7.endTime = r3
        L_0x0017:
            long r3 = r7.endTime
            long r5 = r7.startTime
            long r3 = r3 - r5
            long r5 = r7.eventAccumulatedDuration
            long r3 = r3 + r5
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            r1 = 0
            if (r0 < 0) goto L_0x0071
            r5 = 86400000(0x5265c00, double:4.2687272E-316)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x002c
            goto L_0x0071
        L_0x002c:
            java.util.concurrent.TimeUnit r0 = r7.timeUnit     // Catch:{ Exception -> 0x0076 }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x0076 }
            if (r0 != r2) goto L_0x0034
        L_0x0032:
            float r0 = (float) r3     // Catch:{ Exception -> 0x0076 }
            goto L_0x0055
        L_0x0034:
            java.util.concurrent.TimeUnit r0 = r7.timeUnit     // Catch:{ Exception -> 0x0076 }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x0076 }
            r5 = 1148846080(0x447a0000, float:1000.0)
            if (r0 != r2) goto L_0x003f
            float r0 = (float) r3     // Catch:{ Exception -> 0x0076 }
            float r0 = r0 / r5
            goto L_0x0055
        L_0x003f:
            java.util.concurrent.TimeUnit r0 = r7.timeUnit     // Catch:{ Exception -> 0x0076 }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MINUTES     // Catch:{ Exception -> 0x0076 }
            r6 = 1114636288(0x42700000, float:60.0)
            if (r0 != r2) goto L_0x004b
            float r0 = (float) r3     // Catch:{ Exception -> 0x0076 }
            float r0 = r0 / r5
        L_0x0049:
            float r0 = r0 / r6
            goto L_0x0055
        L_0x004b:
            java.util.concurrent.TimeUnit r0 = r7.timeUnit     // Catch:{ Exception -> 0x0076 }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.HOURS     // Catch:{ Exception -> 0x0076 }
            if (r0 != r2) goto L_0x0032
            float r0 = (float) r3     // Catch:{ Exception -> 0x0076 }
            float r0 = r0 / r5
            float r0 = r0 / r6
            goto L_0x0049
        L_0x0055:
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x005f
            java.lang.String r0 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0076 }
            goto L_0x0070
        L_0x005f:
            java.util.Locale r2 = java.util.Locale.CHINA     // Catch:{ Exception -> 0x0076 }
            java.lang.String r3 = "%.3f"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0076 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ Exception -> 0x0076 }
            r4[r1] = r0     // Catch:{ Exception -> 0x0076 }
            java.lang.String r0 = java.lang.String.format(r2, r3, r4)     // Catch:{ Exception -> 0x0076 }
        L_0x0070:
            return r0
        L_0x0071:
            java.lang.String r0 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0076 }
            return r0
        L_0x0076:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            java.lang.String r0 = java.lang.String.valueOf(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.EventTimer.duration():java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public long getStartTime() {
        return this.startTime;
    }

    /* access modifiers changed from: package-private */
    public void setStartTime(long j) {
        this.startTime = j;
    }

    /* access modifiers changed from: package-private */
    public void setEndTime(long j) {
        this.endTime = j;
    }

    /* access modifiers changed from: package-private */
    public long getEndTime() {
        return this.endTime;
    }

    /* access modifiers changed from: package-private */
    public long getEventAccumulatedDuration() {
        return this.eventAccumulatedDuration;
    }

    /* access modifiers changed from: package-private */
    public void setEventAccumulatedDuration(long j) {
        this.eventAccumulatedDuration = j;
    }

    /* access modifiers changed from: package-private */
    public void setTimerState(boolean z, long j) {
        this.isPaused = z;
        if (z) {
            this.eventAccumulatedDuration = (this.eventAccumulatedDuration + j) - this.startTime;
        }
        this.startTime = j;
    }

    /* access modifiers changed from: package-private */
    public boolean isPaused() {
        return this.isPaused;
    }
}
