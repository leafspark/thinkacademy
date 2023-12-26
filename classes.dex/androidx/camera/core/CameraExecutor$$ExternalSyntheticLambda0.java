package androidx.camera.core;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public final /* synthetic */ class CameraExecutor$$ExternalSyntheticLambda0 implements RejectedExecutionHandler {
    public static final /* synthetic */ CameraExecutor$$ExternalSyntheticLambda0 INSTANCE = new CameraExecutor$$ExternalSyntheticLambda0();

    private /* synthetic */ CameraExecutor$$ExternalSyntheticLambda0() {
    }

    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        Logger.e(CameraExecutor.TAG, "A rejected execution occurred in CameraExecutor!");
    }
}
