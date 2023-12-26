package com.adyen.checkout.components;

import android.app.Activity;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.model.payments.response.Action;

public interface ActionComponent<ConfigurationT extends Configuration> extends Component<ActionComponentData, ConfigurationT> {
    boolean canHandleAction(Action action);

    void handleAction(Activity activity, Action action);
}
