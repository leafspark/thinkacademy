package io.agora.rtc.video;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.bonree.sdk.agent.engine.external.XMLParseInstrumentation;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.internal.DeviceUtils;
import io.agora.rtc.internal.Logging;

public class VideoCaptureFactory {
    private static final int ANDROID_CAMERA1 = 0;
    private static final int ANDROID_CAMERA2 = 1;
    private static final int ANDROID_CAMERA_NOT_DEFINE = -1;
    private static final String TAG = "CAM-FACTORY";

    static class AndroidCameraInfo {
        AndroidCameraInfo() {
        }

        /* access modifiers changed from: private */
        public static int getNumberOfCameras(Context context) {
            int i = 0;
            if (Build.VERSION.SDK_INT >= 23 || context.getPackageManager().checkPermission("android.permission.CAMERA", context.getPackageName()) == 0) {
                if (VideoCaptureFactory.isLReleaseOrLater()) {
                    i = VideoCaptureCamera2.getNumberOfCameras(context);
                }
                return i == 0 ? VideoCaptureCamera.getNumberOfCameras() : i;
            }
            Log.e(VideoCaptureFactory.TAG, "Missing android.permission.CAMERA permission, no system camera available");
            return 0;
        }
    }

    public static boolean isLReleaseOrLater() {
        if ("ocean".equalsIgnoreCase(Build.DEVICE) && "oe106".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        if ("trident".equalsIgnoreCase(Build.DEVICE) && "de106".equalsIgnoreCase(Build.MODEL)) {
            return false;
        }
        if (("shark".equalsIgnoreCase(Build.DEVICE) && "skr-a0".equalsIgnoreCase(Build.MODEL)) || "hnnem-h".equalsIgnoreCase(Build.DEVICE)) {
            return false;
        }
        if (("on7xelte".equals(Build.DEVICE) && "SM-G610F".equals(Build.MODEL)) || "m2c".equals(Build.DEVICE) || "M578CA".equals(Build.MODEL)) {
            return false;
        }
        if ("samsung".equalsIgnoreCase(Build.MANUFACTURER) && Build.MODEL != null && (Build.MODEL.contains("SM-G930") || Build.MODEL.contains("SM-G935") || Build.MODEL.contains("SM-G950") || Build.MODEL.contains("SM-G955") || "SC-02H".equals(Build.MODEL) || "SCV33".equals(Build.MODEL) || "SC-02J".equals(Build.MODEL) || "SCV36".equals(Build.MODEL) || "SM-G892A".equals(Build.MODEL) || "SM-G892U".equals(Build.MODEL) || "SC-03J".equals(Build.MODEL) || "SCV35".equals(Build.MODEL))) {
            return false;
        }
        if ((!"oneplus".equalsIgnoreCase(Build.MANUFACTURER) || Build.MODEL.contains("ONEPLUS A6")) && Build.VERSION.SDK_INT >= 21) {
            return true;
        }
        return false;
    }

    public static VideoCapture createVideoCapture(Context context, int i, int i2, int i3, int i4, EglBase.Context context2, long j) {
        Logging.i(TAG, "createVideoCapture id: " + i + " select: " + i2 + " pqFirst: " + i3 + " lowPowerFlag: " + i4);
        if (i4 != fetchLowPowerFlag(context)) {
            cacheLowPowerFlag(context, i4);
            VideoCapture.clearCapabilityCache(context);
        }
        if (checkCamera2Availability(i, context, i2)) {
            Logging.d(TAG, "create CAMERA2, id:" + i);
            return new VideoCaptureCamera2(context, i, i3, context2, j);
        }
        Logging.d(TAG, "create CAMERA1, id:" + i);
        return new VideoCaptureCamera(context, i, i3, context2, j);
    }

    public static int getNumberOfCameras(Context context) {
        return AndroidCameraInfo.getNumberOfCameras(context);
    }

    public static int getFrontCameraIndex(Context context) {
        int selectFrontCamera = DeviceUtils.selectFrontCamera(context);
        Logging.i(TAG, "getFrontCameraIndex  = " + selectFrontCamera);
        return selectFrontCamera;
    }

    public static String getDeviceName(int i, Context context, int i2) {
        if (checkCamera2Availability(i, context, i2)) {
            return VideoCaptureCamera2.getName(i, context);
        }
        return VideoCaptureCamera.getName(i);
    }

    public static boolean checkCamera2Availability(int i, Context context, int i2) {
        if (i2 == 1 && isLReleaseOrLater()) {
            return true;
        }
        if (i2 != -1 || !isLReleaseOrLater() || VideoCaptureCamera2.isLegacyDevice(context, i)) {
            return false;
        }
        return true;
    }

    public static int getDeviceOrientation(int i, Context context, int i2) {
        if (checkCamera2Availability(i, context, i2)) {
            return VideoCaptureCamera2.getSensorOrientation(i, context);
        }
        return VideoCaptureCamera.getSensorOrientation(i);
    }

    public static String getCapabilities(int i, Context context, int i2) {
        String str;
        if (checkCamera2Availability(i, context, i2)) {
            str = VideoCapture.fetchCapability(i, context, VideoCaptureCamera2.getCaptureName());
        } else {
            str = VideoCapture.fetchCapability(i, context, VideoCaptureCamera.getCaptureName());
        }
        if (str == null) {
            Logging.e(TAG, "Capability hasn't been created");
        } else {
            printCameraInfo(str);
        }
        return str;
    }

    public static void cacheLowPowerFlag(Context context, int i) {
        SharedPreferences.Editor edit = (!(context instanceof Context) ? context.getSharedPreferences("CamCapsLowPower", 0) : XMLParseInstrumentation.getSharedPreferences(context, "CamCapsLowPower", 0)).edit();
        edit.putInt("Cam_LowPower", i);
        edit.commit();
    }

    public static int fetchLowPowerFlag(Context context) {
        SharedPreferences sharedPreferences = !(context instanceof Context) ? context.getSharedPreferences("CamCapsLowPower", 0) : XMLParseInstrumentation.getSharedPreferences(context, "CamCapsLowPower", 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("Cam_LowPower", -1);
        }
        return 0;
    }

    public static int printCameraInfo(String str) {
        String str2;
        int length = (str.length() / 150) + 1;
        for (int i = 0; i < length; i++) {
            try {
                String str3 = "lines = " + length + ":";
                if (i == length - 1) {
                    str2 = str3 + str.substring(i * 150, str.length());
                } else {
                    str2 = str3 + str.substring(i * 150, (i + 1) * 150);
                }
                Logging.d("CameraInfo", str2);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
