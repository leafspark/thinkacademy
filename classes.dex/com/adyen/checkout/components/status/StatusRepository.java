package com.adyen.checkout.components.status;

import android.os.Handler;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.adyen.checkout.components.status.api.StatusApi;
import com.adyen.checkout.components.status.api.StatusConnectionTask;
import com.adyen.checkout.components.status.api.StatusResponseUtils;
import com.adyen.checkout.components.status.model.StatusResponse;
import com.adyen.checkout.core.api.Environment;
import com.adyen.checkout.core.exception.ApiCallException;
import com.adyen.checkout.core.exception.ComponentException;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.util.concurrent.TimeUnit;

public final class StatusRepository {
    private static final long POLLING_DELAY_FAST = TimeUnit.SECONDS.toMillis(2);
    private static final long POLLING_DELAY_SLOW = TimeUnit.SECONDS.toMillis(10);
    private static final long POLLING_MAX_COUNT = TimeUnit.MINUTES.toMillis(15);
    private static final long POLLING_THRESHOLD = TimeUnit.SECONDS.toMillis(60);
    static final String TAG = LogUtil.getTag();
    private static StatusRepository sInstance;
    String mClientKey;
    final Handler mHandler = new Handler();
    Boolean mIsPolling = false;
    String mPaymentData;
    long mPollingDelay;
    private long mPollingStartTime;
    final StatusApi mStatusApi;
    final StatusConnectionTask.StatusCallback mStatusCallback = new StatusConnectionTask.StatusCallback() {
        public void onSuccess(StatusResponse statusResponse) {
            String str = StatusRepository.TAG;
            Logger.d(str, "onSuccess - " + statusResponse.getResultCode());
            StatusRepository.this.mStatusResponseLiveData.postValue(statusResponse);
            if (StatusResponseUtils.isFinalResult(statusResponse)) {
                StatusRepository.this.stopPolling();
            }
        }

        public void onFailed(ApiCallException apiCallException) {
            Logger.e(StatusRepository.TAG, "onFailed");
        }
    };
    private final MutableLiveData<ComponentException> mStatusErrorLiveData = new MutableLiveData<>();
    final Runnable mStatusPollingRunnable = new Runnable() {
        public void run() {
            Logger.d(StatusRepository.TAG, "mStatusPollingRunnable.run()");
            StatusRepository.this.mStatusApi.callStatus(StatusRepository.this.mClientKey, StatusRepository.this.mPaymentData, StatusRepository.this.mStatusCallback);
            StatusRepository.this.updatePollingDelay();
            StatusRepository.this.mHandler.postDelayed(StatusRepository.this.mStatusPollingRunnable, StatusRepository.this.mPollingDelay);
        }
    };
    final MutableLiveData<StatusResponse> mStatusResponseLiveData = new MutableLiveData<>();

    public static StatusRepository getInstance(Environment environment) {
        synchronized (StatusRepository.class) {
            if (sInstance == null) {
                sInstance = new StatusRepository(environment);
            }
        }
        return sInstance;
    }

    private StatusRepository(Environment environment) {
        this.mStatusApi = StatusApi.getInstance(environment);
    }

    public LiveData<StatusResponse> getStatusResponseLiveData() {
        return this.mStatusResponseLiveData;
    }

    public LiveData<ComponentException> getErrorLiveData() {
        return this.mStatusErrorLiveData;
    }

    public void startPolling(String str, String str2) {
        String str3 = TAG;
        Logger.d(str3, "startPolling");
        if (!this.mIsPolling.booleanValue() || !str.equals(this.mClientKey) || !str2.equals(this.mPaymentData)) {
            stopPolling();
            this.mIsPolling = true;
            this.mClientKey = str;
            this.mPaymentData = str2;
            this.mPollingStartTime = System.currentTimeMillis();
            Handler handler = this.mHandler;
            Runnable runnable = this.mStatusPollingRunnable;
            if (!(handler instanceof Handler)) {
                handler.post(runnable);
            } else {
                AsynchronousInstrumentation.handlerPost(handler, runnable);
            }
        } else {
            Logger.e(str3, "Already polling for this payment.");
        }
    }

    public void updateStatus() {
        String str = TAG;
        Logger.d(str, "updateStatus");
        if (!this.mIsPolling.booleanValue()) {
            Logger.d(str, "No polling in progress");
            return;
        }
        this.mHandler.removeCallbacks(this.mStatusPollingRunnable);
        Handler handler = this.mHandler;
        Runnable runnable = this.mStatusPollingRunnable;
        if (!(handler instanceof Handler)) {
            handler.post(runnable);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, runnable);
        }
    }

    public void stopPolling() {
        String str = TAG;
        Logger.d(str, "stopPolling");
        if (!this.mIsPolling.booleanValue()) {
            Logger.w(str, "Stop called with no polling in progress, stopping anyway");
        }
        this.mIsPolling = false;
        this.mHandler.removeCallbacksAndMessages((Object) null);
        this.mStatusResponseLiveData.setValue(null);
        this.mStatusErrorLiveData.setValue(null);
    }

    /* access modifiers changed from: package-private */
    public void updatePollingDelay() {
        long currentTimeMillis = System.currentTimeMillis() - this.mPollingStartTime;
        if (currentTimeMillis <= POLLING_THRESHOLD) {
            this.mPollingDelay = POLLING_DELAY_FAST;
        } else if (currentTimeMillis <= POLLING_MAX_COUNT) {
            this.mPollingDelay = POLLING_DELAY_SLOW;
        } else {
            this.mStatusErrorLiveData.setValue(new ComponentException("Status requesting timed out with no result"));
        }
    }

    public long getMaxPollingDurationMillis() {
        return POLLING_MAX_COUNT;
    }
}
