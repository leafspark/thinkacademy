package com.adyen.checkout.components;

import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.model.paymentmethods.PaymentMethod;

public interface ComponentAvailableCallback<ConfigurationT extends Configuration> {
    void onAvailabilityResult(boolean z, PaymentMethod paymentMethod, ConfigurationT configurationt);
}
