package androidx.camera.view;

import android.content.Context;
import android.view.OrientationEventListener;

public abstract class RotationReceiver {
    private static final int INVALID_SURFACE_ROTATION = -1;
    private final OrientationEventListener mOrientationEventListener;
    int mRotation = -1;

    public abstract void onRotationChanged(int i);

    public RotationReceiver(Context context) {
        this.mOrientationEventListener = new OrientationEventListener(context) {
            public void onOrientationChanged(int i) {
                if (i != -1) {
                    int i2 = (i >= 315 || i < 45) ? 0 : i >= 225 ? 1 : i >= 135 ? 2 : 3;
                    if (RotationReceiver.this.mRotation != i2) {
                        RotationReceiver.this.mRotation = i2;
                        RotationReceiver.this.onRotationChanged(i2);
                    }
                }
            }
        };
    }

    public boolean canDetectOrientation() {
        return this.mOrientationEventListener.canDetectOrientation();
    }

    public void enable() {
        this.mOrientationEventListener.enable();
    }

    public void disable() {
        this.mOrientationEventListener.disable();
    }
}
