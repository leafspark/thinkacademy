package com.tal100.mars.comm;

import android.content.Context;
import android.os.Handler;
import android.os.PowerManager;

public class WakerLock {
    private static final String TAG = "MicroMsg.WakerLock";
    private Handler mHandler = null;
    private Runnable mReleaser = new Runnable() {
        public void run() {
            WakerLock.this.unLock();
        }
    };
    private PowerManager.WakeLock wakeLock = null;

    public WakerLock(Context context) {
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, TAG);
        this.wakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        this.mHandler = new Handler(context.getMainLooper());
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        unLock();
    }

    public void lock(long j) {
        lock();
        this.mHandler.postDelayed(this.mReleaser, j);
    }

    public void lock() {
        this.mHandler.removeCallbacks(this.mReleaser);
        this.wakeLock.acquire();
    }

    public void unLock() {
        this.mHandler.removeCallbacks(this.mReleaser);
        if (this.wakeLock.isHeld()) {
            this.wakeLock.release();
        }
    }

    public boolean isLocking() {
        return this.wakeLock.isHeld();
    }
}
