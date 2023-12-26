package com.adyen.checkout.components;

import android.app.Application;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.model.paymentmethods.PaymentMethod;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J5\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00018\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fH&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/adyen/checkout/components/PaymentMethodAvailabilityCheck;", "ConfigurationT", "Lcom/adyen/checkout/components/base/Configuration;", "", "isAvailable", "", "applicationContext", "Landroid/app/Application;", "paymentMethod", "Lcom/adyen/checkout/components/model/paymentmethods/PaymentMethod;", "configuration", "callback", "Lcom/adyen/checkout/components/ComponentAvailableCallback;", "(Landroid/app/Application;Lcom/adyen/checkout/components/model/paymentmethods/PaymentMethod;Lcom/adyen/checkout/components/base/Configuration;Lcom/adyen/checkout/components/ComponentAvailableCallback;)V", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: PaymentMethodAvailabilityCheck.kt */
public interface PaymentMethodAvailabilityCheck<ConfigurationT extends Configuration> {
    void isAvailable(Application application, PaymentMethod paymentMethod, ConfigurationT configurationt, ComponentAvailableCallback<ConfigurationT> componentAvailableCallback);
}
