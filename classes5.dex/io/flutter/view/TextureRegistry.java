package io.flutter.view;

import android.graphics.SurfaceTexture;

public interface TextureRegistry {

    /* renamed from: io.flutter.view.TextureRegistry$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onTrimMemory(TextureRegistry textureRegistry, int i) {
        }
    }

    public interface OnFrameConsumedListener {
        void onFrameConsumed();
    }

    public interface OnTrimMemoryListener {
        void onTrimMemory(int i);
    }

    public interface SurfaceTextureEntry {

        /* renamed from: io.flutter.view.TextureRegistry$SurfaceTextureEntry$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$setOnFrameConsumedListener(SurfaceTextureEntry surfaceTextureEntry, OnFrameConsumedListener onFrameConsumedListener) {
            }

            public static void $default$setOnTrimMemoryListener(SurfaceTextureEntry surfaceTextureEntry, OnTrimMemoryListener onTrimMemoryListener) {
            }
        }

        long id();

        void release();

        void setOnFrameConsumedListener(OnFrameConsumedListener onFrameConsumedListener);

        void setOnTrimMemoryListener(OnTrimMemoryListener onTrimMemoryListener);

        SurfaceTexture surfaceTexture();
    }

    SurfaceTextureEntry createSurfaceTexture();

    void onTrimMemory(int i);

    SurfaceTextureEntry registerSurfaceTexture(SurfaceTexture surfaceTexture);
}
