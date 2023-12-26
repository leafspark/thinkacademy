package io.agora.rtc.video;

import android.hardware.Camera;
import io.agora.rtc.internal.Logging;
import java.util.ArrayList;
import java.util.List;

public class CameraHelper {
    private static final String TAG = "CameraHelper";

    public static boolean checkPermission() {
        return true;
    }

    public static class Capability {
        public static final int CAMERA_FACING_BACK = 0;
        public static final int CAMERA_FACING_FRONT = 1;
        public int facing;
        public int height;
        public int id;
        public int maxFps;
        public int width;

        public Capability(int i, int i2, int i3, int i4, int i5) {
            this.id = i;
            this.facing = i2;
            this.width = i3;
            this.height = i4;
            this.maxFps = i5;
        }
    }

    public static Capability createCapability(int i, int i2, Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (supportedPreviewSizes.isEmpty() || supportedPreviewFpsRange.isEmpty()) {
            Logging.e(TAG, "failed get preview size/fps, parameters = " + parameters.flatten());
            throw new IllegalArgumentException(parameters.flatten());
        }
        Camera.Size size = supportedPreviewSizes.get(0);
        for (Camera.Size next : supportedPreviewSizes) {
            if (next.width * next.height > size.width * size.height) {
                size = next;
            }
        }
        int i3 = supportedPreviewFpsRange.get(0)[1] / 1000;
        Logging.d(TAG, "creaet capability for camera " + i + " : width: " + size.width + " , height: " + size.height + " max fps: " + i3);
        return new Capability(i, i2, size.width, size.height, i3);
    }

    public static synchronized List<Capability> getCameraCapability() {
        ArrayList arrayList;
        synchronized (CameraHelper.class) {
            arrayList = new ArrayList();
            int numberOfCameras = Camera.getNumberOfCameras();
            if (numberOfCameras >= 1) {
                int i = 0;
                while (i < numberOfCameras) {
                    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(i, cameraInfo);
                    try {
                        Camera open = Camera.open(i);
                        arrayList.add(createCapability(i, cameraInfo.facing, open.getParameters()));
                        open.release();
                        i++;
                    } catch (RuntimeException e) {
                        throw e;
                    }
                }
            } else {
                throw new RuntimeException("no camera device");
            }
        }
        return arrayList;
    }
}
