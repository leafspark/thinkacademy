package com.didi.hummer.adapter.navigator.impl;

import android.content.Context;
import android.content.Intent;
import com.didi.hummer.adapter.navigator.NavPage;

public interface IntentCreator {
    Intent createCustomIntent(Context context, NavPage navPage);

    Intent createHummerIntent(Context context, NavPage navPage);

    Intent createWebIntent(Context context, NavPage navPage);
}
