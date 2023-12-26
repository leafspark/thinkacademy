package io.agora.rtc.audio;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;

class AudioManagerAndroid {
    private static final int DEFAULT_FRAMES_PER_BUFFER = 256;
    private static final int DEFAULT_SAMPLING_RATE = 44100;
    private AudioManager audioManager;
    private int mAudioLowLatencyOutputFrameSize = DEFAULT_FRAMES_PER_BUFFER;
    private boolean mAudioLowLatencySupported;
    private int mNativeOutputSampleRate = DEFAULT_SAMPLING_RATE;
    private Context mcontext;

    private AudioManagerAndroid(Context context) {
        this.mcontext = context;
        this.audioManager = (AudioManager) context.getSystemService("audio");
        if (Build.VERSION.SDK_INT >= 17) {
            String property = this.audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
            if (property != null) {
                this.mNativeOutputSampleRate = Integer.parseInt(property);
            }
            String property2 = this.audioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
            if (property2 != null) {
                this.mAudioLowLatencyOutputFrameSize = Integer.parseInt(property2);
            }
        }
        this.mAudioLowLatencySupported = context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    }

    private int getNativeOutputSampleRate() {
        return this.mNativeOutputSampleRate;
    }

    private boolean isAudioLowLatencySupported() {
        return this.mAudioLowLatencySupported;
    }

    private int getAudioLowLatencyOutputFrameSize() {
        return this.mAudioLowLatencyOutputFrameSize;
    }

    private int QuerySpeakerStatus() {
        if (this.audioManager.isBluetoothScoOn()) {
            return 5;
        }
        if (this.audioManager.isWiredHeadsetOn()) {
            return 0;
        }
        return this.audioManager.isSpeakerphoneOn() ? 3 : 1;
    }

    private int SetPlayoutSpeaker(boolean z) {
        this.audioManager.setSpeakerphoneOn(z);
        return 0;
    }

    private int SetAudioMode(int i) {
        if (i == 0) {
            this.audioManager.setMode(0);
        } else if (i == 1) {
            this.audioManager.setMode(1);
        } else if (i == 2) {
            this.audioManager.setMode(2);
        } else if (i != 3) {
            this.audioManager.setMode(0);
        } else {
            this.audioManager.setMode(3);
        }
        return 0;
    }

    private int GetAudioMode(int i) {
        return this.audioManager.getMode();
    }

    private boolean isHardwareEarbackSupported() {
        Context context = this.mcontext;
        if (context != null) {
            return HardwareEarbackController.getInstance(context).isHardwareEarbackSupported();
        }
        return false;
    }

    private int enableHardwareEarback(boolean z) {
        Context context = this.mcontext;
        if (context != null) {
            return HardwareEarbackController.getInstance(context).enableHardwareEarback(z);
        }
        return -1;
    }

    private int setHardwareEarbackVolume(int i) {
        Context context = this.mcontext;
        if (context != null) {
            return HardwareEarbackController.getInstance(context).setHardwareEarbackVolume(i);
        }
        return -1;
    }

    private boolean checkAudioPermission() {
        Context context = this.mcontext;
        return context != null && context.checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") == 0 && this.mcontext.checkCallingOrSelfPermission("android.permission.MODIFY_AUDIO_SETTINGS") == 0;
    }
}
