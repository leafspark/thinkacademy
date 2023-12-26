package com.adyen.checkout.components.base.lifecycle;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.adyen.checkout.components.base.Configuration;

public final class ActionComponentViewModelFactory implements ViewModelProvider.Factory {
    private final Application mApplication;
    private final Configuration mConfiguration;
    private final Class<?> mConfigurationClass;

    public ActionComponentViewModelFactory(Application application, Class<?> cls, Configuration configuration) {
        this.mApplication = application;
        this.mConfigurationClass = cls;
        this.mConfiguration = configuration;
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        try {
            return (ViewModel) cls.getConstructor(new Class[]{Application.class, this.mConfigurationClass}).newInstance(new Object[]{this.mApplication, this.mConfiguration});
        } catch (Exception e) {
            throw new RuntimeException("Failed to create an instance of component: " + cls, e);
        }
    }
}
