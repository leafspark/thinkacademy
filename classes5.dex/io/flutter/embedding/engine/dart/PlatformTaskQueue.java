package io.flutter.embedding.engine.dart;

import android.os.Handler;
import android.os.Looper;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import io.flutter.embedding.engine.dart.DartMessenger;
import io.flutter.util.HandlerCompat;

public class PlatformTaskQueue implements DartMessenger.DartMessengerTaskQueue {
    private final Handler handler = HandlerCompat.createAsyncHandler(Looper.getMainLooper());

    public void dispatch(Runnable runnable) {
        Handler handler2 = this.handler;
        if (!(handler2 instanceof Handler)) {
            handler2.post(runnable);
        } else {
            AsynchronousInstrumentation.handlerPost(handler2, runnable);
        }
    }
}
