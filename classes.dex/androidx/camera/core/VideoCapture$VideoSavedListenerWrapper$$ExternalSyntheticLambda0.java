package androidx.camera.core;

import androidx.camera.core.VideoCapture;

public final /* synthetic */ class VideoCapture$VideoSavedListenerWrapper$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ VideoCapture.VideoSavedListenerWrapper f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ Throwable f$3;

    public /* synthetic */ VideoCapture$VideoSavedListenerWrapper$$ExternalSyntheticLambda0(VideoCapture.VideoSavedListenerWrapper videoSavedListenerWrapper, int i, String str, Throwable th) {
        this.f$0 = videoSavedListenerWrapper;
        this.f$1 = i;
        this.f$2 = str;
        this.f$3 = th;
    }

    public final void run() {
        this.f$0.lambda$onError$1$VideoCapture$VideoSavedListenerWrapper(this.f$1, this.f$2, this.f$3);
    }
}
