package com.tal.app.thinkacademy.lib.utils;

import android.app.Application;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/tal/app/thinkacademy/lib/utils/AppGlobals;", "", "()V", "application", "Landroid/app/Application;", "get", "lib_library_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppGlobals.kt */
public final class AppGlobals {
    public static final AppGlobals INSTANCE = new AppGlobals();
    private static Application application;

    private AppGlobals() {
    }

    public final Application get() {
        if (application == null) {
            try {
                Object invoke = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke((Object) null, new Object[0]);
                if (invoke != null) {
                    application = (Application) invoke;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return application;
    }
}
