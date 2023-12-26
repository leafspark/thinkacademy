package com.wushuangtech.audiocore;

import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.library.GlobalConfig;
import java.nio.ByteBuffer;

public class AudioEffect {
    private static AudioEffect effect;
    private static int nChannels;
    private static int nEffectType;
    private static int nSampleRate;
    private boolean loadLibrary;
    private boolean nEnableEffect;

    private native void ChooseEffectType(int i);

    private native void Process(ByteBuffer byteBuffer, int i, int i2);

    private native void Setup(int i, int i2);

    public void enableAudioEffect(boolean z) {
    }

    public void setup(int i, int i2) {
    }

    public static AudioEffect getInstance() {
        if (effect == null) {
            effect = new AudioEffect();
        }
        return effect;
    }

    public void chooseEffectType(int i) {
        if (nEffectType != i) {
            nEffectType = i;
            AudioEffect audioEffect = effect;
            if (audioEffect != null) {
                audioEffect.ChooseEffectType(i);
            }
        }
    }

    public void process(ByteBuffer byteBuffer, int i, int i2) {
        AudioEffect audioEffect;
        if ((GlobalConfig.mBranch == LocalSDKConstants.BRANCH_CLIENT_MOMO || this.nEnableEffect) && (audioEffect = effect) != null) {
            audioEffect.Process(byteBuffer, i, i2);
        }
    }
}
