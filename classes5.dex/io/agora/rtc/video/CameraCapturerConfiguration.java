package io.agora.rtc.video;

import io.flutter.plugin.platform.PlatformPlugin;

public class CameraCapturerConfiguration {
    public static final CaptureDimensions CD_1280x720 = new CaptureDimensions(PlatformPlugin.DEFAULT_SYSTEM_UI, 720);
    public static final CaptureDimensions CD_1920x1080 = new CaptureDimensions(1920, 1080);
    public static final CaptureDimensions CD_640x480 = new CaptureDimensions(640, 480);
    public CAMERA_DIRECTION cameraDirection;
    public CaptureDimensions dimensions;
    public CAPTURER_OUTPUT_PREFERENCE preference;

    public static class CaptureDimensions {
        public int height;
        public int width;

        public CaptureDimensions(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public CaptureDimensions() {
            this.width = 640;
            this.height = 480;
        }
    }

    public enum CAPTURER_OUTPUT_PREFERENCE {
        CAPTURER_OUTPUT_PREFERENCE_AUTO(0),
        CAPTURER_OUTPUT_PREFERENCE_PERFORMANCE(1),
        CAPTURER_OUTPUT_PREFERENCE_PREVIEW(2),
        CAPTURER_OUTPUT_PREFERENCE_MANUAL(3);
        
        private int value;

        private CAPTURER_OUTPUT_PREFERENCE(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum CAMERA_DIRECTION {
        CAMERA_REAR(0),
        CAMERA_FRONT(1);
        
        private int value;

        private CAMERA_DIRECTION(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public CameraCapturerConfiguration(CAPTURER_OUTPUT_PREFERENCE capturer_output_preference, CAMERA_DIRECTION camera_direction) {
        this.preference = capturer_output_preference;
        this.cameraDirection = camera_direction;
    }

    public CameraCapturerConfiguration(int i, int i2, CAMERA_DIRECTION camera_direction) {
        this.preference = CAPTURER_OUTPUT_PREFERENCE.CAPTURER_OUTPUT_PREFERENCE_MANUAL;
        this.cameraDirection = camera_direction;
        this.dimensions = new CaptureDimensions(i, i2);
    }

    public CameraCapturerConfiguration(CaptureDimensions captureDimensions, CAMERA_DIRECTION camera_direction) {
        this.preference = CAPTURER_OUTPUT_PREFERENCE.CAPTURER_OUTPUT_PREFERENCE_MANUAL;
        this.cameraDirection = camera_direction;
        this.dimensions = captureDimensions;
    }
}
