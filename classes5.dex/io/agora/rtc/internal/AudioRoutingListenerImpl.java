package io.agora.rtc.internal;

class AudioRoutingListenerImpl implements AudioRoutingListener {
    private long mAudioRoutingNativeHandle = 0;

    /* access modifiers changed from: package-private */
    public native void nativeAudioRoutingChanged(long j, int i);

    /* access modifiers changed from: package-private */
    public native void nativeAudioRoutingError(long j, int i);

    AudioRoutingListenerImpl(long j) {
        this.mAudioRoutingNativeHandle = j;
    }

    public void onAudioRoutingChanged(int i) {
        synchronized (this) {
            nativeAudioRoutingChanged(this.mAudioRoutingNativeHandle, i);
        }
    }

    public void onAudioRoutingError(int i) {
        synchronized (this) {
            nativeAudioRoutingError(this.mAudioRoutingNativeHandle, i);
        }
    }

    public void onAudioRoutingDestroyed() {
        synchronized (this) {
            this.mAudioRoutingNativeHandle = 0;
        }
    }
}
