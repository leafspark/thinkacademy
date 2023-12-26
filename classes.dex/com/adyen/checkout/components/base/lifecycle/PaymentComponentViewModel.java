package com.adyen.checkout.components.base.lifecycle;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.adyen.checkout.components.PaymentComponent;
import com.adyen.checkout.components.PaymentComponentState;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.base.PaymentMethodDelegate;
import com.adyen.checkout.components.model.payments.request.PaymentMethodDetails;

public abstract class PaymentComponentViewModel<ConfigurationT extends Configuration, ComponentStateT extends PaymentComponentState<? extends PaymentMethodDetails>> extends ViewModel implements PaymentComponent<ComponentStateT, ConfigurationT> {
    protected final ConfigurationT mConfiguration;
    protected final PaymentMethodDelegate mPaymentMethodDelegate;
    private final SavedStateHandle mSavedStateHandle;

    public PaymentComponentViewModel(SavedStateHandle savedStateHandle, PaymentMethodDelegate paymentMethodDelegate, ConfigurationT configurationt) {
        this.mPaymentMethodDelegate = paymentMethodDelegate;
        this.mConfiguration = configurationt;
        this.mSavedStateHandle = savedStateHandle;
    }

    public ConfigurationT getConfiguration() {
        return this.mConfiguration;
    }

    public SavedStateHandle getSavedStateHandle() {
        return this.mSavedStateHandle;
    }
}
