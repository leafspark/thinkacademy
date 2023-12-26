package com.wushuangtech.jni;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class NetTestJni {
    private static NetTestJni mNetTestJni;
    private List<WeakReference<NetTestJniCallback>> mCallBacks = new ArrayList();

    public interface NetTestJniCallback {
        void OnNetTestCallback(int i);
    }

    public native void StartTest();

    public native void StopTest();

    public native boolean initialize(NetTestJni netTestJni);

    public native void unInitialize();

    private NetTestJni() {
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
    public static synchronized com.wushuangtech.jni.NetTestJni getInstance() {
        /*
            java.lang.Class<com.wushuangtech.jni.NetTestJni> r0 = com.wushuangtech.jni.NetTestJni.class
            monitor-enter(r0)
            com.wushuangtech.jni.NetTestJni r1 = mNetTestJni     // Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x0027
            monitor-enter(r0)     // Catch:{ all -> 0x002b }
            com.wushuangtech.jni.NetTestJni r1 = mNetTestJni     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x0022
            com.wushuangtech.jni.NetTestJni r1 = new com.wushuangtech.jni.NetTestJni     // Catch:{ all -> 0x0024 }
            r1.<init>()     // Catch:{ all -> 0x0024 }
            mNetTestJni = r1     // Catch:{ all -> 0x0024 }
            boolean r1 = r1.initialize(r1)     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x001a
            goto L_0x0022
        L_0x001a:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0024 }
            java.lang.String r2 = "can't initilaize NetTestJni"
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
            com.wushuangtech.jni.NetTestJni r1 = mNetTestJni     // Catch:{ all -> 0x002b }
            monitor-exit(r0)
            return r1
        L_0x002b:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.jni.NetTestJni.getInstance():com.wushuangtech.jni.NetTestJni");
    }

    public static synchronized void destroyInstance() {
        synchronized (NetTestJni.class) {
            NetTestJni netTestJni = mNetTestJni;
            if (netTestJni != null) {
                netTestJni.StopTest();
                mNetTestJni.unInitialize();
                mNetTestJni = null;
            }
        }
    }

    public void addCallback(NetTestJniCallback netTestJniCallback) {
        this.mCallBacks.add(new WeakReference(netTestJniCallback));
    }

    public void removeCallback(NetTestJniCallback netTestJniCallback) {
        int i = 0;
        while (i < this.mCallBacks.size()) {
            WeakReference weakReference = this.mCallBacks.get(i);
            if (weakReference == null || weakReference.get() == null || weakReference.get() != netTestJniCallback) {
                i++;
            } else {
                this.mCallBacks.remove(weakReference);
                return;
            }
        }
    }

    private void OnNetTestCallback(int i) {
        for (int i2 = 0; i2 < this.mCallBacks.size(); i2++) {
            WeakReference weakReference = this.mCallBacks.get(i2);
            if (!(weakReference == null || weakReference.get() == null)) {
                ((NetTestJniCallback) weakReference.get()).OnNetTestCallback(i);
            }
        }
    }
}
