package com.dianping.logan;

import android.os.Looper;
import android.text.TextUtils;
import com.dianping.logan.LoganModel;
import java.io.File;
import java.util.concurrent.ConcurrentLinkedQueue;

class LoganControlCenter {
    private static LoganControlCenter sLoganControlCenter;
    private ConcurrentLinkedQueue<LoganModel> mCacheLogQueue = new ConcurrentLinkedQueue<>();
    private String mCachePath;
    private String mEncryptIv16;
    private String mEncryptKey16;
    private LoganThread mLoganThread;
    private long mMaxLogFile;
    private long mMaxQueue;
    private long mMinSDCard;
    private String mPath;
    private long mSaveTime;

    private LoganControlCenter(LoganConfig loganConfig) {
        if (loganConfig.isValid()) {
            this.mPath = loganConfig.mPathPath;
            this.mCachePath = loganConfig.mCachePath;
            this.mSaveTime = loganConfig.mDay;
            this.mMinSDCard = loganConfig.mMinSDCard;
            this.mMaxLogFile = loganConfig.mMaxFile;
            this.mMaxQueue = loganConfig.mMaxQueue;
            this.mEncryptKey16 = new String(loganConfig.mEncryptKey16);
            this.mEncryptIv16 = new String(loganConfig.mEncryptIv16);
            init();
            return;
        }
        throw new NullPointerException("config's param is invalid");
    }

    private void init() {
        if (this.mLoganThread == null) {
            LoganThread loganThread = new LoganThread(this.mCacheLogQueue, this.mCachePath, this.mPath, this.mSaveTime, this.mMaxLogFile, this.mMinSDCard, this.mEncryptKey16, this.mEncryptIv16);
            this.mLoganThread = loganThread;
            loganThread.setName("logan-thread");
            this.mLoganThread.start();
        }
    }

    static LoganControlCenter instance(LoganConfig loganConfig) {
        if (sLoganControlCenter == null) {
            synchronized (LoganControlCenter.class) {
                if (sLoganControlCenter == null) {
                    sLoganControlCenter = new LoganControlCenter(loganConfig);
                }
            }
        }
        return sLoganControlCenter;
    }

    /* access modifiers changed from: package-private */
    public void write(String str, int i) {
        write(str, i, "", "", "", 0);
    }

    /* access modifiers changed from: package-private */
    public void write(String str, int i, String str2, String str3, String str4, int i2) {
        if (!TextUtils.isEmpty(str)) {
            LoganModel loganModel = new LoganModel();
            loganModel.action = LoganModel.Action.WRITE;
            WriteAction writeAction = new WriteAction();
            String name = Thread.currentThread().getName();
            long id = Thread.currentThread().getId();
            boolean z = false;
            if (Looper.getMainLooper() == Looper.myLooper()) {
                z = true;
            }
            writeAction.log = str;
            writeAction.localTime = System.currentTimeMillis();
            writeAction.flag = i;
            writeAction.isMainThread = z;
            writeAction.threadId = id;
            writeAction.threadName = name;
            writeAction.tagName = str2;
            writeAction.funcName = str3;
            writeAction.fileName = str4;
            writeAction.fileLine = i2;
            loganModel.writeAction = writeAction;
            if (((long) this.mCacheLogQueue.size()) < this.mMaxQueue) {
                this.mCacheLogQueue.add(loganModel);
                LoganThread loganThread = this.mLoganThread;
                if (loganThread != null) {
                    loganThread.notifyRun();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void send(String[] strArr, SendLogRunnable sendLogRunnable) {
        if (!TextUtils.isEmpty(this.mPath) && strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    LoganModel loganModel = new LoganModel();
                    SendAction sendAction = new SendAction();
                    loganModel.action = LoganModel.Action.SEND;
                    sendAction.name = str;
                    sendAction.sendLogRunnable = sendLogRunnable;
                    loganModel.sendAction = sendAction;
                    this.mCacheLogQueue.add(loganModel);
                    LoganThread loganThread = this.mLoganThread;
                    if (loganThread != null) {
                        loganThread.notifyRun();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void open(String str) {
        LoganModel loganModel = new LoganModel();
        loganModel.action = LoganModel.Action.OPEN;
        OpenAction openAction = new OpenAction();
        openAction.extra = str;
        loganModel.openAction = openAction;
        this.mCacheLogQueue.add(loganModel);
        LoganThread loganThread = this.mLoganThread;
        if (loganThread != null) {
            loganThread.notifyRun();
        }
    }

    /* access modifiers changed from: package-private */
    public void flush() {
        if (!TextUtils.isEmpty(this.mPath)) {
            LoganModel loganModel = new LoganModel();
            loganModel.action = LoganModel.Action.FLUSH;
            this.mCacheLogQueue.add(loganModel);
            LoganThread loganThread = this.mLoganThread;
            if (loganThread != null) {
                loganThread.notifyRun();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public File getDir() {
        return new File(this.mPath);
    }
}
