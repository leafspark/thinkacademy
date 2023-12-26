package io.flutter.plugin.platform;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewTreeObserver;
import io.flutter.plugin.platform.SingleViewPresentation;
import io.flutter.view.TextureRegistry;

class VirtualDisplayController {
    private static String TAG = "VirtualDisplayController";
    private final AccessibilityEventsDelegate accessibilityEventsDelegate;
    private int bufferHeight;
    private int bufferWidth;
    private final Context context;
    private final int densityDpi;
    private final View.OnFocusChangeListener focusChangeListener;
    SingleViewPresentation presentation;
    private final Surface surface;
    private final TextureRegistry.SurfaceTextureEntry textureEntry;
    private VirtualDisplay virtualDisplay;

    public static VirtualDisplayController create(Context context2, AccessibilityEventsDelegate accessibilityEventsDelegate2, PlatformView platformView, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, int i, int i2, int i3, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        int i4 = i;
        int i5 = i2;
        context2.getResources().getDisplayMetrics();
        if (i4 == 0 || i5 == 0) {
            return null;
        }
        surfaceTextureEntry.surfaceTexture().setDefaultBufferSize(i4, i5);
        Surface surface2 = new Surface(surfaceTextureEntry.surfaceTexture());
        VirtualDisplay createVirtualDisplay = ((DisplayManager) context2.getSystemService("display")).createVirtualDisplay("flutter-vd", i, i2, context2.getResources().getDisplayMetrics().densityDpi, surface2, 0);
        if (createVirtualDisplay == null) {
            return null;
        }
        VirtualDisplayController virtualDisplayController = new VirtualDisplayController(context2, accessibilityEventsDelegate2, createVirtualDisplay, platformView, surface2, surfaceTextureEntry, onFocusChangeListener, i3, obj);
        virtualDisplayController.bufferWidth = i4;
        virtualDisplayController.bufferHeight = i5;
        return virtualDisplayController;
    }

    private VirtualDisplayController(Context context2, AccessibilityEventsDelegate accessibilityEventsDelegate2, VirtualDisplay virtualDisplay2, PlatformView platformView, Surface surface2, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, View.OnFocusChangeListener onFocusChangeListener, int i, Object obj) {
        Context context3 = context2;
        this.context = context3;
        AccessibilityEventsDelegate accessibilityEventsDelegate3 = accessibilityEventsDelegate2;
        this.accessibilityEventsDelegate = accessibilityEventsDelegate3;
        this.textureEntry = surfaceTextureEntry;
        View.OnFocusChangeListener onFocusChangeListener2 = onFocusChangeListener;
        this.focusChangeListener = onFocusChangeListener2;
        this.surface = surface2;
        this.virtualDisplay = virtualDisplay2;
        this.densityDpi = context2.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(context3, this.virtualDisplay.getDisplay(), platformView, accessibilityEventsDelegate3, i, onFocusChangeListener2);
        this.presentation = singleViewPresentation;
        singleViewPresentation.show();
    }

    public int getBufferWidth() {
        return this.bufferWidth;
    }

    public int getBufferHeight() {
        return this.bufferHeight;
    }

    public void resize(int i, int i2, final Runnable runnable) {
        boolean isFocused = getView().isFocused();
        SingleViewPresentation.PresentationState detachState = this.presentation.detachState();
        this.virtualDisplay.setSurface((Surface) null);
        this.virtualDisplay.release();
        this.bufferWidth = i;
        this.bufferHeight = i2;
        this.textureEntry.surfaceTexture().setDefaultBufferSize(i, i2);
        this.virtualDisplay = ((DisplayManager) this.context.getSystemService("display")).createVirtualDisplay("flutter-vd", i, i2, this.densityDpi, this.surface, 0);
        final View view = getView();
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            public void onViewDetachedFromWindow(View view) {
            }

            public void onViewAttachedToWindow(View view) {
                OneTimeOnDrawListener.schedule(view, new Runnable() {
                    public void run() {
                        view.postDelayed(runnable, 128);
                    }
                });
                view.removeOnAttachStateChangeListener(this);
            }
        });
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.context, this.virtualDisplay.getDisplay(), this.accessibilityEventsDelegate, detachState, this.focusChangeListener, isFocused);
        singleViewPresentation.show();
        this.presentation.cancel();
        this.presentation = singleViewPresentation;
    }

    public void dispose() {
        this.presentation.cancel();
        this.presentation.detachState();
        this.virtualDisplay.release();
        this.textureEntry.release();
    }

    /* access modifiers changed from: package-private */
    public void onFlutterViewAttached(View view) {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.presentation.getView().onFlutterViewAttached(view);
        }
    }

    /* access modifiers changed from: package-private */
    public void onFlutterViewDetached() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.presentation.getView().onFlutterViewDetached();
        }
    }

    /* access modifiers changed from: package-private */
    public void onInputConnectionLocked() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.presentation.getView().onInputConnectionLocked();
        }
    }

    /* access modifiers changed from: package-private */
    public void onInputConnectionUnlocked() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null && singleViewPresentation.getView() != null) {
            this.presentation.getView().onInputConnectionUnlocked();
        }
    }

    public View getView() {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().getView();
    }

    public void dispatchTouchEvent(MotionEvent motionEvent) {
        SingleViewPresentation singleViewPresentation = this.presentation;
        if (singleViewPresentation != null) {
            singleViewPresentation.dispatchTouchEvent(motionEvent);
        }
    }

    static class OneTimeOnDrawListener implements ViewTreeObserver.OnDrawListener {
        Runnable mOnDrawRunnable;
        final View mView;

        static void schedule(View view, Runnable runnable) {
            view.getViewTreeObserver().addOnDrawListener(new OneTimeOnDrawListener(view, runnable));
        }

        OneTimeOnDrawListener(View view, Runnable runnable) {
            this.mView = view;
            this.mOnDrawRunnable = runnable;
        }

        public void onDraw() {
            Runnable runnable = this.mOnDrawRunnable;
            if (runnable != null) {
                runnable.run();
                this.mOnDrawRunnable = null;
                this.mView.post(new Runnable() {
                    public void run() {
                        OneTimeOnDrawListener.this.mView.getViewTreeObserver().removeOnDrawListener(OneTimeOnDrawListener.this);
                    }
                });
            }
        }
    }
}
