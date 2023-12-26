package com.adyen.checkout.components.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateHandle;
import com.adyen.checkout.components.ActionComponentData;
import com.adyen.checkout.components.ComponentError;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.base.lifecycle.ActionComponentViewModel;
import com.adyen.checkout.components.model.payments.response.Action;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.exception.ComponentException;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import org.json.JSONObject;

public abstract class BaseActionComponent<ConfigurationT extends Configuration> extends ActionComponentViewModel<ConfigurationT> {
    private static final String PAYMENT_DATA_KEY = "payment_data";
    private static final String TAG = LogUtil.getTag();
    private final MutableLiveData<ComponentError> mErrorMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<ActionComponentData> mResultLiveData = new MutableLiveData<>();

    /* access modifiers changed from: protected */
    public abstract void handleActionInternal(Activity activity, Action action) throws ComponentException;

    public BaseActionComponent(SavedStateHandle savedStateHandle, Application application, ConfigurationT configurationt) {
        super(savedStateHandle, application, configurationt);
    }

    public void handleAction(Activity activity, Action action) {
        if (!canHandleAction(action)) {
            notifyException(new ComponentException("Action type not supported by this component - " + action.getType()));
            return;
        }
        setPaymentData(action.getPaymentData());
        try {
            handleActionInternal(activity, action);
        } catch (ComponentException e) {
            notifyException(e);
        }
    }

    public void observe(LifecycleOwner lifecycleOwner, Observer<ActionComponentData> observer) {
        this.mResultLiveData.observe(lifecycleOwner, observer);
    }

    public void removeObservers(LifecycleOwner lifecycleOwner) {
        this.mResultLiveData.removeObservers(lifecycleOwner);
    }

    public void removeObserver(Observer<ActionComponentData> observer) {
        this.mResultLiveData.removeObserver(observer);
    }

    public void observeErrors(LifecycleOwner lifecycleOwner, Observer<ComponentError> observer) {
        this.mErrorMutableLiveData.observe(lifecycleOwner, observer);
    }

    public void removeErrorObservers(LifecycleOwner lifecycleOwner) {
        this.mErrorMutableLiveData.removeObservers(lifecycleOwner);
    }

    public void removeErrorObserver(Observer<ComponentError> observer) {
        this.mErrorMutableLiveData.removeObserver(observer);
    }

    @Deprecated
    public void saveState(Bundle bundle) {
        Logger.w(TAG, "Calling saveState is not necessary anymore, you can safely remove this method.");
    }

    @Deprecated
    public void restoreState(Bundle bundle) {
        Logger.w(TAG, "Calling restoreState is not necessary anymore, you can safely remove this method.");
    }

    /* access modifiers changed from: protected */
    public void notifyDetails(JSONObject jSONObject) throws ComponentException {
        ActionComponentData actionComponentData = new ActionComponentData();
        actionComponentData.setDetails(jSONObject);
        actionComponentData.setPaymentData(getPaymentData());
        this.mResultLiveData.setValue(actionComponentData);
    }

    /* access modifiers changed from: protected */
    public void notifyException(CheckoutException checkoutException) {
        this.mErrorMutableLiveData.postValue(new ComponentError(checkoutException));
    }

    /* access modifiers changed from: protected */
    public String getPaymentData() {
        return (String) getSavedStateHandle().get(PAYMENT_DATA_KEY);
    }

    /* access modifiers changed from: protected */
    public void setPaymentData(String str) {
        getSavedStateHandle().set(PAYMENT_DATA_KEY, str);
    }
}
