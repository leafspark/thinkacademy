package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

class TransferStatusUpdater {
    static final Map<Integer, List<TransferListener>> LISTENERS = new ConcurrentHashMap<Integer, List<TransferListener>>() {
    };
    /* access modifiers changed from: private */
    public static final Log LOGGER = LogFactory.getLog((Class<?>) TransferStatusUpdater.class);
    private static final HashSet<TransferState> STATES_NOT_TO_NOTIFY = new HashSet<>(Arrays.asList(new TransferState[]{TransferState.PART_COMPLETED, TransferState.PENDING_CANCEL, TransferState.PENDING_PAUSE, TransferState.PENDING_NETWORK_DISCONNECT}));
    static final String TEMP_FILE_PREFIX = "aws-s3-d861b25a-1edf-11eb-adc1-0242ac120002";
    private static TransferDBUtil dbUtil;
    private static TransferStatusUpdater transferStatusUpdater;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Map<Integer, TransferRecord> transfers = new ConcurrentHashMap();

    TransferStatusUpdater(TransferDBUtil transferDBUtil) {
        dbUtil = transferDBUtil;
    }

    public static synchronized TransferStatusUpdater getInstance(Context context) {
        TransferStatusUpdater transferStatusUpdater2;
        synchronized (TransferStatusUpdater.class) {
            if (transferStatusUpdater == null) {
                dbUtil = new TransferDBUtil(context);
                transferStatusUpdater = new TransferStatusUpdater(dbUtil);
            }
            transferStatusUpdater2 = transferStatusUpdater;
        }
        return transferStatusUpdater2;
    }

    /* access modifiers changed from: package-private */
    public synchronized Map<Integer, TransferRecord> getTransfers() {
        return Collections.unmodifiableMap(this.transfers);
    }

    /* access modifiers changed from: package-private */
    public synchronized void addTransfer(TransferRecord transferRecord) {
        this.transfers.put(Integer.valueOf(transferRecord.id), transferRecord);
    }

