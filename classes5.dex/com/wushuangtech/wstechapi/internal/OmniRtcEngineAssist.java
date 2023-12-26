package com.wushuangtech.wstechapi.internal;

import android.app.Activity;
import android.provider.Settings;
import com.wushuangtech.api.InterCorrectionManager;
import com.wushuangtech.bean.InterCorrectUserBean;
import com.wushuangtech.bean.InterCorrectionBean;
import com.wushuangtech.bean.InterCorrectionEnum;
import com.wushuangtech.handler.ContentInspectHandler;
import com.wushuangtech.inter.OnRtcGlobalMessageCallBack;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.wstechapi.OmniRtcEngine;
import com.wushuangtech.wstechapi.bean.VideoCanvas;
import com.wushuangtech.wstechapi.inter.OmniInterSyncHelper;
import java.lang.ref.WeakReference;

class OmniRtcEngineAssist {
    /* access modifiers changed from: private */
    public static final String TAG = "OmniRtcEngineAssist";
    private static final boolean mRotateChangedType = false;
    private ContentInspectHandler mContentInspectHandler;
    /* access modifiers changed from: private */
    public int mRotate;
    private WeakReference<OmniRtcEngine> mRtcEngineRef;
    private RtcGlobalMessageCallBackImpl mRtcGlobalMessageCallBackImpl;
    private final Object mScreenRotateLock = new Object();
    private WeakReference<Activity> mTopActivity;

    OmniRtcEngineAssist() {
    }

    public void init(OmniRtcEngine omniRtcEngine) {
        this.mRtcEngineRef = new WeakReference<>(omniRtcEngine);
        this.mRtcGlobalMessageCallBackImpl = new RtcGlobalMessageCallBackImpl(this);
        GlobalHolder.getInstance().addRtcGlobalMessageCallBack(this.mRtcGlobalMessageCallBackImpl);
        this.mContentInspectHandler = new ContentInspectHandler();
    }

    public void unInit() {
        WeakReference<OmniRtcEngine> weakReference = this.mRtcEngineRef;
        if (weakReference != null) {
            weakReference.clear();
            this.mRtcEngineRef = null;
        }
        this.mRtcGlobalMessageCallBackImpl = null;
        this.mContentInspectHandler = null;
    }

    public void resetStats() {
        ContentInspectHandler contentInspectHandler = this.mContentInspectHandler;
        if (contentInspectHandler != null) {
            contentInspectHandler.enableContentInspect(false, 5);
        }
    }

    public ContentInspectHandler getContentInspectHandler() {
        return this.mContentInspectHandler;
    }

    public void setActivity(Activity activity) {
        synchronized (this.mScreenRotateLock) {
            this.mTopActivity = new WeakReference<>(activity);
        }
    }

    public void putCacheOptForSetupRemoteVideo(VideoCanvas videoCanvas) {
        InterCorrectionManager interCorrectionManager = GlobalHolder.getInstance().getInterCorrectionManager();
        if (interCorrectionManager != null) {
            InterCorrectUserBean interCorrectUserBean = new InterCorrectUserBean(videoCanvas.getChannelId(), videoCanvas.getUserID());
            interCorrectUserBean.mAction = InterCorrectionEnum.INTER_SETUP_REMOTE_VIDEO;
            interCorrectUserBean.mInfo = videoCanvas;
            interCorrectUserBean.mTimestamp = System.currentTimeMillis();
            interCorrectionManager.addInterCorrection(interCorrectUserBean);
        }
    }

    public boolean checkCacheOptForSetupRemoteVideo(InterCorrectUserBean interCorrectUserBean) {
        InterCorrectionManager interCorrectionManager = GlobalHolder.getInstance().getInterCorrectionManager();
        boolean z = false;
        if (interCorrectionManager == null) {
            OmniLog.w(OmniLog.INTER_CORRECT_WATCH, TAG, "Check cahce opt failed, InterCorrectionManager is null!");
            return false;
        }
        if (interCorrectionManager.getInterCacheBean(interCorrectUserBean).mTimestamp <= interCorrectUserBean.mTimestamp) {
            z = true;
        }
        String str = TAG;
        OmniLog.i(OmniLog.INTER_CORRECT_WATCH, str, "Check cahce opt for setupRemote, result=" + z);
        return z;
    }

    private static class RtcGlobalMessageCallBackImpl implements OnRtcGlobalMessageCallBack {
        private final WeakReference<OmniRtcEngineAssist> mOutReference;

