package com.eaydu.omni.core.screen;

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
import com.eaydu.omni.core.screen.TextureMovieEncoder;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;

public class ScreenCapture {
    private static final String TAG = "ScreenCapture";
    private WeakReference<Activity> activityRef;
    /* access modifiers changed from: private */
    public OnScreenStartListener mOnScreenStartListener;
    private TextureMovieEncoder mRecorder;
    /* access modifiers changed from: private */
    public boolean mScreenShared;
    private boolean mServiceBinded;
    /* access modifiers changed from: private */
    public volatile boolean mStartCapturingResult;
    /* access modifiers changed from: private */
    public volatile boolean mWaitServiceStartedAndExecute;
    /* access modifiers changed from: private */
    public volatile boolean mWaitStartCapturingExecute;
    /* access modifiers changed from: private */
    public volatile boolean mWaitStopCapturingExecute;
    private int mWaitTime;
    private MediaProjection mediaProjection;
    /* access modifiers changed from: private */
    public Intent responseIntent;
    private volatile boolean running;
    private ScreenCaptureServiceConn screenCaptureServiceConn = new ScreenCaptureServiceConn(this);
    /* access modifiers changed from: private */
    public ScreenEncoderConfig screenEncoderConfig;
    /* access modifiers changed from: private */
    public VirtualDisplay virtualDisplay;

    public interface OnScreenStartListener {
        void onScreenStartResult(boolean z);
    }

    public interface RecordCallback {
        void onRecordFailed(String str, long j);

        String onRecordMoveFile(String str);

        void onRecordSuccess(String str, long j);

        void onRecordedDurationChanged(long j);
    }

    public boolean resizeScreenCapture(boolean z) {
        return true;
    }

    static {
        System.loadLibrary("avrecoder");
        OmniLog.d("LOADLIBRARY", "avrecoder");
    }

    public ScreenCapture() {
        TextureMovieEncoder textureMovieEncoder = new TextureMovieEncoder();
        this.mRecorder = textureMovieEncoder;
        textureMovieEncoder.setCallback(new TextureMovieEncoder.Callback() {
            public void onInputSurfacePrepared(Surface surface) {
                if (ScreenCapture.this.virtualDisplay != null) {
                    ScreenCapture.this.virtualDisplay.setSurface(surface);
                }
            }

            public void onStartWorkingResult(boolean z) {
                boolean unused = ScreenCapture.this.mStartCapturingResult = z;
                boolean unused2 = ScreenCapture.this.mWaitStartCapturingExecute = false;
                if (!z) {
                    return;
                }
                if (ScreenCapture.this.mScreenShared) {
                    GlobalConfig.mIsScreenRecordShare.set(true);
                } else {
                    GlobalConfig.mIsScreenRecording.set(true);
                }
            }

            public void onStopWorkingResult() {
                ScreenCapture.this.clearResource();
                boolean unused = ScreenCapture.this.mWaitStopCapturingExecute = false;
            }
        });
    }

    public void setActivityRef(Activity activity) {
        if (activity != null) {
            this.activityRef = new WeakReference<>(activity);
        }
    }

    public void setRecordCallback(RecordCallback recordCallback) {
        this.mRecorder.setRecordCallback(recordCallback);
    }

    public void setOnScreenStartListener(OnScreenStartListener onScreenStartListener) {
        this.mOnScreenStartListener = onScreenStartListener;
    }

    public void setScreenCaptureType(boolean z) {
        this.mScreenShared = z;
    }

    public boolean isProjecting() {
        return this.running;
    }

    public boolean isRecording() {
        return this.mRecorder.isRecording();
    }

