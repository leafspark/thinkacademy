package com.adyen.checkout.redirect;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.SavedStateHandle;
import com.adyen.checkout.components.ActionComponentProvider;
import com.adyen.checkout.components.base.BaseActionComponent;
import com.adyen.checkout.components.base.IntentHandlingComponent;
import com.adyen.checkout.components.model.payments.response.Action;
import com.adyen.checkout.components.model.payments.response.RedirectAction;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.exception.ComponentException;

public final class RedirectComponent extends BaseActionComponent<RedirectConfiguration> implements IntentHandlingComponent {
    public static final ActionComponentProvider<RedirectComponent, RedirectConfiguration> PROVIDER = new RedirectComponentProvider();
    private final RedirectDelegate mRedirectDelegate;

    public RedirectComponent(SavedStateHandle savedStateHandle, Application application, RedirectConfiguration redirectConfiguration, RedirectDelegate redirectDelegate) {
        super(savedStateHandle, application, redirectConfiguration);
        this.mRedirectDelegate = redirectDelegate;
    }

    public static String getReturnUrl(Context context) {
        return RedirectUtil.REDIRECT_RESULT_SCHEME + context.getPackageName();
    }

    public boolean canHandleAction(Action action) {
        return PROVIDER.canHandleAction(action);
    }

    /* access modifiers changed from: protected */
    public void handleActionInternal(Activity activity, Action action) throws ComponentException {
        this.mRedirectDelegate.makeRedirect(activity, (RedirectAction) action);
    }

    public void handleIntent(Intent intent) {
        try {
            notifyDetails(this.mRedirectDelegate.handleRedirectResponse(intent.getData()));
        } catch (CheckoutException e) {
            notifyException(e);
        }
    }
}
