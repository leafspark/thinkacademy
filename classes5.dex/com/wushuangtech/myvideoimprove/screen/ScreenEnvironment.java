package com.wushuangtech.myvideoimprove.screen;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Surface;
import com.wushuangtech.expansion.api.Constants;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;

public class ScreenEnvironment {
    private static final String TAG = "ScreenCapturer";
    private Activity mActivityRef;
    private MediaProjection mMediaProjection;
    private ScreenCaptureServiceConn mScreenCaptureServiceConn;
    /* access modifiers changed from: private */
    public WeakReference<ScreenEnvironmentCallBack> mScreenEnvironmentCallBackRef;
    private boolean mServiceBinded;
    private VirtualDisplay mVirtualDisplay;

    public interface ScreenEnvironmentCallBack {
        void onServiceConnected();

        void onServiceDisconnected();
    }

    public ScreenEnvironment(Activity activity) {
        this.mActivityRef = activity;
    }

    public void setScreenEnvironmentCallBack(ScreenEnvironmentCallBack screenEnvironmentCallBack) {
        this.mScreenEnvironmentCallBackRef = new WeakReference<>(screenEnvironmentCallBack);
    }

    public boolean requestPermission() {
        MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) this.mActivityRef.getSystemService("media_projection");
        if (mediaProjectionManager == null) {
            return false;
        }
        this.mActivityRef.startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), Constants.CAPTURE_REQUEST_CODE);
        return true;
    }

    public boolean createDisplay(Intent intent, int i, int i2) {
        MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) this.mActivityRef.getSystemService("media_projection");
        if (mediaProjectionManager == null) {
            OmniLog.screen_e(TAG, "Starting, Get system MEDIA_PROJECTION_SERVICE service failed ... ");
            return false;
        }
        Intent intent2 = intent;
        try {
            MediaProjection mediaProjection = mediaProjectionManager.getMediaProjection(-1, intent);
            if (mediaProjection == null) {
                OmniLog.screen_e(TAG, "Starting, Get MediaProjection obj is null ... ");
                return false;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.mActivityRef.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            VirtualDisplay createVirtualDisplay = mediaProjection.createVirtualDisplay("LiveScreen", i, i2, displayMetrics.densityDpi, 16, (Surface) null, (VirtualDisplay.Callback) null, (Handler) null);
            this.mMediaProjection = mediaProjection;
            this.mVirtualDisplay = createVirtualDisplay;
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            OmniLog.screen_e(TAG, "Starting, IllegalStateException ... " + e.getLocalizedMessage());
            return false;
        }
    }

    public boolean startService() {
        Intent intent = new Intent(this.mActivityRef, ScreenCaptureService.class);
        this.mActivityRef.startService(intent);
        if (!this.mActivityRef.bindService(intent, this.mScreenCaptureServiceConn, 1)) {
            this.mActivityRef.stopService(intent);
            return false;
        }
        this.mServiceBinded = true;
        return true;
    }

    public void clearResource() {
        this.mVirtualDisplay.setSurface((Surface) null);
        if (Build.VERSION.SDK_INT >= 19) {
            this.mVirtualDisplay.release();
        }
        this.mVirtualDisplay = null;
        this.mMediaProjection.stop();
        this.mMediaProjection = null;
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                if (this.mServiceBinded) {
                    this.mServiceBinded = false;
                    this.mActivityRef.unbindService(this.mScreenCaptureServiceConn);
                }
                this.mActivityRef.stopService(new Intent(this.mActivityRef, ScreenCaptureService.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.mActivityRef = null;
    }

    private static class ScreenCaptureServiceConn implements ServiceConnection {
        private final WeakReference<ScreenEnvironment> outReference;

        ScreenCaptureServiceConn(ScreenEnvironment screenEnvironment) {
            this.outReference = new WeakReference<>(screenEnvironment);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ScreenEnvironmentCallBack callBack = getCallBack();
            if (callBack != null) {
                callBack.onServiceConnected();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            ScreenEnvironmentCallBack callBack = getCallBack();
            if (callBack != null) {
                callBack.onServiceDisconnected();
            }
        }

        public ScreenEnvironmentCallBack getCallBack() {
            ScreenEnvironment screenEnvironment = (ScreenEnvironment) this.outReference.get();
            if (screenEnvironment != null) {
                WeakReference access$000 = screenEnvironment.mScreenEnvironmentCallBackRef;
                if (access$000 == null) {
                    return null;
                }
                return (ScreenEnvironmentCallBack) access$000.get();
            }
            throw new RuntimeException("ScreenCapture reference invaild... ");
        }
    }
}
