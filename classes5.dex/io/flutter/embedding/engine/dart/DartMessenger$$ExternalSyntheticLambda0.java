package io.flutter.embedding.engine.dart;

import io.flutter.embedding.engine.dart.DartMessenger;
import java.nio.ByteBuffer;

public final /* synthetic */ class DartMessenger$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DartMessenger f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ DartMessenger.HandlerInfo f$3;
    public final /* synthetic */ ByteBuffer f$4;
    public final /* synthetic */ long f$5;

    public /* synthetic */ DartMessenger$$ExternalSyntheticLambda0(DartMessenger dartMessenger, String str, int i, DartMessenger.HandlerInfo handlerInfo, ByteBuffer byteBuffer, long j) {
        this.f$0 = dartMessenger;
        this.f$1 = str;
        this.f$2 = i;
        this.f$3 = handlerInfo;
        this.f$4 = byteBuffer;
        this.f$5 = j;
    }

    public final void run() {
        this.f$0.lambda$dispatchMessageToQueue$0$DartMessenger(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
