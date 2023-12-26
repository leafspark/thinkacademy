package com.igexin.a;

import android.os.Build;
import android.text.TextUtils;

final class k implements f {
    k() {
    }

    public void a(String str) {
        System.loadLibrary(str);
    }

    public String[] a() {
        if (Build.VERSION.SDK_INT >= 21 && Build.SUPPORTED_ABIS.length > 0) {
            return Build.SUPPORTED_ABIS;
        }
        if (!TextUtils.isEmpty(Build.CPU_ABI2)) {
            return new String[]{Build.CPU_ABI, Build.CPU_ABI2};
        }
        return new String[]{Build.CPU_ABI};
    }

    public void b(String str) {
        System.load(str);
    }

    public String c(String str) {
        return (!str.startsWith("lib") || !str.endsWith(".so")) ? System.mapLibraryName(str) : str;
    }

    public String d(String str) {
        return str.substring(3, str.length() - 3);
    }
}
