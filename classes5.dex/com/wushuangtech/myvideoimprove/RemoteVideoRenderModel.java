package com.wushuangtech.myvideoimprove;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import com.wushuangtech.bean.FastLogCacheBean;
import com.wushuangtech.constants.RtcEngineEvent;
import com.wushuangtech.library.video.bean.VideoRemoteRawDataBean;
import com.wushuangtech.myvideoimprove.bean.BaseVideoModelConfigureBean;
import com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean;
import com.wushuangtech.myvideoimprove.render.RemoteVideoRenderer;
import com.wushuangtech.myvideoimprove.view.VideoRenderView;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class RemoteVideoRenderModel extends BaseVideoRenderModel {
    private static final String TAG = "RemoteVideoRenderModel";
    private final HashMap<String, RemoteVideoModelConfigureBean> mCacheBeans = new HashMap<>();
    protected final OnRemoteVideoRenderModelCallBack mOnRemoteVideoRenderModelCallBack;
    private final FastLogCacheBean mRequestRenderWatcher;
    private final HashMap<String, RemoteVideoModelConfigureBean> mUsers = new HashMap<>();

    public interface OnRemoteVideoRenderModelCallBack {
        void onRenderFinish(String str);

        void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, String str);
    }

    public native void nativeInitOpenglesRenderer(long j, String str);

    public native long nativeInitialize(RemoteVideoRenderModel remoteVideoRenderModel);

    public native void nativeReceiveDecodedData(long j, String str);

    public native void nativeSetRenderMode(long j, String str, int i);

    public native void nativeSetRenderPreviewSize(long j, String str, int i, int i2);

    public native void nativeSetRenderRawSize(long j, String str, int i, int i2);

    public native void nativeStartRenderer(long j, String str);

    public native void nativeUninitialize(long j);

    public void stopVideoRender() {
    }

    public RemoteVideoRenderModel(OnRemoteVideoRenderModelCallBack onRemoteVideoRenderModelCallBack) {
        super("RVW", TAG);
        OmniLog.i(TAG, "Recv CallBack Object=" + onRemoteVideoRenderModelCallBack);
        this.mOnRemoteVideoRenderModelCallBack = onRemoteVideoRenderModelCallBack;
        FastLogCacheBean fastLogCacheBean = new FastLogCacheBean("RemoteVideoRenderModel - requestRender", TAG, 4);
        this.mRequestRenderWatcher = fastLogCacheBean;
        fastLogCacheBean.mInterval = RtcEngineEvent.AudioEvent.EVENT_AUDIO_START_POINT;
    }

    public RemoteVideoRenderer getVideoRenderer(String str) {
        RemoteVideoRenderer remoteVideoRenderer;
        try {
            this.mLock.lock();
            RemoteVideoModelConfigureBean remoteVideoModelConfigureBean = this.mUsers.get(str);
            if (remoteVideoModelConfigureBean == null) {
                remoteVideoRenderer = null;
            } else {
                remoteVideoRenderer = remoteVideoModelConfigureBean.mRemoteVideoRenderer;
            }
            return remoteVideoRenderer;
        } finally {
            this.mLock.unlock();
        }
    }

    public void setRenderMode(String str, int i) {
        setVideoRenderParams(str, Integer.valueOf(i), (Integer) null, (int[]) null);
    }

    public void setVideoRenderMirror(String str, int i) {
        setVideoRenderParams(str, (Integer) null, Integer.valueOf(i), (int[]) null);
    }

    public void setVideoSize(String str, int[] iArr) {
        setVideoRenderParams(str, (Integer) null, (Integer) null, iArr);
    }

    public void requestRender(VideoRemoteRawDataBean videoRemoteRawDataBean) {
        RemoteVideoRenderer videoRenderer = getVideoRenderer(videoRemoteRawDataBean.mDeviceId);
        if (videoRenderer == null) {
            FastLogCacheBean fastLogCacheBean = this.mRequestRenderWatcher;
            fastLogCacheBean.mMessage = "Request render failed... " + videoRemoteRawDataBean.toString();
            OmniLog.fd(this.mRequestRenderWatcher);
            return;
        }
        videoRenderer.requestRender(videoRemoteRawDataBean);
    }

    public void waitForTextureUpdated(String str) {
        RemoteVideoRenderer videoRenderer = getVideoRenderer(str);
        if (videoRenderer != null) {
            videoRenderer.waitForTextureUpdate();
        }
    }

    public void stopWaitForTextureUpdated(String str) {
        RemoteVideoRenderer videoRenderer = getVideoRenderer(str);
        if (videoRenderer != null) {
            videoRenderer.stopWiatForTextureUpdate();
        }
    }

    public boolean createVideoRenderer(BaseVideoModelConfigureBean baseVideoModelConfigureBean) {
        try {
            this.mLock.lock();
            if (baseVideoModelConfigureBean == null) {
                logE("BaseVideoModelConfigureBean is null");
                return false;
            }
            RemoteVideoModelConfigureBean remoteVideoModelConfigureBean = (RemoteVideoModelConfigureBean) baseVideoModelConfigureBean;
            RemoteVideoModelConfigureBean remoteVideoModelConfigureBean2 = this.mUsers.get(remoteVideoModelConfigureBean.mDeviceId);
            if (remoteVideoModelConfigureBean2 == null || remoteVideoModelConfigureBean2.mVideoRenderView != remoteVideoModelConfigureBean.mVideoRenderView) {
                RemoteVideoRenderer remoteVideoRenderer = new RemoteVideoRenderer(remoteVideoModelConfigureBean.mChannelName, remoteVideoModelConfigureBean.mUid, remoteVideoModelConfigureBean.mDeviceId, new RemoteVideoRenderCallBackImpl(this));
                remoteVideoRenderer.initRenderer();
                remoteVideoRenderer.setVideoRenderView(remoteVideoModelConfigureBean.mVideoRenderView);
                remoteVideoModelConfigureBean.mRemoteVideoRenderer = remoteVideoRenderer;
                this.mUsers.put(remoteVideoModelConfigureBean.mDeviceId, remoteVideoModelConfigureBean);
                logI("Create new video remote renderer... " + baseVideoModelConfigureBean.toString() + " | size : " + this.mUsers.size());
            } else {
                OmniLog.i(TAG, "createVideoRenderer view:" + remoteVideoModelConfigureBean.mVideoRenderView);
            }
            this.mLock.unlock();
            return true;
        } finally {
            this.mLock.unlock();
        }
    }

    public void destroyVideoRenderer(BaseVideoModelConfigureBean baseVideoModelConfigureBean) {
        try {
            this.mLock.lock();
            OmniLog.i(TAG, "Starting destroy video renderer, bean=" + baseVideoModelConfigureBean);
            if (baseVideoModelConfigureBean != null) {
                String str = ((RemoteVideoModelConfigureBean) baseVideoModelConfigureBean).mDeviceId;
                if (TextUtils.isEmpty(str)) {
                    OmniLog.e(TAG, "Destroy video renderer failed! deviceId is empty!");
                } else {
                    if ("all".equals(str)) {
                        for (Map.Entry<String, RemoteVideoModelConfigureBean> value : this.mUsers.entrySet()) {
                            RemoteVideoModelConfigureBean remoteVideoModelConfigureBean = (RemoteVideoModelConfigureBean) value.getValue();
                            remoteVideoModelConfigureBean.mRemoteVideoRenderer.unInitVideoRenderer();
                            remoteVideoModelConfigureBean.mRemoteVideoRenderer = null;
                            remoteVideoModelConfigureBean.mVideoRenderView = null;
                        }
                        this.mUsers.clear();
                    } else {
                        RemoteVideoModelConfigureBean remove = this.mUsers.remove(str);
                        if (remove == null) {
                            OmniLog.e(TAG, "Destroy video renderer failed! not found target bean! " + str);
                        } else {
                            remove.mRemoteVideoRenderer.unInitVideoRenderer();
                            remove.mRemoteVideoRenderer = null;
                            remove.mVideoRenderView = null;
                        }
                    }
                    logI("Destroy video renderer success! deviceId : " + str + " | size : " + this.mUsers.size());
                    this.mLock.unlock();
                }
            }
        } finally {
            this.mLock.unlock();
        }
    }

    public boolean startVideoRender(BaseVideoModelConfigureBean baseVideoModelConfigureBean) {
        try {
            this.mLock.lock();
            if (baseVideoModelConfigureBean == null) {
                logE("BaseVideoModelConfigureBean is null...");
            } else {
                OmniLog.i(TAG, "startVideoRender bean:" + baseVideoModelConfigureBean.toString());
                RemoteVideoModelConfigureBean remoteVideoModelConfigureBean = (RemoteVideoModelConfigureBean) baseVideoModelConfigureBean;
                RemoteVideoRenderer remoteVideoRenderer = remoteVideoModelConfigureBean.mRemoteVideoRenderer;
                if (remoteVideoModelConfigureBean.mVideoRenderView != null) {
                    if (remoteVideoRenderer != null) {
                        RemoteVideoModelConfigureBean remove = this.mCacheBeans.remove(remoteVideoModelConfigureBean.mDeviceId);
                        StringBuilder sb = new StringBuilder();
                        sb.append("REMOTE_MODE Start rendering.. ");
                        sb.append(baseVideoModelConfigureBean.toString());
                        sb.append(" | cacheBean : ");
                        sb.append(remove == null ? "null" : remove.toString());
                        logI(sb.toString());
                        if (remove != null) {
                            if (remove.mRenderMode != 0) {
                                remoteVideoRenderer.setRenderMode(remove.mRenderMode);
                            }
                            if (remove.mMirrorMode != 0) {
                                remoteVideoRenderer.setRenderMode(remove.mMirrorMode);
                            }
                            if (!(remove.mWidth == 0 || remove.mHeight == 0)) {
                                remoteVideoRenderer.setVideoSize(remove.mWidth, remove.mHeight);
                            }
                        }
                        this.mLock.unlock();
                        return true;
                    }
                }
                logE("VideoRenderView or RemoteVideoRenderer2 is null...");
            }
            return false;
        } finally {
            this.mLock.unlock();
        }
    }

    public boolean changeVideoRenderView(String str, VideoRenderView videoRenderView) {
        try {
            this.mLock.lock();
            RemoteVideoModelConfigureBean remoteVideoModelConfigureBean = this.mUsers.get(str);
            if (remoteVideoModelConfigureBean != null) {
                if (remoteVideoModelConfigureBean.mRemoteVideoRenderer == null) {
                    logE("Change video render view failed! RemoteVideoRenderer is null! " + remoteVideoModelConfigureBean.toString());
                } else if (remoteVideoModelConfigureBean.mVideoRenderView == null) {
                    logE("Change video render view failed! Old view is null! " + remoteVideoModelConfigureBean.toString());
                } else if (remoteVideoModelConfigureBean.mVideoRenderView == videoRenderView) {
                    this.mLock.unlock();
                    return true;
                } else {
                    remoteVideoModelConfigureBean.mVideoRenderView = videoRenderView;
                    remoteVideoModelConfigureBean.mRemoteVideoRenderer.setVideoRenderView(videoRenderView);
                    this.mLock.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            this.mLock.unlock();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c2 A[SYNTHETIC, Splitter:B:33:0x00c2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setVideoRenderParams(java.lang.String r9, java.lang.Integer r10, java.lang.Integer r11, int[] r12) {
        /*
            r8 = this;
            java.util.concurrent.locks.Lock r0 = r8.mLock     // Catch:{ all -> 0x0109 }
            r0.lock()     // Catch:{ all -> 0x0109 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0109 }
            r0.<init>()     // Catch:{ all -> 0x0109 }
            java.lang.String r1 = "REMOTE_MODE Setting renderer args, deviceId="
            r0.append(r1)     // Catch:{ all -> 0x0109 }
            r0.append(r9)     // Catch:{ all -> 0x0109 }
            java.lang.String r1 = ", mode="
            r0.append(r1)     // Catch:{ all -> 0x0109 }
            r0.append(r10)     // Catch:{ all -> 0x0109 }
            java.lang.String r1 = ", mirror="
            r0.append(r1)     // Catch:{ all -> 0x0109 }
            r0.append(r11)     // Catch:{ all -> 0x0109 }
            java.lang.String r1 = ", size="
            r0.append(r1)     // Catch:{ all -> 0x0109 }
            if (r12 != 0) goto L_0x002c
            java.lang.String r1 = "null"
            goto L_0x0030
        L_0x002c:
            java.lang.String r1 = java.util.Arrays.toString(r12)     // Catch:{ all -> 0x0109 }
        L_0x0030:
            r0.append(r1)     // Catch:{ all -> 0x0109 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0109 }
            r8.logI(r0)     // Catch:{ all -> 0x0109 }
            java.lang.String r0 = "OPTION_FOR_ALL_STRING"
            boolean r0 = r0.equals(r9)     // Catch:{ all -> 0x0109 }
            if (r0 == 0) goto L_0x0068
            java.util.HashMap<java.lang.String, com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean> r0 = r8.mUsers     // Catch:{ all -> 0x0109 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x0109 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0109 }
        L_0x004c:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0109 }
            if (r1 == 0) goto L_0x00fe
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0109 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x0109 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x0109 }
            r3 = r1
            com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean r3 = (com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean) r3     // Catch:{ all -> 0x0109 }
            r2 = r8
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r12
            r2.executingSetVideoRenderParams(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0109 }
            goto L_0x004c
        L_0x0068:
            java.util.HashMap<java.lang.String, com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean> r0 = r8.mUsers     // Catch:{ all -> 0x0109 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x0109 }
            com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean r0 = (com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean) r0     // Catch:{ all -> 0x0109 }
            java.lang.String r1 = "REMOTE_MODE Setting renderer args failed!, RemoteVideoModelConfigureBean is null! "
            if (r0 != 0) goto L_0x009a
            java.util.HashMap<java.lang.String, com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean> r0 = r8.mCacheBeans     // Catch:{ all -> 0x0109 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x0109 }
            com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean r0 = (com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean) r0     // Catch:{ all -> 0x0109 }
            if (r0 != 0) goto L_0x009a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0109 }
            r0.<init>()     // Catch:{ all -> 0x0109 }
            r0.append(r1)     // Catch:{ all -> 0x0109 }
            r0.append(r9)     // Catch:{ all -> 0x0109 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0109 }
            r8.logE(r0)     // Catch:{ all -> 0x0109 }
            com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean r0 = new com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean     // Catch:{ all -> 0x0109 }
            r0.<init>()     // Catch:{ all -> 0x0109 }
            java.util.HashMap<java.lang.String, com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean> r2 = r8.mCacheBeans     // Catch:{ all -> 0x0109 }
            r2.put(r9, r0)     // Catch:{ all -> 0x0109 }
        L_0x009a:
            r3 = r0
            r2 = r8
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r12
            r2.executingSetVideoRenderParams(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0109 }
            java.lang.String r0 = ":"
            java.lang.String[] r9 = r9.split(r0)     // Catch:{ Exception -> 0x0104 }
            int r0 = r9.length     // Catch:{ Exception -> 0x0104 }
            r2 = 1
            r3 = -1
            if (r0 <= r2) goto L_0x00b7
            r0 = 0
            r9 = r9[r0]     // Catch:{ Exception -> 0x00b7 }
            long r5 = java.lang.Long.parseLong(r9)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00b8
        L_0x00b7:
            r5 = r3
        L_0x00b8:
            int r9 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r9 != 0) goto L_0x00c2
        L_0x00bc:
            java.util.concurrent.locks.Lock r9 = r8.mLock
            r9.unlock()
            return
        L_0x00c2:
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0109 }
            java.util.HashMap<java.lang.String, com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean> r9 = r8.mUsers     // Catch:{ all -> 0x0109 }
            java.lang.Object r9 = r9.get(r2)     // Catch:{ all -> 0x0109 }
            com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean r9 = (com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean) r9     // Catch:{ all -> 0x0109 }
            if (r9 != 0) goto L_0x00f6
            java.util.HashMap<java.lang.String, com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean> r9 = r8.mCacheBeans     // Catch:{ all -> 0x0109 }
            java.lang.Object r9 = r9.get(r2)     // Catch:{ all -> 0x0109 }
            com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean r9 = (com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean) r9     // Catch:{ all -> 0x0109 }
            if (r9 != 0) goto L_0x00f6
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0109 }
            r9.<init>()     // Catch:{ all -> 0x0109 }
            r9.append(r1)     // Catch:{ all -> 0x0109 }
            r9.append(r2)     // Catch:{ all -> 0x0109 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0109 }
            r8.logE(r9)     // Catch:{ all -> 0x0109 }
            com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean r9 = new com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean     // Catch:{ all -> 0x0109 }
            r9.<init>()     // Catch:{ all -> 0x0109 }
            java.util.HashMap<java.lang.String, com.wushuangtech.myvideoimprove.bean.RemoteVideoModelConfigureBean> r0 = r8.mCacheBeans     // Catch:{ all -> 0x0109 }
            r0.put(r2, r9)     // Catch:{ all -> 0x0109 }
        L_0x00f6:
            r1 = r9
            r0 = r8
            r3 = r10
            r4 = r11
            r5 = r12
            r0.executingSetVideoRenderParams(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0109 }
        L_0x00fe:
            java.util.concurrent.locks.Lock r9 = r8.mLock
            r9.unlock()
            return
        L_0x0104:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ all -> 0x0109 }
            goto L_0x00bc
        L_0x0109:
            r9 = move-exception
            java.util.concurrent.locks.Lock r10 = r8.mLock
            r10.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.RemoteVideoRenderModel.setVideoRenderParams(java.lang.String, java.lang.Integer, java.lang.Integer, int[]):void");
    }

    private void executingSetVideoRenderParams(RemoteVideoModelConfigureBean remoteVideoModelConfigureBean, String str, Integer num, Integer num2, int[] iArr) {
        RemoteVideoRenderer remoteVideoRenderer = remoteVideoModelConfigureBean.mRemoteVideoRenderer;
        if (remoteVideoRenderer == null) {
            if (num != null) {
                remoteVideoModelConfigureBean.mRenderMode = num.intValue();
            }
            if (num2 != null) {
                remoteVideoModelConfigureBean.mMirrorMode = num2.intValue();
            }
            if (iArr != null) {
                remoteVideoModelConfigureBean.mWidth = iArr[0];
                remoteVideoModelConfigureBean.mHeight = iArr[1];
                return;
            }
            return;
        }
        if (num != null) {
            remoteVideoRenderer.setRenderMode(num.intValue());
        }
        if (num2 != null) {
            remoteVideoRenderer.setMirrorMode(num2.intValue());
        }
        if (iArr != null) {
            remoteVideoRenderer.setVideoSize(iArr[0], iArr[1]);
        }
    }

    private static class RemoteVideoRenderCallBackImpl implements RemoteVideoRenderer.OnRemoteVideoRendererCallBack {
        private final WeakReference<RemoteVideoRenderModel> mOutReference;

        public RemoteVideoRenderCallBackImpl(RemoteVideoRenderModel remoteVideoRenderModel) {
            this.mOutReference = new WeakReference<>(remoteVideoRenderModel);
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, String str) {
            RemoteVideoRenderModel remoteVideoRenderModel = (RemoteVideoRenderModel) this.mOutReference.get();
            if (remoteVideoRenderModel != null && remoteVideoRenderModel.mOnRemoteVideoRenderModelCallBack != null) {
                remoteVideoRenderModel.mOnRemoteVideoRenderModelCallBack.onSurfaceTextureAvailable(surfaceTexture, str);
            }
        }

        public void onRenderFinish(String str) {
            RemoteVideoRenderModel remoteVideoRenderModel;
            if (!TextUtils.isEmpty(str) && (remoteVideoRenderModel = (RemoteVideoRenderModel) this.mOutReference.get()) != null && remoteVideoRenderModel.mOnRemoteVideoRenderModelCallBack != null) {
                remoteVideoRenderModel.mOnRemoteVideoRenderModelCallBack.onRenderFinish(str);
            }
        }

        public void onEGLSurfaceDisplayRenderError(String str) {
            RemoteVideoRenderModel remoteVideoRenderModel = (RemoteVideoRenderModel) this.mOutReference.get();
            if (remoteVideoRenderModel != null) {
                remoteVideoRenderModel.handleEGLSurfaceRenderError(str);
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleEGLSurfaceRenderError(String str) {
        if (!TextUtils.isEmpty(str)) {
            RemoteVideoModelConfigureBean remoteVideoModelConfigureBean = this.mUsers.get(str);
            if (remoteVideoModelConfigureBean == null) {
                logE("RemoteVideoModelConfigureBean is null! id = " + str);
                return;
            }
            VideoRenderView videoRenderView = remoteVideoModelConfigureBean.mVideoRenderView;
            if (videoRenderView == null) {
                logE("VideoRenderView is null! id = " + str);
                return;
            }
            videoRenderView.resetSurface();
        }
    }
}
