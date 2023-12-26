package androidx.camera.camera2.internal.compat.quirk;

import androidx.camera.core.impl.Quirk;
import java.util.ArrayList;
import java.util.List;

public class DeviceQuirksLoader {
    private DeviceQuirksLoader() {
    }

    static List<Quirk> loadQuirks() {
        ArrayList arrayList = new ArrayList();
        if (ImageCapturePixelHDRPlusQuirk.load()) {
            arrayList.add(new ImageCapturePixelHDRPlusQuirk());
        }
        if (SamsungPreviewTargetAspectRatioQuirk.load()) {
            arrayList.add(new SamsungPreviewTargetAspectRatioQuirk());
        }
        if (Nexus4AndroidLTargetAspectRatioQuirk.load()) {
            arrayList.add(new Nexus4AndroidLTargetAspectRatioQuirk());
        }
        if (ExcludedSupportedSizesQuirk.load()) {
            arrayList.add(new ExcludedSupportedSizesQuirk());
        }
        if (CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.load()) {
            arrayList.add(new CrashWhenTakingPhotoWithAutoFlashAEModeQuirk());
        }
        if (PreviewPixelHDRnetQuirk.load()) {
            arrayList.add(new PreviewPixelHDRnetQuirk());
        }
        if (StillCaptureFlashStopRepeatingQuirk.load()) {
            arrayList.add(new StillCaptureFlashStopRepeatingQuirk());
        }
        if (ExtraSupportedSurfaceCombinationsQuirk.load()) {
            arrayList.add(new ExtraSupportedSurfaceCombinationsQuirk());
        }
        return arrayList;
    }
}