        public RtcGlobalMessageCallBackImpl(OmniRtcEngineAssist omniRtcEngineAssist) {
            this.mOutReference = new WeakReference<>(omniRtcEngineAssist);
        }

        public void onGlobalMessage(int i, Object... objArr) {
            OmniRtcEngineAssist omniRtcEngineAssist = (OmniRtcEngineAssist) this.mOutReference.get();
            if (omniRtcEngineAssist != null) {
                if (i == 1) {
                    omniRtcEngineAssist.recvMessageToHandleJoinChannelResponse(objArr);
                } else if (i == 2) {
                    omniRtcEngineAssist.recvMessageToHandleSeiContentInsert(objArr);
                } else if (i == 3) {
                    omniRtcEngineAssist.recvMessageToHandleScreenRotate(objArr);
                } else if (i == 4) {
                    omniRtcEngineAssist.recvMsgToHandleScreenConfigChanged();
                } else if (i == 5) {
                    omniRtcEngineAssist.recvInterCorrection(objArr);
                } else if (i == 20) {
                    omniRtcEngineAssist.recvMessageToHandleTopActivity(objArr);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void recvMessageToHandleJoinChannelResponse(Object[] objArr) {
        OmniRtcEngine omniRtcEngine = (OmniRtcEngine) this.mRtcEngineRef.get();
        if (omniRtcEngine != null && objArr.length > 0) {
            ((OmniRtcEngineImpl) omniRtcEngine).responseForJoinChannel(objArr[0]);
        }
    }

    /* access modifiers changed from: private */
    public void recvMessageToHandleSeiContentInsert(Object[] objArr) {
        if (((OmniRtcEngine) this.mRtcEngineRef.get()) != null) {
            objArr[0].booleanValue();
        }
    }

    /* access modifiers changed from: private */
    public void recvMessageToHandleTopActivity(Object[] objArr) {
        synchronized (this.mScreenRotateLock) {
            this.mTopActivity = new WeakReference<>(objArr[0]);
        }
    }

    /* access modifiers changed from: private */
    public void recvMessageToHandleScreenRotate(Object[] objArr) {
        int i;
        int intValue = objArr[0].intValue();
        try {
            i = Settings.System.getInt(GlobalHolder.getInstance().getContext().getContentResolver(), "accelerometer_rotation");
            if (i == 0) {
                return;
            }
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            i = -1;
        }
        String str = TAG;
        OmniLog.i(str, OmniLog.SCREEN_ROTATE, "Recv screen new rotate: " + intValue + ", autoRotate: " + i);
        synchronized (this.mScreenRotateLock) {
            if (intValue != 270) {
                this.mRotate = intValue;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003d, code lost:
        r0 = r4.mRotate;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        if (r0 != 0) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0041, code lost:
        r2.setRequestedOrientation(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0048, code lost:
        if (r0 != 90) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004a, code lost:
        r2.setRequestedOrientation(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0051, code lost:
        if (r0 != 180) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0053, code lost:
        r2.setRequestedOrientation(8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0059, code lost:
        if (r0 != 270) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005b, code lost:
        r2.setRequestedOrientation(9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0060, code lost:
        ((com.wushuangtech.wstechapi.internal.OmniRtcEngineImpl) r5).getInterSyncHepler().executeInter("", new com.wushuangtech.wstechapi.internal.OmniRtcEngineAssist.AnonymousClass1(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0070, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void recvMessageToHandleScreenRotate2(int r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.mScreenRotateLock
            monitor-enter(r0)
            r4.mRotate = r5     // Catch:{ all -> 0x0071 }
            r1 = 270(0x10e, float:3.78E-43)
            if (r5 != r1) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            return
        L_0x000b:
            java.lang.ref.WeakReference<com.wushuangtech.wstechapi.OmniRtcEngine> r5 = r4.mRtcEngineRef     // Catch:{ all -> 0x0071 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x0071 }
            com.wushuangtech.wstechapi.OmniRtcEngine r5 = (com.wushuangtech.wstechapi.OmniRtcEngine) r5     // Catch:{ all -> 0x0071 }
            if (r5 != 0) goto L_0x001e
            java.lang.String r5 = TAG     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = "RtcEngine is null..."
            com.wushuangtech.utils.OmniLog.w(r5, r1)     // Catch:{ all -> 0x0071 }
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            return
        L_0x001e:
            java.lang.ref.WeakReference<android.app.Activity> r2 = r4.mTopActivity     // Catch:{ all -> 0x0071 }
            if (r2 != 0) goto L_0x002b
            java.lang.String r5 = TAG     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = "Top activity ref is null..."
            com.wushuangtech.utils.OmniLog.w(r5, r1)     // Catch:{ all -> 0x0071 }
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            return
        L_0x002b:
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0071 }
            android.app.Activity r2 = (android.app.Activity) r2     // Catch:{ all -> 0x0071 }
            if (r2 != 0) goto L_0x003c
            java.lang.String r5 = TAG     // Catch:{ all -> 0x0071 }
            java.lang.String r1 = "Top activity is null..."
            com.wushuangtech.utils.OmniLog.w(r5, r1)     // Catch:{ all -> 0x0071 }
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            return
        L_0x003c:
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            int r0 = r4.mRotate
            if (r0 != 0) goto L_0x0046
            r0 = 0
            r2.setRequestedOrientation(r0)
            goto L_0x0060
        L_0x0046:
            r3 = 90
            if (r0 != r3) goto L_0x004f
            r0 = 1
            r2.setRequestedOrientation(r0)
            goto L_0x0060
        L_0x004f:
            r3 = 180(0xb4, float:2.52E-43)
            if (r0 != r3) goto L_0x0059
            r0 = 8
            r2.setRequestedOrientation(r0)
            goto L_0x0060
        L_0x0059:
            if (r0 != r1) goto L_0x0060
            r0 = 9
            r2.setRequestedOrientation(r0)
        L_0x0060:
            com.wushuangtech.wstechapi.internal.OmniRtcEngineImpl r5 = (com.wushuangtech.wstechapi.internal.OmniRtcEngineImpl) r5
            com.wushuangtech.wstechapi.internal.OmniInterSyncHelperImpl r5 = r5.getInterSyncHepler()
            java.lang.String r0 = ""
            com.wushuangtech.wstechapi.internal.OmniRtcEngineAssist$1 r1 = new com.wushuangtech.wstechapi.internal.OmniRtcEngineAssist$1
            r1.<init>()
            r5.executeInter(r0, r1)
            return
        L_0x0071:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0071 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.wstechapi.internal.OmniRtcEngineAssist.recvMessageToHandleScreenRotate2(int):void");
    }

    /* access modifiers changed from: private */
    public void recvMsgToHandleScreenConfigChanged() {
        if (((OmniRtcEngine) this.mRtcEngineRef.get()) != null) {
            synchronized (this.mScreenRotateLock) {
                OmniRtcEngine omniRtcEngine = (OmniRtcEngine) this.mRtcEngineRef.get();
                if (omniRtcEngine == null) {
                    OmniLog.e(TAG, "Screen config changed, rtcEngine is null... ");
                    return;
                }
                final int i = this.mRotate;
                ((OmniRtcEngineImpl) omniRtcEngine).getInterSyncHepler().executeInter("", new OmniInterSyncHelper() {
                    public int run() {
                        String access$700 = OmniRtcEngineAssist.TAG;
                        OmniLog.i(access$700, "Screen config changed, rotate : " + i);
                        OmniVideoModule.getInstance().setVideoCapRotate(i);
                        return 0;
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void recvInterCorrection(Object[] objArr) {
        if (GlobalHolder.getInstance().getInterCorrectionManager() != null) {
            InterCorrectionBean interCorrectionBean = objArr[0];
            if (AnonymousClass3.$SwitchMap$com$wushuangtech$bean$InterCorrectionEnum[interCorrectionBean.mAction.ordinal()] == 1) {
                InterCorrectUserBean interCorrectUserBean = (InterCorrectUserBean) interCorrectionBean;
                VideoCanvas videoCanvas = (VideoCanvas) interCorrectUserBean.mInfo;
                String str = TAG;
                OmniLog.i(OmniLog.INTER_CORRECT_WATCH, str, "Find cache, videoCanvas=" + videoCanvas);
                ((OmniRtcEngineImpl) ((OmniRtcEngine) this.mRtcEngineRef.get())).setupRemoteVideoInternal(videoCanvas, interCorrectUserBean);
            }
        }
    }

    /* renamed from: com.wushuangtech.wstechapi.internal.OmniRtcEngineAssist$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$wushuangtech$bean$InterCorrectionEnum;

        static {
            int[] iArr = new int[InterCorrectionEnum.values().length];
            $SwitchMap$com$wushuangtech$bean$InterCorrectionEnum = iArr;
            try {
                iArr[InterCorrectionEnum.INTER_SETUP_REMOTE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
