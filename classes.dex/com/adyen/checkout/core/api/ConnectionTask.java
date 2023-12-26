package com.adyen.checkout.core.api;

import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class ConnectionTask<T> extends FutureTask<T> {
    private static final String TAG = LogUtil.getTag();
    private final long mTimeOut;

    protected ConnectionTask(Connection<T> connection) {
        this(connection, 0);
    }

    protected ConnectionTask(Connection<T> connection, long j) {
        super(connection);
        this.mTimeOut = j;
    }

    public boolean cancel(boolean z) {
        String str = TAG;
        Logger.d(str, "cancel - " + z);
        return super.cancel(z);
    }

    public void run() {
        if (this.mTimeOut > 0) {
            String str = TAG;
            Logger.d(str, "run with timeout - " + this.mTimeOut);
        }
        super.run();
        long j = this.mTimeOut;
        if (j > 0) {
            try {
                get(j, TimeUnit.MILLISECONDS);
            } catch (ExecutionException e) {
                Logger.d(TAG, "ExecutionException", e);
            } catch (InterruptedException e2) {
                Logger.d(TAG, "InterruptedException", e2);
            } catch (TimeoutException unused) {
                String str2 = TAG;
                Logger.e(str2, "Task timed out after " + this.mTimeOut + " milliseconds.");
                cancel(true);
            }
        }
    }
}
