package com.idlefish.flutterboost.containers;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.idlefish.flutterboost.FlutterBoost;
import io.flutter.embedding.android.FlutterTextureView;
import io.flutter.embedding.engine.FlutterEngine;
import java.lang.reflect.Field;

class FlutterTextureHooker {
    private FlutterTextureView flutterTextureView;
    /* access modifiers changed from: private */
    public boolean isNeedRestoreState = false;
    /* access modifiers changed from: private */
    public SurfaceTexture restoreSurface;

    FlutterTextureHooker() {
    }

    public void onFlutterTextureViewRelease() {
        if (Build.VERSION.SDK_INT <= 23) {
            if (FlutterContainerManager.instance().getContainerSize() == 1) {
                FlutterBoost.instance().getEngine().getRenderer().stopRenderingToSurface();
            }
            SurfaceTexture surfaceTexture = this.restoreSurface;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.restoreSurface = null;
            }
        }
    }

    public void onFlutterTextureViewRestoreState() {
        FlutterTextureView flutterTextureView2;
        if (Build.VERSION.SDK_INT <= 23 && this.restoreSurface != null && (flutterTextureView2 = this.flutterTextureView) != null && this.isNeedRestoreState) {
            try {
                Class<?> cls = flutterTextureView2.getClass();
                Field declaredField = cls.getDeclaredField("isSurfaceAvailableForRendering");
                declaredField.setAccessible(true);
                declaredField.set(this.flutterTextureView, true);
                Field declaredField2 = cls.getDeclaredField("isAttachedToFlutterRenderer");
                declaredField2.setAccessible(true);
                if (declaredField2.getBoolean(this.flutterTextureView)) {
                    FlutterEngine engine = FlutterBoost.instance().getEngine();
                    if (engine != null) {
                        engine.getRenderer().startRenderingToSurface(new Surface(this.restoreSurface), false);
                        this.flutterTextureView.setSurfaceTexture(this.restoreSurface);
                    }
                    this.restoreSurface = null;
                    this.isNeedRestoreState = false;
                }
            } catch (Exception e) {
                throw new RuntimeException("You *SHOULD* keep FlutterTextureView: -keep class io.flutter.embedding.android.FlutterTextureView { *; }.", e);
            }
        }
    }

    public void hookFlutterTextureView(final FlutterTextureView flutterTextureView2) {
        if (Build.VERSION.SDK_INT <= 23 && flutterTextureView2 != null) {
            final TextureView.SurfaceTextureListener surfaceTextureListener = flutterTextureView2.getSurfaceTextureListener();
            this.flutterTextureView = flutterTextureView2;
            flutterTextureView2.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
                public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                    surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, i, i2);
                }

                public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                    surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
                }

                public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                    try {
                        Class<?> cls = flutterTextureView2.getClass();
                        Field declaredField = cls.getDeclaredField("isSurfaceAvailableForRendering");
                        declaredField.setAccessible(true);
                        declaredField.set(flutterTextureView2, false);
                        cls.getDeclaredField("isAttachedToFlutterRenderer").setAccessible(true);
                        boolean unused = FlutterTextureHooker.this.isNeedRestoreState = true;
                        return false;
                    } catch (Exception e) {
                        throw new RuntimeException("You *SHOULD* keep FlutterTextureView: -keep class io.flutter.embedding.android.FlutterTextureView { *; }.", e);
                    }
                }

                public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                    surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
                    SurfaceTexture unused = FlutterTextureHooker.this.restoreSurface = surfaceTexture;
                }
            });
        }
    }
}
