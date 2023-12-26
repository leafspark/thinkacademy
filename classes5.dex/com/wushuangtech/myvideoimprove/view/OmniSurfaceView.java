package com.wushuangtech.myvideoimprove.view;

import android.content.Context;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.wushuangtech.myvideoimprove.bean.VideoRenderViewLifeBean;
import com.wushuangtech.myvideoimprove.view.VideoRenderView;
import com.wushuangtech.utils.OmniLog;

public class OmniSurfaceView extends SurfaceView implements VideoRenderView, SurfaceHolder.Callback {
    private static final String TAG = "OmniSurfaceView";
    private String mDeviceId;
    private int mHeight;
    private final Object mLock = new Object();
    private boolean mSurfaceCreated;
    private VideoRenderView.OnVideoRenderViewCallBack mVideoRenderViewCallBack;
    private int mWidth;

    public OmniSurfaceView(Context context) {
        super(context);
        String str = TAG;
        OmniLog.i(str, "SurfaceView is created! " + this);
        getHolder().addCallback(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        synchronized (this.mLock) {
            String str = TAG;
            OmniLog.i(str, "onDetachedFromWindow! --------------------------- " + this + " | " + getParent());
            VideoRenderView.OnVideoRenderViewCallBack onVideoRenderViewCallBack = this.mVideoRenderViewCallBack;
            if (onVideoRenderViewCallBack != null) {
                onVideoRenderViewCallBack.onViewRenderDetachedFromWindow(this);
            }
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        synchronized (this.mLock) {
            String str = TAG;
            OmniLog.i(str, "onAttachedToWindow! --------------------------- " + this + " | " + getParent());
            VideoRenderView.OnVideoRenderViewCallBack onVideoRenderViewCallBack = this.mVideoRenderViewCallBack;
            if (onVideoRenderViewCallBack != null) {
                onVideoRenderViewCallBack.onViewRenderAttachedToWindow(this);
            }
        }
        super.onAttachedToWindow();
    }

    public void setVideoRenderViewCallBack(VideoRenderView.OnVideoRenderViewCallBack onVideoRenderViewCallBack) {
        synchronized (this.mLock) {
            this.mVideoRenderViewCallBack = onVideoRenderViewCallBack;
            if (this.mSurfaceCreated && onVideoRenderViewCallBack != null) {
                VideoRenderViewLifeBean videoRenderViewLifeBean = new VideoRenderViewLifeBean();
                videoRenderViewLifeBean.mRenderView = this;
                videoRenderViewLifeBean.mSurface = getHolder();
                videoRenderViewLifeBean.mWidth = this.mWidth;
                videoRenderViewLifeBean.mHeight = this.mHeight;
                videoRenderViewLifeBean.mDeviceId = this.mDeviceId;
                this.mVideoRenderViewCallBack.onVideoRenderSurfaceAvailable(videoRenderViewLifeBean);
            }
            String str = TAG;
            OmniLog.i(str, "Recv call back :" + onVideoRenderViewCallBack + " | this : " + this);
        }
    }

    public void setDeviceId(String str) {
        this.mDeviceId = str;
    }

    public Object getNativeWindow() {
        synchronized (this.mLock) {
            if (!this.mSurfaceCreated) {
                return null;
            }
            SurfaceHolder holder = getHolder();
            return holder;
        }
    }

    public int[] getViewSize() {
        int i;
        int i2 = this.mWidth;
        if (i2 == 0 || (i = this.mHeight) == 0) {
            return null;
        }
        return new int[]{i2, i};
    }

    public void resetSurface() {
        if (this.mSurfaceCreated) {
            String str = TAG;
            OmniLog.i(str, "Rest surface... thread id : " + Thread.currentThread().getId());
            Handler handler = getHandler();
            if (handler != null) {
                handler.postDelayed(new Runnable() {
                    public void run() {
                        OmniSurfaceView.this.executeCreateSurface();
                    }
                }, 2000);
            }
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        synchronized (this.mLock) {
            String str = TAG;
            OmniLog.i(str, "surfaceCreated... view : " + this + " | holder : " + surfaceHolder + " | thread id : " + Thread.currentThread().getId());
            this.mSurfaceCreated = true;
        }
        executeCreateSurface();
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        synchronized (this.mLock) {
            this.mWidth = i2;
            this.mHeight = i3;
            String str = TAG;
            OmniLog.i(str, "surfaceChanged... view : " + this + " | holder : " + surfaceHolder + " | width : " + i2 + " | height : " + i3 + " callback : " + this.mVideoRenderViewCallBack + " | thread id : " + Thread.currentThread().getId());
            if (this.mVideoRenderViewCallBack != null) {
                VideoRenderViewLifeBean videoRenderViewLifeBean = new VideoRenderViewLifeBean();
                videoRenderViewLifeBean.mWidth = i2;
                videoRenderViewLifeBean.mHeight = i3;
                videoRenderViewLifeBean.mRenderView = this;
                videoRenderViewLifeBean.mDeviceId = this.mDeviceId;
                this.mVideoRenderViewCallBack.onVideoRenderSurfaceSizeChanged(videoRenderViewLifeBean);
            }
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        synchronized (this.mLock) {
            this.mSurfaceCreated = false;
            String str = TAG;
            OmniLog.i(str, "surfaceDestroyed... view : " + this + " | thread id : " + Thread.currentThread().getId());
            if (this.mVideoRenderViewCallBack != null) {
                VideoRenderViewLifeBean videoRenderViewLifeBean = new VideoRenderViewLifeBean();
                videoRenderViewLifeBean.mRenderView = this;
                videoRenderViewLifeBean.mSurface = surfaceHolder;
                this.mVideoRenderViewCallBack.onVideoRenderSurfaceDestroyed(videoRenderViewLifeBean);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x006e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeCreateSurface() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mLock
            monitor-enter(r0)
            boolean r1 = r6.mSurfaceCreated     // Catch:{ all -> 0x006f }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x006f }
            return
        L_0x0009:
            android.view.SurfaceHolder r1 = r6.getHolder()     // Catch:{ all -> 0x006f }
            java.lang.String r2 = TAG     // Catch:{ all -> 0x006f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            r3.<init>()     // Catch:{ all -> 0x006f }
            java.lang.String r4 = "Create surface life... view : "
            r3.append(r4)     // Catch:{ all -> 0x006f }
            r3.append(r6)     // Catch:{ all -> 0x006f }
            java.lang.String r4 = " | window : "
            r3.append(r4)     // Catch:{ all -> 0x006f }
            r3.append(r1)     // Catch:{ all -> 0x006f }
            java.lang.String r4 = " | callback : "
            r3.append(r4)     // Catch:{ all -> 0x006f }
            com.wushuangtech.myvideoimprove.view.VideoRenderView$OnVideoRenderViewCallBack r4 = r6.mVideoRenderViewCallBack     // Catch:{ all -> 0x006f }
            r3.append(r4)     // Catch:{ all -> 0x006f }
            java.lang.String r4 = " | device id : "
            r3.append(r4)     // Catch:{ all -> 0x006f }
            java.lang.String r4 = r6.mDeviceId     // Catch:{ all -> 0x006f }
            r3.append(r4)     // Catch:{ all -> 0x006f }
            java.lang.String r4 = " | thread id : "
            r3.append(r4)     // Catch:{ all -> 0x006f }
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x006f }
            long r4 = r4.getId()     // Catch:{ all -> 0x006f }
            r3.append(r4)     // Catch:{ all -> 0x006f }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x006f }
            com.wushuangtech.utils.OmniLog.i(r2, r3)     // Catch:{ all -> 0x006f }
            com.wushuangtech.myvideoimprove.view.VideoRenderView$OnVideoRenderViewCallBack r2 = r6.mVideoRenderViewCallBack     // Catch:{ all -> 0x006f }
            if (r2 == 0) goto L_0x006d
            com.wushuangtech.myvideoimprove.bean.VideoRenderViewLifeBean r2 = new com.wushuangtech.myvideoimprove.bean.VideoRenderViewLifeBean     // Catch:{ all -> 0x006f }
            r2.<init>()     // Catch:{ all -> 0x006f }
            r2.mRenderView = r6     // Catch:{ all -> 0x006f }
            r2.mSurface = r1     // Catch:{ all -> 0x006f }
            int r1 = r6.mWidth     // Catch:{ all -> 0x006f }
            r2.mWidth = r1     // Catch:{ all -> 0x006f }
            int r1 = r6.mHeight     // Catch:{ all -> 0x006f }
            r2.mHeight = r1     // Catch:{ all -> 0x006f }
            java.lang.String r1 = r6.mDeviceId     // Catch:{ all -> 0x006f }
            r2.mDeviceId = r1     // Catch:{ all -> 0x006f }
            com.wushuangtech.myvideoimprove.view.VideoRenderView$OnVideoRenderViewCallBack r1 = r6.mVideoRenderViewCallBack     // Catch:{ all -> 0x006f }
            r1.onVideoRenderSurfaceAvailable(r2)     // Catch:{ all -> 0x006f }
        L_0x006d:
            monitor-exit(r0)     // Catch:{ all -> 0x006f }
            return
        L_0x006f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.view.OmniSurfaceView.executeCreateSurface():void");
    }

    public String getSurfaceViewChild() {
        StringBuilder sb = new StringBuilder();
        ViewParent parent = getParent();
        if (parent == null) {
            return sb.toString();
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != null && (childAt instanceof SurfaceView)) {
                sb.append(Integer.toHexString(childAt.hashCode()));
                if (i != childCount - 1) {
                    sb.append("_");
                }
            }
        }
        return sb.toString();
    }
}
