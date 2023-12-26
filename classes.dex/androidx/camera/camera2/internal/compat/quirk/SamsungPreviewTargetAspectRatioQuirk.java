package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;

public class SamsungPreviewTargetAspectRatioQuirk implements Quirk {
    private static final List<String> DEVICE_MODELS = Arrays.asList(new String[]{"SM-J710MN", "SM-T580"});

    static boolean load() {
        return "SAMSUNG".equals(Build.BRAND.toUpperCase()) && DEVICE_MODELS.contains(Build.MODEL.toUpperCase());
    }

    public boolean require16_9(Config config) {
        return config instanceof PreviewConfig;
    }
}
