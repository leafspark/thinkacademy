package com.adyen.checkout.redirect;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.adyen.checkout.components.ActionComponentProvider;
import com.adyen.checkout.components.model.payments.response.Action;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J4\u0010\t\u001a\u00020\u0002\"\f\b\u0000\u0010\n*\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u0002H\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0011J3\u0010\t\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0017J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u001c"}, d2 = {"Lcom/adyen/checkout/redirect/RedirectComponentProvider;", "Lcom/adyen/checkout/components/ActionComponentProvider;", "Lcom/adyen/checkout/redirect/RedirectComponent;", "Lcom/adyen/checkout/redirect/RedirectConfiguration;", "()V", "canHandleAction", "", "action", "Lcom/adyen/checkout/components/model/payments/response/Action;", "get", "T", "Landroidx/savedstate/SavedStateRegistryOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "application", "Landroid/app/Application;", "configuration", "(Landroidx/savedstate/SavedStateRegistryOwner;Landroid/app/Application;Lcom/adyen/checkout/redirect/RedirectConfiguration;)Lcom/adyen/checkout/redirect/RedirectComponent;", "savedStateRegistryOwner", "viewModelStoreOwner", "defaultArgs", "Landroid/os/Bundle;", "getSupportedActionTypes", "", "", "providesDetails", "requiresConfiguration", "requiresView", "redirect_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: RedirectComponentProvider.kt */
public final class RedirectComponentProvider implements ActionComponentProvider<RedirectComponent, RedirectConfiguration> {
    public boolean providesDetails() {
        return true;
    }

    @Deprecated(message = "You can safely remove this method, it will always return true as all action components require a configuration.", replaceWith = @ReplaceWith(expression = "true", imports = {}))
    public boolean requiresConfiguration() {
        return true;
    }

    public boolean requiresView(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return false;
    }

    public <T extends SavedStateRegistryOwner & ViewModelStoreOwner> RedirectComponent get(T t, Application application, RedirectConfiguration redirectConfiguration) {
        Intrinsics.checkNotNullParameter(t, "owner");
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(redirectConfiguration, "configuration");
        return get((SavedStateRegistryOwner) t, (ViewModelStoreOwner) t, application, redirectConfiguration, (Bundle) null);
    }

    public RedirectComponent get(SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner, Application application, RedirectConfiguration redirectConfiguration, Bundle bundle) {
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "savedStateRegistryOwner");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(redirectConfiguration, "configuration");
        ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory) new RedirectComponentProvider$get$$inlined$viewModelFactory$1(savedStateRegistryOwner, bundle, application, redirectConfiguration, new RedirectDelegate())).get(RedirectComponent.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(viewModelStoreOwner, redirectFactory).get(RedirectComponent::class.java)");
        return (RedirectComponent) viewModel;
    }

    public List<String> getSupportedActionTypes() {
        return CollectionsKt.listOf("redirect");
    }

    public boolean canHandleAction(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return CollectionsKt.contains(getSupportedActionTypes(), action.getType());
    }
}
