package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.core.util.Consumer;

public final /* synthetic */ class SurfaceRequest$$ExternalSyntheticLambda6 implements Runnable {
    public final /* synthetic */ Consumer f$0;
    public final /* synthetic */ Surface f$1;

    public /* synthetic */ SurfaceRequest$$ExternalSyntheticLambda6(Consumer consumer, Surface surface) {
        this.f$0 = consumer;
        this.f$1 = surface;
    }

    public final void run() {
        this.f$0.accept(SurfaceRequest.Result.of(3, this.f$1));
    }
}
