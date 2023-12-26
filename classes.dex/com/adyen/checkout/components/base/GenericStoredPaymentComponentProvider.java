package com.adyen.checkout.components.base;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.adyen.checkout.components.StoredPaymentComponentProvider;
import com.adyen.checkout.components.base.BasePaymentComponent;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.model.paymentmethods.PaymentMethod;
import com.adyen.checkout.components.model.paymentmethods.StoredPaymentMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0018\b\u0000\u0010\u0001*\u0012\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0013\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ4\u0010\t\u001a\u00028\u0000\"\f\b\u0002\u0010\n*\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u0002H\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u0011J4\u0010\t\u001a\u00028\u0000\"\f\b\u0002\u0010\n*\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u0002H\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u0014J8\u0010\t\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010\u0019J8\u0010\t\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00028\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010\u001aR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/adyen/checkout/components/base/GenericStoredPaymentComponentProvider;", "BaseComponentT", "Lcom/adyen/checkout/components/base/BasePaymentComponent;", "ConfigurationT", "Lcom/adyen/checkout/components/base/Configuration;", "Lcom/adyen/checkout/components/StoredPaymentComponentProvider;", "componentClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "get", "T", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/savedstate/SavedStateRegistryOwner;", "owner", "paymentMethod", "Lcom/adyen/checkout/components/model/paymentmethods/PaymentMethod;", "configuration", "(Landroidx/lifecycle/ViewModelStoreOwner;Lcom/adyen/checkout/components/model/paymentmethods/PaymentMethod;Lcom/adyen/checkout/components/base/Configuration;)Lcom/adyen/checkout/components/base/BasePaymentComponent;", "storedPaymentMethod", "Lcom/adyen/checkout/components/model/paymentmethods/StoredPaymentMethod;", "(Landroidx/lifecycle/ViewModelStoreOwner;Lcom/adyen/checkout/components/model/paymentmethods/StoredPaymentMethod;Lcom/adyen/checkout/components/base/Configuration;)Lcom/adyen/checkout/components/base/BasePaymentComponent;", "savedStateRegistryOwner", "viewModelStoreOwner", "defaultArgs", "Landroid/os/Bundle;", "(Landroidx/savedstate/SavedStateRegistryOwner;Landroidx/lifecycle/ViewModelStoreOwner;Lcom/adyen/checkout/components/model/paymentmethods/PaymentMethod;Lcom/adyen/checkout/components/base/Configuration;Landroid/os/Bundle;)Lcom/adyen/checkout/components/base/BasePaymentComponent;", "(Landroidx/savedstate/SavedStateRegistryOwner;Landroidx/lifecycle/ViewModelStoreOwner;Lcom/adyen/checkout/components/model/paymentmethods/StoredPaymentMethod;Lcom/adyen/checkout/components/base/Configuration;Landroid/os/Bundle;)Lcom/adyen/checkout/components/base/BasePaymentComponent;", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GenericStoredPaymentComponentProvider.kt */
public final class GenericStoredPaymentComponentProvider<BaseComponentT extends BasePaymentComponent<?, ?, ?, ?>, ConfigurationT extends Configuration> implements StoredPaymentComponentProvider<BaseComponentT, ConfigurationT> {
    /* access modifiers changed from: private */
    public final Class<BaseComponentT> componentClass;

    public GenericStoredPaymentComponentProvider(Class<BaseComponentT> cls) {
        Intrinsics.checkNotNullParameter(cls, "componentClass");
        this.componentClass = cls;
    }

    public <T extends ViewModelStoreOwner & SavedStateRegistryOwner> BaseComponentT get(T t, StoredPaymentMethod storedPaymentMethod, ConfigurationT configurationt) {
        Intrinsics.checkNotNullParameter(t, "owner");
        Intrinsics.checkNotNullParameter(storedPaymentMethod, "storedPaymentMethod");
        Intrinsics.checkNotNullParameter(configurationt, "configuration");
        return get((SavedStateRegistryOwner) t, (ViewModelStoreOwner) t, storedPaymentMethod, (Configuration) configurationt, (Bundle) null);
    }

    public <T extends ViewModelStoreOwner & SavedStateRegistryOwner> BaseComponentT get(T t, PaymentMethod paymentMethod, ConfigurationT configurationt) {
        Intrinsics.checkNotNullParameter(t, "owner");
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        Intrinsics.checkNotNullParameter(configurationt, "configuration");
        return get((SavedStateRegistryOwner) t, (ViewModelStoreOwner) t, paymentMethod, (Configuration) configurationt, (Bundle) null);
    }

    public BaseComponentT get(SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner, StoredPaymentMethod storedPaymentMethod, ConfigurationT configurationt, Bundle bundle) {
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "savedStateRegistryOwner");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(storedPaymentMethod, "storedPaymentMethod");
        Intrinsics.checkNotNullParameter(configurationt, "configuration");
        BaseComponentT basecomponentt = new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory) new GenericStoredPaymentComponentProvider$get$$inlined$viewModelFactory$1(savedStateRegistryOwner, bundle, this, configurationt, storedPaymentMethod)).get(this.componentClass);
        Intrinsics.checkNotNullExpressionValue(basecomponentt, "ViewModelProvider(viewModelStoreOwner, genericStoredFactory)[componentClass]");
        return (BasePaymentComponent) basecomponentt;
    }

    public BaseComponentT get(SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner, PaymentMethod paymentMethod, ConfigurationT configurationt, Bundle bundle) {
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "savedStateRegistryOwner");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        Intrinsics.checkNotNullParameter(configurationt, "configuration");
        BaseComponentT basecomponentt = new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory) new GenericStoredPaymentComponentProvider$get$$inlined$viewModelFactory$2(savedStateRegistryOwner, bundle, this, configurationt, paymentMethod)).get(this.componentClass);
        Intrinsics.checkNotNullExpressionValue(basecomponentt, "ViewModelProvider(viewModelStoreOwner, genericFactory)[componentClass]");
        return (BasePaymentComponent) basecomponentt;
    }
}
