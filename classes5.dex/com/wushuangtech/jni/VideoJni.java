package com.wushuangtech.jni;

import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class VideoJni {
    private static VideoJni mVideoJni;
    private List<WeakReference<VideoJniCallback>> mCallBacks = new ArrayList();

    public interface VideoJniCallback {
        void OnSetSei(long j, String str);
    }

    public native void EnableVideoDev(String str, int i);

    public native void RtmpAddAudio(String str, long j, int i, String str2);

    public native void RtmpAddVideo(String str, long j, String str2, int i, String str3);

    public native void RtmpSetH264Sei(String str, String str2, String str3, String str4);

    public native void RtmpSetSubVideoPosRation(long j, String str, double d, double d2, double d3, double d4);

    public native void VideoChangeDefaultMediaType(String str, int i);

    public native void VideoCloseDevice(String str, long j, int i);

    public native void VideoCloseDevice(String str, long j, String str2);

    public native void VideoCloseMixer(String str, String str2);

    public native void VideoOpenDevice(String str, long j, int i);

    public native void VideoOpenDevice(String str, long j, String str2);

    public native void VideoOpenMixer(String str, String str2);

    public native void VideoSetLocalCapParam(String str, int i, int i2, int i3);

    public native void VideoUpdateDefaultDevice(String str, boolean z);

    public native boolean initialize(VideoJni videoJni);

    public native void unInitialize();

    private VideoJni() {
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
    public static synchronized com.wushuangtech.jni.VideoJni getInstance() {
        /*
            java.lang.Class<com.wushuangtech.jni.VideoJni> r0 = com.wushuangtech.jni.VideoJni.class
            monitor-enter(r0)
            com.wushuangtech.jni.VideoJni r1 = mVideoJni     // Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x0027
            monitor-enter(r0)     // Catch:{ all -> 0x002b }
            com.wushuangtech.jni.VideoJni r1 = mVideoJni     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x0022
            com.wushuangtech.jni.VideoJni r1 = new com.wushuangtech.jni.VideoJni     // Catch:{ all -> 0x0024 }
            r1.<init>()     // Catch:{ all -> 0x0024 }
            mVideoJni = r1     // Catch:{ all -> 0x0024 }
            boolean r1 = r1.initialize(r1)     // Catch:{ all -> 0x0024 }
            if (r1 == 0) goto L_0x001a
            goto L_0x0022
        L_0x001a:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0024 }
            java.lang.String r2 = "can't initilaize VideoJni"
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
            com.wushuangtech.jni.VideoJni r1 = mVideoJni     // Catch:{ all -> 0x002b }
            monitor-exit(r0)
            return r1
        L_0x002b:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.jni.VideoJni.getInstance():com.wushuangtech.jni.VideoJni");
    }

    public void addCallback(VideoJniCallback videoJniCallback) {
        this.mCallBacks.add(new WeakReference(videoJniCallback));
    }

    public void removeCallback(VideoJniCallback videoJniCallback) {
        int i = 0;
        while (i < this.mCallBacks.size()) {
            WeakReference weakReference = this.mCallBacks.get(i);
            if (weakReference == null || weakReference.get() == null || weakReference.get() != videoJniCallback) {
                i++;
            } else {
                this.mCallBacks.remove(weakReference);
                return;
            }
        }
    }

    private void OnSetSei(long j, String str) {
        OmniLog.jniCall("OnSetSei", "operUserId : " + j + " | sei : " + str + " | trunOnCallback : " + GlobalHolder.trunOnCallback);
        if (GlobalHolder.trunOnCallback) {
            for (int i = 0; i < this.mCallBacks.size(); i++) {
                WeakReference weakReference = this.mCallBacks.get(i);
                if (!(weakReference == null || weakReference.get() == null)) {
                    ((VideoJniCallback) weakReference.get()).OnSetSei(j, str);
                }
            }
        }
    }
}
