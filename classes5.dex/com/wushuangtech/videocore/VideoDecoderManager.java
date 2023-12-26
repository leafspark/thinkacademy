package com.wushuangtech.videocore;

import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import com.wushuangtech.bean.FastLogCacheBean;
import com.wushuangtech.bean.VideoRenderBean;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.UserDeviceConfig;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.videocore.bean.VideoRecvFrameRateBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoDecoderManager {
    private static final String TAG = "VideoDecoderManager";
    private static VideoDecoderManager holder;
    private ConcurrentHashMap<String, VideoDecoder> mDecodes;
    private boolean mIsInit;
    private final Object mLock = new Object();
    private final FastLogCacheBean mRecvVideoDataWatcher = new FastLogCacheBean("VideoDecoderManager-addVideoData", TAG, 4);
    private ConcurrentHashMap<String, VideoRecvFrameRateBean> mVideoRecvFrameRates;
    private List<VideoRenderBean> mVideoRenderBeans;

    private VideoDecoderManager() {
    }

    public static VideoDecoderManager getInstance() {
        if (holder == null) {
            synchronized (VideoDecoderManager.class) {
                if (holder == null) {
                    holder = new VideoDecoderManager();
                }
            }
        }
        return holder;
    }

    public void initMananger() {
        synchronized (this.mLock) {
            this.mVideoRenderBeans = new ArrayList();
            this.mDecodes = new ConcurrentHashMap<>();
            this.mVideoRecvFrameRates = new ConcurrentHashMap<>();
            this.mIsInit = true;
            logI("Init video decoder manager... ");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean checkVideoDecoderExist(String str) {
        ConcurrentHashMap<String, VideoDecoder> concurrentHashMap;
        if (!TextUtils.isEmpty(str) && (concurrentHashMap = this.mDecodes) != null && this.mIsInit && concurrentHashMap.get(str) != null) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        if (com.wushuangtech.library.GlobalHolder.getInstance().checkChannelExist(r4) != false) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
        logE("Create a new decoder failed... " + "channel not joined... " + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0068, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0069, code lost:
        r1 = com.wushuangtech.library.GlobalHolder.getInstance().getUserManager(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0071, code lost:
        if (r1 != null) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0073, code lost:
        logE("Create a new decoder failed... " + "RtcUserManager is null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0088, code lost:
        r1 = r1.getUser(r5);
        r2 = com.wushuangtech.library.GlobalHolder.getInstance().checkMixDeviceIdExist(r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0094, code lost:
        if (r1 != null) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0096, code lost:
        if (r2 != false) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0098, code lost:
        logE("Create a new decoder failed... " + "user leave room!");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ac, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ad, code lost:
        r1 = new com.wushuangtech.videocore.VideoDecoder(r4, r5, r7);
        r1.setDecoderType(com.wushuangtech.library.GlobalConfig.mForceVideoSoftDecoder);
        r1.setVideoSize(r8, r9);
        r1.setOnVideoDecoderHardwareListener(((com.wushuangtech.videocore.MyVideoApiImpl) com.wushuangtech.videocore.MyVideoApi.getInstance()).getVideoDecoderHardwareModel());
        r5 = r3.mLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c9, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r6 = r3.mDecodes;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00cc, code lost:
        if (r6 != null) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ce, code lost:
        logE("Create a new decoder failed... " + "decoder list is null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e2, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e3, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e4, code lost:
        r6.put(r7, r1);
        r6 = java.lang.Integer.toHexString(r1.hashCode());
        logI("Create a new decoder success , channelName : " + r4 + " | device id : " + r7 + " | decoder address : " + r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0113, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0114, code lost:
        r1.start(r8, r9);
        registerVideoDecoder(r7, r6, r8, r9);
        com.wushuangtech.api.EnterConfApiImpl.getInstance().reportCreateVideoDecoder(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0121, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void createNewVideoDecoder(java.lang.String r4, long r5, java.lang.String r7, int r8, int r9) {
        /*
            r3 = this;
            java.lang.String r0 = "Create a new decoder failed... "
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 == 0) goto L_0x001d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r5 = "device id is null"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.logE(r4)
            return
        L_0x001d:
            java.lang.Object r1 = r3.mLock
            monitor-enter(r1)
            boolean r2 = r3.mIsInit     // Catch:{ all -> 0x0125 }
            if (r2 != 0) goto L_0x003a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0125 }
            r4.<init>()     // Catch:{ all -> 0x0125 }
            r4.append(r0)     // Catch:{ all -> 0x0125 }
            java.lang.String r5 = "manager not init..."
            r4.append(r5)     // Catch:{ all -> 0x0125 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0125 }
            r3.logE(r4)     // Catch:{ all -> 0x0125 }
            monitor-exit(r1)     // Catch:{ all -> 0x0125 }
            return
        L_0x003a:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.wushuangtech.videocore.VideoDecoder> r2 = r3.mDecodes     // Catch:{ all -> 0x0125 }
            java.lang.Object r2 = r2.get(r7)     // Catch:{ all -> 0x0125 }
            com.wushuangtech.videocore.VideoDecoder r2 = (com.wushuangtech.videocore.VideoDecoder) r2     // Catch:{ all -> 0x0125 }
            if (r2 == 0) goto L_0x0046
            monitor-exit(r1)     // Catch:{ all -> 0x0125 }
            return
        L_0x0046:
            monitor-exit(r1)     // Catch:{ all -> 0x0125 }
            com.wushuangtech.library.GlobalHolder r1 = com.wushuangtech.library.GlobalHolder.getInstance()
            boolean r1 = r1.checkChannelExist(r4)
            if (r1 != 0) goto L_0x0069
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            java.lang.String r6 = "channel not joined... "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r3.logE(r4)
            return
        L_0x0069:
            com.wushuangtech.library.GlobalHolder r1 = com.wushuangtech.library.GlobalHolder.getInstance()
            com.wushuangtech.api.RtcUserManager r1 = r1.getUserManager(r4)
            if (r1 != 0) goto L_0x0088
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r5 = "RtcUserManager is null"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.logE(r4)
            return
        L_0x0088:
            com.wushuangtech.library.User r1 = r1.getUser(r5)
            com.wushuangtech.library.GlobalHolder r2 = com.wushuangtech.library.GlobalHolder.getInstance()
            boolean r2 = r2.checkMixDeviceIdExist(r4, r7)
            if (r1 != 0) goto L_0x00ad
            if (r2 != 0) goto L_0x00ad
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r5 = "user leave room!"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.logE(r4)
            return
        L_0x00ad:
            com.wushuangtech.videocore.VideoDecoder r1 = new com.wushuangtech.videocore.VideoDecoder
            r1.<init>(r4, r5, r7)
            boolean r5 = com.wushuangtech.library.GlobalConfig.mForceVideoSoftDecoder
            r1.setDecoderType(r5)
            r1.setVideoSize(r8, r9)
            com.wushuangtech.videocore.MyVideoApi r5 = com.wushuangtech.videocore.MyVideoApi.getInstance()
            com.wushuangtech.videocore.MyVideoApiImpl r5 = (com.wushuangtech.videocore.MyVideoApiImpl) r5
            com.wushuangtech.videocore.model.VideoDecoderHardwareModel r5 = r5.getVideoDecoderHardwareModel()
            r1.setOnVideoDecoderHardwareListener(r5)
            java.lang.Object r5 = r3.mLock
            monitor-enter(r5)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.wushuangtech.videocore.VideoDecoder> r6 = r3.mDecodes     // Catch:{ all -> 0x0122 }
            if (r6 != 0) goto L_0x00e4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0122 }
            r4.<init>()     // Catch:{ all -> 0x0122 }
            r4.append(r0)     // Catch:{ all -> 0x0122 }
            java.lang.String r6 = "decoder list is null"
            r4.append(r6)     // Catch:{ all -> 0x0122 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0122 }
            r3.logE(r4)     // Catch:{ all -> 0x0122 }
            monitor-exit(r5)     // Catch:{ all -> 0x0122 }
            return
        L_0x00e4:
            r6.put(r7, r1)     // Catch:{ all -> 0x0122 }
            int r6 = r1.hashCode()     // Catch:{ all -> 0x0122 }
            java.lang.String r6 = java.lang.Integer.toHexString(r6)     // Catch:{ all -> 0x0122 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0122 }
            r0.<init>()     // Catch:{ all -> 0x0122 }
            java.lang.String r2 = "Create a new decoder success , channelName : "
            r0.append(r2)     // Catch:{ all -> 0x0122 }
            r0.append(r4)     // Catch:{ all -> 0x0122 }
            java.lang.String r4 = " | device id : "
            r0.append(r4)     // Catch:{ all -> 0x0122 }
            r0.append(r7)     // Catch:{ all -> 0x0122 }
            java.lang.String r4 = " | decoder address : "
            r0.append(r4)     // Catch:{ all -> 0x0122 }
            r0.append(r6)     // Catch:{ all -> 0x0122 }
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x0122 }
            r3.logI(r4)     // Catch:{ all -> 0x0122 }
            monitor-exit(r5)     // Catch:{ all -> 0x0122 }
            r1.start(r8, r9)
            r3.registerVideoDecoder(r7, r6, r8, r9)
            com.wushuangtech.api.EnterConfApiImpl r4 = com.wushuangtech.api.EnterConfApiImpl.getInstance()
            r4.reportCreateVideoDecoder(r7, r6)
            return
        L_0x0122:
            r4 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0122 }
            throw r4
        L_0x0125:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0125 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.videocore.VideoDecoderManager.createNewVideoDecoder(java.lang.String, long, java.lang.String, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addVideoData(java.lang.String r8, java.lang.String r9, com.wushuangtech.library.video.bean.VideoFrame r10) {
        /*
            r7 = this;
            java.lang.String r0 = "recv data : "
            java.lang.String r1 = ""
            java.lang.String r2 = "_"
            r3 = 0
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.wushuangtech.videocore.VideoDecoder> r4 = r7.mDecodes     // Catch:{ all -> 0x00dc }
            boolean r5 = r7.mIsInit     // Catch:{ all -> 0x00dc }
            if (r5 == 0) goto L_0x00ce
            if (r4 != 0) goto L_0x0011
            goto L_0x00ce
        L_0x0011:
            java.lang.Object r4 = r4.get(r9)     // Catch:{ all -> 0x00dc }
            com.wushuangtech.videocore.VideoDecoder r4 = (com.wushuangtech.videocore.VideoDecoder) r4     // Catch:{ all -> 0x00dc }
            if (r4 != 0) goto L_0x0078
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cc }
            r3.<init>()     // Catch:{ all -> 0x00cc }
            java.lang.String r5 = "Decoder is null... "
            r3.append(r5)     // Catch:{ all -> 0x00cc }
            r3.append(r9)     // Catch:{ all -> 0x00cc }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00cc }
            r7.logE(r3)     // Catch:{ all -> 0x00cc }
            if (r4 == 0) goto L_0x0037
            int r1 = r4.hashCode()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x0037:
            com.wushuangtech.bean.FastLogCacheBean r3 = r7.mRecvVideoDataWatcher
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
        L_0x003e:
            r4.append(r0)
            r4.append(r8)
            r4.append(r2)
            r4.append(r9)
            r4.append(r2)
            com.wushuangtech.api.ExternalVideoModuleCallback$VideoFrameType r8 = r10.frameType
            int r8 = r8.ordinal()
            r4.append(r8)
            r4.append(r2)
            r4.append(r1)
            r4.append(r2)
            int r8 = r10.width
            r4.append(r8)
            r4.append(r2)
            int r8 = r10.height
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            r3.mMessage = r8
            com.wushuangtech.bean.FastLogCacheBean r8 = r7.mRecvVideoDataWatcher
            com.wushuangtech.utils.OmniLog.fd(r8)
            return
        L_0x0078:
            int r3 = r7.getRecvFrameRate(r9)     // Catch:{ all -> 0x00cc }
            r10.recvFrameRate = r3     // Catch:{ all -> 0x00cc }
            r4.onGetH264Frame(r10)     // Catch:{ all -> 0x00cc }
            if (r4 == 0) goto L_0x008b
            int r1 = r4.hashCode()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x008b:
            com.wushuangtech.bean.FastLogCacheBean r3 = r7.mRecvVideoDataWatcher
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            r4.append(r8)
            r4.append(r2)
            r4.append(r9)
            r4.append(r2)
            com.wushuangtech.api.ExternalVideoModuleCallback$VideoFrameType r8 = r10.frameType
            int r8 = r8.ordinal()
            r4.append(r8)
            r4.append(r2)
            r4.append(r1)
            r4.append(r2)
            int r8 = r10.width
            r4.append(r8)
            r4.append(r2)
            int r8 = r10.height
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            r3.mMessage = r8
            com.wushuangtech.bean.FastLogCacheBean r8 = r7.mRecvVideoDataWatcher
            com.wushuangtech.utils.OmniLog.fd(r8)
            return
        L_0x00cc:
            r3 = move-exception
            goto L_0x00e0
        L_0x00ce:
            java.lang.String r4 = "Manager not init..."
            r7.logE(r4)     // Catch:{ all -> 0x00dc }
            com.wushuangtech.bean.FastLogCacheBean r3 = r7.mRecvVideoDataWatcher
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            goto L_0x003e
        L_0x00dc:
            r4 = move-exception
            r6 = r4
            r4 = r3
            r3 = r6
        L_0x00e0:
            if (r4 == 0) goto L_0x00ea
            int r1 = r4.hashCode()
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
        L_0x00ea:
            com.wushuangtech.bean.FastLogCacheBean r4 = r7.mRecvVideoDataWatcher
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            r5.append(r8)
            r5.append(r2)
            r5.append(r9)
            r5.append(r2)
            com.wushuangtech.api.ExternalVideoModuleCallback$VideoFrameType r8 = r10.frameType
            int r8 = r8.ordinal()
            r5.append(r8)
            r5.append(r2)
            r5.append(r1)
            r5.append(r2)
            int r8 = r10.width
            r5.append(r8)
            r5.append(r2)
            int r8 = r10.height
            r5.append(r8)
            java.lang.String r8 = r5.toString()
            r4.mMessage = r8
            com.wushuangtech.bean.FastLogCacheBean r8 = r7.mRecvVideoDataWatcher
            com.wushuangtech.utils.OmniLog.fd(r8)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.videocore.VideoDecoderManager.addVideoData(java.lang.String, java.lang.String, com.wushuangtech.library.video.bean.VideoFrame):void");
    }

    private int getRecvFrameRate(String str) {
        ConcurrentHashMap<String, VideoRecvFrameRateBean> concurrentHashMap = this.mVideoRecvFrameRates;
        if (concurrentHashMap == null) {
            return 0;
        }
        VideoRecvFrameRateBean videoRecvFrameRateBean = concurrentHashMap.get(str);
        if (videoRecvFrameRateBean == null) {
            videoRecvFrameRateBean = new VideoRecvFrameRateBean();
            videoRecvFrameRateBean.mLastRecvTime = System.currentTimeMillis();
            concurrentHashMap.put(str, videoRecvFrameRateBean);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - videoRecvFrameRateBean.mLastRecvTime >= 1000) {
                videoRecvFrameRateBean.mRecvFrameRate = (int) (videoRecvFrameRateBean.mRecvFrames - videoRecvFrameRateBean.mLastRecvFrames);
                videoRecvFrameRateBean.mLastRecvTime = currentTimeMillis;
                videoRecvFrameRateBean.mLastRecvFrames = videoRecvFrameRateBean.mRecvFrames;
            }
        }
        videoRecvFrameRateBean.mRecvFrames++;
        return videoRecvFrameRateBean.mRecvFrameRate;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008d, code lost:
        if (r2 == null) goto L_0x00b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008f, code lost:
        logI("stop video decoder, id : " + r7 + " | " + java.lang.Integer.toHexString(r2.hashCode()));
        r2.uninitialize();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b6, code lost:
        r2 = r6.mLock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b8, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        r1 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c2, code lost:
        if (r1.hasNext() == false) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00d0, code lost:
        if (r7.equals(r1.next().mDeviceId) == false) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00d3, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d6, code lost:
        r4 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d7, code lost:
        if (r4 == -1) goto L_0x00fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d9, code lost:
        r0.remove(r4);
        logD("remove video render bean : " + r4 + " | " + r0.size());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00fc, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void closeVideoDecoder(java.lang.String r7) {
        /*
            r6 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            java.util.List<com.wushuangtech.bean.VideoRenderBean> r0 = r6.mVideoRenderBeans
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.wushuangtech.videocore.VideoDecoder> r1 = r6.mDecodes
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.wushuangtech.videocore.bean.VideoRecvFrameRateBean> r2 = r6.mVideoRecvFrameRates
            java.lang.String r3 = "all"
            boolean r3 = r3.equals(r7)
            r4 = 0
            if (r3 == 0) goto L_0x007b
            java.lang.Object r3 = r6.mLock
            monitor-enter(r3)
            r5 = 0
            r6.mDecodes = r5     // Catch:{ all -> 0x0078 }
            r6.mVideoRecvFrameRates = r5     // Catch:{ all -> 0x0078 }
            r6.mVideoRenderBeans = r5     // Catch:{ all -> 0x0078 }
            r6.mIsInit = r4     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x0027
            r0.clear()     // Catch:{ all -> 0x0078 }
        L_0x0027:
            monitor-exit(r3)     // Catch:{ all -> 0x0078 }
            if (r1 == 0) goto L_0x0071
            java.util.Set r0 = r1.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0032:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x006e
            java.lang.Object r3 = r0.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r3 = r3.getValue()
            com.wushuangtech.videocore.VideoDecoder r3 = (com.wushuangtech.videocore.VideoDecoder) r3
            if (r3 == 0) goto L_0x0032
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "stop video decoder, id : "
            r4.append(r5)
            r4.append(r7)
            java.lang.String r5 = " | "
            r4.append(r5)
            int r5 = r3.hashCode()
            java.lang.String r5 = java.lang.Integer.toHexString(r5)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r6.logI(r4)
            r3.uninitialize()
            goto L_0x0032
        L_0x006e:
            r1.clear()
        L_0x0071:
            if (r2 == 0) goto L_0x00fd
            r2.clear()
            goto L_0x00fd
        L_0x0078:
            r7 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0078 }
            throw r7
        L_0x007b:
            java.lang.Object r1 = r6.mLock
            monitor-enter(r1)
            boolean r2 = r6.mIsInit     // Catch:{ all -> 0x0101 }
            if (r2 != 0) goto L_0x0084
            monitor-exit(r1)     // Catch:{ all -> 0x0101 }
            return
        L_0x0084:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.wushuangtech.videocore.VideoDecoder> r2 = r6.mDecodes     // Catch:{ all -> 0x0101 }
            java.lang.Object r2 = r2.remove(r7)     // Catch:{ all -> 0x0101 }
            com.wushuangtech.videocore.VideoDecoder r2 = (com.wushuangtech.videocore.VideoDecoder) r2     // Catch:{ all -> 0x0101 }
            monitor-exit(r1)     // Catch:{ all -> 0x0101 }
            if (r2 == 0) goto L_0x00b6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "stop video decoder, id : "
            r1.append(r3)
            r1.append(r7)
            java.lang.String r3 = " | "
            r1.append(r3)
            int r3 = r2.hashCode()
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r6.logI(r1)
            r2.uninitialize()
        L_0x00b6:
            java.lang.Object r2 = r6.mLock
            monitor-enter(r2)
            java.util.Iterator r1 = r0.iterator()     // Catch:{ all -> 0x00fe }
        L_0x00bd:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x00fe }
            r5 = -1
            if (r3 == 0) goto L_0x00d6
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x00fe }
            com.wushuangtech.bean.VideoRenderBean r3 = (com.wushuangtech.bean.VideoRenderBean) r3     // Catch:{ all -> 0x00fe }
            java.lang.String r3 = r3.mDeviceId     // Catch:{ all -> 0x00fe }
            boolean r3 = r7.equals(r3)     // Catch:{ all -> 0x00fe }
            if (r3 == 0) goto L_0x00d3
            goto L_0x00d7
        L_0x00d3:
            int r4 = r4 + 1
            goto L_0x00bd
        L_0x00d6:
            r4 = r5
        L_0x00d7:
            if (r4 == r5) goto L_0x00fc
            r0.remove(r4)     // Catch:{ all -> 0x00fe }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fe }
            r7.<init>()     // Catch:{ all -> 0x00fe }
            java.lang.String r1 = "remove video render bean : "
            r7.append(r1)     // Catch:{ all -> 0x00fe }
            r7.append(r4)     // Catch:{ all -> 0x00fe }
            java.lang.String r1 = " | "
            r7.append(r1)     // Catch:{ all -> 0x00fe }
            int r0 = r0.size()     // Catch:{ all -> 0x00fe }
            r7.append(r0)     // Catch:{ all -> 0x00fe }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00fe }
            r6.logD(r7)     // Catch:{ all -> 0x00fe }
        L_0x00fc:
            monitor-exit(r2)     // Catch:{ all -> 0x00fe }
        L_0x00fd:
            return
        L_0x00fe:
            r7 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00fe }
            throw r7
        L_0x0101:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0101 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.videocore.VideoDecoderManager.closeVideoDecoder(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a7, code lost:
        if (r5 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00a9, code lost:
        logI("Decoder is ready! notify video size...");
        r9.onVideoDataSize(r2.mVideoWidth, r2.mVideoHeight);
        r2.mVideoSizeSetting = true;
        logI("Decoder is ready! notify video surface texture...");
        r9.onVideoTexture();
        r2.mTextureSetting = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void registerVideoView(long r5, java.lang.String r7, java.lang.String r8, com.wushuangtech.inter.OnVideoDecoderSettingSizeToViewCallBack r9) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Executing regist video view... "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = " | "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r1 = " | "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            r4.logI(r0)
            java.lang.Object r0 = r4.mLock
            monitor-enter(r0)
            java.util.List<com.wushuangtech.bean.VideoRenderBean> r1 = r4.mVideoRenderBeans     // Catch:{ all -> 0x00c2 }
            if (r1 != 0) goto L_0x002d
            monitor-exit(r0)     // Catch:{ all -> 0x00c2 }
            return
        L_0x002d:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00c2 }
        L_0x0031:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x00c2 }
            if (r2 == 0) goto L_0x0046
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x00c2 }
            com.wushuangtech.bean.VideoRenderBean r2 = (com.wushuangtech.bean.VideoRenderBean) r2     // Catch:{ all -> 0x00c2 }
            java.lang.String r3 = r2.mDeviceId     // Catch:{ all -> 0x00c2 }
            boolean r3 = r7.equals(r3)     // Catch:{ all -> 0x00c2 }
            if (r3 == 0) goto L_0x0031
            goto L_0x0047
        L_0x0046:
            r2 = 0
        L_0x0047:
            if (r2 != 0) goto L_0x0062
            java.lang.String r1 = "View is ready! not find VideoRenderBean ... "
            r4.logI(r1)     // Catch:{ all -> 0x00c2 }
            com.wushuangtech.bean.VideoRenderBean r1 = new com.wushuangtech.bean.VideoRenderBean     // Catch:{ all -> 0x00c2 }
            r1.<init>()     // Catch:{ all -> 0x00c2 }
            r1.mUserId = r5     // Catch:{ all -> 0x00c2 }
            r1.mDeviceId = r7     // Catch:{ all -> 0x00c2 }
            r1.mViewAddress = r8     // Catch:{ all -> 0x00c2 }
            r1.mOnVideoDecoderSettingSizeToViewCallBack = r9     // Catch:{ all -> 0x00c2 }
            java.util.List<com.wushuangtech.bean.VideoRenderBean> r5 = r4.mVideoRenderBeans     // Catch:{ all -> 0x00c2 }
            r5.add(r1)     // Catch:{ all -> 0x00c2 }
            monitor-exit(r0)     // Catch:{ all -> 0x00c2 }
            return
        L_0x0062:
            r2.mUserId = r5     // Catch:{ all -> 0x00c2 }
            r2.mViewAddress = r8     // Catch:{ all -> 0x00c2 }
            r2.mOnVideoDecoderSettingSizeToViewCallBack = r9     // Catch:{ all -> 0x00c2 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c2 }
            r5.<init>()     // Catch:{ all -> 0x00c2 }
            java.lang.String r6 = "View is ready! find decoder... "
            r5.append(r6)     // Catch:{ all -> 0x00c2 }
            java.lang.String r6 = r2.mVideoDecoderAddress     // Catch:{ all -> 0x00c2 }
            r5.append(r6)     // Catch:{ all -> 0x00c2 }
            java.lang.String r6 = " | "
            r5.append(r6)     // Catch:{ all -> 0x00c2 }
            int r6 = r2.mVideoWidth     // Catch:{ all -> 0x00c2 }
            r5.append(r6)     // Catch:{ all -> 0x00c2 }
            java.lang.String r6 = " | "
            r5.append(r6)     // Catch:{ all -> 0x00c2 }
            int r6 = r2.mVideoHeight     // Catch:{ all -> 0x00c2 }
            r5.append(r6)     // Catch:{ all -> 0x00c2 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00c2 }
            r4.logI(r5)     // Catch:{ all -> 0x00c2 }
            java.lang.String r5 = r2.mVideoDecoderAddress     // Catch:{ all -> 0x00c2 }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00c2 }
            r6 = 1
            if (r5 != 0) goto L_0x00a5
            int r5 = r2.mVideoWidth     // Catch:{ all -> 0x00c2 }
            if (r5 == 0) goto L_0x00a5
            int r5 = r2.mVideoHeight     // Catch:{ all -> 0x00c2 }
            if (r5 == 0) goto L_0x00a5
            r5 = r6
            goto L_0x00a6
        L_0x00a5:
            r5 = 0
        L_0x00a6:
            monitor-exit(r0)     // Catch:{ all -> 0x00c2 }
            if (r5 == 0) goto L_0x00c1
            java.lang.String r5 = "Decoder is ready! notify video size..."
            r4.logI(r5)
            int r5 = r2.mVideoWidth
            int r7 = r2.mVideoHeight
            r9.onVideoDataSize(r5, r7)
            r2.mVideoSizeSetting = r6
            java.lang.String r5 = "Decoder is ready! notify video surface texture..."
            r4.logI(r5)
            r9.onVideoTexture()
            r2.mTextureSetting = r6
        L_0x00c1:
            return
        L_0x00c2:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c2 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.videocore.VideoDecoderManager.registerVideoView(long, java.lang.String, java.lang.String, com.wushuangtech.inter.OnVideoDecoderSettingSizeToViewCallBack):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0044, code lost:
        if (r5 != null) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        logI("Decoder is ready! notify video size...");
        r5.onVideoDataSize(r7, r8);
        r2.mVideoSizeSetting = true;
        logI("Decoder is ready! notify video surface texture...");
        r5.onVideoTexture();
        r2.mTextureSetting = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void registerVideoDecoder(java.lang.String r5, java.lang.String r6, int r7, int r8) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.mLock
            monitor-enter(r0)
            java.util.List<com.wushuangtech.bean.VideoRenderBean> r1 = r4.mVideoRenderBeans     // Catch:{ all -> 0x005d }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return
        L_0x0009:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x005d }
        L_0x000d:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x0022
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x005d }
            com.wushuangtech.bean.VideoRenderBean r2 = (com.wushuangtech.bean.VideoRenderBean) r2     // Catch:{ all -> 0x005d }
            java.lang.String r3 = r2.mDeviceId     // Catch:{ all -> 0x005d }
            boolean r3 = r5.equals(r3)     // Catch:{ all -> 0x005d }
            if (r3 == 0) goto L_0x000d
            goto L_0x0023
        L_0x0022:
            r2 = 0
        L_0x0023:
            if (r2 != 0) goto L_0x0039
            com.wushuangtech.bean.VideoRenderBean r1 = new com.wushuangtech.bean.VideoRenderBean     // Catch:{ all -> 0x005d }
            r1.<init>()     // Catch:{ all -> 0x005d }
            r1.mDeviceId = r5     // Catch:{ all -> 0x005d }
            r1.mVideoDecoderAddress = r6     // Catch:{ all -> 0x005d }
            r1.mVideoWidth = r7     // Catch:{ all -> 0x005d }
            r1.mVideoHeight = r8     // Catch:{ all -> 0x005d }
            java.util.List<com.wushuangtech.bean.VideoRenderBean> r5 = r4.mVideoRenderBeans     // Catch:{ all -> 0x005d }
            r5.add(r1)     // Catch:{ all -> 0x005d }
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return
        L_0x0039:
            r2.mDeviceId = r5     // Catch:{ all -> 0x005d }
            r2.mVideoDecoderAddress = r6     // Catch:{ all -> 0x005d }
            r2.mVideoWidth = r7     // Catch:{ all -> 0x005d }
            r2.mVideoHeight = r8     // Catch:{ all -> 0x005d }
            com.wushuangtech.inter.OnVideoDecoderSettingSizeToViewCallBack r5 = r2.mOnVideoDecoderSettingSizeToViewCallBack     // Catch:{ all -> 0x005d }
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            if (r5 != 0) goto L_0x0047
            return
        L_0x0047:
            java.lang.String r6 = "Decoder is ready! notify video size..."
            r4.logI(r6)
            r5.onVideoDataSize(r7, r8)
            r6 = 1
            r2.mVideoSizeSetting = r6
            java.lang.String r7 = "Decoder is ready! notify video surface texture..."
            r4.logI(r7)
            r5.onVideoTexture()
            r2.mTextureSetting = r6
            return
        L_0x005d:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.videocore.VideoDecoderManager.registerVideoDecoder(java.lang.String, java.lang.String, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0041, code lost:
        r0 = r0.get(r9);
        logI("[HardwareDecoderChange] - New surface texture coming... surface texture : " + r8 + " | " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0063, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0065, code lost:
        r0.setSurfaceTexture(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void registerSurfaceTexture(android.graphics.SurfaceTexture r8, java.lang.String r9) {
        /*
            r7 = this;
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.wushuangtech.videocore.VideoDecoder> r0 = r7.mDecodes
            java.util.List<com.wushuangtech.bean.VideoRenderBean> r1 = r7.mVideoRenderBeans
            if (r0 == 0) goto L_0x006c
            if (r1 != 0) goto L_0x0009
            goto L_0x006c
        L_0x0009:
            java.lang.Object r2 = r7.mLock
            monitor-enter(r2)
            r3 = 0
            java.util.Iterator r4 = r1.iterator()     // Catch:{ all -> 0x0069 }
        L_0x0011:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0069 }
            if (r5 == 0) goto L_0x0026
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0069 }
            com.wushuangtech.bean.VideoRenderBean r5 = (com.wushuangtech.bean.VideoRenderBean) r5     // Catch:{ all -> 0x0069 }
            java.lang.String r6 = r5.mDeviceId     // Catch:{ all -> 0x0069 }
            boolean r6 = r9.equals(r6)     // Catch:{ all -> 0x0069 }
            if (r6 == 0) goto L_0x0011
            r3 = r5
        L_0x0026:
            int r4 = r8.hashCode()     // Catch:{ all -> 0x0069 }
            java.lang.String r4 = java.lang.Integer.toHexString(r4)     // Catch:{ all -> 0x0069 }
            if (r3 != 0) goto L_0x003e
            com.wushuangtech.bean.VideoRenderBean r8 = new com.wushuangtech.bean.VideoRenderBean     // Catch:{ all -> 0x0069 }
            r8.<init>()     // Catch:{ all -> 0x0069 }
            r8.mDeviceId = r9     // Catch:{ all -> 0x0069 }
            r8.mTextureAddress = r4     // Catch:{ all -> 0x0069 }
            r1.add(r8)     // Catch:{ all -> 0x0069 }
            monitor-exit(r2)     // Catch:{ all -> 0x0069 }
            return
        L_0x003e:
            r3.mTextureAddress = r4     // Catch:{ all -> 0x0069 }
            monitor-exit(r2)     // Catch:{ all -> 0x0069 }
            java.lang.Object r0 = r0.get(r9)
            com.wushuangtech.videocore.VideoDecoder r0 = (com.wushuangtech.videocore.VideoDecoder) r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "[HardwareDecoderChange] - New surface texture coming... surface texture : "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r2 = " | "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r7.logI(r9)
            if (r0 == 0) goto L_0x0068
            r0.setSurfaceTexture(r8)
        L_0x0068:
            return
        L_0x0069:
            r8 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0069 }
            throw r8
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.videocore.VideoDecoderManager.registerSurfaceTexture(android.graphics.SurfaceTexture, java.lang.String):void");
    }

    public void setVideoSurfaceTexture(String str, SurfaceTexture surfaceTexture) {
        VideoDecoder videoDecoder;
        ConcurrentHashMap<String, VideoDecoder> concurrentHashMap = this.mDecodes;
        if (concurrentHashMap != null && (videoDecoder = concurrentHashMap.get(str)) != null) {
            logI("Executing decoder ready notify, setting surface texture... " + surfaceTexture + " | " + str);
            videoDecoder.setSurfaceTexture(surfaceTexture);
        }
    }

    public void receiveVideoRenderFinish(String str) {
        VideoDecoder videoDecoder;
        ConcurrentHashMap<String, VideoDecoder> concurrentHashMap = this.mDecodes;
        if (concurrentHashMap != null && (videoDecoder = concurrentHashMap.get(str)) != null) {
            videoDecoder.receiveVideoRenderFinish();
        }
    }

    private void logI(String str) {
        String str2 = TAG;
        OmniLog.rv_i(str2, str + " | thread id : " + Thread.currentThread().getId());
    }

    private void logD(String str) {
        String str2 = TAG;
        OmniLog.rv_d(str2, str + " | thread id : " + Thread.currentThread().getId());
    }

    private void logE(String str) {
        String str2 = TAG;
        OmniLog.rv_e(str2, str + " | thread id : " + Thread.currentThread().getId());
    }

    public VideoDecoder getVideoDecoder(UserDeviceConfig userDeviceConfig) {
        ConcurrentHashMap<String, VideoDecoder> concurrentHashMap;
        if (userDeviceConfig == null) {
            return null;
        }
        String deviceId = userDeviceConfig.getDeviceId();
        if (!TextUtils.isEmpty(deviceId) && (concurrentHashMap = this.mDecodes) != null) {
            return concurrentHashMap.get(deviceId);
        }
        return null;
    }

    public void resetVideoDecoderFirstReportFlag(String str) {
        ConcurrentHashMap<String, VideoDecoder> concurrentHashMap = this.mDecodes;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, VideoDecoder> value : concurrentHashMap.entrySet()) {
                VideoDecoder videoDecoder = (VideoDecoder) value.getValue();
                if (videoDecoder != null) {
                    videoDecoder.resetReportFirstDecoded(str);
                }
            }
        }
    }

    public void changeVideoDecoderType(boolean z) {
        ConcurrentHashMap<String, VideoDecoder> concurrentHashMap = this.mDecodes;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, VideoDecoder> value : concurrentHashMap.entrySet()) {
                VideoDecoder videoDecoder = (VideoDecoder) value.getValue();
                if (videoDecoder != null) {
                    videoDecoder.setDecoderType(z);
                }
            }
        }
    }

    public void testDecoderCreateEarly(String str, long j, String str2, int i, int i2) {
        VideoDecoder videoDecoder = new VideoDecoder(str, j, str2);
        videoDecoder.setDecoderType(GlobalConfig.mForceVideoSoftDecoder);
        videoDecoder.setVideoSize(i, i2);
        videoDecoder.setOnVideoDecoderHardwareListener(((MyVideoApiImpl) MyVideoApi.getInstance()).getVideoDecoderHardwareModel());
        synchronized (this.mLock) {
            ConcurrentHashMap<String, VideoDecoder> concurrentHashMap = this.mDecodes;
            if (concurrentHashMap != null) {
                concurrentHashMap.put(str2, videoDecoder);
            }
        }
    }

    public void updateVideoDecoderSpentTime() {
        ConcurrentHashMap<String, VideoDecoder> concurrentHashMap = this.mDecodes;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, VideoDecoder> value : concurrentHashMap.entrySet()) {
                VideoDecoder videoDecoder = (VideoDecoder) value.getValue();
                if (videoDecoder != null) {
                    videoDecoder.updateDecoderSpentTime();
                }
            }
        }
    }
}
