package androidx.camera.core;

import android.media.MediaCodec;

public final /* synthetic */ class VideoCapture$$ExternalSyntheticLambda8 implements Runnable {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ MediaCodec f$1;

    public /* synthetic */ VideoCapture$$ExternalSyntheticLambda8(boolean z, MediaCodec mediaCodec) {
        this.f$0 = z;
        this.f$1 = mediaCodec;
    }

    public final void run() {
        VideoCapture.lambda$releaseCameraSurface$7(this.f$0, this.f$1);
    }
}
