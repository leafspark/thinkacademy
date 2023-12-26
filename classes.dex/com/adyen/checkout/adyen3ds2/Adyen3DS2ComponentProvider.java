package com.adyen.checkout.adyen3ds2;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.adyen.checkout.adyen3ds2.repository.SubmitFingerprintRepository;
import com.adyen.checkout.components.ActionComponentProvider;
import com.adyen.checkout.components.model.payments.response.Action;
import com.adyen.checkout.redirect.RedirectDelegate;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J4\u0010\t\u001a\u00020\u0002\"\f\b\u0000\u0010\n*\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u0002H\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0011J3\u0010\t\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0017J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u001c"}, d2 = {"Lcom/adyen/checkout/adyen3ds2/Adyen3DS2ComponentProvider;", "Lcom/adyen/checkout/components/ActionComponentProvider;", "Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Component;", "Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Configuration;", "()V", "canHandleAction", "", "action", "Lcom/adyen/checkout/components/model/payments/response/Action;", "get", "T", "Landroidx/savedstate/SavedStateRegistryOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "application", "Landroid/app/Application;", "configuration", "(Landroidx/savedstate/SavedStateRegistryOwner;Landroid/app/Application;Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Configuration;)Lcom/adyen/checkout/adyen3ds2/Adyen3DS2Component;", "savedStateRegistryOwner", "viewModelStoreOwner", "defaultArgs", "Landroid/os/Bundle;", "getSupportedActionTypes", "", "", "providesDetails", "requiresConfiguration", "requiresView", "3ds2_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Adyen3DS2ComponentProvider.kt */
public final class Adyen3DS2ComponentProvider implements ActionComponentProvider<Adyen3DS2Component, Adyen3DS2Configuration> {
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

    public <T extends SavedStateRegistryOwner & ViewModelStoreOwner> Adyen3DS2Component get(T t, Application application, Adyen3DS2Configuration adyen3DS2Configuration) {
        Intrinsics.checkNotNullParameter(t, "owner");
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(adyen3DS2Configuration, "configuration");
        return get((SavedStateRegistryOwner) t, (ViewModelStoreOwner) t, application, adyen3DS2Configuration, (Bundle) null);
    }

    public Adyen3DS2Component get(SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner, Application application, Adyen3DS2Configuration adyen3DS2Configuration, Bundle bundle) {
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "savedStateRegistryOwner");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(adyen3DS2Configuration, "configuration");
        ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner, (ViewModelProvider.Factory) new Adyen3DS2ComponentProvider$get$$inlined$viewModelFactory$1(savedStateRegistryOwner, bundle, application, adyen3DS2Configuration, new SubmitFingerprintRepository(), new Adyen3DS2Serializer(), new RedirectDelegate())).get(Adyen3DS2Component.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(viewModelStoreOwner, threeDS2Factory).get(Adyen3DS2Component::class.java)");
        return (Adyen3DS2Component) viewModel;
    }

    public List<String> getSupportedActionTypes() {
        return CollectionsKt.listOf(new String[]{"threeDS2Fingerprint", "threeDS2Challenge", "threeDS2"});
    }

    public boolean canHandleAction(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return CollectionsKt.contains(getSupportedActionTypes(), action.getType());
    }
}
