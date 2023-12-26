package com.amazonaws.services.s3.internal;

import java.util.regex.Pattern;

public enum BucketNameUtils {
    ;
    
    private static final Pattern IP_ADDRESS_PATTERN = null;
    private static final int MAX_BUCKET_NAME_LENGTH = 63;
    private static final int MIN_BUCKET_NAME_LENGTH = 3;

    static {
        IP_ADDRESS_PATTERN = Pattern.compile("(\\d+\\.){3}\\d+");
    }

    public static void validateBucketName(String str) {
        isValidV2BucketName(str, true);
    }

    public static boolean isValidV2BucketName(String str) {
        return isValidV2BucketName(str, false);
    }

    public static boolean isDNSBucketName(String str) {
        return isValidV2BucketName(str);
    }

    private static boolean isValidV2BucketName(String str, boolean z) {
        if (str == null) {
            return exception(z, "Bucket name cannot be null");
        }
        if (str.length() < 3 || str.length() > 63) {
            return exception(z, "Bucket name should be between 3 and 63 characters long");
        }
        if (IP_ADDRESS_PATTERN.matcher(str).matches()) {
            return exception(z, "Bucket name must not be formatted as an IP Address");
        }
        int i = 0;
        char c = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt >= 'A' && charAt <= 'Z') {
                return exception(z, "Bucket name should not contain uppercase characters");
            }
            if (charAt == ' ' || charAt == 9 || charAt == 13 || charAt == 10) {
                return exception(z, "Bucket name should not contain white space");
            }
            if (charAt == '.') {
                if (c == 0) {
                    return exception(z, "Bucket name should not begin with a period");
                }
                if (c == '.') {
                    return exception(z, "Bucket name should not contain two adjacent periods");
                }
                if (c == '-') {
                    return exception(z, "Bucket name should not contain dashes next to periods");
                }
            } else if (charAt == '-') {
                if (c == '.') {
                    return exception(z, "Bucket name should not contain dashes next to periods");
                }
                if (c == 0) {
                    return exception(z, "Bucket name should not begin with a '-'");
                }
            } else if (charAt < '0' || ((charAt > '9' && charAt < 'a') || charAt > 'z')) {
                return exception(z, "Bucket name should not contain '" + charAt + "'");
            }
            i++;
            c = charAt;
        }
        if (c == '.' || c == '-') {
            return exception(z, "Bucket name should not end with '-' or '.'");
        }
        if (str.contains(".")) {
            return false;
        }
        return true;
    }

    private static boolean exception(boolean z, String str) {
        if (!z) {
            return false;
        }
        throw new IllegalArgumentException(str);
    }
}
