package com.adyen.checkout.redirect;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;
import com.adyen.checkout.components.ui.util.ThemeUtil;
import com.adyen.checkout.core.exception.CheckoutException;
import com.adyen.checkout.core.log.LogUtil;
import com.adyen.checkout.core.log.Logger;
import com.adyen.checkout.redirect.ResolveResult;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/adyen/checkout/redirect/RedirectUtil;", "", "()V", "MD_PARAMETER", "", "PAYLOAD_PARAMETER", "PAYMENT_RESULT_PARAMETER", "QUERY_STRING_RESULT", "REDIRECT_RESULT_PARAMETER", "REDIRECT_RESULT_SCHEME", "RESOLVER_ACTIVITY_PACKAGE_NAME", "TAG", "createCustomTabIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "createRedirectIntent", "determineResolveResult", "Lcom/adyen/checkout/redirect/ResolveResult;", "parseRedirectResult", "Lorg/json/JSONObject;", "data", "redirect_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: RedirectUtil.kt */
public final class RedirectUtil {
    public static final RedirectUtil INSTANCE = new RedirectUtil();
    private static final String MD_PARAMETER = "MD";
    private static final String PAYLOAD_PARAMETER = "payload";
    private static final String PAYMENT_RESULT_PARAMETER = "PaRes";
    private static final String QUERY_STRING_RESULT = "returnUrlQueryString";
    private static final String REDIRECT_RESULT_PARAMETER = "redirectResult";
    public static final String REDIRECT_RESULT_SCHEME = "adyencheckout://";
    private static final String RESOLVER_ACTIVITY_PACKAGE_NAME = "android";
    private static final String TAG;

    private RedirectUtil() {
    }

