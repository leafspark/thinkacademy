package com.wushuangtech.api;

import android.util.LongSparseArray;
import com.wushuangtech.bean.CommonEventBean;
import com.wushuangtech.bean.ServerConfigBean;
import com.wushuangtech.bean.VideoStuckStatsBean;
import java.util.LinkedList;
import java.util.List;

public abstract class ExternalVideoModule implements VideoSender {
    private static ExternalVideoModuleImpl mExternalVideoModule;

    public abstract int getBufferDuration();

    public abstract long getEncodeDataSize();

    public abstract int[] getEncodeSize();

    public abstract int getLastSliceQp();

    public abstract LocalVideoStatistics getLocalVideoStatistics();

    public abstract void getNativeVdieoStuckStats();

    public abstract int getRTT();

    public abstract int getRecvDataErrorTimes();

    public abstract int getSentFrameCount();

    public abstract LinkedList<VideoStuckStatsBean> getStuck();

    public abstract long getTotalRecvBytes();

    public abstract long getTotalSendBytes();

    public abstract LongSparseArray<VideoStatistics> getVideoStatistics();

    public abstract LongSparseArray<VideoStatistics> getVideoStatistics(String str);

    public abstract void initVideoConfig(String str);

    public abstract void initVideoGlobalConfig();

    public abstract void insertH264SeiContent(byte[] bArr);

    public abstract boolean isCapturing();

    public abstract void resetVideoDecoderStatus(CommonEventBean commonEventBean);

    public abstract void setBitrateMode(int i);

    public abstract void setExternalVideoDecoderPlugin(ExternalVideoDecoderPluginCallback externalVideoDecoderPluginCallback);

    public abstract void setExternalVideoModuleCallback(ExternalVideoModuleCallback externalVideoModuleCallback);

    public abstract void setMaxBufferDuration(int i);

    public abstract void stopAllPlay();

    public abstract void stopPlay(String str);

    public abstract void stopPlay(String str, String str2);

    public abstract void updateMaxBitrateControlParam(int i, int i2);

    public abstract void updateServerConfig(List<ServerConfigBean> list);

    public abstract void updateVideoDecoderSpentTime();

    public static class VideoStatistics {
        public int av_sync_diff;
        public int bufferDuration;
        public String channelName;
        public int decodeBitrate;
        public int delayMS;
        public String devId;
        public int e2e_fraction_lost;
        public int fractionLost;
        public int height;
        public boolean isValid;
        public int jitter;
        public int lostDelay;
        public int lostDelayFraction;
        public int lostFrames;
        public int lostRate;
        public int rDelay;
        public int rDelayFraction;
        public int recvBitrate;
        public int recvFramerate;
        public int recvFrames;
        public int recvPkts;
        public long recvSize;
        public int rtt;
        public int ssrc;
        public long userId;
        public int v_targetvbr;
        public VideoMediaServerInfo vmsInfo = new VideoMediaServerInfo();
        public int width;

        VideoStatistics() {
        }

        public String toString() {
            return "VideoStatistics{userId=" + this.userId + ", devId='" + this.devId + '\'' + ", ssrc=" + this.ssrc + ", recvSize=" + this.recvSize + ", recvFrames=" + this.recvFrames + ", lostFrames=" + this.lostFrames + ", recvBitrate=" + this.recvBitrate + ", decodeBitrate=" + this.decodeBitrate + ", recvFramerate=" + this.recvFramerate + ", bufferDuration=" + this.bufferDuration + ", delayMS=" + this.delayMS + ", recvPkts=" + this.recvPkts + ", fractionLost=" + this.fractionLost + ", e2e_fraction_lost=" + this.e2e_fraction_lost + ", rtt=" + this.rtt + ", lostRate=" + this.lostRate + ", jitter=" + this.jitter + ", rDelay=" + this.rDelay + ", lostDelay=" + this.lostDelay + ", rDelayFraction=" + this.rDelayFraction + ", lostDelayFraction=" + this.lostDelayFraction + ", width=" + this.width + ", height=" + this.height + ", av_sync_diff=" + this.av_sync_diff + ", v_targetvbr=" + this.v_targetvbr + '}';
        }
    }

    public static class VideoMediaServerInfo {
        public int msIOType;
        public String msId = "";
        public String msIp = "";
        public int msPort;
        public int msState;

        VideoMediaServerInfo() {
        }
    }

    public static class LocalVideoStatistics {
        public int V_FBR;
        public int V_FPS;
        public int V_RBR;
        public int V_RTT;
        public long V_SENDBYTES;
        public int V_SENDCOUNT;
        public int V_SENDFRACTIONLOST;
        public int V_SFPS;
        public int V_SSRC;
        public int V_VBR;
        public boolean isValid;
        public long userId;
        public VideoMediaServerInfo vmsInfo = new VideoMediaServerInfo();

        LocalVideoStatistics() {
        }

        public String toString() {
            return "{userId=" + this.userId + ", V_SSRC=" + this.V_SSRC + ", V_VBR=" + this.V_VBR + ", V_RBR=" + this.V_RBR + ", V_FBR=" + this.V_FBR + ", V_FPS=" + this.V_FPS + ", V_SFPS=" + this.V_SFPS + ", V_SENDBYTES=" + this.V_SENDBYTES + ", V_SENDCOUNT=" + this.V_SENDCOUNT + ", V_SENDFRACTIONLOST=" + this.V_SENDFRACTIONLOST + ", V_RTT=" + this.V_RTT + '}';
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
    public static synchronized com.wushuangtech.api.ExternalVideoModule getInstance() {
        /*
            java.lang.Class<com.wushuangtech.api.ExternalVideoModule> r0 = com.wushuangtech.api.ExternalVideoModule.class
            monitor-enter(r0)
            com.wushuangtech.api.ExternalVideoModuleImpl r1 = mExternalVideoModule     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            com.wushuangtech.api.ExternalVideoModuleImpl r1 = mExternalVideoModule     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            com.wushuangtech.api.ExternalVideoModuleImpl r1 = new com.wushuangtech.api.ExternalVideoModuleImpl     // Catch:{ all -> 0x0015 }
            r1.<init>()     // Catch:{ all -> 0x0015 }
            mExternalVideoModule = r1     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r1     // Catch:{ all -> 0x001c }
        L_0x0018:
            com.wushuangtech.api.ExternalVideoModuleImpl r1 = mExternalVideoModule     // Catch:{ all -> 0x001c }
            monitor-exit(r0)
            return r1
        L_0x001c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.ExternalVideoModule.getInstance():com.wushuangtech.api.ExternalVideoModule");
    }
}
