package com.eaydu.omni.log;

import com.eaydu.omni.log.bean.StatsCaculation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LogCommonInfo {
    private static volatile LogCommonInfo singleton;
    private final Map<String, Integer> mVolumeMap = Collections.synchronizedMap(new HashMap());
    private final Map<String, StatsCaculation> mmapStats = Collections.synchronizedMap(new HashMap());

    private LogCommonInfo() {
    }

    public static LogCommonInfo getInstance() {
        if (singleton == null) {
            synchronized (LogCommonInfo.class) {
                if (singleton == null) {
                    singleton = new LogCommonInfo();
                }
            }
        }
        return singleton;
    }

    public synchronized void updateVolume(String str, int i) {
        this.mVolumeMap.put(str, Integer.valueOf(i));
    }

    public synchronized void removeVolume(String str) {
        this.mVolumeMap.remove(str);
    }

    public synchronized int getVolume(String str) {
        Integer num = this.mVolumeMap.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public synchronized int getVolumeAndReset(String str) {
        int intValue;
        Integer num = this.mVolumeMap.get(str);
        intValue = num != null ? num.intValue() : 0;
        this.mVolumeMap.put(str, 0);
        return intValue;
    }

    public synchronized void clearVolumes() {
        this.mVolumeMap.clear();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void LogStaticLocalVideoStats(java.lang.String r4, com.eaydu.omni.log.bean.LogVideoLocalStatistics r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r5 != 0) goto L_0x0005
            monitor-exit(r3)
            return
        L_0x0005:
            java.util.Map<java.lang.String, com.eaydu.omni.log.bean.StatsCaculation> r0 = r3.mmapStats     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            com.eaydu.omni.log.bean.StatsCaculation r0 = (com.eaydu.omni.log.bean.StatsCaculation) r0     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            if (r0 != 0) goto L_0x001d
            com.eaydu.omni.log.bean.StatsCaculation r0 = new com.eaydu.omni.log.bean.StatsCaculation     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            r0.<init>()     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            long r1 = r5.uid     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            r0.uid = r1     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            java.util.Map<java.lang.String, com.eaydu.omni.log.bean.StatsCaculation> r1 = r3.mmapStats     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            r1.put(r4, r0)     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
        L_0x001d:
            int r4 = r5.sentBitrate     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            long r1 = (long) r4     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            r0.videoBps = r1     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            int r4 = r5.sentFrameRate     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            r0.videoFps = r4     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            int r4 = r5.videoTargetBps     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            long r1 = (long) r4     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            r0.videoTargetBps = r1     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            int r4 = r5.videoTargetFps     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            float r4 = (float) r4     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            r0.videoTargetFps = r4     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            int r4 = r5.videoEncoded     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            r0.videoEncoded = r4     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            int r4 = r5.mVideoLossRate     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            long r1 = (long) r4     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            r0.videoLost = r1     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            int r4 = r5.vRtt     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            r0.vRtt = r4     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            int r4 = r5.encodedFrameWidth     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            r0.videoWidth = r4     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            int r4 = r5.encodedFrameHeight     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            r0.videoHeight = r4     // Catch:{ Exception -> 0x0049, all -> 0x0046 }
            goto L_0x0049
        L_0x0046:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x0049:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.log.LogCommonInfo.LogStaticLocalVideoStats(java.lang.String, com.eaydu.omni.log.bean.LogVideoLocalStatistics):void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void LogStaticLocalAudioStats(java.lang.String r4, com.eaydu.omni.log.bean.LogAudioLocalStatistics r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r5 != 0) goto L_0x0005
            monitor-exit(r3)
            return
        L_0x0005:
            java.util.Map<java.lang.String, com.eaydu.omni.log.bean.StatsCaculation> r0 = r3.mmapStats     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            com.eaydu.omni.log.bean.StatsCaculation r0 = (com.eaydu.omni.log.bean.StatsCaculation) r0     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            if (r0 != 0) goto L_0x001d
            com.eaydu.omni.log.bean.StatsCaculation r0 = new com.eaydu.omni.log.bean.StatsCaculation     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            r0.<init>()     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            long r1 = r5.uid     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            r0.uid = r1     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            java.util.Map<java.lang.String, com.eaydu.omni.log.bean.StatsCaculation> r1 = r3.mmapStats     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            r1.put(r4, r0)     // Catch:{ Exception -> 0x002f, all -> 0x002c }
        L_0x001d:
            int r4 = r5.audioLossRate     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            long r1 = (long) r4     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            r0.audioLost = r1     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            int r4 = r5.aRtt     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            r0.aRtt = r4     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            int r4 = r5.sentBitrate     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            long r4 = (long) r4     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            r0.audioBps = r4     // Catch:{ Exception -> 0x002f, all -> 0x002c }
            goto L_0x002f
        L_0x002c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x002f:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.eaydu.omni.log.LogCommonInfo.LogStaticLocalAudioStats(java.lang.String, com.eaydu.omni.log.bean.LogAudioLocalStatistics):void");
    }

    public synchronized StatsCaculation getPublishInfo(String str) {
        return this.mmapStats.get(str);
    }

    public synchronized void clearPublishInfo() {
        this.mmapStats.clear();
    }
}
