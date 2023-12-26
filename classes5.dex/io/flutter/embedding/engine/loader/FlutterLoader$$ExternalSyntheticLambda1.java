package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.os.Handler;

public final /* synthetic */ class FlutterLoader$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ FlutterLoader f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ String[] f$2;
    public final /* synthetic */ Handler f$3;
    public final /* synthetic */ Runnable f$4;

    public /* synthetic */ FlutterLoader$$ExternalSyntheticLambda1(FlutterLoader flutterLoader, Context context, String[] strArr, Handler handler, Runnable runnable) {
        this.f$0 = flutterLoader;
        this.f$1 = context;
        this.f$2 = strArr;
        this.f$3 = handler;
        this.f$4 = runnable;
    }

    public final void run() {
        this.f$0.lambda$ensureInitializationCompleteAsync$1$FlutterLoader(this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
