package com.adyen.checkout.components.status.api;

import com.adyen.checkout.components.status.api.StatusConnectionTask;
import com.adyen.checkout.components.status.model.StatusRequest;
import com.adyen.checkout.core.api.Environment;
import com.adyen.checkout.core.api.ThreadManager;
import com.adyen.checkout.core.exception.ApiCallException;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;

public final class StatusApi {
    private static final String STATUS_PATH = "services/PaymentInitiation/v1/status?token=%1$s";
    private static final String TAG = LogUtil.getTag();
    private static StatusApi sInstance;
    private StatusConnectionTask mCurrentTask;
    private final String mStatusUrlFormat;

    public static StatusApi getInstance(Environment environment) {
        StatusApi statusApi;
        String baseUrl = environment.getBaseUrl();
        synchronized (StatusApi.class) {
            StatusApi statusApi2 = sInstance;
            if (statusApi2 == null || isDifferentHost(statusApi2, baseUrl)) {
                sInstance = new StatusApi(baseUrl);
            }
            statusApi = sInstance;
        }
        return statusApi;
    }

    private static boolean isDifferentHost(StatusApi statusApi, String str) {
        return !statusApi.mStatusUrlFormat.startsWith(str);
    }

    private StatusApi(String str) {
        String str2 = TAG;
        Logger.v(str2, "Environment URL - " + str);
        this.mStatusUrlFormat = str + STATUS_PATH;
    }

    /* access modifiers changed from: package-private */
    public void taskFinished() {
        synchronized (this) {
            this.mCurrentTask = null;
        }
    }

    public void callStatus(String str, String str2, StatusConnectionTask.StatusCallback statusCallback) {
        String str3 = TAG;
        Logger.v(str3, "getStatus");
        String format = String.format(this.mStatusUrlFormat, new Object[]{str});
        synchronized (this) {
            if (this.mCurrentTask != null) {
                Logger.e(str3, "Status already pending.");
                statusCallback.onFailed(new ApiCallException("Other Status call already pending."));
            }
            StatusRequest statusRequest = new StatusRequest();
            statusRequest.setPaymentData(str2);
            this.mCurrentTask = new StatusConnectionTask(this, format, statusRequest, statusCallback);
            ThreadManager.EXECUTOR.submit(this.mCurrentTask);
        }
    }
}
