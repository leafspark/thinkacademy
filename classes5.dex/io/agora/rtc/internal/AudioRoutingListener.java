package io.agora.rtc.internal;

interface AudioRoutingListener {
    void onAudioRoutingChanged(int i);

    void onAudioRoutingDestroyed();

    void onAudioRoutingError(int i);
}
