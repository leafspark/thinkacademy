package com.wushuangtech.myvideoimprove.utils;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.util.Log;
import java.util.List;

public class MyCameraUtils {
    public static final int CAMERA_LEVEL = 1;
    public static final int CAMERA_LEVEL_ONE = 1;
    public static final int CAMERA_LEVEL_TWO = 2;
    public static final int CAMERA_SUPPORT_EXPOSURE = 4;
    public static final int CAMERA_SUPPORT_FACE_FOCUS = 5;
    public static final int CAMERA_SUPPORT_FOCUS = 3;
    public static final int CAMERA_SUPPORT_TORCH = 2;
    public static final int CAMERA_SUPPORT_ZOOM = 1;
    private static final String TAG = "MyCameraUtils";

    public static boolean supportSwitchCamera() {
        return Camera.getNumberOfCameras() > 1;
    }

    public static boolean hasBackFacingCamera() {
        return checkCameraFacing(0);
    }

    public static boolean hasFrontFacingCamera() {
        return checkCameraFacing(1);
    }

    public static boolean hasBackFacingCamera2(Context context) {
        return checkCamera2Facing(context, 1);
    }

    public static String autoSelectCamera2ID(Context context, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (context == null) {
            Log.e(TAG, "Selecting the correct camera2 instance, But Context obj is null!");
            return null;
        }
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        if (cameraManager == null) {
            Log.e(TAG, "Selecting the correct camera2 instance, But CameraManager obj is null!");
            return null;
        }
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            if (cameraIdList.length <= 0) {
                Log.e(TAG, "Selecting the correct camera2 instance, But the number of camera instances is zero");
                return null;
            }
            String str = TAG;
            Log.d(str, "The number of camera instances : " + cameraIdList.length);
            String str2 = null;
            for (int i2 = 0; i2 < cameraIdList.length; i2++) {
                String str3 = TAG;
                Log.d(str3, "Iterate over the camera instance : " + cameraIdList[i2]);
                if (i == i2) {
                    str2 = cameraIdList[i2];
                }
            }
            return str2 == null ? cameraIdList[0] : str2;
        } catch (Exception e) {
            String str4 = TAG;
            Log.e(str4, "An exception occurred while selecting the correct camera2 instance, CameraAccessException! " + e.getLocalizedMessage());
            return null;
        }
    }

    public static boolean hasFrontFacingCamera2(Context context) {
        return checkCamera2Facing(context, 0);
    }

    public static int autoSelectCameraID(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        String str = TAG;
        Log.d(str, "Camera nums : " + numberOfCameras);
        if (numberOfCameras <= 0) {
            Log.e(str, "autoSelectCameraID -> camera num is zero!");
            return -1;
        } else if (i < numberOfCameras) {
            return i;
        } else {
            return 0;
        }
    }

    public static boolean hasExtraFacingCamera2(Context context) {
        return checkCamera2Facing(context, 2);
    }

    public static int getCameraMaxZoom(int i) {
        Camera camera = null;
        try {
            camera = Camera.open(i);
            if (camera != null) {
                int maxZoom = camera.getParameters().getMaxZoom();
                if (camera != null) {
                    camera.release();
                }
                return maxZoom;
            }
            if (camera == null) {
                return 0;
            }
            camera.release();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            if (camera == null) {
                return 0;
            }
        } catch (Throwable th) {
            if (camera != null) {
                camera.release();
            }
            throw th;
        }
    }

    public static boolean inspectCameraSupports(int i, int i2) {
        Camera camera = null;
        try {
            camera = Camera.open(i);
            if (camera != null) {
                boolean inspectCameraSupports = inspectCameraSupports(camera.getParameters(), i2);
                if (camera != null) {
                    camera.release();
                }
                return inspectCameraSupports;
            }
            if (camera == null) {
                return false;
            }
            camera.release();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            if (camera == null) {
                return false;
            }
        } catch (Throwable th) {
            if (camera != null) {
                camera.release();
            }
            throw th;
        }
    }

    public static boolean inspectCameraSupports(Camera.Parameters parameters, int i) {
        if (parameters == null) {
            return false;
        }
        if (i == 1) {
            return parameters.isZoomSupported();
        }
        if (i == 2) {
            List<String> supportedFlashModes = parameters.getSupportedFlashModes();
            if (supportedFlashModes == null) {
                return false;
            }
            return supportedFlashModes.contains("torch");
        } else if (i != 3) {
            if (i != 4) {
                return i == 5 && parameters.getMaxNumDetectedFaces() > 0;
            }
            if (parameters.getMaxExposureCompensation() - parameters.getMinExposureCompensation() > 0) {
                return true;
            }
            return false;
        } else if (parameters.getMaxNumFocusAreas() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] calVideoEncodeSize(int i, int i2, int i3, int i4, int i5) {
        if (i == 90 || i == 270) {
            int min = Math.min(i4, i3);
            int min2 = Math.min(i5, i2);
            if (!(i2 == i5 && i3 == i4)) {
                i4 = min;
                i5 = min2;
            }
            int i6 = i5;
            i5 = i4;
            i4 = i6;
        } else {
            int min3 = Math.min(i4, i2);
            int min4 = Math.min(i5, i3);
            if (!(i2 == i4 && i3 == i5)) {
                i4 = min3;
                i5 = min4;
            }
        }
        int i7 = 16;
        if (isMtk()) {
            i7 = 32;
        }
        int i8 = i4 % i7;
        int i9 = i5 % i7;
        if (i4 >= 240 && i5 >= 240) {
            if (i8 != 0) {
                i4 -= i8;
            }
            if (i9 != 0) {
                i5 -= i9;
            }
        }
        return new int[]{i4, i5};
    }

    private static boolean checkCameraFacing(int i) {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            String str = TAG;
            Log.d(str, "Camera nums : " + numberOfCameras);
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            for (int i2 = 0; i2 < numberOfCameras; i2++) {
                Camera.getCameraInfo(i2, cameraInfo);
                String str2 = TAG;
                Log.d(str2, "Camera iterator : " + cameraInfo.facing);
                if (i == cameraInfo.facing) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            String str3 = TAG;
            Log.e(str3, "checkCameraFacing -> Exception! " + e.getLocalizedMessage());
            return false;
        }
    }

    private static boolean checkCamera2Facing(Context context, int i) {
        if (context == null) {
            return false;
        }
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        if (cameraManager == null) {
            Log.e(TAG, "checkCamera2Facing -> CameraManager is null!");
            return false;
        }
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            if (cameraIdList.length <= 0) {
                Log.e(TAG, "checkCamera2Facing -> cameraIdList len is zero!");
                return false;
            }
            for (String cameraCharacteristics : cameraIdList) {
                Integer num = (Integer) cameraManager.getCameraCharacteristics(cameraCharacteristics).get(CameraCharacteristics.LENS_FACING);
                if (num != null && num.intValue() == i) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            Log.e(TAG, "checkCamera2Facing -> Exception! " + e.getLocalizedMessage());
            return false;
        }
    }

    private static boolean isMtk() {
        int codecCount = MediaCodecList.getCodecCount();
        MediaCodecInfo mediaCodecInfo = null;
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                int length = supportedTypes.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (supportedTypes[i2].equalsIgnoreCase("video/avc")) {
                        mediaCodecInfo = codecInfoAt;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (mediaCodecInfo != null) {
                    break;
                }
            }
        }
        if (mediaCodecInfo == null || !mediaCodecInfo.getName().contains("MTK")) {
            return false;
        }
        return true;
    }
}
