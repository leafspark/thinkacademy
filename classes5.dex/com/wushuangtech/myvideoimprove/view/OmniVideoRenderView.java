package com.wushuangtech.myvideoimprove.view;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.wushuangtech.myvideoimprove.bean.VideoRenderViewLifeBean;
import com.wushuangtech.myvideoimprove.view.VideoRenderView;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;

public class OmniVideoRenderView implements VideoRenderView {
    /* access modifiers changed from: private */
    public static final String TAG = "OmniVideoRenderView";
    public static final int VIEW_TYPE_SURFACE = 1;
    public static final int VIEW_TYPE_TEXTURE = 2;
    private String mDeviceId;
    private int mHeight;
    private final Object mLock = new Object();
    private boolean mSurfaceCreated;
    /* access modifiers changed from: private */
    public WeakReference<SurfaceView> mSurfaceViewRef;
    /* access modifiers changed from: private */
    public WeakReference<TextureView> mTextureViewRef;
    private VideoRenderView.OnVideoRenderViewCallBack mVideoRenderViewCallBack;
    private final int mViewType;
    private int mWidth;
    private Object mWindow;

    public OmniVideoRenderView(SurfaceView surfaceView) {
        this.mSurfaceViewRef = new WeakReference<>(surfaceView);
        LocalSurfaceViewCallBackImpl localSurfaceViewCallBackImpl = new LocalSurfaceViewCallBackImpl(this);
        surfaceView.getHolder().addCallback(localSurfaceViewCallBackImpl);
        surfaceView.addOnAttachStateChangeListener(localSurfaceViewCallBackImpl);
        boolean isAttachedToWindow = surfaceView.isAttachedToWindow();
        this.mSurfaceCreated = isAttachedToWindow;
        if (isAttachedToWindow) {
            this.mWindow = surfaceView.getHolder();
            this.mWidth = surfaceView.getWidth();
            this.mHeight = surfaceView.getHeight();
        }
        this.mViewType = 1;
        String str = TAG;
        OmniLog.i(str, "Create surface view created = " + this.mSurfaceCreated + ", window = " + this.mWindow + ", mWidth = " + this.mWidth + ", mHeight = " + this.mHeight);
    }

    public OmniVideoRenderView(TextureView textureView) {
        this.mTextureViewRef = new WeakReference<>(textureView);
        LocalTextureViewCallBackImpl localTextureViewCallBackImpl = new LocalTextureViewCallBackImpl(this);
        textureView.setSurfaceTextureListener(localTextureViewCallBackImpl);
        textureView.addOnAttachStateChangeListener(localTextureViewCallBackImpl);
        boolean isAttachedToWindow = textureView.isAttachedToWindow();
        this.mSurfaceCreated = isAttachedToWindow;
        if (isAttachedToWindow) {
            this.mWindow = textureView.getSurfaceTexture();
            this.mWidth = textureView.getWidth();
            this.mHeight = textureView.getHeight();
        }
        this.mViewType = 2;
        String str = TAG;
        OmniLog.i(str, "Create texture view created = " + this.mSurfaceCreated + ", window = " + this.mWindow + ", mWidth = " + this.mWidth + ", mHeight = " + this.mHeight);
    }

    public void setVideoRenderViewCallBack(VideoRenderView.OnVideoRenderViewCallBack onVideoRenderViewCallBack) {
        View view;
        synchronized (this.mLock) {
            this.mVideoRenderViewCallBack = onVideoRenderViewCallBack;
            if (this.mSurfaceCreated && onVideoRenderViewCallBack != null) {
                VideoRenderViewLifeBean videoRenderViewLifeBean = new VideoRenderViewLifeBean();
                videoRenderViewLifeBean.mRenderView = this;
                videoRenderViewLifeBean.mSurface = this.mWindow;
                videoRenderViewLifeBean.mWidth = this.mWidth;
                videoRenderViewLifeBean.mHeight = this.mHeight;
                videoRenderViewLifeBean.mDeviceId = this.mDeviceId;
                this.mVideoRenderViewCallBack.onVideoRenderSurfaceAvailable(videoRenderViewLifeBean);
            }
            if (this.mViewType == 1) {
                view = (View) this.mSurfaceViewRef.get();
            } else {
                view = (View) this.mTextureViewRef.get();
            }
            String str = TAG;
            OmniLog.i(str, "Recv call back :" + onVideoRenderViewCallBack + ", created = " + this.mSurfaceCreated + ", view = " + view + ", wrapper = " + this);
        }
    }

