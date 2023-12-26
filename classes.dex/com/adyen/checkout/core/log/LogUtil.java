package com.adyen.checkout.core.log;

import android.os.Build;
import com.adyen.checkout.core.exception.NoConstructorException;
import com.adyen.checkout.core.util.KotlinBase;

public final class LogUtil {
    private static final String CHECKOUT_LOG_PREFIX = "CO.";
    private static final String CLASS_NOT_FOUND = "?Unknown?";
    private static final int MAX_TAG_SIZE = 23;

    static {
        KotlinBase.log();
    }

    public static String getTag() {
        return getTag(CHECKOUT_LOG_PREFIX);
    }

    public static String getTag(String str) {
        String str2 = str + getSimplifiedCallerClassName();
        return (Build.VERSION.SDK_INT > 23 || str2.length() <= 23) ? str2 : str2.substring(0, 23);
    }

    private static String getSimplifiedCallerClassName() {
        return simplifyClassName(getCallerClassName());
    }

    private static String getCallerClassName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 1; i < stackTrace.length; i++) {
            String className = stackTrace[i].getClassName();
            if (!className.equals(LogUtil.class.getName()) && className.indexOf("java.lang.Thread") != 0) {
                return className;
            }
        }
        return CLASS_NOT_FOUND;
    }

    private static String simplifyClassName(String str) {
        String[] split = str.split("\\.");
        if (split.length == 0) {
            return str;
        }
        return split[split.length - 1];
    }

    private LogUtil() {
        throw new NoConstructorException();
    }
}
