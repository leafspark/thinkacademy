package com.adyen.checkout.components;

import com.adyen.checkout.components.model.payments.request.PaymentComponentData;
import com.adyen.checkout.components.model.payments.request.PaymentMethodDetails;

public abstract class PaymentComponentState<PaymentMethodDetailsT extends PaymentMethodDetails> {
    private final boolean mIsInputValid;
    private final boolean mIsReady;
    private final PaymentComponentData<PaymentMethodDetailsT> mPaymentComponentData;

    public PaymentComponentState(PaymentComponentData<PaymentMethodDetailsT> paymentComponentData, boolean z, boolean z2) {
        this.mPaymentComponentData = paymentComponentData;
        this.mIsInputValid = z;
        this.mIsReady = z2;
    }

    public PaymentComponentData<PaymentMethodDetailsT> getData() {
        return this.mPaymentComponentData;
    }

    public boolean isValid() {
        return this.mIsInputValid && this.mIsReady;
    }

    public boolean isInputValid() {
        return this.mIsInputValid;
    }

    public boolean isReady() {
        return this.mIsReady;
    }
}
