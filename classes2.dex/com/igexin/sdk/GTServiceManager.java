package com.igexin.sdk;

import android.app.Activity;
import com.igexin.push.core.x;

public class GTServiceManager {
    private GTServiceManager() {
    }

    public static GTServiceManager getInstance() {
        return c.a;
    }

    public void onActivityCreate(Activity activity) {
        x.a().a(activity);
    }
}
