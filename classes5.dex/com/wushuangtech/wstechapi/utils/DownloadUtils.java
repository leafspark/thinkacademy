package com.wushuangtech.wstechapi.utils;

import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.HttpInstrumentation;
import com.wushuangtech.constants.RtcEngineEvent;
import com.wushuangtech.utils.OmniLog;
import com.yanzhenjie.andserver.util.HttpHeaders;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class DownloadUtils {
    private static final String TAG = "startAudioMixing(DownloadUtils)";
    /* access modifiers changed from: private */
    public int fileSize;
    private int mCompleteNum;
    private DownloadCallBack mDownloadCallBack;
    /* access modifiers changed from: private */
    public boolean mIsBroken;
    /* access modifiers changed from: private */
    public boolean mIsStop;
    /* access modifiers changed from: private */
    public String path;
    /* access modifiers changed from: private */
    public String targetFile;
    /* access modifiers changed from: private */
    public int threadNum;
    /* access modifiers changed from: private */
    public DownThread[] threads;

    public interface DownloadCallBack {
        void downloadError();

        void downloadSuccess(String str);
    }

    public DownloadUtils(String str, String str2, int i, DownloadCallBack downloadCallBack) {
        this.path = str;
        this.targetFile = str2;
        this.threadNum = i;
        this.threads = new DownThread[i];
        this.targetFile = str2;
        this.mDownloadCallBack = downloadCallBack;
    }

    public void download() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) HttpInstrumentation.openConnection(new URL(DownloadUtils.this.path).openConnection());
                    httpURLConnection.setConnectTimeout(RtcEngineEvent.AudioEvent.EVENT_AUDIO_START_POINT);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
                    httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_LANGUAGE, "zh-CN");
                    httpURLConnection.setRequestProperty("Charset", "UTF-8");
                    httpURLConnection.setRequestProperty(HttpHeaders.CONNECTION, "Keep-Alive");
                    int unused = DownloadUtils.this.fileSize = httpURLConnection.getContentLength();
                    httpURLConnection.disconnect();
                    int access$100 = (DownloadUtils.this.fileSize / DownloadUtils.this.threadNum) + 1;
                    RandomAccessFile randomAccessFile = new RandomAccessFile(DownloadUtils.this.targetFile, "rw");
                    randomAccessFile.setLength((long) DownloadUtils.this.fileSize);
                    randomAccessFile.close();
                    for (int i = 0; i < DownloadUtils.this.threadNum; i++) {
                        int i2 = i * access$100;
                        RandomAccessFile randomAccessFile2 = new RandomAccessFile(DownloadUtils.this.targetFile, "rw");
                        randomAccessFile2.seek((long) i2);
                        DownloadUtils.this.threads[i] = new DownThread(i2, access$100, randomAccessFile2, i);
                        DownloadUtils.this.threads[i].start();
                    }
                } catch (MalformedURLException e) {
                    OmniLog.d(DownloadUtils.TAG, "MalformedURLException Error : " + e.getLocalizedMessage());
                    DownloadUtils.this.downloadOver(true);
                } catch (FileNotFoundException e2) {
                    OmniLog.d(DownloadUtils.TAG, "FileNotFoundException Error : " + e2.getLocalizedMessage());
                    DownloadUtils.this.downloadOver(true);
                } catch (ProtocolException e3) {
                    OmniLog.d(DownloadUtils.TAG, "ProtocolException Error : " + e3.getLocalizedMessage());
                    DownloadUtils.this.downloadOver(true);
                } catch (IOException e4) {
                    OmniLog.d(DownloadUtils.TAG, "IOException Error : " + e4.getLocalizedMessage());
                    DownloadUtils.this.downloadOver(true);
                }
            }
        });
        if (!(thread instanceof Thread)) {
            thread.start();
        } else {
            AsynchronousInstrumentation.threadStart(thread);
        }
    }

    public double getCompleteRate() {
        int i = 0;
        for (int i2 = 0; i2 < this.threadNum; i2++) {
            i += this.threads[i2].length;
        }
        return (((double) i) * 1.0d) / ((double) this.fileSize);
    }

    private class DownThread extends Thread {
        private RandomAccessFile currentPart;
        private int currentPartSize;
        private int index;
        public int length;
        private int startPos;

        DownThread(int i, int i2, RandomAccessFile randomAccessFile, int i3) {
            this.startPos = i;
            this.currentPartSize = i2;
            this.currentPart = randomAccessFile;
            this.index = i3;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:18|19|20|21|(2:23|41)(1:39)) */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00d4, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            com.wushuangtech.utils.OmniLog.d(com.wushuangtech.wstechapi.utils.DownloadUtils.TAG, "线程" + r7.index + "发生异常,未到指定大小. mIsBroken ： " + com.wushuangtech.wstechapi.utils.DownloadUtils.access$700(r7.this$0) + " | mIsStop : " + com.wushuangtech.wstechapi.utils.DownloadUtils.access$800(r7.this$0));
            com.wushuangtech.wstechapi.utils.DownloadUtils.access$500(r7.this$0, true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            r7.currentPart.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0121, code lost:
            if (r2 != null) goto L_0x0123;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0123, code lost:
            r2.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0127, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0128, code lost:
            r1.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x012b, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00d6 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r7 = this;
                java.lang.String r0 = "线程"
                java.lang.String r1 = "startAudioMixing(DownloadUtils)"
                r2 = 0
                java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x00d6 }
                com.wushuangtech.wstechapi.utils.DownloadUtils r4 = com.wushuangtech.wstechapi.utils.DownloadUtils.this     // Catch:{ IOException -> 0x00d6 }
                java.lang.String r4 = r4.path     // Catch:{ IOException -> 0x00d6 }
                r3.<init>(r4)     // Catch:{ IOException -> 0x00d6 }
                java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x00d6 }
                java.net.URLConnection r3 = com.bonree.sdk.agent.engine.external.HttpInstrumentation.openConnection(r3)     // Catch:{ IOException -> 0x00d6 }
                java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x00d6 }
                r4 = 5000(0x1388, float:7.006E-42)
                r3.setConnectTimeout(r4)     // Catch:{ IOException -> 0x00d6 }
                java.lang.String r4 = "GET"
                r3.setRequestMethod(r4)     // Catch:{ IOException -> 0x00d6 }
                java.lang.String r4 = "Accept"
                java.lang.String r5 = "image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*"
                r3.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x00d6 }
                java.lang.String r4 = "Accept-Language"
                java.lang.String r5 = "zh-CN"
                r3.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x00d6 }
                java.lang.String r4 = "Charset"
                java.lang.String r5 = "UTF-8"
                r3.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x00d6 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d6 }
                r4.<init>()     // Catch:{ IOException -> 0x00d6 }
                r4.append(r0)     // Catch:{ IOException -> 0x00d6 }
                int r5 = r7.index     // Catch:{ IOException -> 0x00d6 }
                r4.append(r5)     // Catch:{ IOException -> 0x00d6 }
                java.lang.String r5 = "开始连接..."
                r4.append(r5)     // Catch:{ IOException -> 0x00d6 }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x00d6 }
                com.wushuangtech.utils.OmniLog.d(r1, r4)     // Catch:{ IOException -> 0x00d6 }
                java.io.InputStream r2 = r3.getInputStream()     // Catch:{ IOException -> 0x00d6 }
                int r3 = r7.startPos     // Catch:{ IOException -> 0x00d6 }
                long r3 = (long) r3     // Catch:{ IOException -> 0x00d6 }
                com.wushuangtech.wstechapi.utils.DownloadUtils.skipFully(r2, r3)     // Catch:{ IOException -> 0x00d6 }
                r3 = 1024(0x400, float:1.435E-42)
                byte[] r3 = new byte[r3]     // Catch:{ IOException -> 0x00d6 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d6 }
                r4.<init>()     // Catch:{ IOException -> 0x00d6 }
                r4.append(r0)     // Catch:{ IOException -> 0x00d6 }
                int r5 = r7.index     // Catch:{ IOException -> 0x00d6 }
                r4.append(r5)     // Catch:{ IOException -> 0x00d6 }
                java.lang.String r5 = "连接成功开始下载. currentPartSize : "
                r4.append(r5)     // Catch:{ IOException -> 0x00d6 }
                int r5 = r7.currentPartSize     // Catch:{ IOException -> 0x00d6 }
                r4.append(r5)     // Catch:{ IOException -> 0x00d6 }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x00d6 }
                com.wushuangtech.utils.OmniLog.d(r1, r4)     // Catch:{ IOException -> 0x00d6 }
            L_0x007e:
                int r4 = r7.length     // Catch:{ IOException -> 0x00d6 }
                int r5 = r7.currentPartSize     // Catch:{ IOException -> 0x00d6 }
                r6 = 0
                if (r4 >= r5) goto L_0x00a6
                int r4 = r2.read(r3)     // Catch:{ IOException -> 0x00d6 }
                if (r4 <= 0) goto L_0x00a6
                com.wushuangtech.wstechapi.utils.DownloadUtils r5 = com.wushuangtech.wstechapi.utils.DownloadUtils.this     // Catch:{ IOException -> 0x00d6 }
                boolean r5 = r5.mIsBroken     // Catch:{ IOException -> 0x00d6 }
                if (r5 != 0) goto L_0x00a6
                com.wushuangtech.wstechapi.utils.DownloadUtils r5 = com.wushuangtech.wstechapi.utils.DownloadUtils.this     // Catch:{ IOException -> 0x00d6 }
                boolean r5 = r5.mIsStop     // Catch:{ IOException -> 0x00d6 }
                if (r5 != 0) goto L_0x00a6
                java.io.RandomAccessFile r5 = r7.currentPart     // Catch:{ IOException -> 0x00d6 }
                r5.write(r3, r6, r4)     // Catch:{ IOException -> 0x00d6 }
                int r5 = r7.length     // Catch:{ IOException -> 0x00d6 }
                int r5 = r5 + r4
                r7.length = r5     // Catch:{ IOException -> 0x00d6 }
                goto L_0x007e
            L_0x00a6:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d6 }
                r3.<init>()     // Catch:{ IOException -> 0x00d6 }
                r3.append(r0)     // Catch:{ IOException -> 0x00d6 }
                int r4 = r7.index     // Catch:{ IOException -> 0x00d6 }
                r3.append(r4)     // Catch:{ IOException -> 0x00d6 }
                java.lang.String r4 = "下载完毕. length : "
                r3.append(r4)     // Catch:{ IOException -> 0x00d6 }
                int r4 = r7.length     // Catch:{ IOException -> 0x00d6 }
                r3.append(r4)     // Catch:{ IOException -> 0x00d6 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00d6 }
                com.wushuangtech.utils.OmniLog.d(r1, r3)     // Catch:{ IOException -> 0x00d6 }
                com.wushuangtech.wstechapi.utils.DownloadUtils r3 = com.wushuangtech.wstechapi.utils.DownloadUtils.this     // Catch:{ IOException -> 0x00d6 }
                r3.downloadOver(r6)     // Catch:{ IOException -> 0x00d6 }
                java.io.RandomAccessFile r0 = r7.currentPart     // Catch:{ IOException -> 0x0117 }
                r0.close()     // Catch:{ IOException -> 0x0117 }
                if (r2 == 0) goto L_0x011b
                r2.close()     // Catch:{ IOException -> 0x0117 }
                goto L_0x011b
            L_0x00d4:
                r0 = move-exception
                goto L_0x011c
            L_0x00d6:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d4 }
                r3.<init>()     // Catch:{ all -> 0x00d4 }
                r3.append(r0)     // Catch:{ all -> 0x00d4 }
                int r0 = r7.index     // Catch:{ all -> 0x00d4 }
                r3.append(r0)     // Catch:{ all -> 0x00d4 }
                java.lang.String r0 = "发生异常,未到指定大小. mIsBroken ： "
                r3.append(r0)     // Catch:{ all -> 0x00d4 }
                com.wushuangtech.wstechapi.utils.DownloadUtils r0 = com.wushuangtech.wstechapi.utils.DownloadUtils.this     // Catch:{ all -> 0x00d4 }
                boolean r0 = r0.mIsBroken     // Catch:{ all -> 0x00d4 }
                r3.append(r0)     // Catch:{ all -> 0x00d4 }
                java.lang.String r0 = " | mIsStop : "
                r3.append(r0)     // Catch:{ all -> 0x00d4 }
                com.wushuangtech.wstechapi.utils.DownloadUtils r0 = com.wushuangtech.wstechapi.utils.DownloadUtils.this     // Catch:{ all -> 0x00d4 }
                boolean r0 = r0.mIsStop     // Catch:{ all -> 0x00d4 }
                r3.append(r0)     // Catch:{ all -> 0x00d4 }
                java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00d4 }
                com.wushuangtech.utils.OmniLog.d(r1, r0)     // Catch:{ all -> 0x00d4 }
                com.wushuangtech.wstechapi.utils.DownloadUtils r0 = com.wushuangtech.wstechapi.utils.DownloadUtils.this     // Catch:{ all -> 0x00d4 }
                r1 = 1
                r0.downloadOver(r1)     // Catch:{ all -> 0x00d4 }
                java.io.RandomAccessFile r0 = r7.currentPart     // Catch:{ IOException -> 0x0117 }
                r0.close()     // Catch:{ IOException -> 0x0117 }
                if (r2 == 0) goto L_0x011b
                r2.close()     // Catch:{ IOException -> 0x0117 }
                goto L_0x011b
            L_0x0117:
                r0 = move-exception
                r0.printStackTrace()
            L_0x011b:
                return
            L_0x011c:
                java.io.RandomAccessFile r1 = r7.currentPart     // Catch:{ IOException -> 0x0127 }
                r1.close()     // Catch:{ IOException -> 0x0127 }
                if (r2 == 0) goto L_0x012b
                r2.close()     // Catch:{ IOException -> 0x0127 }
                goto L_0x012b
            L_0x0127:
                r1 = move-exception
                r1.printStackTrace()
            L_0x012b:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.wstechapi.utils.DownloadUtils.DownThread.run():void");
        }
    }

    /* access modifiers changed from: private */
    public void downloadOver(boolean z) {
        OmniLog.d(TAG, "downloadOver. mIsBroken ： " + this.mIsBroken + " | mIsStop : " + this.mIsStop);
        if (!this.mIsBroken && !this.mIsStop) {
            synchronized (DownloadUtils.class) {
                OmniLog.d(TAG, "downloadOver. mIsFaild ： " + z + " | mCompleteNum : " + this.mCompleteNum);
                if (z) {
                    this.mIsBroken = true;
                    DownloadCallBack downloadCallBack = this.mDownloadCallBack;
                    if (downloadCallBack != null) {
                        downloadCallBack.downloadError();
                    }
                } else {
                    int i = this.mCompleteNum + 1;
                    this.mCompleteNum = i;
                    if (i == this.threadNum) {
                        OmniLog.d(TAG, "downloadOver success");
                        this.mIsBroken = true;
                        DownloadCallBack downloadCallBack2 = this.mDownloadCallBack;
                        if (downloadCallBack2 != null) {
                            downloadCallBack2.downloadSuccess(this.targetFile);
                        }
                    }
                }
            }
        }
    }

    public void stop() {
        this.mIsStop = true;
    }

    /* access modifiers changed from: private */
    public static void skipFully(InputStream inputStream, long j) throws IOException {
        while (j > 0) {
            j -= inputStream.skip(j);
        }
    }
}
