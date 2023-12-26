package com.didi.hummer.utils;

import android.text.TextUtils;

public class JsSourceUtil {
    public static final String JS_SOURCE_PREFIX_ASSETS = "assets:///";
    public static final String JS_SOURCE_PREFIX_FILE = "file:///";
    public static final String JS_SOURCE_PREFIX_HTTP = "http";
    public static final int JS_SOURCE_TYPE_ASSETS = 1;
    public static final int JS_SOURCE_TYPE_FILE = 2;
    public static final int JS_SOURCE_TYPE_HTTP = 3;
    public static final int JS_SOURCE_TYPE_UNKNOWN = 0;

    public static int getJsSourceType(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith(JS_SOURCE_PREFIX_ASSETS)) {
            return 1;
        }
        if (lowerCase.startsWith(JS_SOURCE_PREFIX_FILE)) {
            return 2;
        }
        if (lowerCase.startsWith("http")) {
            return 3;
        }
        return 0;
    }

    public static String getPathDir(String str) {
        int lastIndexOf;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf("/")) >= 0) {
            return str.substring(0, lastIndexOf + 1);
        }
        return "";
    }

    public static String relativePath2AbsolutePath(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.startsWith("./")) {
            return str;
        }
        String pathDir = getPathDir(str2);
        if (TextUtils.isEmpty(pathDir)) {
            return str.substring(2);
        }
        return pathDir + str.substring(2);
    }

    public static String getRealResourcePath(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.startsWith("./")) {
            return str;
        }
        String pathDir = getPathDir(str2);
        if (TextUtils.isEmpty(pathDir)) {
            return str;
        }
        String substring = str.substring(2);
        int jsSourceType = getJsSourceType(str2);
        if (jsSourceType == 1) {
            String substring2 = pathDir.substring(10);
            return substring2 + substring;
        } else if (jsSourceType == 2) {
            String substring3 = pathDir.substring(7);
            return substring3 + substring;
        } else if (jsSourceType != 3) {
            return substring;
        } else {
            return pathDir + substring;
        }
    }
}
