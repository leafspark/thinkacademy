package androidx.camera.core.impl;

import android.content.Context;
import android.util.Size;
import androidx.camera.core.InitializationException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface CameraDeviceSurfaceManager {

    public interface Provider {
        CameraDeviceSurfaceManager newInstance(Context context, Object obj, Set<String> set) throws InitializationException;
    }

    boolean checkSupported(String str, List<SurfaceConfig> list);

    Map<UseCaseConfig<?>, Size> getSuggestedResolutions(String str, List<SurfaceConfig> list, List<UseCaseConfig<?>> list2);

    SurfaceConfig transformSurfaceConfig(String str, int i, Size size);
}
