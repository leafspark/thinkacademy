package com.eaydu.omni.core.voiceengine;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import com.luck.picture.lib.config.PictureMimeType;
import com.wushuangtech.utils.OmniLog;

public class WebRtcAudioManager {
    private static final String[] AUDIO_MODES = {"MODE_NORMAL", "MODE_RINGTONE", "MODE_IN_CALL", "MODE_IN_COMMUNICATION"};
    private static final int BITS_PER_SAMPLE = 16;
    private static final int CHANNELS = 2;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_FRAME_PER_BUFFER = 256;
    private static final String TAG = "WebRtcAudioManager";
    private static boolean blacklistDeviceForOpenSLESUsage = false;
    private static boolean blacklistDeviceForOpenSLESUsageIsOverridden = false;
    public static boolean ignorSystemFeatureForLowlatency = false;
    public static boolean serverForceDisableLowlatency = true;
    private final AudioManager audioManager;
    private int channels;
    private final Context context;
    private boolean hardwareAEC;
    private boolean hardwareAGC;
    private boolean hardwareNS;
    private boolean initialized = false;
    private int inputBufferSize;
    private boolean lowLatencyOutput;
    private final long nativeAudioManager;
    private int nativeChannels;
    private int nativeSampleRate;
    private int outputBufferSize;
    private int sampleRate;

    private native void nativeCacheAudioParameters(int i, int i2, boolean z, boolean z2, boolean z3, boolean z4, int i3, int i4, long j);

    public static synchronized void setBlacklistDeviceForOpenSLESUsage(boolean z) {
        synchronized (WebRtcAudioManager.class) {
            blacklistDeviceForOpenSLESUsageIsOverridden = true;
            blacklistDeviceForOpenSLESUsage = z;
        }
    }

    WebRtcAudioManager(Context context2, long j) {
        OmniLog.aw_d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
        this.context = context2;
        this.nativeAudioManager = j;
        this.audioManager = (AudioManager) context2.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
        storeAudioParameters();
        nativeCacheAudioParameters(this.sampleRate, this.channels, this.hardwareAEC, this.hardwareAGC, this.hardwareNS, this.lowLatencyOutput, this.outputBufferSize, this.inputBufferSize, j);
    }

    private boolean init() {
        OmniLog.aw_d(TAG, "init" + WebRtcAudioUtils.getThreadInfo());
        if (this.initialized) {
            return true;
        }
        OmniLog.aw_d(TAG, "audio mode is: " + AUDIO_MODES[this.audioManager.getMode()]);
        this.initialized = true;
        return true;
    }

    private void dispose() {
        OmniLog.aw_d(TAG, "dispose" + WebRtcAudioUtils.getThreadInfo());
    }

    private boolean isCommunicationModeEnabled() {
        if (Build.MODEL.equals("SM-G9350") || Build.MODEL.equals("SM-G9300")) {
            this.audioManager.setMode(3);
        }
        return this.audioManager.getMode() == 3;
    }

    private boolean isDeviceBlacklistedForOpenSLESUsage() {
        boolean z;
        if (blacklistDeviceForOpenSLESUsageIsOverridden) {
            z = blacklistDeviceForOpenSLESUsage;
        } else {
            z = WebRtcAudioUtils.deviceIsBlacklistedForOpenSLESUsage();
        }
        if (z) {
            OmniLog.aw_e(TAG, Build.MODEL + " is blacklisted for OpenSL ES usage!");
        }
        return z;
    }

    private void storeAudioParameters() {
        int i;
        this.channels = 2;
        this.sampleRate = getNativeOutputSampleRate();
        this.hardwareAEC = isAcousticEchoCancelerSupported();
        this.hardwareAGC = isAutomaticGainControlSupported();
        this.hardwareNS = isNoiseSuppressorSupported();
        boolean isLowLatencyOutputSupported = isLowLatencyOutputSupported();
        this.lowLatencyOutput = isLowLatencyOutputSupported;
        if (isLowLatencyOutputSupported) {
            i = getLowLatencyOutputFramesPerBuffer();
        } else {
            i = getMinOutputFrameSize(this.sampleRate, this.channels);
        }
        this.outputBufferSize = i;
        this.inputBufferSize = getMinInputFrameSize(this.sampleRate, this.channels);
    }

