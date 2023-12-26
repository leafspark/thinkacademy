package com.adyen.checkout.components.base.lifecycle;

import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\u0002H\u0003\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00030\b2\u0006\u0010\t\u001a\u00020\nH\u0014¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/adyen/checkout/components/base/lifecycle/ViewModelExtKt$viewModelFactory$2", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ViewModelExt.kt */
public final class ViewModelExtKt$viewModelFactory$2 extends AbstractSavedStateViewModelFactory {
    final /* synthetic */ Bundle $defaultArgs;
    final /* synthetic */ Function1<SavedStateHandle, ViewModelT> $factoryProducer;
    final /* synthetic */ SavedStateRegistryOwner $owner;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewModelExtKt$viewModelFactory$2(Function1<? super SavedStateHandle, ? extends ViewModelT> function1, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
        super(savedStateRegistryOwner, bundle);
        this.$factoryProducer = function1;
        this.$owner = savedStateRegistryOwner;
        this.$defaultArgs = bundle;
    }

    /* access modifiers changed from: protected */
    public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(str, TransferTable.COLUMN_KEY);
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        Intrinsics.checkNotNullParameter(savedStateHandle, "handle");
        return (ViewModel) this.$factoryProducer.invoke(savedStateHandle);
    }
}