    public boolean requestScreenCapture() {
        Activity activity = (Activity) this.activityRef.get();
        if (activity == null) {
            OmniLog.screen_e(TAG, "Request screen capturing, Activity reference is null ... ");
            return false;
        }
        MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) activity.getSystemService("media_projection");
        if (mediaProjectionManager == null) {
            return false;
        }
        activity.startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), 8080);
        return true;
    }

    public int startBlockingCapture(Intent intent, ScreenEncoderConfig screenEncoderConfig2) {
        if (intent == null || screenEncoderConfig2 == null) {
            OmniLog.screen_e(TAG, "Start project faield, args error ... ");
            return -6;
        } else if (this.running) {
            OmniLog.screen_e(TAG, "Already start project... ");
            return -6;
        } else {
            this.screenEncoderConfig = screenEncoderConfig2;
            this.responseIntent = intent;
            if (Build.VERSION.SDK_INT >= 29) {
                if (this.mWaitServiceStartedAndExecute || !startProjectionForQ()) {
                    return -6;
                }
                this.mWaitServiceStartedAndExecute = true;
                return 0;
            } else if (!realStartProjection(intent, screenEncoderConfig2.mWidth, screenEncoderConfig2.mHeight)) {
                return -6;
            } else {
                return startRecordEncoding();
            }
        }
    }

    public void stopBlockingCapture() {
        this.mWaitStopCapturingExecute = true;
        if (stopProjection()) {
            this.mWaitTime = 0;
            while (this.mWaitStopCapturingExecute) {
                try {
                    Thread.sleep(5);
                    int i = this.mWaitTime + 5;
                    this.mWaitTime = i;
                    if (i > 3000) {
                        OmniLog.screen_e(TAG, "Execute stopProjection too slow! " + this.mWaitTime);
                        return;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean startProjectionForQ() {
        Activity activity = (Activity) this.activityRef.get();
        if (activity != null) {
            Intent intent = new Intent(activity, ScreenCaptureService.class);
            activity.startService(intent);
            this.mServiceBinded = activity.bindService(intent, this.screenCaptureServiceConn, 1);
            return true;
        }
        OmniLog.screen_e(TAG, "Start servicing, Activity reference is null ... ");
        return false;
    }

    private boolean stopProjection() {
        if (!this.running) {
            return false;
        }
        this.running = false;
        if (this.mRecorder.stopRecording()) {
            return true;
        }
        clearResource();
        return true;
    }

    /* access modifiers changed from: private */
    public void clearResource() {
        OmniLog.screen_d(TAG, "Execute clear resource ! ");
        this.virtualDisplay.setSurface((Surface) null);
        if (Build.VERSION.SDK_INT >= 19) {
            this.virtualDisplay.release();
        }
        this.virtualDisplay = null;
        this.mediaProjection.stop();
        this.mediaProjection = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Activity activity = (Activity) this.activityRef.get();
            if (activity == null) {
                OmniLog.screen_e(TAG, "Clear resourcing, Activity reference is null ... ");
                return;
            }
            try {
                if (this.mServiceBinded) {
                    this.mServiceBinded = false;
                    activity.unbindService(this.screenCaptureServiceConn);
                }
                activity.stopService(new Intent(activity, ScreenCaptureService.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public int startRecordEncoding() {
        this.mWaitStartCapturingExecute = true;
        this.mWaitTime = 0;
        if (!this.mRecorder.startRecording(this.screenEncoderConfig)) {
            return 0;
        }
        while (this.mWaitStartCapturingExecute) {
            try {
                Thread.sleep(5);
                int i = this.mWaitTime + 5;
                this.mWaitTime = i;
                if (i > 3000) {
                    OmniLog.screen_e(TAG, "Execute startRecording too slow! " + this.mWaitTime);
                    return -6;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!this.mStartCapturingResult) {
            return -6;
        }
        this.running = true;
        return 0;
    }

    /* access modifiers changed from: private */
    public boolean realStartProjection(Intent intent, int i, int i2) {
        Activity activity = (Activity) this.activityRef.get();
        if (activity == null) {
            OmniLog.screen_e(TAG, "Starting, ScreenCapture reference invaild... ");
            return false;
        }
        MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) activity.getSystemService("media_projection");
        if (mediaProjectionManager == null) {
            OmniLog.screen_e(TAG, "Starting, Get system MEDIA_PROJECTION_SERVICE service failed ... ");
            return false;
        }
        try {
            MediaProjection mediaProjection2 = mediaProjectionManager.getMediaProjection(-1, intent);
            this.mediaProjection = mediaProjection2;
            if (mediaProjection2 == null) {
                OmniLog.screen_e(TAG, "Starting, Get MediaProjection obj is null ... ");
                return false;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.virtualDisplay = this.mediaProjection.createVirtualDisplay("LiveScreen", i, i2, displayMetrics.densityDpi, 16, (Surface) null, (VirtualDisplay.Callback) null, (Handler) null);
            this.running = true;
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            OmniLog.screen_e(TAG, "Starting, IllegalStateException ... " + e.getLocalizedMessage());
            return false;
        }
    }

    private static class ScreenCaptureServiceConn implements ServiceConnection {
        private final WeakReference<ScreenCapture> outReference;

        ScreenCaptureServiceConn(ScreenCapture screenCapture) {
            this.outReference = new WeakReference<>(screenCapture);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ScreenCapture screenCapture = (ScreenCapture) this.outReference.get();
            if (screenCapture != null) {
                boolean z = false;
                if (!screenCapture.realStartProjection(screenCapture.responseIntent, screenCapture.screenEncoderConfig.mWidth, screenCapture.screenEncoderConfig.mHeight)) {
                    screenCapture.mOnScreenStartListener.onScreenStartResult(false);
                    boolean unused = screenCapture.mWaitServiceStartedAndExecute = false;
                    return;
                }
                int access$1100 = screenCapture.startRecordEncoding();
                boolean unused2 = screenCapture.mWaitServiceStartedAndExecute = false;
                OnScreenStartListener access$900 = screenCapture.mOnScreenStartListener;
                if (access$1100 == 0) {
                    z = true;
                }
                access$900.onScreenStartResult(z);
                return;
            }
            throw new RuntimeException("ScreenCapture reference invaild... ");
        }

        public void onServiceDisconnected(ComponentName componentName) {
            OmniLog.screen_e(ScreenCapture.TAG, "onServiceDisconnected... " + componentName);
        }
    }
}
