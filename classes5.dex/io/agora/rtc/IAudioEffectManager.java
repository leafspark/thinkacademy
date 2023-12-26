package io.agora.rtc;

import io.agora.rtc.audio.AgoraRhythmPlayerConfig;

public interface IAudioEffectManager {
    int configRhythmPlayer(AgoraRhythmPlayerConfig agoraRhythmPlayerConfig);

    int getEffectCurrentPosition(int i);

    int getEffectDuration(String str);

    double getEffectsVolume();

    int pauseAllEffects();

    int pauseEffect(int i);

    @Deprecated
    int playEffect(int i, String str, int i2, double d, double d2, double d3);

    @Deprecated
    int playEffect(int i, String str, int i2, double d, double d2, double d3, boolean z);

    int playEffect(int i, String str, int i2, double d, double d2, double d3, boolean z, int i3);

    int preloadEffect(int i, String str);

    int resumeAllEffects();

    int resumeEffect(int i);

    int setEffectPosition(int i, int i2);

    int setEffectsVolume(double d);

    int setVolumeOfEffect(int i, double d);

    int startRhythmPlayer(String str, String str2, AgoraRhythmPlayerConfig agoraRhythmPlayerConfig);

    int stopAllEffects();

    int stopEffect(int i);

    int stopRhythmPlayer();

    int unloadEffect(int i);
}
