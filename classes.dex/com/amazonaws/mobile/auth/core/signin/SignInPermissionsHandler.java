package com.amazonaws.mobile.auth.core.signin;

public interface SignInPermissionsHandler {
    int getPermissionRequestCode();

    void handleRequestPermissionsResult(int i, String[] strArr, int[] iArr);
}
