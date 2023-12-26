package com.adyen.checkout.components.base.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"com/adyen/checkout/components/base/lifecycle/ViewModelExtKt$viewModelFactory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "components-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ViewModelExt.kt */
public final class ViewModelExtKt$viewModelFactory$1 implements ViewModelProvider.Factory {
    final /* synthetic */ Function0<ViewModelT> $factoryProducer;

    public ViewModelExtKt$viewModelFactory$1(Function0<? extends ViewModelT> function0) {
        this.$factoryProducer = function0;
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        return (ViewModel) this.$factoryProducer.invoke();
    }
}
