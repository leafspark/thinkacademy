package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ResumableUploadTask extends BaseMultipartUploadTask<ResumableUploadRequest, ResumableUploadResult> implements Callable<ResumableUploadResult> {
    private List<Integer> mAlreadyUploadIndex = new ArrayList();
    private File mCRC64RecordFile;
    private File mRecordFile;
    private OSSSharedPreferences mSp = OSSSharedPreferences.instance(this.mContext.getApplicationContext());

    public ResumableUploadTask(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback<ResumableUploadRequest, ResumableUploadResult> oSSCompletedCallback, ExecutionContext executionContext, InternalRequestOperation internalRequestOperation) {
        super(internalRequestOperation, resumableUploadRequest, oSSCompletedCallback, executionContext);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v13, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v67, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: java.util.Map} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v18, resolved type: java.lang.String} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x025a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x025b, code lost:
        r20 = r5;
        r19 = r6;
        r17 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x029c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x029d, code lost:
        r17 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x02ca, code lost:
        r0 = e;
        r17 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x02cb, code lost:
        r5 = r20;
        r17 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x02d5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02d6, code lost:
        r17 = r2;
        r20 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02db, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02dc, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02ea, code lost:
        r1.mUploadId = null;
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02fc, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02fc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02fd A[EDGE_INSN: B:112:0x02fd->B:97:0x02fd ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0190 A[Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02db A[ExcHandler: ClientException (r0v49 'e' com.alibaba.sdk.android.oss.ClientException A[CUSTOM_DECLARE]), Splitter:B:35:0x016e] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02ea  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02f4 A[LOOP:0: B:31:0x0148->B:95:0x02f4, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initMultipartUploadId() throws java.io.IOException, com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        /*
            r21 = this;
            r1 = r21
            java.lang.String r2 = "[initUploadId] -  "
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r0 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r0 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r0 = r0.getRecordDirectory()
            boolean r0 = com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(r0)
            r3 = 0
            if (r0 != 0) goto L_0x0330
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "[initUploadId] - mUploadFilePath : "
            r0.append(r4)
            java.lang.String r4 = r1.mUploadFilePath
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(r0)
            java.lang.String r0 = r1.mUploadFilePath
            java.lang.String r0 = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str((java.lang.String) r0)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "[initUploadId] - mRequest.getPartSize() : "
            r4.append(r5)
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r5 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r5 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r5
            long r5 = r5.getPartSize()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r0 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r0 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r0 = r0.getBucketName()
            r4.append(r0)
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r0 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r0 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r0 = r0.getObjectKey()
            r4.append(r0)
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r0 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r0 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r0
            long r5 = r0.getPartSize()
            java.lang.String r0 = java.lang.String.valueOf(r5)
            r4.append(r0)
            boolean r0 = r1.mCheckCRC64
            if (r0 == 0) goto L_0x007f
            java.lang.String r0 = "-crc64"
            goto L_0x0081
        L_0x007f:
            java.lang.String r0 = ""
        L_0x0081:
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            byte[] r0 = r0.getBytes()
            java.lang.String r0 = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str((byte[]) r0)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r5 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r5 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r5
            java.lang.String r5 = r5.getRecordDirectory()
            r4.append(r5)
            java.lang.String r5 = java.io.File.separator
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.io.File r4 = new java.io.File
            r4.<init>(r0)
            r1.mRecordFile = r4
            boolean r0 = r4.exists()
            if (r0 == 0) goto L_0x00ce
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.FileReader r4 = new java.io.FileReader
            java.io.File r5 = r1.mRecordFile
            r4.<init>(r5)
            r0.<init>(r4)
            java.lang.String r4 = r0.readLine()
            r1.mUploadId = r4
            r0.close()
        L_0x00ce:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "[initUploadId] - mUploadId : "
            r0.append(r4)
            java.lang.String r4 = r1.mUploadId
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(r0)
            java.lang.String r0 = r1.mUploadId
            boolean r0 = com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(r0)
            if (r0 != 0) goto L_0x02fd
            boolean r0 = r1.mCheckCRC64
            if (r0 == 0) goto L_0x0145
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r4 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r4 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r4
            java.lang.String r4 = r4.getRecordDirectory()
            r0.append(r4)
            java.lang.String r4 = java.io.File.separator
            r0.append(r4)
            java.lang.String r4 = r1.mUploadId
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.io.File r4 = new java.io.File
            r4.<init>(r0)
            boolean r0 = r4.exists()
            if (r0 == 0) goto L_0x0145
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r4)
            java.io.ObjectInputStream r5 = new java.io.ObjectInputStream
            r5.<init>(r0)
            java.lang.Object r0 = r5.readObject()     // Catch:{ ClassNotFoundException -> 0x0132 }
            r6 = r0
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ ClassNotFoundException -> 0x0132 }
            r4.delete()     // Catch:{ ClassNotFoundException -> 0x012e }
            goto L_0x0137
        L_0x012e:
            r0 = move-exception
            goto L_0x0134
        L_0x0130:
            r0 = move-exception
            goto L_0x013e
        L_0x0132:
            r0 = move-exception
            r6 = r3
        L_0x0134:
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r0)     // Catch:{ all -> 0x0130 }
        L_0x0137:
            r5.close()
            r4.delete()
            goto L_0x0146
        L_0x013e:
            r5.close()
            r4.delete()
            throw r0
        L_0x0145:
            r6 = r3
        L_0x0146:
            r4 = 0
            r5 = r4
        L_0x0148:
            com.alibaba.sdk.android.oss.model.ListPartsRequest r0 = new com.alibaba.sdk.android.oss.model.ListPartsRequest
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r7 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r7 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r7
            java.lang.String r7 = r7.getBucketName()
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r8 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r8 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r8
            java.lang.String r8 = r8.getObjectKey()
            java.lang.String r9 = r1.mUploadId
            r0.<init>(r7, r8, r9)
            if (r5 <= 0) goto L_0x0168
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            r0.setPartNumberMarker(r7)
        L_0x0168:
            com.alibaba.sdk.android.oss.internal.InternalRequestOperation r7 = r1.mApiOperation
            com.alibaba.sdk.android.oss.internal.OSSAsyncTask r7 = r7.listParts(r0, r3)
            com.alibaba.sdk.android.oss.model.OSSResult r0 = r7.getResult()     // Catch:{ ServiceException -> 0x02dd, ClientException -> 0x02db }
            com.alibaba.sdk.android.oss.model.ListPartsResult r0 = (com.alibaba.sdk.android.oss.model.ListPartsResult) r0     // Catch:{ ServiceException -> 0x02dd, ClientException -> 0x02db }
            boolean r8 = r0.isTruncated()     // Catch:{ ServiceException -> 0x02dd, ClientException -> 0x02db }
            int r5 = r0.getNextPartNumberMarker()     // Catch:{ ServiceException -> 0x02dd, ClientException -> 0x02db }
            java.util.List r0 = r0.getParts()     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            int[] r9 = r1.mPartAttr     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            r9 = r9[r4]     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            int[] r10 = r1.mPartAttr     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            r11 = 1
            r10 = r10[r11]     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            r12 = r4
        L_0x018a:
            int r13 = r0.size()     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            if (r12 >= r13) goto L_0x02ce
            java.lang.Object r13 = r0.get(r12)     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            com.alibaba.sdk.android.oss.model.PartSummary r13 = (com.alibaba.sdk.android.oss.model.PartSummary) r13     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            com.alibaba.sdk.android.oss.model.PartETag r14 = new com.alibaba.sdk.android.oss.model.PartETag     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            int r15 = r13.getPartNumber()     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            java.lang.String r4 = r13.getETag()     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            r14.<init>(r15, r4)     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            long r3 = r13.getSize()     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            r14.setPartSize(r3)     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            if (r6 == 0) goto L_0x01d5
            int r3 = r6.size()     // Catch:{ ServiceException -> 0x02dd, ClientException -> 0x02db }
            if (r3 <= 0) goto L_0x01d5
            int r3 = r14.getPartNumber()     // Catch:{ ServiceException -> 0x02dd, ClientException -> 0x02db }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ ServiceException -> 0x02dd, ClientException -> 0x02db }
            boolean r3 = r6.containsKey(r3)     // Catch:{ ServiceException -> 0x02dd, ClientException -> 0x02db }
            if (r3 == 0) goto L_0x01d5
            int r3 = r14.getPartNumber()     // Catch:{ ServiceException -> 0x02dd, ClientException -> 0x02db }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ ServiceException -> 0x02dd, ClientException -> 0x02db }
            java.lang.Object r3 = r6.get(r3)     // Catch:{ ServiceException -> 0x02dd, ClientException -> 0x02db }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ ServiceException -> 0x02dd, ClientException -> 0x02db }
            long r3 = r3.longValue()     // Catch:{ ServiceException -> 0x02dd, ClientException -> 0x02db }
            r14.setCRC64(r3)     // Catch:{ ServiceException -> 0x02dd, ClientException -> 0x02db }
        L_0x01d5:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            r3.<init>()     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            r3.append(r2)     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            r3.append(r12)     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            java.lang.String r4 = " part.getPartNumber() : "
            r3.append(r4)     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            int r4 = r13.getPartNumber()     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            r3.append(r4)     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            java.lang.String r3 = r3.toString()     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(r3)     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            r3.<init>()     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            r3.append(r2)     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            r3.append(r12)     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            java.lang.String r4 = " part.getSize() : "
            r3.append(r4)     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            r16 = r12
            long r11 = r13.getSize()     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            r3.append(r11)     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            java.lang.String r3 = r3.toString()     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(r3)     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            int r3 = r13.getPartNumber()     // Catch:{ ServiceException -> 0x02d5, ClientException -> 0x02db }
            if (r3 != r10) goto L_0x021b
            r3 = 1
            goto L_0x021c
        L_0x021b:
            r3 = 0
        L_0x021c:
            java.lang.String r11 = " or lastPartSize : "
            java.lang.String r12 = " setting is inconsistent with PartSize : "
            java.lang.String r4 = "current part size "
            if (r3 == 0) goto L_0x0263
            long r17 = r13.getSize()     // Catch:{ ServiceException -> 0x025a, ClientException -> 0x02db }
            r20 = r5
            r19 = r6
            long r5 = r1.mLastPartSize     // Catch:{ ServiceException -> 0x029c, ClientException -> 0x02db }
            int r5 = (r17 > r5 ? 1 : (r17 == r5 ? 0 : -1))
            if (r5 != 0) goto L_0x0233
            goto L_0x0267
        L_0x0233:
            com.alibaba.sdk.android.oss.ClientException r0 = new com.alibaba.sdk.android.oss.ClientException     // Catch:{ ServiceException -> 0x029c, ClientException -> 0x02db }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ServiceException -> 0x029c, ClientException -> 0x02db }
            r3.<init>()     // Catch:{ ServiceException -> 0x029c, ClientException -> 0x02db }
            r3.append(r4)     // Catch:{ ServiceException -> 0x029c, ClientException -> 0x02db }
            long r4 = r13.getSize()     // Catch:{ ServiceException -> 0x029c, ClientException -> 0x02db }
            r3.append(r4)     // Catch:{ ServiceException -> 0x029c, ClientException -> 0x02db }
            r3.append(r12)     // Catch:{ ServiceException -> 0x029c, ClientException -> 0x02db }
            r3.append(r9)     // Catch:{ ServiceException -> 0x029c, ClientException -> 0x02db }
            r3.append(r11)     // Catch:{ ServiceException -> 0x029c, ClientException -> 0x02db }
            long r4 = r1.mLastPartSize     // Catch:{ ServiceException -> 0x029c, ClientException -> 0x02db }
            r3.append(r4)     // Catch:{ ServiceException -> 0x029c, ClientException -> 0x02db }
            java.lang.String r3 = r3.toString()     // Catch:{ ServiceException -> 0x029c, ClientException -> 0x02db }
            r0.<init>((java.lang.String) r3)     // Catch:{ ServiceException -> 0x029c, ClientException -> 0x02db }
            throw r0     // Catch:{ ServiceException -> 0x029c, ClientException -> 0x02db }
        L_0x025a:
            r0 = move-exception
            r20 = r5
            r19 = r6
            r17 = r2
            goto L_0x02e2
        L_0x0263:
            r20 = r5
            r19 = r6
        L_0x0267:
            if (r3 != 0) goto L_0x02a0
            long r5 = r13.getSize()     // Catch:{ ServiceException -> 0x029c, ClientException -> 0x02db }
            r17 = r2
            long r2 = (long) r9
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0275
            goto L_0x02a2
        L_0x0275:
            com.alibaba.sdk.android.oss.ClientException r0 = new com.alibaba.sdk.android.oss.ClientException     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            r2.<init>()     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            r2.append(r4)     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            long r3 = r13.getSize()     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            r2.append(r3)     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            r2.append(r12)     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            r2.append(r9)     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            r2.append(r11)     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            long r3 = r1.mLastPartSize     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            r2.append(r3)     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            java.lang.String r2 = r2.toString()     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            r0.<init>((java.lang.String) r2)     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            throw r0     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
        L_0x029c:
            r0 = move-exception
            r17 = r2
            goto L_0x02cb
        L_0x02a0:
            r17 = r2
        L_0x02a2:
            java.util.List r2 = r1.mPartETags     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            r2.add(r14)     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            long r2 = r1.mUploadedLength     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            long r4 = r13.getSize()     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            long r2 = r2 + r4
            r1.mUploadedLength = r2     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            java.util.List<java.lang.Integer> r2 = r1.mAlreadyUploadIndex     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            int r3 = r13.getPartNumber()     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            r2.add(r3)     // Catch:{ ServiceException -> 0x02ca, ClientException -> 0x02db }
            int r12 = r16 + 1
            r2 = r17
            r6 = r19
            r5 = r20
            r3 = 0
            r4 = 0
            r11 = 1
            goto L_0x018a
        L_0x02ca:
            r0 = move-exception
        L_0x02cb:
            r5 = r20
            goto L_0x02e2
        L_0x02ce:
            r17 = r2
            r20 = r5
            r19 = r6
            goto L_0x02ee
        L_0x02d5:
            r0 = move-exception
            r17 = r2
            r20 = r5
            goto L_0x02e0
        L_0x02db:
            r0 = move-exception
            throw r0
        L_0x02dd:
            r0 = move-exception
            r17 = r2
        L_0x02e0:
            r19 = r6
        L_0x02e2:
            int r2 = r0.getStatusCode()
            r3 = 404(0x194, float:5.66E-43)
            if (r2 != r3) goto L_0x02fc
            r2 = 0
            r1.mUploadId = r2
            r8 = 0
        L_0x02ee:
            r7.waitUntilFinished()
            if (r8 != 0) goto L_0x02f4
            goto L_0x02fd
        L_0x02f4:
            r2 = r17
            r6 = r19
            r3 = 0
            r4 = 0
            goto L_0x0148
        L_0x02fc:
            throw r0
        L_0x02fd:
            java.io.File r0 = r1.mRecordFile
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0330
            java.io.File r0 = r1.mRecordFile
            boolean r0 = r0.createNewFile()
            if (r0 == 0) goto L_0x030e
            goto L_0x0330
        L_0x030e:
            com.alibaba.sdk.android.oss.ClientException r0 = new com.alibaba.sdk.android.oss.ClientException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Can't create file at path: "
            r2.append(r3)
            java.io.File r3 = r1.mRecordFile
            java.lang.String r3 = r3.getAbsolutePath()
            r2.append(r3)
            java.lang.String r3 = "\nPlease make sure the directory exist!"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>((java.lang.String) r2)
            throw r0
        L_0x0330:
            java.lang.String r0 = r1.mUploadId
            boolean r0 = com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(r0)
            if (r0 == 0) goto L_0x0380
            com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest r0 = new com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r2 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r2 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r2
            java.lang.String r2 = r2.getBucketName()
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r3 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r3 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r3
            java.lang.String r3 = r3.getObjectKey()
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r4 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r4 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r4
            com.alibaba.sdk.android.oss.model.ObjectMetadata r4 = r4.getMetadata()
            r0.<init>(r2, r3, r4)
            com.alibaba.sdk.android.oss.internal.InternalRequestOperation r2 = r1.mApiOperation
            r3 = 0
            com.alibaba.sdk.android.oss.internal.OSSAsyncTask r0 = r2.initMultipartUpload(r0, r3)
            com.alibaba.sdk.android.oss.model.OSSResult r0 = r0.getResult()
            com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult r0 = (com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult) r0
            java.lang.String r0 = r0.getUploadId()
            r1.mUploadId = r0
            java.io.File r0 = r1.mRecordFile
            if (r0 == 0) goto L_0x0380
            java.io.BufferedWriter r0 = new java.io.BufferedWriter
            java.io.FileWriter r2 = new java.io.FileWriter
            java.io.File r3 = r1.mRecordFile
            r2.<init>(r3)
            r0.<init>(r2)
            java.lang.String r2 = r1.mUploadId
            r0.write(r2)
            r0.close()
        L_0x0380:
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r0 = r1.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r0 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r2 = r1.mUploadId
            r0.setUploadId(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.ResumableUploadTask.initMultipartUploadId():void");
    }

    /* access modifiers changed from: protected */
    public ResumableUploadResult doMultipartUpload() throws IOException, ClientException, ServiceException, InterruptedException {
        long j = this.mUploadedLength;
        checkCancel();
        final int i = this.mPartAttr[0];
        final int i2 = this.mPartAttr[1];
        if (this.mPartETags.size() > 0 && this.mAlreadyUploadIndex.size() > 0) {
            if (this.mUploadedLength <= this.mFileLength) {
                long j2 = this.mUploadedLength;
                if (!TextUtils.isEmpty(this.mSp.getStringValue(this.mUploadId))) {
                    j2 = Long.valueOf(this.mSp.getStringValue(this.mUploadId)).longValue();
                }
                long j3 = j2;
                if (this.mProgressCallback != null) {
                    this.mProgressCallback.onProgress(this.mRequest, j3, this.mFileLength);
                }
                this.mSp.removeKey(this.mUploadId);
            } else {
                throw new ClientException("The uploading file is inconsistent with before");
            }
        }
        this.mRunPartTaskCount = this.mPartETags.size();
        for (final int i3 = 0; i3 < i2; i3++) {
            if ((this.mAlreadyUploadIndex.size() == 0 || !this.mAlreadyUploadIndex.contains(Integer.valueOf(i3 + 1))) && this.mPoolExecutor != null) {
                if (i3 == i2 - 1) {
                    i = (int) (this.mFileLength - j);
                }
                j += (long) i;
                this.mPoolExecutor.execute(new Runnable() {
                    public void run() {
                        ResumableUploadTask.this.uploadPart(i3, i, i2);
                    }
                });
            }
        }
        if (checkWaitCondition(i2)) {
            synchronized (this.mLock) {
                this.mLock.wait();
            }
        }
        checkException();
        CompleteMultipartUploadResult completeMultipartUploadResult = completeMultipartUploadResult();
        ResumableUploadResult resumableUploadResult = null;
        if (completeMultipartUploadResult != null) {
            resumableUploadResult = new ResumableUploadResult(completeMultipartUploadResult);
        }
        File file = this.mRecordFile;
        if (file != null) {
            file.delete();
        }
        File file2 = this.mCRC64RecordFile;
        if (file2 != null) {
            file2.delete();
        }
        releasePool();
        return resumableUploadResult;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkException() throws java.io.IOException, com.alibaba.sdk.android.oss.ServiceException, com.alibaba.sdk.android.oss.ClientException {
        /*
            r6 = this;
            com.alibaba.sdk.android.oss.network.ExecutionContext r0 = r6.mContext
            com.alibaba.sdk.android.oss.network.CancellationHandler r0 = r0.getCancellationHandler()
            boolean r0 = r0.isCancelled()
            if (r0 == 0) goto L_0x00c7
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r0 = r6.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r0 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.Boolean r0 = r0.deleteUploadOnCancelling()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0026
            r6.abortThisUpload()
            java.io.File r0 = r6.mRecordFile
            if (r0 == 0) goto L_0x00c7
            r0.delete()
            goto L_0x00c7
        L_0x0026:
            java.util.List r0 = r6.mPartETags
            if (r0 == 0) goto L_0x00c7
            java.util.List r0 = r6.mPartETags
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00c7
            boolean r0 = r6.mCheckCRC64
            if (r0 == 0) goto L_0x00c7
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r0 = r6.mRequest
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r0 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r0
            java.lang.String r0 = r0.getRecordDirectory()
            if (r0 == 0) goto L_0x00c7
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.List r1 = r6.mPartETags
            java.util.Iterator r1 = r1.iterator()
        L_0x004b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x006b
            java.lang.Object r2 = r1.next()
            com.alibaba.sdk.android.oss.model.PartETag r2 = (com.alibaba.sdk.android.oss.model.PartETag) r2
            int r3 = r2.getPartNumber()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            long r4 = r2.getCRC64()
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r0.put(r3, r2)
            goto L_0x004b
        L_0x006b:
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b7 }
            r2.<init>()     // Catch:{ IOException -> 0x00b7 }
            com.alibaba.sdk.android.oss.model.MultipartUploadRequest r3 = r6.mRequest     // Catch:{ IOException -> 0x00b7 }
            com.alibaba.sdk.android.oss.model.ResumableUploadRequest r3 = (com.alibaba.sdk.android.oss.model.ResumableUploadRequest) r3     // Catch:{ IOException -> 0x00b7 }
            java.lang.String r3 = r3.getRecordDirectory()     // Catch:{ IOException -> 0x00b7 }
            r2.append(r3)     // Catch:{ IOException -> 0x00b7 }
            java.lang.String r3 = java.io.File.separator     // Catch:{ IOException -> 0x00b7 }
            r2.append(r3)     // Catch:{ IOException -> 0x00b7 }
            java.lang.String r3 = r6.mUploadId     // Catch:{ IOException -> 0x00b7 }
            r2.append(r3)     // Catch:{ IOException -> 0x00b7 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x00b7 }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x00b7 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x00b7 }
            r6.mCRC64RecordFile = r3     // Catch:{ IOException -> 0x00b7 }
            boolean r2 = r3.exists()     // Catch:{ IOException -> 0x00b7 }
            if (r2 != 0) goto L_0x009c
            java.io.File r2 = r6.mCRC64RecordFile     // Catch:{ IOException -> 0x00b7 }
            r2.createNewFile()     // Catch:{ IOException -> 0x00b7 }
        L_0x009c:
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x00b7 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00b7 }
            java.io.File r4 = r6.mCRC64RecordFile     // Catch:{ IOException -> 0x00b7 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00b7 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x00b7 }
            r2.writeObject(r0)     // Catch:{ IOException -> 0x00b2, all -> 0x00af }
            r2.close()
            goto L_0x00c7
        L_0x00af:
            r0 = move-exception
            r1 = r2
            goto L_0x00c1
        L_0x00b2:
            r0 = move-exception
            r1 = r2
            goto L_0x00b8
        L_0x00b5:
            r0 = move-exception
            goto L_0x00c1
        L_0x00b7:
            r0 = move-exception
        L_0x00b8:
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(r0)     // Catch:{ all -> 0x00b5 }
            if (r1 == 0) goto L_0x00c7
            r1.close()
            goto L_0x00c7
        L_0x00c1:
            if (r1 == 0) goto L_0x00c6
            r1.close()
        L_0x00c6:
            throw r0
        L_0x00c7:
            super.checkException()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.oss.internal.ResumableUploadTask.checkException():void");
    }

    /* access modifiers changed from: protected */
    public void abortThisUpload() {
        if (this.mUploadId != null) {
            this.mApiOperation.abortMultipartUpload(new AbortMultipartUploadRequest(((ResumableUploadRequest) this.mRequest).getBucketName(), ((ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId), (OSSCompletedCallback<AbortMultipartUploadRequest, AbortMultipartUploadResult>) null).waitUntilFinished();
        }
    }

    /* access modifiers changed from: protected */
    public void processException(Exception exc) {
        synchronized (this.mLock) {
            this.mPartExceptionCount++;
            this.mUploadException = exc;
            OSSLog.logThrowable2Local(exc);
            if (this.mContext.getCancellationHandler().isCancelled() && !this.mIsCancel) {
                this.mIsCancel = true;
                this.mLock.notify();
            }
            if (this.mPartETags.size() == this.mRunPartTaskCount - this.mPartExceptionCount) {
                notifyMultipartThread();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void uploadPartFinish(PartETag partETag) throws Exception {
        if (this.mContext.getCancellationHandler().isCancelled() && !this.mSp.contains(this.mUploadId)) {
            this.mSp.setStringValue(this.mUploadId, String.valueOf(this.mUploadedLength));
            onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
        }
    }
}
