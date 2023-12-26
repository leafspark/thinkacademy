package com.eaydu.omni.core.voiceengine;

import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.AudioEffect;
import android.media.audiofx.AutomaticGainControl;
import android.media.audiofx.NoiseSuppressor;
import android.os.Build;
import com.wushuangtech.utils.OmniLog;
import java.util.UUID;

class WebRtcAudioEffects {
    private static final UUID AOSP_ACOUSTIC_ECHO_CANCELER = UUID.fromString("bb392ec0-8d4d-11e0-a896-0002a5d5c51b");
    private static final UUID AOSP_AUTOMATIC_GAIN_CONTROL = UUID.fromString("aa8130e0-66fc-11e0-bad0-0002a5d5c51b");
    private static final UUID AOSP_NOISE_SUPPRESSOR = UUID.fromString("c06c8400-8e06-11e0-9cb6-0002a5d5c51b");
    private static final boolean DEBUG = true;
    private static final String TAG = "WebRtcAudioEffects";
    private static Boolean canUseAcousticEchoCanceler = null;
    private static Boolean canUseAutomaticGainControl = null;
    private static Boolean canUseNoiseSuppressor = null;
    private AcousticEchoCanceler aec = null;
    private AutomaticGainControl agc = null;
    private NoiseSuppressor ns = null;
    private boolean shouldEnableAec = false;
    private boolean shouldEnableAgc = false;
    private boolean shouldEnableNs = false;

    public static boolean isAcousticEchoCancelerSupported() {
        return WebRtcAudioUtils.runningOnJellyBeanOrHigher() && AcousticEchoCanceler.isAvailable();
    }

    public static boolean isAutomaticGainControlSupported() {
        return WebRtcAudioUtils.runningOnJellyBeanOrHigher() && AutomaticGainControl.isAvailable();
    }

    public static boolean isNoiseSuppressorSupported() {
        return WebRtcAudioUtils.runningOnJellyBeanOrHigher() && NoiseSuppressor.isAvailable();
    }

    public static boolean isAcousticEchoCancelerBlacklisted() {
        boolean contains = WebRtcAudioUtils.getBlackListedModelsForAecUsage().contains(Build.MODEL);
        if (contains) {
            OmniLog.w(TAG, Build.MODEL + " is blacklisted for HW AEC usage!");
        }
        return contains;
    }

    public static boolean isAutomaticGainControlBlacklisted() {
        boolean contains = WebRtcAudioUtils.getBlackListedModelsForAgcUsage().contains(Build.MODEL);
        if (contains) {
            OmniLog.w(TAG, Build.MODEL + " is blacklisted for HW AGC usage!");
        }
        return contains;
    }

    public static boolean isNoiseSuppressorBlacklisted() {
        boolean contains = WebRtcAudioUtils.getBlackListedModelsForNsUsage().contains(Build.MODEL);
        if (contains) {
            OmniLog.w(TAG, Build.MODEL + " is blacklisted for HW NS usage!");
        }
        return contains;
    }

    public static boolean isCommunicationModeWhitelisted() {
        boolean contains = WebRtcAudioUtils.getWhiteListedModelsForCommunicationMode().contains(Build.MODEL);
        if (contains) {
            OmniLog.w(TAG, Build.MODEL + " is isWhitelisted for Communication mode!");
        }
        return contains;
    }

