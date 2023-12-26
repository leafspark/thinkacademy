package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class Futures$$ExternalSyntheticLambda0 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ ListenableFuture f$0;

    public /* synthetic */ Futures$$ExternalSyntheticLambda0(ListenableFuture listenableFuture) {
        this.f$0 = listenableFuture;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return Futures.propagateTransform(false, this.f$0, Futures.IDENTITY_FUNCTION, completer, CameraXExecutors.directExecutor());
    }
}
