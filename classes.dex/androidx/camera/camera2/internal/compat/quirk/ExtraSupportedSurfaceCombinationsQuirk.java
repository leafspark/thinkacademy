package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Quirk;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExtraSupportedSurfaceCombinationsQuirk implements Quirk {
    private static final String TAG = "ExtraSupportedSurfaceCombinationsQuirk";

    static boolean load() {
        return isSamsungS7();
    }

    private static boolean isSamsungS7() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && ("heroqltevzw".equalsIgnoreCase(Build.DEVICE) || "heroqltetmo".equalsIgnoreCase(Build.DEVICE));
    }

    public List<SurfaceCombination> getExtraSupportedSurfaceCombinations(String str) {
        if (isSamsungS7()) {
            return getSamsungS7ExtraCombinations(str);
        }
        Logger.w(TAG, "Cannot retrieve list of extra supported surface combinations on this device.");
        return Collections.emptyList();
    }

    private List<SurfaceCombination> getSamsungS7ExtraCombinations(String str) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("1")) {
            SurfaceCombination surfaceCombination = new SurfaceCombination();
            surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.ANALYSIS));
            surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.PRIV, SurfaceConfig.ConfigSize.PREVIEW));
            surfaceCombination.addSurfaceConfig(SurfaceConfig.create(SurfaceConfig.ConfigType.YUV, SurfaceConfig.ConfigSize.MAXIMUM));
            arrayList.add(surfaceCombination);
        }
        return arrayList;
    }
}
