package androidx.camera.core;

public final /* synthetic */ class ProcessingSurface$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ ProcessingSurface f$0;

    public /* synthetic */ ProcessingSurface$$ExternalSyntheticLambda1(ProcessingSurface processingSurface) {
        this.f$0 = processingSurface;
    }

    public final void run() {
        this.f$0.release();
    }
}
