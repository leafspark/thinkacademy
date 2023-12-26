package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCharacteristics;
import java.util.HashMap;
import java.util.Map;

public class CameraCharacteristicsCompat {
    private final CameraCharacteristics mCameraCharacteristics;
    private final Map<CameraCharacteristics.Key<?>, Object> mValuesCache = new HashMap();

    private CameraCharacteristicsCompat(CameraCharacteristics cameraCharacteristics) {
        this.mCameraCharacteristics = cameraCharacteristics;
    }

    public static CameraCharacteristicsCompat toCameraCharacteristicsCompat(CameraCharacteristics cameraCharacteristics) {
        return new CameraCharacteristicsCompat(cameraCharacteristics);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T get(android.hardware.camera2.CameraCharacteristics.Key<T> r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map<android.hardware.camera2.CameraCharacteristics$Key<?>, java.lang.Object> r0 = r2.mValuesCache     // Catch:{ all -> 0x001a }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r2)     // Catch:{ all -> 0x001a }
            return r0
        L_0x000b:
            android.hardware.camera2.CameraCharacteristics r0 = r2.mCameraCharacteristics     // Catch:{ all -> 0x001a }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0018
            java.util.Map<android.hardware.camera2.CameraCharacteristics$Key<?>, java.lang.Object> r1 = r2.mValuesCache     // Catch:{ all -> 0x001a }
            r1.put(r3, r0)     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r2)     // Catch:{ all -> 0x001a }
            return r0
        L_0x001a:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat.get(android.hardware.camera2.CameraCharacteristics$Key):java.lang.Object");
    }

    public CameraCharacteristics toCameraCharacteristics() {
        return this.mCameraCharacteristics;
    }
}
