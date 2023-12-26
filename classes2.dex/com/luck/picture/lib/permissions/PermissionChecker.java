package com.luck.picture.lib.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;

public class PermissionChecker {
    public static boolean checkSelfPermission(Context context, String str) {
        return ContextCompat.checkSelfPermission(context.getApplicationContext(), str) == 0;
    }

    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        ActivityCompat.requestPermissions(activity, strArr, i);
    }

    public static void launchAppDetailsSettings(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + applicationContext.getPackageName()));
        if (isIntentAvailable(context, intent)) {
            applicationContext.startActivity(intent.addFlags(268435456));
        }
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        return context.getApplicationContext().getPackageManager().queryIntentActivities(intent, ArrayPool.STANDARD_BUFFER_SIZE_BYTES).size() > 0;
    }

    public static boolean checkSelfPermission(Context context, String[] strArr) {
        if (strArr != null) {
            for (String checkSelfPermission : strArr) {
                if (ContextCompat.checkSelfPermission(context.getApplicationContext(), checkSelfPermission) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isCheckReadStorage(Context context) {
        return checkSelfPermission(context, PermissionConfig.getReadPermissionArray(context));
    }

    public static boolean isCheckReadWriteStorage(Context context) {
        return checkSelfPermission(context, PermissionConfig.getReadWritePermissionArray(context));
    }

    public static boolean isCheckWriteStorage(Context context) {
        return checkSelfPermission(context, PermissionConfig.getWritePermissionArray(context));
    }
}
