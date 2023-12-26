package androidx.camera.camera2.internal;

public final /* synthetic */ class SynchronizedCaptureSessionBaseImpl$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ SynchronizedCaptureSessionBaseImpl f$0;
    public final /* synthetic */ SynchronizedCaptureSession f$1;

    public /* synthetic */ SynchronizedCaptureSessionBaseImpl$$ExternalSyntheticLambda4(SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl, SynchronizedCaptureSession synchronizedCaptureSession) {
        this.f$0 = synchronizedCaptureSessionBaseImpl;
        this.f$1 = synchronizedCaptureSession;
    }

    public final void run() {
        this.f$0.lambda$onSessionFinished$4$SynchronizedCaptureSessionBaseImpl(this.f$1);
    }
}
