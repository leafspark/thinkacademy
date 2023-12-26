package com.adyen.checkout.components;

import com.adyen.checkout.components.PaymentComponentState;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.model.payments.request.PaymentMethodDetails;

public interface PaymentComponent<ComponentStateT extends PaymentComponentState<? extends PaymentMethodDetails>, ConfigurationT extends Configuration> extends Component<ComponentStateT, ConfigurationT> {
    PaymentComponentState<? extends PaymentMethodDetails> getState();

    String[] getSupportedPaymentMethodTypes();

    boolean requiresInput();
}
