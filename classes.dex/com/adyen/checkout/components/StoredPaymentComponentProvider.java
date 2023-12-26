package com.adyen.checkout.components;

import android.os.Bundle;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.adyen.checkout.components.PaymentComponent;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.model.paymentmethods.StoredPaymentMethod;
import com.adyen.checkout.core.exception.CheckoutException;

public interface StoredPaymentComponentProvider<ComponentT extends PaymentComponent, ConfigurationT extends Configuration> extends PaymentComponentProvider<ComponentT, ConfigurationT> {
    ComponentT get(SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner, StoredPaymentMethod storedPaymentMethod, ConfigurationT configurationt, Bundle bundle) throws CheckoutException;

    <T extends SavedStateRegistryOwner & ViewModelStoreOwner> ComponentT get(T t, StoredPaymentMethod storedPaymentMethod, ConfigurationT configurationt) throws CheckoutException;
}
