package com.amazonaws.mobileconnectors.cognitoidentityprovider.util;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoInternalErrorException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import com.amazonaws.util.Base64;
import com.amazonaws.util.StringUtils;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class CognitoSecretHash {
    private static final String HMAC_SHA_256 = "HmacSHA256";

    public static String getSecretHash(String str, String str2, String str3) {
        if (str == null) {
            throw new CognitoParameterInvalidException("user ID cannot be null");
        } else if (str2 == null) {
            throw new CognitoParameterInvalidException("client ID cannot be null");
        } else if (StringUtils.isBlank(str3)) {
            return null;
        } else {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(StringUtils.UTF8), HMAC_SHA_256);
            try {
                Mac instance = Mac.getInstance(HMAC_SHA_256);
                instance.init(secretKeySpec);
                instance.update(str.getBytes(StringUtils.UTF8));
                return new String(Base64.encode(instance.doFinal(str2.getBytes(StringUtils.UTF8))));
            } catch (Exception unused) {
                throw new CognitoInternalErrorException("errors in HMAC calculation");
            }
        }
    }
}
