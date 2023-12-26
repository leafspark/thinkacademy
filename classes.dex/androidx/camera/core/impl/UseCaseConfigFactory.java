package androidx.camera.core.impl;

import android.content.Context;
import androidx.camera.core.InitializationException;

public interface UseCaseConfigFactory {

    public enum CaptureType {
        IMAGE_CAPTURE,
        PREVIEW,
        IMAGE_ANALYSIS,
        VIDEO_CAPTURE
    }

    public interface Provider {
        UseCaseConfigFactory newInstance(Context context) throws InitializationException;
    }

    Config getConfig(CaptureType captureType);
}
