package com.adyen.checkout.components.encoding;

import android.util.Base64;
import com.adyen.checkout.core.exception.NoConstructorException;
import java.nio.charset.Charset;

public final class Base64Encoder {
    private static final Charset DEFAULT_CHARSET = (Charset.isSupported("UTF-8") ? Charset.forName("UTF-8") : Charset.defaultCharset());
    private static final String UTF_8 = "UTF-8";

    public static String encode(String str) {
        return encode(str, 0);
    }

    public static String encode(String str, int i) {
        return Base64.encodeToString(str.getBytes(DEFAULT_CHARSET), i);
    }

    public static String decode(String str) {
        return decode(str, 0);
    }

    public static String decode(String str, int i) {
        return new String(Base64.decode(str, i), DEFAULT_CHARSET);
    }

    private Base64Encoder() {
        throw new NoConstructorException();
    }
}
