package com.wushuangtech.jni;

import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ReportLogJni {
    private static ReportLogJni mReportLogJni;
    private List<WeakReference<ReportLogJniCallback>> mCallBacks = new ArrayList();

    public interface ReportLogJniCallback {
        void OnReportFireEvent(long j);

        void OnUpdateReportLogConfig(boolean z, boolean z2, int i);
    }

    public native void ReportLog(String str, int i, String str2);

    public native boolean initialize(ReportLogJni reportLogJni);

    public native void setupLogConnection(String str);

    public native void unInitialize();

    private ReportLogJni() {
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
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized com.wushuangtech.jni.ReportLogJni getInstance() {
        /*
            java.lang.Class<com.wushuangtech.jni.ReportLogJni> r0 = com.wushuangtech.jni.ReportLogJni.class
            monitor-enter(r0)
            com.wushuangtech.jni.ReportLogJni r1 = mReportLogJni     // Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x0027
            monitor-enter(r0)     // Catch:{ all -> 0x002b }
            com.wushuangtech.jni.ReportLogJni r1 = mReportLogJni     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x0022
            com.wushuangtech.jni.ReportLogJni r1 = new com.wushuangtech.jni.ReportLogJni     // Catch:{ all -> 0x0024 }
            r1.<init>()     // Catch:{ all -> 0x0024 }
            mReportLogJni = r1     // Catch:{ all -> 0x0024 }
            boolean r1 = r1.initialize(r1)     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x001a
            goto L_0x0022
        L_0x001a:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0024 }
            java.lang.String r2 = "can't initilaize ReportLogJni"
            r1.<init>(r2)     // Catch:{ all -> 0x0024 }
            throw r1     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            goto L_0x0027
        L_0x0024:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0024 }
            throw r1     // Catch:{ all -> 0x002b }
        L_0x0027:
            com.wushuangtech.jni.ReportLogJni r1 = mReportLogJni     // Catch:{ all -> 0x002b }
            monitor-exit(r0)
            return r1
        L_0x002b:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.jni.ReportLogJni.getInstance():com.wushuangtech.jni.ReportLogJni");
    }

    public void addCallback(ReportLogJniCallback reportLogJniCallback) {
        this.mCallBacks.add(new WeakReference(reportLogJniCallback));
    }

    public void removeCallback(ReportLogJniCallback reportLogJniCallback) {
        int i = 0;
        while (i < this.mCallBacks.size()) {
            WeakReference weakReference = this.mCallBacks.get(i);
            if (weakReference == null || weakReference.get() == null || weakReference.get() != reportLogJniCallback) {
                i++;
            } else {
                this.mCallBacks.remove(weakReference);
                return;
            }
        }
    }

    private void OnUpdateReportLogConfig(boolean z, boolean z2, int i) {
        OmniLog.jniCall("OnUpdateReportLogConfig", "reportData : " + z + " | reportEvent : " + z2 + " | reportInterval : " + i + " | trunOnCallback: " + GlobalHolder.trunOnCallback);
        if (GlobalHolder.trunOnCallback) {
            for (int i2 = 0; i2 < this.mCallBacks.size(); i2++) {
                WeakReference weakReference = this.mCallBacks.get(i2);
                if (!(weakReference == null || weakReference.get() == null)) {
                    ((ReportLogJniCallback) weakReference.get()).OnUpdateReportLogConfig(z, z2, i);
                }
            }
        }
    }

    private void OnReportLogFireEvent(long j) {
        if (GlobalHolder.trunOnCallback) {
            for (int i = 0; i < this.mCallBacks.size(); i++) {
                WeakReference weakReference = this.mCallBacks.get(i);
                if (!(weakReference == null || weakReference.get() == null)) {
                    ((ReportLogJniCallback) weakReference.get()).OnReportFireEvent(j);
                }
            }
        }
    }
}
