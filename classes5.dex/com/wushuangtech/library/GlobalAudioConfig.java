package com.wushuangtech.library;

import com.wushuangtech.api.ExternalAudioModule;
import com.wushuangtech.bean.AudioEncodedConfig;
import com.wushuangtech.utils.OmniLog;

public class GlobalAudioConfig {
    public static final int AUDIO_ENCODE_DEFAULT_BITRATE = 18;
    public static final int AUDIO_ENCODE_DEFAULT_TYPE = 4;
    public static final int AUDIO_MIX_CHANNEL = 1;
    public static final int AUDIO_MIX_DATA_SIZE = 1920;
    public static final int AUDIO_MIX_SAMPLERATE = 48000;
    public static final int AUDIO_PLAYMIX_CHANNEL = 1;
    public static final int AUDIO_PLAYMIX_DATA_SIZE = 1920;
    public static final int AUDIO_PLAYMIX_SAMPLERATE = 48000;
    public static final int AUDIO_RECORDMIX_CHANNEL = 1;
    public static final int AUDIO_RECORDMIX_DATA_SIZE = 1920;
    public static final int AUDIO_RECORDMIX_SAMPLERATE = 48000;
    public static final int AUDIO_RECORD_DEFAULT_CHANNEL = 1;
    public static final int AUDIO_RECORD_DEFAULT_SAMPLERATE = 16000;
    private static final String DEFAULT_AUDIO_ENCODE_CONFIG = "DEFAULT_AUDIO_ENCODE_CONFIG";
    private static final String TAG = "GlobalAudioConfig";
    private AudioEncodedConfig mAudioEncodedConfig;
    private final Object mAudioLocalFirstEncodedLock = new Object();
    private volatile boolean mAudioLocalFirstEncodedNotifyed;
    private int mAudioMode = -1;
    private boolean mJoinedChannel;
    private final Object mLock = new Object();

    public GlobalAudioConfig() {
        initAudioEncodeConfig();
    }

    public void configChannelAfterJoinChannel() {
        synchronized (this.mLock) {
            boolean z = true;
            this.mJoinedChannel = true;
            if (this.mAudioMode != -1) {
                ExternalAudioModule instance = ExternalAudioModule.getInstance();
                if (this.mAudioMode == 2) {
                    z = false;
                }
                instance.replayUsingVoip(z);
            }
        }
    }

    public void clearResource() {
        synchronized (this.mLock) {
            this.mJoinedChannel = false;
            this.mAudioMode = -1;
        }
    }

    public boolean isAudioLocalFirstEncodedNotifyed() {
        return this.mAudioLocalFirstEncodedNotifyed;
    }

    public AudioEncodedConfig getAudioEncodedConfig() {
        AudioEncodedConfig clone;
        synchronized (this.mLock) {
            clone = this.mAudioEncodedConfig.clone();
            if (clone == null) {
                OmniLog.e(TAG, "AUDIO_ENCODE_PARAMS Clone audio encode config failed!");
                clone = new AudioEncodedConfig();
                clone.copy(this.mAudioEncodedConfig);
            }
        }
        return clone;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean setAudioLocalFirstEncodedNotifyed(boolean r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mAudioLocalFirstEncodedLock
            monitor-enter(r0)
            r1 = 1
            r2 = 0
            if (r4 == 0) goto L_0x0010
            boolean r4 = com.wushuangtech.library.GlobalConfig.mAudioLocalEnabled     // Catch:{ all -> 0x0014 }
            if (r4 != 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            return r2
        L_0x000d:
            r3.mAudioLocalFirstEncodedNotifyed = r1     // Catch:{ all -> 0x0014 }
            goto L_0x0012
        L_0x0010:
            r3.mAudioLocalFirstEncodedNotifyed = r2     // Catch:{ all -> 0x0014 }
        L_0x0012:
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            return r1
        L_0x0014:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0014 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.library.GlobalAudioConfig.setAudioLocalFirstEncodedNotifyed(boolean):boolean");
    }

    public void setAudioMode(int i) {
        synchronized (this.mLock) {
            this.mAudioMode = i;
            if (this.mJoinedChannel) {
                ExternalAudioModule.getInstance().replayUsingVoip(i != 2);
            }
        }
    }

    public void setAudioEncodeBitrateParam(int i) {
        synchronized (this.mLock) {
            String str = TAG;
            OmniLog.i(str, "AUDIO_ENCODE_PARAMS Set audio encode bitrate param, bitrate=" + i);
            this.mAudioEncodedConfig.mEncodeBitrate = i;
        }
    }

    public void setAudioEncodeParams(int i, int i2, int i3) {
        synchronized (this.mLock) {
            String str = TAG;
            OmniLog.i(str, "AUDIO_ENCODE_PARAMS Set audio encode params, type=" + i + ", bitrate=" + i2 + ", channel=" + i3);
            this.mAudioEncodedConfig.mEncodeType = i;
            this.mAudioEncodedConfig.mEncodeBitrate = i2;
            this.mAudioEncodedConfig.mChannelNum = i3;
        }
    }

    private void initAudioEncodeConfig() {
        AudioEncodedConfig audioEncodedConfig = new AudioEncodedConfig();
        this.mAudioEncodedConfig = audioEncodedConfig;
        audioEncodedConfig.mSampleRate = AUDIO_RECORD_DEFAULT_SAMPLERATE;
        this.mAudioEncodedConfig.mChannelNum = 1;
        this.mAudioEncodedConfig.mEncodeType = 4;
        this.mAudioEncodedConfig.mEncodeBitrate = 18;
        OmniLog.i(TAG, "AUDIO_ENCODE_PARAMS Init audio encode params");
    }
}
