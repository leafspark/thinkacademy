package androidx.camera.camera2;

import android.content.Context;
import androidx.camera.camera2.internal.Camera2DeviceSurfaceManager;
import androidx.camera.camera2.internal.Camera2UseCaseConfigFactory;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.CameraXConfig;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.UseCaseConfigFactory;
import java.util.Set;

public final class Camera2Config {
    private Camera2Config() {
    }

    public static CameraXConfig defaultConfig() {
        Camera2Config$$ExternalSyntheticLambda1 camera2Config$$ExternalSyntheticLambda1 = Camera2Config$$ExternalSyntheticLambda1.INSTANCE;
        Camera2Config$$ExternalSyntheticLambda0 camera2Config$$ExternalSyntheticLambda0 = Camera2Config$$ExternalSyntheticLambda0.INSTANCE;
        return new CameraXConfig.Builder().setCameraFactoryProvider(camera2Config$$ExternalSyntheticLambda1).setDeviceSurfaceManagerProvider(camera2Config$$ExternalSyntheticLambda0).setUseCaseConfigFactoryProvider(Camera2Config$$ExternalSyntheticLambda2.INSTANCE).build();
    }

    static /* synthetic */ CameraDeviceSurfaceManager lambda$defaultConfig$0(Context context, Object obj, Set set) throws InitializationException {
        try {
            return new Camera2DeviceSurfaceManager(context, obj, set);
        } catch (CameraUnavailableException e) {
            throw new InitializationException((Throwable) e);
        }
    }

    static /* synthetic */ UseCaseConfigFactory lambda$defaultConfig$1(Context context) throws InitializationException {
        return new Camera2UseCaseConfigFactory(context);
    }

    public static final class DefaultProvider implements CameraXConfig.Provider {
        public CameraXConfig getCameraXConfig() {
            return Camera2Config.defaultConfig();
        }
    }
}
