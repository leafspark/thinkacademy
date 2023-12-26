package com.adyen.checkout.components;

import androidx.lifecycle.LifecycleOwner;
import com.adyen.checkout.components.ViewableComponent;
import com.adyen.checkout.components.base.OutputData;

public interface ComponentView<OutputDataT extends OutputData, ComponentT extends ViewableComponent> {
    void attach(ComponentT componentt, LifecycleOwner lifecycleOwner);

    void highlightValidationErrors();

    void initView();

    boolean isConfirmationRequired();

    void onComponentAttached();
}
