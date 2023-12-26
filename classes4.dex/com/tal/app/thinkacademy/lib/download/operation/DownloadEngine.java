package com.tal.app.thinkacademy.lib.download.operation;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.tal.app.thinkacademy.lib.download.config.RSAConfig;
import com.tal.app.thinkacademy.lib.download.listener.DownloadListener;
import com.tal.app.thinkacademy.lib.download.listener.FilePointProvider;
import com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListener;
import com.tal.app.thinkacademy.lib.download.model.FilePoint;
import com.tal.app.thinkacademy.lib.download.model.OnlineResFile;
import com.tal.app.thinkacademy.lib.download.util.AppCacheUtil;
import com.tal.app.thinkacademy.lib.download.util.ResOperationUtil;
import com.tal.app.thinkacademy.lib.download.util.ZipUtils;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import com.tal.app.thinkacademy.lib.util.CollectionUtils;
import com.tal.app.thinkacademy.lib.util.DiffUtils;
import com.tal.app.thinkacademy.lib.util.FileUtils;
import com.tal.app.thinkacademy.lib.util.StorageUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import okhttp3.Dns;

public class DownloadEngine {
    public static final String TAG = "DownloadEngine";
    /* access modifiers changed from: private */
    public static final Executor io = Executors.newCachedThreadPool();
    private static DownloadEngine mInstance;
    /* access modifiers changed from: private */
    public Application application;
    private CompositeDisposable disposableList;
    private Dns dns;
    /* access modifiers changed from: private */
    public MainThreadExecutor mainThreadExecutor;
    private FilePointProvider provider;

    public void setProvider(FilePointProvider filePointProvider) {
        this.provider = filePointProvider;
    }

    public static DownloadEngine getInstance() {
        if (mInstance == null) {
            synchronized (DownloadEngine.class) {
                if (mInstance == null) {
                    mInstance = new DownloadEngine();
                }
            }
        }
        return mInstance;
    }

    private DownloadEngine() {
        if (this.mainThreadExecutor == null) {
            this.mainThreadExecutor = new MainThreadExecutor();
        }
        if (this.disposableList == null) {
            this.disposableList = new CompositeDisposable();
        }
    }

    public void init(Application application2, String str) {
        this.application = application2;
        RSAConfig.sRsaPublicKey = str;
    }

    public void setDns(Dns dns2) {
        this.dns = dns2;
    }

    public Dns getDns() {
        return this.dns;
    }

    public void destroyDisposable() {
        if (!this.disposableList.isDisposed()) {
            this.disposableList.dispose();
        }
    }

    public void download(FilePoint filePoint, SimpleDownloadListener simpleDownloadListener) {
        if (filePoint != null) {
            filePoint.setListener(simpleDownloadListener);
            filePoint.setResType(ResourceType.RES_TYPE_ONLINE.value);
            downloadInternal(filePoint, new ImpDownloadListener(filePoint, simpleDownloadListener));
        }
    }

    public void download(FilePoint filePoint, int i, SimpleDownloadListener simpleDownloadListener) {
        if (filePoint != null) {
            filePoint.setListener(simpleDownloadListener);
            filePoint.setResType(i);
            downloadInternal(filePoint, new ImpDownloadListener(filePoint, simpleDownloadListener));
        }
    }

    public void download(List<FilePoint> list, SimpleDownloadListener simpleDownloadListener) {
        if (!CollectionUtils.isEmpty(list)) {
            for (FilePoint next : list) {
                if (next != null) {
                    next.setListener(simpleDownloadListener);
                    next.setResType(ResourceType.RES_TYPE_ONLINE.value);
                    downloadInternal(next, new ImpDownloadListener(next, simpleDownloadListener));
                }
            }
        }
    }

    public void download(List<FilePoint> list, int i, SimpleDownloadListener simpleDownloadListener) {
        if (!CollectionUtils.isEmpty(list)) {
            for (FilePoint next : list) {
                if (next != null) {
                    next.setListener(simpleDownloadListener);
                    next.setResType(i);
                    downloadInternal(next, new ImpDownloadListener(next, simpleDownloadListener));
                }
            }
        }
    }

    public void addDownloadQueue(OnlineResFile onlineResFile, SimpleDownloadListener simpleDownloadListener) {
        if (onlineResFile != null) {
            download(assembleData(onlineResFile), simpleDownloadListener);
        }
    }

