package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.AmazonS3;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import java.util.ArrayList;

public class TransferNetworkLossHandler extends BroadcastReceiver {
    private static final Log LOGGER = LogFactory.getLog((Class<?>) TransferNetworkLossHandler.class);
    private static TransferNetworkLossHandler transferNetworkLossHandler;
    final ConnectivityManager connManager;
    private TransferDBUtil dbUtil;
    TransferStatusUpdater updater;

    private TransferNetworkLossHandler(Context context) {
        this.connManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.dbUtil = new TransferDBUtil(context);
        this.updater = TransferStatusUpdater.getInstance(context);
    }

    public static synchronized TransferNetworkLossHandler getInstance(Context context) {
        TransferNetworkLossHandler transferNetworkLossHandler2;
        synchronized (TransferNetworkLossHandler.class) {
            if (transferNetworkLossHandler == null) {
                transferNetworkLossHandler = new TransferNetworkLossHandler(context);
            }
            transferNetworkLossHandler2 = transferNetworkLossHandler;
        }
        return transferNetworkLossHandler2;
    }

    public static synchronized TransferNetworkLossHandler getInstance() throws TransferUtilityException {
        TransferNetworkLossHandler transferNetworkLossHandler2;
        synchronized (TransferNetworkLossHandler.class) {
            transferNetworkLossHandler2 = transferNetworkLossHandler;
            if (transferNetworkLossHandler2 == null) {
                LOGGER.error("TransferNetworkLossHandler is not created. Please call `TransferNetworkLossHandler.getInstance(Context)` to instantiate it before retrieving");
                throw new TransferUtilityException("TransferNetworkLossHandler is not created. Please call `TransferNetworkLossHandler.getInstance(Context)` to instantiate it before retrieving");
            }
        }
        return transferNetworkLossHandler2;
    }

    public void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            Log log = LOGGER;
            log.info("Network connectivity changed detected.");
            boolean isNetworkConnected = isNetworkConnected();
            log.info("Network connected: " + isNetworkConnected);
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    if (TransferNetworkLossHandler.this.isNetworkConnected()) {
                        TransferNetworkLossHandler.this.resumeAllTransfersOnNetworkAvailability();
                    } else {
                        TransferNetworkLossHandler.this.pauseAllTransfersDueToNetworkInterruption();
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isNetworkConnected() {
        NetworkInfo activeNetworkInfo = this.connManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* access modifiers changed from: private */
    public synchronized void resumeAllTransfersOnNetworkAvailability() {
        TransferRecord transfer;
        int i = 0;
        TransferState[] transferStateArr = {TransferState.WAITING_FOR_NETWORK};
        LOGGER.debug("Loading transfers from database...");
        Cursor cursor = null;
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            Cursor queryTransfersWithTypeAndStates = this.dbUtil.queryTransfersWithTypeAndStates(TransferType.ANY, transferStateArr);
            while (queryTransfersWithTypeAndStates.moveToNext()) {
                int i2 = queryTransfersWithTypeAndStates.getInt(queryTransfersWithTypeAndStates.getColumnIndexOrThrow(TransferTable.COLUMN_ID));
                if (this.updater.getTransfer(i2) == null) {
                    TransferRecord transferRecord = new TransferRecord(i2);
                    transferRecord.updateFromDB(queryTransfersWithTypeAndStates);
                    this.updater.addTransfer(transferRecord);
                    i++;
                }
                arrayList.add(Integer.valueOf(i2));
            }
            if (queryTransfersWithTypeAndStates != null) {
                LOGGER.debug("Closing the cursor for resumeAllTransfers");
                queryTransfersWithTypeAndStates.close();
            }
            for (Integer num : arrayList) {
                AmazonS3 amazonS3 = S3ClientReference.get(num);
                if (!(amazonS3 == null || (transfer = this.updater.getTransfer(num.intValue())) == null || transfer.isRunning())) {
                    transfer.start(amazonS3, this.dbUtil, this.updater, this.connManager);
                }
            }
        } catch (Exception e) {
            Log log = LOGGER;
            log.error("Error in resuming the transfers." + e.getMessage());
        } catch (Throwable th) {
            if (cursor != null) {
                LOGGER.debug("Closing the cursor for resumeAllTransfers");
                cursor.close();
            }
            throw th;
        }
        Log log2 = LOGGER;
        log2.debug(i + " transfers are loaded from database.");
    }

    /* access modifiers changed from: private */
    public synchronized void pauseAllTransfersDueToNetworkInterruption() {
        for (TransferRecord next : this.updater.getTransfers().values()) {
            AmazonS3 amazonS3 = S3ClientReference.get(Integer.valueOf(next.id));
            if (!(amazonS3 == null || next == null || !next.pauseIfRequiredForNetworkInterruption(amazonS3, this.updater, this.connManager))) {
                this.updater.updateState(next.id, TransferState.WAITING_FOR_NETWORK);
            }
        }
    }
}
