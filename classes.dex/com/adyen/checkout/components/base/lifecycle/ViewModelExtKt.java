package com.adyen.checkout.components.base.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\bø\u0001\u0000\u001a>\u0010\u0000\u001a\u00020\u0006\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\u00020\u000bH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\r"}, d2 = {"viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "ViewModelT", "Landroidx/lifecycle/ViewModel;", "factoryProducer", "Lkotlin/Function0;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "defaultArgs", "Landroid/os/Bundle;", "Lkotlin/Function1;", "Landroidx/lifecycle/SavedStateHandle;", "components-core_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: ViewModelExt.kt */
public final class ViewModelExtKt {
    public static final <ViewModelT extends ViewModel> ViewModelProvider.Factory viewModelFactory(Function0<? extends ViewModelT> function0) {
        Intrinsics.checkNotNullParameter(function0, "factoryProducer");
        return new ViewModelExtKt$viewModelFactory$1(function0);
    }

    public static final <ViewModelT extends ViewModel> AbstractSavedStateViewModelFactory viewModelFactory(SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle, Function1<? super SavedStateHandle, ? extends ViewModelT> function1) {
        Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "owner");
        Intrinsics.checkNotNullParameter(function1, "factoryProducer");
        return new ViewModelExtKt$viewModelFactory$2(function1, savedStateRegistryOwner, bundle);
    }
}
