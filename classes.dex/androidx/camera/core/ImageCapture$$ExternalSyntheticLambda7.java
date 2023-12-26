package androidx.camera.core;

import androidx.camera.core.internal.YuvToJpegProcessor;

public final /* synthetic */ class ImageCapture$$ExternalSyntheticLambda7 implements Runnable {
    public final /* synthetic */ YuvToJpegProcessor f$0;
    public final /* synthetic */ CaptureProcessorPipeline f$1;

    public /* synthetic */ ImageCapture$$ExternalSyntheticLambda7(YuvToJpegProcessor yuvToJpegProcessor, CaptureProcessorPipeline captureProcessorPipeline) {
        this.f$0 = yuvToJpegProcessor;
        this.f$1 = captureProcessorPipeline;
    }

    public final void run() {
        ImageCapture.lambda$createPipeline$1(this.f$0, this.f$1);
    }
}
