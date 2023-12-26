package com.adyen.checkout.components.status.api;

import android.os.Handler;
import com.adyen.checkout.components.status.model.StatusRequest;
import com.adyen.checkout.components.status.model.StatusResponse;
import com.adyen.checkout.core.api.ConnectionTask;
import com.adyen.checkout.core.api.ThreadManager;
import com.adyen.checkout.core.exception.ApiCallException;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class StatusConnectionTask extends ConnectionTask<StatusResponse> {
    private static final int SAFETY_TIMEOUT = 100;
    private static final String TAG = LogUtil.getTag();
    StatusCallback mCallback;
    private final StatusApi mStatusApi;

    public interface StatusCallback {
        void onFailed(ApiCallException apiCallException);

        void onSuccess(StatusResponse statusResponse);
    }

    StatusConnectionTask(StatusApi statusApi, String str, StatusRequest statusRequest, StatusCallback statusCallback) {
        super(new StatusConnection(str, statusRequest));
        this.mStatusApi = statusApi;
        this.mCallback = statusCallback;
    }

    /* access modifiers changed from: protected */
    public void done() {
        String str = TAG;
        Logger.v(str, "done");
        if (isCancelled()) {
            Logger.d(str, StatusResponseUtils.RESULT_CANCELED);
            notifyFailed(new ApiCallException("Execution canceled."));
            return;
        }
        try {
            notifySuccess((StatusResponse) get(100, TimeUnit.MILLISECONDS));
        } catch (ExecutionException e) {
            Logger.e(TAG, "Execution failed.", e);
            notifyFailed(new ApiCallException("Execution failed.", e));
        } catch (InterruptedException e2) {
            Logger.e(TAG, "Execution interrupted.", e2);
            notifyFailed(new ApiCallException("Execution interrupted.", e2));
        } catch (TimeoutException e3) {
            Logger.e(TAG, "Execution timed out.", e3);
            notifyFailed(new ApiCallException("Execution timed out.", e3));
        }
    }

    /* access modifiers changed from: package-private */
    public StatusApi getApi() {
        return this.mStatusApi;
    }

    private void notifySuccess(final StatusResponse statusResponse) {
        Handler handler = ThreadManager.MAIN_HANDLER;
        AnonymousClass1 r1 = new Runnable() {
            public void run() {
                StatusConnectionTask.this.getApi().taskFinished();
                StatusConnectionTask.this.mCallback.onSuccess(statusResponse);
                StatusConnectionTask.this.mCallback = null;
            }
        };
        if (!(handler instanceof Handler)) {
            handler.post(r1);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, r1);
        }
    }

    private void notifyFailed(final ApiCallException apiCallException) {
        Handler handler = ThreadManager.MAIN_HANDLER;
        AnonymousClass2 r1 = new Runnable() {
            public void run() {
                StatusConnectionTask.this.getApi().taskFinished();
                StatusConnectionTask.this.mCallback.onFailed(apiCallException);
                StatusConnectionTask.this.mCallback = null;
            }
        };
        if (!(handler instanceof Handler)) {
            handler.post(r1);
        } else {
            AsynchronousInstrumentation.handlerPost(handler, r1);
        }
    }
}
