package com.adyen.checkout.components;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.base.OutputData;

public interface ViewableComponent<OutputDataT extends OutputData, ConfigurationT extends Configuration, ComponentStateT> extends Component<ComponentStateT, ConfigurationT> {
    OutputDataT getOutputData();

    void observeOutputData(LifecycleOwner lifecycleOwner, Observer<OutputDataT> observer);

    void sendAnalyticsEvent(Context context);
}
