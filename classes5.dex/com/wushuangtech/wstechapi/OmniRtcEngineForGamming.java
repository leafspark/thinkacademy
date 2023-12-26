package com.wushuangtech.wstechapi;

import android.content.Context;
import android.view.SurfaceView;
import com.wushuangtech.wstechapi.bean.VideoCanvas;

public final class OmniRtcEngineForGamming {
    private static OmniRtcEngineForGamming mInstance;
    private OmniRtcEngine mOmniRtcEngine;

    public boolean isChatAudioPlaying() {
        return false;
    }

    private OmniRtcEngineForGamming(Context context, String str, OmniRtcEngineEventHandler omniRtcEngineEventHandler) {
        this.mOmniRtcEngine = OmniRtcEngine.create(context, str, omniRtcEngineEventHandler);
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
    public static synchronized com.wushuangtech.wstechapi.OmniRtcEngineForGamming create(android.content.Context r2, java.lang.String r3, com.wushuangtech.wstechapi.OmniRtcEngineEventHandler r4) {
        /*
            java.lang.Class<com.wushuangtech.wstechapi.OmniRtcEngineForGamming> r0 = com.wushuangtech.wstechapi.OmniRtcEngineForGamming.class
            monitor-enter(r0)
            com.wushuangtech.wstechapi.OmniRtcEngineForGamming r1 = mInstance     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            com.wushuangtech.wstechapi.OmniRtcEngineForGamming r1 = mInstance     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            com.wushuangtech.wstechapi.OmniRtcEngineForGamming r1 = new com.wushuangtech.wstechapi.OmniRtcEngineForGamming     // Catch:{ all -> 0x0015 }
            r1.<init>(r2, r3, r4)     // Catch:{ all -> 0x0015 }
            mInstance = r1     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r2     // Catch:{ all -> 0x001c }
        L_0x0018:
            com.wushuangtech.wstechapi.OmniRtcEngineForGamming r2 = mInstance     // Catch:{ all -> 0x001c }
            monitor-exit(r0)
            return r2
        L_0x001c:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.wstechapi.OmniRtcEngineForGamming.create(android.content.Context, java.lang.String, com.wushuangtech.wstechapi.OmniRtcEngineEventHandler):com.wushuangtech.wstechapi.OmniRtcEngineForGamming");
    }

    public static OmniRtcEngineForGamming getInstance() {
        return mInstance;
    }

    public static synchronized void destroy() {
        synchronized (OmniRtcEngineForGamming.class) {
            if (mInstance != null) {
                OmniRtcEngine.destroy();
            }
        }
    }

    public void setTTTRtcEngineForGammingEventHandler(OmniRtcEngineEventHandler omniRtcEngineEventHandler) {
        this.mOmniRtcEngine.addHandler(omniRtcEngineEventHandler);
    }

    public int setChannelProfile(int i) {
        if (i != 2) {
            return -5;
        }
        return this.mOmniRtcEngine.setChannelProfile(i);
    }

    public int setClientRole(int i, String str) {
        return this.mOmniRtcEngine.setClientRole(i);
    }

    public synchronized int joinChannel(String str, long j) {
        return this.mOmniRtcEngine.joinChannel("", str, j);
    }

    public synchronized int joinChannel(String str, String str2, long j) {
        return this.mOmniRtcEngine.joinChannel(str, str2, j);
    }

    public synchronized int leaveChannel() {
        return this.mOmniRtcEngine.leaveChannel();
    }

    public int setLogFile(String str) {
        return this.mOmniRtcEngine.setLogFile(str);
    }

    public int setLogFilter(int i) {
        return this.mOmniRtcEngine.setLogFilter(i);
    }

    public int setDefaultAudioRoutetoSpeakerphone(boolean z) {
        return this.mOmniRtcEngine.setDefaultAudioRouteToSpeakerphone(z);
    }

    public boolean isSpeakerphoneEnabled() {
        return this.mOmniRtcEngine.isSpeakerphoneEnabled();
    }

    public int enableAudioVolumeIndication(int i, int i2) {
        return this.mOmniRtcEngine.enableAudioVolumeIndication(i, i2);
    }

    public int muteLocalAudioStream(boolean z) {
        return this.mOmniRtcEngine.muteLocalAudioStream(z);
    }

    public int muteAllRemoteAudioStreams(boolean z) {
        return this.mOmniRtcEngine.muteAllRemoteAudioStreams(z);
    }

    public int muteRemoteAudioStream(long j, boolean z) {
        return this.mOmniRtcEngine.muteRemoteAudioStream(j, z);
    }

    public int muteRemoteVideoStream(long j, boolean z) {
        return this.mOmniRtcEngine.muteRemoteVideoStream(j, z);
    }

    public int startAudioMixing(String str, boolean z, boolean z2, int i) {
        return this.mOmniRtcEngine.startAudioMixing(str, z, z2, i);
    }

    public int stopAudioMixing() {
        return this.mOmniRtcEngine.stopAudioMixing();
    }

    public int pauseAudioMixing() {
        return this.mOmniRtcEngine.pauseAudioMixing();
    }

    public int resumeAudioMixing() {
        return this.mOmniRtcEngine.resumeAudioMixing();
    }

    public int adjustAudioMixingVolume(int i) {
        return this.mOmniRtcEngine.adjustAudioMixingVolume(i);
    }

    public int getAudioMixingDuration() {
        return this.mOmniRtcEngine.getAudioMixingDuration();
    }

    public int getAudioMixingCurrentPosition() {
        return this.mOmniRtcEngine.getAudioMixingCurrentPosition();
    }

    public int enableVideo() {
        return this.mOmniRtcEngine.enableVideo();
    }

    public int disableVideo() {
        return this.mOmniRtcEngine.disableVideo();
    }

    public String getVersion() {
        return OmniRtcEngine.getSdkVersion();
    }

    public boolean kickChannelUser(long j) {
        return this.mOmniRtcEngine.kickChannelUser(j);
    }

    public SurfaceView CreateRendererView(Context context) {
        return OmniRtcEngine.CreateRendererSurfaceView(context);
    }

    public int setupLocalVideo(VideoCanvas videoCanvas, int i) {
        return this.mOmniRtcEngine.setupLocalVideo(videoCanvas, i);
    }

    public int setupRemoteVideo(VideoCanvas videoCanvas) {
        return this.mOmniRtcEngine.setupRemoteVideo(videoCanvas);
    }

    public int muteLocalVideoStream(boolean z) {
        return this.mOmniRtcEngine.enableLocalVideo(z);
    }

    public int setEnableSpeakerphone(boolean z) {
        return this.mOmniRtcEngine.setEnableSpeakerphone(z);
    }

    public int setVideoProfile(int i, boolean z) {
        return this.mOmniRtcEngine.setVideoProfile(i, z);
    }
}
