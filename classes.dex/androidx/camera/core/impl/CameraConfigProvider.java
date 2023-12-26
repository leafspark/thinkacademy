package androidx.camera.core.impl;

import android.content.Context;
import androidx.camera.core.CameraInfo;

public interface CameraConfigProvider {
    public static final CameraConfigProvider EMPTY = CameraConfigProvider$$ExternalSyntheticLambda0.INSTANCE;

    /* renamed from: androidx.camera.core.impl.CameraConfigProvider$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            CameraConfigProvider cameraConfigProvider = CameraConfigProvider.EMPTY;
        }

        public static /* synthetic */ CameraConfig lambda$static$0(CameraInfo cameraInfo, Context context) {
            return null;
        }
    }

    CameraConfig getConfig(CameraInfo cameraInfo, Context context);
}
