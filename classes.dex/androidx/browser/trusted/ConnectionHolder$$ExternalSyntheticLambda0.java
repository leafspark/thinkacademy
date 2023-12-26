package androidx.browser.trusted;

import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class ConnectionHolder$$ExternalSyntheticLambda0 implements CallbackToFutureAdapter.Resolver {
    public final /* synthetic */ ConnectionHolder f$0;

    public /* synthetic */ ConnectionHolder$$ExternalSyntheticLambda0(ConnectionHolder connectionHolder) {
        this.f$0 = connectionHolder;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f$0.lambda$getServiceWrapper$0$ConnectionHolder(completer);
    }
}
