package com.wushuangtech.thread;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.wushuangtech.api.ExternalAudioModule;
import com.wushuangtech.api.ExternalVideoModule;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.handler.NetworkQualityHandler;
import com.wushuangtech.inter.RtcGlobalAVInterface;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.GlobalVideoConfig;
import com.wushuangtech.library.video.VideoStatistical;
import com.wushuangtech.library.video.bean.VideoRemoteStatsBean;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.utils.PhoneUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WorkerThread extends Thread {
    private static final int ACTION_WORKER_AV_STATUS = 4114;
    private static final int ACTION_WORKER_COMMON_INTERVAL_10 = 4116;
    private static final int ACTION_WORKER_COMMON_INTERVAL_2 = 4115;
    private static final int ACTION_WORKER_THREAD_QUIT = 4112;
    private static final int INTERVAL_10 = 10000;
    private static final int INTERVAL_2 = 2000;
    private static final String TAG = "WorkerThread";
    private final StringBuilder mBuildStatsStr = new StringBuilder();
    private boolean mFirstCalcAVStatus = true;
    private int mLastNetworkType;
    private boolean mReady;
    private final StringBuilder mStatsStr = new StringBuilder();
    private WorkerThreadHandler mWorkerHandler;

    public final void waitForReady() {
        while (!this.mReady) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            OmniLog.i(TAG, "wait for " + TAG);
        }
    }

    public void run() {
        OmniLog.i(TAG, "start to run");
        Looper.prepare();
        this.mWorkerHandler = new WorkerThreadHandler(this);
        this.mReady = true;
        startAVStatus();
        Looper.loop();
    }

    public final void exit() {
        if (Thread.currentThread() != this) {
            OmniLog.w(TAG, "exit() - exit app thread asynchronously");
            this.mWorkerHandler.sendEmptyMessage(ACTION_WORKER_THREAD_QUIT);
            return;
        }
        OmniLog.i(TAG, "exit() > start");
        this.mReady = false;
        stopAVStatus();
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            myLooper.quit();
        }
        this.mWorkerHandler.release();
        this.mLastNetworkType = 0;
        OmniLog.i(TAG, "exit() > end");
    }

    private void startAVStatus() {
        this.mWorkerHandler.sendEmptyMessageDelayed(ACTION_WORKER_AV_STATUS, 1000);
        this.mWorkerHandler.sendEmptyMessageDelayed(ACTION_WORKER_COMMON_INTERVAL_2, 2000);
        this.mWorkerHandler.sendEmptyMessageDelayed(ACTION_WORKER_COMMON_INTERVAL_10, 10000);
    }

    private void stopAVStatus() {
        this.mWorkerHandler.removeMessages(ACTION_WORKER_AV_STATUS);
        this.mWorkerHandler.removeMessages(ACTION_WORKER_COMMON_INTERVAL_2);
        this.mWorkerHandler.removeMessages(ACTION_WORKER_COMMON_INTERVAL_10);
        RtcGlobalAVInterface globalAVInterface = GlobalHolder.getInstance().getGlobalAVInterface();
        if (globalAVInterface != null) {
            globalAVInterface.resetAVStatistical();
        }
    }

    private static final class WorkerThreadHandler extends Handler {
        private WeakReference<WorkerThread> mWorkerThreadRef;

        WorkerThreadHandler(WorkerThread workerThread) {
            this.mWorkerThreadRef = new WeakReference<>(workerThread);
        }

        /* access modifiers changed from: private */
        public void release() {
            this.mWorkerThreadRef = null;
        }

        public void handleMessage(Message message) {
            AsynchronousInstrumentation.handlerMessageBegin(this, message);
            WeakReference<WorkerThread> weakReference = this.mWorkerThreadRef;
            if (weakReference == null) {
                OmniLog.w(WorkerThread.TAG, "handler is already released! " + message.what);
                AsynchronousInstrumentation.handlerMessageEnd();
                return;
            }
            WorkerThread workerThread = (WorkerThread) weakReference.get();
            if (workerThread == null) {
                AsynchronousInstrumentation.handlerMessageEnd();
                return;
            }
            switch (message.what) {
                case WorkerThread.ACTION_WORKER_THREAD_QUIT /*4112*/:
                    workerThread.exit();
                    break;
                case WorkerThread.ACTION_WORKER_AV_STATUS /*4114*/:
                    workerThread.handleAVStatus();
                    workerThread.handleOtherJob();
                    sendEmptyMessageDelayed(WorkerThread.ACTION_WORKER_AV_STATUS, 1000);
                    break;
                case WorkerThread.ACTION_WORKER_COMMON_INTERVAL_2 /*4115*/:
                    workerThread.handleJobForInternal_2();
                    sendEmptyMessageDelayed(WorkerThread.ACTION_WORKER_COMMON_INTERVAL_2, 2000);
                    break;
                case WorkerThread.ACTION_WORKER_COMMON_INTERVAL_10 /*4116*/:
                    workerThread.handleJobForInternal_10();
                    sendEmptyMessageDelayed(WorkerThread.ACTION_WORKER_COMMON_INTERVAL_10, 10000);
                    break;
            }
            AsynchronousInstrumentation.handlerMessageEnd();
        }
    }

    /* access modifiers changed from: private */
    public void handleAVStatus() {
        RtcGlobalAVInterface globalAVInterface;
        if (GlobalHolder.getInstance().isJoinedChannel() && (globalAVInterface = GlobalHolder.getInstance().getGlobalAVInterface()) != null) {
            if (this.mFirstCalcAVStatus) {
                this.mFirstCalcAVStatus = false;
                globalAVInterface.startAVStatistical();
            }
            globalAVInterface.updateAVStatistical();
            globalAVInterface.reportAVStatistical();
        }
    }

    /* access modifiers changed from: private */
    public void handleOtherJob() {
        VideoStatistical globalVideoStatistical = GlobalHolder.getInstance().getGlobalVideoStatistical();
        if (globalVideoStatistical != null) {
            globalVideoStatistical.updateVideoStats();
        }
        Context context = GlobalHolder.getInstance().getContext();
        if (context != null) {
            checkNetworkType(context);
        }
    }

    /* access modifiers changed from: private */
    public void handleJobForInternal_2() {
        if (GlobalHolder.getInstance().isJoinedChannel()) {
            ExternalVideoModule.getInstance().updateVideoDecoderSpentTime();
            NetworkQualityHandler netQualityHandler = GlobalHolder.getInstance().getNetQualityHandler();
            if (netQualityHandler != null) {
                netQualityHandler.updateNetQuality();
            }
            checkAudioPcmDirExist(LocalSDKConstants.VIDEO_RAW_DATA_SAVE_AUDIO_DIR);
        }
    }

    /* access modifiers changed from: private */
    public void handleJobForInternal_10() {
        GlobalVideoConfig globalVideoConfig;
        if (GlobalHolder.getInstance().isJoinedChannel() && (globalVideoConfig = GlobalHolder.getInstance().getGlobalVideoConfig()) != null) {
            String arrays = Arrays.toString(globalVideoConfig.getVideoLocalRawReportFps());
            ConcurrentHashMap<String, LongSparseArray<VideoRemoteStatsBean>> userDecodeStatsMap = globalVideoConfig.getUserDecodeStatsMap();
            try {
                String str = "VideoRawDataReportStatus Local={" + arrays + "}" + (userDecodeStatsMap != null ? buildVideoDecodedFrameReportStatusStr(userDecodeStatsMap) : "");
                if (!TextUtils.isEmpty(str)) {
                    OmniLog.i(TAG, str);
                }
            } catch (Exception unused) {
            }
        }
    }

    private void checkNetworkType(Context context) {
        int networkType = PhoneUtils.getNetworkType(context);
        GlobalConfig.mNetworkType = networkType;
        if (isMobileNetworkType(networkType)) {
            if (this.mLastNetworkType == LocalSDKConstants.PHONE_NETWORK_WIFI) {
                RoomJni.getInstance().UpdateNetworkType(networkType);
            }
            this.mLastNetworkType = networkType;
        } else if (networkType == LocalSDKConstants.PHONE_NETWORK_WIFI) {
            if (isMobileNetworkType(this.mLastNetworkType)) {
                RoomJni.getInstance().UpdateNetworkType(networkType);
            }
            this.mLastNetworkType = networkType;
        }
    }

    private void checkAudioPcmDirExist(String str) {
        File externalFilesDir;
        try {
            Context context = GlobalHolder.getInstance().getContext();
            if (context != null && (externalFilesDir = context.getExternalFilesDir((String) null)) != null) {
                if (externalFilesDir.exists()) {
                    File file = new File(externalFilesDir.getAbsolutePath() + File.separator + LocalSDKConstants.VIDEO_RAW_DATA_SAVE_ROOT_DIR);
                    if (file.exists() || (file.mkdirs() && file.exists())) {
                        File file2 = new File(file, str);
                        ExternalAudioModule.getInstance().enableAudioPcmWriteFile(file2.exists(), file2.getAbsolutePath());
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private String buildVideoDecodedFrameReportStatusStr(ConcurrentHashMap<String, LongSparseArray<VideoRemoteStatsBean>> concurrentHashMap) {
        String invokedMethodNameWithFormat = OmniLog.getInvokedMethodNameWithFormat();
        try {
            StringBuilder sb = this.mStatsStr;
            int i = 0;
            sb.delete(0, sb.length());
            for (Map.Entry next : concurrentHashMap.entrySet()) {
                String str = (String) next.getKey();
                LongSparseArray longSparseArray = (LongSparseArray) next.getValue();
                if (!TextUtils.isEmpty(str)) {
                    if (longSparseArray != null) {
                        if (i == 0) {
                            StringBuilder sb2 = this.mStatsStr;
                            sb2.append(", {");
                            sb2.append(str);
                            sb2.append('=');
                            sb2.append(buildVideoDecoderStatsBeanStr(longSparseArray));
                        } else {
                            StringBuilder sb3 = this.mStatsStr;
                            sb3.append(',');
                            sb3.append(' ');
                            sb3.append(str);
                            sb3.append('=');
                            sb3.append(buildVideoDecoderStatsBeanStr(longSparseArray));
                            sb3.append(',');
                            sb3.append(' ');
                        }
                        i++;
                    }
                }
            }
            this.mStatsStr.append('}');
            return this.mStatsStr.toString();
        } catch (Exception e) {
            OmniLog.e(TAG, invokedMethodNameWithFormat + "exception = " + e.getLocalizedMessage());
            return "";
        }
    }

    private String buildVideoDecoderStatsBeanStr(LongSparseArray<VideoRemoteStatsBean> longSparseArray) {
        StringBuilder sb = this.mBuildStatsStr;
        sb.delete(0, sb.length());
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            long keyAt = longSparseArray.keyAt(i);
            VideoRemoteStatsBean valueAt = longSparseArray.valueAt(i);
            if (valueAt != null) {
                if (i == 0) {
                    StringBuilder sb2 = this.mBuildStatsStr;
                    sb2.append('[');
                    sb2.append(keyAt);
                    sb2.append('=');
                    sb2.append(valueAt.mDecodedFrameReportRate);
                    if (size == 1) {
                        this.mBuildStatsStr.append(']');
                    } else {
                        StringBuilder sb3 = this.mBuildStatsStr;
                        sb3.append(',');
                        sb3.append(' ');
                    }
                } else if (i == size - 1) {
                    StringBuilder sb4 = this.mBuildStatsStr;
                    sb4.append(keyAt);
                    sb4.append('=');
                    sb4.append(valueAt.mDecodedFrameReportRate);
                    this.mBuildStatsStr.append(']');
                } else {
                    StringBuilder sb5 = this.mBuildStatsStr;
                    sb5.append(keyAt);
                    sb5.append('=');
                    sb5.append(valueAt.mDecodedFrameReportRate);
                    sb5.append(',');
                    sb5.append(' ');
                }
            }
        }
        return this.mBuildStatsStr.toString();
    }

    private boolean isMobileNetworkType(int i) {
        return i == LocalSDKConstants.PHONE_NETWORK_2G || i == LocalSDKConstants.PHONE_NETWORK_3G || i == LocalSDKConstants.PHONE_NETWORK_4G || i == LocalSDKConstants.PHONE_NETWORK_5G;
    }
}
