package androidx.camera.core;

import androidx.camera.core.VideoCapture;

public final /* synthetic */ class VideoCapture$$ExternalSyntheticLambda5 implements Runnable {
    public final /* synthetic */ VideoCapture f$0;
    public final /* synthetic */ VideoCapture.OnVideoSavedCallback f$1;

    public /* synthetic */ VideoCapture$$ExternalSyntheticLambda5(VideoCapture videoCapture, VideoCapture.OnVideoSavedCallback onVideoSavedCallback) {
        this.f$0 = videoCapture;
        this.f$1 = onVideoSavedCallback;
    }

    public final void run() {
        this.f$0.lambda$startRecording$3$VideoCapture(this.f$1);
    }
}
