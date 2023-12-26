package com.tal.app.thinkacademy.lib.download.operation;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.common.location.CustomLocationManagerKt;
import com.tal.app.thinkacademy.lib.download.exception.DownloadException;
import com.tal.app.thinkacademy.lib.download.exception.DownloadHttpException;
import com.tal.app.thinkacademy.lib.download.exception.IllegalURLException;
import com.tal.app.thinkacademy.lib.download.exception.NetException;
import com.tal.app.thinkacademy.lib.download.exception.ResumeTransferExceptionEngine;
import com.tal.app.thinkacademy.lib.download.listener.DownloadListener;
import com.tal.app.thinkacademy.lib.download.model.FilePoint;
import com.tal.app.thinkacademy.lib.download.util.HttpHelper;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.EncryptUtils;
import com.tal.app.thinkacademy.lib.util.FileUtils;
import com.tal.app.thinkacademy.lib.util.NetworkUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.internal.http2.StreamResetException;

public class DownloadTask extends Handler {
    private static final int MSG_CANCEL = 4100;
    private static final int MSG_FAILED = 4101;
    private static final int MSG_FINISH = 4098;
    private static final int MSG_PAUSE = 4099;
    private static final int MSG_PROGRESS = 4097;
    private static final int MSG_START = 4096;
    private static final String TAG = "XesSlimDownload";
    private int THREAD_COUNT = 1;
    private Call callImmediately;
    private Call callSliceLength;
    private Call[] callSlices;
    /* access modifiers changed from: private */
    public volatile boolean cancel;
    /* access modifiers changed from: private */
    public AtomicInteger childFailedCount = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public AtomicInteger childFinshCount = new AtomicInteger(0);
    private int currentProgress;
    /* access modifiers changed from: private */
    public volatile boolean isDownloading = false;
    private File[] mCacheFiles;
    /* access modifiers changed from: private */
    public long mFileLength;
    private HttpHelper mHttpHelper;
    /* access modifiers changed from: private */
    public DownloadListener mListener;
    /* access modifiers changed from: private */
    public FilePoint mPoint;
    private long mProgress;
    /* access modifiers changed from: private */
    public long[] mProgresses;
    /* access modifiers changed from: private */
    public File mTmpFile;
    /* access modifiers changed from: private */
    public volatile boolean pause;
    private Map<String, AtomicInteger> retryCount = new ConcurrentHashMap();
    private Throwable sliceThrowable;
    private long startTime = -1;

    DownloadTask(FilePoint filePoint, DownloadListener downloadListener) {
        this.mPoint = filePoint;
        if (filePoint.isDiff() || this.mPoint.isSingleSlice()) {
            this.THREAD_COUNT = 1;
        } else {
            this.callSlices = new Call[this.THREAD_COUNT];
        }
        this.mListener = downloadListener;
        int i = this.THREAD_COUNT;
        this.mProgresses = new long[i];
        this.mCacheFiles = new File[i];
        this.mHttpHelper = HttpHelper.getInstance();
    }

    public void handleMessage(Message message) {
        AsynchronousInstrumentation.handlerMessageBegin(this, message);
        if (this.mListener == null) {
            AsynchronousInstrumentation.handlerMessageEnd();
            return;
        }
        switch (message.what) {
            case MSG_START /*4096*/:
                this.mListener.onStart(this.mPoint);
                break;
            case 4097:
                this.mListener.onProgress(this.mProgress, this.mFileLength, this.mPoint);
                break;
            case MSG_FINISH /*4098*/:
                this.mListener.onFinished(this.mPoint);
                break;
            case MSG_PAUSE /*4099*/:
                this.mListener.onPause(this.mPoint);
                break;
            case MSG_CANCEL /*4100*/:
                this.mListener.onCancel(this.mPoint);
                break;
            case MSG_FAILED /*4101*/:
                downloadFailed(message);
                break;
        }
        AsynchronousInstrumentation.handlerMessageEnd();
    }

