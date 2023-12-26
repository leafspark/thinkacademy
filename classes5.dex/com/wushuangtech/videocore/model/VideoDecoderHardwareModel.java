package com.wushuangtech.videocore.model;

import android.text.TextUtils;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.videocore.bean.VideoDecoderHardwareBean;
import com.wushuangtech.videocore.inter.OnVideoDecoderHardwareListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoDecoderHardwareModel implements OnVideoDecoderHardwareListener {
    private static final String TAG = "VideoDecoderHardwareModel";
    private int decoderCreatedCounts;
    private HashMap<String, Integer> decoderCreatedTimes = new HashMap<>();
    private int decoderStopFailedCounts;
    private HashMap<String, Integer> decoderStopFailedTimes = new HashMap<>();
    private List<VideoDecoderHardwareBean> hardwareDecoders = new ArrayList();

    public synchronized void hardwareDecoderCreated(VideoDecoderHardwareBean videoDecoderHardwareBean) {
        if (videoDecoderHardwareBean != null) {
            if (!TextUtils.isEmpty(videoDecoderHardwareBean.mediaCodecAddress)) {
                this.decoderCreatedCounts++;
                List<VideoDecoderHardwareBean> list = this.hardwareDecoders;
                if (list != null) {
                    list.add(videoDecoderHardwareBean);
                }
                if (this.decoderCreatedTimes != null && !TextUtils.isEmpty(videoDecoderHardwareBean.deviceId)) {
                    Integer num = this.decoderCreatedTimes.get(videoDecoderHardwareBean.deviceId);
                    if (num == null) {
                        this.decoderCreatedTimes.put(videoDecoderHardwareBean.deviceId, 1);
                    } else {
                        this.decoderCreatedTimes.put(videoDecoderHardwareBean.deviceId, Integer.valueOf(num.intValue() + 1));
                    }
                }
                buildDebugMsg();
            }
        }
    }

    public synchronized void hardwareDecoderDestory(VideoDecoderHardwareBean videoDecoderHardwareBean) {
        Integer num;
        if (videoDecoderHardwareBean != null) {
            if (!TextUtils.isEmpty(videoDecoderHardwareBean.mediaCodecAddress)) {
                if (this.hardwareDecoders != null) {
                    int i = 0;
                    while (true) {
                        if (i >= this.hardwareDecoders.size()) {
                            i = -1;
                            break;
                        }
                        VideoDecoderHardwareBean videoDecoderHardwareBean2 = this.hardwareDecoders.get(i);
                        if (videoDecoderHardwareBean2.mediaCodecAddress != null && videoDecoderHardwareBean2.mediaCodecAddress.equals(videoDecoderHardwareBean.mediaCodecAddress)) {
                            break;
                        }
                        i++;
                    }
                    if (i != -1) {
                        this.hardwareDecoders.remove(i);
                    }
                    if (!(this.decoderCreatedTimes == null || TextUtils.isEmpty(videoDecoderHardwareBean.deviceId) || (num = this.decoderCreatedTimes.get(videoDecoderHardwareBean.deviceId)) == null)) {
                        if (num.intValue() <= 1) {
                            this.decoderCreatedTimes.remove(videoDecoderHardwareBean.deviceId);
                        } else {
                            this.decoderCreatedTimes.put(videoDecoderHardwareBean.deviceId, Integer.valueOf(num.intValue() - 1));
                        }
                    }
                }
                buildDebugMsg();
            }
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public synchronized void hardwareDecoderStopFailed(com.wushuangtech.videocore.bean.VideoDecoderHardwareBean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            monitor-enter(r3)     // Catch:{ all -> 0x0055 }
            if (r4 != 0) goto L_0x0007
            monitor-exit(r3)     // Catch:{ all -> 0x0052 }
            monitor-exit(r3)
            return
        L_0x0007:
            java.lang.String r0 = r4.mediaCodecAddress     // Catch:{ all -> 0x0052 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r3)     // Catch:{ all -> 0x0052 }
            monitor-exit(r3)
            return
        L_0x0012:
            int r0 = r3.decoderStopFailedCounts     // Catch:{ all -> 0x0052 }
            r1 = 1
            int r0 = r0 + r1
            r3.decoderStopFailedCounts = r0     // Catch:{ all -> 0x0052 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r3.decoderStopFailedTimes     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x004c
            java.lang.String r0 = r4.deviceId     // Catch:{ all -> 0x0052 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0052 }
            if (r0 != 0) goto L_0x004c
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r3.decoderStopFailedTimes     // Catch:{ all -> 0x0052 }
            java.lang.String r2 = r4.deviceId     // Catch:{ all -> 0x0052 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0052 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x0052 }
            if (r0 != 0) goto L_0x003c
            java.util.HashMap<java.lang.String, java.lang.Integer> r0 = r3.decoderStopFailedTimes     // Catch:{ all -> 0x0052 }
            java.lang.String r4 = r4.deviceId     // Catch:{ all -> 0x0052 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0052 }
            r0.put(r4, r1)     // Catch:{ all -> 0x0052 }
            goto L_0x004c
        L_0x003c:
            int r0 = r0.intValue()     // Catch:{ all -> 0x0052 }
            int r0 = r0 + r1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0052 }
            java.util.HashMap<java.lang.String, java.lang.Integer> r1 = r3.decoderStopFailedTimes     // Catch:{ all -> 0x0052 }
            java.lang.String r4 = r4.deviceId     // Catch:{ all -> 0x0052 }
            r1.put(r4, r0)     // Catch:{ all -> 0x0052 }
        L_0x004c:
            monitor-exit(r3)     // Catch:{ all -> 0x0052 }
            r3.buildDebugMsg()     // Catch:{ all -> 0x0055 }
            monitor-exit(r3)
            return
        L_0x0052:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0052 }
            throw r4     // Catch:{ all -> 0x0055 }
        L_0x0055:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.videocore.model.VideoDecoderHardwareModel.hardwareDecoderStopFailed(com.wushuangtech.videocore.bean.VideoDecoderHardwareBean):void");
    }

    public synchronized void clear() {
        this.hardwareDecoders.clear();
        this.hardwareDecoders = null;
        this.decoderCreatedTimes.clear();
        this.decoderCreatedTimes = null;
        this.decoderStopFailedTimes.clear();
        this.decoderStopFailedTimes = null;
        this.decoderCreatedCounts = 0;
        this.decoderStopFailedCounts = 0;
    }

    private void buildDebugMsg() {
        String str = TAG;
        OmniLog.d(str, "decoder create count : " + this.decoderCreatedCounts + " | stop failed count : " + this.decoderStopFailedCounts);
        List<VideoDecoderHardwareBean> list = this.hardwareDecoders;
        HashMap<String, Integer> hashMap = this.decoderCreatedTimes;
        HashMap<String, Integer> hashMap2 = this.decoderStopFailedTimes;
        if (list != null) {
            OmniLog.d(str, "size : " + list.size());
            for (VideoDecoderHardwareBean videoDecoderHardwareBean : this.hardwareDecoders) {
                String str2 = TAG;
                OmniLog.d(str2, "iterator element : " + videoDecoderHardwareBean.toString());
            }
        }
        if (hashMap != null) {
            for (Map.Entry next : hashMap.entrySet()) {
                String str3 = TAG;
                OmniLog.d(str3, "decoderCreatedTimes -> iterator element : " + ((String) next.getKey()) + " | " + ((Integer) next.getValue()));
            }
        }
        if (hashMap2 != null) {
            for (Map.Entry next2 : hashMap2.entrySet()) {
                String str4 = TAG;
                OmniLog.d(str4, "decoderStopFailedTimes -> iterator element : " + ((String) next2.getKey()) + " | " + ((Integer) next2.getValue()));
            }
        }
    }
}
