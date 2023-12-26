package com.adyen.threeds2.parameters;

import com.adyen.threeds2.exception.InvalidInputException;
import com.adyen.threeds2.util.Preconditions;
import java.util.HashMap;
import java.util.Map;

public final class ConfigParameters {
    private final Map<String, Map<String, String>> a = new HashMap();

    private Map<String, String> a(String str, boolean z) {
        Map<String, String> map = this.a.get(str);
        if (!z || map != null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        this.a.put(str, hashMap);
        return hashMap;
    }

    public void addParam(String str, String str2, String str3) throws InvalidInputException {
        Preconditions.requireNonNull("paramName", str2);
        a(str, true).put(str2, str3);
    }

    public Map<String, String> getGroup(String str) {
        return a(str, false);
    }

    public String getParamValue(String str, String str2) throws InvalidInputException {
        Preconditions.requireNonNull("paramName", str2);
        Map<String, String> a2 = a(str, false);
        if (a2 != null) {
            return a2.get(str2);
        }
        return null;
    }

    public String removeParam(String str, String str2) throws InvalidInputException {
        Preconditions.requireNonNull("paramName", str2);
        Map<String, String> a2 = a(str, false);
        if (a2 != null) {
            return a2.remove(str2);
        }
        return null;
    }
}