    private boolean hasEarpiece() {
        return this.context.getPackageManager().hasSystemFeature("android.hardware.telephony");
    }

    private boolean isLowLatencyOutputSupported() {
        if (serverForceDisableLowlatency) {
            return false;
        }
        if (ignorSystemFeatureForLowlatency) {
            return isOpenSLESSupported();
        }
        if (isDeviceBlacklistedForOpenSLESUsage() || !isOpenSLESSupported() || !this.context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency")) {
            return false;
        }
        return true;
    }

    public boolean isLowLatencyInputSupported() {
        return WebRtcAudioUtils.runningOnLollipopOrHigher() && isLowLatencyOutputSupported();
    }

    private int getNativeOutputSampleRate() {
        int i;
        if (WebRtcAudioUtils.runningOnEmulator()) {
            OmniLog.aw_d(TAG, "Running emulator, overriding sample rate to 8 kHz.");
            return 8000;
        } else if (WebRtcAudioUtils.isDefaultSampleRateOverridden()) {
            OmniLog.aw_d(TAG, "Default sample rate is overriden to " + WebRtcAudioUtils.getDefaultSampleRateHz() + " Hz");
            return WebRtcAudioUtils.getDefaultSampleRateHz();
        } else {
            if (WebRtcAudioUtils.runningOnJellyBeanMR1OrHigher()) {
                i = getSampleRateOnJellyBeanMR10OrHigher();
            } else {
                i = WebRtcAudioUtils.getDefaultSampleRateHz();
            }
            if (i != 48000) {
                i = 16000;
            }
            OmniLog.aw_d(TAG, "Sample rate is set to " + i + " Hz");
            return i;
        }
    }

    private int getSampleRateOnJellyBeanMR10OrHigher() {
        String property = this.audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
        if (property == null) {
            return WebRtcAudioUtils.getDefaultSampleRateHz();
        }
        return Integer.parseInt(property);
    }

    private int getLowLatencyOutputFramesPerBuffer() {
        String property;
        assertTrue(isLowLatencyOutputSupported());
        if (WebRtcAudioUtils.runningOnJellyBeanMR1OrHigher() && (property = this.audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER")) != null) {
            return Integer.parseInt(property);
        }
        return 256;
    }

    private static boolean isAcousticEchoCancelerSupported() {
        return WebRtcAudioEffects.canUseAcousticEchoCanceler();
    }

    private static boolean isAutomaticGainControlSupported() {
        return WebRtcAudioEffects.canUseAutomaticGainControl();
    }

    private static boolean isNoiseSuppressorSupported() {
        return WebRtcAudioEffects.canUseNoiseSuppressor();
    }

    private static int getMinOutputFrameSize(int i, int i2) {
        int i3;
        int i4 = i2 * 2;
        if (i2 == 1) {
            i3 = 4;
        } else if (i2 != 2) {
            return -1;
        } else {
            i3 = 12;
        }
        return AudioTrack.getMinBufferSize(i, i3, 2) / i4;
    }

    private int getLowLatencyInputFramesPerBuffer() {
        assertTrue(isLowLatencyInputSupported());
        return getLowLatencyOutputFramesPerBuffer();
    }

    private static int getMinInputFrameSize(int i, int i2) {
        int i3 = i2 * 2;
        assertTrue(i2 == 2);
        return AudioRecord.getMinBufferSize(i, 16, 2) / i3;
    }

    private static boolean isOpenSLESSupported() {
        return WebRtcAudioUtils.runningOnGingerBreadOrHigher();
    }

    private static void assertTrue(boolean z) {
        if (!z) {
            throw new AssertionError("Expected condition to be true");
        }
    }
}
