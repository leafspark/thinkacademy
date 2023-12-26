package org.bouncycastle.util;

import java.math.BigInteger;
import java.security.AccessControlException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Properties {
    private static final ThreadLocal threadProperties = new ThreadLocal();

    private Properties() {
    }

    public static BigInteger asBigInteger(String str) {
        String propertyValue = getPropertyValue(str);
        if (propertyValue != null) {
            return new BigInteger(propertyValue);
        }
        return null;
    }

    public static Set<String> asKeySet(String str) {
        HashSet hashSet = new HashSet();
        String propertyValue = getPropertyValue(str);
        if (propertyValue != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(propertyValue, ",");
            while (stringTokenizer.hasMoreElements()) {
                hashSet.add(Strings.toLowerCase(stringTokenizer.nextToken()).trim());
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        r0 = (java.lang.String) r0.get(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getPropertyValue(final java.lang.String r1) {
        /*
            org.bouncycastle.util.Properties$1 r0 = new org.bouncycastle.util.Properties$1
            r0.<init>(r1)
            java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x000e
            return r0
        L_0x000e:
            java.lang.ThreadLocal r0 = threadProperties
            java.lang.Object r0 = r0.get()
            java.util.Map r0 = (java.util.Map) r0
            if (r0 == 0) goto L_0x0021
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x0021
            return r0
        L_0x0021:
            org.bouncycastle.util.Properties$2 r0 = new org.bouncycastle.util.Properties$2
            r0.<init>(r1)
            java.lang.Object r1 = java.security.AccessController.doPrivileged(r0)
            java.lang.String r1 = (java.lang.String) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.util.Properties.getPropertyValue(java.lang.String):java.lang.String");
    }

    public static boolean isOverrideSet(String str) {
        try {
            return isSetTrue(getPropertyValue(str));
        } catch (AccessControlException unused) {
            return false;
        }
    }

    public static boolean isOverrideSetTo(String str, boolean z) {
        try {
            String propertyValue = getPropertyValue(str);
            return z ? isSetTrue(propertyValue) : isSetFalse(propertyValue);
        } catch (AccessControlException unused) {
            return false;
        }
    }

    private static boolean isSetFalse(String str) {
        if (str == null || str.length() != 5) {
            return false;
        }
        if (str.charAt(0) != 'f' && str.charAt(0) != 'F') {
            return false;
        }
        if (str.charAt(1) != 'a' && str.charAt(1) != 'A') {
            return false;
        }
        if (str.charAt(2) != 'l' && str.charAt(2) != 'L') {
            return false;
        }
        if (str.charAt(3) == 's' || str.charAt(3) == 'S') {
            return str.charAt(4) == 'e' || str.charAt(4) == 'E';
        }
        return false;
    }

    private static boolean isSetTrue(String str) {
        if (str == null || str.length() != 4) {
            return false;
        }
        if (str.charAt(0) != 't' && str.charAt(0) != 'T') {
            return false;
        }
        if (str.charAt(1) != 'r' && str.charAt(1) != 'R') {
            return false;
        }
        if (str.charAt(2) == 'u' || str.charAt(2) == 'U') {
            return str.charAt(3) == 'e' || str.charAt(3) == 'E';
        }
        return false;
    }

    public static boolean removeThreadOverride(String str) {
        String str2;
        ThreadLocal threadLocal = threadProperties;
        Map map = (Map) threadLocal.get();
        if (map == null || (str2 = (String) map.remove(str)) == null) {
            return false;
        }
        if (map.isEmpty()) {
            threadLocal.remove();
        }
        return "true".equals(Strings.toLowerCase(str2));
    }

    public static boolean setThreadOverride(String str, boolean z) {
        boolean isOverrideSet = isOverrideSet(str);
        ThreadLocal threadLocal = threadProperties;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
        }
        map.put(str, z ? "true" : "false");
        return isOverrideSet;
    }
}
