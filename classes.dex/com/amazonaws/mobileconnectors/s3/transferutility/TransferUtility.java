package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import com.adyen.checkout.card.ui.ExpiryDateInput;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.RequestClientOptions;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.internal.Constants;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.VersionInfoUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class TransferUtility {
    private static final Object LOCK = new Object();
    private static final Log LOGGER = LogFactory.getLog((Class<?>) TransferUtility.class);
    static final int MINIMUM_UPLOAD_PART_SIZE = 5242880;
    private static final String TRANSFER_ADD = "add_transfer";
    private static final String TRANSFER_CANCEL = "cancel_transfer";
    private static final String TRANSFER_PAUSE = "pause_transfer";
    private static final String TRANSFER_RESUME = "resume_transfer";
    private static String userAgentFromConfig = "";
    final ConnectivityManager connManager;
    private TransferDBUtil dbUtil;
    private final String defaultBucket;
    private final AmazonS3 s3;
    private final TransferUtilityOptions transferUtilityOptions;
    private TransferStatusUpdater updater;

    /* access modifiers changed from: private */
    public static void setUserAgentFromConfig(String str) {
        synchronized (LOCK) {
            userAgentFromConfig = str;
        }
    }

    private static String getUserAgentFromConfig() {
        synchronized (LOCK) {
            String str = userAgentFromConfig;
            if (str != null) {
                if (!str.trim().isEmpty()) {
                    String str2 = userAgentFromConfig.trim() + ExpiryDateInput.SEPARATOR;
                    return str2;
                }
            }
            return "";
        }
    }

    public static class Builder {
        private Context appContext;
        private AWSConfiguration awsConfig;
        private String defaultBucket;
        private AmazonS3 s3;
        private TransferUtilityOptions transferUtilityOptions;

        protected Builder() {
        }

        public Builder s3Client(AmazonS3 amazonS3) {
            this.s3 = amazonS3;
            return this;
        }

        public Builder context(Context context) {
            this.appContext = context.getApplicationContext();
            return this;
        }

        public Builder defaultBucket(String str) {
            this.defaultBucket = str;
            return this;
        }

        public Builder awsConfiguration(AWSConfiguration aWSConfiguration) {
            this.awsConfig = aWSConfiguration;
            return this;
        }

        public Builder transferUtilityOptions(TransferUtilityOptions transferUtilityOptions2) {
            this.transferUtilityOptions = transferUtilityOptions2;
            return this;
        }

        public TransferUtility build() {
            if (this.s3 == null) {
                throw new IllegalArgumentException("AmazonS3 client is required please set using .s3Client(yourClient)");
            } else if (this.appContext != null) {
                AWSConfiguration aWSConfiguration = this.awsConfig;
                if (aWSConfiguration != null) {
                    try {
                        JSONObject optJsonObject = aWSConfiguration.optJsonObject("S3TransferUtility");
                        this.s3.setRegion(Region.getRegion(optJsonObject.getString("Region")));
                        this.defaultBucket = optJsonObject.getString("Bucket");
                        if (optJsonObject.has(Constants.LOCAL_TESTING_FLAG_NAME) ? optJsonObject.getBoolean(Constants.LOCAL_TESTING_FLAG_NAME) : false) {
                            this.s3.setEndpoint(Constants.LOCAL_TESTING_ENDPOINT);
                            this.s3.setS3ClientOptions(S3ClientOptions.builder().setPathStyleAccess(true).skipContentMd5Check(true).build());
                        }
                        TransferUtility.setUserAgentFromConfig(this.awsConfig.getUserAgent());
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Failed to read S3TransferUtility please check your setup or awsconfiguration.json file", e);
                    }
                }
                if (this.transferUtilityOptions == null) {
                    this.transferUtilityOptions = new TransferUtilityOptions();
                }
                return new TransferUtility(this.s3, this.appContext, this.defaultBucket, this.transferUtilityOptions);
            } else {
                throw new IllegalArgumentException("Context is required please set using .context(applicationContext)");
            }
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private TransferUtility(AmazonS3 amazonS3, Context context, String str, TransferUtilityOptions transferUtilityOptions2) {
        this.s3 = amazonS3;
        this.defaultBucket = str;
        this.transferUtilityOptions = transferUtilityOptions2;
        this.dbUtil = new TransferDBUtil(context.getApplicationContext());
        this.updater = TransferStatusUpdater.getInstance(context.getApplicationContext());
        TransferThreadPool.init(transferUtilityOptions2.getTransferThreadPoolSize());
        this.connManager = (ConnectivityManager) context.getSystemService("connectivity");
    }

    @Deprecated
    public TransferUtility(AmazonS3 amazonS3, Context context) {
        this.s3 = amazonS3;
        this.defaultBucket = null;
        TransferUtilityOptions transferUtilityOptions2 = new TransferUtilityOptions();
        this.transferUtilityOptions = transferUtilityOptions2;
        this.dbUtil = new TransferDBUtil(context.getApplicationContext());
        this.updater = TransferStatusUpdater.getInstance(context.getApplicationContext());
        TransferThreadPool.init(transferUtilityOptions2.getTransferThreadPoolSize());
        this.connManager = (ConnectivityManager) context.getSystemService("connectivity");
    }

    private String getDefaultBucketOrThrow() {
        String str = this.defaultBucket;
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("TransferUtility has not been configured with a default bucket. Please use the corresponding method that specifies bucket name or configure the default bucket name in construction of the object. See TransferUtility.builder().defaultBucket() or TransferUtility.builder().awsConfiguration()");
    }

    public TransferObserver download(String str, String str2, File file) {
        return download(str, str2, file, (TransferListener) null);
    }

    public TransferObserver download(String str, File file) {
        return download(getDefaultBucketOrThrow(), str, file, (TransferListener) null);
    }

    public TransferObserver download(String str, String str2, File file, TransferListener transferListener) {
        if (file == null || file.isDirectory()) {
            throw new IllegalArgumentException("Invalid file: " + file);
        }
        int parseInt = Integer.parseInt(this.dbUtil.insertSingleTransferRecord(TransferType.DOWNLOAD, str, str2, file, this.transferUtilityOptions).getLastPathSegment());
        if (file.isFile()) {
            Log log = LOGGER;
            log.warn("Overwrite existing file: " + file);
            file.delete();
        }
        TransferObserver transferObserver = new TransferObserver(parseInt, this.dbUtil, str, str2, file, transferListener);
        submitTransferJob(TRANSFER_ADD, parseInt);
        return transferObserver;
    }

    public TransferObserver download(String str, File file, TransferListener transferListener) {
        return download(getDefaultBucketOrThrow(), str, file, transferListener);
    }

    public TransferObserver upload(String str, String str2, File file) {
        return upload(str, str2, file, new ObjectMetadata());
    }

    public TransferObserver upload(String str, File file) {
        return upload(getDefaultBucketOrThrow(), str, file, new ObjectMetadata());
    }

    public TransferObserver upload(String str, String str2, File file, CannedAccessControlList cannedAccessControlList) {
        return upload(str, str2, file, new ObjectMetadata(), cannedAccessControlList);
    }

    public TransferObserver upload(String str, File file, CannedAccessControlList cannedAccessControlList) {
        return upload(getDefaultBucketOrThrow(), str, file, new ObjectMetadata(), cannedAccessControlList);
    }

    public TransferObserver upload(String str, String str2, File file, ObjectMetadata objectMetadata) {
        return upload(str, str2, file, objectMetadata, (CannedAccessControlList) null);
    }

    public TransferObserver upload(String str, File file, ObjectMetadata objectMetadata) {
        return upload(getDefaultBucketOrThrow(), str, file, objectMetadata, (CannedAccessControlList) null);
    }

    public TransferObserver upload(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList) {
        return upload(str, str2, file, objectMetadata, cannedAccessControlList, (TransferListener) null);
    }

    public TransferObserver upload(String str, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList) {
        return upload(getDefaultBucketOrThrow(), str, file, objectMetadata, cannedAccessControlList, (TransferListener) null);
    }

    public TransferObserver upload(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferListener transferListener) {
        int i;
        if (file == null || file.isDirectory() || !file.exists()) {
            throw new IllegalArgumentException("Invalid file: " + file);
        }
        if (shouldUploadInMultipart(file)) {
            i = createMultipartUploadRecords(str, str2, file, objectMetadata, cannedAccessControlList);
        } else {
            i = Integer.parseInt(this.dbUtil.insertSingleTransferRecord(TransferType.UPLOAD, str, str2, file, objectMetadata, cannedAccessControlList, this.transferUtilityOptions).getLastPathSegment());
        }
        TransferObserver transferObserver = new TransferObserver(i, this.dbUtil, str, str2, file, transferListener);
        submitTransferJob(TRANSFER_ADD, i);
        return transferObserver;
    }

    public TransferObserver upload(String str, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList, TransferListener transferListener) {
        return upload(getDefaultBucketOrThrow(), str, file, objectMetadata, cannedAccessControlList, transferListener);
    }

    public TransferObserver upload(String str, InputStream inputStream) throws IOException {
        return upload(str, inputStream, UploadOptions.builder().build());
    }

    public TransferObserver upload(String str, InputStream inputStream, UploadOptions uploadOptions) throws IOException {
        return upload(uploadOptions.getBucket() != null ? uploadOptions.getBucket() : getDefaultBucketOrThrow(), str, writeInputStreamToFile(inputStream), uploadOptions.getMetadata() != null ? uploadOptions.getMetadata() : new ObjectMetadata(), uploadOptions.getCannedAcl(), uploadOptions.getTransferListener());
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver getTransferById(int r4) {
        /*
            r3 = this;
            r0 = 0
            com.amazonaws.mobileconnectors.s3.transferutility.TransferDBUtil r1 = r3.dbUtil     // Catch:{ all -> 0x0026 }
            android.database.Cursor r1 = r1.queryTransferById(r4)     // Catch:{ all -> 0x0026 }
            boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x0023 }
            if (r2 == 0) goto L_0x001d
            com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver r0 = new com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver     // Catch:{ all -> 0x0023 }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferDBUtil r2 = r3.dbUtil     // Catch:{ all -> 0x0023 }
            r0.<init>(r4, r2)     // Catch:{ all -> 0x0023 }
            r0.updateFromDB(r1)     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x001c
            r1.close()
        L_0x001c:
            return r0
        L_0x001d:
            if (r1 == 0) goto L_0x0022
            r1.close()
        L_0x0022:
            return r0
        L_0x0023:
            r4 = move-exception
            r0 = r1
            goto L_0x0027
        L_0x0026:
            r4 = move-exception
        L_0x0027:
            if (r0 == 0) goto L_0x002c
            r0.close()
        L_0x002c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility.getTransferById(int):com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver");
    }

    public List<TransferObserver> getTransfersWithType(TransferType transferType) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.dbUtil.queryAllTransfersWithType(transferType);
            while (cursor.moveToNext()) {
                TransferObserver transferObserver = new TransferObserver(cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_ID)), this.dbUtil);
                transferObserver.updateFromDB(cursor);
                arrayList.add(transferObserver);
            }
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public List<TransferObserver> getTransfersWithTypeAndState(TransferType transferType, TransferState transferState) {
        return getTransfersWithTypeAndStates(transferType, new TransferState[]{transferState});
    }

    public List<TransferObserver> getTransfersWithTypeAndStates(TransferType transferType, TransferState[] transferStateArr) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.dbUtil.queryTransfersWithTypeAndStates(transferType, transferStateArr);
            while (cursor.moveToNext()) {
                if (cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_PART_NUM)) == 0) {
                    TransferObserver transferObserver = new TransferObserver(cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_ID)), this.dbUtil);
                    transferObserver.updateFromDB(cursor);
                    arrayList.add(transferObserver);
                }
            }
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private List<Integer> getTransferIdsWithTypeAndStates(TransferType transferType, TransferState[] transferStateArr) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = this.dbUtil.queryTransfersWithTypeAndStates(transferType, transferStateArr);
            while (cursor.moveToNext()) {
                if (cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_PART_NUM)) == 0) {
                    arrayList.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_ID))));
                }
            }
            return arrayList;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private int createMultipartUploadRecords(String str, String str2, File file, ObjectMetadata objectMetadata, CannedAccessControlList cannedAccessControlList) {
        long length = file.length();
        double d = (double) length;
        long max = (long) Math.max(Math.ceil(d / 10000.0d), 5242880.0d);
        int ceil = ((int) Math.ceil(d / ((double) max))) + 1;
        ContentValues[] contentValuesArr = new ContentValues[ceil];
        contentValuesArr[0] = this.dbUtil.generateContentValuesForMultiPartUpload(str, str2, file, 0, 0, "", file.length(), 0, objectMetadata, cannedAccessControlList, this.transferUtilityOptions);
        int i = 1;
        long j = 0;
        for (int i2 = 1; i2 < ceil; i2++) {
            long min = Math.min(max, length);
            length -= max;
            contentValuesArr[i2] = this.dbUtil.generateContentValuesForMultiPartUpload(str, str2, file, j, i, "", min, length <= 0 ? 1 : 0, objectMetadata, cannedAccessControlList, this.transferUtilityOptions);
            j += max;
            i++;
        }
        return this.dbUtil.bulkInsertTransferRecords(contentValuesArr);
    }

    private File writeInputStreamToFile(InputStream inputStream) throws IOException {
        if (inputStream != null) {
            File createTempFile = File.createTempFile("aws-s3-d861b25a-1edf-11eb-adc1-0242ac120002", ".tmp");
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    } else {
                        fileOutputStream.close();
                        return createTempFile;
                    }
                }
            } catch (IOException e) {
                createTempFile.delete();
                throw new IOException("Error writing the inputStream into a file.", e);
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Invalid inputStream: " + inputStream);
        }
    }

    public boolean pause(int i) {
        submitTransferJob(TRANSFER_PAUSE, i);
        return true;
    }

    public void pauseAllWithType(TransferType transferType) {
        Cursor cursor = null;
        try {
            cursor = this.dbUtil.queryAllTransfersWithType(transferType);
            while (cursor.moveToNext()) {
                pause(cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_ID)));
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public TransferObserver resume(int i) {
        submitTransferJob(TRANSFER_RESUME, i);
        return getTransferById(i);
    }

    public List<TransferObserver> resumeAllWithType(TransferType transferType) {
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : getTransferIdsWithTypeAndStates(transferType, new TransferState[]{TransferState.PAUSED, TransferState.FAILED, TransferState.CANCELED})) {
            arrayList.add(resume(intValue.intValue()));
        }
        return arrayList;
    }

    public boolean cancel(int i) {
        submitTransferJob(TRANSFER_CANCEL, i);
        return true;
    }

    public void cancelAllWithType(TransferType transferType) {
        Cursor cursor = null;
        try {
            cursor = this.dbUtil.queryAllTransfersWithType(transferType);
            while (cursor.moveToNext()) {
                cancel(cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_ID)));
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public boolean deleteTransferRecord(int i) {
        cancel(i);
        return this.dbUtil.deleteTransferRecords(i) > 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ac, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void submitTransferJob(java.lang.String r4, int r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x00ad }
            com.amazonaws.services.s3.AmazonS3 r1 = r3.s3     // Catch:{ all -> 0x00ad }
            com.amazonaws.mobileconnectors.s3.transferutility.S3ClientReference.put(r0, r1)     // Catch:{ all -> 0x00ad }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater r0 = r3.updater     // Catch:{ all -> 0x00ad }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferRecord r0 = r0.getTransfer(r5)     // Catch:{ all -> 0x00ad }
            if (r0 != 0) goto L_0x0038
            com.amazonaws.mobileconnectors.s3.transferutility.TransferDBUtil r0 = r3.dbUtil     // Catch:{ all -> 0x00ad }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferRecord r0 = r0.getTransferById(r5)     // Catch:{ all -> 0x00ad }
            if (r0 != 0) goto L_0x0032
            com.amazonaws.logging.Log r4 = LOGGER     // Catch:{ all -> 0x00ad }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
            r0.<init>()     // Catch:{ all -> 0x00ad }
            java.lang.String r1 = "Cannot find transfer with id: "
            r0.append(r1)     // Catch:{ all -> 0x00ad }
            r0.append(r5)     // Catch:{ all -> 0x00ad }
            java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x00ad }
            r4.error(r5)     // Catch:{ all -> 0x00ad }
            monitor-exit(r3)
            return
        L_0x0032:
            com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater r5 = r3.updater     // Catch:{ all -> 0x00ad }
            r5.addTransfer(r0)     // Catch:{ all -> 0x00ad }
            goto L_0x0058
        L_0x0038:
            java.lang.String r1 = "add_transfer"
            boolean r1 = r1.equals(r4)     // Catch:{ all -> 0x00ad }
            if (r1 == 0) goto L_0x0058
            com.amazonaws.logging.Log r4 = LOGGER     // Catch:{ all -> 0x00ad }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
            r0.<init>()     // Catch:{ all -> 0x00ad }
            java.lang.String r1 = "Transfer has already been added: "
            r0.append(r1)     // Catch:{ all -> 0x00ad }
            r0.append(r5)     // Catch:{ all -> 0x00ad }
            java.lang.String r5 = r0.toString()     // Catch:{ all -> 0x00ad }
            r4.warn(r5)     // Catch:{ all -> 0x00ad }
            monitor-exit(r3)
            return
        L_0x0058:
            java.lang.String r5 = "add_transfer"
            boolean r5 = r5.equals(r4)     // Catch:{ all -> 0x00ad }
            if (r5 != 0) goto L_0x00a0
            java.lang.String r5 = "resume_transfer"
            boolean r5 = r5.equals(r4)     // Catch:{ all -> 0x00ad }
            if (r5 == 0) goto L_0x0069
            goto L_0x00a0
        L_0x0069:
            java.lang.String r5 = "pause_transfer"
            boolean r5 = r5.equals(r4)     // Catch:{ all -> 0x00ad }
            if (r5 == 0) goto L_0x0079
            com.amazonaws.services.s3.AmazonS3 r4 = r3.s3     // Catch:{ all -> 0x00ad }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater r5 = r3.updater     // Catch:{ all -> 0x00ad }
            r0.pause(r4, r5)     // Catch:{ all -> 0x00ad }
            goto L_0x00ab
        L_0x0079:
            java.lang.String r5 = "cancel_transfer"
            boolean r5 = r5.equals(r4)     // Catch:{ all -> 0x00ad }
            if (r5 == 0) goto L_0x0089
            com.amazonaws.services.s3.AmazonS3 r4 = r3.s3     // Catch:{ all -> 0x00ad }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater r5 = r3.updater     // Catch:{ all -> 0x00ad }
            r0.cancel(r4, r5)     // Catch:{ all -> 0x00ad }
            goto L_0x00ab
        L_0x0089:
            com.amazonaws.logging.Log r5 = LOGGER     // Catch:{ all -> 0x00ad }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
            r0.<init>()     // Catch:{ all -> 0x00ad }
            java.lang.String r1 = "Unknown action: "
            r0.append(r1)     // Catch:{ all -> 0x00ad }
            r0.append(r4)     // Catch:{ all -> 0x00ad }
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x00ad }
            r5.error(r4)     // Catch:{ all -> 0x00ad }
            goto L_0x00ab
        L_0x00a0:
            com.amazonaws.services.s3.AmazonS3 r4 = r3.s3     // Catch:{ all -> 0x00ad }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferDBUtil r5 = r3.dbUtil     // Catch:{ all -> 0x00ad }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater r1 = r3.updater     // Catch:{ all -> 0x00ad }
            android.net.ConnectivityManager r2 = r3.connManager     // Catch:{ all -> 0x00ad }
            r0.start(r4, r5, r1, r2)     // Catch:{ all -> 0x00ad }
        L_0x00ab:
            monitor-exit(r3)
            return
        L_0x00ad:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility.submitTransferJob(java.lang.String, int):void");
    }

    private boolean shouldUploadInMultipart(File file) {
        return file != null && file.length() > 5242880;
    }

    static <X extends AmazonWebServiceRequest> X appendTransferServiceUserAgentString(X x) {
        RequestClientOptions requestClientOptions = x.getRequestClientOptions();
        requestClientOptions.appendUserAgent("TransferService/" + getUserAgentFromConfig() + VersionInfoUtils.getVersion());
        return x;
    }

    static <X extends AmazonWebServiceRequest> X appendMultipartTransferServiceUserAgentString(X x) {
        RequestClientOptions requestClientOptions = x.getRequestClientOptions();
        requestClientOptions.appendUserAgent("TransferService_multipart/" + getUserAgentFromConfig() + VersionInfoUtils.getVersion());
        return x;
    }

    /* access modifiers changed from: package-private */
    public TransferDBUtil getDbUtil() {
        return this.dbUtil;
    }
}
