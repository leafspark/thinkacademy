package androidx.camera.camera2.internal;

import java.util.LinkedHashSet;

public final /* synthetic */ class CaptureSessionRepository$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ LinkedHashSet f$0;

    public /* synthetic */ CaptureSessionRepository$1$$ExternalSyntheticLambda0(LinkedHashSet linkedHashSet) {
        this.f$0 = linkedHashSet;
    }

    public final void run() {
        CaptureSessionRepository.forceOnClosed(this.f$0);
    }
}
