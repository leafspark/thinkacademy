package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.SessionConfig;

public final /* synthetic */ class ImageAnalysis$$ExternalSyntheticLambda1 implements SessionConfig.ErrorListener {
    public final /* synthetic */ ImageAnalysis f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ ImageAnalysisConfig f$2;
    public final /* synthetic */ Size f$3;

    public /* synthetic */ ImageAnalysis$$ExternalSyntheticLambda1(ImageAnalysis imageAnalysis, String str, ImageAnalysisConfig imageAnalysisConfig, Size size) {
        this.f$0 = imageAnalysis;
        this.f$1 = str;
        this.f$2 = imageAnalysisConfig;
        this.f$3 = size;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.f$0.lambda$createPipeline$0$ImageAnalysis(this.f$1, this.f$2, this.f$3, sessionConfig, sessionError);
    }
}
