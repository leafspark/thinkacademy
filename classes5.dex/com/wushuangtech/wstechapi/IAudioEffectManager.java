package com.wushuangtech.wstechapi;

public interface IAudioEffectManager {
    double getEffectsVolume();

    int pauseAllEffects();

    int pauseEffect(int i);

    int playEffect(int i, String str, int i2, double d, double d2, double d3, boolean z);

    int resumeAllEffects();

    int resumeEffect(int i);

    int setEffectsVolume(double d);

    int setVolumeOfEffect(int i, double d);

    int stopAllEffects();

    int stopEffect(int i);
}
