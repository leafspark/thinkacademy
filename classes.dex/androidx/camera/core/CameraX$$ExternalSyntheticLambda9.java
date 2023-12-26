package androidx.camera.core;

import android.content.Context;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class CameraX$$ExternalSyntheticLambda9 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ CameraX f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ CameraX$$ExternalSyntheticLambda9(CameraX cameraX, Context context) {
        this.f$0 = cameraX;
        this.f$1 = context;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return CameraX.lambda$initializeInstanceLocked$3(this.f$0, this.f$1, completer);
    }
}
