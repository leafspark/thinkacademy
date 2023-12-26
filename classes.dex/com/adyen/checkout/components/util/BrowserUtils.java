package com.adyen.checkout.components.util;

import android.content.Intent;
import android.net.Uri;
import com.adyen.checkout.core.exception.NoConstructorException;

public final class BrowserUtils {
    public static Intent createBrowserIntent(Uri uri) {
        return new Intent("android.intent.action.VIEW", uri);
    }

    private BrowserUtils() {
        throw new NoConstructorException();
    }
}
