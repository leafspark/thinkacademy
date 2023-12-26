package com.dianping.logan;

import android.os.StatFs;
import android.text.TextUtils;
import com.dianping.logan.LoganModel;
import com.dianping.logan.SendLogRunnable;
import java.io.File;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

class LoganThread extends Thread {
    private static final int CACHE_SIZE = 1024;
    private static final long LONG = 86400000;
    private static final int MINUTE = 60000;
    private static final String TAG = "LoganThread";
    /* access modifiers changed from: private */
    public ConcurrentLinkedQueue<LoganModel> mCacheLogQueue;
    private String mCachePath;
    /* access modifiers changed from: private */
    public ConcurrentLinkedQueue<LoganModel> mCacheSendQueue = new ConcurrentLinkedQueue<>();
    private long mCurrentDay;
    private String mEncryptIv16;
    private String mEncryptKey16;
    private File mFileDirectory;
    private volatile boolean mIsRun = true;
    private boolean mIsSDCard;
    private boolean mIsWorking;
    private long mLastTime;
    private LoganProtocol mLoganProtocol;
    private long mMaxLogFile;
    private long mMinSDCard;
    private String mPath;
    private long mSaveTime;
    /* access modifiers changed from: private */
    public int mSendLogStatusCode;
    private ExecutorService mSingleThreadExecutor;
    /* access modifiers changed from: private */
    public final Object sendSync = new Object();
    private final Object sync = new Object();

    LoganThread(ConcurrentLinkedQueue<LoganModel> concurrentLinkedQueue, String str, String str2, long j, long j2, long j3, String str3, String str4) {
        this.mCacheLogQueue = concurrentLinkedQueue;
        this.mCachePath = str;
        this.mPath = str2;
        this.mSaveTime = j;
        this.mMaxLogFile = j2;
        this.mMinSDCard = j3;
        this.mEncryptKey16 = str3;
        this.mEncryptIv16 = str4;
    }

