package com.didi.hummer.adapter.navigator.impl;

import android.content.Context;
import android.content.Intent;
import com.didi.hummer.adapter.navigator.NavPage;

public class DefaultIntentCreator implements IntentCreator {
    public Intent createCustomIntent(Context context, NavPage navPage) {
        return null;
    }

    public Intent createWebIntent(Context context, NavPage navPage) {
        return null;
    }

    public Intent appendBaseIntentParams(Intent intent, NavPage navPage) {
        intent.putExtra(DefaultNavigatorAdapter.EXTRA_PAGE_ID, navPage.id);
        intent.putExtra(DefaultNavigatorAdapter.EXTRA_PAGE_MODEL, navPage);
        return intent;
    }

    public Intent createHummerIntent(Context context, NavPage navPage) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.didi.hummer.HummerActivity");
        appendBaseIntentParams(intent, navPage);
        return intent;
    }
}