    public void setDeviceId(String str) {
        View view;
        this.mDeviceId = str;
        if (this.mViewType == 1) {
            view = (View) this.mSurfaceViewRef.get();
        } else {
            view = (View) this.mTextureViewRef.get();
        }
        String str2 = TAG;
        OmniLog.i(str2, "Setting device id = " + str + ", view = " + view + ", wrapper = " + this);
    }

    public Object getNativeWindow() {
        synchronized (this.mLock) {
            if (!this.mSurfaceCreated) {
                return null;
            }
            Object obj = this.mWindow;
            return obj;
        }
    }

    public int[] getViewSize() {
        synchronized (this.mLock) {
            int i = this.mWidth;
            if (i != 0) {
                int i2 = this.mHeight;
                if (i2 != 0) {
                    int[] iArr = {i, i2};
                    return iArr;
                }
            }
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: android.view.TextureView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: android.view.SurfaceView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: android.view.TextureView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: android.view.TextureView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: android.view.TextureView} */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.os.Handler, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.os.Handler] */
    /* JADX WARNING: type inference failed for: r1v6, types: [android.os.Handler] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void resetSurface() {
        /*
            r7 = this;
            int r0 = r7.mViewType
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L_0x001c
            java.lang.ref.WeakReference<android.view.SurfaceView> r0 = r7.mSurfaceViewRef
            java.lang.Object r0 = r0.get()
            android.view.SurfaceView r0 = (android.view.SurfaceView) r0
            if (r0 == 0) goto L_0x0019
            android.os.Handler r1 = r0.getHandler()
            android.view.SurfaceHolder r2 = r0.getHolder()
            goto L_0x002e
        L_0x0019:
            r0 = r1
            r2 = r0
            goto L_0x002e
        L_0x001c:
            java.lang.ref.WeakReference<android.view.TextureView> r0 = r7.mTextureViewRef
            java.lang.Object r0 = r0.get()
            android.view.TextureView r0 = (android.view.TextureView) r0
            if (r0 == 0) goto L_0x0032
            android.os.Handler r1 = r0.getHandler()
            android.graphics.SurfaceTexture r2 = r0.getSurfaceTexture()
        L_0x002e:
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x0034
        L_0x0032:
            r0 = r1
            r2 = r0
        L_0x0034:
            java.lang.String r3 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Reset render view = "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r5 = ", handler = "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r5 = ", view = "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r5 = ", window = "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r5 = ", id = "
            r4.append(r5)
            java.lang.String r5 = r7.mDeviceId
            r4.append(r5)
            java.lang.String r5 = ", created = "
            r4.append(r5)
            boolean r5 = r7.mSurfaceCreated
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.wushuangtech.utils.OmniLog.i(r3, r4)
            if (r1 == 0) goto L_0x008b
            if (r0 == 0) goto L_0x008b
            if (r2 == 0) goto L_0x008b
            boolean r3 = r7.mSurfaceCreated
            if (r3 != 0) goto L_0x0081
            goto L_0x008b
        L_0x0081:
            com.wushuangtech.myvideoimprove.view.OmniVideoRenderView$1 r3 = new com.wushuangtech.myvideoimprove.view.OmniVideoRenderView$1
            r3.<init>(r1, r2)
            r1 = 2000(0x7d0, double:9.88E-321)
            r0.postDelayed(r3, r1)
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.view.OmniVideoRenderView.resetSurface():void");
    }

    /* access modifiers changed from: private */
    public void onViewAvailable(View view, Object obj) {
        synchronized (this.mLock) {
            this.mSurfaceCreated = true;
            this.mWindow = obj;
            String str = TAG;
            OmniLog.i(str, "onViewAvailable window = " + obj + ", view = " + view + ", wrapper = " + this + ", size = " + this.mWidth + " * " + this.mHeight + ", callback = " + this.mVideoRenderViewCallBack);
            if (this.mVideoRenderViewCallBack != null) {
                VideoRenderViewLifeBean videoRenderViewLifeBean = new VideoRenderViewLifeBean();
                videoRenderViewLifeBean.mRenderView = this;
                videoRenderViewLifeBean.mSurface = obj;
                videoRenderViewLifeBean.mWidth = this.mWidth;
                videoRenderViewLifeBean.mHeight = this.mHeight;
                videoRenderViewLifeBean.mDeviceId = this.mDeviceId;
                this.mVideoRenderViewCallBack.onVideoRenderSurfaceAvailable(videoRenderViewLifeBean);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onViewSizeChanged(View view, Object obj, int i, int i2) {
        synchronized (this.mLock) {
            this.mWidth = i;
            this.mHeight = i2;
            String str = TAG;
            OmniLog.i(str, "onViewSizeChanged window = " + obj + ", view = " + view + ", wrapper = " + this + ", size = " + this.mWidth + " * " + this.mHeight + ", callback = " + this.mVideoRenderViewCallBack);
            if (this.mVideoRenderViewCallBack != null) {
                VideoRenderViewLifeBean videoRenderViewLifeBean = new VideoRenderViewLifeBean();
                videoRenderViewLifeBean.mWidth = i;
                videoRenderViewLifeBean.mHeight = i2;
                videoRenderViewLifeBean.mRenderView = this;
                videoRenderViewLifeBean.mDeviceId = this.mDeviceId;
                this.mVideoRenderViewCallBack.onVideoRenderSurfaceSizeChanged(videoRenderViewLifeBean);
            }
        }
    }

    /* access modifiers changed from: private */
    public void onViewDestroy(View view, Object obj) {
        synchronized (this.mLock) {
            this.mSurfaceCreated = false;
            String str = TAG;
            OmniLog.i(str, "onViewDestroy window = " + obj + ", view = " + view + ", wrapper = " + this + ", size = " + this.mWidth + " * " + this.mHeight + ", callback = " + this.mVideoRenderViewCallBack);
            if (this.mVideoRenderViewCallBack != null) {
                VideoRenderViewLifeBean videoRenderViewLifeBean = new VideoRenderViewLifeBean();
                videoRenderViewLifeBean.mRenderView = this;
                videoRenderViewLifeBean.mSurface = obj;
                this.mVideoRenderViewCallBack.onVideoRenderSurfaceDestroyed(videoRenderViewLifeBean);
            }
        }
    }

    private static class LocalSurfaceViewCallBackImpl implements SurfaceHolder.Callback, View.OnAttachStateChangeListener {
        private final WeakReference<OmniVideoRenderView> mOutReference;

        public LocalSurfaceViewCallBackImpl(OmniVideoRenderView omniVideoRenderView) {
            this.mOutReference = new WeakReference<>(omniVideoRenderView);
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            SurfaceView surfaceView;
            OmniVideoRenderView omniVideoRenderView = (OmniVideoRenderView) this.mOutReference.get();
            if (omniVideoRenderView != null && (surfaceView = (SurfaceView) omniVideoRenderView.mSurfaceViewRef.get()) != null) {
                String access$200 = OmniVideoRenderView.TAG;
                OmniLog.i(access$200, "surfaceCreated view = " + surfaceView + ", wrapper = " + omniVideoRenderView);
                omniVideoRenderView.onViewAvailable(surfaceView, surfaceHolder);
            }
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            SurfaceView surfaceView;
            OmniVideoRenderView omniVideoRenderView = (OmniVideoRenderView) this.mOutReference.get();
            if (omniVideoRenderView != null && (surfaceView = (SurfaceView) omniVideoRenderView.mSurfaceViewRef.get()) != null) {
                String access$200 = OmniVideoRenderView.TAG;
                OmniLog.i(access$200, "surfaceChanged view = " + surfaceView + ", wrapper = " + omniVideoRenderView + ", width = " + i2 + ", height = " + i3);
                omniVideoRenderView.onViewSizeChanged(surfaceView, surfaceHolder, i2, i3);
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            SurfaceView surfaceView;
            OmniVideoRenderView omniVideoRenderView = (OmniVideoRenderView) this.mOutReference.get();
            if (omniVideoRenderView != null && (surfaceView = (SurfaceView) omniVideoRenderView.mSurfaceViewRef.get()) != null) {
                String access$200 = OmniVideoRenderView.TAG;
                OmniLog.i(access$200, "surfaceDestroyed view = " + surfaceView + ", wrapper = " + omniVideoRenderView);
                omniVideoRenderView.onViewDestroy(surfaceView, surfaceHolder);
            }
        }

        public void onViewAttachedToWindow(View view) {
            SurfaceView surfaceView;
            OmniVideoRenderView omniVideoRenderView = (OmniVideoRenderView) this.mOutReference.get();
            if (omniVideoRenderView != null && (surfaceView = (SurfaceView) omniVideoRenderView.mSurfaceViewRef.get()) != null) {
                String access$200 = OmniVideoRenderView.TAG;
                OmniLog.i(access$200, "onViewAttachedToWindow view = " + surfaceView + ", wrapper = " + omniVideoRenderView);
            }
        }

        public void onViewDetachedFromWindow(View view) {
            SurfaceView surfaceView;
            OmniVideoRenderView omniVideoRenderView = (OmniVideoRenderView) this.mOutReference.get();
            if (omniVideoRenderView != null && (surfaceView = (SurfaceView) omniVideoRenderView.mSurfaceViewRef.get()) != null) {
                String access$200 = OmniVideoRenderView.TAG;
                OmniLog.i(access$200, "onViewDetachedFromWindow view = " + surfaceView + ", wrapper = " + omniVideoRenderView);
            }
        }
    }

    private static class LocalTextureViewCallBackImpl implements TextureView.SurfaceTextureListener, View.OnAttachStateChangeListener {
        private final WeakReference<OmniVideoRenderView> mOutReference;

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public LocalTextureViewCallBackImpl(OmniVideoRenderView omniVideoRenderView) {
            this.mOutReference = new WeakReference<>(omniVideoRenderView);
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            TextureView textureView;
            OmniVideoRenderView omniVideoRenderView = (OmniVideoRenderView) this.mOutReference.get();
            if (omniVideoRenderView != null && (textureView = (TextureView) omniVideoRenderView.mTextureViewRef.get()) != null) {
                String access$200 = OmniVideoRenderView.TAG;
                OmniLog.i(access$200, "onSurfaceTextureAvailable view = " + textureView + ", wrapper = " + omniVideoRenderView);
                omniVideoRenderView.onViewAvailable(textureView, surfaceTexture);
                omniVideoRenderView.onViewSizeChanged(textureView, surfaceTexture, i, i2);
            }
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            TextureView textureView;
            OmniVideoRenderView omniVideoRenderView = (OmniVideoRenderView) this.mOutReference.get();
            if (omniVideoRenderView != null && (textureView = (TextureView) omniVideoRenderView.mTextureViewRef.get()) != null) {
                String access$200 = OmniVideoRenderView.TAG;
                OmniLog.i(access$200, "onSurfaceTextureSizeChanged view = " + textureView + ", wrapper = " + omniVideoRenderView);
                omniVideoRenderView.onViewSizeChanged(textureView, surfaceTexture, i, i2);
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            TextureView textureView;
            OmniVideoRenderView omniVideoRenderView = (OmniVideoRenderView) this.mOutReference.get();
            if (omniVideoRenderView == null || (textureView = (TextureView) omniVideoRenderView.mTextureViewRef.get()) == null) {
                return true;
            }
            String access$200 = OmniVideoRenderView.TAG;
            OmniLog.i(access$200, "onSurfaceTextureDestroyed view = " + textureView + ", wrapper = " + omniVideoRenderView);
            omniVideoRenderView.onViewDestroy(textureView, surfaceTexture);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
            TextureView textureView;
            OmniVideoRenderView omniVideoRenderView = (OmniVideoRenderView) this.mOutReference.get();
            if (omniVideoRenderView != null && (textureView = (TextureView) omniVideoRenderView.mTextureViewRef.get()) != null) {
                String access$200 = OmniVideoRenderView.TAG;
                OmniLog.i(access$200, "onViewAttachedToWindow view = " + textureView + ", wrapper = " + omniVideoRenderView);
            }
        }

        public void onViewDetachedFromWindow(View view) {
            TextureView textureView;
            OmniVideoRenderView omniVideoRenderView = (OmniVideoRenderView) this.mOutReference.get();
            if (omniVideoRenderView != null && (textureView = (TextureView) omniVideoRenderView.mTextureViewRef.get()) != null) {
                String access$200 = OmniVideoRenderView.TAG;
                OmniLog.i(access$200, "onViewDetachedFromWindow view = " + textureView + ", wrapper = " + omniVideoRenderView);
            }
        }
    }
}
