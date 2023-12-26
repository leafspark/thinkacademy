package androidx.camera.camera2.internal.compat.workaround;

import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.StillCaptureFlashStopRepeatingQuirk;

public class StillCaptureFlow {
    private final boolean mShouldStopRepeatingBeforeStillCapture;

    public StillCaptureFlow() {
        this.mShouldStopRepeatingBeforeStillCapture = ((StillCaptureFlashStopRepeatingQuirk) DeviceQuirks.get(StillCaptureFlashStopRepeatingQuirk.class)) != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0012  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldStopRepeatingBeforeCapture(java.util.List<android.hardware.camera2.CaptureRequest> r3, boolean r4) {
        /*
            r2 = this;
            boolean r0 = r2.mShouldStopRepeatingBeforeStillCapture
            r1 = 0
            if (r0 == 0) goto L_0x002c
            if (r4 != 0) goto L_0x0008
            goto L_0x002c
        L_0x0008:
            java.util.Iterator r3 = r3.iterator()
        L_0x000c:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x002c
            java.lang.Object r4 = r3.next()
            android.hardware.camera2.CaptureRequest r4 = (android.hardware.camera2.CaptureRequest) r4
            android.hardware.camera2.CaptureRequest$Key r0 = android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE
            java.lang.Object r4 = r4.get(r0)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r0 = 2
            if (r4 == r0) goto L_0x002a
            r0 = 3
            if (r4 != r0) goto L_0x000c
        L_0x002a:
            r3 = 1
            return r3
        L_0x002c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.compat.workaround.StillCaptureFlow.shouldStopRepeatingBeforeCapture(java.util.List, boolean):boolean");
    }
}
