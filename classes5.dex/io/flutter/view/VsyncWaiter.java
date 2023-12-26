package io.flutter.view;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Choreographer;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.Objects;

public class VsyncWaiter {
    private static VsyncWaiter instance;
    private static DisplayListener listener;
    private final FlutterJNI.AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate = new FlutterJNI.AsyncWaitForVsyncDelegate() {
        private Choreographer.FrameCallback obtainFrameCallback(long j) {
            if (VsyncWaiter.this.frameCallback == null) {
                return new FrameCallback(j);
            }
            long unused = VsyncWaiter.this.frameCallback.cookie = j;
            FrameCallback access$200 = VsyncWaiter.this.frameCallback;
            FrameCallback unused2 = VsyncWaiter.this.frameCallback = null;
            return access$200;
        }

        public void asyncWaitForVsync(long j) {
            Choreographer.getInstance().postFrameCallback(obtainFrameCallback(j));
        }
    };
    /* access modifiers changed from: private */
    public FlutterJNI flutterJNI;
    /* access modifiers changed from: private */
    public FrameCallback frameCallback = new FrameCallback(0);
    /* access modifiers changed from: private */
    public long refreshPeriodNanos = -1;

    class DisplayListener implements DisplayManager.DisplayListener {
        private DisplayManager displayManager;

        public void onDisplayAdded(int i) {
        }

        public void onDisplayRemoved(int i) {
        }

        DisplayListener(DisplayManager displayManager2) {
            this.displayManager = displayManager2;
        }

        /* access modifiers changed from: package-private */
        public void register() {
            this.displayManager.registerDisplayListener(this, (Handler) null);
        }

        public void onDisplayChanged(int i) {
            if (i == 0) {
                float refreshRate = this.displayManager.getDisplay(0).getRefreshRate();
                long unused = VsyncWaiter.this.refreshPeriodNanos = (long) (1.0E9d / ((double) refreshRate));
                VsyncWaiter.this.flutterJNI.setRefreshRateFPS(refreshRate);
            }
        }
    }

    public static VsyncWaiter getInstance(float f, FlutterJNI flutterJNI2) {
        if (instance == null) {
            instance = new VsyncWaiter(flutterJNI2);
        }
        flutterJNI2.setRefreshRateFPS(f);
        VsyncWaiter vsyncWaiter = instance;
        vsyncWaiter.refreshPeriodNanos = (long) (1.0E9d / ((double) f));
        return vsyncWaiter;
    }

    public static VsyncWaiter getInstance(DisplayManager displayManager, FlutterJNI flutterJNI2) {
        if (instance == null) {
            instance = new VsyncWaiter(flutterJNI2);
        }
        if (listener == null) {
            VsyncWaiter vsyncWaiter = instance;
            Objects.requireNonNull(vsyncWaiter);
            DisplayListener displayListener = new DisplayListener(displayManager);
            listener = displayListener;
            displayListener.register();
        }
        if (instance.refreshPeriodNanos == -1) {
            float refreshRate = displayManager.getDisplay(0).getRefreshRate();
            instance.refreshPeriodNanos = (long) (1.0E9d / ((double) refreshRate));
            flutterJNI2.setRefreshRateFPS(refreshRate);
        }
        return instance;
    }

    public static void reset() {
        instance = null;
        listener = null;
    }

    private class FrameCallback implements Choreographer.FrameCallback {
        /* access modifiers changed from: private */
        public long cookie;

        FrameCallback(long j) {
            this.cookie = j;
        }

        public void doFrame(long j) {
            long nanoTime = System.nanoTime() - j;
            VsyncWaiter.this.flutterJNI.onVsync(nanoTime < 0 ? 0 : nanoTime, VsyncWaiter.this.refreshPeriodNanos, this.cookie);
            FrameCallback unused = VsyncWaiter.this.frameCallback = this;
        }
    }

    private VsyncWaiter(FlutterJNI flutterJNI2) {
        this.flutterJNI = flutterJNI2;
    }

    public void init() {
        this.flutterJNI.setAsyncWaitForVsyncDelegate(this.asyncWaitForVsyncDelegate);
    }
}
