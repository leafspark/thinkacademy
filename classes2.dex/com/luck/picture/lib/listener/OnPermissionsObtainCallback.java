package com.luck.picture.lib.listener;

import android.content.Context;

public interface OnPermissionsObtainCallback {
    void onPermissionsIntercept(Context context, boolean z, String[] strArr, String str, OnPermissionDialogOptionCallback onPermissionDialogOptionCallback);
}