    /* access modifiers changed from: package-private */
    public synchronized TransferRecord getTransfer(int i) {
        return this.transfers.get(Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    public synchronized void removeTransfer(int i) {
        Map<Integer, List<TransferListener>> map = LISTENERS;
        synchronized (map) {
            map.remove(Integer.valueOf(i));
        }
        this.transfers.remove(Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    public synchronized void removeTransferRecordFromDB(int i) {
        TransferRecord transferById = dbUtil.getTransferById(i);
        if (transferById != null) {
            String str = transferById.file;
            if (new File(str).getName().startsWith(TEMP_FILE_PREFIX)) {
                new File(str).delete();
            }
        }
        S3ClientReference.remove(Integer.valueOf(i));
        dbUtil.deleteTransferRecords(i);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c2, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void updateState(final int r7, final com.amazonaws.mobileconnectors.s3.transferutility.TransferState r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.util.HashSet<com.amazonaws.mobileconnectors.s3.transferutility.TransferState> r0 = STATES_NOT_TO_NOTIFY     // Catch:{ all -> 0x00c9 }
            boolean r0 = r0.contains(r8)     // Catch:{ all -> 0x00c9 }
            java.util.Map<java.lang.Integer, com.amazonaws.mobileconnectors.s3.transferutility.TransferRecord> r1 = r6.transfers     // Catch:{ all -> 0x00c9 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x00c9 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x00c9 }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferRecord r1 = (com.amazonaws.mobileconnectors.s3.transferutility.TransferRecord) r1     // Catch:{ all -> 0x00c9 }
            if (r1 != 0) goto L_0x0034
            com.amazonaws.mobileconnectors.s3.transferutility.TransferDBUtil r1 = dbUtil     // Catch:{ all -> 0x00c9 }
            int r1 = r1.updateState(r7, r8)     // Catch:{ all -> 0x00c9 }
            if (r1 != 0) goto L_0x005b
            com.amazonaws.logging.Log r1 = LOGGER     // Catch:{ all -> 0x00c9 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c9 }
            r2.<init>()     // Catch:{ all -> 0x00c9 }
            java.lang.String r3 = "Failed to update the status of transfer "
            r2.append(r3)     // Catch:{ all -> 0x00c9 }
            r2.append(r7)     // Catch:{ all -> 0x00c9 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00c9 }
            r1.warn(r2)     // Catch:{ all -> 0x00c9 }
            goto L_0x005b
        L_0x0034:
            com.amazonaws.mobileconnectors.s3.transferutility.TransferState r2 = r1.state     // Catch:{ all -> 0x00c9 }
            boolean r2 = r8.equals(r2)     // Catch:{ all -> 0x00c9 }
            r0 = r0 | r2
            r1.state = r8     // Catch:{ all -> 0x00c9 }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferDBUtil r2 = dbUtil     // Catch:{ all -> 0x00c9 }
            int r1 = r2.updateTransferRecord(r1)     // Catch:{ all -> 0x00c9 }
            if (r1 != 0) goto L_0x005b
            com.amazonaws.logging.Log r1 = LOGGER     // Catch:{ all -> 0x00c9 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c9 }
            r2.<init>()     // Catch:{ all -> 0x00c9 }
            java.lang.String r3 = "Failed to update the status of transfer "
            r2.append(r3)     // Catch:{ all -> 0x00c9 }
            r2.append(r7)     // Catch:{ all -> 0x00c9 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00c9 }
            r1.warn(r2)     // Catch:{ all -> 0x00c9 }
        L_0x005b:
            if (r0 == 0) goto L_0x005f
            monitor-exit(r6)
            return
        L_0x005f:
            com.amazonaws.mobileconnectors.s3.transferutility.TransferState r0 = com.amazonaws.mobileconnectors.s3.transferutility.TransferState.COMPLETED     // Catch:{ all -> 0x00c9 }
            boolean r0 = r0.equals(r8)     // Catch:{ all -> 0x00c9 }
            if (r0 == 0) goto L_0x006a
            r6.removeTransferRecordFromDB(r7)     // Catch:{ all -> 0x00c9 }
        L_0x006a:
            java.util.Map<java.lang.Integer, java.util.List<com.amazonaws.mobileconnectors.s3.transferutility.TransferListener>> r0 = LISTENERS     // Catch:{ all -> 0x00c9 }
            monitor-enter(r0)     // Catch:{ all -> 0x00c9 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x00c6 }
            java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x00c6 }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x00c6 }
            if (r1 == 0) goto L_0x00c3
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x00c6 }
            if (r2 == 0) goto L_0x0080
            goto L_0x00c3
        L_0x0080:
            java.util.Iterator r2 = r1.iterator()     // Catch:{ all -> 0x00c6 }
        L_0x0084:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x00c6 }
            if (r3 == 0) goto L_0x00a5
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x00c6 }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferListener r3 = (com.amazonaws.mobileconnectors.s3.transferutility.TransferListener) r3     // Catch:{ all -> 0x00c6 }
            android.os.Handler r4 = r6.mainHandler     // Catch:{ all -> 0x00c6 }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater$2 r5 = new com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater$2     // Catch:{ all -> 0x00c6 }
            r5.<init>(r3, r7, r8)     // Catch:{ all -> 0x00c6 }
            boolean r3 = r4 instanceof android.os.Handler     // Catch:{ all -> 0x00c6 }
            if (r3 != 0) goto L_0x009f
            r4.post(r5)     // Catch:{ all -> 0x00c6 }
            goto L_0x0084
        L_0x009f:
            android.os.Handler r4 = (android.os.Handler) r4     // Catch:{ all -> 0x00c6 }
            com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation.handlerPost(r4, r5)     // Catch:{ all -> 0x00c6 }
            goto L_0x0084
        L_0x00a5:
            com.amazonaws.mobileconnectors.s3.transferutility.TransferState r7 = com.amazonaws.mobileconnectors.s3.transferutility.TransferState.COMPLETED     // Catch:{ all -> 0x00c6 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x00c6 }
            if (r7 != 0) goto L_0x00bd
            com.amazonaws.mobileconnectors.s3.transferutility.TransferState r7 = com.amazonaws.mobileconnectors.s3.transferutility.TransferState.FAILED     // Catch:{ all -> 0x00c6 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x00c6 }
            if (r7 != 0) goto L_0x00bd
            com.amazonaws.mobileconnectors.s3.transferutility.TransferState r7 = com.amazonaws.mobileconnectors.s3.transferutility.TransferState.CANCELED     // Catch:{ all -> 0x00c6 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x00c6 }
            if (r7 == 0) goto L_0x00c0
        L_0x00bd:
            r1.clear()     // Catch:{ all -> 0x00c6 }
        L_0x00c0:
            monitor-exit(r0)     // Catch:{ all -> 0x00c6 }
            monitor-exit(r6)
            return
        L_0x00c3:
            monitor-exit(r0)     // Catch:{ all -> 0x00c6 }
            monitor-exit(r6)
            return
        L_0x00c6:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c6 }
            throw r7     // Catch:{ all -> 0x00c9 }
        L_0x00c9:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.updateState(int, com.amazonaws.mobileconnectors.s3.transferutility.TransferState):void");
    }

    /* access modifiers changed from: package-private */
    public synchronized void updateProgress(int i, long j, long j2, boolean z) {
        long j3 = j;
        synchronized (this) {
            TransferRecord transferRecord = this.transfers.get(Integer.valueOf(i));
            if (transferRecord != null) {
                transferRecord.bytesCurrent = j3;
                transferRecord.bytesTotal = j2;
            } else {
                long j4 = j2;
            }
            dbUtil.updateBytesTransferred(i, j3);
            if (z) {
                Map<Integer, List<TransferListener>> map = LISTENERS;
                synchronized (map) {
                    List list = map.get(Integer.valueOf(i));
                    if (list != null) {
                        if (!list.isEmpty()) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                final TransferListener transferListener = (TransferListener) it.next();
                                final int i2 = i;
                                final long j5 = j;
                                Iterator it2 = it;
                                Handler handler = this.mainHandler;
                                AnonymousClass3 r10 = r1;
                                final long j6 = j2;
                                AnonymousClass3 r1 = new Runnable() {
                                    public void run() {
                                        transferListener.onProgressChanged(i2, j5, j6);
                                    }
                                };
                                if (!(handler instanceof Handler)) {
                                    handler.post(r10);
                                } else {
                                    AsynchronousInstrumentation.handlerPost(handler, r10);
                                }
                                long j7 = j;
                                it = it2;
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void throwError(final int r6, final java.lang.Exception r7) {
        /*
            r5 = this;
            java.util.Map<java.lang.Integer, java.util.List<com.amazonaws.mobileconnectors.s3.transferutility.TransferListener>> r0 = LISTENERS
            monitor-enter(r0)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x003f }
            java.lang.Object r1 = r0.get(r1)     // Catch:{ all -> 0x003f }
            java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
            boolean r2 = r1.isEmpty()     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x0016
            goto L_0x003d
        L_0x0016:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x003f }
        L_0x001a:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x003b
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x003f }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferListener r2 = (com.amazonaws.mobileconnectors.s3.transferutility.TransferListener) r2     // Catch:{ all -> 0x003f }
            android.os.Handler r3 = r5.mainHandler     // Catch:{ all -> 0x003f }
            com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater$4 r4 = new com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater$4     // Catch:{ all -> 0x003f }
            r4.<init>(r2, r6, r7)     // Catch:{ all -> 0x003f }
            boolean r2 = r3 instanceof android.os.Handler     // Catch:{ all -> 0x003f }
            if (r2 != 0) goto L_0x0035
            r3.post(r4)     // Catch:{ all -> 0x003f }
            goto L_0x001a
        L_0x0035:
            android.os.Handler r3 = (android.os.Handler) r3     // Catch:{ all -> 0x003f }
            com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation.handlerPost(r3, r4)     // Catch:{ all -> 0x003f }
            goto L_0x001a
        L_0x003b:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.throwError(int, java.lang.Exception):void");
    }

    /* access modifiers changed from: package-private */
    public synchronized void clear() {
        Map<Integer, List<TransferListener>> map = LISTENERS;
        synchronized (map) {
            map.clear();
        }
        this.transfers.clear();
    }

    static void registerListener(int i, TransferListener transferListener) {
        if (transferListener != null) {
            Map<Integer, List<TransferListener>> map = LISTENERS;
            synchronized (map) {
                List list = map.get(Integer.valueOf(i));
                if (list == null) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    copyOnWriteArrayList.add(transferListener);
                    map.put(Integer.valueOf(i), copyOnWriteArrayList);
                } else if (!list.contains(transferListener)) {
                    list.add(transferListener);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Listener can't be null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void unregisterListener(int r2, com.amazonaws.mobileconnectors.s3.transferutility.TransferListener r3) {
        /*
            if (r3 == 0) goto L_0x0022
            java.util.Map<java.lang.Integer, java.util.List<com.amazonaws.mobileconnectors.s3.transferutility.TransferListener>> r0 = LISTENERS
            monitor-enter(r0)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x001f }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001f }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x001f }
            if (r2 == 0) goto L_0x001d
            boolean r1 = r2.isEmpty()     // Catch:{ all -> 0x001f }
            if (r1 == 0) goto L_0x0018
            goto L_0x001d
        L_0x0018:
            r2.remove(r3)     // Catch:{ all -> 0x001f }
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r2 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            throw r2
        L_0x0022:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Listener can't be null"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.unregisterListener(int, com.amazonaws.mobileconnectors.s3.transferutility.TransferListener):void");
    }

    private class TransferProgressListener implements ProgressListener {
        private long bytesTransferredSoFar;
        private final TransferRecord transfer;

        public TransferProgressListener(TransferRecord transferRecord) {
            this.transfer = transferRecord;
        }

        public synchronized void progressChanged(ProgressEvent progressEvent) {
            if (32 == progressEvent.getEventCode()) {
                TransferStatusUpdater.LOGGER.info("Reset Event triggered. Resetting the bytesCurrent to 0.");
                this.bytesTransferredSoFar = 0;
            } else {
                long bytesTransferred = this.bytesTransferredSoFar + progressEvent.getBytesTransferred();
                this.bytesTransferredSoFar = bytesTransferred;
                if (bytesTransferred > this.transfer.bytesCurrent) {
                    this.transfer.bytesCurrent = this.bytesTransferredSoFar;
                    TransferStatusUpdater.this.updateProgress(this.transfer.id, this.transfer.bytesCurrent, this.transfer.bytesTotal, true);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized ProgressListener newProgressListener(int i) {
        TransferRecord transfer;
        transfer = getTransfer(i);
        if (transfer != null) {
            Log log = LOGGER;
            log.info("Creating a new progress listener for transfer: " + i);
        } else {
            Log log2 = LOGGER;
            log2.info("TransferStatusUpdater doesn't track the transfer: " + i);
            throw new IllegalArgumentException("transfer " + i + " doesn't exist");
        }
        return new TransferProgressListener(transfer);
    }
}
