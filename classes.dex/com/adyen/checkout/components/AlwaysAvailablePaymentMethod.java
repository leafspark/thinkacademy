package com.adyen.checkout.components;

import android.app.Application;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.model.paymentmethods.PaymentMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/adyen/checkout/components/AlwaysAvailablePaymentMethod;", "Lcom/adyen/checkout/components/PaymentMethodAvailabilityCheck;", "Lcom/adyen/checkout/components/base/Configuration;", "()V", "isAvailable", "", "applicationContext", "Landroid/app/Application;", "paymentMethod", "Lcom/adyen/checkout/components/model/paymentmethods/PaymentMethod;", "configuration", "callback", "Lcom/adyen/checkout/components/ComponentAvailableCallback;", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AlwaysAvailablePaymentMethod.kt */
public final class AlwaysAvailablePaymentMethod implements PaymentMethodAvailabilityCheck<Configuration> {
    public void isAvailable(Application application, PaymentMethod paymentMethod, Configuration configuration, ComponentAvailableCallback<Configuration> componentAvailableCallback) {
        Intrinsics.checkNotNullParameter(application, "applicationContext");
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        Intrinsics.checkNotNullParameter(componentAvailableCallback, "callback");
        componentAvailableCallback.onAvailabilityResult(true, paymentMethod, configuration);
    }
}
