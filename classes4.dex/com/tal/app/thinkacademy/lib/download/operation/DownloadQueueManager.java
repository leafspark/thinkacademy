package com.tal.app.thinkacademy.lib.download.operation;

import android.net.TrafficStats;
import android.text.TextUtils;
import com.tal.app.thinkacademy.lib.download.listener.DownloadListener;
import com.tal.app.thinkacademy.lib.download.model.FilePoint;
import com.tal.app.thinkacademy.lib.download.util.ResOperationUtil;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadQueueManager {
    public static final String TAG = "DownloadQueueManager";
    private static DownloadQueueManager mInstance;
    private long TIME_SPAN = 1000;
    /* access modifiers changed from: private */
    public PriorityQueue<String> downloadQueue = new PriorityQueue<>(16, new Comparator<String>() {
        public int compare(String str, String str2) {
            try {
                DownloadTask downloadTask = (DownloadTask) DownloadQueueManager.this.mDownloadTasks.get(str);
                DownloadTask downloadTask2 = (DownloadTask) DownloadQueueManager.this.mDownloadTasks.get(str2);
                if (downloadTask.getPoint().isFirst()) {
                    return 1;
                }
                if (downloadTask2.getPoint().isFirst()) {
                    return -1;
                }
                return downloadTask2.getPoint().getPriority() - downloadTask.getPoint().getPriority();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
    });
    private final int initialCapacity = 16;
    /* access modifiers changed from: private */
    public Map<String, DownloadTask> mDownloadTasks = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public String netSpeed;
    private long rxtxTotal;
    private DecimalFormat showFloatFormat = new DecimalFormat("0.00");
    private Timer speedTimer;
    private int taskMaxNum = 1;
    private PriorityQueue<String> waitQueue = new PriorityQueue<>(16, new Comparator<String>() {
        public int compare(String str, String str2) {
            try {
                DownloadTask downloadTask = (DownloadTask) DownloadQueueManager.this.mDownloadTasks.get(str);
                DownloadTask downloadTask2 = (DownloadTask) DownloadQueueManager.this.mDownloadTasks.get(str2);
                if (downloadTask.getPoint().isFirst()) {
                    return -1;
                }
                if (downloadTask2.getPoint().isFirst()) {
                    return 1;
                }
                return downloadTask.getPoint().getPriority() - downloadTask2.getPoint().getPriority();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
    });

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0137, code lost:
        if (r9.mDownloadTasks.get(r4).getPoint().getPriority() < r9.mDownloadTasks.get(r1).getPoint().getPriority()) goto L_0x00d2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0210  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void download() {
        /*
            r9 = this;
            r0 = 1
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "download()"
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "DownloadQueueManager"
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r2, r1)
            java.util.PriorityQueue<java.lang.String> r1 = r9.waitQueue
            java.util.Iterator r1 = r1.iterator()
        L_0x0013:
            r4 = 0
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0074
            java.lang.Object r4 = r1.next()
            java.lang.String r4 = (java.lang.String) r4
            java.util.Map<java.lang.String, com.tal.app.thinkacademy.lib.download.operation.DownloadTask> r5 = r9.mDownloadTasks
            java.lang.Object r5 = r5.get(r4)
            if (r5 == 0) goto L_0x004c
            java.util.Map<java.lang.String, com.tal.app.thinkacademy.lib.download.operation.DownloadTask> r5 = r9.mDownloadTasks
            java.lang.Object r5 = r5.get(r4)
            com.tal.app.thinkacademy.lib.download.operation.DownloadTask r5 = (com.tal.app.thinkacademy.lib.download.operation.DownloadTask) r5
            com.tal.app.thinkacademy.lib.download.model.FilePoint r5 = r5.getPoint()
            if (r5 != 0) goto L_0x0037
            goto L_0x004c
        L_0x0037:
            java.util.Map<java.lang.String, com.tal.app.thinkacademy.lib.download.operation.DownloadTask> r5 = r9.mDownloadTasks
            java.lang.Object r5 = r5.get(r4)
            com.tal.app.thinkacademy.lib.download.operation.DownloadTask r5 = (com.tal.app.thinkacademy.lib.download.operation.DownloadTask) r5
            com.tal.app.thinkacademy.lib.download.model.FilePoint r5 = r5.getPoint()
            com.tal.app.thinkacademy.lib.download.operation.DownloadState r5 = r5.getDownloadState()
            com.tal.app.thinkacademy.lib.download.operation.DownloadState r6 = com.tal.app.thinkacademy.lib.download.operation.DownloadState.PAUSE
            if (r5 == r6) goto L_0x0013
            goto L_0x0074
        L_0x004c:
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "空指针taskRealName:"
            r1.append(r5)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0[r3] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.et(r2, r0)
            java.util.Map<java.lang.String, com.tal.app.thinkacademy.lib.download.operation.DownloadTask> r0 = r9.mDownloadTasks
            r0.remove(r4)
            java.util.PriorityQueue<java.lang.String> r0 = r9.waitQueue
            r0.remove(r4)
            java.util.PriorityQueue<java.lang.String> r0 = r9.downloadQueue
            r0.remove(r4)
            return
        L_0x0074:
            if (r4 != 0) goto L_0x0087
            java.util.Map<java.lang.String, com.tal.app.thinkacademy.lib.download.operation.DownloadTask> r1 = r9.mDownloadTasks
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0087
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r5 = "资源都被暂停"
            r1[r3] = r5
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r2, r1)
        L_0x0087:
            if (r4 == 0) goto L_0x0284
            java.util.Map<java.lang.String, com.tal.app.thinkacademy.lib.download.operation.DownloadTask> r1 = r9.mDownloadTasks
            int r1 = r1.size()
            if (r1 != 0) goto L_0x0093
            goto L_0x0284
        L_0x0093:
            r9.startTrackNetSpeed()
            java.util.PriorityQueue<java.lang.String> r1 = r9.downloadQueue
            int r1 = r1.size()
            int r5 = r9.taskMaxNum
            if (r1 != r5) goto L_0x021a
            java.util.PriorityQueue<java.lang.String> r1 = r9.downloadQueue
            java.lang.Object r1 = r1.peek()
            java.lang.String r1 = (java.lang.String) r1
            java.util.Map<java.lang.String, com.tal.app.thinkacademy.lib.download.operation.DownloadTask> r5 = r9.mDownloadTasks
            java.lang.Object r5 = r5.get(r4)
            com.tal.app.thinkacademy.lib.download.operation.DownloadTask r5 = (com.tal.app.thinkacademy.lib.download.operation.DownloadTask) r5
            com.tal.app.thinkacademy.lib.download.model.FilePoint r5 = r5.getPoint()
            boolean r5 = r5.isFirst()
            if (r5 == 0) goto L_0x00d5
            java.lang.Object[] r5 = new java.lang.Object[r0]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "目标下载优先："
            r6.append(r7)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            r5[r3] = r6
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r2, r5)
        L_0x00d2:
            r5 = r0
            goto L_0x0160
        L_0x00d5:
            java.util.Map<java.lang.String, com.tal.app.thinkacademy.lib.download.operation.DownloadTask> r5 = r9.mDownloadTasks
            java.lang.Object r5 = r5.get(r1)
            com.tal.app.thinkacademy.lib.download.operation.DownloadTask r5 = (com.tal.app.thinkacademy.lib.download.operation.DownloadTask) r5
            com.tal.app.thinkacademy.lib.download.model.FilePoint r5 = r5.getPoint()
            boolean r5 = r5.isFirst()
            if (r5 == 0) goto L_0x0100
            java.lang.Object[] r5 = new java.lang.Object[r0]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "正在下载优先："
            r6.append(r7)
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            r5[r3] = r6
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r2, r5)
            goto L_0x013a
        L_0x0100:
            java.util.Map<java.lang.String, com.tal.app.thinkacademy.lib.download.operation.DownloadTask> r5 = r9.mDownloadTasks
            java.lang.Object r5 = r5.get(r1)
            if (r5 == 0) goto L_0x013c
            java.util.Map<java.lang.String, com.tal.app.thinkacademy.lib.download.operation.DownloadTask> r5 = r9.mDownloadTasks
            java.lang.Object r5 = r5.get(r1)
            com.tal.app.thinkacademy.lib.download.operation.DownloadTask r5 = (com.tal.app.thinkacademy.lib.download.operation.DownloadTask) r5
            com.tal.app.thinkacademy.lib.download.model.FilePoint r5 = r5.getPoint()
            if (r5 != 0) goto L_0x0117
            goto L_0x013c
        L_0x0117:
            java.util.Map<java.lang.String, com.tal.app.thinkacademy.lib.download.operation.DownloadTask> r5 = r9.mDownloadTasks
            java.lang.Object r5 = r5.get(r4)
            com.tal.app.thinkacademy.lib.download.operation.DownloadTask r5 = (com.tal.app.thinkacademy.lib.download.operation.DownloadTask) r5
            com.tal.app.thinkacademy.lib.download.model.FilePoint r5 = r5.getPoint()
            int r5 = r5.getPriority()
            java.util.Map<java.lang.String, com.tal.app.thinkacademy.lib.download.operation.DownloadTask> r6 = r9.mDownloadTasks
            java.lang.Object r6 = r6.get(r1)
            com.tal.app.thinkacademy.lib.download.operation.DownloadTask r6 = (com.tal.app.thinkacademy.lib.download.operation.DownloadTask) r6
            com.tal.app.thinkacademy.lib.download.model.FilePoint r6 = r6.getPoint()
            int r6 = r6.getPriority()
            if (r5 >= r6) goto L_0x013a
            goto L_0x00d2
        L_0x013a:
            r5 = r3
            goto L_0x0160
        L_0x013c:
            java.lang.Object[] r5 = new java.lang.Object[r0]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "空指针realName:"
            r6.append(r7)
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            r5[r3] = r6
            com.tal.app.thinkacademy.lib.logger.XesLog.et(r2, r5)
            java.util.Map<java.lang.String, com.tal.app.thinkacademy.lib.download.operation.DownloadTask> r5 = r9.mDownloadTasks
            r5.remove(r1)
            java.util.PriorityQueue<java.lang.String> r5 = r9.waitQueue
            r5.remove(r1)
            goto L_0x00d2
        L_0x0160:
            if (r5 == 0) goto L_0x0210
            java.lang.Object[] r5 = new java.lang.Object[r0]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "需要插队："
            r6.append(r7)
            r6.append(r4)
            java.lang.String r8 = "\n原来是:"
            r6.append(r8)
            r6.append(r1)
            java.lang.String r6 = r6.toString()
            r5[r3] = r6
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r2, r5)
            java.lang.Object[] r5 = new java.lang.Object[r0]
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r7)
            java.util.Map<java.lang.String, com.tal.app.thinkacademy.lib.download.operation.DownloadTask> r7 = r9.mDownloadTasks
            java.lang.Object r7 = r7.get(r4)
            com.tal.app.thinkacademy.lib.download.operation.DownloadTask r7 = (com.tal.app.thinkacademy.lib.download.operation.DownloadTask) r7
            com.tal.app.thinkacademy.lib.download.model.FilePoint r7 = r7.getPoint()
            boolean r7 = r7.isFirst()
            r6.append(r7)
            r6.append(r8)
            java.util.Map<java.lang.String, com.tal.app.thinkacademy.lib.download.operation.DownloadTask> r7 = r9.mDownloadTasks
            java.lang.Object r7 = r7.get(r1)
            com.tal.app.thinkacademy.lib.download.operation.DownloadTask r7 = (com.tal.app.thinkacademy.lib.download.operation.DownloadTask) r7
            com.tal.app.thinkacademy.lib.download.model.FilePoint r7 = r7.getPoint()
            boolean r7 = r7.isFirst()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5[r3] = r6
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r2, r5)
            java.util.Map<java.lang.String, com.tal.app.thinkacademy.lib.download.operation.DownloadTask> r5 = r9.mDownloadTasks
            java.lang.Object r5 = r5.get(r1)
            com.tal.app.thinkacademy.lib.download.operation.DownloadTask r5 = (com.tal.app.thinkacademy.lib.download.operation.DownloadTask) r5
            r5.pause()
            java.util.PriorityQueue<java.lang.String> r5 = r9.downloadQueue
            r5.remove(r1)
            java.util.PriorityQueue<java.lang.String> r5 = r9.waitQueue
            r5.offer(r1)
            java.util.Map<java.lang.String, com.tal.app.thinkacademy.lib.download.operation.DownloadTask> r5 = r9.mDownloadTasks
            java.lang.Object r1 = r5.get(r1)
            com.tal.app.thinkacademy.lib.download.operation.DownloadTask r1 = (com.tal.app.thinkacademy.lib.download.operation.DownloadTask) r1
            com.tal.app.thinkacademy.lib.download.model.FilePoint r1 = r1.getPoint()
            r1.setFirst(r3)
            java.util.PriorityQueue<java.lang.String> r1 = r9.waitQueue
            r1.remove(r4)
            java.util.PriorityQueue<java.lang.String> r1 = r9.downloadQueue
            r1.offer(r4)
            java.util.Map<java.lang.String, com.tal.app.thinkacademy.lib.download.operation.DownloadTask> r1 = r9.mDownloadTasks
            java.lang.Object r1 = r1.get(r4)
            com.tal.app.thinkacademy.lib.download.operation.DownloadTask r1 = (com.tal.app.thinkacademy.lib.download.operation.DownloadTask) r1
            r1.start()
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "插队开始下载："
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r1[r3] = r4
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r2, r1)
            goto L_0x0247
        L_0x0210:
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r4 = "不需要插队"
            r1[r3] = r4
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r2, r1)
            goto L_0x0247
        L_0x021a:
            java.util.PriorityQueue<java.lang.String> r1 = r9.waitQueue
            r1.remove(r4)
            java.util.PriorityQueue<java.lang.String> r1 = r9.downloadQueue
            r1.offer(r4)
            java.util.Map<java.lang.String, com.tal.app.thinkacademy.lib.download.operation.DownloadTask> r1 = r9.mDownloadTasks
            java.lang.Object r1 = r1.get(r4)
            com.tal.app.thinkacademy.lib.download.operation.DownloadTask r1 = (com.tal.app.thinkacademy.lib.download.operation.DownloadTask) r1
            r1.start()
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "正常开始下载："
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r1[r3] = r4
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r2, r1)
        L_0x0247:
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "等待队列："
            r4.append(r5)
            java.util.PriorityQueue<java.lang.String> r5 = r9.waitQueue
            java.lang.String r5 = r5.toString()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r1[r3] = r4
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r2, r1)
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "下载队列："
            r1.append(r4)
            java.util.PriorityQueue<java.lang.String> r4 = r9.downloadQueue
            java.lang.String r4 = r4.toString()
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0[r3] = r1
            com.tal.app.thinkacademy.lib.logger.XesLog.it(r2, r0)
            return
        L_0x0284:
            r9.stopTrackNetSpeed()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.download.operation.DownloadQueueManager.download():void");
    }

    public void download(FilePoint filePoint, DownloadListener downloadListener) {
        add(filePoint, downloadListener);
        download();
    }

    public String getFileName(String str) {
        return str.substring(str.lastIndexOf("/") + 1);
    }

    private void add(FilePoint filePoint, DownloadListener downloadListener) {
        if (filePoint == null || TextUtils.isEmpty(filePoint.getRealUrl())) {
            XesLog.it(TAG, "add()  下载地址为空");
            return;
        }
        if (TextUtils.isEmpty(filePoint.getFilePath())) {
            filePoint.setFilePath(ResOperationUtil.getDefaultDirectory());
        }
        if (TextUtils.isEmpty(filePoint.getFileName())) {
            filePoint.setFileName(getFileName(filePoint.getRealUrl()));
        }
        String realFileName = filePoint.getRealFileName();
        XesLog.it(TAG, "文件realName：" + realFileName);
        if (TextUtils.isEmpty(realFileName) || this.mDownloadTasks.get(realFileName) == null) {
            this.mDownloadTasks.put(realFileName, new DownloadTask(filePoint, downloadListener));
        } else if (!this.downloadQueue.contains(realFileName) && filePoint.getListener() != null) {
            this.mDownloadTasks.get(realFileName).setPoint(filePoint);
            this.mDownloadTasks.get(realFileName).setListner(downloadListener);
        }
        if (this.waitQueue.contains(realFileName)) {
            this.waitQueue.remove(realFileName);
            this.waitQueue.offer(realFileName);
        } else if (!this.downloadQueue.contains(realFileName)) {
            this.waitQueue.offer(realFileName);
        }
    }

    public static DownloadQueueManager getInstance() {
        if (mInstance == null) {
            synchronized (DownloadQueueManager.class) {
                if (mInstance == null) {
                    mInstance = new DownloadQueueManager();
                }
            }
        }
        return mInstance;
    }

    public boolean isDownloading(String... strArr) {
        boolean z = false;
        for (String str : strArr) {
            if (this.mDownloadTasks.containsKey(str)) {
                z = this.mDownloadTasks.get(str).isDownloading();
            }
        }
        return z;
    }

    public String getDownloadingUrl(String str) {
        return (str == null || !this.mDownloadTasks.containsKey(str) || !this.mDownloadTasks.get(str).isDownloading()) ? "" : str;
    }

    public boolean isDownloading() {
        Map<String, DownloadTask> map = this.mDownloadTasks;
        if (!(map == null || map.size() == 0)) {
            for (String str : this.mDownloadTasks.keySet()) {
                if (this.mDownloadTasks.get(str).isDownloading()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void pause(String... strArr) {
        XesLog.it(TAG, "调用暂停" + strArr);
        for (String str : strArr) {
            if (this.mDownloadTasks.containsKey(str)) {
                this.mDownloadTasks.get(str).pause();
            }
        }
    }

    public void cancel(String... strArr) {
        XesLog.it(TAG, "调用取消" + strArr);
        for (String str : strArr) {
            if (this.mDownloadTasks.containsKey(str)) {
                this.mDownloadTasks.get(str).cancel();
                onDownloadEnd(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void pauseAll(int i) {
        Map<String, DownloadTask> map = this.mDownloadTasks;
        if (map != null && map.size() != 0) {
            XesLog.dt(TAG, "暂停所有任务 " + this.mDownloadTasks.keySet());
            for (String next : this.mDownloadTasks.keySet()) {
                FilePoint point = this.mDownloadTasks.get(next).getPoint();
                if (point != null && point.getResType() == i) {
                    this.mDownloadTasks.get(next).pause();
                    this.mDownloadTasks.get(next).getPoint().setDownloadState(DownloadState.PAUSE);
                    if (this.downloadQueue.remove(next)) {
                        this.waitQueue.offer(next);
                    }
                }
            }
            download();
        }
    }

    /* access modifiers changed from: package-private */
    public void resumeAll(int i) {
        Map<String, DownloadTask> map = this.mDownloadTasks;
        if (map != null && map.size() != 0) {
            XesLog.dt(TAG, "恢复所有任务 " + this.mDownloadTasks.keySet());
            for (String next : this.mDownloadTasks.keySet()) {
                if (this.mDownloadTasks.get(next).getPoint() != null) {
                    this.mDownloadTasks.get(next).getPoint().setDownloadState(DownloadState.START);
                }
            }
            download();
        }
    }

    public synchronized void onDownloadEnd(String str) {
        this.waitQueue.remove(str);
        this.downloadQueue.remove(str);
        this.mDownloadTasks.remove(str);
        XesLog.it(TAG, "download结束：" + str);
        download();
    }

    private void clearAllTask() {
        this.waitQueue.clear();
        this.downloadQueue.clear();
        this.mDownloadTasks.clear();
        XesLog.it(TAG, "清空所有下载任务：waitQueue size:" + this.waitQueue.size() + " downloadQueue size:" + this.downloadQueue.size() + " mDownloadTasks size:" + this.mDownloadTasks.size());
    }

    public void setTaskMaxNum(int i) {
        this.taskMaxNum = i;
        download();
    }

    private int getCurrentMaxPriority() {
        Map<String, DownloadTask> map = this.mDownloadTasks;
        if (map == null || map.size() == 0) {
            return 0;
        }
        int i = 1001;
        for (String str : this.mDownloadTasks.keySet()) {
            DownloadTask downloadTask = this.mDownloadTasks.get(str);
            if (i > downloadTask.getPoint().getPriority()) {
                i = downloadTask.getPoint().getPriority();
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    public double getCurrentNetSpeed() {
        long totalRxBytes = TrafficStats.getTotalRxBytes() + TrafficStats.getTotalTxBytes();
        this.rxtxTotal = totalRxBytes;
        return (((double) (totalRxBytes - this.rxtxTotal)) * 1000.0d) / ((double) this.TIME_SPAN);
    }

    /* access modifiers changed from: private */
    public String showSpeed(double d) {
        if (d >= 1048576.0d) {
            return this.showFloatFormat.format(d / 1048576.0d) + "MB/s";
        }
        return this.showFloatFormat.format(d / 1024.0d) + "KB/s";
    }

    public void startTrackNetSpeed() {
        if (this.speedTimer == null) {
            getCurrentNetSpeed();
            Timer timer = new Timer();
            this.speedTimer = timer;
            AnonymousClass3 r2 = new TimerTask() {
                public void run() {
                    double access$100 = DownloadQueueManager.this.getCurrentNetSpeed();
                    DownloadQueueManager downloadQueueManager = DownloadQueueManager.this;
                    String unused = downloadQueueManager.netSpeed = downloadQueueManager.showSpeed(access$100);
                    Iterator it = new PriorityQueue(DownloadQueueManager.this.downloadQueue).iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (DownloadQueueManager.this.mDownloadTasks != null && DownloadQueueManager.this.mDownloadTasks.get(str) != null && ((DownloadTask) DownloadQueueManager.this.mDownloadTasks.get(str)).getPoint() != null && ((DownloadTask) DownloadQueueManager.this.mDownloadTasks.get(str)).getPoint().getListener() != null) {
                            DownloadTask downloadTask = (DownloadTask) DownloadQueueManager.this.mDownloadTasks.get(str);
                            downloadTask.getPoint().getListener().onNetSpeed(DownloadQueueManager.this.netSpeed, access$100, downloadTask.getProgress());
                        } else {
                            return;
                        }
                    }
                }
            };
            long j = this.TIME_SPAN;
            timer.schedule(r2, j, j);
        }
    }

    public void stopTrackNetSpeed() {
        if (this.speedTimer != null) {
            XesLog.it(TAG, "stopTrackNetSpeed");
            this.speedTimer.cancel();
            this.speedTimer = null;
        }
    }

    public String getNetSpeed() {
        return this.netSpeed;
    }
}
