package com.adyen.checkout.components;

import android.os.Bundle;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.adyen.checkout.components.PaymentComponent;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.model.paymentmethods.PaymentMethod;
import com.adyen.checkout.core.exception.CheckoutException;

public interface PaymentComponentProvider<ComponentT extends PaymentComponent, ConfigurationT extends Configuration> extends ComponentProvider<ComponentT> {
    ComponentT get(SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner, PaymentMethod paymentMethod, ConfigurationT configurationt, Bundle bundle) throws CheckoutException;

    <T extends SavedStateRegistryOwner & ViewModelStoreOwner> ComponentT get(T t, PaymentMethod paymentMethod, ConfigurationT configurationt) throws CheckoutException;
}
