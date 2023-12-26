package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Quirk;

public final class ImageCaptureRotationOptionQuirk implements Quirk {
    static boolean load() {
        return isHuaweiMate20Lite() || isHonor9X();
    }

    private static boolean isHuaweiMate20Lite() {
        return "HUAWEI".equalsIgnoreCase(Build.BRAND) && "SNE-LX1".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isHonor9X() {
        return "HONOR".equalsIgnoreCase(Build.BRAND) && "STK-LX1".equalsIgnoreCase(Build.MODEL);
    }

    public boolean isSupported(Config.Option<?> option) {
        return option != CaptureConfig.OPTION_ROTATION;
    }
}