    /* access modifiers changed from: package-private */
    public void notifyRun() {
        if (!this.mIsWorking) {
            synchronized (this.sync) {
                this.sync.notify();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void quit() {
        this.mIsRun = false;
        if (!this.mIsWorking) {
            synchronized (this.sync) {
                this.sync.notify();
            }
        }
    }

    public void run() {
        super.run();
        while (this.mIsRun) {
            synchronized (this.sync) {
                this.mIsWorking = true;
                try {
                    LoganModel poll = this.mCacheLogQueue.poll();
                    if (poll == null) {
                        this.mIsWorking = false;
                        this.sync.wait();
                        this.mIsWorking = true;
                    } else {
                        action(poll);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    this.mIsWorking = false;
                }
            }
        }
    }

    private void action(LoganModel loganModel) {
        if (loganModel != null && loganModel.isValid()) {
            if (this.mLoganProtocol == null) {
                LoganProtocol newInstance = LoganProtocol.newInstance();
                this.mLoganProtocol = newInstance;
                newInstance.setOnLoganProtocolStatus(new OnLoganProtocolStatus() {
                    public void loganProtocolStatus(String str, int i) {
                        Logan.onListenerLogWriteStatus(str, i);
                    }
                });
                this.mLoganProtocol.logan_init(this.mCachePath, this.mPath, (int) this.mMaxLogFile, this.mEncryptKey16, this.mEncryptIv16);
                this.mLoganProtocol.logan_debug(Logan.sDebug);
            }
            if (loganModel.action == LoganModel.Action.OPEN) {
                doOpenFile(loganModel.openAction.extra);
            } else if (loganModel.action == LoganModel.Action.WRITE) {
                doWriteLog2File(loganModel.writeAction);
            } else if (loganModel.action == LoganModel.Action.SEND) {
                if (loganModel.sendAction.sendLogRunnable != null) {
                    synchronized (this.sendSync) {
                        if (this.mSendLogStatusCode == 10001) {
                            this.mCacheSendQueue.add(loganModel);
                        } else {
                            doSendLog2Net(loganModel.sendAction);
                        }
                    }
                }
            } else if (loganModel.action == LoganModel.Action.FLUSH) {
                doFlushLog2File();
            }
        }
    }

    private void doOpenFile(String str) {
        Util.logI(TAG, "Logan open start");
        this.mLoganProtocol.logan_flush();
        if (!isDay()) {
            Util.logI(TAG, "new day or init");
            long currentTime = Util.getCurrentTime();
            deleteExpiredFile(currentTime - this.mSaveTime);
            this.mCurrentDay = currentTime;
            Util.resetIndex(this.mFileDirectory, currentTime);
        }
        String newFileNameWithExtra = Util.newFileNameWithExtra(this.mCurrentDay, str);
        Util.logI(TAG, "open file: " + newFileNameWithExtra);
        this.mLoganProtocol.logan_open(newFileNameWithExtra);
    }

    private void doFlushLog2File() {
        Util.logI(TAG, "Logan flush start");
        LoganProtocol loganProtocol = this.mLoganProtocol;
        if (loganProtocol != null) {
            loganProtocol.logan_flush();
        }
    }

    private boolean isDay() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mCurrentDay;
        return j < currentTimeMillis && j + LONG > currentTimeMillis;
    }

    private void deleteExpiredFile(long j) {
        String[] list;
        File file = new File(this.mPath);
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        String[] split = str.split("\\.");
                        if (split.length > 0 && Util.formatFileTime(split[0]).longValue() <= j && split.length == 1) {
                            new File(this.mPath, str).delete();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doWriteLog2File(WriteAction writeAction) {
        Util.logI(TAG, "Logan write start");
        if (this.mFileDirectory == null) {
            this.mFileDirectory = new File(this.mPath);
        }
        if (!isDay()) {
            Util.logI(TAG, "new day or init");
            long currentTime = Util.getCurrentTime();
            deleteExpiredFile(currentTime - this.mSaveTime);
            this.mCurrentDay = currentTime;
            Util.resetIndex(this.mFileDirectory, currentTime);
            String newFileName = Util.newFileName(this.mCurrentDay);
            Util.logI(TAG, "open file: " + newFileName);
            this.mLoganProtocol.logan_open(newFileName);
        }
        if (System.currentTimeMillis() - this.mLastTime > 60000) {
            this.mIsSDCard = isCanWriteSDCard();
        }
        this.mLastTime = System.currentTimeMillis();
        if (!this.mIsSDCard) {
            Util.logI(TAG, "大于50M 不让再次写入");
        } else {
            this.mLoganProtocol.logan_write(writeAction.flag, writeAction.log, writeAction.localTime, writeAction.threadName, writeAction.tagName, writeAction.funcName, writeAction.fileName, writeAction.fileLine, writeAction.threadId, writeAction.isMainThread);
        }
    }

    private void doSendLog2Net(SendAction sendAction) {
        if (!TextUtils.isEmpty(this.mPath) && sendAction != null && sendAction.isValid()) {
            if (!prepareLogFile(sendAction)) {
                Util.logI(TAG, "Logan prepare log file failed");
                return;
            }
            sendAction.sendLogRunnable.setSendAction(sendAction);
            sendAction.sendLogRunnable.setCallBackListener(new SendLogRunnable.OnSendLogCallBackListener() {
                public void onCallBack(int i) {
                    synchronized (LoganThread.this.sendSync) {
                        int unused = LoganThread.this.mSendLogStatusCode = i;
                        if (i == 10002) {
                            LoganThread.this.mCacheLogQueue.addAll(LoganThread.this.mCacheSendQueue);
                            LoganThread.this.mCacheSendQueue.clear();
                            LoganThread.this.notifyRun();
                        }
                    }
                }
            });
            this.mSendLogStatusCode = 10001;
            if (this.mSingleThreadExecutor == null) {
                this.mSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() {
                    public Thread newThread(Runnable runnable) {
                        Thread thread = new Thread(Thread.currentThread().getThreadGroup(), runnable, "logan-thread-send-log", 0);
                        if (thread.isDaemon()) {
                            thread.setDaemon(false);
                        }
                        if (thread.getPriority() != 5) {
                            thread.setPriority(5);
                        }
                        return thread;
                    }
                });
            }
            this.mSingleThreadExecutor.execute(sendAction.sendLogRunnable);
        }
    }

    private boolean prepareLogFile(SendAction sendAction) {
        Util.logI(TAG, "prepare log file");
        if (isFile(sendAction.name)) {
            String str = this.mPath + File.separator + sendAction.name;
            if (sendAction.name.equals(String.valueOf(this.mLoganProtocol.getCurrentFileName()))) {
                return false;
            }
            sendAction.uploadPath = str;
            return true;
        }
        sendAction.uploadPath = "";
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0055 A[SYNTHETIC, Splitter:B:39:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x005f A[SYNTHETIC, Splitter:B:44:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x006a A[SYNTHETIC, Splitter:B:51:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0074 A[SYNTHETIC, Splitter:B:56:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x007b A[SYNTHETIC, Splitter:B:61:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0085 A[SYNTHETIC, Splitter:B:66:0x0085] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:36:0x0050=Splitter:B:36:0x0050, B:48:0x0065=Splitter:B:48:0x0065} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean copyFile(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0063, IOException -> 0x004e, all -> 0x004b }
            java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0063, IOException -> 0x004e, all -> 0x004b }
            r3.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0063, IOException -> 0x004e, all -> 0x004b }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0063, IOException -> 0x004e, all -> 0x004b }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0043, all -> 0x003f }
            java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0043, all -> 0x003f }
            r3.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0043, all -> 0x003f }
            r5.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0043, all -> 0x003f }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x003b, all -> 0x0039 }
        L_0x001a:
            int r0 = r2.read(r6)     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x003b, all -> 0x0039 }
            if (r0 < 0) goto L_0x0027
            r5.write(r6, r1, r0)     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x003b, all -> 0x0039 }
            r5.flush()     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x003b, all -> 0x0039 }
            goto L_0x001a
        L_0x0027:
            r1 = 1
            r2.close()     // Catch:{ Exception -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0030:
            r5.close()     // Catch:{ Exception -> 0x0034 }
            goto L_0x0077
        L_0x0034:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x0077
        L_0x0039:
            r6 = move-exception
            goto L_0x0041
        L_0x003b:
            r6 = move-exception
            goto L_0x0045
        L_0x003d:
            r6 = move-exception
            goto L_0x0049
        L_0x003f:
            r6 = move-exception
            r5 = r0
        L_0x0041:
            r0 = r2
            goto L_0x0079
        L_0x0043:
            r6 = move-exception
            r5 = r0
        L_0x0045:
            r0 = r2
            goto L_0x0050
        L_0x0047:
            r6 = move-exception
            r5 = r0
        L_0x0049:
            r0 = r2
            goto L_0x0065
        L_0x004b:
            r6 = move-exception
            r5 = r0
            goto L_0x0079
        L_0x004e:
            r6 = move-exception
            r5 = r0
        L_0x0050:
            r6.printStackTrace()     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x005d
            r0.close()     // Catch:{ Exception -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r6 = move-exception
            r6.printStackTrace()
        L_0x005d:
            if (r5 == 0) goto L_0x0077
            r5.close()     // Catch:{ Exception -> 0x0034 }
            goto L_0x0077
        L_0x0063:
            r6 = move-exception
            r5 = r0
        L_0x0065:
            r6.printStackTrace()     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x0072
            r0.close()     // Catch:{ Exception -> 0x006e }
            goto L_0x0072
        L_0x006e:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0072:
            if (r5 == 0) goto L_0x0077
            r5.close()     // Catch:{ Exception -> 0x0034 }
        L_0x0077:
            return r1
        L_0x0078:
            r6 = move-exception
        L_0x0079:
            if (r0 == 0) goto L_0x0083
            r0.close()     // Catch:{ Exception -> 0x007f }
            goto L_0x0083
        L_0x007f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0083:
            if (r5 == 0) goto L_0x008d
            r5.close()     // Catch:{ Exception -> 0x0089 }
            goto L_0x008d
        L_0x0089:
            r5 = move-exception
            r5.printStackTrace()
        L_0x008d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dianping.logan.LoganThread.copyFile(java.lang.String, java.lang.String):boolean");
    }

    private boolean isCanWriteSDCard() {
        try {
            StatFs statFs = new StatFs(this.mPath);
            if (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > this.mMinSDCard) {
                return true;
            }
            return false;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isFile(String str) {
        if (TextUtils.isEmpty(this.mPath)) {
            return false;
        }
        File file = new File(this.mPath + File.separator + str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        return true;
    }
}
