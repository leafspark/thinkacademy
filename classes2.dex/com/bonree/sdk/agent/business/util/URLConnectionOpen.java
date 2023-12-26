package com.bonree.sdk.agent.business.util;

import com.bonree.sdk.agent.engine.external.HttpInstrumentation;
import com.bonree.sdk.be.a;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionOpen {
    public URLConnection getURLConnectionOpen(URL url) {
        try {
            return HttpInstrumentation.openConnection(url.openConnection());
        } catch (Throwable th) {
            a.a().a("URLConnectionUtilOpen", th);
            return null;
        }
    }
}
