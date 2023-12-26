package com.adyen.checkout.components.analytics;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.JobIntentService;
import com.adyen.checkout.core.api.Environment;
import com.adyen.checkout.core.log.LogUtil;

public class AnalyticsDispatcher extends JobIntentService {
    private static final String ANALYTICS_ENDPOINT = "images/analytics.png";
    private static final int ANALYTICS_JOB_ID = 4747;
    private static final String ENV_URL_KEY = "env_url_key";
    private static final String EVENT_KEY = "analytic_event";
    private static final String TAG = LogUtil.getTag();

    public static void dispatchEvent(Context context, Environment environment, AnalyticEvent analyticEvent) {
        Intent intent = new Intent();
        intent.putExtra(EVENT_KEY, analyticEvent);
        intent.putExtra(ENV_URL_KEY, environment.getBaseUrl());
        enqueueWork(context, (Class<?>) AnalyticsDispatcher.class, (int) ANALYTICS_JOB_ID, intent);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0065, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
        if (r0 != null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0070, code lost:
        throw r2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onHandleWork(android.content.Intent r4) {
        /*
            r3 = this;
            java.lang.String r0 = "analytic_event"
            android.os.Parcelable r0 = r4.getParcelableExtra(r0)
            com.adyen.checkout.components.analytics.AnalyticEvent r0 = (com.adyen.checkout.components.analytics.AnalyticEvent) r0
            java.lang.String r1 = "env_url_key"
            java.lang.String r4 = r4.getStringExtra(r1)
            if (r0 != 0) goto L_0x0018
            java.lang.String r4 = TAG
            java.lang.String r0 = "Analytics event is null."
            com.adyen.checkout.core.log.Logger.e(r4, r0)
            return
        L_0x0018:
            if (r4 != 0) goto L_0x0022
            java.lang.String r4 = TAG
            java.lang.String r0 = "env url is null."
            com.adyen.checkout.core.log.Logger.e(r4, r0)
            return
        L_0x0022:
            java.lang.String r1 = TAG
            java.lang.String r2 = "Sending analytic event."
            com.adyen.checkout.core.log.Logger.v(r1, r2)
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0079 }
            r2.<init>()     // Catch:{ IOException -> 0x0079 }
            r2.append(r4)     // Catch:{ IOException -> 0x0079 }
            java.lang.String r4 = "images/analytics.png"
            r2.append(r4)     // Catch:{ IOException -> 0x0079 }
            java.lang.String r4 = r2.toString()     // Catch:{ IOException -> 0x0079 }
            java.net.URL r4 = r0.toUrl(r4)     // Catch:{ IOException -> 0x0079 }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ IOException -> 0x0079 }
            java.net.URLConnection r4 = com.bonree.sdk.agent.engine.external.HttpInstrumentation.openConnection(r4)     // Catch:{ IOException -> 0x0079 }
            javax.net.ssl.HttpsURLConnection r4 = (javax.net.ssl.HttpsURLConnection) r4     // Catch:{ IOException -> 0x0079 }
            javax.net.ssl.SSLSocketFactory r0 = com.adyen.checkout.core.api.SSLSocketUtil.TLS_SOCKET_FACTORY     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r4.setSSLSocketFactory(r0)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r4.connect()     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            java.io.InputStream r0 = r4.getInputStream()     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
            r0.read()     // Catch:{ all -> 0x0063 }
            if (r0 == 0) goto L_0x005d
            r0.close()     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
        L_0x005d:
            if (r4 == 0) goto L_0x0086
            r4.disconnect()
            goto L_0x0086
        L_0x0063:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r2 = move-exception
            if (r0 == 0) goto L_0x0070
            r0.close()     // Catch:{ all -> 0x006c }
            goto L_0x0070
        L_0x006c:
            r0 = move-exception
            r1.addSuppressed(r0)     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
        L_0x0070:
            throw r2     // Catch:{ IOException -> 0x0074, all -> 0x0071 }
        L_0x0071:
            r0 = move-exception
            r1 = r4
            goto L_0x0087
        L_0x0074:
            r0 = move-exception
            r1 = r4
            goto L_0x007a
        L_0x0077:
            r0 = move-exception
            goto L_0x0087
        L_0x0079:
            r0 = move-exception
        L_0x007a:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x0077 }
            java.lang.String r2 = "Failed to send analytics event."
            com.adyen.checkout.core.log.Logger.e(r4, r2, r0)     // Catch:{ all -> 0x0077 }
            if (r1 == 0) goto L_0x0086
            r1.disconnect()
        L_0x0086:
            return
        L_0x0087:
            if (r1 == 0) goto L_0x008c
            r1.disconnect()
        L_0x008c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.components.analytics.AnalyticsDispatcher.onHandleWork(android.content.Intent):void");
    }
}
