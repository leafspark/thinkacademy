package androidx.camera.core;

import android.view.Surface;

public final /* synthetic */ class VideoCapture$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Surface f$0;

    public /* synthetic */ VideoCapture$$ExternalSyntheticLambda1(Surface surface) {
        this.f$0 = surface;
    }

    public final void run() {
        this.f$0.release();
    }
}
