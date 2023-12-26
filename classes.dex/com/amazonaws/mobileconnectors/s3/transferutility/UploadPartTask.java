package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.AbortedException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.s3.transferutility.UploadTask;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

class UploadPartTask implements Callable<Boolean> {
    /* access modifiers changed from: private */
    public static final Log LOGGER = LogFactory.getLog((Class<?>) UploadPartTask.class);
    private static final int RETRY_COUNT = 3;
    private final TransferDBUtil dbUtil;
    private final AmazonS3 s3;
    /* access modifiers changed from: private */
    public final UploadPartRequest uploadPartRequest;
    private final UploadTask.UploadPartTaskMetadata uploadPartTaskMetadata;
    private final UploadPartTaskProgressListener uploadPartTaskProgressListener;

    public UploadPartTask(UploadTask.UploadPartTaskMetadata uploadPartTaskMetadata2, UploadTask.UploadTaskProgressListener uploadTaskProgressListener, UploadPartRequest uploadPartRequest2, AmazonS3 amazonS3, TransferDBUtil transferDBUtil) {
        this.uploadPartTaskMetadata = uploadPartTaskMetadata2;
        this.uploadPartTaskProgressListener = new UploadPartTaskProgressListener(uploadTaskProgressListener);
        this.uploadPartRequest = uploadPartRequest2;
        this.s3 = amazonS3;
        this.dbUtil = transferDBUtil;
    }

    public Boolean call() throws Exception {
        this.uploadPartTaskMetadata.state = TransferState.IN_PROGRESS;
        this.uploadPartRequest.setGeneralProgressListener(this.uploadPartTaskProgressListener);
        int i = 1;
        while (true) {
            try {
                UploadPartResult uploadPart = this.s3.uploadPart(this.uploadPartRequest);
                setTaskState(TransferState.PART_COMPLETED);
                this.dbUtil.updateETag(this.uploadPartRequest.getId(), uploadPart.getETag());
                return true;
            } catch (AbortedException unused) {
                LOGGER.debug("Upload part aborted.");
                resetProgress();
                return false;
            } catch (Exception e) {
                Log log = LOGGER;
                log.error("Unexpected error occurred: " + e);
                resetProgress();
                try {
                    if (TransferNetworkLossHandler.getInstance() != null && !TransferNetworkLossHandler.getInstance().isNetworkConnected()) {
                        log.info("Thread: [" + Thread.currentThread().getId() + "]: Network wasn't available.");
                        this.uploadPartTaskMetadata.state = TransferState.WAITING_FOR_NETWORK;
                        this.dbUtil.updateState(this.uploadPartRequest.getId(), TransferState.WAITING_FOR_NETWORK);
                        log.info("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                        return false;
                    }
                } catch (TransferUtilityException e2) {
                    LOGGER.error("TransferUtilityException: [" + e2 + "]");
                }
                if (i < 3) {
                    long exponentialBackoffWithJitter = exponentialBackoffWithJitter(i);
                    Log log2 = LOGGER;
                    log2.info("Retrying in " + exponentialBackoffWithJitter + " ms.");
                    TimeUnit.MILLISECONDS.sleep(exponentialBackoffWithJitter);
                    log2.debug("Retry attempt: " + i, e);
                    i++;
                } else {
                    setTaskState(TransferState.FAILED);
                    LOGGER.error("Encountered error uploading part ", e);
                    throw e;
                }
            }
        }
    }

    private void setTaskState(TransferState transferState) {
        this.uploadPartTaskMetadata.state = transferState;
        this.dbUtil.updateState(this.uploadPartRequest.getId(), transferState);
    }

    private void resetProgress() {
        ProgressEvent progressEvent = new ProgressEvent(0);
        progressEvent.setEventCode(32);
        this.uploadPartTaskProgressListener.progressChanged(progressEvent);
    }

    private class UploadPartTaskProgressListener implements ProgressListener {
        private long bytesTransferredSoFar;
        private final UploadTask.UploadTaskProgressListener uploadTaskProgressListener;

        public UploadPartTaskProgressListener(UploadTask.UploadTaskProgressListener uploadTaskProgressListener2) {
            this.uploadTaskProgressListener = uploadTaskProgressListener2;
        }

        public void progressChanged(ProgressEvent progressEvent) {
            if (32 == progressEvent.getEventCode()) {
                UploadPartTask.LOGGER.debug("Reset Event triggered. Resetting the bytesCurrent to 0.");
                this.bytesTransferredSoFar = 0;
            } else {
                this.bytesTransferredSoFar += progressEvent.getBytesTransferred();
            }
            this.uploadTaskProgressListener.onProgressChanged(UploadPartTask.this.uploadPartRequest.getPartNumber(), this.bytesTransferredSoFar);
        }
    }

    private long exponentialBackoffWithJitter(int i) {
        return (((long) (1 << i)) * 1000) + ((long) (Math.random() * 1000.0d));
    }
}
