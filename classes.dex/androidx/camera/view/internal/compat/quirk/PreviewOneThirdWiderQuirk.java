package androidx.camera.view.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.Quirk;

public class PreviewOneThirdWiderQuirk implements Quirk {
    private static final String SAMSUNG_A3_2017 = "A3Y17LTE";
    private static final String SAMSUNG_J5_PRIME = "ON5XELTE";

    public float getCropRectScaleX() {
        return 0.75f;
    }

    static boolean load() {
        boolean z = SAMSUNG_J5_PRIME.equals(Build.DEVICE.toUpperCase()) && Build.VERSION.SDK_INT >= 26;
        boolean equals = SAMSUNG_A3_2017.equals(Build.DEVICE.toUpperCase());
        if (z || equals) {
            return true;
        }
        return false;
    }
}
