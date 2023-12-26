package io.flutter.embedding.engine.dart;

import io.flutter.embedding.engine.dart.DartMessenger;

public final /* synthetic */ class DartMessenger$SerialTaskQueue$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ DartMessenger.SerialTaskQueue f$0;

    public /* synthetic */ DartMessenger$SerialTaskQueue$$ExternalSyntheticLambda1(DartMessenger.SerialTaskQueue serialTaskQueue) {
        this.f$0 = serialTaskQueue;
    }

    public final void run() {
        this.f$0.lambda$flush$1$DartMessenger$SerialTaskQueue();
    }
}
