package io.agora.rtc.video;

public class CameraUtil {
    private static final String TAG = "CAMERA_UTIL";

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getCameraDisplayOrientation(android.content.Context r3, int r4) {
        /*
            android.hardware.Camera$CameraInfo r0 = new android.hardware.Camera$CameraInfo
            r0.<init>()
            android.hardware.Camera.getCameraInfo(r4, r0)
            r4 = 90
            if (r3 == 0) goto L_0x0056
            java.lang.String r1 = "window"
            java.lang.Object r2 = r3.getSystemService(r1)
            if (r2 == 0) goto L_0x0056
            java.lang.Object r3 = r3.getSystemService(r1)
            android.view.WindowManager r3 = (android.view.WindowManager) r3
            android.view.WindowManager r3 = (android.view.WindowManager) r3
            android.view.Display r3 = r3.getDefaultDisplay()
            if (r3 != 0) goto L_0x002a
            java.lang.String r3 = "CAMERA_UTIL"
            java.lang.String r0 = "display is null"
            io.agora.rtc.internal.Logging.e(r3, r0)
            return r4
        L_0x002a:
            int r3 = r3.getRotation()
            r1 = 1
            r2 = 0
            if (r3 == 0) goto L_0x003a
            if (r3 == r1) goto L_0x0041
            r4 = 2
            if (r3 == r4) goto L_0x003f
            r4 = 3
            if (r3 == r4) goto L_0x003c
        L_0x003a:
            r4 = r2
            goto L_0x0041
        L_0x003c:
            r4 = 270(0x10e, float:3.78E-43)
            goto L_0x0041
        L_0x003f:
            r4 = 180(0xb4, float:2.52E-43)
        L_0x0041:
            int r3 = r0.facing
            if (r3 != r1) goto L_0x004f
            int r3 = r0.orientation
            int r3 = r3 + r4
            int r3 = r3 % 360
            int r3 = 360 - r3
            int r4 = r3 % 360
            goto L_0x0056
        L_0x004f:
            int r3 = r0.orientation
            int r3 = r3 - r4
            int r3 = r3 + 360
            int r4 = r3 % 360
        L_0x0056:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.rtc.video.CameraUtil.getCameraDisplayOrientation(android.content.Context, int):int");
    }
}
