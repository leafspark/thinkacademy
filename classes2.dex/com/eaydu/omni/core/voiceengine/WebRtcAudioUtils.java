package com.eaydu.omni.core.voiceengine;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.wushuangtech.utils.OmniLog;
import java.util.Arrays;
import java.util.List;

public final class WebRtcAudioUtils {
    private static final String[] BLACKLISTED_AEC_MODELS = {"Nexus 5", "D6503", "ONE A2005", "MI 6"};
    private static final String[] BLACKLISTED_AGC_MODELS = {"Nexus 10", "Nexus 9"};
    private static final String[] BLACKLISTED_NS_MODELS = {"Nexus 10", "Nexus 9", "Nexus 5", "ONE A2005", "MI 8 SE", "MI 8"};
    private static final String[] BLACKLISTED_OPEN_SL_ES_MODELS = {"Nexus 6P", "HMA-AL00", "LYA-AL00", "LYA-TL00", "TNY-AL00", "TNY-TL00", "PCT-AL10", "EVR-AL00"};
    private static final String[] BLACKLISTED_VOICE_COMMUNICATION = {"SM801", "MI 6", "vivo X9", "vivo X9i", "Meitu M4", "MI 5", "NX529J", "ALP-AL00", "BLA-AL00", "PACM00", "EML-AL00", "AL00", "nb6797_6c_m", "Hi3798CV200"};
    private static final int DEFAULT_SAMPLE_RATE_HZ = 16000;
    private static final String TAG = "WebRtcAudioUtils";
    private static final String[] WHITELISTED_COMMUNICATION_MODE = {"SM-C7000"};
    private static int defaultSampleRateHz = DEFAULT_SAMPLE_RATE_HZ;
    private static boolean isDefaultSampleRateOverridden = false;
    private static boolean useWebRtcBasedAcousticEchoCanceler = false;
    private static boolean useWebRtcBasedAutomaticGainControl = false;
    private static boolean useWebRtcBasedNoiseSuppressor = false;

    public static synchronized void setWebRtcBasedAcousticEchoCanceler(boolean z) {
        synchronized (WebRtcAudioUtils.class) {
            useWebRtcBasedAcousticEchoCanceler = z;
        }
    }

    public static synchronized void setWebRtcBasedAutomaticGainControl(boolean z) {
        synchronized (WebRtcAudioUtils.class) {
            useWebRtcBasedAutomaticGainControl = z;
        }
    }

    public static synchronized void setWebRtcBasedNoiseSuppressor(boolean z) {
        synchronized (WebRtcAudioUtils.class) {
            useWebRtcBasedNoiseSuppressor = z;
        }
    }

    public static synchronized boolean useWebRtcBasedAcousticEchoCanceler() {
        boolean z;
        synchronized (WebRtcAudioUtils.class) {
            if (useWebRtcBasedAcousticEchoCanceler) {
                OmniLog.w(TAG, "Overriding default behavior; now using WebRTC AEC!");
            }
            z = useWebRtcBasedAcousticEchoCanceler;
        }
        return z;
    }

    public static synchronized boolean useWebRtcBasedAutomaticGainControl() {
        boolean z;
        synchronized (WebRtcAudioUtils.class) {
            if (useWebRtcBasedAutomaticGainControl) {
                OmniLog.w(TAG, "Overriding default behavior; now using WebRTC AGC!");
            }
            z = useWebRtcBasedAutomaticGainControl;
        }
        return z;
    }

    public static synchronized boolean useWebRtcBasedNoiseSuppressor() {
        boolean z;
        synchronized (WebRtcAudioUtils.class) {
            if (useWebRtcBasedNoiseSuppressor) {
                OmniLog.w(TAG, "Overriding default behavior; now using WebRTC NS!");
            }
            z = useWebRtcBasedNoiseSuppressor;
        }
        return z;
    }

    public static synchronized void setDefaultSampleRateHz(int i) {
        synchronized (WebRtcAudioUtils.class) {
            isDefaultSampleRateOverridden = true;
            defaultSampleRateHz = i;
        }
    }

    public static synchronized boolean isDefaultSampleRateOverridden() {
        boolean z;
        synchronized (WebRtcAudioUtils.class) {
            z = isDefaultSampleRateOverridden;
        }
        return z;
    }

    public static synchronized int getDefaultSampleRateHz() {
        int i;
        synchronized (WebRtcAudioUtils.class) {
            i = defaultSampleRateHz;
        }
        return i;
    }

    public static List<String> getBlackListedModelsForAecUsage() {
        return Arrays.asList(BLACKLISTED_AEC_MODELS);
    }

    public static List<String> getBlackListedModelsForAgcUsage() {
        return Arrays.asList(BLACKLISTED_AGC_MODELS);
    }

    public static List<String> getBlackListedModelsForNsUsage() {
        return Arrays.asList(BLACKLISTED_NS_MODELS);
    }

    public static List<String> getWhiteListedModelsForCommunicationMode() {
        return Arrays.asList(WHITELISTED_COMMUNICATION_MODE);
    }

    public static List<String> getBlackListedVoiceCommunication() {
        return Arrays.asList(BLACKLISTED_VOICE_COMMUNICATION);
    }

    public static boolean isBlackListedVoiceCommunication() {
        return getBlackListedVoiceCommunication().contains(Build.MODEL);
    }

    public static boolean runningOnGingerBreadOrHigher() {
        return Build.VERSION.SDK_INT >= 9;
    }

    public static boolean runningOnJellyBeanOrHigher() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean runningOnJellyBeanMR1OrHigher() {
        return Build.VERSION.SDK_INT >= 17;
    }

    public static boolean runningOnJellyBeanMR2OrHigher() {
        return Build.VERSION.SDK_INT >= 18;
    }

    public static boolean runningOnLollipopOrHigher() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static String getThreadInfo() {
        return "@[name=" + Thread.currentThread().getName() + ", id=" + Thread.currentThread().getId() + "]";
    }

    public static boolean runningOnEmulator() {
        return Build.HARDWARE.equals("goldfish") && Build.BRAND.startsWith("generic_");
    }

    public static boolean deviceIsBlacklistedForOpenSLESUsage() {
        return Arrays.asList(BLACKLISTED_OPEN_SL_ES_MODELS).contains(Build.MODEL);
    }

    public static void logDeviceInfo(String str) {
        OmniLog.d(str, "Android SDK: " + Build.VERSION.SDK_INT + ", Release: " + Build.VERSION.RELEASE + ", Brand: " + Build.BRAND + ", Device: " + Build.DEVICE + ", Id: " + Build.ID + ", Hardware: " + Build.HARDWARE + ", Manufacturer: " + Build.MANUFACTURER + ", Model: " + Build.MODEL + ", Product: " + Build.PRODUCT);
    }

    public static boolean hasPermission(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    public static void assertTrue(boolean z) {
        if (!z) {
            throw new AssertionError("Expected condition to be true");
        }
    }
}