    private void downloadFailed(Message message) {
        resetStutus();
        if (message == null) {
            message = new Message();
        }
        if (!(message.obj instanceof Throwable)) {
            message.obj = new Exception(CustomLocationManagerKt.KUnKnown);
        }
        Throwable th = (Throwable) message.obj;
        String message2 = th != null ? th.getMessage() : "null";
        DownloadException handleException = ResumeTransferExceptionEngine.handleException(th);
        long j = 0;
        for (long j2 : this.mProgresses) {
            j += j2;
        }
        String str = "进度:" + ((((float) j) * 1.0f) / ((float) this.mFileLength)) + "已下载:" + j + "总数:" + this.mFileLength;
        XesLog.it(TAG, "下载失败，重试线程：" + Thread.currentThread().getName());
        if (!this.retryCount.containsKey(this.mPoint.getRealUrl())) {
            this.retryCount.put(this.mPoint.getRealUrl(), new AtomicInteger(0));
        }
        if (confirmRetryCount(this.retryCount.get(this.mPoint.getRealUrl()))) {
            if (handleException.code == 1007 || handleException.code == 1006) {
                this.mPoint.getHttpRealUrl();
            }
            XesLog.it(TAG, "失败后直接重试：" + this.mPoint.getRealUrl());
            start();
            return;
        }
        if (!TextUtils.isEmpty(this.mPoint.getRealUrl())) {
            FileUtils.deleteFile(new File(this.mPoint.getFilePath(), this.mPoint.getRealFileName()));
            FileUtils.deleteFile(new File(this.mPoint.getFilePath(), this.mPoint.getRealFileName() + ".tmp"));
            cleanFile(this.mCacheFiles);
        }
        this.retryCount.remove(this.mPoint.getRealUrl());
        if (this.mPoint.hasNextUr()) {
            XesLog.it(TAG, "切换url重试：," + this.mPoint.getRealUrl());
            start();
        } else if (!this.mPoint.isDiff() || this.mPoint.getFullFilePoint() == null) {
            this.mListener.onFailed(this.mPoint, handleException.code, handleException.errorMsg, str, message2);
        } else {
            this.mPoint = this.mPoint.getFullFilePoint();
            XesLog.it(TAG, "切换url重试：," + this.mPoint.getRealUrl());
            start();
        }
    }

    public synchronized void start() {
        try {
            if (this.isDownloading) {
                XesLog.it(TAG, "start: 正在下载");
                return;
            }
            sendEmptyMessage(MSG_START);
            if (!NetworkUtils.isConnected()) {
                onFailed(MSG_FAILED, new NetException());
                return;
            }
            FilePoint filePoint = this.mPoint;
            if (filePoint != null && !TextUtils.isEmpty(filePoint.getRealUrl())) {
                if (this.mPoint.getRealUrl().startsWith("https://") || this.mPoint.getRealUrl().startsWith("http://")) {
                    XesLog.it(TAG, "start: " + this.isDownloading + "\t" + this.mPoint.getRealUrl());
                    if (this.startTime == -1) {
                        this.startTime = System.currentTimeMillis();
                    }
                    downloadBySlice();
                }
            }
            onFailed(MSG_FAILED, new IllegalURLException());
            return;
        } catch (IOException e) {
            e.printStackTrace();
            onFailed(MSG_FAILED, e);
            XesLog.it(TAG, "大线程中下载异常" + e.getMessage());
        }
        return;
    }

