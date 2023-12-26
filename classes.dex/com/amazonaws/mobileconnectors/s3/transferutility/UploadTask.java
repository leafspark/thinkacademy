package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.ObjectTagging;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.SSEAwsKeyManagementParams;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.util.Mimetypes;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class UploadTask implements Callable<Boolean> {
    private static final Map<String, CannedAccessControlList> CANNED_ACL_MAP = new HashMap();
    /* access modifiers changed from: private */
    public static final Log LOGGER = LogFactory.getLog((Class<?>) UploadTask.class);
    private static final String OBJECT_TAGS_DELIMITER = "&";
    private static final String OBJECT_TAG_KEY_VALUE_SEPARATOR = "=";
    private static final String REQUESTER_PAYS = "requester";
    private final TransferDBUtil dbUtil;
    private List<UploadPartRequest> requestList;
    private final AmazonS3 s3;
    /* access modifiers changed from: private */
    public final TransferStatusUpdater updater;
    /* access modifiers changed from: private */
    public final TransferRecord upload;
    Map<Integer, UploadPartTaskMetadata> uploadPartTasks = new HashMap();

    static {
        for (CannedAccessControlList cannedAccessControlList : CannedAccessControlList.values()) {
            CANNED_ACL_MAP.put(cannedAccessControlList.toString(), cannedAccessControlList);
        }
    }

    public UploadTask(TransferRecord transferRecord, AmazonS3 amazonS3, TransferDBUtil transferDBUtil, TransferStatusUpdater transferStatusUpdater) {
        this.upload = transferRecord;
        this.s3 = amazonS3;
        this.dbUtil = transferDBUtil;
        this.updater = transferStatusUpdater;
    }

    public Boolean call() throws Exception {
        try {
            if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                LOGGER.info("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                this.updater.updateState(this.upload.id, TransferState.WAITING_FOR_NETWORK);
                return false;
            }
        } catch (TransferUtilityException e) {
            Log log = LOGGER;
            log.error("TransferUtilityException: [" + e + "]");
        }
        this.updater.updateState(this.upload.id, TransferState.IN_PROGRESS);
        if (this.upload.isMultipart == 1 && this.upload.partNumber == 0) {
            return uploadMultipartAndWaitForCompletion();
        }
        if (this.upload.isMultipart == 0) {
            return uploadSinglePartAndWaitForCompletion();
        }
        return false;
    }

    private Boolean uploadMultipartAndWaitForCompletion() throws ExecutionException {
        long j;
        if (this.upload.multipartId == null || this.upload.multipartId.isEmpty()) {
            PutObjectRequest createPutObjectRequest = createPutObjectRequest(this.upload);
            TransferUtility.appendMultipartTransferServiceUserAgentString(createPutObjectRequest);
            try {
                this.upload.multipartId = initiateMultipartUpload(createPutObjectRequest);
                this.dbUtil.updateMultipartId(this.upload.id, this.upload.multipartId);
                j = 0;
            } catch (AmazonClientException e) {
                LOGGER.error("Error initiating multipart upload: " + this.upload.id + " due to " + e.getMessage(), e);
                this.updater.throwError(this.upload.id, e);
                this.updater.updateState(this.upload.id, TransferState.FAILED);
                return false;
            }
        } else {
            long queryBytesTransferredByMainUploadId = this.dbUtil.queryBytesTransferredByMainUploadId(this.upload.id);
            if (queryBytesTransferredByMainUploadId > 0) {
                LOGGER.info(String.format("Resume transfer %d from %d bytes", new Object[]{Integer.valueOf(this.upload.id), Long.valueOf(queryBytesTransferredByMainUploadId)}));
            }
            j = queryBytesTransferredByMainUploadId;
        }
        UploadTaskProgressListener uploadTaskProgressListener = new UploadTaskProgressListener(this.upload);
        this.updater.updateProgress(this.upload.id, j, this.upload.bytesTotal, false);
        this.requestList = this.dbUtil.getNonCompletedPartRequestsFromDB(this.upload.id, this.upload.multipartId);
        LOGGER.info("Multipart upload " + this.upload.id + " in " + this.requestList.size() + " parts.");
        for (UploadPartRequest next : this.requestList) {
            TransferUtility.appendMultipartTransferServiceUserAgentString(next);
            UploadPartTaskMetadata uploadPartTaskMetadata = new UploadPartTaskMetadata();
            uploadPartTaskMetadata.uploadPartRequest = next;
            uploadPartTaskMetadata.bytesTransferredSoFar = 0;
            uploadPartTaskMetadata.state = TransferState.WAITING;
            this.uploadPartTasks.put(Integer.valueOf(next.getPartNumber()), uploadPartTaskMetadata);
            uploadPartTaskMetadata.uploadPartTask = TransferThreadPool.submitTask(new UploadPartTask(uploadPartTaskMetadata, uploadTaskProgressListener, next, this.s3, this.dbUtil));
        }
        try {
            boolean z = true;
            for (UploadPartTaskMetadata uploadPartTaskMetadata2 : this.uploadPartTasks.values()) {
                z &= uploadPartTaskMetadata2.uploadPartTask.get().booleanValue();
            }
            if (!z) {
                try {
                    if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                        LOGGER.info("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                        this.updater.updateState(this.upload.id, TransferState.WAITING_FOR_NETWORK);
                        return false;
                    }
                } catch (TransferUtilityException e2) {
                    LOGGER.error("TransferUtilityException: [" + e2 + "]");
                }
            }
            LOGGER.info("Completing the multi-part upload transfer for " + this.upload.id);
            try {
                completeMultiPartUpload(this.upload.id, this.upload.bucketName, this.upload.key, this.upload.multipartId);
                this.updater.updateProgress(this.upload.id, this.upload.bytesTotal, this.upload.bytesTotal, true);
                this.updater.updateState(this.upload.id, TransferState.COMPLETED);
                return true;
            } catch (AmazonClientException e3) {
                LOGGER.error("Failed to complete multipart: " + this.upload.id + " due to " + e3.getMessage(), e3);
                abortMultiPartUpload(this.upload.id, this.upload.bucketName, this.upload.key, this.upload.multipartId);
                this.updater.throwError(this.upload.id, e3);
                this.updater.updateState(this.upload.id, TransferState.FAILED);
                return false;
            }
        } catch (Exception e4) {
            Exception exc = e4;
            LOGGER.error("Upload resulted in an exception. " + exc);
            for (UploadPartTaskMetadata uploadPartTaskMetadata3 : this.uploadPartTasks.values()) {
                uploadPartTaskMetadata3.uploadPartTask.cancel(true);
            }
            if (TransferState.PENDING_CANCEL.equals(this.upload.state)) {
                this.updater.updateState(this.upload.id, TransferState.CANCELED);
                LOGGER.info("Transfer is " + TransferState.CANCELED);
                return false;
            } else if (TransferState.PENDING_PAUSE.equals(this.upload.state)) {
                this.updater.updateState(this.upload.id, TransferState.PAUSED);
                LOGGER.info("Transfer is " + TransferState.PAUSED);
                return false;
            } else {
                for (UploadPartTaskMetadata uploadPartTaskMetadata4 : this.uploadPartTasks.values()) {
                    if (TransferState.WAITING_FOR_NETWORK.equals(uploadPartTaskMetadata4.state)) {
                        LOGGER.info("Individual part is WAITING_FOR_NETWORK.");
                        this.updater.updateState(this.upload.id, TransferState.WAITING_FOR_NETWORK);
                        return false;
                    }
                }
                try {
                    if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                        LOGGER.info("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                        this.updater.updateState(this.upload.id, TransferState.WAITING_FOR_NETWORK);
                        return false;
                    }
                } catch (TransferUtilityException e5) {
                    LOGGER.error("TransferUtilityException: [" + e5 + "]");
                }
                if (RetryUtils.isInterrupted(exc)) {
                    LOGGER.info("Transfer is interrupted. " + exc);
                    this.updater.updateState(this.upload.id, TransferState.FAILED);
                    return false;
                }
                LOGGER.error("Error encountered during multi-part upload: " + this.upload.id + " due to " + exc.getMessage(), exc);
                this.updater.throwError(this.upload.id, exc);
                this.updater.updateState(this.upload.id, TransferState.FAILED);
                return false;
            }
        }
    }

    private Boolean uploadSinglePartAndWaitForCompletion() {
        PutObjectRequest createPutObjectRequest = createPutObjectRequest(this.upload);
        ProgressListener newProgressListener = this.updater.newProgressListener(this.upload.id);
        long length = createPutObjectRequest.getFile().length();
        TransferUtility.appendTransferServiceUserAgentString(createPutObjectRequest);
        createPutObjectRequest.setGeneralProgressListener(newProgressListener);
        try {
            this.s3.putObject(createPutObjectRequest);
            this.updater.updateProgress(this.upload.id, length, length, true);
            this.updater.updateState(this.upload.id, TransferState.COMPLETED);
            return true;
        } catch (Exception e) {
            if (TransferState.PENDING_CANCEL.equals(this.upload.state)) {
                this.updater.updateState(this.upload.id, TransferState.CANCELED);
                Log log = LOGGER;
                log.info("Transfer is " + TransferState.CANCELED);
                return false;
            } else if (TransferState.PENDING_PAUSE.equals(this.upload.state)) {
                this.updater.updateState(this.upload.id, TransferState.PAUSED);
                Log log2 = LOGGER;
                log2.info("Transfer is " + TransferState.PAUSED);
                new ProgressEvent(0).setEventCode(32);
                newProgressListener.progressChanged(new ProgressEvent(0));
                return false;
            } else {
                try {
                    if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                        Log log3 = LOGGER;
                        log3.info("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                        this.updater.updateState(this.upload.id, TransferState.WAITING_FOR_NETWORK);
                        log3.debug("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                        new ProgressEvent(0).setEventCode(32);
                        newProgressListener.progressChanged(new ProgressEvent(0));
                        return false;
                    }
                } catch (TransferUtilityException e2) {
                    Log log4 = LOGGER;
                    log4.error("TransferUtilityException: [" + e2 + "]");
                }
                if (RetryUtils.isInterrupted(e)) {
                    Log log5 = LOGGER;
                    log5.info("Transfer is interrupted. " + e);
                    this.updater.updateState(this.upload.id, TransferState.FAILED);
                    return false;
                }
                Log log6 = LOGGER;
                log6.debug("Failed to upload: " + this.upload.id + " due to " + e.getMessage());
                this.updater.throwError(this.upload.id, e);
                this.updater.updateState(this.upload.id, TransferState.FAILED);
                return false;
            }
        }
    }

    private void completeMultiPartUpload(int i, String str, String str2, String str3) throws AmazonClientException, AmazonServiceException {
        CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(str, str2, str3, this.dbUtil.queryPartETagsOfUpload(i));
        TransferUtility.appendMultipartTransferServiceUserAgentString(completeMultipartUploadRequest);
        this.s3.completeMultipartUpload(completeMultipartUploadRequest);
    }

    private void abortMultiPartUpload(int i, String str, String str2, String str3) {
        Log log = LOGGER;
        log.info("Aborting the multipart since complete multipart failed.");
        try {
            this.s3.abortMultipartUpload(new AbortMultipartUploadRequest(str, str2, str3));
            log.debug("Successfully aborted multipart upload: " + i);
        } catch (AmazonClientException e) {
            Log log2 = LOGGER;
            log2.debug("Failed to abort the multipart upload: " + i, e);
        }
    }

    private String initiateMultipartUpload(PutObjectRequest putObjectRequest) {
        InitiateMultipartUploadRequest withTagging = new InitiateMultipartUploadRequest(putObjectRequest.getBucketName(), putObjectRequest.getKey()).withCannedACL(putObjectRequest.getCannedAcl()).withObjectMetadata(putObjectRequest.getMetadata()).withSSEAwsKeyManagementParams(putObjectRequest.getSSEAwsKeyManagementParams()).withTagging(putObjectRequest.getTagging());
        TransferUtility.appendMultipartTransferServiceUserAgentString(withTagging);
        return this.s3.initiateMultipartUpload(withTagging).getUploadId();
    }

    private PutObjectRequest createPutObjectRequest(TransferRecord transferRecord) {
        File file = new File(transferRecord.file);
        PutObjectRequest putObjectRequest = new PutObjectRequest(transferRecord.bucketName, transferRecord.key, file);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.length());
        if (transferRecord.headerCacheControl != null) {
            objectMetadata.setCacheControl(transferRecord.headerCacheControl);
        }
        if (transferRecord.headerContentDisposition != null) {
            objectMetadata.setContentDisposition(transferRecord.headerContentDisposition);
        }
        if (transferRecord.headerContentEncoding != null) {
            objectMetadata.setContentEncoding(transferRecord.headerContentEncoding);
        }
        if (transferRecord.headerContentType != null) {
            objectMetadata.setContentType(transferRecord.headerContentType);
        } else {
            objectMetadata.setContentType(Mimetypes.getInstance().getMimetype(file));
        }
        if (transferRecord.headerStorageClass != null) {
            putObjectRequest.setStorageClass(transferRecord.headerStorageClass);
        }
        if (transferRecord.expirationTimeRuleId != null) {
            objectMetadata.setExpirationTimeRuleId(transferRecord.expirationTimeRuleId);
        }
        if (transferRecord.httpExpires != null) {
            objectMetadata.setHttpExpiresDate(new Date(Long.valueOf(transferRecord.httpExpires).longValue()));
        }
        if (transferRecord.sseAlgorithm != null) {
            objectMetadata.setSSEAlgorithm(transferRecord.sseAlgorithm);
        }
        if (transferRecord.userMetadata != null) {
            objectMetadata.setUserMetadata(transferRecord.userMetadata);
            String str = transferRecord.userMetadata.get(Headers.S3_TAGGING);
            if (str != null) {
                try {
                    String[] split = str.split(OBJECT_TAGS_DELIMITER);
                    ArrayList arrayList = new ArrayList();
                    for (String split2 : split) {
                        String[] split3 = split2.split(OBJECT_TAG_KEY_VALUE_SEPARATOR);
                        arrayList.add(new Tag(split3[0], split3[1]));
                    }
                    putObjectRequest.setTagging(new ObjectTagging(arrayList));
                } catch (Exception e) {
                    LOGGER.error("Error in passing the object tags as request headers.", e);
                }
            }
            String str2 = transferRecord.userMetadata.get(Headers.REDIRECT_LOCATION);
            if (str2 != null) {
                putObjectRequest.setRedirectLocation(str2);
            }
            String str3 = transferRecord.userMetadata.get(Headers.REQUESTER_PAYS_HEADER);
            if (str3 != null) {
                putObjectRequest.setRequesterPays("requester".equals(str3));
            }
        }
        if (transferRecord.md5 != null) {
            objectMetadata.setContentMD5(transferRecord.md5);
        }
        if (transferRecord.sseKMSKey != null) {
            putObjectRequest.setSSEAwsKeyManagementParams(new SSEAwsKeyManagementParams(transferRecord.sseKMSKey));
        }
        putObjectRequest.setMetadata(objectMetadata);
        putObjectRequest.setCannedAcl(getCannedAclFromString(transferRecord.cannedAcl));
        return putObjectRequest;
    }

    private static CannedAccessControlList getCannedAclFromString(String str) {
        if (str == null) {
            return null;
        }
        return CANNED_ACL_MAP.get(str);
    }

    class UploadTaskProgressListener implements ProgressListener {
        private long prevTotalBytesTransferredOfAllParts;

        public void progressChanged(ProgressEvent progressEvent) {
        }

        UploadTaskProgressListener(TransferRecord transferRecord) {
            this.prevTotalBytesTransferredOfAllParts = transferRecord.bytesCurrent;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0066, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void onProgressChanged(int r8, long r9) {
            /*
                r7 = this;
                monitor-enter(r7)
                com.amazonaws.mobileconnectors.s3.transferutility.UploadTask r0 = com.amazonaws.mobileconnectors.s3.transferutility.UploadTask.this     // Catch:{ all -> 0x0067 }
                java.util.Map<java.lang.Integer, com.amazonaws.mobileconnectors.s3.transferutility.UploadTask$UploadPartTaskMetadata> r0 = r0.uploadPartTasks     // Catch:{ all -> 0x0067 }
                java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0067 }
                java.lang.Object r8 = r0.get(r8)     // Catch:{ all -> 0x0067 }
                com.amazonaws.mobileconnectors.s3.transferutility.UploadTask$UploadPartTaskMetadata r8 = (com.amazonaws.mobileconnectors.s3.transferutility.UploadTask.UploadPartTaskMetadata) r8     // Catch:{ all -> 0x0067 }
                if (r8 != 0) goto L_0x001c
                com.amazonaws.logging.Log r8 = com.amazonaws.mobileconnectors.s3.transferutility.UploadTask.LOGGER     // Catch:{ all -> 0x0067 }
                java.lang.String r9 = "Update received for unknown part. Ignoring."
                r8.info(r9)     // Catch:{ all -> 0x0067 }
                monitor-exit(r7)
                return
            L_0x001c:
                r8.bytesTransferredSoFar = r9     // Catch:{ all -> 0x0067 }
                r8 = 0
                com.amazonaws.mobileconnectors.s3.transferutility.UploadTask r10 = com.amazonaws.mobileconnectors.s3.transferutility.UploadTask.this     // Catch:{ all -> 0x0067 }
                java.util.Map<java.lang.Integer, com.amazonaws.mobileconnectors.s3.transferutility.UploadTask$UploadPartTaskMetadata> r10 = r10.uploadPartTasks     // Catch:{ all -> 0x0067 }
                java.util.Set r10 = r10.entrySet()     // Catch:{ all -> 0x0067 }
                java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x0067 }
            L_0x002c:
                boolean r0 = r10.hasNext()     // Catch:{ all -> 0x0067 }
                if (r0 == 0) goto L_0x0042
                java.lang.Object r0 = r10.next()     // Catch:{ all -> 0x0067 }
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x0067 }
                java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x0067 }
                com.amazonaws.mobileconnectors.s3.transferutility.UploadTask$UploadPartTaskMetadata r0 = (com.amazonaws.mobileconnectors.s3.transferutility.UploadTask.UploadPartTaskMetadata) r0     // Catch:{ all -> 0x0067 }
                long r0 = r0.bytesTransferredSoFar     // Catch:{ all -> 0x0067 }
                long r8 = r8 + r0
                goto L_0x002c
            L_0x0042:
                long r0 = r7.prevTotalBytesTransferredOfAllParts     // Catch:{ all -> 0x0067 }
                int r10 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r10 <= 0) goto L_0x0065
                com.amazonaws.mobileconnectors.s3.transferutility.UploadTask r10 = com.amazonaws.mobileconnectors.s3.transferutility.UploadTask.this     // Catch:{ all -> 0x0067 }
                com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater r0 = r10.updater     // Catch:{ all -> 0x0067 }
                com.amazonaws.mobileconnectors.s3.transferutility.UploadTask r10 = com.amazonaws.mobileconnectors.s3.transferutility.UploadTask.this     // Catch:{ all -> 0x0067 }
                com.amazonaws.mobileconnectors.s3.transferutility.TransferRecord r10 = r10.upload     // Catch:{ all -> 0x0067 }
                int r1 = r10.id     // Catch:{ all -> 0x0067 }
                com.amazonaws.mobileconnectors.s3.transferutility.UploadTask r10 = com.amazonaws.mobileconnectors.s3.transferutility.UploadTask.this     // Catch:{ all -> 0x0067 }
                com.amazonaws.mobileconnectors.s3.transferutility.TransferRecord r10 = r10.upload     // Catch:{ all -> 0x0067 }
                long r4 = r10.bytesTotal     // Catch:{ all -> 0x0067 }
                r6 = 1
                r2 = r8
                r0.updateProgress(r1, r2, r4, r6)     // Catch:{ all -> 0x0067 }
                r7.prevTotalBytesTransferredOfAllParts = r8     // Catch:{ all -> 0x0067 }
            L_0x0065:
                monitor-exit(r7)
                return
            L_0x0067:
                r8 = move-exception
                monitor-exit(r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.UploadTask.UploadTaskProgressListener.onProgressChanged(int, long):void");
        }
    }

    class UploadPartTaskMetadata {
        long bytesTransferredSoFar;
        TransferState state;
        UploadPartRequest uploadPartRequest;
        Future<Boolean> uploadPartTask;

        UploadPartTaskMetadata() {
        }
    }
}
