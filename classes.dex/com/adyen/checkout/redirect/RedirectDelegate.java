package com.adyen.checkout.redirect;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import com.adyen.checkout.components.model.payments.response.RedirectAction;
import com.adyen.checkout.core.exception.ComponentException;
import com.adyen.checkout.core.log.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e¨\u0006\u000f"}, d2 = {"Lcom/adyen/checkout/redirect/RedirectDelegate;", "", "()V", "handleRedirectResponse", "Lorg/json/JSONObject;", "data", "Landroid/net/Uri;", "makeRedirect", "", "activity", "Landroid/app/Activity;", "redirectAction", "Lcom/adyen/checkout/components/model/payments/response/RedirectAction;", "url", "", "redirect_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: RedirectDelegate.kt */
public final class RedirectDelegate {
    public final void makeRedirect(Activity activity, RedirectAction redirectAction) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(redirectAction, "redirectAction");
        makeRedirect(activity, redirectAction.getUrl());
    }

    public final void makeRedirect(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.d(RedirectDelegateKt.TAG, Intrinsics.stringPlus("makeRedirect - ", str));
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            Uri parse = Uri.parse(str);
            Intrinsics.checkNotNullExpressionValue(parse, "redirectUri");
            try {
                activity.startActivity(RedirectUtil.createRedirectIntent(activity, parse));
            } catch (ActivityNotFoundException e) {
                throw new ComponentException("Redirect to app failed.", e);
            }
        } else {
            throw new ComponentException("Redirect URL is empty.");
        }
    }

    public final JSONObject handleRedirectResponse(Uri uri) {
        if (uri != null) {
            return RedirectUtil.parseRedirectResult(uri);
        }
        throw new ComponentException("Received a null redirect Uri");
    }
}
