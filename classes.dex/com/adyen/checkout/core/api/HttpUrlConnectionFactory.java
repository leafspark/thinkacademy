package com.adyen.checkout.core.api;

import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import java.net.HttpURLConnection;

final class HttpUrlConnectionFactory extends BaseHttpUrlConnectionFactory {
    private static final String ERROR_MESSAGE_INSECURE_CONNECTION = "Trying to connect to a URL that is not HTTPS.";
    private static final String TAG = LogUtil.getTag();
    private static HttpUrlConnectionFactory sInstance;

    static HttpUrlConnectionFactory getInstance() {
        HttpUrlConnectionFactory httpUrlConnectionFactory;
        synchronized (HttpUrlConnectionFactory.class) {
            if (sInstance == null) {
                sInstance = new HttpUrlConnectionFactory();
            }
            httpUrlConnectionFactory = sInstance;
        }
        return httpUrlConnectionFactory;
    }

    private HttpUrlConnectionFactory() {
    }

    /* access modifiers changed from: package-private */
    public HttpURLConnection handleInsecureConnection(HttpURLConnection httpURLConnection) {
        Logger.w(TAG, ERROR_MESSAGE_INSECURE_CONNECTION);
        return httpURLConnection;
    }
}
