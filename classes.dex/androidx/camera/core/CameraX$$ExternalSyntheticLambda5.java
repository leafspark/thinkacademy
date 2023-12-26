package androidx.camera.core;

import android.content.Context;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class CameraX$$ExternalSyntheticLambda5 implements AsyncFunction {
    public final /* synthetic */ CameraX f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ CameraX$$ExternalSyntheticLambda5(CameraX cameraX, Context context) {
        this.f$0 = cameraX;
        this.f$1 = context;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f$0.initInternal(this.f$1);
    }
}
