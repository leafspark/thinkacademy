package com.adyen.checkout.components.base.lifecycle;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.SavedStateHandle;
import com.adyen.checkout.components.ActionComponent;
import com.adyen.checkout.components.base.Configuration;

public abstract class ActionComponentViewModel<ConfigurationT extends Configuration> extends AndroidViewModel implements ActionComponent<ConfigurationT> {
    private final ConfigurationT mConfiguration;
    private final SavedStateHandle mSavedStateHandle;

    public ActionComponentViewModel(SavedStateHandle savedStateHandle, Application application, ConfigurationT configurationt) {
        super(application);
        this.mConfiguration = configurationt;
        this.mSavedStateHandle = savedStateHandle;
    }

    public ConfigurationT getConfiguration() {
        return this.mConfiguration;
    }

    public SavedStateHandle getSavedStateHandle() {
        return this.mSavedStateHandle;
    }
}