    private void downloadImmediately() throws IOException {
        this.callImmediately = this.mHttpHelper.downloadFileByUrl(this.mPoint.getRealUrl(), new Callback() {
            public void onFailure(Call call, IOException iOException) {
                if (DownloadTask.this.pause && DownloadTask.this.isOkCancelException(iOException)) {
                    XesLog.et(DownloadTask.TAG, "直接下载暂停：" + iOException.getMessage() + "\n" + DownloadTask.this.mPoint.getRealUrl());
                    DownloadTask.this.pauseInThread();
                } else if (!DownloadTask.this.cancel || !DownloadTask.this.isOkCancelException(iOException)) {
                    XesLog.et(DownloadTask.TAG, "直接下载异常：" + iOException.getMessage() + "\n" + DownloadTask.this.mPoint.getRealUrl());
                    DownloadTask.this.childFailedCount.incrementAndGet();
                    Message unused = DownloadTask.this.onFailed(DownloadTask.MSG_FAILED, iOException);
                } else {
                    XesLog.et(DownloadTask.TAG, "直接下载取消：" + iOException.getMessage() + "\n" + DownloadTask.this.mPoint.getRealUrl());
                    DownloadTask.this.cancelInThread();
                }
            }

            public void onResponse(Call call, Response response) throws IOException {
                try {
                    XesLog.et(DownloadTask.TAG, "start: " + response.code() + "\t isDownloading:" + DownloadTask.this.isDownloading + "\t" + DownloadTask.this.mPoint.getRealUrl());
                    if (!response.isSuccessful()) {
                        DownloadTask.this.close(response.body());
                        Message unused = DownloadTask.this.onFailed(DownloadTask.MSG_FAILED, new DownloadHttpException(response));
                        return;
                    }
                    long unused2 = DownloadTask.this.mFileLength = response.body().contentLength();
                    if (DownloadTask.this.mFileLength <= 0) {
                        DownloadTask downloadTask = DownloadTask.this;
                        long unused3 = downloadTask.mFileLength = downloadTask.mPoint.getFileSize();
                    }
                    if (DownloadTask.this.mFileLength <= 0) {
                        XesLog.it(DownloadTask.TAG, "文件size小于0，fileLength = " + DownloadTask.this.mFileLength);
                        Message unused4 = DownloadTask.this.onFailed(DownloadTask.MSG_FAILED, new DownloadHttpException(response));
                        return;
                    }
                    if (DownloadTask.this.mPoint != null) {
                        DownloadTask.this.mPoint.setFileSize(DownloadTask.this.mFileLength);
                    }
                    File file = new File(DownloadTask.this.mPoint.getFilePath(), DownloadTask.this.mPoint.getRealFileName());
                    if (file.exists() && file.length() == DownloadTask.this.mFileLength) {
                        if (TextUtils.isEmpty(DownloadTask.this.mPoint.getMd5())) {
                            XesLog.it(DownloadTask.TAG, "文件已经完全下载完成，不需要开始下载");
                            DownloadTask.this.mListener.onFinished(DownloadTask.this.mPoint);
                            return;
                        } else if (TextUtils.equals(EncryptUtils.encodeFile(file), DownloadTask.this.mPoint.getMd5())) {
                            XesLog.it(DownloadTask.TAG, "md5校验一致，不需要开始下载");
                            DownloadTask.this.mListener.onFinished(DownloadTask.this.mPoint);
                            return;
                        }
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    DownloadTask.this.resetStutus();
                    DownloadTask.this.childFinshCount.set(0);
                    DownloadTask.this.childFailedCount.set(0);
                    boolean unused5 = DownloadTask.this.isDownloading = true;
                    byte[] bArr = new byte[DownloadTask.MSG_START];
                    InputStream byteStream = response.body().byteStream();
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    int i = 0;
                    while (true) {
                        int read = byteStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                            i += read;
                            DownloadTask.this.mProgresses[0] = (long) i;
                            DownloadTask.this.progressInThread();
                        } else {
                            DownloadTask.this.close(byteStream, response.body());
                            XesLog.it(DownloadTask.TAG, "不分片直接下载完成：" + DownloadTask.this.mPoint.getFileName());
                            DownloadTask.this.finishInThread();
                            return;
                        }
                    }
                } catch (Exception e) {
                    XesLog.et(DownloadTask.TAG, "直接下载异常：" + e.getMessage());
                    DownloadTask.this.failedInThread(e);
                }
            }
        });
    }