    static {
        String tag = LogUtil.getTag();
        Intrinsics.checkNotNullExpressionValue(tag, "getTag()");
        TAG = tag;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031 A[Catch:{ Exception -> 0x0068 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040 A[Catch:{ Exception -> 0x0068 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048 A[Catch:{ Exception -> 0x0068 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.adyen.checkout.redirect.ResolveResult determineResolveResult(android.content.Context r5, android.net.Uri r6) {
        /*
            r4 = this;
            java.lang.String r0 = "android.intent.action.VIEW"
            r1 = 0
            android.content.Intent r2 = new android.content.Intent     // Catch:{ Exception -> 0x0068 }
            r2.<init>(r0, r6)     // Catch:{ Exception -> 0x0068 }
            android.content.Intent r6 = new android.content.Intent     // Catch:{ Exception -> 0x0068 }
            java.lang.String r3 = "http://"
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x0068 }
            r6.<init>(r0, r3)     // Catch:{ Exception -> 0x0068 }
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch:{ Exception -> 0x0068 }
            r0 = 0
            android.content.pm.ResolveInfo r0 = r5.resolveActivity(r2, r0)     // Catch:{ Exception -> 0x0068 }
            r2 = 65536(0x10000, float:9.18355E-41)
            android.content.pm.ResolveInfo r5 = r5.resolveActivity(r6, r2)     // Catch:{ Exception -> 0x0068 }
            if (r0 != 0) goto L_0x0026
        L_0x0024:
            r6 = r1
            goto L_0x002d
        L_0x0026:
            android.content.pm.ActivityInfo r6 = r0.activityInfo     // Catch:{ Exception -> 0x0068 }
            if (r6 != 0) goto L_0x002b
            goto L_0x0024
        L_0x002b:
            java.lang.String r6 = r6.packageName     // Catch:{ Exception -> 0x0068 }
        L_0x002d:
            if (r5 != 0) goto L_0x0031
        L_0x002f:
            r5 = r1
            goto L_0x0038
        L_0x0031:
            android.content.pm.ActivityInfo r5 = r5.activityInfo     // Catch:{ Exception -> 0x0068 }
            if (r5 != 0) goto L_0x0036
            goto L_0x002f
        L_0x0036:
            java.lang.String r5 = r5.packageName     // Catch:{ Exception -> 0x0068 }
        L_0x0038:
            java.lang.String r2 = "android"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r2)     // Catch:{ Exception -> 0x0068 }
            if (r2 == 0) goto L_0x0048
            com.adyen.checkout.redirect.ResolveResult r5 = new com.adyen.checkout.redirect.ResolveResult     // Catch:{ Exception -> 0x0068 }
            com.adyen.checkout.redirect.ResolveResult$Type r6 = com.adyen.checkout.redirect.ResolveResult.Type.RESOLVER_ACTIVITY     // Catch:{ Exception -> 0x0068 }
            r5.<init>(r6, r0)     // Catch:{ Exception -> 0x0068 }
            goto L_0x0079
        L_0x0048:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r5)     // Catch:{ Exception -> 0x0068 }
            if (r5 == 0) goto L_0x0056
            com.adyen.checkout.redirect.ResolveResult r5 = new com.adyen.checkout.redirect.ResolveResult     // Catch:{ Exception -> 0x0068 }
            com.adyen.checkout.redirect.ResolveResult$Type r6 = com.adyen.checkout.redirect.ResolveResult.Type.DEFAULT_BROWSER     // Catch:{ Exception -> 0x0068 }
            r5.<init>(r6, r0)     // Catch:{ Exception -> 0x0068 }
            goto L_0x0079
        L_0x0056:
            if (r6 != 0) goto L_0x0060
            com.adyen.checkout.redirect.ResolveResult r5 = new com.adyen.checkout.redirect.ResolveResult     // Catch:{ Exception -> 0x0068 }
            com.adyen.checkout.redirect.ResolveResult$Type r6 = com.adyen.checkout.redirect.ResolveResult.Type.UNKNOWN     // Catch:{ Exception -> 0x0068 }
            r5.<init>(r6, r1)     // Catch:{ Exception -> 0x0068 }
            goto L_0x0079
        L_0x0060:
            com.adyen.checkout.redirect.ResolveResult r5 = new com.adyen.checkout.redirect.ResolveResult     // Catch:{ Exception -> 0x0068 }
            com.adyen.checkout.redirect.ResolveResult$Type r6 = com.adyen.checkout.redirect.ResolveResult.Type.APPLICATION     // Catch:{ Exception -> 0x0068 }
            r5.<init>(r6, r0)     // Catch:{ Exception -> 0x0068 }
            goto L_0x0079
        L_0x0068:
            r5 = move-exception
            java.lang.String r6 = TAG
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            java.lang.String r0 = "determineResolveResult exception"
            com.adyen.checkout.core.log.Logger.e(r6, r0, r5)
            com.adyen.checkout.redirect.ResolveResult r5 = new com.adyen.checkout.redirect.ResolveResult
            com.adyen.checkout.redirect.ResolveResult$Type r6 = com.adyen.checkout.redirect.ResolveResult.Type.UNKNOWN
            r5.<init>(r6, r1)
        L_0x0079:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.redirect.RedirectUtil.determineResolveResult(android.content.Context, android.net.Uri):com.adyen.checkout.redirect.ResolveResult");
    }

    @JvmStatic
    public static final JSONObject parseRedirectResult(Uri uri) throws CheckoutException {
        String encodedQuery;
        String queryParameter;
        Intrinsics.checkNotNullParameter(uri, "data");
        Logger.d(TAG, Intrinsics.stringPlus("parseRedirectResult - ", uri));
        HashMap hashMap = new HashMap();
        String queryParameter2 = uri.getQueryParameter("payload");
        if (queryParameter2 != null) {
            String str = (String) hashMap.put("payload", queryParameter2);
        }
        String queryParameter3 = uri.getQueryParameter(REDIRECT_RESULT_PARAMETER);
        if (queryParameter3 != null) {
            String str2 = (String) hashMap.put(REDIRECT_RESULT_PARAMETER, queryParameter3);
        }
        String queryParameter4 = uri.getQueryParameter(PAYMENT_RESULT_PARAMETER);
        if (!(queryParameter4 == null || (queryParameter = uri.getQueryParameter(MD_PARAMETER)) == null)) {
            hashMap.put(PAYMENT_RESULT_PARAMETER, queryParameter4);
            hashMap.put(MD_PARAMETER, queryParameter);
        }
        if (hashMap.isEmpty() && (encodedQuery = uri.getEncodedQuery()) != null) {
            String str3 = (String) hashMap.put(QUERY_STRING_RESULT, encodedQuery);
        }
        if (!hashMap.isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : hashMap.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
                return jSONObject;
            } catch (JSONException e) {
                throw new CheckoutException("Error creating redirect result.", e);
            }
        } else {
            throw new CheckoutException("Error parsing redirect result, could not any query parameters");
        }
    }

    @JvmStatic
    public static final Intent createRedirectIntent(Context context, Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (Build.VERSION.SDK_INT >= 30) {
            return INSTANCE.createCustomTabIntent(context, uri);
        }
        RedirectUtil redirectUtil = INSTANCE;
        if (redirectUtil.determineResolveResult(context, uri).getType() == ResolveResult.Type.APPLICATION) {
            return new Intent("android.intent.action.VIEW", uri);
        }
        return redirectUtil.createCustomTabIntent(context, uri);
    }

    private final Intent createCustomTabIntent(Context context, Uri uri) {
        CustomTabColorSchemeParams build = new CustomTabColorSchemeParams.Builder().setToolbarColor(ThemeUtil.getPrimaryThemeColor(context)).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .setToolbarColor(ThemeUtil.getPrimaryThemeColor(context))\n            .build()");
        CustomTabsIntent build2 = new CustomTabsIntent.Builder().setShowTitle(true).setDefaultColorSchemeParams(build).build();
        Intrinsics.checkNotNullExpressionValue(build2, "Builder()\n            .setShowTitle(true)\n            .setDefaultColorSchemeParams(defaultColors)\n            .build()");
        build2.intent.setData(uri);
        Intent intent = build2.intent;
        Intrinsics.checkNotNullExpressionValue(intent, "customTabsIntent.intent");
        return intent;
    }
}
