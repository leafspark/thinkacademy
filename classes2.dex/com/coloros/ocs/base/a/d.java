package com.coloros.ocs.base.a;

import android.content.Context;
import android.content.pm.PackageManager;

public class d {
    private static final String a = "d";

    public static boolean a(Context context, String str) {
        int i;
        try {
            i = context.getPackageManager().getApplicationInfo(str, 128).uid;
        } catch (PackageManager.NameNotFoundException unused) {
            b.d(a, "OCS not found");
            i = 0;
        }
        if (i != 0) {
            return true;
        }
        return false;
    }
}
