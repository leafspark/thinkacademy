package com.adyen.checkout.components;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.adyen.checkout.components.ActionComponent;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.model.payments.response.Action;
import java.util.List;

public interface ActionComponentProvider<ComponentT extends ActionComponent, ConfigurationT extends Configuration> extends ComponentProvider<ComponentT> {
    boolean canHandleAction(Action action);

    <T extends SavedStateRegistryOwner & ViewModelStoreOwner> ComponentT get(T t, Application application, ConfigurationT configurationt);

    ComponentT get(SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner, Application application, ConfigurationT configurationt, Bundle bundle);

    List<String> getSupportedActionTypes();

    boolean providesDetails();

    @Deprecated
    boolean requiresConfiguration();

    boolean requiresView(Action action);
}
