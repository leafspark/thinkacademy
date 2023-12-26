package io.agora.rtc.mediaio;

public class MediaIO {

    public enum BufferType {
        BYTE_BUFFER(1),
        BYTE_ARRAY(2),
        TEXTURE(3);
        
        final int value;

        private BufferType(int i) {
            this.value = i;
        }

        public int intValue() {
            return this.value;
        }
    }

    public enum PixelFormat {
        I420(1),
        NV21(3),
        RGBA(4),
        TEXTURE_2D(10),
        TEXTURE_OES(11);
        
        final int value;

        private PixelFormat(int i) {
            this.value = i;
        }

        public int intValue() {
            return this.value;
        }
    }

    public enum CaptureType {
        UNKNOWN(0),
        CAMERA(1),
        SCREEN(2);
        
        final int value;

        private CaptureType(int i) {
            this.value = i;
        }

        public int intValue() {
            return this.value;
        }
    }

    public enum ContentHint {
        NONE(0),
        MOTION(1),
        DETAIL(2);
        
        final int value;

        private ContentHint(int i) {
            this.value = i;
        }

        public int intValue() {
            return this.value;
        }
    }
}
