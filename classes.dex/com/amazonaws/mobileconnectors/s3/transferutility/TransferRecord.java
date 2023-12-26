package com.amazonaws.mobileconnectors.s3.transferutility;

import android.database.Cursor;
import android.net.ConnectivityManager;
import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.util.json.JsonUtils;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.GsonInstrumentation;
import com.google.gson.Gson;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class TransferRecord {
    /* access modifiers changed from: private */
    public static final Log LOGGER = LogFactory.getLog((Class<?>) TransferRecord.class);
    public String bucketName;
    public long bytesCurrent;
    public long bytesTotal;
    public String cannedAcl;
    public String eTag;
    public String expirationTimeRuleId;
    public String file;
    public long fileOffset;
    private Gson gson = new Gson();
    public String headerCacheControl;
    public String headerContentDisposition;
    public String headerContentEncoding;
    public String headerContentLanguage;
    public String headerContentType;
    public String headerExpire;
    public String headerStorageClass;
    public String httpExpires;
    public int id;
    public int isEncrypted;
    public int isLastPart;
    public int isMultipart;
    public int isRequesterPays;
    public String key;
    public int mainUploadId;
    public String md5;
    public String multipartId;
    public int partNumber;
    public long rangeLast;
    public long rangeStart;
    public long speed;
    public String sseAlgorithm;
    public String sseKMSKey;
    public TransferState state;
    private Future<?> submittedTask;
    public TransferUtilityOptions transferUtilityOptions;
    public TransferType type;
    public Map<String, String> userMetadata;
    public String versionId;

    public TransferRecord(int i) {
        this.id = i;
    }

    public void updateFromDB(Cursor cursor) {
        this.id = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_ID));
        this.mainUploadId = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_MAIN_UPLOAD_ID));
        this.type = TransferType.getType(cursor.getString(cursor.getColumnIndexOrThrow("type")));
        this.state = TransferState.getState(cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_STATE)));
        this.bucketName = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_BUCKET_NAME));
        this.key = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_KEY));
        this.versionId = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_VERSION_ID));
        this.bytesTotal = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_BYTES_TOTAL));
        this.bytesCurrent = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_BYTES_CURRENT));
        this.speed = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_SPEED));
        this.isRequesterPays = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_IS_REQUESTER_PAYS));
        this.isMultipart = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_IS_MULTIPART));
        this.isLastPart = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_IS_LAST_PART));
        this.isEncrypted = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_IS_ENCRYPTED));
        this.partNumber = cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_PART_NUM));
        this.eTag = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_ETAG));
        this.file = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_FILE));
        this.multipartId = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_MULTIPART_ID));
        this.rangeStart = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_DATA_RANGE_START));
        this.rangeLast = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_DATA_RANGE_LAST));
        this.fileOffset = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_FILE_OFFSET));
        this.headerContentType = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_CONTENT_TYPE));
        this.headerContentLanguage = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_CONTENT_LANGUAGE));
        this.headerContentDisposition = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_CONTENT_DISPOSITION));
        this.headerContentEncoding = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_CONTENT_ENCODING));
        this.headerCacheControl = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_CACHE_CONTROL));
        this.headerExpire = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_EXPIRE));
        this.userMetadata = JsonUtils.jsonToMap(cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_USER_METADATA)));
        this.expirationTimeRuleId = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_EXPIRATION_TIME_RULE_ID));
        this.httpExpires = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HTTP_EXPIRES_DATE));
        this.sseAlgorithm = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_SSE_ALGORITHM));
        this.sseKMSKey = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_SSE_KMS_KEY));
        this.md5 = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_CONTENT_MD5));
        this.cannedAcl = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_CANNED_ACL));
        this.headerStorageClass = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_HEADER_STORAGE_CLASS));
        Gson gson2 = this.gson;
        String string = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_TRANSFER_UTILITY_OPTIONS));
        Class<TransferUtilityOptions> cls = TransferUtilityOptions.class;
        this.transferUtilityOptions = (TransferUtilityOptions) (!(gson2 instanceof Gson) ? gson2.fromJson(string, cls) : GsonInstrumentation.fromJson(gson2, string, cls));
    }

    public boolean start(AmazonS3 amazonS3, TransferDBUtil transferDBUtil, TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        if (isRunning() || !checkIsReadyToRun() || !checkPreferredNetworkAvailability(transferStatusUpdater, connectivityManager)) {
            return false;
        }
        if (this.type.equals(TransferType.DOWNLOAD)) {
            this.submittedTask = TransferThreadPool.submitTask(new DownloadTask(this, amazonS3, transferStatusUpdater));
            return true;
        }
        this.submittedTask = TransferThreadPool.submitTask(new UploadTask(this, amazonS3, transferDBUtil, transferStatusUpdater));
        return true;
    }

    public boolean pause(AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater) {
        if (isFinalState(this.state) || TransferState.PAUSED.equals(this.state) || TransferState.PENDING_PAUSE.equals(this.state)) {
            return false;
        }
        transferStatusUpdater.updateState(this.id, TransferState.PENDING_PAUSE);
        if (isRunning()) {
            this.submittedTask.cancel(true);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean pauseIfRequiredForNetworkInterruption(AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        boolean checkPreferredNetworkAvailability = checkPreferredNetworkAvailability(transferStatusUpdater, connectivityManager);
        boolean z = false;
        if (!checkPreferredNetworkAvailability && !isFinalState(this.state)) {
            z = true;
            if (isRunning()) {
                this.submittedTask.cancel(true);
            }
        }
        return z;
    }

    public boolean cancel(final AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater) {
        if (isFinalState(this.state)) {
            return false;
        }
        transferStatusUpdater.updateState(this.id, TransferState.PENDING_CANCEL);
        if (isRunning()) {
            this.submittedTask.cancel(true);
        }
        if (TransferType.UPLOAD.equals(this.type) && this.isMultipart == 1) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        amazonS3.abortMultipartUpload(new AbortMultipartUploadRequest(TransferRecord.this.bucketName, TransferRecord.this.key, TransferRecord.this.multipartId));
                        Log access$000 = TransferRecord.LOGGER;
                        access$000.debug("Successfully clean up multipart upload: " + TransferRecord.this.id);
                    } catch (AmazonClientException e) {
                        Log access$0002 = TransferRecord.LOGGER;
                        access$0002.debug("Failed to abort multiplart upload: " + TransferRecord.this.id, e);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else if (TransferType.DOWNLOAD.equals(this.type)) {
            new File(this.file).delete();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isRunning() {
        Future<?> future = this.submittedTask;
        return future != null && !future.isDone();
    }

    /* access modifiers changed from: package-private */
    public void waitTillFinish(long j) throws InterruptedException, ExecutionException, TimeoutException {
        if (isRunning()) {
            this.submittedTask.get(j, TimeUnit.MILLISECONDS);
        }
    }

    private boolean isFinalState(TransferState transferState) {
        return TransferState.COMPLETED.equals(transferState) || TransferState.FAILED.equals(transferState) || TransferState.CANCELED.equals(transferState);
    }

    private boolean checkIsReadyToRun() {
        return this.partNumber == 0 && !TransferState.COMPLETED.equals(this.state);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("id:");
        sb.append(this.id);
        sb.append(",");
        sb.append("bucketName:");
        sb.append(this.bucketName);
        sb.append(",");
        sb.append("key:");
        sb.append(this.key);
        sb.append(",");
        sb.append("file:");
        sb.append(this.file);
        sb.append(",");
        sb.append("type:");
        sb.append(this.type);
        sb.append(",");
        sb.append("bytesTotal:");
        sb.append(this.bytesTotal);
        sb.append(",");
        sb.append("bytesCurrent:");
        sb.append(this.bytesCurrent);
        sb.append(",");
        sb.append("fileOffset:");
        sb.append(this.fileOffset);
        sb.append(",");
        sb.append("state:");
        sb.append(this.state);
        sb.append(",");
        sb.append("cannedAcl:");
        sb.append(this.cannedAcl);
        sb.append(",");
        sb.append("mainUploadId:");
        sb.append(this.mainUploadId);
        sb.append(",");
        sb.append("isMultipart:");
        sb.append(this.isMultipart);
        sb.append(",");
        sb.append("isLastPart:");
        sb.append(this.isLastPart);
        sb.append(",");
        sb.append("partNumber:");
        sb.append(this.partNumber);
        sb.append(",");
        sb.append("multipartId:");
        sb.append(this.multipartId);
        sb.append(",");
        sb.append("eTag:");
        sb.append(this.eTag);
        sb.append(",");
        sb.append("storageClass:");
        sb.append(this.headerStorageClass);
        sb.append(",");
        sb.append("userMetadata:");
        sb.append(this.userMetadata.toString());
        sb.append(",");
        sb.append("transferUtilityOptions:");
        Gson gson2 = this.gson;
        TransferUtilityOptions transferUtilityOptions2 = this.transferUtilityOptions;
        sb.append(!(gson2 instanceof Gson) ? gson2.toJson(transferUtilityOptions2) : GsonInstrumentation.toJson(gson2, transferUtilityOptions2));
        sb.append("]");
        return sb.toString();
    }

    private boolean checkPreferredNetworkAvailability(TransferStatusUpdater transferStatusUpdater, ConnectivityManager connectivityManager) {
        TransferUtilityOptions transferUtilityOptions2;
        if (connectivityManager == null || (transferUtilityOptions2 = this.transferUtilityOptions) == null || transferUtilityOptions2.getTransferNetworkConnectionType().isConnected(connectivityManager)) {
            return true;
        }
        Log log = LOGGER;
        log.info("Network Connection " + this.transferUtilityOptions.getTransferNetworkConnectionType() + " is not available.");
        transferStatusUpdater.updateState(this.id, TransferState.WAITING_FOR_NETWORK);
        return false;
    }
}
