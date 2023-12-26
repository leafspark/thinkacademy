package com.adyen.checkout.components.status.api;

import com.adyen.checkout.components.status.model.StatusResponse;
import com.adyen.checkout.core.exception.NoConstructorException;

public final class StatusResponseUtils {
    public static final String RESULT_AUTHORIZED = "authorised";
    public static final String RESULT_CANCELED = "canceled";
    public static final String RESULT_ERROR = "error";
    public static final String RESULT_PENDING = "pending";
    public static final String RESULT_REFUSED = "refused";

    public static boolean isFinalResult(StatusResponse statusResponse) {
        return !RESULT_PENDING.equals(statusResponse.getResultCode());
    }

    private StatusResponseUtils() {
        throw new NoConstructorException();
    }
}