    private static boolean isAcousticEchoCancelerExcludedByUUID() {
        for (AudioEffect.Descriptor descriptor : AudioEffect.queryEffects()) {
            if (descriptor.type.equals(AudioEffect.EFFECT_TYPE_AEC) && descriptor.uuid.equals(AOSP_ACOUSTIC_ECHO_CANCELER)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAutomaticGainControlExcludedByUUID() {
        for (AudioEffect.Descriptor descriptor : AudioEffect.queryEffects()) {
            if (descriptor.type.equals(AudioEffect.EFFECT_TYPE_AGC) && descriptor.uuid.equals(AOSP_AUTOMATIC_GAIN_CONTROL)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNoiseSuppressorExcludedByUUID() {
        for (AudioEffect.Descriptor descriptor : AudioEffect.queryEffects()) {
            if (descriptor.type.equals(AudioEffect.EFFECT_TYPE_NS) && descriptor.uuid.equals(AOSP_NOISE_SUPPRESSOR)) {
                return true;
            }
        }
        return false;
    }

    public static boolean canUseAcousticEchoCanceler() {
        if (canUseAcousticEchoCanceler == null) {
            canUseAcousticEchoCanceler = Boolean.valueOf(isAcousticEchoCancelerSupported() && !WebRtcAudioUtils.useWebRtcBasedAcousticEchoCanceler() && !isAcousticEchoCancelerBlacklisted() && !isAcousticEchoCancelerExcludedByUUID());
            OmniLog.d(TAG, "canUseAcousticEchoCanceler: " + canUseAcousticEchoCanceler);
        }
        return canUseAcousticEchoCanceler.booleanValue();
    }

    public static boolean canUseAutomaticGainControl() {
        if (canUseAutomaticGainControl == null) {
            canUseAutomaticGainControl = Boolean.valueOf(isAutomaticGainControlSupported() && !WebRtcAudioUtils.useWebRtcBasedAutomaticGainControl() && !isAutomaticGainControlBlacklisted() && !isAutomaticGainControlExcludedByUUID());
            OmniLog.d(TAG, "canUseAutomaticGainControl: " + canUseAutomaticGainControl);
        }
        return canUseAutomaticGainControl.booleanValue();
    }

    public static boolean canUseNoiseSuppressor() {
        if (canUseNoiseSuppressor == null) {
            canUseNoiseSuppressor = Boolean.valueOf(isNoiseSuppressorSupported() && !WebRtcAudioUtils.useWebRtcBasedNoiseSuppressor() && !isNoiseSuppressorBlacklisted() && !isNoiseSuppressorExcludedByUUID());
            OmniLog.d(TAG, "canUseNoiseSuppressor: " + canUseNoiseSuppressor);
        }
        return canUseNoiseSuppressor.booleanValue();
    }

    static WebRtcAudioEffects create() {
        if (WebRtcAudioUtils.runningOnJellyBeanOrHigher()) {
            return new WebRtcAudioEffects();
        }
        OmniLog.w(TAG, "API level 16 or higher is required!");
        return null;
    }

    private WebRtcAudioEffects() {
        OmniLog.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
    }

    public boolean setAEC(boolean z) {
        OmniLog.d(TAG, "setAEC(" + z + ")");
        if (!canUseAcousticEchoCanceler()) {
            OmniLog.w(TAG, "Platform AEC is not supported");
            this.shouldEnableAec = false;
            return false;
        } else if (this.aec == null || z == this.shouldEnableAec) {
            this.shouldEnableAec = z;
            return true;
        } else {
            OmniLog.e(TAG, "Platform AEC state can't be modified while recording");
            return false;
        }
    }

    public boolean setAGC(boolean z) {
        OmniLog.d(TAG, "setAGC(" + z + ")");
        if (!canUseAutomaticGainControl()) {
            OmniLog.w(TAG, "Platform AGC is not supported");
            this.shouldEnableAgc = false;
            return false;
        } else if (this.agc == null || z == this.shouldEnableAgc) {
            this.shouldEnableAgc = z;
            return true;
        } else {
            OmniLog.e(TAG, "Platform AGC state can't be modified while recording");
            return false;
        }
    }

    public boolean setNS(boolean z) {
        OmniLog.d(TAG, "setNS(" + z + ")");
        if (!canUseNoiseSuppressor()) {
            OmniLog.w(TAG, "Platform NS is not supported");
            this.shouldEnableNs = false;
            return false;
        } else if (this.ns == null || z == this.shouldEnableNs) {
            this.shouldEnableNs = z;
            return true;
        } else {
            OmniLog.e(TAG, "Platform NS state can't be modified while recording");
            return false;
        }
    }

    public void enable(int i) {
        String str;
        String str2;
        String str3;
        OmniLog.d(TAG, "enable(audioSession=" + i + ")");
        boolean z = true;
        assertTrue(this.aec == null);
        assertTrue(this.agc == null);
        assertTrue(this.ns == null);
        for (AudioEffect.Descriptor descriptor : AudioEffect.queryEffects()) {
            effectTypeIsVoIP(descriptor.type);
            OmniLog.d(TAG, "name: " + descriptor.name + ", mode: " + descriptor.connectMode + ", implementor: " + descriptor.implementor + ", UUID: " + descriptor.uuid);
        }
        String str4 = "enabled";
        if (isAcousticEchoCancelerSupported()) {
            AcousticEchoCanceler create = AcousticEchoCanceler.create(i);
            this.aec = create;
            if (create != null) {
                boolean enabled = create.getEnabled();
                boolean z2 = this.shouldEnableAec && canUseAcousticEchoCanceler();
                if (this.aec.setEnabled(z2) != 0) {
                    OmniLog.e(TAG, "Failed to set the AcousticEchoCanceler state");
                }
                StringBuilder sb = new StringBuilder();
                sb.append("AcousticEchoCanceler: was ");
                if (enabled) {
                    str2 = str4;
                } else {
                    str2 = "disabled";
                }
                sb.append(str2);
                sb.append(", enable: ");
                sb.append(z2);
                sb.append(", is now: ");
                if (this.aec.getEnabled()) {
                    str3 = str4;
                } else {
                    str3 = "disabled";
                }
                sb.append(str3);
                OmniLog.d(TAG, sb.toString());
            } else {
                OmniLog.e(TAG, "Failed to create the AcousticEchoCanceler instance");
            }
        }
        if (isNoiseSuppressorSupported()) {
            NoiseSuppressor create2 = NoiseSuppressor.create(i);
            this.ns = create2;
            if (create2 != null) {
                boolean enabled2 = create2.getEnabled();
                if (!this.shouldEnableNs || !canUseNoiseSuppressor()) {
                    z = false;
                }
                if (this.ns.setEnabled(z) != 0) {
                    OmniLog.e(TAG, "Failed to set the NoiseSuppressor state");
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("NoiseSuppressor: was ");
                if (enabled2) {
                    str = str4;
                } else {
                    str = "disabled";
                }
                sb2.append(str);
                sb2.append(", enable: ");
                sb2.append(z);
                sb2.append(", is now: ");
                if (!this.ns.getEnabled()) {
                    str4 = "disabled";
                }
                sb2.append(str4);
                OmniLog.d(TAG, sb2.toString());
                return;
            }
            OmniLog.e(TAG, "Failed to create the NoiseSuppressor instance");
        }
    }

    public void release() {
        OmniLog.d(TAG, "release");
        AcousticEchoCanceler acousticEchoCanceler = this.aec;
        if (acousticEchoCanceler != null) {
            acousticEchoCanceler.release();
            this.aec = null;
        }
        AutomaticGainControl automaticGainControl = this.agc;
        if (automaticGainControl != null) {
            automaticGainControl.release();
            this.agc = null;
        }
        NoiseSuppressor noiseSuppressor = this.ns;
        if (noiseSuppressor != null) {
            noiseSuppressor.release();
            this.ns = null;
        }
    }

    private boolean effectTypeIsVoIP(UUID uuid) {
        if (!WebRtcAudioUtils.runningOnJellyBeanMR2OrHigher()) {
            return false;
        }
        if ((!AudioEffect.EFFECT_TYPE_AEC.equals(uuid) || !isAcousticEchoCancelerSupported()) && ((!AudioEffect.EFFECT_TYPE_AGC.equals(uuid) || !isAutomaticGainControlSupported()) && (!AudioEffect.EFFECT_TYPE_NS.equals(uuid) || !isNoiseSuppressorSupported()))) {
            return false;
        }
        return true;
    }

    private static void assertTrue(boolean z) {
        if (!z) {
            throw new AssertionError("Expected condition to be true");
        }
    }
}
