package com.wushuangtech.api;

import android.content.Context;
import android.util.LongSparseArray;
import com.wushuangtech.api.ExternalAudioModuleImpl;
import com.wushuangtech.bean.CommonEventBean;

public abstract class ExternalAudioModule {
    private static ExternalAudioModuleImpl mExternalAudioModule;

    public static class AecDelayMetrics {
        public int delay_median;
        public int delay_std;
        public double fraction_poor_delays;
    }

    public static class AecParams {
        public int delay_estimate;
        public String model;
        public int offset;
        public int open_delay_estimate;
        public int pre_offset;
        public boolean valid;
        public int voip_play;
        public int voip_record;
    }

    public static class RecordErrInfo {
        public int audioMode;
        public boolean audiofocus;
        public int channels;
        public int errorCode;
        public int recordmode;
        public int samplerate;
        public boolean speakerphoneon;
    }

    public abstract boolean StartCapture();

    public abstract boolean StartSafetyCapture();

    public abstract boolean StopCapture();

    public abstract void configChannelAfterJoinChannel(Context context);

    public abstract void configChannelBeforeJoinChannel();

    public abstract void enableAudioPcmWriteFile(boolean z, String str);

    public abstract void enableAudioVadIndication(boolean z, boolean z2);

    public abstract int getAudioLevel(String str, long j, boolean z);

    public abstract LongSparseArray<AudioStatistics> getAudioStatistics();

    public abstract LongSparseArray<AudioStatistics> getAudioStatistics(String str);

    public abstract int getAudioVadLevel(String str, long j);

    public abstract int getBufferDuration();

    public abstract long getCaptureDataSzie();

    public abstract int getEncodeDataSize();

    public abstract int getEncodeFrameCount();

    public abstract int getEncodedFps();

    public abstract ExternalAudioModuleImpl.LocalAudioSender getLocalAudioSender();

    public abstract LocalAudioStatistics getLocalAudioStatistics();

    public abstract int getRecvBytes(long j);

    public abstract LocalAudioLevelSum getSpeechInputLevelSum();

    public abstract long getTotalRecvBytes();

    public abstract long getTotalSendBytes();

    public abstract void initChannelResAfterJoined(String str);

    public abstract boolean isLocalMuted();

    public abstract void leaveChannel(String str);

    public abstract void replayUsingVoip(boolean z);

    public abstract Object sendAudioModuleEvent(CommonEventBean commonEventBean);

    public abstract void setAudioApplicationScene(int i);

    public abstract int setEncodeParams(int i, int i2, int i3);

    public abstract void setExpandCartonParams(int i, int i2);

    public abstract void setExternalAudioModuleCallback(ExternalAudioModuleCallback externalAudioModuleCallback);

    public abstract int setProfile(int i, int i2);

    public abstract void setServerDevParam(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6);

    public abstract void unConfigChannelAfterJoinChannel();

    public static class LocalAudioLevelSum implements Cloneable {
        public int afterLevelSum;
        public int levelSum;
        public int preLevelSum;

        /* access modifiers changed from: protected */
        public LocalAudioLevelSum clone() {
            try {
                return (LocalAudioLevelSum) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
    }

    public static class LocalAudioStatistics {
        public long aAfterlevelSum;
        public int aNlp;
        public int asVolumeCallBackAfterLevel;
        public int asVolumeCallBackBeforeLevel;
        public int asVolumeLevelRms;
        public int asVolumeLevelRmsA;
        public long asVolumeLevelRmsSend;
        public long asVolumeLevelSum;
        public int asVolumeOriginalLevel;
        public int capFps;
        public int delayMedian;
        public int delayStd;
        public int eRle;
        public long encodeDataSize;
        public int encodeInputFps;
        public int encodeOutputFps;
        public int erl;
        public int fractionLost;
        public float fractionPoorDelays;
        public int reportType;
        public int rttMs;
        public long ssrc;

        public String toString() {
            return "{ssrc=" + this.ssrc + ", fractionLost=" + this.fractionLost + ", rttMs=" + this.rttMs + ", capFps=" + this.capFps + ", encodeInputFps=" + this.encodeInputFps + ", encodeOutputFps=" + this.encodeOutputFps + ", aAfterlevelSum=" + this.aAfterlevelSum + '}';
        }
    }

    public static class AudioStatistics {
        public int arProcElapsedAvg;
        public int arProcElapsedMax;
        public int arSysPlayoutFps;
        public int arVolumeLevelRms;
        public int arVolumeLevelRmsA;
        public int arVolumeLevelSum;
        public int bufferDuration;
        public int cartonCount;
        public int channels;
        public int decFps;
        public int decodeDur;
        public long decodedLength;
        public int decoderInputFps;
        public int decoderOutputFps;
        public int delayMs;
        public int fractionLost;
        public int jitterBufferMs;
        public int lossRate;
        public int recvFps;
        public long recvLength;
        public int renderOutputFps;
        public int rttMs;
        public int sampleRate;
        public long ssrc;

        public String toString() {
            return "{recvLength=" + this.recvLength + ", lossRate=" + this.lossRate + ", bufferDuration=" + this.bufferDuration + ", delayMs=" + this.delayMs + ", decodedLength=" + this.decodedLength + ", fractionLost=" + this.fractionLost + ", cartonCount=" + this.cartonCount + ", ssrc=" + this.ssrc + ", rttMs=" + this.rttMs + ", recvFps=" + this.recvFps + ", decoderInputFps=" + this.decoderInputFps + ", decoderOutputFps=" + this.decoderOutputFps + ", renderOutputFps=" + this.renderOutputFps + ", decodeDur =" + this.decodeDur + '}';
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
    public static synchronized com.wushuangtech.api.ExternalAudioModule getInstance() {
        /*
            java.lang.Class<com.wushuangtech.api.ExternalAudioModule> r0 = com.wushuangtech.api.ExternalAudioModule.class
            monitor-enter(r0)
            com.wushuangtech.api.ExternalAudioModuleImpl r1 = mExternalAudioModule     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            com.wushuangtech.api.ExternalAudioModuleImpl r1 = mExternalAudioModule     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            com.wushuangtech.api.ExternalAudioModuleImpl r1 = new com.wushuangtech.api.ExternalAudioModuleImpl     // Catch:{ all -> 0x0015 }
            r1.<init>()     // Catch:{ all -> 0x0015 }
            mExternalAudioModule = r1     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r1     // Catch:{ all -> 0x001c }
        L_0x0018:
            com.wushuangtech.api.ExternalAudioModuleImpl r1 = mExternalAudioModule     // Catch:{ all -> 0x001c }
            monitor-exit(r0)
            return r1
        L_0x001c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.api.ExternalAudioModule.getInstance():com.wushuangtech.api.ExternalAudioModule");
    }
}
