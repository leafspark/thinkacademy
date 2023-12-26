package com.adyen.checkout.components;

import com.adyen.checkout.components.model.payments.request.PaymentComponentData;
import com.adyen.checkout.components.model.payments.request.PaymentMethodDetails;

public class GenericComponentState<PaymentMethodDetailsT extends PaymentMethodDetails> extends PaymentComponentState<PaymentMethodDetailsT> {
    public GenericComponentState(PaymentComponentData<PaymentMethodDetailsT> paymentComponentData, boolean z, boolean z2) {
        super(paymentComponentData, z, z2);
    }
}
