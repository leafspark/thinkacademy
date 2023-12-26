package com.adyen.checkout.components.base;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateHandle;
import com.adyen.checkout.components.ComponentError;
import com.adyen.checkout.components.PaymentComponentState;
import com.adyen.checkout.components.ViewableComponent;
import com.adyen.checkout.components.analytics.AnalyticEvent;
import com.adyen.checkout.components.analytics.AnalyticsDispatcher;
import com.adyen.checkout.components.base.Configuration;
import com.adyen.checkout.components.base.InputData;
import com.adyen.checkout.components.base.OutputData;
import com.adyen.checkout.components.base.lifecycle.PaymentComponentViewModel;
import com.adyen.checkout.components.model.payments.request.PaymentMethodDetails;
import com.adyen.checkout.core.api.ThreadManager;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.exception.ComponentException;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;

public abstract class BasePaymentComponent<ConfigurationT extends Configuration, InputDataT extends InputData, OutputDataT extends OutputData, ComponentStateT extends PaymentComponentState<? extends PaymentMethodDetails>> extends PaymentComponentViewModel<ConfigurationT, ComponentStateT> implements ViewableComponent<OutputDataT, ConfigurationT, ComponentStateT> {
    private static final String TAG = LogUtil.getTag();
    private final MutableLiveData<ComponentError> mComponentErrorLiveData = new MutableLiveData<>();
    private boolean mIsAnalyticsEnabled = true;
    private boolean mIsCreatedForDropIn = false;
    protected InputDataT mLatestInputData;
    private final MutableLiveData<OutputDataT> mOutputLiveData = new MutableLiveData<>();
    private final MutableLiveData<ComponentStateT> mPaymentComponentStateLiveData = new MutableLiveData<>();

    /* access modifiers changed from: protected */
    public abstract ComponentStateT createComponentState();

    /* access modifiers changed from: protected */
    public abstract OutputDataT onInputDataChanged(InputDataT inputdatat);

    public boolean requiresInput() {
        return true;
    }

    public BasePaymentComponent(SavedStateHandle savedStateHandle, PaymentMethodDelegate paymentMethodDelegate, ConfigurationT configurationt) {
        super(savedStateHandle, paymentMethodDelegate, configurationt);
        assertSupported(paymentMethodDelegate.getPaymentMethodType());
    }

    public void observe(LifecycleOwner lifecycleOwner, Observer<ComponentStateT> observer) {
        this.mPaymentComponentStateLiveData.observe(lifecycleOwner, observer);
    }

    public void removeObservers(LifecycleOwner lifecycleOwner) {
        this.mPaymentComponentStateLiveData.removeObservers(lifecycleOwner);
    }

    public void removeObserver(Observer<ComponentStateT> observer) {
        this.mPaymentComponentStateLiveData.removeObserver(observer);
    }

    public void observeErrors(LifecycleOwner lifecycleOwner, Observer<ComponentError> observer) {
        this.mComponentErrorLiveData.observe(lifecycleOwner, observer);
    }

    public void removeErrorObservers(LifecycleOwner lifecycleOwner) {
        this.mComponentErrorLiveData.removeObservers(lifecycleOwner);
    }

    public void removeErrorObserver(Observer<ComponentError> observer) {
        this.mComponentErrorLiveData.removeObserver(observer);
    }

    public PaymentComponentState<? extends PaymentMethodDetails> getState() {
        return (PaymentComponentState) this.mPaymentComponentStateLiveData.getValue();
    }

    public final void inputDataChanged(InputDataT inputdatat) {
        Logger.v(TAG, "inputDataChanged");
        this.mLatestInputData = inputdatat;
        notifyStateChanged(onInputDataChanged(inputdatat));
    }

    public void setAnalyticsEnabled(boolean z) {
        this.mIsAnalyticsEnabled = z;
    }

    public void sendAnalyticsEvent(Context context) {
        AnalyticEvent.Flavor flavor;
        if (this.mIsAnalyticsEnabled) {
            if (this.mIsCreatedForDropIn) {
                flavor = AnalyticEvent.Flavor.DROPIN;
            } else {
                flavor = AnalyticEvent.Flavor.COMPONENT;
            }
            String paymentMethodType = this.mPaymentMethodDelegate.getPaymentMethodType();
            if (!TextUtils.isEmpty(paymentMethodType)) {
                AnalyticsDispatcher.dispatchEvent(context, getConfiguration().getEnvironment(), AnalyticEvent.create(context, flavor, paymentMethodType, getConfiguration().getShopperLocale()));
                return;
            }
            throw new CheckoutException("Payment method has empty or null type");
        }
    }

    public void observeOutputData(LifecycleOwner lifecycleOwner, Observer<OutputDataT> observer) {
        this.mOutputLiveData.observe(lifecycleOwner, observer);
    }

    public OutputDataT getOutputData() {
        return (OutputData) this.mOutputLiveData.getValue();
    }

    /* access modifiers changed from: protected */
    public void notifyException(CheckoutException checkoutException) {
        String str = TAG;
        Logger.e(str, "notifyException - " + checkoutException.getMessage());
        this.mComponentErrorLiveData.postValue(new ComponentError(checkoutException));
    }

    /* access modifiers changed from: protected */
    public void notifyStateChanged(OutputDataT outputdatat) {
        String str = TAG;
        Logger.d(str, "notifyStateChanged with OutputData");
        if (!outputdatat.equals(this.mOutputLiveData.getValue())) {
            this.mOutputLiveData.setValue(outputdatat);
            notifyStateChanged();
            return;
        }
        Logger.d(str, "state has not changed");
    }

    /* access modifiers changed from: protected */
    public void notifyStateChanged() {
        Logger.d(TAG, "notifyStateChanged");
        ThreadManager.EXECUTOR.submit(new BasePaymentComponent$$ExternalSyntheticLambda0(this));
    }

    public /* synthetic */ void lambda$notifyStateChanged$0$BasePaymentComponent() {
        try {
            this.mPaymentComponentStateLiveData.postValue(createComponentState());
        } catch (Exception e) {
            String str = TAG;
            Logger.e(str, "notifyStateChanged - error:" + e.getMessage());
            notifyException(new ComponentException("Unexpected error", e));
        }
    }

    private void assertSupported(String str) {
        if (!isSupported(str)) {
            throw new IllegalArgumentException("Unsupported payment method type " + str);
        }
    }

    private boolean isSupported(String str) {
        for (String equals : getSupportedPaymentMethodTypes()) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void setCreatedForDropIn() {
        this.mIsCreatedForDropIn = true;
    }
}
