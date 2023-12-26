package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import java.io.File;
import java.util.concurrent.Callable;

class DownloadTask implements Callable<Boolean> {
    private static final Log LOGGER = LogFactory.getLog((Class<?>) DownloadTask.class);
    private static final int SIXTEEN_KB = 16384;
    private final TransferRecord download;
    private final AmazonS3 s3;
    private final TransferStatusUpdater updater;

    public DownloadTask(TransferRecord transferRecord, AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater) {
        this.download = transferRecord;
        this.s3 = amazonS3;
        this.updater = transferStatusUpdater;
    }

    public Boolean call() {
        try {
            if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                Log log = LOGGER;
                log.info("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                this.updater.updateState(this.download.id, TransferState.WAITING_FOR_NETWORK);
                return false;
            }
        } catch (TransferUtilityException e) {
            Log log2 = LOGGER;
            log2.error("TransferUtilityException: [" + e + "]");
        }
        this.updater.updateState(this.download.id, TransferState.IN_PROGRESS);
        ProgressListener newProgressListener = this.updater.newProgressListener(this.download.id);
        try {
            GetObjectRequest getObjectRequest = new GetObjectRequest(this.download.bucketName, this.download.key);
            TransferUtility.appendTransferServiceUserAgentString(getObjectRequest);
            File file = new File(this.download.file);
            long length = file.length();
            if (length > 0) {
                LOGGER.debug(String.format("Resume transfer %d from %d bytes", new Object[]{Integer.valueOf(this.download.id), Long.valueOf(length)}));
                getObjectRequest.setRange(length, -1);
            }
            getObjectRequest.setGeneralProgressListener(newProgressListener);
            S3Object object = this.s3.getObject(getObjectRequest);
            if (object == null) {
                this.updater.throwError(this.download.id, new IllegalStateException("AmazonS3.getObject returns null"));
                this.updater.updateState(this.download.id, TransferState.FAILED);
                return false;
            }
            long instanceLength = object.getObjectMetadata().getInstanceLength();
            this.updater.updateProgress(this.download.id, length, instanceLength, true);
            saveToFile(object.getObjectContent(), file);
            this.updater.updateProgress(this.download.id, instanceLength, instanceLength, true);
            this.updater.updateState(this.download.id, TransferState.COMPLETED);
            return true;
        } catch (Exception e2) {
            Exception exc = e2;
            if (TransferState.PENDING_CANCEL.equals(this.download.state)) {
                this.updater.updateState(this.download.id, TransferState.CANCELED);
                Log log3 = LOGGER;
                log3.info("Transfer is " + TransferState.CANCELED);
                return false;
            } else if (TransferState.PENDING_PAUSE.equals(this.download.state)) {
                this.updater.updateState(this.download.id, TransferState.PAUSED);
                Log log4 = LOGGER;
                log4.info("Transfer is " + TransferState.PAUSED);
                new ProgressEvent(0).setEventCode(32);
                newProgressListener.progressChanged(new ProgressEvent(0));
                return false;
            } else {
                try {
                    if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                        Log log5 = LOGGER;
                        log5.info("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                        this.updater.updateState(this.download.id, TransferState.WAITING_FOR_NETWORK);
                        log5.debug("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                        new ProgressEvent(0).setEventCode(32);
                        newProgressListener.progressChanged(new ProgressEvent(0));
                        return false;
                    }
                } catch (TransferUtilityException e3) {
                    Log log6 = LOGGER;
                    log6.error("TransferUtilityException: [" + e3 + "]");
                }
                if (RetryUtils.isInterrupted(exc)) {
                    Log log7 = LOGGER;
                    log7.info("Transfer is interrupted. " + exc);
                    this.updater.updateState(this.download.id, TransferState.FAILED);
                    return false;
                }
                Log log8 = LOGGER;
                log8.debug("Failed to download: " + this.download.id + " due to " + exc.getMessage());
                this.updater.throwError(this.download.id, exc);
                this.updater.updateState(this.download.id, TransferState.FAILED);
                return false;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x009a A[SYNTHETIC, Splitter:B:42:0x009a] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a6 A[SYNTHETIC, Splitter:B:47:0x00a6] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void saveToFile(java.io.InputStream r7, java.io.File r8) {
        /*
            r6 = this;
            java.lang.String r0 = "got exception"
            java.io.File r1 = r8.getParentFile()
            if (r1 == 0) goto L_0x0011
            boolean r2 = r1.exists()
            if (r2 != 0) goto L_0x0011
            r1.mkdirs()
        L_0x0011:
            long r1 = r8.length()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 0
            if (r1 <= 0) goto L_0x001e
            r1 = 1
            goto L_0x001f
        L_0x001e:
            r1 = r2
        L_0x001f:
            r3 = 0
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ SocketTimeoutException -> 0x0077, IOException -> 0x005b }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ SocketTimeoutException -> 0x0077, IOException -> 0x005b }
            r5.<init>(r8, r1)     // Catch:{ SocketTimeoutException -> 0x0077, IOException -> 0x005b }
            r4.<init>(r5)     // Catch:{ SocketTimeoutException -> 0x0077, IOException -> 0x005b }
            r8 = 16384(0x4000, float:2.2959E-41)
            byte[] r8 = new byte[r8]     // Catch:{ SocketTimeoutException -> 0x0056, IOException -> 0x0053, all -> 0x0050 }
        L_0x002e:
            int r1 = r7.read(r8)     // Catch:{ SocketTimeoutException -> 0x0056, IOException -> 0x0053, all -> 0x0050 }
            r3 = -1
            if (r1 == r3) goto L_0x0039
            r4.write(r8, r2, r1)     // Catch:{ SocketTimeoutException -> 0x0056, IOException -> 0x0053, all -> 0x0050 }
            goto L_0x002e
        L_0x0039:
            r4.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0043
        L_0x003d:
            r8 = move-exception
            com.amazonaws.logging.Log r1 = LOGGER
            r1.warn(r0, r8)
        L_0x0043:
            if (r7 == 0) goto L_0x004f
            r7.close()     // Catch:{ IOException -> 0x0049 }
            goto L_0x004f
        L_0x0049:
            r7 = move-exception
            com.amazonaws.logging.Log r8 = LOGGER
            r8.warn(r0, r7)
        L_0x004f:
            return
        L_0x0050:
            r8 = move-exception
            r3 = r4
            goto L_0x0098
        L_0x0053:
            r8 = move-exception
            r3 = r4
            goto L_0x005c
        L_0x0056:
            r8 = move-exception
            r3 = r4
            goto L_0x0078
        L_0x0059:
            r8 = move-exception
            goto L_0x0098
        L_0x005b:
            r8 = move-exception
        L_0x005c:
            com.amazonaws.AmazonClientException r1 = new com.amazonaws.AmazonClientException     // Catch:{ all -> 0x0059 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0059 }
            r2.<init>()     // Catch:{ all -> 0x0059 }
            java.lang.String r4 = "Unable to store object contents to disk: "
            r2.append(r4)     // Catch:{ all -> 0x0059 }
            java.lang.String r4 = r8.getMessage()     // Catch:{ all -> 0x0059 }
            r2.append(r4)     // Catch:{ all -> 0x0059 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0059 }
            r1.<init>(r2, r8)     // Catch:{ all -> 0x0059 }
            throw r1     // Catch:{ all -> 0x0059 }
        L_0x0077:
            r8 = move-exception
        L_0x0078:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0059 }
            r1.<init>()     // Catch:{ all -> 0x0059 }
            java.lang.String r2 = "SocketTimeoutException: Unable to retrieve contents over network: "
            r1.append(r2)     // Catch:{ all -> 0x0059 }
            java.lang.String r2 = r8.getMessage()     // Catch:{ all -> 0x0059 }
            r1.append(r2)     // Catch:{ all -> 0x0059 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0059 }
            com.amazonaws.logging.Log r2 = LOGGER     // Catch:{ all -> 0x0059 }
            r2.error(r1)     // Catch:{ all -> 0x0059 }
            com.amazonaws.AmazonClientException r2 = new com.amazonaws.AmazonClientException     // Catch:{ all -> 0x0059 }
            r2.<init>(r1, r8)     // Catch:{ all -> 0x0059 }
            throw r2     // Catch:{ all -> 0x0059 }
        L_0x0098:
            if (r3 == 0) goto L_0x00a4
            r3.close()     // Catch:{ IOException -> 0x009e }
            goto L_0x00a4
        L_0x009e:
            r1 = move-exception
            com.amazonaws.logging.Log r2 = LOGGER
            r2.warn(r0, r1)
        L_0x00a4:
            if (r7 == 0) goto L_0x00b0
            r7.close()     // Catch:{ IOException -> 0x00aa }
            goto L_0x00b0
        L_0x00aa:
            r7 = move-exception
            com.amazonaws.logging.Log r1 = LOGGER
            r1.warn(r0, r7)
        L_0x00b0:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.DownloadTask.saveToFile(java.io.InputStream, java.io.File):void");
    }
}
