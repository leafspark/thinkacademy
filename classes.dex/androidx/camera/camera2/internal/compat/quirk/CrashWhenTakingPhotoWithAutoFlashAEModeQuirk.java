package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;
import java.util.Arrays;
import java.util.List;

public class CrashWhenTakingPhotoWithAutoFlashAEModeQuirk implements Quirk {
    static final List<String> AFFECTED_MODELS = Arrays.asList(new String[]{"5059X"});

    static boolean load() {
        if (("SAMSUNG".equals(Build.MANUFACTURER.toUpperCase()) && Build.MODEL.toUpperCase().startsWith("SM-A300")) || AFFECTED_MODELS.contains(Build.MODEL.toUpperCase())) {
            return true;
        }
        return false;
    }
}
