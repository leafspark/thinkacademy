package com.wushuangtech.audiocore;

import android.content.Context;
import android.util.LongSparseArray;
import com.wushuangtech.api.AudioSender;
import com.wushuangtech.api.ExternalAudioModule;
import com.wushuangtech.api.ExternalAudioModuleCallback;
import com.wushuangtech.api.ExternalLoadHelper;
import com.wushuangtech.audiocore.callback.AudioFileMixCallback;
import com.wushuangtech.audiocore.callback.ExternalAudioProcessCallback;
import java.nio.ByteBuffer;

public abstract class MyAudioApi implements ExternalAudioModuleCallback {
    static volatile MyAudioApiImpl mAudioApi;

    public abstract void addAudioSender(AudioSender audioSender);

    public abstract void adjSpeakerVolumeScale(float f);

    public abstract void adjustAudioFilePlayoutTrackVol(double d);

    public abstract void adjustAudioFilePublishTrackVol(double d);

    public abstract void adjustAudioFileVolumeScale(double d);

    public abstract void adjustAudioSoloVolumeScale(double d);

    public abstract void adjustPlaybackSignalVolume(double d);

    public abstract void adjustPlaybackSignalVolume(long j, double d);

    public abstract void adjustPlaybackSignalVolumeForChannel(long j, double d);

    public abstract boolean audioFileMixing();

    public abstract float audioFileVolumeScale();

    public abstract float audioSoloVolumeScale();

    public abstract void enableAudioEffect(boolean z, int i);

    public abstract void enableEarsBack(boolean z);

    public abstract void enableVoiceDetection(boolean z);

    public abstract long getCaptureDataSize();

    public abstract int getDynamicBitrate();

    public abstract double getEffectsVolume();

    public abstract int getEncodeDataSize();

    public abstract ExternalAudioModule.LocalAudioStatistics getLocalAudioStatistics();

    public abstract int getRecvBytes(long j);

    public abstract LongSparseArray<ExternalAudioModule.AudioStatistics> getRemoteAudioStatistics();

    public abstract int getSizeOfMuteAudioPlayed();

    public abstract double getVolumeOfEffect(int i);

    public abstract boolean isCapturing();

    public abstract boolean isVoiceDetectionEnabled();

    public abstract void pauseAllEffect();

    public abstract boolean pauseAudio();

    public abstract void pauseAudioFileMix();

    public abstract void pauseEffect(int i);

    public abstract boolean playEffect(int i, String str, int i2, double d, double d2, boolean z);

    public abstract boolean playEffectForAsset(int i, String str, int i2, double d, double d2, boolean z);

    public abstract boolean playMixing();

    public abstract void pullPlayoutData(byte[] bArr, int i, int i2);

    public abstract int pushExternalAudioFrame(byte[] bArr, long j, int i, int i2, int i3, int i4);

    public abstract void pushRecordPcm(byte[] bArr, int i, int i2);

    public abstract boolean recordMixing();

    public abstract float remoteVolumeScale(long j);

    public abstract void removeAudioSender(AudioSender audioSender);

    public abstract void reportAudioPlayError(int i);

    public abstract void reportAudioRecordError(int i);

    public abstract void resumeAllEffect();

    public abstract boolean resumeAudio();

    public abstract void resumeAudioFileMix();

    public abstract void resumeEffect(int i);

    public abstract void seekAudioFileTo(int i);

    public abstract int setAudioEncoderConfiguration(int i, int i2);

    public abstract void setAudioFileMixCallback(AudioFileMixCallback audioFileMixCallback);

    public abstract int setAudioMixMode(int i, long[] jArr);

    public abstract void setAudioMixingPitch(int i);

    public abstract void setDelayoffset(int i, boolean z, boolean z2, boolean z3);

    public abstract void setEffectsVolume(double d);

    public abstract void setExternalAudioProcessCallback(ExternalAudioProcessCallback externalAudioProcessCallback);

    public abstract void setHeadsetStatus(boolean z);

    public abstract void setPlayMixParamatars(int i, int i2, int i3);

    public abstract int setRecordMixParameters(int i, int i2, int i3, int i4);

    public abstract int setRemoteAndLocalMixParamatars(int i, int i2, int i3);

    public abstract void setSendCodec(int i, int i2, int i3, boolean z);

    public abstract void setVolumeOfEffect(int i, double d);

    public abstract float speakerVolumeScale();

    public abstract boolean startAudioFileMixing(String str, boolean z, int i);

    public abstract boolean startAudioFileMixingForAssert(String str, boolean z, int i);

    public abstract int startPlayMix();

    public abstract int startRecordMix();

    public abstract void startRemoteAndLocalMix();

    public abstract void stopAllEffect();

    public abstract void stopAudioFileMixing();

    public abstract void stopEffect(int i);

    public abstract void stopPlayMix();

    public abstract void stopRecordMix();

    public abstract void stopRemoteAndLocalMix();

    public abstract void useExtPcm(boolean z, boolean z2);

    public abstract void useHighQualityAudio(boolean z);

    public abstract void writeAudioLocalPcmData(ByteBuffer byteBuffer);

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
    public static synchronized com.wushuangtech.audiocore.MyAudioApi getInstance(android.content.Context r2) {
        /*
            java.lang.Class<com.wushuangtech.audiocore.MyAudioApi> r0 = com.wushuangtech.audiocore.MyAudioApi.class
            monitor-enter(r0)
            com.wushuangtech.audiocore.MyAudioApiImpl r1 = mAudioApi     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x001b
            monitor-enter(r0)     // Catch:{ all -> 0x001f }
            com.wushuangtech.audiocore.MyAudioApiImpl r1 = mAudioApi     // Catch:{ all -> 0x0018 }
            if (r1 != 0) goto L_0x0016
            tryLoadLibrary()     // Catch:{ all -> 0x0018 }
            com.wushuangtech.audiocore.MyAudioApiImpl r1 = new com.wushuangtech.audiocore.MyAudioApiImpl     // Catch:{ all -> 0x0018 }
            r1.<init>(r2)     // Catch:{ all -> 0x0018 }
            mAudioApi = r1     // Catch:{ all -> 0x0018 }
        L_0x0016:
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            goto L_0x001b
        L_0x0018:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0018 }
            throw r2     // Catch:{ all -> 0x001f }
        L_0x001b:
            com.wushuangtech.audiocore.MyAudioApiImpl r2 = mAudioApi     // Catch:{ all -> 0x001f }
            monitor-exit(r0)
            return r2
        L_0x001f:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.audiocore.MyAudioApi.getInstance(android.content.Context):com.wushuangtech.audiocore.MyAudioApi");
    }

    public static MyAudioApi getInstance() {
        return getInstance((Context) null);
    }

    private static void tryLoadLibrary() {
        if (!ExternalLoadHelper.isLoaded()) {
            try {
                loadLibrary();
            } catch (Exception unused) {
                loadLibrary();
            }
        }
    }

    private static void loadLibrary() {
        System.loadLibrary("audioengine");
    }
}
