package androidx.camera.core.internal;

import java.util.List;

public final /* synthetic */ class CameraUseCaseAdapter$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ List f$0;

    public /* synthetic */ CameraUseCaseAdapter$$ExternalSyntheticLambda0(List list) {
        this.f$0 = list;
    }

    public final void run() {
        CameraUseCaseAdapter.lambda$notifyAttachedUseCasesChange$0(this.f$0);
    }
}
