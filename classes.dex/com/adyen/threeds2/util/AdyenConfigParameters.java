package com.adyen.threeds2.util;

import android.text.TextUtils;
import com.adyen.threeds2.exception.InvalidInputException;
import com.adyen.threeds2.parameters.ConfigParameters;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public final class AdyenConfigParameters {
    public static final a DEVICE_PARAMETER_BLOCK_LIST = new a((String) null, "deviceParameterBlockList");
    public static final a DIRECTORY_SERVER_ID = new a("threeds2.directoryServer", "id");
    public static final a DIRECTORY_SERVER_PUBLIC_KEY = new a("threeds2.directoryServer", "publicKey");
    public static final a SECURITY_APP_SIGNATURE = new a("security", "appSignature");
    public static final a SECURITY_MALICIOUS_APPS = new a("security", "maliciousApps");
    public static final a SECURITY_TRUSTED_APP_STORES = new a("security", "trustedAppStores");

    public static final class Builder {
        private final String a;
        private final String b;
        private String c;
        private Set<String> d;
        private Set<String> e;
        private Set<String> f;

        public Builder(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public Builder appSignature(String str) {
            this.c = str;
            return this;
        }

        public ConfigParameters build() throws InvalidInputException {
            Preconditions.requireNonEmpty("directoryServerId", this.a);
            Preconditions.requireNonEmpty("directoryServerPublicKey", this.b);
            ConfigParameters configParameters = new ConfigParameters();
            AdyenConfigParameters.a(configParameters, AdyenConfigParameters.DIRECTORY_SERVER_ID, this.a);
            AdyenConfigParameters.a(configParameters, AdyenConfigParameters.DIRECTORY_SERVER_PUBLIC_KEY, this.b);
            String str = this.c;
            if (str != null) {
                AdyenConfigParameters.a(configParameters, AdyenConfigParameters.SECURITY_APP_SIGNATURE, str);
            }
            Set<String> set = this.d;
            if (set != null) {
                AdyenConfigParameters.a(configParameters, AdyenConfigParameters.SECURITY_TRUSTED_APP_STORES, (Collection<String>) set);
            }
            Set<String> set2 = this.e;
            if (set2 != null) {
                AdyenConfigParameters.a(configParameters, AdyenConfigParameters.SECURITY_MALICIOUS_APPS, (Collection<String>) set2);
            }
            Set<String> set3 = this.f;
            if (set3 != null) {
                AdyenConfigParameters.a(configParameters, AdyenConfigParameters.DEVICE_PARAMETER_BLOCK_LIST, (Collection<String>) set3);
            }
            return configParameters;
        }

        public Builder deviceParameterBlockList(Set<String> set) {
            this.f = set;
            return this;
        }

        public Builder maliciousApps(Set<String> set) {
            this.e = set;
            return this;
        }

        public Builder trustedAppStores(Set<String> set) {
            this.d = set;
            return this;
        }
    }

    private static final class a {
        private final String a;
        private final String b;

        a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        /* access modifiers changed from: package-private */
        public String a() {
            return this.a;
        }

        /* access modifiers changed from: package-private */
        public String b() {
            return this.b;
        }
    }

    private AdyenConfigParameters() {
        throw new IllegalStateException("No instances.");
    }

    static void a(ConfigParameters configParameters, a aVar, Collection<String> collection) throws InvalidInputException {
        Preconditions.requireNonNull("paramValues", collection);
        a(configParameters, aVar, TextUtils.join(";", collection));
    }

    public static String getParamValue(ConfigParameters configParameters, a aVar) throws InvalidInputException {
        Preconditions.requireNonNull("configParameters", configParameters);
        Preconditions.requireNonNull("parameter", aVar);
        return configParameters.getParamValue(aVar.a(), aVar.b());
    }

    public static Collection<String> getParamValues(ConfigParameters configParameters, a aVar) throws InvalidInputException {
        String paramValue = getParamValue(configParameters, aVar);
        if (paramValue == null) {
            return null;
        }
        return Arrays.asList(paramValue.split(";"));
    }

    static void a(ConfigParameters configParameters, a aVar, String str) throws InvalidInputException {
        Preconditions.requireNonNull("configParameters", configParameters);
        Preconditions.requireNonNull("parameter", aVar);
        Preconditions.requireNonEmpty("paramValue", str);
        configParameters.addParam(aVar.a(), aVar.b(), str);
    }
}
