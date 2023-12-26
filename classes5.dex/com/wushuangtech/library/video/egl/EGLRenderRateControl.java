package com.wushuangtech.library.video.egl;

import com.wushuangtech.bean.CommonEventBean;
import com.wushuangtech.library.video.VideoStatus;
import com.wushuangtech.utils.OmniLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class EGLRenderRateControl extends TimerTask {
    private static final String TAG = "EGLRenderRateControl";
    private CommonEventBean mCommonEventBean;
    private int mDrawFrameTimes;
    private EGLEnvImpl mEGLEnvImpl;
    private int mLastDrawFrameTime;
    private int mLastDrawFrameTimeStamp;
    private int mLastDrawFrameTimes;
    private final Object mLock = new Object();
    private List<CommonEventBean> mRunnables;
    private final String mThreadName;
    private Timer mTimer;

    public EGLRenderRateControl(EGLEnvImpl eGLEnvImpl, String str) {
        this.mThreadName = str;
        this.mEGLEnvImpl = eGLEnvImpl;
    }

    public void startGLThread(CommonEventBean commonEventBean) {
        if (this.mTimer == null) {
            this.mCommonEventBean = commonEventBean;
            this.mRunnables = new ArrayList();
            Timer timer = new Timer(this.mThreadName);
            this.mTimer = timer;
            try {
                timer.scheduleAtFixedRate(this, 0, 33);
            } catch (Exception e) {
                e.printStackTrace();
                OmniLog.e(TAG, "OpenGL redner timer thread start failed : " + this.mThreadName);
            }
        }
    }

    public void stopGLThread() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer.purge();
            this.mTimer = null;
        }
        synchronized (this.mLock) {
            this.mCommonEventBean = null;
            this.mEGLEnvImpl = null;
            this.mDrawFrameTimes = 0;
            List<CommonEventBean> list = this.mRunnables;
            if (list != null) {
                list.clear();
                this.mRunnables = null;
            }
        }
    }

    public void addUrgentEvent(CommonEventBean commonEventBean) {
        synchronized (this.mLock) {
            List<CommonEventBean> list = this.mRunnables;
            if (list != null) {
                list.add(commonEventBean);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.mLock
            monitor-enter(r0)
            com.wushuangtech.library.video.egl.EGLEnvImpl r1 = r4.mEGLEnvImpl     // Catch:{ all -> 0x0046 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            return
        L_0x0009:
            java.util.List<com.wushuangtech.bean.CommonEventBean> r1 = r4.mRunnables     // Catch:{ all -> 0x0046 }
            int r1 = r1.size()     // Catch:{ all -> 0x0046 }
            if (r1 <= 0) goto L_0x002e
            java.util.List<com.wushuangtech.bean.CommonEventBean> r1 = r4.mRunnables     // Catch:{ all -> 0x0046 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0046 }
        L_0x0017:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x0029
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0046 }
            com.wushuangtech.bean.CommonEventBean r2 = (com.wushuangtech.bean.CommonEventBean) r2     // Catch:{ all -> 0x0046 }
            com.wushuangtech.library.video.egl.EGLEnvImpl r3 = r4.mEGLEnvImpl     // Catch:{ all -> 0x0046 }
            r3.handleRendererEvent(r2)     // Catch:{ all -> 0x0046 }
            goto L_0x0017
        L_0x0029:
            java.util.List<com.wushuangtech.bean.CommonEventBean> r1 = r4.mRunnables     // Catch:{ all -> 0x0046 }
            r1.clear()     // Catch:{ all -> 0x0046 }
        L_0x002e:
            com.wushuangtech.library.video.egl.EGLEnvImpl r1 = r4.mEGLEnvImpl     // Catch:{ all -> 0x0046 }
            com.wushuangtech.bean.CommonEventBean r2 = r4.mCommonEventBean     // Catch:{ all -> 0x0046 }
            int r2 = r2.mEventType     // Catch:{ all -> 0x0046 }
            boolean r1 = r1.checkEventExist(r2)     // Catch:{ all -> 0x0046 }
            if (r1 != 0) goto L_0x0044
            r4.buildStatusInfo()     // Catch:{ all -> 0x0046 }
            com.wushuangtech.library.video.egl.EGLEnvImpl r1 = r4.mEGLEnvImpl     // Catch:{ all -> 0x0046 }
            com.wushuangtech.bean.CommonEventBean r2 = r4.mCommonEventBean     // Catch:{ all -> 0x0046 }
            r1.handleRendererEvent(r2)     // Catch:{ all -> 0x0046 }
        L_0x0044:
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            return
        L_0x0046:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.library.video.egl.EGLRenderRateControl.run():void");
    }

    private void buildStatusInfo() {
        this.mDrawFrameTimes++;
        long currentTimeMillis = System.currentTimeMillis();
        int i = this.mLastDrawFrameTime;
        if (i != 0) {
            long j = currentTimeMillis - ((long) i);
            int i2 = this.mLastDrawFrameTimeStamp;
            if (i2 >= 1000) {
                VideoStatus.videoCapBeforeFrameRate = this.mDrawFrameTimes - this.mLastDrawFrameTimes;
                this.mLastDrawFrameTimeStamp = 0;
                this.mLastDrawFrameTimes = this.mDrawFrameTimes;
            } else {
                this.mLastDrawFrameTimeStamp = (int) (((long) i2) + j);
            }
        }
        this.mLastDrawFrameTime = (int) currentTimeMillis;
    }
}
