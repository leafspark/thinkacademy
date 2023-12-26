package com.adyen.checkout.core.util;

import com.adyen.checkout.core.exception.NoConstructorException;

public final class StringUtil {
    public static String normalize(String str, char... cArr) {
        return str.replaceAll("[\\s" + new String(cArr) + "]", "");
    }

    public static boolean isDigitsAndSeparatorsOnly(String str, char... cArr) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!Character.isDigit(charAt)) {
                return false;
            }
            for (char c : cArr) {
                if (c != charAt) {
                    return false;
                }
            }
        }
        return true;
    }

    private StringUtil() {
        throw new NoConstructorException();
    }
}
