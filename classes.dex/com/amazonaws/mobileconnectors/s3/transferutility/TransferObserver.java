package com.amazonaws.mobileconnectors.s3.transferutility;

import android.database.Cursor;
import java.io.File;

public class TransferObserver {
    private String bucket;
    /* access modifiers changed from: private */
    public long bytesTotal;
    /* access modifiers changed from: private */
    public long bytesTransferred;
    private final TransferDBUtil dbUtil;
    private String filePath;
    private final int id;
    private String key;
    private TransferStatusListener statusListener;
    private TransferListener transferListener;
    /* access modifiers changed from: private */
    public TransferState transferState;

    TransferObserver(int i, TransferDBUtil transferDBUtil, String str, String str2, File file) {
        this.id = i;
        this.dbUtil = transferDBUtil;
        this.bucket = str;
        this.key = str2;
        this.filePath = file.getAbsolutePath();
        this.bytesTotal = file.length();
        this.transferState = TransferState.WAITING;
    }

    TransferObserver(int i, TransferDBUtil transferDBUtil, String str, String str2, File file, TransferListener transferListener2) {
        this(i, transferDBUtil, str, str2, file);
        setTransferListener(transferListener2);
    }

    TransferObserver(int i, TransferDBUtil transferDBUtil) {
        this.id = i;
        this.dbUtil = transferDBUtil;
    }

    public void refresh() {
        Cursor cursor = null;
        try {
            cursor = this.dbUtil.queryTransferById(this.id);
            if (cursor.moveToFirst()) {
                updateFromDB(cursor);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void updateFromDB(Cursor cursor) {
        this.bucket = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_BUCKET_NAME));
        this.key = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_KEY));
        this.bytesTotal = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_BYTES_TOTAL));
        this.bytesTransferred = cursor.getLong(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_BYTES_CURRENT));
        this.transferState = TransferState.getState(cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_STATE)));
        this.filePath = cursor.getString(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_FILE));
    }

    public void setTransferListener(TransferListener transferListener2) {
        if (transferListener2 != null) {
            synchronized (this) {
                cleanTransferListener();
                TransferStatusListener transferStatusListener = new TransferStatusListener();
                this.statusListener = transferStatusListener;
                TransferStatusUpdater.registerListener(this.id, transferStatusListener);
                this.transferListener = transferListener2;
                TransferStatusUpdater.registerListener(this.id, transferListener2);
            }
        }
    }

    public int getId() {
        return this.id;
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getKey() {
        return this.key;
    }

    public long getBytesTotal() {
        return this.bytesTotal;
    }

    public String getAbsoluteFilePath() {
        return this.filePath;
    }

    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public TransferState getState() {
        return this.transferState;
    }

    public void cleanTransferListener() {
        synchronized (this) {
            TransferListener transferListener2 = this.transferListener;
            if (transferListener2 != null) {
                TransferStatusUpdater.unregisterListener(this.id, transferListener2);
                this.transferListener = null;
            }
            TransferStatusListener transferStatusListener = this.statusListener;
            if (transferStatusListener != null) {
                TransferStatusUpdater.unregisterListener(this.id, transferStatusListener);
                this.statusListener = null;
            }
        }
    }

    private class TransferStatusListener implements TransferListener {
        public void onError(int i, Exception exc) {
        }

        private TransferStatusListener() {
        }

        public void onStateChanged(int i, TransferState transferState) {
            TransferState unused = TransferObserver.this.transferState = transferState;
        }

        public void onProgressChanged(int i, long j, long j2) {
            long unused = TransferObserver.this.bytesTransferred = j;
            long unused2 = TransferObserver.this.bytesTotal = j2;
        }
    }

    public String toString() {
        return "TransferObserver{id=" + this.id + ", bucket='" + this.bucket + '\'' + ", key='" + this.key + '\'' + ", bytesTotal=" + this.bytesTotal + ", bytesTransferred=" + this.bytesTransferred + ", transferState=" + this.transferState + ", filePath='" + this.filePath + '\'' + '}';
    }
}
