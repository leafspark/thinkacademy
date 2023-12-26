package com.alibaba.sdk.android.oss.internal;

import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.TaskCancelException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class BaseMultipartUploadTask<Request extends MultipartUploadRequest, Result extends CompleteMultipartUploadResult> implements Callable<Result> {
    protected final int CPU_SIZE;
    protected final int KEEP_ALIVE_TIME;
    protected final int MAX_CORE_POOL_SIZE;
    protected final int MAX_IMUM_POOL_SIZE;
    protected final int MAX_QUEUE_SIZE;
    protected InternalRequestOperation mApiOperation;
    protected boolean mCheckCRC64;
    protected OSSCompletedCallback<Request, Result> mCompletedCallback;
    protected ExecutionContext mContext;
    protected long mFileLength;
    protected boolean mIsCancel;
    protected long mLastPartSize;
    protected Object mLock;
    protected int[] mPartAttr;
    protected List<PartETag> mPartETags;
    protected int mPartExceptionCount;
    protected ThreadPoolExecutor mPoolExecutor;
    protected OSSProgressCallback<Request> mProgressCallback;
    protected Request mRequest;
    protected int mRunPartTaskCount;
    protected Exception mUploadException;
    protected File mUploadFile;
    protected String mUploadFilePath;
    protected String mUploadId;
    protected long mUploadedLength;

    /* access modifiers changed from: protected */
    public abstract void abortThisUpload();

    /* access modifiers changed from: protected */
    public abstract Result doMultipartUpload() throws IOException, ServiceException, ClientException, InterruptedException;

    /* access modifiers changed from: protected */
    public abstract void initMultipartUploadId() throws IOException, ClientException, ServiceException;

    /* access modifiers changed from: protected */
    public void preUploadPart(int i, int i2, int i3) throws Exception {
    }

    /* access modifiers changed from: protected */
    public abstract void processException(Exception exc);

    /* access modifiers changed from: protected */
    public void uploadPartFinish(PartETag partETag) throws Exception {
    }

    public BaseMultipartUploadTask(InternalRequestOperation internalRequestOperation, Request request, OSSCompletedCallback<Request, Result> oSSCompletedCallback, ExecutionContext executionContext) {
        int availableProcessors = Runtime.getRuntime().availableProcessors() * 2;
        this.CPU_SIZE = availableProcessors;
        int i = availableProcessors < 5 ? availableProcessors : 5;
        this.MAX_CORE_POOL_SIZE = i;
        this.MAX_IMUM_POOL_SIZE = availableProcessors;
        this.KEEP_ALIVE_TIME = PathInterpolatorCompat.MAX_NUM_POINTS;
        this.MAX_QUEUE_SIZE = 5000;
        this.mPoolExecutor = new ThreadPoolExecutor(i, availableProcessors, 3000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(5000), new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "oss-android-multipart-thread");
            }
        });
        this.mPartETags = new ArrayList();
        this.mLock = new Object();
        this.mUploadedLength = 0;
        boolean z = false;
        this.mCheckCRC64 = false;
        this.mPartAttr = new int[2];
        this.mApiOperation = internalRequestOperation;
        this.mRequest = request;
        this.mProgressCallback = request.getProgressCallback();
        this.mCompletedCallback = oSSCompletedCallback;
        this.mContext = executionContext;
        this.mCheckCRC64 = request.getCRC64() == OSSRequest.CRC64Config.YES ? true : z;
    }

    /* access modifiers changed from: protected */
    public void checkCancel() throws ClientException {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            TaskCancelException taskCancelException = new TaskCancelException("multipart cancel");
            throw new ClientException(taskCancelException.getMessage(), taskCancelException, true);
        }
    }

    public Result call() throws Exception {
        ClientException clientException;
        try {
            checkInitData();
            initMultipartUploadId();
            Result doMultipartUpload = doMultipartUpload();
            OSSCompletedCallback<Request, Result> oSSCompletedCallback = this.mCompletedCallback;
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onSuccess(this.mRequest, doMultipartUpload);
            }
            return doMultipartUpload;
        } catch (ServiceException e) {
            OSSCompletedCallback<Request, Result> oSSCompletedCallback2 = this.mCompletedCallback;
            if (oSSCompletedCallback2 != null) {
                oSSCompletedCallback2.onFailure(this.mRequest, (ClientException) null, e);
            }
            throw e;
        } catch (Exception e2) {
            if (e2 instanceof ClientException) {
                clientException = (ClientException) e2;
            } else {
                clientException = new ClientException(e2.toString(), e2);
            }
            OSSCompletedCallback<Request, Result> oSSCompletedCallback3 = this.mCompletedCallback;
            if (oSSCompletedCallback3 != null) {
                oSSCompletedCallback3.onFailure(this.mRequest, clientException, (ServiceException) null);
            }
            throw clientException;
        }
    }

    /* access modifiers changed from: protected */
    public void checkInitData() throws ClientException {
        this.mUploadFilePath = this.mRequest.getUploadFilePath();
        this.mUploadedLength = 0;
        File file = new File(this.mUploadFilePath);
        this.mUploadFile = file;
        long length = file.length();
        this.mFileLength = length;
        if (length != 0) {
            checkPartSize(this.mPartAttr);
            long partSize = this.mRequest.getPartSize();
            int i = this.mPartAttr[1];
            OSSLog.logDebug("[checkInitData] - partNumber : " + i);
            OSSLog.logDebug("[checkInitData] - partSize : " + partSize);
            if (i > 1 && partSize < OSSConstants.MIN_PART_SIZE_LIMIT) {
                throw new ClientException("Part size must be greater than or equal to 100KB!");
            }
            return;
        }
        throw new ClientException("file length must not be 0");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0107 A[SYNTHETIC, Splitter:B:58:0x0107] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void uploadPart(int r10, int r11, int r12) {
        /*
            r9 = this;
            r0 = 0
            com.alibaba.sdk.android.oss.network.ExecutionContext r1 = r9.mContext     // Catch:{ Exception -> 0x00f6 }
            com.alibaba.sdk.android.oss.network.CancellationHandler r1 = r1.getCancellationHandler()     // Catch:{ Exception -> 0x00f6 }
            boolean r1 = r1.isCancelled()     // Catch:{ Exception -> 0x00f6 }
            if (r1 == 0) goto L_0x0017
            java.util.concurrent.ThreadPoolExecutor r10 = r9.mPoolExecutor     // Catch:{ Exception -> 0x00f6 }
            java.util.concurrent.BlockingQueue r10 = r10.getQueue()     // Catch:{ Exception -> 0x00f6 }
            r10.clear()     // Catch:{ Exception -> 0x00f6 }
            return
        L_0x0017:
            java.lang.Object r1 = r9.mLock     // Catch:{ Exception -> 0x00f6 }
            monitor-enter(r1)     // Catch:{ Exception -> 0x00f6 }
            int r2 = r9.mRunPartTaskCount     // Catch:{ all -> 0x00f1 }
            r3 = 1
            int r2 = r2 + r3
            r9.mRunPartTaskCount = r2     // Catch:{ all -> 0x00f1 }
            monitor-exit(r1)     // Catch:{ all -> 0x00f1 }
            r9.preUploadPart(r10, r11, r12)     // Catch:{ Exception -> 0x00f6 }
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00f6 }
            java.io.File r2 = r9.mUploadFile     // Catch:{ Exception -> 0x00f6 }
            java.lang.String r4 = "r"
            r1.<init>(r2, r4)     // Catch:{ Exception -> 0x00f6 }
            com.alibaba.sdk.android.oss.model.UploadPartRequest r0 = new com.alibaba.sdk.android.oss.model.UploadPartRequest     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            Request r2 = r9.mRequest     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            java.lang.String r2 = r2.getBucketName()     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            Request r4 = r9.mRequest     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            java.lang.String r4 = r4.getObjectKey()     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            java.lang.String r5 = r9.mUploadId     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            int r6 = r10 + 1
            r0.<init>(r2, r4, r5, r6)     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            long r4 = (long) r10     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            Request r10 = r9.mRequest     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            long r6 = r10.getPartSize()     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            long r4 = r4 * r6
            byte[] r10 = new byte[r11]     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            r1.seek(r4)     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            r2 = 0
            r1.readFully(r10, r2, r11)     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            r0.setPartContent(r10)     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            java.lang.String r10 = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateBase64Md5((byte[]) r10)     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            r0.setMd5Digest(r10)     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            Request r10 = r9.mRequest     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            java.lang.Enum r10 = r10.getCRC64()     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            r0.setCRC64(r10)     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            com.alibaba.sdk.android.oss.internal.InternalRequestOperation r10 = r9.mApiOperation     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            com.alibaba.sdk.android.oss.model.UploadPartResult r10 = r10.syncUploadPart(r0)     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            java.lang.Object r2 = r9.mLock     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            monitor-enter(r2)     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
            com.alibaba.sdk.android.oss.model.PartETag r4 = new com.alibaba.sdk.android.oss.model.PartETag     // Catch:{ all -> 0x00e8 }
            int r0 = r0.getPartNumber()     // Catch:{ all -> 0x00e8 }
            java.lang.String r5 = r10.getETag()     // Catch:{ all -> 0x00e8 }
            r4.<init>(r0, r5)     // Catch:{ all -> 0x00e8 }
            long r5 = (long) r11     // Catch:{ all -> 0x00e8 }
            r4.setPartSize(r5)     // Catch:{ all -> 0x00e8 }
            boolean r11 = r9.mCheckCRC64     // Catch:{ all -> 0x00e8 }
            if (r11 == 0) goto L_0x008f
            java.lang.Long r10 = r10.getClientCRC()     // Catch:{ all -> 0x00e8 }
            long r10 = r10.longValue()     // Catch:{ all -> 0x00e8 }
            r4.setCRC64(r10)     // Catch:{ all -> 0x00e8 }
        L_0x008f:
            java.util.List<com.alibaba.sdk.android.oss.model.PartETag> r10 = r9.mPartETags     // Catch:{ all -> 0x00e8 }
            r10.add(r4)     // Catch:{ all -> 0x00e8 }
            long r10 = r9.mUploadedLength     // Catch:{ all -> 0x00e8 }
            long r10 = r10 + r5
            r9.mUploadedLength = r10     // Catch:{ all -> 0x00e8 }
            r9.uploadPartFinish(r4)     // Catch:{ all -> 0x00e8 }
            com.alibaba.sdk.android.oss.network.ExecutionContext r10 = r9.mContext     // Catch:{ all -> 0x00e8 }
            com.alibaba.sdk.android.oss.network.CancellationHandler r10 = r10.getCancellationHandler()     // Catch:{ all -> 0x00e8 }
            boolean r10 = r10.isCancelled()     // Catch:{ all -> 0x00e8 }
            if (r10 == 0) goto L_0x00cb
            java.util.List<com.alibaba.sdk.android.oss.model.PartETag> r10 = r9.mPartETags     // Catch:{ all -> 0x00e8 }
            int r10 = r10.size()     // Catch:{ all -> 0x00e8 }
            int r11 = r9.mRunPartTaskCount     // Catch:{ all -> 0x00e8 }
            int r12 = r9.mPartExceptionCount     // Catch:{ all -> 0x00e8 }
            int r11 = r11 - r12
            if (r10 == r11) goto L_0x00b6
            goto L_0x00e3
        L_0x00b6:
            com.alibaba.sdk.android.oss.TaskCancelException r10 = new com.alibaba.sdk.android.oss.TaskCancelException     // Catch:{ all -> 0x00e8 }
            java.lang.String r11 = "multipart cancel"
            r10.<init>((java.lang.String) r11)     // Catch:{ all -> 0x00e8 }
            com.alibaba.sdk.android.oss.ClientException r11 = new com.alibaba.sdk.android.oss.ClientException     // Catch:{ all -> 0x00e8 }
            java.lang.String r12 = r10.getMessage()     // Catch:{ all -> 0x00e8 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)     // Catch:{ all -> 0x00e8 }
            r11.<init>(r12, r10, r0)     // Catch:{ all -> 0x00e8 }
            throw r11     // Catch:{ all -> 0x00e8 }
        L_0x00cb:
            java.util.List<com.alibaba.sdk.android.oss.model.PartETag> r10 = r9.mPartETags     // Catch:{ all -> 0x00e8 }
            int r10 = r10.size()     // Catch:{ all -> 0x00e8 }
            int r11 = r9.mPartExceptionCount     // Catch:{ all -> 0x00e8 }
            int r12 = r12 - r11
            if (r10 != r12) goto L_0x00d9
            r9.notifyMultipartThread()     // Catch:{ all -> 0x00e8 }
        L_0x00d9:
            Request r4 = r9.mRequest     // Catch:{ all -> 0x00e8 }
            long r5 = r9.mUploadedLength     // Catch:{ all -> 0x00e8 }
            long r7 = r9.mFileLength     // Catch:{ all -> 0x00e8 }
            r3 = r9
            r3.onProgressCallback(r4, r5, r7)     // Catch:{ all -> 0x00e8 }
        L_0x00e3:
            monitor-exit(r2)     // Catch:{ all -> 0x00e8 }
            r1.close()     // Catch:{ IOException -> 0x0100 }
            goto L_0x0104
        L_0x00e8:
            r10 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00e8 }
            throw r10     // Catch:{ Exception -> 0x00ee, all -> 0x00eb }
        L_0x00eb:
            r10 = move-exception
            r0 = r1
            goto L_0x0105
        L_0x00ee:
            r10 = move-exception
            r0 = r1
            goto L_0x00f7
        L_0x00f1:
            r10 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00f1 }
            throw r10     // Catch:{ Exception -> 0x00f6 }
        L_0x00f4:
            r10 = move-exception
            goto L_0x0105
        L_0x00f6:
            r10 = move-exception
        L_0x00f7:
            r9.processException(r10)     // Catch:{ all -> 0x00f4 }
            if (r0 == 0) goto L_0x0104
            r0.close()     // Catch:{ IOException -> 0x0100 }
            goto L_0x0104
        L_0x0100:
            r10 = move-exception
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r10)
        L_0x0104:
            return
        L_0x0105:
            if (r0 == 0) goto L_0x010f
            r0.close()     // Catch:{ IOException -> 0x010b }
            goto L_0x010f
        L_0x010b:
            r11 = move-exception
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r11)
        L_0x010f:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.uploadPart(int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public CompleteMultipartUploadResult completeMultipartUploadResult() throws ClientException, ServiceException {
        CompleteMultipartUploadResult completeMultipartUploadResult;
        if (this.mPartETags.size() > 0) {
            Collections.sort(this.mPartETags, new Comparator<PartETag>() {
                public int compare(PartETag partETag, PartETag partETag2) {
                    if (partETag.getPartNumber() < partETag2.getPartNumber()) {
                        return -1;
                    }
                    return partETag.getPartNumber() > partETag2.getPartNumber() ? 1 : 0;
                }
            });
            CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey(), this.mUploadId, this.mPartETags);
            completeMultipartUploadRequest.setMetadata(this.mRequest.getMetadata());
            if (this.mRequest.getCallbackParam() != null) {
                completeMultipartUploadRequest.setCallbackParam(this.mRequest.getCallbackParam());
            }
            if (this.mRequest.getCallbackVars() != null) {
                completeMultipartUploadRequest.setCallbackVars(this.mRequest.getCallbackVars());
            }
            completeMultipartUploadRequest.setCRC64(this.mRequest.getCRC64());
            completeMultipartUploadResult = this.mApiOperation.syncCompleteMultipartUpload(completeMultipartUploadRequest);
        } else {
            completeMultipartUploadResult = null;
        }
        this.mUploadedLength = 0;
        return completeMultipartUploadResult;
    }

    /* access modifiers changed from: protected */
    public void releasePool() {
        ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.getQueue().clear();
            this.mPoolExecutor.shutdown();
        }
    }

    /* access modifiers changed from: protected */
    public void checkException() throws IOException, ServiceException, ClientException {
        if (this.mUploadException != null) {
            releasePool();
            Exception exc = this.mUploadException;
            if (exc instanceof IOException) {
                throw ((IOException) exc);
            } else if (exc instanceof ServiceException) {
                throw ((ServiceException) exc);
            } else if (exc instanceof ClientException) {
                throw ((ClientException) exc);
            } else {
                throw new ClientException(this.mUploadException.getMessage(), this.mUploadException);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkWaitCondition(int i) {
        return this.mPartETags.size() != i;
    }

    /* access modifiers changed from: protected */
    public void notifyMultipartThread() {
        this.mLock.notify();
        this.mPartExceptionCount = 0;
    }

    /* access modifiers changed from: protected */
    public void checkPartSize(int[] iArr) {
        long partSize = this.mRequest.getPartSize();
        OSSLog.logDebug("[checkPartSize] - mFileLength : " + this.mFileLength);
        OSSLog.logDebug("[checkPartSize] - partSize : " + partSize);
        long j = this.mFileLength;
        int i = (int) (j / partSize);
        if (j % partSize != 0) {
            i++;
        }
        if (i == 1) {
            partSize = j;
        } else if (i > 5000) {
            partSize = j / ((long) 5000);
            i = 5000;
        }
        int i2 = (int) partSize;
        iArr[0] = i2;
        iArr[1] = i;
        this.mRequest.setPartSize((long) i2);
        OSSLog.logDebug("[checkPartSize] - partNumber : " + i);
        OSSLog.logDebug("[checkPartSize] - partSize : " + i2);
        long j2 = this.mFileLength % partSize;
        if (j2 != 0) {
            partSize = j2;
        }
        this.mLastPartSize = partSize;
    }

    /* access modifiers changed from: protected */
    public void onProgressCallback(Request request, long j, long j2) {
        OSSProgressCallback<Request> oSSProgressCallback = this.mProgressCallback;
        if (oSSProgressCallback != null) {
            oSSProgressCallback.onProgress(request, j, j2);
        }
    }
}