    private List<FilePoint> assembleData(OnlineResFile onlineResFile) {
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtils.isEmpty(onlineResFile.getHighPriorityRes())) {
            List<OnlineResFile.ResourceData> highPriorityRes = onlineResFile.getHighPriorityRes();
            for (int i = 0; i < highPriorityRes.size(); i++) {
                FilePoint create = this.provider.create();
                create.setUrl(highPriorityRes.get(i).url);
                create.setResBusinessType(highPriorityRes.get(i).resBusinessType);
                create.setExpandData(highPriorityRes.get(i).expandData);
                create.setFilePath(highPriorityRes.get(i).filePath);
                create.setUnZipPath(highPriorityRes.get(i).unZipPath);
                create.setFileName(highPriorityRes.get(i).fileName);
                create.setMd5(highPriorityRes.get(i).md5);
                create.setVersion(highPriorityRes.get(i).version);
                create.setLocalVersion(highPriorityRes.get(i).localVersion);
                create.setDiff(highPriorityRes.get(i).isDiff);
                create.setFileSize(highPriorityRes.get(i).fileSize);
                create.setUnZipFileSize(highPriorityRes.get(i).unZipFileSize);
                create.setIgnoreSRAVerify(highPriorityRes.get(i).isIgnoreSRAVerify);
                create.setPriority(highPriorityRes.get(i).isHighPriorityRes ? 201 : 1001);
                arrayList.add(create);
            }
        }
        if (!CollectionUtils.isEmpty(onlineResFile.getDefaultPriorityRes())) {
            List<OnlineResFile.ResourceData> defaultPriorityRes = onlineResFile.getDefaultPriorityRes();
            for (int i2 = 0; i2 < defaultPriorityRes.size(); i2++) {
                FilePoint create2 = this.provider.create();
                create2.setUrl(defaultPriorityRes.get(i2).url);
                create2.setResBusinessType(defaultPriorityRes.get(i2).resBusinessType);
                create2.setExpandData(defaultPriorityRes.get(i2).expandData);
                create2.setFilePath(defaultPriorityRes.get(i2).filePath);
                create2.setUnZipPath(defaultPriorityRes.get(i2).unZipPath);
                create2.setFileName(defaultPriorityRes.get(i2).fileName);
                create2.setMd5(defaultPriorityRes.get(i2).md5);
                create2.setVersion(defaultPriorityRes.get(i2).version);
                create2.setLocalVersion(defaultPriorityRes.get(i2).localVersion);
                create2.setDiff(defaultPriorityRes.get(i2).isDiff);
                create2.setFileSize(defaultPriorityRes.get(i2).fileSize);
                create2.setUnZipFileSize(defaultPriorityRes.get(i2).unZipFileSize);
                create2.setIgnoreSRAVerify(true);
                create2.setPriority(defaultPriorityRes.get(i2).isHighPriorityRes ? 201 : 1001);
                arrayList.add(create2);
            }
        }
        return arrayList;
    }

    public void pauseOnlineAll() {
        DownloadQueueManager.getInstance().pauseAll(ResourceType.RES_TYPE_ONLINE.value);
    }

    public void resumeOnlineAll() {
        DownloadQueueManager.getInstance().resumeAll(ResourceType.RES_TYPE_ONLINE.value);
    }

    public void cancel(String... strArr) {
        DownloadQueueManager.getInstance().cancel(strArr);
    }

    private void downloadInternal(final FilePoint filePoint, final DownloadListener downloadListener) {
        if (filePoint != null) {
            if (filePoint.isHighPriorityRes()) {
                filePoint.setPriority(201);
            }
            if (isSpaceAvailable(filePoint)) {
                DownloadQueueManager.getInstance().download(filePoint, downloadListener);
            } else {
                Observable.create(new ObservableOnSubscribe<String>() {
                    public void subscribe(ObservableEmitter<String> observableEmitter) {
                        DownloadEngine.this.clearAppCache();
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
                    public void accept(String str) {
                        if (DownloadEngine.this.isSpaceAvailable(filePoint)) {
                            DownloadQueueManager.getInstance().download(filePoint, downloadListener);
                        } else if (filePoint.getListener() != null) {
                            filePoint.getListener().onStorageSpaceNotEnough(filePoint);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean isSpaceAvailable(FilePoint filePoint) {
        return StorageUtil.getAvailableSize(this.application) > filePoint.getFileSize();
    }

    public void clearAppCache() {
        AppCacheUtil.clearCache(this.application);
    }

    private boolean getDownUrl(String str) {
        return !TextUtils.isEmpty(DownloadQueueManager.getInstance().getDownloadingUrl(str));
    }

    class ImpDownloadListener implements DownloadListener {
        /* access modifiers changed from: private */
        public WeakReference<SimpleDownloadListener> mDownLoadListener;
        private FilePoint mFilePoint;

        public ImpDownloadListener(FilePoint filePoint, SimpleDownloadListener simpleDownloadListener) {
            this.mFilePoint = filePoint;
            if (filePoint != null) {
                this.mDownLoadListener = new WeakReference<>(simpleDownloadListener);
            }
        }

        public void onStart(FilePoint filePoint) {
            XesLog.it(DownloadEngine.TAG, "onStart() " + filePoint.toString());
            WeakReference<SimpleDownloadListener> weakReference = this.mDownLoadListener;
            if (!(weakReference == null || weakReference.get() == null)) {
                ((SimpleDownloadListener) this.mDownLoadListener.get()).onStart(filePoint);
            }
            if (filePoint != null) {
                filePoint.onStart();
            }
        }

        public void onFinished(final FilePoint filePoint) {
            XesLog.it(DownloadEngine.TAG, "onFinished() " + filePoint.toString());
            WeakReference<SimpleDownloadListener> weakReference = this.mDownLoadListener;
            if (!(weakReference == null || weakReference.get() == null)) {
                ((SimpleDownloadListener) this.mDownLoadListener.get()).onDownloadOver(filePoint);
            }
            DownloadEngine.io.execute(new Runnable() {
                public void run() {
                    ImpDownloadListener.this.finishOption(filePoint);
                }
            });
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x0263, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void finishOption(final com.tal.app.thinkacademy.lib.download.model.FilePoint r12) {
            /*
                r11 = this;
                monitor-enter(r11)
                r0 = 0
                r12.setDownloadDuration(r0)     // Catch:{ all -> 0x0264 }
                java.lang.String r0 = r12.getMd5()     // Catch:{ all -> 0x0264 }
                boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0264 }
                if (r0 == 0) goto L_0x002b
                com.tal.app.thinkacademy.lib.download.operation.DownloadEngine r0 = com.tal.app.thinkacademy.lib.download.operation.DownloadEngine.this     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.download.operation.DownloadEngine$MainThreadExecutor r0 = r0.mainThreadExecutor     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.download.operation.DownloadEngine$ImpDownloadListener$2 r1 = new com.tal.app.thinkacademy.lib.download.operation.DownloadEngine$ImpDownloadListener$2     // Catch:{ all -> 0x0264 }
                r1.<init>(r12)     // Catch:{ all -> 0x0264 }
                r0.execute(r1)     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.download.operation.DownloadQueueManager r0 = com.tal.app.thinkacademy.lib.download.operation.DownloadQueueManager.getInstance()     // Catch:{ all -> 0x0264 }
                java.lang.String r12 = r12.getRealFileName()     // Catch:{ all -> 0x0264 }
                r0.onDownloadEnd(r12)     // Catch:{ all -> 0x0264 }
                monitor-exit(r11)
                return
            L_0x002b:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0264 }
                r0.<init>()     // Catch:{ all -> 0x0264 }
                java.lang.String r1 = r12.getFilePath()     // Catch:{ all -> 0x0264 }
                r0.append(r1)     // Catch:{ all -> 0x0264 }
                java.lang.String r1 = r12.getRealFileName()     // Catch:{ all -> 0x0264 }
                r0.append(r1)     // Catch:{ all -> 0x0264 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0264 }
                java.lang.String r1 = "DownloadEngine"
                r2 = 1
                java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x0264 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0264 }
                r4.<init>()     // Catch:{ all -> 0x0264 }
                java.lang.String r5 = "下载的文件："
                r4.append(r5)     // Catch:{ all -> 0x0264 }
                r4.append(r0)     // Catch:{ all -> 0x0264 }
                java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0264 }
                r5 = 0
                r3[r5] = r4     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.logger.XesLog.it(r1, r3)     // Catch:{ all -> 0x0264 }
                boolean r1 = com.tal.app.thinkacademy.lib.util.FileUtils.isFileExists((java.lang.String) r0)     // Catch:{ all -> 0x0264 }
                java.lang.String r3 = "DownloadEngine"
                java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x0264 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0264 }
                r6.<init>()     // Catch:{ all -> 0x0264 }
                java.lang.String r7 = "下载文件是否存在："
                r6.append(r7)     // Catch:{ all -> 0x0264 }
                r6.append(r1)     // Catch:{ all -> 0x0264 }
                java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0264 }
                r4[r5] = r6     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.logger.XesLog.it(r3, r4)     // Catch:{ all -> 0x0264 }
                r3 = 10004(0x2714, float:1.4019E-41)
                if (r1 != 0) goto L_0x0085
                r11.finishErrorOption(r12, r3, r5)     // Catch:{ all -> 0x0264 }
                monitor-exit(r11)
                return
            L_0x0085:
                boolean r4 = r12.isIgnoreSRAVerify()     // Catch:{ all -> 0x0264 }
                if (r4 != 0) goto L_0x00a1
                java.lang.String r4 = com.tal.app.thinkacademy.lib.download.config.RSAConfig.sRsaPublicKey     // Catch:{ all -> 0x0264 }
                boolean r4 = com.tal.app.thinkacademy.lib.util.StringUtils.isEmpty(r4)     // Catch:{ all -> 0x0264 }
                if (r4 != 0) goto L_0x00a1
                java.lang.String r4 = com.tal.app.thinkacademy.lib.download.config.RSAConfig.sRsaPublicKey     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.util.RSA.setRsaPublicKey(r4)     // Catch:{ all -> 0x0264 }
                java.lang.String r4 = r12.getMd5()     // Catch:{ all -> 0x0264 }
                java.lang.String r4 = com.tal.app.thinkacademy.lib.util.RSA.decryptByPublic(r4)     // Catch:{ all -> 0x0264 }
                goto L_0x00a5
            L_0x00a1:
                java.lang.String r4 = r12.getMd5()     // Catch:{ all -> 0x0264 }
            L_0x00a5:
                java.io.File r6 = com.tal.app.thinkacademy.lib.util.FileUtils.getFileByPath(r0)     // Catch:{ all -> 0x0264 }
                java.lang.String r6 = com.tal.app.thinkacademy.lib.util.EncryptUtils.encodeFile(r6)     // Catch:{ all -> 0x0264 }
                java.lang.String r7 = "DownloadEngine"
                java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ all -> 0x0264 }
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0264 }
                r9.<init>()     // Catch:{ all -> 0x0264 }
                java.lang.String r10 = "服务端md5="
                r9.append(r10)     // Catch:{ all -> 0x0264 }
                r9.append(r4)     // Catch:{ all -> 0x0264 }
                java.lang.String r10 = " 本地md5="
                r9.append(r10)     // Catch:{ all -> 0x0264 }
                r9.append(r6)     // Catch:{ all -> 0x0264 }
                java.lang.String r10 = ","
                r9.append(r10)     // Catch:{ all -> 0x0264 }
                java.lang.String r10 = r12.getFileName()     // Catch:{ all -> 0x0264 }
                r9.append(r10)     // Catch:{ all -> 0x0264 }
                java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0264 }
                r8[r5] = r9     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.logger.XesLog.it(r7, r8)     // Catch:{ all -> 0x0264 }
                if (r1 == 0) goto L_0x023d
                boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0264 }
                if (r1 != 0) goto L_0x023d
                boolean r1 = r4.equalsIgnoreCase(r6)     // Catch:{ all -> 0x0264 }
                if (r1 == 0) goto L_0x023d
                com.tal.app.thinkacademy.lib.download.operation.DownloadEngine r1 = com.tal.app.thinkacademy.lib.download.operation.DownloadEngine.this     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.download.operation.DownloadEngine$MainThreadExecutor r1 = r1.mainThreadExecutor     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.download.operation.DownloadEngine$ImpDownloadListener$3 r4 = new com.tal.app.thinkacademy.lib.download.operation.DownloadEngine$ImpDownloadListener$3     // Catch:{ all -> 0x0264 }
                r4.<init>(r12)     // Catch:{ all -> 0x0264 }
                r1.execute(r4)     // Catch:{ all -> 0x0264 }
                boolean r1 = r12.isDiff()     // Catch:{ all -> 0x0264 }
                if (r1 == 0) goto L_0x0137
                java.lang.String r1 = "DownloadEngine"
                java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x0264 }
                java.lang.String r6 = "是差分包，准备合并"
                r4[r5] = r6     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.logger.XesLog.it(r1, r4)     // Catch:{ all -> 0x0264 }
                java.lang.String r1 = r11.mergeDiff(r12, r0)     // Catch:{ all -> 0x0264 }
                boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0264 }
                if (r4 != 0) goto L_0x012d
                java.lang.String r0 = "DownloadEngine"
                java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x0264 }
                java.lang.String r6 = "合并差分包成功"
                r4[r5] = r6     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.logger.XesLog.it(r0, r4)     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.download.operation.DownloadEngine r0 = com.tal.app.thinkacademy.lib.download.operation.DownloadEngine.this     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.download.operation.DownloadEngine$MainThreadExecutor r0 = r0.mainThreadExecutor     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.download.operation.DownloadEngine$ImpDownloadListener$4 r4 = new com.tal.app.thinkacademy.lib.download.operation.DownloadEngine$ImpDownloadListener$4     // Catch:{ all -> 0x0264 }
                r4.<init>(r12)     // Catch:{ all -> 0x0264 }
                r0.execute(r4)     // Catch:{ all -> 0x0264 }
                r0 = r1
                goto L_0x0137
            L_0x012d:
                com.tal.app.thinkacademy.lib.util.FileUtils.deleteTemp(r0)     // Catch:{ all -> 0x0264 }
                r0 = 10003(0x2713, float:1.4017E-41)
                r11.finishErrorOption(r12, r0, r2)     // Catch:{ all -> 0x0264 }
                monitor-exit(r11)
                return
            L_0x0137:
                boolean r1 = com.tal.app.thinkacademy.lib.util.FileUtils.isFileExists((java.lang.String) r0)     // Catch:{ all -> 0x0264 }
                java.lang.String r4 = "DownloadEngine"
                java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x0264 }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0264 }
                r7.<init>()     // Catch:{ all -> 0x0264 }
                java.lang.String r8 = "新文件是否存在"
                r7.append(r8)     // Catch:{ all -> 0x0264 }
                r7.append(r1)     // Catch:{ all -> 0x0264 }
                java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0264 }
                r6[r5] = r7     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.logger.XesLog.it(r4, r6)     // Catch:{ all -> 0x0264 }
                java.lang.String r4 = r12.getLocalVersion()     // Catch:{ all -> 0x0264 }
                boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0264 }
                if (r4 != 0) goto L_0x01ac
                java.lang.String r4 = r12.getFileNameByLocalVersion()     // Catch:{ all -> 0x0264 }
                boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0264 }
                if (r4 != 0) goto L_0x01ac
                java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0264 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0264 }
                r6.<init>()     // Catch:{ all -> 0x0264 }
                java.lang.String r7 = r12.getFilePath()     // Catch:{ all -> 0x0264 }
                r6.append(r7)     // Catch:{ all -> 0x0264 }
                java.lang.String r7 = r12.getFileNameByLocalVersion()     // Catch:{ all -> 0x0264 }
                r6.append(r7)     // Catch:{ all -> 0x0264 }
                java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0264 }
                r4.<init>(r6)     // Catch:{ all -> 0x0264 }
                boolean r6 = r4.exists()     // Catch:{ all -> 0x0264 }
                if (r6 == 0) goto L_0x01ac
                java.lang.String r6 = "DownloadEngine"
                java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ all -> 0x0264 }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0264 }
                r8.<init>()     // Catch:{ all -> 0x0264 }
                java.lang.String r9 = "需要删除老文件："
                r8.append(r9)     // Catch:{ all -> 0x0264 }
                java.lang.String r9 = r4.getPath()     // Catch:{ all -> 0x0264 }
                r8.append(r9)     // Catch:{ all -> 0x0264 }
                java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0264 }
                r7[r5] = r8     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.logger.XesLog.it(r6, r7)     // Catch:{ all -> 0x0264 }
                r4.delete()     // Catch:{ all -> 0x0264 }
            L_0x01ac:
                if (r1 == 0) goto L_0x0239
                java.lang.String r1 = r12.getUnZipPath()     // Catch:{ all -> 0x0264 }
                boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0264 }
                if (r1 != 0) goto L_0x022a
                boolean r1 = r11.unzip(r12, r0)     // Catch:{ all -> 0x0264 }
                if (r1 != 0) goto L_0x01cf
                com.tal.app.thinkacademy.lib.util.FileUtils.deleteTemp(r0)     // Catch:{ all -> 0x0264 }
                java.lang.String r0 = r12.getUnZipPath()     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.util.FileUtils.deleteTemp(r0)     // Catch:{ all -> 0x0264 }
                r0 = 10001(0x2711, float:1.4014E-41)
                r11.finishErrorOption(r12, r0, r2)     // Catch:{ all -> 0x0264 }
                monitor-exit(r11)
                return
            L_0x01cf:
                java.lang.String r0 = r12.getLocalVersion()     // Catch:{ all -> 0x0264 }
                boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0264 }
                if (r0 != 0) goto L_0x022a
                java.lang.String r0 = r12.getFileNameByLocalVersion()     // Catch:{ all -> 0x0264 }
                boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0264 }
                if (r0 != 0) goto L_0x022a
                java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0264 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0264 }
                r1.<init>()     // Catch:{ all -> 0x0264 }
                java.lang.String r3 = r12.getFilePath()     // Catch:{ all -> 0x0264 }
                r1.append(r3)     // Catch:{ all -> 0x0264 }
                java.lang.String r3 = r12.getFilDirByLocalVersion()     // Catch:{ all -> 0x0264 }
                r1.append(r3)     // Catch:{ all -> 0x0264 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0264 }
                r0.<init>(r1)     // Catch:{ all -> 0x0264 }
                boolean r1 = r0.exists()     // Catch:{ all -> 0x0264 }
                if (r1 == 0) goto L_0x022a
                java.lang.String r1 = "DownloadEngine"
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0264 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0264 }
                r3.<init>()     // Catch:{ all -> 0x0264 }
                java.lang.String r4 = "需要删除老文件夹："
                r3.append(r4)     // Catch:{ all -> 0x0264 }
                java.lang.String r4 = r0.getPath()     // Catch:{ all -> 0x0264 }
                r3.append(r4)     // Catch:{ all -> 0x0264 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0264 }
                r2[r5] = r3     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.logger.XesLog.it(r1, r2)     // Catch:{ all -> 0x0264 }
                java.lang.String r0 = r0.getPath()     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.util.FileUtils.deleteDir(r0, r5)     // Catch:{ all -> 0x0264 }
            L_0x022a:
                com.tal.app.thinkacademy.lib.download.operation.DownloadEngine r0 = com.tal.app.thinkacademy.lib.download.operation.DownloadEngine.this     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.download.operation.DownloadEngine$MainThreadExecutor r0 = r0.mainThreadExecutor     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.download.operation.DownloadEngine$ImpDownloadListener$5 r1 = new com.tal.app.thinkacademy.lib.download.operation.DownloadEngine$ImpDownloadListener$5     // Catch:{ all -> 0x0264 }
                r1.<init>(r12)     // Catch:{ all -> 0x0264 }
                r0.execute(r1)     // Catch:{ all -> 0x0264 }
                goto L_0x0262
            L_0x0239:
                r11.finishErrorOption(r12, r3, r5)     // Catch:{ all -> 0x0264 }
                goto L_0x0262
            L_0x023d:
                java.lang.String r1 = "DownloadEngine"
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0264 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0264 }
                r3.<init>()     // Catch:{ all -> 0x0264 }
                java.lang.String r4 = "文件校验失败 "
                r3.append(r4)     // Catch:{ all -> 0x0264 }
                r3.append(r0)     // Catch:{ all -> 0x0264 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0264 }
                r2[r5] = r3     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.logger.XesLog.it(r1, r2)     // Catch:{ all -> 0x0264 }
                r12.getMd5()     // Catch:{ all -> 0x0264 }
                com.tal.app.thinkacademy.lib.util.FileUtils.deleteTemp(r0)     // Catch:{ all -> 0x0264 }
                r0 = 10002(0x2712, float:1.4016E-41)
                r11.finishErrorOption(r12, r0, r5)     // Catch:{ all -> 0x0264 }
            L_0x0262:
                monitor-exit(r11)
                return
            L_0x0264:
                r12 = move-exception
                monitor-exit(r11)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.download.operation.DownloadEngine.ImpDownloadListener.finishOption(com.tal.app.thinkacademy.lib.download.model.FilePoint):void");
        }

        private void finishErrorOption(final FilePoint filePoint, final int i, final boolean z) {
            DownloadEngine.this.mainThreadExecutor.execute(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:10:0x0064, code lost:
                    r7 = r0;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:12:0x006b, code lost:
                    if (r3.hasNextUr() != false) goto L_0x0090;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:13:0x006d, code lost:
                    r0 = r3;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:14:0x006f, code lost:
                    if (r0 == null) goto L_0x0078;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:15:0x0071, code lost:
                    r0.onFailed(r4, "资源加载失败", "", r7);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:16:0x0078, code lost:
                    ((com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListener) com.tal.app.thinkacademy.lib.download.operation.DownloadEngine.ImpDownloadListener.access$300(r8.this$1).get()).onFailed(r3, r4, "资源加载失败", "", r7);
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r8 = this;
                        com.tal.app.thinkacademy.lib.download.operation.DownloadEngine$ImpDownloadListener r0 = com.tal.app.thinkacademy.lib.download.operation.DownloadEngine.ImpDownloadListener.this
                        java.lang.ref.WeakReference r0 = r0.mDownLoadListener
                        if (r0 == 0) goto L_0x0090
                        com.tal.app.thinkacademy.lib.download.operation.DownloadEngine$ImpDownloadListener r0 = com.tal.app.thinkacademy.lib.download.operation.DownloadEngine.ImpDownloadListener.this
                        java.lang.ref.WeakReference r0 = r0.mDownLoadListener
                        java.lang.Object r0 = r0.get()
                        if (r0 == 0) goto L_0x0090
                        int r0 = r4
                        java.lang.String r1 = ""
                        switch(r0) {
                            case 10001: goto L_0x004d;
                            case 10002: goto L_0x0035;
                            case 10003: goto L_0x001d;
                            default: goto L_0x001b;
                        }
                    L_0x001b:
                        r7 = r1
                        goto L_0x0065
                    L_0x001d:
                        com.tal.app.thinkacademy.lib.download.operation.DownloadEngine$ImpDownloadListener r0 = com.tal.app.thinkacademy.lib.download.operation.DownloadEngine.ImpDownloadListener.this
                        java.lang.ref.WeakReference r0 = r0.mDownLoadListener
                        java.lang.Object r0 = r0.get()
                        com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListener r0 = (com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListener) r0
                        com.tal.app.thinkacademy.lib.download.model.FilePoint r2 = r3
                        com.tal.app.thinkacademy.lib.download.operation.OperationState r3 = com.tal.app.thinkacademy.lib.download.operation.OperationState.FAILED
                        int r3 = r3.value
                        r0.onMergeResult(r2, r3)
                        java.lang.String r0 = "包合并失败"
                        goto L_0x0064
                    L_0x0035:
                        com.tal.app.thinkacademy.lib.download.operation.DownloadEngine$ImpDownloadListener r0 = com.tal.app.thinkacademy.lib.download.operation.DownloadEngine.ImpDownloadListener.this
                        java.lang.ref.WeakReference r0 = r0.mDownLoadListener
                        java.lang.Object r0 = r0.get()
                        com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListener r0 = (com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListener) r0
                        com.tal.app.thinkacademy.lib.download.model.FilePoint r2 = r3
                        com.tal.app.thinkacademy.lib.download.operation.OperationState r3 = com.tal.app.thinkacademy.lib.download.operation.OperationState.FAILED
                        int r3 = r3.value
                        r0.onVerifyResult(r2, r3)
                        java.lang.String r0 = "MD5校验失败"
                        goto L_0x0064
                    L_0x004d:
                        com.tal.app.thinkacademy.lib.download.operation.DownloadEngine$ImpDownloadListener r0 = com.tal.app.thinkacademy.lib.download.operation.DownloadEngine.ImpDownloadListener.this
                        java.lang.ref.WeakReference r0 = r0.mDownLoadListener
                        java.lang.Object r0 = r0.get()
                        com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListener r0 = (com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListener) r0
                        com.tal.app.thinkacademy.lib.download.model.FilePoint r2 = r3
                        com.tal.app.thinkacademy.lib.download.operation.OperationState r3 = com.tal.app.thinkacademy.lib.download.operation.OperationState.FAILED
                        int r3 = r3.value
                        r0.onUnZipResult(r2, r3)
                        java.lang.String r0 = "解压失败"
                    L_0x0064:
                        r7 = r0
                    L_0x0065:
                        com.tal.app.thinkacademy.lib.download.model.FilePoint r0 = r3
                        boolean r0 = r0.hasNextUr()
                        if (r0 != 0) goto L_0x0090
                        com.tal.app.thinkacademy.lib.download.model.FilePoint r0 = r3
                        if (r0 == 0) goto L_0x0078
                        int r2 = r4
                        java.lang.String r3 = "资源加载失败"
                        r0.onFailed(r2, r3, r1, r7)
                    L_0x0078:
                        com.tal.app.thinkacademy.lib.download.operation.DownloadEngine$ImpDownloadListener r0 = com.tal.app.thinkacademy.lib.download.operation.DownloadEngine.ImpDownloadListener.this
                        java.lang.ref.WeakReference r0 = r0.mDownLoadListener
                        java.lang.Object r0 = r0.get()
                        r2 = r0
                        com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListener r2 = (com.tal.app.thinkacademy.lib.download.listener.SimpleDownloadListener) r2
                        com.tal.app.thinkacademy.lib.download.model.FilePoint r3 = r3
                        int r4 = r4
                        java.lang.String r5 = "资源加载失败"
                        java.lang.String r6 = ""
                        r2.onFailed(r3, r4, r5, r6, r7)
                    L_0x0090:
                        com.tal.app.thinkacademy.lib.download.operation.DownloadQueueManager r0 = com.tal.app.thinkacademy.lib.download.operation.DownloadQueueManager.getInstance()
                        com.tal.app.thinkacademy.lib.download.model.FilePoint r1 = r3
                        java.lang.String r1 = r1.getRealFileName()
                        r0.onDownloadEnd(r1)
                        com.tal.app.thinkacademy.lib.download.operation.DownloadEngine$ImpDownloadListener r0 = com.tal.app.thinkacademy.lib.download.operation.DownloadEngine.ImpDownloadListener.this
                        com.tal.app.thinkacademy.lib.download.operation.DownloadEngine r0 = com.tal.app.thinkacademy.lib.download.operation.DownloadEngine.this
                        com.tal.app.thinkacademy.lib.download.model.FilePoint r1 = r3
                        boolean r2 = r5
                        r0.trySwitchRes(r1, r2)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.lib.download.operation.DownloadEngine.ImpDownloadListener.AnonymousClass6.run():void");
                }
            });
        }

        private String mergeDiff(FilePoint filePoint, String str) {
            String str2 = filePoint.getFilePath() + filePoint.getFileNameByLocalVersion();
            if (FileUtils.isFileExists(str2)) {
                String version = filePoint.getVersion();
                String resNewPath = ResOperationUtil.getResNewPath(filePoint);
                try {
                    DiffUtils.bsPatch(str2, str, resNewPath);
                    FileUtils.delete(str);
                    filePoint.setVersion(version);
                    return resNewPath;
                } catch (Exception e) {
                    e.printStackTrace();
                    FileUtils.delete(str);
                    XesLog.it(DownloadEngine.TAG, "合并差分包异常");
                }
            }
            return "";
        }

        private boolean unzip(final FilePoint filePoint, String str) {
            if (StorageUtil.getAvailableSize(DownloadEngine.this.application) < filePoint.getUnZipFileSize()) {
                DownloadEngine.this.mainThreadExecutor.execute(new Runnable() {
                    public void run() {
                        if (ImpDownloadListener.this.mDownLoadListener != null && ImpDownloadListener.this.mDownLoadListener.get() != null) {
                            ((SimpleDownloadListener) ImpDownloadListener.this.mDownLoadListener.get()).onStorageSpaceNotEnough(filePoint);
                        }
                    }
                });
                return false;
            }
            String unZipPath = filePoint.getUnZipPath();
            try {
                XesLog.it(DownloadEngine.TAG, "解压线程：" + Thread.currentThread().getName());
                XesLog.it(DownloadEngine.TAG, "文件解压地址" + unZipPath);
                ZipUtils.decompressFile(str, unZipPath);
                XesLog.it(DownloadEngine.TAG, "文件解压成功");
                if (filePoint.isDeleteResAfterDownloadOverAndUnzip()) {
                    FileUtils.delete(str);
                }
                DownloadEngine.this.mainThreadExecutor.execute(new Runnable() {
                    public void run() {
                        if (ImpDownloadListener.this.mDownLoadListener != null && ImpDownloadListener.this.mDownLoadListener.get() != null) {
                            ((SimpleDownloadListener) ImpDownloadListener.this.mDownLoadListener.get()).onUnZipResult(filePoint, OperationState.SUCCESS.value);
                        }
                    }
                });
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                XesLog.it(DownloadEngine.TAG, "文件解压失败" + str);
                FileUtils.deleteDir(unZipPath);
                return false;
            }
        }

        public void onProgress(long j, long j2, FilePoint filePoint) {
            XesLog.dt("onProgress() " + ((((float) j) * 1.0f) / ((float) j2)) + "  " + filePoint.getFileName(), new Object[0]);
            if (filePoint != null) {
                filePoint.onProgress(j, j2);
            }
            WeakReference<SimpleDownloadListener> weakReference = this.mDownLoadListener;
            if (weakReference != null && weakReference.get() != null) {
                ((SimpleDownloadListener) this.mDownLoadListener.get()).onProgress(j, j2, filePoint);
            }
        }

        public void onPause(FilePoint filePoint) {
            XesLog.it(DownloadEngine.TAG, "download---onPause() " + filePoint.toString());
            WeakReference<SimpleDownloadListener> weakReference = this.mDownLoadListener;
            if (weakReference != null && weakReference.get() != null) {
                ((SimpleDownloadListener) this.mDownLoadListener.get()).onPause(filePoint);
            }
        }

        public void onCancel(FilePoint filePoint) {
            XesLog.it(DownloadEngine.TAG, "download---onCancel() " + filePoint.toString());
            WeakReference<SimpleDownloadListener> weakReference = this.mDownLoadListener;
            if (!(weakReference == null || weakReference.get() == null)) {
                ((SimpleDownloadListener) this.mDownLoadListener.get()).onCancel(filePoint);
            }
            DownloadQueueManager.getInstance().onDownloadEnd(filePoint.getRealFileName());
        }

        public void onFailed(FilePoint filePoint, int i, String str, String str2, String str3) {
            XesLog.it(DownloadEngine.TAG, "download---onFailed() code=" + i + " message=" + str + " errorInfo=" + str3 + " " + filePoint.toString());
            DownloadQueueManager.getInstance().onDownloadEnd(filePoint.getRealFileName());
            if (filePoint != null) {
                filePoint.onFailed(i, str, str2, str3);
            }
            WeakReference<SimpleDownloadListener> weakReference = this.mDownLoadListener;
            if (weakReference != null && weakReference.get() != null) {
                ((SimpleDownloadListener) this.mDownLoadListener.get()).onFailed(filePoint, i, str, str2, str3);
            }
        }

        public void onBlockComplete(final FilePoint filePoint) {
            XesLog.it(DownloadEngine.TAG, "download---onBlockComplete() " + filePoint.toString());
            DownloadEngine.this.mainThreadExecutor.execute(new Runnable() {
                public void run() {
                    if (ImpDownloadListener.this.mDownLoadListener != null && ImpDownloadListener.this.mDownLoadListener.get() != null) {
                        ((SimpleDownloadListener) ImpDownloadListener.this.mDownLoadListener.get()).onBlockComplete(filePoint);
                    }
                }
            });
        }
    }

    static class MainThreadExecutor implements Executor {
        private final Handler handler = new Handler(Looper.getMainLooper());

        MainThreadExecutor() {
        }

        public void execute(Runnable runnable) {
            Handler handler2 = this.handler;
            if (!(handler2 instanceof Handler)) {
                handler2.post(runnable);
            } else {
                AsynchronousInstrumentation.handlerPost(handler2, runnable);
            }
        }
    }

    public Application getApplication() {
        return this.application;
    }

    public boolean trySwitchRes(FilePoint filePoint, boolean z) {
        if (filePoint == null) {
            return false;
        }
        XesLog.et(DownloadQueueManager.TAG, "切换资源重试：" + filePoint.getFileName());
        if (filePoint.isDiff() && z) {
            getInstance().download(filePoint.getFullFilePoint(), filePoint.getListener());
            return true;
        } else if (filePoint.hasNextUr()) {
            getInstance().download(filePoint, filePoint.getListener());
            return true;
        } else if (!filePoint.isDiff()) {
            return false;
        } else {
            getInstance().download(filePoint.getFullFilePoint(), filePoint.getListener());
            return true;
        }
    }
}
