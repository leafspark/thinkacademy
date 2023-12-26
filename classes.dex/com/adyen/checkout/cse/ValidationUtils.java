package com.adyen.checkout.cse;

import com.adyen.checkout.core.exception.NoConstructorException;
import java.util.regex.Pattern;

public final class ValidationUtils {
    private static final String PUBLIC_KEY_PATTERN = "([A-F]|[0-9]){5}\\|([A-F]|[0-9]){512}";
    private static final int PUBLIC_KEY_SIZE = 518;

    public static boolean isPublicKeyValid(String str) {
        return Pattern.compile(PUBLIC_KEY_PATTERN).matcher(str).find() && str.length() == PUBLIC_KEY_SIZE;
    }

    private ValidationUtils() {
        throw new NoConstructorException();
    }
}