    private void downloadBySlice() throws IOException {
        long fileSize = this.mPoint.getFileSize();
        this.mFileLength = fileSize;
        if (fileSize == 0) {
            XesLog.it(TAG, "需要先获取文件大小：" + this.mPoint.getFileName());
            this.callSliceLength = this.mHttpHelper.downloadFileByUrl(this.mPoint.getRealUrl(), new Callback() {
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        XesLog.dt(DownloadTask.TAG, "start: " + response.code() + "\t isDownloading:" + DownloadTask.this.isDownloading + "\t" + DownloadTask.this.mPoint.getRealUrl());
                        if (!response.isSuccessful()) {
                            DownloadTask.this.close(response.body());
                            Message unused = DownloadTask.this.onFailed(DownloadTask.MSG_FAILED, new DownloadHttpException(response));
                            return;
                        }
                        long unused2 = DownloadTask.this.mFileLength = response.body().contentLength();
                        if (DownloadTask.this.mFileLength <= 0) {
                            XesLog.it(DownloadTask.TAG, "文件size小于0，fileLength = " + DownloadTask.this.mFileLength);
                            Message unused3 = DownloadTask.this.onFailed(DownloadTask.MSG_FAILED, new DownloadHttpException(response));
                            return;
                        }
                        if (DownloadTask.this.mPoint != null) {
                            DownloadTask.this.mPoint.setFileSize(DownloadTask.this.mFileLength);
                        }
                        DownloadTask.this.close(response.body());
                        DownloadTask.this.downloadBySlices();
                    } catch (Exception e) {
                        XesLog.it(DownloadTask.TAG, "获取文件大小异常：" + e.toString());
                        DownloadTask.this.failedInThread(e);
                    }
                }

                public void onFailure(Call call, IOException iOException) {
                    XesLog.it(DownloadTask.TAG, "获取文件大小异常：" + iOException.toString());
                    DownloadTask.this.failedInThread(iOException);
                }
            });
            return;
        }
        XesLog.it(TAG, "不需要获取文件大小，直接分片：" + this.mPoint.getFileName());
        downloadBySlices();
    }

    /* access modifiers changed from: private */
    public void downloadBySlices() throws IOException {
        File file = new File(this.mPoint.getFilePath(), this.mPoint.getRealFileName());
        int i = 0;
        if (file.exists() && file.length() == this.mFileLength) {
            if (!TextUtils.isEmpty(this.mPoint.getMd5())) {
                if (this.mPoint.getMd5().equalsIgnoreCase(EncryptUtils.encodeFile(file))) {
                    XesLog.it(TAG, "md5校验一致，不需要开始下载");
                    this.mListener.onFinished(this.mPoint);
                    return;
                }
            } else {
                XesLog.it(TAG, "文件已经完全下载完成，不需要开始下载");
                this.mListener.onFinished(this.mPoint);
                return;
            }
        }
        this.childFinshCount.set(0);
        this.childFailedCount.set(0);
        this.isDownloading = true;
        String filePath = this.mPoint.getFilePath();
        File file2 = new File(filePath, this.mPoint.getRealFileName() + ".tmp");
        this.mTmpFile = file2;
        if (!file2.getParentFile().exists()) {
            this.mTmpFile.getParentFile().mkdirs();
        }
        new RandomAccessFile(this.mTmpFile, "rw").setLength(this.mFileLength);
        long j = this.mFileLength / ((long) this.THREAD_COUNT);
        XesLog.it(TAG, "开始分片下载：" + this.mPoint.getFileName() + "," + this.THREAD_COUNT);
        while (true) {
            int i2 = i;
            int i3 = this.THREAD_COUNT;
            if (i2 < i3) {
                i = i2 + 1;
                download(((long) i2) * j, i2 == i3 + -1 ? this.mFileLength - 1 : (((long) i) * j) - 1, i2);
            } else {
                return;
            }
        }
    }

    private void download(long j, long j2, int i) throws IOException {
        long j3;
        int i2 = i;
        String filePath = this.mPoint.getFilePath();
        final File file = new File(filePath, "thread" + i2 + "_" + this.mPoint.getRealFileName() + ".cache");
        this.mCacheFiles[i2] = file;
        final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rwd");
        if (file.exists()) {
            String readLine = randomAccessFile.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                try {
                    j3 = Long.parseLong(readLine);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                final long j4 = j3;
                final int i3 = i;
                final long j5 = j;
                this.callSlices[i2] = this.mHttpHelper.downloadFileByRange(this.mPoint.getRealUrl(), j3, j2, new Callback() {
                    public void onResponse(Call call, Response response) throws IOException {
                        try {
                            XesLog.it(DownloadTask.TAG, "download: " + response.code() + "\t isDownloading:" + DownloadTask.this.isDownloading + "\t" + DownloadTask.this.mPoint.getRealUrl());
                            if (!response.isSuccessful()) {
                                DownloadTask.this.resetStutus();
                                DownloadTask.this.close(response.body());
                                Message unused = DownloadTask.this.onFailed(DownloadTask.MSG_FAILED, new DownloadHttpException(response));
                                return;
                            }
                            InputStream byteStream = response.body().byteStream();
                            RandomAccessFile randomAccessFile = new RandomAccessFile(DownloadTask.this.mTmpFile, "rw");
                            randomAccessFile.seek(j4);
                            byte[] bArr = new byte[DownloadTask.MSG_START];
                            int i = 0;
                            while (true) {
                                int read = byteStream.read(bArr);
                                if (read > 0) {
                                    randomAccessFile.write(bArr, 0, read);
                                    i += read;
                                    long j = j4 + ((long) i);
                                    randomAccessFile.seek(0);
                                    randomAccessFile.write((j + "").getBytes(StandardCharsets.UTF_8));
                                    DownloadTask.this.mProgresses[i3] = j - j5;
                                    DownloadTask.this.progressInThread();
                                } else {
                                    DownloadTask.this.close(randomAccessFile, byteStream, response.body());
                                    DownloadTask.this.cleanFile(file);
                                    DownloadTask.this.dealDownloadFinish(i3);
                                    return;
                                }
                            }
                        } catch (Exception e) {
                            DownloadTask.this.dealDownloadEnd(e);
                        }
                    }

                    public void onFailure(Call call, IOException iOException) {
                        DownloadTask.this.dealDownloadEnd(iOException);
                    }
                });
            }
        }
        j3 = j;
        final long j42 = j3;
        final int i32 = i;
        final long j52 = j;
        this.callSlices[i2] = this.mHttpHelper.downloadFileByRange(this.mPoint.getRealUrl(), j3, j2, new Callback() {
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    XesLog.it(DownloadTask.TAG, "download: " + response.code() + "\t isDownloading:" + DownloadTask.this.isDownloading + "\t" + DownloadTask.this.mPoint.getRealUrl());
                    if (!response.isSuccessful()) {
                        DownloadTask.this.resetStutus();
                        DownloadTask.this.close(response.body());
                        Message unused = DownloadTask.this.onFailed(DownloadTask.MSG_FAILED, new DownloadHttpException(response));
                        return;
                    }
                    InputStream byteStream = response.body().byteStream();
                    RandomAccessFile randomAccessFile = new RandomAccessFile(DownloadTask.this.mTmpFile, "rw");
                    randomAccessFile.seek(j42);
                    byte[] bArr = new byte[DownloadTask.MSG_START];
                    int i = 0;
                    while (true) {
                        int read = byteStream.read(bArr);
                        if (read > 0) {
                            randomAccessFile.write(bArr, 0, read);
                            i += read;
                            long j = j42 + ((long) i);
                            randomAccessFile.seek(0);
                            randomAccessFile.write((j + "").getBytes(StandardCharsets.UTF_8));
                            DownloadTask.this.mProgresses[i32] = j - j52;
                            DownloadTask.this.progressInThread();
                        } else {
                            DownloadTask.this.close(randomAccessFile, byteStream, response.body());
                            DownloadTask.this.cleanFile(file);
                            DownloadTask.this.dealDownloadFinish(i32);
                            return;
                        }
                    }
                } catch (Exception e) {
                    DownloadTask.this.dealDownloadEnd(e);
                }
            }

            public void onFailure(Call call, IOException iOException) {
                DownloadTask.this.dealDownloadEnd(iOException);
            }
        });
    }

    /* access modifiers changed from: private */
    public synchronized void dealDownloadFinish(int i) {
        int incrementAndGet = this.childFinshCount.incrementAndGet();
        XesLog.it(TAG, "分片下载完成数：" + incrementAndGet + " 线程：" + i);
        if (this.childFinshCount.get() == this.THREAD_COUNT) {
            XesLog.it(TAG, "完成分片下载 " + this.mPoint.getRealFileName());
            finishInThread();
        } else if (this.childFinshCount.get() + this.childFailedCount.get() == this.THREAD_COUNT) {
            XesLog.it(TAG, "分片下载失败：" + this.mPoint.getRealFileName());
            onFailed(MSG_FAILED, this.sliceThrowable);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void dealDownloadEnd(Throwable th) {
        XesLog.it(TAG, "子线程中下载异常" + th.toString());
        this.childFailedCount.incrementAndGet();
        if (this.childFinshCount.get() + this.childFailedCount.get() == this.THREAD_COUNT) {
            failedInThread(th);
        }
    }

    /* access modifiers changed from: private */
    public Message onFailed(int i, Throwable th) {
        Message message = new Message();
        message.what = i;
        message.obj = th;
        sendMessage(message);
        return message;
    }

    /* access modifiers changed from: private */
    public void close(Closeable... closeableArr) {
        int length = closeableArr.length;
        for (int i = 0; i < length; i++) {
            try {
                if (closeableArr[i] != null) {
                    closeableArr[i].close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void cleanFile(File... fileArr) {
        int length = fileArr.length;
        for (int i = 0; i < length; i++) {
            if (fileArr[i] != null) {
                fileArr[i].delete();
            }
        }
    }

    public void pause() {
        this.pause = true;
        cancelRequest();
    }

    public void cancel() {
        this.cancel = true;
        cancelRequest();
        cleanFile(this.mTmpFile);
        if (!this.isDownloading && this.mListener != null) {
            cleanFile(this.mCacheFiles);
            resetStutus();
            this.mListener.onCancel(this.mPoint);
        }
    }

    /* access modifiers changed from: private */
    public void resetStutus() {
        this.pause = false;
        this.cancel = false;
        this.isDownloading = false;
    }

    public boolean isDownloading() {
        return this.isDownloading;
    }

    public FilePoint getPoint() {
        return this.mPoint;
    }

    public void setPoint(FilePoint filePoint) {
        this.mPoint = filePoint;
    }

    public void setListner(DownloadListener downloadListener) {
        this.mListener = downloadListener;
    }

    private boolean confirmRetryCount(AtomicInteger atomicInteger) {
        return atomicInteger != null && atomicInteger.getAndIncrement() < 1;
    }

    private void cancelRequest() {
        if (this.THREAD_COUNT == 1) {
            Call call = this.callImmediately;
            if (call != null) {
                call.cancel();
                return;
            }
            return;
        }
        Call call2 = this.callSliceLength;
        if (call2 != null) {
            call2.cancel();
        }
        int i = 0;
        while (true) {
            Call[] callArr = this.callSlices;
            if (i < callArr.length) {
                if (callArr[i] != null) {
                    callArr[i].cancel();
                }
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void progressInThread() {
        long j = 0;
        for (long j2 : this.mProgresses) {
            j += j2;
        }
        try {
            int i = (int) ((((double) j) * 100.0d) / ((double) this.mFileLength));
            if (this.currentProgress != i) {
                this.currentProgress = i;
                this.mProgress = j;
                XesLog.it(TAG, "进度回调：" + this.currentProgress + "  fileName: " + this.mPoint.getFileName());
                sendEmptyMessage(4097);
            }
        } catch (Exception e) {
            XesLog.et(TAG, "进度回调失败：" + e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void pauseInThread() {
        resetStutus();
        this.startTime = 0;
        sendEmptyMessage(MSG_PAUSE);
    }

    /* access modifiers changed from: private */
    public void cancelInThread() {
        resetStutus();
        this.mProgresses = new long[this.THREAD_COUNT];
        sendEmptyMessage(MSG_CANCEL);
    }

    /* access modifiers changed from: private */
    public void finishInThread() {
        resetStutus();
        if (this.startTime > 0) {
            this.mPoint.setDownloadDuration(System.currentTimeMillis() - this.startTime);
        }
        File file = this.mTmpFile;
        if (file != null) {
            file.renameTo(new File(this.mPoint.getFilePath(), this.mPoint.getRealFileName()));
        }
        sendEmptyMessage(MSG_FINISH);
    }

    /* access modifiers changed from: private */
    public void failedInThread(Throwable th) {
        if (this.pause && isOkCancelException(th)) {
            XesLog.et(TAG, "暂停资源下载 " + this.mPoint.getRealFileName());
            pauseInThread();
        } else if (!this.cancel || !isOkCancelException(th)) {
            this.sliceThrowable = th;
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder();
            sb.append(this.THREAD_COUNT == 1 ? "直接下载失败" : "分片下载失败");
            sb.append(this.mPoint.getRealFileName());
            objArr[0] = sb.toString();
            XesLog.et(TAG, objArr);
            onFailed(MSG_FAILED, th);
        } else {
            XesLog.et(TAG, "取消资源下载 " + this.mPoint.getRealFileName());
            cancelInThread();
        }
    }

    /* access modifiers changed from: private */
    public boolean isOkCancelException(Throwable th) {
        if (th == null || TextUtils.isEmpty(th.getMessage())) {
            return false;
        }
        if ((th instanceof StreamResetException) && th.getMessage().contains("stream was reset: CANCEL")) {
            return true;
        }
        if ((th instanceof SocketException) && th.getMessage().contains("Socket closed")) {
            return true;
        }
        if (!(th instanceof IOException) || !th.getMessage().contains("Canceled")) {
            return false;
        }
        return true;
    }

    public long getProgress() {
        return this.mProgress;
    }
}
