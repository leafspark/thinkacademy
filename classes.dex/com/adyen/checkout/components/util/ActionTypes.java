package com.adyen.checkout.components.util;

import com.adyen.checkout.core.exception.NoConstructorException;

public final class ActionTypes {
    public static final String AWAIT = "await";
    public static final String QR_CODE = "qrCode";
    public static final String REDIRECT = "redirect";
    public static final String SDK = "sdk";
    public static final String THREEDS2 = "threeDS2";
    public static final String THREEDS2_CHALLENGE = "threeDS2Challenge";
    public static final String THREEDS2_FINGERPRINT = "threeDS2Fingerprint";
    public static final String VOUCHER = "voucher";

    private ActionTypes() {
        throw new NoConstructorException();
    }
}
