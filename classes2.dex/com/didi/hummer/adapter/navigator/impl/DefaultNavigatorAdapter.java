package com.didi.hummer.adapter.navigator.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.hummer.HummerSDK;
import com.didi.hummer.adapter.navigator.INavigatorAdapter;
import com.didi.hummer.adapter.navigator.NavCallback;
import com.didi.hummer.adapter.navigator.NavPage;
import com.didi.hummer.adapter.navigator.impl.router.ActivityLauncher;
import java.util.HashMap;
import java.util.Map;

public class DefaultNavigatorAdapter implements INavigatorAdapter {
    public static final String EXTRA_PAGE_ID = "PAGE_ID";
    public static final String EXTRA_PAGE_MODEL = "PAGE_MODEL";
    public static final String SCHEME_HTTP = "http";
    public static final String SCHEME_HTTPS = "https";
    public static final String SCHEME_HUMMER = "hummer";
    protected IntentCreator intentCreator;

    public DefaultNavigatorAdapter() {
        this((IntentCreator) null);
    }

    public DefaultNavigatorAdapter(IntentCreator intentCreator2) {
        this.intentCreator = intentCreator2;
        if (intentCreator2 == null) {
            this.intentCreator = new DefaultIntentCreator();
        }
    }

    public void openPage(Context context, NavPage navPage, NavCallback navCallback) {
        if (context == null) {
            context = HummerSDK.appContext;
        }
        goToPage(context, navPage, navCallback);
    }

    public void popPage(Context context, NavPage navPage) {
        Activity activity;
        if (navPage == null || TextUtils.isEmpty(navPage.id)) {
            activity = context instanceof Activity ? (Activity) context : null;
        } else {
            activity = ActivityStackManager.getInstance().getActivity(navPage.id);
        }
        if (activity != null) {
            activity.finish();
            if (navPage != null && !navPage.animated) {
                activity.overridePendingTransition(0, 0);
            }
        }
    }

    public void popToPage(Context context, NavPage navPage) {
        if (navPage != null) {
            ActivityStackManager.getInstance().popToActivity(navPage.id, navPage.animated);
        }
    }

    public void popToRootPage(Context context, NavPage navPage) {
        ActivityStackManager.getInstance().popToRootActivity(navPage == null || navPage.animated);
    }

    public void popBack(Context context, int i, NavPage navPage) {
        boolean z = true;
        if (i == 1) {
            popPage(context, navPage);
            return;
        }
        if (navPage != null && !navPage.animated) {
            z = false;
        }
        ActivityStackManager.getInstance().popBack(i, z);
    }

    /* access modifiers changed from: protected */
    public void goToPage(Context context, NavPage navPage, NavCallback navCallback) {
        if (context != null && navPage != null && !TextUtils.isEmpty(navPage.url)) {
            String scheme = navPage.getScheme();
            if (!TextUtils.isEmpty(scheme)) {
                String lowerCase = scheme.toLowerCase();
                lowerCase.hashCode();
                char c = 65535;
                switch (lowerCase.hashCode()) {
                    case -1206128422:
                        if (lowerCase.equals(SCHEME_HUMMER)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3213448:
                        if (lowerCase.equals("http")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 99617003:
                        if (lowerCase.equals(SCHEME_HTTPS)) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        openHummerPage(context, navPage, navCallback);
                        return;
                    case 1:
                    case 2:
                        if (navPage.isJsUrl()) {
                            openHummerPage(context, navPage, navCallback);
                            return;
                        } else {
                            openWebPage(context, navPage, navCallback);
                            return;
                        }
                    default:
                        if (navPage.isJsUrl()) {
                            openHummerPage(context, navPage, navCallback);
                            return;
                        } else {
                            openCustomPage(context, navPage, navCallback);
                            return;
                        }
                }
            } else if (navPage.isJsUrl()) {
                openHummerPage(context, navPage, navCallback);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void openHummerPage(Context context, NavPage navPage, NavCallback navCallback) {
        openPage(context, this.intentCreator.createHummerIntent(context, navPage), navPage, navCallback);
    }

    /* access modifiers changed from: protected */
    public void openWebPage(Context context, NavPage navPage, NavCallback navCallback) {
        openPage(context, this.intentCreator.createWebIntent(context, navPage), navPage, navCallback);
    }

    /* access modifiers changed from: protected */
    public void openCustomPage(Context context, NavPage navPage, NavCallback navCallback) {
        openPage(context, this.intentCreator.createCustomIntent(context, navPage), navPage, navCallback);
    }

    /* access modifiers changed from: protected */
    public void openPage(Context context, Intent intent, NavPage navPage, NavCallback navCallback) {
        if (intent != null) {
            if (context instanceof Application) {
                intent.addFlags(268435456);
            }
            if (navPage.closeSelf) {
                context.startActivity(intent);
            } else {
                ActivityLauncher.init(context).startActivityForResult(intent, (ActivityLauncher.Callback) new DefaultNavigatorAdapter$$ExternalSyntheticLambda0(this, navCallback));
            }
            if (!navPage.animated && (context instanceof Activity)) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
            if (navPage.closeSelf && (context instanceof Activity)) {
                ((Activity) context).finish();
            }
        }
    }

    public /* synthetic */ void lambda$openPage$0$DefaultNavigatorAdapter(NavCallback navCallback, int i, Intent intent) {
        Map<String, Object> transIntentData = transIntentData(intent);
        if (navCallback != null && transIntentData != null) {
            navCallback.onResult(transIntentData);
        }
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> transIntentData(Intent intent) {
        HashMap hashMap = null;
        if (intent == null) {
            return null;
        }
        try {
            if (intent.getExtras() == null) {
                return null;
            }
            Bundle extras = intent.getExtras();
            HashMap hashMap2 = new HashMap();
            try {
                for (String str : extras.keySet()) {
                    Object obj = extras.get(str);
                    if (obj != null) {
                        hashMap2.put(str, obj);
                    }
                }
                return hashMap2;
            } catch (Exception e) {
                e = e;
                hashMap = hashMap2;
                e.printStackTrace();
                return hashMap;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return hashMap;
        }
    }
}
