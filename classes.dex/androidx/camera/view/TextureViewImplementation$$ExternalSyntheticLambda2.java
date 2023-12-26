package androidx.camera.view;

import androidx.camera.core.SurfaceRequest;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;

public final /* synthetic */ class TextureViewImplementation$$ExternalSyntheticLambda2 implements Consumer {
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$0;

    public /* synthetic */ TextureViewImplementation$$ExternalSyntheticLambda2(CallbackToFutureAdapter.Completer completer) {
        this.f$0 = completer;
    }

    public final void accept(Object obj) {
        this.f$0.set((SurfaceRequest.Result) obj);
    }
}
